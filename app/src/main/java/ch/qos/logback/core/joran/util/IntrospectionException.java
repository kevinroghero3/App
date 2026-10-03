package ch.qos.logback.core.joran.util;

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
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.soloader.Elf32;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Random;
import o.ArtificialStackFrames;
import o._CREATION;
import o.artificialFrame;

/* JADX INFO: loaded from: classes2.dex */
public class IntrospectionException extends RuntimeException {
    private static final long serialVersionUID = -6760181416658938878L;
    private static final byte[] $$a = {113, 6, -112, 1};
    private static final int $$b = 88;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] _CREATION = {6548, 30729, 55972, 15709, 40926, 65086, 20489, 45697, 5421, 30669, 54864, 10469, 35458, 60697, 20452, 44629, 235, 25468, 50458, 10226, 34366, 6277, 31530, 56756, 16320, 40448, 61687, 21276, 46502, 5200, 30232, 51389, 11088, 36299, 60539, 19980, 41095, 828, 6559, 30726, 55990, 15694, 40905, 65145, 20510, 45770, 5421, 30679, 54860, 10488, 35475, 60686, 20414, 44570, 238, 25445, 50524, 10124, 34343, 6355, 31601, 56805, 16265, 40509, 61583, 21325, 46584, 5217, 30221, 51377, 11084, 63287, 38570, 13319, 54270, 28971, 4288, 48828, 23588, 64408, 39273, 14568, 50779, 25644, 1005, 41226, 16626, 61007, 36319, 11263, 51495, 26832, 63011, 38272, 13156, 53544, 28809, 7701, 48614, 23379, 64202, 39082, 9750, 50665, 25454};
    private static long _BOUNDARY = -4904338173811001240L;
    private static int[] ICustomTabsCallbackStub = {-1565110666, 1755840566, -1141120614, -1559419318, -666526002, 404265744, 703976515, 1922434867, -1880346818, -1229597632, -387901677, 1479475642, 784399397, -759946168, 571778023, -152765261, -1937253044, 359280399};

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(short r6, byte r7, short r8) {
        /*
            int r6 = r6 + 4
            int r8 = r8 * 2
            int r8 = r8 + 1
            byte[] r0 = ch.qos.logback.core.joran.util.IntrospectionException.$$a
            int r7 = 115 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L13
            r7 = r6
            r4 = r8
            r3 = r2
            goto L28
        L13:
            r3 = r2
        L14:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L23:
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r5
        L28:
            int r4 = -r4
            int r6 = r6 + r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.core.joran.util.IntrospectionException.$$c(short, byte, short):java.lang.String");
    }

    public IntrospectionException(Exception exc) {
        super(exc);
    }

    public IntrospectionException(String str) {
        super(str);
    }

    private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
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
                    int size = 8 - View.MeasureSpec.getSize(0);
                    char cAxisFromString = (char) (9278 - MotionEvent.axisFromString(""));
                    int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 1977;
                    byte b = $$a[3];
                    byte b2 = (byte) (-b);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(size, cAxisFromString, longPressTimeout, 1113883676, false, $$c(b2, (byte) (b2 & Ascii.VT), (byte) (b - 1)), new Class[]{Integer.TYPE});
                }
                try {
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i4), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        int i5 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 29;
                        char packedPositionGroup = (char) (49362 - ExpandableListView.getPackedPositionGroup(0L));
                        int iAxisFromString = 683 - MotionEvent.axisFromString("");
                        byte b3 = $$a[3];
                        byte b4 = (byte) (-b3);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i5, packedPositionGroup, iAxisFromString, -115095555, false, $$c(b4, (byte) (b4 & 9), (byte) (b3 - 1)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i4] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    try {
                        Object[] objArr4 = {_creation, _creation};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame3 == null) {
                            int iRgb = Color.rgb(0, 0, 0) + 16777241;
                            char packedPositionGroup2 = (char) (ExpandableListView.getPackedPositionGroup(0L) + 30068);
                            int iNormalizeMetaState = KeyEvent.normalizeMetaState(0) + 816;
                            byte b5 = $$a[3];
                            byte b6 = (byte) (-b5);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iRgb, packedPositionGroup2, iNormalizeMetaState, 1897803493, false, $$c(b6, (byte) (b6 & Ascii.FF), (byte) (b5 - 1)), new Class[]{Object.class, Object.class});
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
            int i6 = $10 + 79;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            cArr[_creation.b] = (char) jArr[_creation.b];
            try {
                Object[] objArr5 = {_creation, _creation};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame4 == null) {
                    int i8 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 25;
                    char windowTouchSlop = (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 30068);
                    int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 817;
                    byte b7 = $$a[3];
                    byte b8 = (byte) (-b7);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i8, windowTouchSlop, iIndexOf, 1897803493, false, $$c(b8, (byte) (b8 & Ascii.FF), (byte) (b7 - 1)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                int i9 = $10 + 39;
                $11 = i9 % 128;
                if (i9 % 2 == 0) {
                    int i10 = 4 % 4;
                }
            } catch (Throwable th4) {
                Throwable cause4 = th4.getCause();
                if (cause4 == null) {
                    throw th4;
                }
                throw cause4;
            }
        }
        String str = new String(cArr);
        int i11 = $10 + 81;
        $11 = i11 % 128;
        int i12 = i11 % 2;
        objArr[0] = str;
    }

    private static void b(int i, int[] iArr, Object[] objArr) throws Throwable {
        int length;
        int[] iArr2;
        int i2;
        int length2;
        int[] iArr3;
        int i3 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr4 = ICustomTabsCallbackStub;
        int i4 = -1780896814;
        float f = 0.0f;
        char c = 3;
        int i5 = 1;
        int i6 = 0;
        if (iArr4 != null) {
            int i7 = $10 + 25;
            $11 = i7 % 128;
            if (i7 % 2 == 0) {
                length2 = iArr4.length;
                iArr3 = new int[length2];
            } else {
                length2 = iArr4.length;
                iArr3 = new int[length2];
            }
            int i8 = 0;
            while (i8 < length2) {
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i6] = Integer.valueOf(iArr4[i8]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                    if (objAccessartificialFrame == null) {
                        int scrollBarSize = 11 - (ViewConfiguration.getScrollBarSize() >> 8);
                        char c2 = (char) ((ViewConfiguration.getScrollFriction() > f ? 1 : (ViewConfiguration.getScrollFriction() == f ? 0 : -1)) - 1);
                        int iLastIndexOf = TextUtils.lastIndexOf("", '0', i6, i6) + 1563;
                        byte[] bArr = $$a;
                        byte b = bArr[c];
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(scrollBarSize, c2, iLastIndexOf, 180153818, false, $$c((byte) (-b), bArr[1], (byte) (b - 1)), new Class[]{Integer.TYPE});
                    }
                    iArr3[i8] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i8++;
                    int i9 = $10 + 49;
                    $11 = i9 % 128;
                    int i10 = i9 % 2;
                    i4 = -1780896814;
                    f = 0.0f;
                    c = 3;
                    i6 = 0;
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
        long j = 0;
        if (iArr6 != null) {
            int i11 = $11 + 95;
            $10 = i11 % 128;
            if (i11 % 2 != 0) {
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
                    Object[] objArr3 = new Object[i5];
                    objArr3[0] = Integer.valueOf(iArr6[i2]);
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                    if (objAccessartificialFrame2 == null) {
                        int offsetBefore = 11 - TextUtils.getOffsetBefore("", 0);
                        char c3 = (char) ((ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1)) - 1);
                        int bitsPerPixel = 1561 - ImageFormat.getBitsPerPixel(0);
                        byte[] bArr2 = $$a;
                        byte b2 = bArr2[3];
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(offsetBefore, c3, bitsPerPixel, 180153818, false, $$c((byte) (-b2), bArr2[1], (byte) (b2 - 1)), new Class[]{Integer.TYPE});
                    }
                    iArr2[i2] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    i2++;
                    iArr6 = iArr6;
                    length = length;
                    j = 0;
                    i5 = 1;
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
        char c4 = 0;
        System.arraycopy(iArr6, 0, iArr5, 0, length3);
        artificialframe.e = 0;
        while (artificialframe.e < iArr.length) {
            cArr[c4] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr5);
            int i12 = 0;
            while (i12 < 16) {
                int i13 = $11 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                $10 = i13 % 128;
                if (i13 % 2 != 0) {
                    artificialframe.c ^= iArr5[i12];
                    Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                    if (objAccessartificialFrame3 == null) {
                        int trimmedLength = TextUtils.getTrimmedLength("") + 26;
                        char windowTouchSlop = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                        int i14 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1041;
                        byte b3 = (byte) (-$$a[3]);
                        byte b4 = (byte) (b3 + 1);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(trimmedLength, windowTouchSlop, i14, 995482881, false, $$c(b3, b4, b4), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = iIntValue;
                    i12 += 77;
                } else {
                    artificialframe.c ^= iArr5[i12];
                    Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                    if (objAccessartificialFrame4 == null) {
                        int doubleTapTimeout = 26 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        char cResolveSizeAndState = (char) View.resolveSizeAndState(0, 0, 0);
                        int iGreen = 1041 - Color.green(0);
                        byte b5 = (byte) (-$$a[3]);
                        byte b6 = (byte) (b5 + 1);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, cResolveSizeAndState, iGreen, 995482881, false, $$c(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = iIntValue2;
                    i12++;
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
            Object[] objArr6 = {artificialframe, artificialframe};
            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1348396126);
            if (objAccessartificialFrame5 == null) {
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(37 - ExpandableListView.getPackedPositionType(0L), (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 28010), 306 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            c4 = 0;
        }
        String str = new String(cArr2, 0, i);
        int i18 = $10 + 115;
        $11 = i18 % 128;
        if (i18 % 2 != 0) {
            objArr[0] = str;
        } else {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
    }

    public static Object[] accessartificialFrame(Context context, int i, int i2) {
        int i3;
        Constructor<?> declaredConstructor;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Object[] objArr;
        int[] iArr;
        char c;
        int i11 = 2 % 2;
        int i12 = artificialFrame;
        int i13 = i12 + 123;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i13 % 128;
        int i14 = i13 % 2;
        int i15 = 1;
        if (context == null) {
            int i16 = (i12 & 63) + (i12 | 63);
            int i17 = i16 % 128;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i17;
            if (i16 % 2 != 0) {
                objArr = new Object[3];
                iArr = new int[1];
                c = 1;
            } else {
                objArr = new Object[4];
                iArr = new int[1];
                c = 0;
            }
            objArr[c] = iArr;
            int[] iArr2 = new int[1];
            objArr[1] = iArr2;
            objArr[2] = new int[1];
            int i18 = ((i17 | 45) << 1) - (i17 ^ 45);
            int i19 = i18 % 128;
            artificialFrame = i19;
            if (i18 % 2 == 0) {
                iArr2[1] = i;
            } else {
                ((int[]) objArr[0])[0] = i;
            }
            iArr2[0] = i;
            objArr[3] = null;
            int i20 = i19 + 1;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
            int i21 = i20 % 2;
            int iNextInt = new Random().nextInt();
            int i22 = ~iNextInt;
            int i23 = (-288145178) + ((iNextInt | 536871168) * 988) + (((~(748307200 | i22)) | 18880542) * (-1976)) + (((~(iNextInt | (-230316575))) | 536871168 | (~(230316574 | i22))) * 988);
            int i24 = (i2 ^ i23) + ((i2 & i23) << 1);
            int i25 = i24 << 13;
            int i26 = ((~i24) & i25) | ((~i25) & i24);
            int i27 = i26 >>> 17;
            int i28 = (i26 | i27) & (~(i26 & i27));
            int i29 = i28 << 5;
            ((int[]) objArr[2])[0] = (i28 | i29) & (~(i28 & i29));
            return objArr;
        }
        try {
            int iLastIndexOf = TextUtils.lastIndexOf("", '0');
            int iICustomTabsCallbackStub = Elf32.Shdr.ICustomTabsCallbackStub();
            int i30 = iLastIndexOf * (-51);
            int i31 = (i30 ^ 53) + ((i30 & 53) << 1);
            int i32 = ~iICustomTabsCallbackStub;
            int i33 = i32 | iLastIndexOf;
            int i34 = i31 + ((~((i33 ^ 1) | (i33 & 1))) * 52);
            int i35 = ~iICustomTabsCallbackStub;
            int i36 = ~(((-2) ^ i35) | ((-2) & i35));
            int i37 = ~(((-2) ^ iLastIndexOf) | ((-2) & iLastIndexOf));
            int i38 = (i36 ^ i37) | (i37 & i36);
            int i39 = ~((i35 & iLastIndexOf) | (i35 ^ iLastIndexOf));
            int i40 = -(-(((i38 & i39) | (i38 ^ i39)) * (-52)));
            int i41 = (i34 & i40) + (i40 | i34);
            int i42 = ~((~iLastIndexOf) | i32);
            int i43 = ~iLastIndexOf;
            int i44 = ~((i43 & 1) | (i43 ^ 1));
            Object[] objArr2 = new Object[1];
            a((char) ((i41 - (~(((i42 & i44) | (i42 ^ i44)) * 52))) - 1), Drawable.resolveOpacity(0, 0), 38 - (~(-(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)))), objArr2);
            Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
            int i45 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
            int iICustomTabsCallbackStub2 = Elf32.Shdr.ICustomTabsCallbackStub();
            int i46 = i45 * (-419);
            int i47 = (i46 ^ 13051) + ((i46 & 13051) << 1);
            int i48 = (~((iICustomTabsCallbackStub2 ^ 31) | (iICustomTabsCallbackStub2 & 31))) * TypedValues.CycleType.TYPE_EASING;
            int i49 = (i47 ^ i48) + ((i48 & i47) << 1);
            int i50 = ~i45;
            int i51 = (i49 - (~(-(-(((i50 & 31) | (i50 ^ 31)) * (-420)))))) - 1;
            int i52 = ~i45;
            int i53 = ~((i52 & (-32)) | (i52 ^ (-32)));
            int i54 = ~iICustomTabsCallbackStub2;
            int i55 = ~((i54 & 31) | (i54 ^ 31));
            int i56 = ((i53 & i55) | (i53 ^ i55)) * TypedValues.CycleType.TYPE_EASING;
            Object[] objArr4 = new Object[1];
            b((i51 & i56) + (i51 | i56), new int[]{-1528017505, -552267627, 1156899660, -82815465, -1339105764, 702599849, 308449507, -1098005397, 1746765053, 1233872765, 1156899660, -82815465, 1704986320, 1190986843, -1959040527, -1406044148}, objArr4);
            String str = (String) objArr4[0];
            int i57 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i58 = (i57 & b.i) + (i57 | b.i);
            artificialFrame = i58 % 128;
            int i59 = i58 % 2;
            try {
                char c2 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                int i60 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                int iBlue = Color.blue(0);
                int i61 = iBlue * 85;
                int i62 = ((i61 | 3230) << 1) - (i61 ^ 3230);
                int i63 = ~iBlue;
                int i64 = ~((i63 ^ (-39)) | (i63 & (-39)));
                int i65 = ~i;
                int i66 = (~((i63 ^ i65) | (i63 & i65))) | i64;
                int i67 = ~i;
                int i68 = ~(((-39) ^ i67) | ((-39) & i67));
                int i69 = (i66 ^ i68) | (i66 & i68);
                int i70 = (iBlue ^ 38) | (iBlue & 38);
                int i71 = (i62 - (~((i69 | (~(i70 | i))) * (-84)))) - 1;
                int i72 = ~(((-39) ^ i) | ((-39) & i));
                int i73 = (i72 & iBlue) | (iBlue ^ i72);
                int i74 = ~(i67 | 38);
                int i75 = (i71 - (~(-(-(((i73 & i74) | (i73 ^ i74)) * (-84)))))) - 1;
                int i76 = ~i70;
                int i77 = i75 + (((i76 & i74) | (i74 ^ i76)) * 84);
                Object[] objArr5 = new Object[1];
                a(c2, (i60 & 1) + (i60 | 1), i77, objArr5);
                objArr3[0] = Class.forName((String) objArr5[0]).getDeclaredConstructor(String.class).newInstance(str);
                int i78 = -View.MeasureSpec.getMode(0);
                Object[] objArr6 = new Object[1];
                b((i78 & 31) + (i78 | 31), new int[]{-2095188255, 2029513943, 1746765053, 1233872765, 1156899660, -82815465, 1704986320, 1190986843, 400869724, -1722217626, -1047885210, -1868338742, 1682045958, 490294015, 585581967, -1669957635}, objArr6);
                try {
                    Object[] objArr7 = {(String) objArr6[0]};
                    int i79 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    int iICustomTabsCallbackStub3 = Elf32.Shdr.ICustomTabsCallbackStub();
                    int i80 = artificialFrame;
                    int i81 = i80 + 63;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i81 % 128;
                    if (i81 % 2 != 0) {
                        i3 = 1569105 * i79;
                    } else {
                        int i82 = i79 * 1773;
                        i3 = (i82 | 885) + (i82 & 885);
                    }
                    int i83 = ~(~i79);
                    int i84 = ~iICustomTabsCallbackStub3;
                    int i85 = (i83 & i84) | (i83 ^ i84);
                    int i86 = ~iICustomTabsCallbackStub3;
                    int i87 = (i86 & i79) | (i86 ^ i79);
                    int i88 = ~(i87 | (~i87));
                    int i89 = -(-(886 * ((i85 & i88) | (i85 ^ i88))));
                    int i90 = ~iICustomTabsCallbackStub3;
                    int i91 = (((i3 ^ i89) + ((i3 & i89) << 1)) - (~(((~((~i90) | i90)) | i79) * (-1772)))) - 1;
                    int i92 = i80 + 43;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i92 % 128;
                    int i93 = i92 % 2;
                    int i94 = 886 * (~(i79 | i90));
                    char c3 = (char) ((i91 ^ i94) + ((i94 & i91) << 1));
                    int jumpTapTimeout = ViewConfiguration.getJumpTapTimeout() >> 16;
                    int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0);
                    int i95 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i96 = (i95 ^ 17) + ((i95 & 17) << 1);
                    artificialFrame = i96 % 128;
                    if (i96 % 2 == 0) {
                        Object[] objArr8 = new Object[1];
                        a(c3, jumpTapTimeout, iLastIndexOf2 * 39, objArr8);
                        declaredConstructor = Class.forName((String) objArr8[0]).getDeclaredConstructor(String.class);
                    } else {
                        Object[] objArr9 = new Object[1];
                        a(c3, jumpTapTimeout, 38 - (~(-(-iLastIndexOf2))), objArr9);
                        declaredConstructor = Class.forName((String) objArr9[0]).getDeclaredConstructor(String.class);
                    }
                    objArr3[1] = declaredConstructor.newInstance(objArr7);
                    int i97 = artificialFrame;
                    int i98 = ((i97 | b.i) << 1) - (i97 ^ b.i);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i98 % 128;
                    int i99 = i98 % 2;
                    try {
                        int i100 = -(-(Process.myPid() >> 22));
                        Object[] objArr10 = new Object[1];
                        b((i100 & 23) + (i100 | 23), new int[]{-231986722, 857421807, 970643064, -1652599987, -1600040591, 801854682, 1245244747, -167297108, 471408579, 938811054, 157211430, -616899134}, objArr10);
                        Class<?> cls = Class.forName((String) objArr10[0]);
                        int minimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity() >> 16;
                        int i101 = ~(1645363179 | i65);
                        int i102 = -(-(((i101 & 1222437066) | (1222437066 ^ i101)) * (-90)));
                        int i103 = ((2020235236 | i102) << 1) - (i102 ^ 2020235236);
                        int i104 = ~((1645363179 & i) | (1645363179 ^ i));
                        int i105 = -(-(((i104 & 570562337) | (i104 ^ 570562337)) * (-45)));
                        int i106 = (i103 ^ i105) + ((i105 & i103) << 1);
                        int i107 = ~(((-1222437067) & i) | ((-1222437067) ^ i));
                        int i108 = (i107 & 1645363179) | (1645363179 ^ i107);
                        int i109 = ~((1222437066 & i67) | (i67 ^ 1222437066));
                        int i110 = ((i108 & i109) | (i108 ^ i109)) * 45;
                        int i111 = (i106 & i110) + (i110 | i106);
                        int iICustomTabsCallbackStub4 = Elf32.Shdr.ICustomTabsCallbackStub();
                        int i112 = ~((1796443008 ^ iICustomTabsCallbackStub4) | (1796443008 & iICustomTabsCallbackStub4));
                        int i113 = 1971810200 - (~(-(-(((i112 & (-1043266483)) | ((-1043266483) ^ i112)) * 191))));
                        int i114 = ~iICustomTabsCallbackStub4;
                        int i115 = ~((i114 & 1796443008) | (i114 ^ 1796443008));
                        if (i111 > i113 + (((i115 & (-2134899635)) | ((-2134899635) ^ i115)) * 191)) {
                            int i116 = TypedValues.PositionType.TYPE_PERCENT_WIDTH >>> minimumFlingVelocity;
                            i4 = (i116 << 1) - i116;
                            i5 = (-503) - (~(-((minimumFlingVelocity ^ 17) | (minimumFlingVelocity & 17))));
                        } else {
                            int i117 = minimumFlingVelocity * TypedValues.PositionType.TYPE_PERCENT_WIDTH;
                            i4 = ((i117 | 8551) << 1) - (i117 ^ 8551);
                            i5 = ((minimumFlingVelocity ^ 17) | (minimumFlingVelocity & 17)) * (-502);
                        }
                        int i118 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i119 = (i118 ^ 59) + ((i118 & 59) << 1);
                        int i120 = i119 % 128;
                        artificialFrame = i120;
                        if (i119 % 2 == 0) {
                            i6 = i4 % i5;
                            i8 = ~((~minimumFlingVelocity) | (-18));
                            i7 = ~minimumFlingVelocity;
                        } else {
                            i6 = (i4 & i5) + (i5 | i4);
                            i7 = ~minimumFlingVelocity;
                            i8 = ~(i7 | (-18));
                        }
                        int i121 = ~((i7 & i67) | (i7 ^ i67));
                        int i122 = (i8 & i121) | (i8 ^ i121);
                        int i123 = ~(minimumFlingVelocity | 17 | i);
                        int i124 = (-502) * ((i122 & i123) | (i122 ^ i123));
                        int i125 = ((i6 | i124) << 1) - (i6 ^ i124);
                        int i126 = ~minimumFlingVelocity;
                        int i127 = ~((i126 & i67) | (i126 ^ i67) | 17);
                        int i128 = i120 + 5;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i128 % 128;
                        int i129 = i128 % 2;
                        int i130 = -(-(TypedValues.PositionType.TYPE_DRAWPATH * ((i127 & i123) | (i127 ^ i123))));
                        int i131 = (i125 & i130) + (i130 | i125);
                        Object[] objArr11 = new Object[1];
                        b(i131, new int[]{127421039, -682801090, 762077181, 1560461432, -1605979326, -707002211, -278420051, 697699532, -1379694893, 1775733586}, objArr11);
                        Object objInvoke = cls.getMethod((String) objArr11[0], null).invoke(context, null);
                        try {
                            int threadPriority = Process.getThreadPriority(0);
                            int i132 = threadPriority * 565;
                            int i133 = ((-11260) ^ i132) + ((i132 & (-11260)) << 1);
                            int i134 = ~threadPriority;
                            int i135 = (~((i134 & i67) | (i134 ^ i67))) | (-21);
                            int i136 = ~((threadPriority ^ i) | (threadPriority & i));
                            int i137 = -(-(((i135 & i136) | (i135 ^ i136)) * (-564)));
                            int i138 = (((i133 | i137) << 1) - (i137 ^ i133)) + ((~((-21) | threadPriority | i)) * 1128);
                            int i139 = ~(((-21) & i67) | ((-21) ^ i67));
                            int i140 = ~((threadPriority & 20) | (threadPriority ^ 20));
                            int i141 = ((i139 & i140) | (i139 ^ i140)) * 564;
                            int i142 = ((i138 ^ i141) + ((i141 & i138) << 1)) >> 6;
                            int iICustomTabsCallbackStub5 = Elf32.Shdr.ICustomTabsCallbackStub();
                            int i143 = i142 * 624;
                            int i144 = (i143 ^ (-14306)) + ((i143 & (-14306)) << 1);
                            int iICustomTabsCallbackStub6 = Elf32.Shdr.ICustomTabsCallbackStub();
                            int i145 = 1094469175 - (~(-(-(((~(((-1889342471) & iICustomTabsCallbackStub6) | ((-1889342471) ^ iICustomTabsCallbackStub6))) | 545522690) * (-140)))));
                            int i146 = -(-((~((-1343819781) | iICustomTabsCallbackStub6)) * 70));
                            int i147 = ~((iICustomTabsCallbackStub6 & (-1578736509)) | ((-1578736509) ^ iICustomTabsCallbackStub6));
                            int i148 = (i145 & i146) + (i146 | i145) + (((i147 & 780439418) | (780439418 ^ i147)) * 70);
                            int iICustomTabsCallbackStub7 = Elf32.Shdr.ICustomTabsCallbackStub();
                            int i149 = 369745581 | iICustomTabsCallbackStub7;
                            int i150 = ((i149 ^ (-1756296793)) | (i149 & (-1756296793))) * (-381);
                            int i151 = (2131008390 ^ i150) + ((2131008390 & i150) << 1);
                            int i152 = ~iICustomTabsCallbackStub7;
                            int i153 = ~((i152 & 369745581) | (i152 ^ 369745581));
                            int i154 = (i153 & 579080) | (579080 ^ i153);
                            int i155 = -(-(((i154 & (-2125463294)) | (i154 ^ (-2125463294))) * 381));
                            if (i148 > (((i151 | i155) << 1) - (i151 ^ i155)) - 1086449904) {
                                int i156 = ((-24) ^ i142) | ((-24) & i142);
                                int i157 = i144 >>> (623 % (~((i156 & iICustomTabsCallbackStub5) | (i156 ^ iICustomTabsCallbackStub5))));
                                int i158 = ~iICustomTabsCallbackStub5;
                                int i159 = ~i142;
                                int i160 = ~((i159 & 23) | (i159 ^ 23));
                                i9 = (i157 - (~((-623) % ((i158 & i160) | (i158 ^ i160))))) - 1;
                                i10 = ~((-24) | i142);
                            } else {
                                int i161 = ((-24) & i142) | ((-24) ^ i142);
                                int i162 = (~(i161 | iICustomTabsCallbackStub5)) * 623;
                                int i163 = (i144 & i162) + (i144 | i162);
                                int i164 = ~iICustomTabsCallbackStub5;
                                int i165 = ~i142;
                                int i166 = ~((i165 & 23) | (i165 ^ 23));
                                i9 = i163 + (((i164 & i166) | (i164 ^ i166)) * (-623));
                                i10 = ~i161;
                            }
                            int i167 = ~(((-24) & iICustomTabsCallbackStub5) | ((-24) ^ iICustomTabsCallbackStub5));
                            int i168 = (i10 & i167) | (i10 ^ i167);
                            int i169 = ~((i142 & iICustomTabsCallbackStub5) | (i142 ^ iICustomTabsCallbackStub5));
                            Object[] objArr12 = new Object[1];
                            b((i9 - (~(-(-(623 * ((i169 & i168) | (i168 ^ i169))))))) - 1, new int[]{-231986722, 857421807, 970643064, -1652599987, -1600040591, 801854682, 1245244747, -167297108, 471408579, 938811054, 157211430, -616899134}, objArr12);
                            Class<?> cls2 = Class.forName((String) objArr12[0]);
                            int i170 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                            int i171 = i170 * 615;
                            int i172 = ((i171 | (-8582)) << 1) - (i171 ^ (-8582));
                            int i173 = (~i170) | 14;
                            int i174 = ~i173;
                            int i175 = (i174 & i) | (i ^ i174);
                            int i176 = ~(((-15) ^ i170) | ((-15) & i170));
                            int i177 = -(-(((i175 ^ i176) | (i175 & i176)) * 614));
                            int i178 = ((i172 | i177) << 1) - (i172 ^ i177);
                            int i179 = ~i170;
                            int i180 = (~i173) | (~(i179 | i67));
                            int i181 = ~(i67 | 14);
                            int i182 = ((i180 ^ i181) | (i180 & i181)) * (-1228);
                            int i183 = (i178 ^ i182) + ((i182 & i178) << 1);
                            int i184 = artificialFrame;
                            int i185 = (i184 & 97) + (i184 | 97);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i185 % 128;
                            int i186 = i185 % 2;
                            int i187 = (i179 ^ (-15)) | (i179 & (-15));
                            int i188 = ~((i187 & i65) | (i187 ^ i65));
                            int i189 = i170 | i67;
                            int i190 = ~((i189 & 14) | (i189 ^ 14));
                            int i191 = (i183 - (~(-(-(614 * ((i190 & i188) | (i188 ^ i190))))))) - 1;
                            Object[] objArr13 = new Object[1];
                            b(i191, new int[]{127421039, -682801090, 762077181, 1560461432, -400920591, 732879963, -677129442, 1145319993}, objArr13);
                            Object objInvoke2 = cls2.getMethod((String) objArr13[0], null).invoke(context, null);
                            int i192 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i193 = i192 + 67;
                            artificialFrame = i193 % 128;
                            int i194 = i193 % 2;
                            int i195 = i192 + 33;
                            artificialFrame = i195 % 128;
                            int i196 = i195 % 2;
                            try {
                                Object[] objArr14 = {objInvoke2, 64};
                                int i197 = -TextUtils.lastIndexOf("", '0', 0);
                                int iICustomTabsCallbackStub8 = Elf32.Shdr.ICustomTabsCallbackStub();
                                int i198 = i197 * (-575);
                                int i199 = (i198 & 575) + (i198 | 575);
                                int i200 = ~i197;
                                int i201 = ~i200;
                                int i202 = ~iICustomTabsCallbackStub8;
                                int i203 = i199 + (((i201 & i202) | (i201 ^ i202)) * 576);
                                int i204 = ~((~i200) | i200);
                                int i205 = ~iICustomTabsCallbackStub8;
                                int i206 = ~((i197 & i205) | (i205 ^ i197));
                                int i207 = -(-(((i206 & i204) | (i204 ^ i206)) * 576));
                                char c4 = (char) (((((i203 | i207) << 1) - (i207 ^ i203)) - (~(-(-((~i200) * 576))))) - 1);
                                int i208 = 37 - (~Drawable.resolveOpacity(0, 0));
                                int i209 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                                int i210 = (i209 * 398) - 12672;
                                int i211 = ~i209;
                                int i212 = ~(i211 | i67);
                                int i213 = ~(i211 | 32);
                                int i214 = (i212 ^ i213) | (i212 & i213);
                                int i215 = ~(i67 | 32);
                                int i216 = -(-(((i214 ^ i215) | (i214 & i215)) * (-397)));
                                int i217 = (i210 & i216) + (i210 | i216) + ((~((~i209) | 32)) * (-397));
                                int i218 = ~((i211 ^ 32) | (i211 & 32));
                                int i219 = (i218 & i) | (i ^ i218);
                                int i220 = ~((i209 & (-33)) | ((-33) ^ i209));
                                int i221 = ((i220 & i219) | (i219 ^ i220)) * 397;
                                int i222 = (i217 ^ i221) + ((i221 & i217) << 1);
                                Object[] objArr15 = new Object[1];
                                a(c4, i208, i222, objArr15);
                                Class<?> cls3 = Class.forName((String) objArr15[0]);
                                int i223 = -(-TextUtils.getOffsetAfter("", 0));
                                Object[] objArr16 = new Object[1];
                                b((i223 & 14) + (i223 | 14), new int[]{127421039, -682801090, 762077181, 1560461432, 1544676418, 2024374170, 1478053429, -967380042}, objArr16);
                                Object objInvoke3 = cls3.getMethod((String) objArr16[0], String.class, Integer.TYPE).invoke(objInvoke, objArr14);
                                int i224 = -ImageFormat.getBitsPerPixel(0);
                                int iICustomTabsCallbackStub9 = Elf32.Shdr.ICustomTabsCallbackStub();
                                int i225 = (i224 * 659) - 19053;
                                int i226 = ~i224;
                                int i227 = ~((i226 & 29) | (i226 ^ 29));
                                int i228 = ~((-30) | i224);
                                int i229 = (i227 & i228) | (i227 ^ i228);
                                int i230 = ~(i224 | iICustomTabsCallbackStub9);
                                int i231 = -(-(((i229 & i230) | (i229 ^ i230)) * (-658)));
                                int i232 = (i225 & i231) + (i225 | i231);
                                int i233 = (~(((-30) & i224) | ((-30) ^ i224))) * 658;
                                int i234 = (i232 ^ i233) + ((i233 & i232) << 1);
                                int i235 = ~(((-30) & i224) | ((-30) ^ i224));
                                int i236 = i224 ^ iICustomTabsCallbackStub9;
                                Object[] objArr17 = new Object[1];
                                b(i234 + (((~((i224 & iICustomTabsCallbackStub9) | i236)) | i235) * 658), new int[]{-231986722, 857421807, 970643064, -1652599987, -1600040591, 801854682, 1245244747, -167297108, -860417592, 430322865, 762077181, 1560461432, 1544676418, 2024374170, 1478053429, -967380042}, objArr17);
                                Class<?> cls4 = Class.forName((String) objArr17[0]);
                                int i237 = -(-(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                                Object[] objArr18 = new Object[1];
                                b((i237 ^ 9) + ((i237 & 9) << 1), new int[]{2029107004, 398467303, -1428337337, 870821349, 1490366487, -449689257}, objArr18);
                                Object[] objArr19 = (Object[]) cls4.getField((String) objArr18[0]).get(objInvoke3);
                                int length = objArr19.length;
                                int i238 = artificialFrame;
                                int i239 = ((i238 | b.i) << 1) - (i238 ^ b.i);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i239 % 128;
                                int i240 = i239 % 2;
                                int i241 = 0;
                                while (i241 < length) {
                                    Object obj = objArr19[i241];
                                    int i242 = 4 - (~(-ExpandableListView.getPackedPositionGroup(0L)));
                                    int[] iArr3 = {-1096202418, -130518844, 1241531163, -894667318};
                                    int i243 = artificialFrame;
                                    int i244 = (i243 & 77) + (i243 | 77);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i244 % 128;
                                    int i245 = i244 % 2;
                                    Object[] objArr20 = new Object[i15];
                                    b(i242, iArr3, objArr20);
                                    try {
                                        Object[] objArr21 = {(String) objArr20[0]};
                                        int iBlue2 = Color.blue(0);
                                        int iICustomTabsCallbackStub10 = Elf32.Shdr.ICustomTabsCallbackStub();
                                        int i246 = iBlue2 * (-559);
                                        int i247 = (i246 ^ 20757) + ((i246 & 20757) << i15);
                                        int i248 = ~iICustomTabsCallbackStub10;
                                        int i249 = -(-((~((i248 ^ iBlue2) | (i248 & iBlue2))) * (-560)));
                                        int i250 = (i247 ^ i249) + ((i249 & i247) << 1);
                                        int i251 = ((-38) & iBlue2) | ((-38) ^ iBlue2);
                                        int i252 = -(-((~((iICustomTabsCallbackStub10 & i251) | (i251 ^ iICustomTabsCallbackStub10))) * (-560)));
                                        int i253 = (i250 & i252) + (i250 | i252);
                                        int i254 = ~iBlue2;
                                        int i255 = ~((i254 & 37) | (i254 ^ 37));
                                        int i256 = ~((i248 ^ 37) | (i248 & 37));
                                        int i257 = -(-(((i255 & i256) | (i255 ^ i256)) * 560));
                                        Object[] objArr22 = new Object[1];
                                        b((i253 & i257) + (i257 | i253), new int[]{-794681752, -2137294447, -764099928, -328339933, -1195889699, 754484639, -1055039645, 224302601, -2129667903, -38466236, -353656646, 805906442, 1583913307, -993286547, 517188678, -864728737, -1510673660, -1204962265, 1436063165, -515168239}, objArr22);
                                        Class<?> cls5 = Class.forName((String) objArr22[0]);
                                        int iKeyCodeFromString = KeyEvent.keyCodeFromString("");
                                        int i258 = (iKeyCodeFromString * (-500)) - 5500;
                                        int i259 = ~(((-12) & iKeyCodeFromString) | ((-12) ^ iKeyCodeFromString));
                                        int i260 = (~iKeyCodeFromString) | 11;
                                        int i261 = ~((i260 ^ i) | (i260 & i));
                                        int i262 = -(-(((i259 ^ i261) | (i259 & i261)) * TypedValues.PositionType.TYPE_TRANSITION_EASING));
                                        int i263 = ((i258 | i262) << 1) - (i258 ^ i262);
                                        int i264 = ~iKeyCodeFromString;
                                        int i265 = -(-((~(i264 | (-12))) * 1002));
                                        int i266 = (i263 & i265) + (i265 | i263);
                                        int i267 = i264 | i67;
                                        int i268 = -(-((~((i267 & 11) | (i267 ^ 11))) * TypedValues.PositionType.TYPE_TRANSITION_EASING));
                                        Object[] objArr23 = new Object[1];
                                        b((i266 ^ i268) + ((i268 & i266) << 1), new int[]{529958419, 175671946, 1518877688, 854720125, 2079284654, 1456636681}, objArr23);
                                        Object objInvoke4 = cls5.getMethod((String) objArr23[0], String.class).invoke(null, objArr21);
                                        try {
                                            int i269 = 28 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                            int i270 = artificialFrame + 53;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i270 % 128;
                                            int i271 = i270 % 2;
                                            Object[] objArr24 = new Object[1];
                                            b(i269, new int[]{-231986722, 857421807, 970643064, -1652599987, -1600040591, 801854682, 1245244747, -167297108, -1867920441, 1128685974, 1642686155, 46171737, -693084181, -2013643276}, objArr24);
                                            Class<?> cls6 = Class.forName((String) objArr24[0]);
                                            Object[] objArr25 = objArr19;
                                            Object[] objArr26 = new Object[1];
                                            b(11 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new int[]{-1329332317, -705119090, 1679241993, -118436801, 985676981, -2105513564}, objArr26);
                                            try {
                                                Object[] objArr27 = {new ByteArrayInputStream((byte[]) cls6.getMethod((String) objArr26[0], null).invoke(obj, null))};
                                                int keyRepeatDelay = ViewConfiguration.getKeyRepeatDelay() >> 16;
                                                Object[] objArr28 = new Object[1];
                                                b((keyRepeatDelay & 37) + (keyRepeatDelay | 37), new int[]{-794681752, -2137294447, -764099928, -328339933, -1195889699, 754484639, -1055039645, 224302601, -2129667903, -38466236, -353656646, 805906442, 1583913307, -993286547, 517188678, -864728737, -1510673660, -1204962265, 1436063165, -515168239}, objArr28);
                                                Class<?> cls7 = Class.forName((String) objArr28[0]);
                                                int i272 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                                                Object[] objArr29 = new Object[1];
                                                b((i272 & 19) + (i272 | 19), new int[]{1785330264, 1845518860, 1644079591, -1062775423, -2006269029, -1135161405, 1260171533, -156624354, -1664083588, 978636373}, objArr29);
                                                Object objInvoke5 = cls7.getMethod((String) objArr29[0], InputStream.class).invoke(objInvoke4, objArr27);
                                                int length2 = objArr3.length;
                                                int i273 = artificialFrame;
                                                int i274 = (i273 & 117) + (i273 | 117);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i274 % 128;
                                                int i275 = i274 % 2;
                                                int i276 = 0;
                                                for (int i277 = 2; i276 < i277; i277 = 2) {
                                                    Object obj2 = objArr3[i276];
                                                    try {
                                                        int i278 = -TextUtils.lastIndexOf("", '0', 0, 0);
                                                        int iICustomTabsCallbackStub11 = Elf32.Shdr.ICustomTabsCallbackStub();
                                                        int i279 = (i278 * 50) - 5925730;
                                                        int i280 = ~iICustomTabsCallbackStub11;
                                                        int i281 = length;
                                                        int i282 = ~(((-61091) ^ i280) | ((-61091) & i280));
                                                        int i283 = ~(((-61091) ^ i278) | ((-61091) & i278));
                                                        int i284 = ((i282 ^ i283) | (i282 & i283)) * 98;
                                                        int i285 = (i279 & i284) + (i284 | i279);
                                                        int i286 = ~i278;
                                                        int i287 = ~((i286 & i280) | (i286 ^ i280));
                                                        int i288 = (i287 & (-61091)) | ((-61091) ^ i287);
                                                        int i289 = ~((i278 ^ iICustomTabsCallbackStub11) | (i278 & iICustomTabsCallbackStub11));
                                                        int i290 = ((i288 & i289) | (i288 ^ i289)) * (-49);
                                                        char c5 = (char) ((i285 & i290) + (i290 | i285) + (((~(((-61091) & iICustomTabsCallbackStub11) | ((-61091) ^ iICustomTabsCallbackStub11))) | (~(i278 | 61090))) * 49));
                                                        int iRgb = Color.rgb(0, 0, 0);
                                                        int iICustomTabsCallbackStub12 = Elf32.Shdr.ICustomTabsCallbackStub();
                                                        int i291 = iRgb * (-183);
                                                        int i292 = ((i291 | (-1191169201)) << 1) - (i291 ^ (-1191169201));
                                                        int i293 = ~iRgb;
                                                        int i294 = i292 + (((i293 ^ 16777287) | (i293 & 16777287)) * (-368));
                                                        int i295 = (iRgb ^ (-16777288)) | (iRgb & (-16777288));
                                                        int i296 = ~iICustomTabsCallbackStub12;
                                                        int i297 = -(-(((i295 ^ i296) | (i295 & i296)) * SyslogConstants.LOG_LOCAL7));
                                                        int i298 = (i294 ^ i297) + ((i297 & i294) << 1);
                                                        int i299 = ~iRgb;
                                                        int i300 = (~(i296 | iRgb)) | (~(((-16777288) & i299) | (i299 ^ (-16777288))));
                                                        int i301 = ~((iRgb & 16777287) | (iRgb ^ 16777287));
                                                        int i302 = -(-(((i300 & i301) | (i300 ^ i301)) * SyslogConstants.LOG_LOCAL7));
                                                        Object[] objArr30 = new Object[1];
                                                        a(c5, (i298 & i302) + (i298 | i302), 34 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr30);
                                                        Class<?> cls8 = Class.forName((String) objArr30[0]);
                                                        Object[] objArr31 = new Object[1];
                                                        b(23 - (~(-(-TextUtils.indexOf((CharSequence) "", '0', 0, 0)))), new int[]{-738983497, 1313457131, -504533110, 1673768216, 1112261350, -1176716700, 388958928, 1663877057, 1749170235, -1974591104, -1601446973, -1680138651}, objArr31);
                                                        if (obj2.equals(cls8.getMethod((String) objArr31[0], null).invoke(objInvoke5, null))) {
                                                            Object[] objArr32 = {new int[]{i}, new int[]{i ^ 1}, new int[]{(i | i) & (~(i & i))}, null};
                                                            int i303 = 704215000 + ((~((-556271619) | i67)) * 433) + (((~((-211260413) | i)) | (-767363363)) * (-433)) + (((~((-767363363) | i)) | (-767532031)) * 433);
                                                            int i304 = 5935 - (~(i303 * 371));
                                                            int i305 = ~i303;
                                                            int i306 = ~((i305 & i67) | (i305 ^ i67));
                                                            int i307 = ~((-17) | i);
                                                            int i308 = ((i306 & i307) | (i306 ^ i307)) * (-370);
                                                            int i309 = ((i304 | i308) << 1) - (i304 ^ i308);
                                                            int i310 = ~(((-17) ^ i65) | ((-17) & i65));
                                                            int i311 = ~i303;
                                                            int i312 = ~((i311 & i) | (i311 ^ i));
                                                            int i313 = (i310 & i312) | (i310 ^ i312);
                                                            int i314 = i303 | 16;
                                                            int i315 = ~i314;
                                                            int i316 = (i309 - (~(-(-(((i313 & i315) | (i313 ^ i315)) * (-370)))))) - 1;
                                                            int i317 = (~i314) * 370;
                                                            int i318 = (i316 ^ i317) + ((i317 & i316) << 1);
                                                            int i319 = (i2 & i318) + (i318 | i2);
                                                            int i320 = i319 << 13;
                                                            int i321 = ((~i319) & i320) | ((~i320) & i319);
                                                            int i322 = i321 >>> 17;
                                                            int i323 = ((~i321) & i322) | ((~i322) & i321);
                                                            int i324 = i323 << 5;
                                                            return objArr32;
                                                        }
                                                        int i325 = i276 - 48;
                                                        i276 = (i325 ^ 49) + ((i325 & 49) << 1);
                                                        length = i281;
                                                    } catch (Throwable th) {
                                                        Throwable cause = th.getCause();
                                                        if (cause != null) {
                                                            throw cause;
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                int i326 = length;
                                                int i327 = (i241 & (-6)) + (i241 | (-6));
                                                i241 = (i327 ^ 7) + ((i327 & 7) << 1);
                                                int i328 = getARTIFICIAL_FRAME_PACKAGE_NAME + 43;
                                                artificialFrame = i328 % 128;
                                                if (i328 % 2 == 0) {
                                                    int i329 = 3 / 4;
                                                }
                                                objArr19 = objArr25;
                                                length = i326;
                                                i15 = 1;
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
        Object[] objArr33 = {new int[]{i}, new int[]{i}, new int[1], null};
        int i330 = ~((int) Runtime.getRuntime().totalMemory());
        int i331 = ~(258352661 | i330);
        int i332 = (-271071726) + ((i331 | 720271113) * 764) + (((~(i330 | 720271113)) | 83886100) * (-1528)) + ((629690652 | i331) * 764);
        int i333 = artificialFrame;
        int i334 = (i333 ^ 13) + ((i333 & 13) << 1);
        getARTIFICIAL_FRAME_PACKAGE_NAME = i334 % 128;
        int i335 = i334 % 2;
        int i336 = -(-(i332 * 829));
        int i337 = (i336 << 1) - i336;
        int i338 = ~i332;
        int i339 = ~(i338 | ((-1) ^ i338));
        int i340 = ~i;
        int i341 = ~(i340 | i332);
        int i342 = (i337 - (~(((i339 & i341) | (i339 ^ i341)) * (-828)))) - 1;
        int i343 = ((i340 & i332) | (i332 ^ i340)) * (-828);
        int i344 = (i342 & i343) + (i343 | i342);
        int i345 = -(-((~i332) * 828));
        int i346 = (i344 ^ i345) + ((i345 & i344) << 1);
        int iICustomTabsCallbackStub13 = Elf32.Shdr.ICustomTabsCallbackStub();
        int i347 = i346 * (-464);
        int i348 = -(-(i2 * (-929)));
        int i349 = ((i347 | i348) << 1) - (i347 ^ i348);
        int i350 = ~i346;
        int i351 = ~(i2 | iICustomTabsCallbackStub13);
        int i352 = ((i351 & i350) | (i350 ^ i351)) * (-465);
        int i353 = ~i346;
        int i354 = ((((i349 | i352) << 1) - (i352 ^ i349)) - (~(((~((i353 & iICustomTabsCallbackStub13) | (i353 ^ iICustomTabsCallbackStub13))) | i2) * 930))) - 1;
        int i355 = ((iICustomTabsCallbackStub13 & i2) | (i2 ^ iICustomTabsCallbackStub13) | i350) * 465;
        int i356 = (i354 & i355) + (i355 | i354);
        int i357 = i356 << 13;
        int i358 = (i357 | i356) & (~(i356 & i357));
        int i359 = i358 >>> 17;
        int i360 = (i358 | i359) & (~(i358 & i359));
        int i361 = i360 << 5;
        ((int[]) objArr33[2])[0] = ((~i360) & i361) | ((~i361) & i360);
        return objArr33;
    }
}
