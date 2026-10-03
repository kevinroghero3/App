package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BridgeReactContext;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ProxyJavaScriptExecutor;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactCxxErrorHandler;
import com.facebook.react.bridge.ReactInstanceManagerInspectorTarget;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerProvider;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.devsupport.DevSupportManagerFactory;
import com.facebook.react.devsupport.InspectorFlags;
import com.facebook.react.devsupport.ReactInstanceDevHelper;
import com.facebook.react.devsupport.inspector.InspectorNetworkHelper;
import com.facebook.react.devsupport.inspector.InspectorNetworkRequestListener;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.interfaces.TaskInterface;
import com.facebook.react.internal.AndroidChoreographerProvider;
import com.facebook.react.internal.ChoreographerProvider;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.internal.turbomodule.core.TurboModuleManager;
import com.facebook.react.modules.appearance.AppearanceModule;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.google.common.base.Ascii;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.ArtificialStackFrames;
import o._CREATION;
import o.onMessageChannelReady;

/* JADX INFO: loaded from: classes.dex */
public class ReactInstanceManager {
    private static final String TAG = "ReactInstanceManager";
    private final Context mApplicationContext;
    private final NotThreadSafeBridgeIdleDebugListener mBridgeIdleDebugListener;
    private final JSBundleLoader mBundleLoader;
    private volatile Thread mCreateReactContextThread;
    private Activity mCurrentActivity;
    private volatile ReactContext mCurrentReactContext;
    private DefaultHardwareBackBtnHandler mDefaultBackButtonImpl;
    private final DevSupportManager mDevSupportManager;
    private ReactInstanceManagerInspectorTarget mInspectorTarget;
    private final JSExceptionHandler mJSExceptionHandler;
    private final String mJSMainModulePath;
    private final JavaScriptExecutorFactory mJavaScriptExecutorFactory;
    private final boolean mKeepActivity;
    private volatile LifecycleState mLifecycleState;
    private final MemoryPressureRouter mMemoryPressureRouter;
    private final List<ReactPackage> mPackages;
    private ReactContextInitParams mPendingReactContextInitParams;
    private final boolean mRequireActivity;
    private final ReactPackageTurboModuleManagerDelegate.Builder mTMMDelegateBuilder;
    private final UIManagerProvider mUIManagerProvider;
    private final boolean mUseDeveloperSupport;
    private List<ViewManager> mViewManagers;
    private final Set<ReactRoot> mAttachedReactRoots = Collections.synchronizedSet(new HashSet());
    private Collection<String> mViewManagerNames = null;
    private final Object mReactContextLock = new Object();
    private final Collection<com.facebook.react.ReactInstanceEventListener> mReactInstanceEventListeners = Collections.synchronizedList(new ArrayList());
    private volatile boolean mHasStartedCreatingInitialContext = false;
    private volatile Boolean mHasStartedDestroying = Boolean.FALSE;
    private boolean mUseFallbackBundle = true;
    private volatile boolean mInstanceManagerInvalidated = false;

    /* JADX INFO: loaded from: classes4.dex */
    @Deprecated
    public interface ReactInstanceEventListener extends com.facebook.react.ReactInstanceEventListener {
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class ReactContextInitParams {
        private final JSBundleLoader mJsBundleLoader;
        private final JavaScriptExecutorFactory mJsExecutorFactory;
        private static final byte[] $$c = {106, -29, -101, -119};
        private static final int $$d = 35;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {119, 121, -44, Ascii.VT, Ascii.FF, 6, -27, Ascii.SYN, Ascii.SUB, -4, Ascii.FF, 0, 8, 2, 8};
        private static final int $$b = 206;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] validateRelationship = {55869, 56006, 55849, 56049, 55857, 55870, 55856, 56019, 55864, 56037, 55850, 55865, 55866, 55861, 55851, 55859, 56027, 56030, 55860, 56004, 56036, 55867, 56011, 55858, 55863, 56053, 56042, 56041, 56054, 56026, 55854, 56028, 56023, 56024, 55871, 56015, 56055, 56046, 56025, 56052, 56043, 56040, 55848, 56051, 55868, 56018, 56017, 56038};
        private static int warmup = -1044260185;
        private static boolean requestPostMessageChannelWithExtras = true;
        private static boolean ICustomTabsServiceDefault = true;
        private static char[] _CREATION = {6596, 5557, 33900, 13846, 41029, 21176, 6591, 34888, 14890, 44036, 24305, 49327, 29322, 58717, 38747, 14623, 43997, 24002, 53169, 32372, 57419, 54779, 17448, 63063, 24696, 37599, 3290, 48868, 10522, 23332, 62843, 26504, 37293, 968, 45639, 11274, 24156, 51304, 31386, 38101, 1782, 45315, 9036, 6546, 34889, 14895, 44050, 6548, 34887, 14904, 44055, 24240, 49333, 29323, 58741, 38731, 14612, 44007, 24002, 53159, 32296, 57437, 37414, 1051, 46789, 22752, 51891, 32093, 61185, 37131, 1016, 46574, 10119, 54908, 30807, 59955, 40163, 3802, 45235, 8844, 54645, 18238, 59667, 39933, 57374, 29149, 50108, 21992, 42783, 14656, 35691, 49954, 21240, 57473, 30344, 33867, 6686, 43066, 16329, 19936, 58297, 34536, 5938, 42321, 13154, 49565, 24534, 60907, 31234, 2060, 42610, 13453, 49843, 20678, 57617, 32566, 3396, 39790, 10659, 51162, 51710, 22573, 59986, 31869, 36570, 4319, 41697, 13599, 18209, 59774, 31629, 36264, 8141, 44610, 12327, 16985, 54374, 26296, 34954, 6852, 44353, 16156, 16701, 54207, 26033, 63486, 1552, 43061, 14930, 19589, 56999, 24797, 62176, 1321, 29481, 58099, 20618, 50819, 13398, 43522, 6203, 36808, 65021, 21439, 49489, 14184, 42296, 5335, 35570, 63635, 28331, 31965, 60695, 24384, 51547, 15282, 42467, 6126, 32801, 61978, 23618, 52905, 14470, 6548, 34887, 14904, 44055, 24240, 49320, 29319, 58745, 38672, 14628, 44027, 24016, 53176, 32355, 57436, 6546, 34895, 14883, 44063, 24298, 56748, 19583, 65024, 26671, 39560, 1170, 46775, 8512, 21345, 64880, 28666, 39393, 2952, 47705, 21603, 50592, 30703, 57850, 4879, 36220, 16243, 43149, 55998, 29921, 58880, 58345, 29246, 49244, 22130, 42119, 15065, 35068, 8014, 27947, 50047, 20886, 42932, 13773, 33822, 6700, 26638, 65099, 19647, 41686, 12532, 34573, 5448, 27500, 6553, 34883, 14906, 44070, 24319, 49317, 29317, 58743, 38745, 14595, 43975, 24024, 53176, 32361, 6559, 34888, 14890, 44036, 24305, 49327, 29322, 58680, 38749, 14601, 44000, 24002, 53179, 32360, 57434, 37496, 1038, 46795, 22752, 51878, 32127, 61221, 37125, 1015, 46553, 10115, 54855, 30808, 59960, 40169, 6541, 34895, 14889, 44056, 24319, 49330, 29339, 58724, 38747, 14613, 61596, 24911, 54064, 17695, 47032, 10685, 39811, 3197, 32323, 53276, 17135, 46282, 9903, 38688, 2411, 31547, 60677, 24541, 45479, 9113, 38003, 1546, 30735, 60153, 23763, 52893, 16242, 61765, 24722, 54000, 17630, 46635, 10357, 39504, 3554, 32647, 53715, 17210, 46360, 10081, 38578, 2176, 31394, 60628, 24081, 45114, 8831, 38317, 2043, 31194, 60205, 23824, 53065, 16038, 37001, 59498, 31167, 52185, 24035, 44829, 12610, 6580, 34887, 14904, 44055};
        private static long _BOUNDARY = 4326970996510722086L;

