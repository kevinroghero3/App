package com.salesforce.marketingcloud.util;

import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.Collection;
import o.ArtificialStackFrames;
import o._CREATION;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    private static final byte[] $$c = {119, 121, -44, Ascii.VT};
    private static final int $$d = 89;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {114, 98, 44, 76, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, 50, Ascii.SO, -50, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4};
    private static final int $$b = 224;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] _CREATION = {6559, 60928, 63162, 65340, 51153, 52295, 54522, 56608, 42269, 44417, 45616, 47802, 33627, 35776, 36970, 39072, 24765, 26881, 29104, 17978, 20187, 22358, 24554, 56474, 11016, 13225, 14860, 717, 2397, 4593, 6244, 24606, 26764, 30505, 32676, 18002, 20163, 21844, 24035, 42395, 44034, 37427, 26028, 32022, 29840, 19581, 18411, 24406, 22156, 11953, 9773, 14748, 12566, 2295, 'l', 7110, 4876, 60194, 58031, 64092, 52643, 50530, 56562, 54366, 45003, 42929, 48931, 46726, 36363, 33277, 39276, 37115, 26700, 24628, 31661, 6552, 60930, 63167, 65321, 51149, 33606, 29852, 27709, 26042, 23814, 22224, 20071, 18416, 16285, 14166, 10405, 8245, 6594, 4445, 2724, 637, 64012, 62363, 60220, 56510, 54350, 52696, 50539, 48885, 46732, 44631, 42939, 40762, 6540, 60929, 63216, 65322, 51163, 52300, 54507, 56681, 42265, 44431, 45628, 47778, 33627, 14613};
    private static long _BOUNDARY = -8361866239009952146L;

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
            int r7 = r7 + 103
            int r6 = r6 * 4
            int r0 = 1 - r6
            byte[] r1 = com.salesforce.marketingcloud.util.g.$$c
            int r5 = r5 * 4
            int r5 = 4 - r5
            byte[] r0 = new byte[r0]
            r2 = 0
            int r6 = 0 - r6
            if (r1 != 0) goto L17
            r7 = r5
            r3 = r6
            r4 = r2
            goto L27
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r7
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L25:
            r3 = r1[r5]
        L27:
            int r5 = r5 + 1
            int r7 = r7 + r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.util.g.$$e(short, int, byte):java.lang.String");
    }

    private g() {
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r5, short r6, int r7, java.lang.Object[] r8) {
        /*
            int r0 = r7 + 2
            byte[] r1 = com.salesforce.marketingcloud.util.g.$$a
            int r5 = r5 + 66
            int r6 = 53 - r6
            byte[] r0 = new byte[r0]
            int r7 = r7 + 1
            r2 = 0
            if (r1 != 0) goto L13
            r4 = r5
            r5 = r7
            r3 = r2
            goto L25
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r5
            r0[r3] = r4
            if (r3 != r7) goto L21
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L21:
            int r3 = r3 + 1
            r4 = r1[r6]
        L25:
            int r5 = r5 + r4
            int r5 = r5 + (-5)
            int r6 = r6 + 1
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.util.g.b(short, short, int, java.lang.Object[]):void");
    }

    public static <T extends CharSequence> T a(T t, String str) {
        if (TextUtils.isEmpty(t)) {
            throw new IllegalArgumentException(str);
        }
        return t;
    }

    public static <T extends Collection> T a(T t, String str) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException(str);
        }
        return t;
    }

    public static boolean a(boolean z, String str) {
        if (z) {
            return true;
        }
        throw new IllegalArgumentException(str);
    }

    private static void c(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i4 = _creation.b;
            try {
                Object[] objArr2 = {Integer.valueOf(_CREATION[i + i4])};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 9, (char) (9280 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), 1977 - KeyEvent.normalizeMetaState(0), 1113883676, false, $$e(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                }
                Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i4), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 30, (char) (49363 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), (Process.myPid() >> 22) + 684, -115095555, false, $$e(b3, b4, (byte) (b4 + 3)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i4] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                Object[] objArr4 = {_creation, _creation};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Color.green(0) + 25, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 30067), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 815, 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
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
        int i5 = $10 + 67;
        $11 = i5 % 128;
        int i6 = i5 % 2;
        while (_creation.b < i2) {
            int i7 = $11 + 105;
            $10 = i7 % 128;
            if (i7 % 2 != 0) {
                cArr[_creation.b] = (char) jArr[_creation.b];
                Object[] objArr5 = {_creation, _creation};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) 0;
                    byte b8 = b7;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(24 - MotionEvent.axisFromString(""), (char) (30067 - TextUtils.lastIndexOf("", '0', 0, 0)), View.getDefaultSize(0, 0) + 816, 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                throw null;
            }
            cArr[_creation.b] = (char) jArr[_creation.b];
            try {
                Object[] objArr6 = {_creation, _creation};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame5 == null) {
                    byte b9 = (byte) 0;
                    byte b10 = b9;
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0, 0) + 26, (char) (30068 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 817, 1897803493, false, $$e(b9, b10, b10), new Class[]{Object.class, Object.class});
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
        objArr[0] = new String(cArr);
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0aa4 A[Catch: all -> 0x0c13, TryCatch #1 {all -> 0x0c13, blocks: (B:105:0x0a97, B:107:0x0aa4, B:108:0x0aec), top: B:138:0x0a97, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0760  */
    /* JADX WARN: Code duplicated, block: B:62:0x0766  */
    /* JADX WARN: Code duplicated, block: B:64:0x07f7  */
    /* JADX WARN: Code duplicated, block: B:66:0x0810  */
    /* JADX WARN: Code duplicated, block: B:82:0x08c3 A[Catch: all -> 0x09e0, TryCatch #0 {all -> 0x09e0, blocks: (B:80:0x08b6, B:82:0x08c3, B:83:0x090f), top: B:136:0x08b6, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0928  */
    /* JADX WARN: Code duplicated, block: B:88:0x0991  */
    /* JADX WARN: Code duplicated, block: B:91:0x09b7  */
    /* JADX WARN: Code duplicated, block: B:94:0x09db  */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0b28, code lost:
    
        if (r5.equals((java.lang.String) r3[0]) != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0b2a, code lost:
    
        r3 = com.salesforce.marketingcloud.util.g.artificialFrame;
        r4 = (r3 ^ 13) + ((13 & r3) << 1);
        r0 = r4 % 128;
        com.salesforce.marketingcloud.util.g.getARTIFICIAL_FRAME_PACKAGE_NAME = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0b38, code lost:
    
        if ((r4 % 2) == 0) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0b3a, code lost:
    
        r3 = (r35 & (-70)) | (r8 & 69);
        r4 = 1;
        r5 = new java.lang.Object[]{new int[0], new int[1]};
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0b4d, code lost:
    
        r4 = 1;
        r3 = (r35 & (-11)) | (r8 & 10);
        r5 = new java.lang.Object[4];
        r5[0] = new int[1];
        r5[1] = new int[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0b60, code lost:
    
        r5[2] = new int[r4];
        r6 = (r0 ^ 35) + ((r0 & 35) << r4);
        com.salesforce.marketingcloud.util.g.artificialFrame = r6 % 128;
        r6 = r6 % 2;
        ((int[]) r5[0])[0] = r35;
        ((int[]) r5[r4])[0] = r3;
        r5[3] = null;
        r0 = (((~((-4886623) | r8)) * 130) - 1267599262) + (((~(r35 | (-4886623))) | 805309056) * 130);
        r1 = com.google.android.material.navigation.NavigationView$$ExternalSyntheticLambda0.f();
        r3 = -(-(r0 * 382));
        r6 = (((-6080) | r3) << 1) - (r3 ^ (-6080));
        r3 = (r0 ^ r1) | (r0 & r1);
        r3 = -(-(((r3 & (-17)) | (r3 ^ (-17))) * (-381)));
        r4 = (r6 ^ r3) + ((r3 & r6) << 1);
        r3 = com.salesforce.marketingcloud.util.g.getARTIFICIAL_FRAME_PACKAGE_NAME + 69;
        com.salesforce.marketingcloud.util.g.artificialFrame = r3 % 128;
        r3 = r3 % 2;
        r3 = ~r0;
        r3 = ~((r3 & (-17)) | ((-17) ^ r3));
        r1 = ~((~r1) | r0);
        r1 = (r1 & r3) | (r3 ^ r1);
        r3 = ~((16 & r0) | (16 ^ r0));
        r4 = (r4 - (~(((r1 & r3) | (r1 ^ r3)) * 381))) - 1;
        r0 = -(-((~((r0 & (-17)) | ((-17) ^ r0))) * 381));
        r3 = (r4 ^ r0) + ((r0 & r4) << 1);
        r0 = (r37 ^ r3) + ((r37 & r3) << 1);
        r0 = r0 ^ (r0 << 13);
        r1 = r0 >>> 17;
        r0 = ((~r0) & r1) | ((~r1) & r0);
        r1 = r0 << 5;
        ((int[]) r5[2])[0] = (r0 | r1) & (~(r0 & r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:?, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x09b3, code lost:
    
        if (((r3 & r4) | (r3 ^ r4)) == 1) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x09d7, code lost:
    
        if (((r3 & r4) | (r3 ^ r4)) == 1) goto L112;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object[] coroutineCreation(android.content.Context r34, int r35, int r36, int r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.util.g.coroutineCreation(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
