package io.sentry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultSpanFactory implements ISpanFactory {
    @Override // io.sentry.ISpanFactory
    public ITransaction createTransaction(@NotNull TransactionContext transactionContext, @NotNull IScopes iScopes, @NotNull TransactionOptions transactionOptions, @Nullable CompositePerformanceCollector compositePerformanceCollector) {
        return new SentryTracer(transactionContext, iScopes, transactionOptions, compositePerformanceCollector);
    }

    @Override // io.sentry.ISpanFactory
    public ISpan createSpan(@NotNull IScopes iScopes, @NotNull SpanOptions spanOptions, @NotNull SpanContext spanContext, @Nullable ISpan iSpan) {
        return NoOpSpan.getInstance();
    }
}
