package com.facebook.react.bridge;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.provider.Settings;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.common.logging.FLog;
import com.facebook.fresco.urimod.UriModifierInterface;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.interop.InteropModuleRegistry;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.FrameworkAPI;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.io.encoding.Base64;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.extraCallback;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public class BridgeReactContext extends ReactApplicationContext {
    private static final String EARLY_JS_ACCESS_EXCEPTION_MESSAGE = "Tried to access a JS module before the React instance was fully set up. Calls to ReactContext#getJSModule should only happen once initialize() has been called on your native module.";
    private static final String EARLY_NATIVE_MODULE_EXCEPTION_MESSAGE = "Trying to call native module before CatalystInstance has been set!";
    private static final String LATE_JS_ACCESS_EXCEPTION_MESSAGE = "Tried to access a JS module after the React instance was destroyed.";
    private static final String LATE_NATIVE_MODULE_EXCEPTION_MESSAGE = "Trying to call native module after CatalystInstance has been destroyed!";
    private static final String TAG = "BridgeReactContext";
    private CatalystInstance mCatalystInstance;
    private volatile boolean mDestroyed;
    private static final byte[] $$c = {118, 52, 73, 45};
    private static final int $$f = 21;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$j = {68, 66, 84, 89, Ascii.CR, -50, 75, 6, Ascii.FF, -61, 70, Ascii.VT, 0, 3, 7, 10, Ascii.DLE, -53, Base64.padSymbol, Ascii.DC4, Ascii.VT, -5, -47, 77, 5, 1, -51, Ascii.GS, 62, -14, 17, 5, 2, -25, 59, -7, 8, 7, Ascii.NAK, -22, 38, -9, 10, Ascii.DLE, 2, Ascii.NAK, 8, 69, Ascii.DC4, 6, -55, SignedBytes.MAX_POWER_OF_TWO, 3, 10, 10, 5, Ascii.NAK, 8, 4, -53, 67, Ascii.FF, -4, Ascii.SO, 6, 19, 1, Ascii.SI, -3, Ascii.SI, 5, Ascii.CR, -1, -47, Base64.padSymbol, Ascii.DC4, Ascii.VT, -5, -47, 42, 42, 5, -3, Ascii.EM, -10, 10, Ascii.NAK, -23, Ascii.SUB, Ascii.DC4, Ascii.FF, -8, 17, -3, 10, -23, 35, 10, Ascii.EM, 3, Ascii.VT, Ascii.SI, -77, 39, 52, 6, Ascii.VT, -7, Ascii.NAK, 3, Ascii.SO, 7};
    private static final int $$k = 27;
    private static final byte[] $$a = {5, -37, 48, 84, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$b = 149;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] ArtificialStackFrames = {44409, 44370, 44392, 44402, 44406, 44403, 44399, 44387, 44371, 44396, 44334, 44414, 44400, 44388, 44385, 44397, 44393, 44394, 44355, 44389, 44391, 44404, 44360, 44395, 44398};
    private static char coroutineCreation = 39071;

    /* JADX INFO: loaded from: classes4.dex */
    public interface RCTDeviceEventEmitter extends JavaScriptModule {
        void emit(@NonNull String str, @Nullable Object obj);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$i(int r7, int r8, int r9) {
        /*
            byte[] r0 = com.facebook.react.bridge.BridgeReactContext.$$c
            int r8 = r8 * 3
            int r8 = r8 + 1
            int r7 = r7 * 3
            int r7 = 4 - r7
            int r9 = r9 + 97
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L15
            r9 = r7
            r3 = r8
            r4 = r2
            goto L29
        L15:
            r3 = r2
        L16:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L23:
            r3 = r0[r7]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r6
        L29:
            int r7 = -r7
            int r7 = r7 + r3
            int r9 = r9 + 1
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r6
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.BridgeReactContext.$$i(int, int, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r0 = 12 - r8
            byte[] r1 = com.facebook.react.bridge.BridgeReactContext.$$a
            int r7 = r7 + 4
            int r6 = r6 * 28
            int r6 = 112 - r6
            byte[] r0 = new byte[r0]
            int r8 = 11 - r8
            r2 = 0
            if (r1 != 0) goto L17
            r6 = r7
            r4 = r8
            r3 = r2
            goto L2e
        L17:
            r3 = r2
            r5 = r7
            r7 = r6
            r6 = r5
        L1b:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r1[r6]
            int r3 = r3 + 1
        L2e:
            int r4 = -r4
            int r7 = r7 + r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.BridgeReactContext.a(short, short, short, java.lang.Object[]):void");
    }

    private static void c(int i, short s, int i2, Object[] objArr) {
        int i3 = 99 - (i2 * 63);
        int i4 = 47 - (i * 2);
        byte[] bArr = $$j;
        int i5 = s * 2;
        byte[] bArr2 = new byte[65 - i5];
        int i6 = 64 - i5;
        int i7 = -1;
        if (bArr == null) {
            i3 = (i4 + i3) - 8;
            i4 = i4;
        }
        while (true) {
            i7++;
            int i8 = i4 + 1;
            bArr2[i7] = (byte) i3;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                i3 = (i3 + bArr[i8]) - 8;
                i4 = i8;
            }
        }
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Deprecated
    public boolean isBridgeless() {
        return false;
    }

    public BridgeReactContext(Context context) {
        super(context);
        this.mDestroyed = false;
    }

    public void initializeWithInstance(CatalystInstance catalystInstance) {
        if (catalystInstance == null) {
            throw new IllegalArgumentException("CatalystInstance cannot be null.");
        }
        if (this.mCatalystInstance != null) {
            throw new IllegalStateException("ReactContext has been already initialized");
        }
        if (this.mDestroyed) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Cannot initialize ReactContext after it has been destroyed."));
        }
        this.mCatalystInstance = catalystInstance;
        initializeMessageQueueThreads(catalystInstance.getReactQueueConfiguration());
        initializeInteropModules();
    }

    private void raiseCatalystInstanceMissingException() {
        throw new IllegalStateException(this.mDestroyed ? LATE_NATIVE_MODULE_EXCEPTION_MESSAGE : EARLY_NATIVE_MODULE_EXCEPTION_MESSAGE);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public <T extends JavaScriptModule> T getJSModule(Class<T> cls) {
        if (this.mCatalystInstance == null) {
            if (this.mDestroyed) {
                throw new IllegalStateException(LATE_JS_ACCESS_EXCEPTION_MESSAGE);
            }
            throw new IllegalStateException(EARLY_JS_ACCESS_EXCEPTION_MESSAGE);
        }
        InteropModuleRegistry interopModuleRegistry = this.mInteropModuleRegistry;
        if (interopModuleRegistry != null && interopModuleRegistry.shouldReturnInteropModule(cls)) {
            return (T) this.mInteropModuleRegistry.getInteropModule(cls);
        }
        return (T) this.mCatalystInstance.getJSModule(cls);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public <T extends NativeModule> boolean hasNativeModule(Class<T> cls) {
        if (this.mCatalystInstance == null) {
            raiseCatalystInstanceMissingException();
        }
        return this.mCatalystInstance.hasNativeModule(cls);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public Collection<NativeModule> getNativeModules() {
        if (this.mCatalystInstance == null) {
            raiseCatalystInstanceMissingException();
        }
        return this.mCatalystInstance.getNativeModules();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public <T extends NativeModule> T getNativeModule(Class<T> cls) {
        if (this.mCatalystInstance == null) {
            raiseCatalystInstanceMissingException();
        }
        return (T) this.mCatalystInstance.getNativeModule(cls);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public NativeModule getNativeModule(String str) {
        if (this.mCatalystInstance == null) {
            raiseCatalystInstanceMissingException();
        }
        return this.mCatalystInstance.getNativeModule(str);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public CatalystInstance getCatalystInstance() {
        return (CatalystInstance) Assertions.assertNotNull(this.mCatalystInstance);
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Deprecated
    public boolean hasActiveCatalystInstance() {
        return hasActiveReactInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasActiveReactInstance() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        return (catalystInstance == null || catalystInstance.isDestroyed()) ? false : true;
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Deprecated
    public boolean hasCatalystInstance() {
        return this.mCatalystInstance != null;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasReactInstance() {
        return this.mCatalystInstance != null;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void destroy() {
        UiThreadUtil.assertOnUiThread();
        this.mDestroyed = true;
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance != null) {
            catalystInstance.lambda$onNativeException$6();
        }
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void handleException(Exception exc) {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        boolean z = catalystInstance != null;
        boolean z2 = z && !catalystInstance.isDestroyed();
        boolean z3 = getJSExceptionHandler() != null;
        if (z2 && z3) {
            getJSExceptionHandler().handleException(exc);
            return;
        }
        FLog.e(ReactConstants.TAG, "Unable to handle Exception - catalystInstanceVariableExists: " + z + " - isCatalystInstanceAlive: " + z2 + " - hasExceptionHandler: " + z3, exc);
        throw new IllegalStateException(exc);
    }

    @Override // com.facebook.react.bridge.ReactContext
    @FrameworkAPI
    @UnstableReactNativeAPI
    public JavaScriptContextHolder getJavaScriptContextHolder() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance != null) {
            return catalystInstance.getJavaScriptContextHolder();
        }
        return null;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public CallInvokerHolder getJSCallInvokerHolder() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance != null) {
            return catalystInstance.getJSCallInvokerHolder();
        }
        return null;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public UIManager getFabricUIManager() {
        return this.mCatalystInstance.getFabricUIManager();
    }

    private static void b(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
        int i2;
        int i3;
        int i4 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        long j = 0;
        int i5 = -1819279892;
        if (cArr2 != null) {
            int i6 = $10 + 125;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i8 = 0;
            while (i8 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i8])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                    if (objAccessartificialFrame == null) {
                        byte b2 = (byte) 0;
                        byte b3 = b2;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 15, (char) (20487 - ExpandableListView.getPackedPositionChild(j)), 2148 - TextUtils.getOffsetAfter("", 0), 216710116, false, $$i(b2, b3, b3), new Class[]{Integer.TYPE});
                    }
                    cArr3[i8] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i8++;
                    j = 0;
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
        float f = 0.0f;
        if (objAccessartificialFrame2 == null) {
            byte b4 = (byte) 0;
            byte b5 = b4;
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 15, (char) (20488 - View.MeasureSpec.getSize(0)), Drawable.resolveOpacity(0, 0) + 2148, 216710116, false, $$i(b4, b5, b5), new Class[]{Integer.TYPE});
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
            extracallback.a = 0;
            int i9 = $10 + 43;
            $11 = i9 % 128;
            int i10 = i9 % 2;
            while (extracallback.a < i2) {
                extracallback.createBrowser = cArr[extracallback.a];
                extracallback.c = cArr[extracallback.a + 1];
                if (extracallback.createBrowser == extracallback.c) {
                    cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                    cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                    i3 = 2;
                } else {
                    Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                    if (objAccessartificialFrame3 == null) {
                        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 46;
                        char size = (char) (View.MeasureSpec.getSize(0) + 58859);
                        int i11 = 2464 - (PointF.length(f, f) > f ? 1 : (PointF.length(f, f) == f ? 0 : -1));
                        byte b6 = (byte) 0;
                        byte b7 = b6;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, size, i11, 276640984, false, $$i(b6, b7, (byte) (b7 + 5)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                    }
                    if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                        Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                        if (objAccessartificialFrame4 == null) {
                            byte b8 = (byte) 0;
                            byte b9 = b8;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(24 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) Color.argb(0, 0, 0, 0), 792 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), -834291897, false, $$i(b8, b9, (byte) (b9 | 8)), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                        }
                        int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                        int i12 = (extracallback.d * cCharValue) + extracallback.g;
                        cArr4[extracallback.a] = cArr2[iIntValue];
                        cArr4[extracallback.a + 1] = cArr2[i12];
                    } else if (extracallback.b == extracallback.d) {
                        extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                        extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                        int i13 = (extracallback.b * cCharValue) + extracallback.j;
                        int i14 = (extracallback.d * cCharValue) + extracallback.g;
                        cArr4[extracallback.a] = cArr2[i13];
                        cArr4[extracallback.a + 1] = cArr2[i14];
                    } else {
                        int i15 = (extracallback.b * cCharValue) + extracallback.g;
                        int i16 = (extracallback.d * cCharValue) + extracallback.j;
                        cArr4[extracallback.a] = cArr2[i15];
                        cArr4[extracallback.a + 1] = cArr2[i16];
                        int i17 = $11 + 1;
                        $10 = i17 % 128;
                        i3 = 2;
                        int i18 = i17 % 2;
                    }
                    i3 = 2;
                }
                extracallback.a += i3;
                f = 0.0f;
            }
        }
        for (int i19 = 0; i19 < i; i19++) {
            int i20 = $10 + 33;
            $11 = i20 % 128;
            int i21 = i20 % 2;
            cArr4[i19] = (char) (cArr4[i19] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public String getSourceURL() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance == null) {
            return null;
        }
        return catalystInstance.getSourceURL();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void registerSegment(int i, String str, Callback callback) {
        ((CatalystInstance) Assertions.assertNotNull(this.mCatalystInstance)).registerSegment(i, str);
        ((Callback) Assertions.assertNotNull(callback)).invoke(new Object[0]);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0215  */
    /* JADX WARN: Code duplicated, block: B:24:0x02cf A[Catch: all -> 0x0c0a, TryCatch #0 {all -> 0x0c0a, blocks: (B:62:0x08bb, B:64:0x08dc, B:65:0x092c, B:22:0x02bb, B:24:0x02cf, B:25:0x02fb), top: B:102:0x02bb }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0311  */
    /* JADX WARN: Code duplicated, block: B:33:0x0426  */
    /* JADX WARN: Code duplicated, block: B:61:0x07e0  */
    /* JADX WARN: Code duplicated, block: B:64:0x08dc A[Catch: all -> 0x0c0a, TryCatch #0 {all -> 0x0c0a, blocks: (B:62:0x08bb, B:64:0x08dc, B:65:0x092c, B:22:0x02bb, B:24:0x02cf, B:25:0x02fb), top: B:102:0x02bb }] */
    /* JADX WARN: Code duplicated, block: B:68:0x093e  */
    /* JADX WARN: Code duplicated, block: B:73:0x0a09  */
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
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
        artificialFrame = i2 % 128;
        if (i2 % 2 == 0) {
            super.attachBaseContext(context);
            Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame7 == null) {
                int iCombineMeasuredStates = 26 - View.combineMeasuredStates(0, 0);
                char trimmedLength = (char) TextUtils.getTrimmedLength("");
                int capsMode = 1041 - TextUtils.getCapsMode("", 0, 0);
                byte[] bArr = $$a;
                byte b = bArr[5];
                Object[] objArr2 = new Object[1];
                a((byte) (b - 1), bArr[21], b, objArr2);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, trimmedLength, capsMode, 2061780482, false, (String) objArr2[0], null);
            }
            ((Field) objAccessartificialFrame7).getLong(null);
            throw null;
        }
        super.attachBaseContext(context);
        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame8 == null) {
            int iIndexOf = 25 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
            char pressedStateDuration = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
            int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 1041;
            byte[] bArr2 = $$a;
            byte b2 = bArr2[5];
            Object[] objArr3 = new Object[1];
            a((byte) (b2 - 1), bArr2[21], b2, objArr3);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iIndexOf, pressedStateDuration, tapTimeout, 2061780482, false, (String) objArr3[0], null);
        }
        long j = ((Field) objAccessartificialFrame8).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387919L;
            Object[] objArr4 = new Object[1];
            b(21 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{19, 4, 18, '\b', 11, 21, 14, 11, 7, 6, CharUtils.CR, 5, 5, '\n', 24, 16, 16, 19, 5, 7, '\b', 22}, (byte) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 38), objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            b(ExpandableListView.getPackedPositionChild(0L) + 16, new char[]{24, 14, '\n', CharUtils.CR, '\t', 15, 11, 3, 24, 19, 6, 24, 17, 16, 13892}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(16) - 41), objArr5);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame9 == null) {
                    int i3 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 26;
                    char scrollDefaultDelay = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    int touchSlop = 1041 - (ViewConfiguration.getTouchSlop() >> 8);
                    byte[] bArr3 = $$a;
                    byte b3 = bArr3[5];
                    Object[] objArr6 = new Object[1];
                    a((byte) (b3 - 1), bArr3[11], b3, objArr6);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i3, scrollDefaultDelay, touchSlop, 1145017376, false, (String) objArr6[0], null);
                }
                Object[] objArr7 = (Object[]) ((Field) objAccessartificialFrame9).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i4 = ((int[]) objArr7[3])[0];
                int i5 = ((int[]) objArr7[2])[0];
                String[] strArr = (String[]) objArr7[0];
                int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1624940483;
                int i6 = ~((-681126808) | length);
                int i7 = ~length;
                int i8 = (((1308360318 + ((i6 | (~((-603023001) | i7))) * (-1808))) + (((~((-134744328) | length)) | (~(i7 | (-56640521)))) * TypedValues.Custom.TYPE_BOOLEAN)) + ((((~(length | 603023000)) | 546382480) | (~(681126807 | i7))) * TypedValues.Custom.TYPE_BOOLEAN)) - 292481660;
                int i9 = (i8 << 13) ^ i8;
                int i10 = i9 ^ (i9 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i10 ^ (i10 << 5);
            } else {
                Object[] objArr8 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, new char[]{19, '\f', '\t', 19, 14, 5, 19, 4, 0, 15, 5, 3, 6, 20, 15, 16}, (byte) (65 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), objArr8);
                Class<?> cls2 = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{18, 11, 24, 4, 1, 21, 20, 1, 24, '\f', 7, 0, 16, '\b', 14, 18}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 48), objArr9);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr9[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr10 = {-1748015280};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.getDefaultSize(0, 0) + 8, (char) ((ViewConfiguration.getTouchSlop() >> 8) + 22251), Drawable.resolveOpacity(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = UriModifierInterface.ModificationResult.Modified.ModifiedToMaxDimens.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr10), -292481660, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0, 0) + 27;
                        char c = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        int modifierMetaStateMask = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.DC2;
                        byte[] bArr4 = $$a;
                        byte b4 = bArr4[5];
                        Object[] objArr11 = new Object[1];
                        a((byte) (b4 - 1), bArr4[11], b4, objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c, modifierMetaStateMask, 1145017376, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr12 = new Object[1];
                        b((ViewConfiguration.getScrollBarSize() >> 8) + 22, new char[]{19, 4, 18, '\b', 11, 21, 14, 11, 7, 6, CharUtils.CR, 5, 5, '\n', 24, 16, 16, 19, 5, 7, '\b', 22}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 34), objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 21, new char[]{24, 14, '\n', CharUtils.CR, '\t', 15, 11, 3, 24, 19, 6, 24, 17, 16, 13892}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 20), objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int scrollBarFadeDuration = 26 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                            char cArgb = (char) Color.argb(0, 0, 0, 0);
                            int i11 = 1042 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                            byte[] bArr5 = $$a;
                            byte b5 = bArr5[5];
                            Object[] objArr14 = new Object[1];
                            a((byte) (b5 - 1), bArr5[21], b5, objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, cArgb, i11, 2061780482, false, (String) objArr14[0], null);
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
            Object[] objArr15 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, new char[]{19, '\f', '\t', 19, 14, 5, 19, 4, 0, 15, 5, 3, 6, 20, 15, 16}, (byte) (65 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{18, 11, 24, 4, 1, 21, 20, 1, 24, '\f', 7, 0, 16, '\b', 14, 18}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 48), objArr16);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr17 = {-1748015280};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.getDefaultSize(0, 0) + 8, (char) ((ViewConfiguration.getTouchSlop() >> 8) + 22251), Drawable.resolveOpacity(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = UriModifierInterface.ModificationResult.Modified.ModifiedToMaxDimens.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr17), -292481660, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0, 0) + 27;
                char c2 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                int modifierMetaStateMask2 = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.DC2;
                byte[] bArr6 = $$a;
                byte b6 = bArr6[5];
                Object[] objArr18 = new Object[1];
                a((byte) (b6 - 1), bArr6[11], b6, objArr18);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, c2, modifierMetaStateMask2, 1145017376, false, (String) objArr18[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr19 = new Object[1];
            b((ViewConfiguration.getScrollBarSize() >> 8) + 22, new char[]{19, 4, 18, '\b', 11, 21, 14, 11, 7, 6, CharUtils.CR, 5, 5, '\n', 24, 16, 16, 19, 5, 7, '\b', 22}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 34), objArr19);
            Class<?> cls5 = Class.forName((String) objArr19[0]);
            Object[] objArr110 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 21, new char[]{24, 14, '\n', CharUtils.CR, '\t', 15, 11, 3, 24, 19, 6, 24, 17, 16, 13892}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 20), objArr110);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr110[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int scrollBarFadeDuration2 = 26 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                char cArgb2 = (char) Color.argb(0, 0, 0, 0);
                int i12 = 1042 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                byte[] bArr7 = $$a;
                byte b7 = bArr7[5];
                Object[] objArr111 = new Object[1];
                a((byte) (b7 - 1), bArr7[21], b7, objArr111);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, cArgb2, i12, 2061780482, false, (String) objArr111[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i14 == i13) {
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i17 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i18 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 263399078);
            int i19 = i15 + 297939614 + (((~(i18 | 12081851)) | (-67074812)) * (-160)) + (((~(i18 | (-66021956))) | 12081851) * SyslogConstants.LOG_LOCAL4);
            int i20 = (i19 << 13) ^ i19;
            int i21 = i20 ^ (i20 >>> 17);
            ((int[]) objArr20[1])[0] = i21 ^ (i21 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i22 = artificialFrame + 49;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i22 % 128;
                for (int i23 = i22 % 2 != 0 ? 1 : 0; i23 < strArr3.length; i23++) {
                    arrayList.add(strArr3[i23]);
                }
            }
            long j3 = ((long) (i13 ^ i14)) ^ (((long) (-718663457)) << 32);
            long j4 = -718663459;
            int i24 = artificialFrame + 15;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i24 % 128;
            int i25 = i24 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr8 = $$j;
                Object[] objArr22 = new Object[1];
                c((byte) (-bArr8[39]), bArr8[11], bArr8[12], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b8 = bArr8[25];
                byte b9 = b8;
                Object[] objArr23 = new Object[1];
                c(b9, (byte) (b9 | Ascii.RS), b8, objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i26 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i27 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i28 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i29 = i26 + (-478269278) + (((~iIdentityHashCode) | 94914305) * 1444) + (((~(iIdentityHashCode | (-714172874))) | (~(792276680 | iIdentityHashCode)) | 8405249) * (-1444)) + 191347804;
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
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame10 == null) {
            int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 25;
            char bitsPerPixel = (char) (ImageFormat.getBitsPerPixel(0) + 30069);
            int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 816;
            byte[] bArr9 = $$a;
            byte b10 = bArr9[5];
            Object[] objArr25 = new Object[1];
            a((byte) (b10 - 1), bArr9[21], b10, objArr25);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, bitsPerPixel, iKeyCodeFromString, 721586079, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j5 != -1) {
            int i32 = getARTIFICIAL_FRAME_PACKAGE_NAME + 63;
            artificialFrame = i32 % 128;
            int i33 = i32 % 2;
            long j6 = j5 + 1880;
            Object[] objArr26 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 14, new char[]{19, 4, 18, '\b', 11, 21, 14, 11, 7, 6, CharUtils.CR, 5, 5, '\n', 24, 16, 16, 19, 5, 7, '\b', 22}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(15) - 79), objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, new char[]{24, 14, '\n', CharUtils.CR, '\t', 15, 11, 3, 24, 19, 6, 24, 17, 16, 13892}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 20), objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i34 = artificialFrame + 115;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i34 % 128;
                int i35 = i34 % 2;
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame11 == null) {
                    int iMyTid = (Process.myTid() >> 22) + 25;
                    char cIndexOf = (char) (TextUtils.indexOf("", "", 0) + 30068);
                    int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 816;
                    byte[] bArr10 = $$a;
                    byte b11 = bArr10[5];
                    Object[] objArr28 = new Object[1];
                    a((byte) (b11 - 1), bArr10[11], b11, objArr28);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iMyTid, cIndexOf, edgeSlop, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame11).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i36 = ((int[]) objArr29[0])[0];
                int i37 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i38 = ~iIdentityHashCode2;
                int i39 = (~((-679371721) | i38)) | 542139136;
                int i40 = ~(iIdentityHashCode2 | (-343966771));
                int i41 = ((1769078989 + ((i39 | i40) * (-502))) + ((i40 | (~(i38 | (-137232585)))) * TypedValues.PositionType.TYPE_DRAWPATH)) - 1491871185;
                int i42 = (i41 << 13) ^ i41;
                int i43 = i42 ^ (i42 >>> 17);
                ((int[]) objArr[3])[0] = i43 ^ (i43 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 5, new char[]{19, '\f', '\t', 19, 14, 5, 19, 4, 0, 15, 5, 3, 6, 20, 15, 16}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 61), objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 20, new char[]{18, 11, 24, 4, 1, 21, 20, 1, 24, '\f', 7, 0, 16, '\b', 14, 18}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 79), objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -1491871185};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int iLastIndexOf3 = 24 - TextUtils.lastIndexOf("", '0');
                    char gidForName = (char) (Process.getGidForName("") + 30069);
                    int i44 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 815;
                    byte[] bArr11 = $$a;
                    byte b12 = bArr11[5];
                    Object[] objArr33 = new Object[1];
                    a(b12, (byte) (-bArr11[19]), (byte) (b12 - 1), objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, gidForName, i44, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int i45 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 24;
                    char edgeSlop2 = (char) (30068 - (ViewConfiguration.getEdgeSlop() >> 16));
                    int iIndexOf2 = TextUtils.indexOf("", "", 0) + 816;
                    byte[] bArr12 = $$a;
                    byte b13 = bArr12[5];
                    Object[] objArr34 = new Object[1];
                    a((byte) (b13 - 1), bArr12[11], b13, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i45, edgeSlop2, iIndexOf2, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new char[]{19, 4, 18, '\b', 11, 21, 14, 11, 7, 6, CharUtils.CR, 5, 5, '\n', 24, 16, 16, 19, 5, 7, '\b', 22}, (byte) (38 - ExpandableListView.getPackedPositionGroup(0L)), objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    b(TextUtils.indexOf("", "") + 15, new char[]{24, 14, '\n', CharUtils.CR, '\t', 15, 11, 3, 24, 19, 6, 24, 17, 16, 13892}, (byte) (69 - (Process.myPid() >> 22)), objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int iResolveSize = View.resolveSize(0, 0) + 25;
                        char jumpTapTimeout = (char) (30068 - (ViewConfiguration.getJumpTapTimeout() >> 16));
                        int defaultSize = View.getDefaultSize(0, 0) + 816;
                        byte[] bArr13 = $$a;
                        byte b14 = bArr13[5];
                        Object[] objArr37 = new Object[1];
                        a((byte) (b14 - 1), bArr13[21], b14, objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iResolveSize, jumpTapTimeout, defaultSize, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 5, new char[]{19, '\f', '\t', 19, 14, 5, 19, 4, 0, 15, 5, 3, 6, 20, 15, 16}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 61), objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 20, new char[]{18, 11, 24, 4, 1, 21, 20, 1, 24, '\f', 7, 0, 16, '\b', 14, 18}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 79), objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -1491871185};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int iLastIndexOf4 = 24 - TextUtils.lastIndexOf("", '0');
                char gidForName2 = (char) (Process.getGidForName("") + 30069);
                int i46 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 815;
                byte[] bArr14 = $$a;
                byte b15 = bArr14[5];
                Object[] objArr311 = new Object[1];
                a(b15, (byte) (-bArr14[19]), (byte) (b15 - 1), objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iLastIndexOf4, gidForName2, i46, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int i47 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 24;
                char edgeSlop3 = (char) (30068 - (ViewConfiguration.getEdgeSlop() >> 16));
                int iIndexOf3 = TextUtils.indexOf("", "", 0) + 816;
                byte[] bArr15 = $$a;
                byte b16 = bArr15[5];
                Object[] objArr312 = new Object[1];
                a((byte) (b16 - 1), bArr15[11], b16, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i47, edgeSlop3, iIndexOf3, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new char[]{19, 4, 18, '\b', 11, 21, 14, 11, 7, 6, CharUtils.CR, 5, 5, '\n', 24, 16, 16, 19, 5, 7, '\b', 22}, (byte) (38 - ExpandableListView.getPackedPositionGroup(0L)), objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            b(TextUtils.indexOf("", "") + 15, new char[]{24, 14, '\n', CharUtils.CR, '\t', 15, 11, 3, 24, 19, 6, 24, 17, 16, 13892}, (byte) (69 - (Process.myPid() >> 22)), objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int iResolveSize2 = View.resolveSize(0, 0) + 25;
                char jumpTapTimeout2 = (char) (30068 - (ViewConfiguration.getJumpTapTimeout() >> 16));
                int defaultSize2 = View.getDefaultSize(0, 0) + 816;
                byte[] bArr16 = $$a;
                byte b17 = bArr16[5];
                Object[] objArr315 = new Object[1];
                a((byte) (b17 - 1), bArr16[21], b17, objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iResolveSize2, jumpTapTimeout2, defaultSize2, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i48 = ((int[]) objArr[1])[0];
        int i49 = ((int[]) objArr[0])[0];
        if (i49 == i48) {
            int i50 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
            artificialFrame = i50 % 128;
            int i51 = i50 % 2;
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i52 = ((int[]) objArr[3])[0];
            int i53 = ((int[]) objArr[0])[0];
            int i54 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i55 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
            int i56 = i52 + (((~((-575065126) | i55)) | 536870944) * (-241)) + 1908771557 + (((~(i55 | (-38194182))) | (-913763704)) * 241);
            int i57 = (i56 << 13) ^ i56;
            int i58 = i57 ^ (i57 >>> 17);
            ((int[]) objArr40[3])[0] = i58 ^ (i58 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            for (String str : strArr7) {
                int i59 = artificialFrame + 71;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i59 % 128;
                int i60 = i59 % 2;
                arrayList2.add(str);
            }
        }
        long j7 = ((long) (i48 ^ i49)) ^ (((long) 338167342) << 32);
        long j8 = 338167343;
        int i61 = getARTIFICIAL_FRAME_PACKAGE_NAME + 29;
        artificialFrame = i61 % 128;
        int i62 = i61 % 2;
        Object[] objArr41 = {Long.valueOf(j7), Long.valueOf(j8)};
        byte[] bArr17 = $$j;
        byte b18 = bArr17[12];
        byte b19 = b18;
        Object[] objArr42 = new Object[1];
        c(b18, b19, b19, objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b20 = bArr17[25];
        byte b21 = b20;
        Object[] objArr43 = new Object[1];
        c(b21, (byte) (b21 | Ascii.RS), b20, objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i63 = ((int[]) objArr[3])[0];
        int i64 = ((int[]) objArr[0])[0];
        int i65 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int i66 = Settings.System.getInt(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getContentResolver(), "screen_brightness", -1);
        int i67 = ~i66;
        int i68 = (-335218159) + (((~((-381915791) | i67)) | 335544334 | (~(183743424 | i67)) | (~((-137371969) | i66))) * (-84));
        int i69 = (~(i66 | 183743424)) | 381915790;
        int i70 = ~(i67 | (-183743425));
        int i71 = i63 + i68 + ((i69 | i70) * (-84)) + ((137371968 | i70) * 84);
        int i72 = (i71 << 13) ^ i71;
        int i73 = i72 ^ (i72 >>> 17);
        ((int[]) objArr44[3])[0] = i73 ^ (i73 << 5);
    }
}
