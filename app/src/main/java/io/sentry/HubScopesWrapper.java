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

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final class HubScopesWrapper implements IHub {
    private final IScopes scopes;

    public HubScopesWrapper(@NotNull IScopes iScopes) {
        this.scopes = iScopes;
    }

    public IScopes getScopes() {
        return this.scopes;
    }

    @Override // io.sentry.IScopes
    public boolean isEnabled() {
        return this.scopes.isEnabled();
    }

    @Override // io.sentry.IScopes
    public SentryId captureEvent(@NotNull SentryEvent sentryEvent, @Nullable Hint hint) {
        return this.scopes.captureEvent(sentryEvent, hint);
    }

    @Override // io.sentry.IScopes
    public SentryId captureEvent(@NotNull SentryEvent sentryEvent, @Nullable Hint hint, @NotNull ScopeCallback scopeCallback) {
        return this.scopes.captureEvent(sentryEvent, hint, scopeCallback);
    }

    @Override // io.sentry.IScopes
    public SentryId captureMessage(@NotNull String str, @NotNull SentryLevel sentryLevel) {
        return this.scopes.captureMessage(str, sentryLevel);
    }

    @Override // io.sentry.IScopes
    public SentryId captureMessage(@NotNull String str, @NotNull SentryLevel sentryLevel, @NotNull ScopeCallback scopeCallback) {
        return this.scopes.captureMessage(str, sentryLevel, scopeCallback);
    }

    @Override // io.sentry.IScopes
    public SentryId captureFeedback(@NotNull Feedback feedback, @Nullable Hint hint, @Nullable ScopeCallback scopeCallback) {
        return this.scopes.captureFeedback(feedback, hint, scopeCallback);
    }

    @Override // io.sentry.IScopes
    public SentryId captureEnvelope(@NotNull SentryEnvelope sentryEnvelope, @Nullable Hint hint) {
        return this.scopes.captureEnvelope(sentryEnvelope, hint);
    }

    @Override // io.sentry.IScopes
    public SentryId captureException(@NotNull Throwable th, @Nullable Hint hint) {
        return this.scopes.captureException(th, hint);
    }

    @Override // io.sentry.IScopes
    public SentryId captureException(@NotNull Throwable th, @Nullable Hint hint, @NotNull ScopeCallback scopeCallback) {
        return this.scopes.captureException(th, hint, scopeCallback);
    }

    @Override // io.sentry.IScopes
    public void captureUserFeedback(@NotNull UserFeedback userFeedback) {
        this.scopes.captureUserFeedback(userFeedback);
    }

    @Override // io.sentry.IScopes
    public void startSession() {
        this.scopes.startSession();
    }

    @Override // io.sentry.IScopes
    public void endSession() {
        this.scopes.endSession();
    }

    @Override // io.sentry.IScopes
    public void close() {
        this.scopes.close();
    }

    @Override // io.sentry.IScopes
    public void close(boolean z) {
        this.scopes.close(z);
    }

    @Override // io.sentry.IScopes
    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable Hint hint) {
        this.scopes.addBreadcrumb(breadcrumb, hint);
    }

    @Override // io.sentry.IScopes
    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb) {
        this.scopes.addBreadcrumb(breadcrumb);
    }

    @Override // io.sentry.IScopes
    public void setLevel(@Nullable SentryLevel sentryLevel) {
        this.scopes.setLevel(sentryLevel);
    }

    @Override // io.sentry.IScopes
    public void setTransaction(@Nullable String str) {
        this.scopes.setTransaction(str);
    }

    @Override // io.sentry.IScopes
    public void setUser(@Nullable User user) {
        this.scopes.setUser(user);
    }

    @Override // io.sentry.IScopes
    public void setFingerprint(@NotNull List<String> list) {
        this.scopes.setFingerprint(list);
    }

    @Override // io.sentry.IScopes
    public void clearBreadcrumbs() {
        this.scopes.clearBreadcrumbs();
    }

    @Override // io.sentry.IScopes
    public void setTag(@Nullable String str, @Nullable String str2) {
        this.scopes.setTag(str, str2);
    }

    @Override // io.sentry.IScopes
    public void removeTag(@Nullable String str) {
        this.scopes.removeTag(str);
    }

    @Override // io.sentry.IScopes
    public void setExtra(@Nullable String str, @Nullable String str2) {
        this.scopes.setExtra(str, str2);
    }

    @Override // io.sentry.IScopes
    public void removeExtra(@Nullable String str) {
        this.scopes.removeExtra(str);
    }

    @Override // io.sentry.IScopes
    public SentryId getLastEventId() {
        return this.scopes.getLastEventId();
    }

    @Override // io.sentry.IScopes
    public ISentryLifecycleToken pushScope() {
        return this.scopes.pushScope();
    }

    @Override // io.sentry.IScopes
    public ISentryLifecycleToken pushIsolationScope() {
        return this.scopes.pushIsolationScope();
    }

    @Override // io.sentry.IScopes
    @Deprecated
    public void popScope() {
        this.scopes.popScope();
    }

    @Override // io.sentry.IScopes
    public void withScope(@NotNull ScopeCallback scopeCallback) {
        this.scopes.withScope(scopeCallback);
    }

    @Override // io.sentry.IScopes
    public void withIsolationScope(@NotNull ScopeCallback scopeCallback) {
        this.scopes.withIsolationScope(scopeCallback);
    }

    @Override // io.sentry.IScopes
    public void configureScope(@Nullable ScopeType scopeType, @NotNull ScopeCallback scopeCallback) {
        this.scopes.configureScope(scopeType, scopeCallback);
    }

    @Override // io.sentry.IScopes
    public void bindClient(@NotNull ISentryClient iSentryClient) {
        this.scopes.bindClient(iSentryClient);
    }

    @Override // io.sentry.IScopes
    public boolean isHealthy() {
        return this.scopes.isHealthy();
    }

    @Override // io.sentry.IScopes
    public void flush(long j) {
        this.scopes.flush(j);
    }

    @Override // io.sentry.IScopes
    @Deprecated
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public IHub m5368clone() {
        return this.scopes.m5380clone();
    }

    @Override // io.sentry.IScopes
    public IScopes forkedScopes(@NotNull String str) {
        return this.scopes.forkedScopes(str);
    }

    @Override // io.sentry.IScopes
    public IScopes forkedCurrentScope(@NotNull String str) {
        return this.scopes.forkedCurrentScope(str);
    }

    @Override // io.sentry.IScopes
    public IScopes forkedRootScopes(@NotNull String str) {
        return Sentry.forkedRootScopes(str);
    }

    @Override // io.sentry.IScopes
    public ISentryLifecycleToken makeCurrent() {
        return this.scopes.makeCurrent();
    }

    @Override // io.sentry.IScopes
    public IScope getScope() {
        return this.scopes.getScope();
    }

    @Override // io.sentry.IScopes
    public IScope getIsolationScope() {
        return this.scopes.getIsolationScope();
    }

    @Override // io.sentry.IScopes
    public IScope getGlobalScope() {
        return Sentry.getGlobalScope();
    }

    @Override // io.sentry.IScopes
    public IScopes getParentScopes() {
        return this.scopes.getParentScopes();
    }

    @Override // io.sentry.IScopes
    public boolean isAncestorOf(@Nullable IScopes iScopes) {
        return this.scopes.isAncestorOf(iScopes);
    }

    @Override // io.sentry.IScopes
    public SentryId captureTransaction(@NotNull SentryTransaction sentryTransaction, @Nullable TraceContext traceContext, @Nullable Hint hint, @Nullable ProfilingTraceData profilingTraceData) {
        return this.scopes.captureTransaction(sentryTransaction, traceContext, hint, profilingTraceData);
    }

    @Override // io.sentry.IScopes
    public SentryId captureProfileChunk(@NotNull ProfileChunk profileChunk) {
        return this.scopes.captureProfileChunk(profileChunk);
    }

    @Override // io.sentry.IScopes
    public ITransaction startTransaction(@NotNull TransactionContext transactionContext, @NotNull TransactionOptions transactionOptions) {
        return this.scopes.startTransaction(transactionContext, transactionOptions);
    }

    @Override // io.sentry.IScopes
    public void startProfiler() {
        this.scopes.startProfiler();
    }

    @Override // io.sentry.IScopes
    public void stopProfiler() {
        this.scopes.stopProfiler();
    }

    @Override // io.sentry.IScopes
    public void setSpanContext(@NotNull Throwable th, @NotNull ISpan iSpan, @NotNull String str) {
        this.scopes.setSpanContext(th, iSpan, str);
    }

    @Override // io.sentry.IScopes
    public ISpan getSpan() {
        return this.scopes.getSpan();
    }

    @Override // io.sentry.IScopes
    public void setActiveSpan(@Nullable ISpan iSpan) {
        this.scopes.setActiveSpan(iSpan);
    }

    @Override // io.sentry.IScopes
    public ITransaction getTransaction() {
        return this.scopes.getTransaction();
    }

    @Override // io.sentry.IScopes
    public SentryOptions getOptions() {
        return this.scopes.getOptions();
    }

    @Override // io.sentry.IScopes
    public Boolean isCrashedLastRun() {
        return this.scopes.isCrashedLastRun();
    }

    @Override // io.sentry.IScopes
    public void reportFullyDisplayed() {
        this.scopes.reportFullyDisplayed();
    }

    @Override // io.sentry.IScopes
    public TransactionContext continueTrace(@Nullable String str, @Nullable List<String> list) {
        return this.scopes.continueTrace(str, list);
    }

    @Override // io.sentry.IScopes
    public SentryTraceHeader getTraceparent() {
        return this.scopes.getTraceparent();
    }

    @Override // io.sentry.IScopes
    public BaggageHeader getBaggage() {
        return this.scopes.getBaggage();
    }

    @Override // io.sentry.IScopes
    public SentryId captureCheckIn(@NotNull CheckIn checkIn) {
        return this.scopes.captureCheckIn(checkIn);
    }

    @Override // io.sentry.IScopes
    public RateLimiter getRateLimiter() {
        return this.scopes.getRateLimiter();
    }

    @Override // io.sentry.IScopes
    public SentryId captureReplay(@NotNull SentryReplayEvent sentryReplayEvent, @Nullable Hint hint) {
        return this.scopes.captureReplay(sentryReplayEvent, hint);
    }

    @Override // io.sentry.IScopes
    public ILoggerApi logger() {
        return this.scopes.logger();
    }
}
