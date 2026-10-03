package com.google.android.datatransport.cct;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.onPostMessage;

/* JADX INFO: loaded from: classes2.dex */
public final class StringMerger {
    private static final byte[] $$c = {Ascii.SYN, 117, 37, -99};
    private static final int $$d = 101;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {99, -110, -1, 56, Ascii.VT, 2, -12};
    private static final int $$b = 195;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] IPostMessageService = {38280, 38374, 38373, 38356, 38361, 38360, 38353, 38356, 38364, 38379, 38372, 38353, 38361, 38363, 38355, 38356, 38363, 38358, 38353, 38182, 38035, 38040, 38039, 38032, 38035, 38043, 38058, 38051, 38030, 38052, 38056, 38036, 38035, 38032, 38032, 38041, 38034, 38185, 38045, 38053, 38068, 38223, 38072, 38039, 38074, 38079, 38050, 38044, 38040, 38045, 38047, 38049, 38052, 38278, 38356, 38363, 38365, 38358, 38348, 38358, 38358, 38350, 38358, 38356, 38349, 38348, 38355, 38390, 38388, 38357, 38356, 38361, 38365, 38358, 38348, 38382, 38388, 38353, 38356, 38364, 38363, 38390, 38386, 38359, 38358, 38351, 38356, 38359, 38386, 38382, 38345, 38345, 38382, 38280, 38353, 38352, 38383, 38202, 38199, 38172, 38171, 38164, 38169, 38172, 38199, 38195, 38158, 38158, 38195, 38203, 38171, 38164, 38163, 38197, 38203, 38176, 38172, 38173, 38179, 38173, 38171, 38178, 38178, 38176, 38178, 38171, 38161, 38311, 38277, 38348, 38358, 38365, 38361, 38356, 38357, 38388, 38382, 38348, 38358, 38365, 38361, 38356, 38357, 38364, 38360, 38353, 38385, 38382, 38345, 38345, 38382, 38386, 38359, 38356, 38351, 38358, 38359, 38386, 38390, 38363, 38364, 38356, 38353, 38388};

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r6, short r7, byte r8) {
        /*
            int r6 = r6 * 4
            int r6 = 1 - r6
            int r7 = r7 * 3
            int r7 = r7 + 4
            byte[] r0 = com.google.android.datatransport.cct.StringMerger.$$c
            int r8 = r8 * 3
            int r8 = 122 - r8
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r8
            r4 = r2
            r8 = r6
            goto L27
        L17:
            r3 = r2
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L25:
            r3 = r0[r7]
        L27:
            int r8 = r8 + r3
            int r7 = r7 + 1
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.StringMerger.$$e(byte, short, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r5, short r6, short r7, java.lang.Object[] r8) {
        /*
            int r6 = r6 * 2
            int r6 = 4 - r6
            int r7 = r7 * 4
            int r7 = 109 - r7
            int r5 = r5 * 4
            int r0 = r5 + 4
            byte[] r1 = com.google.android.datatransport.cct.StringMerger.$$a
            byte[] r0 = new byte[r0]
            int r5 = r5 + 3
            r2 = 0
            if (r1 != 0) goto L19
            r3 = r7
            r4 = r2
            r7 = r5
            goto L2b
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r7
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r5) goto L29
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L29:
            r3 = r1[r6]
        L2b:
            int r6 = r6 + 1
            int r7 = r7 + r3
            int r7 = r7 + (-3)
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.StringMerger.b(short, short, short, java.lang.Object[]):void");
    }

    static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    private static void a(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
        int i;
        int i2 = 2;
        int i3 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i4 = 0;
        int i5 = iArr[0];
        int i6 = iArr[1];
        int i7 = iArr[2];
        int i8 = iArr[3];
        char[] cArr = IPostMessageService;
        long j = 0;
        if (cArr != null) {
            int i9 = $10 + 87;
            $11 = i9 % 128;
            int i10 = i9 % 2;
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i11 = 0;
            while (i11 < length) {
                int i12 = $11 + 91;
                $10 = i12 % 128;
                if (i12 % i2 != 0) {
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i4] = Integer.valueOf(cArr[i11]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i4;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getPressedStateDuration() >> 16) + 11, (char) ((ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1)) - 1), 1562 - View.MeasureSpec.getSize(i4), 178318710, false, $$e(b, b2, (byte) (b2 | 19)), new Class[]{Integer.TYPE});
                        }
                        cArr2[i11] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i11 = 0;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    try {
                        Object[] objArr3 = {Integer.valueOf(cArr[i11])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(11 - View.MeasureSpec.getMode(0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), 1562 - Color.argb(0, 0, 0, 0), 178318710, false, $$e(b3, b4, (byte) (b4 | 19)), new Class[]{Integer.TYPE});
                        }
                        cArr2[i11] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        i11++;
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                i2 = 2;
                i4 = 0;
                j = 0;
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i6];
        System.arraycopy(cArr, i5, cArr3, 0, i6);
        if (bArr != null) {
            char[] cArr4 = new char[i6];
            onpostmessage.a = 0;
            char c = 0;
            while (onpostmessage.a < i6) {
                if (bArr[onpostmessage.a] == 1) {
                    int i13 = onpostmessage.a;
                    Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.CAN, (char) TextUtils.getCapsMode("", 0, 0), 2442 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), -850656813, false, $$e(b5, b6, (byte) (b6 | Ascii.DC2)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i13] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                } else {
                    int i14 = onpostmessage.a;
                    Object[] objArr5 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = b7;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) View.resolveSize(0, 0), Color.blue(0) + 1562, 1918398056, false, $$e(b7, b8, b8), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i14] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                }
                c = cArr4[onpostmessage.a];
                Object[] objArr6 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(21 - ExpandableListView.getPackedPositionChild(0L), (char) (29363 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), (KeyEvent.getMaxKeyCode() >> 16) + JfifUtil.MARKER_RST7, -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            }
            cArr3 = cArr4;
        }
        if (i8 > 0) {
            int i15 = $11 + 61;
            $10 = i15 % 128;
            int i16 = i15 % 2;
            char[] cArr5 = new char[i6];
            i = 0;
            System.arraycopy(cArr3, 0, cArr5, 0, i6);
            int i17 = i6 - i8;
            System.arraycopy(cArr5, 0, cArr3, i17, i8);
            System.arraycopy(cArr5, i8, cArr3, 0, i17);
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
                cArr6[onpostmessage.a] = cArr3[(i6 - onpostmessage.a) - 1];
                i = onpostmessage.a + 1;
            }
            cArr3 = cArr6;
        }
        if (i7 > 0) {
            int i18 = 0;
            while (true) {
                onpostmessage.a = i18;
                if (onpostmessage.a >= i6) {
                    break;
                }
                cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                i18 = onpostmessage.a + 1;
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
    public static java.lang.Object[] coroutineCreation(int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 2562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.StringMerger.coroutineCreation(int, int):java.lang.Object[]");
    }
}
