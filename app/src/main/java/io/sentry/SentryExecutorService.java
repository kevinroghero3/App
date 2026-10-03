package io.sentry;

import io.sentry.util.AutoClosableReentrantLock;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SentryExecutorService implements ISentryExecutorService {
    private static final int INITIAL_QUEUE_SIZE = 40;
    private static final int MAX_QUEUE_SIZE = 271;
    private final Runnable dummyRunnable;
    private final ScheduledThreadPoolExecutor executorService;
    private final AutoClosableReentrantLock lock;
    private final SentryOptions options;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0() {
    }

    SentryExecutorService(@NotNull ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, @Nullable SentryOptions sentryOptions) {
        this.lock = new AutoClosableReentrantLock();
        this.dummyRunnable = new Runnable() { // from class: io.sentry.SentryExecutorService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SentryExecutorService.lambda$new$0();
            }
        };
        this.executorService = scheduledThreadPoolExecutor;
        this.options = sentryOptions;
    }

    public SentryExecutorService(@Nullable SentryOptions sentryOptions) {
        this(new ScheduledThreadPoolExecutor(1, new SentryExecutorServiceThreadFactory()), sentryOptions);
    }

    public SentryExecutorService() {
        this(new ScheduledThreadPoolExecutor(1, new SentryExecutorServiceThreadFactory()), null);
    }

    @Override // io.sentry.ISentryExecutorService
    public Future<?> submit(@NotNull Runnable runnable) {
        if (this.executorService.getQueue().size() < MAX_QUEUE_SIZE) {
            return this.executorService.submit(runnable);
        }
        SentryOptions sentryOptions = this.options;
        if (sentryOptions != null) {
            sentryOptions.getLogger().log(SentryLevel.WARNING, "Task " + runnable + " rejected from " + this.executorService, new Object[0]);
        }
        return new CancelledFuture();
    }

    @Override // io.sentry.ISentryExecutorService
    public <T> Future<T> submit(@NotNull Callable<T> callable) {
        if (this.executorService.getQueue().size() < MAX_QUEUE_SIZE) {
            return this.executorService.submit(callable);
        }
        SentryOptions sentryOptions = this.options;
        if (sentryOptions != null) {
            sentryOptions.getLogger().log(SentryLevel.WARNING, "Task " + callable + " rejected from " + this.executorService, new Object[0]);
        }
        return new CancelledFuture();
    }

    @Override // io.sentry.ISentryExecutorService
    public Future<?> schedule(@NotNull Runnable runnable, long j) {
        if (this.executorService.getQueue().size() < MAX_QUEUE_SIZE) {
            return this.executorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
        SentryOptions sentryOptions = this.options;
        if (sentryOptions != null) {
            sentryOptions.getLogger().log(SentryLevel.WARNING, "Task " + runnable + " rejected from " + this.executorService, new Object[0]);
        }
        return new CancelledFuture();
    }

    @Override // io.sentry.ISentryExecutorService
    public void close(long j) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            if (!this.executorService.isShutdown()) {
                this.executorService.shutdown();
                try {
                    if (!this.executorService.awaitTermination(j, TimeUnit.MILLISECONDS)) {
                        this.executorService.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    this.executorService.shutdownNow();
                    Thread.currentThread().interrupt();
                }
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.ISentryExecutorService
    public boolean isClosed() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            boolean zIsShutdown = this.executorService.isShutdown();
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return zIsShutdown;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.ISentryExecutorService
    public void prewarm() {
        this.executorService.submit(new Runnable() { // from class: io.sentry.SentryExecutorService$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$prewarm$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prewarm$1() {
        for (int i = 0; i < 40; i++) {
            try {
                this.executorService.schedule(this.dummyRunnable, 365L, TimeUnit.DAYS).cancel(true);
            } catch (RejectedExecutionException unused) {
                return;
            }
        }
        this.executorService.purge();
    }

    static final class SentryExecutorServiceThreadFactory implements ThreadFactory {
        private int cnt;

        private SentryExecutorServiceThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NotNull Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("SentryExecutorServiceThreadFactory-");
            int i = this.cnt;
            this.cnt = i + 1;
            sb.append(i);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    static final class CancelledFuture<T> implements Future<T> {
        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return true;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        private CancelledFuture() {
        }

        @Override // java.util.concurrent.Future
        public T get() {
            throw new CancellationException();
        }

        @Override // java.util.concurrent.Future
        public T get(long j, @NotNull TimeUnit timeUnit) {
            throw new CancellationException();
        }
    }
}
