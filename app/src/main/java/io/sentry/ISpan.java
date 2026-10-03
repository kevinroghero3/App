package io.sentry;

import io.sentry.protocol.Contexts;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface ISpan {
    void finish();

    void finish(@Nullable SpanStatus spanStatus);

    void finish(@Nullable SpanStatus spanStatus, @Nullable SentryDate sentryDate);

    Contexts getContexts();

    Object getData(@Nullable String str);

    String getDescription();

    SentryDate getFinishDate();

    String getOperation();

    TracesSamplingDecision getSamplingDecision();

    SpanContext getSpanContext();

    SentryDate getStartDate();

    SpanStatus getStatus();

    String getTag(@Nullable String str);

    Throwable getThrowable();

    boolean isFinished();

    boolean isNoOp();

    Boolean isSampled();

    ISentryLifecycleToken makeCurrent();

    void setContext(@Nullable String str, @Nullable Object obj);

    void setData(@Nullable String str, @Nullable Object obj);

    void setDescription(@Nullable String str);

    void setMeasurement(@NotNull String str, @NotNull Number number);

    void setMeasurement(@NotNull String str, @NotNull Number number, @NotNull MeasurementUnit measurementUnit);

    void setOperation(@NotNull String str);

    void setStatus(@Nullable SpanStatus spanStatus);

    void setTag(@Nullable String str, @Nullable String str2);

    void setThrowable(@Nullable Throwable th);

    ISpan startChild(@NotNull SpanContext spanContext, @NotNull SpanOptions spanOptions);

    ISpan startChild(@NotNull String str);

    ISpan startChild(@NotNull String str, @Nullable String str2);

    ISpan startChild(@NotNull String str, @Nullable String str2, @Nullable SentryDate sentryDate, @NotNull Instrumenter instrumenter);

    ISpan startChild(@NotNull String str, @Nullable String str2, @Nullable SentryDate sentryDate, @NotNull Instrumenter instrumenter, @NotNull SpanOptions spanOptions);

    ISpan startChild(@NotNull String str, @Nullable String str2, @NotNull SpanOptions spanOptions);

    BaggageHeader toBaggageHeader(@Nullable List<String> list);

    SentryTraceHeader toSentryTrace();

    TraceContext traceContext();

    boolean updateEndDate(@NotNull SentryDate sentryDate);
}
