package com.google.android.material.color;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.ColorInt;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.artificialFrame;

/* JADX INFO: loaded from: classes5.dex */
public final class ColorRoles {
    private final int accent;
    private final int accentContainer;
    private final int onAccent;
    private final int onAccentContainer;
    private static final byte[] $$c = {35, -18, 33, -64};
    private static final int $$d = 23;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {72, -88, 5, 32, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, -50, 50, Ascii.SO, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4};
    private static final int $$b = 145;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int[] ICustomTabsCallbackStub = {2057258650, -1605590565, 1255671047, 1842535415, 167973220, -328187815, -834964537, 1494578299, -382647215, 1044944596, 1510369754, 846205703, 850873575, 757836709, 1298685016, -2073209189, 80072217, -1489719055};

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r7, short r8, int r9) {
        /*
            int r7 = r7 * 6
            int r7 = r7 + 109
            int r8 = r8 * 3
            int r8 = 1 - r8
            byte[] r0 = com.google.android.material.color.ColorRoles.$$c
            int r9 = r9 * 2
            int r9 = 3 - r9
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r9
            r5 = r2
            r9 = r8
            goto L2d
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L25:
            int r9 = r9 + 1
            r3 = r0[r9]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r6
        L2d:
            int r7 = -r7
            int r7 = r7 + r9
            r9 = r3
            r3 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.ColorRoles.$$e(byte, short, int):java.lang.String");
    }

    private static void a(int i, byte b, int i2, Object[] objArr) {
        byte[] bArr = $$a;
        int i3 = 115 - i;
        int i4 = 52 - i2;
        byte[] bArr2 = new byte[28 - b];
        int i5 = 27 - b;
        int i6 = -1;
        if (bArr == null) {
            i3 = (i3 + i4) - 5;
            i4 = i4;
            i6 = -1;
        }
        while (true) {
            int i7 = i6 + 1;
            int i8 = i4 + 1;
            bArr2[i7] = (byte) i3;
            if (i7 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                i3 = (i3 + bArr[i8]) - 5;
                i4 = i8;
                i6 = i7;
            }
        }
    }

    ColorRoles(@ColorInt int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4) {
        this.accent = i;
        this.onAccent = i2;
        this.accentContainer = i3;
        this.onAccentContainer = i4;
    }

    public int getAccent() {
        return this.accent;
    }

    public int getOnAccent() {
        return this.onAccent;
    }

    public int getAccentContainer() {
        return this.accentContainer;
    }

    public int getOnAccentContainer() {
        return this.onAccentContainer;
    }

    private static void b(int i, int[] iArr, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = ICustomTabsCallbackStub;
        int i4 = -1780896814;
        int i5 = 1;
        int i6 = 0;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i7 = 0;
            while (i7 < length) {
                int i8 = $10 + 85;
                $11 = i8 % 128;
                if (i8 % i2 == 0) {
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i6] = Integer.valueOf(iArr2[i7]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i6;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(i6, i6) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(i6, i6) == 0L ? 0 : -1))), 1562 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 180153818, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        iArr3[i7] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    Object[] objArr3 = {Integer.valueOf(iArr2[i7])};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(11 - Drawable.resolveOpacity(0, 0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), 1561 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 180153818, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE});
                    }
                    iArr3[i7] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                }
                i7++;
                i2 = 2;
                i4 = -1780896814;
                i6 = 0;
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = ICustomTabsCallbackStub;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i9 = $11 + 69;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            int i11 = 0;
            while (i11 < length3) {
                Object[] objArr4 = new Object[i5];
                objArr4[0] = Integer.valueOf(iArr5[i11]);
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (Color.rgb(0, 0, 0) + 16777216), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 1562, 180153818, false, $$e(b5, b6, b6), new Class[]{Integer.TYPE});
                }
                iArr6[i11] = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                i11++;
                iArr5 = iArr5;
                i5 = 1;
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        artificialframe.e = 0;
        int i12 = $10 + 123;
        $11 = i12 % 128;
        if (i12 % 2 == 0) {
            int i13 = 4 / 2;
        }
        while (artificialframe.e < iArr.length) {
            cArr[0] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr4);
            int i14 = 0;
            for (int i15 = 16; i14 < i15; i15 = 16) {
                int i16 = $10 + 117;
                $11 = i16 % 128;
                int i17 = i16 % 2;
                artificialframe.c ^= iArr4[i14];
                Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                if (objAccessartificialFrame4 == null) {
                    int jumpTapTimeout = 26 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                    char pressedStateDuration = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                    int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 1041;
                    byte b7 = (byte) ($$d & 1);
                    byte b8 = (byte) (b7 - 1);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, pressedStateDuration, iCombineMeasuredStates, 995482881, false, $$e(b7, b8, b8), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                artificialframe.c = artificialframe.b;
                artificialframe.b = iIntValue;
                i14++;
            }
            int i18 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i18;
            artificialframe.b ^= iArr4[16];
            artificialframe.c ^= iArr4[17];
            int i19 = artificialframe.c;
            int i20 = artificialframe.b;
            cArr[0] = (char) (artificialframe.c >>> 16);
            cArr[1] = (char) artificialframe.c;
            cArr[2] = (char) (artificialframe.b >>> 16);
            cArr[3] = (char) artificialframe.b;
            artificialFrame.coroutineBoundary(iArr4);
            cArr2[artificialframe.e * 2] = cArr[0];
            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
            try {
                Object[] objArr6 = {artificialframe, artificialframe};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1348396126);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0) + 38, (char) (28010 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), Gravity.getAbsoluteGravity(0, 0) + 306, -818175402, false, "q", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0370  */
    /* JADX WARN: Code duplicated, block: B:41:0x0372  */
    /* JADX WARN: Code duplicated, block: B:75:0x064a  */
    /* JADX WARN: Code duplicated, block: B:77:0x0650  */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0a8b, code lost:
    
        if (r0.equals((java.lang.String) r3[0]) != true) goto L133;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r29, int r30, int r31, int r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.ColorRoles.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
