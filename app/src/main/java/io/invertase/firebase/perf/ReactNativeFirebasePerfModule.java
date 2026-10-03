package io.invertase.firebase.perf;

import android.app.Activity;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Ascii;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.lang.reflect.Method;
import java.util.Map;
import o.ArtificialStackFrames;
import o.build;

/* JADX INFO: loaded from: classes.dex */
public class ReactNativeFirebasePerfModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "Perf";
    private final UniversalFirebasePerfModule module;

    ReactNativeFirebasePerfModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
        this.module = new UniversalFirebasePerfModule(reactApplicationContext, SERVICE_NAME);
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        this.module.onTearDown();
    }

    @ReactMethod
    public void setPerformanceCollectionEnabled(Boolean bool, final Promise promise) {
        this.module.setPerformanceCollectionEnabled(bool).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda3
            private static final byte[] $$c = {7, -118, Ascii.DC4, 104};
            private static final int $$d = 150;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {65, Ascii.SYN, 92, -30, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, 50, Ascii.SO, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4, -50};
            private static final int $$b = 65;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static char TopicBuilder = 59400;
            private static char ICustomTabsCallback = 48862;
            private static char extraCallbackWithResult = 59529;
            private static char onMessageChannelReady = 55993;

            /* JADX WARN: Code duplicated, block: B:10:0x0025  */
            /* JADX WARN: Code duplicated, block: B:8:0x001f  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(int r6, short r7, byte r8) {
                /*
                    byte[] r0 = io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda3.$$c
                    int r7 = r7 * 2
                    int r7 = 110 - r7
                    int r8 = r8 * 3
                    int r8 = r8 + 4
                    int r6 = r6 * 2
                    int r6 = 1 - r6
                    byte[] r1 = new byte[r6]
                    r2 = 0
                    if (r0 != 0) goto L17
                    r7 = r6
                    r3 = r8
                    r4 = r2
                    goto L27
                L17:
                    r3 = r2
                L18:
                    int r4 = r3 + 1
                    byte r5 = (byte) r7
                    r1[r3] = r5
                    if (r4 != r6) goto L25
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r1, r2)
                    return r6
                L25:
                    r3 = r0[r8]
                L27:
                    int r8 = r8 + 1
                    int r7 = r7 + r3
                    r3 = r4
                    goto L18
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda3.$$e(int, short, byte):java.lang.String");
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0021  */
            /* JADX WARN: Code duplicated, block: B:8:0x0019  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0029). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void a(int r6, int r7, int r8, java.lang.Object[] r9) {
                /*
                    int r0 = 28 - r8
                    byte[] r1 = io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda3.$$a
                    int r7 = r7 + 4
                    int r6 = 115 - r6
                    byte[] r0 = new byte[r0]
                    int r8 = 27 - r8
                    r2 = 0
                    if (r1 != 0) goto L13
                    r3 = r7
                    r6 = r8
                    r4 = r2
                    goto L29
                L13:
                    r3 = r2
                L14:
                    byte r4 = (byte) r6
                    r0[r3] = r4
                    if (r3 != r8) goto L21
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r0, r2)
                    r9[r2] = r6
                    return
                L21:
                    int r3 = r3 + 1
                    r4 = r1[r7]
                    r5 = r3
                    r3 = r7
                    r7 = r4
                    r4 = r5
                L29:
                    int r6 = r6 + r7
                    int r6 = r6 + (-5)
                    int r7 = r3 + 1
                    r3 = r4
                    goto L14
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda3.a(int, int, int, java.lang.Object[]):void");
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebasePerfModule.lambda$setPerformanceCollectionEnabled$0(promise, task);
            }

            private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
                char c;
                int i2 = 2 % 2;
                build buildVar = new build();
                char[] cArr2 = new char[cArr.length];
                buildVar.c = 0;
                char[] cArr3 = new char[2];
                int i3 = $10 + 33;
                $11 = i3 % 128;
                char c2 = 3;
                if (i3 % 2 == 0) {
                    int i4 = 3 % 3;
                }
                while (buildVar.c < cArr.length) {
                    int i5 = $11 + 35;
                    $10 = i5 % 128;
                    int i6 = i5 % 2;
                    cArr3[0] = cArr[buildVar.c];
                    cArr3[1] = cArr[buildVar.c + 1];
                    int i7 = 58224;
                    int i8 = 0;
                    while (i8 < 16) {
                        int i9 = $10 + 15;
                        $11 = i9 % 128;
                        int i10 = i9 % 2;
                        char c3 = cArr3[1];
                        char c4 = cArr3[0];
                        int i11 = (c4 + i7) ^ ((c4 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))));
                        int i12 = c4 >>> 5;
                        try {
                            Object[] objArr2 = new Object[4];
                            objArr2[c2] = Integer.valueOf(onMessageChannelReady);
                            objArr2[2] = Integer.valueOf(i12);
                            objArr2[1] = Integer.valueOf(i11);
                            objArr2[0] = Integer.valueOf(c3);
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                            if (objAccessartificialFrame == null) {
                                byte b = (byte) 0;
                                byte b2 = (byte) (b + 1);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(0) + 29, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 17263), 1068 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 1042277788, false, $$e(b, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                            }
                            char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            cArr3[1] = cCharValue;
                            Object[] objArr3 = {Integer.valueOf(cArr3[0]), Integer.valueOf((cCharValue + i7) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                            if (objAccessartificialFrame2 == null) {
                                byte b3 = (byte) 0;
                                byte b4 = (byte) (b3 + 1);
                                c = 3;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(28 - View.getDefaultSize(0, 0), (char) (View.MeasureSpec.getMode(0) + 17263), 1067 - (ViewConfiguration.getPressedStateDuration() >> 16), 1042277788, false, $$e(b3, b4, (byte) (b4 - 1)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                            } else {
                                c = 3;
                            }
                            cArr3[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                            i7 -= 40503;
                            i8++;
                            int i13 = $11 + 59;
                            $10 = i13 % 128;
                            int i14 = i13 % 2;
                            c2 = c;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    char c5 = c2;
                    cArr2[buildVar.c] = cArr3[0];
                    cArr2[buildVar.c + 1] = cArr3[1];
                    Object[] objArr4 = {buildVar, buildVar};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(26 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 63928), (KeyEvent.getMaxKeyCode() >> 16) + 486, 1554985764, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    c2 = c5;
                }
                objArr[0] = new String(cArr2, 0, i);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v138 */
            /* JADX WARN: Type inference failed for: r10v26, types: [int[]] */
            /* JADX WARN: Type inference failed for: r11v34, types: [int[]] */
            /* JADX WARN: Type inference failed for: r11v75, types: [int[]] */
            /* JADX WARN: Type inference failed for: r13v67 */
            /* JADX WARN: Type inference failed for: r13v75 */
            /* JADX WARN: Type inference failed for: r13v91 */
            /* JADX WARN: Type inference failed for: r14v50 */
            /* JADX WARN: Type inference failed for: r14v58 */
            /* JADX WARN: Type inference failed for: r16v12 */
            /* JADX WARN: Type inference failed for: r16v16 */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v108, types: [int] */
            /* JADX WARN: Type inference failed for: r1v23 */
            /* JADX WARN: Type inference failed for: r1v24 */
            /* JADX WARN: Type inference failed for: r1v33 */
            /* JADX WARN: Type inference failed for: r1v38, types: [java.lang.reflect.Method] */
            /* JADX WARN: Type inference failed for: r2v41 */
            /* JADX WARN: Type inference failed for: r3v181 */
            /* JADX WARN: Type inference failed for: r3v185 */
            /* JADX WARN: Type inference failed for: r3v6, types: [int[]] */
            /* JADX WARN: Type inference failed for: r4v108 */
            /* JADX WARN: Type inference failed for: r4v14, types: [int[]] */
            /* JADX WARN: Type inference failed for: r4v87, types: [int[]] */
            /* JADX WARN: Type inference failed for: r5v88, types: [int[]] */
            /* JADX WARN: Type inference failed for: r5v90, types: [int[]] */
            /* JADX WARN: Type inference failed for: r5v96, types: [int[]] */
            /* JADX WARN: Type inference failed for: r6v52, types: [int[]] */
            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r22, int r23, int r24, int r25) {
                /*
                    Method dump skipped, instruction units count: 3074
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda3.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setPerformanceCollectionEnabled$0(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void startTrace(int i, String str, final Promise promise) {
        this.module.startTrace(i, str).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebasePerfModule.lambda$startTrace$1(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startTrace$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void stopTrace(int i, ReadableMap readableMap, final Promise promise) {
        this.module.stopTrace(i, Arguments.toBundle(readableMap.getMap("metrics")), Arguments.toBundle(readableMap.getMap("attributes"))).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebasePerfModule.lambda$stopTrace$2(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$stopTrace$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void startScreenTrace(int i, String str, final Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.resolve(null);
        } else {
            this.module.startScreenTrace(currentActivity, i, str).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda6
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    ReactNativeFirebasePerfModule.lambda$startScreenTrace$3(promise, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startScreenTrace$3(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void stopScreenTrace(int i, final Promise promise) {
        this.module.stopScreenTrace(i).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebasePerfModule.lambda$stopScreenTrace$4(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$stopScreenTrace$4(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void startHttpMetric(int i, String str, String str2, final Promise promise) {
        this.module.startHttpMetric(i, str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebasePerfModule.lambda$startHttpMetric$5(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startHttpMetric$5(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void stopHttpMetric(int i, ReadableMap readableMap, final Promise promise) {
        this.module.stopHttpMetric(i, Arguments.toBundle(readableMap), Arguments.toBundle(readableMap.getMap("attributes"))).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebasePerfModule.lambda$stopHttpMetric$6(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$stopHttpMetric$6(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return this.module.getConstants();
    }
}
