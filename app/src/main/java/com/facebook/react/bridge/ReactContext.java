package com.facebook.react.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.interop.InteropModuleRegistry;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.google.android.gms.stats.zza;
import com.google.common.base.Ascii;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.io.encoding.Base64;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;

/* JADX INFO: loaded from: classes.dex */
public abstract class ReactContext extends ContextWrapper {
    private static final String TAG = "ReactContext";
    private final CopyOnWriteArraySet<ActivityEventListener> mActivityEventListeners;
    private WeakReference<Activity> mCurrentActivity;
    private JSExceptionHandler mExceptionHandlerWrapper;
    private LayoutInflater mInflater;
    public InteropModuleRegistry mInteropModuleRegistry;
    private boolean mIsInitialized;
    private JSExceptionHandler mJSExceptionHandler;
    private MessageQueueThread mJSMessageQueueThread;
    private final CopyOnWriteArraySet<LifecycleEventListener> mLifecycleEventListeners;
    private LifecycleState mLifecycleState;
    private MessageQueueThread mNativeModulesMessageQueueThread;
    private ReactQueueConfiguration mQueueConfig;
    private MessageQueueThread mUiMessageQueueThread;
    private final CopyOnWriteArraySet<WindowFocusChangeListener> mWindowFocusEventListeners;
    private static final byte[] $$s = {84, 120, -38, -81};
    private static final int $$t = 34;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$p = {96, -63, 33, 4, -20, -6, 55, -64, -3, -10, -10, -5, -21, -8, -4, 53, -67, -12, 4, -14, -6, -19, -1, -15, 3, -15, -5, -13, 1, 47, -61, -20, -11, 5, 47, -42, -42, -5, 3, -25, 10, -10, -21, Ascii.ETB, -26, -20, -12, 8, -17, 3, -10, Ascii.ETB, -35, -10, -25, -3, -11, -15, 77, -39, -52, -6, -11, 7, -21, -3, -14, -7, -8, -69, -13, 50, -75, -6, -12, Base64.padSymbol, -70, -11, 0, -3, -7, -10, -16, 53, -61, -20, -11, 5, 47, -77, -5, -1, 51, -29, -62, Ascii.SO, -17, -5, -2, Ascii.EM, -59, 7, -8, -7, -21, Ascii.SYN, -38, 9, -10, -16, -2, -21};
    private static final int $$q = 236;
    private static final byte[] $$g = {67, 87, 59, -10, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$h = 232;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] validateRelationship = {56073, 56068, 56078, 56184, 56187, 56065, 56260, 56191, 56095, 56177, 56190, 56077, 56069, 56111, 56070, 56079, 56071, 56186, 56088, 56064, 56188, 56067, 56098, 56066};
    private static int warmup = -1044259862;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;

    /* JADX INFO: loaded from: classes2.dex */
    public interface RCTDeviceEventEmitter extends JavaScriptModule {
        void emit(@NonNull String str, @Nullable Object obj);
    }

