package com.reactnativecommunity.asyncstorage;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.asBinder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeAsyncStorageModuleSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    private static final byte[] $$c = {32, -45, -106, 106};
    private static final int $$d = 213;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {98, -62, -118, -34, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, -50, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4, 50, Ascii.SO};
    private static final int $$b = 237;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long extraCommand = -7179957193726136144L;

    private static String $$e(int i, byte b, int i2) {
        byte[] bArr = $$c;
        int i3 = 4 - (b * 3);
        int i4 = 118 - (i2 * 2);
        int i5 = i * 3;
        byte[] bArr2 = new byte[i5 + 1];
        int i6 = -1;
        if (bArr == null) {
            i3++;
            i4 = i3 + i5;
        }
        while (true) {
            int i7 = i4;
            int i8 = i3;
            i6++;
            bArr2[i6] = (byte) i7;
            if (i6 == i5) {
                return new String(bArr2, 0);
            }
            i3 = i8 + 1;
            i4 = i7 + bArr[i8];
        }
    }

    private static void a(int i, int i2, int i3, Object[] objArr) {
        byte[] bArr = $$a;
        int i4 = i2 + 4;
        int i5 = i + 66;
        byte[] bArr2 = new byte[28 - i3];
        int i6 = 27 - i3;
        int i7 = -1;
        if (bArr == null) {
            i5 = (i6 + i4) - 5;
            i4 = i4;
            i7 = -1;
        }
        while (true) {
            int i8 = i7 + 1;
            bArr2[i8] = (byte) i5;
            int i9 = i4 + 1;
            if (i8 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                i5 = (i5 + bArr[i9]) - 5;
                i4 = i9;
                i7 = i8;
            }
        }
    }

    @ReactMethod
    public abstract void clear(Callback callback);

    @ReactMethod
    public abstract void getAllKeys(Callback callback);

    @ReactMethod
    public abstract void multiGet(ReadableArray readableArray, Callback callback);

    @ReactMethod
    public abstract void multiMerge(ReadableArray readableArray, Callback callback);

    @ReactMethod
    public abstract void multiRemove(ReadableArray readableArray, Callback callback);

    @ReactMethod
    public abstract void multiSet(ReadableArray readableArray, Callback callback);

    public NativeAsyncStorageModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i4 = $11 + 105;
            $10 = i4 % 128;
            if (i4 % i2 != 0) {
                int i5 = asbinder.d;
                char c = cArr[asbinder.d];
                try {
                    Object[] objArr2 = new Object[3];
                    objArr2[i2] = asbinder;
                    objArr2[1] = asbinder;
                    objArr2[0] = Integer.valueOf(c);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                    if (objAccessartificialFrame == null) {
                        int scrollBarSize = 11 - (ViewConfiguration.getScrollBarSize() >> 8);
                        char size = (char) View.MeasureSpec.getSize(0);
                        int iIndexOf = TextUtils.indexOf("", "") + 1407;
                        byte b = (byte) 0;
                        byte b2 = b;
                        String str$$e = $$e(b, b2, b2);
                        Class[] clsArr = new Class[3];
                        clsArr[0] = Integer.TYPE;
                        clsArr[1] = Object.class;
                        clsArr[i2] = Object.class;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(scrollBarSize, size, iIndexOf, 1035473698, false, str$$e, clsArr);
                    }
                    jArr[i5] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() % (extraCommand ^ (-2360974883025274865L));
                    Object[] objArr3 = {asbinder, asbinder};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame2 == null) {
                        int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 8;
                        char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                        int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 249;
                        Class[] clsArr2 = new Class[i2];
                        clsArr2[0] = Object.class;
                        clsArr2[1] = Object.class;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, jumpTapTimeout, windowTouchSlop, 378009232, false, "w", clsArr2);
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } else {
                int i6 = asbinder.d;
                char c2 = cArr[asbinder.d];
                Object[] objArr4 = new Object[3];
                objArr4[i2] = asbinder;
                objArr4[1] = asbinder;
                objArr4[0] = Integer.valueOf(c2);
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame3 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(11 - View.MeasureSpec.getSize(0), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), 1407 - (ViewConfiguration.getTouchSlop() >> 8), 1035473698, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i6] = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr5 = {asbinder, asbinder};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(7 - MotionEvent.axisFromString(""), (char) TextUtils.getOffsetBefore("", 0), ImageFormat.getBitsPerPixel(0) + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                i2 = 2;
            }
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i7 = $11 + 105;
            $10 = i7 % 128;
            if (i7 % 2 != 0) {
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                Object[] objArr6 = {asbinder, asbinder};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(8 - (Process.myTid() >> 22), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1), 248 - TextUtils.lastIndexOf("", '0', 0, 0), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                Object obj = null;
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                obj.hashCode();
                throw null;
            }
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            Object[] objArr7 = {asbinder, asbinder};
            Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1981632360);
            if (objAccessartificialFrame6 == null) {
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(8 - Drawable.resolveOpacity(0, 0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), Color.green(0) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame6).invoke(null, objArr7);
        }
        objArr[0] = new String(cArr2);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:36:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:63:0x056e A[PHI: r25 r26
  0x056e: PHI (r25v2 java.lang.String) = (r25v27 java.lang.String), (r25v28 java.lang.String) binds: [B:57:0x0514, B:62:0x056c] A[DONT_GENERATE, DONT_INLINE]
  0x056e: PHI (r26v2 java.lang.Class[]) = (r26v22 java.lang.Class[]), (r26v23 java.lang.Class[]) binds: [B:57:0x0514, B:62:0x056c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:65:0x0574  */
    /* JADX WARN: Code duplicated, block: B:67:0x05d5  */
    /* JADX WARN: Code duplicated, block: B:68:0x05e6  */
    /* JADX WARN: Code duplicated, block: B:71:0x060c  */
    /* JADX WARN: Code duplicated, block: B:72:0x0627  */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x08a6, code lost:
    
        if (r0.equals((java.lang.String) r5[0]) != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x08a8, code lost:
    
        r26 = r26;
        r26 = r26;
        r3 = new java.lang.Object[]{new int[]{r30}, new int[]{(r30 & (-11)) | (r26 & 10)}, new int[1], null};
        r0 = new java.util.Random().nextInt(28906398);
        r1 = ((((~((-719147635) | r0)) | 545787986) * (-283)) + 817801156) + ((~(r0 | (-173359649))) * 283);
        r0 = ((r1 | 16) << 1) - (r1 ^ 16);
        r1 = io.sentry.android.core.ActivityFramesTracker$$ExternalSyntheticLambda1.l();
        r5 = com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec.artificialFrame;
        r6 = ((r5 | 123) << 1) - (r5 ^ 123);
        r4 = r6 % 128;
        com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec.getARTIFICIAL_FRAME_PACKAGE_NAME = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0907, code lost:
    
        if ((r6 % 2) == 0) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0909, code lost:
    
        r5 = ((-1940) - (~(-r0))) % (971 >>> r32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0911, code lost:
    
        r6 = ~r32;
        r6 = ~((r6 & r0) | (r6 ^ r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0918, code lost:
    
        r5 = ((r0 * (-1939)) - (~(r32 * 971))) - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0921, code lost:
    
        r1 = ~r1;
        r7 = ~((r1 ^ r32) | (r1 & r32));
        r5 = r5 + ((-970) * ((r6 & r7) | (r6 ^ r7)));
        r6 = ~r0;
        r6 = (~((r6 & r32) | (r6 ^ r32))) * 1940;
        r7 = (r5 ^ r6) + ((r5 & r6) << 1);
        r0 = ~r0;
        r5 = ~r32;
        r0 = ~((r0 & r5) | (r0 ^ r5));
        r1 = ~((r1 & r32) | (r1 ^ r32));
        r7 = r7 + (((r0 & r1) | (r0 ^ r1)) * 970);
        r0 = r7 << 13;
        r0 = (r0 | r7) & (~(r7 & r0));
        r4 = r4 + 73;
        com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec.artificialFrame = r4 % 128;
        r4 = r4 % 2;
        r1 = r0 >>> 17;
        r0 = ((~r0) & r1) | ((~r1) & r0);
        r1 = r0 << 5;
        ((int[]) r3[2])[0] = ((~r0) & r1) | ((~r1) & r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0787, code lost:
    
        if (r0 == 0) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x078e, code lost:
    
        if (r0 == 1) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0792, code lost:
    
        r26 = r26;
        r26 = r26;
        r0 = (r3 ^ 31) + ((r3 & 31) << r4);
        com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec.artificialFrame = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v10 */
    /* JADX WARN: Type inference failed for: r25v11 */
    /* JADX WARN: Type inference failed for: r25v23 */
    /* JADX WARN: Type inference failed for: r25v24 */
    /* JADX WARN: Type inference failed for: r25v25 */
    /* JADX WARN: Type inference failed for: r25v26 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r25v8 */
    /* JADX WARN: Type inference failed for: r26v10 */
    /* JADX WARN: Type inference failed for: r26v17 */
    /* JADX WARN: Type inference failed for: r26v18 */
    /* JADX WARN: Type inference failed for: r26v19 */
    /* JADX WARN: Type inference failed for: r26v20 */
    /* JADX WARN: Type inference failed for: r26v21 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r26v5 */
    /* JADX WARN: Type inference failed for: r26v6 */
    /* JADX WARN: Type inference failed for: r26v8 */
    /* JADX WARN: Type inference failed for: r26v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r29, int r30, int r31, int r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2883
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
