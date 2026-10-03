package com.facebook.react.runtime;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.JavaScriptModuleRegistry;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.interop.InteropModuleRegistry;
import com.facebook.react.common.annotations.FrameworkAPI;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherProvider;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager$$ExternalSyntheticLambda2;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.asBinder;
import okio.Utf8;

/* JADX INFO: loaded from: classes2.dex */
class BridgelessReactContext extends ReactApplicationContext implements EventDispatcherProvider {
    private final String TAG;
    private final ReactHostImpl mReactHost;
    private final AtomicReference<String> mSourceURL;
    private static final byte[] $$c = {103, 5, 74, Ascii.SYN};
    private static final int $$f = b.i;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$j = {42, -6, -6, 62, -2, -3, -18, -6, -2, 55, -1, -65, -11, -12, 9, -19, -2, 7, -17, 56, -79, -2, Utf8.REPLACEMENT_BYTE, -42, -25, -2, -17, Ascii.SI, -20, -3, 9, -34, 6, -14, 0, -21, 74, -57, -33, 3, -17, 9, -19, Ascii.CAN, -19, -24, 2, -6, -67, -18, -4, 57, -62, -1, -8, -8, -3, -19, -6, -2, 55, -65, -10, 6, -12, -4, -17, 1, -13, 5, -13, -3, -11, 3, 49, -59, -18, -9, 7, 49, -40, -40, -3, 5, -23, Ascii.FF, -8, -19, Ascii.EM, -24, -18, -10, 10, -15, 5, -8, Ascii.EM, -33, -8, -23, -1, -9, -13, 79, -37, -50, -4, -9, 9, -19, -1, -12, -5};
    private static final int $$k = 178;
    private static final byte[] $$a = {Ascii.EM, -12, SignedBytes.MAX_POWER_OF_TWO, 107, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$b = 172;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long extraCommand = -464867199847044950L;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$i(byte r5, byte r6, short r7) {
        /*
            byte[] r0 = com.facebook.react.runtime.BridgelessReactContext.$$c
            int r7 = r7 * 4
            int r1 = 1 - r7
            int r5 = r5 * 4
            int r5 = 4 - r5
            int r6 = r6 * 4
            int r6 = r6 + 118
            byte[] r1 = new byte[r1]
            r2 = 0
            int r7 = 0 - r7
            if (r0 != 0) goto L18
            r4 = r7
            r3 = r2
            goto L28
        L18:
            r3 = r2
        L19:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L24
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L24:
            int r3 = r3 + 1
            r4 = r0[r5]
        L28:
            int r6 = r6 + r4
            int r5 = r5 + 1
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.runtime.BridgelessReactContext.$$i(byte, byte, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 28
            int r7 = 112 - r7
            int r6 = r6 * 8
            int r6 = 20 - r6
            int r8 = r8 * 3
            int r0 = r8 + 9
            byte[] r1 = com.facebook.react.runtime.BridgelessReactContext.$$a
            byte[] r0 = new byte[r0]
            int r8 = r8 + 8
            r2 = 0
            if (r1 != 0) goto L19
            r4 = r7
            r3 = r2
            r7 = r6
            goto L2e
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r1[r6]
            r5 = r7
            r7 = r6
            r6 = r5
        L2e:
            int r4 = -r4
            int r6 = r6 + r4
            int r7 = r7 + 1
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.runtime.BridgelessReactContext.a(int, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r5, int r6, short r7, java.lang.Object[] r8) {
        /*
            int r0 = r5 + 3
            int r6 = r6 * 3
            int r6 = r6 + 36
            byte[] r1 = com.facebook.react.runtime.BridgelessReactContext.$$j
            int r7 = 49 - r7
            byte[] r0 = new byte[r0]
            int r5 = r5 + 2
            r2 = 0
            if (r1 != 0) goto L15
            r6 = r5
            r3 = r7
            r4 = r2
            goto L27
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r6
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r5) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L25:
            r3 = r1[r7]
        L27:
            int r7 = r7 + 1
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + (-6)
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.runtime.BridgelessReactContext.c(int, int, short, java.lang.Object[]):void");
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void destroy() {
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasCatalystInstance() {
        return false;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean isBridgeless() {
        return true;
    }

    BridgelessReactContext(Context context, ReactHostImpl reactHostImpl) {
        super(context);
        this.mSourceURL = new AtomicReference<>();
        this.TAG = getClass().getSimpleName();
        this.mReactHost = reactHostImpl;
        if (ReactNativeFeatureFlags.useFabricInterop()) {
            initializeInteropModules();
        }
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcherProvider
    public EventDispatcher getEventDispatcher() {
        return this.mReactHost.getEventDispatcher();
    }

    public void setSourceURL(String str) {
        this.mSourceURL.set(str);
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Nullable
    public String getSourceURL() {
        return this.mSourceURL.get();
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        int i3 = $10 + 95;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (asbinder.d < cArr.length) {
            int i5 = asbinder.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getPressedStateDuration() >> 16), 1407 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 1035473698, false, $$i(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i5] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                try {
                    Object[] objArr3 = {asbinder, asbinder};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionGroup(0L) + 8, (char) ('0' - AndroidCharacter.getMirror('0')), Drawable.resolveOpacity(0, 0) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i6 = $10 + 39;
            $11 = i6 % 128;
            if (i6 % 2 == 0) {
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                try {
                    Object[] objArr4 = {asbinder, asbinder};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame3 == null) {
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 8, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), 249 - Color.green(0), 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    int i7 = 70 / 0;
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            } else {
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                Object[] objArr5 = {asbinder, asbinder};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(Color.alpha(0) + 8, (char) TextUtils.getOffsetAfter("", 0), 249 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
        }
        String str = new String(cArr2);
        int i8 = $10 + 27;
        $11 = i8 % 128;
        int i9 = i8 % 2;
        objArr[0] = str;
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Nullable
    public UIManager getFabricUIManager() {
        return this.mReactHost.getUIManager();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public CatalystInstance getCatalystInstance() {
        SentryLogcatAdapter.w(this.TAG, "[WARNING] Bridgeless doesn't support CatalystInstance. Accessing an API that's not part of the new architecture is not encouraged usage.");
        return new BridgelessCatalystInstance(this.mReactHost);
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Deprecated
    public boolean hasActiveCatalystInstance() {
        return hasActiveReactInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasActiveReactInstance() {
        return this.mReactHost.isInstanceInitialized();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasReactInstance() {
        return this.mReactHost.isInstanceInitialized();
    }

    DevSupportManager getDevSupportManager() {
        return this.mReactHost.getDevSupportManager();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void registerSegment(int i, String str, Callback callback) {
        this.mReactHost.registerSegment(i, str, callback);
    }

    static class BridgelessJSModuleInvocationHandler implements InvocationHandler {
        private final Class<? extends JavaScriptModule> mJSModuleInterface;
        private final ReactHostImpl mReactHost;

        public BridgelessJSModuleInvocationHandler(ReactHostImpl reactHostImpl, Class<? extends JavaScriptModule> cls) {
            this.mReactHost = reactHostImpl;
            this.mJSModuleInterface = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(Object obj, Method method, @Nullable Object[] objArr) {
            this.mReactHost.callFunctionOnModule(JavaScriptModuleRegistry.getJSModuleName(this.mJSModuleInterface), method.getName(), objArr != null ? Arguments.fromJavaArgs(objArr) : new WritableNativeArray());
            return null;
        }
    }

    @Override // com.facebook.react.bridge.ReactContext
    public <T extends JavaScriptModule> T getJSModule(Class<T> cls) {
        InteropModuleRegistry interopModuleRegistry = this.mInteropModuleRegistry;
        if (interopModuleRegistry != null && interopModuleRegistry.shouldReturnInteropModule(cls)) {
            return (T) this.mInteropModuleRegistry.getInteropModule(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new BridgelessJSModuleInvocationHandler(this.mReactHost, cls));
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void emitDeviceEvent(String str, @Nullable Object obj) {
        this.mReactHost.callFunctionOnModule("RCTDeviceEventEmitter", "emit", Arguments.fromJavaArgs(new Object[]{str, obj}));
    }

    @Override // com.facebook.react.bridge.ReactContext
    public <T extends NativeModule> boolean hasNativeModule(Class<T> cls) {
        return this.mReactHost.hasNativeModule(cls);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public Collection<NativeModule> getNativeModules() {
        return this.mReactHost.getNativeModules();
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Nullable
    public <T extends NativeModule> T getNativeModule(Class<T> cls) {
        return (T) this.mReactHost.getNativeModule(cls);
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Nullable
    public NativeModule getNativeModule(String str) {
        return this.mReactHost.getNativeModule(str);
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Nullable
    @FrameworkAPI
    @UnstableReactNativeAPI
    public JavaScriptContextHolder getJavaScriptContextHolder() {
        return this.mReactHost.getJavaScriptContextHolder();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void handleException(Exception exc) {
        this.mReactHost.handleHostException(exc);
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Nullable
    public CallInvokerHolder getJSCallInvokerHolder() {
        return this.mReactHost.getJSCallInvokerHolder();
    }

    DefaultHardwareBackBtnHandler getDefaultHardwareBackBtnHandler() {
        return this.mReactHost.getDefaultBackButtonHandler();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:16:0x026a A[Catch: all -> 0x0a20, TryCatch #0 {all -> 0x0a20, blocks: (B:51:0x070b, B:53:0x072b, B:54:0x0779, B:14:0x0256, B:16:0x026a, B:17:0x029a), top: B:91:0x0256 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:25:0x0371  */
    /* JADX WARN: Code duplicated, block: B:50:0x0684  */
    /* JADX WARN: Code duplicated, block: B:53:0x072b A[Catch: all -> 0x0a20, TryCatch #0 {all -> 0x0a20, blocks: (B:51:0x070b, B:53:0x072b, B:54:0x0779, B:14:0x0256, B:16:0x026a, B:17:0x029a), top: B:91:0x0256 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x078b  */
    /* JADX WARN: Code duplicated, block: B:62:0x0844  */
    @Override // com.facebook.react.bridge.ReactApplicationContext, com.facebook.react.bridge.ReactContext, android.content.ContextWrapper
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
        int i2 = artificialFrame + 9;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int i4 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 26;
            char cBlue = (char) Color.blue(0);
            int i5 = 1042 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
            byte b = $$a[8];
            byte b2 = (byte) (b - 2);
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i4, cBlue, i5, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387913L;
            Object[] objArr3 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 47980, new char[]{20676, 60246, 10235, 25088, 48830, 64221, 13679, 29120, 35874, 51283, 1193, 24393, 39808, 54831, 4679, 44787, 59672, 9611, 25027, 48237, 63618, 13103}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(9) + 14773, new char[]{20672, 27374, 9354, 65184, 47178, 29187, 3115, 51174, 33272, 23451, 5455, 12156, 59672, 41779, 32482}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 51;
                artificialFrame = i6 % 128;
                int i7 = i6 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int iResolveSize = View.resolveSize(0, 0) + 26;
                    char packedPositionType = (char) ExpandableListView.getPackedPositionType(0L);
                    int iIndexOf = 1041 - TextUtils.indexOf("", "", 0);
                    byte b3 = $$a[5];
                    byte b4 = (byte) (b3 - 1);
                    Object[] objArr5 = new Object[1];
                    a(b3, b4, b4, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iResolveSize, packedPositionType, iIndexOf, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i8 = ((int[]) objArr6[3])[0];
                int i9 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int i10 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
                int i11 = ~i10;
                int i12 = (-1432698178) + ((133005183 | i10) * (-676)) + (((~(107822967 | i11)) | (-133005184)) * 676) + (((~(i10 | (-25182217))) | (~(i11 | 29719160)) | 103286023) * 676) + 1006973542;
                int i13 = (i12 << 13) ^ i12;
                int i14 = i13 ^ (i13 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i14 ^ (i14 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) + 17452, new char[]{20687, 5269, 55409, 39991, 16847, 1372, 51490, 36604, 29258, 13906, 64476, 49063, 25370, 10444, 60590, 20599}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 13451, new char[]{20684, 25710, 14750, 52934, 33389, 22439, 27851, 8213, 62869, 35555, 24064, 4936, 10450, 64553, 45395, 18049}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {1757693746};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollDefaultDelay() >> 16) + 8, (char) (22251 - (ViewConfiguration.getTapTimeout() >> 16)), Color.alpha(0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = HpkePrivateKeyManager$$ExternalSyntheticLambda2.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), 1006973542, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int iAlpha = Color.alpha(0) + 26;
                        char c = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                        int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 1042;
                        byte b5 = $$a[5];
                        byte b6 = (byte) (b5 - 1);
                        Object[] objArr10 = new Object[1];
                        a(b5, b6, b6, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iAlpha, c, packedPositionChild, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 47994, new char[]{20676, 60246, 10235, 25088, 48830, 64221, 13679, 29120, 35874, 51283, 1193, 24393, 39808, 54831, 4679, 44787, 59672, 9611, 25027, 48237, 63618, 13103}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 14852, new char[]{20672, 27374, 9354, 65184, 47178, 29187, 3115, 51174, 33272, 23451, 5455, 12156, 59672, 41779, 32482}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27;
                            char cBlue2 = (char) Color.blue(0);
                            int scrollBarFadeDuration = 1041 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                            byte b7 = $$a[8];
                            byte b8 = (byte) (b7 - 2);
                            Object[] objArr13 = new Object[1];
                            a(b7, b8, b8, objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf2, cBlue2, scrollBarFadeDuration, 2061780482, false, (String) objArr13[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                        int i15 = artificialFrame + 13;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i15 % 128;
                        int i16 = i15 % 2;
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
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) + 17452, new char[]{20687, 5269, 55409, 39991, 16847, 1372, 51490, 36604, 29258, 13906, 64476, 49063, 25370, 10444, 60590, 20599}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 13451, new char[]{20684, 25710, 14750, 52934, 33389, 22439, 27851, 8213, 62869, 35555, 24064, 4936, 10450, 64553, 45395, 18049}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {1757693746};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollDefaultDelay() >> 16) + 8, (char) (22251 - (ViewConfiguration.getTapTimeout() >> 16)), Color.alpha(0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = HpkePrivateKeyManager$$ExternalSyntheticLambda2.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), 1006973542, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int iAlpha2 = Color.alpha(0) + 26;
                char c2 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                int packedPositionChild2 = ExpandableListView.getPackedPositionChild(0L) + 1042;
                byte b9 = $$a[5];
                byte b10 = (byte) (b9 - 1);
                Object[] objArr17 = new Object[1];
                a(b9, b10, b10, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iAlpha2, c2, packedPositionChild2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 47994, new char[]{20676, 60246, 10235, 25088, 48830, 64221, 13679, 29120, 35874, 51283, 1193, 24393, 39808, 54831, 4679, 44787, 59672, 9611, 25027, 48237, 63618, 13103}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 14852, new char[]{20672, 27374, 9354, 65184, 47178, 29187, 3115, 51174, 33272, 23451, 5455, 12156, 59672, 41779, 32482}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27;
                char cBlue3 = (char) Color.blue(0);
                int scrollBarFadeDuration2 = 1041 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                byte b11 = $$a[8];
                byte b12 = (byte) (b11 - 2);
                Object[] objArr110 = new Object[1];
                a(b11, b12, b12, objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf3, cBlue3, scrollBarFadeDuration2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
            int i17 = artificialFrame + 13;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i17 % 128;
            int i18 = i17 % 2;
        }
        int i19 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i20 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i20 == i19) {
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i21 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i22 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i23 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int streamMaxVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamMaxVolume(3);
            int i24 = (-1544325762) + (((~(1067484368 | streamMaxVolume)) | (-989380562)) * 672);
            int i25 = ~streamMaxVolume;
            int i26 = i21 + i24 + (((~(streamMaxVolume | (-989380562))) | (~((-1067484369) | i25))) * (-672)) + (((~(989380561 | i25)) | (-1073266642)) * 672);
            int i27 = (i26 << 13) ^ i26;
            int i28 = i27 ^ (i27 >>> 17);
            ((int[]) objArr20[1])[0] = i28 ^ (i28 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i29 = artificialFrame + 91;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i29 % 128;
                int i30 = i29 % 2;
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i19 ^ i20)) ^ (((long) 1421696529) << 32)), Long.valueOf(1421696531)};
                byte[] bArr = $$j;
                Object[] objArr22 = new Object[1];
                c((byte) (bArr[0] - 1), bArr[88], (byte) 45, objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b13 = bArr[34];
                Object[] objArr23 = new Object[1];
                c(b13, b13, bArr[46], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i31 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i32 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i33 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int i34 = ~new Random().nextInt();
                int i35 = i31 + 323545734 + (((~((-5833745) | i34)) | 83937551) * (-828)) + ((i34 | (-5833745)) * (-828)) + 535372736;
                int i36 = (i35 << 13) ^ i35;
                int i37 = i36 ^ (i36 >>> 17);
                ((int[]) objArr24[1])[0] = i37 ^ (i37 << 5);
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
            int iMyPid = 25 - (Process.myPid() >> 22);
            char c3 = (char) (30068 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
            int i38 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 815;
            byte b14 = $$a[8];
            byte b15 = (byte) (b14 - 2);
            Object[] objArr25 = new Object[1];
            a(b14, b15, b15, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iMyPid, c3, i38, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            int i39 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
            artificialFrame = i39 % 128;
            int i40 = i39 % 2;
            long j4 = j3 + 2020;
            Object[] objArr26 = new Object[1];
            b(48077 - AndroidCharacter.getMirror('0'), new char[]{20676, 60246, 10235, 25088, 48830, 64221, 13679, 29120, 35874, 51283, 1193, 24393, 39808, 54831, 4679, 44787, 59672, 9611, 25027, 48237, 63618, 13103}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b(14888 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), new char[]{20672, 27374, 9354, 65184, 47178, 29187, 3115, 51174, 33272, 23451, 5455, 12156, 59672, 41779, 32482}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int iIndexOf4 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 26;
                    char cBlue4 = (char) (Color.blue(0) + 30068);
                    int mirror = 864 - AndroidCharacter.getMirror('0');
                    byte b16 = $$a[5];
                    byte b17 = (byte) (b16 - 1);
                    Object[] objArr28 = new Object[1];
                    a(b16, b17, b17, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf4, cBlue4, mirror, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i41 = ((int[]) objArr29[0])[0];
                int i42 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i43 = (((~((-690833217) | iIdentityHashCode)) | 151863360) * (-283)) + 225830285 + ((~(iIdentityHashCode | (-538969857))) * 283) + 221139969;
                int i44 = (i43 << 13) ^ i43;
                int i45 = i44 ^ (i44 >>> 17);
                ((int[]) objArr[3])[0] = i45 ^ (i45 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 17440, new char[]{20687, 5269, 55409, 39991, 16847, 1372, 51490, 36604, 29258, 13906, 64476, 49063, 25370, 10444, 60590, 20599}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 13466, new char[]{20684, 25710, 14750, 52934, 33389, 22439, 27851, 8213, 62869, 35555, 24064, 4936, 10450, 64553, 45395, 18049}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, 221139969};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int threadPriority = 25 - ((Process.getThreadPriority(0) + 20) >> 6);
                    char cRed = (char) (30068 - Color.red(0));
                    int i46 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 817;
                    byte b18 = $$a[5];
                    byte b19 = (byte) (b18 - 1);
                    byte b20 = b18;
                    Object[] objArr33 = new Object[1];
                    a(b19, b20, b20, objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(threadPriority, cRed, i46, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int i47 = 26 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    char cResolveSize = (char) (30068 - View.resolveSize(0, 0));
                    int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 817;
                    byte b21 = $$a[5];
                    byte b22 = (byte) (b21 - 1);
                    Object[] objArr34 = new Object[1];
                    a(b21, b22, b22, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i47, cResolveSize, bitsPerPixel, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 47993, new char[]{20676, 60246, 10235, 25088, 48830, 64221, 13679, 29120, 35874, 51283, 1193, 24393, 39808, 54831, 4679, 44787, 59672, 9611, 25027, 48237, 63618, 13103}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    b(14886 - TextUtils.indexOf((CharSequence) "", '0'), new char[]{20672, 27374, 9354, 65184, 47178, 29187, 3115, 51174, 33272, 23451, 5455, 12156, 59672, 41779, 32482}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int iLastIndexOf = 24 - TextUtils.lastIndexOf("", '0');
                        char c4 = (char) (30068 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        int iAlpha3 = Color.alpha(0) + 816;
                        byte b23 = $$a[8];
                        byte b24 = (byte) (b23 - 2);
                        Object[] objArr37 = new Object[1];
                        a(b23, b24, b24, objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c4, iAlpha3, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 17440, new char[]{20687, 5269, 55409, 39991, 16847, 1372, 51490, 36604, 29258, 13906, 64476, 49063, 25370, 10444, 60590, 20599}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 13466, new char[]{20684, 25710, 14750, 52934, 33389, 22439, 27851, 8213, 62869, 35555, 24064, 4936, 10450, 64553, 45395, 18049}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, 221139969};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int threadPriority2 = 25 - ((Process.getThreadPriority(0) + 20) >> 6);
                char cRed2 = (char) (30068 - Color.red(0));
                int i48 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 817;
                byte b110 = $$a[5];
                byte b111 = (byte) (b110 - 1);
                byte b25 = b110;
                Object[] objArr311 = new Object[1];
                a(b111, b25, b25, objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(threadPriority2, cRed2, i48, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int i49 = 26 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                char cResolveSize2 = (char) (30068 - View.resolveSize(0, 0));
                int bitsPerPixel2 = ImageFormat.getBitsPerPixel(0) + 817;
                byte b26 = $$a[5];
                byte b27 = (byte) (b26 - 1);
                Object[] objArr312 = new Object[1];
                a(b26, b27, b27, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i49, cResolveSize2, bitsPerPixel2, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 47993, new char[]{20676, 60246, 10235, 25088, 48830, 64221, 13679, 29120, 35874, 51283, 1193, 24393, 39808, 54831, 4679, 44787, 59672, 9611, 25027, 48237, 63618, 13103}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            b(14886 - TextUtils.indexOf((CharSequence) "", '0'), new char[]{20672, 27374, 9354, 65184, 47178, 29187, 3115, 51174, 33272, 23451, 5455, 12156, 59672, 41779, 32482}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int iLastIndexOf2 = 24 - TextUtils.lastIndexOf("", '0');
                char c5 = (char) (30068 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                int iAlpha4 = Color.alpha(0) + 816;
                byte b28 = $$a[8];
                byte b29 = (byte) (b28 - 2);
                Object[] objArr315 = new Object[1];
                a(b28, b29, b29, objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, c5, iAlpha4, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i50 = ((int[]) objArr[1])[0];
        int i51 = ((int[]) objArr[0])[0];
        if (i51 == i50) {
            int i52 = artificialFrame + 63;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i52 % 128;
            int i53 = i52 % 2;
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i54 = ((int[]) objArr[3])[0];
            int i55 = ((int[]) objArr[0])[0];
            int i56 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i57 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigation;
            int i58 = i54 + (-284842070) + ((~((~i57) | (-872484897))) * 433) + (((~(873542690 | i57)) | (-1071715057)) * (-433)) + (((~(i57 | (-1071715057))) | 1057794) * 433);
            int i59 = (i58 << 13) ^ i58;
            int i60 = i59 ^ (i59 >>> 17);
            ((int[]) objArr40[3])[0] = i60 ^ (i60 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            int i61 = artificialFrame + 55;
            int i62 = i61 % 128;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i62;
            int i63 = i61 % 2;
            int i64 = i62 + 107;
            artificialFrame = i64 % 128;
            int i65 = i64 % 2;
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf((((long) (-842683791)) << 32) ^ ((long) (i50 ^ i51))), Long.valueOf(-842683792)};
        byte[] bArr2 = $$j;
        Object[] objArr42 = new Object[1];
        c(bArr2[3], (byte) (-bArr2[35]), bArr2[34], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b30 = bArr2[34];
        Object[] objArr43 = new Object[1];
        c(b30, b30, bArr2[46], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i66 = ((int[]) objArr[3])[0];
        int i67 = ((int[]) objArr[0])[0];
        int i68 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int iUptimeMillis = (int) SystemClock.uptimeMillis();
        int i69 = ~iUptimeMillis;
        int i70 = i66 + (-2071570980) + (((~((-718434207) | i69)) | 520261840) * (-865)) + ((~(iUptimeMillis | 718434206)) * 865) + (((~(520261840 | i69)) | (~(i69 | 718434206))) * 865);
        int i71 = (i70 << 13) ^ i70;
        int i72 = i71 ^ (i71 >>> 17);
        ((int[]) objArr44[3])[0] = i72 ^ (i72 << 5);
    }
}
