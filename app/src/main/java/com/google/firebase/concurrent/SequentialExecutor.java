package com.google.firebase.concurrent;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.swmansion.worklets.WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import o.ArtificialStackFrames;
import o.build;
import o.extraCallback;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes5.dex */
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
                Runnable runnable2 = new Runnable() { // from class: com.google.firebase.concurrent.SequentialExecutor.1
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

    public final class QueueWorker implements Runnable {

        @CheckForNull
        Runnable task;
        private static final byte[] $$a = {4, -122, -75, -94};
        private static final int $$b = 82;
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char TopicBuilder = 3104;
        private static char ICustomTabsCallback = 36816;
        private static char extraCallbackWithResult = 34388;
        private static char onMessageChannelReady = 49151;
        private static char[] ArtificialStackFrames = {44349, 44391, 44386, 44373, 44409, 44337, 44320, 44332, 44404, 44339, 44368, 44361, 44393, 44397, 44334, 44336, 44338, 44390, 44395, 44389, 44387, 44402, 44400, 44399, 44354, 44371, 44365, 44405, 44356, 44388, 44355, 44367, 44366, 44353, 44385, 44398};
        private static char coroutineCreation = 39068;

        private static String $$c(int i, int i2, byte b) {
            byte[] bArr = $$a;
            int i3 = i + 4;
            int i4 = i2 * 3;
            int i5 = 110 - b;
            byte[] bArr2 = new byte[i4 + 1];
            int i6 = -1;
            if (bArr == null) {
                i6 = -1;
                i5 = i3 + i5;
                i3 = i3;
            }
            while (true) {
                int i7 = i6 + 1;
                int i8 = i3 + 1;
                bArr2[i7] = (byte) i5;
                if (i7 == i4) {
                    return new String(bArr2, 0);
                }
                i6 = i7;
                i5 = bArr[i8] + i5;
                i3 = i8;
            }
        }

        private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            build buildVar = new build();
            char[] cArr2 = new char[cArr.length];
            int i3 = 0;
            buildVar.c = 0;
            char[] cArr3 = new char[2];
            int i4 = $11 + 37;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            while (buildVar.c < cArr.length) {
                int i6 = $11 + 57;
                $10 = i6 % 128;
                if (i6 % 2 != 0) {
                    cArr3[i3] = cArr[buildVar.c];
                    cArr3[1] = cArr[buildVar.c - 1];
                } else {
                    cArr3[i3] = cArr[buildVar.c];
                    cArr3[1] = cArr[buildVar.c + 1];
                }
                int i7 = 58224;
                int i8 = i3;
                while (i8 < 16) {
                    int i9 = $10 + 55;
                    $11 = i9 % 128;
                    int i10 = i9 % 2;
                    char c = cArr3[1];
                    char c2 = cArr3[i3];
                    int i11 = (c2 + i7) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))));
                    int i12 = c2 >>> 5;
                    try {
                        Object[] objArr2 = new Object[4];
                        objArr2[3] = Integer.valueOf(onMessageChannelReady);
                        objArr2[2] = Integer.valueOf(i12);
                        objArr2[1] = Integer.valueOf(i11);
                        objArr2[i3] = Integer.valueOf(c);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                        if (objAccessartificialFrame == null) {
                            int mode = 28 - View.MeasureSpec.getMode(i3);
                            char c3 = (char) (17263 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                            int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 1067;
                            byte b = (byte) (-1);
                            byte b2 = (byte) (b + 1);
                            String str$$c = $$c(b, b2, (byte) (b2 + 2));
                            Class[] clsArr = new Class[4];
                            clsArr[i3] = Integer.TYPE;
                            clsArr[1] = Integer.TYPE;
                            clsArr[2] = Integer.TYPE;
                            clsArr[3] = Integer.TYPE;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(mode, c3, edgeSlop, 1042277788, false, str$$c, clsArr);
                        }
                        char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        cArr3[1] = cCharValue;
                        char[] cArr4 = cArr3;
                        Object[] objArr3 = {Integer.valueOf(cArr3[i3]), Integer.valueOf((cCharValue + i7) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) (-1);
                            byte b4 = (byte) (b3 + 1);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(29 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (17263 - Color.argb(0, 0, 0, 0)), 1067 - Color.green(0), 1042277788, false, $$c(b3, b4, (byte) (b4 + 2)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                        }
                        cArr4[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        i7 -= 40503;
                        i8++;
                        cArr3 = cArr4;
                        i3 = 0;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                char[] cArr5 = cArr3;
                cArr2[buildVar.c] = cArr5[0];
                cArr2[buildVar.c + 1] = cArr5[1];
                Object[] objArr4 = {buildVar, buildVar};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) (-1);
                    byte b6 = (byte) (b5 + 1);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getTouchSlop() >> 8), (char) (63927 - ((byte) KeyEvent.getModifierMetaStateMask())), 486 - View.MeasureSpec.getMode(0), 1554985764, false, $$c(b5, b6, b6), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                cArr3 = cArr5;
                i3 = 0;
            }
            objArr[0] = new String(cArr2, 0, i);
        }

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
        
            r8.task.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
        
            com.google.firebase.concurrent.SequentialExecutor.log.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r8.task, (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x007c, code lost:
        
            r8.task = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x007e, code lost:
        
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
                r8 = this;
                r0 = 0
                r1 = r0
            L2:
                com.google.firebase.concurrent.SequentialExecutor r2 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L82
                java.util.Deque r2 = com.google.firebase.concurrent.SequentialExecutor.access$100(r2)     // Catch: java.lang.Throwable -> L82
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L82
                if (r1 != 0) goto L2b
                com.google.firebase.concurrent.SequentialExecutor r1 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L7f
                com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r1 = com.google.firebase.concurrent.SequentialExecutor.access$200(r1)     // Catch: java.lang.Throwable -> L7f
                com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.firebase.concurrent.SequentialExecutor.WorkerRunningState.RUNNING     // Catch: java.lang.Throwable -> L7f
                if (r1 != r3) goto L20
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L7f
                if (r0 == 0) goto L1f
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L1f:
                return
            L20:
                com.google.firebase.concurrent.SequentialExecutor r1 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L7f
                com.google.firebase.concurrent.SequentialExecutor.access$308(r1)     // Catch: java.lang.Throwable -> L7f
                com.google.firebase.concurrent.SequentialExecutor r1 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L7f
                com.google.firebase.concurrent.SequentialExecutor.access$202(r1, r3)     // Catch: java.lang.Throwable -> L7f
                r1 = 1
            L2b:
                com.google.firebase.concurrent.SequentialExecutor r3 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L7f
                java.util.Deque r3 = com.google.firebase.concurrent.SequentialExecutor.access$100(r3)     // Catch: java.lang.Throwable -> L7f
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L7f
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L7f
                r8.task = r3     // Catch: java.lang.Throwable -> L7f
                if (r3 != 0) goto L4d
                com.google.firebase.concurrent.SequentialExecutor r1 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L7f
                com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.firebase.concurrent.SequentialExecutor.WorkerRunningState.IDLE     // Catch: java.lang.Throwable -> L7f
                com.google.firebase.concurrent.SequentialExecutor.access$202(r1, r3)     // Catch: java.lang.Throwable -> L7f
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L7f
                if (r0 == 0) goto L4c
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L4c:
                return
            L4d:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L7f
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L82
                r0 = r0 | r2
                r2 = 0
                java.lang.Runnable r3 = r8.task     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
                r3.run()     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
                goto L79
            L5a:
                r1 = move-exception
                goto L7c
            L5c:
                r3 = move-exception
                java.util.logging.Logger r4 = com.google.firebase.concurrent.SequentialExecutor.access$400()     // Catch: java.lang.Throwable -> L5a
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L5a
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
                r6.<init>()     // Catch: java.lang.Throwable -> L5a
                java.lang.String r7 = "Exception while executing runnable "
                r6.append(r7)     // Catch: java.lang.Throwable -> L5a
                java.lang.Runnable r7 = r8.task     // Catch: java.lang.Throwable -> L5a
                r6.append(r7)     // Catch: java.lang.Throwable -> L5a
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L5a
                r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L5a
            L79:
                r8.task = r2     // Catch: java.lang.Throwable -> L82
                goto L2
            L7c:
                r8.task = r2     // Catch: java.lang.Throwable -> L82
                throw r1     // Catch: java.lang.Throwable -> L82
            L7f:
                r1 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L7f
                throw r1     // Catch: java.lang.Throwable -> L82
            L82:
                r1 = move-exception
                if (r0 == 0) goto L8c
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L8c:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.concurrent.SequentialExecutor.QueueWorker.workOnQueue():void");
        }

        public String toString() {
            Runnable runnable = this.task;
            if (runnable != null) {
                return "SequentialExecutorWorker{running=" + runnable + "}";
            }
            return "SequentialExecutorWorker{state=" + SequentialExecutor.this.workerRunningState + "}";
        }

        private static void b(byte b, int i, char[] cArr, Object[] objArr) throws Throwable {
            int i2;
            int i3 = 2 % 2;
            extraCallback extracallback = new extraCallback();
            char[] cArr2 = ArtificialStackFrames;
            int i4 = -1819279892;
            long j = 0;
            int i5 = -1;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i6 = 0;
                while (i6 < length) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i6])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                        if (objAccessartificialFrame == null) {
                            int iMyTid = (Process.myTid() >> 22) + 15;
                            char cIndexOf = (char) (20488 - TextUtils.indexOf("", ""));
                            int i7 = 2149 - (SystemClock.elapsedRealtimeNanos() > j ? 1 : (SystemClock.elapsedRealtimeNanos() == j ? 0 : -1));
                            byte b2 = (byte) i5;
                            byte b3 = (byte) (b2 + 1);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iMyTid, cIndexOf, i7, 216710116, false, $$c(b2, b3, (byte) (b3 | Ascii.CR)), new Class[]{Integer.TYPE});
                        }
                        cArr3[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i6++;
                        int i8 = $10 + 3;
                        $11 = i8 % 128;
                        int i9 = i8 % 2;
                        i4 = -1819279892;
                        j = 0;
                        i5 = -1;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                int i10 = $11 + 5;
                $10 = i10 % 128;
                int i11 = i10 % 2;
                cArr2 = cArr3;
            }
            try {
                Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                if (objAccessartificialFrame2 == null) {
                    byte b4 = (byte) (-1);
                    byte b5 = (byte) (b4 + 1);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 15, (char) (20487 - MotionEvent.axisFromString("")), 2148 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 216710116, false, $$c(b4, b5, (byte) (b5 | Ascii.CR)), new Class[]{Integer.TYPE});
                }
                char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                char[] cArr4 = new char[i];
                if (i % 2 != 0) {
                    i2 = i - 1;
                    cArr4[i2] = (char) (cArr[i2] - b);
                } else {
                    i2 = i;
                }
                if (i2 > 1) {
                    int i12 = $11 + 65;
                    $10 = i12 % 128;
                    int i13 = i12 % 2;
                    extracallback.a = 0;
                    while (extracallback.a < i2) {
                        extracallback.createBrowser = cArr[extracallback.a];
                        extracallback.c = cArr[extracallback.a + 1];
                        if (extracallback.createBrowser == extracallback.c) {
                            cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                            cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        } else {
                            Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                            if (objAccessartificialFrame3 == null) {
                                byte b6 = (byte) (-1);
                                byte b7 = (byte) (b6 + 1);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(KeyEvent.normalizeMetaState(0) + 46, (char) ((Process.myTid() >> 22) + 58859), 2465 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 276640984, false, $$c(b6, b7, (byte) (b7 | 8)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                            }
                            if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                                int i14 = $11 + 89;
                                $10 = i14 % 128;
                                int i15 = i14 % 2;
                                try {
                                    Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                    if (objAccessartificialFrame4 == null) {
                                        byte b8 = (byte) (-1);
                                        byte b9 = (byte) (b8 + 1);
                                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(25 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 792 - View.MeasureSpec.getSize(0), -834291897, false, $$c(b8, b9, (byte) (b9 + 5)), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                    }
                                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                                    int i16 = (extracallback.d * cCharValue) + extracallback.g;
                                    cArr4[extracallback.a] = cArr2[iIntValue];
                                    cArr4[extracallback.a + 1] = cArr2[i16];
                                } catch (Throwable th2) {
                                    Throwable cause2 = th2.getCause();
                                    if (cause2 == null) {
                                        throw th2;
                                    }
                                    throw cause2;
                                }
                            } else if (extracallback.b == extracallback.d) {
                                int i17 = $10 + 81;
                                $11 = i17 % 128;
                                int i18 = i17 % 2;
                                extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                int i19 = (extracallback.b * cCharValue) + extracallback.j;
                                int i20 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[i19];
                                cArr4[extracallback.a + 1] = cArr2[i20];
                            } else {
                                int i21 = (extracallback.b * cCharValue) + extracallback.g;
                                int i22 = (extracallback.d * cCharValue) + extracallback.j;
                                cArr4[extracallback.a] = cArr2[i21];
                                cArr4[extracallback.a + 1] = cArr2[i22];
                            }
                        }
                        extracallback.a += 2;
                    }
                }
                int i23 = 0;
                while (i23 < i) {
                    int i24 = $11 + 1;
                    $10 = i24 % 128;
                    if (i24 % 2 != 0) {
                        cArr4[i23] = (char) (cArr4[i23] ^ 2653);
                        i23 += 20;
                    } else {
                        cArr4[i23] = (char) (cArr4[i23] ^ 13722);
                        i23++;
                    }
                }
                objArr[0] = new String(cArr4);
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }

        public static Object[] accessartificialFrame(Context context, int i, int i2) {
            int i3;
            int i4;
            int i5;
            Class<?> cls;
            long zoomControlsTimeout;
            int i6;
            Object obj;
            int i7;
            int i8;
            int i9 = 2 % 2;
            int i10 = ~WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0.MediaBrowserCompatMediaBrowserImpl();
            int i11 = ~(513107168 | i10);
            int i12 = ((i11 & (-304376815)) | ((-304376815) ^ i11)) * (-983);
            int i13 = 1;
            int i14 = ((451188788 | i12) << 1) - (i12 ^ 451188788);
            int i15 = ~((i10 & (-304376815)) | ((-304376815) ^ i10));
            int i16 = ((i15 & 302276832) | (i15 ^ 302276832)) * 983;
            int i17 = (i14 & i16) + (i16 | i14);
            int i18 = ~i;
            int i19 = -(-(((~((737930173 & i18) | (737930173 ^ i18))) | (~(((-198855066) & i) | ((-198855066) ^ i)))) * 520));
            int i20 = ((-579403183) ^ i19) + ((i19 & (-579403183)) << 1);
            int i21 = ~i;
            int i22 = ~(198855065 | i21);
            int i23 = ~(((-703308461) & i) | ((-703308461) ^ i));
            int i24 = i20 + (((i22 & i23) | (i22 ^ i23)) * (-1040));
            int i25 = ~(703308460 | i18);
            int i26 = ((i25 & 539075108) | (i25 ^ 539075108) | i23) * 520;
            int i27 = (i24 ^ i26) + ((i26 & i24) << 1);
            Object obj2 = null;
            if (i17 <= i27) {
                obj2.hashCode();
                throw null;
            }
            int i28 = 0;
            if (context == null) {
                int i29 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i30 = ((i29 | 83) << 1) - (i29 ^ 83);
                artificialFrame = i30 % 128;
                int i31 = i30 % 2;
                Object[] objArr = {new int[]{i}, new int[]{i}, new int[1], null};
                int i32 = 73821438 + ((i | 959142096) * 614) + (((~((-278723256) | i18)) | 268982416 | (~(699900519 | i18))) * (-1228)) + (((~((-9740840) | i18)) | (~(i18 | 968882935))) * 614);
                int iMediaBrowserCompatMediaBrowserImpl = WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0.MediaBrowserCompatMediaBrowserImpl();
                int i33 = (-1) - (~(-(-(i32 * (-496)))));
                int i34 = ~i32;
                int i35 = ((-1) ^ i34) | i34;
                int i36 = (~i35) * 497;
                int i37 = ((((i33 | i36) << 1) - (i33 ^ i36)) - (~(((~(i35 | iMediaBrowserCompatMediaBrowserImpl)) | (~((~iMediaBrowserCompatMediaBrowserImpl) | i34))) * 497))) - 1;
                int i38 = ~(((-1) ^ i32) | i32);
                int i39 = ~((iMediaBrowserCompatMediaBrowserImpl & i34) | (i34 ^ iMediaBrowserCompatMediaBrowserImpl));
                int i40 = (i37 - (~(((i39 & i38) | (i38 ^ i39)) * 497))) - 1;
                int iMediaBrowserCompatMediaBrowserImpl2 = WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0.MediaBrowserCompatMediaBrowserImpl();
                int i41 = i40 * 371;
                int i42 = i2 * 371;
                int i43 = (i41 ^ i42) + ((i41 & i42) << 1);
                int i44 = ~i2;
                int i45 = ~iMediaBrowserCompatMediaBrowserImpl2;
                int i46 = ~((i44 ^ i45) | (i44 & i45));
                int i47 = ~i40;
                int i48 = ~((i47 & iMediaBrowserCompatMediaBrowserImpl2) | (i47 ^ iMediaBrowserCompatMediaBrowserImpl2));
                int i49 = ((i46 & i48) | (i46 ^ i48)) * (-370);
                int i50 = ~(i45 | (~i40));
                int i51 = ~(iMediaBrowserCompatMediaBrowserImpl2 | i44);
                int i52 = (((((i43 | i49) << 1) - (i43 ^ i49)) + ((((i51 & i50) | (i50 ^ i51)) | (~((i40 ^ i2) | (i40 & i2)))) * (-370))) - (~((~(i40 | i2)) * 370))) - 1;
                int i53 = (i52 << 13) ^ i52;
                int i54 = i53 >>> 17;
                int i55 = (i53 | i54) & (~(i53 & i54));
                int i56 = i55 << 5;
                ((int[]) objArr[2])[0] = (i55 | i56) & (~(i55 & i56));
                return objArr;
            }
            try {
                Object[] objArr2 = new Object[1];
                a((ViewConfiguration.getTapTimeout() >> 16) + 38, new char[]{18122, 11228, 48397, 34001, 622, 21100, 55233, 22761, 63857, 26972, 61165, 42537, 35522, 4532, 23914, 6133, 30256, 20468, 28309, 29435, 55349, 58181, 64836, 15977, 16934, 52477, 310, 3016, 24173, 27699, 61165, 42537, 25457, 36597, 28503, 25584, 5772, 4442}, objArr2);
                Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
                int iCombineMeasuredStates = View.combineMeasuredStates(0, 0);
                byte b = (byte) ((iCombineMeasuredStates ^ 115) + ((iCombineMeasuredStates & 115) << 1));
                int i57 = -ExpandableListView.getPackedPositionChild(0L);
                int iMediaBrowserCompatMediaBrowserImpl3 = WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0.MediaBrowserCompatMediaBrowserImpl();
                int i58 = artificialFrame;
                int i59 = ((i58 | 57) << 1) - (i58 ^ 57);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i59 % 128;
                if (i59 % 2 != 0) {
                    i3 = (375 << i57) >>> (-24);
                } else {
                    int i60 = i57 * 375;
                    i3 = ((i60 & (-22410)) << 1) + (i60 ^ (-22410));
                }
                int i61 = ~((~i57) | 30);
                int i62 = ~iMediaBrowserCompatMediaBrowserImpl3;
                int i63 = ~((i62 ^ i57) | (i62 & i57));
                int i64 = -(-((-374) * ((i61 ^ i63) | (i61 & i63))));
                int i65 = (i3 ^ i64) + ((i3 & i64) << 1);
                int i66 = (~(((-31) & i57) | ((-31) ^ i57))) * 748;
                int i67 = (i65 ^ i66) + ((i66 & i65) << 1);
                int i68 = (i58 & 95) + (i58 | 95);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i68 % 128;
                if (i68 % 2 != 0) {
                    Object obj3 = null;
                    obj3.hashCode();
                    throw null;
                }
                int i69 = ~i57;
                int i70 = ~((i69 & (-31)) | (i69 ^ (-31)));
                int i71 = ~((~iMediaBrowserCompatMediaBrowserImpl3) | i57);
                int i72 = -(-(374 * ((i70 & i71) | (i70 ^ i71))));
                Object[] objArr4 = new Object[1];
                b(b, ((i67 | i72) << 1) - (i72 ^ i67), new char[]{31, '!', 3, 30, 5, '#', 22, 18, 17, 24, '\n', 24, 20, 1, 25, 3, CharUtils.CR, 1, 3, 30, 5, '#', 22, 18, 17, 24, 6, 31, 1, 4, 13884}, objArr4);
                try {
                    Object[] objArr5 = {(String) objArr4[0]};
                    int i73 = -Color.argb(0, 0, 0, 0);
                    int i74 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i75 = i74 + 77;
                    artificialFrame = i75 % 128;
                    int i76 = i75 % 2;
                    int i77 = (i73 * 829) + 31502;
                    int i78 = ~((~i73) | (-39));
                    int i79 = i74 + 1;
                    artificialFrame = i79 % 128;
                    int i80 = i79 % 2;
                    int i81 = ~(i18 | i73 | 38);
                    int i82 = (-828) * ((i81 & i78) | (i78 ^ i81));
                    int i83 = ((i77 | i82) << 1) - (i82 ^ i77);
                    int i84 = (i73 & 38) | (i73 ^ 38);
                    int i85 = (i84 | i18) * (-828);
                    int i86 = (i83 ^ i85) + ((i83 & i85) << 1);
                    int i87 = -(-((~i84) * 828));
                    Object[] objArr6 = new Object[1];
                    a((i86 ^ i87) + ((i87 & i86) << 1), new char[]{18122, 11228, 48397, 34001, 622, 21100, 55233, 22761, 63857, 26972, 61165, 42537, 35522, 4532, 23914, 6133, 30256, 20468, 28309, 29435, 55349, 58181, 64836, 15977, 16934, 52477, 310, 3016, 24173, 27699, 61165, 42537, 25457, 36597, 28503, 25584, 5772, 4442}, objArr6);
                    Class<?> cls2 = Class.forName((String) objArr6[0]);
                    Class<?>[] clsArr = {String.class};
                    int i88 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i89 = (i88 & 125) + (i88 | 125);
                    artificialFrame = i89 % 128;
                    if (i89 % 2 == 0) {
                        objArr3[0] = cls2.getDeclaredConstructor(clsArr).newInstance(objArr5);
                        i4 = b.i;
                    } else {
                        objArr3[0] = cls2.getDeclaredConstructor(clsArr).newInstance(objArr5);
                        i4 = 31;
                    }
                    Object[] objArr7 = new Object[1];
                    a(i4 + (ViewConfiguration.getKeyRepeatDelay() >> 16), new char[]{20478, 38701, 40988, 5720, 24555, 14251, 31479, 11099, 47701, 3430, 'K', 60158, 12224, 7899, 57997, 61244, 56174, 56167, 21795, 59114, 3579, 56312, 2466, 41142, 63848, 27725, 48937, 29117, 9949, 34871, 1489, 39904}, objArr7);
                    String str = (String) objArr7[0];
                    int i90 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i91 = (i90 ^ 27) + ((i90 & 27) << 1);
                    artificialFrame = i91 % 128;
                    int i92 = i91 % 2;
                    try {
                        Object[] objArr8 = {str};
                        int mode = View.MeasureSpec.getMode(0);
                        int i93 = (mode * 866) - 32832;
                        int i94 = ~mode;
                        int i95 = ~((i94 & i18) | (i94 ^ i18));
                        int i96 = (((-39) & i95) | ((-39) ^ i95)) * (-865);
                        int i97 = ((i93 | i96) << 1) - (i93 ^ i96);
                        int i98 = -(-((~((mode ^ i) | (mode & i))) * 865));
                        int i99 = (i97 & i98) + (i98 | i97);
                        int i100 = ~(((-39) & i21) | ((-39) ^ i21));
                        int i101 = artificialFrame + 51;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i101 % 128;
                        int i102 = i101 % 2;
                        int i103 = i99 + (865 * ((~((i18 ^ mode) | (mode & i18))) | i100));
                        Object[] objArr9 = new Object[1];
                        a(i103, new char[]{18122, 11228, 48397, 34001, 622, 21100, 55233, 22761, 63857, 26972, 61165, 42537, 35522, 4532, 23914, 6133, 30256, 20468, 28309, 29435, 55349, 58181, 64836, 15977, 16934, 52477, 310, 3016, 24173, 27699, 61165, 42537, 25457, 36597, 28503, 25584, 5772, 4442}, objArr9);
                        Object objNewInstance = Class.forName((String) objArr9[0]).getDeclaredConstructor(String.class).newInstance(objArr8);
                        int i104 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i105 = (i104 & 25) + (i104 | 25);
                        artificialFrame = i105 % 128;
                        int i106 = i105 % 2;
                        objArr3[1] = objNewInstance;
                        try {
                            int i107 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            Object[] objArr10 = new Object[1];
                            a((i107 & 23) + (i107 | 23), new char[]{53236, 61289, 3579, 56312, 2466, 41142, 12801, 32366, 2750, 37812, 33021, 60084, 37829, 16881, 1598, 8798, 58928, 47639, 33021, 60084, 63395, 36721, 52264, 55427}, objArr10);
                            Class<?> cls3 = Class.forName((String) objArr10[0]);
                            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L);
                            int i108 = -(-AndroidCharacter.getMirror('0'));
                            Object[] objArr11 = new Object[1];
                            b((byte) (((packedPositionGroup | 18) << 1) - (packedPositionGroup ^ 18)), (i108 & (-31)) + (i108 | (-31)), new char[]{7, 25, '\t', 11, ' ', 22, 22, 30, 7, 25, 28, ' ', 30, '#', 7, 25, 13818}, objArr11);
                            Object objInvoke = cls3.getMethod((String) objArr11[0], null).invoke(context, null);
                            int i109 = artificialFrame;
                            int i110 = (i109 & 33) + (i109 | 33);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i110 % 128;
                            int i111 = i110 % 2;
                            try {
                                int i112 = -(-((byte) KeyEvent.getModifierMetaStateMask()));
                                Object[] objArr12 = new Object[1];
                                a((i112 ^ 24) + ((i112 & 24) << 1), new char[]{53236, 61289, 3579, 56312, 2466, 41142, 12801, 32366, 2750, 37812, 33021, 60084, 37829, 16881, 1598, 8798, 58928, 47639, 33021, 60084, 63395, 36721, 52264, 55427}, objArr12);
                                Class<?> cls4 = Class.forName((String) objArr12[0]);
                                int i113 = -View.MeasureSpec.getSize(0);
                                int iMediaBrowserCompatMediaBrowserImpl4 = WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0.MediaBrowserCompatMediaBrowserImpl();
                                int i114 = i113 * (-495);
                                int i115 = (i114 & (-6930)) + (i114 | (-6930));
                                int i116 = ~i113;
                                int i117 = ~((i116 ^ (-15)) | (i116 & (-15)));
                                int i118 = ~((i116 ^ iMediaBrowserCompatMediaBrowserImpl4) | (i116 & iMediaBrowserCompatMediaBrowserImpl4));
                                int i119 = ((i117 ^ i118) | (i118 & i117)) * 992;
                                int i120 = (i115 ^ i119) + ((i119 & i115) << 1);
                                int i121 = ~((i116 ^ (-15)) | (i116 & (-15)));
                                int i122 = ~i113;
                                int i123 = ~((i122 & iMediaBrowserCompatMediaBrowserImpl4) | (i122 ^ iMediaBrowserCompatMediaBrowserImpl4));
                                int i124 = (i121 & i123) | (i121 ^ i123);
                                int i125 = ~iMediaBrowserCompatMediaBrowserImpl4;
                                int i126 = ~((i125 & i113) | (i125 ^ i113) | 14);
                                int i127 = i124 ^ i126;
                                Object[] objArr13 = new Object[1];
                                a(i120 + (((i124 & i126) | i127) * (-496)) + (((iMediaBrowserCompatMediaBrowserImpl4 ^ 14) | (iMediaBrowserCompatMediaBrowserImpl4 & 14)) * 496), new char[]{65151, 54867, 2775, 26201, 26676, 63630, 38512, 4764, 65151, 54867, 31936, 35535, 37111, 59581}, objArr13);
                                try {
                                    Object[] objArr14 = {cls4.getMethod((String) objArr13[0], null).invoke(context, null), 64};
                                    int i128 = -TextUtils.indexOf((CharSequence) "", '0', 0);
                                    int iMediaBrowserCompatMediaBrowserImpl5 = WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0.MediaBrowserCompatMediaBrowserImpl();
                                    int i129 = (i128 * 659) - 21024;
                                    int i130 = ~i128;
                                    int i131 = ~((i130 & 32) | (i130 ^ 32));
                                    int i132 = ~(((-33) & i128) | ((-33) ^ i128));
                                    int i133 = (i131 & i132) | (i131 ^ i132);
                                    int i134 = ~((i128 ^ iMediaBrowserCompatMediaBrowserImpl5) | (i128 & iMediaBrowserCompatMediaBrowserImpl5));
                                    int i135 = -(-(((i133 & i134) | (i133 ^ i134)) * (-658)));
                                    int i136 = ((i129 | i135) << 1) - (i129 ^ i135);
                                    int i137 = -(-((~(((-33) & i128) | ((-33) ^ i128))) * 658));
                                    int i138 = ((i136 | i137) << 1) - (i137 ^ i136);
                                    int i139 = ~(((-33) & i128) | ((-33) ^ i128));
                                    int i140 = ~(i128 | iMediaBrowserCompatMediaBrowserImpl5);
                                    Object[] objArr15 = new Object[1];
                                    a((i138 - (~(((i140 & i139) | (i139 ^ i140)) * 658))) - 1, new char[]{53236, 61289, 3579, 56312, 2466, 41142, 12801, 32366, 2750, 37812, 33021, 60084, 37829, 16881, 1598, 8798, 56714, 4482, 46033, 10817, 26676, 63630, 38512, 4764, 65151, 54867, 38177, 14487, 26138, 1151, 65151, 54867, 42652, 42476}, objArr15);
                                    Class<?> cls5 = Class.forName((String) objArr15[0]);
                                    int i141 = -(-(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                                    int i142 = -(-Color.blue(0));
                                    Object[] objArr16 = new Object[1];
                                    b((byte) (((i141 | 85) << 1) - (i141 ^ 85)), (i142 ^ 14) + ((i142 & 14) << 1), new char[]{7, 25, '\t', 11, ' ', 22, 22, 30, 7, 25, 17, 5, 23, 29}, objArr16);
                                    Object objInvoke2 = cls5.getMethod((String) objArr16[0], String.class, Integer.TYPE).invoke(objInvoke, objArr14);
                                    int i143 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                    int i144 = -Color.alpha(0);
                                    int i145 = ~((~i144) | (-31));
                                    int i146 = ~(((-31) & i) | ((-31) ^ i));
                                    int i147 = (i145 & i146) | (i145 ^ i146);
                                    int i148 = i21 | i144;
                                    int i149 = ~((i148 & 30) | (i148 ^ 30));
                                    int i150 = ((i144 * 1773) - 26550) + (((i147 & i149) | (i147 ^ i149)) * 886);
                                    int i151 = ~((i21 ^ 30) | (i21 & 30));
                                    int i152 = (i150 - (~(-(-(((i151 & i144) | (i144 ^ i151)) * (-1772)))))) - 1;
                                    int i153 = -(-((~((i144 & i18) | (i18 ^ i144))) * 886));
                                    Object[] objArr17 = new Object[1];
                                    b((byte) ((i143 & 98) + (i143 | 98)), (i152 ^ i153) + ((i153 & i152) << 1), new char[]{'#', 30, 27, 23, 18, 17, 26, 17, 21, 18, ' ', 11, 23, 31, 14, 20, 19, 16, 16, '\b', ' ', 22, 22, 30, 7, 25, 17, 5, 23, 29}, objArr17);
                                    Class<?> cls6 = Class.forName((String) objArr17[0]);
                                    int i154 = -(-TextUtils.getTrimmedLength(""));
                                    Object[] objArr18 = new Object[1];
                                    a(((i154 | 10) << 1) - (i154 ^ 10), new char[]{9156, 25148, 63391, 63209, 6842, 6662, 39913, 36056, 56341, 2384}, objArr18);
                                    Object[] objArr19 = (Object[]) cls6.getField((String) objArr18[0]).get(objInvoke2);
                                    int length = objArr19.length;
                                    int i155 = 0;
                                    while (i155 < length) {
                                        Object obj4 = objArr19[i155];
                                        int iRed = Color.red(i28);
                                        int i156 = artificialFrame + 89;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i156 % 128;
                                        if (i156 % 2 != 0) {
                                            int i157 = -iRed;
                                            i5 = (((i157 | (-1965)) << i13) - (i157 ^ (-1965))) / 196;
                                        } else {
                                            int i158 = iRed * (-1965);
                                            i5 = (i158 & 4920) + (i158 | 4920);
                                        }
                                        int i159 = -(-(983 * ((iRed ^ (-6)) | (iRed & (-6)))));
                                        int i160 = ((i5 | i159) << i13) - (i159 ^ i5);
                                        int i161 = ~iRed;
                                        int i162 = ~(((-6) & i21) | ((-6) ^ i21));
                                        int i163 = i160 + (((i162 & i161) | (i161 ^ i162)) * (-983));
                                        int i164 = ~((i161 ^ i18) | (i161 & i18));
                                        int i165 = ~((i161 & 5) | (i161 ^ 5));
                                        int i166 = ((i165 & i164) | (i164 ^ i165)) * 983;
                                        Object[] objArr20 = new Object[i13];
                                        a(((i163 | i166) << i13) - (i166 ^ i163), new char[]{19724, 9789, 310, 3016, 19345, 20243}, objArr20);
                                        try {
                                            Object[] objArr21 = {(String) objArr20[i28]};
                                            int i167 = -(ViewConfiguration.getKeyRepeatDelay() >> 16);
                                            int i168 = (i167 ^ 37) + ((i167 & 37) << i13);
                                            char[] cArr = {18122, 11228, 48397, 34001, 37027, 52168, 11381, 42142, 39913, 36056, 15000, 58797, 13407, 26960, 4925, 41638, 30283, 16537, 36389, 3298, 20456, 42972, 55038, 24093, 11864, 21063, 63226, 1512, 16652, 36824, 57165, 62191, 58920, 38664, 3196, 12466, 23947, 31497};
                                            int i169 = getARTIFICIAL_FRAME_PACKAGE_NAME + 23;
                                            artificialFrame = i169 % 128;
                                            int i170 = i169 % 2;
                                            Object[] objArr22 = new Object[i13];
                                            a(i168, cArr, objArr22);
                                            Class<?> cls7 = Class.forName((String) objArr22[i28]);
                                            int i171 = -Drawable.resolveOpacity(i28, i28);
                                            int iMediaBrowserCompatMediaBrowserImpl6 = WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0.MediaBrowserCompatMediaBrowserImpl();
                                            int i172 = artificialFrame + 3;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i172 % 128;
                                            int i173 = i172 % 2 != 0 ? (i171 + 55) << (-118) : (i171 * 55) - 1177;
                                            int i174 = ~i171;
                                            int i175 = ~((i174 ^ 11) | (i174 & 11));
                                            Object[] objArr23 = objArr19;
                                            int i176 = ~iMediaBrowserCompatMediaBrowserImpl6;
                                            int i177 = length;
                                            int i178 = (i173 - (~(-(-((-108) * ((~((i176 ^ 11) | (i176 & 11))) | i175)))))) - 1;
                                            int i179 = ~((i174 ^ iMediaBrowserCompatMediaBrowserImpl6) | (i174 & iMediaBrowserCompatMediaBrowserImpl6));
                                            int i180 = ~(((-12) & i171) | ((-12) ^ i171));
                                            int i181 = (i179 & i180) | (i179 ^ i180);
                                            int i182 = ~((i176 & i171) | (i176 ^ i171));
                                            int i183 = i178 + (((i182 & i181) | (i181 ^ i182)) * 54);
                                            int i184 = ~(((-12) & i171) | ((-12) ^ i171));
                                            int i185 = ((i184 & iMediaBrowserCompatMediaBrowserImpl6) | (iMediaBrowserCompatMediaBrowserImpl6 ^ i184)) * 54;
                                            Object[] objArr24 = new Object[1];
                                            a((i183 & i185) + (i185 | i183), new char[]{65151, 54867, 42764, 50747, 4077, 18806, 27423, 64156, 25457, 36597, 23367, 19164}, objArr24);
                                            Object objInvoke3 = cls7.getMethod((String) objArr24[0], String.class).invoke(null, objArr21);
                                            try {
                                                int i186 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                                int i187 = ~i186;
                                                int i188 = ~((i187 & (-30)) | (i187 ^ (-30)));
                                                int i189 = ~((-30) | i);
                                                int i190 = ((((i186 * (-167)) - 4843) - (~(((i188 & i189) | (i188 ^ i189)) * 336))) - 1) + (((~((i186 ^ 29) | (i186 & 29))) | (~((i186 ^ i) | (i186 & i)))) * (-168));
                                                int i191 = ~((i186 & i18) | (i18 ^ i186));
                                                Object[] objArr25 = new Object[1];
                                                a((i190 - (~(((i191 & (-30)) | ((-30) ^ i191)) * 168))) - 1, new char[]{53236, 61289, 3579, 56312, 2466, 41142, 12801, 32366, 2750, 37812, 33021, 60084, 37829, 16881, 1598, 8798, 56714, 4482, 60721, 11517, 35491, 40773, 26138, 1151, 31475, 24601, 49529, 50743}, objArr25);
                                                Class<?> cls8 = Class.forName((String) objArr25[0]);
                                                int i192 = -TextUtils.lastIndexOf("", '0', 0, 0);
                                                int iMediaBrowserCompatMediaBrowserImpl7 = WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0.MediaBrowserCompatMediaBrowserImpl();
                                                int i193 = (i192 * (-813)) + 35088;
                                                int i194 = ~(((-87) & i192) | ((-87) ^ i192));
                                                int i195 = ~(i192 | iMediaBrowserCompatMediaBrowserImpl7);
                                                int i196 = ((i194 & i195) | (i194 ^ i195)) * (-814);
                                                int i197 = ((i193 | i196) << 1) - (i193 ^ i196);
                                                int i198 = ~iMediaBrowserCompatMediaBrowserImpl7;
                                                int i199 = ~((i198 & (-87)) | ((-87) ^ i198));
                                                int i200 = ~i192;
                                                int i201 = ~((i200 & 86) | (i200 ^ 86));
                                                int i202 = (i199 & i201) | (i199 ^ i201);
                                                int i203 = ~((i192 ^ iMediaBrowserCompatMediaBrowserImpl7) | (i192 & iMediaBrowserCompatMediaBrowserImpl7));
                                                int i204 = ((i202 & i203) | (i202 ^ i203)) * 407;
                                                int i205 = ~i192;
                                                int i206 = (~((i205 & iMediaBrowserCompatMediaBrowserImpl7) | (i205 ^ iMediaBrowserCompatMediaBrowserImpl7))) | (~((i205 ^ 86) | (i205 & 86)));
                                                int i207 = ~((iMediaBrowserCompatMediaBrowserImpl7 & 86) | (iMediaBrowserCompatMediaBrowserImpl7 ^ 86));
                                                byte b2 = (byte) ((i197 ^ i204) + ((i204 & i197) << 1) + (((i206 & i207) | (i206 ^ i207)) * 407));
                                                int bitsPerPixel = ImageFormat.getBitsPerPixel(0);
                                                Object[] objArr26 = new Object[1];
                                                b(b2, (bitsPerPixel & 12) + (bitsPerPixel | 12), new char[]{11, 20, 28, 0, 7, 20, 3, 27, 22, '!', 13882}, objArr26);
                                                try {
                                                    Object[] objArr27 = {new ByteArrayInputStream((byte[]) cls8.getMethod((String) objArr26[0], null).invoke(obj4, null))};
                                                    int i208 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                                    int i209 = i208 * 595;
                                                    WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0.MediaBrowserCompatMediaBrowserImpl();
                                                    WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0.MediaBrowserCompatMediaBrowserImpl();
                                                    int i210 = ((i209 | (-43919)) << 1) - (i209 ^ (-43919));
                                                    int i211 = ~i208;
                                                    int i212 = ~((i211 & 37) | (i211 ^ 37));
                                                    int i213 = ~((i21 ^ 37) | (i21 & 37));
                                                    int i214 = -(-(((i212 & i213) | (i212 ^ i213)) * (-1188)));
                                                    int i215 = (i210 & i214) + (i214 | i210);
                                                    int i216 = ~i208;
                                                    int i217 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i218 = ((i217 | 123) << 1) - (i217 ^ 123);
                                                    artificialFrame = i218 % 128;
                                                    int i219 = i218 % 2;
                                                    int i220 = ~((i216 & 37) | (i216 ^ 37));
                                                    int i221 = ~(((-38) & i) | ((-38) ^ i));
                                                    int i222 = (i220 & i221) | (i220 ^ i221);
                                                    int i223 = ~(i21 | i208);
                                                    int i224 = 594 * ((i222 & i223) | (i222 ^ i223));
                                                    int i225 = (i215 & i224) + (i215 | i224);
                                                    int i226 = ((-38) ^ i18) | ((-38) & i18);
                                                    int i227 = (i217 ^ b.f40o) + ((i217 & b.f40o) << 1);
                                                    artificialFrame = i227 % 128;
                                                    if (i227 % 2 == 0) {
                                                        int i228 = ~i226;
                                                        int i229 = ~(((-38) & i208) | ((-38) ^ i208));
                                                        int i230 = (i229 & i228) | (i228 ^ i229);
                                                        int i231 = ~((i208 & i21) | (i21 ^ i208));
                                                        Object[] objArr28 = new Object[1];
                                                        a(i225 / (594 % ((i231 & i230) | (i230 ^ i231))), new char[]{18122, 11228, 48397, 34001, 37027, 52168, 11381, 42142, 39913, 36056, 15000, 58797, 13407, 26960, 4925, 41638, 30283, 16537, 36389, 3298, 20456, 42972, 55038, 24093, 11864, 21063, 63226, 1512, 16652, 36824, 57165, 62191, 58920, 38664, 3196, 12466, 23947, 31497}, objArr28);
                                                        cls = Class.forName((String) objArr28[0]);
                                                        i6 = 81;
                                                        zoomControlsTimeout = ViewConfiguration.getZoomControlsTimeout();
                                                    } else {
                                                        int i232 = ~i226;
                                                        int i233 = ~(((-38) & i208) | ((-38) ^ i208));
                                                        Object[] objArr29 = new Object[1];
                                                        a(i225 + (((~((i208 & i18) | (i18 ^ i208))) | (i233 & i232) | (i232 ^ i233)) * 594), new char[]{18122, 11228, 48397, 34001, 37027, 52168, 11381, 42142, 39913, 36056, 15000, 58797, 13407, 26960, 4925, 41638, 30283, 16537, 36389, 3298, 20456, 42972, 55038, 24093, 11864, 21063, 63226, 1512, 16652, 36824, 57165, 62191, 58920, 38664, 3196, 12466, 23947, 31497}, objArr29);
                                                        cls = Class.forName((String) objArr29[0]);
                                                        zoomControlsTimeout = ViewConfiguration.getZoomControlsTimeout();
                                                        i6 = 69;
                                                    }
                                                    int i234 = -(zoomControlsTimeout > 0L ? 1 : (zoomControlsTimeout == 0L ? 0 : -1));
                                                    int iMediaBrowserCompatMediaBrowserImpl8 = WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0.MediaBrowserCompatMediaBrowserImpl();
                                                    int i235 = ((i234 * 70) - (~(i6 * (-68)))) - 1;
                                                    int i236 = ~i234;
                                                    int i237 = ~i6;
                                                    int i238 = (i236 ^ i237) | (i237 & i236);
                                                    int i239 = ~((i238 ^ iMediaBrowserCompatMediaBrowserImpl8) | (i238 & iMediaBrowserCompatMediaBrowserImpl8));
                                                    int i240 = (i234 ^ i6) | (i234 & i6);
                                                    int i241 = ~((i240 ^ iMediaBrowserCompatMediaBrowserImpl8) | (i240 & iMediaBrowserCompatMediaBrowserImpl8));
                                                    int i242 = ((i239 ^ i241) | (i241 & i239)) * 69;
                                                    int i243 = (i235 & i242) + (i242 | i235);
                                                    int i244 = ~((i236 ^ i6) | (i236 & i6));
                                                    int i245 = ~i234;
                                                    int i246 = getARTIFICIAL_FRAME_PACKAGE_NAME + 51;
                                                    int i247 = i21;
                                                    artificialFrame = i246 % 128;
                                                    int i248 = i246 % 2;
                                                    int i249 = ~((i245 & iMediaBrowserCompatMediaBrowserImpl8) | (i245 ^ iMediaBrowserCompatMediaBrowserImpl8));
                                                    int i250 = (i249 & i244) | (i244 ^ i249);
                                                    int i251 = ~((i6 ^ iMediaBrowserCompatMediaBrowserImpl8) | (iMediaBrowserCompatMediaBrowserImpl8 & i6));
                                                    int i252 = (i243 - (~(-(-((-69) * ((i250 & i251) | (i250 ^ i251))))))) - 1;
                                                    int i253 = ~i6;
                                                    byte b3 = (byte) (i252 + ((~((i253 & i234) | (i253 ^ i234))) * 69));
                                                    int i254 = 17 - (~(-(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)))));
                                                    char[] cArr2 = {7, 25, 31, 23, 22, '!', 7, 20, 31, 18, 20, '\t', CharUtils.CR, '\f', 14, 18, ' ', '\n', 13891};
                                                    int i255 = artificialFrame + 61;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i255 % 128;
                                                    int i256 = i255 % 2;
                                                    Object[] objArr30 = new Object[1];
                                                    b(b3, i254, cArr2, objArr30);
                                                    Object objInvoke4 = cls.getMethod((String) objArr30[0], InputStream.class).invoke(objInvoke3, objArr27);
                                                    int length2 = objArr3.length;
                                                    int i257 = 0;
                                                    while (i257 < 2) {
                                                        int i258 = getARTIFICIAL_FRAME_PACKAGE_NAME + 15;
                                                        artificialFrame = i258 % 128;
                                                        if (i258 % 2 == 0) {
                                                            obj = objArr3[i257];
                                                            int i259 = 7 / 0;
                                                        } else {
                                                            obj = objArr3[i257];
                                                        }
                                                        try {
                                                            int i260 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                                            Object[] objArr31 = new Object[1];
                                                            a(((i260 | 34) << 1) - (i260 ^ 34), new char[]{18122, 11228, 48397, 34001, 37027, 52168, 11381, 42142, 39913, 36056, 15000, 58797, 13407, 26960, 4925, 41638, 30283, 16537, 16934, 52477, 310, 3016, 42218, 45430, 20456, 42972, 55038, 24093, 11864, 21063, 63226, 1512, 16652, 36824}, objArr31);
                                                            Class<?> cls9 = Class.forName((String) objArr31[0]);
                                                            int i261 = -TextUtils.indexOf("", "");
                                                            int iMediaBrowserCompatMediaBrowserImpl9 = WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0.MediaBrowserCompatMediaBrowserImpl();
                                                            int i262 = (i261 * 471) + 10833;
                                                            int i263 = artificialFrame;
                                                            int i264 = ((i263 | 113) << 1) - (i263 ^ 113);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i264 % 128;
                                                            int i265 = i264 % 2;
                                                            int i266 = -(-((-470) * ((i261 ^ 23) | (i261 & 23))));
                                                            int i267 = (i262 & i266) + (i262 | i266);
                                                            int i268 = ~((~i261) | (-24));
                                                            int i269 = ~(((-24) ^ iMediaBrowserCompatMediaBrowserImpl9) | ((-24) & iMediaBrowserCompatMediaBrowserImpl9));
                                                            int i270 = (i268 ^ i269) | (i268 & i269);
                                                            int i271 = ~iMediaBrowserCompatMediaBrowserImpl9;
                                                            int i272 = (i271 ^ i261) | (i271 & i261);
                                                            int i273 = ~((i272 ^ 23) | (i272 & 23));
                                                            int i274 = i267 + (((i270 ^ i273) | (i270 & i273)) * (-470));
                                                            int i275 = ((-24) ^ i261) | ((-24) & i261);
                                                            int i276 = ~((i275 & iMediaBrowserCompatMediaBrowserImpl9) | (i275 ^ iMediaBrowserCompatMediaBrowserImpl9));
                                                            int i277 = ~iMediaBrowserCompatMediaBrowserImpl9;
                                                            int i278 = (i261 & i277) | (i277 ^ i261);
                                                            int i279 = ~((i278 & 23) | (i278 ^ 23));
                                                            int i280 = ((i279 & i276) | (i276 ^ i279)) * 470;
                                                            Object[] objArr32 = new Object[1];
                                                            a(((i274 | i280) << 1) - (i280 ^ i274), new char[]{65151, 54867, 62289, 24562, 31658, 19108, 13995, 47908, 58920, 38664, 8567, 51744, 64836, 15977, 9779, 30205, 46476, 32885, 18272, 9774, 43302, 53916, 1299, 24550}, objArr32);
                                                            if (obj.equals(cls9.getMethod((String) objArr32[0], null).invoke(objInvoke4, null))) {
                                                                Object[] objArr33 = {new int[]{i}, new int[]{i ^ 1}, new int[1], null};
                                                                int i281 = (-1001025590) + (((~((-589338048) | i18)) | (~((-389285728) | i))) * 1900) + (((~(i18 | 389285727)) | (~(i | 589338047))) * (-950)) + (((~(389285727 | i)) | (~(i18 | 589338047))) * 950);
                                                                int iMediaBrowserCompatMediaBrowserImpl10 = WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0.MediaBrowserCompatMediaBrowserImpl();
                                                                int i282 = -(-(i281 * (-183)));
                                                                int i283 = ((-2928) & i282) + (i282 | (-2928));
                                                                int i284 = ~iMediaBrowserCompatMediaBrowserImpl10;
                                                                int i285 = ((-17) ^ i284) | ((-17) & i284);
                                                                int i286 = ~((i285 & i281) | (i285 ^ i281));
                                                                int i287 = ~i281;
                                                                int i288 = ~iMediaBrowserCompatMediaBrowserImpl10;
                                                                int i289 = i287 | i288;
                                                                int i290 = (i289 & 16) | (i289 ^ 16);
                                                                int i291 = getARTIFICIAL_FRAME_PACKAGE_NAME + 1;
                                                                artificialFrame = i291 % 128;
                                                                if (i291 % 2 == 0) {
                                                                    int i292 = ~i290;
                                                                    i8 = i283 >> ((-184) % ((i292 & i286) | (i286 ^ i292)));
                                                                    int i293 = ~(((-17) ^ i287) | ((-17) & i287));
                                                                    int i294 = ~(((-17) & i288) | ((-17) ^ i288));
                                                                    i7 = (i293 & i294) | (i293 ^ i294);
                                                                } else {
                                                                    int i295 = ~i290;
                                                                    int i296 = (i283 - (~(((i286 & i295) | (i286 ^ i295)) * (-184)))) - 1;
                                                                    i7 = (~(((-17) & i287) | ((-17) ^ i287))) | (~(i284 | (-17)));
                                                                    i8 = i296;
                                                                }
                                                                int i297 = ~(i288 | (~i281));
                                                                int i298 = (i8 - (~(-(-(SyslogConstants.LOG_LOCAL7 * ((i297 & i7) | (i7 ^ i297))))))) - 1;
                                                                int i299 = -(-(((16 & i281) | (16 ^ i281)) * SyslogConstants.LOG_LOCAL7));
                                                                int i300 = i2 + (i298 ^ i299) + ((i299 & i298) << 1);
                                                                int i301 = i300 << 13;
                                                                int i302 = ((~i300) & i301) | ((~i301) & i300);
                                                                int i303 = i302 ^ (i302 >>> 17);
                                                                int i304 = i303 << 5;
                                                                ((int[]) objArr33[2])[0] = (i303 | i304) & (~(i303 & i304));
                                                                return objArr33;
                                                            }
                                                            i257++;
                                                            int i305 = artificialFrame;
                                                            int i306 = (i305 ^ 93) + ((i305 & 93) << 1);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i306 % 128;
                                                            int i307 = i306 % 2;
                                                        } catch (Throwable th) {
                                                            Throwable cause = th.getCause();
                                                            if (cause != null) {
                                                                throw cause;
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    i155++;
                                                    objArr19 = objArr23;
                                                    i21 = i247;
                                                    length = i177;
                                                    i28 = 0;
                                                    i13 = 1;
                                                } catch (Throwable th2) {
                                                    Throwable cause2 = th2.getCause();
                                                    if (cause2 != null) {
                                                        throw cause2;
                                                    }
                                                    throw th2;
                                                }
                                            } catch (Throwable th3) {
                                                Throwable cause3 = th3.getCause();
                                                if (cause3 != null) {
                                                    throw cause3;
                                                }
                                                throw th3;
                                            }
                                        } catch (Throwable th4) {
                                            Throwable cause4 = th4.getCause();
                                            if (cause4 != null) {
                                                throw cause4;
                                            }
                                            throw th4;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 != null) {
                                        throw cause5;
                                    }
                                    throw th5;
                                }
                            } catch (Throwable th6) {
                                Throwable cause6 = th6.getCause();
                                if (cause6 != null) {
                                    throw cause6;
                                }
                                throw th6;
                            }
                        } catch (Throwable th7) {
                            Throwable cause7 = th7.getCause();
                            if (cause7 != null) {
                                throw cause7;
                            }
                            throw th7;
                        }
                    } catch (Throwable th8) {
                        Throwable cause8 = th8.getCause();
                        if (cause8 != null) {
                            throw cause8;
                        }
                        throw th8;
                    }
                } catch (Throwable th9) {
                    Throwable cause9 = th9.getCause();
                    if (cause9 != null) {
                        throw cause9;
                    }
                    throw th9;
                }
            } catch (Throwable unused) {
            }
            Object[] objArr34 = {new int[]{i}, new int[]{i}, new int[1], null};
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i308 = ~iElapsedRealtime;
            int i309 = (-2099563466) + (((~(i308 | (-55939997))) | 1034563771) * (-1042)) + (((-55939997) | iElapsedRealtime) * 521) + (((~(iElapsedRealtime | (-1034563772))) | 1017782307 | (~(i308 | (-39158533)))) * 521);
            int i310 = i309 * (-667);
            int i311 = ~i309;
            int i312 = -(-(((~i) | i311) * (-668)));
            int i313 = (i310 ^ i312) + ((i310 & i312) << 1);
            int i314 = -(-((~((i311 ^ i) | (i311 & i))) * 1336));
            int i315 = (i313 ^ i314) + ((i314 & i313) << 1);
            int i316 = ~i309;
            int i317 = ((i316 & i) | (i ^ i316)) * 668;
            int i318 = (i315 ^ i317) + ((i317 & i315) << 1);
            int i319 = ((i2 | i318) << 1) - (i2 ^ i318);
            int i320 = i319 << 13;
            int i321 = (i320 | i319) & (~(i319 & i320));
            int i322 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i323 = (i322 ^ b.f40o) + ((i322 & b.f40o) << 1);
            artificialFrame = i323 % 128;
            int i324 = i323 % 2;
            int i325 = i321 >>> 17;
            int i326 = ((~i321) & i325) | ((~i325) & i321);
            int i327 = i326 << 5;
            ((int[]) objArr34[2])[0] = ((~i326) & i327) | ((~i327) & i326);
            int iMediaBrowserCompatMediaBrowserImpl11 = WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0.MediaBrowserCompatMediaBrowserImpl();
            int i328 = 140912441 | iMediaBrowserCompatMediaBrowserImpl11;
            int i329 = 1008876244 + (((i328 & 269588484) | (i328 ^ 269588484)) * 376);
            int i330 = ~iMediaBrowserCompatMediaBrowserImpl11;
            int i331 = ~((i330 & 761669497) | (i330 ^ 761669497));
            int i332 = -(-(((i331 & 269588484) | (i331 ^ 269588484)) * (-376)));
            int i333 = (i329 ^ i332) + ((i332 & i329) << 1);
            int i334 = ~((iMediaBrowserCompatMediaBrowserImpl11 & (-761669498)) | ((-761669498) ^ iMediaBrowserCompatMediaBrowserImpl11));
            int i335 = ((i334 & (-890345541)) | ((-890345541) ^ i334)) * 376;
            int i336 = (i333 & i335) + (i335 | i333);
            int i337 = -(-(((-2144992639) | i18) * 1324));
            int i338 = ((133581176 | i337) << 1) - (i337 ^ 133581176);
            int i339 = ~(((-1771167101) & i) | ((-1771167101) ^ i));
            int i340 = ~((i & (-2010685467)) | ((-2010685467) ^ i));
            int i341 = ((i340 & i339) | (i339 ^ i340)) * (-1324);
            int i342 = ((i338 | i341) << 1) - (i341 ^ i338);
            if (i336 <= (i342 & 1376404932) + (1376404932 | i342)) {
                return objArr34;
            }
            int i343 = 5 / 3;
            return objArr34;
        }
    }

    public String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.executor + "}";
    }
}
