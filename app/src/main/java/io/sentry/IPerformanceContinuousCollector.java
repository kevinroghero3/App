package io.sentry;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface IPerformanceContinuousCollector extends IPerformanceCollector {
    void clear();

    void onSpanFinished(@NotNull ISpan iSpan);

    void onSpanStarted(@NotNull ISpan iSpan);
}
