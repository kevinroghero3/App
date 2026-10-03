package com.google.firebase.components;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.extraCallback;
import o.onMessageChannelReady;

/* JADX INFO: loaded from: classes5.dex */
public class InvalidRegistrarException extends RuntimeException {
    private static final byte[] $$a = {4, -24, -50, 10};
    private static final int $$b = 76;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] ArtificialStackFrames = {44373, 44395, 44334, 44361, 44359, 44363, 44398, 44400, 44404, 44349, 44394, 44399, 44368, 44371, 44409, 44392, 44405, 44376, 44360, 44385, 44389, 44386, 44403, 44365, 44345, 44406, 44364, 44362, 44402, 44320, 44387, 44397, 44367, 44336, 44366, 44355, 44353, 44358, 44393, 44352, 44388, 44396, 44391, 44390, 44356, 44332, 44408, 44341, 44354};
    private static char coroutineCreation = 39069;
    private static char[] validateRelationship = {56112, 56126, 56102, 56096, 56271, 56108, 56114, 56077, 56087, 56065, 56076, 56074, 56109, 56275, 56119, 56086, 56081, 56070, 56084, 56064, 56082, 56071, 56091, 56269, 56262, 56259, 56122, 56106, 56080, 56067, 56078, 56085};
    private static int warmup = -1044259853;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;

    private static String $$c(byte b, short s, short s2) {
        byte[] bArr = $$a;
        int i = 121 - s;
        int i2 = b * 4;
        int i3 = 3 - (s2 * 4);
        byte[] bArr2 = new byte[i2 + 1];
        int i4 = -1;
        if (bArr == null) {
            i = i2 + i3;
            i3 = i3;
            i4 = -1;
        }
        while (true) {
            int i5 = i3 + 1;
            int i6 = i4 + 1;
            bArr2[i6] = (byte) i;
            if (i6 == i2) {
                return new String(bArr2, 0);
            }
            i += bArr[i5];
            i3 = i5;
            i4 = i6;
        }
    }

    public InvalidRegistrarException(String str) {
        super(str);
    }

    public InvalidRegistrarException(String str, Throwable th) {
        super(str, th);
    }

    private static void b(char[] cArr, byte[] bArr, int i, int[] iArr, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr2 = validateRelationship;
        float f = 0.0f;
        int i4 = 0;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i5 = 0;
            while (i5 < length) {
                int i6 = $11 + 81;
                $10 = i6 % 128;
                int i7 = i6 % i2;
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i4] = Integer.valueOf(cArr2[i5]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i4;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(26 - Color.red(i4), (char) ((ViewConfiguration.getScrollFriction() > f ? 1 : (ViewConfiguration.getScrollFriction() == f ? 0 : -1)) - 1), (ViewConfiguration.getPressedStateDuration() >> 16) + 1041, -1719489573, false, $$c(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    cArr3[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i5++;
                    int i8 = $10 + 57;
                    $11 = i8 % 128;
                    int i9 = i8 % 2;
                    i2 = 2;
                    f = 0.0f;
                    i4 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            int i10 = $11 + 91;
            $10 = i10 % 128;
            if (i10 % 2 != 0) {
                int i11 = 3 / 4;
            }
            cArr2 = cArr3;
        }
        Object[] objArr3 = {Integer.valueOf(warmup)};
        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
        if (objAccessartificialFrame2 == null) {
            byte b3 = (byte) 0;
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(15 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (20488 - TextUtils.indexOf("", "")), 2148 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 216472770, false, $$c(b3, (byte) (b3 | 54), b3), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
        int i12 = 59174;
        int i13 = -2083387879;
        if (ICustomTabsServiceDefault) {
            onmessagechannelready.c = bArr.length;
            char[] cArr4 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            int i14 = $11 + 49;
            $10 = i14 % 128;
            int i15 = i14 % 2;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                if (objAccessartificialFrame3 == null) {
                    byte b4 = (byte) 0;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(22 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (Color.alpha(0) + 59174), 1943 - (Process.myTid() >> 22), 481771537, false, $$c(b4, (byte) (b4 | 55), b4), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            }
            objArr[0] = new String(cArr4);
            return;
        }
        if (requestPostMessageChannelWithExtras) {
            onmessagechannelready.c = cArr.length;
            char[] cArr5 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr5[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(i13);
                if (objAccessartificialFrame4 == null) {
                    byte b5 = (byte) 0;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 21, (char) (i12 - TextUtils.indexOf("", "", 0, 0)), 1943 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 481771537, false, $$c(b5, (byte) (b5 | 55), b5), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                i12 = 59174;
                i13 = -2083387879;
            }
            objArr[0] = new String(cArr5);
            return;
        }
        int i16 = 0;
        onmessagechannelready.c = iArr.length;
        char[] cArr6 = new char[onmessagechannelready.c];
        while (true) {
            onmessagechannelready.a = i16;
            if (onmessagechannelready.a >= onmessagechannelready.c) {
                objArr[0] = new String(cArr6);
                return;
            }
            int i17 = $10 + 5;
            $11 = i17 % 128;
            if (i17 % 2 == 0) {
                cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c >> 1) - onmessagechannelready.a] >>> i] * iIntValue);
                i16 = onmessagechannelready.a % 1;
            } else {
                cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                i16 = onmessagechannelready.a + 1;
            }
        }
    }

    private static void a(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
        int i2;
        Object obj;
        char c;
        int i3 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        long j = 0;
        Object obj2 = null;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i4 = 0;
            while (i4 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i4])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1819279892);
                    if (objAccessartificialFrame == null) {
                        byte b2 = (byte) 0;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(0) + 16, (char) (20489 - (SystemClock.uptimeMillis() > j ? 1 : (SystemClock.uptimeMillis() == j ? 0 : -1))), 2148 - View.combineMeasuredStates(0, 0), 216710116, false, $$c(b2, (byte) (-$$a[1]), b2), new Class[]{Integer.TYPE});
                    }
                    cArr3[i4] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i4++;
                    j = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr2 = cArr3;
        }
        try {
            Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
            if (objAccessartificialFrame2 == null) {
                byte b3 = (byte) 0;
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(15 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (ExpandableListView.getPackedPositionType(0L) + 20488), 2148 - TextUtils.getTrimmedLength(""), 216710116, false, $$c(b3, (byte) (-$$a[1]), b3), new Class[]{Integer.TYPE});
            }
            char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
            char[] cArr4 = new char[i];
            char c2 = 11;
            if (i % 2 != 0) {
                int i5 = $11 + 11;
                $10 = i5 % 128;
                if (i5 % 2 != 0) {
                    i2 = i + 76;
                    cArr4[i2] = (char) (cArr[i2] * b);
                } else {
                    i2 = i - 1;
                    cArr4[i2] = (char) (cArr[i2] - b);
                }
            } else {
                i2 = i;
            }
            if (i2 > 1) {
                int i6 = $11 + 3;
                $10 = i6 % 128;
                if (i6 % 2 != 0) {
                    extracallback.a = 1;
                } else {
                    extracallback.a = 0;
                }
                while (extracallback.a < i2) {
                    extracallback.createBrowser = cArr[extracallback.a];
                    extracallback.c = cArr[extracallback.a + 1];
                    if (extracallback.createBrowser == extracallback.c) {
                        int i7 = $10 + 21;
                        $11 = i7 % 128;
                        int i8 = i7 % 2;
                        cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                        cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        int i9 = $11 + 17;
                        $10 = i9 % 128;
                        int i10 = i9 % 2;
                        c = c2;
                        obj = obj2;
                    } else {
                        try {
                            Object[] objArr4 = new Object[13];
                            objArr4[12] = extracallback;
                            objArr4[c2] = Integer.valueOf(cCharValue);
                            objArr4[10] = extracallback;
                            objArr4[9] = extracallback;
                            objArr4[8] = Integer.valueOf(cCharValue);
                            objArr4[7] = extracallback;
                            objArr4[6] = extracallback;
                            objArr4[5] = Integer.valueOf(cCharValue);
                            objArr4[4] = extracallback;
                            objArr4[3] = extracallback;
                            objArr4[2] = Integer.valueOf(cCharValue);
                            objArr4[1] = extracallback;
                            objArr4[0] = extracallback;
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                            if (objAccessartificialFrame3 == null) {
                                byte b4 = (byte) 0;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 46, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 58858), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 2464, 276640984, false, $$c(b4, (byte) (b4 | 19), b4), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                            }
                            if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                                int i11 = $11 + 101;
                                $10 = i11 % 128;
                                int i12 = i11 % 2;
                                Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                if (objAccessartificialFrame4 == null) {
                                    int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 24;
                                    char c3 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                                    int absoluteGravity = 792 - Gravity.getAbsoluteGravity(0, 0);
                                    byte b5 = (byte) 0;
                                    String str$$c = $$c(b5, (byte) (b5 | Ascii.DLE), b5);
                                    c = 11;
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(tapTimeout, c3, absoluteGravity, -834291897, false, str$$c, new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                } else {
                                    c = 11;
                                }
                                obj = null;
                                int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                                int i13 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[iIntValue];
                                cArr4[extracallback.a + 1] = cArr2[i13];
                            } else {
                                obj = null;
                                c = 11;
                                if (extracallback.b == extracallback.d) {
                                    extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                    extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                    int i14 = (extracallback.b * cCharValue) + extracallback.j;
                                    int i15 = (extracallback.d * cCharValue) + extracallback.g;
                                    cArr4[extracallback.a] = cArr2[i14];
                                    cArr4[extracallback.a + 1] = cArr2[i15];
                                } else {
                                    int i16 = (extracallback.b * cCharValue) + extracallback.g;
                                    int i17 = (extracallback.d * cCharValue) + extracallback.j;
                                    cArr4[extracallback.a] = cArr2[i16];
                                    cArr4[extracallback.a + 1] = cArr2[i17];
                                }
                            }
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    }
                    extracallback.a += 2;
                    obj2 = obj;
                    c2 = c;
                }
            }
            for (int i18 = 0; i18 < i; i18++) {
                cArr4[i18] = (char) (cArr4[i18] ^ 13722);
            }
            objArr[0] = new String(cArr4);
        } catch (Throwable th3) {
            Throwable cause3 = th3.getCause();
            if (cause3 == null) {
                throw th3;
            }
            throw cause3;
        }
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] accessartificialFrame(android.content.Context r27, int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 3987
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.InvalidRegistrarException.accessartificialFrame(android.content.Context, int, int):java.lang.Object[]");
    }
}
