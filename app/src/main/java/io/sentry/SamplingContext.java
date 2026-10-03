package io.sentry;

import io.sentry.util.Objects;
import io.sentry.util.SentryRandom;
import java.util.Collections;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SamplingContext {
    private final Map<String, Object> attributes;
    private final CustomSamplingContext customSamplingContext;
    private final Double sampleRand;
    private final TransactionContext transactionContext;

    @Deprecated
    public SamplingContext(@NotNull TransactionContext transactionContext, @Nullable CustomSamplingContext customSamplingContext) {
        this(transactionContext, customSamplingContext, Double.valueOf(SentryRandom.current().nextDouble()), null);
    }

    public SamplingContext(@NotNull TransactionContext transactionContext, @Nullable CustomSamplingContext customSamplingContext, @NotNull Double d, @Nullable Map<String, Object> map) {
        this.transactionContext = (TransactionContext) Objects.requireNonNull(transactionContext, "transactionContexts is required");
        this.customSamplingContext = customSamplingContext;
        this.sampleRand = d;
        this.attributes = map == null ? Collections.emptyMap() : map;
    }

    public CustomSamplingContext getCustomSamplingContext() {
        return this.customSamplingContext;
    }

    public TransactionContext getTransactionContext() {
        return this.transactionContext;
    }

    public Double getSampleRand() {
        return this.sampleRand;
    }

    public Object getAttribute(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.attributes.get(str);
    }
}
