package com.google.android.gms.stats;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.core.view.ViewCompat;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.asBinder;
import o.onPostMessage;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ WakeLock zza;
    private static final byte[] $$c = {96, -63, 33, 4};
    private static final int $$d = 54;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {71, -70, 54, 33, 10, 4, 3, Ascii.DC4, -50, -5, Ascii.SYN, -16, Ascii.SYN, -3, 8, 50, Ascii.SO, -49, Ascii.DLE, 5, 32, 8, 6, 10, Ascii.DC2, 0, -8, Ascii.DC4, Ascii.US, 5, Ascii.DLE, 8, 5, Ascii.ESC, Ascii.SYN, -16, -2, Ascii.DC2, 3, 36, 8, 3, 1, -6, Ascii.GS, 1, -9, Ascii.SO, -5, 10, 2, 5, -9, 5, Ascii.VT};
    private static final int $$b = 195;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] IPostMessageService = {38276, 38354, 38356, 38358, 38363, 38388, 38385, 38351, 38356, 38356, 38358, 38284, 38356, 38354, 38359, 38362, 38360, 38353, 38354, 38272, 38344, 38344, 38336, 38207, 38344, 38353, 38352, 38342, 38338, 38348, 38348, 38374, 38370, 38344, 38343, 38343, 38346, 38339, 38338, 38372, 38373, 38339, 38278, 38351, 38385, 38384, 38350, 38351, 38358, 38355, 38355, 38356, 38382, 38383, 38345, 38345, 38348, 38355, 38358, 38386, 38386, 38360, 38360, 38350, 38354, 38364, 38365, 38356, 38347, 38348, 38356, 38356, 38311, 38284, 38362, 38364, 38357, 38355, 38356, 38347, 38354, 38356, 38338, 38208, 38209, 38209, 38078, 38079, 38336, 38073, 38227, 38233, 38069, 38072, 38208, 38079, 38235, 38227, 38069, 38072, 38072, 38279, 38352, 38350, 38350, 38355, 38058, 38044, 38282, 38355, 38360, 38358, 38357, 38358, 38351, 38350, 38276, 38339, 38207, 38336, 38340, 38344, 38337, 38336, 38338, 38203, 38204, 38338, 38281, 38351, 38356, 38356, 38356, 38363, 38359, 38355, 38354, 38358, 38363, 38357, 38351, 38350, 38276, 38349, 38360, 38359, 38350, 38354, 38356, 38278, 38348, 38282, 38360, 38358, 38354, 38362, 38364, 38353, 38353, 38351, 38356, 38358, 38348, 38358, 38357, 38348, 38348, 38350, 38358, 38361, 38363, 38197, 38059, 38059, 38069, 38076, 38074, 38277, 38347, 38278, 38347, 38347, 38357, 38357, 38348, 38383, 38384, 38356, 38352, 38350, 38353, 38353, 38356, 38360, 38357, 38287, 38359, 38357, 38363, 38365, 38358, 38348, 38353, 38353, 38352, 38241, 38251, 38258, 38256, 38250, 38252, 38250, 38246, 38149, 38286, 38365, 38358, 38348, 38378, 38386, 38355, 38347, 38349, 38351, 38356, 38280, 38357, 38357, 38356, 38363, 38366, 38358, 38356, 38351, 38349, 38350, 38386, 38155, 38256, 38247, 38378, 38161, 38161, 38161, 38154, 38186, 38194, 38165, 38159, 38188, 38184, 38194, 38054, 38056, 38062, 38222, 38224, 38065, 38063, 38058, 38062, 38225, 38219, 38057, 38280, 38353, 38353, 38358, 38364, 38365, 38366, 38357, 38347, 38383, 38391, 38355, 38347, 38383, 38382, 38353, 38356, 38356, 38360, 38226, 38069, 38075, 38232, 38227, 38074, 38078, 38071, 38067, 38227, 38232, 38070, 38070, 38078, 38231, 38312, 38382, 38357, 38362, 38356, 38385, 38312, 38382, 38350, 38352, 38351, 38384, 38391, 38363, 38362, 38358, 38386, 38390, 38353, 38380, 38383, 38349, 38347, 38381, 38385, 38358, 38355, 38348, 38345, 38345, 38382, 38281, 38193, 38156, 38156, 38159, 38166, 38169, 38196, 38191, 38165, 38173, 38167, 38196, 38310, 38388, 38381, 38277, 38282, 38387, 38303, 38373, 38341, 38206, 38205, 38367, 38350, 38247, 38255, 38251, 38248, 38246, 38150, 38146, 38239, 38244, 38250, 38251, 38253, 38249, 38148, 38148, 38249, 38155, 38148, 38239, 38239, 38148, 38312, 38390, 38363, 38354, 38381, 38379, 38342, 38351, 38359, 38353, 38352, 38385, 38168, 38168, 38204, 38198, 38173, 38172, 38169, 38201, 38338, 38181, 38166, 38168, 38176, 38177, 38172, 38397, 38341, 38342, 38204, 38204};
    private static long extraCommand = 383155210181204445L;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r5, int r6, byte r7) {
        /*
            int r7 = r7 + 65
            int r5 = r5 * 3
            int r5 = 4 - r5
            int r6 = r6 * 2
            int r0 = 1 - r6
            byte[] r1 = com.google.android.gms.stats.zza.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            int r6 = 0 - r6
            if (r1 != 0) goto L17
            r4 = r7
            r3 = r2
            r7 = r6
            goto L27
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r6) goto L23
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L23:
            int r3 = r3 + 1
            r4 = r1[r5]
        L27:
            int r7 = r7 + r4
            int r5 = r5 + 1
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.zza.$$e(short, int, byte):java.lang.String");
    }

    public /* synthetic */ zza(WakeLock wakeLock) {
        this.zza = wakeLock;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 66
            int r0 = r6 + 2
            int r7 = 51 - r7
            byte[] r1 = com.google.android.gms.stats.zza.$$a
            byte[] r0 = new byte[r0]
            int r6 = r6 + 1
            r2 = 0
            if (r1 != 0) goto L13
            r3 = r6
            r8 = r7
            r4 = r2
            goto L2c
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r8
            int r7 = r7 + 1
            r0[r3] = r4
            if (r3 != r6) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L23:
            r4 = r1[r7]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r5
        L2c:
            int r3 = r3 + r7
            int r7 = r3 + (-5)
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.zza.a(byte, short, byte, java.lang.Object[]):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        WakeLock.zza(this.zza);
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        int i2 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        int i3 = $10 + 5;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (asbinder.d < cArr.length) {
            int i5 = $11 + 11;
            $10 = i5 % 128;
            if (i5 % 2 != 0) {
                int i6 = asbinder.d;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - Drawable.resolveOpacity(0, 0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), Color.green(0) + 1407, 1035473698, false, $$e(b, b2, (byte) (b2 | 53)), new Class[]{Integer.TYPE, Object.class, Object.class});
                    }
                    jArr[i6] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() | (extraCommand % (-2360974883025274865L));
                    try {
                        Object[] objArr3 = {asbinder, asbinder};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                        if (objAccessartificialFrame2 == null) {
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0) + 9, (char) (ViewConfiguration.getWindowTouchSlop() >> 8), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 248, 378009232, false, "w", new Class[]{Object.class, Object.class});
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
            } else {
                int i7 = asbinder.d;
                Object[] objArr4 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame3 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0) + 12, (char) (ViewConfiguration.getLongPressTimeout() >> 16), 1407 - TextUtils.getCapsMode("", 0, 0), 1035473698, false, $$e(b3, b4, (byte) (b4 | 53)), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i7] = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr5 = {asbinder, asbinder};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - ExpandableListView.getPackedPositionType(0L), (char) (TextUtils.lastIndexOf("", '0', 0) + 1), 249 - View.MeasureSpec.makeMeasureSpec(0, 0), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i8 = $10 + 85;
            $11 = i8 % 128;
            int i9 = i8 % 2;
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            Object[] objArr6 = {asbinder, asbinder};
            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1981632360);
            if (objAccessartificialFrame5 == null) {
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((-16777208) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16), 249 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 378009232, false, "w", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame5).invoke(null, objArr6);
        }
        objArr[0] = new String(cArr2);
    }

    private static void c(byte[] bArr, int[] iArr, boolean z, Object[] objArr) {
        int i;
        char[] cArr;
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i5 = 0;
        int i6 = iArr[0];
        int i7 = 1;
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        char[] cArr2 = IPostMessageService;
        float f = 0.0f;
        if (cArr2 != null) {
            int i11 = $11 + 25;
            $10 = i11 % 128;
            int i12 = i11 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i13 = 0;
            while (i13 < length) {
                int i14 = $11 + 69;
                $10 = i14 % 128;
                int i15 = i14 % i3;
                try {
                    Object[] objArr2 = new Object[i7];
                    objArr2[i5] = Integer.valueOf(cArr2[i13]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                    if (objAccessartificialFrame == null) {
                        int offsetBefore = 11 - TextUtils.getOffsetBefore("", i5);
                        char threadPriority = (char) ((Process.getThreadPriority(i5) + 20) >> 6);
                        int i16 = (AudioTrack.getMinVolume() > f ? 1 : (AudioTrack.getMinVolume() == f ? 0 : -1)) + 1562;
                        byte b = (byte) i5;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(offsetBefore, threadPriority, i16, 178318710, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    cArr3[i13] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i13++;
                    i3 = 2;
                    i5 = 0;
                    i7 = 1;
                    f = 0.0f;
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
        char[] cArr4 = new char[i8];
        System.arraycopy(cArr2, i6, cArr4, 0, i8);
        if (bArr != null) {
            int i17 = $11 + 87;
            $10 = i17 % 128;
            if (i17 % 2 != 0) {
                cArr = new char[i8];
                i2 = 1;
            } else {
                cArr = new char[i8];
                i2 = 0;
            }
            onpostmessage.a = i2;
            char c = 0;
            while (onpostmessage.a < i8) {
                if (bArr[onpostmessage.a] == 1) {
                    int i18 = $10 + 25;
                    $11 = i18 % 128;
                    if (i18 % 2 == 0) {
                        int i19 = onpostmessage.a;
                        Object[] objArr3 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(23 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0)), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 2440, -850656813, false, $$e(b3, b4, (byte) (b4 + 3)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr[i19] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        throw null;
                    }
                    int i20 = onpostmessage.a;
                    Object[] objArr4 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(MotionEvent.axisFromString("") + 24, (char) View.MeasureSpec.getSize(0), 2441 - KeyEvent.normalizeMetaState(0), -850656813, false, $$e(b5, b6, (byte) (b6 + 3)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr[i20] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                } else {
                    int i21 = onpostmessage.a;
                    Object[] objArr5 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = b7;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(10 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16), TextUtils.indexOf("", "") + 1562, 1918398056, false, $$e(b7, b8, (byte) (b8 | 57)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr[i21] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                }
                c = cArr[onpostmessage.a];
                Object[] objArr6 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.makeMeasureSpec(0, 0) + 22, (char) (TextUtils.lastIndexOf("", '0') + 29364), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + JfifUtil.MARKER_RST7, -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            }
            cArr4 = cArr;
        }
        if (i10 > 0) {
            char[] cArr5 = new char[i8];
            i = 0;
            System.arraycopy(cArr4, 0, cArr5, 0, i8);
            int i22 = i8 - i10;
            System.arraycopy(cArr5, 0, cArr4, i22, i10);
            System.arraycopy(cArr5, i10, cArr4, 0, i22);
        } else {
            i = 0;
        }
        if (z) {
            char[] cArr6 = new char[i8];
            while (true) {
                onpostmessage.a = i;
                if (onpostmessage.a >= i8) {
                    break;
                }
                cArr6[onpostmessage.a] = cArr4[(i8 - onpostmessage.a) - 1];
                i = onpostmessage.a + 1;
            }
            cArr4 = cArr6;
        }
        if (i9 > 0) {
            int i23 = $11 + 15;
            $10 = i23 % 128;
            int i24 = i23 % 2;
            onpostmessage.a = 0;
            while (onpostmessage.a < i8) {
                cArr4[onpostmessage.a] = (char) (cArr4[onpostmessage.a] - iArr[2]);
                onpostmessage.a++;
                int i25 = $11 + 49;
                $10 = i25 % 128;
                int i26 = i25 % 2;
            }
        }
        objArr[0] = new String(cArr4);
    }

    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 6848 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v849 */
    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] accessartificialFrame$78cbbd35(int r59, int r60, java.lang.Object r61, int r62, boolean r63) {
        /*
            Method dump skipped, instruction units count: 18661
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.zza.accessartificialFrame$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
    }
}
