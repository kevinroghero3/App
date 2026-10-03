package kotlinx.coroutines;

import android.graphics.ImageFormat;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.app.AppCompatDelegate;
import ch.qos.logback.core.CoreConstants;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import o.ArtificialStackFrames;
import o.onPostMessage;

/* JADX INFO: loaded from: classes.dex */
public final class Empty implements Incomplete {
    private final boolean isActive;
    private static final byte[] $$c = {43, Base64.padSymbol, 10, -87};
    private static final int $$d = 7;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {Ascii.ESC, -99, -92, 1, 9, -20, Ascii.FS, -26, -18, 10, -5, -11, 2, 19, -39, 6, -6, Ascii.ESC, -46, 8, -6, -15, 2, -4, Ascii.CR, -24, -13, -7, -12, Ascii.FF, -4, 50, -50, -14, -31, -17, -4, 38, -49, -3, -8, 10, -24, Ascii.US, -22, -22, 10, -7, -12, -2, -22, Ascii.DLE, -18, 9, -20, 44, -35, -20, -9, 6, -11, -4, 0, -10, 2, Ascii.GS, -46, 8, -6, -15, 2, -4};
    private static final int $$b = 45;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] IPostMessageService = {38184, 38030, 38038, 38040, 38035, 38038, 38059, 38220, 38067, 38035, 38043, 38040, 38035, 38038, 38043, 38076, 38075, 38046, 38040, 38036, 38041, 38043, 38045, 38283, 38353, 38357, 38365, 38361, 38357, 38353, 38351, 38375, 38373, 38355, 38361, 38356, 38357, 38357, 38372, 38372, 38353, 38288, 38345, 38193, 38195, 38199, 38203, 38207, 38199, 38195, 38197, 38195, 38342, 38342, 38199, 38199, 38201, 38202, 38200, 38198, 38193, 38197, 38203, 38360, 38361, 38200, 38195, 38192, 38197, 38200, 38192, 38352, 38354, 38195, 38356, 38281, 38361, 38363, 38354, 38355, 38286, 38357, 38383, 38390, 38359, 38360, 38366, 38363, 38360, 38353, 38356, 38364, 38363, 38391, 38391, 38360, 38356, 38355, 38386, 38382, 38353, 38356, 38356, 38387, 38390, 38356, 38355, 38389, 38278, 38351, 38385, 38390, 38363, 38364, 38356, 38353, 38360, 38363, 38366, 38360, 38359, 38311};

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r6, int r7, byte r8) {
        /*
            int r6 = r6 * 2
            int r0 = r6 + 1
            byte[] r1 = kotlinx.coroutines.Empty.$$c
            int r8 = r8 * 3
            int r8 = 122 - r8
            int r7 = r7 * 3
            int r7 = 3 - r7
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L17
            r3 = r8
            r4 = r2
            r8 = r7
            goto L2e
        L17:
            r3 = r2
        L18:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r0[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L25:
            int r3 = r3 + 1
            r4 = r1[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r5
        L2e:
            int r7 = r7 + r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.Empty.$$e(byte, int, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r0 = r8 + 2
            int r6 = 52 - r6
            int r7 = r7 + 66
            byte[] r1 = kotlinx.coroutines.Empty.$$a
            byte[] r0 = new byte[r0]
            int r8 = r8 + 1
            r2 = 0
            if (r1 != 0) goto L12
            r3 = r6
            r4 = r2
            goto L2d
        L12:
            r3 = r2
            r5 = r7
            r7 = r6
            r6 = r5
        L16:
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L23:
            int r7 = r7 + 1
            int r3 = r3 + 1
            r4 = r1[r7]
            r5 = r3
            r3 = r7
            r7 = r4
            r4 = r5
        L2d:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + (-5)
            r7 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.Empty.a(byte, int, int, java.lang.Object[]):void");
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList getList() {
        return null;
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
        char c = '0';
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i9 = 0;
            while (i9 < length) {
                try {
                    Object[] objArr2 = new Object[i5];
                    objArr2[i3] = Integer.valueOf(cArr[i9]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                    if (objAccessartificialFrame == null) {
                        int iIndexOf = 11 - TextUtils.indexOf("", "", i3, i3);
                        char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                        int iIndexOf2 = TextUtils.indexOf("", c, i3, i3) + 1563;
                        byte b = (byte) i3;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iIndexOf, edgeSlop, iIndexOf2, 178318710, false, $$e(b, b2, (byte) (b2 | 19)), new Class[]{Integer.TYPE});
                    }
                    cArr2[i9] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i9++;
                    i3 = 0;
                    i5 = 1;
                    c = '0';
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
            char[] cArr4 = new char[i6];
            onpostmessage.a = 0;
            char c2 = 0;
            while (onpostmessage.a < i6) {
                int i10 = $10 + 77;
                $11 = i10 % 128;
                int i11 = i10 % 2;
                if (bArr[onpostmessage.a] == 1) {
                    int i12 = $11 + 35;
                    $10 = i12 % 128;
                    if (i12 % 2 != 0) {
                        int i13 = onpostmessage.a;
                        Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c2)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(22 - ImageFormat.getBitsPerPixel(0), (char) (Process.myPid() >> 22), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2440, -850656813, false, $$e(b3, b4, (byte) (b4 | Ascii.DC2)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr4[i13] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        throw null;
                    }
                    int i14 = onpostmessage.a;
                    Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c2)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 23, (char) View.combineMeasuredStates(0, 0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 2441, -850656813, false, $$e(b5, b6, (byte) (b6 | Ascii.DC2)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i14] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                } else {
                    int i15 = onpostmessage.a;
                    Object[] objArr5 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c2)};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = b7;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(11 - (Process.myTid() >> 22), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), TextUtils.getOffsetAfter("", 0) + 1562, 1918398056, false, $$e(b7, b8, b8), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i15] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                }
                c2 = cArr4[onpostmessage.a];
                Object[] objArr6 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollDefaultDelay() >> 16) + 22, (char) (29363 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), 215 - Gravity.getAbsoluteGravity(0, 0), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            }
            int i16 = $11 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            $10 = i16 % 128;
            int i17 = i16 % 2;
            cArr3 = cArr4;
        }
        if (i8 > 0) {
            char[] cArr5 = new char[i6];
            i = 0;
            System.arraycopy(cArr3, 0, cArr5, 0, i6);
            int i18 = i6 - i8;
            System.arraycopy(cArr5, 0, cArr3, i18, i8);
            System.arraycopy(cArr5, i8, cArr3, 0, i18);
        } else {
            i = 0;
        }
        if (z) {
            char[] cArr6 = new char[i6];
            onpostmessage.a = i;
            int i19 = $10 + 83;
            while (true) {
                $11 = i19 % 128;
                int i20 = i19 % 2;
                if (onpostmessage.a >= i6) {
                    break;
                }
                int i21 = $11 + b.i;
                $10 = i21 % 128;
                int i22 = i21 % 2;
                cArr6[onpostmessage.a] = cArr3[(i6 - onpostmessage.a) - 1];
                onpostmessage.a++;
                i19 = $10 + b.f40o;
            }
            cArr3 = cArr6;
        }
        if (i7 > 0) {
            int i23 = $11 + 97;
            $10 = i23 % 128;
            int i24 = i23 % 2;
            int i25 = 0;
            while (true) {
                onpostmessage.a = i25;
                if (onpostmessage.a >= i6) {
                    break;
                }
                int i26 = $10 + 29;
                $11 = i26 % 128;
                if (i26 % 2 == 0) {
                    cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] << iArr[4]);
                    i25 = onpostmessage.a % 1;
                } else {
                    cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                    i25 = onpostmessage.a + 1;
                }
            }
        }
        objArr[0] = new String(cArr3);
    }

    public Empty(boolean z) {
        this.isActive = z;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return this.isActive;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append(CoreConstants.CURLY_RIGHT);
        return sb.toString();
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r34, int r35, int r36, int r37) {
        /*
            Method dump skipped, instruction units count: 2767
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.Empty.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