    private static String $$u(byte b, int i, short s) {
        int i2 = 121 - s;
        int i3 = i * 4;
        byte[] bArr = $$s;
        int i4 = b + 4;
        byte[] bArr2 = new byte[1 - i3];
        int i5 = 0 - i3;
        int i6 = -1;
        if (bArr == null) {
            i2 += i5;
        }
        while (true) {
            i6++;
            bArr2[i6] = (byte) i2;
            i4++;
            if (i6 == i5) {
                return new String(bArr2, 0);
            }
            i2 += bArr[i4];
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void g(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 28
            int r8 = 112 - r8
            int r6 = r6 + 4
            byte[] r0 = com.facebook.react.bridge.ReactContext.$$g
            int r7 = r7 * 3
            int r1 = r7 + 9
            byte[] r1 = new byte[r1]
            int r7 = r7 + 8
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r8
            r4 = r2
            r8 = r6
            goto L2f
        L17:
            r3 = r2
        L18:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r0[r6]
            r5 = r8
            r8 = r6
            r6 = r3
            r3 = r5
        L2f:
            int r6 = -r6
            int r6 = r6 + r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.ReactContext.g(short, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void i(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.facebook.react.bridge.ReactContext.$$p
            int r6 = r6 * 63
            int r6 = 99 - r6
            int r8 = r8 * 2
            int r1 = r8 + 3
            int r7 = r7 * 2
            int r7 = 70 - r7
            byte[] r1 = new byte[r1]
            int r8 = r8 + 2
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r7
            r4 = r2
            goto L2f
        L18:
            r3 = r2
        L19:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2f:
            int r6 = -r6
            int r7 = r7 + r6
            int r6 = r7 + (-8)
            int r7 = r3 + 1
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.ReactContext.i(short, byte, byte, java.lang.Object[]):void");
    }

    public abstract void destroy();

    public abstract CatalystInstance getCatalystInstance();

    @Deprecated(since = "This method is deprecated, please use UIManagerHelper.getUIManager() instead.")
    public abstract UIManager getFabricUIManager();

    public abstract CallInvokerHolder getJSCallInvokerHolder();

    public abstract <T extends JavaScriptModule> T getJSModule(Class<T> cls);

    public abstract JavaScriptContextHolder getJavaScriptContextHolder();

    public abstract <T extends NativeModule> T getNativeModule(Class<T> cls);

    public abstract NativeModule getNativeModule(String str);

    public abstract Collection<NativeModule> getNativeModules();

    public abstract String getSourceURL();

    public abstract void handleException(Exception exc);

    @Deprecated
    public abstract boolean hasActiveCatalystInstance();

    public abstract boolean hasActiveReactInstance();

    @Deprecated
    public abstract boolean hasCatalystInstance();

    public abstract <T extends NativeModule> boolean hasNativeModule(Class<T> cls);

    public abstract boolean hasReactInstance();

    @Deprecated
    public abstract boolean isBridgeless();

    public abstract void registerSegment(int i, String str, Callback callback);

    public ReactContext(Context context) {
        super(context);
        this.mLifecycleEventListeners = new CopyOnWriteArraySet<>();
        this.mActivityEventListeners = new CopyOnWriteArraySet<>();
        this.mWindowFocusEventListeners = new CopyOnWriteArraySet<>();
        this.mLifecycleState = LifecycleState.BEFORE_CREATE;
        this.mIsInitialized = false;
    }

    public void initializeFromOther(ReactContext reactContext) {
        if (reactContext.hasReactInstance()) {
            initializeMessageQueueThreads(reactContext.mQueueConfig);
        }
        this.mInteropModuleRegistry = reactContext.mInteropModuleRegistry;
    }

    public void initializeMessageQueueThreads(ReactQueueConfiguration reactQueueConfiguration) {
        synchronized (this) {
            FLog.d(TAG, "initializeMessageQueueThreads() is called.");
            if (this.mUiMessageQueueThread != null || this.mNativeModulesMessageQueueThread != null || this.mJSMessageQueueThread != null) {
                throw new IllegalStateException("Message queue threads already initialized");
            }
            this.mQueueConfig = reactQueueConfiguration;
            this.mUiMessageQueueThread = reactQueueConfiguration.getUIQueueThread();
            this.mNativeModulesMessageQueueThread = reactQueueConfiguration.getNativeModulesQueueThread();
            MessageQueueThread jSQueueThread = reactQueueConfiguration.getJSQueueThread();
            this.mJSMessageQueueThread = jSQueueThread;
            if (this.mUiMessageQueueThread == null) {
                throw new IllegalStateException("UI thread is null");
            }
            if (this.mNativeModulesMessageQueueThread == null) {
                throw new IllegalStateException("NativeModules thread is null");
            }
            if (jSQueueThread == null) {
                throw new IllegalStateException("JavaScript thread is null");
            }
            this.mIsInitialized = true;
        }
    }

    public void initializeInteropModules() {
        this.mInteropModuleRegistry = new InteropModuleRegistry();
    }

    public void resetPerfStats() {
        MessageQueueThread messageQueueThread = this.mNativeModulesMessageQueueThread;
        if (messageQueueThread != null) {
            messageQueueThread.resetPerfStats();
        }
        MessageQueueThread messageQueueThread2 = this.mJSMessageQueueThread;
        if (messageQueueThread2 != null) {
            messageQueueThread2.resetPerfStats();
        }
    }

    public void setJSExceptionHandler(@Nullable JSExceptionHandler jSExceptionHandler) {
        this.mJSExceptionHandler = jSExceptionHandler;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.mInflater;
        }
        return getBaseContext().getSystemService(str);
    }

    public void emitDeviceEvent(String str, @Nullable Object obj) {
        RCTDeviceEventEmitter rCTDeviceEventEmitter = (RCTDeviceEventEmitter) getJSModule(RCTDeviceEventEmitter.class);
        if (rCTDeviceEventEmitter != null) {
            rCTDeviceEventEmitter.emit(str, obj);
        }
    }

    public void emitDeviceEvent(String str) {
        emitDeviceEvent(str, null);
    }

    private static void h(char[] cArr, byte[] bArr, int i, int[] iArr, Object[] objArr) throws Throwable {
        int length;
        char[] cArr2;
        int i2;
        int i3 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr3 = validateRelationship;
        int i4 = -1;
        int i5 = 0;
        if (cArr3 != null) {
            int i6 = $11 + 3;
            $10 = i6 % 128;
            if (i6 % 2 != 0) {
                length = cArr3.length;
                cArr2 = new char[length];
                i2 = 1;
            } else {
                length = cArr3.length;
                cArr2 = new char[length];
                i2 = 0;
            }
            while (i2 < length) {
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i5] = Integer.valueOf(cArr3[i2]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i4;
                        byte b2 = (byte) (b + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(26 - Color.red(i5), (char) (Process.myTid() >> 22), (ViewConfiguration.getScrollBarSize() >> 8) + 1041, -1719489573, false, $$u(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    cArr2[i2] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i2++;
                    i4 = -1;
                    i5 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr3 = cArr2;
        }
        Object[] objArr3 = {Integer.valueOf(warmup)};
        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
        if (objAccessartificialFrame2 == null) {
            byte b3 = (byte) (-1);
            byte b4 = (byte) (b3 + 1);
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(14 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 20488), TextUtils.lastIndexOf("", '0', 0) + 2149, 216472770, false, $$u(b3, b4, (byte) (b4 | 54)), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
        long j = 0;
        if (ICustomTabsServiceDefault) {
            onmessagechannelready.c = bArr.length;
            char[] cArr4 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr4[onmessagechannelready.a] = (char) (cArr3[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                if (objAccessartificialFrame3 == null) {
                    int i7 = (ViewConfiguration.getGlobalActionKeyTimeout() > j ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == j ? 0 : -1)) + 20;
                    char c = (char) ((ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1)) + 59173);
                    int i8 = 1944 - (ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1));
                    byte b5 = (byte) (-1);
                    byte b6 = (byte) (b5 + 1);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i7, c, i8, 481771537, false, $$u(b5, b6, (byte) (b6 | 55)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                j = 0;
            }
            objArr[0] = new String(cArr4);
            return;
        }
        if (requestPostMessageChannelWithExtras) {
            int i9 = $11 + 3;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            onmessagechannelready.c = cArr.length;
            char[] cArr5 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr5[onmessagechannelready.a] = (char) (cArr3[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) (-1);
                    byte b8 = (byte) (b7 + 1);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((Process.myPid() >> 22) + 21, (char) (59174 - View.resolveSize(0, 0)), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1942, 481771537, false, $$u(b7, b8, (byte) (b8 | 55)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            objArr[0] = new String(cArr5);
            return;
        }
        int i11 = 0;
        onmessagechannelready.c = iArr.length;
        char[] cArr6 = new char[onmessagechannelready.c];
        while (true) {
            onmessagechannelready.a = i11;
            if (onmessagechannelready.a >= onmessagechannelready.c) {
                objArr[0] = new String(cArr6);
                return;
            }
            int i12 = $11 + 81;
            $10 = i12 % 128;
            int i13 = i12 % 2;
            cArr6[onmessagechannelready.a] = (char) (cArr3[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
            i11 = onmessagechannelready.a + 1;
        }
    }

    public LifecycleState getLifecycleState() {
        return this.mLifecycleState;
    }

    public void addLifecycleEventListener(final LifecycleEventListener lifecycleEventListener) {
        int i;
        this.mLifecycleEventListeners.add(lifecycleEventListener);
        if ((!hasActiveReactInstance() && !isBridgeless()) || (i = AnonymousClass2.$SwitchMap$com$facebook$react$common$LifecycleState[this.mLifecycleState.ordinal()]) == 1 || i == 2) {
            return;
        }
        if (i == 3) {
            runOnUiQueueThread(new Runnable() { // from class: com.facebook.react.bridge.ReactContext.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ReactContext.this.mLifecycleEventListeners.contains(lifecycleEventListener)) {
                        try {
                            lifecycleEventListener.onHostResume();
                        } catch (RuntimeException e) {
                            ReactContext.this.handleException(e);
                        }
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("Unhandled lifecycle state.");
    }

    /* JADX INFO: renamed from: com.facebook.react.bridge.ReactContext$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$common$LifecycleState;

        static {
            int[] iArr = new int[LifecycleState.values().length];
            $SwitchMap$com$facebook$react$common$LifecycleState = iArr;
            try {
                iArr[LifecycleState.BEFORE_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$common$LifecycleState[LifecycleState.BEFORE_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$common$LifecycleState[LifecycleState.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void removeLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.mLifecycleEventListeners.remove(lifecycleEventListener);
    }

    public void addActivityEventListener(ActivityEventListener activityEventListener) {
        this.mActivityEventListeners.add(activityEventListener);
    }

    public void removeActivityEventListener(ActivityEventListener activityEventListener) {
        this.mActivityEventListeners.remove(activityEventListener);
    }

    public void addWindowFocusChangeListener(WindowFocusChangeListener windowFocusChangeListener) {
        this.mWindowFocusEventListeners.add(windowFocusChangeListener);
    }

    public void removeWindowFocusChangeListener(WindowFocusChangeListener windowFocusChangeListener) {
        this.mWindowFocusEventListeners.remove(windowFocusChangeListener);
    }

    public void onHostResume(@Nullable Activity activity) {
        this.mLifecycleState = LifecycleState.RESUMED;
        this.mCurrentActivity = new WeakReference<>(activity);
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_RESUME_START);
        Iterator<LifecycleEventListener> it2 = this.mLifecycleEventListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().onHostResume();
            } catch (RuntimeException e) {
                handleException(e);
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_RESUME_END);
    }

    public void onUserLeaveHint(@Nullable Activity activity) {
        ReactMarker.logMarker(ReactMarkerConstants.ON_USER_LEAVE_HINT_START);
        Iterator<ActivityEventListener> it2 = this.mActivityEventListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().onUserLeaveHint(activity);
            } catch (RuntimeException e) {
                handleException(e);
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.ON_USER_LEAVE_HINT_END);
    }

    public void onNewIntent(@Nullable Activity activity, Intent intent) {
        UiThreadUtil.assertOnUiThread();
        this.mCurrentActivity = new WeakReference<>(activity);
        Iterator<ActivityEventListener> it2 = this.mActivityEventListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().onNewIntent(intent);
            } catch (RuntimeException e) {
                handleException(e);
            }
        }
    }

    public void onHostPause() {
        this.mLifecycleState = LifecycleState.BEFORE_RESUME;
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_PAUSE_START);
        Iterator<LifecycleEventListener> it2 = this.mLifecycleEventListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().onHostPause();
            } catch (RuntimeException e) {
                handleException(e);
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_PAUSE_END);
    }

    public void onHostDestroy() {
        onHostDestroyImpl();
        this.mCurrentActivity = null;
    }

    public void onHostDestroy(boolean z) {
        if (!z) {
            onHostDestroy();
        } else {
            onHostDestroyImpl();
        }
    }

    private void onHostDestroyImpl() {
        UiThreadUtil.assertOnUiThread();
        this.mLifecycleState = LifecycleState.BEFORE_CREATE;
        Iterator<LifecycleEventListener> it2 = this.mLifecycleEventListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().onHostDestroy();
            } catch (RuntimeException e) {
                handleException(e);
            }
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, @Nullable Intent intent) {
        Iterator<ActivityEventListener> it2 = this.mActivityEventListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().onActivityResult(activity, i, i2, intent);
            } catch (RuntimeException e) {
                handleException(e);
            }
        }
    }

    public void onWindowFocusChange(boolean z) {
        UiThreadUtil.assertOnUiThread();
        Iterator<WindowFocusChangeListener> it2 = this.mWindowFocusEventListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().onWindowFocusChange(z);
            } catch (RuntimeException e) {
                handleException(e);
            }
        }
    }

    public void assertOnUiQueueThread() {
        ((MessageQueueThread) Assertions.assertNotNull(this.mUiMessageQueueThread)).assertIsOnThread();
    }

    public boolean isOnUiQueueThread() {
        return ((MessageQueueThread) Assertions.assertNotNull(this.mUiMessageQueueThread)).isOnThread();
    }

    public void runOnUiQueueThread(Runnable runnable) {
        ((MessageQueueThread) Assertions.assertNotNull(this.mUiMessageQueueThread)).runOnQueue(runnable);
    }

    public void assertOnNativeModulesQueueThread() {
        if (!this.mIsInitialized) {
            throw new IllegalStateException("Tried to call assertOnNativeModulesQueueThread() on an uninitialized ReactContext");
        }
        ((MessageQueueThread) Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).assertIsOnThread();
    }

    public void assertOnNativeModulesQueueThread(String str) {
        if (!this.mIsInitialized) {
            throw new IllegalStateException("Tried to call assertOnNativeModulesQueueThread(message) on an uninitialized ReactContext");
        }
        ((MessageQueueThread) Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).assertIsOnThread(str);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0356  */
    /* JADX WARN: Code duplicated, block: B:32:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:34:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:37:0x03eb A[LOOP:1: B:35:0x03e8->B:37:0x03eb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:46:0x0527  */
    /* JADX WARN: Code duplicated, block: B:48:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:50:0x05af  */
    /* JADX WARN: Code duplicated, block: B:52:0x067b  */
    /* JADX WARN: Code duplicated, block: B:55:0x0722 A[Catch: all -> 0x09fb, TryCatch #2 {all -> 0x09fb, blocks: (B:53:0x070e, B:55:0x0722, B:56:0x074d, B:16:0x01cd, B:18:0x01ed, B:19:0x0236), top: B:97:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0763  */
    /* JADX WARN: Code duplicated, block: B:64:0x081f  */
    /* JADX WARN: Code duplicated, block: B:68:0x0867  */
    /* JADX WARN: Code duplicated, block: B:69:0x08ef  */
    /* JADX WARN: Code duplicated, block: B:71:0x08fa  */
    /* JADX WARN: Code duplicated, block: B:74:0x0907 A[LOOP:0: B:72:0x0904->B:74:0x0907, LOOP_END] */
    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        int i;
        Class<?> cls;
        Object[] objArr;
        Object[] objArr2;
        int i2;
        int i3;
        ArrayList arrayList;
        String[] strArr;
        int i4;
        Object objAccessartificialFrame;
        long j;
        Object objAccessartificialFrame2;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        int i5;
        int i6;
        ArrayList arrayList2;
        String[] strArr2;
        int i7;
        long j2;
        Class<?> cls2;
        Object[] objArr3;
        Object objAccessartificialFrame5;
        int i8 = 2 % 2;
        int i9 = artificialFrame + 17;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i9 % 128;
        int i10 = i9 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame6 == null) {
            int i11 = 26 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
            char maxKeyCode = (char) ((KeyEvent.getMaxKeyCode() >> 16) + 30068);
            int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 816;
            byte b = $$g[21];
            byte b2 = (byte) (b + 1);
            Object[] objArr4 = new Object[1];
            g(b, b2, b2, objArr4);
            objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i11, maxKeyCode, absoluteGravity, 721586079, false, (String) objArr4[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame6).getLong(null);
        try {
            try {
                if (j3 != -1) {
                    long j4 = j3 + 1923;
                    Object[] objArr5 = new Object[1];
                    h(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, 128 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), null, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    h(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, null, objArr6);
                    if (j4 >= ((Long) cls3.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame7 == null) {
                            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0) + 26;
                            char capsMode = (char) (30068 - TextUtils.getCapsMode("", 0, 0));
                            int trimmedLength = TextUtils.getTrimmedLength("") + 816;
                            byte[] bArr = $$g;
                            byte b3 = bArr[11];
                            byte b4 = (byte) (bArr[5] - 1);
                            Object[] objArr7 = new Object[1];
                            g(b3, b4, b4, objArr7);
                            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iIndexOf, capsMode, trimmedLength, 891606461, false, (String) objArr7[0], null);
                        }
                        Object[] objArr8 = (Object[]) ((Field) objAccessartificialFrame7).get(null);
                        objArr2 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i12 = ((int[]) objArr8[0])[0];
                        int i13 = ((int[]) objArr8[1])[0];
                        String[] strArr3 = (String[]) objArr8[2];
                        int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                        int i14 = ~iElapsedRealtime;
                        int i15 = (-720468400) + (((~(3992016 | i14)) | 202164382) * 226) + (((~(i14 | 205318622)) | (~((-202164383) | iElapsedRealtime)) | 837776) * (-113)) + ((~(iElapsedRealtime | 3992016)) * 113) + 1696218622;
                        int i16 = (i15 << 13) ^ i15;
                        int i17 = i16 ^ (i16 >>> 17);
                        ((int[]) objArr2[3])[0] = i17 ^ (i17 << 5);
                    } else {
                        i = 16;
                    }
                    i2 = ((int[]) objArr2[1])[0];
                    i3 = ((int[]) objArr2[0])[0];
                    if (i3 == i2) {
                        int i18 = artificialFrame + 17;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i18 % 128;
                        int i19 = i18 % 2;
                        Object[] objArr9 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i20 = ((int[]) objArr2[3])[0];
                        int i21 = ((int[]) objArr2[0])[0];
                        int i22 = ((int[]) objArr2[1])[0];
                        String[] strArr4 = (String[]) objArr2[2];
                        int i23 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
                        int i24 = i20 + ((((-2142914385) + (((~i23) | 207740944) * 1324)) + (((~(i23 | (-596774248))) | (~(794946613 | i23))) * (-1324))) - 2124983458);
                        int i25 = (i24 << 13) ^ i24;
                        int i26 = i25 ^ (i25 >>> 17);
                        ((int[]) objArr9[3])[0] = i26 ^ (i26 << 5);
                    } else {
                        arrayList = new ArrayList();
                        strArr = (String[]) objArr2[2];
                        if (strArr != null) {
                            for (String str : strArr) {
                                arrayList.add(str);
                            }
                        }
                        try {
                            Object[] objArr10 = {Long.valueOf((((long) (-1784643742)) << 32) ^ ((long) (i2 ^ i3))), Long.valueOf(-1784643741)};
                            byte[] bArr2 = $$p;
                            byte b5 = bArr2[78];
                            byte b6 = bArr2[2];
                            Object[] objArr11 = new Object[1];
                            i(b5, b6, (byte) (b6 - 2), objArr11);
                            Class<?> cls4 = Class.forName((String) objArr11[0]);
                            byte b7 = bArr2[28];
                            Object[] objArr12 = new Object[1];
                            i(b7, b7, bArr2[78], objArr12);
                            cls4.getMethod((String) objArr12[0], Long.TYPE, Long.TYPE).invoke(null, objArr10);
                            Object[] objArr13 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                            int i27 = ((int[]) objArr2[3])[0];
                            int i28 = ((int[]) objArr2[0])[0];
                            int i29 = ((int[]) objArr2[1])[0];
                            String[] strArr5 = (String[]) objArr2[2];
                            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(14) + 332282163;
                            int i30 = i27 + (-1233275809) + (((~((~iCodePointAt) | (-690555937))) | (~((-75514441) | iCodePointAt))) * (-302)) + ((~((-690555937) | iCodePointAt)) * (-604)) + (((~(iCodePointAt | (-766070377))) | (-1039757183)) * 302);
                            int i31 = (i30 << 13) ^ i30;
                            int i32 = i31 ^ (i31 >>> 17);
                            ((int[]) objArr13[3])[0] = i32 ^ (i32 << 5);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame == null) {
                        int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0, 0) + 27;
                        char cIndexOf = (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1);
                        int iAxisFromString = MotionEvent.axisFromString("") + 1042;
                        byte b8 = $$g[21];
                        byte b9 = (byte) (b8 + 1);
                        Object[] objArr14 = new Object[1];
                        g(b8, b9, b9, objArr14);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iLastIndexOf, cIndexOf, iAxisFromString, 2061780482, false, (String) objArr14[0], null);
                    }
                    j = ((Field) objAccessartificialFrame).getLong(null);
                    if (j != -1) {
                        j2 = j + 4611686018427387935L;
                        Object[] objArr15 = new Object[1];
                        h(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, null, objArr15);
                        cls2 = Class.forName((String) objArr15[0]);
                        objArr3 = new Object[1];
                        h(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(8) + 26, null, objArr3);
                        if (j2 >= ((Long) cls2.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                            if (objAccessartificialFrame5 == null) {
                                int iLastIndexOf2 = 25 - TextUtils.lastIndexOf("", '0', 0, 0);
                                char cRgb = (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0));
                                int absoluteGravity2 = 1041 - Gravity.getAbsoluteGravity(0, 0);
                                byte[] bArr3 = $$g;
                                byte b10 = bArr3[11];
                                byte b11 = (byte) (bArr3[5] - 1);
                                Object[] objArr16 = new Object[1];
                                g(b10, b11, b11, objArr16);
                                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, cRgb, absoluteGravity2, 1145017376, false, (String) objArr16[0], null);
                            }
                            Object[] objArr17 = (Object[]) ((Field) objAccessartificialFrame5).get(null);
                            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                            int i33 = ((int[]) objArr17[3])[0];
                            int i34 = ((int[]) objArr17[2])[0];
                            String[] strArr6 = (String[]) objArr17[0];
                            int i35 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
                            int i36 = ~((-373913568) | i35);
                            int i37 = ~i35;
                            int i38 = ((((-82396418) + ((i36 | (~((-295809761) | i37))) * (-1808))) + (((~((-105399584) | i35)) | (~(i37 | (-27295777)))) * TypedValues.Custom.TYPE_BOOLEAN)) + ((((~(i35 | 295809760)) | 268513984) | (~(373913567 | i37))) * TypedValues.Custom.TYPE_BOOLEAN)) - 1364139398;
                            int i39 = (i38 << 13) ^ i38;
                            int i40 = i39 ^ (i39 >>> 17);
                            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i40 ^ (i40 << 5);
                        } else {
                            Object[] objArr18 = new Object[1];
                            h(null, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, null, objArr18);
                            Class<?> cls5 = Class.forName((String) objArr18[0]);
                            Object[] objArr19 = new Object[1];
                            h(null, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, null, objArr19);
                            int iIntValue = ((Integer) cls5.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue();
                            Object[] objArr20 = {-2143107729};
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                            if (objAccessartificialFrame2 == null) {
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((-16777208) - Color.rgb(0, 0, 0), (char) (22251 - Drawable.resolveOpacity(0, 0)), 1033 - ExpandableListView.getPackedPositionType(0L), 47343338, false, null, new Class[]{Integer.TYPE});
                            }
                            objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame2).newInstance(objArr20), -1364139398, false);
                            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-614804952);
                            if (objAccessartificialFrame3 == null) {
                                int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 26;
                                char c = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1);
                                int deadChar = 1041 - KeyEvent.getDeadChar(0, 0);
                                byte[] bArr4 = $$g;
                                byte b12 = bArr4[11];
                                byte b13 = (byte) (bArr4[5] - 1);
                                Object[] objArr21 = new Object[1];
                                g(b12, b13, b13, objArr21);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, c, deadChar, 1145017376, false, (String) objArr21[0], null);
                            }
                            ((Field) objAccessartificialFrame3).set(null, objArrAccessartificialFrame$78cbbd35);
                            try {
                                Object[] objArr22 = new Object[1];
                                h(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, 128 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), null, objArr22);
                                Class<?> cls6 = Class.forName((String) objArr22[0]);
                                Object[] objArr23 = new Object[1];
                                h(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, null, objArr23);
                                Long lValueOf = Long.valueOf(((Long) cls6.getDeclaredMethod((String) objArr23[0], new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-444530678);
                                if (objAccessartificialFrame4 == null) {
                                    int trimmedLength2 = TextUtils.getTrimmedLength("") + 26;
                                    char offsetAfter = (char) TextUtils.getOffsetAfter("", 0);
                                    int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0) + 1042;
                                    byte b14 = $$g[21];
                                    byte b15 = (byte) (b14 + 1);
                                    Object[] objArr24 = new Object[1];
                                    g(b14, b15, b15, objArr24);
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(trimmedLength2, offsetAfter, iLastIndexOf3, 2061780482, false, (String) objArr24[0], null);
                                }
                                ((Field) objAccessartificialFrame4).set(null, lValueOf);
                            } catch (Exception unused) {
                                throw new RuntimeException();
                            }
                        }
                    } else {
                        Object[] objArr110 = new Object[1];
                        h(null, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, null, objArr110);
                        Class<?> cls7 = Class.forName((String) objArr110[0]);
                        Object[] objArr111 = new Object[1];
                        h(null, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, null, objArr111);
                        int iIntValue2 = ((Integer) cls7.getMethod((String) objArr111[0], Object.class).invoke(null, this)).intValue();
                        Object[] objArr25 = {-2143107729};
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                        if (objAccessartificialFrame2 == null) {
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((-16777208) - Color.rgb(0, 0, 0), (char) (22251 - Drawable.resolveOpacity(0, 0)), 1033 - ExpandableListView.getPackedPositionType(0L), 47343338, false, null, new Class[]{Integer.TYPE});
                        }
                        objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame2).newInstance(objArr25), -1364139398, false);
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame3 == null) {
                            int jumpTapTimeout2 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 26;
                            char c2 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1);
                            int deadChar2 = 1041 - KeyEvent.getDeadChar(0, 0);
                            byte[] bArr5 = $$g;
                            byte b16 = bArr5[11];
                            byte b17 = (byte) (bArr5[5] - 1);
                            Object[] objArr26 = new Object[1];
                            g(b16, b17, b17, objArr26);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout2, c2, deadChar2, 1145017376, false, (String) objArr26[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, objArrAccessartificialFrame$78cbbd35);
                        Object[] objArr27 = new Object[1];
                        h(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, 128 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), null, objArr27);
                        Class<?> cls8 = Class.forName((String) objArr27[0]);
                        Object[] objArr28 = new Object[1];
                        h(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, null, objArr28);
                        Long lValueOf2 = Long.valueOf(((Long) cls8.getDeclaredMethod((String) objArr28[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame4 == null) {
                            int trimmedLength3 = TextUtils.getTrimmedLength("") + 26;
                            char offsetAfter2 = (char) TextUtils.getOffsetAfter("", 0);
                            int iLastIndexOf4 = TextUtils.lastIndexOf("", '0', 0) + 1042;
                            byte b18 = $$g[21];
                            byte b19 = (byte) (b18 + 1);
                            Object[] objArr29 = new Object[1];
                            g(b18, b19, b19, objArr29);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(trimmedLength3, offsetAfter2, iLastIndexOf4, 2061780482, false, (String) objArr29[0], null);
                        }
                        ((Field) objAccessartificialFrame4).set(null, lValueOf2);
                    }
                    i5 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    i6 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    if (i6 == i5) {
                        int i41 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                        artificialFrame = i41 % 128;
                        int i42 = i41 % 2;
                        Object[] objArr30 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                        int i43 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                        int i44 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                        int i45 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                        int i46 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
                        int i47 = ~i46;
                        int i48 = i43 + (-1241422114) + ((~(289491546 | i47)) * (-560)) + ((~(i46 | 500813659)) * (-560)) + (((~((-211387740) | i47)) | 65626) * 560);
                        int i49 = (i48 << 13) ^ i48;
                        int i50 = i49 ^ (i49 >>> 17);
                        ((int[]) objArr30[1])[0] = i50 ^ (i50 << 5);
                        return;
                    }
                    arrayList2 = new ArrayList();
                    strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    if (strArr2 != null) {
                        int i51 = getARTIFICIAL_FRAME_PACKAGE_NAME + 99;
                        artificialFrame = i51 % 128;
                        int i52 = i51 % 2;
                        for (String str2 : strArr2) {
                            int i53 = artificialFrame + 53;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i53 % 128;
                            int i54 = i53 % 2;
                            arrayList2.add(str2);
                        }
                    }
                    long j5 = ((long) (i5 ^ i6)) ^ (((long) (-965970744)) << 32);
                    long j6 = -965970742;
                    int i55 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                    artificialFrame = i55 % 128;
                    int i56 = i55 % 2;
                    Object[] objArr31 = {Long.valueOf(j5), Long.valueOf(j6)};
                    byte[] bArr6 = $$p;
                    byte b20 = bArr6[78];
                    Object[] objArr32 = new Object[1];
                    i(b20, b20, (byte) (-bArr6[4]), objArr32);
                    Class<?> cls9 = Class.forName((String) objArr32[0]);
                    byte b21 = bArr6[28];
                    Object[] objArr33 = new Object[1];
                    i(b21, b21, bArr6[78], objArr33);
                    cls9.getMethod((String) objArr33[0], Long.TYPE, Long.TYPE).invoke(null, objArr31);
                    Object[] objArr34 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                    int i57 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                    int i58 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    int i59 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    int iUptimeMillis = (int) SystemClock.uptimeMillis();
                    int i60 = i57 + (-158433714) + (((~(516135929 | iUptimeMillis)) | 556294144) * 336) + (((~(iUptimeMillis | 594239736)) | 478190337) * (-168)) + (((~((~iUptimeMillis) | 594239736)) | 516135929) * 168);
                    int i61 = (i60 << 13) ^ i60;
                    int i62 = i61 ^ (i61 >>> 17);
                    ((int[]) objArr34[1])[0] = i62 ^ (i62 << 5);
                    return;
                }
                i = 16;
                Object[] objArr35 = new Object[1];
                h(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 127, null, objArr35);
                Class<?> cls10 = Class.forName((String) objArr35[0]);
                Object[] objArr36 = new Object[1];
                h(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 91, null, objArr36);
                Long lValueOf3 = Long.valueOf(((Long) cls10.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame8 == null) {
                    int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 25;
                    char c3 = (char) (30069 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                    int i63 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 815;
                    byte b22 = $$g[21];
                    byte b23 = (byte) (b22 + 1);
                    Object[] objArr37 = new Object[1];
                    g(b22, b23, b23, objArr37);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(tapTimeout, c3, i63, 721586079, false, (String) objArr37[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, lValueOf3);
                i2 = ((int[]) objArr2[1])[0];
                i3 = ((int[]) objArr2[0])[0];
                if (i3 == i2) {
                    int i110 = artificialFrame + 17;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i110 % 128;
                    int i111 = i110 % 2;
                    Object[] objArr38 = {new int[]{i21}, new int[]{i22}, strArr4, new int[1]};
                    int i210 = ((int[]) objArr2[3])[0];
                    int i211 = ((int[]) objArr2[0])[0];
                    int i212 = ((int[]) objArr2[1])[0];
                    String[] strArr9 = (String[]) objArr2[2];
                    int i213 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
                    int i214 = i210 + ((((-2142914385) + (((~i213) | 207740944) * 1324)) + (((~(i213 | (-596774248))) | (~(794946613 | i213))) * (-1324))) - 2124983458);
                    int i215 = (i214 << 13) ^ i214;
                    int i216 = i215 ^ (i215 >>> 17);
                    ((int[]) objArr38[3])[0] = i216 ^ (i216 << 5);
                } else {
                    arrayList = new ArrayList();
                    strArr = (String[]) objArr2[2];
                    if (strArr != null) {
                        while (i4 < strArr.length) {
                            arrayList.add(str);
                        }
                    }
                    Object[] objArr112 = {Long.valueOf((((long) (-1784643742)) << 32) ^ ((long) (i2 ^ i3))), Long.valueOf(-1784643741)};
                    byte[] bArr7 = $$p;
                    byte b24 = bArr7[78];
                    byte b25 = bArr7[2];
                    Object[] objArr113 = new Object[1];
                    i(b24, b25, (byte) (b25 - 2), objArr113);
                    Class<?> cls11 = Class.forName((String) objArr113[0]);
                    byte b26 = bArr7[28];
                    Object[] objArr114 = new Object[1];
                    i(b26, b26, bArr7[78], objArr114);
                    cls11.getMethod((String) objArr114[0], Long.TYPE, Long.TYPE).invoke(null, objArr112);
                    Object[] objArr115 = {new int[]{i28}, new int[]{i29}, strArr5, new int[1]};
                    int i217 = ((int[]) objArr2[3])[0];
                    int i218 = ((int[]) objArr2[0])[0];
                    int i219 = ((int[]) objArr2[1])[0];
                    String[] strArr10 = (String[]) objArr2[2];
                    int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(14) + 332282163;
                    int i310 = i217 + (-1233275809) + (((~((~iCodePointAt2) | (-690555937))) | (~((-75514441) | iCodePointAt2))) * (-302)) + ((~((-690555937) | iCodePointAt2)) * (-604)) + (((~(iCodePointAt2 | (-766070377))) | (-1039757183)) * 302);
                    int i311 = (i310 << 13) ^ i310;
                    int i312 = i311 ^ (i311 >>> 17);
                    ((int[]) objArr115[3])[0] = i312 ^ (i312 << 5);
                }
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame == null) {
                    int iLastIndexOf5 = TextUtils.lastIndexOf("", '0', 0, 0) + 27;
                    char cIndexOf2 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1);
                    int iAxisFromString2 = MotionEvent.axisFromString("") + 1042;
                    byte b27 = $$g[21];
                    byte b28 = (byte) (b27 + 1);
                    Object[] objArr116 = new Object[1];
                    g(b27, b28, b28, objArr116);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iLastIndexOf5, cIndexOf2, iAxisFromString2, 2061780482, false, (String) objArr116[0], null);
                }
                j = ((Field) objAccessartificialFrame).getLong(null);
                if (j != -1) {
                    j2 = j + 4611686018427387935L;
                    Object[] objArr117 = new Object[1];
                    h(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, null, objArr117);
                    cls2 = Class.forName((String) objArr117[0]);
                    objArr3 = new Object[1];
                    h(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(8) + 26, null, objArr3);
                    if (j2 >= ((Long) cls2.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame5 == null) {
                            int iLastIndexOf6 = 25 - TextUtils.lastIndexOf("", '0', 0, 0);
                            char cRgb2 = (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0));
                            int absoluteGravity3 = 1041 - Gravity.getAbsoluteGravity(0, 0);
                            byte[] bArr8 = $$g;
                            byte b110 = bArr8[11];
                            byte b111 = (byte) (bArr8[5] - 1);
                            Object[] objArr118 = new Object[1];
                            g(b110, b111, b111, objArr118);
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iLastIndexOf6, cRgb2, absoluteGravity3, 1145017376, false, (String) objArr118[0], null);
                        }
                        Object[] objArr119 = (Object[]) ((Field) objAccessartificialFrame5).get(null);
                        objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr6, new int[1], new int[]{i34}, new int[]{i33}};
                        int i313 = ((int[]) objArr119[3])[0];
                        int i314 = ((int[]) objArr119[2])[0];
                        String[] strArr11 = (String[]) objArr119[0];
                        int i315 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
                        int i316 = ~((-373913568) | i315);
                        int i317 = ~i315;
                        int i318 = ((((-82396418) + ((i316 | (~((-295809761) | i317))) * (-1808))) + (((~((-105399584) | i315)) | (~(i317 | (-27295777)))) * TypedValues.Custom.TYPE_BOOLEAN)) + ((((~(i315 | 295809760)) | 268513984) | (~(373913567 | i317))) * TypedValues.Custom.TYPE_BOOLEAN)) - 1364139398;
                        int i319 = (i318 << 13) ^ i318;
                        int i410 = i319 ^ (i319 >>> 17);
                        ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i410 ^ (i410 << 5);
                    } else {
                        Object[] objArr1110 = new Object[1];
                        h(null, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, null, objArr1110);
                        Class<?> cls12 = Class.forName((String) objArr1110[0]);
                        Object[] objArr1111 = new Object[1];
                        h(null, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, null, objArr1111);
                        int iIntValue3 = ((Integer) cls12.getMethod((String) objArr1111[0], Object.class).invoke(null, this)).intValue();
                        Object[] objArr210 = {-2143107729};
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                        if (objAccessartificialFrame2 == null) {
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((-16777208) - Color.rgb(0, 0, 0), (char) (22251 - Drawable.resolveOpacity(0, 0)), 1033 - ExpandableListView.getPackedPositionType(0L), 47343338, false, null, new Class[]{Integer.TYPE});
                        }
                        objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue3, 0, ((Constructor) objAccessartificialFrame2).newInstance(objArr210), -1364139398, false);
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame3 == null) {
                            int jumpTapTimeout3 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 26;
                            char c4 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1);
                            int deadChar3 = 1041 - KeyEvent.getDeadChar(0, 0);
                            byte[] bArr9 = $$g;
                            byte b112 = bArr9[11];
                            byte b113 = (byte) (bArr9[5] - 1);
                            Object[] objArr211 = new Object[1];
                            g(b112, b113, b113, objArr211);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout3, c4, deadChar3, 1145017376, false, (String) objArr211[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, objArrAccessartificialFrame$78cbbd35);
                        Object[] objArr212 = new Object[1];
                        h(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, 128 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), null, objArr212);
                        Class<?> cls13 = Class.forName((String) objArr212[0]);
                        Object[] objArr213 = new Object[1];
                        h(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, null, objArr213);
                        Long lValueOf4 = Long.valueOf(((Long) cls13.getDeclaredMethod((String) objArr213[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame4 == null) {
                            int trimmedLength4 = TextUtils.getTrimmedLength("") + 26;
                            char offsetAfter3 = (char) TextUtils.getOffsetAfter("", 0);
                            int iLastIndexOf7 = TextUtils.lastIndexOf("", '0', 0) + 1042;
                            byte b114 = $$g[21];
                            byte b115 = (byte) (b114 + 1);
                            Object[] objArr214 = new Object[1];
                            g(b114, b115, b115, objArr214);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(trimmedLength4, offsetAfter3, iLastIndexOf7, 2061780482, false, (String) objArr214[0], null);
                        }
                        ((Field) objAccessartificialFrame4).set(null, lValueOf4);
                    }
                } else {
                    Object[] objArr1112 = new Object[1];
                    h(null, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, null, objArr1112);
                    Class<?> cls14 = Class.forName((String) objArr1112[0]);
                    Object[] objArr1113 = new Object[1];
                    h(null, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, null, objArr1113);
                    int iIntValue4 = ((Integer) cls14.getMethod((String) objArr1113[0], Object.class).invoke(null, this)).intValue();
                    Object[] objArr215 = {-2143107729};
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((-16777208) - Color.rgb(0, 0, 0), (char) (22251 - Drawable.resolveOpacity(0, 0)), 1033 - ExpandableListView.getPackedPositionType(0L), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue4, 0, ((Constructor) objAccessartificialFrame2).newInstance(objArr215), -1364139398, false);
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame3 == null) {
                        int jumpTapTimeout4 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 26;
                        char c5 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1);
                        int deadChar4 = 1041 - KeyEvent.getDeadChar(0, 0);
                        byte[] bArr10 = $$g;
                        byte b116 = bArr10[11];
                        byte b117 = (byte) (bArr10[5] - 1);
                        Object[] objArr216 = new Object[1];
                        g(b116, b117, b117, objArr216);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout4, c5, deadChar4, 1145017376, false, (String) objArr216[0], null);
                    }
                    ((Field) objAccessartificialFrame3).set(null, objArrAccessartificialFrame$78cbbd35);
                    Object[] objArr217 = new Object[1];
                    h(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, 128 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), null, objArr217);
                    Class<?> cls15 = Class.forName((String) objArr217[0]);
                    Object[] objArr218 = new Object[1];
                    h(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, null, objArr218);
                    Long lValueOf5 = Long.valueOf(((Long) cls15.getDeclaredMethod((String) objArr218[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame4 == null) {
                        int trimmedLength5 = TextUtils.getTrimmedLength("") + 26;
                        char offsetAfter4 = (char) TextUtils.getOffsetAfter("", 0);
                        int iLastIndexOf8 = TextUtils.lastIndexOf("", '0', 0) + 1042;
                        byte b118 = $$g[21];
                        byte b119 = (byte) (b118 + 1);
                        Object[] objArr219 = new Object[1];
                        g(b118, b119, b119, objArr219);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(trimmedLength5, offsetAfter4, iLastIndexOf8, 2061780482, false, (String) objArr219[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, lValueOf5);
                }
                i5 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                i6 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                if (i6 == i5) {
                    int i411 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                    artificialFrame = i411 % 128;
                    int i412 = i411 % 2;
                    Object[] objArr39 = {strArr7, new int[1], new int[]{i45}, new int[]{i44}};
                    int i413 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                    int i414 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    int i415 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    String[] strArr12 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    int i416 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
                    int i417 = ~i416;
                    int i418 = i413 + (-1241422114) + ((~(289491546 | i417)) * (-560)) + ((~(i416 | 500813659)) * (-560)) + (((~((-211387740) | i417)) | 65626) * 560);
                    int i419 = (i418 << 13) ^ i418;
                    int i510 = i419 ^ (i419 >>> 17);
                    ((int[]) objArr39[1])[0] = i510 ^ (i510 << 5);
                    return;
                }
                arrayList2 = new ArrayList();
                strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                if (strArr2 != null) {
                    int i511 = getARTIFICIAL_FRAME_PACKAGE_NAME + 99;
                    artificialFrame = i511 % 128;
                    int i512 = i511 % 2;
                    while (i7 < strArr2.length) {
                        int i513 = artificialFrame + 53;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i513 % 128;
                        int i514 = i513 % 2;
                        arrayList2.add(str2);
                    }
                }
                long j7 = ((long) (i5 ^ i6)) ^ (((long) (-965970744)) << 32);
                long j8 = -965970742;
                int i515 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                artificialFrame = i515 % 128;
                int i516 = i515 % 2;
                Object[] objArr310 = {Long.valueOf(j7), Long.valueOf(j8)};
                byte[] bArr11 = $$p;
                byte b29 = bArr11[78];
                Object[] objArr311 = new Object[1];
                i(b29, b29, (byte) (-bArr11[4]), objArr311);
                Class<?> cls16 = Class.forName((String) objArr311[0]);
                byte b210 = bArr11[28];
                Object[] objArr312 = new Object[1];
                i(b210, b210, bArr11[78], objArr312);
                cls16.getMethod((String) objArr312[0], Long.TYPE, Long.TYPE).invoke(null, objArr310);
                Object[] objArr313 = {strArr8, new int[1], new int[]{i59}, new int[]{i58}};
                int i517 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i518 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i519 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr13 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
                int i64 = i517 + (-158433714) + (((~(516135929 | iUptimeMillis2)) | 556294144) * 336) + (((~(iUptimeMillis2 | 594239736)) | 478190337) * (-168)) + (((~((~iUptimeMillis2) | 594239736)) | 516135929) * 168);
                int i65 = (i64 << 13) ^ i64;
                int i66 = i65 ^ (i65 >>> 17);
                ((int[]) objArr313[1])[0] = i66 ^ (i66 << 5);
                return;
            } catch (Exception unused2) {
                throw new RuntimeException();
            }
            Object[] objArr40 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr[0], Object.class).invoke(null, this)).intValue()), 0, 1696218622};
            Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame9 == null) {
                int gidForName = Process.getGidForName("") + 26;
                char cCombineMeasuredStates = (char) (30068 - View.combineMeasuredStates(0, 0));
                int i67 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 815;
                byte[] bArr12 = $$g;
                byte b30 = (byte) (-bArr12[19]);
                byte b31 = bArr12[5];
                Object[] objArr41 = new Object[1];
                g(b30, b31, b31, objArr41);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(gidForName, cCombineMeasuredStates, i67, -797394565, false, (String) objArr41[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr2 = (Object[]) ((Method) objAccessartificialFrame9).invoke(null, objArr40);
            Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame10 == null) {
                int i68 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 24;
                char scrollBarFadeDuration = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30068);
                int iIndexOf2 = 816 - TextUtils.indexOf("", "", 0);
                byte[] bArr13 = $$g;
                byte b32 = bArr13[11];
                byte b33 = (byte) (bArr13[5] - 1);
                Object[] objArr42 = new Object[1];
                g(b32, b33, b33, objArr42);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i68, scrollBarFadeDuration, iIndexOf2, 891606461, false, (String) objArr42[0], null);
            }
            ((Field) objAccessartificialFrame10).set(null, objArr2);
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
        byte[] bArr14 = new byte[i];
        // fill-array-data instruction
        bArr14[0] = -115;
        bArr14[1] = -116;
        bArr14[2] = -117;
        bArr14[3] = -120;
        bArr14[4] = -118;
        bArr14[5] = -119;
        bArr14[6] = -121;
        bArr14[7] = -106;
        bArr14[8] = -126;
        bArr14[9] = -127;
        bArr14[10] = -113;
        bArr14[11] = -121;
        bArr14[12] = -127;
        bArr14[13] = -107;
        bArr14[14] = -127;
        bArr14[15] = -108;
        Object[] objArr43 = new Object[1];
        h(null, bArr14, (KeyEvent.getMaxKeyCode() >> i) + 127, null, objArr43);
        cls = Class.forName((String) objArr43[0]);
        byte[] bArr15 = new byte[i];
        // fill-array-data instruction
        bArr15[0] = -116;
        bArr15[1] = -125;
        bArr15[2] = -123;
        bArr15[3] = -114;
        bArr15[4] = -104;
        bArr15[5] = -120;
        bArr15[6] = -127;
        bArr15[7] = -105;
        bArr15[8] = -118;
        bArr15[9] = -117;
        bArr15[10] = -122;
        bArr15[11] = -117;
        bArr15[12] = -126;
        bArr15[13] = -116;
        bArr15[14] = -125;
        bArr15[15] = -122;
        objArr = new Object[1];
        h(null, bArr15, 127 - (ViewConfiguration.getScrollBarSize() >> 8), null, objArr);
    }

    public boolean isOnNativeModulesQueueThread() {
        return ((MessageQueueThread) Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).isOnThread();
    }

    public void runOnNativeModulesQueueThread(Runnable runnable) {
        ((MessageQueueThread) Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).runOnQueue(runnable);
    }

    public void assertOnJSQueueThread() {
        ((MessageQueueThread) Assertions.assertNotNull(this.mJSMessageQueueThread)).assertIsOnThread();
    }

    public boolean isOnJSQueueThread() {
        return ((MessageQueueThread) Assertions.assertNotNull(this.mJSMessageQueueThread)).isOnThread();
    }

    public boolean runOnJSQueueThread(Runnable runnable) {
        return ((MessageQueueThread) Assertions.assertNotNull(this.mJSMessageQueueThread)).runOnQueue(runnable);
    }

    public MessageQueueThread getJSMessageQueueThread() {
        return this.mJSMessageQueueThread;
    }

    public MessageQueueThread getNativeModulesMessageQueueThread() {
        return this.mNativeModulesMessageQueueThread;
    }

    public MessageQueueThread getUiMessageQueueThread() {
        return this.mUiMessageQueueThread;
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class ExceptionHandlerWrapper implements JSExceptionHandler {
        public ExceptionHandlerWrapper() {
        }

        @Override // com.facebook.react.bridge.JSExceptionHandler
        public void handleException(Exception exc) {
            ReactContext.this.handleException(exc);
        }
    }

    public JSExceptionHandler getExceptionHandler() {
        if (this.mExceptionHandlerWrapper == null) {
            this.mExceptionHandlerWrapper = new ExceptionHandlerWrapper();
        }
        return this.mExceptionHandlerWrapper;
    }

    public JSExceptionHandler getJSExceptionHandler() {
        return this.mJSExceptionHandler;
    }

    public boolean hasCurrentActivity() {
        WeakReference<Activity> weakReference = this.mCurrentActivity;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public boolean startActivityForResult(Intent intent, int i, Bundle bundle) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return false;
        }
        currentActivity.startActivityForResult(intent, i, bundle);
        return true;
    }

    public Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.mCurrentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public <T extends JavaScriptModule> void internal_registerInteropModule(Class<T> cls, Object obj) {
        InteropModuleRegistry interopModuleRegistry = this.mInteropModuleRegistry;
        if (interopModuleRegistry != null) {
            interopModuleRegistry.registerInteropModule(cls, obj);
        }
    }
}
