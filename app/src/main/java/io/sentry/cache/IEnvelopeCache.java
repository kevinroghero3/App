package io.sentry.cache;

import io.sentry.Hint;
import io.sentry.SentryEnvelope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface IEnvelopeCache extends Iterable<SentryEnvelope> {
    void discard(@NotNull SentryEnvelope sentryEnvelope);

    @Deprecated
    void store(@NotNull SentryEnvelope sentryEnvelope, @NotNull Hint hint);

    default boolean storeEnvelope(@NotNull SentryEnvelope sentryEnvelope, @NotNull Hint hint) {
        store(sentryEnvelope, hint);
        return true;
    }

    @Deprecated
    default void store(@NotNull SentryEnvelope sentryEnvelope) {
        storeEnvelope(sentryEnvelope, new Hint());
    }
}
