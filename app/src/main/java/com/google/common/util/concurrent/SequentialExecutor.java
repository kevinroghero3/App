package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
final class SequentialExecutor implements Executor {
    private static final Logger log = Logger.getLogger(SequentialExecutor.class.getName());
    private final Executor executor;
    private final Deque<Runnable> queue = new ArrayDeque();
    private WorkerRunningState workerRunningState = WorkerRunningState.IDLE;
    private long workerRunCount = 0;
    private final QueueWorker worker = new QueueWorker();

    enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    static /* synthetic */ long access$308(SequentialExecutor sequentialExecutor) {
        long j = sequentialExecutor.workerRunCount;
        sequentialExecutor.workerRunCount = 1 + j;
        return j;
    }

    SequentialExecutor(Executor executor) {
        this.executor = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        WorkerRunningState workerRunningState;
        Preconditions.checkNotNull(runnable);
        synchronized (this.queue) {
            WorkerRunningState workerRunningState2 = this.workerRunningState;
            if (workerRunningState2 != WorkerRunningState.RUNNING && workerRunningState2 != (workerRunningState = WorkerRunningState.QUEUED)) {
                long j = this.workerRunCount;
                Runnable runnable2 = new Runnable(this) { // from class: com.google.common.util.concurrent.SequentialExecutor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        runnable.run();
                    }

                    public String toString() {
                        return runnable.toString();
                    }
                };
                this.queue.add(runnable2);
                WorkerRunningState workerRunningState3 = WorkerRunningState.QUEUING;
                this.workerRunningState = workerRunningState3;
                try {
                    this.executor.execute(this.worker);
                    if (this.workerRunningState != workerRunningState3) {
                        return;
                    }
                    synchronized (this.queue) {
                        if (this.workerRunCount == j && this.workerRunningState == workerRunningState3) {
                            this.workerRunningState = workerRunningState;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e) {
                    synchronized (this.queue) {
                        WorkerRunningState workerRunningState4 = this.workerRunningState;
                        boolean z = (workerRunningState4 == WorkerRunningState.IDLE || workerRunningState4 == WorkerRunningState.QUEUING) && this.queue.removeLastOccurrence(runnable2);
                        if (!(e instanceof RejectedExecutionException) || z) {
                            throw e;
                        }
                    }
                    return;
                }
            }
            this.queue.add(runnable);
        }
    }

    final class QueueWorker implements Runnable {

        @CheckForNull
        Runnable task;

        private QueueWorker() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                workOnQueue();
            } catch (Error e) {
                synchronized (SequentialExecutor.this.queue) {
                    SequentialExecutor.this.workerRunningState = WorkerRunningState.IDLE;
                    throw e;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
        
            if (r0 == false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
        
            r0 = r0 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
        
            r9.task.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
        
            r4 = com.google.common.util.concurrent.SequentialExecutor.log;
            r5 = java.util.logging.Level.SEVERE;
            r6 = java.lang.String.valueOf(r9.task);
            r8 = new java.lang.StringBuilder(r6.length() + 35);
            r8.append("Exception while executing runnable ");
            r8.append(r6);
            r4.log(r5, r8.toString(), (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
        
            r9.task = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
        
            throw r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void workOnQueue() {
            /*
                r9 = this;
                r0 = 0
                r1 = r0
            L2:
                com.google.common.util.concurrent.SequentialExecutor r2 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L8d
                java.util.Deque r2 = com.google.common.util.concurrent.SequentialExecutor.access$100(r2)     // Catch: java.lang.Throwable -> L8d
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L8d
                if (r1 != 0) goto L2b
                com.google.common.util.concurrent.SequentialExecutor r1 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L8a
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r1 = com.google.common.util.concurrent.SequentialExecutor.access$200(r1)     // Catch: java.lang.Throwable -> L8a
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.RUNNING     // Catch: java.lang.Throwable -> L8a
                if (r1 != r3) goto L20
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L8a
                if (r0 == 0) goto L1f
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L1f:
                return
            L20:
                com.google.common.util.concurrent.SequentialExecutor r1 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L8a
                com.google.common.util.concurrent.SequentialExecutor.access$308(r1)     // Catch: java.lang.Throwable -> L8a
                com.google.common.util.concurrent.SequentialExecutor r1 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L8a
                com.google.common.util.concurrent.SequentialExecutor.access$202(r1, r3)     // Catch: java.lang.Throwable -> L8a
                r1 = 1
            L2b:
                com.google.common.util.concurrent.SequentialExecutor r3 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L8a
                java.util.Deque r3 = com.google.common.util.concurrent.SequentialExecutor.access$100(r3)     // Catch: java.lang.Throwable -> L8a
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L8a
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L8a
                r9.task = r3     // Catch: java.lang.Throwable -> L8a
                if (r3 != 0) goto L4d
                com.google.common.util.concurrent.SequentialExecutor r1 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L8a
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE     // Catch: java.lang.Throwable -> L8a
                com.google.common.util.concurrent.SequentialExecutor.access$202(r1, r3)     // Catch: java.lang.Throwable -> L8a
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L8a
                if (r0 == 0) goto L4c
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L4c:
                return
            L4d:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L8a
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L8d
                r0 = r0 | r2
                r2 = 0
                java.lang.Runnable r3 = r9.task     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
                r3.run()     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
                goto L83
            L5a:
                r1 = move-exception
                goto L87
            L5c:
                r3 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.SequentialExecutor.access$400()     // Catch: java.lang.Throwable -> L5a
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L5a
                java.lang.Runnable r6 = r9.task     // Catch: java.lang.Throwable -> L5a
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L5a
                int r7 = r6.length()     // Catch: java.lang.Throwable -> L5a
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
                int r7 = r7 + 35
                r8.<init>(r7)     // Catch: java.lang.Throwable -> L5a
                java.lang.String r7 = "Exception while executing runnable "
                r8.append(r7)     // Catch: java.lang.Throwable -> L5a
                r8.append(r6)     // Catch: java.lang.Throwable -> L5a
                java.lang.String r6 = r8.toString()     // Catch: java.lang.Throwable -> L5a
                r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L5a
            L83:
                r9.task = r2     // Catch: java.lang.Throwable -> L8d
                goto L2
            L87:
                r9.task = r2     // Catch: java.lang.Throwable -> L8d
                throw r1     // Catch: java.lang.Throwable -> L8d
            L8a:
                r1 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L8a
                throw r1     // Catch: java.lang.Throwable -> L8d
            L8d:
                r1 = move-exception
                if (r0 == 0) goto L97
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L97:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.SequentialExecutor.QueueWorker.workOnQueue():void");
        }

        public String toString() {
            Runnable runnable = this.task;
            if (runnable == null) {
                String strValueOf = String.valueOf(SequentialExecutor.this.workerRunningState);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
                sb.append("SequentialExecutorWorker{state=");
                sb.append(strValueOf);
                sb.append("}");
                return sb.toString();
            }
            String strValueOf2 = String.valueOf(runnable);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 34);
            sb2.append("SequentialExecutorWorker{running=");
            sb2.append(strValueOf2);
            sb2.append("}");
            return sb2.toString();
        }
    }

    public String toString() {
        int iIdentityHashCode = System.identityHashCode(this);
        String strValueOf = String.valueOf(this.executor);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
        sb.append("SequentialExecutor@");
        sb.append(iIdentityHashCode);
        sb.append("{");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
