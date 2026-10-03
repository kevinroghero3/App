package com.google.crypto.tink.hybrid.internal;

import android.graphics.Color;
import android.os.Process;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.hybrid.HpkeParameters;
import com.google.crypto.tink.internal.KeyCreator;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.artificialFrame;
import o.onRelationshipValidationResult;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HpkePrivateKeyManager$$ExternalSyntheticLambda2 implements KeyCreator {
    private static final byte[] $$c = {5, -37, 48, 84};
    private static final int $$d = 75;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {70, -123, Ascii.CR, 112, 10, 4, 50, Ascii.SO, 3, Ascii.DC4, -50, 1, Ascii.SYN, -3, 8, Ascii.DLE, 5, 0, -8, Ascii.DC4, -9, Ascii.SO, -5, -2, Ascii.DC2, 3, 10, 2, 5, 8, 5, Ascii.US, 5, Ascii.DLE, 1, -6, Ascii.GS, 36, 8, 3, Ascii.ESC, Ascii.SYN, -16, -9, 5, Ascii.VT, 32, 8, 6, 10, Ascii.DC2};
    private static final int $$b = 178;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long onPostMessage = 8374314031049267357L;
    private static int[] ICustomTabsCallbackStub = {575882634, 1613538888, 319627293, 1109245274, -819275072, -1572340085, 186480083, -1663992036, -1985771949, 2084464134, 1179032869, -1965297250, -1523049981, 792299701, 229028491, -1984253501, -361035886, 1604882232};

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r6, short r7, byte r8) {
        /*
            int r7 = r7 * 2
            int r0 = 1 - r7
            int r6 = r6 * 2
            int r6 = 115 - r6
            byte[] r1 = com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager$$ExternalSyntheticLambda2.$$c
            int r8 = r8 * 2
            int r8 = r8 + 4
            byte[] r0 = new byte[r0]
            r2 = 0
            int r7 = 0 - r7
            if (r1 != 0) goto L19
            r6 = r7
            r3 = r8
            r4 = r2
            goto L2d
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L25:
            int r3 = r3 + 1
            r4 = r1[r8]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2d:
            int r8 = -r8
            int r3 = r3 + 1
            int r6 = r6 + r8
            r8 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager$$ExternalSyntheticLambda2.$$e(short, short, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(int r5, int r6, short r7, java.lang.Object[] r8) {
        /*
            int r0 = r7 + 2
            int r6 = 49 - r6
            byte[] r1 = com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager$$ExternalSyntheticLambda2.$$a
            int r5 = r5 + 66
            byte[] r0 = new byte[r0]
            int r7 = r7 + 1
            r2 = -1
            if (r1 != 0) goto L12
            r3 = r2
            r2 = r6
            goto L2b
        L12:
            r4 = r6
            r6 = r5
            r5 = r4
        L15:
            int r2 = r2 + 1
            byte r3 = (byte) r6
            r0[r2] = r3
            if (r2 != r7) goto L25
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r0, r6)
            r8[r6] = r5
            return
        L25:
            r3 = r1[r5]
            r4 = r2
            r2 = r5
            r5 = r3
            r3 = r4
        L2b:
            int r6 = r6 + r5
            int r6 = r6 + (-5)
            int r5 = r2 + 1
            r2 = r3
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager$$ExternalSyntheticLambda2.a(int, int, short, java.lang.Object[]):void");
    }

    @Override // com.google.crypto.tink.internal.KeyCreator
    public final Key createKey(Parameters parameters, Integer num) {
        return HpkePrivateKeyManager.createKey((HpkeParameters) parameters, num);
    }

    private static void c(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        int i3 = $10 + 95;
        $11 = i3 % 128;
        while (true) {
            int i4 = i3 % 2;
            if (onrelationshipvalidationresult.e >= cArrAccessartificialFrame.length) {
                objArr[0] = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
                return;
            }
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i5 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Process.getGidForName("") + 28, (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 30690), TextUtils.getTrimmedLength("") + 188, -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    int iRgb = (-16777183) - Color.rgb(0, 0, 0);
                    char longPressTimeout = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                    int i6 = 1484 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    byte b = (byte) ($$d & 6);
                    byte b2 = (byte) (b - 2);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iRgb, longPressTimeout, i6, -1940971975, false, $$e(b, b2, b2), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                i3 = $11 + 95;
                $10 = i3 % 128;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    private static void b(int i, int[] iArr, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = ICustomTabsCallbackStub;
        long j = 0;
        int i4 = -1780896814;
        int i5 = 1;
        int i6 = 0;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i7 = 0;
            while (i7 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(iArr2[i7])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                    if (objAccessartificialFrame == null) {
                        int iGreen = Color.green(0) + 11;
                        char deadChar = (char) KeyEvent.getDeadChar(0, 0);
                        int i8 = 1561 - (ExpandableListView.getPackedPositionForChild(0, 0) > j ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == j ? 0 : -1));
                        byte b = (byte) ($$d & 7);
                        byte b2 = (byte) (b - 3);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iGreen, deadChar, i8, 180153818, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    iArr3[i7] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i7++;
                    j = 0;
                    i4 = -1780896814;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = ICustomTabsCallbackStub;
        int i9 = 16;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i10 = 0;
            while (i10 < length3) {
                try {
                    Object[] objArr3 = new Object[i5];
                    objArr3[i6] = Integer.valueOf(iArr5[i10]);
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                    if (objAccessartificialFrame2 == null) {
                        int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> i9) + 11;
                        char scrollBarSize = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                        int i11 = 1562 - (CdmaCellLocation.convertQuartSecToDecDegrees(i6) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(i6) == 0.0d ? 0 : -1));
                        byte b3 = (byte) ($$d & 7);
                        byte b4 = (byte) (b3 - 3);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, scrollBarSize, i11, 180153818, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE});
                    }
                    iArr6[i10] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    i10++;
                    i9 = 16;
                    i5 = 1;
                    i6 = 0;
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            int i12 = $10 + 107;
            $11 = i12 % 128;
            int i13 = i12 % 2;
            iArr5 = iArr6;
            i2 = 0;
        } else {
            i2 = 0;
        }
        System.arraycopy(iArr5, i2, iArr4, i2, length2);
        artificialframe.e = i2;
        while (artificialframe.e < iArr.length) {
            cArr[i2] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr4);
            int i14 = 0;
            for (int i15 = 16; i14 < i15; i15 = 16) {
                artificialframe.c ^= iArr4[i14];
                Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 26, (char) ExpandableListView.getPackedPositionType(0L), Color.argb(0, 0, 0, 0) + 1041, 995482881, false, $$e(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                artificialframe.c = artificialframe.b;
                artificialframe.b = iIntValue;
                i14++;
                int i16 = $11 + 49;
                $10 = i16 % 128;
                int i17 = i16 % 2;
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
            Object[] objArr5 = {artificialframe, artificialframe};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1348396126);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(37 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 28010), 305 - TextUtils.indexOf((CharSequence) "", '0'), -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            int i21 = $10 + 55;
            $11 = i21 % 128;
            int i22 = i21 % 2;
            i2 = 0;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 6625 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v114 */
    /* JADX WARN: Type inference failed for: r2v115 */
    /* JADX WARN: Type inference failed for: r2v116, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v117 */
    /* JADX WARN: Type inference failed for: r2v118, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v138 */
    /* JADX WARN: Type inference failed for: r2v167, types: [java.util.regex.Pattern] */
    /* JADX WARN: Type inference failed for: r2v718 */
    /* JADX WARN: Type inference failed for: r2v719 */
    /* JADX WARN: Type inference failed for: r2v738, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v943 */
    /* JADX WARN: Type inference failed for: r2v944 */
    /* JADX WARN: Type inference failed for: r2v945 */
    /* JADX WARN: Type inference failed for: r2v946 */
    /* JADX WARN: Type inference failed for: r2v947 */
    /* JADX WARN: Type inference failed for: r33v22 */
    /* JADX WARN: Type inference failed for: r33v23 */
    /* JADX WARN: Type inference failed for: r33v24 */
    /* JADX WARN: Type inference failed for: r33v25 */
    /* JADX WARN: Type inference failed for: r33v26 */
    /* JADX WARN: Type inference failed for: r33v27 */
    /* JADX WARN: Type inference failed for: r33v28 */
    /* JADX WARN: Type inference failed for: r33v30 */
    /* JADX WARN: Type inference failed for: r33v31 */
    /* JADX WARN: Type inference failed for: r33v43 */
    /* JADX WARN: Type inference failed for: r33v44 */
    /* JADX WARN: Type inference failed for: r33v45 */
    /* JADX WARN: Type inference failed for: r33v46 */
    /* JADX WARN: Type inference failed for: r33v47 */
    /* JADX WARN: Type inference failed for: r33v48 */
    /* JADX WARN: Type inference failed for: r33v49 */
    /* JADX WARN: Type inference failed for: r33v50 */
    /* JADX WARN: Type inference failed for: r44v13 */
    /* JADX WARN: Type inference failed for: r44v16 */
    /* JADX WARN: Type inference failed for: r44v23 */
    /* JADX WARN: Type inference failed for: r44v24 */
    /* JADX WARN: Type inference failed for: r44v8 */
    /* JADX WARN: Type inference failed for: r4v109 */
    /* JADX WARN: Type inference failed for: r4v110, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v197 */
    /* JADX WARN: Type inference failed for: r4v198 */
    /* JADX WARN: Type inference failed for: r4v224, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v26, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v410 */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v582 */
    /* JADX WARN: Type inference failed for: r4v583 */
    /* JADX WARN: Type inference failed for: r4v584 */
    /* JADX WARN: Type inference failed for: r4v585 */
    /* JADX WARN: Type inference failed for: r4v586 */
    /* JADX WARN: Type inference failed for: r4v68, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v213 */
    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] accessartificialFrame$78cbbd35(int r66, int r67, java.lang.Object r68, int r69, boolean r70) {
        /*
            Method dump skipped, instruction units count: 18069
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager$$ExternalSyntheticLambda2.accessartificialFrame$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
    }
}
