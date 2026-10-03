package io.sentry;

import io.sentry.protocol.Feedback;
import io.sentry.protocol.Message;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.RateLimiter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface ISentryClient {
    void captureBatchedLogEvents(@NotNull SentryLogEvents sentryLogEvents);

    SentryId captureCheckIn(@NotNull CheckIn checkIn, @Nullable IScope iScope, @Nullable Hint hint);

    SentryId captureEnvelope(@NotNull SentryEnvelope sentryEnvelope, @Nullable Hint hint);

    SentryId captureEvent(@NotNull SentryEvent sentryEvent, @Nullable IScope iScope, @Nullable Hint hint);

    SentryId captureFeedback(@NotNull Feedback feedback, @Nullable Hint hint, @NotNull IScope iScope);

    void captureLog(@NotNull SentryLogEvent sentryLogEvent, @Nullable IScope iScope);

    SentryId captureProfileChunk(@NotNull ProfileChunk profileChunk, @Nullable IScope iScope);

    SentryId captureReplayEvent(@NotNull SentryReplayEvent sentryReplayEvent, @Nullable IScope iScope, @Nullable Hint hint);

    void captureSession(@NotNull Session session, @Nullable Hint hint);

    SentryId captureTransaction(@NotNull SentryTransaction sentryTransaction, @Nullable TraceContext traceContext, @Nullable IScope iScope, @Nullable Hint hint, @Nullable ProfilingTraceData profilingTraceData);

    void captureUserFeedback(@NotNull UserFeedback userFeedback);

    void close();

    void close(boolean z);

    void flush(long j);

    RateLimiter getRateLimiter();

    boolean isEnabled();

    default boolean isHealthy() {
        return true;
    }

    default SentryId captureEvent(@NotNull SentryEvent sentryEvent) {
        return captureEvent(sentryEvent, null, null);
    }

    default SentryId captureEvent(@NotNull SentryEvent sentryEvent, @Nullable IScope iScope) {
        return captureEvent(sentryEvent, iScope, null);
    }

    default SentryId captureEvent(@NotNull SentryEvent sentryEvent, @Nullable Hint hint) {
        return captureEvent(sentryEvent, null, hint);
    }

    default SentryId captureMessage(@NotNull String str, @NotNull SentryLevel sentryLevel, @Nullable IScope iScope) {
        SentryEvent sentryEvent = new SentryEvent();
        Message message = new Message();
        message.setFormatted(str);
        sentryEvent.setMessage(message);
        sentryEvent.setLevel(sentryLevel);
        return captureEvent(sentryEvent, iScope);
    }

    default SentryId captureMessage(@NotNull String str, @NotNull SentryLevel sentryLevel) {
        return captureMessage(str, sentryLevel, null);
    }

    default SentryId captureException(@NotNull Throwable th) {
        return captureException(th, null, null);
    }

    default SentryId captureException(@NotNull Throwable th, @Nullable IScope iScope, @Nullable Hint hint) {
        return captureEvent(new SentryEvent(th), iScope, hint);
    }

    default SentryId captureException(@NotNull Throwable th, @Nullable Hint hint) {
        return captureException(th, null, hint);
    }

    default SentryId captureException(@NotNull Throwable th, @Nullable IScope iScope) {
        return captureException(th, iScope, null);
    }

    default void captureSession(@NotNull Session session) {
        captureSession(session, null);
    }

    default SentryId captureEnvelope(@NotNull SentryEnvelope sentryEnvelope) {
        return captureEnvelope(sentryEnvelope, null);
    }

    default SentryId captureTransaction(@NotNull SentryTransaction sentryTransaction, @Nullable IScope iScope, @Nullable Hint hint) {
        return captureTransaction(sentryTransaction, null, iScope, hint);
    }

    default SentryId captureTransaction(@NotNull SentryTransaction sentryTransaction, @Nullable TraceContext traceContext, @Nullable IScope iScope, @Nullable Hint hint) {
        return captureTransaction(sentryTransaction, traceContext, iScope, hint, null);
    }

    default SentryId captureTransaction(@NotNull SentryTransaction sentryTransaction, @Nullable TraceContext traceContext) {
        return captureTransaction(sentryTransaction, traceContext, null, null);
    }

    default SentryId captureTransaction(@NotNull SentryTransaction sentryTransaction) {
        return captureTransaction(sentryTransaction, null, null, null);
    }
}
