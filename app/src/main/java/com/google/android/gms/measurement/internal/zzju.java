package com.google.android.gms.measurement.internal;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.app.AppCompatDelegate;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.onNavigationEvent;
import o.onPostMessage;

/* JADX INFO: loaded from: classes5.dex */
public final class zzju implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzja zze;
    private static final byte[] $$c = {96, -63, 33, 4};
    private static final int $$d = 157;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {110, 48, -111, -89, -12, -6, Ascii.ESC, -22, -26, 4, -12, 0, -8, -2, -8};
    private static final int $$b = AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int setDefaultImpl = -260893999;
    private static char[] IPostMessageService = {38358, 38285, 38355, 38357, 38381, 38278, 38386, 38357, 38353, 38347, 38382, 38392, 38356, 38356, 38362, 38388, 38179, 38174, 38173, 38187, 38184, 38175, 38198, 38199, 38184, 38178, 38174, 38179, 38181, 38199, 38283, 38353, 38345, 38380, 38275, 38375, 38352, 38361, 38364, 38350, 38351, 38356, 38360, 38362, 38356, 38356, 38392, 38383, 38355, 38363, 38355, 38348, 38285, 38363, 38365, 38274, 38341, 38207, 38343, 38349, 38336, 38338, 38278, 38355, 38363, 38358, 38382, 38284, 38282, 38379, 38382, 38391, 38181, 38174, 38180, 38179, 38171, 38206, 38337, 38176, 38183, 38189, 38345, 38360, 38349, 38348, 38203, 38184, 38194, 38201, 38184, 38184, 38186, 38184, 38181, 38181, 38182, 38191, 38192, 38183, 38189, 38187, 38188, 38182, 38182, 38346, 38337, 38181, 38364, 38147, 38155, 38151, 38149, 38262, 38253, 38302, 38395, 38192, 38215, 38238, 38210, 38059, 38070, 38210, 38069, 38061, 38078, 38212, 38065, 38065, 38063, 38065, 38064, 38057, 38058, 38060, 38069, 38063, 38063, 38227, 38218, 38062, 38070, 38062, 38055, 38061, 38060, 38284, 38361, 38355, 38372, 38379, 38356, 38348, 38353, 38360, 38360, 38361, 38365, 38357, 38355, 38379, 38378, 38363, 38362, 38356, 38278, 38355, 38363, 38355, 38348, 38354, 38353, 38345, 38380, 38391, 38363, 38356, 38348, 38382, 38279, 38379, 38356, 38348, 38353, 38360, 38360, 38361, 38365, 38357, 38355, 38378, 38380, 38365, 38356, 38350, 38351, 38346, 38350, 38362, 38356, 38356, 38392, 38285, 38363, 38358, 38358, 38359, 38374, 38371, 38355, 38361, 38362, 38274, 38205, 38207, 38343, 38339, 38338, 38338, 38203, 38198, 38206, 38357, 38357, 38205, 38207, 38336, 38206, 38336, 38336, 38339, 38346, 38231, 38230, 38230, 38228, 38228, 38231, 38231, 38229, 38229, 38231, 38231, 38231, 38229, 38229, 38229, 38225, 38227, 38230, 38230, 38231, 38231, 38231, 38226, 38287, 38365, 38361, 38360, 38360, 38353, 38348, 38356, 38379, 38273, 38283, 38285, 38393, 38396, 38382, 38348, 38356, 38363, 38391, 38380, 38345, 38353, 38354, 38348, 38355, 38363, 38355, 38383, 38392, 38356, 38356, 38362, 38360, 38355, 38383, 38179, 38173, 38173, 38337, 38202, 38173, 38172, 38202, 38352, 38189, 38171, 38178, 38179, 38173, 38281, 38357, 38356, 38356, 38353, 38277, 38355, 38361, 38313, 38347, 38237, 38242, 38244, 38241, 38241, 38257, 38255, 38242, 38244, 38242, 38241, 38246, 38256, 38246, 38236, 38242, 38287, 38360, 38358, 38356, 38351, 38355, 38361, 38390, 38391, 38358, 38353, 38350, 38355, 38358, 38350, 38382, 38384, 38353, 38386, 38272, 38375, 38365, 38360, 38361, 38363, 38361, 38374, 38376, 38360, 38360, 38363, 38361, 38356, 38201, 38072, 38212, 38280, 38357, 38357, 38372, 38376, 38361, 38363, 38361, 38360, 38365, 38375, 38272, 38386, 38353, 38384, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38386, 38188, 38189, 38181, 38180, 38190, 38193, 38190, 38192, 38186, 38282, 38362, 38356, 38356, 38392, 38383, 38355, 38363, 38355, 38348, 38354, 38353, 38345, 38380, 38274, 38374, 38355, 38348, 38357, 38363, 38361, 38379, 38377, 38359, 38361, 38355, 38348, 38287, 38360, 38358, 38356, 38351, 38355, 38361, 38390, 38391, 38358, 38353, 38350, 38355, 38358, 38350, 38382, 38384, 38353, 38386, 38399, 38369, 38359, 38357, 38360, 38357, 38347, 38348, 38356, 38302, 38375, 38350, 38345, 38354, 38358, 38349, 38374, 38380, 38355, 38345, 38394, 38197, 38204, 38338, 38336, 38338, 38207, 38067, 38045, 38045};

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r7, short r8, int r9) {
        /*
            byte[] r0 = com.google.android.gms.measurement.internal.zzju.$$c
            int r8 = r8 * 2
            int r8 = r8 + 4
            int r9 = r9 * 2
            int r9 = r9 + 1
            int r7 = r7 + 65
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r8
            r8 = r9
            r5 = r2
            goto L29
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L23:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r6
        L29:
            int r3 = r3 + 1
            int r7 = -r7
            int r7 = r7 + r8
            r8 = r3
            r3 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzju.$$e(int, short, int):java.lang.String");
    }

    zzju(zzja zzjaVar, String str, String str2, Object obj, long j) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = j;
        this.zze = zzjaVar;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 112
            int r9 = r9 * 8
            int r9 = r9 + 4
            byte[] r0 = com.google.android.gms.measurement.internal.zzju.$$a
            int r7 = r7 * 5
            int r7 = r7 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r9
            r5 = r2
            goto L2b
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r9]
            r6 = r3
            r3 = r8
            r8 = r6
        L2b:
            int r9 = r9 + 1
            int r8 = -r8
            int r3 = r3 + r8
            int r8 = r3 + (-7)
            r3 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzju.b(int, byte, short, java.lang.Object[]):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0178  */
    /* JADX WARN: Code duplicated, block: B:33:0x0179  */
    private static void a(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) throws Throwable {
        int i4;
        Throwable cause;
        int i5 = 2 % 2;
        onNavigationEvent onnavigationevent = new onNavigationEvent();
        char[] cArr2 = new char[i3];
        onnavigationevent.d = 0;
        while (true) {
            i4 = -1257606387;
            if (onnavigationevent.d >= i3) {
                break;
            }
            int i6 = $10 + 7;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            onnavigationevent.c = cArr[onnavigationevent.d];
            cArr2[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
            int i8 = onnavigationevent.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr2[i8]), Integer.valueOf(setDefaultImpl)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(MotionEvent.axisFromString("") + 23, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1775, -2069783171, false, $$e((byte) 49, b, b), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr2[i8] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame2 == null) {
                    byte b2 = (byte) 0;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(37 - Color.alpha(0), (char) (56277 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 1258, 711931141, false, $$e((byte) 51, b2, b2), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
            } catch (Throwable th) {
                cause = th.getCause();
                if (cause != null) {
                    throw th;
                }
                throw cause;
            }
            cause = th.getCause();
            if (cause != null) {
                throw th;
            }
            throw cause;
        }
        if (i > 0) {
            int i9 = $11 + 125;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            onnavigationevent.b = i;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - onnavigationevent.b, onnavigationevent.b);
            System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i3 - onnavigationevent.b);
        }
        if (z) {
            int i11 = $10 + 57;
            $11 = i11 % 128;
            int i12 = i11 % 2;
            char[] cArr4 = new char[i3];
            onnavigationevent.d = 0;
            while (onnavigationevent.d < i3) {
                cArr4[onnavigationevent.d] = cArr2[(i3 - onnavigationevent.d) - 1];
                Object[] objArr4 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(i4);
                if (objAccessartificialFrame3 == null) {
                    byte b3 = (byte) 0;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(37 - TextUtils.getOffsetBefore("", 0), (char) (56277 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), 1258 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 711931141, false, $$e((byte) 51, b3, b3), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                i4 = -1257606387;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }

    private static void c(boolean z, byte[] bArr, int[] iArr, Object[] objArr) throws Throwable {
        int i;
        int i2 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i3 = 0;
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = iArr[2];
        int i7 = iArr[3];
        char[] cArr = IPostMessageService;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i8 = 0;
            while (i8 < length) {
                int i9 = $10 + 27;
                $11 = i9 % 128;
                if (i9 % 2 == 0) {
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i3] = Integer.valueOf(cArr[i8]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i3;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) Color.alpha(i3), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1562, 178318710, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        cArr2[i8] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    Object[] objArr3 = {Integer.valueOf(cArr[i8])};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1782207618);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 11, (char) (ViewConfiguration.getFadingEdgeLength() >> 16), 1562 - (ViewConfiguration.getEdgeSlop() >> 16), 178318710, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE});
                    }
                    cArr2[i8] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i8++;
                }
                i3 = 0;
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i5];
        System.arraycopy(cArr, i4, cArr3, 0, i5);
        if (bArr != null) {
            char[] cArr4 = new char[i5];
            onpostmessage.a = 0;
            char c = 0;
            while (onpostmessage.a < i5) {
                if (bArr[onpostmessage.a] == 1) {
                    int i10 = $10 + 67;
                    $11 = i10 % 128;
                    if (i10 % 2 == 0) {
                        int i11 = onpostmessage.a;
                        Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                        if (objAccessartificialFrame3 == null) {
                            int iIndexOf = TextUtils.indexOf("", "", 0, 0) + 23;
                            char c2 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                            int iMyPid = 2441 - (Process.myPid() >> 22);
                            byte b5 = (byte) ($$c[3] - 1);
                            byte b6 = (byte) (b5 - 3);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf, c2, iMyPid, -850656813, false, $$e(b5, b6, b6), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr4[i11] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                        int i12 = 71 / 0;
                    } else {
                        int i13 = onpostmessage.a;
                        Object[] objArr5 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1378437083);
                        if (objAccessartificialFrame4 == null) {
                            int i14 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 22;
                            char cIndexOf = (char) TextUtils.indexOf("", "", 0, 0);
                            int maximumFlingVelocity = 2441 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                            byte b7 = (byte) ($$c[3] - 1);
                            byte b8 = (byte) (b7 - 3);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i14, cIndexOf, maximumFlingVelocity, -850656813, false, $$e(b7, b8, b8), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr4[i13] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                    }
                } else {
                    int i15 = onpostmessage.a;
                    Object[] objArr6 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame5 == null) {
                        byte b9 = (byte) 0;
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(11 - Color.green(0), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), Color.blue(0) + 1562, 1918398056, false, $$e((byte) 57, b9, b9), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i15] = ((Character) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).charValue();
                }
                c = cArr4[onpostmessage.a];
                Object[] objArr7 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame6 == null) {
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 21, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 29362), (Process.myPid() >> 22) + JfifUtil.MARKER_RST7, -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame6).invoke(null, objArr7);
            }
            cArr3 = cArr4;
        }
        if (i7 > 0) {
            int i16 = $11 + 27;
            $10 = i16 % 128;
            int i17 = i16 % 2;
            char[] cArr5 = new char[i5];
            i = 0;
            System.arraycopy(cArr3, 0, cArr5, 0, i5);
            int i18 = i5 - i7;
            System.arraycopy(cArr5, 0, cArr3, i18, i7);
            System.arraycopy(cArr5, i7, cArr3, 0, i18);
        } else {
            i = 0;
        }
        if (z) {
            char[] cArr6 = new char[i5];
            while (true) {
                onpostmessage.a = i;
                if (onpostmessage.a >= i5) {
                    break;
                }
                cArr6[onpostmessage.a] = cArr3[(i5 - onpostmessage.a) - 1];
                i = onpostmessage.a + 1;
            }
            cArr3 = cArr6;
        }
        if (i6 > 0) {
            int i19 = 0;
            while (true) {
                onpostmessage.a = i19;
                if (onpostmessage.a >= i5) {
                    break;
                }
                cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                i19 = onpostmessage.a + 1;
            }
        }
        objArr[0] = new String(cArr3);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 158501. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static java.lang.Object[] accessartificialFrame(android.content.Context r53, java.lang.String[] r54, int r55, int r56, int r57) {
        /*
            Method dump skipped, instruction units count: 15850
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzju.accessartificialFrame(android.content.Context, java.lang.String[], int, int, int):java.lang.Object[]");
    }
}
