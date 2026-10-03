package com.facebook.bolts;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.asBinder;
import o.extraCallback;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class AndroidExecutors {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    public static final Companion Companion = new Companion(null);
    private static final AndroidExecutors INSTANCE = new AndroidExecutors();
    private static final long KEEP_ALIVE_TIME = 1;
    private static final int MAX_POOL_SIZE;
    private final Executor uiThread = new UIThreadExecutor();

    @JvmStatic
    public static final ExecutorService newCachedThreadPool() {
        return Companion.newCachedThreadPool();
    }

    @JvmStatic
    public static final Executor uiThread() {
        return Companion.uiThread();
    }

    private AndroidExecutors() {
    }

    static final class UIThreadExecutor implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@NotNull Runnable command) {
            Intrinsics.checkNotNullParameter(command, "command");
            new Handler(Looper.getMainLooper()).post(command);
        }
    }

    public static final class Companion {
        private static final byte[] $$c = {70, -54, 7, 50};
        private static final int $$d = 24;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {5, -37, 48, 84, -12, -6, Ascii.ESC, -22, -26, 4, -12, 0, -8, -2, -8};
        private static final int $$b = 238;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] ArtificialStackFrames = {39071, 44372, 44373, 44374, 44355, 44339, 44409, 44362, 39059, 44359, 44408, 44364, 44360, 44342, 44343, 44385, 44361, 44366, 44368, 44388, 44333, 44340, 44387, 39067, 44353, 44391, 39062, 44371, 39058, 44345, 44399, 44358, 44356, 44406, 44403, 39057, 44407, 39056, 44394, 44389, 44393, 44365, 44397, 44334, 44363, 44337, 39065, 44400, 44354, 44405, 39068, 44404, 44398, 44396, 44390, 44357, 44341, 44402, 39064, 44344, 39069, 44338, 44395, 39070};
        private static char coroutineCreation = 39058;
        private static long extraCommand = 8903649741308738242L;

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        /* JADX WARN: Code duplicated, block: B:8:0x001b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0025). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(short r5, byte r6, byte r7) {
            /*
                int r5 = 118 - r5
                byte[] r0 = com.facebook.bolts.AndroidExecutors.Companion.$$c
                int r7 = r7 * 2
                int r1 = r7 + 1
                int r6 = r6 * 4
                int r6 = 4 - r6
                byte[] r1 = new byte[r1]
                r2 = 0
                if (r0 != 0) goto L15
                r4 = r5
                r5 = r7
                r3 = r2
                goto L25
            L15:
                r3 = r2
            L16:
                byte r4 = (byte) r5
                r1[r3] = r4
                if (r3 != r7) goto L21
                java.lang.String r5 = new java.lang.String
                r5.<init>(r1, r2)
                return r5
            L21:
                int r3 = r3 + 1
                r4 = r0[r6]
            L25:
                int r5 = r5 + r4
                int r6 = r6 + 1
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.bolts.AndroidExecutors.Companion.$$e(short, byte, byte):java.lang.String");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0028  */
        /* JADX WARN: Code duplicated, block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void b(short r5, byte r6, byte r7, java.lang.Object[] r8) {
            /*
                int r7 = r7 * 8
                int r7 = r7 + 4
                int r6 = r6 * 5
                int r0 = 9 - r6
                byte[] r1 = com.facebook.bolts.AndroidExecutors.Companion.$$a
                int r5 = r5 * 3
                int r5 = r5 + 112
                byte[] r0 = new byte[r0]
                int r6 = 8 - r6
                r2 = 0
                if (r1 != 0) goto L18
                r3 = r6
                r4 = r2
                goto L2a
            L18:
                r3 = r2
            L19:
                byte r4 = (byte) r5
                r0[r3] = r4
                int r4 = r3 + 1
                if (r3 != r6) goto L28
                java.lang.String r5 = new java.lang.String
                r5.<init>(r0, r2)
                r8[r2] = r5
                return
            L28:
                r3 = r1[r7]
            L2a:
                int r3 = -r3
                int r5 = r5 + r3
                int r5 = r5 + (-7)
                int r7 = r7 + 1
                r3 = r4
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.bolts.AndroidExecutors.Companion.b(short, byte, byte, java.lang.Object[]):void");
        }

        private Companion() {
        }

        @JvmStatic
        public final ExecutorService newCachedThreadPool() {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(AndroidExecutors.CORE_POOL_SIZE, AndroidExecutors.MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return threadPoolExecutor;
        }

        private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            asBinder asbinder = new asBinder();
            asbinder.c = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            asbinder.d = 0;
            while (asbinder.d < cArr.length) {
                int i3 = $11 + 79;
                $10 = i3 % 128;
                int i4 = i3 % 2;
                int i5 = asbinder.d;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - Color.blue(0), (char) Gravity.getAbsoluteGravity(0, 0), 1408 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 1035473698, false, $$e(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                    }
                    jArr[i5] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                    Object[] objArr3 = {asbinder, asbinder};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(View.combineMeasuredStates(0, 0) + 8, (char) Color.argb(0, 0, 0, 0), Process.getGidForName("") + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            char[] cArr2 = new char[length];
            asbinder.d = 0;
            while (asbinder.d < cArr.length) {
                int i6 = $10 + 65;
                $11 = i6 % 128;
                if (i6 % 2 == 0) {
                    cArr2[asbinder.d] = (char) jArr[asbinder.d];
                    Object[] objArr4 = {asbinder, asbinder};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame3 == null) {
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getEdgeSlop() >> 16) + 8, (char) TextUtils.indexOf("", ""), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 248, 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    throw null;
                }
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                Object[] objArr5 = {asbinder, asbinder};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - TextUtils.indexOf("", ""), (char) (Process.getGidForName("") + 1), TextUtils.indexOf((CharSequence) "", '0', 0) + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            objArr[0] = new String(cArr2);
        }

        @JvmStatic
        public final Executor uiThread() {
            return AndroidExecutors.INSTANCE.uiThread;
        }

        /* JADX WARN: Code duplicated, block: B:33:0x0120  */
        /* JADX WARN: Code duplicated, block: B:34:0x0140  */
        /* JADX WARN: Code duplicated, block: B:37:0x018a A[Catch: all -> 0x034f, TryCatch #0 {all -> 0x034f, blocks: (B:7:0x001e, B:9:0x002c, B:10:0x0065, B:14:0x007f, B:16:0x0090, B:17:0x00be, B:35:0x0142, B:37:0x018a, B:38:0x01fb, B:42:0x021b, B:44:0x0257, B:46:0x02be), top: B:63:0x001e }] */
        /* JADX WARN: Code duplicated, block: B:41:0x020e  */
        /* JADX WARN: Code duplicated, block: B:44:0x0257 A[Catch: all -> 0x034f, TryCatch #0 {all -> 0x034f, blocks: (B:7:0x001e, B:9:0x002c, B:10:0x0065, B:14:0x007f, B:16:0x0090, B:17:0x00be, B:35:0x0142, B:37:0x018a, B:38:0x01fb, B:42:0x021b, B:44:0x0257, B:46:0x02be), top: B:63:0x001e }] */
        /* JADX WARN: Code duplicated, block: B:45:0x02bd  */
        /* JADX WARN: Code duplicated, block: B:48:0x02df  */
        /* JADX WARN: Code duplicated, block: B:50:0x02e7  */
        /* JADX WARN: Code duplicated, block: B:51:0x0319  */
        private static void c(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
            int i2;
            Object[] objArr2;
            Object objAccessartificialFrame;
            Object objAccessartificialFrame2;
            int i3 = 2 % 2;
            extraCallback extracallback = new extraCallback();
            char[] cArr2 = ArtificialStackFrames;
            int i4 = -1819279892;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i5 = 0;
                while (i5 < length) {
                    try {
                        Object[] objArr3 = {Integer.valueOf(cArr2[i5])};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(i4);
                        if (objAccessartificialFrame3 == null) {
                            byte b2 = (byte) 0;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(14 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (20487 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), View.resolveSizeAndState(0, 0, 0) + 2148, 216710116, false, $$e((byte) ($$d - 3), b2, b2), new Class[]{Integer.TYPE});
                        }
                        cArr3[i5] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr3)).charValue();
                        i5++;
                        i4 = -1819279892;
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
            Object[] objArr4 = {Integer.valueOf(coroutineCreation)};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1819279892);
            if (objAccessartificialFrame4 == null) {
                byte b3 = (byte) 0;
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(15 - TextUtils.indexOf("", "", 0, 0), (char) (View.getDefaultSize(0, 0) + 20488), 2147 - ImageFormat.getBitsPerPixel(0), 216710116, false, $$e((byte) ($$d - 3), b3, b3), new Class[]{Integer.TYPE});
            }
            char cCharValue = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr4)).charValue();
            char[] cArr4 = new char[i];
            if (i % 2 != 0) {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            } else {
                i2 = i;
            }
            if (i2 > 1) {
                int i6 = $11 + 115;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                extracallback.a = 0;
                while (extracallback.a < i2) {
                    int i8 = $11 + 7;
                    $10 = i8 % 128;
                    if (i8 % 2 != 0) {
                        extracallback.createBrowser = cArr[extracallback.a];
                        extracallback.c = cArr[extracallback.a];
                        if (extracallback.createBrowser == extracallback.c) {
                            cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                            cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                            int i9 = $10 + 7;
                            $11 = i9 % 128;
                            int i10 = i9 % 2;
                        } else {
                            objArr2 = new Object[]{extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1894223152);
                            if (objAccessartificialFrame == null) {
                                byte b4 = (byte) 0;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Color.blue(0) + 46, (char) (58859 - KeyEvent.normalizeMetaState(0)), 2463 - ImageFormat.getBitsPerPixel(0), 276640984, false, $$e((byte) ($$d & 116), b4, b4), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                            }
                            if (((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue() == extracallback.g) {
                                int i11 = $10 + 9;
                                $11 = i11 % 128;
                                int i12 = i11 % 2;
                                Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                if (objAccessartificialFrame2 == null) {
                                    byte b5 = (byte) 0;
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 24, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 793 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), -834291897, false, $$e((byte) 13, b5, b5), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                }
                                int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr5)).intValue();
                                int i13 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[iIntValue];
                                cArr4[extracallback.a + 1] = cArr2[i13];
                            } else if (extracallback.b == extracallback.d) {
                                int i14 = $11 + b.f40o;
                                $10 = i14 % 128;
                                int i15 = i14 % 2;
                                extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                int i16 = (extracallback.b * cCharValue) + extracallback.j;
                                int i17 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[i16];
                                cArr4[extracallback.a + 1] = cArr2[i17];
                            } else {
                                int i18 = (extracallback.b * cCharValue) + extracallback.g;
                                int i19 = (extracallback.d * cCharValue) + extracallback.j;
                                cArr4[extracallback.a] = cArr2[i18];
                                cArr4[extracallback.a + 1] = cArr2[i19];
                            }
                        }
                    } else {
                        extracallback.createBrowser = cArr[extracallback.a];
                        extracallback.c = cArr[extracallback.a + 1];
                        if (extracallback.createBrowser == extracallback.c) {
                            cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                            cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                            int i20 = $10 + 7;
                            $11 = i20 % 128;
                            int i110 = i20 % 2;
                        } else {
                            objArr2 = new Object[]{extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1894223152);
                            if (objAccessartificialFrame == null) {
                                byte b6 = (byte) 0;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Color.blue(0) + 46, (char) (58859 - KeyEvent.normalizeMetaState(0)), 2463 - ImageFormat.getBitsPerPixel(0), 276640984, false, $$e((byte) ($$d & 116), b6, b6), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                            }
                            if (((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue() == extracallback.g) {
                                int i111 = $10 + 9;
                                $11 = i111 % 128;
                                int i112 = i111 % 2;
                                Object[] objArr6 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                if (objAccessartificialFrame2 == null) {
                                    byte b7 = (byte) 0;
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 24, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 793 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), -834291897, false, $$e((byte) 13, b7, b7), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                }
                                int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr6)).intValue();
                                int i113 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[iIntValue2];
                                cArr4[extracallback.a + 1] = cArr2[i113];
                            } else if (extracallback.b == extracallback.d) {
                                int i114 = $11 + b.f40o;
                                $10 = i114 % 128;
                                int i115 = i114 % 2;
                                extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                int i116 = (extracallback.b * cCharValue) + extracallback.j;
                                int i117 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[i116];
                                cArr4[extracallback.a + 1] = cArr2[i117];
                            } else {
                                int i118 = (extracallback.b * cCharValue) + extracallback.g;
                                int i119 = (extracallback.d * cCharValue) + extracallback.j;
                                cArr4[extracallback.a] = cArr2[i118];
                                cArr4[extracallback.a + 1] = cArr2[i119];
                            }
                        }
                    }
                    extracallback.a += 2;
                }
            }
            for (int i21 = 0; i21 < i; i21++) {
                cArr4[i21] = (char) (cArr4[i21] ^ 13722);
            }
            objArr[0] = new String(cArr4);
        }

        /*  JADX ERROR: Types fix failed
            jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 156841. Try increasing type updates limit count.
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:99)
            */
        public static java.lang.Object[] accessartificialFrame(android.content.Context r46, java.lang.String[] r47, int r48, int r49, int r50) {
            /*
                Method dump skipped, instruction units count: 15684
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.bolts.AndroidExecutors.Companion.accessartificialFrame(android.content.Context, java.lang.String[], int, int, int):java.lang.Object[]");
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = iAvailableProcessors;
        CORE_POOL_SIZE = iAvailableProcessors + 1;
        MAX_POOL_SIZE = (iAvailableProcessors * 2) + 1;
    }
}
