package kotlin.io.path;

import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import o.extraCallback;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ExceptionsCollector$$ExternalSyntheticApiModelOutline6 {
    private static short[] ICustomTabsService;
    private static final byte[] $$c = {54, 81, -13, 100};
    private static final int $$d = JfifUtil.MARKER_SOS;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {Ascii.FF, 109, 62, -103, 10, 4, -5, Ascii.SYN, -16, 50, Ascii.SO, 3, Ascii.DC4, 1, Ascii.SYN, -3, 8, 32, 8, 6, 10, Ascii.DC2, 0, -8, Ascii.DC4, Ascii.US, 5, Ascii.DLE, 8, 5, Ascii.DLE, 5, -49, 1, -6, Ascii.GS, -9, 5, Ascii.VT, 10, 2, 5, Ascii.ESC, Ascii.SYN, -16, 36, 8, 3, -2, Ascii.DC2, 3, -50, -9, Ascii.SO, -5};
    private static final int $$b = JfifUtil.MARKER_EOI;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int onTransact = -1689741014;
    private static int mayLaunchUrl = -81862471;
    private static int getInterfaceDescriptor = 1105160242;
    private static byte[] ICustomTabsCallbackStubProxy = {82, 53, 87, 62, 85, 54, 87, 79, -114, 1, 67, 95, -105, -97, -113, -105, 117, 110, -90, -104, -106, -86, -70, -87, -112, -102, -84, -90, -97, -44, 81, -70, -123, -70, -98, -106, -87, -23, 84, -106, 80, -7, 8, -15, -8, -14, -32, 7, -3, -15, 36, -77, -3, 93, 8, Ascii.SYN, 8, Ascii.RS, Ascii.CR, Ascii.FF, 7, 95, -99, -87, -99, -112, -91, 80, 87, -92, 57, 86, 117, 99, 103, -87, 47, 125, 109, 123, 91, 54, 87, -57, -18, -56, -18, -39, -58, -33, -38, -21, -38, -64, -38, -35, 94, -87, -98, -87, -107, -81, -124, 105, 114, 119, 122, 114, 98, 112, 108, 125, -117, 97, 108, 117, 110, -128, 85, 126, -113, 107, 127, 85, -79, -74, -60, -94, -74, 9, 124, -62, -84, -58, -70, -52, -68, -62, -95, 83, 1, 59, 68, 38, 76, 53, 53, 32, 49, 82, -11, Ascii.NAK, 39, 56, 33, 49, 36, 36, Ascii.ETB, 32, 81, 127, -77, -79, -19, 126, -80, -81, -65, -90, -78, -4, 110, 51, 44, 50, 52, 37, 52, 103, -26, 50, 54, 48, 56, 54, 35, 113, -7, 72, 102, -7, 59, 55, 113, 84, -55, -50, -36, -70, -50, 3, -122, -75, -64, -67, 3, -101, -77, -54, -51, Ascii.SO, 94, 101, 92, 108, 107, 103, -95, 81, -111, -105, -113, -46, 92, -106, -115, -99, -124, -112, -46, 82, -122, -124, -80, 78, -128, -104, 117, -102, 124, -60, 88, 42, 40, 0, 107, 89, -99, -67, -42, 80, 123, 120, 125, -94, 50, 108, 121, 104, -119, -88, 37, 103, 82, 73, 68, 71, 93, SignedBytes.MAX_POWER_OF_TWO, 78, 69, 81, 62, 104, 107, 38, 59, Base64.padSymbol, 57, 32, 56, 19, 59, 120, -14, Ascii.DLE, 58, 120, -29, 50, 34, 56, 110, Base64.padSymbol, 79, 51, Base64.padSymbol, 51, 51, 42, 48, Base64.padSymbol, 56, 113, -6, 59, 55, 112, -5, 60, 75, 39, 60, 72, 32, 84, Ascii.SYN, 106, 104, 77, -82, Ascii.DC4, 108, 81, 91, 84, -110, 33, 66, 100, 82, -102, 95, -23, 45, 35, Ascii.ESC, 110, 84, 62, 125, -122, -70, 114, 48, 116, -118, -90, 55, -119, 96, 112, 127, -117, -75, 104, 37, 104, 98, 89, 96, 108, 103, 84, -112, 46, 98, 96, -100, 45, 103, 94, 110, 85, 97, -93, 85, -77, -9, -11, -22, 75, -55, -29, 48, -78, -12, -29, -13, -6, -10, 48, 92, Ascii.FS, 80, 86, -126, Ascii.CAN, 94, 95, -105, 84, 101, 126, 99, 126, 122, -90, 51, 98, 125, 106, -72, 48, 104, 103, 122, -69, 95, Ascii.FS, 102, 94, 77, Ascii.NAK, 94, 46, 39, Ascii.DC4, 39, 35, 111, 82, 114, -128, -120, 100, -117, -57, 49, -103, -119, -67, 85, 62, 37, 46, 55, 77, 83, -14, 32, 52, 44, 123, -12, Ascii.SYN, 76, 34};
    private static char[] ArtificialStackFrames = {44385, 44389, 44407, 44333, 44402, 44409, 44339, 44405, 44391, 44699, 44388, 44703, 44334, 44400, 44696, 44396, 44390, 44393, 44387, 44702, 44392, 44697, 44406, 44408, 44404, 44383, 44386, 44337, 44401, 44398, 44335, 44397, 44403, 44399, 44698, 44395};
    private static char coroutineCreation = 39068;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r7, byte r8, short r9) {
        /*
            int r7 = r7 + 4
            byte[] r0 = kotlin.io.path.ExceptionsCollector$$ExternalSyntheticApiModelOutline6.$$c
            int r8 = r8 * 3
            int r8 = 1 - r8
            int r9 = 117 - r9
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L12
            r3 = r8
            r4 = r2
            goto L27
        L12:
            r3 = r2
        L13:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            int r7 = r7 + 1
            if (r4 != r8) goto L22
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L22:
            r3 = r0[r7]
            r6 = r3
            r3 = r9
            r9 = r6
        L27:
            int r9 = -r9
            int r9 = r9 + r3
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.ExceptionsCollector$$ExternalSyntheticApiModelOutline6.$$e(int, byte, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(int r5, short r6, byte r7, java.lang.Object[] r8) {
        /*
            int r0 = 4 - r6
            int r5 = 51 - r5
            int r7 = r7 + 66
            byte[] r1 = kotlin.io.path.ExceptionsCollector$$ExternalSyntheticApiModelOutline6.$$a
            byte[] r0 = new byte[r0]
            int r6 = 3 - r6
            r2 = 0
            if (r1 != 0) goto L13
            r4 = r7
            r3 = r2
            r7 = r6
            goto L27
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r6) goto L21
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L21:
            int r5 = r5 + 1
            r4 = r1[r5]
            int r3 = r3 + 1
        L27:
            int r7 = r7 + r4
            int r7 = r7 + (-5)
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.ExceptionsCollector$$ExternalSyntheticApiModelOutline6.a(int, short, byte, java.lang.Object[]):void");
    }

    public static /* synthetic */ void m() {
    }

    /* JADX WARN: Code duplicated, block: B:61:0x0266  */
    /* JADX WARN: Code duplicated, block: B:62:0x0292  */
    private static void b(int i, byte b, int i2, short s, int i3, Object[] objArr) throws Throwable {
        boolean z;
        int length;
        byte[] bArr;
        int i4 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
            int i5 = -1;
            if (objAccessartificialFrame == null) {
                byte b2 = (byte) (-1);
                byte b3 = (byte) (b2 + 1);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(40 - ExpandableListView.getPackedPositionType(0L), (char) (36241 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), TextUtils.indexOf((CharSequence) "", '0', 0) + 2343, 371880939, false, $$e(b2, b3, (byte) (b3 + 5)), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
            int i6 = iIntValue == -1 ? 1 : 0;
            if (i6 != 0) {
                byte[] bArr2 = ICustomTabsCallbackStubProxy;
                if (bArr2 != null) {
                    int length2 = bArr2.length;
                    byte[] bArr3 = new byte[length2];
                    int i7 = 0;
                    while (i7 < length2) {
                        try {
                            Object[] objArr3 = {Integer.valueOf(bArr2[i7])};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                            if (objAccessartificialFrame2 == null) {
                                byte b4 = (byte) i5;
                                byte b5 = (byte) (b4 + 1);
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(Drawable.resolveOpacity(0, 0) + 44, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + i5), 1215 - (ViewConfiguration.getFadingEdgeLength() >> 16), 1011328145, false, $$e(b4, b5, b5), new Class[]{Integer.TYPE});
                            }
                            bArr3[i7] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                            i7++;
                            i5 = -1;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    bArr2 = bArr3;
                }
                if (bArr2 != null) {
                    int i8 = $10 + 105;
                    $11 = i8 % 128;
                    int i9 = i8 % 2;
                    byte[] bArr4 = ICustomTabsCallbackStubProxy;
                    Object[] objArr4 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                    if (objAccessartificialFrame3 == null) {
                        byte b6 = (byte) (-1);
                        byte b7 = (byte) (b6 + 1);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(40 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (36241 - (ViewConfiguration.getEdgeSlop() >> 16)), View.MeasureSpec.getMode(0) + 2342, 371880939, false, $$e(b6, b7, (byte) (b7 + 5)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    iIntValue = (byte) (((byte) (((long) bArr4[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                } else {
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            }
            if (iIntValue > 0) {
                int i10 = $10 + 37;
                $11 = i10 % 128;
                int i11 = i10 % 2;
                iCustomTabsCallback.c = ((i3 + iIntValue) - 2) + ((int) (((long) onTransact) ^ (-4629754035390455669L))) + i6;
                Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(MotionEvent.axisFromString("") + 42, (char) Drawable.resolveOpacity(0, 0), 4066 - KeyEvent.getDeadChar(0, 0), -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                byte[] bArr5 = ICustomTabsCallbackStubProxy;
                if (bArr5 != null) {
                    int i12 = $11 + 23;
                    $10 = i12 % 128;
                    if (i12 % 2 != 0) {
                        length = bArr5.length;
                        bArr = new byte[length];
                    } else {
                        length = bArr5.length;
                        bArr = new byte[length];
                    }
                    for (int i13 = 0; i13 < length; i13++) {
                        bArr[i13] = (byte) (((long) bArr5[i13]) ^ (-4629754035390455669L));
                    }
                    bArr5 = bArr;
                }
                if (bArr5 != null) {
                    z = true;
                } else {
                    int i14 = $11 + 33;
                    $10 = i14 % 128;
                    int i15 = i14 % 2;
                    z = false;
                }
                iCustomTabsCallback.a = 1;
                while (iCustomTabsCallback.a < iIntValue) {
                    int i16 = $11 + 33;
                    int i17 = i16 % 128;
                    $10 = i17;
                    if (i16 % 2 != 0) {
                        int i18 = 29 / 0;
                        if (z) {
                            int i19 = i17 + 35;
                            $11 = i19 % 128;
                            int i20 = i19 % 2;
                            byte[] bArr6 = ICustomTabsCallbackStubProxy;
                            int i21 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i21 - 1;
                            iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr6[i21]) ^ (-4629754035390455669L))) + s)) ^ b));
                        } else {
                            short[] sArr = ICustomTabsService;
                            int i22 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i22 - 1;
                            iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i22]) ^ (-4629754035390455669L))) + s)) ^ b));
                        }
                    } else if (z) {
                        int i110 = i17 + 35;
                        $11 = i110 % 128;
                        int i23 = i110 % 2;
                        byte[] bArr7 = ICustomTabsCallbackStubProxy;
                        int i24 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i24 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr7[i24]) ^ (-4629754035390455669L))) + s)) ^ b));
                    } else {
                        short[] sArr2 = ICustomTabsService;
                        int i25 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i25 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr2[i25]) ^ (-4629754035390455669L))) + s)) ^ b));
                    }
                    sb.append(iCustomTabsCallback.createConnectionCallback);
                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                    iCustomTabsCallback.a++;
                }
            }
            objArr[0] = sb.toString();
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    private static void c(byte b, int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2;
        Object obj;
        int length;
        char[] cArr2;
        int i3 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr3 = ArtificialStackFrames;
        int i4 = -1819279892;
        long j = 0;
        Object obj2 = null;
        int i5 = -1;
        if (cArr3 != null) {
            int i6 = $11 + 107;
            $10 = i6 % 128;
            if (i6 % 2 != 0) {
                length = cArr3.length;
                cArr2 = new char[length];
            } else {
                length = cArr3.length;
                cArr2 = new char[length];
            }
            int i7 = 0;
            while (i7 < length) {
                int i8 = $10 + 47;
                $11 = i8 % 128;
                int i9 = i8 % 2;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr3[i7])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                    if (objAccessartificialFrame == null) {
                        byte b2 = (byte) i5;
                        byte b3 = (byte) (b2 + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1)) + 14, (char) (20488 - ExpandableListView.getPackedPositionType(j)), 2148 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 216710116, false, $$e(b2, b3, (byte) (b3 | Ascii.DC4)), new Class[]{Integer.TYPE});
                    }
                    cArr2[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i7++;
                    int i10 = $11 + 77;
                    $10 = i10 % 128;
                    int i11 = i10 % 2;
                    i4 = -1819279892;
                    j = 0;
                    i5 = -1;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr3 = cArr2;
        }
        try {
            Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
            if (objAccessartificialFrame2 == null) {
                byte b4 = (byte) (-1);
                byte b5 = (byte) (b4 + 1);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 14, (char) (20488 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), 2147 - ((byte) KeyEvent.getModifierMetaStateMask()), 216710116, false, $$e(b4, b5, (byte) (b5 | Ascii.DC4)), new Class[]{Integer.TYPE});
            }
            char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
            char[] cArr4 = new char[i];
            if (i % 2 != 0) {
                int i12 = $10 + 25;
                $11 = i12 % 128;
                if (i12 % 2 == 0) {
                    i2 = i + 4;
                    cArr4[i2] = (char) (cArr[i2] >>> b);
                } else {
                    i2 = i - 1;
                    cArr4[i2] = (char) (cArr[i2] - b);
                }
            } else {
                i2 = i;
            }
            if (i2 > 1) {
                extracallback.a = 0;
                while (extracallback.a < i2) {
                    extracallback.createBrowser = cArr[extracallback.a];
                    extracallback.c = cArr[extracallback.a + 1];
                    if (extracallback.createBrowser == extracallback.c) {
                        cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                        cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        obj = obj2;
                    } else {
                        try {
                            Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                            if (objAccessartificialFrame3 == null) {
                                byte b6 = (byte) (-1);
                                byte b7 = (byte) (b6 + 1);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 46, (char) (TextUtils.getOffsetAfter("", 0) + 58859), ImageFormat.getBitsPerPixel(0) + 2465, 276640984, false, $$e(b6, b7, (byte) (b7 | Ascii.SI)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                            }
                            if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                                Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                if (objAccessartificialFrame4 == null) {
                                    byte b8 = (byte) (-1);
                                    byte b9 = (byte) (b8 + 1);
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(Drawable.resolveOpacity(0, 0) + 24, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), TextUtils.getCapsMode("", 0, 0) + 792, -834291897, false, $$e(b8, b9, (byte) (b9 | Ascii.FF)), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                }
                                obj = null;
                                int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                                int i13 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr3[iIntValue];
                                cArr4[extracallback.a + 1] = cArr3[i13];
                            } else {
                                obj = null;
                                if (extracallback.b == extracallback.d) {
                                    extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                    extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                    int i14 = (extracallback.b * cCharValue) + extracallback.j;
                                    int i15 = (extracallback.d * cCharValue) + extracallback.g;
                                    cArr4[extracallback.a] = cArr3[i14];
                                    cArr4[extracallback.a + 1] = cArr3[i15];
                                } else {
                                    int i16 = (extracallback.b * cCharValue) + extracallback.g;
                                    int i17 = (extracallback.d * cCharValue) + extracallback.j;
                                    cArr4[extracallback.a] = cArr3[i16];
                                    cArr4[extracallback.a + 1] = cArr3[i17];
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
                }
            }
            for (int i18 = 0; i18 < i; i18++) {
                int i19 = $10 + 65;
                $11 = i19 % 128;
                int i20 = i19 % 2;
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
    public static java.lang.Object[] accessartificialFrame$78cbbd35(int r64, int r65, java.lang.Object r66, int r67, boolean r68) {
        /*
            Method dump skipped, instruction units count: 18429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.ExceptionsCollector$$ExternalSyntheticApiModelOutline6.accessartificialFrame$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
    }
}
