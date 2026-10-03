package com.salesforce.marketingcloud.internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.zip.Inflater;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.asBinder;
import o.onMessageChannelReady;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final byte[] $$c = {70, -123, Ascii.CR, 112};
    private static final int $$d = 170;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {72, -88, 5, 32, -50, -14, -3, -20, 50, 5, -22, Ascii.DLE, 49, -22, 3, -8, -1, 6, -29, -1, -16, -5, -36, -8, -3, 9, -14, 5, -8, -5, 0, 8, -20, -27, -22, Ascii.DLE, -31, -5, -16, -10, -2, -5, 9, -5, -11, -10, -4, -32, -8, -6, -10, -18, 2, -18, -3};
    private static final int $$b = 247;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long extraCommand = -4008168597886299387L;
    private static char[] validateRelationship = {55941, 56061, 56056, 55936, 55942, 56059, 56049, 55940, 56050, 55998, 56060, 56055, 55937, 56048, 56043, 55943, 56063, 55939, 56062, 55997, 56057, 55999, 55938, 55949, 56054, 56053, 56042, 56052, 55945, 55996, 55979, 55951, 55993};
    private static int warmup = -1044259988;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r5, int r6, short r7) {
        /*
            byte[] r0 = com.salesforce.marketingcloud.internal.b.$$c
            int r6 = r6 + 4
            int r5 = r5 + 66
            int r7 = r7 * 4
            int r1 = 1 - r7
            byte[] r1 = new byte[r1]
            r2 = 0
            int r7 = 0 - r7
            if (r0 != 0) goto L14
            r4 = r7
            r3 = r2
            goto L26
        L14:
            r3 = r2
        L15:
            byte r4 = (byte) r5
            r1[r3] = r4
            if (r3 != r7) goto L20
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L20:
            int r3 = r3 + 1
            int r6 = r6 + 1
            r4 = r0[r6]
        L26:
            int r5 = r5 + r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.internal.b.$$e(byte, int, short):java.lang.String");
    }

    public static final <R> R a(@NotNull Inflater inflater, @NotNull Function1<? super Inflater, ? extends R> block) {
        Intrinsics.checkNotNullParameter(inflater, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke(inflater);
        } finally {
            InlineMarker.finallyStart(1);
            inflater.end();
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = 115 - r6
            int r0 = r7 + 2
            byte[] r1 = com.salesforce.marketingcloud.internal.b.$$a
            int r8 = 51 - r8
            byte[] r0 = new byte[r0]
            int r7 = r7 + 1
            r2 = 0
            if (r1 != 0) goto L12
            r3 = r8
            r4 = r2
            goto L29
        L12:
            r3 = r2
        L13:
            byte r4 = (byte) r6
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L22:
            int r8 = r8 + 1
            r3 = r1[r8]
            r5 = r3
            r3 = r8
            r8 = r5
        L29:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-5)
            r8 = r3
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.internal.b.c(short, byte, short, java.lang.Object[]):void");
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        int i3 = $10 + 47;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (asbinder.d < cArr.length) {
            int i5 = asbinder.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) (-1);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - View.MeasureSpec.getMode(0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), TextUtils.indexOf((CharSequence) "", '0') + 1408, 1035473698, false, $$e((byte) 52, b, (byte) (b + 1)), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i5] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr3 = {asbinder, asbinder};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame2 == null) {
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (Process.myPid() >> 22), 249 - Color.green(0), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i6 = $11 + 17;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            Object[] objArr4 = {asbinder, asbinder};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getFadingEdgeLength() >> 16) + 8, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), Color.green(0) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
        }
        objArr[0] = new String(cArr2);
    }

    private static void d(char[] cArr, byte[] bArr, int i, int[] iArr, Object[] objArr) throws Throwable {
        int length;
        char[] cArr2;
        int i2 = 2;
        int i3 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr3 = validateRelationship;
        int i4 = 1;
        int i5 = 0;
        if (cArr3 != null) {
            int i6 = $11 + 39;
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
                int i8 = $11 + 107;
                $10 = i8 % 128;
                int i9 = i8 % i2;
                try {
                    Object[] objArr2 = new Object[i4];
                    objArr2[i5] = Integer.valueOf(cArr3[i7]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame == null) {
                        int iBlue = 26 - Color.blue(i5);
                        char offsetBefore = (char) TextUtils.getOffsetBefore("", i5);
                        int capsMode = TextUtils.getCapsMode("", i5, i5) + 1041;
                        byte b = (byte) (-1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iBlue, offsetBefore, capsMode, -1719489573, false, $$e((byte) 55, b, (byte) (b + 1)), new Class[]{Integer.TYPE});
                    }
                    cArr2[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i7++;
                    int i10 = $10 + 31;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                    i2 = 2;
                    i4 = 1;
                    i5 = 0;
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
            Object[] objArr3 = {Integer.valueOf(warmup)};
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
            if (objAccessartificialFrame2 == null) {
                byte b2 = (byte) 1;
                byte b3 = (byte) (-b2);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(15 - TextUtils.indexOf("", "", 0, 0), (char) (View.resolveSizeAndState(0, 0, 0) + 20488), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 2148, 216472770, false, $$e(b2, b3, (byte) (b3 + 1)), new Class[]{Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
            if (ICustomTabsServiceDefault) {
                onmessagechannelready.c = bArr.length;
                char[] cArr4 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    cArr4[onmessagechannelready.a] = (char) (cArr3[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                    Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame3 == null) {
                        byte b4 = (byte) 0;
                        byte b5 = (byte) (b4 - 1);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(21 - (ViewConfiguration.getTouchSlop() >> 8), (char) ((Process.myPid() >> 22) + 59174), View.combineMeasuredStates(0, 0) + 1943, 481771537, false, $$e(b4, b5, (byte) (b5 + 1)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    int i12 = $10 + 87;
                    $11 = i12 % 128;
                    int i13 = i12 % 2;
                }
                objArr[0] = new String(cArr4);
                return;
            }
            if (requestPostMessageChannelWithExtras) {
                onmessagechannelready.c = cArr.length;
                char[] cArr5 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    int i14 = $11 + 99;
                    $10 = i14 % 128;
                    int i15 = i14 % 2;
                    cArr5[onmessagechannelready.a] = (char) (cArr3[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame4 == null) {
                        byte b6 = (byte) 0;
                        byte b7 = (byte) (b6 - 1);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(21 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (ImageFormat.getBitsPerPixel(0) + 59175), (Process.myTid() >> 22) + 1943, 481771537, false, $$e(b6, b7, (byte) (b7 + 1)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                }
                objArr[0] = new String(cArr5);
                return;
            }
            int i16 = 0;
            onmessagechannelready.c = iArr.length;
            char[] cArr6 = new char[onmessagechannelready.c];
            while (true) {
                onmessagechannelready.a = i16;
                if (onmessagechannelready.a >= onmessagechannelready.c) {
                    objArr[0] = new String(cArr6);
                    return;
                } else {
                    cArr6[onmessagechannelready.a] = (char) (cArr3[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    i16 = onmessagechannelready.a + 1;
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

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] coroutineCreation$78cbbd35(int r56, int r57, java.lang.Object r58, int r59, boolean r60) {
        /*
            Method dump skipped, instruction units count: 18737
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.internal.b.coroutineCreation$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
    }
}
