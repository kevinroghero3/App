package kotlin.text;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import ch.qos.logback.core.CoreConstants;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.artificialFrame;
import o.onMessageChannelReady;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    private static final byte[] $$c = {123, -106, -53, 126};
    private static final int $$d = 242;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {55, -4, -8, -76, -12, -6, Ascii.ESC, -22, -26, 4, -12, 0, -8, -2, -8};
    private static final int $$b = 91;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] validateRelationship = {55941, 55950, 56049, 55993, 56057, 55942, 56056, 55963, 55936, 55981, 56050, 55937, 55938, 56061, 55982, 55939, 55972, 56054, 55964, 56051, 56060, 55948, 55974, 56059, 55980, 55955, 56058, 55943, 55959, 55986, 55999, 55990, 55970, 56055, 55953, 56048, 56063, 55975, 55995, 55967, 55940, 55961, 55962, 55971};
    private static int warmup = -1044259985;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;
    private static int[] ICustomTabsCallbackStub = {1419610880, -75232830, -1871643199, 531438003, -1978207287, -28126819, 900057956, 29844220, -404957391, -617618744, 2002462468, -1183926904, -2125634269, 1719024462, -1769167517, 1636440441, 1965752403, -84254899};

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r6, int r7, short r8) {
        /*
            int r8 = r8 * 2
            int r0 = 1 - r8
            int r7 = r7 + 66
            byte[] r1 = kotlin.text.StringsKt__StringNumberConversionsKt.$$c
            int r6 = r6 + 4
            byte[] r0 = new byte[r0]
            r2 = 0
            int r8 = 0 - r8
            if (r1 != 0) goto L15
            r4 = r7
            r3 = r2
            r7 = r6
            goto L2a
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r8) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L21:
            int r6 = r6 + 1
            r4 = r1[r6]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r5
        L2a:
            int r4 = -r4
            int r6 = r6 + r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringNumberConversionsKt.$$e(int, int, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = kotlin.text.StringsKt__StringNumberConversionsKt.$$a
            int r7 = r7 + 4
            int r6 = r6 * 5
            int r6 = r6 + 4
            int r8 = r8 * 3
            int r8 = r8 + 112
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r6
            r4 = r2
            goto L2c
        L14:
            r3 = r2
        L15:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r4 = r0[r7]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2c:
            int r8 = -r8
            int r3 = r3 + r8
            int r8 = r3 + (-7)
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringNumberConversionsKt.b(int, byte, byte, java.lang.Object[]):void");
    }

    public static final Byte toByteOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toByteOrNull(str, 10);
    }

    public static final Byte toByteOrNull(@NotNull String str, int i) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Integer intOrNull = toIntOrNull(str, i);
        if (intOrNull == null || (iIntValue = intOrNull.intValue()) < -128 || iIntValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) iIntValue);
    }

    public static final Short toShortOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toShortOrNull(str, 10);
    }

    public static final Short toShortOrNull(@NotNull String str, int i) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Integer intOrNull = toIntOrNull(str, i);
        if (intOrNull == null || (iIntValue = intOrNull.intValue()) < -32768 || iIntValue > 32767) {
            return null;
        }
        return Short.valueOf((short) iIntValue);
    }

    public static Integer toIntOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toIntOrNull(str, 10);
    }

    public static final Integer toIntOrNull(@NotNull String str, int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char cCharAt = str.charAt(0);
        int i5 = -2147483647;
        if (Intrinsics.compare((int) cCharAt, 48) < 0) {
            z = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                i2 = 1;
                z = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i5 = Integer.MIN_VALUE;
                i2 = 1;
            }
        } else {
            i2 = 0;
            z = false;
        }
        int i6 = -59652323;
        while (i2 < length) {
            int iDigitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i2), i);
            if (iDigitOf < 0) {
                return null;
            }
            if ((i4 < i6 && (i6 != -59652323 || i4 < (i6 = i5 / i))) || (i3 = i4 * i) < i5 + iDigitOf) {
                return null;
            }
            i4 = i3 - iDigitOf;
            i2++;
        }
        return z ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }

    private static void c(int i, int[] iArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = ICustomTabsCallbackStub;
        int i3 = -1780896814;
        int i4 = -1;
        int i5 = 1;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i6 = 0;
            while (i6 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(iArr2[i6])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i3);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i4;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - Color.red(0), (char) (Process.myTid() >> 22), 1562 - KeyEvent.normalizeMetaState(0), 180153818, false, $$e(b, (byte) (b & 43), (byte) 0), new Class[]{Integer.TYPE});
                    }
                    iArr3[i6] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i6++;
                    i3 = -1780896814;
                    i4 = -1;
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
        int i7 = 16;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i8 = 0;
            while (i8 < length3) {
                Object[] objArr3 = new Object[i5];
                objArr3[0] = Integer.valueOf(iArr5[i8]);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                if (objAccessartificialFrame2 == null) {
                    byte b2 = (byte) (-1);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(View.getDefaultSize(0, 0) + 11, (char) (ViewConfiguration.getFadingEdgeLength() >> i7), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 1561, 180153818, false, $$e(b2, (byte) (b2 & 43), (byte) 0), new Class[]{Integer.TYPE});
                }
                iArr6[i8] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                i8++;
                iArr5 = iArr5;
                i7 = 16;
                i5 = 1;
            }
            int i9 = $10 + 125;
            $11 = i9 % 128;
            int i10 = i9 % 2;
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        artificialframe.e = 0;
        while (artificialframe.e < iArr.length) {
            cArr[0] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr4);
            int i11 = 0;
            for (int i12 = 16; i11 < i12; i12 = 16) {
                artificialframe.c ^= iArr4[i11];
                try {
                    Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                    if (objAccessartificialFrame3 == null) {
                        byte b3 = (byte) (-1);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 26, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), Color.argb(0, 0, 0, 0) + 1041, 995482881, false, $$e(b3, (byte) (b3 & 49), (byte) 0), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = iIntValue;
                    i11++;
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            int i13 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i13;
            artificialframe.b ^= iArr4[16];
            artificialframe.c ^= iArr4[17];
            int i14 = artificialframe.c;
            int i15 = artificialframe.b;
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
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 37, (char) (28010 - ((Process.getThreadPriority(0) + 20) >> 6)), Drawable.resolveOpacity(0, 0) + 306, -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
        }
        String str = new String(cArr2, 0, i);
        int i16 = $11 + 31;
        $10 = i16 % 128;
        int i17 = i16 % 2;
        objArr[0] = str;
    }

    public static Long toLongOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toLongOrNull(str, 10);
    }

    public static final Long toLongOrNull(@NotNull String str, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        long j = -9223372036854775807L;
        if (Intrinsics.compare((int) cCharAt, 48) < 0) {
            z = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z = false;
                i2 = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j = Long.MIN_VALUE;
                i2 = 1;
            }
        } else {
            z = false;
        }
        long j2 = -256204778801521550L;
        long j3 = 0;
        long j4 = -256204778801521550L;
        while (i2 < length) {
            int iDigitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i2), i);
            if (iDigitOf < 0) {
                return null;
            }
            if (j3 < j4) {
                if (j4 == j2) {
                    j4 = j / ((long) i);
                    if (j3 < j4) {
                    }
                }
                return null;
            }
            long j5 = j3 * ((long) i);
            long j6 = iDigitOf;
            if (j5 < j + j6) {
                return null;
            }
            j3 = j5 - j6;
            i2++;
            j2 = -256204778801521550L;
        }
        return z ? Long.valueOf(j3) : Long.valueOf(-j3);
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr2 = validateRelationship;
        float f = 0.0f;
        int i4 = 1;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i5 = 0;
            while (i5 < length) {
                int i6 = $10 + 59;
                $11 = i6 % 128;
                if (i6 % i2 == 0) {
                    try {
                        Object[] objArr2 = new Object[i4];
                        objArr2[0] = Integer.valueOf(cArr2[i5]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) (-1);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(26 - (AudioTrack.getMinVolume() > f ? 1 : (AudioTrack.getMinVolume() == f ? 0 : -1)), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 1040 - TextUtils.indexOf((CharSequence) "", '0'), -1719489573, false, $$e(b, (byte) (b & 55), (byte) 0), new Class[]{Integer.TYPE});
                        }
                        cArr3[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i5 = 0;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    Object[] objArr3 = {Integer.valueOf(cArr2[i5])};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame2 == null) {
                        byte b2 = (byte) (-1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(26 - TextUtils.getTrimmedLength(""), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), View.combineMeasuredStates(0, 0) + 1041, -1719489573, false, $$e(b2, (byte) (b2 & 55), (byte) 0), new Class[]{Integer.TYPE});
                    }
                    cArr3[i5] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i5++;
                }
                i2 = 2;
                f = 0.0f;
                i4 = 1;
            }
            cArr2 = cArr3;
        }
        Object[] objArr4 = {Integer.valueOf(warmup)};
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1820173622);
        if (objAccessartificialFrame3 == null) {
            byte b3 = (byte) (-1);
            byte b4 = (byte) (-b3);
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 14, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 20488), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 2147, 216472770, false, $$e(b3, b4, (byte) (b4 - 1)), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
        int i7 = -2083387879;
        if (ICustomTabsServiceDefault) {
            onmessagechannelready.c = bArr.length;
            char[] cArr4 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(i7);
                if (objAccessartificialFrame4 == null) {
                    byte b5 = (byte) (-1);
                    byte b6 = (byte) (b5 + 1);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(22 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 59175), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 1942, 481771537, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                int i8 = $10 + 9;
                $11 = i8 % 128;
                int i9 = i8 % 2;
                i7 = -2083387879;
            }
            objArr[0] = new String(cArr4);
            return;
        }
        if (!requestPostMessageChannelWithExtras) {
            onmessagechannelready.c = iArr.length;
            char[] cArr5 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr5[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                onmessagechannelready.a++;
            }
            objArr[0] = new String(cArr5);
            return;
        }
        onmessagechannelready.c = cArr.length;
        char[] cArr6 = new char[onmessagechannelready.c];
        onmessagechannelready.a = 0;
        while (onmessagechannelready.a < onmessagechannelready.c) {
            int i10 = $11 + 29;
            $10 = i10 % 128;
            if (i10 % 2 != 0) {
                cArr6[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c % 1) + onmessagechannelready.a] >>> i] >> iIntValue);
                try {
                    Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame5 == null) {
                        byte b7 = (byte) (-1);
                        byte b8 = (byte) (b7 + 1);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(21 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 59174), 1943 - TextUtils.getOffsetBefore("", 0), 481771537, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            } else {
                cArr6[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                Object[] objArr7 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                if (objAccessartificialFrame6 == null) {
                    byte b9 = (byte) (-1);
                    byte b10 = (byte) (b9 + 1);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(21 - TextUtils.getCapsMode("", 0, 0), (char) (59173 - TextUtils.lastIndexOf("", '0', 0, 0)), (ViewConfiguration.getLongPressTimeout() >> 16) + 1943, 481771537, false, $$e(b9, b10, b10), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame6).invoke(null, objArr7);
            }
        }
        String str = new String(cArr6);
        int i11 = $11 + 105;
        $10 = i11 % 128;
        if (i11 % 2 != 0) {
            throw null;
        }
        objArr[0] = str;
    }

    public static final Void numberFormatError(@NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + CoreConstants.SINGLE_QUOTE_CHAR);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 147181. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static java.lang.Object[] accessartificialFrame(android.content.Context r37, java.lang.String[] r38, int r39, int r40, int r41) {
        /*
            Method dump skipped, instruction units count: 14718
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringNumberConversionsKt.accessartificialFrame(android.content.Context, java.lang.String[], int, int, int):java.lang.Object[]");
    }
}
