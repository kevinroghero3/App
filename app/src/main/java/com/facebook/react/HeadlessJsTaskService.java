package com.facebook.react;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.salesforce.marketingcloud.internal.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.io.encoding.Base64;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HeadlessJsTaskService extends Service implements HeadlessJsTaskEventListener {
    private static short[] ICustomTabsService;
    private static PowerManager.WakeLock sWakeLock;
    private final Set<Integer> mActiveTasks = new CopyOnWriteArraySet();
    private static final byte[] $$c = {55, -4, -8, -76};
    private static final int $$f = 60;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$g = {75, 100, -62, Ascii.SYN, Ascii.CR, -50, 75, 6, Ascii.FF, -61, 70, Ascii.VT, 0, 3, 7, 10, Ascii.DLE, -53, Base64.padSymbol, Ascii.DC4, Ascii.VT, -5, -47, 77, 5, 1, -51, Ascii.GS, 62, -14, 17, 5, 2, -25, 59, -7, 8, 7, Ascii.NAK, -22, 38, -9, 10, Ascii.DLE, 2, Ascii.NAK, 8, 69, Ascii.DC4, 6, -55, SignedBytes.MAX_POWER_OF_TWO, 3, 10, 10, 5, Ascii.NAK, 8, 4, -53, 67, Ascii.FF, -4, Ascii.SO, 6, 19, 1, Ascii.SI, -3, Ascii.SI, 5, Ascii.CR, -1, -47, Base64.padSymbol, Ascii.DC4, Ascii.VT, -5, -47, 42, 42, 5, -3, Ascii.EM, -10, 10, Ascii.NAK, -23, Ascii.SUB, Ascii.DC4, Ascii.FF, -8, 17, -3, 10, -23, 35, 10, Ascii.EM, 3, Ascii.VT, Ascii.SI, -77, 39, 52, 6, Ascii.VT, -7, Ascii.NAK, 3, Ascii.SO, 7};
    private static final int $$h = 105;
    private static final byte[] $$a = {Ascii.DC4, 17, 111, Ascii.ESC, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$b = 158;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int onTransact = -368983138;
    private static int mayLaunchUrl = -81862406;
    private static int getInterfaceDescriptor = -619835555;
    private static byte[] ICustomTabsCallbackStubProxy = {-6, 6, -3, -37, 32, -6, 3, -13, -12, -48, -41, 53, -10, -77, 36, -11, -12, Ascii.SI, -8, 0, -1, -2, -110, -29, -82, -83, -6, -123, 8, -7, -28, -107, -87, -29, -111, 99, 100, 84, 113, 77, 72, -82, 124, 96, 120, 53, -96, -126, 88, 126, -41, 59, -14, 9, 59, -64, -49, Ascii.GS, -21, -39, 59, -44, -33, -41, 41, -117, -117, -117, -117};

    private static String $$i(short s, int i, short s2) {
        int i2 = i * 2;
        int i3 = (s2 * 5) + 112;
        byte[] bArr = $$c;
        int i4 = (s * 3) + 4;
        byte[] bArr2 = new byte[i2 + 1];
        int i5 = -1;
        if (bArr == null) {
            i5 = -1;
            i3 = (-i4) + i2;
            i4++;
        }
        while (true) {
            int i6 = i5 + 1;
            bArr2[i6] = (byte) i3;
            if (i6 == i2) {
                return new String(bArr2, 0);
            }
            int i7 = i3;
            i5 = i6;
            i3 = (-bArr[i4]) + i7;
            i4++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 28
            int r6 = 112 - r6
            int r7 = r7 * 3
            int r7 = 12 - r7
            byte[] r0 = com.facebook.react.HeadlessJsTaskService.$$a
            int r8 = r8 * 8
            int r8 = r8 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r8
            r4 = r2
            goto L2c
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r4 = r0[r8]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2c:
            int r8 = -r8
            int r3 = r3 + 1
            int r6 = r6 + r8
            r8 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.HeadlessJsTaskService.a(int, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = 48 - r8
            int r6 = r6 * 2
            int r6 = 65 - r6
            byte[] r0 = com.facebook.react.HeadlessJsTaskService.$$g
            int r7 = r7 * 63
            int r7 = r7 + 36
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r6
            r5 = r2
            goto L28
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r6) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r3 = r0[r8]
        L28:
            int r8 = r8 + 1
            int r7 = r7 + r3
            int r7 = r7 + (-8)
            r3 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.HeadlessJsTaskService.c(short, byte, byte, java.lang.Object[]):void");
    }

    protected HeadlessJsTaskConfig getTaskConfig(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskStart(int i) {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        HeadlessJsTaskConfig taskConfig = getTaskConfig(intent);
        if (taskConfig == null) {
            return 2;
        }
        startTask(taskConfig);
        return 3;
    }

    public static void acquireWakeLockNow(Context context) {
        PowerManager.WakeLock wakeLock = sWakeLock;
        if (wakeLock == null || !wakeLock.isHeld()) {
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) Assertions.assertNotNull((PowerManager) context.getSystemService("power"))).newWakeLock(1, HeadlessJsTaskService.class.getCanonicalName());
            sWakeLock = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
            sWakeLock.acquire();
        }
    }

    protected void startTask(HeadlessJsTaskConfig headlessJsTaskConfig) {
        UiThreadUtil.assertOnUiThread();
        acquireWakeLockNow(this);
        ReactContext reactContext = getReactContext();
        if (reactContext == null) {
            createReactContextAndScheduleTask(headlessJsTaskConfig);
        } else {
            invokeStartTask(reactContext, headlessJsTaskConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeStartTask(ReactContext reactContext, final HeadlessJsTaskConfig headlessJsTaskConfig) {
        final HeadlessJsTaskContext headlessJsTaskContext = HeadlessJsTaskContext.getInstance(reactContext);
        headlessJsTaskContext.addTaskEventListener(this);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.HeadlessJsTaskService.1
            @Override // java.lang.Runnable
            public void run() {
                HeadlessJsTaskService.this.mActiveTasks.add(Integer.valueOf(headlessJsTaskContext.startTask(headlessJsTaskConfig)));
            }
        });
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ReactContext reactContext = getReactContext();
        if (reactContext != null) {
            HeadlessJsTaskContext.getInstance(reactContext).removeTaskEventListener(this);
        }
        PowerManager.WakeLock wakeLock = sWakeLock;
        if (wakeLock != null) {
            wakeLock.release();
        }
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskFinish(int i) {
        this.mActiveTasks.remove(Integer.valueOf(i));
        if (this.mActiveTasks.size() == 0) {
            stopSelf();
        }
    }

    protected ReactNativeHost getReactNativeHost() {
        return ((ReactApplication) getApplication()).getReactNativeHost();
    }

    protected ReactHost getReactHost() {
        return ((ReactApplication) getApplication()).getReactHost();
    }

    protected ReactContext getReactContext() {
        if (ReactNativeFeatureFlags.enableBridgelessArchitecture()) {
            ReactHost reactHost = getReactHost();
            Assertions.assertNotNull(reactHost, "getReactHost() is null in New Architecture");
            return reactHost.getCurrentReactContext();
        }
        return getReactNativeHost().getReactInstanceManager().getCurrentReactContext();
    }

    private void createReactContextAndScheduleTask(final HeadlessJsTaskConfig headlessJsTaskConfig) {
        if (ReactNativeFeatureFlags.enableBridgelessArchitecture()) {
            final ReactHost reactHost = getReactHost();
            reactHost.addReactInstanceEventListener(new ReactInstanceEventListener() { // from class: com.facebook.react.HeadlessJsTaskService.2
                @Override // com.facebook.react.ReactInstanceEventListener
                public void onReactContextInitialized(@NonNull ReactContext reactContext) {
                    HeadlessJsTaskService.this.invokeStartTask(reactContext, headlessJsTaskConfig);
                    reactHost.removeReactInstanceEventListener(this);
                }
            });
            reactHost.start();
        } else {
            final ReactInstanceManager reactInstanceManager = getReactNativeHost().getReactInstanceManager();
            reactInstanceManager.addReactInstanceEventListener(new ReactInstanceEventListener() { // from class: com.facebook.react.HeadlessJsTaskService.3
                @Override // com.facebook.react.ReactInstanceEventListener
                public void onReactContextInitialized(@NonNull ReactContext reactContext) {
                    HeadlessJsTaskService.this.invokeStartTask(reactContext, headlessJsTaskConfig);
                    reactInstanceManager.removeReactInstanceEventListener(this);
                }
            });
            reactInstanceManager.createReactContextInBackground();
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x019d  */
    /* JADX WARN: Code duplicated, block: B:67:0x0261  */
    /* JADX WARN: Code duplicated, block: B:68:0x0285  */
    private static void b(int i, byte b, int i2, short s, int i3, Object[] objArr) throws Throwable {
        long j;
        int i4;
        boolean z;
        int i5 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
            if (objAccessartificialFrame == null) {
                byte b2 = (byte) 0;
                byte b3 = b2;
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(40 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 36241), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 2342, 371880939, false, $$i(b2, b3, b3), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
            boolean z2 = iIntValue == -1;
            if (z2) {
                int i6 = $11 + 85;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                byte[] bArr = ICustomTabsCallbackStubProxy;
                if (bArr != null) {
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    for (int i8 = 0; i8 < length; i8++) {
                        Object[] objArr3 = {Integer.valueOf(bArr[i8])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                        if (objAccessartificialFrame2 == null) {
                            byte b4 = (byte) 0;
                            byte b5 = b4;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(44 - TextUtils.getOffsetBefore("", 0), (char) (ViewConfiguration.getWindowTouchSlop() >> 8), ImageFormat.getBitsPerPixel(0) + 1216, 1011328145, false, $$i(b4, b5, (byte) (b5 + 1)), new Class[]{Integer.TYPE});
                        }
                        bArr2[i8] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                    }
                    bArr = bArr2;
                }
                if (bArr != null) {
                    byte[] bArr3 = ICustomTabsCallbackStubProxy;
                    Object[] objArr4 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                    if (objAccessartificialFrame3 == null) {
                        byte b6 = (byte) 0;
                        byte b7 = b6;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(40 - (ViewConfiguration.getTouchSlop() >> 8), (char) (36241 - (ViewConfiguration.getJumpTapTimeout() >> 16)), View.combineMeasuredStates(0, 0) + 2342, 371880939, false, $$i(b6, b7, b7), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                    j = -4629754035390455669L;
                } else {
                    j = -4629754035390455669L;
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            } else {
                j = -4629754035390455669L;
            }
            if (iIntValue > 0) {
                int i9 = ((i3 + iIntValue) - 2) + ((int) (((long) onTransact) ^ j));
                if (z2) {
                    int i10 = $11 + 95;
                    $10 = i10 % 128;
                    if (i10 % 2 != 0) {
                        i4 = 0;
                    } else {
                        i4 = 1;
                    }
                } else {
                    i4 = 0;
                }
                iCustomTabsCallback.c = i9 + i4;
                Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(42 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) TextUtils.getOffsetAfter("", 0), (ViewConfiguration.getLongPressTimeout() >> 16) + 4066, -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                byte[] bArr4 = ICustomTabsCallbackStubProxy;
                if (bArr4 != null) {
                    int length2 = bArr4.length;
                    byte[] bArr5 = new byte[length2];
                    for (int i11 = 0; i11 < length2; i11++) {
                        int i12 = $11 + 35;
                        $10 = i12 % 128;
                        int i13 = i12 % 2;
                        bArr5[i11] = (byte) (((long) bArr4[i11]) ^ (-4629754035390455669L));
                    }
                    bArr4 = bArr5;
                }
                if (bArr4 != null) {
                    int i14 = $10 + 5;
                    $11 = i14 % 128;
                    if (i14 % 2 == 0) {
                        int i15 = 5 % 2;
                    }
                    z = true;
                } else {
                    z = false;
                }
                iCustomTabsCallback.a = 1;
                while (iCustomTabsCallback.a < iIntValue) {
                    int i16 = $11 + 23;
                    $10 = i16 % 128;
                    if (i16 % 2 != 0) {
                        int i17 = 92 / 0;
                        if (z) {
                            byte[] bArr6 = ICustomTabsCallbackStubProxy;
                            int i18 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i18 - 1;
                            iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr6[i18]) ^ (-4629754035390455669L))) + s)) ^ b));
                        } else {
                            short[] sArr = ICustomTabsService;
                            int i19 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i19 - 1;
                            iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i19]) ^ (-4629754035390455669L))) + s)) ^ b));
                        }
                    } else if (z) {
                        byte[] bArr7 = ICustomTabsCallbackStubProxy;
                        int i110 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i110 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr7[i110]) ^ (-4629754035390455669L))) + s)) ^ b));
                    } else {
                        short[] sArr2 = ICustomTabsService;
                        int i111 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i111 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr2[i111]) ^ (-4629754035390455669L))) + s)) ^ b));
                    }
                    sb.append(iCustomTabsCallback.createConnectionCallback);
                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                    iCustomTabsCallback.a++;
                }
            }
            objArr[0] = sb.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x025f  */
    /* JADX WARN: Code duplicated, block: B:16:0x03f0 A[Catch: all -> 0x0ffd, TryCatch #2 {all -> 0x0ffd, blocks: (B:51:0x0bbf, B:53:0x0bdf, B:54:0x0c32, B:14:0x03dc, B:16:0x03f0, B:17:0x0421), top: B:95:0x03dc }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0437  */
    /* JADX WARN: Code duplicated, block: B:25:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:50:0x0a5e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0bdf A[Catch: all -> 0x0ffd, TryCatch #2 {all -> 0x0ffd, blocks: (B:51:0x0bbf, B:53:0x0bdf, B:54:0x0c32, B:14:0x03dc, B:16:0x03f0, B:17:0x0421), top: B:95:0x03dc }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0c44  */
    /* JADX WARN: Code duplicated, block: B:62:0x0df8  */
    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArrCoroutineCreation$78cbbd35;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArr;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int iBlue = Color.blue(0) + 26;
            char cLastIndexOf = (char) ((-1) - TextUtils.lastIndexOf("", '0'));
            int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1041;
            byte b = $$a[5];
            byte b2 = (byte) (b - 1);
            byte b3 = b;
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iBlue, cLastIndexOf, keyRepeatTimeout, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387898L;
            Object[] objArr3 = new Object[1];
            b((-537980789) - View.resolveSize(0, 0), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 54), KeyEvent.normalizeMetaState(0) - 91, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 161), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 287253304, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 537980820, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) - 148), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 203, (short) ((-72) - TextUtils.indexOf("", "", 0)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 287253284, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int iIndexOf = 25 - TextUtils.indexOf((CharSequence) "", '0', 0);
                    char doubleTapTimeout = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int iLastIndexOf = 1040 - TextUtils.lastIndexOf("", '0', 0);
                    byte b4 = $$a[5];
                    byte b5 = (byte) (b4 - 1);
                    byte b6 = b4;
                    Object[] objArr5 = new Object[1];
                    a(b5, b6, b6, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iIndexOf, doubleTapTimeout, iLastIndexOf, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrCoroutineCreation$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i2 = ((int[]) objArr6[3])[0];
                int i3 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int i4 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().smallestScreenWidthDp;
                int i5 = (-666300102) + (((~((-103827714) | (~i4))) | 25723906) * (-591)) + ((i4 | (-103827714)) * 591) + 1322291004;
                int i6 = (i5 << 13) ^ i5;
                int i7 = i6 ^ (i6 >>> 17);
                ((int[]) objArrCoroutineCreation$78cbbd35[1])[0] = i7 ^ (i7 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 537980784, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 78), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 134, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 146), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 287253238, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 537980830, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 55), (-97) - View.MeasureSpec.getSize(0), (short) (TextUtils.getCapsMode("", 0, 0) - 2), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 287253223, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {-1860611533};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 22251), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrCoroutineCreation$78cbbd35 = b.coroutineCreation$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), 1322291004, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int gidForName = Process.getGidForName("") + 27;
                        char c = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1);
                        int keyRepeatDelay = 1041 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        byte b7 = $$a[5];
                        byte b8 = (byte) (b7 - 1);
                        byte b9 = b7;
                        Object[] objArr10 = new Object[1];
                        a(b8, b9, b9, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(gidForName, c, keyRepeatDelay, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrCoroutineCreation$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 537980826, (byte) ((ViewConfiguration.getTouchSlop() >> 8) - 5), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 126, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 161), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 287253273, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 537980820, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 79), (ViewConfiguration.getWindowTouchSlop() >> 8) - 98, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 76), (-287253248) - ExpandableListView.getPackedPositionType(0L), objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int i8 = 27 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                            char c2 = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1);
                            int i9 = 1042 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                            byte b10 = $$a[5];
                            byte b11 = (byte) (b10 - 1);
                            byte b12 = b10;
                            Object[] objArr13 = new Object[1];
                            a(b11, b12, (byte) (b12 - 1), objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i8, c2, i9, 2061780482, false, (String) objArr13[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                        int i10 = artificialFrame + 33;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i10 % 128;
                        int i11 = i10 % 2;
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
        } else {
            Object[] objArr14 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 537980784, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 78), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 134, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 146), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 287253238, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 537980830, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 55), (-97) - View.MeasureSpec.getSize(0), (short) (TextUtils.getCapsMode("", 0, 0) - 2), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 287253223, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {-1860611533};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 22251), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrCoroutineCreation$78cbbd35 = b.coroutineCreation$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), 1322291004, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int gidForName2 = Process.getGidForName("") + 27;
                char c3 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1);
                int keyRepeatDelay2 = 1041 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                byte b13 = $$a[5];
                byte b14 = (byte) (b13 - 1);
                byte b15 = b13;
                Object[] objArr17 = new Object[1];
                a(b14, b15, b15, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(gidForName2, c3, keyRepeatDelay2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrCoroutineCreation$78cbbd35);
            Object[] objArr18 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 537980826, (byte) ((ViewConfiguration.getTouchSlop() >> 8) - 5), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 126, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 161), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 287253273, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 537980820, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 79), (ViewConfiguration.getWindowTouchSlop() >> 8) - 98, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 76), (-287253248) - ExpandableListView.getPackedPositionType(0L), objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int i12 = 27 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                char c4 = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1);
                int i13 = 1042 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                byte b16 = $$a[5];
                byte b17 = (byte) (b16 - 1);
                byte b18 = b16;
                Object[] objArr110 = new Object[1];
                a(b17, b18, (byte) (b18 - 1), objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i12, c4, i13, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
            int i14 = artificialFrame + 33;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i14 % 128;
            int i15 = i14 % 2;
        }
        int i16 = ((int[]) objArrCoroutineCreation$78cbbd35[2])[0];
        int i17 = ((int[]) objArrCoroutineCreation$78cbbd35[3])[0];
        if (i17 == i16) {
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i18 = ((int[]) objArrCoroutineCreation$78cbbd35[1])[0];
            int i19 = ((int[]) objArrCoroutineCreation$78cbbd35[3])[0];
            int i20 = ((int[]) objArrCoroutineCreation$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrCoroutineCreation$78cbbd35[0];
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1148480481;
            int i21 = ~length;
            int i22 = i18 + (-2105834626) + ((395424 | i21) * (-192)) + (((~(229001640 | i21)) | 306710023) * (-384)) + (((~(length | (-228606217))) | (~(i21 | 535711663)) | (~((-306710024) | length))) * JfifUtil.MARKER_SOFn);
            int i23 = (i22 << 13) ^ i22;
            int i24 = i23 ^ (i23 >>> 17);
            ((int[]) objArr20[1])[0] = i24 ^ (i24 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrCoroutineCreation$78cbbd35[0];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i16 ^ i17)) ^ (((long) 1021033702) << 32)), Long.valueOf(1021033700)};
                byte[] bArr = $$g;
                Object[] objArr22 = new Object[1];
                c(bArr[11], bArr[25], bArr[3], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c((byte) 31, bArr[12], bArr[25], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i25 = ((int[]) objArrCoroutineCreation$78cbbd35[1])[0];
                int i26 = ((int[]) objArrCoroutineCreation$78cbbd35[3])[0];
                int i27 = ((int[]) objArrCoroutineCreation$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrCoroutineCreation$78cbbd35[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i28 = i25 + 1734529158 + (((~((~iIdentityHashCode) | (-734005605))) | (-655901798)) * (-235)) + (((~((-734005605) | iIdentityHashCode)) | (-655901798)) * (-470)) + (((~(iIdentityHashCode | (-587202661))) | (-802704742)) * 235);
                int i29 = (i28 << 13) ^ i28;
                int i30 = i29 ^ (i29 >>> 17);
                ((int[]) objArr24[1])[0] = i30 ^ (i30 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame9 == null) {
            int iNormalizeMetaState = 25 - KeyEvent.normalizeMetaState(0);
            char maximumFlingVelocity = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 30068);
            int i31 = 817 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
            byte b19 = $$a[5];
            byte b20 = (byte) (b19 - 1);
            byte b21 = b19;
            Object[] objArr25 = new Object[1];
            a(b20, b21, (byte) (b21 - 1), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, maximumFlingVelocity, i31, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            int i32 = getARTIFICIAL_FRAME_PACKAGE_NAME + 59;
            artificialFrame = i32 % 128;
            int i33 = i32 % 2;
            long j4 = j3 + 2014;
            Object[] objArr26 = new Object[1];
            b((ViewConfiguration.getEdgeSlop() >> 16) - 537980789, (byte) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 6), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(8) - 192, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 130), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(10) - 287253387, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 537980789, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 64), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 213, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 76), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 287253269, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int iMyPid = (Process.myPid() >> 22) + 25;
                    char cGreen = (char) (Color.green(0) + 30068);
                    int i34 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 815;
                    byte b22 = $$a[5];
                    byte b23 = (byte) (b22 - 1);
                    byte b24 = b22;
                    Object[] objArr28 = new Object[1];
                    a(b23, b24, b24, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iMyPid, cGreen, i34, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i35 = ((int[]) objArr29[0])[0];
                int i36 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int i37 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
                int i38 = (((-1905804427) + (((~(i37 | (-181305345))) | (~((-16849970) | i37))) * (-184))) + (((8526 | (~((-16858496) | i37))) | (~((-181313871) | i37))) * SyslogConstants.LOG_LOCAL7)) - 14934774;
                int i39 = (i38 << 13) ^ i38;
                int i40 = i39 ^ (i39 >>> 17);
                ((int[]) objArr[3])[0] = i40 ^ (i40 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 537980801, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 64), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 132, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 132), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 287253339, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b(TextUtils.indexOf("", "", 0, 0) - 537980781, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 56), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 132, (short) ((-1) - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 287253268, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -2117342782};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int i41 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 24;
                    char cLastIndexOf2 = (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 30069);
                    int i42 = 816 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    byte[] bArr2 = $$a;
                    byte b25 = bArr2[5];
                    Object[] objArr33 = new Object[1];
                    a(b25, (byte) (b25 - 1), bArr2[8], objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i41, cLastIndexOf2, i42, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int i43 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 26;
                    char cAxisFromString = (char) (30067 - MotionEvent.axisFromString(""));
                    int iLastIndexOf2 = 815 - TextUtils.lastIndexOf("", '0', 0, 0);
                    byte b26 = $$a[5];
                    byte b27 = (byte) (b26 - 1);
                    byte b28 = b26;
                    Object[] objArr34 = new Object[1];
                    a(b27, b28, b28, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i43, cAxisFromString, iLastIndexOf2, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 537980904, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) - 104), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 140, (short) (View.MeasureSpec.getMode(0) - 126), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 287253304, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 537980834, (byte) (View.MeasureSpec.getSize(0) - 43), (-99) - TextUtils.lastIndexOf("", '0', 0), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 93), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 287253252, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int defaultSize = View.getDefaultSize(0, 0) + 25;
                        char scrollBarFadeDuration = (char) (30068 - (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                        int i44 = 817 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        byte b29 = $$a[5];
                        byte b30 = (byte) (b29 - 1);
                        byte b31 = b29;
                        Object[] objArr37 = new Object[1];
                        a(b30, b31, (byte) (b31 - 1), objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(defaultSize, scrollBarFadeDuration, i44, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 537980801, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 64), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 132, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 132), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 287253339, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            b(TextUtils.indexOf("", "", 0, 0) - 537980781, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 56), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 132, (short) ((-1) - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 287253268, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -2117342782};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int i45 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 24;
                char cLastIndexOf3 = (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 30069);
                int i46 = 816 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                byte[] bArr3 = $$a;
                byte b210 = bArr3[5];
                Object[] objArr311 = new Object[1];
                a(b210, (byte) (b210 - 1), bArr3[8], objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i45, cLastIndexOf3, i46, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int i47 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 26;
                char cAxisFromString2 = (char) (30067 - MotionEvent.axisFromString(""));
                int iLastIndexOf3 = 815 - TextUtils.lastIndexOf("", '0', 0, 0);
                byte b211 = $$a[5];
                byte b212 = (byte) (b211 - 1);
                byte b213 = b211;
                Object[] objArr312 = new Object[1];
                a(b212, b213, b213, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i47, cAxisFromString2, iLastIndexOf3, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 537980904, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) - 104), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 140, (short) (View.MeasureSpec.getMode(0) - 126), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 287253304, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 537980834, (byte) (View.MeasureSpec.getSize(0) - 43), (-99) - TextUtils.lastIndexOf("", '0', 0), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 93), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 287253252, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int defaultSize2 = View.getDefaultSize(0, 0) + 25;
                char scrollBarFadeDuration2 = (char) (30068 - (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                int i48 = 817 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                byte b214 = $$a[5];
                byte b32 = (byte) (b214 - 1);
                byte b33 = b214;
                Object[] objArr315 = new Object[1];
                a(b32, b33, (byte) (b33 - 1), objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(defaultSize2, scrollBarFadeDuration2, i48, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i49 = ((int[]) objArr[1])[0];
        int i50 = ((int[]) objArr[0])[0];
        if (i50 == i49) {
            int i51 = artificialFrame + 125;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i51 % 128;
            int i52 = i51 % 2;
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i53 = ((int[]) objArr[3])[0];
            int i54 = ((int[]) objArr[0])[0];
            int i55 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i56 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboardHidden;
            int i57 = (-2075618451) + (((~(591162105 | i56)) | (-392989740)) * 672);
            int i58 = ~i56;
            int i59 = i53 + i57 + (((~(i56 | (-392989740))) | (~((-591162106) | i58))) * (-672)) + (((~(392989739 | i58)) | (-930934524)) * 672);
            int i60 = (i59 << 13) ^ i59;
            int i61 = i60 ^ (i60 >>> 17);
            ((int[]) objArr40[3])[0] = i61 ^ (i61 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            int i62 = 0;
            while (i62 < strArr7.length) {
                arrayList2.add(strArr7[i62]);
                i62++;
                int i63 = artificialFrame + 25;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i63 % 128;
                int i64 = i63 % 2;
            }
        }
        long j5 = ((long) (i49 ^ i50)) ^ (((long) 612579282) << 32);
        long j6 = 612579283;
        int i65 = artificialFrame + 107;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i65 % 128;
        int i66 = i65 % 2;
        Object[] objArr41 = {Long.valueOf(j5), Long.valueOf(j6)};
        byte[] bArr4 = $$g;
        byte b34 = bArr4[12];
        Object[] objArr42 = new Object[1];
        c(b34, bArr4[25], b34, objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c((byte) 31, bArr4[12], bArr4[25], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i67 = ((int[]) objArr[3])[0];
        int i68 = ((int[]) objArr[0])[0];
        int i69 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int i70 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenWidthDp;
        int i71 = i67 + (-1905804427) + (((~(i70 | 1073733599)) | (~((-36634898) | i70))) * (-184)) + ((617635534 | (~((-654270432) | i70)) | (~(456098065 | i70))) * SyslogConstants.LOG_LOCAL7) + 128188232;
        int i72 = (i71 << 13) ^ i71;
        int i73 = i72 ^ (i72 >>> 17);
        ((int[]) objArr44[3])[0] = i73 ^ (i73 << 5);
    }

    @Override // android.app.Service
    public void onCreate() {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 15;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        super.onCreate();
        int i4 = artificialFrame + 97;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
        int i5 = i4 % 2;
    }
}
