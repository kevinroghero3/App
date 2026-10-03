package io.sentry;

import io.sentry.protocol.SentryId;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface IContinuousProfiler {
    void close(boolean z);

    SentryId getProfilerId();

    boolean isRunning();

    void reevaluateSampling();

    void startProfiler(@NotNull ProfileLifecycle profileLifecycle, @NotNull TracesSampler tracesSampler);

    void stopProfiler(@NotNull ProfileLifecycle profileLifecycle);
}
