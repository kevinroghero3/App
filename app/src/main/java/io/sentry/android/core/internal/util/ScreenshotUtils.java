package io.sentry.android.core.internal.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.util.thread.IThreadChecker;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import o.ArtificialStackFrames;
import o._CREATION;
import o.onMessageChannelReady;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public class ScreenshotUtils {
    private static final long CAPTURE_TIMEOUT_MS = 1000;
    private static final byte[] $$c = {SignedBytes.MAX_POWER_OF_TWO, -32, 40, -103};
    private static final int $$d = 77;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {72, -88, 5, 32, -12, -6, Ascii.ESC, -22, -26, 4, -12, 0, -8, -2, -8};
    private static final int $$b = 9;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] validateRelationship = {55940, 55949, 56048, 55992, 56056, 55941, 56063, 55962, 55943, 55980, 56049, 55936, 55937, 56060, 56051, 55939, 56050, 56053, 55963, 55955, 55973, 56058, 55938, 55971, 55954, 56057, 56062, 55996, 55985, 55984, 55997, 55969, 55975, 55966, 55942, 55958, 55998, 55989, 55974, 56054, 56059, 55961, 55970, 55972};
    private static int warmup = -1044259986;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;
    private static char[] _CREATION = {6596, 6548, 51636, 47582, 26910, 22908, 2396, 63624, 43194, 39114, 18515, 14356, 59462, 56206, 35764, 6571, 51585, 47598, 26962, 22890, 6591, 51643, 47564, 26893, 22845, 2368, 63640, 43160, 39107, 18436, 14339, 59475, 56213, 35747, 31681, 43029, 30757, 2129, 55530, 59608, 47268, 18802, 6548, 51636, 47582, 26910, 22908, 2394, 63641, 43184, 39123, 18447, 14393, 59475, 56195, 35839, 31687, 11038, 6972, 52049, 47830, 27276, 23239, 2571, 64056, 43594, 40336, 19876, 15811, 60694, 56638, 36164, 31922, 11434, 7421, 52225, 48167, 27757, 24459, 59982, 14951, 18955, 39661, 43755, 64157, 2884, 23392, 27412, 48078, 51469, 6436, 26962, 47502, 35252, 55772, 10268, 30754, 18545, 39052, 59574, 14535, 2823, 23331, 43865, 64396, 52155, 7109, 27145, 55164, 1864, 30504, 42978, 38871, 51124, 13950, 26190, 22049, 34528, 63186, 9914, 5496, 17747, 46374, 58874, 54724, 1464, 29817, 42066, 37920, 50404, 13518, 25767, 6548, 51636, 47582, 26910, 22908, 2394, 63641, 43184, 39123, 18447, 14393, 59475, 56195, 35839, 31687, 11038, 6972, 52049, 47830, 27287, 23191, 2633, 64117, 43616, 40339, 19903, 15828, 60702, 56620, 36168, 31895, 11434, 7402, 52240, 21112, 33361, 62013, 8923, 4811, 17084, 45944, 58204, 54068, 1013, 29662, 41896, 36941, 49233, 12329, 24815, 20682, 6537, 51623, 47561, 26895, 39971, 19459, 15465, 60585, 56523, 36080, 32034, 11531, 7487, 52616, 48530, 28150, 24107, 3587, 65121, 6546, 51644, 47557, 26902, 22822, 6548, 51636, 47582, 26910, 22908, 2373, 63645, 43197, 39105, 18515, 14364, 59464, 56212, 35766, 57447, 6557, 51636, 47576, 26910, 22833, 2368, 63624, 43178, 2617, 55824, 43644, 31375, 19091, 6890, 60215, 47890, 35681, 23480, 11198, 64486, 51255, 38932, 25697, 46152, 50212, 5335, 9419, 29874, 34159, 54602, 58681, 13792, 17889, 38321, 42596, 63046, 52285, 7199, 27667, 44314, 32062, 3401, 56712, 60856, 48581, 19485, 7288, 11328, 64663, 36027, 23766, 28442, 16186, 53077, 40912, 44987, 32717, 3667, 56858, 60998, 48799, 20130, 7879, 10516, 63789, 35180, 22940, 27049, 14795, 6559, 51643, 47564, 26893, 22845, 2368, 63640, 43261, 39109, 18450, 14398, 59475, 56223, 35775, 31696, 11093, 6974, 52040, 47830, 27292, 23243, 2590, 64034, 43586, 40322, 19896, 15826, 60690, 6538, 51642, 47594, 26886, 22822, 2380, 63677, 43169, 39124, 18460, 14377};
    private static long _BOUNDARY = -3543022214762083883L;

    private static String $$e(short s, int i, int i2) {
        int i3 = i2 + 66;
        int i4 = i * 4;
        byte[] bArr = $$c;
        int i5 = s + 4;
        byte[] bArr2 = new byte[i4 + 1];
        int i6 = -1;
        if (bArr == null) {
            i3 = i5 + i3;
            i5 = i5;
        }
        while (true) {
            i6++;
            bArr2[i6] = (byte) i3;
            int i7 = i5 + 1;
            if (i6 == i4) {
                return new String(bArr2, 0);
            }
            i3 += bArr[i7];
            i5 = i7;
        }
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
    private static void c(short r5, int r6, int r7, java.lang.Object[] r8) {
        /*
            int r6 = r6 * 5
            int r0 = 9 - r6
            int r5 = r5 * 3
            int r5 = 115 - r5
            int r7 = r7 * 8
            int r7 = r7 + 4
            byte[] r1 = io.sentry.android.core.internal.util.ScreenshotUtils.$$a
            byte[] r0 = new byte[r0]
            int r6 = 8 - r6
            r2 = 0
            if (r1 != 0) goto L18
            r3 = r7
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
            int r7 = r7 + 1
            int r3 = -r3
            int r5 = r5 + r3
            int r5 = r5 + (-7)
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.internal.util.ScreenshotUtils.c(short, int, int, java.lang.Object[]):void");
    }

    public static byte[] takeScreenshot(@NotNull Activity activity, @NotNull ILogger iLogger, @NotNull BuildInfoProvider buildInfoProvider) {
        return takeScreenshot(activity, AndroidThreadChecker.getInstance(), iLogger, buildInfoProvider);
    }

    public static byte[] takeScreenshot(@NotNull Activity activity, @NotNull IThreadChecker iThreadChecker, @NotNull ILogger iLogger, @NotNull BuildInfoProvider buildInfoProvider) {
        return compressBitmapToPng(captureScreenshot(activity, iThreadChecker, iLogger, buildInfoProvider), iLogger);
    }

    public static Bitmap captureScreenshot(@NotNull Activity activity, @NotNull ILogger iLogger, @NotNull BuildInfoProvider buildInfoProvider) {
        return captureScreenshot(activity, AndroidThreadChecker.getInstance(), iLogger, buildInfoProvider);
    }

    public static Bitmap captureScreenshot(@NotNull Activity activity, @NotNull IThreadChecker iThreadChecker, @NotNull final ILogger iLogger, @NotNull BuildInfoProvider buildInfoProvider) {
        boolean z = false;
        if (!isActivityValid(activity)) {
            iLogger.log(SentryLevel.DEBUG, "Activity isn't valid, not taking screenshot.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            iLogger.log(SentryLevel.DEBUG, "Activity window is null, not taking screenshot.", new Object[0]);
            return null;
        }
        View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView == null) {
            iLogger.log(SentryLevel.DEBUG, "DecorView is null, not taking screenshot.", new Object[0]);
            return null;
        }
        final View rootView = viewPeekDecorView.getRootView();
        if (rootView == null) {
            iLogger.log(SentryLevel.DEBUG, "Root view is null, not taking screenshot.", new Object[0]);
            return null;
        }
        if (rootView.getWidth() <= 0 || rootView.getHeight() <= 0) {
            iLogger.log(SentryLevel.DEBUG, "View's width and height is zeroed, not taking screenshot.", new Object[0]);
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap.Config.ARGB_8888);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            if (buildInfoProvider.getSdkInfoVersion() >= 26) {
                HandlerThread handlerThread = new HandlerThread("SentryScreenshot");
                handlerThread.start();
                try {
                    Handler handler = new Handler(handlerThread.getLooper());
                    final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    PixelCopy.request(window, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: io.sentry.android.core.internal.util.ScreenshotUtils$$ExternalSyntheticLambda1
                        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                        public final void onPixelCopyFinished(int i) {
                            ScreenshotUtils.lambda$captureScreenshot$0(atomicBoolean, countDownLatch, i);
                        }
                    }, handler);
                    if (countDownLatch.await(1000L, TimeUnit.MILLISECONDS) && atomicBoolean.get()) {
                        z = true;
                    }
                } catch (Throwable th) {
                    try {
                        iLogger.log(SentryLevel.ERROR, "Taking screenshot using PixelCopy failed.", th);
                    } catch (Throwable th2) {
                        handlerThread.quit();
                        throw th2;
                    }
                }
                handlerThread.quit();
                if (!z) {
                    return null;
                }
            } else {
                final Canvas canvas = new Canvas(bitmapCreateBitmap);
                if (iThreadChecker.isMainThread()) {
                    rootView.draw(canvas);
                    countDownLatch.countDown();
                } else {
                    activity.runOnUiThread(new Runnable() { // from class: io.sentry.android.core.internal.util.ScreenshotUtils$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            ScreenshotUtils.lambda$captureScreenshot$1(rootView, canvas, iLogger, countDownLatch);
                        }
                    });
                }
                if (!countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                    return null;
                }
            }
            return bitmapCreateBitmap;
        } catch (Throwable th3) {
            iLogger.log(SentryLevel.ERROR, "Taking screenshot failed.", th3);
            return null;
        }
    }

    private static void b(int i, char c, int i2, Object[] objArr) throws Throwable {
        int i3 = 2;
        int i4 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i];
        _creation.b = 0;
        while (_creation.b < i) {
            int i5 = $10 + 57;
            $11 = i5 % 128;
            if (i5 % i3 == 0) {
                int i6 = _creation.b;
                try {
                    Object[] objArr2 = {Integer.valueOf(_CREATION[i2 << i6])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) (-1);
                        byte b2 = (byte) (b + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionChild(0L) + 9, (char) (9279 - (ViewConfiguration.getTapTimeout() >> 16)), View.resolveSizeAndState(0, 0, 0) + 1977, 1113883676, false, $$e(b, b2, (byte) (b2 | 38)), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) (-1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 49363), ExpandableListView.getPackedPositionType(0L) + 684, -115095555, false, $$e(b3, (byte) (b3 + 1), $$c[2]), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i6] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    Object[] objArr4 = {_creation, _creation};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame3 == null) {
                        byte b4 = (byte) (-1);
                        byte b5 = (byte) (b4 + 1);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 25, (char) (30068 - View.resolveSize(0, 0)), TextUtils.getOffsetAfter("", 0) + 816, 1897803493, false, $$e(b4, b5, (byte) (b5 | 37)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } else {
                int i7 = _creation.b;
                Object[] objArr5 = {Integer.valueOf(_CREATION[i2 + i7])};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-587087340);
                if (objAccessartificialFrame4 == null) {
                    byte b6 = (byte) (-1);
                    byte b7 = (byte) (b6 + 1);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(View.combineMeasuredStates(0, 0) + 8, (char) (ExpandableListView.getPackedPositionType(0L) + 9279), 1977 - View.combineMeasuredStates(0, 0), 1113883676, false, $$e(b6, b7, (byte) (b7 | 38)), new Class[]{Integer.TYPE});
                }
                Object[] objArr6 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).longValue()), Long.valueOf(i7), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1715896821);
                if (objAccessartificialFrame5 == null) {
                    byte b8 = (byte) (-1);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(30 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getTouchSlop() >> 8) + 49362), View.resolveSizeAndState(0, 0, 0) + 684, -115095555, false, $$e(b8, (byte) (b8 + 1), $$c[2]), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i7] = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).longValue();
                Object[] objArr7 = {_creation, _creation};
                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame6 == null) {
                    byte b9 = (byte) (-1);
                    byte b10 = (byte) (b9 + 1);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (30067 - MotionEvent.axisFromString("")), 816 - Drawable.resolveOpacity(0, 0), 1897803493, false, $$e(b9, b10, (byte) (b10 | 37)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame6).invoke(null, objArr7);
            }
            i3 = 2;
        }
        char[] cArr = new char[i];
        _creation.b = 0;
        while (_creation.b < i) {
            int i8 = $10 + 79;
            $11 = i8 % 128;
            int i9 = i8 % 2;
            cArr[_creation.b] = (char) jArr[_creation.b];
            try {
                Object[] objArr8 = {_creation, _creation};
                Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame7 == null) {
                    byte b11 = (byte) (-1);
                    byte b12 = (byte) (b11 + 1);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (30068 - Drawable.resolveOpacity(0, 0)), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 816, 1897803493, false, $$e(b11, b12, (byte) (b12 | 37)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame7).invoke(null, objArr8);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        objArr[0] = new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$captureScreenshot$0(AtomicBoolean atomicBoolean, CountDownLatch countDownLatch, int i) {
        atomicBoolean.set(i == 0);
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$captureScreenshot$1(View view, Canvas canvas, ILogger iLogger, CountDownLatch countDownLatch) {
        try {
            view.draw(canvas);
        } catch (Throwable th) {
            try {
                iLogger.log(SentryLevel.ERROR, "Taking screenshot failed (view.draw).", th);
            } finally {
                countDownLatch.countDown();
            }
        }
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
        int i2;
        char[] cArr2;
        int i3 = 2;
        int i4 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr3 = validateRelationship;
        long j = 0;
        int i5 = 0;
        if (cArr3 != null) {
            int length = cArr3.length;
            char[] cArr4 = new char[length];
            int i6 = 0;
            while (i6 < length) {
                int i7 = $11 + 89;
                $10 = i7 % 128;
                if (i7 % i3 != 0) {
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i5] = Integer.valueOf(cArr3[i6]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) (-1);
                            byte b2 = (byte) (b + 1);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(26 - Color.alpha(i5), (char) (1 - (SystemClock.elapsedRealtimeNanos() > j ? 1 : (SystemClock.elapsedRealtimeNanos() == j ? 0 : -1))), Color.green(i5) + 1041, -1719489573, false, $$e(b, b2, (byte) (b2 | 55)), new Class[]{Integer.TYPE});
                        }
                        cArr4[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i6 <<= 1;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    Object[] objArr3 = {Integer.valueOf(cArr3[i6])};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) (-1);
                        byte b4 = (byte) (b3 + 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(Color.red(0) + 26, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 1040, -1719489573, false, $$e(b3, b4, (byte) (b4 | 55)), new Class[]{Integer.TYPE});
                    }
                    cArr4[i6] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i6++;
                }
                i3 = 2;
                j = 0;
                i5 = 0;
            }
            cArr3 = cArr4;
        }
        Object[] objArr4 = {Integer.valueOf(warmup)};
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1820173622);
        if (objAccessartificialFrame3 == null) {
            byte b5 = (byte) (-1);
            byte b6 = (byte) (b5 + 1);
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 15, (char) (20488 - (ViewConfiguration.getTapTimeout() >> 16)), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2147, 216472770, false, $$e(b5, b6, (byte) (b6 + 1)), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
        int i8 = 59173;
        int i9 = -2083387879;
        if (ICustomTabsServiceDefault) {
            int i10 = $11 + 71;
            $10 = i10 % 128;
            if (i10 % 2 != 0) {
                onmessagechannelready.c = bArr.length;
                cArr2 = new char[onmessagechannelready.c];
                i2 = 0;
            } else {
                i2 = 0;
                onmessagechannelready.c = bArr.length;
                cArr2 = new char[onmessagechannelready.c];
            }
            onmessagechannelready.a = i2;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                int i11 = $11 + 37;
                $10 = i11 % 128;
                if (i11 % 2 != 0) {
                    cArr2[onmessagechannelready.a] = (char) (cArr3[bArr[(onmessagechannelready.c / 0) * onmessagechannelready.a] - i] >> iIntValue);
                    Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) (-1);
                        byte b8 = (byte) (b7 + 1);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(21 - Gravity.getAbsoluteGravity(0, 0), (char) (Color.rgb(0, 0, 0) + 16836390), 1943 - ExpandableListView.getPackedPositionGroup(0L), 481771537, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                } else {
                    cArr2[onmessagechannelready.a] = (char) (cArr3[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                    Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame5 == null) {
                        byte b9 = (byte) (-1);
                        byte b10 = (byte) (b9 + 1);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 20, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 59173), 1943 - (ViewConfiguration.getLongPressTimeout() >> 16), 481771537, false, $$e(b9, b10, b10), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                }
            }
            objArr[0] = new String(cArr2);
            return;
        }
        if (!(!requestPostMessageChannelWithExtras)) {
            onmessagechannelready.c = cArr.length;
            char[] cArr5 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            int i12 = $10 + 67;
            $11 = i12 % 128;
            int i13 = i12 % 2;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr5[onmessagechannelready.a] = (char) (cArr3[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                Object[] objArr7 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(i9);
                if (objAccessartificialFrame6 == null) {
                    byte b11 = (byte) (-1);
                    byte b12 = (byte) (b11 + 1);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(21 - TextUtils.indexOf("", "", 0), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + i8), TextUtils.getOffsetAfter("", 0) + 1943, 481771537, false, $$e(b11, b12, b12), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame6).invoke(null, objArr7);
                i8 = 59173;
                i9 = -2083387879;
            }
            objArr[0] = new String(cArr5);
            return;
        }
        int i14 = 0;
        onmessagechannelready.c = iArr.length;
        char[] cArr6 = new char[onmessagechannelready.c];
        while (true) {
            onmessagechannelready.a = i14;
            if (onmessagechannelready.a >= onmessagechannelready.c) {
                objArr[0] = new String(cArr6);
                return;
            } else {
                cArr6[onmessagechannelready.a] = (char) (cArr3[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                i14 = onmessagechannelready.a + 1;
            }
        }
    }

    public static byte[] compressBitmapToPng(@Nullable Bitmap bitmap, @NotNull ILogger iLogger) {
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                    bitmap.recycle();
                    if (byteArrayOutputStream.size() <= 0) {
                        iLogger.log(SentryLevel.DEBUG, "Screenshot is 0 bytes, not attaching the image.", new Object[0]);
                        byteArrayOutputStream.close();
                        return null;
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                iLogger.log(SentryLevel.ERROR, "Compressing bitmap failed.", th3);
            }
        }
        return null;
    }

    private static boolean isActivityValid(@NotNull Activity activity) {
        return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 32, insn: 0x0c42: MOVE (r3 I:??[OBJECT, ARRAY]) = (r32 I:??[OBJECT, ARRAY]), block:B:224:0x0c40 */
    /* JADX WARN: Type inference failed for: r10v130 */
    /* JADX WARN: Type inference failed for: r10v164, types: [java.lang.Object, java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r10v196, types: [java.lang.Object, java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r10v198, types: [java.lang.Object, java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r10v227, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r10v260 */
    /* JADX WARN: Type inference failed for: r10v314 */
    /* JADX WARN: Type inference failed for: r10v41, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r10v513 */
    /* JADX WARN: Type inference failed for: r10v514 */
    /* JADX WARN: Type inference failed for: r11v132, types: [java.lang.Object, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r11v169 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v121 */
    /* JADX WARN: Type inference failed for: r12v122, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v123 */
    /* JADX WARN: Type inference failed for: r12v124, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v327 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r13v121, types: [java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r1v154, types: [int[]] */
    /* JADX WARN: Type inference failed for: r1v209 */
    /* JADX WARN: Type inference failed for: r1v233 */
    /* JADX WARN: Type inference failed for: r1v301 */
    /* JADX WARN: Type inference failed for: r1v302 */
    /* JADX WARN: Type inference failed for: r1v313 */
    /* JADX WARN: Type inference failed for: r1v314 */
    /* JADX WARN: Type inference failed for: r1v322, types: [java.lang.Object, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v324 */
    /* JADX WARN: Type inference failed for: r1v529 */
    /* JADX WARN: Type inference failed for: r1v530 */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v10 */
    /* JADX WARN: Type inference failed for: r25v11 */
    /* JADX WARN: Type inference failed for: r25v12 */
    /* JADX WARN: Type inference failed for: r25v15 */
    /* JADX WARN: Type inference failed for: r25v16 */
    /* JADX WARN: Type inference failed for: r25v17 */
    /* JADX WARN: Type inference failed for: r25v18 */
    /* JADX WARN: Type inference failed for: r25v26 */
    /* JADX WARN: Type inference failed for: r25v27 */
    /* JADX WARN: Type inference failed for: r25v28 */
    /* JADX WARN: Type inference failed for: r25v29 */
    /* JADX WARN: Type inference failed for: r25v31, types: [int] */
    /* JADX WARN: Type inference failed for: r25v32 */
    /* JADX WARN: Type inference failed for: r25v33 */
    /* JADX WARN: Type inference failed for: r25v34 */
    /* JADX WARN: Type inference failed for: r25v35 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r25v8 */
    /* JADX WARN: Type inference failed for: r25v9 */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r26v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r26v10 */
    /* JADX WARN: Type inference failed for: r26v11 */
    /* JADX WARN: Type inference failed for: r26v12 */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r26v20 */
    /* JADX WARN: Type inference failed for: r26v21 */
    /* JADX WARN: Type inference failed for: r26v22 */
    /* JADX WARN: Type inference failed for: r26v23 */
    /* JADX WARN: Type inference failed for: r26v25 */
    /* JADX WARN: Type inference failed for: r26v26 */
    /* JADX WARN: Type inference failed for: r26v27 */
    /* JADX WARN: Type inference failed for: r26v28 */
    /* JADX WARN: Type inference failed for: r26v29 */
    /* JADX WARN: Type inference failed for: r26v30 */
    /* JADX WARN: Type inference failed for: r26v31 */
    /* JADX WARN: Type inference failed for: r26v32 */
    /* JADX WARN: Type inference failed for: r26v33 */
    /* JADX WARN: Type inference failed for: r26v34 */
    /* JADX WARN: Type inference failed for: r26v35 */
    /* JADX WARN: Type inference failed for: r26v36 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r26v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r26v6 */
    /* JADX WARN: Type inference failed for: r26v9 */
    /* JADX WARN: Type inference failed for: r27v0 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v24 */
    /* JADX WARN: Type inference failed for: r27v25 */
    /* JADX WARN: Type inference failed for: r27v26 */
    /* JADX WARN: Type inference failed for: r27v27 */
    /* JADX WARN: Type inference failed for: r27v28 */
    /* JADX WARN: Type inference failed for: r27v29 */
    /* JADX WARN: Type inference failed for: r27v30 */
    /* JADX WARN: Type inference failed for: r27v31 */
    /* JADX WARN: Type inference failed for: r27v32 */
    /* JADX WARN: Type inference failed for: r27v38 */
    /* JADX WARN: Type inference failed for: r27v39 */
    /* JADX WARN: Type inference failed for: r27v40 */
    /* JADX WARN: Type inference failed for: r27v41 */
    /* JADX WARN: Type inference failed for: r27v42 */
    /* JADX WARN: Type inference failed for: r27v43 */
    /* JADX WARN: Type inference failed for: r27v44 */
    /* JADX WARN: Type inference failed for: r27v5 */
    /* JADX WARN: Type inference failed for: r29v0 */
    /* JADX WARN: Type inference failed for: r29v1 */
    /* JADX WARN: Type inference failed for: r29v11 */
    /* JADX WARN: Type inference failed for: r29v12 */
    /* JADX WARN: Type inference failed for: r29v13 */
    /* JADX WARN: Type inference failed for: r29v16 */
    /* JADX WARN: Type inference failed for: r29v17 */
    /* JADX WARN: Type inference failed for: r29v18 */
    /* JADX WARN: Type inference failed for: r29v19 */
    /* JADX WARN: Type inference failed for: r29v2 */
    /* JADX WARN: Type inference failed for: r29v3 */
    /* JADX WARN: Type inference failed for: r29v31 */
    /* JADX WARN: Type inference failed for: r29v41 */
    /* JADX WARN: Type inference failed for: r29v42 */
    /* JADX WARN: Type inference failed for: r29v44 */
    /* JADX WARN: Type inference failed for: r29v45 */
    /* JADX WARN: Type inference failed for: r29v46 */
    /* JADX WARN: Type inference failed for: r29v47 */
    /* JADX WARN: Type inference failed for: r29v48 */
    /* JADX WARN: Type inference failed for: r29v49 */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Type inference failed for: r29v51 */
    /* JADX WARN: Type inference failed for: r29v52 */
    /* JADX WARN: Type inference failed for: r29v53 */
    /* JADX WARN: Type inference failed for: r29v54 */
    /* JADX WARN: Type inference failed for: r29v55 */
    /* JADX WARN: Type inference failed for: r29v56 */
    /* JADX WARN: Type inference failed for: r29v57 */
    /* JADX WARN: Type inference failed for: r29v58 */
    /* JADX WARN: Type inference failed for: r29v59 */
    /* JADX WARN: Type inference failed for: r29v60 */
    /* JADX WARN: Type inference failed for: r29v61 */
    /* JADX WARN: Type inference failed for: r29v62 */
    /* JADX WARN: Type inference failed for: r29v63 */
    /* JADX WARN: Type inference failed for: r29v64 */
    /* JADX WARN: Type inference failed for: r29v8 */
    /* JADX WARN: Type inference failed for: r29v9 */
    /* JADX WARN: Type inference failed for: r2v108 */
    /* JADX WARN: Type inference failed for: r2v109 */
    /* JADX WARN: Type inference failed for: r2v115, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v148 */
    /* JADX WARN: Type inference failed for: r2v182, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v223, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v235 */
    /* JADX WARN: Type inference failed for: r2v239, types: [java.nio.LongBuffer[]] */
    /* JADX WARN: Type inference failed for: r2v240 */
    /* JADX WARN: Type inference failed for: r2v244 */
    /* JADX WARN: Type inference failed for: r2v247 */
    /* JADX WARN: Type inference failed for: r2v248 */
    /* JADX WARN: Type inference failed for: r2v254, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r2v264, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r2v279 */
    /* JADX WARN: Type inference failed for: r2v355, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r2v509, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v531 */
    /* JADX WARN: Type inference failed for: r2v532 */
    /* JADX WARN: Type inference failed for: r2v533 */
    /* JADX WARN: Type inference failed for: r32v11 */
    /* JADX WARN: Type inference failed for: r32v113 */
    /* JADX WARN: Type inference failed for: r32v4 */
    /* JADX WARN: Type inference failed for: r32v5, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r32v6 */
    /* JADX WARN: Type inference failed for: r32v7 */
    /* JADX WARN: Type inference failed for: r32v8 */
    /* JADX WARN: Type inference failed for: r32v9 */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v158 */
    /* JADX WARN: Type inference failed for: r3v180, types: [int[]] */
    /* JADX WARN: Type inference failed for: r3v189 */
    /* JADX WARN: Type inference failed for: r3v194 */
    /* JADX WARN: Type inference failed for: r3v230, types: [int[]] */
    /* JADX WARN: Type inference failed for: r3v256 */
    /* JADX WARN: Type inference failed for: r3v257 */
    /* JADX WARN: Type inference failed for: r3v258, types: [java.lang.CharSequence, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v259 */
    /* JADX WARN: Type inference failed for: r3v261 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v319 */
    /* JADX WARN: Type inference failed for: r3v321 */
    /* JADX WARN: Type inference failed for: r3v322, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v359 */
    /* JADX WARN: Type inference failed for: r3v360 */
    /* JADX WARN: Type inference failed for: r3v361 */
    /* JADX WARN: Type inference failed for: r3v362 */
    /* JADX WARN: Type inference failed for: r3v363 */
    /* JADX WARN: Type inference failed for: r3v364 */
    /* JADX WARN: Type inference failed for: r3v365 */
    /* JADX WARN: Type inference failed for: r3v366 */
    /* JADX WARN: Type inference failed for: r3v367 */
    /* JADX WARN: Type inference failed for: r3v368 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v89 */
    /* JADX WARN: Type inference failed for: r4v114, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v146, types: [int[]] */
    /* JADX WARN: Type inference failed for: r4v177, types: [java.lang.Object, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v235 */
    /* JADX WARN: Type inference failed for: r4v255, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r5v119 */
    /* JADX WARN: Type inference failed for: r5v151 */
    /* JADX WARN: Type inference failed for: r5v190, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v193 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v532 */
    /* JADX WARN: Type inference failed for: r5v533 */
    /* JADX WARN: Type inference failed for: r5v534 */
    /* JADX WARN: Type inference failed for: r5v535 */
    /* JADX WARN: Type inference failed for: r5v536 */
    /* JADX WARN: Type inference failed for: r5v58, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v59, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.nio.LongBuffer[]] */
    /* JADX WARN: Type inference failed for: r5v85, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v89 */
    /* JADX WARN: Type inference failed for: r5v90, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r6v17, types: [int[]] */
    /* JADX WARN: Type inference failed for: r6v175 */
    /* JADX WARN: Type inference failed for: r6v176, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v212 */
    /* JADX WARN: Type inference failed for: r6v218 */
    /* JADX WARN: Type inference failed for: r6v599, types: [int[]] */
    /* JADX WARN: Type inference failed for: r6v609 */
    /* JADX WARN: Type inference failed for: r6v610 */
    /* JADX WARN: Type inference failed for: r6v611 */
    /* JADX WARN: Type inference failed for: r6v73 */
    /* JADX WARN: Type inference failed for: r6v74, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v79 */
    /* JADX WARN: Type inference failed for: r6v80, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v9, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v145, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v482, types: [int[]] */
    /* JADX WARN: Type inference failed for: r8v120 */
    /* JADX WARN: Type inference failed for: r8v121 */
    /* JADX WARN: Type inference failed for: r8v122, types: [java.security.KeyStore] */
    /* JADX WARN: Type inference failed for: r8v123, types: [java.security.KeyStore] */
    /* JADX WARN: Type inference failed for: r8v134, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r8v135 */
    /* JADX WARN: Type inference failed for: r8v163 */
    /* JADX WARN: Type inference failed for: r8v164 */
    /* JADX WARN: Type inference failed for: r8v198, types: [java.lang.Object, java.security.KeyStore] */
    /* JADX WARN: Type inference failed for: r8v30, types: [java.lang.Object, java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r8v410, types: [int[]] */
    /* JADX WARN: Type inference failed for: r8v416 */
    /* JADX WARN: Type inference failed for: r8v49 */
    /* JADX WARN: Type inference failed for: r8v51 */
    /* JADX WARN: Type inference failed for: r9v108 */
    /* JADX WARN: Type inference failed for: r9v109 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v117 */
    /* JADX WARN: Type inference failed for: r9v118 */
    /* JADX WARN: Type inference failed for: r9v145 */
    /* JADX WARN: Type inference failed for: r9v146 */
    /* JADX WARN: Type inference failed for: r9v147 */
    /* JADX WARN: Type inference failed for: r9v148 */
    /* JADX WARN: Type inference failed for: r9v149 */
    /* JADX WARN: Type inference failed for: r9v150 */
    /* JADX WARN: Type inference failed for: r9v151 */
    /* JADX WARN: Type inference failed for: r9v152 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v62, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v63 */
    /* JADX WARN: Type inference failed for: r9v64 */
    /* JADX WARN: Type inference failed for: r9v65 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] accessartificialFrame(android.content.Context r40, java.lang.String[] r41, int r42, int r43, int r44) {
        /*
            Method dump skipped, instruction units count: 14816
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.internal.util.ScreenshotUtils.accessartificialFrame(android.content.Context, java.lang.String[], int, int, int):java.lang.Object[]");
    }
}
