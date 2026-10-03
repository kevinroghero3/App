package it.aep_italia.vts.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes6.dex */
public class ListenableFuture<T> implements Future<T> {
    private final CountDownLatch a = new CountDownLatch(1);
    private T b;
    private OnResultReadyListener<T> c;

    public interface OnResultReadyListener<T> {
        void onResultReady(T t);
    }

    class a implements Runnable {
        final /* synthetic */ Object a;

        a(Object obj) {
            this.a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture.this.c.onResultReady(this.a);
        }
    }

    private void a(T t, boolean z) {
        if (this.a.getCount() == 0) {
            return;
        }
        this.b = t;
        this.a.countDown();
        if (this.c != null) {
            if (!z || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                this.c.onResultReady(t);
            } else {
                new Handler(Looper.getMainLooper()).post(new a(t));
            }
        }
    }

    public static <T> ListenableFuture<T> createFulfilled() {
        ListenableFuture<T> listenableFuture = new ListenableFuture<>();
        listenableFuture.setResult(null);
        return listenableFuture;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException {
        this.a.await();
        return this.b;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        if (this.a.await(j, timeUnit)) {
            return this.b;
        }
        throw new TimeoutException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.a.getCount() == 0;
    }

    public void onResultReady(OnResultReadyListener<T> onResultReadyListener) {
        if (this.a.getCount() != 0 || onResultReadyListener == null) {
            this.c = onResultReadyListener;
        } else {
            onResultReadyListener.onResultReady(this.b);
        }
    }

    public void setResult(T t) {
        synchronized (this) {
            a(t, false);
        }
    }

    public void setResultOnUiThread(T t) {
        synchronized (this) {
            a(t, true);
        }
    }
}
