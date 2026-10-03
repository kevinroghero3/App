package io.sentry;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface IPerformanceSnapshotCollector extends IPerformanceCollector {
    void collect(@NotNull PerformanceCollectionData performanceCollectionData);

    void setup();
}
