package com.google.crypto.tink.prf.internal;

import android.graphics.Color;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.common.base.Ascii;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import o.ArtificialStackFrames;
import o.artificialFrame;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public class LegacyFullPrf implements Prf {
    private final Prf rawPrf;
    private static final byte[] $$c = {19, -17, 93, 33};
    private static final int $$d = 163;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {53, -94, -28, -114, 9, -20, Ascii.FS, -26, -18, 10, -5, -11, 2, 19, -39, 6, -6, Ascii.ESC, -46, 8, -6, -15, 2, -4, Ascii.CR, -24, -13, -7, -12, Ascii.FF, -4, -50, -14, 50, -31, -17, -4, 38, -49, -3, -8, 10, -24, Ascii.US, -22, -22, 10, -7, -12, -2, -22, Ascii.DLE, -18, 9, -20, 44, -35, -20, -9, 6, -11, -4, 0, -10, 2, Ascii.GS, -46, 8, -6, -15, 2, -4};
    private static final int $$b = 9;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int[] ICustomTabsCallbackStub = {-1366661930, -1196312022, 886168438, 146955243, 901074245, 334753309, -420491350, 1794587372, 1914680848, 2137863569, -175697924, -1360721760, -1277402320, -1987344425, 908951032, 1941294471, 1980210625, 670179947};

    private static String $$e(int i, int i2, byte b) {
        byte[] bArr = $$c;
        int i3 = b + 4;
        int i4 = i * 4;
        int i5 = (i2 * 6) + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        byte[] bArr2 = new byte[1 - i4];
        int i6 = 0 - i4;
        int i7 = -1;
        if (bArr == null) {
            i5 += i3;
            i7 = -1;
        }
        while (true) {
            int i8 = i3;
            int i9 = i5;
            int i10 = i7 + 1;
            bArr2[i10] = (byte) i9;
            if (i10 == i6) {
                return new String(bArr2, 0);
            }
            int i11 = i8 + 1;
            i3 = i11;
            i5 = bArr[i11] + i9;
            i7 = i10;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(int r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            byte[] r0 = com.google.crypto.tink.prf.internal.LegacyFullPrf.$$a
            int r7 = r7 + 66
            int r1 = r8 + 2
            byte[] r1 = new byte[r1]
            int r8 = r8 + 1
            r2 = 0
            if (r0 != 0) goto L12
            r3 = r8
            r4 = r2
            goto L27
        L12:
            r3 = r2
        L13:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L22:
            r3 = r0[r6]
            r5 = r3
            r3 = r7
            r7 = r5
        L27:
            int r7 = -r7
            int r6 = r6 + 1
            int r3 = r3 + r7
            int r7 = r3 + (-5)
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.prf.internal.LegacyFullPrf.a(int, int, byte, java.lang.Object[]):void");
    }

    public static Prf create(LegacyProtoKey legacyProtoKey) throws GeneralSecurityException {
        ProtoKeySerialization serialization = legacyProtoKey.getSerialization(InsecureSecretKeyAccess.get());
        return new LegacyFullPrf((Prf) KeyManagerRegistry.globalInstance().getKeyManager(serialization.getTypeUrl(), Prf.class).getPrimitive(serialization.getValue()));
    }

    private LegacyFullPrf(Prf prf) {
        this.rawPrf = prf;
    }

    @Override // com.google.crypto.tink.prf.Prf
    public byte[] compute(byte[] bArr, int i) throws GeneralSecurityException {
        return this.rawPrf.compute(bArr, i);
    }

    private static void b(int i, int[] iArr, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = ICustomTabsCallbackStub;
        int i4 = -1780896814;
        char c = '0';
        int i5 = 1;
        int i6 = 0;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i7 = 0;
            while (i7 < length) {
                int i8 = $10 + 85;
                $11 = i8 % 128;
                int i9 = i8 % i2;
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i6] = Integer.valueOf(iArr2[i7]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i6;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", c, i6) + 12, (char) ExpandableListView.getPackedPositionGroup(0L), 1561 - ExpandableListView.getPackedPositionChild(0L), 180153818, false, $$e(b, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE});
                    }
                    iArr3[i7] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i7++;
                    i2 = 2;
                    i4 = -1780896814;
                    c = '0';
                    i6 = 0;
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
        if (iArr5 != null) {
            int i10 = $10 + 49;
            $11 = i10 % 128;
            int i11 = 2;
            int i12 = i10 % 2;
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i13 = 0;
            while (i13 < length3) {
                int i14 = $10 + 27;
                $11 = i14 % 128;
                int i15 = i14 % i11;
                Object[] objArr3 = new Object[i5];
                objArr3[0] = Integer.valueOf(iArr5[i13]);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (TextUtils.lastIndexOf("", '0', 0) + 1), TextUtils.indexOf("", "", 0) + 1562, 180153818, false, $$e(b3, b4, (byte) (b4 - 1)), new Class[]{Integer.TYPE});
                }
                iArr6[i13] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                i13++;
                iArr5 = iArr5;
                i11 = 2;
                i5 = 1;
            }
            iArr5 = iArr6;
        }
        char c2 = 0;
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        artificialframe.e = 0;
        while (artificialframe.e < iArr.length) {
            cArr[c2] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr4);
            int i16 = 0;
            for (int i17 = 16; i16 < i17; i17 = 16) {
                int i18 = $11 + 125;
                $10 = i18 % 128;
                if (i18 % 2 != 0) {
                    artificialframe.c ^= iArr4[i16];
                    Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = (byte) (b5 + 1);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((Process.myTid() >> 22) + 26, (char) Color.argb(0, 0, 0, 0), Color.rgb(0, 0, 0) + 16778257, 995482881, false, $$e(b5, b6, (byte) (-b6)), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = iIntValue;
                    i16 += 33;
                } else {
                    artificialframe.c ^= iArr4[i16];
                    Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = (byte) (b7 + 1);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0, 0) + 27, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), View.MeasureSpec.getMode(0) + 1041, 995482881, false, $$e(b7, b8, (byte) (-b8)), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = iIntValue2;
                    i16++;
                }
            }
            int i19 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i19;
            artificialframe.b ^= iArr4[16];
            artificialframe.c ^= iArr4[17];
            int i20 = artificialframe.c;
            int i21 = artificialframe.b;
            cArr[0] = (char) (artificialframe.c >>> 16);
            cArr[1] = (char) artificialframe.c;
            cArr[2] = (char) (artificialframe.b >>> 16);
            cArr[3] = (char) artificialframe.b;
            artificialFrame.coroutineBoundary(iArr4);
            cArr2[artificialframe.e * 2] = cArr[0];
            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
            try {
                Object[] objArr6 = {artificialframe, artificialframe};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1348396126);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(37 - TextUtils.indexOf("", "", 0), (char) (28011 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), TextUtils.getTrimmedLength("") + 306, -818175402, false, "q", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                int i22 = $10 + 39;
                $11 = i22 % 128;
                if (i22 % 2 == 0) {
                    int i23 = 2 % 4;
                }
                c2 = 0;
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v156 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r13v37 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r5v110 */
    /* JADX WARN: Type inference failed for: r5v50 */
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
            Method dump skipped, instruction units count: 2916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.prf.internal.LegacyFullPrf.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
