package io.sentry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpSpanFactory implements ISpanFactory {
    private static final NoOpSpanFactory instance = new NoOpSpanFactory();

    private NoOpSpanFactory() {
    }

    public static NoOpSpanFactory getInstance() {
        return instance;
    }

    @Override // io.sentry.ISpanFactory
    public ITransaction createTransaction(@NotNull TransactionContext transactionContext, @NotNull IScopes iScopes, @NotNull TransactionOptions transactionOptions, @Nullable CompositePerformanceCollector compositePerformanceCollector) {
        return NoOpTransaction.getInstance();
    }

    @Override // io.sentry.ISpanFactory
    public ISpan createSpan(@NotNull IScopes iScopes, @NotNull SpanOptions spanOptions, @NotNull SpanContext spanContext, @Nullable ISpan iSpan) {
        return NoOpSpan.getInstance();
    }
}
