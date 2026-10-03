package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpTransaction implements ITransaction {
    private static final NoOpTransaction instance = new NoOpTransaction();

    @Override // io.sentry.ISpan
    public void finish() {
    }

    @Override // io.sentry.ISpan
    public void finish(@Nullable SpanStatus spanStatus) {
    }

    @Override // io.sentry.ISpan
    public void finish(@Nullable SpanStatus spanStatus, @Nullable SentryDate sentryDate) {
    }

    @Override // io.sentry.ITransaction
    public void finish(@Nullable SpanStatus spanStatus, @Nullable SentryDate sentryDate, boolean z, @Nullable Hint hint) {
    }

    @Override // io.sentry.ITransaction
    public void forceFinish(@NotNull SpanStatus spanStatus, boolean z, @Nullable Hint hint) {
    }

    @Override // io.sentry.ISpan
    public Object getData(@Nullable String str) {
        return null;
    }

    @Override // io.sentry.ISpan
    public String getDescription() {
        return null;
    }

    @Override // io.sentry.ITransaction
    public ISpan getLatestActiveSpan() {
        return null;
    }

    @Override // io.sentry.ISpan
    public TracesSamplingDecision getSamplingDecision() {
        return null;
    }

    @Override // io.sentry.ISpan
    public SpanStatus getStatus() {
        return null;
    }

    @Override // io.sentry.ISpan
    public String getTag(@Nullable String str) {
        return null;
    }

    @Override // io.sentry.ISpan
    public Throwable getThrowable() {
        return null;
    }

    @Override // io.sentry.ISpan
    public boolean isFinished() {
        return true;
    }

    @Override // io.sentry.ISpan
    public boolean isNoOp() {
        return true;
    }

    @Override // io.sentry.ITransaction
    public Boolean isProfileSampled() {
        return null;
    }

    @Override // io.sentry.ISpan
    public Boolean isSampled() {
        return null;
    }

    @Override // io.sentry.ITransaction
    public void scheduleFinish() {
    }

    @Override // io.sentry.ISpan
    public void setContext(@Nullable String str, @Nullable Object obj) {
    }

    @Override // io.sentry.ISpan
    public void setData(@Nullable String str, @Nullable Object obj) {
    }

    @Override // io.sentry.ISpan
    public void setDescription(@Nullable String str) {
    }

    @Override // io.sentry.ISpan
    public void setMeasurement(@NotNull String str, @NotNull Number number) {
    }

    @Override // io.sentry.ISpan
    public void setMeasurement(@NotNull String str, @NotNull Number number, @NotNull MeasurementUnit measurementUnit) {
    }

    @Override // io.sentry.ITransaction
    public void setName(@NotNull String str) {
    }

    @Override // io.sentry.ITransaction
    public void setName(@NotNull String str, @NotNull TransactionNameSource transactionNameSource) {
    }

    @Override // io.sentry.ISpan
    public void setOperation(@NotNull String str) {
    }

    @Override // io.sentry.ISpan
    public void setStatus(@Nullable SpanStatus spanStatus) {
    }

    @Override // io.sentry.ISpan
    public void setTag(@Nullable String str, @Nullable String str2) {
    }

    @Override // io.sentry.ISpan
    public void setThrowable(@Nullable Throwable th) {
    }

    @Override // io.sentry.ISpan
    public BaggageHeader toBaggageHeader(@Nullable List<String> list) {
        return null;
    }

    @Override // io.sentry.ISpan
    public boolean updateEndDate(@NotNull SentryDate sentryDate) {
        return false;
    }

    private NoOpTransaction() {
    }

    public static NoOpTransaction getInstance() {
        return instance;
    }

    @Override // io.sentry.ITransaction
    public String getName() {
        return "";
    }

    @Override // io.sentry.ITransaction
    public TransactionNameSource getTransactionNameSource() {
        return TransactionNameSource.CUSTOM;
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(@NotNull String str) {
        return NoOpSpan.getInstance();
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(@NotNull String str, @Nullable String str2, @NotNull SpanOptions spanOptions) {
        return NoOpSpan.getInstance();
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(@NotNull SpanContext spanContext, @NotNull SpanOptions spanOptions) {
        return NoOpSpan.getInstance();
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(@NotNull String str, @Nullable String str2, @Nullable SentryDate sentryDate, @NotNull Instrumenter instrumenter) {
        return NoOpSpan.getInstance();
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(@NotNull String str, @Nullable String str2, @Nullable SentryDate sentryDate, @NotNull Instrumenter instrumenter, @NotNull SpanOptions spanOptions) {
        return NoOpSpan.getInstance();
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(@NotNull String str, @Nullable String str2) {
        return NoOpSpan.getInstance();
    }

    @Override // io.sentry.ITransaction
    public List<Span> getSpans() {
        return Collections.emptyList();
    }

    @Override // io.sentry.ITransaction
    public ISpan startChild(@NotNull String str, @Nullable String str2, @Nullable SentryDate sentryDate) {
        return NoOpSpan.getInstance();
    }

    @Override // io.sentry.ITransaction
    public SentryId getEventId() {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.ISpan
    public ISentryLifecycleToken makeCurrent() {
        return NoOpScopesLifecycleToken.getInstance();
    }

    @Override // io.sentry.ISpan
    public SentryTraceHeader toSentryTrace() {
        return new SentryTraceHeader(SentryId.EMPTY_ID, SpanId.EMPTY_ID, Boolean.FALSE);
    }

    @Override // io.sentry.ISpan
    public TraceContext traceContext() {
        return new TraceContext(SentryId.EMPTY_ID, "");
    }

    @Override // io.sentry.ISpan
    public String getOperation() {
        return "";
    }

    @Override // io.sentry.ISpan
    public SpanContext getSpanContext() {
        return new SpanContext(SentryId.EMPTY_ID, SpanId.EMPTY_ID, "op", null, null);
    }

    @Override // io.sentry.ISpan
    public Contexts getContexts() {
        return new Contexts();
    }

    @Override // io.sentry.ISpan
    public SentryDate getStartDate() {
        return new SentryNanotimeDate();
    }

    @Override // io.sentry.ISpan
    public SentryDate getFinishDate() {
        return new SentryNanotimeDate();
    }
}
