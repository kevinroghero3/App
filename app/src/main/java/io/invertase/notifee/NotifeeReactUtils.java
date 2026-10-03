package io.invertase.notifee;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import app.notifee.core.EventSubscriber;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.common.base.Ascii;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import o.ArtificialStackFrames;
import o.extraCallback;
import o.onMessageChannelReady;

/* JADX INFO: loaded from: classes6.dex */
class NotifeeReactUtils {
    private static final SparseArray<GenericCallback> headlessTasks = new SparseArray<>();
    private static final HeadlessJsTaskEventListener headlessTasksListener = new HeadlessJsTaskEventListener() { // from class: io.invertase.notifee.NotifeeReactUtils.1
        @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
        public void onHeadlessJsTaskStart(int i) {
        }

        @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
        public void onHeadlessJsTaskFinish(int i) {
            synchronized (NotifeeReactUtils.headlessTasks) {
                GenericCallback genericCallback = (GenericCallback) NotifeeReactUtils.headlessTasks.get(i);
                if (genericCallback != null) {
                    NotifeeReactUtils.headlessTasks.remove(i);
                    genericCallback.call();
                }
            }
        }
    };

    interface GenericCallback {
        void call();
    }

    NotifeeReactUtils() {
    }

    static void promiseResolver(Promise promise, Exception exc, Bundle bundle) {
        if (exc != null) {
            promise.reject(exc);
        } else if (bundle != null) {
            promise.resolve(Arguments.fromBundle(bundle));
        } else {
            promise.resolve(null);
        }
    }

    static void promiseResolver(Promise promise, Exception exc, List<Bundle> list) {
        if (exc != null) {
            promise.reject(exc);
            return;
        }
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<Bundle> it2 = list.iterator();
        while (it2.hasNext()) {
            writableArrayCreateArray.pushMap(Arguments.fromBundle(it2.next()));
        }
        promise.resolve(writableArrayCreateArray);
    }

    static void promiseBooleanResolver(Promise promise, Exception exc, Boolean bool) {
        if (exc != null) {
            promise.reject(exc);
        } else {
            promise.resolve(bool);
        }
    }

