package com.facebook.react.uimanager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.google.android.material.carousel.KeylineState;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.onRelationshipValidationResult;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public class ThemedReactContext extends ReactContext {
    private final String mModuleName;
    private final ReactApplicationContext mReactApplicationContext;
    private final int mSurfaceId;
    private static final byte[] $$c = {85, -33, -39, -30};
    private static final int $$f = 226;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$d = {0, -128, -114, 48, -33, 2, 3, Ascii.DC2, 6, 2, -55, 1, 65, Ascii.VT, Ascii.FF, -9, 19, 2, -7, 17, -56, 79, 2, -63, 42, Ascii.EM, 2, 17, -15, Ascii.DC4, 3, -9, 34, -6, Ascii.SO, 0, Ascii.NAK, -74, 57, 33, -3, 17, -9, 19, -24, 19, Ascii.CAN, -2, 6, 67, Ascii.DC2, 4, -57, Utf8.REPLACEMENT_BYTE, Ascii.SO, 6, -2, Ascii.VT, -1, -49, 59, Ascii.NAK, Ascii.CR, -3, 10, 1, -59, 76, -5, Ascii.VT, 3, -55, 57, 10, 2, 9, -48, Ascii.EM, 42, Ascii.DC4, -40, 34, Ascii.GS, -39, 32, Ascii.SUB, -79, 19};
    private static final int $$e = b.f39n;
    private static final byte[] $$a = {52, -111, -122, 98, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$b = 125;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long onPostMessage = 5234697040387613306L;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$i(int r7, int r8, int r9) {
        /*
            int r7 = r7 * 2
            int r7 = 4 - r7
            int r8 = r8 * 4
            int r8 = 1 - r8
            int r9 = r9 * 2
            int r9 = 111 - r9
            byte[] r0 = com.facebook.react.uimanager.ThemedReactContext.$$c
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r9 = r7
            r3 = r8
            r4 = r2
            goto L2b
        L17:
            r3 = r2
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L25:
            r3 = r0[r7]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r6
        L2b:
            int r7 = -r7
            int r9 = r9 + 1
            int r7 = r7 + r3
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r6
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ThemedReactContext.$$i(int, int, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(int r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 8
            int r8 = r8 + 4
            int r7 = r7 * 28
            int r7 = 112 - r7
            int r9 = r9 * 3
            int r9 = r9 + 9
            byte[] r0 = com.facebook.react.uimanager.ThemedReactContext.$$a
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r8
            r8 = r9
            r4 = r2
            goto L2d
        L17:
            r3 = r2
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r6
        L2d:
            int r7 = -r7
            int r7 = r7 + r8
            int r8 = r3 + 1
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ThemedReactContext.a(int, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r5, short r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.facebook.react.uimanager.ThemedReactContext.$$d
            int r5 = r5 * 3
            int r5 = r5 + 36
            int r7 = r7 + 5
            int r1 = r6 + 3
            byte[] r1 = new byte[r1]
            int r6 = r6 + 2
            r2 = 0
            if (r0 != 0) goto L15
            r4 = r5
            r5 = r6
            r3 = r2
            goto L27
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r5
            r1[r3] = r4
            if (r3 != r6) goto L23
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L23:
            r4 = r0[r7]
            int r3 = r3 + 1
        L27:
            int r7 = r7 + 1
            int r5 = r5 + r4
            int r5 = r5 + (-6)
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ThemedReactContext.c(int, short, int, java.lang.Object[]):void");
    }

    @Deprecated
    public ThemedReactContext(ReactApplicationContext reactApplicationContext, Context context) {
        this(reactApplicationContext, context, null, -1);
    }

    @Deprecated
    public ThemedReactContext(ReactApplicationContext reactApplicationContext, Context context, @Nullable String str) {
        this(reactApplicationContext, context, str, -1);
    }

    public ThemedReactContext(ReactApplicationContext reactApplicationContext, Context context, @Nullable String str, int i) {
        super(context);
        initializeFromOther(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        this.mModuleName = str;
        this.mSurfaceId = i;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void addLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.mReactApplicationContext.addLifecycleEventListener(lifecycleEventListener);
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        Object obj;
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        while (true) {
            obj = null;
            if (onrelationshipvalidationresult.e >= cArrAccessartificialFrame.length) {
                break;
            }
            int i3 = $11 + 117;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i5 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 27, (char) (Color.green(0) + 30690), 188 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(32 - ExpandableListView.getPackedPositionChild(0L), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 1483 - Color.green(0), -1940971975, false, $$i(b, b2, b2), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                int i6 = $11 + 27;
                $10 = i6 % 128;
                int i7 = i6 % 2;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        String str = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
        int i8 = $11 + 69;
        $10 = i8 % 128;
        if (i8 % 2 == 0) {
            objArr[0] = str;
        } else {
            obj.hashCode();
            throw null;
        }
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void removeLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.mReactApplicationContext.removeLifecycleEventListener(lifecycleEventListener);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasCurrentActivity() {
        return this.mReactApplicationContext.hasCurrentActivity();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public Activity getCurrentActivity() {
        return this.mReactApplicationContext.getCurrentActivity();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public <T extends JavaScriptModule> T getJSModule(Class<T> cls) {
        return (T) this.mReactApplicationContext.getJSModule(cls);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public <T extends NativeModule> boolean hasNativeModule(Class<T> cls) {
        return this.mReactApplicationContext.hasNativeModule(cls);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public Collection<NativeModule> getNativeModules() {
        return this.mReactApplicationContext.getNativeModules();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public <T extends NativeModule> T getNativeModule(Class<T> cls) {
        return (T) this.mReactApplicationContext.getNativeModule(cls);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public NativeModule getNativeModule(String str) {
        return this.mReactApplicationContext.getNativeModule(str);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public CatalystInstance getCatalystInstance() {
        return this.mReactApplicationContext.getCatalystInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Deprecated
    public boolean hasActiveCatalystInstance() {
        return this.mReactApplicationContext.hasActiveCatalystInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasActiveReactInstance() {
        return this.mReactApplicationContext.hasActiveCatalystInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasCatalystInstance() {
        return this.mReactApplicationContext.hasCatalystInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasReactInstance() {
        return this.mReactApplicationContext.hasReactInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void destroy() {
        this.mReactApplicationContext.destroy();
    }

    @Deprecated
    public String getSurfaceID() {
        return this.mModuleName;
    }

    public String getModuleName() {
        return this.mModuleName;
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    public ReactApplicationContext getReactApplicationContext() {
        return this.mReactApplicationContext;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void handleException(Exception exc) {
        this.mReactApplicationContext.handleException(exc);
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Deprecated
    public boolean isBridgeless() {
        return this.mReactApplicationContext.isBridgeless();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public JavaScriptContextHolder getJavaScriptContextHolder() {
        return this.mReactApplicationContext.getJavaScriptContextHolder();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public CallInvokerHolder getJSCallInvokerHolder() {
        return this.mReactApplicationContext.getJSCallInvokerHolder();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public UIManager getFabricUIManager() {
        return this.mReactApplicationContext.getFabricUIManager();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public String getSourceURL() {
        return this.mReactApplicationContext.getSourceURL();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void registerSegment(int i, String str, Callback callback) {
        this.mReactApplicationContext.registerSegment(i, str, callback);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x018e  */
    /* JADX WARN: Code duplicated, block: B:16:0x0203 A[Catch: all -> 0x09df, TryCatch #3 {all -> 0x09df, blocks: (B:51:0x06ce, B:53:0x06ee, B:54:0x073e, B:14:0x01ef, B:16:0x0203, B:17:0x0236), top: B:101:0x01ef }] */
    /* JADX WARN: Code duplicated, block: B:20:0x024c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0307  */
    /* JADX WARN: Code duplicated, block: B:50:0x0649  */
    /* JADX WARN: Code duplicated, block: B:53:0x06ee A[Catch: all -> 0x09df, TryCatch #3 {all -> 0x09df, blocks: (B:51:0x06ce, B:53:0x06ee, B:54:0x073e, B:14:0x01ef, B:16:0x0203, B:17:0x0236), top: B:101:0x01ef }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0750  */
    /* JADX WARN: Code duplicated, block: B:62:0x07fc  */
    @Override // com.facebook.react.bridge.ReactContext, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArrAccessartificialFrame$78cbbd35;
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
            int threadPriority = 26 - ((Process.getThreadPriority(0) + 20) >> 6);
            char cRed = (char) Color.red(0);
            int i2 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1041;
            byte b = (byte) ($$a[5] - 1);
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(threadPriority, cRed, i2, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            int i3 = artificialFrame + 55;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
            int i4 = i3 % 2;
            long j2 = j + 4611686018427387809L;
            Object[] objArr3 = new Object[1];
            b(TextUtils.indexOf((CharSequence) "", '0', 0) + 1, new char[]{58367, 58270, 14653, 51305, 10996, 6696, 51428, 51700, 10104, 36726, 28636, 20812, 27200, 16964, 42126, 38105, 44350, 1724, 63932, 60407, 61490, 15780, 16028, 11989, 15124, 61588}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(TextUtils.getOffsetAfter("", 0), new char[]{61767, 61730, 5809, 59367, 30090, 54047, 38815, 193, 13788, 41206, 12455, 38917, 30962, 28122, 64439, 24011, 49046, 10542, 42710}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i5 = artificialFrame + 45;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                int i6 = i5 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int iLastIndexOf = 25 - TextUtils.lastIndexOf("", '0', 0, 0);
                    char absoluteGravity = (char) Gravity.getAbsoluteGravity(0, 0);
                    int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1042;
                    byte b3 = $$a[5];
                    byte b4 = (byte) (b3 - 1);
                    byte b5 = b3;
                    Object[] objArr5 = new Object[1];
                    a(b4, b5, (byte) (b5 - 1), objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, absoluteGravity, iIndexOf, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i7 = ((int[]) objArr6[3])[0];
                int i8 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1433508547;
                int i9 = ((((-1097905488) + (((~((-392433839) | length)) | 88084480) * 345)) + (((~((-392433839) | (~length))) | (-402414512)) * 345)) + ((~(length | (-88084481))) * 345)) - 1928725049;
                int i10 = (i9 << 13) ^ i9;
                int i11 = i10 ^ (i10 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i11 ^ (i11 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                b(ViewConfiguration.getEdgeSlop() >> 16, new char[]{36519, 36557, 38739, 26120, 49200, 10704, 8754, 64031, 19041, 8477, 34063, 25319, 1808, 60535, 20005, 42776, 49260, 43221, 4987, 55316}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{59920, 60025, 50885, 14235, 20436, 21447, 44485, 32775, 11916, 28814, 2797, 6376, 25480, 48558, 49650, 56593, 42219, 63832, 40077, 41476}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {1761753034};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 7, (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 22251), 1034 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = KeylineState.Keyline.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -1928725049, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int deadChar = KeyEvent.getDeadChar(0, 0) + 26;
                        char c = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                        int iAlpha = 1041 - Color.alpha(0);
                        byte b6 = $$a[5];
                        byte b7 = (byte) (b6 - 1);
                        byte b8 = b6;
                        Object[] objArr10 = new Object[1];
                        a(b7, b8, (byte) (b8 - 1), objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(deadChar, c, iAlpha, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        b(1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{58367, 58270, 14653, 51305, 10996, 6696, 51428, 51700, 10104, 36726, 28636, 20812, 27200, 16964, 42126, 38105, 44350, 1724, 63932, 60407, 61490, 15780, 16028, 11989, 15124, 61588}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 37, new char[]{61767, 61730, 5809, 59367, 30090, 54047, 38815, 193, 13788, 41206, 12455, 38917, 30962, 28122, 64439, 24011, 49046, 10542, 42710}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int i12 = 27 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                            char c2 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                            int i13 = 1042 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                            byte b9 = (byte) ($$a[5] - 1);
                            byte b10 = b9;
                            Object[] objArr13 = new Object[1];
                            a(b9, b10, b10, objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i12, c2, i13, 2061780482, false, (String) objArr13[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
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
            b(ViewConfiguration.getEdgeSlop() >> 16, new char[]{36519, 36557, 38739, 26120, 49200, 10704, 8754, 64031, 19041, 8477, 34063, 25319, 1808, 60535, 20005, 42776, 49260, 43221, 4987, 55316}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{59920, 60025, 50885, 14235, 20436, 21447, 44485, 32775, 11916, 28814, 2797, 6376, 25480, 48558, 49650, 56593, 42219, 63832, 40077, 41476}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {1761753034};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 7, (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 22251), 1034 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = KeylineState.Keyline.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -1928725049, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int deadChar2 = KeyEvent.getDeadChar(0, 0) + 26;
                char c3 = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                int iAlpha2 = 1041 - Color.alpha(0);
                byte b11 = $$a[5];
                byte b12 = (byte) (b11 - 1);
                byte b13 = b11;
                Object[] objArr17 = new Object[1];
                a(b12, b13, (byte) (b13 - 1), objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(deadChar2, c3, iAlpha2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            b(1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{58367, 58270, 14653, 51305, 10996, 6696, 51428, 51700, 10104, 36726, 28636, 20812, 27200, 16964, 42126, 38105, 44350, 1724, 63932, 60407, 61490, 15780, 16028, 11989, 15124, 61588}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 37, new char[]{61767, 61730, 5809, 59367, 30090, 54047, 38815, 193, 13788, 41206, 12455, 38917, 30962, 28122, 64439, 24011, 49046, 10542, 42710}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int i14 = 27 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                char c4 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                int i15 = 1042 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                byte b14 = (byte) ($$a[5] - 1);
                byte b15 = b14;
                Object[] objArr110 = new Object[1];
                a(b14, b15, b15, objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i14, c4, i15, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i17 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i17 == i16) {
            int i18 = getARTIFICIAL_FRAME_PACKAGE_NAME + 41;
            artificialFrame = i18 % 128;
            int i19 = i18 % 2;
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i20 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i21 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i22 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 878968959;
            int i23 = i20 + ((((~(length2 | 666147830)) | (-588044024)) * 56) - 31077066) + (((~((~length2) | (-588044024))) | 666147830) * 56);
            int i24 = (i23 << 13) ^ i23;
            int i25 = i24 ^ (i24 >>> 17);
            ((int[]) objArr20[1])[0] = i25 ^ (i25 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) 454244927) << 32) ^ ((long) (i16 ^ i17))), Long.valueOf(454244925)};
                byte[] bArr = $$d;
                Object[] objArr22 = new Object[1];
                c(bArr[25], (byte) (bArr[24] - 1), bArr[0], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b16 = bArr[0];
                byte b17 = b16;
                Object[] objArr23 = new Object[1];
                c(b16, b17, (byte) (b17 | 43), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i26 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i27 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i28 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i29 = i26 + 1513740638 + (((~((-574670344) | iIdentityHashCode)) | (~((~iIdentityHashCode) | (-496566537)))) * (-318)) + (((~(577042071 | iIdentityHashCode)) | (-1073608608)) * (-318)) + (((~(iIdentityHashCode | (-577042072))) | 498938264) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
                int i30 = (i29 << 13) ^ i29;
                int i31 = i30 ^ (i30 >>> 17);
                ((int[]) objArr24[1])[0] = i31 ^ (i31 << 5);
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
            int capsMode = 25 - TextUtils.getCapsMode("", 0, 0);
            char cRgb = (char) (Color.rgb(0, 0, 0) + 16807284);
            int packedPositionChild = 815 - ExpandableListView.getPackedPositionChild(0L);
            byte b18 = (byte) ($$a[5] - 1);
            byte b19 = b18;
            Object[] objArr25 = new Object[1];
            a(b18, b19, b19, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(capsMode, cRgb, packedPositionChild, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 1915;
            Object[] objArr26 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{58367, 58270, 14653, 51305, 10996, 6696, 51428, 51700, 10104, 36726, 28636, 20812, 27200, 16964, 42126, 38105, 44350, 1724, 63932, 60407, 61490, 15780, 16028, 11989, 15124, 61588}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{61767, 61730, 5809, 59367, 30090, 54047, 38815, 193, 13788, 41206, 12455, 38917, 30962, 28122, 64439, 24011, 49046, 10542, 42710}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 25;
                    char gidForName = (char) (30067 - Process.getGidForName(""));
                    int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0') + 817;
                    byte b20 = $$a[5];
                    byte b21 = (byte) (b20 - 1);
                    byte b22 = b20;
                    Object[] objArr28 = new Object[1];
                    a(b21, b22, (byte) (b22 - 1), objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, gidForName, iIndexOf2, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i32 = ((int[]) objArr29[0])[0];
                int i33 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int i34 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
                int i35 = ~(708049336 | i34);
                int i36 = ~i34;
                int i37 = 1934126819 + ((i35 | (~((-137371961) | i36))) * (-406)) + ((~(1043593662 | i36)) * (-406)) + (((~(i34 | (-906221703))) | (~((-708049337) | i36))) * 406) + 461499425;
                int i38 = (i37 << 13) ^ i37;
                int i39 = i38 ^ (i38 >>> 17);
                ((int[]) objArr[3])[0] = i39 ^ (i39 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36, new char[]{36519, 36557, 38739, 26120, 49200, 10704, 8754, 64031, 19041, 8477, 34063, 25319, 1808, 60535, 20005, 42776, 49260, 43221, 4987, 55316}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{59920, 60025, 50885, 14235, 20436, 21447, 44485, 32775, 11916, 28814, 2797, 6376, 25480, 48558, 49650, 56593, 42219, 63832, 40077, 41476}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, 461499425};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int keyRepeatDelay2 = 25 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    char c5 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 30067);
                    int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0) + 817;
                    byte[] bArr2 = $$a;
                    byte b23 = bArr2[5];
                    Object[] objArr33 = new Object[1];
                    a(b23, bArr2[8], b23, objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, c5, iIndexOf3, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int i40 = 26 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    char bitsPerPixel = (char) (30067 - ImageFormat.getBitsPerPixel(0));
                    int minimumFlingVelocity = 816 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    byte b24 = $$a[5];
                    byte b25 = (byte) (b24 - 1);
                    byte b26 = b24;
                    Object[] objArr34 = new Object[1];
                    a(b25, b26, (byte) (b26 - 1), objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i40, bitsPerPixel, minimumFlingVelocity, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    b(View.resolveSizeAndState(0, 0, 0), new char[]{58367, 58270, 14653, 51305, 10996, 6696, 51428, 51700, 10104, 36726, 28636, 20812, 27200, 16964, 42126, 38105, 44350, 1724, 63932, 60407, 61490, 15780, 16028, 11989, 15124, 61588}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{61767, 61730, 5809, 59367, 30090, 54047, 38815, 193, 13788, 41206, 12455, 38917, 30962, 28122, 64439, 24011, 49046, 10542, 42710}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int i41 = 26 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        char cIndexOf = (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 30069);
                        int packedPositionChild2 = ExpandableListView.getPackedPositionChild(0L) + 817;
                        byte b27 = (byte) ($$a[5] - 1);
                        byte b28 = b27;
                        Object[] objArr37 = new Object[1];
                        a(b27, b28, b28, objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i41, cIndexOf, packedPositionChild2, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36, new char[]{36519, 36557, 38739, 26120, 49200, 10704, 8754, 64031, 19041, 8477, 34063, 25319, 1808, 60535, 20005, 42776, 49260, 43221, 4987, 55316}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{59920, 60025, 50885, 14235, 20436, 21447, 44485, 32775, 11916, 28814, 2797, 6376, 25480, 48558, 49650, 56593, 42219, 63832, 40077, 41476}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, 461499425};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int keyRepeatDelay3 = 25 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                char c6 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 30067);
                int iIndexOf4 = TextUtils.indexOf((CharSequence) "", '0', 0) + 817;
                byte[] bArr3 = $$a;
                byte b29 = bArr3[5];
                Object[] objArr311 = new Object[1];
                a(b29, bArr3[8], b29, objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay3, c6, iIndexOf4, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int i42 = 26 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                char bitsPerPixel2 = (char) (30067 - ImageFormat.getBitsPerPixel(0));
                int minimumFlingVelocity2 = 816 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                byte b210 = $$a[5];
                byte b211 = (byte) (b210 - 1);
                byte b212 = b210;
                Object[] objArr312 = new Object[1];
                a(b211, b212, (byte) (b212 - 1), objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i42, bitsPerPixel2, minimumFlingVelocity2, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            b(View.resolveSizeAndState(0, 0, 0), new char[]{58367, 58270, 14653, 51305, 10996, 6696, 51428, 51700, 10104, 36726, 28636, 20812, 27200, 16964, 42126, 38105, 44350, 1724, 63932, 60407, 61490, 15780, 16028, 11989, 15124, 61588}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{61767, 61730, 5809, 59367, 30090, 54047, 38815, 193, 13788, 41206, 12455, 38917, 30962, 28122, 64439, 24011, 49046, 10542, 42710}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int i43 = 26 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                char cIndexOf2 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 30069);
                int packedPositionChild3 = ExpandableListView.getPackedPositionChild(0L) + 817;
                byte b213 = (byte) ($$a[5] - 1);
                byte b214 = b213;
                Object[] objArr315 = new Object[1];
                a(b213, b214, b214, objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i43, cIndexOf2, packedPositionChild3, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i44 = ((int[]) objArr[1])[0];
        int i45 = ((int[]) objArr[0])[0];
        if (i45 == i44) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i46 = ((int[]) objArr[3])[0];
            int i47 = ((int[]) objArr[0])[0];
            int i48 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i49 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenWidthDp;
            int i50 = i46 + 1063082885 + (((~(576085377 | i49)) | 203432014) * 104) + ((~((~i49) | (-5259649))) * (-104)) + ((i49 | 774257743) * 104);
            int i51 = (i50 << 13) ^ i50;
            int i52 = i51 ^ (i51 >>> 17);
            ((int[]) objArr40[3])[0] = i52 ^ (i52 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArr[2];
            if (strArr7 != null) {
                int i53 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.f40o;
                artificialFrame = i53 % 128;
                int i54 = i53 % 2;
                int i55 = 0;
                while (i55 < strArr7.length) {
                    int i56 = artificialFrame + 49;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i56 % 128;
                    if (i56 % 2 != 0) {
                        arrayList2.add(strArr7[i55]);
                        i55 += 112;
                    } else {
                        arrayList2.add(strArr7[i55]);
                        i55++;
                    }
                }
            }
            Object[] objArr41 = {Long.valueOf((((long) (-163165016)) << 32) ^ ((long) (i44 ^ i45))), Long.valueOf(-163165015)};
            byte[] bArr4 = $$d;
            byte b30 = bArr4[36];
            byte b31 = (byte) ($$e & 181);
            Object[] objArr42 = new Object[1];
            c(b30, b31, (byte) (b31 | 9), objArr42);
            Class<?> cls12 = Class.forName((String) objArr42[0]);
            byte b32 = bArr4[0];
            byte b33 = b32;
            Object[] objArr43 = new Object[1];
            c(b32, b33, (byte) (b33 | 43), objArr43);
            cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
            Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i57 = ((int[]) objArr[3])[0];
            int i58 = ((int[]) objArr[0])[0];
            int i59 = ((int[]) objArr[1])[0];
            String[] strArr8 = (String[]) objArr[2];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i60 = i57 + 1264953413 + (((~(331129355 | iIdentityHashCode2)) | 201326800) * 336) + (((~(iIdentityHashCode2 | 529301721)) | 3154434) * (-168)) + (((~((~iIdentityHashCode2) | 529301721)) | 331129355) * 168);
            int i61 = (i60 << 13) ^ i60;
            int i62 = i61 ^ (i61 >>> 17);
            ((int[]) objArr44[3])[0] = i62 ^ (i62 << 5);
        }
        int i63 = artificialFrame + 97;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i63 % 128;
        int i64 = i63 % 2;
    }
}
