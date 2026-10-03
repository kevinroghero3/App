package com.google.android.datatransport.cct.internal;

import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda0;
import com.google.common.base.Ascii;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o._CREATION;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ExternalPrivacyContext {
    private static final byte[] $$c = {104, 117, 100, 60};
    private static final int $$d = 79;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {103, 5, 74, Ascii.SYN, Ascii.VT, 2, -12};
    private static final int $$b = 209;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] _CREATION = {6551, 41449, 26994, 12471, 63500, 32895, 19393, 4901, 55995, 25096, 10837, 62941, 48416, 17540, 3299, 54337, 40906, 10047, 61074, 6537, 41467, 26975, 12454, 63495, 32868, 19393, 4868, 55985, 25096, 10834, 62935, 48428, 17567, 3297, 54341, 40923, 10024, 12989, 35542, 17008, 7042, 54051, 43841, 24800, 14414, 61843, 18731, 282, 57044, 38409, 28586, 10193, 65383, 58835, 24043, 38221, 52387, 1091, 31843, 47041, 61234, 9906, 40477, 54904, 2463, 16680, 47245, 61670, 10325, 25563, 56183, 4736, 19170, 33357, 50603, 15629, 30062, 44283, 58391, 24503, 38661, 53118, 1754, 32289, 45454, 59656, 8519, 39104, 53282, 2957, 17387, 47937, 62130, 6193, 41044, 26855, 46114, 3097, 50359, 40270, 22014, 11734, 58918, 48840, 30558, 53158, 34702, 22564, 4303, 59767, 41232, 31165, 12898, 35535, 17265, 6931, 54204, 37978, 27888, 9390, 64776, 46503, 3652, 50915, 40593, 22332, 12241, 60213, 20017, 62985, 16047, 26433, 44961, 55169, 7203, 17616, 36176, 13823, 32154, 41597, 60106, 4975, 23300, 33719, 51257, 28821, 47458, 57600, 10671, 28233, 38639, 56972, 1817, 20469, 62530, 15584, 25743, 44329, 54735, 6764, 17145, 35493, 13113, 31708};
    private static long _BOUNDARY = -6586071323617680998L;

    public static abstract class Builder {
        public abstract ExternalPrivacyContext build();

        public abstract Builder setPrequest(@Nullable ExternalPRequestContext externalPRequestContext);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r6, byte r7, byte r8) {
        /*
            int r8 = r8 * 2
            int r8 = 3 - r8
            int r7 = r7 * 3
            int r0 = 1 - r7
            int r6 = r6 + 103
            byte[] r1 = com.google.android.datatransport.cct.internal.ExternalPrivacyContext.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            int r7 = 0 - r7
            if (r1 != 0) goto L16
            r3 = r8
            r4 = r2
            goto L2c
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r6
            r0[r3] = r4
            int r8 = r8 + 1
            if (r3 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L24:
            int r3 = r3 + 1
            r4 = r1[r8]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2c:
            int r6 = r6 + r8
            r8 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.internal.ExternalPrivacyContext.$$e(short, byte, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r7 = r7 * 4
            int r7 = 109 - r7
            byte[] r0 = com.google.android.datatransport.cct.internal.ExternalPrivacyContext.$$a
            int r8 = r8 * 2
            int r1 = r8 + 4
            byte[] r1 = new byte[r1]
            int r8 = r8 + 3
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r7
            r4 = r2
            r7 = r6
            goto L2f
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r6 = r6 + 1
            int r4 = r3 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r5
        L2f:
            int r3 = r3 + r6
            int r6 = r3 + (-3)
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.internal.ExternalPrivacyContext.a(byte, short, int, java.lang.Object[]):void");
    }

    public abstract ExternalPRequestContext getPrequest();

    public static Builder builder() {
        return new AutoValue_ExternalPrivacyContext.Builder();
    }

    private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2;
        int i4 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i5 = $11 + 55;
            $10 = i5 % 128;
            if (i5 % i3 != 0) {
                int i6 = _creation.b;
                try {
                    Object[] objArr2 = {Integer.valueOf(_CREATION[i % i6])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame == null) {
                        int iGreen = 8 - Color.green(0);
                        char cIndexOf = (char) (9279 - TextUtils.indexOf("", "", 0));
                        int maxKeyCode = 1977 - (KeyEvent.getMaxKeyCode() >> 16);
                        byte b = (byte) ($$d & 1);
                        byte b2 = (byte) (b - 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iGreen, cIndexOf, maxKeyCode, 1113883676, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    try {
                        Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                        if (objAccessartificialFrame2 == null) {
                            int iMyPid = (Process.myPid() >> 22) + 30;
                            char cIndexOf2 = (char) (TextUtils.indexOf((CharSequence) "", '0') + 49363);
                            int scrollBarSize = 684 - (ViewConfiguration.getScrollBarSize() >> 8);
                            byte b3 = (byte) ($$d & 3);
                            byte b4 = (byte) (b3 - 3);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyPid, cIndexOf2, scrollBarSize, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                        }
                        jArr[i6] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                        try {
                            Object[] objArr4 = {_creation, _creation};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                            if (objAccessartificialFrame3 == null) {
                                byte b5 = (byte) 0;
                                byte b6 = b5;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 25, (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 30068), 815 - Process.getGidForName(""), 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
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
            } else {
                int i7 = _creation.b;
                try {
                    Object[] objArr5 = {Integer.valueOf(_CREATION[i + i7])};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame4 == null) {
                        int iIndexOf = TextUtils.indexOf("", "", 0, 0) + 8;
                        char scrollBarSize2 = (char) (9279 - (ViewConfiguration.getScrollBarSize() >> 8));
                        int touchSlop = 1977 - (ViewConfiguration.getTouchSlop() >> 8);
                        byte b7 = (byte) ($$d & 1);
                        byte b8 = (byte) (b7 - 1);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iIndexOf, scrollBarSize2, touchSlop, 1113883676, false, $$e(b7, b8, b8), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr6 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).longValue()), Long.valueOf(i7), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame5 == null) {
                        int offsetAfter = TextUtils.getOffsetAfter("", 0) + 30;
                        char cBlue = (char) (49362 - Color.blue(0));
                        int i8 = 684 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        byte b9 = (byte) ($$d & 3);
                        byte b10 = (byte) (b9 - 3);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(offsetAfter, cBlue, i8, -115095555, false, $$e(b9, b10, b10), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i7] = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).longValue();
                    Object[] objArr7 = {_creation, _creation};
                    Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame6 == null) {
                        byte b11 = (byte) 0;
                        byte b12 = b11;
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 24, (char) (30068 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), TextUtils.getOffsetAfter("", 0) + 816, 1897803493, false, $$e(b11, b12, b12), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame6).invoke(null, objArr7);
                } catch (Throwable th4) {
                    Throwable cause4 = th4.getCause();
                    if (cause4 == null) {
                        throw th4;
                    }
                    throw cause4;
                }
            }
            i3 = 2;
        }
        char[] cArr = new char[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            cArr[_creation.b] = (char) jArr[_creation.b];
            Object[] objArr8 = {_creation, _creation};
            Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-293902099);
            if (objAccessartificialFrame7 == null) {
                byte b13 = (byte) 0;
                byte b14 = b13;
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getEdgeSlop() >> 16) + 25, (char) (30068 - (ViewConfiguration.getTapTimeout() >> 16)), 815 - TextUtils.indexOf((CharSequence) "", '0', 0), 1897803493, false, $$e(b13, b14, b14), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame7).invoke(null, objArr8);
            int i9 = $10 + 5;
            $11 = i9 % 128;
            int i10 = i9 % 2;
        }
        objArr[0] = new String(cArr);
    }

    public static Object[] coroutineCreation(int i, int i2) throws Throwable {
        Object[] objArr;
        char c;
        char c2;
        String line;
        int i3;
        int i4;
        boolean zEquals;
        int i5;
        int i6;
        char c3;
        int i7;
        String str;
        int iLastIndexOf;
        int iICustomTabsService;
        int i8;
        int i9 = 2;
        int i10 = 2 % 2;
        int i11 = 0;
        int i12 = 1;
        try {
            String[] strArr = new String[2];
            char c4 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
            int i13 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1;
            int i14 = -Color.red(0);
            Object[] objArr2 = new Object[1];
            b(c4, i13, (i14 ^ 19) + ((i14 & 19) << 1), objArr2);
            strArr[0] = (String) objArr2[0];
            int i15 = -ExpandableListView.getPackedPositionChild(0L);
            int i16 = artificialFrame + 1;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i16 % 128;
            int i17 = i16 % 2 != 0 ? ((-183) >> i15) * (-185) : (i15 * (-183)) - 185;
            int i18 = ~i15;
            int i19 = -(-((~(i18 | (~i18))) * SyslogConstants.LOG_LOCAL7));
            int i20 = ((i17 | i19) << 1) - (i17 ^ i19);
            int i21 = ~i15;
            int i22 = ((i21 & i) | (i ^ i21)) * (-184);
            int i23 = (i20 ^ i22) + ((i22 & i20) << 1);
            int i24 = ~i15;
            int i25 = ~i;
            char c5 = (char) (i23 + ((~((i24 & i25) | (i24 ^ i25))) * SyslogConstants.LOG_LOCAL7));
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iICustomTabsService2 = SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
            int i26 = (iMakeMeasureSpec * 465) - 8797;
            int i27 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i28 = (i27 & 53) + (i27 | 53);
            artificialFrame = i28 % 128;
            int i29 = i28 % 2;
            int i30 = ~iICustomTabsService2;
            int i31 = ~(((-20) ^ i30) | (i30 & (-20)));
            int i32 = ~(((-20) ^ iMakeMeasureSpec) | ((-20) & iMakeMeasureSpec));
            int i33 = (i31 ^ i32) | (i32 & i31);
            int i34 = ~((~iICustomTabsService2) | iMakeMeasureSpec);
            int i35 = -(-(((i33 ^ i34) | (i33 & i34)) * 464));
            int i36 = (i26 ^ i35) + ((i35 & i26) << 1);
            SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
            int i37 = ~i;
            int i38 = ~iMakeMeasureSpec;
            int i39 = (iICustomTabsService2 ^ i38) | (i38 & iICustomTabsService2);
            int i40 = i36 + ((-464) * ((i39 ^ (-20)) | (i39 & (-20))));
            int i41 = ~((-20) | iMakeMeasureSpec);
            int i42 = ~((iMakeMeasureSpec ^ iICustomTabsService2) | (iMakeMeasureSpec & iICustomTabsService2));
            int i43 = (i40 - (~(((i41 & i42) | (i41 ^ i42)) * 464))) - 1;
            int i44 = -TextUtils.indexOf((CharSequence) "", '0', 0, 0);
            int i45 = ((i44 | 17) << 1) - (i44 ^ 17);
            Object[] objArr3 = new Object[1];
            b(c5, i43, i45, objArr3);
            strArr[1] = (String) objArr3[0];
            int i46 = 0;
            while (true) {
                if (i46 >= i9) {
                    objArr = new Object[4];
                    int[] iArr = new int[1];
                    objArr[0] = iArr;
                    int[] iArr2 = new int[1];
                    objArr[1] = iArr2;
                    objArr[2] = new int[1];
                    int i47 = getARTIFICIAL_FRAME_PACKAGE_NAME + 7;
                    artificialFrame = i47 % 128;
                    if (i47 % 2 == 0) {
                        iArr[1] = i;
                        c3 = 0;
                    } else {
                        c3 = 0;
                        iArr[0] = i;
                    }
                    iArr2[c3] = i;
                    objArr[3] = null;
                    int startUptimeMillis = (int) Process.getStartUptimeMillis();
                    int i48 = (((~(startUptimeMillis | 566430906)) | 412192868) * 56) + 505189974 + (((~((~startUptimeMillis) | 412192868)) | 566430906) * 56);
                    int iICustomTabsService3 = SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
                    int i49 = (i48 ^ iICustomTabsService3) | (i48 & iICustomTabsService3);
                    int i50 = (-(-(i48 * 382))) + ((i49 | (i49 ^ (-1))) * (-381));
                    int i51 = getARTIFICIAL_FRAME_PACKAGE_NAME + 11;
                    artificialFrame = i51 % 128;
                    if (i51 % 2 == 0) {
                        int i52 = ~iICustomTabsService3;
                        int i53 = ~((i52 & i48) | (i52 ^ i48));
                        int i54 = ~i48;
                        int i55 = (i53 & i54) | (i53 ^ i54);
                        i7 = i50 / ((i55 ^ 381) + ((i55 & 381) << 1));
                    } else {
                        int i56 = ~i48;
                        int i57 = (~((~iICustomTabsService3) | i48)) | (~(i56 | ((-1) ^ i56)));
                        int i58 = ~i48;
                        int i59 = ((i57 & i58) | (i57 ^ i58)) * 381;
                        i7 = ((i50 | i59) << 1) - (i59 ^ i50);
                    }
                    int i60 = -(-(381 * (~(((-1) ^ i48) | i48))));
                    int i61 = (i7 ^ i60) + ((i60 & i7) << 1);
                    int iICustomTabsService4 = SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
                    int i62 = i61 * 784;
                    int i63 = i2 * (-782);
                    int i64 = (((i62 & i63) + (i62 | i63)) - (~((~i2) * (-783)))) - 1;
                    int i65 = ~i61;
                    int i66 = ~iICustomTabsService4;
                    int i67 = i65 | i66;
                    int i68 = -(-((~((i67 & i2) | (i67 ^ i2))) * (-783)));
                    int i69 = ((i64 | i68) << 1) - (i68 ^ i64);
                    int i70 = ~((i66 & i2) | (i66 ^ i2));
                    int i71 = -(-(((i70 & i65) | (i65 ^ i70)) * 783));
                    int i72 = (i69 ^ i71) + ((i71 & i69) << 1);
                    int i73 = artificialFrame;
                    int i74 = i73 + 65;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i74 % 128;
                    if (i74 % 2 != 0) {
                        int i75 = i72 << 43;
                        int i76 = (i72 | i75) & (~(i72 & i75));
                        int i77 = i76 << 41;
                        int i78 = (i76 | i77) & (~(i76 & i77));
                        ((int[]) objArr[3])[0] = i78 ^ (((i78 | (-2)) << 1) - (i78 ^ (-2)));
                    } else {
                        int i79 = i72 ^ (i72 << 13);
                        int i80 = i79 >>> 17;
                        int i81 = (i79 | i80) & (~(i79 & i80));
                        int i82 = i81 << 5;
                        ((int[]) objArr[2])[0] = ((~i81) & i82) | ((~i82) & i81);
                    }
                    int i83 = i73 + 97;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i83 % 128;
                    int i84 = i83 % 2;
                    break;
                }
                int i85 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
                artificialFrame = i85 % 128;
                if (i85 % i9 == 0) {
                    str = strArr[i46];
                    iLastIndexOf = TextUtils.lastIndexOf("", 'p', i12, i11);
                    iICustomTabsService = SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
                    i8 = 14402;
                } else {
                    str = strArr[i46];
                    iLastIndexOf = TextUtils.lastIndexOf("", '0', i11, i11);
                    iICustomTabsService = SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
                    i8 = 11043;
                }
                int i86 = (-559) * iLastIndexOf;
                int i87 = -(-(i8 * 561));
                int i88 = (i86 ^ i87) + ((i86 & i87) << i12);
                int i89 = ~iICustomTabsService;
                int i90 = (~((i89 ^ iLastIndexOf) | (i89 & iLastIndexOf))) * (-560);
                int i91 = (i88 & i90) + (i88 | i90);
                int i92 = ~i8;
                int i93 = (i91 - (~(-(-((~(((i92 ^ iLastIndexOf) | (i92 & iLastIndexOf)) | iICustomTabsService)) * (-560)))))) - 1;
                int i94 = ~iLastIndexOf;
                char c6 = (char) ((i93 - (~(-(-(((~((i94 & i8) | (i94 ^ i8))) | (~(i89 | i8))) * 560))))) - 1);
                int i95 = -(-Color.rgb(i11, i11, i11));
                int i96 = (i95 & 16777253) + (i95 | 16777253);
                int iIndexOf = TextUtils.indexOf("", "", i11, i11);
                int iICustomTabsService5 = SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
                int i97 = ~iIndexOf;
                int i98 = ~iICustomTabsService5;
                int i99 = i97 | i98;
                int i100 = ~((i99 ^ 16) | (i99 & 16));
                int i101 = ((-17) ^ i98) | ((-17) & i98);
                int i102 = ~((i101 ^ iIndexOf) | (i101 & iIndexOf));
                int i103 = ((iIndexOf * (-183)) - 2928) + (((i100 ^ i102) | (i100 & i102)) * (-184));
                int i104 = ~((i97 ^ (-17)) | (i97 & (-17)));
                int i105 = ~iICustomTabsService5;
                int i106 = ~((i97 & i105) | (i97 ^ i105));
                int i107 = (i104 & i106) | (i104 ^ i106);
                int i108 = ~((i105 & (-17)) | ((-17) ^ i105));
                int i109 = i103 + (((i108 & i107) | (i107 ^ i108)) * SyslogConstants.LOG_LOCAL7);
                int i110 = -(-(((iIndexOf & 16) | (iIndexOf ^ 16)) * SyslogConstants.LOG_LOCAL7));
                Object[] objArr4 = new Object[1];
                b(c6, i96, (i109 & i110) + (i110 | i109), objArr4);
                Class<?> cls = Class.forName((String) objArr4[0]);
                if (((Boolean) cls.getMethod(str, new Class[0]).invoke(cls, null)).booleanValue()) {
                    int i111 = artificialFrame;
                    int i112 = (i111 ^ 11) + ((i111 & 11) << 1);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i112 % 128;
                    int i113 = i112 % 2;
                    objArr = new Object[]{new int[]{i}, new int[]{(i & (-2)) | (i37 & 1)}, new int[]{i ^ (i << 5)}, null};
                    int i114 = ((((~((-822755345) | i)) | 2169998) * 449) - 1019996430) + ((2169998 | (~((-822755345) | i37))) * 449);
                    int i115 = 7440 + (i114 * (-463));
                    int i116 = ~i114;
                    int i117 = ~((i37 & i116) | (i116 ^ i37));
                    int i118 = ~((i116 ^ 16) | (i116 & 16));
                    int i119 = -(-(((i117 & i118) | (i117 ^ i118) | (~(i25 | 16))) * 464));
                    int i120 = ((i115 | i119) << 1) - (i119 ^ i115);
                    int i121 = i | (-17);
                    int i122 = i120 + (((i121 & i116) | (i121 ^ i116)) * (-464));
                    int i123 = ~i114;
                    int i124 = ~((i123 & 16) | (i123 ^ 16));
                    int i125 = ~((i ^ 16) | (i & 16));
                    int i126 = ((i124 & i125) | (i124 ^ i125)) * 464;
                    int i127 = ((i122 | i126) << 1) - (i126 ^ i122);
                    int i128 = (i2 ^ i127) + ((i127 & i2) << 1);
                    int i129 = i128 ^ (i128 << 13);
                    int i130 = i129 >>> 17;
                    int i131 = ((~i129) & i130) | ((~i130) & i129);
                    break;
                }
                int i132 = (i46 ^ 127) + ((i46 & 127) << 1);
                i46 = ((i132 | (-126)) << 1) - (i132 ^ (-126));
                i9 = 2;
                i11 = 0;
                i12 = 1;
            }
            c2 = 1;
            c = 0;
        } catch (Exception unused) {
            objArr = new Object[]{new int[]{i}, new int[]{(i & (-3)) | ((~i) & 2)}, new int[1], null};
            int i133 = ~((int) Process.getStartElapsedRealtime());
            int i134 = (-1005955010) + (((~(i133 | 858448285)) | (-925629342)) * (-160)) + (((~(i133 | (-120175490))) | 858448285) * SyslogConstants.LOG_LOCAL4);
            int i135 = (((i134 | 16) << 1) - (i134 ^ 16)) + i2;
            int i136 = i135 << 13;
            int i137 = (i135 | i136) & (~(i135 & i136));
            int i138 = i137 ^ (i137 >>> 17);
            int i139 = i138 << 5;
            int i140 = ((~i138) & i139) | ((~i139) & i138);
            c = 0;
            ((int[]) objArr[2])[0] = i140;
            c2 = 1;
        }
        if (i != ((int[]) objArr[c2])[c]) {
            int i141 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i142 = (i141 & 61) + (i141 | 61);
            artificialFrame = i142 % 128;
            int i143 = i142 % 2;
        } else {
            try {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
                if (objAccessartificialFrame == null) {
                    int size = 9 - View.MeasureSpec.getSize(0);
                    char maximumDrawingCacheSize = (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 64610);
                    int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0) + 1806;
                    byte b = (byte) (-1);
                    byte b2 = (byte) (b + 1);
                    Object[] objArr5 = new Object[1];
                    a(b, b2, b2, objArr5);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(size, maximumDrawingCacheSize, iMakeMeasureSpec2, -1135716921, false, (String) objArr5[0], new Class[0]);
                }
                long jLongValue = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
                long j = -388421262;
                long j2 = -1;
                long j3 = ((j ^ j2) | jLongValue) ^ j2;
                long startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                long j4 = startElapsedRealtime ^ j2;
                long j5 = (((long) 595) * j) + (((long) (-1187)) * jLongValue) + (((long) (-1188)) * (j3 | ((j4 | jLongValue) ^ j2)));
                long j6 = 594;
                long j7 = jLongValue ^ j2;
                long j8 = j3 | ((startElapsedRealtime | j7) ^ j2);
                long j9 = (j4 | j) ^ j2;
                long j10 = j5 + ((j8 | j9) * j6) + (j6 * (((j7 | j4) ^ j2) | ((j7 | j) ^ j2) | j9)) + ((long) 728629296);
                int i144 = ~(1816081070 | i);
                int i145 = 392432970 + ((302007552 | i144) * (-280)) + ((i144 | (~(1041659814 | i))) * 140);
                int i146 = ~(2118088622 | i);
                int i147 = ~i;
                int i148 = ((int) (j10 >> 32)) & (i145 + ((i146 | (~((-302007553) | i147)) | (~((-1076428809) | i147))) * 140));
                int i149 = ((int) j10) & (((1320243365 + (((~(1372722685 | i)) | (-1406812158)) * 1504)) + ((~((-34089473) | i)) * (-1504))) - 35893776);
                if (((i148 & i149) | (i148 ^ i149)) == 1) {
                    Object[] objArr6 = new Object[4];
                    objArr6[0] = new int[]{i};
                    objArr6[1] = new int[]{(i & (-11)) | (i147 & 10)};
                    objArr6[2] = new int[1];
                    int i150 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i151 = ((i150 | 107) << 1) - (i150 ^ 107);
                    artificialFrame = i151 % 128;
                    if (i151 % 2 == 0) {
                        objArr6[3] = null;
                        SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
                        throw null;
                    }
                    objArr6[3] = null;
                    int i152 = (-153198546) + (((~(i | 225404230)) | (-753219545)) * (-668)) + ((225404230 | (~((-753219545) | i))) * 1336) + (((-545264281) | i) * 668);
                    int iICustomTabsService6 = SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
                    int i153 = -(-(i152 * (-68)));
                    int i154 = (1120 & i153) + (i153 | 1120);
                    int i155 = ~i152;
                    int i156 = ~(((-17) ^ i155) | ((-17) & i155) | iICustomTabsService6);
                    int i157 = (16 ^ i152) | (16 & i152);
                    int i158 = ~((i157 & iICustomTabsService6) | (i157 ^ iICustomTabsService6));
                    int i159 = i154 + (((i156 & i158) | (i156 ^ i158)) * 69);
                    int i160 = ~(((-17) ^ i152) | ((-17) & i152));
                    int i161 = ~(((-17) & iICustomTabsService6) | ((-17) ^ iICustomTabsService6));
                    int i162 = (i161 & i160) | (i160 ^ i161);
                    int i163 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
                    artificialFrame = i163 % 128;
                    if (i163 % 2 == 0) {
                        int i164 = ~((iICustomTabsService6 & i152) | (i152 ^ iICustomTabsService6));
                        int i165 = i159 % ((-69) / ((i164 & i162) | (i162 ^ i164)));
                        int i166 = -(69 % (~((i155 ^ 16) | (i155 & 16))));
                        int i167 = i2 % (((i165 | i166) << 1) - (i166 ^ i165));
                        int i168 = ((i167 | (-64)) << 1) - (i167 ^ (-64));
                        i6 = ((~i167) & i168) | ((~i168) & i167);
                    } else {
                        int i169 = ~(iICustomTabsService6 | i152);
                        int i170 = ((i159 + (((i169 & i162) | (i162 ^ i169)) * (-69))) - (~((~((i155 ^ 16) | (i155 & 16))) * 69))) - 1;
                        int i171 = (i2 & i170) + (i2 | i170);
                        i6 = i171 ^ (i171 << 13);
                    }
                    int i172 = i6 >>> 17;
                    int i173 = ((~i6) & i172) | ((~i172) & i6);
                    ((int[]) objArr6[2])[0] = i173 ^ (i173 << 5);
                    objArr = objArr6;
                } else {
                    Object[] objArr7 = {new int[]{i}, new int[]{i}, new int[1], null};
                    int i174 = (-1963351310) + (((~((-173318433) | i147)) | (~((-8456799) | i)) | (~((-623530113) | i))) * 765) + (((~((-181775231) | i147)) | 173318432) * 1530) + (((~((-181775231) | i)) | (~((-623530113) | i147))) * 765);
                    int iICustomTabsService7 = SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
                    int i175 = i174 * (-590);
                    int i176 = ~i174;
                    int i177 = ((-1) ^ i176) | i176;
                    int i178 = ~iICustomTabsService7;
                    int i179 = ~((i177 & i178) | (i177 ^ i178));
                    int i180 = ~i174;
                    int i181 = ((i180 & i179) | (i179 ^ i180)) * (-591);
                    int i182 = (i175 ^ i181) + ((i181 & i175) << 1);
                    int i183 = iICustomTabsService7 | (iICustomTabsService7 ^ (-1));
                    int i184 = -(-(((i183 & i176) | (i183 ^ i176)) * 591));
                    int i185 = (i182 & i184) + (i184 | i182);
                    int i186 = ((i185 * (-520)) - (~(-(-(i2 * 522))))) - 1;
                    int i187 = ~i185;
                    int i188 = (i187 & i2) | (i187 ^ i2);
                    int i189 = -(-((~((i188 & i) | (i188 ^ i))) * 521));
                    int i190 = (i186 & i189) + (i186 | i189);
                    int i191 = ~i2;
                    int i192 = -(-((~((i191 & i185) | (i191 ^ i185))) * (-1042)));
                    int i193 = ((i190 | i192) << 1) - (i192 ^ i190);
                    int i194 = ~((~i2) | i185);
                    int i195 = (~i185) | i147;
                    int i196 = ~((i195 & i2) | (i195 ^ i2));
                    int i197 = (i193 - (~(((i194 & i196) | (i194 ^ i196)) * 521))) - 1;
                    int i198 = i197 << 13;
                    int i199 = (i198 & (~i197)) | ((~i198) & i197);
                    int i200 = i199 >>> 17;
                    int i201 = (i199 | i200) & (~(i199 & i200));
                    int i202 = i201 << 5;
                    ((int[]) objArr7[2])[0] = ((~i201) & i202) | ((~i202) & i201);
                    int i203 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i204 = (i203 & 123) + (i203 | 123);
                    artificialFrame = i204 % 128;
                    if (i204 % 2 == 0) {
                        int i205 = 4 / 5;
                    }
                    objArr = objArr7;
                }
                int i206 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i207 = ((i206 | 61) << 1) - (i206 ^ 61);
                artificialFrame = i207 % 128;
                int i208 = i207 % 2;
                if (i == ((int[]) objArr[1])[0]) {
                    try {
                        char c7 = (char) (64513 - (~(-(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24)))));
                        int i209 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                        Object[] objArr8 = new Object[1];
                        b(c7, ((i209 | 53) << 1) - (i209 ^ 53), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 40, objArr8);
                        File file = new File((String) objArr8[0]);
                        if (!(!file.canRead())) {
                            FileReader fileReader = new FileReader(file);
                            BufferedReader bufferedReader = new BufferedReader(fileReader);
                            try {
                                line = bufferedReader.readLine();
                                int iResolveSize = View.resolveSize(0, 0);
                                int i210 = ~((i147 ^ iResolveSize) | (i147 & iResolveSize));
                                int i211 = ~iResolveSize;
                                int i212 = ((iResolveSize * 860) - 357786) + ((iResolveSize | i) * (-859)) + ((i210 | (~((i211 & (-418)) | (i211 ^ (-418)) | i))) * 859);
                                int i213 = ~((~i) | (-418));
                                int i214 = ~((iResolveSize & (-418)) | ((-418) ^ iResolveSize));
                                Object[] objArr9 = new Object[1];
                                b((char) (i212 + (((i214 & i213) | (i213 ^ i214)) * 859)), 92 - (~(-(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))), 2 - (~TextUtils.indexOf("", "", 0, 0)), objArr9);
                                if (line.equals((String) objArr9[0])) {
                                    fileReader.close();
                                    bufferedReader.close();
                                    line = null;
                                } else {
                                    fileReader.close();
                                    bufferedReader.close();
                                }
                            } catch (Throwable th) {
                                fileReader.close();
                                bufferedReader.close();
                                throw th;
                            }
                        } else {
                            line = null;
                        }
                    } catch (Exception unused2) {
                    }
                    try {
                        char c8 = (char) (44532 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                        int i215 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                        int iICustomTabsService8 = SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
                        int i216 = ~i215;
                        int i217 = (i215 * (-381)) + 18240 + (i216 * (-191));
                        int i218 = ~((iICustomTabsService8 ^ 95) | (iICustomTabsService8 & 95));
                        int i219 = -(-(((i215 & i218) | (i215 ^ i218)) * 191));
                        int i220 = (i217 & i219) + (i219 | i217);
                        int i221 = ~((i216 ^ 95) | (i216 & 95));
                        int i222 = ~iICustomTabsService8;
                        int i223 = ~((i222 & 95) | (i222 ^ 95));
                        int i224 = (i220 - (~(((i221 & i223) | (i221 ^ i223)) * 191))) - 1;
                        int i225 = -Color.red(0);
                        int i226 = (((i225 * 758) - 23436) - (~(((i225 ^ i147) | (i225 & i147)) * (-757)))) - 1;
                        int i227 = (~(((-32) ^ i225) | ((-32) & i225) | i)) * 1514;
                        int i228 = ((i226 | i227) << 1) - (i226 ^ i227);
                        int i229 = (~((~i225) | (-32))) | (~((-32) | i147));
                        int i230 = ~(i225 | 31 | i);
                        int i231 = i228 + (((i230 & i229) | (i229 ^ i230)) * 757);
                        Object[] objArr10 = new Object[1];
                        b(c8, i224, i231, objArr10);
                        File file2 = new File((String) objArr10[0]);
                        if (file2.canRead()) {
                            FileReader fileReader2 = new FileReader(file2);
                            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                            try {
                                String line2 = bufferedReader2.readLine();
                                int i232 = -(ViewConfiguration.getKeyRepeatDelay() >> 16);
                                char c9 = (char) (((i232 | 62202) << 1) - (i232 ^ 62202));
                                int i233 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
                                artificialFrame = i233 % 128;
                                int i234 = i233 % 2;
                                int i235 = 126 - (~(-(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))));
                                int i236 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                                int iICustomTabsService9 = SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
                                int i237 = i236 * (-55);
                                int i238 = ((i237 | (-55)) << 1) - (i237 ^ (-55));
                                int i239 = ~((i236 ^ iICustomTabsService9) | (i236 & iICustomTabsService9));
                                int i240 = -(-(((i239 & 1) | (i239 ^ 1)) * 56));
                                int i241 = (i238 ^ i240) + ((i240 & i238) << 1);
                                int i242 = (~((i236 ^ 1) | (i236 & 1))) * (-56);
                                int i243 = (i241 ^ i242) + ((i242 & i241) << 1);
                                int i244 = ~((~iICustomTabsService9) | 1);
                                int i245 = ((i236 & i244) | (i236 ^ i244)) * 56;
                                int i246 = (i243 ^ i245) + ((i245 & i243) << 1);
                                Object[] objArr11 = new Object[1];
                                b(c9, i235, i246, objArr11);
                                boolean zEquals2 = line2.equals((String) objArr11[0]);
                                fileReader2.close();
                                bufferedReader2.close();
                                if (zEquals2) {
                                    try {
                                        int i247 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                        int threadPriority = Process.getThreadPriority(0);
                                        int i248 = 127 - (~((((threadPriority | 20) << 1) - (threadPriority ^ 20)) >> 6));
                                        int i249 = -(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                                        int iICustomTabsService10 = SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
                                        int i250 = (i249 * (-495)) - 18315;
                                        int i251 = ~i249;
                                        int i252 = ~((i251 ^ (-38)) | (i251 & (-38)));
                                        int i253 = ~((i251 ^ iICustomTabsService10) | (i251 & iICustomTabsService10));
                                        int i254 = -(-(((i252 & i253) | (i252 ^ i253)) * 992));
                                        int i255 = ((i250 | i254) << 1) - (i250 ^ i254);
                                        int i256 = ~((i251 ^ (-38)) | (i251 & (-38)));
                                        int i257 = (i256 & i253) | (i256 ^ i253);
                                        int i258 = ~iICustomTabsService10;
                                        int i259 = (i249 & i258) | (i258 ^ i249);
                                        int i260 = ~((i259 & 37) | (i259 ^ 37));
                                        int i261 = ((i260 & i257) | (i257 ^ i260)) * (-496);
                                        int i262 = (i255 & i261) + (i261 | i255);
                                        int i263 = -(-(((iICustomTabsService10 ^ 37) | (iICustomTabsService10 & 37)) * 496));
                                        int i264 = (i262 & i263) + (i263 | i262);
                                        Object[] objArr12 = new Object[1];
                                        b((char) ((i247 & 22496) + (i247 | 22496)), i248, i264, objArr12);
                                        File file3 = new File((String) objArr12[0]);
                                        if (file3.canRead()) {
                                            FileReader fileReader3 = new FileReader(file3);
                                            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                                            int i265 = artificialFrame + 115;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i265 % 128;
                                            int i266 = i265 % 2;
                                            try {
                                                String line3 = bufferedReader3.readLine();
                                                int i267 = -(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                int iICustomTabsService11 = SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
                                                int i268 = (i267 * 522) - 32345040;
                                                int i269 = artificialFrame + 87;
                                                int i270 = i269 % 128;
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i270;
                                                int i271 = i269 % 2;
                                                int i272 = ~iICustomTabsService11;
                                                int i273 = ~((i272 ^ 62202) | (i272 & 62202));
                                                int i274 = (-1042) * ((i273 & i267) | (i267 ^ i273));
                                                int i275 = (((i268 ^ i274) + ((i268 & i274) << 1)) - (~(-(-((62202 | iICustomTabsService11) * 521))))) - 1;
                                                int i276 = ~i267;
                                                int i277 = (~((i276 ^ iICustomTabsService11) | (iICustomTabsService11 & i276))) | (~((i276 ^ (-62203)) | ((-62203) & i276)));
                                                int i278 = i270 + 61;
                                                artificialFrame = i278 % 128;
                                                int i279 = i278 % 2;
                                                int i280 = i267 | i272;
                                                int i281 = -(-(521 * ((~((i280 & 62202) | (i280 ^ 62202))) | i277)));
                                                char c10 = (char) ((i275 & i281) + (i281 | i275));
                                                int packedPositionGroup = 127 - ExpandableListView.getPackedPositionGroup(0L);
                                                int i282 = -(-Color.blue(0));
                                                int i283 = (i282 & 1) + (i282 | 1);
                                                Object[] objArr13 = new Object[1];
                                                b(c10, packedPositionGroup, i283, objArr13);
                                                zEquals = line3.equals((String) objArr13[0]);
                                                fileReader3.close();
                                                int i284 = artificialFrame;
                                                int i285 = ((i284 | 11) << 1) - (i284 ^ 11);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i285 % 128;
                                                int i286 = i285 % 2;
                                                bufferedReader3.close();
                                            } catch (Throwable th2) {
                                                fileReader3.close();
                                                bufferedReader3.close();
                                                throw th2;
                                            }
                                        } else {
                                            int i287 = artificialFrame + 55;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i287 % 128;
                                            int i288 = i287 % 2;
                                            zEquals = false;
                                        }
                                    } catch (Exception unused3) {
                                        zEquals = false;
                                    }
                                    if (!(!zEquals) && line != null) {
                                        objArr = new Object[]{new int[]{i}, new int[]{(~(i & 20)) & (i | 20)}, new int[1], line};
                                        int i289 = ~(859940741 | i147);
                                        int i290 = 1484113086 + ((68309016 | i289) * (-712)) + (((~((-68309017) | i147)) | (~(928249757 | i))) * (-712)) + ((i289 | (-118683034)) * 712);
                                        int i291 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        int i292 = i291 + 123;
                                        artificialFrame = i292 % 128;
                                        if (i292 % 2 == 0) {
                                            i5 = 15680 * ((-978) % i290);
                                        } else {
                                            int i293 = -(-(i290 * (-978)));
                                            i5 = ((15680 | i293) << 1) - (i293 ^ 15680);
                                        }
                                        int i294 = ~i290;
                                        int i295 = i291 + 39;
                                        artificialFrame = i295 % 128;
                                        int i296 = i295 % 2;
                                        int i297 = ~i;
                                        int i298 = 979 * (~((i297 & i294) | (i294 ^ i297)));
                                        int i299 = ((i5 | i298) << 1) - (i298 ^ i5);
                                        int i300 = ((16 & i) | (16 ^ i)) * (-979);
                                        int i301 = (i299 & i300) + (i299 | i300);
                                        int i302 = ~i290;
                                        int i303 = (i301 - (~(((~((i302 & i) | (i302 ^ i))) | (~(i147 | 16))) * 979))) - 1;
                                        int i304 = i303 * (-244);
                                        int i305 = -(-(i2 * 246));
                                        int i306 = ((i304 | i305) << 1) - (i304 ^ i305);
                                        int i307 = ~i2;
                                        int i308 = ~((i307 ^ i147) | (i147 & i307));
                                        int i309 = ~i2;
                                        int i310 = ~((i309 ^ i303) | (i309 & i303));
                                        int i311 = -(-(((i308 & i310) | (i308 ^ i310)) * (-245)));
                                        int i312 = ((i306 | i311) << 1) - (i311 ^ i306);
                                        int i313 = -(-((~((i309 ^ i) | (i309 & i))) * (-245)));
                                        int i314 = ((i312 | i313) << 1) - (i313 ^ i312);
                                        int iICustomTabsService12 = SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
                                        int i315 = ~iICustomTabsService12;
                                        int i316 = ~(((-1853826871) ^ i315) | ((-1853826871) & i315));
                                        int i317 = (i316 & 1816864530) | (1816864530 ^ i316);
                                        int i318 = ~((iICustomTabsService12 & 2139039615) | (2139039615 ^ iICustomTabsService12));
                                        int i319 = -(-(((i317 & i318) | (i317 ^ i318)) * (-502)));
                                        int i320 = ((1193864157 | i319) << 1) - (i319 ^ 1193864157);
                                        int i321 = (i315 & (-1853826871)) | ((-1853826871) ^ i315);
                                        int i322 = ~((i321 & 2102077275) | (i321 ^ 2102077275));
                                        int i323 = ((i318 & i322) | (i322 ^ i318)) * TypedValues.PositionType.TYPE_DRAWPATH;
                                        int i324 = (i320 ^ i323) + ((i323 & i320) << 1);
                                        int iICustomTabsService13 = SQLiteEventStore$$ExternalSyntheticLambda0.ICustomTabsService();
                                        int i325 = ~iICustomTabsService13;
                                        int i326 = ~((1247312096 & i325) | (i325 ^ 1247312096));
                                        int i327 = 1339756977 + (((i326 & (-1853848567)) | ((-1853848567) ^ i326)) * SyslogConstants.LOG_LOCAL7);
                                        int i328 = (iICustomTabsService13 | 134770848) * (-184);
                                        int i329 = (i327 & i328) + (i328 | i327) + ((~((741307318 & i325) | (741307318 ^ i325))) * SyslogConstants.LOG_LOCAL7);
                                        int i330 = ~((i307 & i) | (i307 ^ i));
                                        if (i324 > i329) {
                                            int i331 = i314 / (245 >>> (i330 | i303));
                                            int i332 = i331 >> 42;
                                            int i333 = (i332 | i331) & (~(i331 & i332));
                                            int i334 = i333 ^ (i333 >>> 122);
                                            int i335 = i334 / 5;
                                            ((int[]) objArr[4])[0] = ((~i334) & i335) | ((~i335) & i334);
                                        } else {
                                            int i336 = -(-(((i330 & i303) | (i303 ^ i330)) * 245));
                                            int i337 = (i314 & i336) + (i336 | i314);
                                            int i338 = (i337 << 13) ^ i337;
                                            int i339 = i338 >>> 17;
                                            int i340 = ((~i338) & i339) | ((~i339) & i338);
                                            int i341 = i340 << 5;
                                            ((int[]) objArr[2])[0] = ((~i340) & i341) | ((~i341) & i340);
                                        }
                                    }
                                }
                            } catch (Throwable th3) {
                                fileReader2.close();
                                bufferedReader2.close();
                                throw th3;
                            }
                        }
                    } catch (Exception unused4) {
                    }
                    int[] iArr3 = new int[1];
                    objArr = new Object[]{new int[]{i}, new int[]{i}, iArr3, null};
                    int i342 = ~(841314884 | i147);
                    int i343 = ((838881284 | i342) * (-374)) + 277444982 + ((i342 | 2433600) * 374);
                    int i344 = artificialFrame + 33;
                    int i345 = i344 % 128;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i345;
                    int i346 = i344 % 2;
                    int i347 = (-958) * i343;
                    int i348 = i2 * (-958);
                    int i349 = (i347 & i348) + (i347 | i348);
                    int i350 = ~i2;
                    int i351 = ~(i350 | i147);
                    int i352 = ~i343;
                    int i353 = i351 | (~((i352 & i) | (i352 ^ i)));
                    int i354 = i345 + 1;
                    artificialFrame = i354 % 128;
                    if (i354 % 2 == 0) {
                        int i355 = ~i;
                        int i356 = -((~((i355 & i343) | (i355 ^ i343))) | i353);
                        int i357 = -(-(((i356 | 959) << 1) - (i356 ^ 959)));
                        int i358 = ~((i2 & i343) | (i343 ^ i2));
                        i3 = (((i349 | i357) << 1) - (i357 ^ i349)) * ((i358 & (-959)) + (i358 | (-959)));
                        i4 = ~i343;
                    } else {
                        int i359 = ~((i147 & i343) | (i147 ^ i343));
                        int i360 = i349 + (((i359 & i353) | (i353 ^ i359)) * 959);
                        int i361 = (~((i2 & i343) | (i343 ^ i2))) * (-959);
                        i3 = (i360 & i361) + (i361 | i360);
                        i4 = ~i343;
                        i147 = ~i;
                    }
                    int i362 = (~((i350 & i) | (i350 ^ i))) | (~((i4 & i147) | (i4 ^ i147)));
                    int i363 = ~((i343 & i) | (i343 ^ i));
                    int i364 = (i3 - (~(959 * ((i362 & i363) | (i362 ^ i363))))) - 1;
                    int i365 = i364 << 13;
                    int i366 = (i365 | i364) & (~(i364 & i365));
                    int i367 = i366 >>> 17;
                    int i368 = (i366 | i367) & (~(i366 & i367));
                    int i369 = i368 << 5;
                    iArr3[0] = (i368 | i369) & (~(i368 & i369));
                }
            } catch (Throwable th4) {
                Throwable cause = th4.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th4;
            }
        }
        return objArr;
    }
}
