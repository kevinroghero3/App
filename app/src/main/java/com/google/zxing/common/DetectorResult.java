package com.google.zxing.common;

import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.zxing.ResultPoint;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.onPostMessage;

/* JADX INFO: loaded from: classes6.dex */
public class DetectorResult {
    private final BitMatrix bits;
    private final ResultPoint[] points;
    private static final byte[] $$c = {114, -78, -61, 42};
    private static final int $$d = 85;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {55, 117, 51, -11, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, -50, 50, Ascii.SO, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4};
    private static final int $$b = 253;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] IPostMessageService = {38277, 38345, 38353, 38355, 38350, 38353, 38374, 38279, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38284, 38361, 38355, 38373, 38375, 38351, 38353, 38357, 38361, 38365, 38357, 38353, 38355, 38353, 38372, 38372, 38357, 38357, 38360, 38226, 38065, 38224, 38222, 38062, 38070, 38067, 38062, 38065, 38070, 38231, 38230, 38073, 38067, 38063, 38068, 38070, 38072, 38071, 38069, 38069, 38212, 38212, 38065, 38067, 38065, 38069, 38077, 38073, 38069, 38065, 38063, 38215, 38181, 38187, 38176, 38182, 38169, 38285, 38364, 38356, 38353, 38360, 38363, 38366, 38360, 38359, 38390, 38383, 38357, 38390, 38389, 38355, 38356, 38390, 38387, 38356, 38356, 38353, 38382, 38386, 38355, 38356, 38360, 38391, 38391, 38312, 38390, 38363, 38364, 38356, 38353, 38360, 38363, 38366, 38360, 38359, 38356, 38351, 38311};

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r5, int r6, byte r7) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 4
            int r5 = r5 * 3
            int r5 = r5 + 65
            int r6 = r6 * 2
            int r6 = 1 - r6
            byte[] r0 = com.google.zxing.common.DetectorResult.$$c
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r5
            r5 = r6
            r3 = r2
            goto L27
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r5
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L25:
            r4 = r0[r7]
        L27:
            int r7 = r7 + 1
            int r5 = r5 + r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.DetectorResult.$$e(short, int, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(int r5, short r6, short r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 + 66
            int r7 = r7 + 2
            int r6 = r6 + 4
            byte[] r0 = com.google.zxing.common.DetectorResult.$$a
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L11
            r4 = r5
            r5 = r7
            r3 = r2
            goto L25
        L11:
            r3 = r2
        L12:
            int r6 = r6 + 1
            byte r4 = (byte) r5
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L23
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L23:
            r4 = r0[r6]
        L25:
            int r5 = r5 + r4
            int r5 = r5 + (-5)
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.DetectorResult.a(int, short, short, java.lang.Object[]):void");
    }

    public DetectorResult(BitMatrix bitMatrix, ResultPoint[] resultPointArr) {
        this.bits = bitMatrix;
        this.points = resultPointArr;
    }

    public final BitMatrix getBits() {
        return this.bits;
    }

    public final ResultPoint[] getPoints() {
        return this.points;
    }

    private static void b(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
        int i;
        int i2 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i3 = 0;
        int i4 = iArr[0];
        int i5 = 1;
        int i6 = iArr[1];
        int i7 = iArr[2];
        int i8 = iArr[3];
        char[] cArr = IPostMessageService;
        if (cArr != null) {
            int i9 = $10 + 25;
            $11 = i9 % 128;
            int i10 = i9 % 2;
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i11 = 0;
            while (i11 < length) {
                try {
                    Object[] objArr2 = new Object[i5];
                    objArr2[i3] = Integer.valueOf(cArr[i11]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i3;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - TextUtils.getOffsetBefore("", i3), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), 1562 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 178318710, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    cArr2[i11] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i11++;
                    int i12 = $11 + 37;
                    $10 = i12 % 128;
                    int i13 = i12 % 2;
                    i3 = 0;
                    i5 = 1;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i6];
        System.arraycopy(cArr, i4, cArr3, 0, i6);
        if (bArr != null) {
            int i14 = $11 + 73;
            $10 = i14 % 128;
            int i15 = i14 % 2;
            char[] cArr4 = new char[i6];
            onpostmessage.a = 0;
            char c = 0;
            while (onpostmessage.a < i6) {
                int i16 = $10 + 41;
                $11 = i16 % 128;
                int i17 = i16 % 2;
                if (bArr[onpostmessage.a] == 1) {
                    int i18 = $11 + 113;
                    $10 = i18 % 128;
                    int i19 = i18 % 2;
                    int i20 = onpostmessage.a;
                    Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                    if (objAccessartificialFrame2 == null) {
                        int modifierMetaStateMask = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.CAN;
                        char maxKeyCode = (char) (KeyEvent.getMaxKeyCode() >> 16);
                        int modifierMetaStateMask2 = ((byte) KeyEvent.getModifierMetaStateMask()) + 2442;
                        byte b3 = (byte) ($$d & 3);
                        byte b4 = (byte) (b3 - 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, maxKeyCode, modifierMetaStateMask2, -850656813, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i20] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                } else {
                    int i21 = onpostmessage.a;
                    Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(11 - Color.red(0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1563, 1918398056, false, $$e((byte) 19, b5, b5), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i21] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                }
                c = cArr4[onpostmessage.a];
                Object[] objArr5 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(22 - TextUtils.getCapsMode("", 0, 0), (char) ((ViewConfiguration.getTouchSlop() >> 8) + 29363), KeyEvent.keyCodeFromString("") + JfifUtil.MARKER_RST7, -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            cArr3 = cArr4;
        }
        if (i8 > 0) {
            char[] cArr5 = new char[i6];
            i = 0;
            System.arraycopy(cArr3, 0, cArr5, 0, i6);
            int i22 = i6 - i8;
            System.arraycopy(cArr5, 0, cArr3, i22, i8);
            System.arraycopy(cArr5, i8, cArr3, 0, i22);
        } else {
            i = 0;
        }
        if (!(!z)) {
            char[] cArr6 = new char[i6];
            while (true) {
                onpostmessage.a = i;
                if (onpostmessage.a >= i6) {
                    break;
                }
                int i23 = $10 + 47;
                $11 = i23 % 128;
                int i24 = i23 % 2;
                cArr6[onpostmessage.a] = cArr3[(i6 - onpostmessage.a) - 1];
                i = onpostmessage.a + 1;
            }
            cArr3 = cArr6;
        }
        if (i7 > 0) {
            int i25 = $11 + 5;
            $10 = i25 % 128;
            int i26 = i25 % 2;
            onpostmessage.a = 0;
            int i27 = $10 + 35;
            $11 = i27 % 128;
            int i28 = i27 % 2;
            while (onpostmessage.a < i6) {
                cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                onpostmessage.a++;
            }
        }
        objArr[0] = new String(cArr3);
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r31, int r32, int r33, int r34) {
        /*
            Method dump skipped, instruction units count: 2403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.DetectorResult.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
