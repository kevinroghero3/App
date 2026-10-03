package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import o.artificialFrame;

/* JADX INFO: loaded from: classes4.dex */
public final class zzjc extends zzeb implements zzfn {
    private static short[] ICustomTabsService;
    private static final byte[] $$c = {5, -37, 48, 84};
    private static final int $$d = 16;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {Ascii.FS, 50, 106, -64, -12, -6, Ascii.ESC, -22, -26, 4, -12, 0, -8, -2, -8};
    private static final int $$b = 79;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int onTransact = -309918419;
    private static int mayLaunchUrl = -81862486;
    private static int getInterfaceDescriptor = 662529729;
    private static byte[] ICustomTabsCallbackStubProxy = {121, 34, -48, 47, -34, Ascii.FS, -12, -42, -48, Ascii.FF, 49, -112, 41, -44, 111, -30, -60, 58, -40, 126, 74, -70, 66, -104, 99, -83, -93, -92, Ascii.FF, -68, -78, 78, 68, -85, 71, 75, -4, 116, 82, -84, 78, 104, 99, -110, 99, 109, -109, 111, 126, -117, 100, -103, 105, -94, -95, 99, 74, -55, -12, -10, 55, -8, Ascii.VT, 7, -113, 4, Ascii.SI, -25, Ascii.ESC, -9, Ascii.VT, -11, 2, -10, Ascii.NAK, -21, -21, Ascii.CAN, -13, -28, -2, 4, -19, 49, 4, Ascii.SI, 7, -65, 79, -1, -15, Ascii.CR, 7, -24, 4, 8, -65, 55, 17, -17, Ascii.CR, 109, 43, 41, 47, -58, -45, -33, 121, 126, 115, -126, 94, -91, -118, 104, -123, -127, 120, -122, -114, 121, 118, 89, -76, 116, -123, 111, -14, 0, -4, 45, -113, -10, -14, 10, -32, -13, -22, Ascii.DLE, 0, -30, Ascii.SI, Ascii.VT, -14, Ascii.FF, 4, -13, -4, -45, -28, 75, -13, -4, -13, -60, 68, -12, -6, 6, Ascii.FF, -29, Ascii.SI, 3, -76, 60, Ascii.SUB, -28, 6, 118, -11, Ascii.ETB, -6, -2, 7, -7, -15, 6, 9, 38, 17, -66, 6, 9, 6, 49, -79, 1, Ascii.SI, -13, -7, Ascii.SYN, -6, -10, 65, -55, -17, 17, -13, 98, 87, -87, 93, -92, 93, -127, 121, -89, 86, 124, -115, -120, 118, -120, 119, -113, 126, -116, -118, -117, -117, -120, 118, -120, 113, -115, 118, -120, 115, -125, 112, -114, 118, -118, -58, 36, -55, -51, 52, -54, -62, 53, 58, Ascii.NAK, Base64.padSymbol, 62, -52, -22, Ascii.GS, -115, 53, 58, 53, 2, -126, 50, 60, -64, -54, 37, -55, -59, 114, -6, -36, 34, -64, 121, -90, 84, -85, 90, -104, 118, 90, 80, -100, -65, Ascii.DC4, -83, 80, -21, 102, SignedBytes.MAX_POWER_OF_TWO, -66, 92, 104, -91, 69, 81, 96, -26, Ascii.DC4, -21, Ascii.SUB, -40, 48, Ascii.DC2, Ascii.DC4, -56, 50, -7, 101, -46, 32, -33, 46, -20, -53, 96, -39, 36, -97, Ascii.DC2, 52, -54, 40, 111, -38, 45, -43, 44, 105, -128, 113, 97, -22, Ascii.SYN, -28, -19, 50, -56, 0, Ascii.SO, -54, -24, 108, 109, 99, 110, 106, -103, 103, -106, 105, -97, -103, 118, 49, -64, Ascii.GS, -36, -58, 62, -50, 48, 58, 41, Ascii.SUB, -7, -59, 122, -126, 62, 49, -55, 62, -57, 52, Ascii.CR, -14, -61, -62, -59, 54, -50, 53, 98, -23, Ascii.DC4, Ascii.SUB, -26, -12, Ascii.DC4, -32, Ascii.EM, 17, 97, 80, -89, 72, 121, -108, -71, -77, 127, -101, -77, 110, Ascii.VT, 4, -12, -12, Ascii.SI, 104, 32, -34, -36};
    private static int[] ICustomTabsCallbackStub = {1425913488, -727953773, -1778219013, 1834913615, -291765164, -264620843, 1853505399, -1105450171, 1019088990, -248876099, -426341520, 1781701880, -1586059233, 1366966600, -1768121569, 1771589781, 1712383753, 1133806619};

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r7, byte r8, int r9) {
        /*
            byte[] r0 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzjc.$$c
            int r8 = r8 + 4
            int r7 = r7 * 3
            int r7 = r7 + 1
            int r9 = 117 - r9
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r7
            r9 = r8
            r5 = r2
            goto L29
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r9
            int r8 = r8 + 1
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L23:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r6
        L29:
            int r8 = -r8
            int r8 = r8 + r3
            r3 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzjc.$$e(short, byte, int):java.lang.String");
    }

    private zzjc() {
        throw null;
    }

    /* synthetic */ zzjc(zzhi zzhiVar) {
        super(zzjd.zzb);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 8
            int r8 = r8 + 4
            int r7 = r7 * 5
            int r7 = r7 + 4
            byte[] r0 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzjc.$$a
            int r6 = r6 * 3
            int r6 = 115 - r6
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r8
            r4 = r2
            goto L28
        L16:
            r3 = r2
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r6
            r1[r3] = r5
            if (r4 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r3 = r0[r8]
        L28:
            int r8 = r8 + 1
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + (-7)
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzjc.c(byte, byte, byte, java.lang.Object[]):void");
    }

    private static void a(int i, int[] iArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = ICustomTabsCallbackStub;
        int i3 = -1780896814;
        int i4 = 1;
        int i5 = 0;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i6 = 0;
            while (i6 < length) {
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i5] = Integer.valueOf(iArr2[i6]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i3);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i5;
                        byte b2 = (byte) (b - 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Color.argb(i5, i5, i5, i5) + 11, (char) TextUtils.getTrimmedLength(""), (ViewConfiguration.getWindowTouchSlop() >> 8) + 1562, 180153818, false, $$e(b, b2, (byte) (b2 & 8)), new Class[]{Integer.TYPE});
                    }
                    iArr3[i6] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i6++;
                    i3 = -1780896814;
                    i5 = 0;
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
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i7 = 0;
            while (i7 < length3) {
                int i8 = $11 + b.i;
                $10 = i8 % 128;
                int i9 = i8 % 2;
                try {
                    Object[] objArr3 = new Object[i4];
                    objArr3[0] = Integer.valueOf(iArr5[i7]);
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = (byte) (b3 - 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 11, (char) ((-1) - MotionEvent.axisFromString("")), ImageFormat.getBitsPerPixel(0) + 1563, 180153818, false, $$e(b3, b4, (byte) (b4 & 8)), new Class[]{Integer.TYPE});
                    }
                    iArr6[i7] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    i7++;
                    iArr5 = iArr5;
                    i4 = 1;
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            int i10 = $10 + 77;
            $11 = i10 % 128;
            int i11 = i10 % 2;
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        artificialframe.e = 0;
        while (artificialframe.e < iArr.length) {
            int i12 = $10 + 45;
            $11 = i12 % 128;
            int i13 = i12 % 2;
            cArr[0] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr4);
            for (int i14 = 0; i14 < 16; i14++) {
                artificialframe.c ^= iArr4[i14];
                Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = (byte) (b5 - 1);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(26 - TextUtils.getOffsetAfter("", 0), (char) KeyEvent.getDeadChar(0, 0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 1041, 995482881, false, $$e(b5, b6, (byte) (b6 + 3)), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                artificialframe.c = artificialframe.b;
                artificialframe.b = iIntValue;
            }
            int i15 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i15;
            artificialframe.b ^= iArr4[16];
            artificialframe.c ^= iArr4[17];
            int i16 = artificialframe.c;
            int i17 = artificialframe.b;
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
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 37, (char) (28011 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 306 - (ViewConfiguration.getDoubleTapTimeout() >> 16), -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x008e A[PHI: r4
  0x008e: PHI (r4v10 byte[] A[IMMUTABLE_TYPE]) = (r4v9 byte[]), (r4v20 byte[]) binds: [B:19:0x008c, B:16:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x0094  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a7 A[Catch: all -> 0x02ce, TryCatch #0 {all -> 0x02ce, blocks: (B:3:0x000f, B:5:0x0028, B:6:0x0060, B:31:0x0104, B:33:0x011b, B:34:0x015a, B:44:0x01bc, B:46:0x01d9, B:47:0x0213, B:23:0x0096, B:25:0x00a7, B:26:0x00dc), top: B:75:0x000f }] */
    private static void b(int i, byte b, int i2, short s, int i3, Object[] objArr) throws Throwable {
        long j;
        int i4;
        char c;
        byte[] bArr;
        int length;
        byte[] bArr2;
        int i5;
        Object objAccessartificialFrame;
        int i6 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1991297565);
            if (objAccessartificialFrame2 == null) {
                byte b2 = (byte) 0;
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(40 - View.MeasureSpec.getMode(0), (char) (36241 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 2342, 371880939, false, $$e(b2, (byte) (b2 - 1), $$c[0]), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr2)).intValue();
            boolean z = iIntValue == -1;
            if (z) {
                int i7 = $10 + 89;
                $11 = i7 % 128;
                if (i7 % 2 == 0) {
                    bArr = ICustomTabsCallbackStubProxy;
                    int i8 = 92 / 0;
                    if (bArr != null) {
                        length = bArr.length;
                        bArr2 = new byte[length];
                        for (i5 = 0; i5 < length; i5++) {
                            Object[] objArr3 = {Integer.valueOf(bArr[i5])};
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1557994855);
                            if (objAccessartificialFrame == null) {
                                byte b3 = (byte) 0;
                                byte b4 = (byte) (b3 - 1);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(45 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L), 1215 - KeyEvent.keyCodeFromString(""), 1011328145, false, $$e(b3, b4, (byte) (b4 + 1)), new Class[]{Integer.TYPE});
                            }
                            bArr2[i5] = ((Byte) ((Method) objAccessartificialFrame).invoke(null, objArr3)).byteValue();
                        }
                        bArr = bArr2;
                    }
                } else {
                    bArr = ICustomTabsCallbackStubProxy;
                    if (bArr != null) {
                        length = bArr.length;
                        bArr2 = new byte[length];
                        while (i5 < length) {
                            Object[] objArr4 = {Integer.valueOf(bArr[i5])};
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1557994855);
                            if (objAccessartificialFrame == null) {
                                byte b5 = (byte) 0;
                                byte b6 = (byte) (b5 - 1);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(45 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L), 1215 - KeyEvent.keyCodeFromString(""), 1011328145, false, $$e(b5, b6, (byte) (b6 + 1)), new Class[]{Integer.TYPE});
                            }
                            bArr2[i5] = ((Byte) ((Method) objAccessartificialFrame).invoke(null, objArr4)).byteValue();
                        }
                        bArr = bArr2;
                    }
                }
                if (bArr != null) {
                    int i9 = $11 + 113;
                    $10 = i9 % 128;
                    int i10 = i9 % 2;
                    byte[] bArr3 = ICustomTabsCallbackStubProxy;
                    Object[] objArr5 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                    if (objAccessartificialFrame3 == null) {
                        byte b7 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(39 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 36242), View.getDefaultSize(0, 0) + 2342, 371880939, false, $$e(b7, (byte) (b7 - 1), $$c[0]), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr5)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                    j = -4629754035390455669L;
                } else {
                    j = -4629754035390455669L;
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            } else {
                j = -4629754035390455669L;
            }
            if (iIntValue > 0) {
                int i11 = ((i3 + iIntValue) - 2) + ((int) (((long) onTransact) ^ j));
                if (z) {
                    int i12 = $10 + 105;
                    $11 = i12 % 128;
                    int i13 = i12 % 2;
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                iCustomTabsCallback.c = i11 + i4;
                Object[] objArr6 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(Color.rgb(0, 0, 0) + 16777257, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), 4066 - TextUtils.indexOf("", "", 0), -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr6)).append(iCustomTabsCallback.createConnectionCallback);
                iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                byte[] bArr4 = ICustomTabsCallbackStubProxy;
                if (bArr4 != null) {
                    int length2 = bArr4.length;
                    byte[] bArr5 = new byte[length2];
                    for (int i14 = 0; i14 < length2; i14++) {
                        bArr5[i14] = (byte) (((long) bArr4[i14]) ^ (-4629754035390455669L));
                    }
                    bArr4 = bArr5;
                }
                boolean z2 = bArr4 != null;
                iCustomTabsCallback.a = 1;
                while (iCustomTabsCallback.a < iIntValue) {
                    if (z2) {
                        int i15 = $10 + 47;
                        $11 = i15 % 128;
                        if (i15 % 2 == 0) {
                            byte[] bArr6 = ICustomTabsCallbackStubProxy;
                            int i16 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i16;
                            c = (char) (iCustomTabsCallback.createBrowser >>> (((byte) (((byte) (((long) bArr6[i16]) ^ (-4629754035390455669L))) * s)) ^ b));
                        } else {
                            byte[] bArr7 = ICustomTabsCallbackStubProxy;
                            int i17 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i17 - 1;
                            c = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr7[i17]) ^ (-4629754035390455669L))) + s)) ^ b));
                        }
                        iCustomTabsCallback.createConnectionCallback = c;
                    } else {
                        short[] sArr = ICustomTabsService;
                        int i18 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i18 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i18]) ^ (-4629754035390455669L))) + s)) ^ b));
                    }
                    sb.append(iCustomTabsCallback.createConnectionCallback);
                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                    iCustomTabsCallback.a++;
                }
            }
            objArr[0] = sb.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 5639 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v27, types: [java.lang.Object, java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r10v75, types: [java.lang.Object, java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r11v161, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r11v251 */
    /* JADX WARN: Type inference failed for: r11v252 */
    /* JADX WARN: Type inference failed for: r11v253, types: [java.security.KeyStore] */
    /* JADX WARN: Type inference failed for: r11v254, types: [java.security.KeyStore] */
    /* JADX WARN: Type inference failed for: r11v262, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v263 */
    /* JADX WARN: Type inference failed for: r11v306 */
    /* JADX WARN: Type inference failed for: r11v307 */
    /* JADX WARN: Type inference failed for: r11v344 */
    /* JADX WARN: Type inference failed for: r11v572 */
    /* JADX WARN: Type inference failed for: r12v217, types: [java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r12v246, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r1v119 */
    /* JADX WARN: Type inference failed for: r1v155, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r29v24 */
    /* JADX WARN: Type inference failed for: r29v25 */
    /* JADX WARN: Type inference failed for: r29v26 */
    /* JADX WARN: Type inference failed for: r29v34 */
    /* JADX WARN: Type inference failed for: r29v35 */
    /* JADX WARN: Type inference failed for: r29v36 */
    /* JADX WARN: Type inference failed for: r29v37 */
    /* JADX WARN: Type inference failed for: r29v41, types: [int] */
    /* JADX WARN: Type inference failed for: r29v49 */
    /* JADX WARN: Type inference failed for: r29v50 */
    /* JADX WARN: Type inference failed for: r29v51 */
    /* JADX WARN: Type inference failed for: r29v52 */
    /* JADX WARN: Type inference failed for: r29v54, types: [int] */
    /* JADX WARN: Type inference failed for: r29v55 */
    /* JADX WARN: Type inference failed for: r29v56 */
    /* JADX WARN: Type inference failed for: r29v57 */
    /* JADX WARN: Type inference failed for: r29v58 */
    /* JADX WARN: Type inference failed for: r29v59 */
    /* JADX WARN: Type inference failed for: r29v60 */
    /* JADX WARN: Type inference failed for: r29v7 */
    /* JADX WARN: Type inference failed for: r29v8 */
    /* JADX WARN: Type inference failed for: r2v59, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r30v0 */
    /* JADX WARN: Type inference failed for: r30v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r30v10 */
    /* JADX WARN: Type inference failed for: r30v11 */
    /* JADX WARN: Type inference failed for: r30v12 */
    /* JADX WARN: Type inference failed for: r30v16, types: [byte] */
    /* JADX WARN: Type inference failed for: r30v29 */
    /* JADX WARN: Type inference failed for: r30v30 */
    /* JADX WARN: Type inference failed for: r30v31 */
    /* JADX WARN: Type inference failed for: r30v32 */
    /* JADX WARN: Type inference failed for: r30v34, types: [char] */
    /* JADX WARN: Type inference failed for: r30v35 */
    /* JADX WARN: Type inference failed for: r30v36 */
    /* JADX WARN: Type inference failed for: r30v37 */
    /* JADX WARN: Type inference failed for: r30v38 */
    /* JADX WARN: Type inference failed for: r30v39 */
    /* JADX WARN: Type inference failed for: r30v4 */
    /* JADX WARN: Type inference failed for: r30v40 */
    /* JADX WARN: Type inference failed for: r30v41 */
    /* JADX WARN: Type inference failed for: r30v5 */
    /* JADX WARN: Type inference failed for: r30v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r30v9 */
    /* JADX WARN: Type inference failed for: r31v11 */
    /* JADX WARN: Type inference failed for: r31v5 */
    /* JADX WARN: Type inference failed for: r31v6 */
    /* JADX WARN: Type inference failed for: r31v8 */
    /* JADX WARN: Type inference failed for: r34v0 */
    /* JADX WARN: Type inference failed for: r34v1 */
    /* JADX WARN: Type inference failed for: r34v19 */
    /* JADX WARN: Type inference failed for: r34v20 */
    /* JADX WARN: Type inference failed for: r34v21 */
    /* JADX WARN: Type inference failed for: r34v22 */
    /* JADX WARN: Type inference failed for: r34v23 */
    /* JADX WARN: Type inference failed for: r34v24 */
    /* JADX WARN: Type inference failed for: r34v25 */
    /* JADX WARN: Type inference failed for: r34v27 */
    /* JADX WARN: Type inference failed for: r34v28 */
    /* JADX WARN: Type inference failed for: r34v48 */
    /* JADX WARN: Type inference failed for: r34v49 */
    /* JADX WARN: Type inference failed for: r34v50 */
    /* JADX WARN: Type inference failed for: r34v51 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v258, types: [java.nio.LongBuffer[]] */
    /* JADX WARN: Type inference failed for: r4v259 */
    /* JADX WARN: Type inference failed for: r4v265 */
    /* JADX WARN: Type inference failed for: r4v266 */
    /* JADX WARN: Type inference failed for: r4v280, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r4v297 */
    /* JADX WARN: Type inference failed for: r4v521 */
    /* JADX WARN: Type inference failed for: r4v522 */
    /* JADX WARN: Type inference failed for: r5v66 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.nio.LongBuffer[]] */
    /* JADX WARN: Type inference failed for: r6v100 */
    /* JADX WARN: Type inference failed for: r6v237 */
    /* JADX WARN: Type inference failed for: r6v238 */
    /* JADX WARN: Type inference failed for: r6v240 */
    /* JADX WARN: Type inference failed for: r6v241 */
    /* JADX WARN: Type inference failed for: r6v272 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v505 */
    /* JADX WARN: Type inference failed for: r6v506 */
    /* JADX WARN: Type inference failed for: r6v507 */
    /* JADX WARN: Type inference failed for: r6v508 */
    /* JADX WARN: Type inference failed for: r9v182, types: [java.lang.Object, java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r9v183, types: [java.lang.Object, java.nio.LongBuffer] */
    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] accessartificialFrame(android.content.Context r50, java.lang.String[] r51, int r52, int r53, int r54) {
        /*
            Method dump skipped, instruction units count: 17224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzjc.accessartificialFrame(android.content.Context, java.lang.String[], int, int, int):java.lang.Object[]");
    }
}
