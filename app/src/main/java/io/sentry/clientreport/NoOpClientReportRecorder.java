package io.sentry.clientreport;

import io.sentry.DataCategory;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class NoOpClientReportRecorder implements IClientReportRecorder {
    @Override // io.sentry.clientreport.IClientReportRecorder
    public SentryEnvelope attachReportToEnvelope(@NotNull SentryEnvelope sentryEnvelope) {
        return sentryEnvelope;
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public void recordLostEnvelope(@NotNull DiscardReason discardReason, @Nullable SentryEnvelope sentryEnvelope) {
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public void recordLostEnvelopeItem(@NotNull DiscardReason discardReason, @Nullable SentryEnvelopeItem sentryEnvelopeItem) {
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public void recordLostEvent(@NotNull DiscardReason discardReason, @NotNull DataCategory dataCategory) {
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public void recordLostEvent(@NotNull DiscardReason discardReason, @NotNull DataCategory dataCategory, long j) {
    }
}
