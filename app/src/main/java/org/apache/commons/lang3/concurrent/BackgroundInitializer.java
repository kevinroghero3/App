package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BackgroundInitializer<T> implements ConcurrentInitializer<T> {
    private ExecutorService executor;
    private ExecutorService externalExecutor;
    private Future<T> future;

    protected int getTaskCount() {
        return 1;
    }

    protected abstract T initialize() throws Exception;

    protected BackgroundInitializer() {
        this(null);
    }

    protected BackgroundInitializer(ExecutorService executorService) {
        setExternalExecutor(executorService);
    }

    public final ExecutorService getExternalExecutor() {
        ExecutorService executorService;
        synchronized (this) {
            executorService = this.externalExecutor;
        }
        return executorService;
    }

    public boolean isStarted() {
        boolean z;
        synchronized (this) {
            z = this.future != null;
        }
        return z;
    }

    public final void setExternalExecutor(ExecutorService executorService) {
        synchronized (this) {
            if (isStarted()) {
                throw new IllegalStateException("Cannot set ExecutorService after start()!");
            }
            this.externalExecutor = executorService;
        }
    }

    public boolean start() {
        ExecutorService executorServiceCreateExecutor;
        synchronized (this) {
            if (isStarted()) {
                return false;
            }
            ExecutorService externalExecutor = getExternalExecutor();
            this.executor = externalExecutor;
            if (externalExecutor == null) {
                executorServiceCreateExecutor = createExecutor();
                this.executor = executorServiceCreateExecutor;
            } else {
                executorServiceCreateExecutor = null;
            }
            this.future = this.executor.submit(createTask(executorServiceCreateExecutor));
            return true;
        }
    }

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        try {
            return getFuture().get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ConcurrentException(e);
        } catch (ExecutionException e2) {
            ConcurrentUtils.handleCause(e2);
            return null;
        }
    }

    public Future<T> getFuture() {
        Future<T> future;
        synchronized (this) {
            future = this.future;
            if (future == null) {
                throw new IllegalStateException("start() must be called first!");
            }
        }
        return future;
    }

    protected final ExecutorService getActiveExecutor() {
        ExecutorService executorService;
        synchronized (this) {
            executorService = this.executor;
        }
        return executorService;
    }

    private Callable<T> createTask(ExecutorService executorService) {
        return new InitializationTask(executorService);
    }

    private ExecutorService createExecutor() {
        return Executors.newFixedThreadPool(getTaskCount());
    }

    class InitializationTask implements Callable<T> {
        private final ExecutorService execFinally;

        InitializationTask(ExecutorService executorService) {
            this.execFinally = executorService;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            try {
                return (T) BackgroundInitializer.this.initialize();
            } finally {
                ExecutorService executorService = this.execFinally;
                if (executorService != null) {
                    executorService.shutdown();
                }
            }
        }
    }
}
