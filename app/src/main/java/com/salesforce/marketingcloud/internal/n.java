package com.salesforce.marketingcloud.internal;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class n {
    private static final String c = "~!SdkExecutors";
    private final ExecutorService a;
    private final ExecutorService b;

    class a implements RejectedExecutionHandler {
        a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            com.salesforce.marketingcloud.g.e(n.c, "Fixed Thread Pool Task %s rejected.", runnable.toString());
        }
    }

    class b implements RejectedExecutionHandler {
        b() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            com.salesforce.marketingcloud.g.e(n.c, "Cached Thread Pool Task %s rejected.", runnable.toString());
        }
    }

    public n(@NonNull ExecutorService executorService, @NonNull ExecutorService executorService2) {
        if (executorService instanceof ThreadPoolExecutor) {
            ((ThreadPoolExecutor) executorService).setRejectedExecutionHandler(new a());
        }
        this.a = executorService;
        if (executorService2 instanceof ThreadPoolExecutor) {
            ((ThreadPoolExecutor) executorService2).setRejectedExecutionHandler(new b());
        }
        this.b = executorService2;
    }

    public ExecutorService a() {
        return this.b;
    }

    public ExecutorService b() {
        return this.a;
    }

    public void c() {
        List<Runnable> listShutdownNow;
        List<Runnable> listShutdownNow2;
        if (!this.a.isShutdown()) {
            this.a.shutdown();
        }
        if (!this.b.isShutdown()) {
            this.b.shutdown();
        }
        try {
            ExecutorService executorService = this.a;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!executorService.awaitTermination(5L, timeUnit) && (listShutdownNow2 = this.a.shutdownNow()) != null && !listShutdownNow2.isEmpty()) {
                com.salesforce.marketingcloud.g.b(c, "Shutdown DiskIO executor with %d tasks pending", Integer.valueOf(listShutdownNow2.size()));
            }
            if (this.b.awaitTermination(5L, timeUnit) || (listShutdownNow = this.b.shutdownNow()) == null || listShutdownNow.isEmpty()) {
                return;
            }
            com.salesforce.marketingcloud.g.b(c, "Shutdown CachedExecutor executor with %d tasks pending", Integer.valueOf(listShutdownNow.size()));
        } catch (InterruptedException e) {
            com.salesforce.marketingcloud.g.b(c, e, "Unable to complete executors", new Object[0]);
        }
    }

    public n() {
        this(Executors.newFixedThreadPool(1), Executors.newCachedThreadPool());
    }
}
