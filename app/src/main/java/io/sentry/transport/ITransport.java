package io.sentry.transport;

import io.sentry.Hint;
import io.sentry.SentryEnvelope;
import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface ITransport extends Closeable {
    void close(boolean z) throws IOException;

    void flush(long j);

    RateLimiter getRateLimiter();

    default boolean isHealthy() {
        return true;
    }

    void send(@NotNull SentryEnvelope sentryEnvelope, @NotNull Hint hint) throws IOException;

    default void send(@NotNull SentryEnvelope sentryEnvelope) throws IOException {
        send(sentryEnvelope, new Hint());
    }
}
