package io.sentry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface ISpanFactory {
    ISpan createSpan(@NotNull IScopes iScopes, @NotNull SpanOptions spanOptions, @NotNull SpanContext spanContext, @Nullable ISpan iSpan);

    ITransaction createTransaction(@NotNull TransactionContext transactionContext, @NotNull IScopes iScopes, @NotNull TransactionOptions transactionOptions, @Nullable CompositePerformanceCollector compositePerformanceCollector);
}
