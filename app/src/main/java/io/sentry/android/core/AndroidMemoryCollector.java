package io.sentry.android.core;

import android.os.Debug;
import io.sentry.IPerformanceSnapshotCollector;
import io.sentry.PerformanceCollectionData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public class AndroidMemoryCollector implements IPerformanceSnapshotCollector {
    @Override // io.sentry.IPerformanceSnapshotCollector
    public void setup() {
    }

    @Override // io.sentry.IPerformanceSnapshotCollector
    public void collect(@NotNull PerformanceCollectionData performanceCollectionData) {
        long j = Runtime.getRuntime().totalMemory();
        long jFreeMemory = Runtime.getRuntime().freeMemory();
        long nativeHeapSize = Debug.getNativeHeapSize();
        long nativeHeapFreeSize = Debug.getNativeHeapFreeSize();
        performanceCollectionData.setUsedHeapMemory(Long.valueOf(j - jFreeMemory));
        performanceCollectionData.setUsedNativeMemory(Long.valueOf(nativeHeapSize - nativeHeapFreeSize));
    }
}
