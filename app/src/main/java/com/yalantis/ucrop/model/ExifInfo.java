package com.yalantis.ucrop.model;

import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.onPostMessage;

/* JADX INFO: loaded from: classes3.dex */
public class ExifInfo {
    private int mExifDegrees;
    private int mExifOrientation;
    private int mExifTranslation;
    private static final byte[] $$c = {Ascii.EM, 104, 41, -86};
    private static final int $$d = 82;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {111, -52, 8, -63, Ascii.VT, 2, -12};
    private static final int $$b = b.l;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] IPostMessageService = {38283, 38353, 38372, 38379, 38364, 38356, 38353, 38360, 38361, 38356, 38373, 38374, 38353, 38353, 38358, 38363, 38356, 38355, 38363, 38176, 38028, 38035, 38026, 38026, 38029, 38030, 38050, 38046, 38024, 38045, 38052, 38037, 38029, 38026, 38033, 38034, 38029, 38284, 38353, 38356, 38364, 38379, 38278, 38383, 38350, 38385, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38280, 38357, 38388, 38390, 38355, 38348, 38349, 38356, 38358, 38350, 38358, 38358, 38348, 38358, 38365, 38363, 38356, 38383, 38382, 38345, 38345, 38382, 38386, 38359, 38356, 38351, 38358, 38359, 38386, 38390, 38363, 38364, 38356, 38353, 38388, 38382, 38348, 38358, 38365, 38361, 38366, 38270, 38271, 38277, 38348, 38358, 38365, 38363, 38365, 38365, 38358, 38360, 38366, 38360, 38359, 38363, 38390, 38384, 38350, 38351, 38358, 38390, 38382, 38345, 38345, 38382, 38386, 38359, 38356, 38351, 38358, 38359, 38386, 38389, 38311, 38310, 38378, 38344, 38354, 38361, 38357, 38352, 38353, 38360, 38356, 38349, 38381, 38378, 38341, 38341, 38378, 38382, 38355, 38352, 38347, 38354, 38355, 38382, 38386, 38359, 38360, 38352, 38349, 38384, 38378, 38344, 38354, 38361, 38357, 38352, 38353};

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r5, short r6, byte r7) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 4
            byte[] r0 = com.yalantis.ucrop.model.ExifInfo.$$c
            int r5 = r5 * 3
            int r5 = 122 - r5
            int r7 = r7 * 3
            int r1 = 1 - r7
            byte[] r1 = new byte[r1]
            r2 = 0
            int r7 = 0 - r7
            if (r0 != 0) goto L19
            r4 = r5
            r5 = r7
            r3 = r2
            goto L29
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r5
            r1[r3] = r4
            if (r3 != r7) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L25:
            int r3 = r3 + 1
            r4 = r0[r6]
        L29:
            int r5 = r5 + r4
            int r6 = r6 + 1
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.model.ExifInfo.$$e(byte, short, byte):java.lang.String");
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
    private static void b(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r8 = r8 * 3
            int r8 = 109 - r8
            int r7 = r7 * 3
            int r0 = 4 - r7
            byte[] r1 = com.yalantis.ucrop.model.ExifInfo.$$a
            byte[] r0 = new byte[r0]
            int r7 = 3 - r7
            r2 = 0
            if (r1 != 0) goto L17
            r8 = r6
            r3 = r7
            r4 = r2
            goto L2f
        L17:
            r3 = r2
        L18:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r1[r6]
            r5 = r8
            r8 = r6
            r6 = r3
            r3 = r5
        L2f:
            int r3 = r3 + r6
            int r6 = r3 + (-3)
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.model.ExifInfo.b(short, short, short, java.lang.Object[]):void");
    }

    public ExifInfo(int i, int i2, int i3) {
        this.mExifOrientation = i;
        this.mExifDegrees = i2;
        this.mExifTranslation = i3;
    }

    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    public int getExifDegrees() {
        return this.mExifDegrees;
    }

    public int getExifTranslation() {
        return this.mExifTranslation;
    }

    public void setExifOrientation(int i) {
        this.mExifOrientation = i;
    }

    public void setExifDegrees(int i) {
        this.mExifDegrees = i;
    }

    public void setExifTranslation(int i) {
        this.mExifTranslation = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExifInfo exifInfo = (ExifInfo) obj;
        return this.mExifOrientation == exifInfo.mExifOrientation && this.mExifDegrees == exifInfo.mExifDegrees && this.mExifTranslation == exifInfo.mExifTranslation;
    }

    public int hashCode() {
        return (((this.mExifOrientation * 31) + this.mExifDegrees) * 31) + this.mExifTranslation;
    }

    private static void a(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
        int i;
        int i2 = 2;
        int i3 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i4 = 0;
        int i5 = iArr[0];
        int i6 = 1;
        int i7 = iArr[1];
        int i8 = iArr[2];
        int i9 = iArr[3];
        char[] cArr = IPostMessageService;
        char c = '0';
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i10 = 0;
            while (i10 < length) {
                int i11 = $11 + 77;
                $10 = i11 % 128;
                int i12 = i11 % i2;
                try {
                    Object[] objArr2 = new Object[i6];
                    objArr2[i4] = Integer.valueOf(cArr[i10]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i4;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror(c) - '%', (char) (TypedValue.complexToFraction(i4, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(i4, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getLongPressTimeout() >> 16) + 1562, 178318710, false, $$e((byte) 19, b, b), new Class[]{Integer.TYPE});
                    }
                    cArr2[i10] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i10++;
                    i2 = 2;
                    i4 = 0;
                    i6 = 1;
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
        char[] cArr3 = new char[i7];
        System.arraycopy(cArr, i5, cArr3, 0, i7);
        if (bArr != null) {
            int i13 = $10 + 39;
            $11 = i13 % 128;
            int i14 = i13 % 2;
            char[] cArr4 = new char[i7];
            onpostmessage.a = 0;
            char c2 = 0;
            while (onpostmessage.a < i7) {
                if (bArr[onpostmessage.a] == 1) {
                    int i15 = onpostmessage.a;
                    Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c2)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                    if (objAccessartificialFrame2 == null) {
                        byte b2 = (byte) 0;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(23 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16), 2441 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), -850656813, false, $$e((byte) ($$d & 63), b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i15] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                } else {
                    int i16 = onpostmessage.a;
                    Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c2)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame3 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 12, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), TextUtils.getOffsetAfter("", 0) + 1562, 1918398056, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i16] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                }
                c2 = cArr4[onpostmessage.a];
                Object[] objArr5 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 23, (char) (29411 - AndroidCharacter.getMirror('0')), 215 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            cArr3 = cArr4;
        }
        if (i9 > 0) {
            char[] cArr5 = new char[i7];
            i = 0;
            System.arraycopy(cArr3, 0, cArr5, 0, i7);
            int i17 = i7 - i9;
            System.arraycopy(cArr5, 0, cArr3, i17, i9);
            System.arraycopy(cArr5, i9, cArr3, 0, i17);
        } else {
            i = 0;
        }
        if (z) {
            char[] cArr6 = new char[i7];
            onpostmessage.a = i;
            while (onpostmessage.a < i7) {
                int i18 = $10 + 89;
                $11 = i18 % 128;
                int i19 = i18 % 2;
                cArr6[onpostmessage.a] = cArr3[(i7 - onpostmessage.a) - 1];
                onpostmessage.a++;
                int i20 = $10 + 85;
                $11 = i20 % 128;
                int i21 = i20 % 2;
            }
            cArr3 = cArr6;
        }
        if (i8 > 0) {
            int i22 = $10 + 53;
            $11 = i22 % 128;
            int i23 = i22 % 2;
            int i24 = 0;
            while (true) {
                onpostmessage.a = i24;
                if (onpostmessage.a >= i7) {
                    break;
                }
                int i25 = $10 + 27;
                $11 = i25 % 128;
                int i26 = i25 % 2;
                cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                i24 = onpostmessage.a + 1;
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
    public static java.lang.Object[] coroutineCreation(int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 2638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.model.ExifInfo.coroutineCreation(int, int):java.lang.Object[]");
    }
}