        /* JADX WARN: Code duplicated, block: B:10:0x0025  */
        /* JADX WARN: Code duplicated, block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(byte r7, byte r8, short r9) {
            /*
                int r8 = r8 * 2
                int r8 = r8 + 1
                byte[] r0 = com.facebook.react.ReactInstanceManager.ReactContextInitParams.$$c
                int r7 = r7 + 66
                int r9 = r9 * 3
                int r9 = 3 - r9
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L15
                r7 = r8
                r3 = r9
                r4 = r2
                goto L2a
            L15:
                r3 = r2
            L16:
                int r4 = r3 + 1
                byte r5 = (byte) r7
                r1[r3] = r5
                int r9 = r9 + 1
                if (r4 != r8) goto L25
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                return r7
            L25:
                r3 = r0[r9]
                r6 = r3
                r3 = r9
                r9 = r6
            L2a:
                int r9 = -r9
                int r7 = r7 + r9
                r9 = r3
                r3 = r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactInstanceManager.ReactContextInitParams.$$e(byte, byte, short):java.lang.String");
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
        private static void a(byte r6, byte r7, short r8, java.lang.Object[] r9) {
            /*
                int r8 = r8 * 3
                int r8 = 115 - r8
                int r7 = r7 * 5
                int r0 = 9 - r7
                int r6 = r6 * 8
                int r6 = r6 + 4
                byte[] r1 = com.facebook.react.ReactInstanceManager.ReactContextInitParams.$$a
                byte[] r0 = new byte[r0]
                int r7 = 8 - r7
                r2 = 0
                if (r1 != 0) goto L19
                r4 = r8
                r3 = r2
                r8 = r6
                goto L2e
            L19:
                r3 = r2
            L1a:
                byte r4 = (byte) r8
                r0[r3] = r4
                if (r3 != r7) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r0, r2)
                r9[r2] = r6
                return
            L27:
                int r3 = r3 + 1
                r4 = r1[r6]
                r5 = r8
                r8 = r6
                r6 = r5
            L2e:
                int r6 = r6 + r4
                int r6 = r6 + (-7)
                int r8 = r8 + 1
                r5 = r8
                r8 = r6
                r6 = r5
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactInstanceManager.ReactContextInitParams.a(byte, byte, short, java.lang.Object[]):void");
        }

        private static void c(int i, char c, int i2, Object[] objArr) throws Throwable {
            int i3 = 2 % 2;
            _CREATION _creation = new _CREATION();
            long[] jArr = new long[i];
            int i4 = 0;
            _creation.b = 0;
            while (_creation.b < i) {
                int i5 = $10 + 85;
                $11 = i5 % 128;
                int i6 = i5 % 2;
                int i7 = _creation.b;
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i4] = Integer.valueOf(_CREATION[i2 + i7]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame == null) {
                        int keyRepeatTimeout = 8 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        char cMakeMeasureSpec = (char) (9279 - View.MeasureSpec.makeMeasureSpec(i4, i4));
                        int modifierMetaStateMask = ((byte) KeyEvent.getModifierMetaStateMask()) + 1978;
                        byte b = (byte) i4;
                        String str$$e = $$e((byte) ($$d + 3), b, b);
                        Class[] clsArr = new Class[1];
                        clsArr[i4] = Integer.TYPE;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, cMakeMeasureSpec, modifierMetaStateMask, 1113883676, false, str$$e, clsArr);
                    }
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i7), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        byte b2 = (byte) 0;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (49362 - Gravity.getAbsoluteGravity(0, 0)), 684 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), -115095555, false, $$e((byte) ($$d + 5), b2, b2), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i7] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    Object[] objArr4 = {_creation, _creation};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame3 == null) {
                        byte b3 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - KeyEvent.keyCodeFromString(""), (char) (30068 - TextUtils.getTrimmedLength("")), Color.red(0) + 816, 1897803493, false, $$e((byte) ($$d + 2), b3, b3), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    i4 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            char[] cArr = new char[i];
            _creation.b = 0;
            while (_creation.b < i) {
                cArr[_creation.b] = (char) jArr[_creation.b];
                try {
                    Object[] objArr5 = {_creation, _creation};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame4 == null) {
                        byte b4 = (byte) 0;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 25, (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 30068), 816 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 1897803493, false, $$e((byte) ($$d + 2), b4, b4), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            String str = new String(cArr);
            int i8 = $10 + 115;
            $11 = i8 % 128;
            int i9 = i8 % 2;
            objArr[0] = str;
        }

        private static void b(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
            char[] cArr2 = validateRelationship;
            int i3 = 0;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i4 = 0;
                while (i4 < length) {
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i3] = Integer.valueOf(cArr2[i4]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i3;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 26, (char) (ViewConfiguration.getPressedStateDuration() >> 16), 1041 - (ViewConfiguration.getFadingEdgeLength() >> 16), -1719489573, false, $$e((byte) ($$d | 20), b, b), new Class[]{Integer.TYPE});
                        }
                        cArr3[i4] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i4++;
                        int i5 = $10 + 73;
                        $11 = i5 % 128;
                        int i6 = i5 % 2;
                        i3 = 0;
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
            try {
                Object[] objArr3 = {Integer.valueOf(warmup)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
                if (objAccessartificialFrame2 == null) {
                    int keyRepeatDelay = 15 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    char c = (char) (20489 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                    int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 2148;
                    byte b2 = (byte) ($$d & 5);
                    byte b3 = (byte) (b2 - 1);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, c, edgeSlop, 216472770, false, $$e(b2, b3, b3), new Class[]{Integer.TYPE});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                int i7 = 59174;
                float f = 0.0f;
                if (ICustomTabsServiceDefault) {
                    onmessagechannelready.c = bArr.length;
                    char[] cArr4 = new char[onmessagechannelready.c];
                    onmessagechannelready.a = 0;
                    while (onmessagechannelready.a < onmessagechannelready.c) {
                        int i8 = $11 + 11;
                        $10 = i8 % 128;
                        if (i8 % 2 != 0) {
                            cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) / onmessagechannelready.a] % i] >> iIntValue);
                            Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                            if (objAccessartificialFrame3 == null) {
                                byte b4 = (byte) 0;
                                byte b5 = b4;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(22 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (i7 - TextUtils.getTrimmedLength("")), 1943 - (ViewConfiguration.getEdgeSlop() >> 16), 481771537, false, $$e(b4, b5, b5), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        } else {
                            cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                            Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                            if (objAccessartificialFrame4 == null) {
                                byte b6 = (byte) 0;
                                byte b7 = b6;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(21 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (59174 - (ViewConfiguration.getTapTimeout() >> 16)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1943, 481771537, false, $$e(b6, b7, b7), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                        }
                        int i9 = $10 + 53;
                        $11 = i9 % 128;
                        if (i9 % 2 == 0) {
                            int i10 = 3 / 5;
                        }
                        i7 = 59174;
                    }
                    objArr[0] = new String(cArr4);
                    return;
                }
                if (requestPostMessageChannelWithExtras) {
                    onmessagechannelready.c = cArr.length;
                    char[] cArr5 = new char[onmessagechannelready.c];
                    onmessagechannelready.a = 0;
                    while (onmessagechannelready.a < onmessagechannelready.c) {
                        int i11 = $10 + 13;
                        $11 = i11 % 128;
                        if (i11 % 2 == 0) {
                            cArr5[onmessagechannelready.a] = (char) (cArr2[cArr[onmessagechannelready.c + onmessagechannelready.a] >>> i] - iIntValue);
                            Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                            if (objAccessartificialFrame5 == null) {
                                byte b8 = (byte) 0;
                                byte b9 = b8;
                                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(21 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) ((ViewConfiguration.getScrollFriction() > f ? 1 : (ViewConfiguration.getScrollFriction() == f ? 0 : -1)) + 59173), 1944 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 481771537, false, $$e(b8, b9, b9), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                        } else {
                            cArr5[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                            Object[] objArr7 = {onmessagechannelready, onmessagechannelready};
                            Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                            if (objAccessartificialFrame6 == null) {
                                byte b10 = (byte) 0;
                                byte b11 = b10;
                                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 21, (char) (TextUtils.indexOf("", "") + 59174), (-16775273) - Color.rgb(0, 0, 0), 481771537, false, $$e(b10, b11, b11), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame6).invoke(null, objArr7);
                        }
                        f = 0.0f;
                    }
                    objArr[0] = new String(cArr5);
                    return;
                }
                int i12 = 0;
                onmessagechannelready.c = iArr.length;
                char[] cArr6 = new char[onmessagechannelready.c];
                while (true) {
                    onmessagechannelready.a = i12;
                    if (onmessagechannelready.a >= onmessagechannelready.c) {
                        objArr[0] = new String(cArr6);
                        return;
                    } else {
                        cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                        i12 = onmessagechannelready.a + 1;
                    }
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }

        public ReactContextInitParams(JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
            this.mJsExecutorFactory = (JavaScriptExecutorFactory) Assertions.assertNotNull(javaScriptExecutorFactory);
            this.mJsBundleLoader = (JSBundleLoader) Assertions.assertNotNull(jSBundleLoader);
        }

        public JavaScriptExecutorFactory getJsExecutorFactory() {
            return this.mJsExecutorFactory;
        }

        public JSBundleLoader getJsBundleLoader() {
            return this.mJsBundleLoader;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v30, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r10v70, types: [java.nio.LongBuffer] */
        /* JADX WARN: Type inference failed for: r12v15, types: [java.nio.LongBuffer[]] */
        /* JADX WARN: Type inference failed for: r12v17, types: [java.lang.CharSequence] */
        /* JADX WARN: Type inference failed for: r12v192 */
        /* JADX WARN: Type inference failed for: r12v193, types: [java.lang.CharSequence, java.lang.String] */
        /* JADX WARN: Type inference failed for: r12v195 */
        /* JADX WARN: Type inference failed for: r12v196 */
        /* JADX WARN: Type inference failed for: r12v197 */
        /* JADX WARN: Type inference failed for: r12v198 */
        /* JADX WARN: Type inference failed for: r12v199 */
        /* JADX WARN: Type inference failed for: r12v200 */
        /* JADX WARN: Type inference failed for: r12v201 */
        /* JADX WARN: Type inference failed for: r12v202, types: [java.nio.LongBuffer[]] */
        /* JADX WARN: Type inference failed for: r12v30 */
        /* JADX WARN: Type inference failed for: r12v31 */
        /* JADX WARN: Type inference failed for: r12v49 */
        /* JADX WARN: Type inference failed for: r12v87 */
        /* JADX WARN: Type inference failed for: r12v88 */
        /* JADX WARN: Type inference failed for: r12v89, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r12v90 */
        /* JADX WARN: Type inference failed for: r12v92 */
        /* JADX WARN: Type inference failed for: r13v138, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r13v139 */
        /* JADX WARN: Type inference failed for: r13v140 */
        /* JADX WARN: Type inference failed for: r13v141 */
        /* JADX WARN: Type inference failed for: r13v142 */
        /* JADX WARN: Type inference failed for: r13v143 */
        /* JADX WARN: Type inference failed for: r13v170 */
        /* JADX WARN: Type inference failed for: r13v235 */
        /* JADX WARN: Type inference failed for: r13v236 */
        /* JADX WARN: Type inference failed for: r13v237 */
        /* JADX WARN: Type inference failed for: r13v238 */
        /* JADX WARN: Type inference failed for: r13v239 */
        /* JADX WARN: Type inference failed for: r1v300, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r1v304, types: [java.lang.Object, java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r21v10 */
        /* JADX WARN: Type inference failed for: r21v14 */
        /* JADX WARN: Type inference failed for: r21v9 */
        /* JADX WARN: Type inference failed for: r26v0 */
        /* JADX WARN: Type inference failed for: r26v1 */
        /* JADX WARN: Type inference failed for: r26v14 */
        /* JADX WARN: Type inference failed for: r26v17 */
        /* JADX WARN: Type inference failed for: r26v18 */
        /* JADX WARN: Type inference failed for: r26v19 */
        /* JADX WARN: Type inference failed for: r26v20 */
        /* JADX WARN: Type inference failed for: r26v21 */
        /* JADX WARN: Type inference failed for: r26v23 */
        /* JADX WARN: Type inference failed for: r26v25, types: [long] */
        /* JADX WARN: Type inference failed for: r26v31 */
        /* JADX WARN: Type inference failed for: r26v32 */
        /* JADX WARN: Type inference failed for: r26v33 */
        /* JADX WARN: Type inference failed for: r26v35, types: [char] */
        /* JADX WARN: Type inference failed for: r26v36 */
        /* JADX WARN: Type inference failed for: r26v37 */
        /* JADX WARN: Type inference failed for: r26v38 */
        /* JADX WARN: Type inference failed for: r26v39 */
        /* JADX WARN: Type inference failed for: r26v40 */
        /* JADX WARN: Type inference failed for: r26v41 */
        /* JADX WARN: Type inference failed for: r26v6 */
        /* JADX WARN: Type inference failed for: r26v7 */
        /* JADX WARN: Type inference failed for: r26v8 */
        /* JADX WARN: Type inference failed for: r27v0 */
        /* JADX WARN: Type inference failed for: r27v1 */
        /* JADX WARN: Type inference failed for: r27v12 */
        /* JADX WARN: Type inference failed for: r27v13 */
        /* JADX WARN: Type inference failed for: r27v14 */
        /* JADX WARN: Type inference failed for: r27v15 */
        /* JADX WARN: Type inference failed for: r27v18 */
        /* JADX WARN: Type inference failed for: r27v19 */
        /* JADX WARN: Type inference failed for: r27v2 */
        /* JADX WARN: Type inference failed for: r27v20 */
        /* JADX WARN: Type inference failed for: r27v21 */
        /* JADX WARN: Type inference failed for: r27v22 */
        /* JADX WARN: Type inference failed for: r27v24 */
        /* JADX WARN: Type inference failed for: r27v3 */
        /* JADX WARN: Type inference failed for: r27v44 */
        /* JADX WARN: Type inference failed for: r27v45 */
        /* JADX WARN: Type inference failed for: r27v51 */
        /* JADX WARN: Type inference failed for: r27v52 */
        /* JADX WARN: Type inference failed for: r27v56 */
        /* JADX WARN: Type inference failed for: r27v58 */
        /* JADX WARN: Type inference failed for: r27v59 */
        /* JADX WARN: Type inference failed for: r27v61, types: [int] */
        /* JADX WARN: Type inference failed for: r27v62 */
        /* JADX WARN: Type inference failed for: r27v63 */
        /* JADX WARN: Type inference failed for: r27v64 */
        /* JADX WARN: Type inference failed for: r27v65 */
        /* JADX WARN: Type inference failed for: r27v66 */
        /* JADX WARN: Type inference failed for: r27v67 */
        /* JADX WARN: Type inference failed for: r27v68 */
        /* JADX WARN: Type inference failed for: r27v69 */
        /* JADX WARN: Type inference failed for: r27v70 */
        /* JADX WARN: Type inference failed for: r27v71 */
        /* JADX WARN: Type inference failed for: r27v9 */
        /* JADX WARN: Type inference failed for: r28v1 */
        /* JADX WARN: Type inference failed for: r2v106, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v117 */
        /* JADX WARN: Type inference failed for: r2v121, types: [java.nio.LongBuffer[]] */
        /* JADX WARN: Type inference failed for: r2v122 */
        /* JADX WARN: Type inference failed for: r2v126 */
        /* JADX WARN: Type inference failed for: r2v129 */
        /* JADX WARN: Type inference failed for: r2v130 */
        /* JADX WARN: Type inference failed for: r2v155, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r2v179 */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v302, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r2v31, types: [int] */
        /* JADX WARN: Type inference failed for: r2v37 */
        /* JADX WARN: Type inference failed for: r2v38 */
        /* JADX WARN: Type inference failed for: r2v39 */
        /* JADX WARN: Type inference failed for: r2v40 */
        /* JADX WARN: Type inference failed for: r2v41, types: [int] */
        /* JADX WARN: Type inference failed for: r2v47 */
        /* JADX WARN: Type inference failed for: r2v493 */
        /* JADX WARN: Type inference failed for: r2v494 */
        /* JADX WARN: Type inference failed for: r2v495 */
        /* JADX WARN: Type inference failed for: r2v496 */
        /* JADX WARN: Type inference failed for: r2v497 */
        /* JADX WARN: Type inference failed for: r2v75 */
        /* JADX WARN: Type inference failed for: r30v0 */
        /* JADX WARN: Type inference failed for: r30v1 */
        /* JADX WARN: Type inference failed for: r30v146 */
        /* JADX WARN: Type inference failed for: r30v147 */
        /* JADX WARN: Type inference failed for: r30v148 */
        /* JADX WARN: Type inference failed for: r30v149 */
        /* JADX WARN: Type inference failed for: r30v18 */
        /* JADX WARN: Type inference failed for: r30v19 */
        /* JADX WARN: Type inference failed for: r30v20 */
        /* JADX WARN: Type inference failed for: r30v21 */
        /* JADX WARN: Type inference failed for: r30v22 */
        /* JADX WARN: Type inference failed for: r30v23 */
        /* JADX WARN: Type inference failed for: r30v24 */
        /* JADX WARN: Type inference failed for: r30v25 */
        /* JADX WARN: Type inference failed for: r4v248 */
        /* JADX WARN: Type inference failed for: r4v249 */
        /* JADX WARN: Type inference failed for: r4v256 */
        /* JADX WARN: Type inference failed for: r4v257 */
        /* JADX WARN: Type inference failed for: r4v278 */
        /* JADX WARN: Type inference failed for: r4v496 */
        /* JADX WARN: Type inference failed for: r4v497 */
        /* JADX WARN: Type inference failed for: r5v84, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v125, types: [java.lang.Object, java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r6v178 */
        /* JADX WARN: Type inference failed for: r6v179, types: [java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v485 */
        /* JADX WARN: Type inference failed for: r6v78 */
        /* JADX WARN: Type inference failed for: r7v128 */
        /* JADX WARN: Type inference failed for: r7v131 */
        /* JADX WARN: Type inference failed for: r7v150, types: [java.lang.Object, java.nio.LongBuffer] */
        /* JADX WARN: Type inference failed for: r7v248, types: [java.lang.Object, java.nio.LongBuffer] */
        /* JADX WARN: Type inference failed for: r7v250, types: [java.lang.Object, java.nio.LongBuffer] */
        /* JADX WARN: Type inference failed for: r7v270 */
        /* JADX WARN: Type inference failed for: r7v271 */
        /* JADX WARN: Type inference failed for: r7v272, types: [java.security.KeyStore] */
        /* JADX WARN: Type inference failed for: r7v276, types: [java.security.KeyStore] */
        /* JADX WARN: Type inference failed for: r7v280, types: [java.lang.Class] */
        /* JADX WARN: Type inference failed for: r7v281 */
        /* JADX WARN: Type inference failed for: r7v312 */
        /* JADX WARN: Type inference failed for: r7v313 */
        /* JADX WARN: Type inference failed for: r7v314 */
        /* JADX WARN: Type inference failed for: r7v315 */
        /* JADX WARN: Type inference failed for: r7v374, types: [java.lang.Object, java.security.KeyStore] */
        /* JADX WARN: Type inference failed for: r7v624 */
        /* JADX WARN: Type inference failed for: r7v625 */
        /* JADX WARN: Type inference failed for: r7v626 */
        /* JADX WARN: Type inference failed for: r8v151 */
        /* JADX WARN: Type inference failed for: r8v152, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v157 */
        /* JADX WARN: Type inference failed for: r8v158, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v184, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v254, types: [java.lang.Object, java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r8v604 */
        /* JADX WARN: Type inference failed for: r8v92, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r9v157, types: [java.lang.Object, java.nio.LongBuffer] */
        /* JADX WARN: Type inference failed for: r9v165 */
        /* JADX WARN: Type inference failed for: r9v166, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v167 */
        /* JADX WARN: Type inference failed for: r9v168, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v389 */
        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] accessartificialFrame(android.content.Context r39, java.lang.String[] r40, int r41, int r42, int r43) {
            /*
                Method dump skipped, instruction units count: 14504
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactInstanceManager.ReactContextInitParams.accessartificialFrame(android.content.Context, java.lang.String[], int, int, int):java.lang.Object[]");
        }
    }

    public static ReactInstanceManagerBuilder builder() {
        return new ReactInstanceManagerBuilder();
    }

    ReactInstanceManager(Context context, @Nullable Activity activity, @Nullable DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler, JavaScriptExecutorFactory javaScriptExecutorFactory, @Nullable JSBundleLoader jSBundleLoader, @Nullable String str, List<ReactPackage> list, boolean z, DevSupportManagerFactory devSupportManagerFactory, boolean z2, boolean z3, @Nullable NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener, LifecycleState lifecycleState, JSExceptionHandler jSExceptionHandler, @Nullable RedBoxHandler redBoxHandler, boolean z4, @Nullable DevBundleDownloadListener devBundleDownloadListener, int i, int i2, @Nullable UIManagerProvider uIManagerProvider, @Nullable Map<String, RequestHandler> map, @Nullable ReactPackageTurboModuleManagerDelegate.Builder builder, @Nullable SurfaceDelegateFactory surfaceDelegateFactory, @Nullable DevLoadingViewManager devLoadingViewManager, @Nullable ChoreographerProvider choreographerProvider, @Nullable PausedInDebuggerOverlayManager pausedInDebuggerOverlayManager) {
        FLog.d(TAG, "ReactInstanceManager.ctor()");
        initializeSoLoaderIfNecessary(context);
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(context);
        this.mApplicationContext = context;
        this.mCurrentActivity = activity;
        this.mDefaultBackButtonImpl = defaultHardwareBackBtnHandler;
        this.mJavaScriptExecutorFactory = javaScriptExecutorFactory;
        this.mBundleLoader = jSBundleLoader;
        this.mJSMainModulePath = str;
        ArrayList arrayList = new ArrayList();
        this.mPackages = arrayList;
        this.mUseDeveloperSupport = z;
        this.mRequireActivity = z2;
        this.mKeepActivity = z3;
        Systrace.beginSection(0L, "ReactInstanceManager.initDevSupportManager");
        DevSupportManager devSupportManagerCreate = devSupportManagerFactory.create(context, createDevHelperInterface(), str, z, redBoxHandler, devBundleDownloadListener, i, map, surfaceDelegateFactory, devLoadingViewManager, pausedInDebuggerOverlayManager);
        this.mDevSupportManager = devSupportManagerCreate;
        Systrace.endSection(0L);
        this.mBridgeIdleDebugListener = notThreadSafeBridgeIdleDebugListener;
        this.mLifecycleState = lifecycleState;
        this.mMemoryPressureRouter = new MemoryPressureRouter(context);
        this.mJSExceptionHandler = jSExceptionHandler;
        this.mTMMDelegateBuilder = builder;
        synchronized (arrayList) {
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: Use Split Packages");
            arrayList.add(new CoreModulesPackage(this, new DefaultHardwareBackBtnHandler() { // from class: com.facebook.react.ReactInstanceManager.1
                @Override // com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
                public void invokeDefaultOnBackPressed() {
                    ReactInstanceManager.this.invokeDefaultOnBackPressed();
                }
            }, z4, i2));
            if (z) {
                arrayList.add(new DebugCorePackage());
            }
            arrayList.addAll(list);
        }
        this.mUIManagerProvider = uIManagerProvider;
        ReactChoreographer.initialize(choreographerProvider != null ? choreographerProvider : AndroidChoreographerProvider.getInstance());
        if (z) {
            devSupportManagerCreate.startInspector();
        }
        registerCxxErrorHandlerFunc();
    }

    private ReactInstanceDevHelper createDevHelperInterface() {
        return new ReactInstanceDevHelper() { // from class: com.facebook.react.ReactInstanceManager.2
            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public ReactContext getCurrentReactContext() {
                return null;
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public TaskInterface<Boolean> loadBundle(JSBundleLoader jSBundleLoader) {
                return null;
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public void reload(String str) {
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public void onReloadWithJSDebugger(JavaJSExecutor.Factory factory) {
                ReactInstanceManager.this.onReloadWithJSDebugger(factory);
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public void onJSBundleLoadedFromServer() {
                ReactInstanceManager.this.onJSBundleLoadedFromServer();
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public void toggleElementInspector() {
                ReactInstanceManager.this.toggleElementInspector();
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public Activity getCurrentActivity() {
                return ReactInstanceManager.this.mCurrentActivity;
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
                return ReactInstanceManager.this.getJSExecutorFactory();
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public View createRootView(String str) {
                Activity currentActivity = getCurrentActivity();
                if (currentActivity == null) {
                    return null;
                }
                ReactRootView reactRootView = new ReactRootView(currentActivity);
                reactRootView.setIsFabric(ReactNativeFeatureFlags.enableFabricRenderer());
                reactRootView.startReactApplication(ReactInstanceManager.this, str, new Bundle());
                return reactRootView;
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public void destroyRootView(View view) {
                if (view instanceof ReactRootView) {
                    ((ReactRootView) view).unmountReactApplication();
                }
            }
        };
    }

    public void setUseFallbackBundle(boolean z) {
        synchronized (this) {
            this.mUseFallbackBundle = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JavaScriptExecutorFactory getJSExecutorFactory() {
        return this.mJavaScriptExecutorFactory;
    }

    public DevSupportManager getDevSupportManager() {
        return this.mDevSupportManager;
    }

    public MemoryPressureRouter getMemoryPressureRouter() {
        return this.mMemoryPressureRouter;
    }

    public List<ReactPackage> getPackages() {
        return new ArrayList(this.mPackages);
    }

    public void handleCxxError(Exception exc) {
        this.mDevSupportManager.handleException(exc);
    }

    private void registerCxxErrorHandlerFunc() {
        Method method;
        try {
            method = ReactInstanceManager.class.getMethod("handleCxxError", Exception.class);
        } catch (NoSuchMethodException e) {
            FLog.e("ReactInstanceHolder", "Failed to set cxx error handler function", e);
            method = null;
        }
        ReactCxxErrorHandler.setHandleErrorFunc(this, method);
    }

    private void unregisterCxxErrorHandlerFunc() {
        ReactCxxErrorHandler.setHandleErrorFunc(null, null);
    }

    static void initializeSoLoaderIfNecessary(Context context) {
        SoLoader.init(context, false);
    }

    public void createReactContextInBackground() {
        FLog.d(TAG, "ReactInstanceManager.createReactContextInBackground()");
        UiThreadUtil.assertOnUiThread();
        if (this.mHasStartedCreatingInitialContext) {
            return;
        }
        this.mHasStartedCreatingInitialContext = true;
        recreateReactContextInBackgroundInner();
    }

    public void recreateReactContextInBackground() {
        Assertions.assertCondition(this.mHasStartedCreatingInitialContext, "recreateReactContextInBackground should only be called after the initial createReactContextInBackground call.");
        recreateReactContextInBackgroundInner();
    }

    private void recreateReactContextInBackgroundInner() {
        FLog.d(TAG, "ReactInstanceManager.recreateReactContextInBackgroundInner()");
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: recreateReactContextInBackground");
        UiThreadUtil.assertOnUiThread();
        if (this.mUseDeveloperSupport && this.mJSMainModulePath != null) {
            DeveloperSettings devSettings = this.mDevSupportManager.getDevSettings();
            if (!Systrace.isTracing(0L)) {
                if (this.mBundleLoader == null) {
                    this.mDevSupportManager.handleReloadJS();
                    return;
                } else {
                    this.mDevSupportManager.isPackagerRunning(new AnonymousClass3(devSettings));
                    return;
                }
            }
        }
        recreateReactContextInBackgroundFromBundleLoader();
    }

    /* JADX INFO: renamed from: com.facebook.react.ReactInstanceManager$3, reason: invalid class name */
    class AnonymousClass3 implements PackagerStatusCallback {
        final /* synthetic */ DeveloperSettings val$devSettings;

        AnonymousClass3(DeveloperSettings developerSettings) {
            this.val$devSettings = developerSettings;
        }

        @Override // com.facebook.react.devsupport.interfaces.PackagerStatusCallback
        public void onPackagerStatusFetched(final boolean z) {
            final DeveloperSettings developerSettings = this.val$devSettings;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.ReactInstanceManager$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPackagerStatusFetched$0(z, developerSettings);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPackagerStatusFetched$0(boolean z, DeveloperSettings developerSettings) {
            if (ReactInstanceManager.this.mInstanceManagerInvalidated) {
                return;
            }
            if (z) {
                ReactInstanceManager.this.mDevSupportManager.handleReloadJS();
                return;
            }
            if (ReactInstanceManager.this.mDevSupportManager.hasUpToDateJSBundleInCache() && !developerSettings.isRemoteJSDebugEnabled() && !ReactInstanceManager.this.mUseFallbackBundle) {
                ReactInstanceManager.this.onJSBundleLoadedFromServer();
            } else {
                developerSettings.setRemoteJSDebugEnabled(false);
                ReactInstanceManager.this.recreateReactContextInBackgroundFromBundleLoader();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recreateReactContextInBackgroundFromBundleLoader() {
        FLog.d(TAG, "ReactInstanceManager.recreateReactContextInBackgroundFromBundleLoader()");
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from BundleLoader");
        recreateReactContextInBackground(this.mJavaScriptExecutorFactory, this.mBundleLoader);
    }

    public boolean hasStartedCreatingInitialContext() {
        return this.mHasStartedCreatingInitialContext;
    }

    public void onBackPressed() {
        UiThreadUtil.assertOnUiThread();
        ReactContext reactContext = this.mCurrentReactContext;
        if (reactContext == null) {
            FLog.w(TAG, "Instance detached from instance manager");
            invokeDefaultOnBackPressed();
        } else {
            DeviceEventManagerModule deviceEventManagerModule = (DeviceEventManagerModule) reactContext.getNativeModule(DeviceEventManagerModule.class);
            if (deviceEventManagerModule != null) {
                deviceEventManagerModule.emitHardwareBackPressed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeDefaultOnBackPressed() {
        UiThreadUtil.assertOnUiThread();
        DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler = this.mDefaultBackButtonImpl;
        if (defaultHardwareBackBtnHandler != null) {
            defaultHardwareBackBtnHandler.invokeDefaultOnBackPressed();
        }
    }

    public void onNewIntent(Intent intent) {
        DeviceEventManagerModule deviceEventManagerModule;
        UiThreadUtil.assertOnUiThread();
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext == null) {
            FLog.w(TAG, "Instance detached from instance manager");
            return;
        }
        String action = intent.getAction();
        Uri data = intent.getData();
        if (data != null && (("android.intent.action.VIEW".equals(action) || "android.nfc.action.NDEF_DISCOVERED".equals(action)) && (deviceEventManagerModule = (DeviceEventManagerModule) currentReactContext.getNativeModule(DeviceEventManagerModule.class)) != null)) {
            deviceEventManagerModule.emitNewIntentReceived(data);
        }
        currentReactContext.onNewIntent(this.mCurrentActivity, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleElementInspector() {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null && currentReactContext.hasActiveReactInstance()) {
            currentReactContext.emitDeviceEvent("toggleElementInspector");
        } else {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot toggleElementInspector, CatalystInstance not available"));
        }
    }

    @Deprecated
    public void onHostPause() {
        UiThreadUtil.assertOnUiThread();
        this.mDefaultBackButtonImpl = null;
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.setDevSupportEnabled(false);
        }
        moveToBeforeResumeLifecycleState();
    }

    public void onUserLeaveHint(@Nullable Activity activity) {
        Activity activity2 = this.mCurrentActivity;
        if (activity2 == null || activity != activity2) {
            return;
        }
        UiThreadUtil.assertOnUiThread();
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            currentReactContext.onUserLeaveHint(activity);
        }
    }

    public void onHostPause(@Nullable Activity activity) {
        if (this.mRequireActivity) {
            if (this.mCurrentActivity == null) {
                FLog.e(TAG, "ReactInstanceManager.onHostPause called with null activity, expected:" + this.mCurrentActivity.getClass().getSimpleName());
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                int length = stackTrace.length;
                for (int i = 0; i < length; i++) {
                    FLog.e(TAG, stackTrace[i].toString());
                }
            }
            Assertions.assertCondition(this.mCurrentActivity != null);
        }
        Activity activity2 = this.mCurrentActivity;
        if (activity2 != null) {
            Assertions.assertCondition(activity == activity2, "Pausing an activity that is not the current activity, this is incorrect! Current activity: " + this.mCurrentActivity.getClass().getSimpleName() + " Paused activity: " + activity.getClass().getSimpleName());
        }
        onHostPause();
    }

    public void onHostResume(@Nullable Activity activity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        UiThreadUtil.assertOnUiThread();
        this.mDefaultBackButtonImpl = defaultHardwareBackBtnHandler;
        onHostResume(activity);
    }

    public void onHostResume(@Nullable Activity activity) {
        UiThreadUtil.assertOnUiThread();
        this.mCurrentActivity = activity;
        if (this.mUseDeveloperSupport) {
            if (activity != null) {
                final View decorView = activity.getWindow().getDecorView();
                if (!ViewCompat.isAttachedToWindow(decorView)) {
                    decorView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.facebook.react.ReactInstanceManager.4
                        @Override // android.view.View.OnAttachStateChangeListener
                        public void onViewDetachedFromWindow(View view) {
                        }

                        @Override // android.view.View.OnAttachStateChangeListener
                        public void onViewAttachedToWindow(View view) {
                            decorView.removeOnAttachStateChangeListener(this);
                            ReactInstanceManager.this.mDevSupportManager.setDevSupportEnabled(true);
                        }
                    });
                } else {
                    this.mDevSupportManager.setDevSupportEnabled(true);
                }
            } else if (!this.mRequireActivity) {
                this.mDevSupportManager.setDevSupportEnabled(true);
            }
        }
        moveToResumedLifecycleState(false);
    }

    @Deprecated
    public void onHostDestroy() {
        UiThreadUtil.assertOnUiThread();
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.setDevSupportEnabled(false);
        }
        moveToBeforeCreateLifecycleState();
        if (this.mKeepActivity) {
            return;
        }
        this.mCurrentActivity = null;
    }

    public void onHostDestroy(@Nullable Activity activity) {
        if (activity == this.mCurrentActivity) {
            onHostDestroy();
        }
    }

    private void logOnDestroy() {
        FLog.d(TAG, "ReactInstanceManager.destroy called", (Throwable) new RuntimeException("ReactInstanceManager.destroy called"));
    }

    public void destroy() {
        ReactInstanceManagerInspectorTarget reactInstanceManagerInspectorTarget;
        UiThreadUtil.assertOnUiThread();
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: Destroy");
        logOnDestroy();
        if (this.mHasStartedDestroying.booleanValue()) {
            FLog.e(ReactConstants.TAG, "ReactInstanceManager.destroy called: bail out, already destroying");
            return;
        }
        this.mHasStartedDestroying = Boolean.TRUE;
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.setDevSupportEnabled(false);
            this.mDevSupportManager.stopInspector();
        }
        moveToBeforeCreateLifecycleState();
        this.mMemoryPressureRouter.destroy(this.mApplicationContext);
        unregisterCxxErrorHandlerFunc();
        this.mCreateReactContextThread = null;
        synchronized (this.mAttachedReactRoots) {
            synchronized (this.mReactContextLock) {
                if (this.mCurrentReactContext != null) {
                    for (ReactRoot reactRoot : this.mAttachedReactRoots) {
                        if (reactRoot.getUIManagerType() == 2) {
                            detachRootViewFromInstance(reactRoot, this.mCurrentReactContext);
                        }
                    }
                    this.mCurrentReactContext.destroy();
                    this.mCurrentReactContext = null;
                }
            }
        }
        if (this.mInstanceManagerInvalidated && (reactInstanceManagerInspectorTarget = this.mInspectorTarget) != null) {
            reactInstanceManagerInspectorTarget.close();
            this.mInspectorTarget = null;
        }
        this.mHasStartedCreatingInitialContext = false;
        if (!this.mKeepActivity) {
            this.mCurrentActivity = null;
        }
        ResourceDrawableIdHelper.getInstance().clear();
        this.mHasStartedDestroying = Boolean.FALSE;
        synchronized (this.mHasStartedDestroying) {
            this.mHasStartedDestroying.notifyAll();
        }
        synchronized (this.mPackages) {
            this.mViewManagerNames = null;
        }
        FLog.d(ReactConstants.TAG, "ReactInstanceManager has been destroyed");
    }

    private void moveToResumedLifecycleState(boolean z) {
        synchronized (this) {
            ReactContext currentReactContext = getCurrentReactContext();
            if (currentReactContext != null && (z || this.mLifecycleState == LifecycleState.BEFORE_RESUME || this.mLifecycleState == LifecycleState.BEFORE_CREATE)) {
                currentReactContext.onHostResume(this.mCurrentActivity);
            }
            this.mLifecycleState = LifecycleState.RESUMED;
        }
    }

    private void moveToBeforeResumeLifecycleState() {
        synchronized (this) {
            ReactContext currentReactContext = getCurrentReactContext();
            if (currentReactContext != null) {
                if (this.mLifecycleState == LifecycleState.BEFORE_CREATE) {
                    currentReactContext.onHostResume(this.mCurrentActivity);
                    currentReactContext.onHostPause();
                } else if (this.mLifecycleState == LifecycleState.RESUMED) {
                    currentReactContext.onHostPause();
                }
            }
            this.mLifecycleState = LifecycleState.BEFORE_RESUME;
        }
    }

    private void moveToBeforeCreateLifecycleState() {
        synchronized (this) {
            ReactContext currentReactContext = getCurrentReactContext();
            if (currentReactContext != null) {
                if (this.mLifecycleState == LifecycleState.RESUMED) {
                    currentReactContext.onHostPause();
                    this.mLifecycleState = LifecycleState.BEFORE_RESUME;
                }
                if (this.mLifecycleState == LifecycleState.BEFORE_RESUME) {
                    currentReactContext.onHostDestroy(this.mKeepActivity);
                }
            }
            this.mLifecycleState = LifecycleState.BEFORE_CREATE;
        }
    }

    private void moveReactContextToCurrentLifecycleState() {
        synchronized (this) {
            if (this.mLifecycleState == LifecycleState.RESUMED) {
                moveToResumedLifecycleState(true);
            }
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, @Nullable Intent intent) {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            currentReactContext.onActivityResult(activity, i, i2, intent);
        }
    }

    public void onWindowFocusChange(boolean z) {
        UiThreadUtil.assertOnUiThread();
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            currentReactContext.onWindowFocusChange(z);
        }
    }

    public void onConfigurationChanged(Context context, @Nullable Configuration configuration) {
        AppearanceModule appearanceModule;
        UiThreadUtil.assertOnUiThread();
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext == null || (appearanceModule = (AppearanceModule) currentReactContext.getNativeModule(AppearanceModule.class)) == null) {
            return;
        }
        appearanceModule.onConfigurationChanged(context);
    }

