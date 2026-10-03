package okio;

import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: okio.-GzipSinkExtensions, reason: invalid class name */
/* JADX INFO: loaded from: classes6.dex */
public final class GzipSinkExtensions {
    private static short[] ICustomTabsService;
    private static final byte[] $$c = {5, Ascii.ESC, -76, Ascii.CR};
    private static final int $$d = 88;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {Ascii.EM, 104, 41, -86, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, 50, Ascii.SO, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4, -50};
    private static final int $$b = 121;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int onTransact = -1362895703;
    private static int mayLaunchUrl = -81862444;
    private static int getInterfaceDescriptor = 1355297513;
    private static byte[] ICustomTabsCallbackStubProxy = {-67, 82, -80, 71, -66, 109, 84, -5, 71, 72, -80, 71, -66, 77, 116, -117, -70, -69, -68, 79, -73, 76, -24, Ascii.EM, -60, 58, Ascii.RS, -25, Ascii.DC4, -14, Ascii.US, Ascii.ESC, Ascii.FS, Ascii.GS, -31, -50, 44, -18, Ascii.US, 109, -100, 65, -65, -101, 98, -111, 119, -102, -98, -103, -104, 100, 75, 119, -91, -103, 38, -34, 98, 109, -107, 98, -101, 104, 81, -82, -97, -98, -103, 106, -110, 105, 17, Ascii.ESC, -24, Ascii.ESC, -79, 4, -119, -71, 74, 65, -70, SignedBytes.MAX_POWER_OF_TWO, -78, 83, -67, 65, 119, -119, -71, -65, SignedBytes.MAX_POWER_OF_TWO, 125, -5, 75, -69, 69, 122, -116, -81, 79, 118, 114, -127, -118, 113, -117, 121, -104, 118, -118, -67, 52, 118, -117, -117, -117, -117, -117, -117, -117};

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    /* JADX WARN: Code duplicated, block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r7, short r8, int r9) {
        /*
            int r8 = r8 * 4
            int r8 = 1 - r8
            int r7 = r7 * 3
            int r7 = 3 - r7
            byte[] r0 = okio.GzipSinkExtensions.$$c
            int r9 = r9 * 5
            int r9 = r9 + 112
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r9 = r7
            r3 = r8
            r5 = r2
            goto L2c
        L17:
            r3 = r2
            r6 = r9
            r9 = r7
            r7 = r6
        L1b:
            byte r4 = (byte) r7
            int r9 = r9 + 1
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L2a:
            r3 = r0[r9]
        L2c:
            int r3 = -r3
            int r7 = r7 + r3
            r3 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.GzipSinkExtensions.$$e(int, short, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = 71 - r8
            byte[] r0 = okio.GzipSinkExtensions.$$a
            int r7 = r7 + 66
            int r1 = r6 + 2
            byte[] r1 = new byte[r1]
            int r6 = r6 + 1
            r2 = 0
            if (r0 != 0) goto L12
            r3 = r8
            r4 = r2
            goto L2a
        L12:
            r3 = r2
            r5 = r8
            r8 = r7
            r7 = r5
        L16:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            r3 = r0[r7]
            r5 = r3
            r3 = r7
            r7 = r5
        L2a:
            int r8 = r8 + r7
            int r8 = r8 + (-5)
            int r7 = r3 + 1
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.GzipSinkExtensions.a(byte, byte, byte, java.lang.Object[]):void");
    }

    public static final GzipSink gzip(@NotNull Sink gzip) {
        Intrinsics.checkNotNullParameter(gzip, "$this$gzip");
        return new GzipSink(gzip);
    }

    private static void b(int i, byte b, int i2, short s, int i3, Object[] objArr) throws Throwable {
        boolean z;
        long j;
        int i4;
        int i5 = 2;
        int i6 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
            if (objAccessartificialFrame == null) {
                byte b2 = (byte) 0;
                byte b3 = b2;
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(39 - MotionEvent.axisFromString(""), (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 36241), 2342 - ExpandableListView.getPackedPositionType(0L), 371880939, false, $$e(b2, b3, b3), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
            if (iIntValue == -1) {
                int i7 = $10 + 79;
                int i8 = i7 % 128;
                $11 = i8;
                int i9 = i7 % 2;
                int i10 = i8 + 67;
                $10 = i10 % 128;
                int i11 = i10 % 2;
                z = true;
            } else {
                z = false;
            }
            float f = 0.0f;
            if (z) {
                byte[] bArr = ICustomTabsCallbackStubProxy;
                if (bArr != null) {
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    int i12 = 0;
                    while (i12 < length) {
                        int i13 = $11 + 33;
                        $10 = i13 % 128;
                        int i14 = i13 % i5;
                        Object[] objArr3 = {Integer.valueOf(bArr[i12])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                        if (objAccessartificialFrame2 == null) {
                            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 45;
                            char cAxisFromString = (char) ((-1) - MotionEvent.axisFromString(""));
                            int i15 = (AudioTrack.getMinVolume() > f ? 1 : (AudioTrack.getMinVolume() == f ? 0 : -1)) + 1215;
                            byte b4 = (byte) 0;
                            byte b5 = b4;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf, cAxisFromString, i15, 1011328145, false, $$e(b4, b5, (byte) (b5 + 1)), new Class[]{Integer.TYPE});
                        }
                        bArr2[i12] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                        i12++;
                        i5 = 2;
                        f = 0.0f;
                    }
                    bArr = bArr2;
                }
                if (bArr != null) {
                    byte[] bArr3 = ICustomTabsCallbackStubProxy;
                    Object[] objArr4 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                    if (objAccessartificialFrame3 == null) {
                        byte b6 = (byte) 0;
                        byte b7 = b6;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(0) + 41, (char) ((ViewConfiguration.getTapTimeout() >> 16) + 36241), 2343 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 371880939, false, $$e(b6, b7, b7), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                    j = -4629754035390455669L;
                } else {
                    j = -4629754035390455669L;
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            } else {
                j = -4629754035390455669L;
            }
            if (iIntValue > 0) {
                int i16 = ((i3 + iIntValue) - 2) + ((int) (((long) onTransact) ^ j));
                if (z) {
                    int i17 = $10 + 13;
                    $11 = i17 % 128;
                    int i18 = i17 % 2;
                    i4 = 1;
                } else {
                    int i19 = $10 + 117;
                    $11 = i19 % 128;
                    int i20 = i19 % 2;
                    i4 = 0;
                }
                iCustomTabsCallback.c = i16 + i4;
                Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(41 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), ((Process.getThreadPriority(0) + 20) >> 6) + 4066, -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                byte[] bArr4 = ICustomTabsCallbackStubProxy;
                if (bArr4 != null) {
                    int length2 = bArr4.length;
                    byte[] bArr5 = new byte[length2];
                    for (int i21 = 0; i21 < length2; i21++) {
                        bArr5[i21] = (byte) (((long) bArr4[i21]) ^ (-4629754035390455669L));
                    }
                    bArr4 = bArr5;
                }
                boolean z2 = bArr4 != null;
                iCustomTabsCallback.a = 1;
                int i22 = $10 + 53;
                $11 = i22 % 128;
                int i23 = i22 % 2;
                while (iCustomTabsCallback.a < iIntValue) {
                    int i24 = $10 + 3;
                    $11 = i24 % 128;
                    int i25 = i24 % 2;
                    if (z2) {
                        byte[] bArr6 = ICustomTabsCallbackStubProxy;
                        int i26 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i26 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr6[i26]) ^ (-4629754035390455669L))) + s)) ^ b));
                    } else {
                        short[] sArr = ICustomTabsService;
                        int i27 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i27 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i27]) ^ (-4629754035390455669L))) + s)) ^ b));
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

    /* JADX WARN: Code duplicated, block: B:100:0x0bc7 A[Catch: all -> 0x0df2, TryCatch #1 {all -> 0x0df2, blocks: (B:98:0x0bba, B:100:0x0bc7, B:101:0x0c0c), top: B:137:0x0bba, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x0c24 A[Catch: Exception -> 0x0dfc, TRY_ENTER, TryCatch #4 {Exception -> 0x0dfc, blocks: (B:86:0x0b0f, B:104:0x0c24, B:106:0x0c3a, B:110:0x0ca8, B:111:0x0cc8, B:105:0x0c2e, B:93:0x0b83, B:95:0x0b89, B:96:0x0b8a, B:97:0x0b8b, B:115:0x0df3, B:117:0x0df9, B:118:0x0dfa, B:98:0x0bba, B:100:0x0bc7, B:101:0x0c0c, B:87:0x0b28, B:89:0x0b35, B:90:0x0b79), top: B:142:0x0af9, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x0c2e A[Catch: Exception -> 0x0dfc, TryCatch #4 {Exception -> 0x0dfc, blocks: (B:86:0x0b0f, B:104:0x0c24, B:106:0x0c3a, B:110:0x0ca8, B:111:0x0cc8, B:105:0x0c2e, B:93:0x0b83, B:95:0x0b89, B:96:0x0b8a, B:97:0x0b8b, B:115:0x0df3, B:117:0x0df9, B:118:0x0dfa, B:98:0x0bba, B:100:0x0bc7, B:101:0x0c0c, B:87:0x0b28, B:89:0x0b35, B:90:0x0b79), top: B:142:0x0af9, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x0ca2  */
    /* JADX WARN: Code duplicated, block: B:111:0x0cc8 A[Catch: Exception -> 0x0dfc, TRY_LEAVE, TryCatch #4 {Exception -> 0x0dfc, blocks: (B:86:0x0b0f, B:104:0x0c24, B:106:0x0c3a, B:110:0x0ca8, B:111:0x0cc8, B:105:0x0c2e, B:93:0x0b83, B:95:0x0b89, B:96:0x0b8a, B:97:0x0b8b, B:115:0x0df3, B:117:0x0df9, B:118:0x0dfa, B:98:0x0bba, B:100:0x0bc7, B:101:0x0c0c, B:87:0x0b28, B:89:0x0b35, B:90:0x0b79), top: B:142:0x0af9, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x07de  */
    /* JADX WARN: Code duplicated, block: B:40:0x07e4  */
    /* JADX WARN: Code duplicated, block: B:53:0x0901  */
    /* JADX WARN: Code duplicated, block: B:56:0x091b A[Catch: Exception -> 0x0dfb, TryCatch #6 {Exception -> 0x0dfb, blocks: (B:45:0x08e3, B:54:0x0904, B:57:0x0930, B:59:0x0951, B:66:0x09dd, B:56:0x091b, B:48:0x08ea), top: B:141:0x08e1 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0988 A[Catch: all -> 0x0a71, TryCatch #0 {all -> 0x0a71, blocks: (B:61:0x097b, B:63:0x0988, B:64:0x09cc), top: B:135:0x097b, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0a5d  */
    /* JADX WARN: Code duplicated, block: B:70:0x0a61  */
    /* JADX WARN: Code duplicated, block: B:81:0x0ab1  */
    /* JADX WARN: Code duplicated, block: B:82:0x0acc  */
    /* JADX WARN: Code duplicated, block: B:85:0x0afb  */
    /* JADX WARN: Code duplicated, block: B:89:0x0b35 A[Catch: all -> 0x0b82, TryCatch #2 {all -> 0x0b82, blocks: (B:87:0x0b28, B:89:0x0b35, B:90:0x0b79), top: B:139:0x0b28, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0b8b A[Catch: Exception -> 0x0dfc, TRY_LEAVE, TryCatch #4 {Exception -> 0x0dfc, blocks: (B:86:0x0b0f, B:104:0x0c24, B:106:0x0c3a, B:110:0x0ca8, B:111:0x0cc8, B:105:0x0c2e, B:93:0x0b83, B:95:0x0b89, B:96:0x0b8a, B:97:0x0b8b, B:115:0x0df3, B:117:0x0df9, B:118:0x0dfa, B:98:0x0bba, B:100:0x0bc7, B:101:0x0c0c, B:87:0x0b28, B:89:0x0b35, B:90:0x0b79), top: B:142:0x0af9, inners: #1, #2 }] */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0cf9, code lost:
    
        if (r0 != false) goto L113;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r27, int r28, int r29, int r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3702
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.GzipSinkExtensions.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