    static void promiseStringListResolver(Promise promise, Exception exc, List<String> list) {
        if (exc != null) {
            promise.reject(exc);
            return;
        }
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            writableArrayCreateArray.pushString(it2.next());
        }
        promise.resolve(writableArrayCreateArray);
    }

    static void promiseResolver(Promise promise, Exception exc) {
        if (exc != null) {
            promise.reject(exc);
        } else {
            promise.resolve(null);
        }
    }

    private static ReactContext getReactContext() {
        return ((ReactApplication) EventSubscriber.getContext()).getReactNativeHost().getReactInstanceManager().getCurrentReactContext();
    }

    private static void initializeReactContext(final GenericCallback genericCallback) {
        final ReactInstanceManager reactInstanceManager = ((ReactApplication) EventSubscriber.getContext()).getReactNativeHost().getReactInstanceManager();
        reactInstanceManager.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() { // from class: io.invertase.notifee.NotifeeReactUtils.2
            private static final byte[] $$c = {35, -18, 33, -64};
            private static final int $$d = AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {Ascii.GS, Ascii.VT, Ascii.VT, -116, -12, -6, Ascii.ESC, -22, -26, 4, -12, 0, -8, -2, -8};
            private static final int $$b = SyslogConstants.LOG_LOCAL1;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static char[] validateRelationship = {56126, 56263, 56106, 56306, 56114, 56127, 56113, 56284, 56121, 56294, 56107, 56122, 56123, 56118, 56302, 56116, 56124, 56292, 56295, 56260, 56285, 56111, 56277, 56117, 56261, 56276, 56115, 56112, 56310, 56299, 56298, 56311, 56283, 56293, 56281, 56272, 56120, 56282, 56105, 56104, 56125, 56274, 56287, 56275};
            private static int warmup = -1044259936;
            private static boolean requestPostMessageChannelWithExtras = true;
            private static boolean ICustomTabsServiceDefault = true;
            private static char[] ArtificialStackFrames = {44362, 44393, 44408, 44412, 44399, 44407, 44368, 44353, 44363, 44409, 44343, 44357, 44389, 44341, 44395, 44359, 44398, 44356, 44361, 44332, 44333, 44371, 44360, 44364, 44372, 44342, 44336, 44366, 44385, 44411, 44354, 44387, 44401, 44390, 44338, 44373, 44404, 44414, 44410, 44345, 44402, 44406, 44355, 44334, 44388, 44344, 44415, 44337, 44352, 44394, 44403, 44391, 44365, 44339, 44376, 44358, 44374, 44405, 44413, 44400, 44340, 44367, 44397, 44396};
            private static char coroutineCreation = 39058;

            /* JADX WARN: Code duplicated, block: B:10:0x0025  */
            /* JADX WARN: Code duplicated, block: B:8:0x001f  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002b). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(byte r7, int r8, byte r9) {
                /*
                    int r7 = r7 * 3
                    int r7 = 3 - r7
                    byte[] r0 = io.invertase.notifee.NotifeeReactUtils.AnonymousClass2.$$c
                    int r9 = r9 * 3
                    int r9 = r9 + 1
                    int r8 = 121 - r8
                    byte[] r1 = new byte[r9]
                    r2 = 0
                    if (r0 != 0) goto L15
                    r3 = r8
                    r4 = r2
                    r8 = r7
                    goto L2b
                L15:
                    r3 = r2
                L16:
                    int r4 = r3 + 1
                    byte r5 = (byte) r8
                    r1[r3] = r5
                    int r7 = r7 + 1
                    if (r4 != r9) goto L25
                    java.lang.String r7 = new java.lang.String
                    r7.<init>(r1, r2)
                    return r7
                L25:
                    r3 = r0[r7]
                    r6 = r8
                    r8 = r7
                    r7 = r3
                    r3 = r6
                L2b:
                    int r7 = r7 + r3
                    r3 = r4
                    r6 = r8
                    r8 = r7
                    r7 = r6
                    goto L16
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.notifee.NotifeeReactUtils.AnonymousClass2.$$e(byte, int, byte):java.lang.String");
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
            private static void b(short r7, byte r8, byte r9, java.lang.Object[] r10) {
                /*
                    int r9 = r9 * 5
                    int r9 = r9 + 4
                    int r8 = r8 * 8
                    int r8 = 12 - r8
                    int r7 = r7 * 3
                    int r7 = 115 - r7
                    byte[] r0 = io.invertase.notifee.NotifeeReactUtils.AnonymousClass2.$$a
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
                    int r8 = r8 + r7
                    int r7 = r8 + (-7)
                    int r8 = r3 + 1
                    r3 = r4
                    goto L18
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.notifee.NotifeeReactUtils.AnonymousClass2.b(short, byte, byte, java.lang.Object[]):void");
            }

            @Override // com.facebook.react.ReactInstanceEventListener
            public void onReactContextInitialized(ReactContext reactContext) {
                reactInstanceManager.removeReactInstanceEventListener(this);
                Handler handler = new Handler(Looper.getMainLooper());
                final GenericCallback genericCallback2 = genericCallback;
                Objects.requireNonNull(genericCallback2);
                handler.postDelayed(new Runnable() { // from class: io.invertase.notifee.NotifeeReactUtils$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        genericCallback2.call();
                    }
                }, 100L);
            }

            private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
                char[] cArr2;
                int i2;
                int i3 = 2 % 2;
                onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
                char[] cArr3 = validateRelationship;
                int i4 = 1;
                int i5 = 0;
                if (cArr3 != null) {
                    int length = cArr3.length;
                    char[] cArr4 = new char[length];
                    int i6 = 0;
                    while (i6 < length) {
                        try {
                            Object[] objArr2 = new Object[i4];
                            objArr2[i5] = Integer.valueOf(cArr3[i6]);
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                            if (objAccessartificialFrame == null) {
                                byte b = (byte) i5;
                                byte b2 = b;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "") + 26, (char) TextUtils.getOffsetAfter("", i5), (Process.myPid() >> 22) + 1041, -1719489573, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                            }
                            cArr4[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            i6++;
                            i4 = 1;
                            i5 = 0;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    cArr3 = cArr4;
                }
                Object[] objArr3 = {Integer.valueOf(warmup)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(14 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 20488), 2149 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 216472770, false, $$e(b3, (byte) (b3 | 54), b3), new Class[]{Integer.TYPE});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                int i7 = 59173;
                int i8 = -2083387879;
                if (ICustomTabsServiceDefault) {
                    int i9 = $10 + 87;
                    $11 = i9 % 128;
                    int i10 = i9 % 2;
                    onmessagechannelready.c = bArr.length;
                    char[] cArr5 = new char[onmessagechannelready.c];
                    onmessagechannelready.a = 0;
                    while (onmessagechannelready.a < onmessagechannelready.c) {
                        cArr5[onmessagechannelready.a] = (char) (cArr3[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                        Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                        if (objAccessartificialFrame3 == null) {
                            byte b4 = (byte) 0;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(20 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (59173 - MotionEvent.axisFromString("")), 1943 - (Process.myTid() >> 22), 481771537, false, $$e(b4, (byte) (b4 | 55), b4), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    }
                    objArr[0] = new String(cArr5);
                    return;
                }
                if (requestPostMessageChannelWithExtras) {
                    int i11 = $11 + 107;
                    $10 = i11 % 128;
                    if (i11 % 2 != 0) {
                        onmessagechannelready.c = cArr.length;
                        cArr2 = new char[onmessagechannelready.c];
                        i2 = 1;
                    } else {
                        onmessagechannelready.c = cArr.length;
                        cArr2 = new char[onmessagechannelready.c];
                        i2 = 0;
                    }
                    onmessagechannelready.a = i2;
                    int i12 = $11 + 81;
                    $10 = i12 % 128;
                    int i13 = 2;
                    int i14 = i12 % 2;
                    while (onmessagechannelready.a < onmessagechannelready.c) {
                        int i15 = $11 + 87;
                        $10 = i15 % 128;
                        int i16 = i15 % i13;
                        cArr2[onmessagechannelready.a] = (char) (cArr3[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                        try {
                            Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(i8);
                            if (objAccessartificialFrame4 == null) {
                                byte b5 = (byte) 0;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(21 - ExpandableListView.getPackedPositionType(0L), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + i7), TextUtils.indexOf((CharSequence) "", '0') + 1944, 481771537, false, $$e(b5, (byte) (b5 | 55), b5), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                            i13 = 2;
                            i7 = 59173;
                            i8 = -2083387879;
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    }
                    String str = new String(cArr2);
                    int i17 = $10 + 87;
                    $11 = i17 % 128;
                    int i18 = i17 % 2;
                    objArr[0] = str;
                    return;
                }
                int i19 = 0;
                onmessagechannelready.c = iArr.length;
                char[] cArr6 = new char[onmessagechannelready.c];
                while (true) {
                    onmessagechannelready.a = i19;
                    while (true) {
                        if (onmessagechannelready.a >= onmessagechannelready.c) {
                            objArr[0] = new String(cArr6);
                            return;
                        }
                        int i20 = $11 + 123;
                        $10 = i20 % 128;
                        if (i20 % 2 != 0) {
                            cArr6[onmessagechannelready.a] = (char) (cArr3[iArr[(onmessagechannelready.c << 1) >>> onmessagechannelready.a] - i] / iIntValue);
                            onmessagechannelready.a = onmessagechannelready.a;
                        }
                    }
                    cArr6[onmessagechannelready.a] = (char) (cArr3[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    i19 = onmessagechannelready.a + 1;
                }
            }

            private static void c(byte b, int i, char[] cArr, Object[] objArr) throws Throwable {
                int i2;
                int length;
                char[] cArr2;
                int i3;
                int i4 = 2;
                int i5 = 2 % 2;
                extraCallback extracallback = new extraCallback();
                char[] cArr3 = ArtificialStackFrames;
                int i6 = -1819279892;
                Object obj = null;
                if (cArr3 != null) {
                    int i7 = $11 + 27;
                    $10 = i7 % 128;
                    if (i7 % 2 != 0) {
                        length = cArr3.length;
                        cArr2 = new char[length];
                        i3 = 1;
                    } else {
                        length = cArr3.length;
                        cArr2 = new char[length];
                        i3 = 0;
                    }
                    while (i3 < length) {
                        int i8 = $10 + 89;
                        $11 = i8 % 128;
                        if (i8 % i4 == 0) {
                            try {
                                Object[] objArr2 = {Integer.valueOf(cArr3[i3])};
                                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i6);
                                if (objAccessartificialFrame == null) {
                                    byte b2 = (byte) 0;
                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Process.getGidForName("") + 16, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 20487), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 2147, 216710116, false, $$e(b2, (byte) (b2 | Ascii.CAN), b2), new Class[]{Integer.TYPE});
                                }
                                cArr2[i3] = ((Character) ((Method) objAccessartificialFrame).invoke(obj, objArr2)).charValue();
                                i3 = 0;
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        } else {
                            Object[] objArr3 = {Integer.valueOf(cArr3[i3])};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                            if (objAccessartificialFrame2 == null) {
                                byte b3 = (byte) 0;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((Process.myPid() >> 22) + 15, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.HT), 2148 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 216710116, false, $$e(b3, (byte) (b3 | Ascii.CAN), b3), new Class[]{Integer.TYPE});
                            }
                            cArr2[i3] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                            i3++;
                        }
                        i4 = 2;
                        i6 = -1819279892;
                        obj = null;
                    }
                    cArr3 = cArr2;
                }
                try {
                    Object[] objArr4 = {Integer.valueOf(coroutineCreation)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                    if (objAccessartificialFrame3 == null) {
                        byte b4 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Color.argb(0, 0, 0, 0) + 15, (char) (KeyEvent.keyCodeFromString("") + 20488), 2148 - (Process.myTid() >> 22), 216710116, false, $$e(b4, (byte) (b4 | Ascii.CAN), b4), new Class[]{Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                    char[] cArr4 = new char[i];
                    if (i % 2 != 0) {
                        i2 = i - 1;
                        cArr4[i2] = (char) (cArr[i2] - b);
                    } else {
                        i2 = i;
                    }
                    if (i2 > 1) {
                        extracallback.a = 0;
                        while (extracallback.a < i2) {
                            extracallback.createBrowser = cArr[extracallback.a];
                            extracallback.c = cArr[extracallback.a + 1];
                            if (extracallback.createBrowser == extracallback.c) {
                                cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                                cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                            } else {
                                Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                                if (objAccessartificialFrame4 == null) {
                                    byte b5 = (byte) 0;
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(46 - Color.red(0), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 58860), 2464 - (ViewConfiguration.getTouchSlop() >> 8), 276640984, false, $$e(b5, (byte) (b5 | 19), b5), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                                }
                                if (((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue() == extracallback.g) {
                                    Object[] objArr6 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                    if (objAccessartificialFrame5 == null) {
                                        byte b6 = (byte) 0;
                                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(25 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) TextUtils.getOffsetAfter("", 0), 791 - TextUtils.lastIndexOf("", '0'), -834291897, false, $$e(b6, (byte) (b6 | Ascii.DLE), b6), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                    }
                                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).intValue();
                                    int i9 = (extracallback.d * cCharValue) + extracallback.g;
                                    cArr4[extracallback.a] = cArr3[iIntValue];
                                    cArr4[extracallback.a + 1] = cArr3[i9];
                                } else if (extracallback.b == extracallback.d) {
                                    extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                    extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                    int i10 = (extracallback.b * cCharValue) + extracallback.j;
                                    int i11 = (extracallback.d * cCharValue) + extracallback.g;
                                    cArr4[extracallback.a] = cArr3[i10];
                                    cArr4[extracallback.a + 1] = cArr3[i11];
                                } else {
                                    int i12 = (extracallback.b * cCharValue) + extracallback.g;
                                    int i13 = (extracallback.d * cCharValue) + extracallback.j;
                                    cArr4[extracallback.a] = cArr3[i12];
                                    cArr4[extracallback.a + 1] = cArr3[i13];
                                }
                            }
                            extracallback.a += 2;
                        }
                    }
                    for (int i14 = 0; i14 < i; i14++) {
                        cArr4[i14] = (char) (cArr4[i14] ^ 13722);
                    }
                    String str = new String(cArr4);
                    int i15 = $11 + 35;
                    $10 = i15 % 128;
                    int i16 = i15 % 2;
                    objArr[0] = str;
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v47, types: [java.lang.reflect.Method] */
            /* JADX WARN: Type inference failed for: r27v1 */
            /* JADX WARN: Type inference failed for: r27v10 */
            /* JADX WARN: Type inference failed for: r27v11 */
            /* JADX WARN: Type inference failed for: r27v12 */
            /* JADX WARN: Type inference failed for: r27v13 */
            /* JADX WARN: Type inference failed for: r27v2 */
            /* JADX WARN: Type inference failed for: r27v22 */
            /* JADX WARN: Type inference failed for: r27v23 */
            /* JADX WARN: Type inference failed for: r27v24 */
            /* JADX WARN: Type inference failed for: r27v25 */
            /* JADX WARN: Type inference failed for: r27v27, types: [char] */
            /* JADX WARN: Type inference failed for: r27v3 */
            /* JADX WARN: Type inference failed for: r27v39 */
            /* JADX WARN: Type inference failed for: r27v40 */
            /* JADX WARN: Type inference failed for: r27v41 */
            /* JADX WARN: Type inference failed for: r27v42 */
            /* JADX WARN: Type inference failed for: r2v134, types: [java.lang.reflect.Method] */
            /* JADX WARN: Type inference failed for: r2v29, types: [java.nio.LongBuffer[]] */
            /* JADX WARN: Type inference failed for: r2v30 */
            /* JADX WARN: Type inference failed for: r2v53 */
            /* JADX WARN: Type inference failed for: r2v538 */
            /* JADX WARN: Type inference failed for: r2v539 */
            /* JADX WARN: Type inference failed for: r2v54 */
            /* JADX WARN: Type inference failed for: r2v58, types: [java.lang.reflect.Method] */
            /* JADX WARN: Type inference failed for: r2v76 */
            /* JADX WARN: Type inference failed for: r31v4 */
            /* JADX WARN: Type inference failed for: r31v5 */
            /* JADX WARN: Type inference failed for: r31v6 */
            /* JADX WARN: Type inference failed for: r31v7 */
            /* JADX WARN: Type inference failed for: r44v1 */
            /* JADX WARN: Type inference failed for: r44v2 */
            /* JADX WARN: Type inference failed for: r44v3 */
            /* JADX WARN: Type inference failed for: r44v4 */
            /* JADX WARN: Type inference failed for: r4v10 */
            /* JADX WARN: Type inference failed for: r4v17 */
            /* JADX WARN: Type inference failed for: r4v318 */
            /* JADX WARN: Type inference failed for: r4v332 */
            /* JADX WARN: Type inference failed for: r4v373 */
            /* JADX WARN: Type inference failed for: r4v374 */
            /* JADX WARN: Type inference failed for: r4v382 */
            /* JADX WARN: Type inference failed for: r4v384 */
            /* JADX WARN: Type inference failed for: r4v420 */
            /* JADX WARN: Type inference failed for: r4v614, types: [java.lang.reflect.Method] */
            /* JADX WARN: Type inference failed for: r4v618 */
            /* JADX WARN: Type inference failed for: r4v637 */
            /* JADX WARN: Type inference failed for: r4v682 */
            /* JADX WARN: Type inference failed for: r4v683 */
            /* JADX WARN: Type inference failed for: r4v684 */
            /* JADX WARN: Type inference failed for: r4v685 */
            /* JADX WARN: Type inference failed for: r4v686 */
            /* JADX WARN: Type inference failed for: r4v687 */
            /* JADX WARN: Type inference failed for: r4v688 */
            /* JADX WARN: Type inference failed for: r4v689 */
            /* JADX WARN: Type inference failed for: r4v690 */
            /* JADX WARN: Type inference failed for: r4v691 */
            /* JADX WARN: Type inference failed for: r4v7, types: [java.nio.LongBuffer[]] */
            /* JADX WARN: Type inference failed for: r4v8 */
            /* JADX WARN: Type inference failed for: r4v9 */
            /* JADX WARN: Type inference failed for: r6v18, types: [java.lang.Object, java.nio.LongBuffer] */
            /* JADX WARN: Type inference failed for: r6v20, types: [java.lang.Object, java.nio.LongBuffer] */
            /* JADX WARN: Type inference failed for: r6v432, types: [java.lang.Object, java.nio.LongBuffer] */
            /* JADX WARN: Type inference failed for: r7v501, types: [java.lang.Object, java.nio.LongBuffer] */
            /* JADX WARN: Type inference failed for: r8v127 */
            /* JADX WARN: Type inference failed for: r8v128 */
            /* JADX WARN: Type inference failed for: r8v164 */
            /* JADX WARN: Type inference failed for: r8v175, types: [java.lang.Object, java.security.KeyStore] */
            /* JADX WARN: Type inference failed for: r8v384, types: [java.lang.reflect.Method] */
            /* JADX WARN: Type inference failed for: r8v547 */
            /* JADX WARN: Type inference failed for: r8v65 */
            /* JADX WARN: Type inference failed for: r8v66 */
            /* JADX WARN: Type inference failed for: r8v67, types: [java.security.KeyStore] */
            /* JADX WARN: Type inference failed for: r8v68, types: [java.security.KeyStore] */
            /* JADX WARN: Type inference failed for: r8v79, types: [java.lang.Class] */
            /* JADX WARN: Type inference failed for: r8v80 */
            /* JADX WARN: Type inference failed for: r9v63, types: [java.nio.LongBuffer] */
            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] accessartificialFrame(android.content.Context r43, java.lang.String[] r44, int r45, int r46, int r47) {
                /*
                    Method dump skipped, instruction units count: 15234
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.notifee.NotifeeReactUtils.AnonymousClass2.accessartificialFrame(android.content.Context, java.lang.String[], int, int, int):java.lang.Object[]");
            }
        });
        if (reactInstanceManager.hasStartedCreatingInitialContext()) {
            return;
        }
        reactInstanceManager.createReactContextInBackground();
    }

    static void clearRunningHeadlessTasks() {
        int i = 0;
        while (true) {
            SparseArray<GenericCallback> sparseArray = headlessTasks;
            if (i >= sparseArray.size()) {
                return;
            }
            sparseArray.valueAt(i).call();
            sparseArray.remove(i);
            i++;
        }
    }

    static void startHeadlessTask(final String str, final WritableMap writableMap, final long j, @Nullable final GenericCallback genericCallback) {
        GenericCallback genericCallback2 = new GenericCallback() { // from class: io.invertase.notifee.NotifeeReactUtils$$ExternalSyntheticLambda1
            @Override // io.invertase.notifee.NotifeeReactUtils.GenericCallback
            public final void call() {
                NotifeeReactUtils.lambda$startHeadlessTask$1(str, writableMap, j, genericCallback);
            }
        };
        if (getReactContext() == null) {
            initializeReactContext(genericCallback2);
        } else {
            genericCallback2.call();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startHeadlessTask$1(String str, WritableMap writableMap, long j, final GenericCallback genericCallback) {
        final HeadlessJsTaskContext headlessJsTaskContext = HeadlessJsTaskContext.getInstance(getReactContext());
        HeadlessJsTaskConfig headlessJsTaskConfig = new HeadlessJsTaskConfig(str, writableMap, j, true);
        SparseArray<GenericCallback> sparseArray = headlessTasks;
        synchronized (sparseArray) {
            if (sparseArray.size() == 0) {
                headlessJsTaskContext.addTaskEventListener(headlessTasksListener);
            }
        }
        sparseArray.put(headlessJsTaskContext.startTask(headlessJsTaskConfig), new GenericCallback() { // from class: io.invertase.notifee.NotifeeReactUtils$$ExternalSyntheticLambda0
            @Override // io.invertase.notifee.NotifeeReactUtils.GenericCallback
            public final void call() {
                NotifeeReactUtils.lambda$startHeadlessTask$0(headlessJsTaskContext, genericCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startHeadlessTask$0(HeadlessJsTaskContext headlessJsTaskContext, GenericCallback genericCallback) {
        SparseArray<GenericCallback> sparseArray = headlessTasks;
        synchronized (sparseArray) {
            if (sparseArray.size() == 0) {
                headlessJsTaskContext.removeTaskEventListener(headlessTasksListener);
            }
        }
        if (genericCallback != null) {
            genericCallback.call();
        }
    }

    static void sendEvent(String str, WritableMap writableMap) {
        try {
            ReactContext reactContext = getReactContext();
            if (reactContext != null && reactContext.hasActiveCatalystInstance()) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
            }
        } catch (Exception e) {
            SentryLogcatAdapter.e("SEND_EVENT", "", e);
        }
    }

    static boolean isAppInForeground() {
        return ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED);
    }

    static void hideNotificationDrawer() {
        try {
            Object systemService = EventSubscriber.getContext().getSystemService("statusbar");
            Method method = Class.forName("android.app.StatusBarManager").getMethod("collapsePanels", null);
            method.setAccessible(true);
            method.invoke(systemService, null);
        } catch (Exception e) {
            SentryLogcatAdapter.e("HIDE_NOTIF_DRAWER", "", e);
        }
    }
}
