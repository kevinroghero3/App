package com.google.common.collect;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import java.io.Serializable;
import java.lang.Comparable;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.artificialFrame;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RangeGwtSerializationDependencies<C extends Comparable> implements Serializable {
    private static final byte[] $$c = {Ascii.ESC, -99, -92, 1};
    private static final int $$d = 156;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {55, 117, 51, -11, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, -50, 50, Ascii.SO, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4};
    private static final int $$b = 107;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int[] ICustomTabsCallbackStub = {187252826, 1604240195, -414675503, 507604652, 1758678652, -54443594, 1227180093, 569270710, -2000364716, 1268770879, 2129984997, -517972705, 290025882, -349989746, 1138462286, 1234147019, 2029486423, -1235360622};

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r5, int r6, short r7) {
        /*
            int r5 = r5 + 4
            byte[] r0 = com.google.common.collect.RangeGwtSerializationDependencies.$$c
            int r6 = r6 * 4
            int r1 = 1 - r6
            int r7 = r7 * 6
            int r7 = r7 + 109
            byte[] r1 = new byte[r1]
            r2 = 0
            int r6 = 0 - r6
            if (r0 != 0) goto L17
            r4 = r7
            r3 = r2
            r7 = r6
            goto L29
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r5 = r5 + 1
            if (r3 != r6) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L25:
            int r3 = r3 + 1
            r4 = r0[r5]
        L29:
            int r7 = r7 + r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RangeGwtSerializationDependencies.$$e(int, int, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(int r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.google.common.collect.RangeGwtSerializationDependencies.$$a
            int r7 = 53 - r7
            int r8 = r8 + 2
            int r9 = 115 - r9
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L11
            r9 = r7
            r3 = r8
            r4 = r2
            goto L27
        L11:
            r3 = r2
        L12:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L21
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L21:
            r3 = r0[r7]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r6
        L27:
            int r3 = r3 + r7
            int r7 = r9 + 1
            int r9 = r3 + (-5)
            r3 = r4
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RangeGwtSerializationDependencies.a(int, short, byte, java.lang.Object[]):void");
    }

    RangeGwtSerializationDependencies() {
    }

    private static void b(int i, int[] iArr, Object[] objArr) throws Throwable {
        int length;
        int[] iArr2;
        int i2;
        int length2;
        int[] iArr3;
        int i3;
        int i4 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr4 = ICustomTabsCallbackStub;
        int i5 = -1780896814;
        char c = 3;
        int i6 = 1;
        int i7 = 0;
        if (iArr4 != null) {
            int i8 = $11 + 1;
            $10 = i8 % 128;
            if (i8 % 2 != 0) {
                length2 = iArr4.length;
                iArr3 = new int[length2];
                i3 = 1;
            } else {
                length2 = iArr4.length;
                iArr3 = new int[length2];
                i3 = 0;
            }
            while (i3 < length2) {
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i7] = Integer.valueOf(iArr4[i3]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                    if (objAccessartificialFrame == null) {
                        int iKeyCodeFromString = 11 - KeyEvent.keyCodeFromString("");
                        char touchSlop = (char) (ViewConfiguration.getTouchSlop() >> 8);
                        int i9 = 1562 - (TypedValue.complexToFraction(i7, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(i7, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                        byte b = (byte) (-$$c[c]);
                        byte b2 = (byte) (b + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, touchSlop, i9, 180153818, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    iArr3[i3] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i3++;
                    int i10 = $11 + 55;
                    $10 = i10 % 128;
                    int i11 = i10 % 2;
                    i5 = -1780896814;
                    c = 3;
                    i7 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            iArr4 = iArr3;
        }
        int length3 = iArr4.length;
        int[] iArr5 = new int[length3];
        int[] iArr6 = ICustomTabsCallbackStub;
        if (iArr6 != null) {
            int i12 = $10 + 65;
            $11 = i12 % 128;
            if (i12 % 2 == 0) {
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
                    Object[] objArr3 = new Object[i6];
                    objArr3[0] = Integer.valueOf(iArr6[i2]);
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                    if (objAccessartificialFrame2 == null) {
                        int iArgb = 11 - Color.argb(0, 0, 0, 0);
                        char scrollBarSize = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                        int iRgb = (-16775654) - Color.rgb(0, 0, 0);
                        byte b3 = (byte) (-$$c[3]);
                        byte b4 = (byte) (b3 + 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iArgb, scrollBarSize, iRgb, 180153818, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE});
                    }
                    iArr2[i2] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    i2++;
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
        char c2 = 0;
        System.arraycopy(iArr6, 0, iArr5, 0, length3);
        artificialframe.e = 0;
        while (artificialframe.e < iArr.length) {
            cArr[c2] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr5);
            for (int i13 = 0; i13 < 16; i13++) {
                artificialframe.c ^= iArr5[i13];
                Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                if (objAccessartificialFrame3 == null) {
                    int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27;
                    char fadingEdgeLength = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                    int tapTimeout = 1041 - (ViewConfiguration.getTapTimeout() >> 16);
                    byte b5 = $$c[3];
                    byte b6 = (byte) (-b5);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf, fadingEdgeLength, tapTimeout, 995482881, false, $$e(b6, (byte) (b6 + 1), b5), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                artificialframe.c = artificialframe.b;
                artificialframe.b = iIntValue;
            }
            int i14 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i14;
            artificialframe.b ^= iArr5[16];
            artificialframe.c ^= iArr5[17];
            int i15 = artificialframe.c;
            int i16 = artificialframe.b;
            cArr[0] = (char) (artificialframe.c >>> 16);
            cArr[1] = (char) artificialframe.c;
            cArr[2] = (char) (artificialframe.b >>> 16);
            cArr[3] = (char) artificialframe.b;
            artificialFrame.coroutineBoundary(iArr5);
            cArr2[artificialframe.e * 2] = cArr[0];
            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
            Object[] objArr5 = {artificialframe, artificialframe};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1348396126);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 38, (char) (TextUtils.getCapsMode("", 0, 0) + 28010), View.MeasureSpec.makeMeasureSpec(0, 0) + 306, -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            c2 = 0;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v216 */
    /* JADX WARN: Type inference failed for: r0v263 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v31, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v67 */
    /* JADX WARN: Type inference failed for: r5v148 */
    /* JADX WARN: Type inference failed for: r5v52 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r7v129 */
    /* JADX WARN: Type inference failed for: r8v112 */
    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 3160
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RangeGwtSerializationDependencies.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
