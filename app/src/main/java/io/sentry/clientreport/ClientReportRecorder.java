package io.sentry.clientreport;

import io.sentry.DataCategory;
import io.sentry.DateUtils;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.SentryTransaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class ClientReportRecorder implements IClientReportRecorder {
    private final SentryOptions options;
    private final IClientReportStorage storage = new AtomicClientReportStorage();

    public ClientReportRecorder(@NotNull SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public SentryEnvelope attachReportToEnvelope(@NotNull SentryEnvelope sentryEnvelope) {
        ClientReport clientReportResetCountsAndGenerateClientReport = resetCountsAndGenerateClientReport();
        if (clientReportResetCountsAndGenerateClientReport == null) {
            return sentryEnvelope;
        }
        try {
            this.options.getLogger().log(SentryLevel.DEBUG, "Attaching client report to envelope.", new Object[0]);
            ArrayList arrayList = new ArrayList();
            Iterator<SentryEnvelopeItem> it2 = sentryEnvelope.getItems().iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
            arrayList.add(SentryEnvelopeItem.fromClientReport(this.options.getSerializer(), clientReportResetCountsAndGenerateClientReport));
            return new SentryEnvelope(sentryEnvelope.getHeader(), arrayList);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, th, "Unable to attach client report to envelope.", new Object[0]);
            return sentryEnvelope;
        }
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public void recordLostEnvelope(@NotNull DiscardReason discardReason, @Nullable SentryEnvelope sentryEnvelope) {
        if (sentryEnvelope == null) {
            return;
        }
        try {
            Iterator<SentryEnvelopeItem> it2 = sentryEnvelope.getItems().iterator();
            while (it2.hasNext()) {
                recordLostEnvelopeItem(discardReason, it2.next());
            }
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, th, "Unable to record lost envelope.", new Object[0]);
        }
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public void recordLostEnvelopeItem(@NotNull DiscardReason discardReason, @Nullable SentryEnvelopeItem sentryEnvelopeItem) {
        SentryTransaction transaction;
        if (sentryEnvelopeItem == null) {
            return;
        }
        try {
            SentryItemType type = sentryEnvelopeItem.getHeader().getType();
            if (SentryItemType.ClientReport.equals(type)) {
                try {
                    restoreCountsFromClientReport(sentryEnvelopeItem.getClientReport(this.options.getSerializer()));
                    return;
                } catch (Exception unused) {
                    this.options.getLogger().log(SentryLevel.ERROR, "Unable to restore counts from previous client report.", new Object[0]);
                    return;
                }
            }
            DataCategory dataCategoryCategoryFromItemType = categoryFromItemType(type);
            if (dataCategoryCategoryFromItemType.equals(DataCategory.Transaction) && (transaction = sentryEnvelopeItem.getTransaction(this.options.getSerializer())) != null) {
                List<SentrySpan> spans = transaction.getSpans();
                String reason = discardReason.getReason();
                DataCategory dataCategory = DataCategory.Span;
                recordLostEventInternal(reason, dataCategory.getCategory(), Long.valueOf(((long) spans.size()) + 1));
                executeOnDiscard(discardReason, dataCategory, Long.valueOf(((long) spans.size()) + 1));
            }
            recordLostEventInternal(discardReason.getReason(), dataCategoryCategoryFromItemType.getCategory(), 1L);
            executeOnDiscard(discardReason, dataCategoryCategoryFromItemType, 1L);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, th, "Unable to record lost envelope item.", new Object[0]);
        }
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public void recordLostEvent(@NotNull DiscardReason discardReason, @NotNull DataCategory dataCategory) {
        recordLostEvent(discardReason, dataCategory, 1L);
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public void recordLostEvent(@NotNull DiscardReason discardReason, @NotNull DataCategory dataCategory, long j) {
        try {
            recordLostEventInternal(discardReason.getReason(), dataCategory.getCategory(), Long.valueOf(j));
            executeOnDiscard(discardReason, dataCategory, Long.valueOf(j));
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, th, "Unable to record lost event.", new Object[0]);
        }
    }

    private void executeOnDiscard(@NotNull DiscardReason discardReason, @NotNull DataCategory dataCategory, @NotNull Long l) {
        if (this.options.getOnDiscard() != null) {
            try {
                this.options.getOnDiscard().execute(discardReason, dataCategory, l);
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, "The onDiscard callback threw an exception.", th);
            }
        }
    }

    private void recordLostEventInternal(@NotNull String str, @NotNull String str2, @NotNull Long l) {
        this.storage.addCount(new ClientReportKey(str, str2), l);
    }

    ClientReport resetCountsAndGenerateClientReport() {
        Date currentDateTime = DateUtils.getCurrentDateTime();
        List<DiscardedEvent> listResetCountsAndGet = this.storage.resetCountsAndGet();
        if (listResetCountsAndGet.isEmpty()) {
            return null;
        }
        return new ClientReport(currentDateTime, listResetCountsAndGet);
    }

    private void restoreCountsFromClientReport(@Nullable ClientReport clientReport) {
        if (clientReport == null) {
            return;
        }
        for (DiscardedEvent discardedEvent : clientReport.getDiscardedEvents()) {
            recordLostEventInternal(discardedEvent.getReason(), discardedEvent.getCategory(), discardedEvent.getQuantity());
        }
    }

    private DataCategory categoryFromItemType(SentryItemType sentryItemType) {
        if (SentryItemType.Event.equals(sentryItemType)) {
            return DataCategory.Error;
        }
        if (SentryItemType.Session.equals(sentryItemType)) {
            return DataCategory.Session;
        }
        if (SentryItemType.Transaction.equals(sentryItemType)) {
            return DataCategory.Transaction;
        }
        if (SentryItemType.UserFeedback.equals(sentryItemType)) {
            return DataCategory.UserReport;
        }
        if (SentryItemType.Feedback.equals(sentryItemType)) {
            return DataCategory.Feedback;
        }
        if (SentryItemType.Profile.equals(sentryItemType)) {
            return DataCategory.Profile;
        }
        if (SentryItemType.ProfileChunk.equals(sentryItemType)) {
            return DataCategory.ProfileChunkUi;
        }
        if (SentryItemType.Attachment.equals(sentryItemType)) {
            return DataCategory.Attachment;
        }
        if (SentryItemType.CheckIn.equals(sentryItemType)) {
            return DataCategory.Monitor;
        }
        if (SentryItemType.ReplayVideo.equals(sentryItemType)) {
            return DataCategory.Replay;
        }
        if (SentryItemType.Log.equals(sentryItemType)) {
            return DataCategory.LogItem;
        }
        return DataCategory.Default;
    }
}
