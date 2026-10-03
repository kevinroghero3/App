package io.sentry;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class JavaMemoryCollector implements IPerformanceSnapshotCollector {
    private final Runtime runtime = Runtime.getRuntime();

    @Override // io.sentry.IPerformanceSnapshotCollector
    public void setup() {
    }

    @Override // io.sentry.IPerformanceSnapshotCollector
    public void collect(@NotNull PerformanceCollectionData performanceCollectionData) {
        performanceCollectionData.setUsedHeapMemory(Long.valueOf(this.runtime.totalMemory() - this.runtime.freeMemory()));
    }
}
