package com.salesforce.marketingcloud.sfmcsdk.components.behaviors;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdk;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import com.salesforce.marketingcloud.sfmcsdk.util.ApplicationUtils;
import com.salesforce.marketingcloud.sfmcsdk.util.FileUtilsKt;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.artificialFrame;
import o.onMessageChannelReady;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.builder.XmlBuilderException;

/* JADX INFO: loaded from: classes3.dex */
public final class BehaviorManagerImpl implements BehaviorManager {
    public static final String BUNDLE_KEY_APP_NAME = "application_name";
    public static final String BUNDLE_KEY_CURRENT_VERSION = "current_version";
    public static final String BUNDLE_KEY_PREVIOUS_VERSION = "previous_version";
    public static final Companion Companion = new Companion(null);
    public static final String KEY_PREFS_CAPTURED_APP_VERSION = "captured_app_version";
    private static final String TAG = "~$BehaviorManager";
    private BehaviorReceiver behaviorReceiver;
    private final ArrayMap<BehaviorType, Set<BehaviorListener>> behaviorTypeListeners;
    private Context context;
    private final ExecutorService executorService;
    private final Map<BehaviorType, Bundle> stickyBehaviors;

    public BehaviorManagerImpl(@NotNull ExecutorService executorService) {
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        this.executorService = executorService;
        this.behaviorTypeListeners = new ArrayMap<>();
        this.stickyBehaviors = new LinkedHashMap();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getKEY_PREFS_CAPTURED_APP_VERSION$sfmcsdk_release$annotations() {
        }

        private Companion() {
        }

        public final void notifyBehavior$sfmcsdk_release(@NotNull Context context, @NotNull final BehaviorType behaviorType, @NotNull final Bundle extras) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(behaviorType, "behaviorType");
            Intrinsics.checkNotNullParameter(extras, "extras");
            Intent intent = new Intent(behaviorType.getIntentFilter$sfmcsdk_release());
            extras.putString(BehaviorManagerImpl.BUNDLE_KEY_APP_NAME, ApplicationUtils.getApplicationName(context));
            extras.putString(BehaviorManagerImpl.BUNDLE_KEY_CURRENT_VERSION, ApplicationUtils.getApplicationVersion(context));
            intent.putExtras(extras);
            SFMCSdkLogger.INSTANCE.d(BehaviorManagerImpl.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManagerImpl$Companion$notifyBehavior$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Notified of behavior " + behaviorType + " with " + extras + " extras.";
                }
            });
            context.sendBroadcast(intent.setPackage(context.getPackageName()));
        }

        public static final class BehaviorRunnable implements Runnable {
            private final Behavior behavior;
            private final BehaviorType behaviorType;
            private final Set<BehaviorListener> listeners;

            /* JADX WARN: Multi-variable type inference failed */
            public BehaviorRunnable(@NotNull Set<? extends BehaviorListener> listeners, @NotNull BehaviorType behaviorType, @NotNull Bundle data) {
                Intrinsics.checkNotNullParameter(listeners, "listeners");
                Intrinsics.checkNotNullParameter(behaviorType, "behaviorType");
                Intrinsics.checkNotNullParameter(data, "data");
                this.listeners = listeners;
                this.behaviorType = behaviorType;
                this.behavior = behaviorType.toBehavior$sfmcsdk_release(data);
            }

            @Override // java.lang.Runnable
            public void run() {
                Behavior behavior = this.behavior;
                if (behavior != null) {
                    SFMCSdk.Companion.track(BehaviorTypeKt.toEvent(behavior));
                    for (final BehaviorListener behaviorListener : this.listeners) {
                        if (behaviorListener != null) {
                            try {
                                SFMCSdkLogger.INSTANCE.d(BehaviorManagerImpl.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManagerImpl$Companion$BehaviorRunnable$run$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return "Delivering behavior " + this.this$0.behaviorType + " to " + behaviorListener + ".";
                                    }
                                });
                                behaviorListener.onBehavior(behavior);
                            } catch (Exception e) {
                                SFMCSdkLogger.INSTANCE.e(BehaviorManagerImpl.TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManagerImpl$Companion$BehaviorRunnable$run$1$1$1$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return "Exception " + e.getLocalizedMessage() + " occurred.";
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    }

    public final ArrayMap<BehaviorType, Set<BehaviorListener>> getBehaviorTypeListeners$sfmcsdk_release() {
        return this.behaviorTypeListeners;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManager
    public void registerForBehaviors(@NotNull EnumSet<BehaviorType> behaviorTypes, @NotNull final BehaviorListener listener) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(behaviorTypes, "behaviorTypes");
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.behaviorTypeListeners) {
            for (final BehaviorType behaviorType : behaviorTypes) {
                Set<BehaviorListener> hashSet = this.behaviorTypeListeners.get(behaviorType);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    this.behaviorTypeListeners.put(behaviorType, hashSet);
                }
                SFMCSdkLogger.INSTANCE.d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManagerImpl$registerForBehaviors$1$1$1
                    private static final byte[] $$a = {92, 127, 52, -8};
                    private static final int $$b = 14;
                    private static int $10 = 0;
                    private static int $11 = 1;
                    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
                    private static int artificialFrame = 1;
                    private static int[] ICustomTabsCallbackStub = {-2069615342, 332743298, 1278151340, 1061437376, -1091913417, -1919518775, -980963068, -868338892, 197615101, 689310331, 1743548951, -1327524467, 564271544, -1122271919, 1531390329, 613993319, 223702278, 633300845};
                    private static char[] validateRelationship = {56040, 56027, 56045, 56031, 56026, 56032, 55963, 56046, 56029, 56044, 55950, 56017, 56034, 56057, 56038, 55940, 56059, 56036, 56025, 55936, 56035, 56030, 56028, 56049, 55964, 55961, 55952, 56062, 56039, 56019, 56016, 56047, 56037};
                    private static int warmup = -1044260023;
                    private static boolean requestPostMessageChannelWithExtras = true;
                    private static boolean ICustomTabsServiceDefault = true;

                    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
                    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
                    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
                        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                        */
                    private static java.lang.String $$c(int r5, short r6, byte r7) {
                        /*
                            int r6 = r6 * 2
                            int r0 = 1 - r6
                            int r5 = 121 - r5
                            int r7 = r7 * 2
                            int r7 = 4 - r7
                            byte[] r1 = com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManagerImpl$registerForBehaviors$1$1$1.$$a
                            byte[] r0 = new byte[r0]
                            r2 = 0
                            int r6 = 0 - r6
                            if (r1 != 0) goto L17
                            r3 = r6
                            r5 = r7
                            r4 = r2
                            goto L27
                        L17:
                            r3 = r2
                        L18:
                            byte r4 = (byte) r5
                            r0[r3] = r4
                            int r4 = r3 + 1
                            if (r3 != r6) goto L25
                            java.lang.String r5 = new java.lang.String
                            r5.<init>(r0, r2)
                            return r5
                        L25:
                            r3 = r1[r7]
                        L27:
                            int r7 = r7 + 1
                            int r3 = -r3
                            int r5 = r5 + r3
                            r3 = r4
                            goto L18
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManagerImpl$registerForBehaviors$1$1$1.$$c(int, short, byte):java.lang.String");
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Listener " + listener + " registering for " + behaviorType;
                    }

                    private static void a(int i, int[] iArr, Object[] objArr) throws Throwable {
                        int length;
                        int[] iArr2;
                        int i2;
                        int i3 = 2;
                        int i4 = 2 % 2;
                        artificialFrame artificialframe = new artificialFrame();
                        char[] cArr = new char[4];
                        char[] cArr2 = new char[iArr.length * 2];
                        int[] iArr3 = ICustomTabsCallbackStub;
                        int i5 = -1780896814;
                        float f = 0.0f;
                        int i6 = 1;
                        int i7 = 0;
                        if (iArr3 != null) {
                            int length2 = iArr3.length;
                            int[] iArr4 = new int[length2];
                            int i8 = 0;
                            while (i8 < length2) {
                                int i9 = $11 + 97;
                                $10 = i9 % 128;
                                if (i9 % i3 != 0) {
                                    try {
                                        Object[] objArr2 = new Object[1];
                                        objArr2[i7] = Integer.valueOf(iArr3[i8]);
                                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                                        if (objAccessartificialFrame == null) {
                                            byte b = (byte) i7;
                                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(i7, f, f) > f ? 1 : (TypedValue.complexToFraction(i7, f, f) == f ? 0 : -1)) + 11, (char) (AudioTrack.getMinVolume() > f ? 1 : (AudioTrack.getMinVolume() == f ? 0 : -1)), TextUtils.indexOf("", "") + 1562, 180153818, false, $$c((byte) ($$b - 2), b, b), new Class[]{Integer.TYPE});
                                        }
                                        iArr4[i8] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                                    } catch (Throwable th) {
                                        Throwable cause = th.getCause();
                                        if (cause == null) {
                                            throw th;
                                        }
                                        throw cause;
                                    }
                                } else {
                                    Object[] objArr3 = {Integer.valueOf(iArr3[i8])};
                                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                                    if (objAccessartificialFrame2 == null) {
                                        byte b2 = (byte) 0;
                                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(KeyEvent.normalizeMetaState(0) + 11, (char) View.MeasureSpec.getMode(0), View.MeasureSpec.getMode(0) + 1562, 180153818, false, $$c((byte) ($$b - 2), b2, b2), new Class[]{Integer.TYPE});
                                    }
                                    iArr4[i8] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                                    i8++;
                                }
                                i3 = 2;
                                i5 = -1780896814;
                                f = 0.0f;
                                i7 = 0;
                            }
                            iArr3 = iArr4;
                        }
                        int length3 = iArr3.length;
                        int[] iArr5 = new int[length3];
                        int[] iArr6 = ICustomTabsCallbackStub;
                        char c = '0';
                        if (iArr6 != null) {
                            int i10 = $11 + 117;
                            $10 = i10 % 128;
                            if (i10 % 2 != 0) {
                                length = iArr6.length;
                                iArr2 = new int[length];
                                i2 = 1;
                            } else {
                                length = iArr6.length;
                                iArr2 = new int[length];
                                i2 = 0;
                            }
                            while (i2 < length) {
                                try {
                                    Object[] objArr4 = new Object[i6];
                                    objArr4[0] = Integer.valueOf(iArr6[i2]);
                                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                                    if (objAccessartificialFrame3 == null) {
                                        byte b3 = (byte) 0;
                                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", c) + 12, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 1562 - ExpandableListView.getPackedPositionType(0L), 180153818, false, $$c((byte) ($$b - 2), b3, b3), new Class[]{Integer.TYPE});
                                    }
                                    iArr2[i2] = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                                    i2++;
                                    iArr6 = iArr6;
                                    c = '0';
                                    i6 = 1;
                                } catch (Throwable th2) {
                                    Throwable cause2 = th2.getCause();
                                    if (cause2 == null) {
                                        throw th2;
                                    }
                                    throw cause2;
                                }
                            }
                            iArr6 = iArr2;
                        }
                        System.arraycopy(iArr6, 0, iArr5, 0, length3);
                        artificialframe.e = 0;
                        while (artificialframe.e < iArr.length) {
                            int i11 = $11 + 55;
                            $10 = i11 % 128;
                            int i12 = i11 % 2;
                            cArr[0] = (char) (iArr[artificialframe.e] >> 16);
                            cArr[1] = (char) iArr[artificialframe.e];
                            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
                            cArr[3] = (char) iArr[artificialframe.e + 1];
                            artificialframe.c = (cArr[0] << 16) + cArr[1];
                            artificialframe.b = (cArr[2] << 16) + cArr[3];
                            artificialFrame.coroutineBoundary(iArr5);
                            int i13 = 0;
                            while (i13 < 16) {
                                int i14 = $10 + 45;
                                $11 = i14 % 128;
                                if (i14 % 2 == 0) {
                                    artificialframe.c ^= iArr5[i13];
                                    Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                                    if (objAccessartificialFrame4 == null) {
                                        byte b4 = (byte) 0;
                                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 26, (char) (ViewConfiguration.getJumpTapTimeout() >> 16), 1041 - (ViewConfiguration.getTapTimeout() >> 16), 995482881, false, $$c((byte) ($$b & 23), b4, b4), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                                    }
                                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                                    artificialframe.c = artificialframe.b;
                                    artificialframe.b = iIntValue;
                                    i13 += 124;
                                } else {
                                    artificialframe.c ^= iArr5[i13];
                                    Object[] objArr6 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                                    if (objAccessartificialFrame5 == null) {
                                        byte b5 = (byte) 0;
                                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(27 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1), TextUtils.getCapsMode("", 0, 0) + 1041, 995482881, false, $$c((byte) ($$b & 23), b5, b5), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                                    }
                                    int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).intValue();
                                    artificialframe.c = artificialframe.b;
                                    artificialframe.b = iIntValue2;
                                    i13++;
                                }
                            }
                            int i15 = artificialframe.c;
                            artificialframe.c = artificialframe.b;
                            artificialframe.b = i15;
                            artificialframe.b ^= iArr5[16];
                            artificialframe.c ^= iArr5[17];
                            int i16 = artificialframe.c;
                            int i17 = artificialframe.b;
                            cArr[0] = (char) (artificialframe.c >>> 16);
                            cArr[1] = (char) artificialframe.c;
                            cArr[2] = (char) (artificialframe.b >>> 16);
                            cArr[3] = (char) artificialframe.b;
                            artificialFrame.coroutineBoundary(iArr5);
                            cArr2[artificialframe.e * 2] = cArr[0];
                            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
                            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
                            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
                            Object[] objArr7 = {artificialframe, artificialframe};
                            Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1348396126);
                            if (objAccessartificialFrame6 == null) {
                                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0) + 38, (char) (28010 - ExpandableListView.getPackedPositionGroup(0L)), 306 - ExpandableListView.getPackedPositionGroup(0L), -818175402, false, "q", new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame6).invoke(null, objArr7);
                        }
                        objArr[0] = new String(cArr2, 0, i);
                    }

                    private static void b(char[] cArr, byte[] bArr, int i, int[] iArr, Object[] objArr) throws Throwable {
                        int i2 = 2 % 2;
                        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
                        char[] cArr2 = validateRelationship;
                        int i3 = 1;
                        int i4 = 0;
                        if (cArr2 != null) {
                            int length = cArr2.length;
                            char[] cArr3 = new char[length];
                            int i5 = 0;
                            while (i5 < length) {
                                try {
                                    Object[] objArr2 = new Object[i3];
                                    objArr2[i4] = Integer.valueOf(cArr2[i5]);
                                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                                    if (objAccessartificialFrame == null) {
                                        byte b = (byte) i4;
                                        byte b2 = b;
                                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(MotionEvent.axisFromString("") + 27, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')), ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.DC2, -1719489573, false, $$c(b, b2, b2), new Class[]{Integer.TYPE});
                                    }
                                    cArr3[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                                    i5++;
                                    i3 = 1;
                                    i4 = 0;
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
                        Object[] objArr3 = {Integer.valueOf(warmup)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(14 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (Color.alpha(0) + 20488), 2148 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 216472770, false, $$c((byte) 54, b3, b3), new Class[]{Integer.TYPE});
                        }
                        int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                        int i6 = 55;
                        if (ICustomTabsServiceDefault) {
                            onmessagechannelready.c = bArr.length;
                            char[] cArr4 = new char[onmessagechannelready.c];
                            onmessagechannelready.a = 0;
                            int i7 = $11 + 5;
                            $10 = i7 % 128;
                            int i8 = i7 % 2;
                            while (onmessagechannelready.a < onmessagechannelready.c) {
                                cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                                Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                                if (objAccessartificialFrame3 == null) {
                                    byte b4 = (byte) 0;
                                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 20, (char) (MotionEvent.axisFromString("") + 59175), ((byte) KeyEvent.getModifierMetaStateMask()) + 1944, 481771537, false, $$c((byte) 55, b4, b4), new Class[]{Object.class, Object.class});
                                }
                                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                            }
                            objArr[0] = new String(cArr4);
                            return;
                        }
                        if (requestPostMessageChannelWithExtras) {
                            onmessagechannelready.c = cArr.length;
                            char[] cArr5 = new char[onmessagechannelready.c];
                            onmessagechannelready.a = 0;
                            while (onmessagechannelready.a < onmessagechannelready.c) {
                                cArr5[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                                Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                                if (objAccessartificialFrame4 == null) {
                                    byte b5 = (byte) 0;
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((-16777195) - Color.rgb(0, 0, 0), (char) (View.MeasureSpec.getSize(0) + 59174), TextUtils.getTrimmedLength("") + 1943, 481771537, false, $$c((byte) i6, b5, b5), new Class[]{Object.class, Object.class});
                                }
                                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                                i6 = 55;
                            }
                            objArr[0] = new String(cArr5);
                            return;
                        }
                        int i9 = 0;
                        onmessagechannelready.c = iArr.length;
                        char[] cArr6 = new char[onmessagechannelready.c];
                        while (true) {
                            onmessagechannelready.a = i9;
                            if (onmessagechannelready.a >= onmessagechannelready.c) {
                                objArr[0] = new String(cArr6);
                                return;
                            }
                            int i10 = $10 + 3;
                            $11 = i10 % 128;
                            int i11 = i10 % 2;
                            cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                            i9 = onmessagechannelready.a + 1;
                        }
                    }

                    public static Object[] accessartificialFrame(Context context, int i, int i2) {
                        byte[] bArr;
                        int iIndexOf;
                        int i3;
                        int i4;
                        int i5;
                        Class<?> cls;
                        int i6;
                        int iMediaBrowserCompatMediaBrowserServiceCallbackImpl;
                        int i7;
                        Field field;
                        int i8;
                        int iMediaBrowserCompatMediaBrowserServiceCallbackImpl2;
                        int i9;
                        int i10;
                        int i11;
                        Object[] objArr;
                        int i12;
                        int i13 = 2 % 2;
                        int i14 = artificialFrame;
                        int i15 = ((i14 | 37) << 1) - (i14 ^ 37);
                        int i16 = i15 % 128;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i16;
                        int i17 = i15 % 2;
                        if (context == null) {
                            int i18 = (i16 ^ 3) + ((i16 & 3) << 1);
                            artificialFrame = i18 % 128;
                            if (i18 % 2 == 0) {
                                objArr = new Object[3];
                                objArr[0] = new int[0];
                                objArr[1] = new int[1];
                            } else {
                                objArr = new Object[4];
                                objArr[0] = new int[1];
                                objArr[1] = new int[1];
                            }
                            objArr[2] = new int[1];
                            ((int[]) objArr[0])[0] = i;
                            ((int[]) objArr[1])[0] = i;
                            objArr[3] = null;
                            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                            int i19 = ((((~((-313684023) | iElapsedRealtime)) | 269504534) * (-283)) - 61004432) + ((~(iElapsedRealtime | (-44179489))) * 283);
                            int iMediaBrowserCompatMediaBrowserServiceCallbackImpl3 = XmlBuilderException.MediaBrowserCompatMediaBrowserServiceCallbackImpl();
                            int i20 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i21 = ((i20 | 75) << 1) - (i20 ^ 75);
                            artificialFrame = i21 % 128;
                            int i22 = i21 % 2;
                            int i23 = i19 * (-751);
                            int i24 = (i23 << 1) - i23;
                            int i25 = ~i19;
                            int i26 = ~(i25 | ((-1) ^ i25));
                            int i27 = i20 + 43;
                            int i28 = i27 % 128;
                            artificialFrame = i28;
                            if (i27 % 2 == 0) {
                                int i29 = (i24 - (~(1504 / i26))) - 1;
                                int i30 = ((-1) ^ i19) | i19;
                                int i31 = ~((iMediaBrowserCompatMediaBrowserServiceCallbackImpl3 & i30) | (i30 ^ iMediaBrowserCompatMediaBrowserServiceCallbackImpl3));
                                i12 = i29 >> (((i31 | (-1504)) << 1) - (i31 ^ (-1504)));
                            } else {
                                int i32 = i26 * 1504;
                                int i33 = ((-1) ^ i19) | i19;
                                i12 = ((~((iMediaBrowserCompatMediaBrowserServiceCallbackImpl3 & i33) | (i33 ^ iMediaBrowserCompatMediaBrowserServiceCallbackImpl3))) * (-1504)) + (i24 ^ i32) + ((i32 & i24) << 1);
                            }
                            int i34 = 752 * (~(~i19));
                            int i35 = -(-((i12 ^ i34) + ((i12 & i34) << 1)));
                            int i36 = (i2 ^ i35) + ((i35 & i2) << 1);
                            int i37 = (i36 << 13) ^ i36;
                            int i38 = ((i28 | 47) << 1) - (i28 ^ 47);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i38 % 128;
                            if (i38 % 2 != 0) {
                                int i39 = i37 ^ (i37 / 41);
                                int i40 = i39 / 2;
                                ((int[]) objArr[3])[0] = (i39 | i40) & (~(i39 & i40));
                                return objArr;
                            }
                            int i41 = i37 >>> 17;
                            int i42 = ((~i37) & i41) | ((~i41) & i37);
                            int i43 = i42 << 5;
                            ((int[]) objArr[2])[0] = (i42 | i43) & (~(i42 & i43));
                            return objArr;
                        }
                        try {
                            int maximumDrawingCacheSize = ViewConfiguration.getMaximumDrawingCacheSize() >> 24;
                            int i44 = (maximumDrawingCacheSize * 866) - 32832;
                            int i45 = ~maximumDrawingCacheSize;
                            int i46 = ~i;
                            int i47 = -(-(((~((i45 & i46) | (i45 ^ i46))) | (-39)) * (-865)));
                            int i48 = (i44 ^ i47) + ((i44 & i47) << 1) + ((~(maximumDrawingCacheSize | i)) * 865);
                            int i49 = ~(((-39) & i46) | ((-39) ^ i46));
                            int i50 = ~((maximumDrawingCacheSize & i46) | (i46 ^ maximumDrawingCacheSize));
                            int i51 = ((i50 & i49) | (i49 ^ i50)) * 865;
                            Object[] objArr2 = new Object[1];
                            a((i48 & i51) + (i51 | i48), new int[]{-446616861, -47159928, 371097955, 1205982419, -1514510630, 562609450, -861622584, 466369494, 1777717474, -667434137, 1572454102, -884335413, 1327356677, 1758326269, 1818639414, 806499597, -1698108011, -1677325601, -41619429, 662242830}, objArr2);
                            Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
                            int i52 = -(-ExpandableListView.getPackedPositionGroup(0L));
                            Object[] objArr4 = new Object[1];
                            a((i52 ^ 31) + ((i52 & 31) << 1), new int[]{-735410545, -431493177, 504996161, -374120676, 2086860397, -847251591, -1481284301, -287061474, 1355387159, -1560035669, 504996161, -374120676, -436809354, 1676427273, 530754915, -1980722391}, objArr4);
                            String str = (String) objArr4[0];
                            int i53 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i54 = ((i53 | 113) << 1) - (i53 ^ 113);
                            artificialFrame = i54 % 128;
                            int i55 = i54 % 2;
                            try {
                                Object[] objArr5 = new Object[1];
                                a(Process.getGidForName("") + 39, new int[]{-446616861, -47159928, 371097955, 1205982419, -1514510630, 562609450, -861622584, 466369494, 1777717474, -667434137, 1572454102, -884335413, 1327356677, 1758326269, 1818639414, 806499597, -1698108011, -1677325601, -41619429, 662242830}, objArr5);
                                objArr3[0] = Class.forName((String) objArr5[0]).getDeclaredConstructor(String.class).newInstance(str);
                                int scrollBarSize = ViewConfiguration.getScrollBarSize() >> 8;
                                int i56 = ~(((-32) ^ i) | ((-32) & i));
                                int i57 = ((((scrollBarSize * 367) + 11377) + (((scrollBarSize ^ 31) | (scrollBarSize & 31)) * (-366))) - (~(-(-(((scrollBarSize ^ i56) | (i56 & scrollBarSize)) * (-366)))))) - 1;
                                int i58 = ~scrollBarSize;
                                int i59 = ~((i58 ^ 31) | (i58 & 31));
                                int i60 = ((-32) ^ scrollBarSize) | (scrollBarSize & (-32));
                                int i61 = ~((i60 & i) | (i60 ^ i));
                                Object[] objArr6 = new Object[1];
                                a(i57 + (((i61 & i59) | (i59 ^ i61)) * 366), new int[]{1873521562, -803789093, 1355387159, -1560035669, 504996161, -374120676, -436809354, 1676427273, 937498584, -393661206, -2144860218, 1443883365, -99297840, 1562536767, -137163084, -235783632}, objArr6);
                                try {
                                    Object[] objArr7 = {(String) objArr6[0]};
                                    int i62 = -View.resolveSizeAndState(0, 0, 0);
                                    int i63 = i62 * 659;
                                    int i64 = (i63 ^ (-24966)) + ((i63 & (-24966)) << 1);
                                    int i65 = ~i62;
                                    int i66 = (~((i65 ^ 38) | (i65 & 38))) | (~(((-39) ^ i62) | ((-39) & i62)));
                                    int i67 = ~((i62 ^ i) | (i62 & i));
                                    int i68 = -(-((i66 | i67) * (-658)));
                                    int i69 = (i64 & i68) + (i68 | i64);
                                    int i70 = (~((-39) | i62)) * 658;
                                    int i71 = ((i69 | i70) << 1) - (i69 ^ i70);
                                    int i72 = ~((i62 & (-39)) | ((-39) ^ i62));
                                    int i73 = ((i72 & i67) | (i72 ^ i67)) * 658;
                                    Object[] objArr8 = new Object[1];
                                    a((i71 ^ i73) + ((i71 & i73) << 1), new int[]{-446616861, -47159928, 371097955, 1205982419, -1514510630, 562609450, -861622584, 466369494, 1777717474, -667434137, 1572454102, -884335413, 1327356677, 1758326269, 1818639414, 806499597, -1698108011, -1677325601, -41619429, 662242830}, objArr8);
                                    objArr3[1] = Class.forName((String) objArr8[0]).getDeclaredConstructor(String.class).newInstance(objArr7);
                                    try {
                                        Object[] objArr9 = new Object[1];
                                        b(null, new byte[]{-119, -116, -118, -119, -126, -123, -117, -121, -119, -126, -118, -119, -126, -123, -120, -121, -125, -122, -123, -124, -125, -126, -127}, KeyEvent.normalizeMetaState(0) + 127, null, objArr9);
                                        Class<?> cls2 = Class.forName((String) objArr9[0]);
                                        Object[] objArr10 = new Object[1];
                                        b(null, new byte[]{-124, -118, -115, -127, -126, -127, -112, -118, -115, -127, -113, -120, -127, -114, -119, -118, -115}, 127 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))), null, objArr10);
                                        Object objInvoke = cls2.getMethod((String) objArr10[0], null).invoke(context, null);
                                        int i74 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        int i75 = (i74 ^ 65) + ((i74 & 65) << 1);
                                        artificialFrame = i75 % 128;
                                        int i76 = i75 % 2;
                                        int iMediaBrowserCompatMediaBrowserServiceCallbackImpl4 = XmlBuilderException.MediaBrowserCompatMediaBrowserServiceCallbackImpl();
                                        int i77 = ~iMediaBrowserCompatMediaBrowserServiceCallbackImpl4;
                                        int i78 = (~((i77 & 857167919) | (857167919 ^ i77))) | (-866081200);
                                        int i79 = ~((~iMediaBrowserCompatMediaBrowserServiceCallbackImpl4) | 814487947);
                                        int i80 = ((i78 ^ i79) | (i78 & i79)) * 464;
                                        int i81 = ((-1783438261) & i80) + (i80 | (-1783438261));
                                        int i82 = ((-814487948) & iMediaBrowserCompatMediaBrowserServiceCallbackImpl4) | (iMediaBrowserCompatMediaBrowserServiceCallbackImpl4 ^ (-814487948));
                                        int i83 = -(-(((i82 ^ 857167919) | (i82 & 857167919)) * (-464)));
                                        int i84 = (i81 ^ i83) + ((i81 & i83) << 1) + (((~((iMediaBrowserCompatMediaBrowserServiceCallbackImpl4 & 814487947) | (814487947 ^ iMediaBrowserCompatMediaBrowserServiceCallbackImpl4))) | (-866081200)) * 464);
                                        int i85 = ~((1316822975 & i) | (1316822975 ^ i));
                                        int i86 = (((-1333755904) & i85) | ((-1333755904) ^ i85)) * (-814);
                                        int i87 = ((-817948947) ^ i86) + ((i86 & (-817948947)) << 1);
                                        int i88 = ~i;
                                        int i89 = ~(251879759 | i88);
                                        int i90 = (i89 ^ 234946831) | (i89 & 234946831);
                                        int i91 = ((i90 ^ i85) | (i85 & i90)) * 407;
                                        int i92 = ((i87 | i91) << 1) - (i87 ^ i91);
                                        int i93 = ~(((-1316822976) ^ i) | ((-1316822976) & i));
                                        int i94 = (234946831 ^ i93) | (234946831 & i93);
                                        int i95 = ~(((-251879760) ^ i) | ((-251879760) & i));
                                        int i96 = -(-(((i94 ^ i95) | (i95 & i94)) * 407));
                                        try {
                                            if (i84 > ((i92 | i96) << 1) - (i96 ^ i92)) {
                                                bArr = new byte[]{-119, -116, -118, -119, -126, -123, -117, -121, -119, -126, -118, -119, -126, -123, -120, -121, -125, -122, -123, -124, -125, -126, -127};
                                                iIndexOf = TextUtils.indexOf((CharSequence) "", ';', 1);
                                                i3 = 13616;
                                            } else {
                                                bArr = new byte[]{-119, -116, -118, -119, -126, -123, -117, -121, -119, -126, -118, -119, -126, -123, -120, -121, -125, -122, -123, -124, -125, -126, -127};
                                                iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0);
                                                i3 = 128;
                                            }
                                            int i97 = ~i3;
                                            int i98 = (i97 ^ i46) | (i97 & i46);
                                            int i99 = ((((-129) * iIndexOf) + (i3 * 131)) - (~((~((i98 ^ iIndexOf) | (i98 & iIndexOf))) * 130))) - 1;
                                            int i100 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            int i101 = i100 + 1;
                                            artificialFrame = i101 % 128;
                                            if (i101 % 2 == 0) {
                                                int i102 = -(~((i97 & iIndexOf) | (i97 ^ iIndexOf)));
                                                i4 = i99 << ((i102 ^ (-260)) + ((i102 & (-260)) << 1));
                                                int i103 = ~iIndexOf;
                                                i5 = (i103 & i3) | (i103 ^ i3);
                                            } else {
                                                int i104 = ~i3;
                                                int i105 = -(-((~((i104 & iIndexOf) | (i104 ^ iIndexOf))) * (-260)));
                                                i4 = (i99 | i105) + (i99 & i105);
                                                i5 = (~iIndexOf) | i3;
                                            }
                                            int i106 = ~i5;
                                            int i107 = i100 + 121;
                                            artificialFrame = i107 % 128;
                                            int i108 = i107 % 2;
                                            int i109 = (~i3) | iIndexOf;
                                            int i110 = -(-(130 * (i106 | (~((i109 & i) | (i109 ^ i))))));
                                            int i111 = (i4 ^ i110) + ((i4 & i110) << 1);
                                            Object[] objArr11 = new Object[1];
                                            b(null, bArr, i111, null, objArr11);
                                            Class<?> cls3 = Class.forName((String) objArr11[0]);
                                            byte[] bArr2 = {-118, -110, -127, -111, -118, -115, -127, -113, -120, -127, -114, -119, -118, -115};
                                            int gidForName = Process.getGidForName("");
                                            int i112 = artificialFrame + 55;
                                            int i113 = i112 % 128;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i113;
                                            int i114 = i112 % 2;
                                            int i115 = -gidForName;
                                            int i116 = (i115 * (-751)) - 94626;
                                            int i117 = ~i115;
                                            int i118 = ~(i117 | (-127));
                                            int i119 = ~(i117 | i);
                                            int i120 = -(-(((i118 ^ i119) | (i119 & i118)) * 1504));
                                            int i121 = (i116 & i120) + (i120 | i116);
                                            int i122 = i113 + 31;
                                            artificialFrame = i122 % 128;
                                            int i123 = i122 % 2;
                                            int i124 = -(-((-1504) * (~((i115 ^ (-1)) | WebSocketProtocol.PAYLOAD_SHORT | i))));
                                            int i125 = (i121 & i124) + (i124 | i121);
                                            int i126 = ~(i117 | WebSocketProtocol.PAYLOAD_SHORT);
                                            int i127 = (i113 & 51) + (i113 | 51);
                                            artificialFrame = i127 % 128;
                                            int i128 = i127 % 2;
                                            int i129 = (i125 - (~(-(-(752 * (i126 | (~((i115 & (-127)) | ((-127) ^ i115))))))))) - 1;
                                            Object[] objArr12 = new Object[1];
                                            b(null, bArr2, i129, null, objArr12);
                                            try {
                                                Object[] objArr13 = {cls3.getMethod((String) objArr12[0], null).invoke(context, null), 64};
                                                byte[] bArr3 = {-124, -118, -115, -127, -126, -127, -112, -118, -115, -127, -113, -120, -127, -114, -121, -110, -109, -121, -119, -126, -118, -119, -126, -123, -120, -121, -125, -122, -123, -124, -125, -126, -127};
                                                float maxVolume = AudioTrack.getMaxVolume();
                                                int i130 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                int i131 = ((i130 | 13) << 1) - (i130 ^ 13);
                                                artificialFrame = i131 % 128;
                                                float f = 0.0f;
                                                int i132 = (maxVolume > 0.0f ? 1 : (maxVolume == 0.0f ? 0 : -1));
                                                if (i131 % 2 == 0) {
                                                    int i133 = ((i132 | 128) << 1) - (i132 ^ 128);
                                                    Object[] objArr14 = new Object[1];
                                                    b(null, bArr3, i133, null, objArr14);
                                                    cls = Class.forName((String) objArr14[0]);
                                                    i6 = -(TypedValue.complexToFloat(1) > 1.0f ? 1 : (TypedValue.complexToFloat(1) == 1.0f ? 0 : -1));
                                                    iMediaBrowserCompatMediaBrowserServiceCallbackImpl = XmlBuilderException.MediaBrowserCompatMediaBrowserServiceCallbackImpl();
                                                    i7 = 119;
                                                } else {
                                                    Object[] objArr15 = new Object[1];
                                                    b(null, bArr3, 128 - i132, null, objArr15);
                                                    cls = Class.forName((String) objArr15[0]);
                                                    i6 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                                    iMediaBrowserCompatMediaBrowserServiceCallbackImpl = XmlBuilderException.MediaBrowserCompatMediaBrowserServiceCallbackImpl();
                                                    i7 = 14;
                                                }
                                                int i134 = i6 * 866;
                                                int i135 = -(-(i7 * (-864)));
                                                int i136 = ((i134 | i135) << 1) - (i134 ^ i135);
                                                int i137 = ~i7;
                                                int i138 = ~i6;
                                                int i139 = iMediaBrowserCompatMediaBrowserServiceCallbackImpl ^ (-1);
                                                int i140 = ~((i138 ^ i139) | (i138 & i139));
                                                int i141 = -(-((-865) * ((i140 & i137) | (i137 ^ i140))));
                                                int i142 = (i136 & i141) + (i141 | i136);
                                                int i143 = (~((i6 ^ iMediaBrowserCompatMediaBrowserServiceCallbackImpl) | (i6 & iMediaBrowserCompatMediaBrowserServiceCallbackImpl))) * 865;
                                                int i144 = ~iMediaBrowserCompatMediaBrowserServiceCallbackImpl;
                                                int i145 = ~((i137 & i144) | (i137 ^ i144));
                                                int i146 = ~(i6 | i144);
                                                int i147 = i145 ^ i146;
                                                Object[] objArr16 = new Object[1];
                                                a((i142 ^ i143) + ((i143 & i142) << 1) + (((i146 & i145) | i147) * 865), new int[]{1877782987, -1973369517, 484975719, 704659140, -982277258, -1295506097, 2124082078, -1327323325}, objArr16);
                                                Object objInvoke2 = cls.getMethod((String) objArr16[0], String.class, Integer.TYPE).invoke(objInvoke, objArr13);
                                                byte[] bArr4 = {-123, -107, -126, -108, -118, -115, -127, -113, -120, -127, -114, -121, -110, -109, -121, -119, -126, -118, -119, -126, -123, -120, -121, -125, -122, -123, -124, -125, -126, -127};
                                                int bitsPerPixel = ImageFormat.getBitsPerPixel(0);
                                                int i148 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
                                                artificialFrame = i148 % 128;
                                                if (i148 % 2 == 0) {
                                                    Object[] objArr17 = new Object[1];
                                                    b(null, bArr4, 126 - bitsPerPixel, null, objArr17);
                                                    Class<?> cls4 = Class.forName((String) objArr17[0]);
                                                    Object[] objArr18 = new Object[1];
                                                    b(null, new byte[]{-106, -118, -124, -105, -119, -127, -126, -115, -122, -106}, 13 / View.getDefaultSize(1, 0), null, objArr18);
                                                    field = cls4.getField((String) objArr18[0]);
                                                } else {
                                                    Object[] objArr19 = new Object[1];
                                                    b(null, bArr4, 126 - bitsPerPixel, null, objArr19);
                                                    Class<?> cls5 = Class.forName((String) objArr19[0]);
                                                    int i149 = -View.getDefaultSize(0, 0);
                                                    int i150 = (i149 ^ 127) + ((i149 & 127) << 1);
                                                    Object[] objArr20 = new Object[1];
                                                    b(null, new byte[]{-106, -118, -124, -105, -119, -127, -126, -115, -122, -106}, i150, null, objArr20);
                                                    field = cls5.getField((String) objArr20[0]);
                                                }
                                                Object[] objArr21 = (Object[]) field.get(objInvoke2);
                                                int length = objArr21.length;
                                                int i151 = artificialFrame;
                                                int i152 = (i151 & 11) + (i151 | 11);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i152 % 128;
                                                int i153 = i152 % 2;
                                                int i154 = 0;
                                                while (i154 < length) {
                                                    Object obj = objArr21[i154];
                                                    byte[] bArr5 = {-101, -102, -103, -121, -104};
                                                    float minVolume = AudioTrack.getMinVolume();
                                                    int i155 = artificialFrame + 23;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i155 % 128;
                                                    if (i155 % 2 != 0) {
                                                        i8 = -(minVolume > 2.0f ? 1 : (minVolume == 2.0f ? 0 : -1));
                                                        iMediaBrowserCompatMediaBrowserServiceCallbackImpl2 = XmlBuilderException.MediaBrowserCompatMediaBrowserServiceCallbackImpl();
                                                    } else {
                                                        i8 = -(minVolume > f ? 1 : (minVolume == f ? 0 : -1));
                                                        iMediaBrowserCompatMediaBrowserServiceCallbackImpl2 = XmlBuilderException.MediaBrowserCompatMediaBrowserServiceCallbackImpl();
                                                    }
                                                    int i156 = -(-(i8 * 306));
                                                    int i157 = ((610 & i156) + (i156 | TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS)) - (-38862);
                                                    int i158 = artificialFrame + 89;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i158 % 128;
                                                    if (i158 % 2 != 0) {
                                                        Object obj2 = null;
                                                        obj2.hashCode();
                                                        throw null;
                                                    }
                                                    int i159 = ~(i8 | 127);
                                                    int i160 = ~((i8 ^ iMediaBrowserCompatMediaBrowserServiceCallbackImpl2) | (i8 & iMediaBrowserCompatMediaBrowserServiceCallbackImpl2));
                                                    int i161 = 305 * ((i159 ^ i160) | (i159 & i160));
                                                    int i162 = (i157 ^ i161) + ((i157 & i161) << 1);
                                                    int i163 = ((~(i8 | (~iMediaBrowserCompatMediaBrowserServiceCallbackImpl2))) | (-128)) * 305;
                                                    int i164 = (i162 & i163) + (i163 | i162);
                                                    Object[] objArr22 = new Object[1];
                                                    b(null, bArr5, i164, null, objArr22);
                                                    try {
                                                        Object[] objArr23 = {(String) objArr22[0]};
                                                        int i165 = -(PointF.length(f, f) > f ? 1 : (PointF.length(f, f) == f ? 0 : -1));
                                                        Object[] objArr24 = new Object[1];
                                                        a(((i165 | 37) << 1) - (i165 ^ 37), new int[]{-446616861, -47159928, 91565014, 228760254, -340989735, -397886984, -49817612, 801849931, -1803339915, 805665342, 1892775069, -2015058584, 1328765285, 645173332, 1665568260, 134841061, -1323076344, 765039229, -449363616, 1879054735}, objArr24);
                                                        Class<?> cls6 = Class.forName((String) objArr24[0]);
                                                        int pressedStateDuration = ViewConfiguration.getPressedStateDuration() >> 16;
                                                        int iMediaBrowserCompatMediaBrowserServiceCallbackImpl5 = XmlBuilderException.MediaBrowserCompatMediaBrowserServiceCallbackImpl();
                                                        int i166 = pressedStateDuration * 375;
                                                        int i167 = (i166 ^ (-94869)) + ((i166 & (-94869)) << 1);
                                                        int i168 = ~pressedStateDuration;
                                                        Object[] objArr25 = objArr21;
                                                        int i169 = ~(i168 | 127);
                                                        int i170 = length;
                                                        int i171 = ~((~iMediaBrowserCompatMediaBrowserServiceCallbackImpl5) | pressedStateDuration);
                                                        int i172 = -(-(((i169 ^ i171) | (i169 & i171)) * (-374)));
                                                        int i173 = (i167 & i172) + (i167 | i172);
                                                        int i174 = -(-((~(((-128) ^ pressedStateDuration) | ((-128) & pressedStateDuration))) * 748));
                                                        int i175 = ((i173 | i174) << 1) - (i174 ^ i173);
                                                        int i176 = ~((i168 ^ (-128)) | (i168 & (-128)));
                                                        int i177 = ~iMediaBrowserCompatMediaBrowserServiceCallbackImpl5;
                                                        int i178 = -(-((i176 | (~((i177 & pressedStateDuration) | (i177 ^ pressedStateDuration)))) * 374));
                                                        int i179 = (i175 & i178) + (i175 | i178);
                                                        Object[] objArr26 = new Object[1];
                                                        b(null, new byte[]{-118, -120, -126, -127, -119, -106, -126, -108, -119, -118, -115}, i179, null, objArr26);
                                                        Object objInvoke3 = cls6.getMethod((String) objArr26[0], String.class).invoke(null, objArr23);
                                                        try {
                                                            byte[] bArr6 = {-118, -124, -105, -119, -127, -126, -115, -122, -100, -121, -110, -109, -121, -119, -126, -118, -119, -126, -123, -120, -121, -125, -122, -123, -124, -125, -126, -127};
                                                            int i180 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                                            int i181 = i180 * 236;
                                                            int i182 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                            int i183 = ((i182 | 37) << 1) - (i182 ^ 37);
                                                            artificialFrame = i183 % 128;
                                                            if (i183 % 2 == 0) {
                                                                i9 = i181 + 60288;
                                                                int i184 = ~i180;
                                                                i10 = i184 ^ i46;
                                                                i11 = i184 & i46;
                                                            } else {
                                                                i9 = ((i181 | 60288) << 1) - (i181 ^ 60288);
                                                                int i185 = ~i180;
                                                                i10 = i185 ^ i88;
                                                                i11 = i185 & i88;
                                                            }
                                                            int i186 = ~(i11 | i10);
                                                            int i187 = i9 + ((-235) * ((i186 ^ 128) | (i186 & 128)));
                                                            int i188 = ~i180;
                                                            int i189 = ~((i188 ^ i) | (i188 & i));
                                                            int i190 = i154;
                                                            int i191 = (i182 ^ 47) + ((i182 & 47) << 1);
                                                            artificialFrame = i191 % 128;
                                                            int i192 = i191 % 2;
                                                            int i193 = i187 + (((i189 & 128) | (i189 ^ 128)) * (-470));
                                                            int i194 = ((~((i180 & (-129)) | ((-129) ^ i180))) | (~(i188 | 128 | i))) * 235;
                                                            Object[] objArr27 = new Object[1];
                                                            b(null, bArr6, (i193 & i194) + (i193 | i194), null, objArr27);
                                                            Class<?> cls7 = Class.forName((String) objArr27[0]);
                                                            int i195 = -(-TextUtils.lastIndexOf("", '0'));
                                                            Object[] objArr28 = new Object[1];
                                                            a((i195 & 12) + (i195 | 12), new int[]{-736660070, -691997432, -1355698969, -111359632, 1218293463, -1096209118}, objArr28);
                                                            try {
                                                                Object[] objArr29 = {new ByteArrayInputStream((byte[]) cls7.getMethod((String) objArr28[0], null).invoke(obj, null))};
                                                                f = 0.0f;
                                                                int i196 = -(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                                int iMediaBrowserCompatMediaBrowserServiceCallbackImpl6 = XmlBuilderException.MediaBrowserCompatMediaBrowserServiceCallbackImpl();
                                                                int i197 = (i196 * (-949)) - 35113;
                                                                int i198 = ~iMediaBrowserCompatMediaBrowserServiceCallbackImpl6;
                                                                int i199 = ~((-38) | i198);
                                                                int i200 = ~((~i196) | iMediaBrowserCompatMediaBrowserServiceCallbackImpl6);
                                                                int i201 = -(-(((i199 ^ i200) | (i199 & i200)) * 1900));
                                                                int i202 = ((i197 | i201) << 1) - (i197 ^ i201);
                                                                int i203 = ~((i198 ^ i196) | (i198 & i196));
                                                                int i204 = ~((iMediaBrowserCompatMediaBrowserServiceCallbackImpl6 ^ 37) | (iMediaBrowserCompatMediaBrowserServiceCallbackImpl6 & 37));
                                                                int i205 = -(-(((i203 ^ i204) | (i203 & i204)) * (-950)));
                                                                int i206 = (i202 ^ i205) + ((i205 & i202) << 1);
                                                                int i207 = ~((i198 ^ 37) | (i198 & 37));
                                                                int i208 = ~(i196 | iMediaBrowserCompatMediaBrowserServiceCallbackImpl6);
                                                                int i209 = i207 ^ i208;
                                                                Object[] objArr30 = new Object[1];
                                                                a(i206 + (((i208 & i207) | i209) * 950), new int[]{-446616861, -47159928, 91565014, 228760254, -340989735, -397886984, -49817612, 801849931, -1803339915, 805665342, 1892775069, -2015058584, 1328765285, 645173332, 1665568260, 134841061, -1323076344, 765039229, -449363616, 1879054735}, objArr30);
                                                                Class<?> cls8 = Class.forName((String) objArr30[0]);
                                                                int i210 = -MotionEvent.axisFromString("");
                                                                Object[] objArr31 = new Object[1];
                                                                a((i210 ^ 18) + ((i210 & 18) << 1), new int[]{-1667522944, -239096581, -1581291578, -1192561427, -138802160, 2016667863, 1565092827, 178478059, -163081150, -208389337}, objArr31);
                                                                Object objInvoke4 = cls8.getMethod((String) objArr31[0], InputStream.class).invoke(objInvoke3, objArr29);
                                                                int length2 = objArr3.length;
                                                                int i211 = artificialFrame + 119;
                                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i211 % 128;
                                                                int i212 = i211 % 2;
                                                                int i213 = 0;
                                                                for (int i214 = 2; i213 < i214; i214 = 2) {
                                                                    Object obj3 = objArr3[i213];
                                                                    int i215 = artificialFrame + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i215 % 128;
                                                                    int i216 = i215 % i214;
                                                                    try {
                                                                        Object[] objArr32 = new Object[1];
                                                                        b(null, new byte[]{-118, -119, -127, -120, -122, -107, -122, -119, -124, -118, -117, -101, -102, -103, -104, -121, -119, -124, -118, -120, -121, -97, -119, -122, -124, -105, -120, -118, -106, -121, -127, -98, -127, -99}, TextUtils.getCapsMode("", 0, 0) + 127, null, objArr32);
                                                                        Class<?> cls9 = Class.forName((String) objArr32[0]);
                                                                        int i217 = -(-(ViewConfiguration.getJumpTapTimeout() >> 16));
                                                                        int i218 = (i217 ^ 127) + ((i217 & 127) << 1);
                                                                        Object[] objArr33 = new Object[1];
                                                                        b(null, new byte[]{-95, -127, -109, -122, -120, -126, -122, -124, -114, -102, -102, -103, -104, -119, -120, -118, -99, -96, -105, -100, -119, -118, -115}, i218, null, objArr33);
                                                                        if (obj3.equals(cls9.getMethod((String) objArr33[0], null).invoke(objInvoke4, null))) {
                                                                            XmlBuilderException.MediaBrowserCompatMediaBrowserServiceCallbackImpl();
                                                                            Object[] objArr34 = {new int[]{i}, new int[]{(i & (-2)) | (i46 & 1)}, new int[1], null};
                                                                            int i219 = (int) Runtime.getRuntime().totalMemory();
                                                                            int i220 = (-872584314) + ((~((~i219) | 804519935)) * (-116)) + ((728940479 | i219) * 116) + (((~(i219 | (-249683296))) | 174103839) * 116);
                                                                            int iMediaBrowserCompatMediaBrowserServiceCallbackImpl7 = XmlBuilderException.MediaBrowserCompatMediaBrowserServiceCallbackImpl();
                                                                            int i221 = ~iMediaBrowserCompatMediaBrowserServiceCallbackImpl7;
                                                                            int i222 = ~i220;
                                                                            int i223 = ~(((-17) ^ i222) | ((-17) & i222));
                                                                            int i224 = (-10576) + (i220 * (-661)) + (((i221 & i223) | (i221 ^ i223)) * 1324);
                                                                            int i225 = ~((iMediaBrowserCompatMediaBrowserServiceCallbackImpl7 ^ 16) | (iMediaBrowserCompatMediaBrowserServiceCallbackImpl7 & 16));
                                                                            int i226 = ~(iMediaBrowserCompatMediaBrowserServiceCallbackImpl7 | i220);
                                                                            int i227 = -(-(((i226 & i225) | (i225 ^ i226)) * (-1324)));
                                                                            int i228 = (i224 & i227) + (i227 | i224);
                                                                            int i229 = ~(((-17) ^ i220) | (i220 & (-17)));
                                                                            int i230 = ~(i222 | 16);
                                                                            int i231 = -(-(((i229 & i230) | (i229 ^ i230)) * 662));
                                                                            int i232 = ((i228 | i231) << 1) - (i231 ^ i228);
                                                                            int i233 = (((i232 * 141) - (~(i2 * (-279)))) - 1) + (((i2 ^ i) | (i2 & i)) * 140);
                                                                            int i234 = ~i232;
                                                                            int i235 = ~((i234 & i2) | (i234 ^ i2));
                                                                            int i236 = ~((i46 ^ i2) | (i46 & i2));
                                                                            int i237 = i233 + (((i235 & i236) | (i235 ^ i236)) * (-280));
                                                                            int i238 = ~i2;
                                                                            int i239 = ~((i238 & i232) | (i238 ^ i232));
                                                                            int i240 = ~(i88 | i232);
                                                                            int i241 = (i239 & i240) | (i239 ^ i240);
                                                                            int i242 = (~i232) | i2;
                                                                            int i243 = ~((i242 & i) | (i242 ^ i));
                                                                            int i244 = i237 + (((i241 & i243) | (i241 ^ i243)) * 140);
                                                                            int i245 = i244 << 13;
                                                                            int i246 = (i244 | i245) & (~(i244 & i245));
                                                                            int i247 = i246 ^ (i246 >>> 17);
                                                                            int i248 = i247 << 5;
                                                                            ((int[]) objArr34[2])[0] = (i247 | i248) & (~(i247 & i248));
                                                                            return objArr34;
                                                                        }
                                                                        i213++;
                                                                    } catch (Throwable th) {
                                                                        Throwable cause = th.getCause();
                                                                        if (cause != null) {
                                                                            throw cause;
                                                                        }
                                                                        throw th;
                                                                    }
                                                                }
                                                                int i249 = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
                                                                artificialFrame = i249 % 128;
                                                                int i250 = i249 % 2;
                                                                i154 = (i190 & 1) + (i190 | 1);
                                                                objArr21 = objArr25;
                                                                length = i170;
                                                            } catch (Throwable th2) {
                                                                Throwable cause2 = th2.getCause();
                                                                if (cause2 != null) {
                                                                    throw cause2;
                                                                }
                                                                throw th2;
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
                        }
                        Object[] objArr35 = {new int[]{i}, new int[]{i}, new int[1], null};
                        int startUptimeMillis = (int) Process.getStartUptimeMillis();
                        int i251 = ~startUptimeMillis;
                        int i252 = (-633692790) + (((~((-349352070) | i251)) | (-629271706)) * (-865)) + ((~(startUptimeMillis | 349352069)) * 865) + (((~((-629271706) | i251)) | (~(i251 | 349352069))) * 865);
                        int i253 = (-1) - (~(i252 * (-858)));
                        int i254 = i * (-859);
                        int i255 = (i253 ^ i254) + ((i254 & i253) << 1);
                        int i256 = ~(~i);
                        int i257 = ~i252;
                        int i258 = ((-1) ^ i257) | i257;
                        int i259 = ~((i258 & i) | (i258 ^ i));
                        int i260 = (i255 - (~(-(-(((i256 & i259) | (i256 ^ i259)) * 859))))) - 1;
                        int i261 = ~i;
                        int i262 = ~((i261 & i257) | (i257 ^ i261));
                        int i263 = ~i257;
                        int i264 = (i260 - (~(((i262 & i263) | (i262 ^ i263)) * 859))) - 1;
                        int i265 = (i2 ^ i264) + ((i2 & i264) << 1);
                        int i266 = i265 << 13;
                        int i267 = (i266 & (~i265)) | ((~i266) & i265);
                        int i268 = i267 >>> 17;
                        int i269 = (i267 | i268) & (~(i267 & i268));
                        int i270 = i269 << 5;
                        ((int[]) objArr35[2])[0] = ((~i269) & i270) | ((~i270) & i269);
                        return objArr35;
                    }
                });
                hashSet.add(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
        synchronized (this.stickyBehaviors) {
            for (final BehaviorType behaviorType2 : behaviorTypes) {
                if (behaviorType2.getSticky$sfmcsdk_release() && (bundle = this.stickyBehaviors.get(behaviorType2)) != null) {
                    ExecutorService executorService = this.executorService;
                    Set of = SetsKt__SetsJVMKt.setOf(listener);
                    Intrinsics.checkNotNull(behaviorType2);
                    executorService.submit(new Companion.BehaviorRunnable(of, behaviorType2, bundle));
                    SFMCSdkLogger.INSTANCE.d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManagerImpl$registerForBehaviors$2$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Delivering sticky behavior " + behaviorType2 + " to " + listener;
                        }
                    });
                }
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManager
    public void unregisterForAllBehaviors(@NotNull final BehaviorListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.behaviorTypeListeners) {
            SFMCSdkLogger.INSTANCE.d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManagerImpl$unregisterForAllBehaviors$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unregistering " + listener + " for all behaviors.";
                }
            });
            Set<Map.Entry<BehaviorType, Set<BehaviorListener>>> setEntrySet = this.behaviorTypeListeners.entrySet();
            Intrinsics.checkNotNullExpressionValue(setEntrySet, "<get-entries>(...)");
            Iterator<T> it2 = setEntrySet.iterator();
            while (it2.hasNext()) {
                ((Set) ((Map.Entry) it2.next()).getValue()).remove(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBehavior(final BehaviorType behaviorType, final Bundle bundle) {
        bundle.putLong("timestamp", System.currentTimeMillis());
        synchronized (this.behaviorTypeListeners) {
            Set<BehaviorListener> set = this.behaviorTypeListeners.get(behaviorType);
            if (set != null) {
                Intrinsics.checkNotNull(set);
                if (!set.isEmpty()) {
                    try {
                        this.executorService.submit(new Companion.BehaviorRunnable(set, behaviorType, bundle));
                    } catch (Exception e) {
                        SFMCSdkLogger.INSTANCE.e(TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManagerImpl$onBehavior$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "BehaviorRunnable failed for " + behaviorType + " with " + bundle;
                            }
                        });
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        synchronized (this.stickyBehaviors) {
            List<BehaviorType> behaviorTypesToClear$sfmcsdk_release = behaviorType.getBehaviorTypesToClear$sfmcsdk_release();
            if (behaviorTypesToClear$sfmcsdk_release != null) {
                Iterator<T> it2 = behaviorTypesToClear$sfmcsdk_release.iterator();
                while (it2.hasNext()) {
                    this.stickyBehaviors.put((BehaviorType) it2.next(), null);
                }
            }
            if (behaviorType.getSticky$sfmcsdk_release()) {
                this.stickyBehaviors.put(behaviorType, bundle);
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final BehaviorManager initIfNecessary$sfmcsdk_release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.context == null) {
            this.context = context;
        }
        if (this.behaviorReceiver == null) {
            SFMCSdkLogger.INSTANCE.d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManagerImpl$initIfNecessary$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "BehaviorManager initializing.";
                }
            });
            BehaviorReceiver behaviorReceiver = new BehaviorReceiver();
            this.behaviorReceiver = behaviorReceiver;
            IntentFilter intentFilter = new IntentFilter();
            Iterator<BehaviorType> it2 = BehaviorType.getEntries().iterator();
            while (it2.hasNext()) {
                intentFilter.addAction(it2.next().getIntentFilter$sfmcsdk_release());
            }
            Unit unit = Unit.INSTANCE;
            ContextCompat.registerReceiver(context, behaviorReceiver, intentFilter, 4);
            SharedPreferences sharedPreferences = context.getSharedPreferences(FileUtilsKt.getFilenamePrefixForSFMCSdk("default"), 0);
            String string = sharedPreferences.getString(KEY_PREFS_CAPTURED_APP_VERSION, null);
            String applicationVersion = ApplicationUtils.getApplicationVersion(context);
            if (!Intrinsics.areEqual(applicationVersion, string) && applicationVersion != null) {
                sharedPreferences.edit().putString(KEY_PREFS_CAPTURED_APP_VERSION, applicationVersion).apply();
                Companion companion = Companion;
                BehaviorType behaviorType = BehaviorType.APP_VERSION_CHANGED;
                Bundle bundle = new Bundle();
                bundle.putString(BUNDLE_KEY_PREVIOUS_VERSION, string);
                Unit unit2 = Unit.INSTANCE;
                companion.notifyBehavior$sfmcsdk_release(context, behaviorType, bundle);
            }
        }
        return this;
    }

    public final void tearDown$sfmcsdk_release() {
        BehaviorReceiver behaviorReceiver;
        Context context = this.context;
        if (context == null || (behaviorReceiver = this.behaviorReceiver) == null) {
            return;
        }
        context.unregisterReceiver(behaviorReceiver);
    }

    final class BehaviorReceiver extends BroadcastReceiver {
        public BehaviorReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable final Intent intent) {
            if (intent != null) {
                BehaviorManagerImpl behaviorManagerImpl = BehaviorManagerImpl.this;
                String action = intent.getAction();
                if (action != null) {
                    final BehaviorType behaviorTypeFromString = BehaviorType.Companion.fromString(action);
                    if (behaviorTypeFromString != null) {
                        SFMCSdkLogger.INSTANCE.d(BehaviorManagerImpl.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManagerImpl$BehaviorReceiver$onReceive$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return behaviorTypeFromString + " received with " + intent.getExtras() + " extras.";
                            }
                        });
                        Bundle extras = intent.getExtras();
                        if (extras == null) {
                            extras = new Bundle();
                        }
                        Intrinsics.checkNotNull(extras);
                        behaviorManagerImpl.onBehavior(behaviorTypeFromString, extras);
                        return;
                    }
                    SFMCSdkLogger.INSTANCE.w(BehaviorManagerImpl.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManagerImpl$BehaviorReceiver$onReceive$1$1$2
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "An unknown behavior was received.";
                        }
                    });
                }
            }
        }
    }
}