    public void showDevOptionsDialog() {
        UiThreadUtil.assertOnUiThread();
        this.mDevSupportManager.showDevOptionsDialog();
    }

    private void clearReactRoot(ReactRoot reactRoot) {
        UiThreadUtil.assertOnUiThread();
        reactRoot.getState().compareAndSet(1, 0);
        ViewGroup rootViewGroup = reactRoot.getRootViewGroup();
        rootViewGroup.removeAllViews();
        rootViewGroup.setId(-1);
    }

    @Deprecated
    public void attachRootView(ReactRoot reactRoot) {
        UiThreadUtil.assertOnUiThread();
        synchronized (this.mAttachedReactRoots) {
            if (this.mAttachedReactRoots.add(reactRoot)) {
                clearReactRoot(reactRoot);
            } else {
                FLog.e(ReactConstants.TAG, "ReactRoot was attached multiple times");
            }
            ReactContext currentReactContext = getCurrentReactContext();
            if (this.mCreateReactContextThread == null && currentReactContext != null) {
                attachRootViewToInstance(reactRoot);
            }
        }
    }

    @Deprecated
    public void detachRootView(ReactRoot reactRoot) {
        ReactContext reactContext;
        UiThreadUtil.assertOnUiThread();
        if (this.mAttachedReactRoots.remove(reactRoot) && (reactContext = this.mCurrentReactContext) != null && reactContext.hasActiveReactInstance()) {
            detachRootViewFromInstance(reactRoot, reactContext);
        }
    }

