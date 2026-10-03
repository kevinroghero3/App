package io.sentry;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpCompositePerformanceCollector implements CompositePerformanceCollector {
    private static final NoOpCompositePerformanceCollector instance = new NoOpCompositePerformanceCollector();

    @Override // io.sentry.CompositePerformanceCollector
    public void close() {
    }

    @Override // io.sentry.CompositePerformanceCollector
    public void onSpanFinished(@NotNull ISpan iSpan) {
    }

    @Override // io.sentry.CompositePerformanceCollector
    public void onSpanStarted(@NotNull ISpan iSpan) {
    }

    @Override // io.sentry.CompositePerformanceCollector
    public void start(@NotNull ITransaction iTransaction) {
    }

    @Override // io.sentry.CompositePerformanceCollector
    public void start(@NotNull String str) {
    }

    @Override // io.sentry.CompositePerformanceCollector
    public List<PerformanceCollectionData> stop(@NotNull ITransaction iTransaction) {
        return null;
    }

    @Override // io.sentry.CompositePerformanceCollector
    public List<PerformanceCollectionData> stop(@NotNull String str) {
        return null;
    }

    public static NoOpCompositePerformanceCollector getInstance() {
        return instance;
    }

    private NoOpCompositePerformanceCollector() {
    }
}
