package io.sentry;

import com.salesforce.marketingcloud.http.b;
import io.sentry.clientreport.DiscardReason;
import io.sentry.clientreport.IClientReportRecorder;
import io.sentry.exception.SentryEnvelopeException;
import io.sentry.hints.AbnormalExit;
import io.sentry.hints.ApplyScopeData;
import io.sentry.hints.Backfillable;
import io.sentry.hints.Cached;
import io.sentry.hints.DiskFlushNotification;
import io.sentry.hints.TransactionEnd;
import io.sentry.logger.ILoggerBatchProcessor;
import io.sentry.logger.LoggerBatchProcessor;
import io.sentry.logger.NoOpLoggerBatchProcessor;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.ITransport;
import io.sentry.transport.RateLimiter;
import io.sentry.util.CheckInUtils;
import io.sentry.util.ErrorUtils;
import io.sentry.util.ExceptionUtils;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import io.sentry.util.Random;
import io.sentry.util.SentryRandom;
import io.sentry.util.TracingUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SentryClient implements ISentryClient {
    static final String SENTRY_PROTOCOL_VERSION = "7";
    private final ILoggerBatchProcessor loggerBatchProcessor;
    private final SentryOptions options;
    private final ITransport transport;
    private final SortBreadcrumbsByDate sortBreadcrumbsByDate = new SortBreadcrumbsByDate();
    private boolean enabled = true;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$captureEvent$0(Session session) {
    }

    @Override // io.sentry.ISentryClient
    public boolean isEnabled() {
        return this.enabled;
    }

    public SentryClient(@NotNull SentryOptions sentryOptions) {
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        ITransportFactory transportFactory = sentryOptions.getTransportFactory();
        if (transportFactory instanceof NoOpTransportFactory) {
            transportFactory = new AsyncHttpTransportFactory();
            sentryOptions.setTransportFactory(transportFactory);
        }
        this.transport = transportFactory.create(sentryOptions, new RequestDetailsResolver(sentryOptions).resolve());
        if (sentryOptions.getLogs().isEnabled()) {
            this.loggerBatchProcessor = new LoggerBatchProcessor(sentryOptions, this);
        } else {
            this.loggerBatchProcessor = NoOpLoggerBatchProcessor.getInstance();
        }
    }

    private boolean shouldApplyScopeData(@NotNull SentryBaseEvent sentryBaseEvent, @NotNull Hint hint) {
        if (HintUtils.shouldApplyScopeData(hint)) {
            return true;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Event was cached so not applying scope: %s", sentryBaseEvent.getEventId());
        return false;
    }

    private boolean shouldApplyScopeData(@NotNull CheckIn checkIn, @NotNull Hint hint) {
        if (HintUtils.shouldApplyScopeData(hint)) {
            return true;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Check-in was cached so not applying scope: %s", checkIn.getCheckInId());
        return false;
    }

    @Override // io.sentry.ISentryClient
    public SentryId captureEvent(@NotNull SentryEvent sentryEvent, @Nullable IScope iScope, @Nullable Hint hint) {
        SentryEvent sentryEvent2;
        Objects.requireNonNull(sentryEvent, "SentryEvent is required.");
        if (hint == null) {
            hint = new Hint();
        }
        if (shouldApplyScopeData(sentryEvent, hint)) {
            addScopeAttachmentsToHint(iScope, hint);
        }
        ILogger logger = this.options.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.log(sentryLevel, "Capturing event: %s", sentryEvent.getEventId());
        Throwable throwable = sentryEvent.getThrowable();
        if (throwable != null && ExceptionUtils.isIgnored(this.options.getIgnoredExceptionsForType(), throwable)) {
            this.options.getLogger().log(sentryLevel, "Event was dropped as the exception %s is ignored", throwable.getClass());
            this.options.getClientReportRecorder().recordLostEvent(DiscardReason.EVENT_PROCESSOR, DataCategory.Error);
            return SentryId.EMPTY_ID;
        }
        if (ErrorUtils.isIgnored(this.options.getIgnoredErrors(), sentryEvent)) {
            this.options.getLogger().log(sentryLevel, "Event was dropped as it matched a string/pattern in ignoredErrors", sentryEvent.getMessage());
            this.options.getClientReportRecorder().recordLostEvent(DiscardReason.EVENT_PROCESSOR, DataCategory.Error);
            return SentryId.EMPTY_ID;
        }
        boolean z = false;
        if (shouldApplyScopeData(sentryEvent, hint) && (sentryEvent = applyScope(sentryEvent, iScope, hint)) == null) {
            this.options.getLogger().log(sentryLevel, "Event was dropped by applyScope", new Object[0]);
            return SentryId.EMPTY_ID;
        }
        SentryEvent sentryEventProcessEvent = processEvent(sentryEvent, hint, this.options.getEventProcessors());
        if (sentryEventProcessEvent != null && (sentryEventProcessEvent = executeBeforeSend(sentryEventProcessEvent, hint)) == null) {
            this.options.getLogger().log(sentryLevel, "Event was dropped by beforeSend", new Object[0]);
            this.options.getClientReportRecorder().recordLostEvent(DiscardReason.BEFORE_SEND, DataCategory.Error);
        }
        if (sentryEventProcessEvent == null) {
            return SentryId.EMPTY_ID;
        }
        Session sessionWithSession = iScope != null ? iScope.withSession(new Scope.IWithSession() { // from class: io.sentry.SentryClient$$ExternalSyntheticLambda0
            @Override // io.sentry.Scope.IWithSession
            public final void accept(Session session) {
                SentryClient.lambda$captureEvent$0(session);
            }
        }) : null;
        Session sessionUpdateSessionData = (sessionWithSession == null || !sessionWithSession.isTerminated()) ? updateSessionData(sentryEventProcessEvent, hint, iScope) : null;
        if (sample()) {
            sentryEvent2 = sentryEventProcessEvent;
        } else {
            this.options.getLogger().log(sentryLevel, "Event %s was dropped due to sampling decision.", sentryEventProcessEvent.getEventId());
            this.options.getClientReportRecorder().recordLostEvent(DiscardReason.SAMPLE_RATE, DataCategory.Error);
            sentryEvent2 = null;
        }
        boolean zShouldSendSessionUpdateForDroppedEvent = shouldSendSessionUpdateForDroppedEvent(sessionWithSession, sessionUpdateSessionData);
        if (sentryEvent2 == null && !zShouldSendSessionUpdateForDroppedEvent) {
            this.options.getLogger().log(sentryLevel, "Not sending session update for dropped event as it did not cause the session health to change.", new Object[0]);
            return SentryId.EMPTY_ID;
        }
        SentryId sentryIdSendEnvelope = SentryId.EMPTY_ID;
        if (sentryEvent2 != null && sentryEvent2.getEventId() != null) {
            sentryIdSendEnvelope = sentryEvent2.getEventId();
        }
        boolean zHasType = HintUtils.hasType(hint, Backfillable.class);
        if (HintUtils.hasType(hint, Cached.class) && !HintUtils.hasType(hint, ApplyScopeData.class)) {
            z = true;
        }
        if (sentryEvent2 != null && !zHasType && !z && (sentryEvent2.isErrored() || sentryEvent2.isCrashed())) {
            this.options.getReplayController().captureReplay(Boolean.valueOf(sentryEvent2.isCrashed()));
        }
        try {
            SentryEnvelope sentryEnvelopeBuildEnvelope = buildEnvelope(sentryEvent2, sentryEvent2 != null ? getAttachments(hint) : null, sessionUpdateSessionData, getTraceContext(iScope, hint, sentryEvent2), null);
            hint.clear();
            if (sentryEnvelopeBuildEnvelope != null) {
                sentryIdSendEnvelope = sendEnvelope(sentryEnvelopeBuildEnvelope, hint);
            }
        } catch (SentryEnvelopeException | IOException e) {
            this.options.getLogger().log(SentryLevel.WARNING, e, "Capturing event %s failed.", sentryIdSendEnvelope);
            sentryIdSendEnvelope = SentryId.EMPTY_ID;
        }
        if (iScope != null) {
            finalizeTransaction(iScope, hint);
        }
        return sentryIdSendEnvelope;
    }

    private void finalizeTransaction(@NotNull IScope iScope, @NotNull Hint hint) {
        ITransaction transaction = iScope.getTransaction();
        if (transaction == null || !HintUtils.hasType(hint, TransactionEnd.class)) {
            return;
        }
        Object sentrySdkHint = HintUtils.getSentrySdkHint(hint);
        if (sentrySdkHint instanceof DiskFlushNotification) {
            ((DiskFlushNotification) sentrySdkHint).setFlushable(transaction.getEventId());
            transaction.forceFinish(SpanStatus.ABORTED, false, hint);
        } else {
            transaction.forceFinish(SpanStatus.ABORTED, false, null);
        }
    }

    @Override // io.sentry.ISentryClient
    public SentryId captureReplayEvent(@NotNull SentryReplayEvent sentryReplayEvent, @Nullable IScope iScope, @Nullable Hint hint) {
        Objects.requireNonNull(sentryReplayEvent, "SessionReplay is required.");
        if (hint == null) {
            hint = new Hint();
        }
        if (shouldApplyScopeData(sentryReplayEvent, hint)) {
            applyScope(sentryReplayEvent, iScope);
        }
        ILogger logger = this.options.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.log(sentryLevel, "Capturing session replay: %s", sentryReplayEvent.getEventId());
        SentryId sentryId = SentryId.EMPTY_ID;
        SentryId eventId = sentryReplayEvent.getEventId() != null ? sentryReplayEvent.getEventId() : sentryId;
        SentryReplayEvent sentryReplayEventProcessReplayEvent = processReplayEvent(sentryReplayEvent, hint, this.options.getEventProcessors());
        if (sentryReplayEventProcessReplayEvent != null && (sentryReplayEventProcessReplayEvent = executeBeforeSendReplay(sentryReplayEventProcessReplayEvent, hint)) == null) {
            this.options.getLogger().log(sentryLevel, "Event was dropped by beforeSendReplay", new Object[0]);
            this.options.getClientReportRecorder().recordLostEvent(DiscardReason.BEFORE_SEND, DataCategory.Replay);
        }
        if (sentryReplayEventProcessReplayEvent == null) {
            return sentryId;
        }
        try {
            SentryEnvelope sentryEnvelopeBuildEnvelope = buildEnvelope(sentryReplayEventProcessReplayEvent, hint.getReplayRecording(), getTraceContext(iScope, hint, sentryReplayEventProcessReplayEvent, null), HintUtils.hasType(hint, Backfillable.class));
            hint.clear();
            this.transport.send(sentryEnvelopeBuildEnvelope, hint);
            return eventId;
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.WARNING, e, "Capturing event %s failed.", eventId);
            return SentryId.EMPTY_ID;
        }
    }

    private void addScopeAttachmentsToHint(@Nullable IScope iScope, @NotNull Hint hint) {
        if (iScope != null) {
            hint.addAttachments(iScope.getAttachments());
        }
    }

    private boolean shouldSendSessionUpdateForDroppedEvent(@Nullable Session session, @Nullable Session session2) {
        if (session2 == null) {
            return false;
        }
        if (session == null) {
            return true;
        }
        Session.State status = session2.getStatus();
        Session.State state = Session.State.Crashed;
        if (status != state || session.getStatus() == state) {
            return session2.errorCount() > 0 && session.errorCount() <= 0;
        }
        return true;
    }

    private List<Attachment> getAttachments(@NotNull Hint hint) {
        List<Attachment> attachments = hint.getAttachments();
        Attachment screenshot = hint.getScreenshot();
        if (screenshot != null) {
            attachments.add(screenshot);
        }
        Attachment viewHierarchy = hint.getViewHierarchy();
        if (viewHierarchy != null) {
            attachments.add(viewHierarchy);
        }
        Attachment threadDump = hint.getThreadDump();
        if (threadDump != null) {
            attachments.add(threadDump);
        }
        return attachments;
    }

    private SentryEnvelope buildEnvelope(@Nullable SentryBaseEvent sentryBaseEvent, @Nullable List<Attachment> list, @Nullable Session session, @Nullable TraceContext traceContext, @Nullable ProfilingTraceData profilingTraceData) throws SentryEnvelopeException, IOException {
        SentryId sentryId;
        ArrayList arrayList = new ArrayList();
        if (sentryBaseEvent != null) {
            arrayList.add(SentryEnvelopeItem.fromEvent(this.options.getSerializer(), sentryBaseEvent));
            sentryId = sentryBaseEvent.getEventId();
        } else {
            sentryId = null;
        }
        if (session != null) {
            arrayList.add(SentryEnvelopeItem.fromSession(this.options.getSerializer(), session));
        }
        if (profilingTraceData != null) {
            arrayList.add(SentryEnvelopeItem.fromProfilingTrace(profilingTraceData, this.options.getMaxTraceFileSize(), this.options.getSerializer()));
            if (sentryId == null) {
                sentryId = new SentryId(profilingTraceData.getProfileId());
            }
        }
        if (list != null) {
            Iterator<Attachment> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(SentryEnvelopeItem.fromAttachment(this.options.getSerializer(), this.options.getLogger(), it2.next(), this.options.getMaxAttachmentSize()));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new SentryEnvelope(new SentryEnvelopeHeader(sentryId, this.options.getSdkVersion(), traceContext), arrayList);
    }

    private SentryEvent processEvent(@NotNull SentryEvent sentryEvent, @NotNull Hint hint, @NotNull List<EventProcessor> list) {
        for (EventProcessor eventProcessor : list) {
            try {
                boolean z = eventProcessor instanceof BackfillingEventProcessor;
                boolean zHasType = HintUtils.hasType(hint, Backfillable.class);
                if (zHasType && z) {
                    sentryEvent = eventProcessor.process(sentryEvent, hint);
                } else if (!zHasType && !z) {
                    sentryEvent = eventProcessor.process(sentryEvent, hint);
                }
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, th, "An exception occurred while processing event by processor: %s", eventProcessor.getClass().getName());
            }
            if (sentryEvent == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Event was dropped by a processor: %s", eventProcessor.getClass().getName());
                this.options.getClientReportRecorder().recordLostEvent(DiscardReason.EVENT_PROCESSOR, DataCategory.Error);
                break;
            }
        }
        return sentryEvent;
    }

    private SentryLogEvent processLogEvent(@NotNull SentryLogEvent sentryLogEvent, @NotNull List<EventProcessor> list) {
        for (EventProcessor eventProcessor : list) {
            try {
                sentryLogEvent = eventProcessor.process(sentryLogEvent);
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, th, "An exception occurred while processing log event by processor: %s", eventProcessor.getClass().getName());
            }
            if (sentryLogEvent == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Log event was dropped by a processor: %s", eventProcessor.getClass().getName());
                this.options.getClientReportRecorder().recordLostEvent(DiscardReason.EVENT_PROCESSOR, DataCategory.LogItem);
                break;
            }
        }
        return sentryLogEvent;
    }

    private SentryTransaction processTransaction(@NotNull SentryTransaction sentryTransaction, @NotNull Hint hint, @NotNull List<EventProcessor> list) {
        for (EventProcessor eventProcessor : list) {
            int size = sentryTransaction.getSpans().size();
            try {
                sentryTransaction = eventProcessor.process(sentryTransaction, hint);
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, th, "An exception occurred while processing transaction by processor: %s", eventProcessor.getClass().getName());
            }
            int size2 = sentryTransaction == null ? 0 : sentryTransaction.getSpans().size();
            if (sentryTransaction == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Transaction was dropped by a processor: %s", eventProcessor.getClass().getName());
                IClientReportRecorder clientReportRecorder = this.options.getClientReportRecorder();
                DiscardReason discardReason = DiscardReason.EVENT_PROCESSOR;
                clientReportRecorder.recordLostEvent(discardReason, DataCategory.Transaction);
                this.options.getClientReportRecorder().recordLostEvent(discardReason, DataCategory.Span, size + 1);
                break;
            }
            if (size2 < size) {
                int i = size - size2;
                this.options.getLogger().log(SentryLevel.DEBUG, "%d spans were dropped by a processor: %s", Integer.valueOf(i), eventProcessor.getClass().getName());
                this.options.getClientReportRecorder().recordLostEvent(DiscardReason.EVENT_PROCESSOR, DataCategory.Span, i);
            }
        }
        return sentryTransaction;
    }

    private SentryReplayEvent processReplayEvent(@NotNull SentryReplayEvent sentryReplayEvent, @NotNull Hint hint, @NotNull List<EventProcessor> list) {
        for (EventProcessor eventProcessor : list) {
            try {
                sentryReplayEvent = eventProcessor.process(sentryReplayEvent, hint);
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, th, "An exception occurred while processing replay event by processor: %s", eventProcessor.getClass().getName());
            }
            if (sentryReplayEvent == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Replay event was dropped by a processor: %s", eventProcessor.getClass().getName());
                this.options.getClientReportRecorder().recordLostEvent(DiscardReason.EVENT_PROCESSOR, DataCategory.Replay);
                break;
            }
        }
        return sentryReplayEvent;
    }

    private SentryEvent processFeedbackEvent(@NotNull SentryEvent sentryEvent, @NotNull Hint hint, @NotNull List<EventProcessor> list) {
        for (EventProcessor eventProcessor : list) {
            try {
                sentryEvent = eventProcessor.process(sentryEvent, hint);
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, th, "An exception occurred while processing feedback event by processor: %s", eventProcessor.getClass().getName());
            }
            if (sentryEvent == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Feedback event was dropped by a processor: %s", eventProcessor.getClass().getName());
                this.options.getClientReportRecorder().recordLostEvent(DiscardReason.EVENT_PROCESSOR, DataCategory.Feedback);
                break;
            }
        }
        return sentryEvent;
    }

    @Override // io.sentry.ISentryClient
    public void captureUserFeedback(@NotNull UserFeedback userFeedback) {
        Objects.requireNonNull(userFeedback, "SentryEvent is required.");
        if (SentryId.EMPTY_ID.equals(userFeedback.getEventId())) {
            this.options.getLogger().log(SentryLevel.WARNING, "Capturing userFeedback without a Sentry Id.", new Object[0]);
            return;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Capturing userFeedback: %s", userFeedback.getEventId());
        try {
            sendEnvelope(buildEnvelope(userFeedback), null);
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.WARNING, e, "Capturing user feedback %s failed.", userFeedback.getEventId());
        }
    }

    private SentryEnvelope buildEnvelope(@NotNull UserFeedback userFeedback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SentryEnvelopeItem.fromUserFeedback(this.options.getSerializer(), userFeedback));
        return new SentryEnvelope(new SentryEnvelopeHeader(userFeedback.getEventId(), this.options.getSdkVersion()), arrayList);
    }

    private SentryEnvelope buildEnvelope(@NotNull CheckIn checkIn, @Nullable TraceContext traceContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SentryEnvelopeItem.fromCheckIn(this.options.getSerializer(), checkIn));
        return new SentryEnvelope(new SentryEnvelopeHeader(checkIn.getCheckInId(), this.options.getSdkVersion(), traceContext), arrayList);
    }

    private SentryEnvelope buildEnvelope(@NotNull SentryLogEvents sentryLogEvents) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SentryEnvelopeItem.fromLogs(this.options.getSerializer(), sentryLogEvents));
        return new SentryEnvelope(new SentryEnvelopeHeader(null, this.options.getSdkVersion(), null), arrayList);
    }

    private SentryEnvelope buildEnvelope(@NotNull SentryReplayEvent sentryReplayEvent, @Nullable ReplayRecording replayRecording, @Nullable TraceContext traceContext, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SentryEnvelopeItem.fromReplay(this.options.getSerializer(), this.options.getLogger(), sentryReplayEvent, replayRecording, z));
        return new SentryEnvelope(new SentryEnvelopeHeader(sentryReplayEvent.getEventId(), this.options.getSessionReplay().getSdkVersion(), traceContext), arrayList);
    }

    Session updateSessionData(@NotNull final SentryEvent sentryEvent, @NotNull final Hint hint, @Nullable IScope iScope) {
        if (HintUtils.shouldApplyScopeData(hint)) {
            if (iScope != null) {
                return iScope.withSession(new Scope.IWithSession() { // from class: io.sentry.SentryClient$$ExternalSyntheticLambda1
                    @Override // io.sentry.Scope.IWithSession
                    public final void accept(Session session) {
                        this.f$0.lambda$updateSessionData$1(sentryEvent, hint, session);
                    }
                });
            }
            this.options.getLogger().log(SentryLevel.INFO, "Scope is null on client.captureEvent", new Object[0]);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSessionData$1(SentryEvent sentryEvent, Hint hint, Session session) {
        if (session != null) {
            String strMechanism = null;
            Session.State state = sentryEvent.isCrashed() ? Session.State.Crashed : null;
            boolean z = Session.State.Crashed == state || sentryEvent.isErrored();
            String str = (sentryEvent.getRequest() == null || sentryEvent.getRequest().getHeaders() == null || !sentryEvent.getRequest().getHeaders().containsKey(b.u)) ? null : sentryEvent.getRequest().getHeaders().get(b.u);
            Object sentrySdkHint = HintUtils.getSentrySdkHint(hint);
            if (sentrySdkHint instanceof AbnormalExit) {
                strMechanism = ((AbnormalExit) sentrySdkHint).mechanism();
                state = Session.State.Abnormal;
            }
            if (session.update(state, str, z, strMechanism) && session.isTerminated()) {
                session.end();
                return;
            }
            return;
        }
        this.options.getLogger().log(SentryLevel.INFO, "Session is null on scope.withSession", new Object[0]);
    }

    @Override // io.sentry.ISentryClient
    public void captureSession(@NotNull Session session, @Nullable Hint hint) {
        Objects.requireNonNull(session, "Session is required.");
        if (session.getRelease() == null || session.getRelease().isEmpty()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Sessions can't be captured without setting a release.", new Object[0]);
            return;
        }
        try {
            captureEnvelope(SentryEnvelope.from(this.options.getSerializer(), session, this.options.getSdkVersion()), hint);
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to capture session.", e);
        }
    }

    @Override // io.sentry.ISentryClient
    public SentryId captureEnvelope(@NotNull SentryEnvelope sentryEnvelope, @Nullable Hint hint) {
        Objects.requireNonNull(sentryEnvelope, "SentryEnvelope is required.");
        if (hint == null) {
            hint = new Hint();
        }
        try {
            hint.clear();
            return sendEnvelope(sentryEnvelope, hint);
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to capture envelope.", e);
            return SentryId.EMPTY_ID;
        }
    }

    private SentryId sendEnvelope(@NotNull SentryEnvelope sentryEnvelope, @Nullable Hint hint) throws IOException {
        SentryOptions.BeforeEnvelopeCallback beforeEnvelopeCallback = this.options.getBeforeEnvelopeCallback();
        if (beforeEnvelopeCallback != null) {
            try {
                beforeEnvelopeCallback.execute(sentryEnvelope, hint);
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, "The BeforeEnvelope callback threw an exception.", th);
            }
        }
        SentryIntegrationPackageStorage.getInstance().checkForMixedVersions(this.options.getLogger());
        if (hint == null) {
            this.transport.send(sentryEnvelope);
        } else {
            this.transport.send(sentryEnvelope, hint);
        }
        SentryId eventId = sentryEnvelope.getHeader().getEventId();
        return eventId != null ? eventId : SentryId.EMPTY_ID;
    }

    @Override // io.sentry.ISentryClient
    public SentryId captureTransaction(@NotNull SentryTransaction sentryTransaction, @Nullable TraceContext traceContext, @Nullable IScope iScope, @Nullable Hint hint, @Nullable ProfilingTraceData profilingTraceData) {
        SentryTransaction sentryTransactionProcessTransaction;
        Objects.requireNonNull(sentryTransaction, "Transaction is required.");
        Hint hint2 = hint == null ? new Hint() : hint;
        if (shouldApplyScopeData(sentryTransaction, hint2)) {
            addScopeAttachmentsToHint(iScope, hint2);
        }
        ILogger logger = this.options.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.log(sentryLevel, "Capturing transaction: %s", sentryTransaction.getEventId());
        if (TracingUtils.isIgnored(this.options.getIgnoredTransactions(), sentryTransaction.getTransaction())) {
            this.options.getLogger().log(sentryLevel, "Transaction was dropped as transaction name %s is ignored", sentryTransaction.getTransaction());
            IClientReportRecorder clientReportRecorder = this.options.getClientReportRecorder();
            DiscardReason discardReason = DiscardReason.EVENT_PROCESSOR;
            clientReportRecorder.recordLostEvent(discardReason, DataCategory.Transaction);
            this.options.getClientReportRecorder().recordLostEvent(discardReason, DataCategory.Span, sentryTransaction.getSpans().size() + 1);
            return SentryId.EMPTY_ID;
        }
        SentryId sentryId = SentryId.EMPTY_ID;
        SentryId eventId = sentryTransaction.getEventId() != null ? sentryTransaction.getEventId() : sentryId;
        if (shouldApplyScopeData(sentryTransaction, hint2)) {
            sentryTransactionProcessTransaction = (SentryTransaction) applyScope(sentryTransaction, iScope);
            if (sentryTransactionProcessTransaction != null && iScope != null) {
                sentryTransactionProcessTransaction = processTransaction(sentryTransactionProcessTransaction, hint2, iScope.getEventProcessors());
            }
            if (sentryTransactionProcessTransaction == null) {
                this.options.getLogger().log(sentryLevel, "Transaction was dropped by applyScope", new Object[0]);
            }
        } else {
            sentryTransactionProcessTransaction = sentryTransaction;
        }
        if (sentryTransactionProcessTransaction != null) {
            sentryTransactionProcessTransaction = processTransaction(sentryTransactionProcessTransaction, hint2, this.options.getEventProcessors());
        }
        if (sentryTransactionProcessTransaction == null) {
            this.options.getLogger().log(sentryLevel, "Transaction was dropped by Event processors.", new Object[0]);
            return sentryId;
        }
        int size = sentryTransactionProcessTransaction.getSpans().size();
        SentryTransaction sentryTransactionExecuteBeforeSendTransaction = executeBeforeSendTransaction(sentryTransactionProcessTransaction, hint2);
        int size2 = sentryTransactionExecuteBeforeSendTransaction == null ? 0 : sentryTransactionExecuteBeforeSendTransaction.getSpans().size();
        if (sentryTransactionExecuteBeforeSendTransaction == null) {
            this.options.getLogger().log(sentryLevel, "Transaction was dropped by beforeSendTransaction.", new Object[0]);
            IClientReportRecorder clientReportRecorder2 = this.options.getClientReportRecorder();
            DiscardReason discardReason2 = DiscardReason.BEFORE_SEND;
            clientReportRecorder2.recordLostEvent(discardReason2, DataCategory.Transaction);
            this.options.getClientReportRecorder().recordLostEvent(discardReason2, DataCategory.Span, size + 1);
            return sentryId;
        }
        if (size2 < size) {
            int i = size - size2;
            this.options.getLogger().log(sentryLevel, "%d spans were dropped by beforeSendTransaction.", Integer.valueOf(i));
            this.options.getClientReportRecorder().recordLostEvent(DiscardReason.BEFORE_SEND, DataCategory.Span, i);
        }
        try {
            SentryEnvelope sentryEnvelopeBuildEnvelope = buildEnvelope(sentryTransactionExecuteBeforeSendTransaction, filterForTransaction(getAttachments(hint2)), null, traceContext, profilingTraceData);
            hint2.clear();
            return sentryEnvelopeBuildEnvelope != null ? sendEnvelope(sentryEnvelopeBuildEnvelope, hint2) : eventId;
        } catch (SentryEnvelopeException | IOException e) {
            this.options.getLogger().log(SentryLevel.WARNING, e, "Capturing transaction %s failed.", eventId);
            return SentryId.EMPTY_ID;
        }
    }

    @Override // io.sentry.ISentryClient
    public SentryId captureProfileChunk(@NotNull ProfileChunk profileChunk, @Nullable IScope iScope) {
        Objects.requireNonNull(profileChunk, "profileChunk is required.");
        this.options.getLogger().log(SentryLevel.DEBUG, "Capturing profile chunk: %s", profileChunk.getChunkId());
        SentryId chunkId = profileChunk.getChunkId();
        DebugMeta debugMetaBuildDebugMeta = DebugMeta.buildDebugMeta(profileChunk.getDebugMeta(), this.options);
        if (debugMetaBuildDebugMeta != null) {
            profileChunk.setDebugMeta(debugMetaBuildDebugMeta);
        }
        try {
            return sendEnvelope(new SentryEnvelope(new SentryEnvelopeHeader(chunkId, this.options.getSdkVersion(), null), Collections.singletonList(SentryEnvelopeItem.fromProfileChunk(profileChunk, this.options.getSerializer()))), null);
        } catch (SentryEnvelopeException | IOException e) {
            this.options.getLogger().log(SentryLevel.WARNING, e, "Capturing profile chunk %s failed.", chunkId);
            return SentryId.EMPTY_ID;
        }
    }

    @Override // io.sentry.ISentryClient
    public SentryId captureCheckIn(@NotNull CheckIn checkIn, @Nullable IScope iScope, @Nullable Hint hint) {
        if (hint == null) {
            hint = new Hint();
        }
        if (checkIn.getEnvironment() == null) {
            checkIn.setEnvironment(this.options.getEnvironment());
        }
        if (checkIn.getRelease() == null) {
            checkIn.setRelease(this.options.getRelease());
        }
        if (shouldApplyScopeData(checkIn, hint)) {
            checkIn = applyScope(checkIn, iScope);
        }
        if (CheckInUtils.isIgnored(this.options.getIgnoredCheckIns(), checkIn.getMonitorSlug())) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Check-in was dropped as slug %s is ignored", checkIn.getMonitorSlug());
            this.options.getClientReportRecorder().recordLostEvent(DiscardReason.EVENT_PROCESSOR, DataCategory.Monitor);
            return SentryId.EMPTY_ID;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Capturing check-in: %s", checkIn.getCheckInId());
        SentryId checkInId = checkIn.getCheckInId();
        try {
            SentryEnvelope sentryEnvelopeBuildEnvelope = buildEnvelope(checkIn, getTraceContext(iScope, hint, null));
            hint.clear();
            return sendEnvelope(sentryEnvelopeBuildEnvelope, hint);
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.WARNING, e, "Capturing check-in %s failed.", checkInId);
            return SentryId.EMPTY_ID;
        }
    }

    @Override // io.sentry.ISentryClient
    public SentryId captureFeedback(@NotNull Feedback feedback, @Nullable Hint hint, @NotNull IScope iScope) {
        SentryEvent sentryEvent = new SentryEvent();
        sentryEvent.getContexts().setFeedback(feedback);
        if (hint == null) {
            hint = new Hint();
        }
        if (feedback.getUrl() == null) {
            feedback.setUrl(iScope.getScreen());
        }
        ILogger logger = this.options.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.log(sentryLevel, "Capturing feedback: %s", sentryEvent.getEventId());
        if (shouldApplyScopeData(sentryEvent, hint) && (sentryEvent = applyFeedbackScope(sentryEvent, iScope, hint)) == null) {
            this.options.getLogger().log(sentryLevel, "Feedback was dropped by applyScope", new Object[0]);
            return SentryId.EMPTY_ID;
        }
        SentryEvent sentryEventProcessFeedbackEvent = processFeedbackEvent(sentryEvent, hint, this.options.getEventProcessors());
        if (sentryEventProcessFeedbackEvent != null && (sentryEventProcessFeedbackEvent = executeBeforeSendFeedback(sentryEventProcessFeedbackEvent, hint)) == null) {
            this.options.getLogger().log(sentryLevel, "Event was dropped by beforeSend", new Object[0]);
            this.options.getClientReportRecorder().recordLostEvent(DiscardReason.BEFORE_SEND, DataCategory.Feedback);
        }
        SentryEvent sentryEvent2 = sentryEventProcessFeedbackEvent;
        if (sentryEvent2 == null) {
            return SentryId.EMPTY_ID;
        }
        SentryId sentryId = SentryId.EMPTY_ID;
        SentryId eventId = sentryEvent2.getEventId() != null ? sentryEvent2.getEventId() : sentryId;
        if (feedback.getReplayId() == null) {
            this.options.getReplayController().captureReplay(Boolean.FALSE);
            SentryId replayId = iScope.getReplayId();
            if (!replayId.equals(sentryId)) {
                feedback.setReplayId(replayId);
            }
        }
        try {
            SentryEnvelope sentryEnvelopeBuildEnvelope = buildEnvelope(sentryEvent2, getAttachments(hint), null, getTraceContext(iScope, hint, sentryEvent2), null);
            hint.clear();
            return sentryEnvelopeBuildEnvelope != null ? sendEnvelope(sentryEnvelopeBuildEnvelope, hint) : eventId;
        } catch (SentryEnvelopeException | IOException e) {
            this.options.getLogger().log(SentryLevel.WARNING, e, "Capturing feedback %s failed.", eventId);
            return SentryId.EMPTY_ID;
        }
    }

    private TraceContext getTraceContext(@Nullable IScope iScope, @NotNull Hint hint, @Nullable SentryEvent sentryEvent) {
        return getTraceContext(iScope, hint, sentryEvent, sentryEvent != null ? sentryEvent.getTransaction() : null);
    }

    private TraceContext getTraceContext(@Nullable IScope iScope, @NotNull Hint hint, @Nullable SentryBaseEvent sentryBaseEvent, @Nullable String str) {
        if (HintUtils.hasType(hint, Backfillable.class)) {
            if (sentryBaseEvent != null) {
                return Baggage.fromEvent(sentryBaseEvent, str, this.options).toTraceContext();
            }
        } else if (iScope != null) {
            ITransaction transaction = iScope.getTransaction();
            if (transaction != null) {
                return transaction.traceContext();
            }
            return TracingUtils.maybeUpdateBaggage(iScope, this.options).traceContext();
        }
        return null;
    }

    @Override // io.sentry.ISentryClient
    public void captureLog(@Nullable SentryLogEvent sentryLogEvent, @Nullable IScope iScope) {
        if (sentryLogEvent == null || iScope == null || (sentryLogEvent = processLogEvent(sentryLogEvent, iScope.getEventProcessors())) != null) {
            if ((sentryLogEvent == null || (sentryLogEvent = processLogEvent(sentryLogEvent, this.options.getEventProcessors())) != null) && sentryLogEvent != null) {
                SentryLogEvent sentryLogEventExecuteBeforeSendLog = executeBeforeSendLog(sentryLogEvent);
                if (sentryLogEventExecuteBeforeSendLog == null) {
                    this.options.getLogger().log(SentryLevel.DEBUG, "Log Event was dropped by beforeSendLog", new Object[0]);
                    this.options.getClientReportRecorder().recordLostEvent(DiscardReason.BEFORE_SEND, DataCategory.LogItem);
                } else {
                    this.loggerBatchProcessor.add(sentryLogEventExecuteBeforeSendLog);
                }
            }
        }
    }

    @Override // io.sentry.ISentryClient
    public void captureBatchedLogEvents(@NotNull SentryLogEvents sentryLogEvents) {
        try {
            sendEnvelope(buildEnvelope(sentryLogEvents), null);
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.WARNING, e, "Capturing log failed.", new Object[0]);
        }
    }

    private List<Attachment> filterForTransaction(@Nullable List<Attachment> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Attachment attachment : list) {
            if (attachment.isAddToTransactions()) {
                arrayList.add(attachment);
            }
        }
        return arrayList;
    }

    private SentryEvent applyScope(@NotNull SentryEvent sentryEvent, @Nullable IScope iScope, @NotNull Hint hint) {
        if (iScope == null) {
            return sentryEvent;
        }
        applyScope(sentryEvent, iScope);
        if (sentryEvent.getTransaction() == null) {
            sentryEvent.setTransaction(iScope.getTransactionName());
        }
        if (sentryEvent.getFingerprints() == null) {
            sentryEvent.setFingerprints(iScope.getFingerprint());
        }
        if (iScope.getLevel() != null) {
            sentryEvent.setLevel(iScope.getLevel());
        }
        ISpan span = iScope.getSpan();
        if (sentryEvent.getContexts().getTrace() == null) {
            if (span == null) {
                sentryEvent.getContexts().setTrace(TransactionContext.fromPropagationContext(iScope.getPropagationContext()));
            } else {
                sentryEvent.getContexts().setTrace(span.getSpanContext());
            }
        }
        return processEvent(sentryEvent, hint, iScope.getEventProcessors());
    }

    private SentryEvent applyFeedbackScope(@NotNull SentryEvent sentryEvent, @NotNull IScope iScope, @NotNull Hint hint) {
        if (sentryEvent.getUser() == null) {
            sentryEvent.setUser(iScope.getUser());
        }
        if (sentryEvent.getTags() == null) {
            sentryEvent.setTags(new HashMap(iScope.getTags()));
        } else {
            for (Map.Entry<String, String> entry : iScope.getTags().entrySet()) {
                if (!sentryEvent.getTags().containsKey(entry.getKey())) {
                    sentryEvent.getTags().put(entry.getKey(), entry.getValue());
                }
            }
        }
        Contexts contexts = sentryEvent.getContexts();
        for (Map.Entry<String, Object> entry2 : new Contexts(iScope.getContexts()).entrySet()) {
            if (!contexts.containsKey(entry2.getKey())) {
                contexts.put(entry2.getKey(), entry2.getValue());
            }
        }
        ISpan span = iScope.getSpan();
        if (sentryEvent.getContexts().getTrace() == null) {
            if (span == null) {
                sentryEvent.getContexts().setTrace(TransactionContext.fromPropagationContext(iScope.getPropagationContext()));
            } else {
                sentryEvent.getContexts().setTrace(span.getSpanContext());
            }
        }
        return processFeedbackEvent(sentryEvent, hint, iScope.getEventProcessors());
    }

    private CheckIn applyScope(@NotNull CheckIn checkIn, @Nullable IScope iScope) {
        if (iScope != null) {
            ISpan span = iScope.getSpan();
            if (checkIn.getContexts().getTrace() == null) {
                if (span == null) {
                    checkIn.getContexts().setTrace(TransactionContext.fromPropagationContext(iScope.getPropagationContext()));
                } else {
                    checkIn.getContexts().setTrace(span.getSpanContext());
                }
            }
        }
        return checkIn;
    }

    private SentryReplayEvent applyScope(@NotNull SentryReplayEvent sentryReplayEvent, @Nullable IScope iScope) {
        if (iScope != null) {
            if (sentryReplayEvent.getRequest() == null) {
                sentryReplayEvent.setRequest(iScope.getRequest());
            }
            if (sentryReplayEvent.getUser() == null) {
                sentryReplayEvent.setUser(iScope.getUser());
            }
            if (sentryReplayEvent.getTags() == null) {
                sentryReplayEvent.setTags(new HashMap(iScope.getTags()));
            } else {
                for (Map.Entry<String, String> entry : iScope.getTags().entrySet()) {
                    if (!sentryReplayEvent.getTags().containsKey(entry.getKey())) {
                        sentryReplayEvent.getTags().put(entry.getKey(), entry.getValue());
                    }
                }
            }
            Contexts contexts = sentryReplayEvent.getContexts();
            for (Map.Entry<String, Object> entry2 : new Contexts(iScope.getContexts()).entrySet()) {
                if (!contexts.containsKey(entry2.getKey())) {
                    contexts.put(entry2.getKey(), entry2.getValue());
                }
            }
            ISpan span = iScope.getSpan();
            if (sentryReplayEvent.getContexts().getTrace() == null) {
                if (span == null) {
                    sentryReplayEvent.getContexts().setTrace(TransactionContext.fromPropagationContext(iScope.getPropagationContext()));
                } else {
                    sentryReplayEvent.getContexts().setTrace(span.getSpanContext());
                }
            }
        }
        return sentryReplayEvent;
    }

    private <T extends SentryBaseEvent> T applyScope(@NotNull T t, @Nullable IScope iScope) {
        if (iScope != null) {
            if (t.getRequest() == null) {
                t.setRequest(iScope.getRequest());
            }
            if (t.getUser() == null) {
                t.setUser(iScope.getUser());
            }
            if (t.getTags() == null) {
                t.setTags(new HashMap(iScope.getTags()));
            } else {
                for (Map.Entry<String, String> entry : iScope.getTags().entrySet()) {
                    if (!t.getTags().containsKey(entry.getKey())) {
                        t.getTags().put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (t.getBreadcrumbs() == null) {
                t.setBreadcrumbs(new ArrayList(iScope.getBreadcrumbs()));
            } else {
                sortBreadcrumbsByDate(t, iScope.getBreadcrumbs());
            }
            if (t.getExtras() == null) {
                t.setExtras(new HashMap(iScope.getExtras()));
            } else {
                for (Map.Entry<String, Object> entry2 : iScope.getExtras().entrySet()) {
                    if (!t.getExtras().containsKey(entry2.getKey())) {
                        t.getExtras().put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
            Contexts contexts = t.getContexts();
            for (Map.Entry<String, Object> entry3 : new Contexts(iScope.getContexts()).entrySet()) {
                if (!contexts.containsKey(entry3.getKey())) {
                    contexts.put(entry3.getKey(), entry3.getValue());
                }
            }
        }
        return t;
    }

    private void sortBreadcrumbsByDate(@NotNull SentryBaseEvent sentryBaseEvent, @NotNull Collection<Breadcrumb> collection) {
        List<Breadcrumb> breadcrumbs = sentryBaseEvent.getBreadcrumbs();
        if (breadcrumbs == null || collection.isEmpty()) {
            return;
        }
        breadcrumbs.addAll(collection);
        Collections.sort(breadcrumbs, this.sortBreadcrumbsByDate);
    }

    private SentryEvent executeBeforeSend(@NotNull SentryEvent sentryEvent, @NotNull Hint hint) {
        SentryOptions.BeforeSendCallback beforeSend = this.options.getBeforeSend();
        if (beforeSend == null) {
            return sentryEvent;
        }
        try {
            return beforeSend.execute(sentryEvent, hint);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "The BeforeSend callback threw an exception. It will be added as breadcrumb and continue.", th);
            return null;
        }
    }

    private SentryTransaction executeBeforeSendTransaction(@NotNull SentryTransaction sentryTransaction, @NotNull Hint hint) {
        SentryOptions.BeforeSendTransactionCallback beforeSendTransaction = this.options.getBeforeSendTransaction();
        if (beforeSendTransaction == null) {
            return sentryTransaction;
        }
        try {
            return beforeSendTransaction.execute(sentryTransaction, hint);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "The BeforeSendTransaction callback threw an exception. It will be added as breadcrumb and continue.", th);
            return null;
        }
    }

    private SentryEvent executeBeforeSendFeedback(@NotNull SentryEvent sentryEvent, @NotNull Hint hint) {
        SentryOptions.BeforeSendCallback beforeSendFeedback = this.options.getBeforeSendFeedback();
        if (beforeSendFeedback == null) {
            return sentryEvent;
        }
        try {
            return beforeSendFeedback.execute(sentryEvent, hint);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "The BeforeSendFeedback callback threw an exception.", th);
            return null;
        }
    }

    private SentryReplayEvent executeBeforeSendReplay(@NotNull SentryReplayEvent sentryReplayEvent, @NotNull Hint hint) {
        SentryOptions.BeforeSendReplayCallback beforeSendReplay = this.options.getBeforeSendReplay();
        if (beforeSendReplay == null) {
            return sentryReplayEvent;
        }
        try {
            return beforeSendReplay.execute(sentryReplayEvent, hint);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "The BeforeSendReplay callback threw an exception. It will be added as breadcrumb and continue.", th);
            return null;
        }
    }

    private SentryLogEvent executeBeforeSendLog(@NotNull SentryLogEvent sentryLogEvent) {
        SentryOptions.Logs.BeforeSendLogCallback beforeSend = this.options.getLogs().getBeforeSend();
        if (beforeSend == null) {
            return sentryLogEvent;
        }
        try {
            return beforeSend.execute(sentryLogEvent);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "The BeforeSendLog callback threw an exception. Dropping log event.", th);
            return null;
        }
    }

    @Override // io.sentry.ISentryClient
    public void close() {
        close(false);
    }

    @Override // io.sentry.ISentryClient
    public void close(boolean z) {
        long shutdownTimeoutMillis;
        this.options.getLogger().log(SentryLevel.INFO, "Closing SentryClient.", new Object[0]);
        if (z) {
            shutdownTimeoutMillis = 0;
        } else {
            try {
                shutdownTimeoutMillis = this.options.getShutdownTimeoutMillis();
            } catch (IOException e) {
                this.options.getLogger().log(SentryLevel.WARNING, "Failed to close the connection to the Sentry Server.", e);
            }
        }
        flush(shutdownTimeoutMillis);
        this.loggerBatchProcessor.close(z);
        this.transport.close(z);
        for (EventProcessor eventProcessor : this.options.getEventProcessors()) {
            if (eventProcessor instanceof Closeable) {
                try {
                    ((Closeable) eventProcessor).close();
                } catch (IOException e2) {
                    this.options.getLogger().log(SentryLevel.WARNING, "Failed to close the event processor {}.", eventProcessor, e2);
                }
            }
        }
        this.enabled = false;
    }

    @Override // io.sentry.ISentryClient
    public void flush(long j) {
        this.loggerBatchProcessor.flush(j);
        this.transport.flush(j);
    }

    @Override // io.sentry.ISentryClient
    public RateLimiter getRateLimiter() {
        return this.transport.getRateLimiter();
    }

    @Override // io.sentry.ISentryClient
    public boolean isHealthy() {
        return this.transport.isHealthy();
    }

    private boolean sample() {
        Random randomCurrent = this.options.getSampleRate() == null ? null : SentryRandom.current();
        return this.options.getSampleRate() == null || randomCurrent == null || this.options.getSampleRate().doubleValue() >= randomCurrent.nextDouble();
    }

    static final class SortBreadcrumbsByDate implements Comparator<Breadcrumb> {
        private SortBreadcrumbsByDate() {
        }

        @Override // java.util.Comparator
        public int compare(@NotNull Breadcrumb breadcrumb, @NotNull Breadcrumb breadcrumb2) {
            return breadcrumb.getTimestamp().compareTo(breadcrumb2.getTimestamp());
        }
    }
}
