package io.sentry;

import io.sentry.clientreport.DiscardReason;
import io.sentry.clientreport.IClientReportRecorder;
import io.sentry.hints.SessionEndHint;
import io.sentry.hints.SessionStartHint;
import io.sentry.logger.ILoggerApi;
import io.sentry.logger.LoggerApi;
import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import io.sentry.transport.RateLimiter;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import io.sentry.util.SpanUtils;
import io.sentry.util.TracingUtils;
import java.io.Closeable;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class Scopes implements IScopes {
    private final CombinedScopeView combinedScope;
    private final CompositePerformanceCollector compositePerformanceCollector;
    private final String creator;
    private final IScope globalScope;
    private final IScope isolationScope;
    private final ILoggerApi logger;
    private final Scopes parentScopes;
    private final IScope scope;

    public Scopes(@NotNull IScope iScope, @NotNull IScope iScope2, @NotNull IScope iScope3, @NotNull String str) {
        this(iScope, iScope2, iScope3, null, str);
    }

    private Scopes(@NotNull IScope iScope, @NotNull IScope iScope2, @NotNull IScope iScope3, @Nullable Scopes scopes, @NotNull String str) {
        this.combinedScope = new CombinedScopeView(iScope3, iScope2, iScope);
        this.scope = iScope;
        this.isolationScope = iScope2;
        this.globalScope = iScope3;
        this.parentScopes = scopes;
        this.creator = str;
        SentryOptions options = getOptions();
        validateOptions(options);
        this.compositePerformanceCollector = options.getCompositePerformanceCollector();
        this.logger = new LoggerApi(this);
    }

    public String getCreator() {
        return this.creator;
    }

    @Override // io.sentry.IScopes
    public IScope getScope() {
        return this.scope;
    }

    @Override // io.sentry.IScopes
    public IScope getIsolationScope() {
        return this.isolationScope;
    }

    @Override // io.sentry.IScopes
    public IScope getGlobalScope() {
        return this.globalScope;
    }

    @Override // io.sentry.IScopes
    public IScopes getParentScopes() {
        return this.parentScopes;
    }

    @Override // io.sentry.IScopes
    public boolean isAncestorOf(@Nullable IScopes iScopes) {
        if (iScopes == null) {
            return false;
        }
        if (this == iScopes) {
            return true;
        }
        if (iScopes.getParentScopes() != null) {
            return isAncestorOf(iScopes.getParentScopes());
        }
        return false;
    }

    @Override // io.sentry.IScopes
    public IScopes forkedScopes(@NotNull String str) {
        return new Scopes(this.scope.m5364clone(), this.isolationScope.m5364clone(), this.globalScope, this, str);
    }

    @Override // io.sentry.IScopes
    public IScopes forkedCurrentScope(@NotNull String str) {
        return new Scopes(this.scope.m5364clone(), this.isolationScope, this.globalScope, this, str);
    }

    @Override // io.sentry.IScopes
    public IScopes forkedRootScopes(@NotNull String str) {
        return Sentry.forkedRootScopes(str);
    }

    @Override // io.sentry.IScopes
    public boolean isEnabled() {
        return getClient().isEnabled();
    }

    @Override // io.sentry.IScopes
    public SentryId captureEvent(@NotNull SentryEvent sentryEvent, @Nullable Hint hint) {
        return captureEventInternal(sentryEvent, hint, null);
    }

    @Override // io.sentry.IScopes
    public SentryId captureEvent(@NotNull SentryEvent sentryEvent, @Nullable Hint hint, @NotNull ScopeCallback scopeCallback) {
        return captureEventInternal(sentryEvent, hint, scopeCallback);
    }

    private SentryId captureEventInternal(@NotNull SentryEvent sentryEvent, @Nullable Hint hint, @Nullable ScopeCallback scopeCallback) {
        SentryId sentryIdCaptureEvent = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureEvent' call is a no-op.", new Object[0]);
            return sentryIdCaptureEvent;
        }
        if (sentryEvent == null) {
            getOptions().getLogger().log(SentryLevel.WARNING, "captureEvent called with null parameter.", new Object[0]);
            return sentryIdCaptureEvent;
        }
        try {
            assignTraceContext(sentryEvent);
            sentryIdCaptureEvent = getClient().captureEvent(sentryEvent, buildLocalScope(getCombinedScopeView(), scopeCallback), hint);
            updateLastEventId(sentryIdCaptureEvent);
            return sentryIdCaptureEvent;
        } catch (Throwable th) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing event with id: " + sentryEvent.getEventId(), th);
            return sentryIdCaptureEvent;
        }
    }

    public ISentryClient getClient() {
        return getCombinedScopeView().getClient();
    }

    private void assignTraceContext(@NotNull SentryEvent sentryEvent) {
        getCombinedScopeView().assignTraceContext(sentryEvent);
    }

    private IScope buildLocalScope(@NotNull IScope iScope, @Nullable ScopeCallback scopeCallback) {
        if (scopeCallback != null) {
            try {
                IScope iScopeM5372clone = iScope.m5364clone();
                scopeCallback.run(iScopeM5372clone);
                return iScopeM5372clone;
            } catch (Throwable th) {
                getOptions().getLogger().log(SentryLevel.ERROR, "Error in the 'ScopeCallback' callback.", th);
            }
        }
        return iScope;
    }

    @Override // io.sentry.IScopes
    public SentryId captureMessage(@NotNull String str, @NotNull SentryLevel sentryLevel) {
        return captureMessageInternal(str, sentryLevel, null);
    }

    @Override // io.sentry.IScopes
    public SentryId captureMessage(@NotNull String str, @NotNull SentryLevel sentryLevel, @NotNull ScopeCallback scopeCallback) {
        return captureMessageInternal(str, sentryLevel, scopeCallback);
    }

    private SentryId captureMessageInternal(@NotNull String str, @NotNull SentryLevel sentryLevel, @Nullable ScopeCallback scopeCallback) {
        SentryId sentryIdCaptureMessage = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureMessage' call is a no-op.", new Object[0]);
        } else if (str == null) {
            getOptions().getLogger().log(SentryLevel.WARNING, "captureMessage called with null parameter.", new Object[0]);
        } else {
            try {
                sentryIdCaptureMessage = getClient().captureMessage(str, sentryLevel, buildLocalScope(getCombinedScopeView(), scopeCallback));
            } catch (Throwable th) {
                getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing message: " + str, th);
            }
        }
        updateLastEventId(sentryIdCaptureMessage);
        return sentryIdCaptureMessage;
    }

    @Override // io.sentry.IScopes
    public SentryId captureFeedback(@NotNull Feedback feedback, @Nullable Hint hint, @Nullable ScopeCallback scopeCallback) {
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureFeedback' call is a no-op.", new Object[0]);
            return sentryId;
        }
        if (feedback.getMessage().isEmpty()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "captureFeedback called with empty message.", new Object[0]);
            return sentryId;
        }
        try {
            return getClient().captureFeedback(feedback, hint, buildLocalScope(getCombinedScopeView(), scopeCallback));
        } catch (Throwable th) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing feedback: " + feedback.getMessage(), th);
            return sentryId;
        }
    }

    @Override // io.sentry.IScopes
    public SentryId captureEnvelope(@NotNull SentryEnvelope sentryEnvelope, @Nullable Hint hint) {
        Objects.requireNonNull(sentryEnvelope, "SentryEnvelope is required.");
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureEnvelope' call is a no-op.", new Object[0]);
            return sentryId;
        }
        try {
            SentryId sentryIdCaptureEnvelope = getClient().captureEnvelope(sentryEnvelope, hint);
            return sentryIdCaptureEnvelope != null ? sentryIdCaptureEnvelope : sentryId;
        } catch (Throwable th) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing envelope.", th);
            return sentryId;
        }
    }

    @Override // io.sentry.IScopes
    public SentryId captureException(@NotNull Throwable th, @Nullable Hint hint) {
        return captureExceptionInternal(th, hint, null);
    }

    @Override // io.sentry.IScopes
    public SentryId captureException(@NotNull Throwable th, @Nullable Hint hint, @NotNull ScopeCallback scopeCallback) {
        return captureExceptionInternal(th, hint, scopeCallback);
    }

    private SentryId captureExceptionInternal(@NotNull Throwable th, @Nullable Hint hint, @Nullable ScopeCallback scopeCallback) {
        SentryId sentryIdCaptureEvent = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureException' call is a no-op.", new Object[0]);
        } else if (th == null) {
            getOptions().getLogger().log(SentryLevel.WARNING, "captureException called with null parameter.", new Object[0]);
        } else {
            try {
                SentryEvent sentryEvent = new SentryEvent(th);
                assignTraceContext(sentryEvent);
                sentryIdCaptureEvent = getClient().captureEvent(sentryEvent, buildLocalScope(getCombinedScopeView(), scopeCallback), hint);
            } catch (Throwable th2) {
                getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing exception: " + th.getMessage(), th2);
            }
        }
        updateLastEventId(sentryIdCaptureEvent);
        return sentryIdCaptureEvent;
    }

    @Override // io.sentry.IScopes
    public void captureUserFeedback(@NotNull UserFeedback userFeedback) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureUserFeedback' call is a no-op.", new Object[0]);
            return;
        }
        try {
            getClient().captureUserFeedback(userFeedback);
        } catch (Throwable th) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing captureUserFeedback: " + userFeedback.toString(), th);
        }
    }

    @Override // io.sentry.IScopes
    public void startSession() {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'startSession' call is a no-op.", new Object[0]);
            return;
        }
        Scope.SessionPair sessionPairStartSession = getCombinedScopeView().startSession();
        if (sessionPairStartSession != null) {
            if (sessionPairStartSession.getPrevious() != null) {
                getClient().captureSession(sessionPairStartSession.getPrevious(), HintUtils.createWithTypeCheckHint(new SessionEndHint()));
            }
            getClient().captureSession(sessionPairStartSession.getCurrent(), HintUtils.createWithTypeCheckHint(new SessionStartHint()));
            return;
        }
        getOptions().getLogger().log(SentryLevel.WARNING, "Session could not be started.", new Object[0]);
    }

    @Override // io.sentry.IScopes
    public void endSession() {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'endSession' call is a no-op.", new Object[0]);
            return;
        }
        Session sessionEndSession = getCombinedScopeView().endSession();
        if (sessionEndSession != null) {
            getClient().captureSession(sessionEndSession, HintUtils.createWithTypeCheckHint(new SessionEndHint()));
        }
    }

    public IScope getCombinedScopeView() {
        return this.combinedScope;
    }

    @Override // io.sentry.IScopes
    public void close() {
        close(false);
    }

    @Override // io.sentry.IScopes
    public void close(final boolean z) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'close' call is a no-op.", new Object[0]);
            return;
        }
        try {
            for (Integration integration : getOptions().getIntegrations()) {
                if (integration instanceof Closeable) {
                    try {
                        ((Closeable) integration).close();
                    } catch (Throwable th) {
                        getOptions().getLogger().log(SentryLevel.WARNING, "Failed to close the integration {}.", integration, th);
                    }
                }
            }
            configureScope(new ScopeCallback() { // from class: io.sentry.Scopes$$ExternalSyntheticLambda1
                @Override // io.sentry.ScopeCallback
                public final void run(IScope iScope) {
                    iScope.clear();
                }
            });
            ScopeType scopeType = ScopeType.ISOLATION;
            configureScope(scopeType, new ScopeCallback() { // from class: io.sentry.Scopes$$ExternalSyntheticLambda2
                @Override // io.sentry.ScopeCallback
                public final void run(IScope iScope) {
                    iScope.clear();
                }
            });
            getOptions().getBackpressureMonitor().close();
            getOptions().getTransactionProfiler().close();
            getOptions().getContinuousProfiler().close(true);
            getOptions().getCompositePerformanceCollector().close();
            getOptions().getConnectionStatusProvider().close();
            final ISentryExecutorService executorService = getOptions().getExecutorService();
            if (z) {
                executorService.submit(new Runnable() { // from class: io.sentry.Scopes$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$close$2(executorService);
                    }
                });
            } else {
                executorService.close(getOptions().getShutdownTimeoutMillis());
            }
            configureScope(ScopeType.CURRENT, new ScopeCallback() { // from class: io.sentry.Scopes$$ExternalSyntheticLambda4
                @Override // io.sentry.ScopeCallback
                public final void run(IScope iScope) {
                    Scopes.lambda$close$3(z, iScope);
                }
            });
            configureScope(scopeType, new ScopeCallback() { // from class: io.sentry.Scopes$$ExternalSyntheticLambda5
                @Override // io.sentry.ScopeCallback
                public final void run(IScope iScope) {
                    Scopes.lambda$close$4(z, iScope);
                }
            });
            configureScope(ScopeType.GLOBAL, new ScopeCallback() { // from class: io.sentry.Scopes$$ExternalSyntheticLambda6
                @Override // io.sentry.ScopeCallback
                public final void run(IScope iScope) {
                    Scopes.lambda$close$5(z, iScope);
                }
            });
        } catch (Throwable th2) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error while closing the Scopes.", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$close$2(ISentryExecutorService iSentryExecutorService) {
        iSentryExecutorService.close(getOptions().getShutdownTimeoutMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$close$3(boolean z, IScope iScope) {
        iScope.getClient().close(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$close$4(boolean z, IScope iScope) {
        iScope.getClient().close(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$close$5(boolean z, IScope iScope) {
        iScope.getClient().close(z);
    }

    @Override // io.sentry.IScopes
    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable Hint hint) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'addBreadcrumb' call is a no-op.", new Object[0]);
        } else if (breadcrumb == null) {
            getOptions().getLogger().log(SentryLevel.WARNING, "addBreadcrumb called with null parameter.", new Object[0]);
        } else {
            getCombinedScopeView().addBreadcrumb(breadcrumb, hint);
        }
    }

    @Override // io.sentry.IScopes
    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb) {
        addBreadcrumb(breadcrumb, new Hint());
    }

    @Override // io.sentry.IScopes
    public void setLevel(@Nullable SentryLevel sentryLevel) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setLevel' call is a no-op.", new Object[0]);
        } else {
            getCombinedScopeView().setLevel(sentryLevel);
        }
    }

    @Override // io.sentry.IScopes
    public void setTransaction(@Nullable String str) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setTransaction' call is a no-op.", new Object[0]);
        } else if (str != null) {
            getCombinedScopeView().setTransaction(str);
        } else {
            getOptions().getLogger().log(SentryLevel.WARNING, "Transaction cannot be null", new Object[0]);
        }
    }

    @Override // io.sentry.IScopes
    public void setUser(@Nullable User user) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setUser' call is a no-op.", new Object[0]);
        } else {
            getCombinedScopeView().setUser(user);
        }
    }

    @Override // io.sentry.IScopes
    public void setFingerprint(@NotNull List<String> list) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setFingerprint' call is a no-op.", new Object[0]);
        } else if (list == null) {
            getOptions().getLogger().log(SentryLevel.WARNING, "setFingerprint called with null parameter.", new Object[0]);
        } else {
            getCombinedScopeView().setFingerprint(list);
        }
    }

    @Override // io.sentry.IScopes
    public void clearBreadcrumbs() {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'clearBreadcrumbs' call is a no-op.", new Object[0]);
        } else {
            getCombinedScopeView().clearBreadcrumbs();
        }
    }

    @Override // io.sentry.IScopes
    public void setTag(@Nullable String str, @Nullable String str2) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setTag' call is a no-op.", new Object[0]);
        } else if (str == null || str2 == null) {
            getOptions().getLogger().log(SentryLevel.WARNING, "setTag called with null parameter.", new Object[0]);
        } else {
            getCombinedScopeView().setTag(str, str2);
        }
    }

    @Override // io.sentry.IScopes
    public void removeTag(@Nullable String str) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'removeTag' call is a no-op.", new Object[0]);
        } else if (str == null) {
            getOptions().getLogger().log(SentryLevel.WARNING, "removeTag called with null parameter.", new Object[0]);
        } else {
            getCombinedScopeView().removeTag(str);
        }
    }

    @Override // io.sentry.IScopes
    public void setExtra(@Nullable String str, @Nullable String str2) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setExtra' call is a no-op.", new Object[0]);
        } else if (str == null || str2 == null) {
            getOptions().getLogger().log(SentryLevel.WARNING, "setExtra called with null parameter.", new Object[0]);
        } else {
            getCombinedScopeView().setExtra(str, str2);
        }
    }

    @Override // io.sentry.IScopes
    public void removeExtra(@Nullable String str) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'removeExtra' call is a no-op.", new Object[0]);
        } else if (str == null) {
            getOptions().getLogger().log(SentryLevel.WARNING, "removeExtra called with null parameter.", new Object[0]);
        } else {
            getCombinedScopeView().removeExtra(str);
        }
    }

    private void updateLastEventId(@NotNull SentryId sentryId) {
        getCombinedScopeView().setLastEventId(sentryId);
    }

    @Override // io.sentry.IScopes
    public SentryId getLastEventId() {
        return getCombinedScopeView().getLastEventId();
    }

    @Override // io.sentry.IScopes
    public ISentryLifecycleToken pushScope() {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'pushScope' call is a no-op.", new Object[0]);
            return NoOpScopesLifecycleToken.getInstance();
        }
        return forkedCurrentScope("pushScope").makeCurrent();
    }

    @Override // io.sentry.IScopes
    public ISentryLifecycleToken pushIsolationScope() {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'pushIsolationScope' call is a no-op.", new Object[0]);
            return NoOpScopesLifecycleToken.getInstance();
        }
        return forkedScopes("pushIsolationScope").makeCurrent();
    }

    @Override // io.sentry.IScopes
    public ISentryLifecycleToken makeCurrent() {
        return Sentry.setCurrentScopes(this);
    }

    @Override // io.sentry.IScopes
    @Deprecated
    public void popScope() {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'popScope' call is a no-op.", new Object[0]);
            return;
        }
        Scopes scopes = this.parentScopes;
        if (scopes != null) {
            scopes.makeCurrent();
        }
    }

    @Override // io.sentry.IScopes
    public void withScope(@NotNull ScopeCallback scopeCallback) {
        if (!isEnabled()) {
            try {
                scopeCallback.run(NoOpScope.getInstance());
                return;
            } catch (Throwable th) {
                getOptions().getLogger().log(SentryLevel.ERROR, "Error in the 'withScope' callback.", th);
                return;
            }
        }
        IScopes iScopesForkedCurrentScope = forkedCurrentScope("withScope");
        try {
            ISentryLifecycleToken iSentryLifecycleTokenMakeCurrent = iScopesForkedCurrentScope.makeCurrent();
            try {
                scopeCallback.run(iScopesForkedCurrentScope.getScope());
                if (iSentryLifecycleTokenMakeCurrent != null) {
                    iSentryLifecycleTokenMakeCurrent.close();
                }
            } catch (Throwable th2) {
                if (iSentryLifecycleTokenMakeCurrent != null) {
                    try {
                        iSentryLifecycleTokenMakeCurrent.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        } catch (Throwable th4) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error in the 'withScope' callback.", th4);
        }
    }

    @Override // io.sentry.IScopes
    public void withIsolationScope(@NotNull ScopeCallback scopeCallback) {
        if (!isEnabled()) {
            try {
                scopeCallback.run(NoOpScope.getInstance());
                return;
            } catch (Throwable th) {
                getOptions().getLogger().log(SentryLevel.ERROR, "Error in the 'withIsolationScope' callback.", th);
                return;
            }
        }
        IScopes iScopesForkedScopes = forkedScopes("withIsolationScope");
        try {
            ISentryLifecycleToken iSentryLifecycleTokenMakeCurrent = iScopesForkedScopes.makeCurrent();
            try {
                scopeCallback.run(iScopesForkedScopes.getIsolationScope());
                if (iSentryLifecycleTokenMakeCurrent != null) {
                    iSentryLifecycleTokenMakeCurrent.close();
                }
            } catch (Throwable th2) {
                if (iSentryLifecycleTokenMakeCurrent != null) {
                    try {
                        iSentryLifecycleTokenMakeCurrent.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        } catch (Throwable th4) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error in the 'withIsolationScope' callback.", th4);
        }
    }

    @Override // io.sentry.IScopes
    public void configureScope(@Nullable ScopeType scopeType, @NotNull ScopeCallback scopeCallback) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            return;
        }
        try {
            scopeCallback.run(this.combinedScope.getSpecificScope(scopeType));
        } catch (Throwable th) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error in the 'configureScope' callback.", th);
        }
    }

    @Override // io.sentry.IScopes
    public void bindClient(@NotNull ISentryClient iSentryClient) {
        if (iSentryClient != null) {
            getOptions().getLogger().log(SentryLevel.DEBUG, "New client bound to scope.", new Object[0]);
            getCombinedScopeView().bindClient(iSentryClient);
        } else {
            getOptions().getLogger().log(SentryLevel.DEBUG, "NoOp client bound to scope.", new Object[0]);
            getCombinedScopeView().bindClient(NoOpSentryClient.getInstance());
        }
    }

    @Override // io.sentry.IScopes
    public boolean isHealthy() {
        return getClient().isHealthy();
    }

    @Override // io.sentry.IScopes
    public void flush(long j) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'flush' call is a no-op.", new Object[0]);
            return;
        }
        try {
            getClient().flush(j);
        } catch (Throwable th) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error in the 'client.flush'.", th);
        }
    }

    @Override // io.sentry.IScopes
    @Deprecated
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public IHub m5380clone() {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Disabled Scopes cloned.", new Object[0]);
        }
        return new HubScopesWrapper(forkedScopes("scopes clone"));
    }

    @Override // io.sentry.IScopes
    public SentryId captureTransaction(@NotNull SentryTransaction sentryTransaction, @Nullable TraceContext traceContext, @Nullable Hint hint, @Nullable ProfilingTraceData profilingTraceData) {
        Objects.requireNonNull(sentryTransaction, "transaction is required");
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
            return sentryId;
        }
        if (!sentryTransaction.isFinished()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Transaction: %s is not finished and this 'captureTransaction' call is a no-op.", sentryTransaction.getEventId());
            return sentryId;
        }
        if (!Boolean.TRUE.equals(Boolean.valueOf(sentryTransaction.isSampled()))) {
            getOptions().getLogger().log(SentryLevel.DEBUG, "Transaction %s was dropped due to sampling decision.", sentryTransaction.getEventId());
            if (getOptions().getBackpressureMonitor().getDownsampleFactor() > 0) {
                IClientReportRecorder clientReportRecorder = getOptions().getClientReportRecorder();
                DiscardReason discardReason = DiscardReason.BACKPRESSURE;
                clientReportRecorder.recordLostEvent(discardReason, DataCategory.Transaction);
                getOptions().getClientReportRecorder().recordLostEvent(discardReason, DataCategory.Span, sentryTransaction.getSpans().size() + 1);
                return sentryId;
            }
            IClientReportRecorder clientReportRecorder2 = getOptions().getClientReportRecorder();
            DiscardReason discardReason2 = DiscardReason.SAMPLE_RATE;
            clientReportRecorder2.recordLostEvent(discardReason2, DataCategory.Transaction);
            getOptions().getClientReportRecorder().recordLostEvent(discardReason2, DataCategory.Span, sentryTransaction.getSpans().size() + 1);
            return sentryId;
        }
        try {
            return getClient().captureTransaction(sentryTransaction, traceContext, getCombinedScopeView(), hint, profilingTraceData);
        } catch (Throwable th) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing transaction with id: " + sentryTransaction.getEventId(), th);
            return sentryId;
        }
    }

    @Override // io.sentry.IScopes
    public SentryId captureProfileChunk(@NotNull ProfileChunk profileChunk) {
        Objects.requireNonNull(profileChunk, "profilingContinuousData is required");
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
            return sentryId;
        }
        try {
            return getClient().captureProfileChunk(profileChunk, getScope());
        } catch (Throwable th) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing profile chunk with id: " + profileChunk.getChunkId(), th);
            return sentryId;
        }
    }

    @Override // io.sentry.IScopes
    public ITransaction startTransaction(@NotNull TransactionContext transactionContext, @NotNull TransactionOptions transactionOptions) {
        return createTransaction(transactionContext, transactionOptions);
    }

    private ITransaction createTransaction(@NotNull TransactionContext transactionContext, @NotNull TransactionOptions transactionOptions) {
        ITransaction iTransactionCreateTransaction;
        Objects.requireNonNull(transactionContext, "transactionContext is required");
        transactionContext.setOrigin(transactionOptions.getOrigin());
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            iTransactionCreateTransaction = NoOpTransaction.getInstance();
        } else if (SpanUtils.isIgnored(getOptions().getIgnoredSpanOrigins(), transactionContext.getOrigin())) {
            getOptions().getLogger().log(SentryLevel.DEBUG, "Returning no-op for span origin %s as the SDK has been configured to ignore it", transactionContext.getOrigin());
            iTransactionCreateTransaction = NoOpTransaction.getInstance();
        } else if (!getOptions().getInstrumenter().equals(transactionContext.getInstrumenter())) {
            getOptions().getLogger().log(SentryLevel.DEBUG, "Returning no-op for instrumenter %s as the SDK has been configured to use instrumenter %s", transactionContext.getInstrumenter(), getOptions().getInstrumenter());
            iTransactionCreateTransaction = NoOpTransaction.getInstance();
        } else if (!getOptions().isTracingEnabled()) {
            getOptions().getLogger().log(SentryLevel.INFO, "Tracing is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            iTransactionCreateTransaction = NoOpTransaction.getInstance();
        } else {
            TracesSamplingDecision tracesSamplingDecisionSample = getOptions().getInternalTracesSampler().sample(new SamplingContext(transactionContext, transactionOptions.getCustomSamplingContext(), getSampleRand(transactionContext), null));
            transactionContext.setSamplingDecision(tracesSamplingDecisionSample);
            ISpanFactory spanFactory = transactionOptions.getSpanFactory();
            if (spanFactory == null) {
                spanFactory = getOptions().getSpanFactory();
            }
            iTransactionCreateTransaction = spanFactory.createTransaction(transactionContext, this, transactionOptions, this.compositePerformanceCollector);
            if (tracesSamplingDecisionSample.getSampled().booleanValue()) {
                if (tracesSamplingDecisionSample.getProfileSampled().booleanValue()) {
                    ITransactionProfiler transactionProfiler = getOptions().getTransactionProfiler();
                    if (!transactionProfiler.isRunning()) {
                        transactionProfiler.start();
                        transactionProfiler.bindTransaction(iTransactionCreateTransaction);
                    } else if (transactionOptions.isAppStartTransaction()) {
                        transactionProfiler.bindTransaction(iTransactionCreateTransaction);
                    }
                }
                if (getOptions().isContinuousProfilingEnabled()) {
                    ProfileLifecycle profileLifecycle = getOptions().getProfileLifecycle();
                    ProfileLifecycle profileLifecycle2 = ProfileLifecycle.TRACE;
                    if (profileLifecycle == profileLifecycle2) {
                        getOptions().getContinuousProfiler().startProfiler(profileLifecycle2, getOptions().getInternalTracesSampler());
                    }
                }
            }
        }
        if (transactionOptions.isBindToScope()) {
            iTransactionCreateTransaction.makeCurrent();
        }
        return iTransactionCreateTransaction;
    }

    private Double getSampleRand(@NotNull TransactionContext transactionContext) {
        Double sampleRand;
        Baggage baggage = transactionContext.getBaggage();
        return (baggage == null || (sampleRand = baggage.getSampleRand()) == null) ? getCombinedScopeView().getPropagationContext().getSampleRand() : sampleRand;
    }

    @Override // io.sentry.IScopes
    public void startProfiler() {
        if (getOptions().isContinuousProfilingEnabled()) {
            ProfileLifecycle profileLifecycle = getOptions().getProfileLifecycle();
            ProfileLifecycle profileLifecycle2 = ProfileLifecycle.MANUAL;
            if (profileLifecycle != profileLifecycle2) {
                getOptions().getLogger().log(SentryLevel.WARNING, "Profiling lifecycle is %s. Profiling cannot be started manually.", getOptions().getProfileLifecycle().name());
                return;
            } else {
                getOptions().getContinuousProfiler().startProfiler(profileLifecycle2, getOptions().getInternalTracesSampler());
                return;
            }
        }
        if (getOptions().isProfilingEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Continuous Profiling is not enabled. Set profilesSampleRate and profilesSampler to null to enable it.", new Object[0]);
        }
    }

    @Override // io.sentry.IScopes
    public void stopProfiler() {
        if (getOptions().isContinuousProfilingEnabled()) {
            ProfileLifecycle profileLifecycle = getOptions().getProfileLifecycle();
            ProfileLifecycle profileLifecycle2 = ProfileLifecycle.MANUAL;
            if (profileLifecycle != profileLifecycle2) {
                getOptions().getLogger().log(SentryLevel.WARNING, "Profiling lifecycle is %s. Profiling cannot be stopped manually.", getOptions().getProfileLifecycle().name());
                return;
            } else {
                getOptions().getLogger().log(SentryLevel.DEBUG, "Stopped continuous Profiling.", new Object[0]);
                getOptions().getContinuousProfiler().stopProfiler(profileLifecycle2);
                return;
            }
        }
        getOptions().getLogger().log(SentryLevel.WARNING, "Continuous Profiling is not enabled. Set profilesSampleRate and profilesSampler to null to enable it.", new Object[0]);
    }

    @Override // io.sentry.IScopes
    public void setSpanContext(@NotNull Throwable th, @NotNull ISpan iSpan, @NotNull String str) {
        getCombinedScopeView().setSpanContext(th, iSpan, str);
    }

    @Override // io.sentry.IScopes
    public ISpan getSpan() {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'getSpan' call is a no-op.", new Object[0]);
            return null;
        }
        return getCombinedScopeView().getSpan();
    }

    @Override // io.sentry.IScopes
    public void setActiveSpan(@Nullable ISpan iSpan) {
        getCombinedScopeView().setActiveSpan(iSpan);
    }

    @Override // io.sentry.IScopes
    public ITransaction getTransaction() {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'getTransaction' call is a no-op.", new Object[0]);
            return null;
        }
        return getCombinedScopeView().getTransaction();
    }

    @Override // io.sentry.IScopes
    public SentryOptions getOptions() {
        return this.combinedScope.getOptions();
    }

    @Override // io.sentry.IScopes
    public Boolean isCrashedLastRun() {
        return SentryCrashLastRunState.getInstance().isCrashedLastRun(getOptions().getCacheDirPath(), !getOptions().isEnableAutoSessionTracking());
    }

    @Override // io.sentry.IScopes
    public void reportFullyDisplayed() {
        if (getOptions().isEnableTimeToFullDisplayTracing()) {
            getOptions().getFullyDisplayedReporter().reportFullyDrawn();
        }
    }

    @Override // io.sentry.IScopes
    public TransactionContext continueTrace(@Nullable String str, @Nullable List<String> list) {
        final PropagationContext propagationContextFromHeaders = PropagationContext.fromHeaders(getOptions().getLogger(), str, list);
        configureScope(new ScopeCallback() { // from class: io.sentry.Scopes$$ExternalSyntheticLambda7
            @Override // io.sentry.ScopeCallback
            public final void run(IScope iScope) {
                Scopes.lambda$continueTrace$7(propagationContextFromHeaders, iScope);
            }
        });
        if (getOptions().isTracingEnabled()) {
            return TransactionContext.fromPropagationContext(propagationContextFromHeaders);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$continueTrace$7(final PropagationContext propagationContext, final IScope iScope) {
        iScope.withPropagationContext(new Scope.IWithPropagationContext() { // from class: io.sentry.Scopes$$ExternalSyntheticLambda0
            @Override // io.sentry.Scope.IWithPropagationContext
            public final void accept(PropagationContext propagationContext2) {
                iScope.setPropagationContext(propagationContext);
            }
        });
    }

    @Override // io.sentry.IScopes
    public SentryTraceHeader getTraceparent() {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'getTraceparent' call is a no-op.", new Object[0]);
        } else {
            TracingUtils.TracingHeaders tracingHeadersTrace = TracingUtils.trace(this, null, getSpan());
            if (tracingHeadersTrace != null) {
                return tracingHeadersTrace.getSentryTraceHeader();
            }
        }
        return null;
    }

    @Override // io.sentry.IScopes
    public BaggageHeader getBaggage() {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'getBaggage' call is a no-op.", new Object[0]);
        } else {
            TracingUtils.TracingHeaders tracingHeadersTrace = TracingUtils.trace(this, null, getSpan());
            if (tracingHeadersTrace != null) {
                return tracingHeadersTrace.getBaggageHeader();
            }
        }
        return null;
    }

    @Override // io.sentry.IScopes
    public SentryId captureCheckIn(@NotNull CheckIn checkIn) {
        SentryId sentryIdCaptureCheckIn = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureCheckIn' call is a no-op.", new Object[0]);
        } else {
            try {
                sentryIdCaptureCheckIn = getClient().captureCheckIn(checkIn, getCombinedScopeView(), null);
            } catch (Throwable th) {
                getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing check-in for slug", th);
            }
        }
        updateLastEventId(sentryIdCaptureCheckIn);
        return sentryIdCaptureCheckIn;
    }

    @Override // io.sentry.IScopes
    public SentryId captureReplay(@NotNull SentryReplayEvent sentryReplayEvent, @Nullable Hint hint) {
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureReplay' call is a no-op.", new Object[0]);
            return sentryId;
        }
        try {
            return getClient().captureReplayEvent(sentryReplayEvent, getCombinedScopeView(), hint);
        } catch (Throwable th) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing replay", th);
            return sentryId;
        }
    }

    @Override // io.sentry.IScopes
    public RateLimiter getRateLimiter() {
        return getClient().getRateLimiter();
    }

    @Override // io.sentry.IScopes
    public ILoggerApi logger() {
        return this.logger;
    }

    private static void validateOptions(@NotNull SentryOptions sentryOptions) {
        Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        if (sentryOptions.getDsn() == null || sentryOptions.getDsn().isEmpty()) {
            throw new IllegalArgumentException("Scopes requires a DSN to be instantiated. Considering using the NoOpScopes if no DSN is available.");
        }
    }
}
