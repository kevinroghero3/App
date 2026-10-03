package com.google.zxing.oned.rss;

import android.os.Process;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.build;

/* JADX INFO: loaded from: classes6.dex */
public final class RSSUtils {
    private static final byte[] $$c = {47, 75, -118, 7};
    private static final int $$d = SyslogConstants.LOG_LOCAL6;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {Ascii.SYN, -75, -19, -49, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, 50, Ascii.SO, -50, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4};
    private static final int $$b = 119;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char TopicBuilder = 51458;
    private static char ICustomTabsCallback = 52261;
    private static char extraCallbackWithResult = 57678;
    private static char onMessageChannelReady = 32633;

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r6, short r7, byte r8) {
        /*
            int r8 = r8 * 3
            int r8 = 3 - r8
            byte[] r0 = com.google.zxing.oned.rss.RSSUtils.$$c
            int r6 = r6 * 3
            int r1 = 1 - r6
            int r7 = r7 * 2
            int r7 = 110 - r7
            byte[] r1 = new byte[r1]
            r2 = 0
            int r6 = 0 - r6
            if (r0 != 0) goto L19
            r7 = r6
            r3 = r8
            r4 = r2
            goto L2f
        L19:
            r3 = r2
        L1a:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L27:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2f:
            int r7 = r7 + r8
            r8 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.RSSUtils.$$e(byte, short, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(byte r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = 28 - r7
            int r9 = r9 + 4
            byte[] r0 = com.google.zxing.oned.rss.RSSUtils.$$a
            int r8 = 115 - r8
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L11
            r3 = r7
            r8 = r9
            r4 = r2
            goto L29
        L11:
            r3 = r2
        L12:
            r6 = r9
            r9 = r8
            r8 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r6
        L29:
            int r9 = r9 + 1
            int r8 = r8 + r3
            int r8 = r8 + (-5)
            r3 = r4
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.RSSUtils.a(byte, int, int, java.lang.Object[]):void");
    }

    private RSSUtils() {
    }

    public static int getRSSvalue(int[] iArr, int i, boolean z) {
        int[] iArr2 = iArr;
        int i2 = 0;
        for (int i3 : iArr2) {
            i2 += i3;
        }
        int length = iArr2.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = length - 1;
            if (i4 >= i7) {
                return i5;
            }
            int i8 = 1 << i4;
            i6 |= i8;
            int i9 = 1;
            while (i9 < iArr2[i4]) {
                int i10 = i2 - i9;
                int i11 = length - i4;
                int i12 = i11 - 2;
                int iCombins = combins(i10 - 1, i12);
                if (z && i6 == 0) {
                    int i13 = i11 - 1;
                    if (i10 - i13 >= i13) {
                        iCombins -= combins(i10 - i11, i12);
                    }
                }
                if (i11 - 1 > 1) {
                    int iCombins2 = 0;
                    for (int i14 = i10 - i12; i14 > i; i14--) {
                        iCombins2 += combins((i10 - i14) - 1, i11 - 3);
                    }
                    iCombins -= iCombins2 * (i7 - i4);
                } else if (i10 > i) {
                    iCombins--;
                }
                i5 += iCombins;
                i9++;
                i6 &= ~i8;
                iArr2 = iArr;
            }
            i2 -= i9;
            i4++;
            iArr2 = iArr;
        }
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        int i3 = $11 + 17;
        $10 = i3 % 128;
        int i4 = i3 % 2;
        while (buildVar.c < cArr.length) {
            cArr3[0] = cArr[buildVar.c];
            cArr3[1] = cArr[buildVar.c + 1];
            int i5 = $11 + 39;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            int i7 = 58224;
            for (int i8 = 0; i8 < 16; i8++) {
                int i9 = $10 + 81;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                char c = cArr3[1];
                char c2 = cArr3[0];
                try {
                    Object[] objArr2 = {Integer.valueOf(c), Integer.valueOf((c2 + i7) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))))), Integer.valueOf(c2 >>> 5), Integer.valueOf(onMessageChannelReady)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = (byte) (b + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(28 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (17263 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), 1067 - View.resolveSize(0, 0), 1042277788, false, $$e(b, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr3[1] = cCharValue;
                    Object[] objArr3 = {Integer.valueOf(cArr3[0]), Integer.valueOf((cCharValue + i7) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = (byte) (b3 + 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(28 - ExpandableListView.getPackedPositionGroup(0L), (char) (17263 - TextUtils.getOffsetAfter("", 0)), View.getDefaultSize(0, 0) + 1067, 1042277788, false, $$e(b3, b4, (byte) (b4 - 1)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr3[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i7 -= 40503;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr2[buildVar.c] = cArr3[0];
            cArr2[buildVar.c + 1] = cArr3[1];
            Object[] objArr4 = {buildVar, buildVar};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
            if (objAccessartificialFrame3 == null) {
                byte b5 = (byte) 0;
                byte b6 = b5;
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 25, (char) (Gravity.getAbsoluteGravity(0, 0) + 63928), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 485, 1554985764, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    private static int combins(int i, int i2) {
        int i3 = i - i2;
        if (i3 <= i2) {
            i3 = i2;
            i2 = i3;
        }
        int i4 = 1;
        int i5 = 1;
        while (i > i3) {
            i4 *= i;
            if (i5 <= i2) {
                i4 /= i5;
                i5++;
            }
            i--;
        }
        while (i5 <= i2) {
            i4 /= i5;
            i5++;
        }
        return i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 2586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.RSSUtils.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
