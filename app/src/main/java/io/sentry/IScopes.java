package io.sentry;

import io.sentry.logger.ILoggerApi;
import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import io.sentry.transport.RateLimiter;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface IScopes {
    void addBreadcrumb(@NotNull Breadcrumb breadcrumb);

    void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable Hint hint);

    void bindClient(@NotNull ISentryClient iSentryClient);

    SentryId captureCheckIn(@NotNull CheckIn checkIn);

    SentryId captureEnvelope(@NotNull SentryEnvelope sentryEnvelope, @Nullable Hint hint);

    SentryId captureEvent(@NotNull SentryEvent sentryEvent, @Nullable Hint hint);

    SentryId captureEvent(@NotNull SentryEvent sentryEvent, @Nullable Hint hint, @NotNull ScopeCallback scopeCallback);

    SentryId captureException(@NotNull Throwable th, @Nullable Hint hint);

    SentryId captureException(@NotNull Throwable th, @Nullable Hint hint, @NotNull ScopeCallback scopeCallback);

    SentryId captureFeedback(@NotNull Feedback feedback, @Nullable Hint hint, @Nullable ScopeCallback scopeCallback);

    SentryId captureMessage(@NotNull String str, @NotNull SentryLevel sentryLevel);

    SentryId captureMessage(@NotNull String str, @NotNull SentryLevel sentryLevel, @NotNull ScopeCallback scopeCallback);

    SentryId captureProfileChunk(@NotNull ProfileChunk profileChunk);

    SentryId captureReplay(@NotNull SentryReplayEvent sentryReplayEvent, @Nullable Hint hint);

    SentryId captureTransaction(@NotNull SentryTransaction sentryTransaction, @Nullable TraceContext traceContext, @Nullable Hint hint, @Nullable ProfilingTraceData profilingTraceData);

    void captureUserFeedback(@NotNull UserFeedback userFeedback);

    void clearBreadcrumbs();

    @Deprecated
    /* JADX INFO: renamed from: clone */
    IHub m5381clone();

    void close();

    void close(boolean z);

    void configureScope(@Nullable ScopeType scopeType, @NotNull ScopeCallback scopeCallback);

    TransactionContext continueTrace(@Nullable String str, @Nullable List<String> list);

    void endSession();

    void flush(long j);

    IScopes forkedCurrentScope(@NotNull String str);

    IScopes forkedRootScopes(@NotNull String str);

    IScopes forkedScopes(@NotNull String str);

    BaggageHeader getBaggage();

    IScope getGlobalScope();

    IScope getIsolationScope();

    SentryId getLastEventId();

    SentryOptions getOptions();

    IScopes getParentScopes();

    RateLimiter getRateLimiter();

    IScope getScope();

    ISpan getSpan();

    SentryTraceHeader getTraceparent();

    ITransaction getTransaction();

    boolean isAncestorOf(@Nullable IScopes iScopes);

    Boolean isCrashedLastRun();

    boolean isEnabled();

    boolean isHealthy();

    default boolean isNoOp() {
        return false;
    }

    ILoggerApi logger();

    ISentryLifecycleToken makeCurrent();

    @Deprecated
    void popScope();

    ISentryLifecycleToken pushIsolationScope();

    ISentryLifecycleToken pushScope();

    void removeExtra(@Nullable String str);

    void removeTag(@Nullable String str);

    void reportFullyDisplayed();

    void setActiveSpan(@Nullable ISpan iSpan);

    void setExtra(@Nullable String str, @Nullable String str2);

    void setFingerprint(@NotNull List<String> list);

    void setLevel(@Nullable SentryLevel sentryLevel);

    void setSpanContext(@NotNull Throwable th, @NotNull ISpan iSpan, @NotNull String str);

    void setTag(@Nullable String str, @Nullable String str2);

    void setTransaction(@Nullable String str);

    void setUser(@Nullable User user);

    void startProfiler();

    void startSession();

    ITransaction startTransaction(@NotNull TransactionContext transactionContext, @NotNull TransactionOptions transactionOptions);

    void stopProfiler();

    void withIsolationScope(@NotNull ScopeCallback scopeCallback);

    void withScope(@NotNull ScopeCallback scopeCallback);

    default SentryId captureEvent(@NotNull SentryEvent sentryEvent) {
        return captureEvent(sentryEvent, new Hint());
    }

    default SentryId captureEvent(@NotNull SentryEvent sentryEvent, @NotNull ScopeCallback scopeCallback) {
        return captureEvent(sentryEvent, new Hint(), scopeCallback);
    }

    default SentryId captureMessage(@NotNull String str) {
        return captureMessage(str, SentryLevel.INFO);
    }

    default SentryId captureMessage(@NotNull String str, @NotNull ScopeCallback scopeCallback) {
        return captureMessage(str, SentryLevel.INFO, scopeCallback);
    }

    default SentryId captureFeedback(@NotNull Feedback feedback) {
        return captureFeedback(feedback, null);
    }

    default SentryId captureFeedback(@NotNull Feedback feedback, @Nullable Hint hint) {
        return captureFeedback(feedback, hint, null);
    }

    default SentryId captureEnvelope(@NotNull SentryEnvelope sentryEnvelope) {
        return captureEnvelope(sentryEnvelope, new Hint());
    }

    default SentryId captureException(@NotNull Throwable th) {
        return captureException(th, new Hint());
    }

    default SentryId captureException(@NotNull Throwable th, @NotNull ScopeCallback scopeCallback) {
        return captureException(th, new Hint(), scopeCallback);
    }

    default void addBreadcrumb(@NotNull String str) {
        addBreadcrumb(new Breadcrumb(str));
    }

    default void addBreadcrumb(@NotNull String str, @NotNull String str2) {
        Breadcrumb breadcrumb = new Breadcrumb(str);
        breadcrumb.setCategory(str2);
        addBreadcrumb(breadcrumb);
    }

    default void configureScope(@NotNull ScopeCallback scopeCallback) {
        configureScope(null, scopeCallback);
    }

    default SentryId captureTransaction(@NotNull SentryTransaction sentryTransaction, @Nullable TraceContext traceContext, @Nullable Hint hint) {
        return captureTransaction(sentryTransaction, traceContext, hint, null);
    }

    default SentryId captureTransaction(@NotNull SentryTransaction sentryTransaction, @Nullable Hint hint) {
        return captureTransaction(sentryTransaction, null, hint);
    }

    default SentryId captureTransaction(@NotNull SentryTransaction sentryTransaction, @Nullable TraceContext traceContext) {
        return captureTransaction(sentryTransaction, traceContext, null);
    }

    default ITransaction startTransaction(@NotNull TransactionContext transactionContext) {
        return startTransaction(transactionContext, new TransactionOptions());
    }

    default ITransaction startTransaction(@NotNull String str, @NotNull String str2) {
        return startTransaction(str, str2, new TransactionOptions());
    }

    default ITransaction startTransaction(@NotNull String str, @NotNull String str2, @NotNull TransactionOptions transactionOptions) {
        return startTransaction(new TransactionContext(str, str2), transactionOptions);
    }
}
