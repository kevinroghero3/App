package io.invertase.firebase.analytics;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import javax.annotation.Nullable;
import o.ArtificialStackFrames;
import o._CREATION;
import okio.Utf8;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes3.dex */
public class ReactNativeFirebaseAnalyticsModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "Analytics";
    private final UniversalFirebaseAnalyticsModule module;

    ReactNativeFirebaseAnalyticsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
        this.module = new UniversalFirebaseAnalyticsModule(reactApplicationContext, SERVICE_NAME);
    }

    @ReactMethod
    public void logEvent(String str, @Nullable ReadableMap readableMap, final Promise promise) {
        this.module.logEvent(str, toBundle(readableMap)).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$logEvent$0(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$logEvent$0(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setAnalyticsCollectionEnabled(Boolean bool, final Promise promise) {
        this.module.setAnalyticsCollectionEnabled(bool).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setAnalyticsCollectionEnabled$1(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setAnalyticsCollectionEnabled$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setSessionTimeoutDuration(double d, final Promise promise) {
        this.module.setSessionTimeoutDuration((long) d).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda8
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setSessionTimeoutDuration$2(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setSessionTimeoutDuration$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void getAppInstanceId(final Promise promise) {
        this.module.getAppInstanceId().addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$getAppInstanceId$3(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getAppInstanceId$3(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void getSessionId(final Promise promise) {
        this.module.getSessionId().addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$getSessionId$4(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getSessionId$4(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Long l = (Long) task.getResult();
            promise.resolve(l != null ? Double.valueOf(l.doubleValue()) : null);
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setUserId(String str, final Promise promise) {
        this.module.setUserId(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda9
            private static final byte[] $$c = {34, -105, 53, -7};
            private static final int $$d = 231;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {67, 111, Ascii.EM, 19, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, 50, Ascii.SO, -50, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4};
            private static final int $$b = 61;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static char[] _CREATION = {6559, 59111, 59252, 59369, 58445, 58564, 58704, 58769, 57893, 58046, 58166, 58263, 57359, 57499, 57608, 60969, 61133, 61302, 61390, 60511, 60631, 60741, 60848, 6553, 59116, 59236, 59354, 58450, 58589, 58712, 58838, 57893, 58032, 58156, 58250, 57349, 57499, 57653, 61033, 61160, 61302, 6559, 59111, 59252, 59369, 58445, 58564, 58704, 58769, 57893, 58046, 58166, 58263, 57359, 57499, 57608, 60969, 61182, 61300, 61326, 60522, 60610, 60749, 60840, 59942, 60085, 60160, 60316, 59418, 59541, 59883, 63045, 63225, 63352, 63430, 60418, 4991, 4843, 4710, 4555, 8024, 57445, 57837, 57713, 57988, 57933, 58323, 58207, 58555, 58487, 58813, 58630, 59016, 58904, 59352, 59626, 59490, 59890, 59740, 60101, 59996, 60373, 60207, 60586, 60474, 60870, 60691, 61081, 6540, 59110, 59198, 59391, 58439, 58575, 58689, 58840, 57889, 58032, 58170, 58255, 57359, 25500};
            private static long _BOUNDARY = -3451423862867761527L;

            /* JADX WARN: Code duplicated, block: B:10:0x0023  */
            /* JADX WARN: Code duplicated, block: B:8:0x001d  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0025). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(short r6, short r7, short r8) {
                /*
                    int r7 = r7 * 4
                    int r7 = 4 - r7
                    int r6 = r6 * 3
                    int r6 = r6 + 1
                    int r8 = 106 - r8
                    byte[] r0 = io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda9.$$c
                    byte[] r1 = new byte[r6]
                    r2 = 0
                    if (r0 != 0) goto L15
                    r3 = r8
                    r4 = r2
                    r8 = r6
                    goto L25
                L15:
                    r3 = r2
                L16:
                    int r4 = r3 + 1
                    byte r5 = (byte) r8
                    r1[r3] = r5
                    if (r4 != r6) goto L23
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r1, r2)
                    return r6
                L23:
                    r3 = r0[r7]
                L25:
                    int r8 = r8 + r3
                    int r7 = r7 + 1
                    r3 = r4
                    goto L16
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda9.$$e(short, short, short):java.lang.String");
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0023  */
            /* JADX WARN: Code duplicated, block: B:8:0x001b  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void a(int r6, byte r7, short r8, java.lang.Object[] r9) {
                /*
                    byte[] r0 = io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda9.$$a
                    int r8 = 28 - r8
                    int r7 = 52 - r7
                    int r6 = r6 + 66
                    byte[] r1 = new byte[r8]
                    r2 = 0
                    if (r0 != 0) goto L11
                    r3 = r7
                    r6 = r8
                    r4 = r2
                    goto L29
                L11:
                    r3 = r2
                L12:
                    byte r4 = (byte) r6
                    r1[r3] = r4
                    int r7 = r7 + 1
                    int r3 = r3 + 1
                    if (r3 != r8) goto L23
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r1, r2)
                    r9[r2] = r6
                    return
                L23:
                    r4 = r0[r7]
                    r5 = r3
                    r3 = r7
                    r7 = r4
                    r4 = r5
                L29:
                    int r6 = r6 + r7
                    int r6 = r6 + (-5)
                    r7 = r3
                    r3 = r4
                    goto L12
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda9.a(int, byte, short, java.lang.Object[]):void");
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setUserId$5(promise, task);
            }

            private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
                int i3 = 2 % 2;
                _CREATION _creation = new _CREATION();
                long[] jArr = new long[i2];
                _creation.b = 0;
                while (_creation.b < i2) {
                    int i4 = $11 + 93;
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                    int i6 = _creation.b;
                    try {
                        Object[] objArr2 = {Integer.valueOf(_CREATION[i + i6])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 0;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollDefaultDelay() >> 16) + 8, (char) (9279 - KeyEvent.getDeadChar(0, 0)), 1978 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 1113883676, false, $$e(b, b2, (byte) (b2 + 2)), new Class[]{Integer.TYPE});
                        }
                        Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(31 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (49362 - (Process.myTid() >> 22)), 683 - TextUtils.lastIndexOf("", '0', 0), -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                        }
                        jArr[i6] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                        Object[] objArr4 = {_creation, _creation};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            byte b6 = b5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 25, (char) (Color.red(0) + 30068), Gravity.getAbsoluteGravity(0, 0) + 816, 1897803493, false, $$e(b5, b6, (byte) (b6 + 3)), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                char[] cArr = new char[i2];
                _creation.b = 0;
                int i7 = $10 + 37;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                while (_creation.b < i2) {
                    cArr[_creation.b] = (char) jArr[_creation.b];
                    Object[] objArr5 = {_creation, _creation};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = b7;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (30069 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 815 - ImageFormat.getBitsPerPixel(0), 1897803493, false, $$e(b7, b8, (byte) (b8 + 3)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                }
                objArr[0] = new String(cArr);
            }

            /* JADX WARN: Code duplicated, block: B:38:0x05b1  */
            /* JADX WARN: Code duplicated, block: B:40:0x05b7  */
            /* JADX WARN: Code duplicated, block: B:42:0x065c  */
            /* JADX WARN: Code duplicated, block: B:43:0x0677  */
            /* JADX WARN: Code restructure failed: missing block: B:93:0x09bb, code lost:
            
                if (r0 != false) goto L94;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r30, int r31, int r32, int r33) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 2918
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda9.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUserId$5(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setUserProperty(String str, String str2, final Promise promise) {
        this.module.setUserProperty(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setUserProperty$6(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUserProperty$6(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setUserProperties(ReadableMap readableMap, final Promise promise) {
        this.module.setUserProperties(Arguments.toBundle(readableMap)).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda7
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setUserProperties$7(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUserProperties$7(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void resetAnalyticsData(final Promise promise) {
        this.module.resetAnalyticsData().addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$resetAnalyticsData$8(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$resetAnalyticsData$8(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setDefaultEventParameters(@Nullable ReadableMap readableMap, final Promise promise) {
        this.module.setDefaultEventParameters(toBundle(readableMap)).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda6
            private static long _BOUNDARY;
            private static char[] _CREATION;
            private static final byte[] $$c = {84, -77, Utf8.REPLACEMENT_BYTE, -18};
            private static final int $$d = 41;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {52, -20, 7, -120, 3, -46, -10, 53, -16, 6, -21, 0, 4, 1, -16, Ascii.CR, -10, 9, -52, Ascii.SO, 2};
            private static final int $$b = 61;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;

            /* JADX WARN: Code duplicated, block: B:10:0x0026  */
            /* JADX WARN: Code duplicated, block: B:8:0x0020  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(byte r5, byte r6, int r7) {
                /*
                    int r5 = r5 * 4
                    int r0 = 1 - r5
                    byte[] r1 = io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda6.$$c
                    int r7 = 106 - r7
                    int r6 = r6 * 4
                    int r6 = 3 - r6
                    byte[] r0 = new byte[r0]
                    r2 = 0
                    int r5 = 0 - r5
                    if (r1 != 0) goto L16
                    r3 = r5
                    r4 = r2
                    goto L28
                L16:
                    r3 = r2
                L17:
                    int r6 = r6 + 1
                    byte r4 = (byte) r7
                    r0[r3] = r4
                    int r4 = r3 + 1
                    if (r3 != r5) goto L26
                    java.lang.String r5 = new java.lang.String
                    r5.<init>(r0, r2)
                    return r5
                L26:
                    r3 = r1[r6]
                L28:
                    int r3 = -r3
                    int r7 = r7 + r3
                    r3 = r4
                    goto L17
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda6.$$e(byte, byte, int):java.lang.String");
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0025  */
            /* JADX WARN: Code duplicated, block: B:8:0x001d  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void a(int r6, byte r7, int r8, java.lang.Object[] r9) {
                /*
                    int r6 = r6 + 66
                    byte[] r0 = io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda6.$$a
                    int r7 = r7 + 4
                    int r1 = r8 + 2
                    byte[] r1 = new byte[r1]
                    int r8 = r8 + 1
                    r2 = 0
                    if (r0 != 0) goto L13
                    r3 = r7
                    r6 = r8
                    r4 = r2
                    goto L2a
                L13:
                    r3 = r2
                L14:
                    byte r4 = (byte) r6
                    r1[r3] = r4
                    int r7 = r7 + 1
                    int r4 = r3 + 1
                    if (r3 != r8) goto L25
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r1, r2)
                    r9[r2] = r6
                    return
                L25:
                    r3 = r0[r7]
                    r5 = r3
                    r3 = r7
                    r7 = r5
                L2a:
                    int r7 = -r7
                    int r6 = r6 + r7
                    int r6 = r6 + (-1)
                    r7 = r3
                    r3 = r4
                    goto L14
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda6.a(int, byte, int, java.lang.Object[]):void");
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setDefaultEventParameters$9(promise, task);
            }

            private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
                int i3 = 2 % 2;
                _CREATION _creation = new _CREATION();
                long[] jArr = new long[i2];
                _creation.b = 0;
                int i4 = $10 + 93;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                while (_creation.b < i2) {
                    int i6 = _creation.b;
                    try {
                        Object[] objArr2 = {Integer.valueOf(_CREATION[i + i6])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 0;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - TextUtils.indexOf("", "", 0), (char) (9279 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1977, 1113883676, false, $$e(b, b2, (byte) (b2 + 2)), new Class[]{Integer.TYPE});
                        }
                        try {
                            Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                            if (objAccessartificialFrame2 == null) {
                                byte b3 = (byte) 0;
                                byte b4 = b3;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - Color.blue(0), (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 49362), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 683, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                            }
                            jArr[i6] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                            try {
                                Object[] objArr4 = {_creation, _creation};
                                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                                if (objAccessartificialFrame3 == null) {
                                    byte b5 = (byte) 0;
                                    byte b6 = b5;
                                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 24, (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 30068), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 815, 1897803493, false, $$e(b5, b6, (byte) (b6 + 3)), new Class[]{Object.class, Object.class});
                                }
                                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
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
                    } catch (Throwable th3) {
                        Throwable cause3 = th3.getCause();
                        if (cause3 == null) {
                            throw th3;
                        }
                        throw cause3;
                    }
                }
                char[] cArr = new char[i2];
                _creation.b = 0;
                while (_creation.b < i2) {
                    int i7 = $10 + 23;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    cArr[_creation.b] = (char) jArr[_creation.b];
                    try {
                        Object[] objArr5 = {_creation, _creation};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame4 == null) {
                            byte b7 = (byte) 0;
                            byte b8 = b7;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(25 - Color.red(0), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 30067), 816 - KeyEvent.normalizeMetaState(0), 1897803493, false, $$e(b7, b8, (byte) (b8 + 3)), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    } catch (Throwable th4) {
                        Throwable cause4 = th4.getCause();
                        if (cause4 == null) {
                            throw th4;
                        }
                        throw cause4;
                    }
                }
                objArr[0] = new String(cArr);
            }

            static {
                char[] cArr = new char[1959];
                ByteBuffer.wrap("É½qI¸\u0089ãÙ+ARN\u009d\u0087ÄÇ\f\u000e·Cþ\u008d9Ôa\u000e¨~Ó\u0081\u001aÇB\u0006\u008dO4\u0099\u007fÌ§\rîf)\u008bPË\u0098\u001bÃV\n\u0091\u008c\u00864rý²¦ânz\u0017uØ¼\u0081üI5òx»¶|ï$5íE\u0096«_ñ\u0007)Ècq\u0098:àâ5«pl \u0015ôÝ%Ö´n@§\u0080üÐ4HMG\u0082\u008eÛÎ\u0013\u0007¨Já\u0084&Ý~\u0007·wÌ\u009a\u0005Ó]\u0005\u0092W/¸\u0097[^\u0090\u0005ÙÍD´A{\u0082\"Êê\u001aQL\u0018\u0084ß\u008d\u0087\u0004NK5\u0089üÂ¤\u0001kQÒ\u008a\u0099ÒA$\b^Ï\u009c¶Ê~\u000b%Uì\u0083SË\u0019Ñ¡$hô3 û-\u0082!Mã\u0014éÜvg;.çé»\u008d}5\u0088üX§\fo\u0081\u0016\u009aÙA\u0080\u0006H\u0084ó\u0095ºV}\b%ÖÑ°iS \u0085ûÁ3\u0002JV\u0085\u0081Ü\u0089\u00145¯næ¤!Åy\u001d°IË©\u0002ÏZ\u001b\u0095QlØÔ,\u001dèF¾\u008ej÷c8£a\u00ad©\u007f\u00125[è\u009c¬Äe\r+\u009a\u0088\"*ëª°¥xi\u0001.Îô\u0097í_pä(\u00adèj½2aû \u0080ìI\u0094\u0011dÞ0gà,\u0088ôr½?zã\u0003â\u0019\u008c¡.h®3¡ûm\u0082*Mð\u0014éÜtg,.ìé¹±ex$\u0003èÊ\u0090\u0092`]4ää¯\u008cwv>;ùç\u0080åKNó\u00ad:fa/©éÐ¿\u001fvFw\u008eõ5¿|u»{ãù*»Qq\u0098>Àó\u000fà¶|ý#\u0019\u009c¡(hç3\u00adûm\u0082=\u0019Ñ¡2hù3°ûv\u0082 Mé\u0014èÜdg .æéä±dx(\u0003áÊº\u0092X]\u001cä½¯½ww>8ùá\u0080úHu\u00136Úöe¯-hô2¿ð\u0019Ñ¡2hù3°ûv\u0082 Mé\u0014èÜdg .æéä±dx(\u0003áÊº\u0092X]\u001cä½¯£w`>:ùä\u0019Ñ¡2hù3°ûv\u0082 Mé\u0014èÜjg .êéä±fx$\u0003îÊ¡\u0092k]<äå¯\u0085w_>%ùæ\u0080¸Hf\u0013wÚëe´þ£FW\u008f\u0097ÔÇ\u001c_eYª\u0093óØ;\u0001\u0080\\É\u008f\u000eÜV\u000b\u009fK£R\u001bðÒp\u0089\u007fA©8ò÷6®}föÝÿ\u00949Sf\u000b \u0019\u0090¡$há3°ûg\u0082kMê\u0014¢ÜrÙ\u000baë¨(óv;»B°\u008d8Ôt\u001c°§öî!)hq£¸ãÃ3\nxR§\u0004\u0002¼¶u\u007f.$æã\u009f±\u0019¢¡\u0000þØFz\u008fúÔç\u001c$e~ª´óæ;1\u0080iÉò\u000eòV?\u009fwä\u00ad-ýu;ºf\u0003°Hò\u00904Ùd\u001e²¿,\u0007\u0091Î[\u0095\u000f\u0019\u008e¡$hò3°ûk\u00826Mð\u0014éÜug0.ûéå±hx)\u0003¢Ê«\u0092k]3äå¯´w<>2ùä\u0080¢H8\u0013?Úùe°-\u007fô\u0002¿ûF¯\u000ekÉ>\u0090Ò[\u0086ãLª\u0001uÁ<\u0095ÄC\u008f\u001b:\u0095\u0082?Ké\u0010«Øp¡-në7òÿnD+\ràÊþ\u0092s[2 ¹é°±p~(Çþ\u008c¯T'\u001d)Úÿ£¹k#0$ùâF«\u000ed×\u0019\u009càe´-pê%³Íx\u009dÀW\u0089\u001aVÐ\u001f\u008e\u0019\u008e¡$hò3°ûk\u00826Mð\u0014éÜug0.ûéå±hx)\u0003¢Ê«\u0092k]3äå¯´w<>'ùû\u0080ùHu\u0013(ÚñÊ\u0003r©»\u007fà=(æQ»\u009e}Çd\u000fø´½ýv:hbå«¤Ð/\u0019&Aæ\u008e¾7h|9¤±íª*vSt\u009b÷Àµ\tv\u009a{\"Ñë\u0007°Ex\u009e\u0001ÃÎ\u0005\u0097\u001c_\u0080äÅ\u00ad\u000ej\u00102\u009dûÜ\u0080WI^\u0011\u009eÞÆg\u0010,AôÉ½Òz\u000e\u0003\fË\u008e\u0090ÏY\u000e\u0019\u008e¡$hò3°ûk\u00826Mð\u0014éÜug0.ûéå±hx)\u0003¢Ê«\u0092k]3äå¯´w<>'ùû\u0080ùH{\u00137Úû\u0019\u0088¡#hï3»ûq\u0082#êÚR:\u009bùÀ§\bjqa¾âç£/i\u00947Ýï\u001a¥BrO¾÷\u0015>Ùe\u008d\u00adSÔ\u0006\u001b×B\u0082\u008aD\u0019¹¡$hî3ºûo\u0082*Mð\u0014®Üig'\u0019\u008b¡/hë3\u00adûm\u00822Mê\u0019\u009d¡)hò3¬ûo\u0082,Mñ\u0014ª\u0019\u008c¡.h®3³ûp\u0082*Mà\u0014²Üeg=.¦é¯±ox;\u0003åÊ¬\u0092ko\u0010×»\u001ewE#\u008d¢ôë;l\u0019\u0099¡$hî3¦ûp\u0082,Mç\u009b<#\u0081êK±\u0003yÕ\u0000\u0089ÏB\u0096=^ÛåÔ¬\u001b\r\u0089µ4|þ'¶ï`\u0096<Y÷\u0000\u0088Ènsa:®ý\u0084¥,li\u0019\u008c¡.h®3³ûp\u0082*Mà\u0014²Üeg=.¦é¦±ex)\u0003éÊ£\u0019\u008d¡%hë\u0019\u009b¡,hõ3¯ûc\u00821Më\u0014µÍùuw¼¶ç¥/\u0016Vv\u0099¬Àõ\b)³bú«=\u00ade*¬d×¸\u001e©F\u000b\u0089\u007f0¤{ú£9êv\u0019¿¡/hä3±ûm\u0082,Mà\u0014çÜUg\r.Ãéë±hx8\u0003åÊ£\u0092z]qäö¯¼w`>uùì\u0080ïH \u0019¿¡/hä3±ûm\u0082,Mà\u0014çÜUg\r.Ãéë±hx8\u0003åÊ£\u0092z]qäö¯¼w`>uùì\u0080ïH \u0013\u0006Ú®eï\u0019\u008c¡.h®3«ûc\u00827Mà\u0014°Ügg;.í\u0019\u0099¡.hì3§ûd\u0082,M÷\u0014¯\u0019\u0088¡#hï3»û:\u0082sUníÂ$\f\u007fB·\u0088ÎÒ\u0019\u008c¡.h®3³ûp\u0082*Mà\u0014²Üeg=.¦é©±xx,\u0003âÊ«\u0019¼¡\u001eh\u009e3\u0098ûW\u0082\u0007MÚ\u0014\u0092ÜZgW.Éé\u009e±Wx\bæ\u008f\u0083ï;MòÍ©Óa\u0004\u0018E×\u0092\u008eÖF\u0000Á\n\u0019\u008c¡.h®3¡ûw\u0082,Mè\u0014£Ü(g9.úé¤±nx8\u0003ïÊ»\u0019\u0098¡4hì3¯û]\u0082=M¼\u0014ñ\u0019\u008c¡.h®3¡ûw\u0082,Mè\u0014£Ü(g/.áé¥±mx(\u0003þÊ¿\u0092|]8äþ¯§°À\b}Á·\u009aÿR)+uä¾½±u,Ît\u0087º@½\u00184Ñqª»có;%ôaMª\u0019\u0099¡$hî3¦ûp\u0082,Mç\u0014\u0098Ü~gq.¾éä±yx)\u0003çÊ\u0090\u0092v]iä¦¯üwu>0ùú\u0080²Hd\u00130Úûe\u0084-bôe¿ªá&Y\u009b\u0090QË\u0019\u0003Ïz\u0093µXìW$Þ\u009f\u0099ÖX\u0011\u0013IÙ\u0080\u0097ûl2\u0003jÕ¥\u0085\u001c\u0000W\u000b\u008fÈÆ\u0084\u0001Nx\u001a°Àë\u0085\u0019\u0099¡$hî3¦ûp\u0082,Mç\u0014èÜpg+.çé³±2x{\u0003üÊà\u0092x]3äÿ¯«w*>cùä\u0019\u0099¡.hï3¤ûn\u0082 M«\u0014´Übg\".×é¬±zx%\u0003ãÊ¡\u0092k]\u000eäè¯ëw$>zùó\u0080²Hx\u0013<Úêe²-yô\u0002¿äFç\u000e(\u0019\u008c¡.h®3¡ûm\u0082*Mð\u0014«Üig(.ìé®±x\u0096-.\u008fç\u000f¼\u0000tÌ\r\u008bÂQ\u009b\u000fSÊè\u0089¡Nf\u000f>\u0085÷\u008e\u008cXE\u0007\u001dÃÒ\u0094k\u001f \u0014øÚ±\u009avR\u000f\u0013ÇÅ\u009c\u0088UKê\u0013¢Õ{\u0088,¹\u0094)]â\u0006·Îk·*xæ!ìéxRw\u001b¸\u0019\u008c¡.h®3¡ûw\u0082,Mè\u0014£Ü(g-.áé¸±zx!\u0003íÊ¶\u0092 ]8äô\u008fº7\u0014þÃ¥\u0087m\u001f\u0019\u0097¡/hé3·û,\u00826Mò\u0014¤Ü(g8.íé¦±\u007fx`\u0003üÊ½\u0092a]!äãc\nÛ¡\u0012hI3\u0081©ø¨7vnl¦î\u001d\u00adTd\u0093 Ëä\u0002\u00adyp°9\u001a\u001e¢µk|0'ø½\u0081§Ns\u0017xßñd¹-rê?²Ä{¿\u0000|É3\u0091ú^²ç`±p\tÛÀ\u0012\u009bISÓ*Éå\u001d¼\u0016t\u0095ÏÕ\u0086\u0013Ak\u0019\u0091Ð×«\u001dbC:\u0098õÚL\u0016\u0019\u008c¡.h®3¨ûg\u00827Mê\u0014¢Üjgg.éé¥±nx?\u0003ãÊ¦\u0092j]\u007fäá¯¶w\u007f> ùð\u0099Ø!zèú³õ{9\u0002~Í¤\u0094½\\#çx®±iê1pøx\u0083®Jÿ\u0012\u0005Ýkd¥/ê÷#ú B\u0002\u008b\u0082Ð\u0080\u0018Ja\u0004®\u0086÷\u0089?_\u0084\fÍÈ\n\u0083R\b\u009b\u0007àÉ)\u008dqE¾\u0018\u0007ÎL\u008f\u0094LÝ\u0010\u001aÖc\u008f\u0019\u008c¡.h®3³ûp\u0082*Mà\u0014²Üeg=.¦é©±\u007fx$\u0003àÊ«\u0092 ]7äù¯½wu>0ùæ\u0080§Hd\u00130Úöe¯\u0000f¸ÄqD*Zâ\u0091\u009bÜT\u001a\rHÅ\u0081~\u008d7\u0000ðT¨\u0089aË\u001a\u0002Ó\u000b\u008b\u0082DÒý\u0014¶^n\u009d'Íà\u000e\u0099OQ\u0095\nÝÃ\u0006\u0019\u008c¡.h®3°û{\u00826Mð\u0014¢Ükg\u0016.íé³±~xc\u0003îÊº\u0092g]=äô¯ýwt><ùú\u0080°Hs\u0013+Úèe©-sô3¿è\u0019\u008c¡.h®3µûg\u0082+Mà\u0014¨Ütgg.êé¾±cx!\u0003èÊá\u0092h]8äþ¯´ww>'ùä\u0080¥H\u007f\u00137Úì\u0019\u008c¡.h®3µûg\u0082+Mà\u0014¨Ütg\u0016.ìé§±ax \u0003¢Ê\u00ad\u0092{]8äü¯·w<>3ùý\u0080¹Hq\u0013<Úêe«-hô4¿òF«\u0019Ä\u001fW§£nc53ý«\u0084²Kg\u0012,Úõa\u0090(~ï$·ü~®\u0019Ñ¡%hå3µû-\u00826Më\u0014¤Ümg,.üéä±hx,\u0003ÿÊª\u0092l]0äþ¯·wM>2ùñ\u0080¹Ho\u0013=À\txý±=êm\"õ[î\u00943Í|\u0005µ¾ô÷$0<hµ¡ðÚ:\u0013nK²\u008bÞ3*úê¡ºi\"\u00109ßä\u0086«Nbõ#¼ó{ë#tê'\u0091îXµ\u0000e\u0019Ñ¡2hù3°û-\u00824Má\u0014ªÜsg\u0016.üé¹±kx.\u0003é\u0019Ñ¡2hù3°ûv\u0082 Mé\u0014èÜjg .êéä±fx$\u0003îÊ¬\u0092Q]<äñ¯¿w~>:ù÷\u0080\u0088Hr\u0013<Úúe®-}ô\u0002¿íFº\u000esÉ\u0014\u0090\u008e[\u0090ãMþòF\u0006\u008fÆÔ\u0096\u001c\u000ee\u0004ªÔó\u0090;z\u0080\rÉÛ\u000e\u009b\u0093:+Îâ\u000e¹^qÆ\bÌÇ\u001c\u009eXV²íÖ¤\ncM;\u0084\u0019Ñ¡%hå3µû-\u00826Më\u0014¤Ümg,.üéä±hx>\u0003øÊ©\u0092a]=äô¯¶w`>1\"]\u009a¾Su\b<Àú¹¬ve/dçæ\\¬\u0015fÒh\u008aêC¨8bñ!©ñf©ßz\u00940Lò\u0005½Â}»)sÅ(¿áz^>\u0016¸Ï¢\u0084\u007f\u0019Ñ¡%hå3µû-\u0082'M÷\u0014³Ügg*.ëé®\u0019Ñ¡%hå3µû-\u0082'M÷\u0014³Üag0.úé¤\u0019Ñ¡%hå3µû-\u0082'M÷\u0014³Ükg,.ïé¥í¾UJ\u009c\u008aÇÚ\u000fBvH¹\u0098àÜ(\u0006\u0093TÚ\u008e\u001dÁ\u0019Ñ¡%hå3µû-\u0082'M÷\u0014³Üpg$.ûé¬eGÝ³\u0014sO#\u0087»þ±1ah% à\u001b¸R\u007f\u00954Íì\u0004¸\u0084d<\u0090õP®\u0000f\u0098\u001f\u0092ÐB\u0089\u0006Aìú\u0095³Pt\u001b\u0001B¹¶pr+$ãð\u009aùUs\f;Äâ\u007f´6wñ7©ø`º\u001blÒs\u008a³Eºüa·ooã&µás\u0098/\u0019Ñ¡,hî3·û-\u00822Mí\u0014©Übg&.ÿé¸±%x\u000f\u0003ÿÊ»\u0092]]9äñ¯¡ww>1ùÒ\u0080¸Hz\u0013=Úýe©\u0081\r9íð.«pc½\u001a¶Õ1\u008ctDªÿú¶&qc)¥\u0019Î¡'hæ3ãû8\u0019Ñ¡1hò3¬ûa\u0082jM÷\u0014¢Üjg/.§é¦±kx=\u0003ÿ\u0095¿-\u0015äÇ¿\u0089wH\u000e\fÁÁ\u0098ÏPGë\u0000¢Âe\u0089=Jô\u0002\u008fÙF\u0081\u001e\u0006Ñ\u0004hÙ\u0019\u0092¡(hâ3\u0084ûN\u0082\u0000M×\u0014\u0098Üdg:.üéå±yx\"\u0019Ñ¡$hô3 û-\u0082(Má\u0014£Üog(.×é¨±ex)\u0003éÊ¬\u0092}]\u007fäè¯¾w~·@\u000fñÆ)\u009dzU\u00ad,íã9ºxr±Éæ\u0019Ñ¡$hô3 û-\u0082(Më\u0014²Ühg=.ûèÌP8\u0099üÂª\n~sw¼ýåµ-l\u0096:ßù\u0018¹@v\u00894òâ;ýc=¬(\u0015ý^á\u0086nÏ8\bùq¹¹%â<+è\u0094ª\u0019Ñ¡1hò3¬ûa\u0082jMç\u0014·Üsg .æé\u00ad±e\u001b½£*jè1£ù`\u0080(Oó\u0016«\u0019Ñ¡%há3·ûc\u0082jMé\u0014®Üug*.§é»±xx\"\u0003êÊ¦\u0092b]4äã¯üwq> ùæ\u0080øH&\u0013vÚûe´-wôs¿ñF¶\u000e}É\u0013\u0090Ï[\u0095ãKª\u0017uÐ<ÉÄK\u008f\fVÅ\u0011\u009eÙC`\u0000+É".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
                _CREATION = cArr;
                _BOUNDARY = -1674224099080822463L;
            }

            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r74, int r75, int r76, int r77) {
                /*
                    Method dump skipped, instruction units count: 15617
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda6.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setDefaultEventParameters$9(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setConsent(ReadableMap readableMap, Promise promise) {
        this.module.setConsent(Arguments.toBundle(readableMap)).addOnCompleteListener(new ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda1(promise));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setConsent$10(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    private Bundle toBundle(ReadableMap readableMap) {
        Bundle bundle = Arguments.toBundle(readableMap);
        if (bundle == null) {
            return null;
        }
        ArrayList arrayList = (ArrayList) bundle.getSerializable("items");
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        for (Object obj : arrayList) {
            if (obj instanceof Bundle) {
                Bundle bundle2 = (Bundle) obj;
                if (bundle2.containsKey("quantity")) {
                    bundle2.putInt("quantity", (int) bundle2.getDouble("quantity"));
                }
            }
        }
        if (bundle.containsKey(FirebaseAnalytics.Param.EXTEND_SESSION)) {
            bundle.putLong(FirebaseAnalytics.Param.EXTEND_SESSION, (long) bundle.getDouble(FirebaseAnalytics.Param.EXTEND_SESSION));
        }
        return bundle;
    }
}
