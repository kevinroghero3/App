package com.reactnativecommunity.netinfo;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;
import o.onRelationshipValidationResult;

/* JADX INFO: renamed from: com.reactnativecommunity.netinfo.AmazonFireDeviceConnectivityPoller-IA, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class AmazonFireDeviceConnectivityPollerIA {
    private static final byte[] $$a = {104, 119, -28, 53};
    private static final int $$b = 132;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] validateRelationship = {56106, 56115, 56102, 56100, 56302, 56097, 56119, 56113, 56103, 56098, 56107, 56096, 56091, 56116, 56295, 56300, 56260, 56268, 56110, 56108, 56104, 56273, 56270, 56287, 56275, 56112, 56109, 56316, 56272, 56114, 56117, 56296, 56269, 56263, 56257, 56105, 56267, 56118, 56278, 56111, 56283};
    private static int warmup = -1044259940;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;
    private static long onPostMessage = -3302409174881988127L;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(byte r6, short r7, byte r8) {
        /*
            byte[] r0 = com.reactnativecommunity.netinfo.AmazonFireDeviceConnectivityPollerIA.$$a
            int r6 = r6 * 4
            int r6 = 3 - r6
            int r8 = r8 * 3
            int r8 = 1 - r8
            int r7 = 121 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r8
            r5 = r2
            goto L26
        L14:
            r3 = r2
        L15:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L24:
            r3 = r0[r6]
        L26:
            int r3 = -r3
            int r7 = r7 + r3
            r3 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.netinfo.AmazonFireDeviceConnectivityPollerIA.$$c(byte, short, byte):java.lang.String");
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            int i3 = $11 + 115;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i5 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(28 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0') + 30691), 188 - TextUtils.getTrimmedLength(""), -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                try {
                    Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                    if (objAccessartificialFrame2 == null) {
                        byte b = (byte) 0;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(32 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), (ViewConfiguration.getScrollBarSize() >> 8) + 1483, -1940971975, false, $$c(b, (byte) (b | 10), b), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        String str = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
        int i6 = $10 + 77;
        $11 = i6 % 128;
        int i7 = i6 % 2;
        objArr[0] = str;
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr2 = validateRelationship;
        long j = 0;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i5 = 0;
            while (i5 < length) {
                int i6 = $10 + 89;
                $11 = i6 % 128;
                int i7 = i6 % i3;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i5])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(27 - (SystemClock.elapsedRealtimeNanos() > j ? 1 : (SystemClock.elapsedRealtimeNanos() == j ? 0 : -1)), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1))), 1041 - Color.alpha(0), -1719489573, false, $$c(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    cArr3[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i5++;
                    i3 = 2;
                    j = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr2 = cArr3;
        }
        Object[] objArr3 = {Integer.valueOf(warmup)};
        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
        if (objAccessartificialFrame2 == null) {
            byte b3 = (byte) 0;
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(14 - ImageFormat.getBitsPerPixel(0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 20487), TextUtils.lastIndexOf("", '0', 0, 0) + 2149, 216472770, false, $$c(b3, (byte) (b3 | 54), b3), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
        int i8 = 59174;
        if (ICustomTabsServiceDefault) {
            onmessagechannelready.c = bArr.length;
            char[] cArr4 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                int i9 = $10 + 57;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                if (objAccessartificialFrame3 == null) {
                    byte b4 = (byte) 0;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarSize() >> 8) + 21, (char) (59174 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), (ViewConfiguration.getScrollBarSize() >> 8) + 1943, 481771537, false, $$c(b4, (byte) (b4 | 55), b4), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            }
            objArr[0] = new String(cArr4);
            return;
        }
        if (!requestPostMessageChannelWithExtras) {
            onmessagechannelready.c = iArr.length;
            char[] cArr5 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                int i11 = $10 + 73;
                $11 = i11 % 128;
                if (i11 % 2 == 0) {
                    cArr5[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c >> 1) / onmessagechannelready.a] * i] + iIntValue);
                    i2 = onmessagechannelready.a >> 1;
                } else {
                    cArr5[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    i2 = onmessagechannelready.a + 1;
                }
                onmessagechannelready.a = i2;
            }
            String str = new String(cArr5);
            int i12 = $10 + 3;
            $11 = i12 % 128;
            if (i12 % 2 != 0) {
                objArr[0] = str;
                return;
            } else {
                int i13 = 93 / 0;
                objArr[0] = str;
                return;
            }
        }
        onmessagechannelready.c = cArr.length;
        char[] cArr6 = new char[onmessagechannelready.c];
        onmessagechannelready.a = 0;
        while (onmessagechannelready.a < onmessagechannelready.c) {
            int i14 = $10 + 31;
            $11 = i14 % 128;
            if (i14 % 2 == 0) {
                cArr6[onmessagechannelready.a] = (char) (cArr2[cArr[onmessagechannelready.c * onmessagechannelready.a] / i] - iIntValue);
                Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                if (objAccessartificialFrame4 == null) {
                    byte b5 = (byte) 0;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTapTimeout() >> 16) + 21, (char) (i8 - (KeyEvent.getMaxKeyCode() >> 16)), TextUtils.indexOf("", "", 0) + 1943, 481771537, false, $$c(b5, (byte) (b5 | 55), b5), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            } else {
                cArr6[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                if (objAccessartificialFrame5 == null) {
                    byte b6 = (byte) 0;
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(21 - (Process.myPid() >> 22), (char) (ImageFormat.getBitsPerPixel(0) + 59175), ExpandableListView.getPackedPositionType(0L) + 1943, 481771537, false, $$c(b6, (byte) (b6 | 55), b6), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            }
            i8 = 59174;
        }
        String str2 = new String(cArr6);
        int i15 = $10 + 79;
        $11 = i15 % 128;
        int i16 = i15 % 2;
        objArr[0] = str2;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] accessartificialFrame(android.content.Context r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 3033
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.netinfo.AmazonFireDeviceConnectivityPollerIA.accessartificialFrame(android.content.Context, int, int):java.lang.Object[]");
    }
}
