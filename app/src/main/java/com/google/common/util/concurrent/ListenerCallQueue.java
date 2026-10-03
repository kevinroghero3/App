package com.google.common.util.concurrent;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
final class ListenerCallQueue<L> {
    private static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
    private final List<PerListenerQueue<L>> listeners = Collections.synchronizedList(new ArrayList());

    interface Event<L> {
        void call(L l);
    }

    ListenerCallQueue() {
    }

    public void addListener(L l, Executor executor) {
        Preconditions.checkNotNull(l, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkNotNull(executor, "executor");
        this.listeners.add(new PerListenerQueue<>(l, executor));
    }

    public void enqueue(Event<L> event) {
        enqueueHelper(event, event);
    }

    public void enqueue(Event<L> event, String str) {
        enqueueHelper(event, str);
    }

    private void enqueueHelper(Event<L> event, Object obj) {
        Preconditions.checkNotNull(event, NotificationCompat.CATEGORY_EVENT);
        Preconditions.checkNotNull(obj, Constants.ScionAnalytics.PARAM_LABEL);
        synchronized (this.listeners) {
            Iterator<PerListenerQueue<L>> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                it2.next().add(event, obj);
            }
        }
    }

    public void dispatch() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).dispatch();
        }
    }

    static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;
        boolean isThreadScheduled;
        final L listener;
        final Queue<Event<L>> waitQueue = Queues.newArrayDeque();
        final Queue<Object> labelQueue = Queues.newArrayDeque();

        PerListenerQueue(L l, Executor executor) {
            this.listener = (L) Preconditions.checkNotNull(l);
            this.executor = (Executor) Preconditions.checkNotNull(executor);
        }

        void add(Event<L> event, Object obj) {
            synchronized (this) {
                this.waitQueue.add(event);
                this.labelQueue.add(obj);
            }
        }

        void dispatch() {
            boolean z;
            synchronized (this) {
                if (this.isThreadScheduled) {
                    z = false;
                } else {
                    z = true;
                    this.isThreadScheduled = true;
                }
            }
            if (z) {
                try {
                    this.executor.execute(this);
                } catch (RuntimeException e) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        Logger logger = ListenerCallQueue.logger;
                        Level level = Level.SEVERE;
                        String strValueOf = String.valueOf(this.listener);
                        String strValueOf2 = String.valueOf(this.executor);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 42 + strValueOf2.length());
                        sb.append("Exception while running callbacks for ");
                        sb.append(strValueOf);
                        sb.append(" on ");
                        sb.append(strValueOf2);
                        logger.log(level, sb.toString(), (Throwable) e);
                        throw e;
                    }
                }
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x006a */
        /* JADX WARN: Code duplicated, block: B:27:0x006f  */
        /* JADX WARN: Code duplicated, block: B:37:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        
            r2.call(r11.listener);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        
            r4 = com.google.common.util.concurrent.ListenerCallQueue.logger;
            r5 = java.util.logging.Level.SEVERE;
            r6 = java.lang.String.valueOf(r11.listener);
            r3 = java.lang.String.valueOf(r3);
            r9 = new java.lang.StringBuilder((r6.length() + 37) + r3.length());
            r9.append("Exception while executing callback: ");
            r9.append(r6);
            r9.append(org.apache.commons.lang3.StringUtils.SPACE);
            r9.append(r3);
            r4.log(r5, r9.toString(), (java.lang.Throwable) r2);
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.Throwable {
            /*
                r11 = this;
            L0:
                r0 = 1
                r1 = 0
                monitor-enter(r11)     // Catch: java.lang.Throwable -> L6c
                boolean r2 = r11.isThreadScheduled     // Catch: java.lang.Throwable -> L5f
                com.google.common.base.Preconditions.checkState(r2)     // Catch: java.lang.Throwable -> L5f
                java.util.Queue<com.google.common.util.concurrent.ListenerCallQueue$Event<L>> r2 = r11.waitQueue     // Catch: java.lang.Throwable -> L5f
                java.lang.Object r2 = r2.poll()     // Catch: java.lang.Throwable -> L5f
                com.google.common.util.concurrent.ListenerCallQueue$Event r2 = (com.google.common.util.concurrent.ListenerCallQueue.Event) r2     // Catch: java.lang.Throwable -> L5f
                java.util.Queue<java.lang.Object> r3 = r11.labelQueue     // Catch: java.lang.Throwable -> L5f
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L5f
                if (r2 != 0) goto L1f
                r11.isThreadScheduled = r1     // Catch: java.lang.Throwable -> L5f
                monitor-exit(r11)     // Catch: java.lang.Throwable -> L1c
                return
            L1c:
                r0 = move-exception
                r2 = r1
                goto L63
            L1f:
                monitor-exit(r11)     // Catch: java.lang.Throwable -> L5f
                L r4 = r11.listener     // Catch: java.lang.RuntimeException -> L26 java.lang.Throwable -> L6c
                r2.call(r4)     // Catch: java.lang.RuntimeException -> L26 java.lang.Throwable -> L6c
                goto L0
            L26:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.ListenerCallQueue.access$000()     // Catch: java.lang.Throwable -> L6c
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L6c
                L r6 = r11.listener     // Catch: java.lang.Throwable -> L6c
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L6c
                java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L6c
                int r7 = r6.length()     // Catch: java.lang.Throwable -> L6c
                int r8 = r3.length()     // Catch: java.lang.Throwable -> L6c
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6c
                int r7 = r7 + 37
                int r7 = r7 + r8
                r9.<init>(r7)     // Catch: java.lang.Throwable -> L6c
                java.lang.String r7 = "Exception while executing callback: "
                r9.append(r7)     // Catch: java.lang.Throwable -> L6c
                r9.append(r6)     // Catch: java.lang.Throwable -> L6c
                java.lang.String r6 = " "
                r9.append(r6)     // Catch: java.lang.Throwable -> L6c
                r9.append(r3)     // Catch: java.lang.Throwable -> L6c
                java.lang.String r3 = r9.toString()     // Catch: java.lang.Throwable -> L6c
                r4.log(r5, r3, r2)     // Catch: java.lang.Throwable -> L6c
                goto L0
            L5f:
                r2 = move-exception
                r10 = r2
                r2 = r0
                r0 = r10
            L63:
                monitor-exit(r11)     // Catch: java.lang.Throwable -> L6a
                throw r0     // Catch: java.lang.Throwable -> L65
            L65:
                r0 = move-exception
                r10 = r2
                r2 = r0
                r0 = r10
                goto L6d
            L6a:
                r0 = move-exception
                goto L63
            L6c:
                r2 = move-exception
            L6d:
                if (r0 == 0) goto L77
                monitor-enter(r11)
                r11.isThreadScheduled = r1     // Catch: java.lang.Throwable -> L74
                monitor-exit(r11)     // Catch: java.lang.Throwable -> L74
                goto L77
            L74:
                r0 = move-exception
                monitor-exit(r11)     // Catch: java.lang.Throwable -> L74
                throw r0
            L77:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue.run():void");
        }
    }
}
