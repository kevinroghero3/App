package io.sentry.react;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.CoreConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import kotlin.text.Typography;
import o.ArtificialStackFrames;
import o.build;
import o.extraCallback;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes3.dex */
public class RNSentryModule extends ReactContextBaseJavaModule {
    private final RNSentryModuleImpl impl;
    private static final byte[] $$a = {19, -17, 93, 33};
    private static final int $$b = 154;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] ArtificialStackFrames = {44367, 44332, 44388, 44364, 44358, 44409, 44371, 44361, 44398, 44386, 44345, 44410, 44411, 44376, 44395, 44406, 44373, 44349, 44359, 44353, 44390, 44320, 44341, 44396, 44394, 44392, 44402, 44368, 44365, 44403, 44391, 44355, 44336, 44354, 44400, 44389, 44357, 44393, 44366, 44334, 44405, 44385, 44387, 44352, 44404, 44356, 44397, 44399, 44408};
    private static char coroutineCreation = 39069;
    private static char TopicBuilder = 3874;
    private static char ICustomTabsCallback = 29766;
    private static char extraCallbackWithResult = 61836;
    private static char onMessageChannelReady = 7288;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(int r5, byte r6, int r7) {
        /*
            int r7 = r7 * 2
            int r7 = 4 - r7
            int r6 = r6 * 2
            int r6 = 1 - r6
            byte[] r0 = io.sentry.react.RNSentryModule.$$a
            int r5 = 110 - r5
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L15
            r4 = r5
            r5 = r6
            r3 = r2
            goto L25
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r5
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L23
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L23:
            r4 = r0[r7]
        L25:
            int r5 = r5 + r4
            int r7 = r7 + 1
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.react.RNSentryModule.$$c(int, byte, int):java.lang.String");
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap fetchNativeStackFramesBy(ReadableArray readableArray) {
        return null;
    }

    RNSentryModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.impl = new RNSentryModuleImpl(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return RNSentryModuleImpl.NAME;
    }

    @ReactMethod
    public void addListener(String str) {
        this.impl.addListener(str);
    }

    @ReactMethod
    public void removeListeners(double d) {
        this.impl.removeListeners(d);
    }

    @ReactMethod
    public void initNativeReactNavigationNewFrameTracking(Promise promise) {
        this.impl.initNativeReactNavigationNewFrameTracking(promise);
    }

    @ReactMethod
    public void initNativeSdk(ReadableMap readableMap, Promise promise) {
        this.impl.initNativeSdk(readableMap, promise);
    }

    @ReactMethod
    public void crash() {
        this.impl.crash();
    }

    @ReactMethod
    public void fetchModules(Promise promise) {
        this.impl.fetchModules(promise);
    }

    @ReactMethod
    public void fetchNativeRelease(Promise promise) {
        this.impl.fetchNativeRelease(promise);
    }

    @ReactMethod
    public void fetchNativeAppStart(Promise promise) {
        this.impl.fetchNativeAppStart(promise);
    }

    @ReactMethod
    public void fetchNativeFrames(Promise promise) {
        this.impl.fetchNativeFrames(promise);
    }

    @ReactMethod
    public void captureEnvelope(String str, ReadableMap readableMap, Promise promise) {
        this.impl.captureEnvelope(str, readableMap, promise);
    }

    @ReactMethod
    public void captureScreenshot(Promise promise) {
        this.impl.captureScreenshot(promise);
    }

    @ReactMethod
    public void fetchViewHierarchy(Promise promise) {
        this.impl.fetchViewHierarchy(promise);
    }

    @ReactMethod
    public void setUser(ReadableMap readableMap, ReadableMap readableMap2) {
        this.impl.setUser(readableMap, readableMap2);
    }

    @ReactMethod
    public void addBreadcrumb(ReadableMap readableMap) {
        this.impl.addBreadcrumb(readableMap);
    }

    @ReactMethod
    public void clearBreadcrumbs() {
        this.impl.clearBreadcrumbs();
    }

    @ReactMethod
    public void setExtra(String str, String str2) {
        this.impl.setExtra(str, str2);
    }

    @ReactMethod
    public void setContext(String str, ReadableMap readableMap) {
        this.impl.setContext(str, readableMap);
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        int i3 = 0;
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        while (buildVar.c < cArr.length) {
            cArr3[i3] = cArr[buildVar.c];
            char c = 1;
            cArr3[1] = cArr[buildVar.c + 1];
            int i4 = 58224;
            int i5 = i3;
            while (i5 < 16) {
                int i6 = $11 + 9;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                char c2 = cArr3[c];
                char c3 = cArr3[i3];
                char[] cArr4 = cArr3;
                int i8 = (c3 + i4) ^ ((c3 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))));
                int i9 = c3 >>> 5;
                try {
                    Object[] objArr2 = new Object[4];
                    objArr2[3] = Integer.valueOf(onMessageChannelReady);
                    objArr2[2] = Integer.valueOf(i9);
                    objArr2[c] = Integer.valueOf(i8);
                    objArr2[0] = Integer.valueOf(c2);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 28;
                        char cIndexOf = (char) (17263 - TextUtils.indexOf("", "", 0));
                        int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 1067;
                        byte b = (byte) ($$b & 7);
                        byte b2 = (byte) (b - 2);
                        String str$$c = $$c(b, b2, b2);
                        Class[] clsArr = new Class[4];
                        clsArr[0] = Integer.TYPE;
                        clsArr[c] = Integer.TYPE;
                        clsArr[2] = Integer.TYPE;
                        clsArr[3] = Integer.TYPE;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, cIndexOf, iResolveOpacity, 1042277788, false, str$$c, clsArr);
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr4[c] = cCharValue;
                    int i10 = i5;
                    Object[] objArr3 = {Integer.valueOf(cArr4[0]), Integer.valueOf((cCharValue + i4) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 29;
                        char absoluteGravity = (char) (Gravity.getAbsoluteGravity(0, 0) + 17263);
                        int iGreen = Color.green(0) + 1067;
                        byte b3 = (byte) ($$b & 7);
                        byte b4 = (byte) (b3 - 2);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, absoluteGravity, iGreen, 1042277788, false, $$c(b3, b4, b4), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i4 -= 40503;
                    i5 = i10 + 1;
                    int i11 = $10 + 125;
                    $11 = i11 % 128;
                    int i12 = i11 % 2;
                    cArr3 = cArr4;
                    i3 = 0;
                    c = 1;
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
                byte b5 = (byte) 0;
                byte b6 = b5;
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getWindowTouchSlop() >> 8) + 25, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 63927), ((Process.getThreadPriority(0) + 20) >> 6) + 486, 1554985764, false, $$c(b5, b6, b6), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            cArr3 = cArr5;
            i3 = 0;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    @ReactMethod
    public void setTag(String str, String str2) {
        this.impl.setTag(str, str2);
    }

    @ReactMethod
    public void closeNativeSdk(Promise promise) {
        this.impl.closeNativeSdk(promise);
    }

    @ReactMethod
    public void enableNativeFramesTracking() {
        this.impl.enableNativeFramesTracking();
    }

    @ReactMethod
    public void disableNativeFramesTracking() {
        this.impl.disableNativeFramesTracking();
    }

    @ReactMethod
    public void fetchNativeDeviceContexts(Promise promise) {
        this.impl.fetchNativeDeviceContexts(promise);
    }

    @ReactMethod
    public void fetchNativeSdkInfo(Promise promise) {
        this.impl.fetchNativeSdkInfo(promise);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap startProfiling(boolean z) {
        return this.impl.startProfiling(z);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap stopProfiling() {
        return this.impl.stopProfiling();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String fetchNativePackageName() {
        return this.impl.fetchNativePackageName();
    }

    @ReactMethod
    public void captureReplay(boolean z, Promise promise) {
        this.impl.captureReplay(z, promise);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getCurrentReplayId() {
        return this.impl.getCurrentReplayId();
    }

    @ReactMethod
    public void crashedLastRun(Promise promise) {
        this.impl.crashedLastRun(promise);
    }

    @ReactMethod
    public void getNewScreenTimeToDisplay(Promise promise) {
        this.impl.getNewScreenTimeToDisplay(promise);
    }

    @ReactMethod
    public void getDataFromUri(String str, Promise promise) {
        this.impl.getDataFromUri(str, promise);
    }

    @ReactMethod
    public void encodeToBase64(ReadableArray readableArray, Promise promise) {
        this.impl.encodeToBase64(readableArray, promise);
    }

    @ReactMethod
    public void popTimeToDisplayFor(String str, Promise promise) {
        this.impl.popTimeToDisplayFor(str, promise);
    }

    @ReactMethod
    public boolean setActiveSpanId(String str) {
        return this.impl.setActiveSpanId(str);
    }

    private static void a(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
        int i2;
        Object obj;
        int i3 = 2;
        int i4 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        char c = '0';
        int i5 = 13;
        Object obj2 = null;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i6 = 0;
            while (i6 < length) {
                int i7 = $11 + 125;
                $10 = i7 % 128;
                if (i7 % i3 != 0) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i6])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1819279892);
                        if (objAccessartificialFrame == null) {
                            byte b2 = (byte) 0;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(14 - TextUtils.lastIndexOf("", c), (char) (20488 - KeyEvent.normalizeMetaState(0)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 2148, 216710116, false, $$c((byte) i5, b2, b2), new Class[]{Integer.TYPE});
                        }
                        cArr3[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    Object[] objArr3 = {Integer.valueOf(cArr2[i6])};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0) + 15, (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 20488), Color.blue(0) + 2148, 216710116, false, $$c((byte) 13, b3, b3), new Class[]{Integer.TYPE});
                    }
                    cArr3[i6] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                }
                i6++;
                i3 = 2;
                c = '0';
                i5 = 13;
            }
            cArr2 = cArr3;
        }
        try {
            Object[] objArr4 = {Integer.valueOf(coroutineCreation)};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1819279892);
            long j = 0;
            if (objAccessartificialFrame3 == null) {
                byte b4 = (byte) 0;
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(16 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (Color.alpha(0) + 20488), 2149 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 216710116, false, $$c((byte) 13, b4, b4), new Class[]{Integer.TYPE});
            }
            char cCharValue = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
            char[] cArr4 = new char[i];
            if (i % 2 != 0) {
                int i8 = $11 + 73;
                $10 = i8 % 128;
                if (i8 % 2 != 0) {
                    i2 = i + 114;
                    cArr4[i2] = (char) (cArr[i2] / b);
                } else {
                    i2 = i - 1;
                    cArr4[i2] = (char) (cArr[i2] - b);
                }
            } else {
                i2 = i;
            }
            if (i2 > 1) {
                extracallback.a = 0;
                while (extracallback.a < i2) {
                    extracallback.createBrowser = cArr[extracallback.a];
                    extracallback.c = cArr[extracallback.a + 1];
                    if (extracallback.createBrowser == extracallback.c) {
                        int i9 = $11 + 15;
                        $10 = i9 % 128;
                        int i10 = i9 % 2;
                        cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                        cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        obj = obj2;
                    } else {
                        Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame4 == null) {
                            byte b5 = (byte) 0;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getJumpTapTimeout() >> 16) + 46, (char) ((KeyEvent.getMaxKeyCode() >> 16) + 58859), 2464 - (ExpandableListView.getPackedPositionForGroup(0) > j ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == j ? 0 : -1)), 276640984, false, $$c((byte) ($$b & 44), b5, b5), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue() == extracallback.g) {
                            int i11 = $10 + b.i;
                            $11 = i11 % 128;
                            int i12 = i11 % 2;
                            Object[] objArr6 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame5 == null) {
                                byte b6 = (byte) 5;
                                byte b7 = (byte) (b6 - 5);
                                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(24 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) ('0' - AndroidCharacter.getMirror('0')), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 792, -834291897, false, $$c(b6, b7, b7), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            obj = null;
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).intValue();
                            int i13 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue];
                            cArr4[extracallback.a + 1] = cArr2[i13];
                        } else {
                            obj = null;
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
                    obj2 = obj;
                    j = 0;
                }
            }
            for (int i18 = 0; i18 < i; i18++) {
                int i19 = $11 + 113;
                $10 = i19 % 128;
                int i20 = i19 % 2;
                cArr4[i18] = (char) (cArr4[i18] ^ 13722);
            }
            String str = new String(cArr4);
            int i21 = $10 + 23;
            $11 = i21 % 128;
            int i22 = i21 % 2;
            objArr[0] = str;
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:156:0x0d15  */
    /* JADX WARN: Code duplicated, block: B:157:0x0d1c  */
    public static Object[] accessartificialFrame(Context context, int i, int i2) {
        Object[] objArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Class<?> cls;
        Object obj;
        int i8;
        int i9;
        Method method;
        Object obj2;
        int i10;
        int i11;
        int i12;
        Object[] objArr2;
        int gidForName;
        char[] cArr;
        int i13;
        int i14;
        int i_CREATION;
        int i15;
        int i16;
        int i17 = 2;
        int i18 = 2 % 2;
        int i19 = artificialFrame;
        int i20 = 1;
        int i21 = ((i19 | 31) << 1) - (i19 ^ 31);
        getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
        int i22 = 0;
        if (i21 % 2 != 0) {
            int i23 = 14 / 0;
        }
        if (context == null) {
            int i24 = i19 + 19;
            int i25 = i24 % 128;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i25;
            int i26 = i24 % 2;
            objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
            int i27 = ((i25 | 63) << 1) - (i25 ^ 63);
            artificialFrame = i27 % 128;
            if (i27 % 2 == 0) {
                Process.getStartElapsedRealtime();
                i16 = 0;
            } else {
                int i28 = ~(i | 593789518);
                i16 = i2 + ((898930846 | i28) * (-658)) + 400933146 + ((i28 | 344987792) * 658);
            }
            int i29 = artificialFrame;
            int i30 = (i29 ^ 53) + ((i29 & 53) << 1);
            int i31 = i30 % 128;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i31;
            int i32 = i30 % 2;
            int i33 = i16 << 13;
            int i34 = (i16 | i33) & (~(i16 & i33));
            int i35 = i34 >>> 17;
            int i36 = ((~i34) & i35) | ((~i35) & i34);
            int i37 = i31 + 47;
            artificialFrame = i37 % 128;
            if (i37 % 2 == 0) {
                int i38 = i36 + 4;
                ((int[]) objArr[4])[0] = ((~i36) & i38) | ((~i38) & i36);
            } else {
                int i39 = i36 << 5;
                ((int[]) objArr[2])[0] = ((~i36) & i39) | ((~i39) & i36);
            }
            i7 = 0;
        } else {
            try {
                int i40 = -KeyEvent.keyCodeFromString("");
                int i_CREATION2 = com.facebook.applinks.R.integer._CREATION();
                int i41 = i40 * (-963);
                int i42 = (i41 & (-964)) + (i41 | (-964));
                int i43 = ((~i40) | (~(((-39) ^ i_CREATION2) | ((-39) & i_CREATION2)))) * (-964);
                int i44 = artificialFrame;
                int i45 = (i44 ^ 65) + ((i44 & 65) << 1);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i45 % 128;
                int i46 = i45 % 2;
                int i47 = (((i42 ^ 36670) + ((36670 & i42) << 1)) - (~(-(-i43)))) - 1;
                int i48 = ~i_CREATION2;
                int i49 = ~((i48 & (-39)) | ((-39) ^ i48));
                int i50 = ~((i40 & (-39)) | ((-39) ^ i40));
                int i51 = i47 + (((i50 & i49) | (i49 ^ i50)) * (-964));
                int i52 = i44 + 83;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i52 % 128;
                if (i52 % 2 != 0) {
                    Object[] objArr3 = new Object[1];
                    a(i51, new char[]{27, Typography.amp, 20, '$', '.', CoreConstants.RIGHT_PARENTHESIS_CHAR, 28, '$', '/', '#', 23, CoreConstants.LEFT_PARENTHESIS_CHAR, '/', 2, CoreConstants.LEFT_PARENTHESIS_CHAR, '#', CoreConstants.PERCENT_CHAR, '/', ' ', '.', '+', 27, 13776, 13776, CoreConstants.RIGHT_PARENTHESIS_CHAR, 11, 25, 29, '\"', 25, 23, CoreConstants.LEFT_PARENTHESIS_CHAR, 7, '+', CoreConstants.RIGHT_PARENTHESIS_CHAR, 30, CoreConstants.PERCENT_CHAR, 27}, (byte) (Color.rgb(1, 0, 0) * 16777254), objArr3);
                    cls = Class.forName((String) objArr3[0]);
                } else {
                    Object[] objArr4 = new Object[1];
                    a(i51, new char[]{27, Typography.amp, 20, '$', '.', CoreConstants.RIGHT_PARENTHESIS_CHAR, 28, '$', '/', '#', 23, CoreConstants.LEFT_PARENTHESIS_CHAR, '/', 2, CoreConstants.LEFT_PARENTHESIS_CHAR, '#', CoreConstants.PERCENT_CHAR, '/', ' ', '.', '+', 27, 13776, 13776, CoreConstants.RIGHT_PARENTHESIS_CHAR, 11, 25, 29, '\"', 25, 23, CoreConstants.LEFT_PARENTHESIS_CHAR, 7, '+', CoreConstants.RIGHT_PARENTHESIS_CHAR, 30, CoreConstants.PERCENT_CHAR, 27}, (byte) (Color.rgb(0, 0, 0) + 16777254), objArr4);
                    cls = Class.forName((String) objArr4[0]);
                }
                Object[] objArr5 = (Object[]) Array.newInstance(cls, 2);
                int i53 = artificialFrame;
                int i54 = (i53 & 89) + (i53 | 89);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i54 % 128;
                int i55 = i54 % 2;
                int i56 = -Color.red(0);
                int i_CREATION3 = com.facebook.applinks.R.integer._CREATION();
                int i57 = i56 * 960;
                int i58 = ((i57 | (-59427)) << 1) - (i57 ^ (-59427));
                int i59 = ~i_CREATION3;
                int i60 = ~((i59 & (-32)) | ((-32) ^ i59));
                int i61 = ~((i56 ^ i_CREATION3) | (i56 & i_CREATION3));
                int i62 = ((i60 ^ i61) | (i60 & i61)) * 959;
                int i63 = ((i58 | i62) << 1) - (i62 ^ i58);
                int i64 = (i63 ^ 30688) + ((i63 & 30688) << 1);
                int i65 = ~(((-32) & i_CREATION3) | ((-32) ^ i_CREATION3));
                int i66 = ~i_CREATION3;
                int i67 = getARTIFICIAL_FRAME_PACKAGE_NAME + 123;
                artificialFrame = i67 % 128;
                if (i67 % 2 == 0) {
                    int i68 = i64 * (959 << ((~((i56 & i66) | (i66 ^ i56))) | i65));
                    Object[] objArr6 = new Object[1];
                    a(i68, new char[]{Typography.amp, CoreConstants.DASH_CHAR, 18, 20, '\t', 1, '!', 5, CoreConstants.COMMA_CHAR, '\t', 24, '*', CoreConstants.PERCENT_CHAR, 7, CoreConstants.PERCENT_CHAR, '!', 2, 1, 18, 20, '\t', 1, '!', 5, CoreConstants.COMMA_CHAR, '\t', 3, 29, 18, 17, 13827}, (byte) ((AudioTrack.getMinVolume() > 1.0f ? 1 : (AudioTrack.getMinVolume() == 1.0f ? 0 : -1)) * b.i), objArr6);
                    obj = objArr6[0];
                } else {
                    int i69 = (i64 - (~(((~((i56 & i66) | (i66 ^ i56))) | i65) * 959))) - 1;
                    char[] cArr2 = {Typography.amp, CoreConstants.DASH_CHAR, 18, 20, '\t', 1, '!', 5, CoreConstants.COMMA_CHAR, '\t', 24, '*', CoreConstants.PERCENT_CHAR, 7, CoreConstants.PERCENT_CHAR, '!', 2, 1, 18, 20, '\t', 1, '!', 5, CoreConstants.COMMA_CHAR, '\t', 3, 29, 18, 17, 13827};
                    int i70 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    Object[] objArr7 = new Object[1];
                    a(i69, cArr2, (byte) ((i70 & 58) + (i70 | 58)), objArr7);
                    obj = objArr7[0];
                }
                try {
                    int deadChar = KeyEvent.getDeadChar(0, 0);
                    int i_CREATION4 = com.facebook.applinks.R.integer._CREATION();
                    int i71 = (deadChar * (-167)) - 6346;
                    int i72 = ~deadChar;
                    int i73 = -(-(((~((i72 & (-39)) | (i72 ^ (-39)))) | (~((-39) | i_CREATION4))) * 336));
                    int i74 = (i71 ^ i73) + ((i71 & i73) << 1);
                    int i75 = ~(deadChar | 38);
                    int i76 = ~((deadChar ^ i_CREATION4) | (deadChar & i_CREATION4));
                    int i77 = i74 + (((i75 ^ i76) | (i75 & i76)) * (-168));
                    int i78 = ~i_CREATION4;
                    int i79 = ((~((deadChar & i78) | (i78 ^ deadChar))) | (-39)) * 168;
                    Object[] objArr8 = new Object[1];
                    a((i77 & i79) + (i79 | i77), new char[]{27, Typography.amp, 20, '$', '.', CoreConstants.RIGHT_PARENTHESIS_CHAR, 28, '$', '/', '#', 23, CoreConstants.LEFT_PARENTHESIS_CHAR, '/', 2, CoreConstants.LEFT_PARENTHESIS_CHAR, '#', CoreConstants.PERCENT_CHAR, '/', ' ', '.', '+', 27, 13776, 13776, CoreConstants.RIGHT_PARENTHESIS_CHAR, 11, 25, 29, '\"', 25, 23, CoreConstants.LEFT_PARENTHESIS_CHAR, 7, '+', CoreConstants.RIGHT_PARENTHESIS_CHAR, 30, CoreConstants.PERCENT_CHAR, 27}, (byte) (37 - (~(-(-View.MeasureSpec.getSize(0))))), objArr8);
                    objArr5[0] = Class.forName((String) objArr8[0]).getDeclaredConstructor(String.class).newInstance((String) obj);
                    int i80 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    int i_CREATION5 = com.facebook.applinks.R.integer._CREATION();
                    int i81 = (i80 * (-501)) + 16096;
                    int i82 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i83 = (i82 & 73) + (i82 | 73);
                    artificialFrame = i83 % 128;
                    if (i83 % 2 == 0) {
                        int i84 = i81 >> ((-502) >>> ((~(((-33) & i_CREATION5) | ((-33) ^ i_CREATION5))) | (~((i80 ^ 32) | (i80 & 32)))));
                        int i85 = ~i_CREATION5;
                        i8 = i84 * ((-502) % (~((((-33) ^ i85) | (i85 & (-33))) | i80)));
                    } else {
                        int i86 = ~(((-33) & i_CREATION5) | ((-33) ^ i_CREATION5));
                        int i87 = ~(i80 | 32);
                        int i88 = (i81 - (~(-(-(((i86 ^ i87) | (i86 & i87)) * (-502)))))) - 1;
                        int i89 = ~i_CREATION5;
                        int i90 = (~(((-33) ^ i89) | (i89 & (-33)) | i80)) * (-502);
                        i8 = ((i88 | i90) << 1) - (i88 ^ i90);
                    }
                    int i91 = ~((~i80) | i_CREATION5);
                    int i92 = TypedValues.PositionType.TYPE_DRAWPATH * ((i91 & (-33)) | ((-33) ^ i91));
                    int i93 = (i8 & i92) + (i92 | i8);
                    char[] cArr3 = {Typography.amp, 24, 20, 2, 2, 1, 18, 20, '\t', 1, '!', 5, CoreConstants.COMMA_CHAR, '\t', 3, 29, CoreConstants.DASH_CHAR, 24, 15, '\f', 5, 23, CoreConstants.COMMA_CHAR, CoreConstants.LEFT_PARENTHESIS_CHAR, 0, 23, '*', Typography.amp, '\f', CoreConstants.PERCENT_CHAR, 13880};
                    int i94 = -(ViewConfiguration.getScrollBarSize() >> 8);
                    int i95 = getARTIFICIAL_FRAME_PACKAGE_NAME + 85;
                    artificialFrame = i95 % 128;
                    if (i95 % 2 == 0) {
                        int i96 = (483 << i94) * 14278;
                        int i97 = ~i94;
                        i9 = i96 >>> ((-241) % ((~((~i) | (~i94))) | (~((i97 ^ (-60)) | (i97 & (-60))))));
                    } else {
                        int i98 = i94 * 483;
                        int i99 = ((i98 | 14278) << 1) - (i98 ^ 14278);
                        int i100 = ~i94;
                        int i101 = ~((i100 ^ (-60)) | (i100 & (-60)));
                        int i102 = ~i;
                        int i103 = ~((i100 ^ i102) | (i100 & i102));
                        i9 = (((i103 & i101) | (i101 ^ i103)) * (-241)) + i99;
                    }
                    int i104 = (i9 - (~(-(-((-482) * ((i94 ^ 59) | (i94 & 59))))))) - 1;
                    int i105 = ~((-60) | i94);
                    int i106 = ~i94;
                    int i107 = ~i;
                    int i108 = (i106 & i107) | (i106 ^ i107);
                    int i109 = ~((i108 & 59) | (i108 ^ 59));
                    int i110 = ((i109 & i105) | (i105 ^ i109)) * 241;
                    byte b = (byte) (((i104 | i110) << 1) - (i104 ^ i110));
                    Object[] objArr9 = new Object[1];
                    a(i93, cArr3, b, objArr9);
                    try {
                        Object[] objArr10 = {(String) objArr9[0]};
                        int i111 = -(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                        int i112 = ~(((-39) & i107) | ((-39) ^ i107));
                        int i113 = ~(((-39) ^ i111) | ((-39) & i111));
                        int i114 = (((((i111 * (-244)) + 9348) - (~(((i112 & i113) | (i112 ^ i113)) * (-245)))) - 1) - (~((~(((-39) & i) | ((-39) ^ i))) * (-245)))) - 1;
                        int i115 = ~(((-39) ^ i) | ((-39) & i));
                        int i116 = i114 + (((i115 & i111) | (i111 ^ i115)) * 245);
                        char[] cArr4 = {27, Typography.amp, 20, '$', '.', CoreConstants.RIGHT_PARENTHESIS_CHAR, 28, '$', '/', '#', 23, CoreConstants.LEFT_PARENTHESIS_CHAR, '/', 2, CoreConstants.LEFT_PARENTHESIS_CHAR, '#', CoreConstants.PERCENT_CHAR, '/', ' ', '.', '+', 27, 13776, 13776, CoreConstants.RIGHT_PARENTHESIS_CHAR, 11, 25, 29, '\"', 25, 23, CoreConstants.LEFT_PARENTHESIS_CHAR, 7, '+', CoreConstants.RIGHT_PARENTHESIS_CHAR, 30, CoreConstants.PERCENT_CHAR, 27};
                        int iResolveSize = View.resolveSize(0, 0);
                        int i_CREATION6 = com.facebook.applinks.R.integer._CREATION();
                        int i117 = iResolveSize * JfifUtil.MARKER_EOI;
                        int i118 = (((i117 & (-8170)) + (i117 | (-8170))) - (~((~((iResolveSize ^ i_CREATION6) | (iResolveSize & i_CREATION6))) * JfifUtil.MARKER_SOI))) - 1;
                        int i119 = (iResolveSize ^ (-39)) | (iResolveSize & (-39));
                        int i120 = ~i_CREATION6;
                        int i121 = (i118 - (~(-(-(((i119 ^ i120) | (i119 & i120)) * (-216)))))) - 1;
                        int i122 = ~(iResolveSize | (~i_CREATION6));
                        Object[] objArr11 = new Object[1];
                        a(i116, cArr4, (byte) ((i121 - (~(-(-(((i122 & 38) | (i122 ^ 38)) * JfifUtil.MARKER_SOI))))) - 1), objArr11);
                        objArr5[1] = Class.forName((String) objArr11[0]).getDeclaredConstructor(String.class).newInstance(objArr10);
                        try {
                            int i123 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                            Object[] objArr12 = new Object[1];
                            a(((i123 | 23) << 1) - (i123 ^ 23), new char[]{'$', CharUtils.CR, 5, 23, CoreConstants.COMMA_CHAR, CoreConstants.LEFT_PARENTHESIS_CHAR, 4, CoreConstants.PERCENT_CHAR, '+', '0', '\t', '+', '$', 7, '.', CoreConstants.PERCENT_CHAR, '!', CoreConstants.DASH_CHAR, '\t', '+', CoreConstants.RIGHT_PARENTHESIS_CHAR, '*', 13879}, (byte) (74 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), objArr12);
                            Class<?> cls2 = Class.forName((String) objArr12[0]);
                            Object[] objArr13 = new Object[1];
                            a(16 - (~View.resolveSizeAndState(0, 0, 0)), new char[]{28, CoreConstants.PERCENT_CHAR, '0', 23, '#', '0', 20, '#', 28, CoreConstants.PERCENT_CHAR, '\"', '#', CharUtils.CR, '$', 28, CoreConstants.PERCENT_CHAR, 13922}, (byte) (122 - View.MeasureSpec.getSize(0)), objArr13);
                            Object objInvoke = cls2.getMethod((String) objArr13[0], null).invoke(context, null);
                            try {
                                int i124 = 21 - (~(-ExpandableListView.getPackedPositionChild(0L)));
                                char[] cArr5 = {'$', CharUtils.CR, 5, 23, CoreConstants.COMMA_CHAR, CoreConstants.LEFT_PARENTHESIS_CHAR, 4, CoreConstants.PERCENT_CHAR, '+', '0', '\t', '+', '$', 7, '.', CoreConstants.PERCENT_CHAR, '!', CoreConstants.DASH_CHAR, '\t', '+', CoreConstants.RIGHT_PARENTHESIS_CHAR, '*', 13879};
                                int i125 = -Color.alpha(0);
                                int i_CREATION7 = com.facebook.applinks.R.integer._CREATION();
                                int i126 = i125 * 370;
                                int i127 = ((i126 | 27010) << 1) - (i126 ^ 27010);
                                int i128 = (i125 ^ 73) | (i125 & 73);
                                int i129 = ~i_CREATION7;
                                int i130 = (i127 - (~(((i128 ^ i129) | (i128 & i129)) * (-369)))) - 1;
                                int i131 = ~i125;
                                int i132 = ~i_CREATION7;
                                int i133 = ~((i131 ^ i132) | (i132 & i131));
                                int i134 = ((i133 & 73) | (i133 ^ 73)) * (-369);
                                int i135 = (i130 & i134) + (i134 | i130);
                                int i136 = ~(((-74) & i125) | ((-74) ^ i125));
                                int i137 = ~((i_CREATION7 & i125) | (i125 ^ i_CREATION7));
                                int i138 = (i136 & i137) | (i136 ^ i137);
                                int i139 = (~i125) | i129;
                                int i140 = ~((i139 & 73) | (i139 ^ 73));
                                byte b2 = (byte) ((i135 - (~(((i138 & i140) | (i138 ^ i140)) * 369))) - 1);
                                Object[] objArr14 = new Object[1];
                                a(i124, cArr5, b2, objArr14);
                                Class<?> cls3 = Class.forName((String) objArr14[0]);
                                int i141 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                int i142 = (134762758 | i107) * (-192);
                                int i143 = ((-585785306) ^ i142) + ((i142 & (-585785306)) << 1);
                                int i144 = ~(((-600936081) & i107) | ((-600936081) ^ i107));
                                int i145 = -(-(((i144 & 17892368) | (17892368 ^ i144)) * (-384)));
                                int i146 = (i143 & i145) + (i145 | i143);
                                int i147 = ~(((-17892369) & i) | ((-17892369) ^ i));
                                int i148 = ((-600936081) & i107) | ((-600936081) ^ i107);
                                int i149 = ~((i148 & 152655126) | (i148 ^ 152655126));
                                int i150 = (i147 & i149) | (i147 ^ i149);
                                int i151 = ~((735698838 & i) | (735698838 ^ i));
                                int i152 = ((i150 & i151) | (i150 ^ i151)) * JfifUtil.MARKER_SOFn;
                                int i153 = (i146 ^ i152) + ((i152 & i146) << 1);
                                int i154 = ~i;
                                int i155 = (((-820202047) - (~(-(-(((~((i154 ^ (-1242517309)) | (i154 & (-1242517309)))) | (-2070346551)) * (-1042)))))) - (~(((-1242517309) | i) * 521))) - 1;
                                int i156 = (-2070937407) | (~((2070346550 ^ i) | (2070346550 & i)));
                                int i157 = (-2070346551) | i107;
                                int i158 = ~((i157 ^ (-1242517309)) | ((-1242517309) & i157));
                                int i159 = i153 > (i155 - (~(((i158 & i156) | (i156 ^ i158)) * 521))) - 1 ? (319 >>> i141) >>> (-1) : (i141 * 319) - 4121;
                                int i160 = ~i141;
                                int i161 = ~((i160 & i) | (i160 ^ i));
                                int i162 = (-318) * ((i161 & (-14)) | ((-14) ^ i161));
                                int i163 = (i159 & i162) + (i159 | i162);
                                int i164 = ~(((-14) & i) | ((-14) ^ i));
                                int i165 = (i107 ^ i141) | (i107 & i141);
                                int i166 = ~((i165 & 13) | (i165 ^ 13));
                                int i167 = ((i164 & i166) | (i164 ^ i166)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET;
                                int i168 = (i163 ^ i167) + ((i167 & i163) << 1);
                                int i169 = ((-14) & i107) | ((-14) ^ i107);
                                int i170 = ~((i169 & i141) | (i169 ^ i141));
                                int i171 = (i141 & 13) | (i141 ^ 13);
                                int i172 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i173 = (i172 & 97) + (i172 | 97);
                                artificialFrame = i173 % 128;
                                if (i173 % 2 == 0) {
                                    int i174 = ~((i171 & i) | (i171 ^ i));
                                    Object[] objArr15 = new Object[1];
                                    b(i168 >> (TypedValues.AttributesType.TYPE_PIVOT_TARGET / ((i174 & i170) | (i170 ^ i174))), new char[]{32079, 2609, 51564, 38391, 18708, 48757, 17111, 55283, 32079, 2609, 1690, 46412, 26917, 40308}, objArr15);
                                    method = cls3.getMethod((String) objArr15[0], null);
                                } else {
                                    int i175 = ~((i171 & i) | (i171 ^ i));
                                    int i176 = -(-(((i175 & i170) | (i170 ^ i175)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET));
                                    Object[] objArr16 = new Object[1];
                                    b((i168 & i176) + (i176 | i168), new char[]{32079, 2609, 51564, 38391, 18708, 48757, 17111, 55283, 32079, 2609, 1690, 46412, 26917, 40308}, objArr16);
                                    method = cls3.getMethod((String) objArr16[0], null);
                                }
                                Object objInvoke2 = method.invoke(context, null);
                                int i177 = getARTIFICIAL_FRAME_PACKAGE_NAME + 95;
                                artificialFrame = i177 % 128;
                                int i178 = i177 % 2;
                                try {
                                    Object[] objArr17 = {objInvoke2, 64};
                                    Object[] objArr18 = new Object[1];
                                    b(33 - (Process.myTid() >> 22), new char[]{24278, 24361, 47799, 39576, 29541, 2131, 23810, 58935, 28425, 39379, 21919, 51116, 29352, 14459, 44029, 51102, 15914, 27133, 19678, 26251, 18708, 48757, 17111, 55283, 32079, 2609, 225, 9916, 2759, 44141, 32079, 2609, 15577, 42297}, objArr18);
                                    Class<?> cls4 = Class.forName((String) objArr18[0]);
                                    int i179 = 13 - (~(ViewConfiguration.getScrollDefaultDelay() >> 16));
                                    char[] cArr6 = {28, CoreConstants.PERCENT_CHAR, '0', 23, '#', '0', 20, '#', 28, CoreConstants.PERCENT_CHAR, '\b', '\t', 19, '0'};
                                    int i180 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                    int i_CREATION8 = com.facebook.applinks.R.integer._CREATION();
                                    int i181 = i180 * (-464);
                                    int i182 = ((i181 | (-48308)) << 1) - (i181 ^ (-48308));
                                    int i183 = ~i180;
                                    int i184 = ((~(i_CREATION8 | 52)) | i183) * (-465);
                                    int i185 = (i182 & i184) + (i182 | i184);
                                    int i186 = ~((i183 ^ i_CREATION8) | (i183 & i_CREATION8));
                                    byte b3 = (byte) (i185 + (((i186 ^ 52) | (i186 & 52)) * 930) + ((i183 | (i_CREATION8 & 52) | (i_CREATION8 ^ 52)) * 465));
                                    Object[] objArr19 = new Object[1];
                                    a(i179, cArr6, b3, objArr19);
                                    Object objInvoke3 = cls4.getMethod((String) objArr19[0], String.class, Integer.TYPE).invoke(objInvoke, objArr17);
                                    int i187 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                    int i188 = i187 * 141;
                                    int i189 = (i188 ^ (-4309)) + ((i188 & (-4309)) << 1);
                                    int i190 = ~i187;
                                    int i191 = -(-(((~((i190 ^ 31) | (i190 & 31))) | (~(i190 | i))) * (-280)));
                                    int i192 = ((i189 | i191) << 1) - (i189 ^ i191);
                                    int i193 = ~i187;
                                    int i194 = ~((i193 ^ i) | (i193 & i));
                                    int i195 = ~(((-32) & i) | ((-32) ^ i));
                                    int i196 = -(-(((i194 & i195) | (i194 ^ i195)) * 140));
                                    int i197 = i193 | (-32);
                                    int i198 = ~((i197 & i) | (i197 ^ i));
                                    int i199 = i190 | i107;
                                    int i200 = ~((i199 & 31) | (i199 ^ 31));
                                    int i201 = (i200 & i198) | (i198 ^ i200);
                                    int i202 = ((-32) ^ i107) | ((-32) & i107);
                                    int i203 = (((i192 ^ i196) + ((i196 & i192) << 1)) - (~(-(-(((~((i187 & i202) | (i202 ^ i187))) | i201) * 140))))) - 1;
                                    char[] cArr7 = {'$', CharUtils.CR, 5, 23, CoreConstants.COMMA_CHAR, CoreConstants.LEFT_PARENTHESIS_CHAR, 4, CoreConstants.PERCENT_CHAR, '+', '0', '\t', '+', '$', 7, '.', CoreConstants.PERCENT_CHAR, ' ', '0', CoreConstants.RIGHT_PARENTHESIS_CHAR, 25, '#', '0', 20, '#', 28, CoreConstants.PERCENT_CHAR, '\b', '\t', 19, '0'};
                                    int i204 = -(ViewConfiguration.getKeyRepeatDelay() >> 16);
                                    int i_CREATION9 = com.facebook.applinks.R.integer._CREATION();
                                    int i205 = i204 * (-813);
                                    int i206 = (i204 ^ i_CREATION9) | (i204 & i_CREATION9);
                                    int i207 = (((i205 & 24888) + (i205 | 24888)) - (~(((~(((-62) & i204) | ((-62) ^ i204))) | (~i206)) * (-814)))) - 1;
                                    int i208 = ~i_CREATION9;
                                    int i209 = ~(((-62) ^ i208) | (i208 & (-62)));
                                    int i210 = ~i204;
                                    int i211 = ~((i210 ^ 61) | (i210 & 61));
                                    int i212 = (i209 ^ i211) | (i211 & i209);
                                    int i213 = ~i206;
                                    int i214 = i207 + (((i212 & i213) | (i212 ^ i213)) * 407);
                                    int i215 = ~i204;
                                    int i216 = ~((i215 & 61) | (i215 ^ 61));
                                    int i217 = ~((i210 ^ i_CREATION9) | (i210 & i_CREATION9));
                                    int i218 = (i216 & i217) | (i216 ^ i217);
                                    int i219 = ~((i_CREATION9 ^ 61) | (i_CREATION9 & 61));
                                    byte b4 = (byte) (i214 + (((i218 & i219) | (i218 ^ i219)) * 407));
                                    Object[] objArr20 = new Object[1];
                                    a(i203, cArr7, b4, objArr20);
                                    Class<?> cls5 = Class.forName((String) objArr20[0]);
                                    int i220 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
                                    int i221 = (i220 ^ 10) + ((i220 & 10) << 1);
                                    char[] cArr8 = {30, '$', 29, '\t', CoreConstants.PERCENT_CHAR, '0', '/', '!', '$', 28};
                                    int i222 = -TextUtils.indexOf("", "");
                                    int i223 = i222 * 273;
                                    int i224 = (i223 ^ (-8943)) + ((i223 & (-8943)) << 1);
                                    int i225 = ~i222;
                                    int i226 = ~(i225 | (-34) | i154);
                                    int i227 = (i222 ^ 33) | (i222 & 33);
                                    int i228 = ~((i227 & i) | (i227 ^ i));
                                    int i229 = (i224 - (~(((i226 & i228) | (i226 ^ i228)) * (-272)))) - 1;
                                    int i230 = ~i222;
                                    int i231 = ~((i230 & 33) | (i230 ^ 33));
                                    int i232 = ~((i225 & i) | (i225 ^ i));
                                    int i233 = ((i232 & i231) | (i231 ^ i232)) * (-272);
                                    int i234 = (i229 & i233) + (i233 | i229);
                                    int i235 = ~((i222 & i) | (i222 ^ i));
                                    int i236 = ((i235 & 33) | (i235 ^ 33)) * 272;
                                    Object[] objArr21 = new Object[1];
                                    a(i221, cArr8, (byte) ((i234 & i236) + (i236 | i234)), objArr21);
                                    Object[] objArr22 = (Object[]) cls5.getField((String) objArr21[0]).get(objInvoke3);
                                    int length = objArr22.length;
                                    int i237 = 0;
                                    while (true) {
                                        if (i237 < length) {
                                            int i238 = artificialFrame + 69;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i238 % 128;
                                            if (i238 % 2 != 0) {
                                                obj2 = objArr22[i237];
                                                i10 = 4 % (TypedValue.complexToFloat(i20) > 2.0f ? 1 : (TypedValue.complexToFloat(i20) == 2.0f ? 0 : -1));
                                            } else {
                                                obj2 = objArr22[i237];
                                                int i239 = -(-(TypedValue.complexToFloat(i22) > 0.0f ? 1 : (TypedValue.complexToFloat(i22) == 0.0f ? 0 : -1)));
                                                i10 = (i239 ^ 5) + ((i239 & 5) << i20);
                                            }
                                            char[] cArr9 = {11, CoreConstants.RIGHT_PARENTHESIS_CHAR, 25, 29, 13771};
                                            int defaultSize = View.getDefaultSize(i22, i22);
                                            int i240 = (defaultSize * (-209)) - 8360;
                                            int i241 = artificialFrame;
                                            int i242 = ((i241 | b.f40o) << i20) - (i241 ^ b.f40o);
                                            int i243 = i242 % 128;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i243;
                                            int i244 = i242 % 2;
                                            int i245 = ~defaultSize;
                                            int i246 = -(-((~((i245 ^ (-41)) | (i245 & (-41)))) * 210));
                                            int i247 = ((i240 | i246) << 1) - (i246 ^ i240);
                                            int i248 = ~(((-41) ^ i107) | ((-41) & i107));
                                            int i249 = i243 + 107;
                                            artificialFrame = i249 % 128;
                                            int i250 = i249 % 2;
                                            int i251 = ~((i245 ^ i) | (i245 & i));
                                            int i252 = ((i251 & i248) | (i248 ^ i251)) * 210;
                                            if (i250 == 0) {
                                                i11 = i247 - i252;
                                                i12 = i245 | i107;
                                            } else {
                                                i11 = (i247 - (~i252)) - 1;
                                                int i253 = ~defaultSize;
                                                i12 = (i253 & i107) | (i253 ^ i107);
                                            }
                                            int i254 = ~((i12 & 40) | (i12 ^ 40));
                                            int i255 = ((-41) & defaultSize) | ((-41) ^ defaultSize);
                                            int i256 = ~((i255 & i) | (i255 ^ i));
                                            int i257 = -(-(210 * ((i254 & i256) | (i254 ^ i256))));
                                            Object[] objArr23 = new Object[1];
                                            a(i10, cArr9, (byte) ((i11 ^ i257) + ((i11 & i257) << 1)), objArr23);
                                            String str = (String) objArr23[0];
                                            int i258 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            int i259 = ((i258 | 91) << 1) - (i258 ^ 91);
                                            artificialFrame = i259 % 128;
                                            if (i259 % 2 == 0) {
                                                try {
                                                    objArr2 = new Object[0];
                                                    objArr2[1] = str;
                                                    gidForName = 64 >>> Process.getGidForName("");
                                                    i13 = 102;
                                                    cArr = new char[]{27, Typography.amp, 20, '$', '$', ' ', '*', 0, '/', '!', CoreConstants.COMMA_CHAR, 2, 4, CoreConstants.LEFT_PARENTHESIS_CHAR, 0, '*', 23, '/', Typography.amp, ' ', CoreConstants.LEFT_PARENTHESIS_CHAR, 21, 2, CoreConstants.COMMA_CHAR, 16, CoreConstants.RIGHT_PARENTHESIS_CHAR, '0', '#', '*', CoreConstants.PERCENT_CHAR, 6, CoreConstants.SINGLE_QUOTE_CHAR, '+', CoreConstants.DASH_CHAR, 5, '!', 13853};
                                                } catch (Throwable th) {
                                                    Throwable cause = th.getCause();
                                                    if (cause != null) {
                                                        throw cause;
                                                    }
                                                    throw th;
                                                }
                                            } else {
                                                objArr2 = new Object[]{str};
                                                int i260 = -(-Process.getGidForName(""));
                                                gidForName = ((i260 | 38) << 1) - (i260 ^ 38);
                                                cArr = new char[]{27, Typography.amp, 20, '$', '$', ' ', '*', 0, '/', '!', CoreConstants.COMMA_CHAR, 2, 4, CoreConstants.LEFT_PARENTHESIS_CHAR, 0, '*', 23, '/', Typography.amp, ' ', CoreConstants.LEFT_PARENTHESIS_CHAR, 21, 2, CoreConstants.COMMA_CHAR, 16, CoreConstants.RIGHT_PARENTHESIS_CHAR, '0', '#', '*', CoreConstants.PERCENT_CHAR, 6, CoreConstants.SINGLE_QUOTE_CHAR, '+', CoreConstants.DASH_CHAR, 5, '!', 13853};
                                                i13 = 58;
                                            }
                                            Object[] objArr24 = new Object[1];
                                            a(gidForName, cArr, (byte) (i13 + ExpandableListView.getPackedPositionType(0L)), objArr24);
                                            Class<?> cls6 = Class.forName((String) objArr24[0]);
                                            int maximumFlingVelocity = 11 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                            char[] cArr10 = {28, CoreConstants.PERCENT_CHAR, '*', '\t', 15, '$', '0', CoreConstants.PERCENT_CHAR, 7, '+', 13880};
                                            int i261 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            int i262 = ((i261 | 125) << 1) - (i261 ^ 125);
                                            artificialFrame = i262 % 128;
                                            if (i262 % 2 == 0) {
                                                i14 = -TextUtils.lastIndexOf("", 'G');
                                                i_CREATION = com.facebook.applinks.R.integer._CREATION();
                                                i15 = AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR;
                                            } else {
                                                i14 = -TextUtils.lastIndexOf("", '0');
                                                i_CREATION = com.facebook.applinks.R.integer._CREATION();
                                                i15 = 56;
                                            }
                                            int i263 = 1773 * i14;
                                            int i264 = i15 * (-885);
                                            int i265 = (i263 ^ i264) + ((i263 & i264) << 1);
                                            int i266 = ~i14;
                                            Object[] objArr25 = objArr22;
                                            int i267 = ~i15;
                                            int i268 = ~((i266 ^ i267) | (i266 & i267));
                                            int i269 = ~((i267 ^ i_CREATION) | (i267 & i_CREATION));
                                            int i270 = (i268 ^ i269) | (i269 & i268);
                                            int i271 = ~i_CREATION;
                                            int i272 = (i271 ^ i14) | (i271 & i14);
                                            int i273 = ~((i272 ^ i15) | (i272 & i15));
                                            int i274 = i265 + (((i270 ^ i273) | (i270 & i273)) * 886);
                                            int i275 = ~i_CREATION;
                                            int i276 = (i274 - (~(-(-(((~((i275 ^ i15) | (i275 & i15))) | i14) * (-1772)))))) - 1;
                                            int i277 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            int i278 = ((i277 | 61) << 1) - (i277 ^ 61);
                                            artificialFrame = i278 % 128;
                                            int i279 = i278 % 2;
                                            int i280 = 886 * (~((i275 & i14) | (i275 ^ i14)));
                                            byte b5 = (byte) (((i276 | i280) << 1) - (i276 ^ i280));
                                            Object[] objArr26 = new Object[1];
                                            a(maximumFlingVelocity, cArr10, b5, objArr26);
                                            Object objInvoke4 = cls6.getMethod((String) objArr26[0], String.class).invoke(null, objArr2);
                                            try {
                                                int i281 = -KeyEvent.keyCodeFromString("");
                                                int i282 = ~i281;
                                                int i283 = ~((i282 & (-29)) | (i282 ^ (-29)));
                                                int i284 = ~((i154 ^ i281) | (i154 & i281) | 28);
                                                int i285 = (((i281 * 221) - 6132) - (~(-(-(((i283 & i284) | (i283 ^ i284)) * 220))))) - 1;
                                                int i286 = ~((i107 ^ 28) | (i107 & 28));
                                                Object[] objArr27 = new Object[1];
                                                b(((i285 - (~(((i286 & i281) | (i281 ^ i286)) * (-440)))) - 1) + (((i281 & 28) | (i281 ^ 28) | i) * 220), new char[]{24278, 24361, 47799, 39576, 29541, 2131, 23810, 58935, 28425, 39379, 21919, 51116, 29352, 14459, 44029, 51102, 15914, 27133, 22641, 12223, 43111, 6526, 2759, 44141, 20418, 31585, 44961, 65007}, objArr27);
                                                Class<?> cls7 = Class.forName((String) objArr27[0]);
                                                int iIndexOf = TextUtils.indexOf("", "");
                                                int i_CREATION10 = com.facebook.applinks.R.integer._CREATION();
                                                int i287 = (iIndexOf * 367) + 4037 + ((iIndexOf | 11) * (-366));
                                                int i288 = ((~(((-12) & i_CREATION10) | ((-12) ^ i_CREATION10))) | iIndexOf) * (-366);
                                                int i289 = (i287 & i288) + (i287 | i288);
                                                int i290 = ~((~iIndexOf) | 11);
                                                int i291 = (iIndexOf & (-12)) | ((-12) ^ iIndexOf);
                                                int i292 = ~((i291 & i_CREATION10) | (i291 ^ i_CREATION10));
                                                int i293 = i290 ^ i292;
                                                Object[] objArr28 = new Object[1];
                                                b((i289 - (~(-(-(((i292 & i290) | i293) * 366))))) - 1, new char[]{17069, 52905, 7994, 9886, 27573, 37764, 53550, 36433, 9704, 49844, 42401, 17480}, objArr28);
                                                try {
                                                    Object[] objArr29 = {new ByteArrayInputStream((byte[]) cls7.getMethod((String) objArr28[0], null).invoke(obj2, null))};
                                                    int i294 = -((Process.getThreadPriority(0) + 20) >> 6);
                                                    int i_CREATION11 = com.facebook.applinks.R.integer._CREATION();
                                                    int i295 = i294 * (-129);
                                                    int i296 = (i295 ^ 4847) + ((i295 & 4847) << 1);
                                                    int i297 = (~i_CREATION11) | (-38);
                                                    int i298 = (i296 - (~(-(-((~((i297 & i294) | (i297 ^ i294))) * 130))))) - 1;
                                                    int i299 = -(-((~((-38) | i294)) * (-260)));
                                                    int i300 = (i298 ^ i299) + ((i298 & i299) << 1);
                                                    int i301 = ~((~i294) | 37);
                                                    int i302 = (i294 & (-38)) | ((-38) ^ i294);
                                                    int i303 = ~((i302 & i_CREATION11) | (i302 ^ i_CREATION11));
                                                    int i304 = ((i303 & i301) | (i301 ^ i303)) * 130;
                                                    int i305 = (i300 ^ i304) + ((i304 & i300) << 1);
                                                    char[] cArr11 = {27, Typography.amp, 20, '$', '$', ' ', '*', 0, '/', '!', CoreConstants.COMMA_CHAR, 2, 4, CoreConstants.LEFT_PARENTHESIS_CHAR, 0, '*', 23, '/', Typography.amp, ' ', CoreConstants.LEFT_PARENTHESIS_CHAR, 21, 2, CoreConstants.COMMA_CHAR, 16, CoreConstants.RIGHT_PARENTHESIS_CHAR, '0', '#', '*', CoreConstants.PERCENT_CHAR, 6, CoreConstants.SINGLE_QUOTE_CHAR, '+', CoreConstants.DASH_CHAR, 5, '!', 13853};
                                                    int tapTimeout = ViewConfiguration.getTapTimeout() >> 16;
                                                    int i306 = tapTimeout * 221;
                                                    int i307 = (i306 ^ (-12702)) + ((i306 & (-12702)) << 1);
                                                    int i308 = ~tapTimeout;
                                                    int i309 = ~((i308 & (-59)) | (i308 ^ (-59)));
                                                    int i310 = ~((i107 ^ tapTimeout) | (i107 & tapTimeout) | 58);
                                                    int i311 = ((i309 & i310) | (i309 ^ i310)) * 220;
                                                    int i312 = ((i307 | i311) << 1) - (i311 ^ i307);
                                                    int i313 = ~(i154 | 58);
                                                    int i314 = -(-(((i313 & tapTimeout) | (tapTimeout ^ i313)) * (-440)));
                                                    byte b6 = (byte) ((i312 ^ i314) + ((i314 & i312) << 1) + ((tapTimeout | 58 | i) * 220));
                                                    Object[] objArr30 = new Object[1];
                                                    a(i305, cArr11, b6, objArr30);
                                                    Class<?> cls8 = Class.forName((String) objArr30[0]);
                                                    Object[] objArr31 = new Object[1];
                                                    b(19 - (ViewConfiguration.getLongPressTimeout() >> 16), new char[]{32079, 2609, 48751, 2078, 9704, 49844, 27573, 37764, 62465, 30183, 56837, 23411, 35043, 38121, 28844, 54469, 4799, 31432, 48274, 28742}, objArr31);
                                                    Object objInvoke5 = cls8.getMethod((String) objArr31[0], InputStream.class).invoke(objInvoke4, objArr29);
                                                    int length2 = objArr5.length;
                                                    int i315 = 0;
                                                    while (true) {
                                                        if (i315 < 2) {
                                                            Object obj3 = objArr5[i315];
                                                            try {
                                                                int i316 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                                                int i317 = ((i316 | 35) << 1) - (i316 ^ 35);
                                                                char[] cArr12 = {27, Typography.amp, 20, '$', '$', ' ', '*', 0, '/', '!', CoreConstants.COMMA_CHAR, 2, 4, CoreConstants.LEFT_PARENTHESIS_CHAR, 0, '*', 23, '/', CoreConstants.RIGHT_PARENTHESIS_CHAR, 11, 25, 29, 17, Typography.amp, CoreConstants.LEFT_PARENTHESIS_CHAR, 21, 2, CoreConstants.COMMA_CHAR, 16, CoreConstants.RIGHT_PARENTHESIS_CHAR, '0', '#', '*', CoreConstants.PERCENT_CHAR};
                                                                int i318 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                                                Object[] objArr32 = new Object[1];
                                                                a(i317, cArr12, (byte) (((i318 | 100) << 1) - (i318 ^ 100)), objArr32);
                                                                Class<?> cls9 = Class.forName((String) objArr32[0]);
                                                                int i319 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                int i320 = (i319 & 71) + (i319 | 71);
                                                                artificialFrame = i320 % 128;
                                                                int i321 = i320 % 2;
                                                                int i322 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                                                                Object[] objArr33 = new Object[1];
                                                                b((i322 & 22) + (i322 | 22), new char[]{32079, 2609, 5251, 47400, 40805, 19707, 898, 39037, 33566, 27862, 65092, 34471, 38876, 23005, 53533, 39108, 20145, 26416, 6941, 44645, 2392, 44169, 63461, 5073}, objArr33);
                                                                if (obj3.equals(cls9.getMethod((String) objArr33[0], null).invoke(objInvoke5, null))) {
                                                                    int i323 = artificialFrame;
                                                                    int i324 = ((i323 | 27) << 1) - (i323 ^ 27);
                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i324 % 128;
                                                                    int i325 = i324 % 2;
                                                                    Object[] objArr34 = {new int[]{i}, new int[]{(i & (-2)) | (i107 & 1)}, new int[1], null};
                                                                    int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                                                                    int i326 = (-2014000914) + (((~((-174408348) | elapsedCpuTime)) | 174408323) * 104) + ((~((~elapsedCpuTime) | 804215451)) * (-104)) + ((elapsedCpuTime | 804215427) * 104);
                                                                    int i327 = -(-((i326 & 16) + (i326 | 16)));
                                                                    int i328 = (i2 & i327) + (i2 | i327);
                                                                    int i329 = i328 << 13;
                                                                    int i330 = (i329 & (~i328)) | ((~i329) & i328);
                                                                    int i331 = i330 >>> 17;
                                                                    int i332 = (i330 | i331) & (~(i330 & i331));
                                                                    int i333 = i332 << 5;
                                                                    ((int[]) objArr34[2])[0] = (i332 | i333) & (~(i332 & i333));
                                                                    objArr = objArr34;
                                                                    i17 = 2;
                                                                    i7 = 0;
                                                                } else {
                                                                    i315 = ((i315 & 1) << 1) + (i315 ^ 1);
                                                                }
                                                            } catch (Throwable th2) {
                                                                Throwable cause2 = th2.getCause();
                                                                if (cause2 != null) {
                                                                    throw cause2;
                                                                }
                                                                throw th2;
                                                            }
                                                        } else {
                                                            i237++;
                                                            objArr22 = objArr25;
                                                            i20 = 1;
                                                            i22 = 0;
                                                        }
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
                                        } else {
                                            objArr = new Object[4];
                                            int i334 = artificialFrame;
                                            int i335 = ((i334 | 41) << 1) - (i334 ^ 41);
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i335 % 128;
                                            int i336 = i335 % 2;
                                            objArr[0] = new int[1];
                                            objArr[1] = new int[1];
                                            objArr[2] = new int[1];
                                            int i337 = ~((-964111995) | i);
                                            int i338 = (-1927802320) + (((i337 & (-155331848)) | ((-155331848) ^ i337)) * (-668));
                                            int i339 = ~(((-155331848) & i) | ((-155331848) ^ i));
                                            int i340 = ((-964111995) & i) | ((-964111995) ^ i);
                                            i3 = ((i338 - (~(((i339 & (-964111995)) | ((-964111995) ^ i339)) * 1336))) - 1) + (((i340 & (-155331848)) | (i340 ^ (-155331848))) * 668);
                                            int i_CREATION12 = com.facebook.applinks.R.integer._CREATION();
                                            int i341 = ~i_CREATION12;
                                            i4 = ~((i341 & 1057234081) | (i341 ^ 1057234081));
                                            i5 = i4 ^ 3842896;
                                            i6 = ~(i_CREATION12 | 1057234081);
                                            if (i3 > (((-386202942) + (((i4 & 3842896) | i5) * 529)) - (~(((i6 & 976925648) | (976925648 ^ i6)) * 529))) - 1) {
                                                ((int[]) objArr[0])[0] = i;
                                            } else {
                                                ((int[]) objArr[0])[0] = i;
                                            }
                                            ((int[]) objArr[1])[0] = i;
                                            objArr[3] = null;
                                            int i342 = ~i;
                                            int i343 = -(-(1721261363 + (((~((-208813081) | i342)) | (-769810695)) * (-983)) + (((~(i342 | (-769810695))) | 562053382) * 983)));
                                            int i344 = (i2 & i343) + (i2 | i343);
                                            int i345 = (i344 << 13) ^ i344;
                                            int i346 = i345 >>> 17;
                                            int i347 = ((~i345) & i346) | ((~i346) & i345);
                                            int i348 = i347 << 5;
                                            int i349 = (i347 | i348) & (~(i347 & i348));
                                            i17 = 2;
                                            i7 = 0;
                                            ((int[]) objArr[2])[0] = i349;
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
                objArr = new Object[4];
                int i3310 = artificialFrame;
                int i3311 = ((i3310 | 41) << 1) - (i3310 ^ 41);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i3311 % 128;
                int i3312 = i3311 % 2;
                objArr[0] = new int[1];
                objArr[1] = new int[1];
                objArr[2] = new int[1];
                int i3313 = ~((-964111995) | i);
                int i3314 = (-1927802320) + (((i3313 & (-155331848)) | ((-155331848) ^ i3313)) * (-668));
                int i3315 = ~(((-155331848) & i) | ((-155331848) ^ i));
                int i3410 = ((-964111995) & i) | ((-964111995) ^ i);
                i3 = ((i3314 - (~(((i3315 & (-964111995)) | ((-964111995) ^ i3315)) * 1336))) - 1) + (((i3410 & (-155331848)) | (i3410 ^ (-155331848))) * 668);
                int i_CREATION13 = com.facebook.applinks.R.integer._CREATION();
                int i3411 = ~i_CREATION13;
                i4 = ~((i3411 & 1057234081) | (i3411 ^ 1057234081));
                i5 = i4 ^ 3842896;
                i6 = ~(i_CREATION13 | 1057234081);
                if (i3 > (((-386202942) + (((i4 & 3842896) | i5) * 529)) - (~(((i6 & 976925648) | (976925648 ^ i6)) * 529))) - 1) {
                    ((int[]) objArr[0])[0] = i;
                } else {
                    ((int[]) objArr[0])[0] = i;
                }
                ((int[]) objArr[1])[0] = i;
                objArr[3] = null;
                int i3412 = ~i;
                int i3413 = -(-(1721261363 + (((~((-208813081) | i3412)) | (-769810695)) * (-983)) + (((~(i3412 | (-769810695))) | 562053382) * 983)));
                int i3414 = (i2 & i3413) + (i2 | i3413);
                int i3415 = (i3414 << 13) ^ i3414;
                int i3416 = i3415 >>> 17;
                int i3417 = ((~i3415) & i3416) | ((~i3416) & i3415);
                int i3418 = i3417 << 5;
                int i3419 = (i3417 | i3418) & (~(i3417 & i3418));
                i17 = 2;
                i7 = 0;
                ((int[]) objArr[2])[0] = i3419;
            }
        }
        int i350 = getARTIFICIAL_FRAME_PACKAGE_NAME + 41;
        artificialFrame = i350 % 128;
        if (i350 % i17 == 0) {
            int i351 = 88 / i7;
        }
        return objArr;
    }
}
