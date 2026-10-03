package io.sentry.android.replay.util;

import io.sentry.ISentryExecutorService;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ExecutorsKt {
    public static final void gracefullyShutdown(@NotNull ExecutorService executorService, @NotNull SentryOptions options) {
        Intrinsics.checkNotNullParameter(executorService, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        synchronized (executorService) {
            if (!executorService.isShutdown()) {
                executorService.shutdown();
            }
            try {
                if (!executorService.awaitTermination(options.getShutdownTimeoutMillis(), TimeUnit.MILLISECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException unused) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final Future<?> submitSafely(@NotNull ISentryExecutorService iSentryExecutorService, @NotNull final SentryOptions options, @NotNull final String taskName, @NotNull final Runnable task) {
        Intrinsics.checkNotNullParameter(iSentryExecutorService, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(task, "task");
        try {
            return iSentryExecutorService.submit(new Runnable() { // from class: io.sentry.android.replay.util.ExecutorsKt$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ExecutorsKt.submitSafely$lambda$1(task, options, taskName);
                }
            });
        } catch (Throwable th) {
            options.getLogger().log(SentryLevel.ERROR, "Failed to submit task " + taskName + " to executor", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitSafely$lambda$1(Runnable task, SentryOptions options, String taskName) {
        Intrinsics.checkNotNullParameter(task, "$task");
        Intrinsics.checkNotNullParameter(options, "$options");
        Intrinsics.checkNotNullParameter(taskName, "$taskName");
        try {
            task.run();
        } catch (Throwable th) {
            options.getLogger().log(SentryLevel.ERROR, "Failed to execute task " + taskName, th);
        }
    }

    public static final Future<?> submitSafely(@NotNull ExecutorService executorService, @NotNull final SentryOptions options, @NotNull final String taskName, @NotNull final Runnable task) {
        Intrinsics.checkNotNullParameter(executorService, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(task, "task");
        String name = Thread.currentThread().getName();
        Intrinsics.checkNotNullExpressionValue(name, "currentThread().name");
        if (StringsKt__StringsJVMKt.startsWith$default(name, "SentryReplayIntegration", false, 2, null)) {
            task.run();
            return null;
        }
        try {
            return executorService.submit(new Runnable() { // from class: io.sentry.android.replay.util.ExecutorsKt$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ExecutorsKt.submitSafely$lambda$2(task, options, taskName);
                }
            });
        } catch (Throwable th) {
            options.getLogger().log(SentryLevel.ERROR, "Failed to submit task " + taskName + " to executor", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitSafely$lambda$2(Runnable task, SentryOptions options, String taskName) {
        Intrinsics.checkNotNullParameter(task, "$task");
        Intrinsics.checkNotNullParameter(options, "$options");
        Intrinsics.checkNotNullParameter(taskName, "$taskName");
        try {
            task.run();
        } catch (Throwable th) {
            options.getLogger().log(SentryLevel.ERROR, "Failed to execute task " + taskName, th);
        }
    }

    public static final ScheduledFuture<?> scheduleAtFixedRateSafely(@NotNull ScheduledExecutorService scheduledExecutorService, @NotNull final SentryOptions options, @NotNull final String taskName, long j, long j2, @NotNull TimeUnit unit, @NotNull final Runnable task) {
        Intrinsics.checkNotNullParameter(scheduledExecutorService, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(task, "task");
        try {
            return scheduledExecutorService.scheduleAtFixedRate(new Runnable() { // from class: io.sentry.android.replay.util.ExecutorsKt$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ExecutorsKt.scheduleAtFixedRateSafely$lambda$3(task, options, taskName);
                }
            }, j, j2, unit);
        } catch (Throwable th) {
            options.getLogger().log(SentryLevel.ERROR, "Failed to submit task " + taskName + " to executor", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleAtFixedRateSafely$lambda$3(Runnable task, SentryOptions options, String taskName) {
        Intrinsics.checkNotNullParameter(task, "$task");
        Intrinsics.checkNotNullParameter(options, "$options");
        Intrinsics.checkNotNullParameter(taskName, "$taskName");
        try {
            task.run();
        } catch (Throwable th) {
            options.getLogger().log(SentryLevel.ERROR, "Failed to execute task " + taskName, th);
        }
    }
}
