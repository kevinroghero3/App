package com.salesforce.marketingcloud.media;

import android.os.Process;
import androidx.annotation.NonNull;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class m extends ThreadPoolExecutor {
    private static final int a = 2;

    class a implements ThreadFactory {

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.m$a$a, reason: collision with other inner class name */
        class C0083a extends Thread {
            C0083a(Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new C0083a(runnable);
        }
    }

    static class b extends FutureTask<e> implements Comparable<Runnable> {
        b(e eVar) {
            super(eVar, null);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull Runnable runnable) {
            return 0;
        }
    }

    static class c extends FutureTask<n> implements Comparable<Runnable> {
        private final n b;

        c(n nVar) {
            super(nVar, null);
            this.b = nVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull Runnable runnable) {
            if (runnable instanceof c) {
                return ((c) runnable).b.m.ordinal() - this.b.m.ordinal();
            }
            return 0;
        }
    }

    m() {
        super(2, 2, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a());
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        RunnableFuture cVar = runnable instanceof n ? new c((n) runnable) : new b((e) runnable);
        execute(cVar);
        return cVar;
    }
}