    public List<ViewManager> getOrCreateViewManagers(ReactApplicationContext reactApplicationContext) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_START);
        Systrace.beginSection(0L, "createAllViewManagers");
        try {
            if (this.mViewManagers == null) {
                synchronized (this.mPackages) {
                    if (this.mViewManagers == null) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<ReactPackage> it2 = this.mPackages.iterator();
                        while (it2.hasNext()) {
                            arrayList.addAll(it2.next().createViewManagers(reactApplicationContext));
                        }
                        this.mViewManagers = arrayList;
                        Systrace.endSection(0L);
                        ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
                        return arrayList;
                    }
                }
            }
            List<ViewManager> list = this.mViewManagers;
            Systrace.endSection(0L);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
            return list;
        } catch (Throwable th) {
            Systrace.endSection(0L);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
            throw th;
        }
    }

    public ViewManager createViewManager(String str) {
        ViewManager viewManagerCreateViewManager;
        synchronized (this.mReactContextLock) {
            ReactApplicationContext reactApplicationContext = (ReactApplicationContext) getCurrentReactContext();
            if (reactApplicationContext != null && reactApplicationContext.hasActiveReactInstance()) {
                synchronized (this.mPackages) {
                    for (ReactPackage reactPackage : this.mPackages) {
                        if ((reactPackage instanceof ViewManagerOnDemandReactPackage) && (viewManagerCreateViewManager = ((ViewManagerOnDemandReactPackage) reactPackage).createViewManager(reactApplicationContext, str)) != null) {
                            return viewManagerCreateViewManager;
                        }
                    }
                    return null;
                }
            }
            return null;
        }
    }

    public Collection<String> getViewManagerNames() {
        Collection<String> collection;
        Systrace.beginSection(0L, "ReactInstanceManager.getViewManagerNames");
        try {
            Collection<String> collection2 = this.mViewManagerNames;
            if (collection2 != null) {
                Systrace.endSection(0L);
                return collection2;
            }
            synchronized (this.mReactContextLock) {
                ReactApplicationContext reactApplicationContext = (ReactApplicationContext) getCurrentReactContext();
                if (reactApplicationContext != null && reactApplicationContext.hasActiveReactInstance()) {
                    synchronized (this.mPackages) {
                        if (this.mViewManagerNames == null) {
                            HashSet hashSet = new HashSet();
                            for (ReactPackage reactPackage : this.mPackages) {
                                SystraceMessage.beginSection(0L, "ReactInstanceManager.getViewManagerName").arg("Package", reactPackage.getClass().getSimpleName()).flush();
                                if (reactPackage instanceof ViewManagerOnDemandReactPackage) {
                                    Collection<String> viewManagerNames = ((ViewManagerOnDemandReactPackage) reactPackage).getViewManagerNames(reactApplicationContext);
                                    if (viewManagerNames != null) {
                                        hashSet.addAll(viewManagerNames);
                                    }
                                } else {
                                    FLog.w(ReactConstants.TAG, "Package %s is not a ViewManagerOnDemandReactPackage, view managers will not be loaded", reactPackage.getClass().getSimpleName());
                                }
                                Systrace.endSection(0L);
                            }
                            this.mViewManagerNames = hashSet;
                        }
                        collection = this.mViewManagerNames;
                    }
                    Systrace.endSection(0L);
                    return collection;
                }
                FLog.w(ReactConstants.TAG, "Calling getViewManagerNames without active context");
                List listEmptyList = Collections.emptyList();
                Systrace.endSection(0L);
                return listEmptyList;
            }
        } catch (Throwable th) {
            Systrace.endSection(0L);
            throw th;
        }
    }

    public void addReactInstanceEventListener(com.facebook.react.ReactInstanceEventListener reactInstanceEventListener) {
        this.mReactInstanceEventListeners.add(reactInstanceEventListener);
    }

    public void removeReactInstanceEventListener(com.facebook.react.ReactInstanceEventListener reactInstanceEventListener) {
        this.mReactInstanceEventListeners.remove(reactInstanceEventListener);
    }

    @VisibleForTesting
    public ReactContext getCurrentReactContext() {
        ReactContext reactContext;
        synchronized (this.mReactContextLock) {
            reactContext = this.mCurrentReactContext;
        }
        return reactContext;
    }

    public LifecycleState getLifecycleState() {
        return this.mLifecycleState;
    }

    public String getJsExecutorName() {
        return this.mJavaScriptExecutorFactory.toString();
    }

    public void invalidate() {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.invalidate()");
        this.mInstanceManagerInvalidated = true;
        destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReloadWithJSDebugger(JavaJSExecutor.Factory factory) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.onReloadWithJSDebugger()");
        recreateReactContextInBackground(new ProxyJavaScriptExecutor.Factory(factory), JSBundleLoader.createRemoteDebuggerBundleLoader(this.mDevSupportManager.getJSBundleURLForRemoteDebugging(), this.mDevSupportManager.getSourceUrl()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onJSBundleLoadedFromServer() {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.onJSBundleLoadedFromServer()");
        recreateReactContextInBackground(this.mJavaScriptExecutorFactory, JSBundleLoader.createCachedBundleFromNetworkLoader(this.mDevSupportManager.getSourceUrl(), this.mDevSupportManager.getDownloadedJSBundleFile()));
    }

    private void recreateReactContextInBackground(JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.recreateReactContextInBackground()");
        UiThreadUtil.assertOnUiThread();
        ReactContextInitParams reactContextInitParams = new ReactContextInitParams(javaScriptExecutorFactory, jSBundleLoader);
        if (this.mCreateReactContextThread == null) {
            runCreateReactContextOnNewThread(reactContextInitParams);
        } else {
            this.mPendingReactContextInitParams = reactContextInitParams;
        }
    }

    private void runCreateReactContextOnNewThread(final ReactContextInitParams reactContextInitParams) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.runCreateReactContextOnNewThread()");
        UiThreadUtil.assertOnUiThread();
        Assertions.assertCondition(!this.mInstanceManagerInvalidated, "Cannot create a new React context on an invalidated ReactInstanceManager");
        ReactMarker.logMarker(ReactMarkerConstants.REACT_BRIDGE_LOADING_START);
        synchronized (this.mAttachedReactRoots) {
            synchronized (this.mReactContextLock) {
                if (this.mCurrentReactContext != null) {
                    tearDownReactContext(this.mCurrentReactContext);
                    this.mCurrentReactContext = null;
                }
            }
        }
        this.mCreateReactContextThread = new Thread(null, new Runnable() { // from class: com.facebook.react.ReactInstanceManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runCreateReactContextOnNewThread$2(reactContextInitParams);
            }
        }, "create_react_context");
        ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_START);
        this.mCreateReactContextThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runCreateReactContextOnNewThread$2(ReactContextInitParams reactContextInitParams) {
        ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_END);
        synchronized (this.mHasStartedDestroying) {
            while (this.mHasStartedDestroying.booleanValue()) {
                try {
                    this.mHasStartedDestroying.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
        this.mHasStartedCreatingInitialContext = true;
        try {
            Process.setThreadPriority(-4);
            ReactMarker.logMarker(ReactMarkerConstants.VM_INIT);
            final ReactApplicationContext reactApplicationContextCreateReactContext = createReactContext(reactContextInitParams.getJsExecutorFactory().create(), reactContextInitParams.getJsBundleLoader());
            try {
                this.mCreateReactContextThread = null;
                ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_START);
                Runnable runnable = new Runnable() { // from class: com.facebook.react.ReactInstanceManager$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$runCreateReactContextOnNewThread$0();
                    }
                };
                reactApplicationContextCreateReactContext.runOnNativeModulesQueueThread(new Runnable() { // from class: com.facebook.react.ReactInstanceManager$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$runCreateReactContextOnNewThread$1(reactApplicationContextCreateReactContext);
                    }
                });
                UiThreadUtil.runOnUiThread(runnable);
            } catch (Exception e) {
                this.mDevSupportManager.handleException(e);
            }
        } catch (Exception e2) {
            this.mHasStartedCreatingInitialContext = false;
            this.mCreateReactContextThread = null;
            this.mDevSupportManager.handleException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runCreateReactContextOnNewThread$0() {
        ReactContextInitParams reactContextInitParams = this.mPendingReactContextInitParams;
        if (reactContextInitParams != null) {
            runCreateReactContextOnNewThread(reactContextInitParams);
            this.mPendingReactContextInitParams = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runCreateReactContextOnNewThread$1(ReactApplicationContext reactApplicationContext) {
        try {
            setupReactContext(reactApplicationContext);
        } catch (Exception e) {
            this.mDevSupportManager.handleException(e);
        }
    }

    private void setupReactContext(final ReactApplicationContext reactApplicationContext) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.setupReactContext()");
        ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_END);
        ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_START);
        Systrace.beginSection(0L, "setupReactContext");
        synchronized (this.mAttachedReactRoots) {
            synchronized (this.mReactContextLock) {
                this.mCurrentReactContext = (ReactContext) Assertions.assertNotNull(reactApplicationContext);
            }
            CatalystInstance catalystInstance = (CatalystInstance) Assertions.assertNotNull(reactApplicationContext.getCatalystInstance());
            catalystInstance.initialize();
            this.mDevSupportManager.onNewReactContextCreated(reactApplicationContext);
            this.mMemoryPressureRouter.addMemoryPressureListener(catalystInstance);
            ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_START);
            Iterator<ReactRoot> it2 = this.mAttachedReactRoots.iterator();
            while (it2.hasNext()) {
                attachRootViewToInstance(it2.next());
            }
            ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_END);
        }
        final com.facebook.react.ReactInstanceEventListener[] reactInstanceEventListenerArr = (com.facebook.react.ReactInstanceEventListener[]) this.mReactInstanceEventListeners.toArray(new com.facebook.react.ReactInstanceEventListener[this.mReactInstanceEventListeners.size()]);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.ReactInstanceManager$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setupReactContext$3(reactInstanceEventListenerArr, reactApplicationContext);
            }
        });
        reactApplicationContext.runOnJSQueueThread(new Runnable() { // from class: com.facebook.react.ReactInstanceManager$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                ReactInstanceManager.lambda$setupReactContext$4();
            }
        });
        reactApplicationContext.runOnNativeModulesQueueThread(new Runnable() { // from class: com.facebook.react.ReactInstanceManager$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                Process.setThreadPriority(0);
            }
        });
        Systrace.endSection(0L);
        ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_END);
        ReactMarker.logMarker(ReactMarkerConstants.REACT_BRIDGE_LOADING_END);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupReactContext$3(com.facebook.react.ReactInstanceEventListener[] reactInstanceEventListenerArr, ReactApplicationContext reactApplicationContext) {
        moveReactContextToCurrentLifecycleState();
        for (com.facebook.react.ReactInstanceEventListener reactInstanceEventListener : reactInstanceEventListenerArr) {
            if (reactInstanceEventListener != null) {
                reactInstanceEventListener.onReactContextInitialized(reactApplicationContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setupReactContext$4() {
        Process.setThreadPriority(0);
        ReactMarker.logMarker(ReactMarkerConstants.CHANGE_THREAD_PRIORITY, "js_default");
    }

    private void attachRootViewToInstance(final ReactRoot reactRoot) {
        WritableMap writableMapFromBundle;
        final int iAddRootView;
        WritableMap writableMapFromBundle2;
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.attachRootViewToInstance()");
        if (reactRoot.getState().compareAndSet(0, 1)) {
            Systrace.beginSection(0L, "attachRootViewToInstance");
            UIManager uIManager = UIManagerHelper.getUIManager(this.mCurrentReactContext, reactRoot.getUIManagerType());
            if (uIManager == null) {
                throw new IllegalStateException("Unable to attach a rootView to ReactInstance when UIManager is not properly initialized.");
            }
            Bundle appProperties = reactRoot.getAppProperties();
            if (reactRoot.getUIManagerType() == 2) {
                ViewGroup rootViewGroup = reactRoot.getRootViewGroup();
                String jSModuleName = reactRoot.getJSModuleName();
                if (appProperties == null) {
                    writableMapFromBundle2 = new WritableNativeMap();
                } else {
                    writableMapFromBundle2 = Arguments.fromBundle(appProperties);
                }
                iAddRootView = uIManager.startSurface(rootViewGroup, jSModuleName, writableMapFromBundle2, reactRoot.getWidthMeasureSpec(), reactRoot.getHeightMeasureSpec());
                reactRoot.setShouldLogContentAppeared(true);
            } else {
                ViewGroup rootViewGroup2 = reactRoot.getRootViewGroup();
                if (appProperties == null) {
                    writableMapFromBundle = new WritableNativeMap();
                } else {
                    writableMapFromBundle = Arguments.fromBundle(appProperties);
                }
                iAddRootView = uIManager.addRootView(rootViewGroup2, writableMapFromBundle);
                reactRoot.setRootViewTag(iAddRootView);
                reactRoot.runApplication();
            }
            Systrace.beginAsyncSection(0L, "pre_rootView.onAttachedToReactInstance", iAddRootView);
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.ReactInstanceManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ReactInstanceManager.lambda$attachRootViewToInstance$6(iAddRootView, reactRoot);
                }
            });
            Systrace.endSection(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$attachRootViewToInstance$6(int i, ReactRoot reactRoot) {
        Systrace.endAsyncSection(0L, "pre_rootView.onAttachedToReactInstance", i);
        reactRoot.onStage(101);
    }

    private void detachRootViewFromInstance(ReactRoot reactRoot, ReactContext reactContext) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.detachRootViewFromInstance()");
        UiThreadUtil.assertOnUiThread();
        if (reactRoot.getState().compareAndSet(1, 0)) {
            int uIManagerType = reactRoot.getUIManagerType();
            if (uIManagerType == 2) {
                int rootViewTag = reactRoot.getRootViewTag();
                if (rootViewTag != -1) {
                    UIManager uIManager = UIManagerHelper.getUIManager(reactContext, uIManagerType);
                    if (uIManager != null) {
                        uIManager.stopSurface(rootViewTag);
                    } else {
                        FLog.w(ReactConstants.TAG, "Failed to stop surface, UIManager has already gone away");
                    }
                } else {
                    ReactSoftExceptionLogger.logSoftException(TAG, new RuntimeException("detachRootViewFromInstance called with ReactRootView with invalid id"));
                }
                clearReactRoot(reactRoot);
                return;
            }
            ((AppRegistry) reactContext.getCatalystInstance().getJSModule(AppRegistry.class)).unmountApplicationComponentAtRootTag(reactRoot.getRootViewTag());
        }
    }

    private void tearDownReactContext(ReactContext reactContext) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.tearDownReactContext()");
        UiThreadUtil.assertOnUiThread();
        if (this.mLifecycleState == LifecycleState.RESUMED) {
            reactContext.onHostPause();
        }
        synchronized (this.mAttachedReactRoots) {
            Iterator<ReactRoot> it2 = this.mAttachedReactRoots.iterator();
            while (it2.hasNext()) {
                detachRootViewFromInstance(it2.next(), reactContext);
            }
        }
        this.mMemoryPressureRouter.removeMemoryPressureListener(reactContext.getCatalystInstance());
        reactContext.destroy();
        this.mDevSupportManager.onReactInstanceDestroyed(reactContext);
    }

    private ReactApplicationContext createReactContext(JavaScriptExecutor javaScriptExecutor, JSBundleLoader jSBundleLoader) {
        UIManager uIManagerCreateUIManager;
        ReactPackageTurboModuleManagerDelegate.Builder builder;
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.createReactContext()");
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_REACT_CONTEXT_START, javaScriptExecutor.getName());
        BridgeReactContext bridgeReactContext = new BridgeReactContext(this.mApplicationContext);
        JSExceptionHandler jSExceptionHandler = this.mJSExceptionHandler;
        if (jSExceptionHandler == null) {
            jSExceptionHandler = this.mDevSupportManager;
        }
        bridgeReactContext.setJSExceptionHandler(jSExceptionHandler);
        CatalystInstanceImpl.Builder inspectorTarget = new CatalystInstanceImpl.Builder().setReactQueueConfigurationSpec(ReactQueueConfigurationSpec.createDefault()).setJSExecutor(javaScriptExecutor).setRegistry(processPackages(bridgeReactContext, this.mPackages)).setJSBundleLoader(jSBundleLoader).setJSExceptionHandler(jSExceptionHandler).setInspectorTarget(getOrCreateInspectorTarget());
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_START);
        Systrace.beginSection(0L, "createCatalystInstance");
        try {
            CatalystInstanceImpl catalystInstanceImplBuild = inspectorTarget.build();
            Systrace.endSection(0L);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
            bridgeReactContext.initializeWithInstance(catalystInstanceImplBuild);
            catalystInstanceImplBuild.getRuntimeScheduler();
            if (ReactNativeFeatureFlags.useTurboModules() && (builder = this.mTMMDelegateBuilder) != null) {
                TurboModuleManager turboModuleManager = new TurboModuleManager(catalystInstanceImplBuild.getRuntimeExecutor(), builder.setPackages(this.mPackages).setReactApplicationContext(bridgeReactContext).build(), catalystInstanceImplBuild.getJSCallInvokerHolder(), catalystInstanceImplBuild.getNativeMethodCallInvokerHolder());
                catalystInstanceImplBuild.setTurboModuleRegistry(turboModuleManager);
                Iterator<String> it2 = turboModuleManager.getEagerInitModuleNames().iterator();
                while (it2.hasNext()) {
                    turboModuleManager.getModule(it2.next());
                }
            }
            UIManagerProvider uIManagerProvider = this.mUIManagerProvider;
            if (uIManagerProvider != null && (uIManagerCreateUIManager = uIManagerProvider.createUIManager(bridgeReactContext)) != null) {
                catalystInstanceImplBuild.setFabricUIManager(uIManagerCreateUIManager);
                uIManagerCreateUIManager.initialize();
                catalystInstanceImplBuild.setFabricUIManager(uIManagerCreateUIManager);
            }
            NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener = this.mBridgeIdleDebugListener;
            if (notThreadSafeBridgeIdleDebugListener != null) {
                catalystInstanceImplBuild.addBridgeIdleDebugListener(notThreadSafeBridgeIdleDebugListener);
            }
            if (Systrace.isTracing(0L)) {
                catalystInstanceImplBuild.setGlobalVariable("__RCTProfileIsProfiling", "true");
            }
            ReactMarker.logMarker(ReactMarkerConstants.PRE_RUN_JS_BUNDLE_START);
            Systrace.beginSection(0L, "runJSBundle");
            catalystInstanceImplBuild.runJSBundle();
            Systrace.endSection(0L);
            return bridgeReactContext;
        } catch (Throwable th) {
            Systrace.endSection(0L);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
            throw th;
        }
    }

    private NativeModuleRegistry processPackages(ReactApplicationContext reactApplicationContext, List<ReactPackage> list) {
        NativeModuleRegistryBuilder nativeModuleRegistryBuilder = new NativeModuleRegistryBuilder(reactApplicationContext);
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_START);
        synchronized (this.mPackages) {
            Iterator<ReactPackage> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    ReactPackage next = it2.next();
                    Systrace.beginSection(0L, "createAndProcessCustomReactPackage");
                    try {
                        processPackage(next, nativeModuleRegistryBuilder);
                        Systrace.endSection(0L);
                    } catch (Throwable th) {
                        Systrace.endSection(0L);
                        throw th;
                    }
                }
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_END);
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_START);
        Systrace.beginSection(0L, "buildNativeModuleRegistry");
        try {
            return nativeModuleRegistryBuilder.build();
        } finally {
            Systrace.endSection(0L);
            ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_END);
        }
    }

    private void processPackage(ReactPackage reactPackage, NativeModuleRegistryBuilder nativeModuleRegistryBuilder) {
        SystraceMessage.beginSection(0L, "processPackage").arg("className", reactPackage.getClass().getSimpleName()).flush();
        boolean z = reactPackage instanceof ReactPackageLogger;
        if (z) {
            ((ReactPackageLogger) reactPackage).startProcessPackage();
        }
        nativeModuleRegistryBuilder.processPackage(reactPackage);
        if (z) {
            ((ReactPackageLogger) reactPackage).endProcessPackage();
        }
        SystraceMessage.endSection(0L).flush();
    }

    /* JADX INFO: loaded from: classes2.dex */
    static class InspectorTargetDelegateImpl implements ReactInstanceManagerInspectorTarget.TargetDelegate {
        private WeakReference<ReactInstanceManager> mReactInstanceManagerWeak;

        public InspectorTargetDelegateImpl(ReactInstanceManager reactInstanceManager) {
            this.mReactInstanceManagerWeak = new WeakReference<>(reactInstanceManager);
        }

        @Override // com.facebook.react.bridge.ReactInstanceManagerInspectorTarget.TargetDelegate
        public Map<String, String> getMetadata() {
            ReactInstanceManager reactInstanceManager = this.mReactInstanceManagerWeak.get();
            return AndroidInfoHelpers.getInspectorHostMetadata(reactInstanceManager != null ? reactInstanceManager.mApplicationContext : null);
        }

        @Override // com.facebook.react.bridge.ReactInstanceManagerInspectorTarget.TargetDelegate
        public void onReload() {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.ReactInstanceManager$InspectorTargetDelegateImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onReload$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReload$0() {
            ReactInstanceManager reactInstanceManager = this.mReactInstanceManagerWeak.get();
            if (reactInstanceManager != null) {
                reactInstanceManager.mDevSupportManager.handleReloadJS();
            }
        }

        @Override // com.facebook.react.bridge.ReactInstanceManagerInspectorTarget.TargetDelegate
        public void onSetPausedInDebuggerMessage(@Nullable String str) {
            final ReactInstanceManager reactInstanceManager = this.mReactInstanceManagerWeak.get();
            if (reactInstanceManager == null) {
                return;
            }
            if (str == null) {
                reactInstanceManager.mDevSupportManager.hidePausedInDebuggerOverlay();
            } else {
                reactInstanceManager.mDevSupportManager.showPausedInDebuggerOverlay(str, new DevSupportManager.PausedInDebuggerOverlayCommandListener() { // from class: com.facebook.react.ReactInstanceManager.InspectorTargetDelegateImpl.1
                    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager.PausedInDebuggerOverlayCommandListener
                    public void onResume() {
                        UiThreadUtil.assertOnUiThread();
                        if (reactInstanceManager.mInspectorTarget != null) {
                            reactInstanceManager.mInspectorTarget.sendDebuggerResumeCommand();
                        }
                    }
                });
            }
        }

        @Override // com.facebook.react.bridge.ReactInstanceManagerInspectorTarget.TargetDelegate
        public void loadNetworkResource(String str, InspectorNetworkRequestListener inspectorNetworkRequestListener) {
            InspectorNetworkHelper.loadNetworkResource(str, inspectorNetworkRequestListener);
        }
    }

    private ReactInstanceManagerInspectorTarget getOrCreateInspectorTarget() {
        if (this.mInspectorTarget == null && InspectorFlags.getFuseboxEnabled()) {
            this.mInspectorTarget = new ReactInstanceManagerInspectorTarget(new InspectorTargetDelegateImpl(this));
        }
        return this.mInspectorTarget;
    }
}
