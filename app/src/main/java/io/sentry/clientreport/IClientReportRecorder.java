package io.sentry.clientreport;

import io.sentry.DataCategory;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface IClientReportRecorder {
    SentryEnvelope attachReportToEnvelope(@NotNull SentryEnvelope sentryEnvelope);

    void recordLostEnvelope(@NotNull DiscardReason discardReason, @Nullable SentryEnvelope sentryEnvelope);

    void recordLostEnvelopeItem(@NotNull DiscardReason discardReason, @Nullable SentryEnvelopeItem sentryEnvelopeItem);

    void recordLostEvent(@NotNull DiscardReason discardReason, @NotNull DataCategory dataCategory);

    void recordLostEvent(@NotNull DiscardReason discardReason, @NotNull DataCategory dataCategory, long j);
}
