package com.google.common.util.concurrent;

import android.graphics.Color;
import android.media.AudioTrack;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import o.ArtificialStackFrames;
import o.extraCallback;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractScheduledService implements Service {
    private static final Logger logger = Logger.getLogger(AbstractScheduledService.class.getName());
    private final AbstractService delegate = new ServiceDelegate();

    interface Cancellable {
        void cancel(boolean z);

        boolean isCancelled();
    }

    protected abstract void runOneIteration() throws Exception;

    protected abstract Scheduler scheduler();

    protected void shutDown() throws Exception {
    }

    protected void startUp() throws Exception {
    }

    public static abstract class Scheduler {
        abstract Cancellable schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable);

        public static Scheduler newFixedDelaySchedule(final long j, final long j2, final TimeUnit timeUnit) {
            Preconditions.checkNotNull(timeUnit);
            Preconditions.checkArgument(j2 > 0, "delay must be > 0, found %s", j2);
            return new Scheduler() { // from class: com.google.common.util.concurrent.AbstractScheduledService.Scheduler.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
                public Cancellable schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return new FutureAsCancellable(scheduledExecutorService.scheduleWithFixedDelay(runnable, j, j2, timeUnit));
                }
            };
        }

        public static Scheduler newFixedRateSchedule(final long j, final long j2, final TimeUnit timeUnit) {
            Preconditions.checkNotNull(timeUnit);
            Preconditions.checkArgument(j2 > 0, "period must be > 0, found %s", j2);
            return new Scheduler() { // from class: com.google.common.util.concurrent.AbstractScheduledService.Scheduler.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
                public Cancellable schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return new FutureAsCancellable(scheduledExecutorService.scheduleAtFixedRate(runnable, j, j2, timeUnit));
                }
            };
        }

        private Scheduler() {
        }
    }

    final class ServiceDelegate extends AbstractService {

        @CheckForNull
        private volatile ScheduledExecutorService executorService;
        private final ReentrantLock lock;

        @CheckForNull
        private volatile Cancellable runningTask;
        private final Runnable task;

        private ServiceDelegate() {
            this.lock = new ReentrantLock();
            this.task = new Task();
        }

        class Task implements Runnable {
            Task() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ServiceDelegate.this.lock.lock();
                try {
                    Cancellable cancellable = ServiceDelegate.this.runningTask;
                    Objects.requireNonNull(cancellable);
                    if (cancellable.isCancelled()) {
                        ServiceDelegate.this.lock.unlock();
                        return;
                    }
                    AbstractScheduledService.this.runOneIteration();
                } catch (Throwable th) {
                    try {
                        try {
                            AbstractScheduledService.this.shutDown();
                        } catch (Exception e) {
                            AbstractScheduledService.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e);
                        }
                        ServiceDelegate.this.notifyFailed(th);
                        Cancellable cancellable2 = ServiceDelegate.this.runningTask;
                        Objects.requireNonNull(cancellable2);
                        cancellable2.cancel(false);
                    } finally {
                        ServiceDelegate.this.lock.unlock();
                    }
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStart() {
            this.executorService = MoreExecutors.renamingDecorator(AbstractScheduledService.this.executor(), new Supplier<String>() { // from class: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.1
                @Override // com.google.common.base.Supplier
                public String get() {
                    String strServiceName = AbstractScheduledService.this.serviceName();
                    String strValueOf = String.valueOf(ServiceDelegate.this.state());
                    StringBuilder sb = new StringBuilder(String.valueOf(strServiceName).length() + 1 + strValueOf.length());
                    sb.append(strServiceName);
                    sb.append(StringUtils.SPACE);
                    sb.append(strValueOf);
                    return sb.toString();
                }
            });
            this.executorService.execute(new Runnable() { // from class: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.2
                @Override // java.lang.Runnable
                public void run() {
                    ServiceDelegate.this.lock.lock();
                    try {
                        AbstractScheduledService.this.startUp();
                        ServiceDelegate serviceDelegate = ServiceDelegate.this;
                        serviceDelegate.runningTask = AbstractScheduledService.this.scheduler().schedule(AbstractScheduledService.this.delegate, ServiceDelegate.this.executorService, ServiceDelegate.this.task);
                        ServiceDelegate.this.notifyStarted();
                    } catch (Throwable th) {
                        try {
                            ServiceDelegate.this.notifyFailed(th);
                            if (ServiceDelegate.this.runningTask != null) {
                                ServiceDelegate.this.runningTask.cancel(false);
                            }
                        } finally {
                            ServiceDelegate.this.lock.unlock();
                        }
                    }
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStop() {
            Objects.requireNonNull(this.runningTask);
            Objects.requireNonNull(this.executorService);
            this.runningTask.cancel(false);
            this.executorService.execute(new Runnable() { // from class: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ServiceDelegate.this.lock.lock();
                        try {
                            if (ServiceDelegate.this.state() != Service.State.STOPPING) {
                                ServiceDelegate.this.lock.unlock();
                                return;
                            }
                            AbstractScheduledService.this.shutDown();
                            ServiceDelegate.this.lock.unlock();
                            ServiceDelegate.this.notifyStopped();
                        } catch (Throwable th) {
                            ServiceDelegate.this.lock.unlock();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        ServiceDelegate.this.notifyFailed(th2);
                    }
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractScheduledService.this.toString();
        }
    }

    public static abstract class CustomScheduler extends Scheduler {
        protected abstract Schedule getNextSchedule() throws Exception;

        public static final class Schedule {
            private final long delay;
            private final TimeUnit unit;
            private static final byte[] $$c = {Ascii.RS, -66, -95, 114};
            private static final int $$d = 252;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {Ascii.FS, 50, 106, -64, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, 50, Ascii.SO, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4, -50};
            private static final int $$b = 58;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static char[] ArtificialStackFrames = {44393, 44385, 44390, 44396, 44389, 44699, 44403, 44335, 44400, 44395, 44701, 44697, 44703, 44398, 44384, 44404, 44388, 44402, 44333, 44408, 44334, 44397, 44337, 44399, 44690, 44361, 44353, 44355, 44698, 44696, 44700, 44386, 44405, 44391, 44387, 44702};
            private static char coroutineCreation = 39068;

            /* JADX WARN: Code duplicated, block: B:10:0x0023  */
            /* JADX WARN: Code duplicated, block: B:8:0x001c  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0027). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(int r5, short r6, byte r7) {
                /*
                    int r7 = r7 + 4
                    byte[] r0 = com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.Schedule.$$c
                    int r6 = r6 * 4
                    int r1 = r6 + 1
                    int r5 = 105 - r5
                    byte[] r1 = new byte[r1]
                    r2 = -1
                    if (r0 != 0) goto L12
                    r3 = r6
                    r5 = r7
                    goto L27
                L12:
                    r4 = r7
                    r7 = r5
                    r5 = r4
                L15:
                    int r2 = r2 + 1
                    byte r3 = (byte) r7
                    r1[r2] = r3
                    if (r2 != r6) goto L23
                    java.lang.String r5 = new java.lang.String
                    r6 = 0
                    r5.<init>(r1, r6)
                    return r5
                L23:
                    int r5 = r5 + 1
                    r3 = r0[r5]
                L27:
                    int r7 = r7 + r3
                    goto L15
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.Schedule.$$e(int, short, byte):java.lang.String");
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0022  */
            /* JADX WARN: Code duplicated, block: B:8:0x001a  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0026). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void b(short r5, byte r6, short r7, java.lang.Object[] r8) {
                /*
                    int r7 = r7 + 66
                    int r0 = 28 - r6
                    int r5 = 70 - r5
                    byte[] r1 = com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.Schedule.$$a
                    byte[] r0 = new byte[r0]
                    int r6 = 27 - r6
                    r2 = 0
                    if (r1 != 0) goto L12
                    r4 = r6
                    r3 = r2
                    goto L26
                L12:
                    r3 = r2
                L13:
                    byte r4 = (byte) r7
                    int r5 = r5 + 1
                    r0[r3] = r4
                    if (r3 != r6) goto L22
                    java.lang.String r5 = new java.lang.String
                    r5.<init>(r0, r2)
                    r8[r2] = r5
                    return
                L22:
                    r4 = r1[r5]
                    int r3 = r3 + 1
                L26:
                    int r7 = r7 + r4
                    int r7 = r7 + (-5)
                    goto L13
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.Schedule.b(short, byte, short, java.lang.Object[]):void");
            }

            private static void a(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
                int i2;
                char c;
                int i3 = 2;
                int i4 = 2 % 2;
                extraCallback extracallback = new extraCallback();
                char[] cArr2 = ArtificialStackFrames;
                int i5 = -1819279892;
                if (cArr2 != null) {
                    int length = cArr2.length;
                    char[] cArr3 = new char[length];
                    int i6 = 0;
                    while (i6 < length) {
                        int i7 = $10 + 67;
                        $11 = i7 % 128;
                        int i8 = i7 % i3;
                        try {
                            Object[] objArr2 = {Integer.valueOf(cArr2[i6])};
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                            if (objAccessartificialFrame == null) {
                                byte b2 = (byte) 0;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(KeyEvent.keyCodeFromString("") + 15, (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 20488), Color.rgb(0, 0, 0) + 16779364, 216710116, false, $$e((byte) ($$d & 10), b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE});
                            }
                            cArr3[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            i6++;
                            i3 = 2;
                            i5 = -1819279892;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    cArr2 = cArr3;
                }
                Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(16 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (Color.argb(0, 0, 0, 0) + 20488), 2148 - TextUtils.indexOf("", "", 0, 0), 216710116, false, $$e((byte) ($$d & 10), b3, (byte) (b3 - 1)), new Class[]{Integer.TYPE});
                }
                char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                char[] cArr4 = new char[i];
                char c2 = 7;
                if (i % 2 != 0) {
                    int i9 = $10 + 7;
                    $11 = i9 % 128;
                    if (i9 % 2 == 0) {
                        i2 = i + 62;
                        cArr4[i2] = (char) (cArr[i2] % b);
                    } else {
                        i2 = i - 1;
                        cArr4[i2] = (char) (cArr[i2] - b);
                    }
                } else {
                    i2 = i;
                }
                if (i2 > 1) {
                    int i10 = $10 + 67;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                    extracallback.a = 0;
                    while (extracallback.a < i2) {
                        extracallback.createBrowser = cArr[extracallback.a];
                        extracallback.c = cArr[extracallback.a + 1];
                        if (extracallback.createBrowser == extracallback.c) {
                            int i12 = $10 + 89;
                            $11 = i12 % 128;
                            if (i12 % 2 == 0) {
                                cArr4[extracallback.a] = (char) (extracallback.createBrowser << b);
                                cArr4[extracallback.a] = (char) (extracallback.c % b);
                            } else {
                                cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                                cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                            }
                            c = c2;
                        } else {
                            Object[] objArr4 = new Object[13];
                            objArr4[12] = extracallback;
                            objArr4[11] = Integer.valueOf(cCharValue);
                            objArr4[10] = extracallback;
                            objArr4[9] = extracallback;
                            objArr4[8] = Integer.valueOf(cCharValue);
                            objArr4[c2] = extracallback;
                            objArr4[6] = extracallback;
                            objArr4[5] = Integer.valueOf(cCharValue);
                            objArr4[4] = extracallback;
                            objArr4[3] = extracallback;
                            objArr4[2] = Integer.valueOf(cCharValue);
                            objArr4[1] = extracallback;
                            objArr4[0] = extracallback;
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                            if (objAccessartificialFrame3 == null) {
                                byte b4 = (byte) 3;
                                byte b5 = (byte) (b4 - 3);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(47 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (58859 - TextUtils.indexOf("", "", 0, 0)), Color.rgb(0, 0, 0) + 16779680, 276640984, false, $$e(b4, b5, (byte) (b5 - 1)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                            }
                            if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                                Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                if (objAccessartificialFrame4 == null) {
                                    int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 24;
                                    char c3 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                    int iRgb = (-16776424) - Color.rgb(0, 0, 0);
                                    byte b6 = (byte) 0;
                                    byte b7 = b6;
                                    String str$$e = $$e(b6, b7, (byte) (b7 - 1));
                                    c = 7;
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, c3, iRgb, -834291897, false, str$$e, new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                } else {
                                    c = 7;
                                }
                                int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                                int i13 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[iIntValue];
                                cArr4[extracallback.a + 1] = cArr2[i13];
                            } else {
                                c = 7;
                                if (extracallback.b == extracallback.d) {
                                    extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                    extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                    int i14 = (extracallback.b * cCharValue) + extracallback.j;
                                    int i15 = (extracallback.d * cCharValue) + extracallback.g;
                                    cArr4[extracallback.a] = cArr2[i14];
                                    cArr4[extracallback.a + 1] = cArr2[i15];
                                } else {
                                    int i16 = (extracallback.b * cCharValue) + extracallback.g;
                                    int i17 = (extracallback.d * cCharValue) + extracallback.j;
                                    cArr4[extracallback.a] = cArr2[i16];
                                    cArr4[extracallback.a + 1] = cArr2[i17];
                                }
                            }
                        }
                        extracallback.a += 2;
                        c2 = c;
                    }
                }
                for (int i18 = 0; i18 < i; i18++) {
                    cArr4[i18] = (char) (cArr4[i18] ^ 13722);
                }
                objArr[0] = new String(cArr4);
            }

            public Schedule(long j, TimeUnit timeUnit) {
                this.delay = j;
                this.unit = (TimeUnit) Preconditions.checkNotNull(timeUnit);
            }

            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r30, int r31, int r32, int r33) {
                /*
                    Method dump skipped, instruction units count: 3315
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.Schedule.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
            }
        }

        public CustomScheduler() {
            super();
        }

        final class ReschedulableCallable implements Callable<Void> {

            @CheckForNull
            private SupplantableFuture cancellationDelegate;
            private final ScheduledExecutorService executor;
            private final ReentrantLock lock = new ReentrantLock();
            private final AbstractService service;
            private final Runnable wrappedRunnable;

            ReschedulableCallable(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                this.wrappedRunnable = runnable;
                this.executor = scheduledExecutorService;
                this.service = abstractService;
            }

            @Override // java.util.concurrent.Callable
            @CheckForNull
            public Void call() throws Exception {
                this.wrappedRunnable.run();
                reschedule();
                return null;
            }

            public Cancellable reschedule() {
                Cancellable futureAsCancellable;
                try {
                    Schedule nextSchedule = CustomScheduler.this.getNextSchedule();
                    this.lock.lock();
                    try {
                        futureAsCancellable = initializeOrUpdateCancellationDelegate(nextSchedule);
                        this.lock.unlock();
                        th = null;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            futureAsCancellable = new FutureAsCancellable(Futures.immediateCancelledFuture());
                            this.lock.unlock();
                        } catch (Throwable th2) {
                            this.lock.unlock();
                            throw th2;
                        }
                    }
                    if (th != null) {
                        this.service.notifyFailed(th);
                    }
                    return futureAsCancellable;
                } catch (Throwable th3) {
                    this.service.notifyFailed(th3);
                    return new FutureAsCancellable(Futures.immediateCancelledFuture());
                }
            }

            private Cancellable initializeOrUpdateCancellationDelegate(Schedule schedule) {
                SupplantableFuture supplantableFuture = this.cancellationDelegate;
                if (supplantableFuture == null) {
                    SupplantableFuture supplantableFuture2 = new SupplantableFuture(this.lock, submitToExecutor(schedule));
                    this.cancellationDelegate = supplantableFuture2;
                    return supplantableFuture2;
                }
                if (!supplantableFuture.currentFuture.isCancelled()) {
                    this.cancellationDelegate.currentFuture = submitToExecutor(schedule);
                }
                return this.cancellationDelegate;
            }

            private ScheduledFuture<Void> submitToExecutor(Schedule schedule) {
                return this.executor.schedule(this, schedule.delay, schedule.unit);
            }
        }

        static final class SupplantableFuture implements Cancellable {
            private Future<Void> currentFuture;
            private final ReentrantLock lock;

            SupplantableFuture(ReentrantLock reentrantLock, Future<Void> future) {
                this.lock = reentrantLock;
                this.currentFuture = future;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
            public void cancel(boolean z) {
                this.lock.lock();
                try {
                    this.currentFuture.cancel(z);
                } finally {
                    this.lock.unlock();
                }
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
            public boolean isCancelled() {
                this.lock.lock();
                try {
                    return this.currentFuture.isCancelled();
                } finally {
                    this.lock.unlock();
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
        final Cancellable schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
            return new ReschedulableCallable(abstractService, scheduledExecutorService, runnable).reschedule();
        }
    }

    protected AbstractScheduledService() {
    }

    protected ScheduledExecutorService executor() {
        final ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.google.common.util.concurrent.AbstractScheduledService.1ThreadFactoryImpl
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return MoreExecutors.newThread(AbstractScheduledService.this.serviceName(), runnable);
            }
        });
        addListener(new Service.Listener(this) { // from class: com.google.common.util.concurrent.AbstractScheduledService.1
            @Override // com.google.common.util.concurrent.Service.Listener
            public void terminated(Service.State state) {
                scheduledExecutorServiceNewSingleThreadScheduledExecutor.shutdown();
            }

            @Override // com.google.common.util.concurrent.Service.Listener
            public void failed(Service.State state, Throwable th) {
                scheduledExecutorServiceNewSingleThreadScheduledExecutor.shutdown();
            }
        }, MoreExecutors.directExecutor());
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    protected String serviceName() {
        return getClass().getSimpleName();
    }

    public String toString() {
        String strServiceName = serviceName();
        String strValueOf = String.valueOf(state());
        StringBuilder sb = new StringBuilder(String.valueOf(strServiceName).length() + 3 + strValueOf.length());
        sb.append(strServiceName);
        sb.append(" [");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitRunning(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitTerminated(j, timeUnit);
    }

    static final class FutureAsCancellable implements Cancellable {
        private final Future<?> delegate;

        FutureAsCancellable(Future<?> future) {
            this.delegate = future;
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
        public void cancel(boolean z) {
            this.delegate.cancel(z);
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }
    }
}
