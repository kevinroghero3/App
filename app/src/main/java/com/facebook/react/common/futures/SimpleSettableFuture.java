package com.facebook.react.common.futures;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class SimpleSettableFuture<T> implements Future<T> {
    private Exception exception;
    private final CountDownLatch readyLatch = new CountDownLatch(1);
    private T result;

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    public final void set(@Nullable T t) {
        checkNotSet();
        this.result = t;
        this.readyLatch.countDown();
    }

    public final void setException(@NotNull Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        checkNotSet();
        this.exception = exception;
        this.readyLatch.countDown();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.readyLatch.getCount() == 0;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        this.readyLatch.await();
        if (this.exception != null) {
            throw new ExecutionException(this.exception);
        }
        return this.result;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, @NotNull TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (!this.readyLatch.await(j, unit)) {
            throw new TimeoutException("Timed out waiting for result");
        }
        if (this.exception != null) {
            throw new ExecutionException(this.exception);
        }
        return this.result;
    }

    public final T getOrThrow() {
        try {
            return get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final T getOrThrow(long j, @NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        try {
            return get(j, unit);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        } catch (TimeoutException e3) {
            throw new RuntimeException(e3);
        }
    }

    private final void checkNotSet() {
        if (this.readyLatch.getCount() == 0) {
            throw new RuntimeException("Result has already been set!");
        }
    }
}
