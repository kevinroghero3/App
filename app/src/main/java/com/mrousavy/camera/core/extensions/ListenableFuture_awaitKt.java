package com.mrousavy.camera.core.extensions;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.android.gms.internal.mlkit_vision_common.zzkf;
import com.google.common.base.Ascii;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.JobKt;
import o.ArtificialStackFrames;
import o._CREATION;
import o.onNavigationEvent;
import org.apache.commons.lang3.CharUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class ListenableFuture_awaitKt {
    public static /* synthetic */ Object await$default(ListenableFuture listenableFuture, Executor executor, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            executor = null;
        }
        return await(listenableFuture, executor, continuation);
    }

    public static final <V> Object await(@NotNull final ListenableFuture<V> listenableFuture, @Nullable Executor executor, @NotNull Continuation<? super V> continuation) throws Throwable {
        if (listenableFuture.isCancelled()) {
            throw new CancellationException("ListenableFuture<V> has been canceled!");
        }
        if (listenableFuture.isDone()) {
            return listenableFuture.get();
        }
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        Runnable runnable = new Runnable() { // from class: com.mrousavy.camera.core.extensions.ListenableFuture_awaitKt$await$2$1
            private static final byte[] $$a = {Ascii.DC2, -20, 124, 53};
            private static final int $$b = 253;
            private static int $10 = 0;
            private static int $11 = 1;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static char[] _CREATION = {28267, 386, 45491, 8646, 53745, 16709, 61758, 24906, 4466, 32902, 12455, 41182, 20717, 49154, 28787, 57438, 36948, 'w', 45965, 9193, 54225, 17342, 62301, 25471, 4895, 33611, 12992, 41703, 21129, 49867, 29199, 57910, 37423, 576, 45676, 9623, 54696, 17863, 6589, 30290, 50695, 22041, 42520, 14064, 34496, 5823, 26247, 63336, 18186, 55052, 9987, 47078, 2007, 38823, 59378, 30643, 50215, 21625, 42040, 13328, 34016, 5343, 25767, 62600, 17702, 54635, 9595, 46385, 1489, 6589, 30241, 50799, 22027, 42586, 14043, 34447, 5777, 26240, 63336, 18264, 55079, 9999, 47072, 1934, 38787, 59280, 30657, 50267, 21590, 42034, 13318, 34045, 5337, 25770, 62668, 17742, 54605, 9508, 46353, 1509, 29492, 7385, 44277, 15489, 52402, 23638, 60541, 31829, 3110, 40392, 11759, 48535, 19880, 56641, 28029, 64837, 36150, 7480, 44767, 16103, 52888, 24231, 61005, 6553, 30329, 50766, 22024, 42519, 14071, 34521, 5809, 26249, 63337, 18279, 55081, 9992, 47077, 1989, 38821, 59308, 38955, 63435, 18428, 55226, 10149, 46917, 1899, 38659, 59195, 30427, 50902, 22171, 42681, 13907, 26759, 1895, 46928, 10006, 55049, 18409, 63431, 26543, 6039, 34423, 13949, 42552, 22046, 50933, 6559, 30322, 50782, 22058, 42521, 14077, 34518, 5886, 26253, 63331, 18244, 55100, 9987, 47082, 2006, 38894, 59310, 30609, 50228, 21608, 42039, 13335, 34041, 5329, 25769, 62601, 17731, 54598, 9504, 46347, 25201, 3480, 48553, 11740, 56765, 19714, 64818, 27990, 7550, 35995, 15526, 44249, 23802, 52303, 31780, 60480, 40009, 3181, 49105, 12190, 57302, 20451, 65283, 28476, 8013, 36704, 16012, 44716, 24279, 52964, 32289, 60964, 40504, 3661, 48752, 10639, 55722, 34452, 59764, 22873, 51504, 14601, 43512, 6603, 35256, 63904, 26724, 55381, 18481, 47106, 10479, 39110, 2222, 30898, 59525, 23410, 27737, 953, 45966, 9163, 54211, 17206, 62232, 25461, 4941, 33464, 12978, 41661, 21142, 49780, 29234, 57970, 37495, 594, 45497, 8593, 53734, 16853, 61758};
            private static long _BOUNDARY = 6705965026142680604L;
            private static int setDefaultImpl = -260894118;

            /* JADX WARN: Code duplicated, block: B:10:0x0023  */
            /* JADX WARN: Code duplicated, block: B:8:0x001d  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0025). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$c(byte r6, byte r7, int r8) {
                /*
                    int r6 = r6 * 4
                    int r6 = r6 + 1
                    int r8 = r8 + 103
                    int r7 = r7 * 3
                    int r7 = r7 + 4
                    byte[] r0 = com.mrousavy.camera.core.extensions.ListenableFuture_awaitKt$await$2$1.$$a
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
                    int r7 = r7 + 1
                    int r8 = r8 + r3
                    r3 = r4
                    goto L16
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.extensions.ListenableFuture_awaitKt$await$2$1.$$c(byte, byte, int):java.lang.String");
            }

            @Override // java.lang.Runnable
            public final void run() throws ExecutionException {
                if (listenableFuture.isCancelled() || !JobKt.isActive(safeContinuation.getContext())) {
                    throw new CancellationException("ListenableFuture<V> has been canceled!");
                }
                try {
                    Continuation<V> continuation2 = safeContinuation;
                    Result.Companion companion = Result.Companion;
                    continuation2.resumeWith(Result.m5472constructorimpl(listenableFuture.get()));
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        Continuation<V> continuation3 = safeContinuation;
                        Result.Companion companion2 = Result.Companion;
                        continuation3.resumeWith(Result.m5472constructorimpl(ResultKt.createFailure(cause)));
                        return;
                    }
                    throw e;
                }
            }

            private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
                int i3 = 2;
                int i4 = 2 % 2;
                _CREATION _creation = new _CREATION();
                long[] jArr = new long[i2];
                _creation.b = 0;
                int i5 = $10 + 79;
                $11 = i5 % 128;
                if (i5 % 2 == 0) {
                    int i6 = 5 % 5;
                }
                while (_creation.b < i2) {
                    int i7 = $10 + 51;
                    $11 = i7 % 128;
                    int i8 = i7 % i3;
                    int i9 = _creation.b;
                    try {
                        Object[] objArr2 = {Integer.valueOf(_CREATION[i + i9])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 0;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionChild(0L) + 9, (char) (Color.green(0) + 9279), 1977 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 1113883676, false, $$c(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                        }
                        Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i9), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - Gravity.getAbsoluteGravity(0, 0), (char) (49362 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 684, -115095555, false, $$c(b3, b4, (byte) (b4 + 3)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                        }
                        jArr[i9] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                        Object[] objArr4 = {_creation, _creation};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            byte b6 = b5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (Color.alpha(0) + 30068), View.resolveSize(0, 0) + 816, 1897803493, false, $$c(b5, b6, b6), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        int i10 = $10 + 125;
                        $11 = i10 % 128;
                        int i11 = i10 % 2;
                        i3 = 2;
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
                while (_creation.b < i2) {
                    cArr[_creation.b] = (char) jArr[_creation.b];
                    Object[] objArr5 = {_creation, _creation};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = b7;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetAfter("", 0) + 25, (char) (30068 - KeyEvent.keyCodeFromString("")), 816 - View.MeasureSpec.getMode(0), 1897803493, false, $$c(b7, b8, b8), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                }
                objArr[0] = new String(cArr);
            }

            private static void b(char[] cArr, int i, int i2, int i3, boolean z, Object[] objArr) throws Throwable {
                int i4 = 2 % 2;
                onNavigationEvent onnavigationevent = new onNavigationEvent();
                char[] cArr2 = new char[i];
                onnavigationevent.d = 0;
                while (onnavigationevent.d < i) {
                    int i5 = $11 + 95;
                    $10 = i5 % 128;
                    int i6 = i5 % 2;
                    onnavigationevent.c = cArr[onnavigationevent.d];
                    cArr2[onnavigationevent.d] = (char) (i3 + onnavigationevent.c);
                    int i7 = onnavigationevent.d;
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i7]), Integer.valueOf(setDefaultImpl)};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 0;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(21 - ImageFormat.getBitsPerPixel(0), (char) TextUtils.getOffsetAfter("", 0), 1775 - (ViewConfiguration.getWindowTouchSlop() >> 8), -2069783171, false, $$c(b, b2, (byte) (b2 | Ascii.VT)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr2[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        try {
                            Object[] objArr3 = {onnavigationevent, onnavigationevent};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                            if (objAccessartificialFrame2 == null) {
                                byte b3 = (byte) 0;
                                byte b4 = b3;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(37 - TextUtils.indexOf("", "", 0, 0), (char) (56278 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), 1259 - (ViewConfiguration.getTouchSlop() >> 8), 711931141, false, $$c(b3, b4, (byte) (b4 | Ascii.CR)), new Class[]{Object.class, Object.class});
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
                if (i2 > 0) {
                    onnavigationevent.b = i2;
                    char[] cArr3 = new char[i];
                    System.arraycopy(cArr2, 0, cArr3, 0, i);
                    System.arraycopy(cArr3, 0, cArr2, i - onnavigationevent.b, onnavigationevent.b);
                    System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i - onnavigationevent.b);
                }
                if (z) {
                    int i8 = $10 + 53;
                    $11 = i8 % 128;
                    int i9 = i8 % 2;
                    char[] cArr4 = new char[i];
                    onnavigationevent.d = 0;
                    while (onnavigationevent.d < i) {
                        cArr4[onnavigationevent.d] = cArr2[(i - onnavigationevent.d) - 1];
                        try {
                            Object[] objArr4 = {onnavigationevent, onnavigationevent};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                            if (objAccessartificialFrame3 == null) {
                                byte b5 = (byte) 0;
                                byte b6 = b5;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(View.combineMeasuredStates(0, 0) + 37, (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 56277), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1259, 711931141, false, $$c(b5, b6, (byte) (b6 | Ascii.CR)), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        } catch (Throwable th3) {
                            Throwable cause3 = th3.getCause();
                            if (cause3 == null) {
                                throw th3;
                            }
                            throw cause3;
                        }
                    }
                    int i10 = $11 + 9;
                    $10 = i10 % 128;
                    if (i10 % 2 != 0) {
                        int i11 = 3 / 2;
                    }
                    cArr2 = cArr4;
                }
                objArr[0] = new String(cArr2);
            }

            public static Object[] accessartificialFrame(Context context, int i, int i2) {
                int i3;
                int i4;
                String str;
                Object[] objArr;
                char packedPositionGroup;
                int tapTimeout;
                long zoomControlsTimeout;
                int i5;
                int i6;
                int iPostMessage;
                int i7;
                char c;
                int i8;
                int i9;
                int i10;
                int i11;
                int i12;
                int i13;
                char c2;
                int i14;
                char cLastIndexOf;
                Class<?> cls;
                int i15;
                int jumpTapTimeout;
                int iPostMessage2;
                int i16;
                int i17;
                int i18;
                int i19;
                String str2 = "";
                int i20 = 2;
                int i21 = 2 % 2;
                int i22 = getARTIFICIAL_FRAME_PACKAGE_NAME + 61;
                int i23 = i22 % 128;
                artificialFrame = i23;
                if (i22 % 2 == 0) {
                    throw null;
                }
                int i24 = 1;
                if (context == null) {
                    Object[] objArr2 = {new int[]{i}, new int[]{i}, new int[]{((~i) & i) | ((~i) & i)}, null};
                    int i25 = ~i;
                    int i26 = (-609779983) + (((~((-366230858) | i25)) | 290725896) * 98) + (((~(i25 | (-612392918))) | (-366230858) | (~(612392917 | i))) * (-49)) + (((~(i | (-366230858))) | (-903118814)) * 49);
                    int i27 = (i2 & i26) + (i2 | i26);
                    int i28 = i27 << 13;
                    int i29 = ((~i27) & i28) | ((~i28) & i27);
                    int i30 = i29 >>> 17;
                    int i31 = ((~i29) & i30) | ((~i30) & i29);
                    int i32 = i31 << 5;
                    int i33 = ((i23 | 25) << 1) - (i23 ^ 25);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i33 % 128;
                    int i34 = i33 % 2;
                    return objArr2;
                }
                try {
                    int i35 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                    char c3 = (char) ((i35 & 30719) + (i35 | 30719));
                    int maxKeyCode = KeyEvent.getMaxKeyCode() >> 16;
                    int i36 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
                    int iPostMessage3 = zzkf.postMessage();
                    int i37 = getARTIFICIAL_FRAME_PACKAGE_NAME + 57;
                    int i38 = i37 % 128;
                    artificialFrame = i38;
                    if (i37 % 2 == 0) {
                        i4 = ~i36;
                        i3 = ((-318) - i4) % 8;
                    } else {
                        i3 = (i36 * (-317)) + 12122;
                        i4 = ~i36;
                    }
                    int i39 = i4 | (-39);
                    int i40 = ~((i39 ^ iPostMessage3) | (i39 & iPostMessage3));
                    int i41 = ~iPostMessage3;
                    int i42 = (i41 ^ i36) | (i41 & i36);
                    int i43 = (-318) * ((~((i42 ^ 38) | (i42 & 38))) | i40);
                    int i44 = (i3 & i43) + (i43 | i3);
                    int i45 = ~(((-39) ^ i36) | ((-39) & i36));
                    int i46 = ((i38 | 91) << 1) - (i38 ^ 91);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i46 % 128;
                    int i47 = i46 % 2;
                    int i48 = ~(i36 | iPostMessage3);
                    if (i47 != 0) {
                        int i49 = (i48 & i45) | (i45 ^ i48);
                        int i50 = i44 % ((i49 & (-318)) + (i49 | (-318)));
                        int i51 = ~i36;
                        int i52 = i50 % (TypedValues.AttributesType.TYPE_PIVOT_TARGET % ((~((i51 & iPostMessage3) | (i51 ^ iPostMessage3))) | (-39)));
                        Object[] objArr3 = new Object[1];
                        a(c3, maxKeyCode, i52, objArr3);
                        str = (String) objArr3[0];
                    } else {
                        int i53 = (i44 - (~(-(-((i48 | i45) * (-318)))))) - 1;
                        int i54 = ~((~i36) | iPostMessage3);
                        int i55 = ((i54 & (-39)) | ((-39) ^ i54)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET;
                        int i56 = (i53 & i55) + (i53 | i55);
                        Object[] objArr4 = new Object[1];
                        a(c3, maxKeyCode, i56, objArr4);
                        str = (String) objArr4[0];
                    }
                    Object[] objArr5 = (Object[]) Array.newInstance(Class.forName(str), 2);
                    char c4 = (char) ((-2) - ((-(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)))) ^ (-1)));
                    int i57 = 37 - (~(-(ViewConfiguration.getLongPressTimeout() >> 16)));
                    int trimmedLength = TextUtils.getTrimmedLength("");
                    int i58 = artificialFrame;
                    int i59 = (i58 ^ 125) + ((i58 & 125) << 1);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i59 % 128;
                    int i60 = i59 % 2;
                    int iPostMessage4 = zzkf.postMessage();
                    int i61 = trimmedLength * 165;
                    int i62 = (i61 ^ (-5053)) + ((i61 & (-5053)) << 1);
                    int i63 = ~iPostMessage4;
                    int i64 = ((~((i63 ^ 31) | (i63 & 31))) | trimmedLength) * (-328);
                    int i65 = (i62 & i64) + (i62 | i64);
                    int i66 = -(-(((trimmedLength ^ iPostMessage4) | (trimmedLength & iPostMessage4)) * 164));
                    int i67 = (i65 ^ i66) + ((i66 & i65) << 1);
                    int i68 = ~((~trimmedLength) | (-32));
                    int i69 = artificialFrame;
                    int i70 = (i69 & 37) + (i69 | 37);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i70 % 128;
                    int i71 = i70 % 2;
                    int i72 = ~(((-32) & iPostMessage4) | ((-32) ^ iPostMessage4));
                    int i73 = (i72 & i68) | (i68 ^ i72);
                    int i74 = ~(trimmedLength | i63 | 31);
                    int i75 = -(-(164 * ((i73 & i74) | (i73 ^ i74))));
                    int i76 = (i67 ^ i75) + ((i75 & i67) << 1);
                    Object[] objArr6 = new Object[1];
                    a(c4, i57, i76, objArr6);
                    String str3 = (String) objArr6[0];
                    int i77 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                    artificialFrame = i77 % 128;
                    try {
                        if (i77 % 2 == 0) {
                            objArr = new Object[1];
                            objArr[1] = str3;
                            packedPositionGroup = (char) (16166 >> ExpandableListView.getPackedPositionGroup(1L));
                            tapTimeout = ViewConfiguration.getTapTimeout() >> 65;
                            zoomControlsTimeout = ViewConfiguration.getZoomControlsTimeout();
                            i5 = 44;
                        } else {
                            objArr = new Object[]{str3};
                            int i78 = -ExpandableListView.getPackedPositionGroup(0L);
                            packedPositionGroup = (char) (((i78 | 30719) << 1) - (i78 ^ 30719));
                            tapTimeout = ViewConfiguration.getTapTimeout() >> 16;
                            zoomControlsTimeout = ViewConfiguration.getZoomControlsTimeout();
                            i5 = 37;
                        }
                        int i79 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i80 = ((i79 | 45) << 1) - (i79 ^ 45);
                        artificialFrame = i80 % 128;
                        int i81 = i80 % 2;
                        int i82 = (zoomControlsTimeout > 0L ? 1 : (zoomControlsTimeout == 0L ? 0 : -1));
                        int i83 = (i5 & i82) + (i82 | i5);
                        Object[] objArr7 = new Object[1];
                        a(packedPositionGroup, tapTimeout, i83, objArr7);
                        Object objNewInstance = Class.forName((String) objArr7[0]).getDeclaredConstructor(String.class).newInstance(objArr);
                        int i84 = artificialFrame + 71;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i84 % 128;
                        if (i84 % 2 != 0) {
                            objArr5[0] = objNewInstance;
                            i6 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 1L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 1L ? 0 : -1));
                            iPostMessage = zzkf.postMessage();
                            i7 = i6 * (-381);
                            c = 0;
                        } else {
                            objArr5[0] = objNewInstance;
                            i6 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                            iPostMessage = zzkf.postMessage();
                            i7 = i6 * (-381);
                            c = 1;
                        }
                        int i85 = i7 - 192;
                        int i86 = (~i6) * (-191);
                        int i87 = ~(iPostMessage | ((-1) ^ iPostMessage));
                        int i88 = ((i85 ^ i86) + ((i85 & i86) << 1)) - (~(-(-(((i6 & i87) | (i6 ^ i87)) * 191))));
                        int i89 = artificialFrame;
                        int i90 = (i89 & 89) + (i89 | 89);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i90 % 128;
                        int i91 = i90 % 2;
                        char c5 = (char) (i88 - 1);
                        int i92 = -Color.rgb(0, 0, 0);
                        int iPostMessage5 = zzkf.postMessage();
                        int i93 = (i92 * 784) - (-234827066);
                        int i94 = artificialFrame + 47;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i94 % 128;
                        int i95 = i94 % 2;
                        int i96 = (i93 & (-251603430)) + (i93 | (-251603430));
                        int i97 = ~i92;
                        int i98 = ~iPostMessage5;
                        int i99 = i97 | i98;
                        int i100 = i96 + ((~((i99 & (-16777147)) | (i99 ^ (-16777147)))) * (-783));
                        int i101 = ~(i98 | (-16777147));
                        Object[] objArr8 = new Object[1];
                        a(c5, (i100 - (~(-(-(((i97 & i101) | (i97 ^ i101)) * 783))))) - 1, 31 - Color.blue(0), objArr8);
                        try {
                            Object[] objArr9 = {(String) objArr8[0]};
                            int i102 = -(-View.MeasureSpec.getSize(0));
                            int iCombineMeasuredStates = View.combineMeasuredStates(0, 0);
                            int i103 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                            int i104 = (i103 & 38) + (i103 | 38);
                            Object[] objArr10 = new Object[1];
                            a((char) (((i102 | 30719) << 1) - (i102 ^ 30719)), iCombineMeasuredStates, i104, objArr10);
                            objArr5[c] = Class.forName((String) objArr10[0]).getDeclaredConstructor(String.class).newInstance(objArr9);
                            try {
                                char c6 = (char) (27307 - (~(-(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)))));
                                int i105 = -(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                                int i106 = (i105 & 100) + (i105 | 100);
                                int gidForName = Process.getGidForName("");
                                int i107 = (gidForName ^ 24) + ((gidForName & 24) << 1);
                                Object[] objArr11 = new Object[1];
                                a(c6, i106, i107, objArr11);
                                Class<?> cls2 = Class.forName((String) objArr11[0]);
                                int i108 = -(-Process.getGidForName(""));
                                char c7 = (char) (((i108 | 1) << 1) - (i108 ^ 1));
                                int i109 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                                int i110 = ((i109 | 122) << 1) - (i109 ^ 122);
                                int i111 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                                int iPostMessage6 = zzkf.postMessage();
                                int i112 = i111 * (-381);
                                int i113 = getARTIFICIAL_FRAME_PACKAGE_NAME + 57;
                                int i114 = i113 % 128;
                                artificialFrame = i114;
                                if (i113 % 2 == 0) {
                                    int i115 = (-191) / (~i111);
                                    i8 = 0;
                                } else {
                                    int i116 = ((i112 | 3264) << 1) - (i112 ^ 3264);
                                    int i117 = -(-((~i111) * (-191)));
                                    i8 = ((i116 | i117) << 1) - (i117 ^ i116);
                                }
                                int i118 = (i114 ^ 15) + ((i114 & 15) << 1);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i118 % 128;
                                if (i118 % 2 != 0) {
                                    i9 = i8 - (191 * ((~((iPostMessage6 ^ 17) | (iPostMessage6 & 17))) | i111));
                                } else {
                                    int i119 = ~(iPostMessage6 | 17);
                                    int i120 = -(-(191 * ((i111 ^ i119) | (i119 & i111))));
                                    i9 = ((i8 & i120) << 1) + (i8 ^ i120);
                                }
                                int i121 = ~i111;
                                int i122 = ~((i121 & 17) | (i121 ^ 17));
                                int i123 = ~iPostMessage6;
                                int i124 = ~((i123 & 17) | (i123 ^ 17));
                                int i125 = 191 * ((i122 & i124) | (i122 ^ i124));
                                int i126 = (i9 & i125) + (i125 | i9);
                                Object[] objArr12 = new Object[1];
                                a(c7, i110, i126, objArr12);
                                String str4 = (String) objArr12[0];
                                int i127 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
                                artificialFrame = i127 % 128;
                                int i128 = i127 % 2;
                                Object objInvoke = cls2.getMethod(str4, null).invoke(context, null);
                                try {
                                    int gidForName2 = Process.getGidForName("");
                                    int iPostMessage7 = zzkf.postMessage();
                                    int i129 = gidForName2 * (-755);
                                    int i130 = (i129 & (-20617540)) + (i129 | (-20617540)) + ((~((~gidForName2) | (-27309))) * 1512);
                                    int i131 = ~gidForName2;
                                    int i132 = ~((i131 & (-27309)) | (i131 ^ (-27309)));
                                    int i133 = (gidForName2 & 27308) | (gidForName2 ^ 27308);
                                    int i134 = ~((i133 ^ iPostMessage7) | (i133 & iPostMessage7));
                                    int i135 = ((i132 & i134) | (i132 ^ i134)) * (-756);
                                    int i136 = ~iPostMessage7;
                                    Object[] objArr13 = new Object[1];
                                    a((char) (((((i130 | i135) << 1) - (i135 ^ i130)) - (~(-(-(((i133 & i136) | (i133 ^ i136)) * 756))))) - 1), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 99, 22 - (~Drawable.resolveOpacity(0, 0)), objArr13);
                                    Class<?> cls3 = Class.forName((String) objArr13[0]);
                                    int trimmedLength2 = TextUtils.getTrimmedLength("");
                                    char c8 = (char) ((trimmedLength2 ^ 33202) + ((trimmedLength2 & 33202) << 1));
                                    int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 140;
                                    int i137 = -Color.blue(0);
                                    int iPostMessage8 = zzkf.postMessage();
                                    int i138 = i137 * (-495);
                                    int i139 = (i138 ^ (-6930)) + ((i138 & (-6930)) << 1);
                                    int i140 = ~i137;
                                    int i141 = ~((i140 ^ (-15)) | (i140 & (-15)));
                                    int i142 = ~((i140 ^ iPostMessage8) | (i140 & iPostMessage8));
                                    int i143 = ((i141 & i142) | (i141 ^ i142)) * 992;
                                    int i144 = ((i139 | i143) << 1) - (i143 ^ i139);
                                    int i145 = ~i137;
                                    int i146 = artificialFrame + 71;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i146 % 128;
                                    int i147 = i146 % 2;
                                    int i148 = (~((i145 & iPostMessage8) | (i145 ^ iPostMessage8))) | (~((i145 ^ (-15)) | (i145 & (-15))));
                                    int i149 = i137 | (~iPostMessage8);
                                    int i150 = ~((i149 & 14) | (i149 ^ 14));
                                    int i151 = (i144 - (~((-496) * ((i150 & i148) | (i148 ^ i150))))) - 1;
                                    int i152 = ((iPostMessage8 ^ 14) | (iPostMessage8 & 14)) * 496;
                                    int i153 = ((i151 | i152) << 1) - (i152 ^ i151);
                                    Object[] objArr14 = new Object[1];
                                    a(c8, absoluteGravity, i153, objArr14);
                                    Object objInvoke2 = cls3.getMethod((String) objArr14[0], null).invoke(context, null);
                                    int i154 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i155 = (i154 & 97) + (i154 | 97);
                                    artificialFrame = i155 % 128;
                                    int i156 = i155 % 2;
                                    try {
                                        Object[] objArr15 = {objInvoke2, 64};
                                        Object[] objArr16 = new Object[1];
                                        b(new char[]{'\t', 65535, 5, 3, 65515, 65535, '\f', 65535, 5, 3, 16, 65535, '\f', 2, 16, CharUtils.CR, 7, 2, 65484, 1, CharUtils.CR, '\f', 18, 3, '\f', 18, 65484, 14, 11, 65484, 65518, 65535, 1}, (ViewConfiguration.getTapTimeout() >> 16) + 33, (ViewConfiguration.getPressedStateDuration() >> 16) + 11, 273 - TextUtils.getTrimmedLength(""), false, objArr16);
                                        Class<?> cls4 = Class.forName((String) objArr16[0]);
                                        int i157 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                        int i158 = artificialFrame + 125;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i158 % 128;
                                        int i159 = i158 % 2;
                                        int iPostMessage9 = zzkf.postMessage();
                                        int i160 = ~i157;
                                        int i161 = ((i157 * (-183)) - (-5357230)) + ((i160 | 28958) * (-368));
                                        int i162 = (i157 ^ (-28959)) | (i157 & (-28959));
                                        int i163 = ~iPostMessage9;
                                        int i164 = ((i162 & i163) | (i162 ^ i163)) * SyslogConstants.LOG_LOCAL7;
                                        int i165 = (i161 ^ i164) + ((i161 & i164) << 1);
                                        int i166 = ~((i160 ^ (-28959)) | (i160 & (-28959)));
                                        int i167 = ~((i163 & i157) | (i163 ^ i157));
                                        int i168 = (i167 & i166) | (i166 ^ i167);
                                        int i169 = ~((i157 & 28958) | (i157 ^ 28958));
                                        int i170 = ((i169 & i168) | (i168 ^ i169)) * SyslogConstants.LOG_LOCAL7;
                                        char c9 = (char) ((i165 & i170) + (i170 | i165));
                                        int iBlue = Color.blue(0);
                                        int i171 = iBlue * (-751);
                                        int i172 = (i171 & (-115654)) + (i171 | (-115654));
                                        int i173 = ~iBlue;
                                        int i174 = ~((i173 ^ (-155)) | (i173 & (-155)));
                                        int i175 = ~(i173 | i);
                                        int i176 = i172 + (((i174 ^ i175) | (i174 & i175)) * 1504);
                                        int i177 = ~iBlue;
                                        int i178 = -(-((~((i177 & 154) | (i177 ^ 154) | i)) * (-1504)));
                                        int i179 = (((i176 & i178) + (i178 | i176)) - (~(-(-(((~((i173 & 154) | (i173 ^ 154))) | (~((iBlue & (-155)) | ((-155) ^ iBlue)))) * 752))))) - 1;
                                        int i180 = -(ViewConfiguration.getTouchSlop() >> 8);
                                        int i181 = (i180 & 14) + (i180 | 14);
                                        Object[] objArr17 = new Object[1];
                                        a(c9, i179, i181, objArr17);
                                        Object objInvoke3 = cls4.getMethod((String) objArr17[0], String.class, Integer.TYPE).invoke(objInvoke, objArr15);
                                        Object[] objArr18 = new Object[1];
                                        a((char) Gravity.getAbsoluteGravity(0, 0), TextUtils.indexOf("", "") + 168, 28 - (~(-(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))), objArr18);
                                        Class<?> cls5 = Class.forName((String) objArr18[0]);
                                        char[] cArr = {65528, 5, '\b', 7, 65524, 1, 65530, 65532, 6, 6};
                                        byte modifierMetaStateMask = (byte) KeyEvent.getModifierMetaStateMask();
                                        int i182 = ~((i ^ 11) | (i & 11));
                                        int i183 = (modifierMetaStateMask * (-419)) + 4631 + (i182 * TypedValues.CycleType.TYPE_EASING);
                                        int i184 = ~modifierMetaStateMask;
                                        int i185 = (i183 - (~(-(-((i184 | 11) * (-420)))))) - 1;
                                        int i186 = ~((i184 & (-12)) | (i184 ^ (-12)));
                                        int i187 = ~i;
                                        int i188 = -(-((i186 | (~((i187 ^ 11) | (i187 & 11)))) * TypedValues.CycleType.TYPE_EASING));
                                        int i189 = (i185 & i188) + (i188 | i185);
                                        int i190 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                                        int i191 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        int i192 = (i191 ^ 7) + ((i191 & 7) << 1);
                                        artificialFrame = i192 % 128;
                                        int i193 = i192 % 2;
                                        int i194 = i190 * (-949);
                                        int i195 = (i194 & (-8541)) + (i194 | (-8541));
                                        int i196 = ~(((-10) & i187) | ((-10) ^ i187));
                                        int i197 = ~i190;
                                        int i198 = ~((i197 ^ i) | (i197 & i));
                                        int i199 = ((i196 ^ i198) | (i196 & i198)) * 1900;
                                        int i200 = (i195 ^ i199) + ((i199 & i195) << 1);
                                        int i201 = ~(i187 | i190);
                                        int i202 = ~((9 ^ i) | (9 & i));
                                        int i203 = (i200 - (~(-(-(((i201 ^ i202) | (i201 & i202)) * (-950)))))) - 1;
                                        int i204 = ~i;
                                        int i205 = i203 + (((~(i190 | i)) | (~(i204 | 9))) * 950);
                                        int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0);
                                        Object[] objArr19 = new Object[1];
                                        b(cArr, i189, i205, (iIndexOf ^ 285) + ((iIndexOf & 285) << 1), true, objArr19);
                                        Object[] objArr20 = (Object[]) cls5.getField((String) objArr19[0]).get(objInvoke3);
                                        int length = objArr20.length;
                                        int i206 = 0;
                                        while (i206 < length) {
                                            Object obj = objArr20[i206];
                                            char[] cArr2 = {65526, 65531, 65524, 30, 65535};
                                            int gidForName3 = Process.getGidForName(str2);
                                            int i207 = artificialFrame;
                                            int i208 = ((i207 | 73) << 1) - (i207 ^ 73);
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i208 % 128;
                                            if (i208 % i20 != 0) {
                                                int i209 = 85 << gidForName3;
                                                i10 = (i209 & 1) + (i209 | i24);
                                            } else {
                                                i10 = (gidForName3 * 85) + TypedValues.PositionType.TYPE_POSITION_TYPE;
                                            }
                                            int i210 = ~gidForName3;
                                            int i211 = ~((i210 ^ (-7)) | (i210 & (-7)));
                                            int i212 = ~gidForName3;
                                            int i213 = ~((i212 ^ i187) | (i212 & i187));
                                            int i214 = (i211 ^ i213) | (i213 & i211) | (~((-7) | i204));
                                            int i215 = (gidForName3 ^ 6) | (gidForName3 & 6);
                                            int i216 = ~((i215 ^ i) | (i215 & i));
                                            int i217 = ((i214 ^ i216) | (i214 & i216)) * (-84);
                                            int i218 = (i10 ^ i217) + ((i217 & i10) << 1);
                                            int i219 = ~(((-7) ^ i) | ((-7) & i));
                                            int i220 = (i219 & gidForName3) | (gidForName3 ^ i219);
                                            int i221 = ~(i187 | 6);
                                            int i222 = -(-(((i220 & i221) | (i220 ^ i221)) * (-84)));
                                            int i223 = ((i218 | i222) << 1) - (i222 ^ i218);
                                            int i224 = ~((i187 ^ 6) | (i187 & 6));
                                            int i225 = ~i215;
                                            int i226 = ((i224 & i225) | (i224 ^ i225)) * 84;
                                            int i227 = ((i223 | i226) << 1) - (i226 ^ i223);
                                            Object[] objArr21 = new Object[1];
                                            b(cArr2, i227, 3 - (~(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), 233 - (ViewConfiguration.getEdgeSlop() >> 16), true, objArr21);
                                            try {
                                                Object[] objArr22 = {(String) objArr21[0]};
                                                char edgeSlop = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 31717);
                                                int i228 = -(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                                                int i229 = ((i228 | 198) << 1) - (i228 ^ 198);
                                                int deadChar = KeyEvent.getDeadChar(0, 0);
                                                int i230 = (deadChar ^ 37) + ((deadChar & 37) << 1);
                                                Object[] objArr23 = new Object[1];
                                                a(edgeSlop, i229, i230, objArr23);
                                                Class<?> cls6 = Class.forName((String) objArr23[0]);
                                                char[] cArr3 = {'\f', 7, 65506, CharUtils.CR, 65534, 0, 65534, 65532, 7, 65530, CharUtils.CR};
                                                int iRgb = Color.rgb(0, 0, 0);
                                                int i231 = 4 - (~(-(-(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)))));
                                                int i232 = -Color.blue(0);
                                                int i233 = ((i232 | 278) << 1) - (i232 ^ 278);
                                                Object[] objArr24 = new Object[1];
                                                b(cArr3, (iRgb & 16777227) + (16777227 | iRgb), i231, i233, true, objArr24);
                                                Object objInvoke4 = cls6.getMethod((String) objArr24[0], String.class).invoke(null, objArr22);
                                                try {
                                                    char[] cArr4 = {'\n', 16, 65482, '\f', '\t', 65482, 65519, 5, 3, '\n', 65533, 16, 17, 14, 1, 65533, '\n', 0, 14, 11, 5, 0, 65482, 65535, 11, '\n', 16, 1};
                                                    int i234 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                    int i235 = ((i234 | 28) << 1) - (i234 ^ 28);
                                                    int iLastIndexOf = TextUtils.lastIndexOf(str2, '0');
                                                    int iPostMessage10 = zzkf.postMessage();
                                                    int i236 = artificialFrame;
                                                    int i237 = (i236 & 45) + (i236 | 45);
                                                    Object[] objArr25 = objArr20;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i237 % 128;
                                                    int i238 = i237 % 2;
                                                    int i239 = ((((-1965) * iLastIndexOf) + 15744) - (~(((iLastIndexOf ^ (-17)) | (iLastIndexOf & (-17))) * 983))) - 1;
                                                    int i240 = ~iLastIndexOf;
                                                    int i241 = ~iPostMessage10;
                                                    int i242 = length;
                                                    int i243 = ((-455474693) ^ i) | ((-455474693) & i);
                                                    int i244 = i206;
                                                    int i245 = ~i243;
                                                    int i246 = -(-((((-729904873) ^ i245) | ((-729904873) & i245)) * (-220)));
                                                    int i247 = ~i243;
                                                    int i248 = ((-1268303091) ^ i246) + (((-1268303091) & i246) << 1) + (((270829572 ^ i247) | (i247 & 270829572)) * 220) + 424487466;
                                                    int i249 = ~((-553691683) | i204);
                                                    int i250 = i187;
                                                    int i251 = ~((2008739750 ^ i) | (2008739750 & i));
                                                    int i252 = ((i249 ^ i251) | (i249 & i251)) * (-272);
                                                    int i253 = (((-937593336) | i252) << 1) - (i252 ^ (-937593336));
                                                    int i254 = ~(((-587902887) & i) | ((-587902887) ^ i));
                                                    int i255 = ((34211204 ^ i254) | (i254 & 34211204)) * (-272);
                                                    int i256 = (i253 ^ i255) + ((i253 & i255) << 1);
                                                    int i257 = ~(587902886 | i);
                                                    int i258 = ((1974528546 ^ i257) | (1974528546 & i257)) * 272;
                                                    if (i248 <= ((i256 | i258) << 1) - (i258 ^ i256)) {
                                                        int i259 = i239 >>> ((-983) >> ((~(((-17) ^ i241) | ((-17) & i241))) | i240));
                                                        int i260 = ~((i240 ^ i241) | (i240 & i241));
                                                        int i261 = ~iLastIndexOf;
                                                        int i262 = ~((i261 & 16) | (i261 ^ 16));
                                                        int i263 = i259 / (983 << ((i260 & i262) | (i260 ^ i262)));
                                                        i13 = 18750;
                                                        i11 = i263;
                                                        c2 = '0';
                                                        i12 = 0;
                                                    } else {
                                                        int i264 = ((~(((-17) ^ i241) | ((-17) & i241))) | i240) * (-983);
                                                        int i265 = (i239 ^ i264) + ((i239 & i264) << 1);
                                                        int i266 = ~iLastIndexOf;
                                                        int i267 = -(-(((~((i266 & i241) | (i266 ^ i241))) | (~((i240 ^ 16) | (i240 & 16)))) * 983));
                                                        i11 = (i265 & i267) + (i267 | i265);
                                                        i12 = 0;
                                                        i13 = 274;
                                                        c2 = '0';
                                                    }
                                                    int i268 = (i13 - (~(-TextUtils.lastIndexOf(str2, c2, i12)))) - 1;
                                                    Object[] objArr26 = new Object[1];
                                                    b(cArr4, i235, i11, i268, false, objArr26);
                                                    Class<?> cls7 = Class.forName((String) objArr26[0]);
                                                    char[] cArr5 = {CharUtils.CR, 18, 65530, 11, 11, 65498, 65534, CharUtils.CR, 18, 65499, '\b'};
                                                    int i269 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                                    int i270 = i269 * 70;
                                                    int i271 = (i270 & (-748)) + (i270 | (-748));
                                                    int i272 = ~i269;
                                                    int i273 = (i272 ^ (-12)) | (i272 & (-12));
                                                    int i274 = ~((i273 & i) | (i273 ^ i));
                                                    int i275 = (i269 ^ 11) | (i269 & 11);
                                                    int i276 = ~((i275 & i) | (i275 ^ i));
                                                    int i277 = ((i274 & i276) | (i274 ^ i276)) * 69;
                                                    int i278 = (~((i272 & i) | (i272 ^ i))) | (~((~i269) | 11));
                                                    int i279 = (((i271 ^ i277) + ((i271 & i277) << 1)) - (~(-(-(((i278 & i182) | (i278 ^ i182)) * (-69)))))) - 1;
                                                    int i280 = (~(i269 | (-12))) * 69;
                                                    int i281 = -Color.alpha(0);
                                                    int i282 = -TextUtils.lastIndexOf(str2, '0', 0, 0);
                                                    int i283 = ((i282 | 277) << 1) - (i282 ^ 277);
                                                    Object[] objArr27 = new Object[1];
                                                    b(cArr5, (i279 & i280) + (i280 | i279), ((i281 | 1) << 1) - (i281 ^ 1), i283, true, objArr27);
                                                    try {
                                                        Object[] objArr28 = {new ByteArrayInputStream((byte[]) cls7.getMethod((String) objArr27[0], null).invoke(obj, null))};
                                                        int i284 = -TextUtils.lastIndexOf(str2, '0', 0);
                                                        int iPostMessage11 = zzkf.postMessage();
                                                        int i285 = i284 * (-563);
                                                        int i286 = (i285 ^ 17919540) + ((i285 & 17919540) << 1);
                                                        int i287 = ~i284;
                                                        int i288 = ~iPostMessage11;
                                                        int i289 = ~((i288 & (-31717)) | ((-31717) ^ i288));
                                                        int i290 = (i289 & i287) | (i287 ^ i289);
                                                        int i291 = ~((iPostMessage11 ^ 31716) | (iPostMessage11 & 31716));
                                                        int i292 = i286 + (((i290 & i291) | (i290 ^ i291)) * (-564));
                                                        int i293 = getARTIFICIAL_FRAME_PACKAGE_NAME + 51;
                                                        int i294 = i293 % 128;
                                                        artificialFrame = i294;
                                                        int i295 = i293 % 2;
                                                        int i296 = (i287 & 31716) | (i287 ^ 31716);
                                                        int i297 = 1128 * (~((i296 & iPostMessage11) | (i296 ^ iPostMessage11)));
                                                        int i298 = (i292 & i297) + (i297 | i292);
                                                        int i299 = ~((~iPostMessage11) | (~i284));
                                                        int i300 = ~(i284 | 31716);
                                                        int i301 = -(-(((i300 & i299) | (i299 ^ i300)) * 564));
                                                        char c10 = (char) ((i298 ^ i301) + ((i301 & i298) << 1));
                                                        int i302 = i294 + 119;
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i302 % 128;
                                                        if (i302 % 2 != 0) {
                                                            Object[] objArr29 = new Object[1];
                                                            a(c10, 15741 << ExpandableListView.getPackedPositionChild(0L), 14 >>> KeyEvent.keyCodeFromString(str2), objArr29);
                                                            cls = Class.forName((String) objArr29[0]);
                                                            cLastIndexOf = (char) (40718 / TextUtils.lastIndexOf(str2, (char) 18, 1));
                                                            i14 = 26883;
                                                        } else {
                                                            int i303 = -(-ExpandableListView.getPackedPositionChild(0L));
                                                            int i304 = (i303 ^ 199) + ((i303 & 199) << 1);
                                                            int i305 = -(-KeyEvent.keyCodeFromString(str2));
                                                            Object[] objArr30 = new Object[1];
                                                            a(c10, i304, (i305 & 37) + (i305 | 37), objArr30);
                                                            Class<?> cls8 = Class.forName((String) objArr30[0]);
                                                            i14 = 235;
                                                            cLastIndexOf = (char) (TextUtils.lastIndexOf(str2, '0', 0) + 40718);
                                                            cls = cls8;
                                                        }
                                                        int doubleTapTimeout = ViewConfiguration.getDoubleTapTimeout() >> 16;
                                                        int i306 = doubleTapTimeout * 714;
                                                        int i307 = i14 * (-712);
                                                        int i308 = (i306 ^ i307) + ((i307 & i306) << 1);
                                                        int i309 = ~doubleTapTimeout;
                                                        int i310 = ~((i309 & i204) | (i309 ^ i204));
                                                        int i311 = ~doubleTapTimeout;
                                                        int i312 = ~((i311 ^ i14) | (i311 & i14));
                                                        int i313 = (i310 ^ i312) | (i310 & i312);
                                                        int i314 = ~i14;
                                                        int i315 = (i314 ^ doubleTapTimeout) | (i314 & doubleTapTimeout);
                                                        int i316 = ~((i315 ^ i) | (i315 & i));
                                                        int i317 = -(-(((i313 ^ i316) | (i313 & i316)) * (-713)));
                                                        int i318 = (i308 ^ i317) + ((i317 & i308) << 1);
                                                        int i319 = (~i14) | doubleTapTimeout;
                                                        int i320 = i318 + ((~((i319 & i) | (i319 ^ i))) * 1426);
                                                        int i321 = (~(i314 | i204)) * 713;
                                                        int i322 = (i320 ^ i321) + ((i321 & i320) << 1);
                                                        int i323 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                                                        int i324 = (i323 ^ 20) + ((i323 & 20) << 1);
                                                        Object[] objArr31 = new Object[1];
                                                        a(cLastIndexOf, i322, i324, objArr31);
                                                        Object objInvoke5 = cls.getMethod((String) objArr31[0], InputStream.class).invoke(objInvoke4, objArr28);
                                                        int length2 = objArr5.length;
                                                        int i325 = 0;
                                                        for (int i326 = 2; i325 < i326; i326 = 2) {
                                                            Object obj2 = objArr5[i325];
                                                            try {
                                                                int iIndexOf2 = 34 - TextUtils.indexOf(str2, str2, 0, 0);
                                                                int iKeyCodeFromString = KeyEvent.keyCodeFromString(str2);
                                                                int i327 = (iKeyCodeFromString ^ 11) + ((iKeyCodeFromString & 11) << 1);
                                                                int i328 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                                                int iPostMessage12 = zzkf.postMessage();
                                                                int i329 = i328 * 367;
                                                                int i330 = (i329 ^ 99090) + ((i329 & 99090) << 1) + (((i328 ^ RotationOptions.ROTATE_270) | (i328 & RotationOptions.ROTATE_270)) * (-366));
                                                                int i331 = ((~(((-271) & iPostMessage12) | ((-271) ^ iPostMessage12))) | i328) * (-366);
                                                                int i332 = ((i330 | i331) << 1) - (i331 ^ i330);
                                                                int i333 = ~i328;
                                                                int i334 = ~((i333 & RotationOptions.ROTATE_270) | (i333 ^ RotationOptions.ROTATE_270));
                                                                int i335 = ~(((-271) ^ i328) | (i328 & (-271)) | iPostMessage12);
                                                                Object[] objArr32 = new Object[1];
                                                                b(new char[]{'\n', 19, 22, 4, 6, 20, 65487, 2, 23, 2, 11, 6, 21, 2, 4, '\n', 7, '\n', 21, 19, 6, 65508, 65498, 65489, 65494, 65529, 65487, 21, 19, 6, 4, 65487, 26, 21}, iIndexOf2, i327, i332 + (((i335 & i334) | (i334 ^ i335)) * 366), true, objArr32);
                                                                Class<?> cls9 = Class.forName((String) objArr32[0]);
                                                                int i336 = -(-(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                                                                char c11 = (char) ((i336 ^ 30144) + ((i336 & 30144) << 1));
                                                                int i337 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                                                int iPostMessage13 = zzkf.postMessage();
                                                                int i338 = i337 * (-1939);
                                                                int i339 = (i338 & 246634) + (i338 | 246634);
                                                                int i340 = ~(((-255) ^ i337) | ((-255) & i337));
                                                                int i341 = ~iPostMessage13;
                                                                int i342 = ~((i341 ^ 254) | (i341 & 254));
                                                                int i343 = i339 + (((i340 ^ i342) | (i340 & i342)) * (-970));
                                                                int i344 = ~i337;
                                                                int i345 = -(-((~((i344 ^ 254) | (i344 & 254))) * 1940));
                                                                int i346 = (i343 ^ i345) + ((i343 & i345) << 1);
                                                                int i347 = getARTIFICIAL_FRAME_PACKAGE_NAME + 51;
                                                                artificialFrame = i347 % 128;
                                                                if (i347 % 2 == 0) {
                                                                    int i348 = ~(i344 | (-255));
                                                                    int i349 = -((i342 & i348) | (i348 ^ i342));
                                                                    i15 = (i346 - (~(((i349 | 970) << 1) - (i349 ^ 970)))) - 1;
                                                                    jumpTapTimeout = ViewConfiguration.getJumpTapTimeout() - 105;
                                                                    iPostMessage2 = zzkf.postMessage();
                                                                    int i350 = -jumpTapTimeout;
                                                                    i16 = (i350 & 491) + (i350 | 491);
                                                                    i17 = 76;
                                                                } else {
                                                                    int i351 = ~(i344 | (-255));
                                                                    int i352 = ~(i341 | 254);
                                                                    int i353 = -(-(((i351 & i352) | (i351 ^ i352)) * 970));
                                                                    i15 = (i346 & i353) + (i353 | i346);
                                                                    jumpTapTimeout = ViewConfiguration.getJumpTapTimeout() >> 16;
                                                                    iPostMessage2 = zzkf.postMessage();
                                                                    i16 = jumpTapTimeout * 491;
                                                                    i17 = 23;
                                                                }
                                                                int i354 = -(-((-489) * i17));
                                                                int i355 = (i16 ^ i354) + ((i16 & i354) << 1);
                                                                int i356 = ~jumpTapTimeout;
                                                                int i357 = ~i17;
                                                                int i358 = (i356 ^ i357) | (i356 & i357);
                                                                String str5 = str2;
                                                                int i359 = ~iPostMessage2;
                                                                int i360 = ((i358 ^ i359) | (i358 & i359)) * (-490);
                                                                int i361 = (i355 & i360) + (i355 | i360);
                                                                int i362 = ~i17;
                                                                int i363 = ((~((i362 & jumpTapTimeout) | (i362 ^ jumpTapTimeout))) | (~((i357 ^ iPostMessage2) | (iPostMessage2 & i357)))) * 490;
                                                                int i364 = ((i361 | i363) << 1) - (i361 ^ i363);
                                                                int i365 = i356 * 490;
                                                                int i366 = (i364 & i365) + (i364 | i365);
                                                                Object[] objArr33 = new Object[1];
                                                                a(c11, i15, i366, objArr33);
                                                                if (obj2.equals(cls9.getMethod((String) objArr33[0], null).invoke(objInvoke5, null))) {
                                                                    int[] iArr = new int[1];
                                                                    Object[] objArr34 = {new int[]{i}, new int[]{(~(i & 1)) & (i | 1)}, iArr, null};
                                                                    int i367 = (~((-207274003) | i)) | 207142912;
                                                                    int i368 = ~(i250 | 771480862);
                                                                    int i369 = (-448455394) + ((i367 | i368) * (-470)) + (((~((-131091) | i)) | i368) * 470);
                                                                    int i370 = ((i369 | 16) << 1) - (i369 ^ 16);
                                                                    int i371 = (i2 ^ i370) + ((i2 & i370) << 1);
                                                                    int i372 = getARTIFICIAL_FRAME_PACKAGE_NAME + 47;
                                                                    artificialFrame = i372 % 128;
                                                                    if (i372 % 2 == 0) {
                                                                        int i373 = i371 - 68;
                                                                        int i374 = (i373 | i371) & (~(i371 & i373));
                                                                        int i375 = i374 % 40;
                                                                        i18 = ((~i374) & i375) | ((~i375) & i374);
                                                                        i19 = 3;
                                                                    } else {
                                                                        int i376 = i371 << 13;
                                                                        int i377 = (i376 & (~i371)) | ((~i376) & i371);
                                                                        i18 = i377 ^ (i377 >>> 17);
                                                                        i19 = 5;
                                                                    }
                                                                    iArr[0] = i18 ^ (i18 << i19);
                                                                    return objArr34;
                                                                }
                                                                i325 = ((i325 | 1) << 1) - (i325 ^ 1);
                                                                str2 = str5;
                                                            } catch (Throwable th) {
                                                                Throwable cause = th.getCause();
                                                                if (cause != null) {
                                                                    throw cause;
                                                                }
                                                                throw th;
                                                            }
                                                        }
                                                        i206 = i244 + 1;
                                                        objArr20 = objArr25;
                                                        length = i242;
                                                        i187 = i250;
                                                        i20 = 2;
                                                        i24 = 1;
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
                Object[] objArr35 = {new int[]{i}, new int[]{i}, new int[]{i ^ (i << 5)}, null};
                int i378 = ~i;
                int i379 = (-221413010) + (((~((-881977530) | i378)) | 75538465) * 168) + ((~((-75538466) | i)) * 168) + (((~(i | (-806439065))) | (~(i378 | (-96646246))) | 21107780) * 168);
                int i380 = (i2 ^ i379) + ((i2 & i379) << 1);
                int i381 = i380 ^ (i380 << 13);
                int i382 = i381 >>> 17;
                int i383 = ((~i381) & i382) | ((~i382) & i381);
                return objArr35;
            }
        };
        if (executor == null) {
            executor = ExecutorsKt.asExecutor(Dispatchers.getMain());
        }
        listenableFuture.addListener(runnable, executor);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
