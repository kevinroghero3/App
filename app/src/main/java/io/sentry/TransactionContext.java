package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.util.Objects;
import io.sentry.util.TracingUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class TransactionContext extends SpanContext {
    private static final TransactionNameSource DEFAULT_NAME_SOURCE = TransactionNameSource.CUSTOM;
    private static final String DEFAULT_OPERATION = "default";
    public static final String DEFAULT_TRANSACTION_NAME = "<unlabeled transaction>";
    private boolean isForNextAppStart;
    private String name;
    private TracesSamplingDecision parentSamplingDecision;
    private TransactionNameSource transactionNameSource;

    public static TransactionContext fromPropagationContext(@NotNull PropagationContext propagationContext) {
        Boolean boolIsSampled = propagationContext.isSampled();
        Baggage baggage = propagationContext.getBaggage();
        return new TransactionContext(propagationContext.getTraceId(), propagationContext.getSpanId(), propagationContext.getParentSpanId(), boolIsSampled == null ? null : new TracesSamplingDecision(boolIsSampled, baggage.getSampleRate(), propagationContext.getSampleRand()), baggage);
    }

    public TransactionContext(@NotNull String str, @NotNull String str2) {
        this(str, str2, (TracesSamplingDecision) null);
    }

    public TransactionContext(@NotNull String str, @NotNull TransactionNameSource transactionNameSource, @NotNull String str2) {
        this(str, transactionNameSource, str2, null);
    }

    public TransactionContext(@NotNull String str, @NotNull String str2, @Nullable TracesSamplingDecision tracesSamplingDecision) {
        this(str, TransactionNameSource.CUSTOM, str2, tracesSamplingDecision);
    }

    public TransactionContext(@NotNull String str, @NotNull TransactionNameSource transactionNameSource, @NotNull String str2, @Nullable TracesSamplingDecision tracesSamplingDecision) {
        super(str2);
        this.isForNextAppStart = false;
        this.name = (String) Objects.requireNonNull(str, "name is required");
        this.transactionNameSource = transactionNameSource;
        setSamplingDecision(tracesSamplingDecision);
        this.baggage = TracingUtils.ensureBaggage(null, tracesSamplingDecision);
    }

    public TransactionContext(@NotNull SentryId sentryId, @NotNull SpanId spanId, @Nullable SpanId spanId2, @Nullable TracesSamplingDecision tracesSamplingDecision, @Nullable Baggage baggage) {
        super(sentryId, spanId, "default", spanId2, null);
        this.isForNextAppStart = false;
        this.name = DEFAULT_TRANSACTION_NAME;
        this.parentSamplingDecision = tracesSamplingDecision;
        this.transactionNameSource = DEFAULT_NAME_SOURCE;
        this.baggage = TracingUtils.ensureBaggage(baggage, tracesSamplingDecision);
    }

    public String getName() {
        return this.name;
    }

    public Boolean getParentSampled() {
        TracesSamplingDecision tracesSamplingDecision = this.parentSamplingDecision;
        if (tracesSamplingDecision == null) {
            return null;
        }
        return tracesSamplingDecision.getSampled();
    }

    public TracesSamplingDecision getParentSamplingDecision() {
        return this.parentSamplingDecision;
    }

    public void setParentSampled(@Nullable Boolean bool) {
        if (bool == null) {
            this.parentSamplingDecision = null;
        } else {
            this.parentSamplingDecision = new TracesSamplingDecision(bool);
        }
    }

    public void setParentSampled(@Nullable Boolean bool, @Nullable Boolean bool2) {
        if (bool == null) {
            this.parentSamplingDecision = null;
        } else if (bool2 == null) {
            this.parentSamplingDecision = new TracesSamplingDecision(bool);
        } else {
            this.parentSamplingDecision = new TracesSamplingDecision(bool, null, bool2, null);
        }
    }

    public TransactionNameSource getTransactionNameSource() {
        return this.transactionNameSource;
    }

    public void setName(@NotNull String str) {
        this.name = (String) Objects.requireNonNull(str, "name is required");
    }

    public void setTransactionNameSource(@NotNull TransactionNameSource transactionNameSource) {
        this.transactionNameSource = transactionNameSource;
    }

    public void setForNextAppStart(boolean z) {
        this.isForNextAppStart = z;
    }

    public boolean isForNextAppStart() {
        return this.isForNextAppStart;
    }
}
