package io.sentry;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface CompositePerformanceCollector {
    void close();

    void onSpanFinished(@NotNull ISpan iSpan);

    void onSpanStarted(@NotNull ISpan iSpan);

    void start(@NotNull ITransaction iTransaction);

    void start(@NotNull String str);

    List<PerformanceCollectionData> stop(@NotNull ITransaction iTransaction);

    List<PerformanceCollectionData> stop(@NotNull String str);
}
