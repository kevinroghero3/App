package io.sentry;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface ISentryExecutorService {
    void close(long j);

    boolean isClosed();

    void prewarm();

    Future<?> schedule(@NotNull Runnable runnable, long j) throws RejectedExecutionException;

    Future<?> submit(@NotNull Runnable runnable) throws RejectedExecutionException;

    <T> Future<T> submit(@NotNull Callable<T> callable) throws RejectedExecutionException;
}
