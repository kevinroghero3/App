package com.google.crypto.tink.mac;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.util.Bytes;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o._CREATION;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MacKey extends Key {
    private static final byte[] $$c = {70, -54, 7, 50};
    private static final int $$d = 151;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {5, Ascii.FF, -27, -23, -11, -2, Ascii.FF};
    private static final int $$b = 47;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] _CREATION = {6551, 15204, 23656, 28960, 37432, 46854, 51439, 60870, 3795, 9149, 17575, 39314, 47996, 56389, 61733, 4666, 14106, 18658, 28152, 32210, 24365, 14366, 5482, 63080, 54086, 44212, 35260, 27266, 18406, 8443, 64963, 57131, 47109, 38268, 30309, 21328, 11438, 6559, 15225, 23624, 28983, 37429, 46874, 51436, 60815, 3801, 9148, 17610, 39353, 47991, 56393, 61749, 4670, 51511, 60290, 36019, 41424, 17043, 26622, 6155, 15669, 56894, 62284, 37998, 18740, 27536, 3240, 8644, 49866, 59375, 38990, 48398, 24097, 29517, 5222, 51575, 60313, 36007, 41462, 17105, 26622, 6166, 15631, 56883, 62273, 37964, 18766, 27550, 3249, 8637, 49878, 59371, 38933, 6544, 15224, 23644, 6609, 15207, 23646, 28970, 37433, 46940, 51451, 60888, 3781, 9184, 17551, 39320, 47968, 56389, 61733, 4661, 14145, 18657, 28136, 36551, 41899, 50304, 6557, 15182, 23619, 29009, 37429, 46863, 51438, 60926, 3796, 6607, 6609, 15204, 23637, 28982, 37493, 46872, 51437, 60883, 3800, 9130, 17544, 39378, 47990, 56398, 61730, 4652, 14089, 18600, 28136, 36551, 41899, 50304, 6545, 15231, 23617, 28944, 37408, 46879, 51427, 60920, 3801, 9127, 17593, 39336, 47971, 56395};
    private static long _BOUNDARY = -8695678625743750377L;

    /* JADX WARN: Code duplicated, block: B:10:0x001f  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x001f -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x001f
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r6, byte r7, byte r8) {
        /*
            byte[] r0 = com.google.crypto.tink.mac.MacKey.$$c
            int r7 = r7 * 2
            int r1 = r7 + 1
            int r6 = 106 - r6
            int r8 = r8 + 4
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r7
            r6 = r8
            r3 = r2
            goto L28
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L1f
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L1f:
            int r3 = r3 + 1
            int r8 = r8 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r5
        L28:
            int r8 = r8 + r4
            r5 = r8
            r8 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.mac.MacKey.$$e(byte, byte, byte):java.lang.String");
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
    private static void b(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 4
            int r7 = 4 - r7
            int r8 = r8 * 4
            int r8 = 109 - r8
            int r6 = r6 * 4
            int r0 = r6 + 4
            byte[] r1 = com.google.crypto.tink.mac.MacKey.$$a
            byte[] r0 = new byte[r0]
            int r6 = r6 + 3
            r2 = 0
            if (r1 != 0) goto L19
            r3 = r8
            r4 = r2
            r8 = r7
            goto L2f
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r8
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r1[r7]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r5
        L2f:
            int r7 = -r7
            int r3 = r3 + r7
            int r7 = r8 + 1
            int r8 = r3 + (-3)
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.mac.MacKey.b(int, int, short, java.lang.Object[]):void");
    }

    public abstract Bytes getOutputPrefix();

    @Override // com.google.crypto.tink.Key
    public abstract MacParameters getParameters();

    private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i4 = $11 + b.f40o;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            int i6 = _creation.b;
            try {
                Object[] objArr2 = {Integer.valueOf(_CREATION[i + i6])};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                if (objAccessartificialFrame == null) {
                    int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 8;
                    char threadPriority = (char) (9279 - ((Process.getThreadPriority(0) + 20) >> 6));
                    int windowTouchSlop = 1977 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                    byte b = (byte) ($$d & 10);
                    byte b2 = (byte) (b - 2);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, threadPriority, windowTouchSlop, 1113883676, false, $$e(b, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE});
                }
                try {
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (49363 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 685 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), -115095555, false, $$e(b3, b4, (byte) (b4 - 1)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i6] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    try {
                        Object[] objArr4 = {_creation, _creation};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame3 == null) {
                            int tapTimeout = 25 - (ViewConfiguration.getTapTimeout() >> 16);
                            char cMyTid = (char) (30068 - (Process.myTid() >> 22));
                            int i7 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 815;
                            byte b5 = (byte) ($$d & 11);
                            byte b6 = (byte) (b5 - 3);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(tapTimeout, cMyTid, i7, 1897803493, false, $$e(b5, b6, (byte) (b6 - 1)), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
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
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        char[] cArr = new char[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i8 = $11 + 69;
            $10 = i8 % 128;
            if (i8 % 2 != 0) {
                cArr[_creation.b] = (char) jArr[_creation.b];
                try {
                    Object[] objArr5 = {_creation, _creation};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame4 == null) {
                        int i9 = 26 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        char cLastIndexOf = (char) (30067 - TextUtils.lastIndexOf("", '0', 0));
                        int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 816;
                        byte b7 = (byte) ($$d & 11);
                        byte b8 = (byte) (b7 - 3);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i9, cLastIndexOf, fadingEdgeLength, 1897803493, false, $$e(b7, b8, (byte) (b8 - 1)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    int i10 = 11 / 0;
                } catch (Throwable th4) {
                    Throwable cause4 = th4.getCause();
                    if (cause4 == null) {
                        throw th4;
                    }
                    throw cause4;
                }
            } else {
                cArr[_creation.b] = (char) jArr[_creation.b];
                Object[] objArr6 = {_creation, _creation};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame5 == null) {
                    int i11 = 25 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    char cRed = (char) (30068 - Color.red(0));
                    int iResolveSizeAndState = 816 - View.resolveSizeAndState(0, 0, 0);
                    byte b9 = (byte) ($$d & 11);
                    byte b10 = (byte) (b9 - 3);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i11, cRed, iResolveSizeAndState, 1897803493, false, $$e(b9, b10, (byte) (b10 - 1)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            }
        }
        objArr[0] = new String(cArr);
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] coroutineCreation(int r25, int r26) {
        /*
            Method dump skipped, instruction units count: 3399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.mac.MacKey.coroutineCreation(int, int):java.lang.Object[]");
    }
}
