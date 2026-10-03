package com.google.android.gms.dynamite;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.asBinder;
import o.onPostMessage;

/* JADX INFO: loaded from: classes2.dex */
public final class zza extends Thread {
    private static final byte[] $$c = {7, 40, -110, -80};
    private static final int $$d = 164;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {Ascii.DC4, 17, 111, Ascii.ESC, 10, 4, 50, Ascii.SO, 3, Ascii.DC4, Ascii.SYN, -3, 8, 1, -6, Ascii.GS, 32, 8, 6, 36, 8, 3, 10, Ascii.DC2, 0, -8, Ascii.DC4, Ascii.ESC, Ascii.SYN, -16, -2, Ascii.DC2, 3, Ascii.DLE, 5, -9, 5, Ascii.VT, -49, -5, Ascii.SYN, -16, 1, 10, 2, 5, -50, -9, Ascii.SO, -5, Ascii.US, 5, Ascii.DLE, 8, 5};
    private static final int $$b = 92;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] IPostMessageService = {38276, 38354, 38356, 38358, 38363, 38388, 38385, 38351, 38356, 38356, 38358, 38278, 38358, 38360, 38359, 38362, 38353, 38337, 38217, 38217, 38209, 38208, 38217, 38226, 38225, 38215, 38211, 38221, 38221, 38247, 38243, 38217, 38216, 38216, 38219, 38212, 38211, 38245, 38246, 38212, 38272, 38343, 38343, 38207, 38206, 38343, 38352, 38351, 38341, 38337, 38347, 38347, 38373, 38373, 38345, 38342, 38207, 38204, 38204, 38370, 38369, 38343, 38342, 38342, 38345, 38338, 38337, 38371, 38372, 38338, 38278, 38345, 38352, 38359, 38362, 38367, 38364, 38365, 38285, 38356, 38356, 38363, 38359, 38350, 38347, 38284, 38362, 38364, 38357, 38355, 38356, 38347, 38354, 38356, 38286, 38360, 38357, 38358, 38361, 38359, 38280, 38354, 38351, 38348, 38358, 38357, 38348, 38383, 38382, 38348, 38353, 38353, 38349, 38356, 38357, 38356, 38286, 38357, 38383, 38390, 38362, 38363, 38357, 38354, 38356, 38354, 38188, 38033, 38034, 38041, 38037, 38033, 38032, 38036, 38041, 38035, 38029, 38028, 38283, 38354, 38350, 38359, 38360, 38349, 38348, 38310, 38387, 38355, 38353, 38357, 38353, 38349, 38282, 38360, 38358, 38354, 38362, 38364, 38353, 38353, 38351, 38356, 38358, 38348, 38358, 38357, 38348, 38348, 38350, 38358, 38361, 38363, 38197, 38195, 38196, 38338, 38340, 38342, 38277, 38347, 38287, 38358, 38348, 38353, 38353, 38357, 38359, 38357, 38363, 38308, 38384, 38353, 38357, 38359, 38357, 38363, 38365, 38358, 38348, 38277, 38348, 38358, 38365, 38363, 38356, 38351, 38349, 38347, 38355, 38386, 38191, 38049, 38056, 38059, 38051, 38049, 38044, 38042, 38043, 38042, 38050, 38280, 38357, 38357, 38356, 38363, 38364, 38361, 38356, 38359, 38366, 38358, 38356, 38351, 38349, 38350, 38193, 38054, 38056, 38061, 38062, 38050, 38047, 38060, 38068, 38060, 38058, 38053, 38051, 38052, 38312, 38382, 38345, 38345, 38382, 38389, 38355, 38382, 38382, 38355, 38359, 38357, 38356, 38350, 38345, 38380, 38389, 38358, 38357, 38357, 38351, 38357, 38363, 38276, 38381, 38390, 38363, 38312, 38385, 38358, 38355, 38348, 38345, 38345, 38382, 38385, 38356, 38362, 38280, 38356, 38362, 38357, 38382, 38385, 38358, 38355, 38348, 38345, 38345, 38382, 38379, 38173, 38173, 38173, 38169, 38196, 38200, 38171, 38177, 38206, 38198, 38355, 38249, 38255, 38250, 38147, 38353, 38245, 38245, 38245, 38242, 38271, 38144, 38236, 38244, 38152, 38144, 38236, 38246, 38255, 38254, 38253, 38247, 38242, 38067, 38060, 38065, 38060, 38060, 38053, 38056, 38280, 38193, 38164, 38170, 38199, 38194, 38169, 38173, 38166, 38162, 38194, 38199, 38165, 38165, 38173, 38198, 38388, 38153, 38252, 38258, 38253, 38150, 38312, 38382, 38345, 38345, 38348, 38355, 38358, 38385, 38391, 38362, 38356, 38385, 38289, 38390, 38353, 38345, 38382, 38277, 38348, 38345, 38345, 38382, 38288, 38389, 38362, 38364, 38357, 38352, 38357, 38362, 38364, 38389, 38385, 38356, 38362, 38391, 38385, 38358, 38276, 38186, 38157, 38163, 38155, 38181, 38191, 38157, 38183, 38186, 38159, 38156, 38149, 38146, 38146, 38183, 38204, 38073, 38235, 38232, 38077, 38242, 38238, 38210, 38214, 38215, 38243, 38236, 38075, 38076, 38074, 38234, 38268, 38234, 38069, 38069, 38072, 38079, 38210, 38237, 38233, 38277, 38348, 38345, 38345, 38382, 38288, 38385, 38356, 38362, 38354, 38380, 38385, 38358, 38278, 38347, 38381, 38288, 38385, 38356, 38362, 38391, 38383, 38312, 38384, 38350, 38351, 38358, 38390, 38382, 38355, 38359, 38358, 38389, 38385, 38353, 38349, 38350, 38350, 38348, 38385, 38157, 38159, 38158, 38151, 38175, 38312, 38390, 38358, 38351, 38350, 38384, 38191, 38209, 38212, 38052, 38048, 38049, 38049, 38282, 38352, 38353, 38359, 38351, 38342, 38379, 38381, 38354, 38363, 38390};
    private static long extraCommand = -1225265349416233536L;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r5, byte r6, short r7) {
        /*
            byte[] r0 = com.google.android.gms.dynamite.zza.$$c
            int r7 = r7 + 4
            int r5 = r5 + 65
            int r6 = r6 * 3
            int r1 = 1 - r6
            byte[] r1 = new byte[r1]
            r2 = 0
            int r6 = 0 - r6
            if (r0 != 0) goto L15
            r4 = r5
            r5 = r6
            r3 = r2
            goto L27
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r5
            r1[r3] = r4
            int r7 = r7 + 1
            if (r3 != r6) goto L23
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L23:
            r4 = r0[r7]
            int r3 = r3 + 1
        L27:
            int r5 = r5 + r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.zza.$$e(int, byte, short):java.lang.String");
    }

    zza(ThreadGroup threadGroup, String str) {
        super(threadGroup, "GmsDynamite");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = 52 - r6
            int r8 = 115 - r8
            byte[] r0 = com.google.android.gms.dynamite.zza.$$a
            int r1 = r7 + 2
            byte[] r1 = new byte[r1]
            int r7 = r7 + 1
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r8
            r3 = r2
            r8 = r6
            goto L2a
        L13:
            r3 = r2
        L14:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            r4 = r0[r6]
            int r3 = r3 + 1
            r5 = r8
            r8 = r6
            r6 = r5
        L2a:
            int r6 = r6 + r4
            int r6 = r6 + (-5)
            r5 = r8
            r8 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.zza.a(short, byte, int, java.lang.Object[]):void");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(19);
        synchronized (this) {
            while (true) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }

    private static void c(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i4 = $11 + 63;
            $10 = i4 % 128;
            int i5 = i4 % i2;
            int i6 = asbinder.d;
            char c = cArr[asbinder.d];
            try {
                Object[] objArr2 = new Object[3];
                objArr2[i2] = asbinder;
                objArr2[1] = asbinder;
                objArr2[0] = Integer.valueOf(c);
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - KeyEvent.normalizeMetaState(0), (char) (ViewConfiguration.getScrollBarSize() >> 8), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 1406, 1035473698, false, $$e((byte) 53, b, (byte) (b - 1)), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i6] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr3 = {asbinder, asbinder};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame2 == null) {
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 9, (char) Color.argb(0, 0, 0, 0), 249 - TextUtils.indexOf("", "", 0, 0), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                i2 = 2;
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
            int i7 = $11 + 5;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            Object[] objArr4 = {asbinder, asbinder};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(8 - View.resolveSize(0, 0), (char) KeyEvent.normalizeMetaState(0), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
        }
        objArr[0] = new String(cArr2);
    }

    private static void b(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
        int i;
        int i2 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i3 = 0;
        int i4 = iArr[0];
        int i5 = 1;
        int i6 = iArr[1];
        int i7 = iArr[2];
        int i8 = iArr[3];
        char[] cArr = IPostMessageService;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i9 = 0;
            while (i9 < length) {
                try {
                    Object[] objArr2 = new Object[i5];
                    objArr2[i3] = Integer.valueOf(cArr[i9]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i3;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(10 - MotionEvent.axisFromString(""), (char) View.MeasureSpec.makeMeasureSpec(i3, i3), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1562, 178318710, false, $$e(b, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE});
                    }
                    cArr2[i9] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i9++;
                    i3 = 0;
                    i5 = 1;
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
        char[] cArr3 = new char[i6];
        System.arraycopy(cArr, i4, cArr3, 0, i6);
        if (bArr != null) {
            char[] cArr4 = new char[i6];
            onpostmessage.a = 0;
            char c = 0;
            while (onpostmessage.a < i6) {
                int i10 = $10 + 63;
                $11 = i10 % 128;
                int i11 = i10 % 2;
                if (bArr[onpostmessage.a] == 1) {
                    int i12 = $11 + 15;
                    $10 = i12 % 128;
                    if (i12 % 2 != 0) {
                        int i13 = onpostmessage.a;
                        Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 3;
                            byte b4 = (byte) (b3 - 3);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(23 - TextUtils.indexOf("", "", 0), (char) (ViewConfiguration.getEdgeSlop() >> 16), 2441 - (ViewConfiguration.getFadingEdgeLength() >> 16), -850656813, false, $$e(b3, b4, (byte) (b4 - 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr4[i13] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        int i14 = 57 / 0;
                    } else {
                        int i15 = onpostmessage.a;
                        try {
                            Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                            if (objAccessartificialFrame3 == null) {
                                byte b5 = (byte) 3;
                                byte b6 = (byte) (b5 - 3);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Process.getGidForName("") + 24, (char) Color.green(0), 2440 - ExpandableListView.getPackedPositionChild(0L), -850656813, false, $$e(b5, b6, (byte) (b6 - 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            cArr4[i15] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    }
                } else {
                    int i16 = onpostmessage.a;
                    Object[] objArr5 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(Color.alpha(0) + 11, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), 1562 - (ViewConfiguration.getScrollBarSize() >> 8), 1918398056, false, $$e((byte) 57, b7, (byte) (b7 - 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i16] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                }
                c = cArr4[onpostmessage.a];
                Object[] objArr6 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(22 - View.combineMeasuredStates(0, 0), (char) (29362 - TextUtils.lastIndexOf("", '0', 0)), (ViewConfiguration.getPressedStateDuration() >> 16) + JfifUtil.MARKER_RST7, -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            }
            cArr3 = cArr4;
        }
        if (i8 > 0) {
            char[] cArr5 = new char[i6];
            i = 0;
            System.arraycopy(cArr3, 0, cArr5, 0, i6);
            int i17 = i6 - i8;
            System.arraycopy(cArr5, 0, cArr3, i17, i8);
            System.arraycopy(cArr5, i8, cArr3, 0, i17);
        } else {
            i = 0;
        }
        if (z) {
            char[] cArr6 = new char[i6];
            while (true) {
                onpostmessage.a = i;
                if (onpostmessage.a >= i6) {
                    break;
                }
                int i18 = $11 + 67;
                $10 = i18 % 128;
                if (i18 % 2 != 0) {
                    cArr6[onpostmessage.a] = cArr3[i6 / onpostmessage.a];
                    i = onpostmessage.a;
                } else {
                    cArr6[onpostmessage.a] = cArr3[(i6 - onpostmessage.a) - 1];
                    i = onpostmessage.a + 1;
                }
            }
            cArr3 = cArr6;
        }
        if (i7 > 0) {
            int i19 = $10 + 45;
            $11 = i19 % 128;
            int i20 = i19 % 2;
            loop3: while (true) {
                int i21 = 0;
                while (true) {
                    onpostmessage.a = i21;
                    if (onpostmessage.a >= i6) {
                        break loop3;
                    }
                    int i22 = $11 + 3;
                    $10 = i22 % 128;
                    if (i22 % 2 != 0) {
                        break;
                    }
                    cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                    i21 = onpostmessage.a + 1;
                }
                cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] >>> iArr[3]);
                int i23 = onpostmessage.a;
            }
        }
        objArr[0] = new String(cArr3);
    }

    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 6662 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v733 */
    /* JADX WARN: Type inference failed for: r2v757 */
    /* JADX WARN: Type inference failed for: r2v758 */
    /* JADX WARN: Type inference failed for: r2v791 */
    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] accessartificialFrame$78cbbd35(int r54, int r55, java.lang.Object r56, int r57, boolean r58) {
        /*
            Method dump skipped, instruction units count: 17912
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.zza.accessartificialFrame$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
    }
}
