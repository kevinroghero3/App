package io.sentry;

import io.sentry.protocol.SentryId;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpContinuousProfiler implements IContinuousProfiler {
    private static final NoOpContinuousProfiler instance = new NoOpContinuousProfiler();

    @Override // io.sentry.IContinuousProfiler
    public void close(boolean z) {
    }

    @Override // io.sentry.IContinuousProfiler
    public boolean isRunning() {
        return false;
    }

    @Override // io.sentry.IContinuousProfiler
    public void reevaluateSampling() {
    }

    @Override // io.sentry.IContinuousProfiler
    public void startProfiler(@NotNull ProfileLifecycle profileLifecycle, @NotNull TracesSampler tracesSampler) {
    }

    @Override // io.sentry.IContinuousProfiler
    public void stopProfiler(@NotNull ProfileLifecycle profileLifecycle) {
    }

    private NoOpContinuousProfiler() {
    }

    public static NoOpContinuousProfiler getInstance() {
        return instance;
    }

    @Override // io.sentry.IContinuousProfiler
    public SentryId getProfilerId() {
        return SentryId.EMPTY_ID;
    }
}
