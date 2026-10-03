package org.simpleframework.xml.filter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.Stack;
import o.ArtificialStackFrames;
import o.onPostMessage;

/* JADX INFO: loaded from: classes6.dex */
public class StackFilter implements Filter {
    private Stack<Filter> stack = new Stack<>();
    private static final byte[] $$c = {85, -33, -39, -30};
    private static final int $$d = 37;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {72, -88, 5, 32, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, 50, Ascii.SO, -50, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4};
    private static final int $$b = 98;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] IPostMessageService = {38277, 38345, 38353, 38355, 38350, 38353, 38374, 38279, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38280, 38357, 38357, 38356, 38361, 38355, 38373, 38375, 38351, 38353, 38357, 38361, 38365, 38357, 38353, 38355, 38353, 38372, 38184, 38037, 38037, 38039, 38040, 38038, 38036, 38031, 38035, 38041, 38070, 38071, 38038, 38033, 38030, 38035, 38038, 38030, 38062, 38064, 38033, 38066, 38216, 38055, 38031, 38033, 38037, 38041, 38045, 38037, 38033, 38035, 38033, 38052, 38278, 38355, 38358, 38361, 38363, 38312, 38389, 38355, 38356, 38390, 38387, 38356, 38356, 38353, 38382, 38386, 38355, 38356, 38360, 38391, 38391, 38363, 38364, 38356, 38353, 38360, 38363, 38366, 38360, 38359, 38390, 38383, 38357, 38278, 38351, 38385, 38390, 38363, 38364, 38356, 38353, 38360, 38363, 38366, 38360, 38359, 38311};

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r5, int r6, short r7) {
        /*
            int r6 = r6 + 4
            byte[] r0 = org.simpleframework.xml.filter.StackFilter.$$c
            int r5 = r5 * 3
            int r5 = r5 + 65
            int r7 = r7 * 3
            int r1 = r7 + 1
            byte[] r1 = new byte[r1]
            r2 = -1
            if (r0 != 0) goto L14
            r5 = r6
            r3 = r7
            goto L29
        L14:
            r4 = r6
            r6 = r5
            r5 = r4
        L17:
            int r2 = r2 + 1
            byte r3 = (byte) r6
            r1[r2] = r3
            int r5 = r5 + 1
            if (r2 != r7) goto L27
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            return r5
        L27:
            r3 = r0[r5]
        L29:
            int r6 = r6 + r3
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: org.simpleframework.xml.filter.StackFilter.$$e(short, int, short):java.lang.String");
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
    private static void b(int r5, short r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = org.simpleframework.xml.filter.StackFilter.$$a
            int r1 = r6 + 2
            int r5 = r5 + 4
            int r7 = r7 + 66
            byte[] r1 = new byte[r1]
            int r6 = r6 + 1
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r5
            r7 = r6
            r4 = r2
            goto L25
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L23
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L23:
            r3 = r0[r5]
        L25:
            int r5 = r5 + 1
            int r7 = r7 + r3
            int r7 = r7 + (-5)
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.simpleframework.xml.filter.StackFilter.b(int, short, int, java.lang.Object[]):void");
    }

    public void push(Filter filter) {
        this.stack.push(filter);
    }

    @Override // org.simpleframework.xml.filter.Filter
    public String replace(String str) {
        String strReplace;
        int size = this.stack.size();
        do {
            size--;
            if (size < 0) {
                return null;
            }
            strReplace = this.stack.get(size).replace(str);
        } while (strReplace == null);
        return strReplace;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0252  */
    /* JADX WARN: Code duplicated, block: B:58:0x0253  */
    private static void a(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
        int i;
        Throwable cause;
        int i2 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i3 = 0;
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = iArr[2];
        int i7 = iArr[3];
        char[] cArr = IPostMessageService;
        long j = 0;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i8 = 0;
            while (i8 < length) {
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i3] = Integer.valueOf(cArr[i8]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i3;
                        byte b2 = (byte) (b - 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1))), Drawable.resolveOpacity(i3, i3) + 1562, 178318710, false, $$e(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                    }
                    cArr2[i8] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i8++;
                    i3 = 0;
                    j = 0;
                } catch (Throwable th) {
                    Throwable cause2 = th.getCause();
                    if (cause2 == null) {
                        throw th;
                    }
                    throw cause2;
                }
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i5];
        System.arraycopy(cArr, i4, cArr3, 0, i5);
        if (bArr != null) {
            char[] cArr4 = new char[i5];
            onpostmessage.a = 0;
            char c = 0;
            while (onpostmessage.a < i5) {
                if (bArr[onpostmessage.a] == 1) {
                    int i9 = $11 + 35;
                    $10 = i9 % 128;
                    if (i9 % 2 != 0) {
                        int i10 = onpostmessage.a;
                        Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                        if (objAccessartificialFrame2 == null) {
                            int i11 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 23;
                            char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
                            int iRgb = (-16774775) - Color.rgb(0, 0, 0);
                            byte b3 = (byte) ($$d & 3);
                            byte b4 = (byte) (-b3);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i11, modifierMetaStateMask, iRgb, -850656813, false, $$e(b3, b4, (byte) (b4 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        Object obj = null;
                        cArr4[i10] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        obj.hashCode();
                        throw null;
                    }
                    int i12 = onpostmessage.a;
                    try {
                        Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                        if (objAccessartificialFrame3 == null) {
                            int i13 = 23 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                            char capsMode = (char) TextUtils.getCapsMode("", 0, 0);
                            int iBlue = Color.blue(0) + 2441;
                            byte b5 = (byte) ($$d & 3);
                            byte b6 = (byte) (-b5);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i13, capsMode, iBlue, -850656813, false, $$e(b5, b6, (byte) (b6 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr4[i12] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                    } catch (Throwable th2) {
                        cause = th2.getCause();
                        if (cause != null) {
                            throw th2;
                        }
                        throw cause;
                    }
                    cause = th2.getCause();
                    if (cause != null) {
                        throw th2;
                    }
                    throw cause;
                }
                int i14 = onpostmessage.a;
                Object[] objArr5 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-314759072);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) (-1);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) ExpandableListView.getPackedPositionType(0L), 1561 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 1918398056, false, $$e((byte) 19, b7, (byte) (b7 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr4[i14] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                c = cArr4[onpostmessage.a];
                Object[] objArr6 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getMode(0) + 22, (char) (29363 - KeyEvent.getDeadChar(0, 0)), KeyEvent.normalizeMetaState(0) + JfifUtil.MARKER_RST7, -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                int i15 = $11 + 45;
                $10 = i15 % 128;
                int i16 = i15 % 2;
            }
            cArr3 = cArr4;
        }
        if (i7 > 0) {
            char[] cArr5 = new char[i5];
            i = 0;
            System.arraycopy(cArr3, 0, cArr5, 0, i5);
            int i17 = i5 - i7;
            System.arraycopy(cArr5, 0, cArr3, i17, i7);
            System.arraycopy(cArr5, i7, cArr3, 0, i17);
        } else {
            i = 0;
        }
        if (z) {
            char[] cArr6 = new char[i5];
            while (true) {
                onpostmessage.a = i;
                if (onpostmessage.a >= i5) {
                    break;
                }
                int i18 = $10 + 99;
                $11 = i18 % 128;
                if (i18 % 2 == 0) {
                    cArr6[onpostmessage.a] = cArr3[(i5 >> onpostmessage.a) % 1];
                    i = onpostmessage.a;
                } else {
                    cArr6[onpostmessage.a] = cArr3[(i5 - onpostmessage.a) - 1];
                    i = onpostmessage.a + 1;
                }
            }
            cArr3 = cArr6;
        }
        if (i6 > 0) {
            int i19 = 0;
            while (true) {
                onpostmessage.a = i19;
                if (onpostmessage.a >= i5) {
                    break;
                }
                int i20 = $11 + 121;
                $10 = i20 % 128;
                int i21 = i20 % 2;
                cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                i19 = onpostmessage.a + 1;
            }
        }
        objArr[0] = new String(cArr3);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x043d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0443  */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0712, code lost:
    
        if (r0 != false) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r28, int r29, int r30, int r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.simpleframework.xml.filter.StackFilter.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
