package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import com.google.android.gms.measurement.internal.zzmi;
import com.google.android.gms.measurement.internal.zzmm;
import com.google.common.base.Ascii;
import com.google.common.collect.CompactHashMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;
import o.ArtificialStackFrames;
import o.onPostMessage;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public final class AppMeasurementJobService extends JobService implements zzmm {
    private zzmi<AppMeasurementJobService> zza;
    private static final byte[] $$c = {10, -69, -10, 57};
    private static final int $$f = 80;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$d = {Ascii.DC2, -20, 124, 53, Ascii.DC2, 4, -57, Utf8.REPLACEMENT_BYTE, Ascii.SO, 6, -2, Ascii.VT, -1, -49, 59, Ascii.NAK, Ascii.CR, -3, 10, 1, -59, 76, -5, Ascii.VT, 3, -55, 57, 10, 2, 9, -48, Ascii.EM, 42, Ascii.DC4, -40, 34, Ascii.GS, -39, 32, Ascii.SUB, -79, 19, 6, 67, 2, 3, Ascii.DC2, 6, 2, -55, 1, 65, Ascii.VT, Ascii.FF, -9, 19, 2, -7, 17, -56, 79, 2, -63, 42, Ascii.EM, 2, 17, -15, Ascii.DC4, 3, -9, 34, -6, Ascii.SO, 0, Ascii.NAK, -74, 57, 33, -3, 17, -9, 19, -24, 19, Ascii.CAN, -2};
    private static final int $$e = WebSocketProtocol.PAYLOAD_SHORT;
    private static final byte[] $$a = {0, -128, -114, 48, -33, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$b = 83;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] IPostMessageService = {38287, 38360, 38358, 38356, 38351, 38355, 38361, 38390, 38385, 38350, 38383, 38399, 38361, 38345, 38348, 38355, 38358, 38375, 38376, 38354, 38358, 38360, 38281, 38359, 38362, 38358, 38356, 38353, 38351, 38361, 38364, 38372, 38372, 38363, 38355, 38350, 38359, 38282, 38362, 38356, 38356, 38392, 38386, 38361, 38360, 38357, 38389, 38399, 38361, 38345, 38348, 38355, 38358, 38398, 38205, 38200, 38344, 38348, 38196, 38199, 38349, 38337, 38187, 38195, 38195, 38192, 38200, 38205, 38203};

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r6, int r7, int r8) {
        /*
            byte[] r0 = com.google.android.gms.measurement.AppMeasurementJobService.$$c
            int r6 = r6 * 3
            int r6 = r6 + 65
            int r7 = r7 * 4
            int r7 = 1 - r7
            int r8 = r8 * 3
            int r8 = 4 - r8
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r7
            r6 = r8
            r5 = r2
            goto L27
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r6
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L25:
            r3 = r0[r8]
        L27:
            int r8 = r8 + 1
            int r3 = -r3
            int r6 = r6 + r3
            r3 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurementJobService.$$g(byte, int, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.google.android.gms.measurement.AppMeasurementJobService.$$a
            int r6 = r6 * 3
            int r1 = r6 + 9
            int r7 = r7 * 28
            int r7 = 112 - r7
            int r8 = r8 + 5
            byte[] r1 = new byte[r1]
            int r6 = r6 + 8
            r2 = 0
            if (r0 != 0) goto L17
            r7 = r6
            r3 = r8
            r4 = r2
            goto L2f
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r8 = r8 + 1
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2f:
            int r8 = -r8
            int r7 = r7 + r8
            r8 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurementJobService.a(byte, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.google.android.gms.measurement.AppMeasurementJobService.$$d
            int r1 = r6 + 3
            int r8 = r8 * 3
            int r8 = 111 - r8
            int r7 = r7 * 2
            int r7 = 44 - r7
            byte[] r1 = new byte[r1]
            int r6 = r6 + 2
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r8
            r3 = r2
            r8 = r7
            goto L2c
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2c:
            int r7 = r7 + r4
            int r7 = r7 + (-6)
            int r8 = r8 + 1
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurementJobService.c(int, byte, short, java.lang.Object[]):void");
    }

    private final zzmi<AppMeasurementJobService> zza() {
        if (this.zza == null) {
            this.zza = new zzmi<>(this);
        }
        return this.zza;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(@NonNull JobParameters jobParameters) {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzmm
    public final void zza(@NonNull Intent intent) {
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        zza().zza();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        zza().zzb();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(@NonNull Intent intent) {
        zza().zzb(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzmm
    public final void zza(@NonNull JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    @Override // com.google.android.gms.measurement.internal.zzmm
    public final boolean zza(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(@NonNull JobParameters jobParameters) {
        return zza().zza(jobParameters);
    }

    @Override // android.app.Service
    public final boolean onUnbind(@NonNull Intent intent) {
        return zza().zzc(intent);
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
        long j = 0;
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
                        int packedPositionChild = 10 - ExpandableListView.getPackedPositionChild(j);
                        char scrollBarFadeDuration = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        int offsetBefore = TextUtils.getOffsetBefore("", i3) + 1562;
                        byte b = (byte) i3;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(packedPositionChild, scrollBarFadeDuration, offsetBefore, 178318710, false, $$g(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    cArr2[i9] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i9++;
                    i3 = 0;
                    i5 = 1;
                    j = 0;
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
            int i10 = $10 + 117;
            $11 = i10 % 128;
            int i11 = i10 % 2;
            char[] cArr4 = new char[i6];
            onpostmessage.a = 0;
            char c = 0;
            while (onpostmessage.a < i6) {
                if (bArr[onpostmessage.a] == 1) {
                    int i12 = onpostmessage.a;
                    Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 1;
                        byte b4 = (byte) (b3 - 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 23, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), 2441 - View.MeasureSpec.getMode(0), -850656813, false, $$g(b3, b4, b4), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i12] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                } else {
                    int i13 = onpostmessage.a;
                    Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 11, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), ExpandableListView.getPackedPositionGroup(0L) + 1562, 1918398056, false, $$g((byte) 19, b5, b5), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i13] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                }
                c = cArr4[onpostmessage.a];
                Object[] objArr5 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(Color.red(0) + 22, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 29364), 216 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            cArr3 = cArr4;
        }
        if (i8 > 0) {
            int i14 = $10 + 31;
            $11 = i14 % 128;
            int i15 = i14 % 2;
            char[] cArr5 = new char[i6];
            i = 0;
            System.arraycopy(cArr3, 0, cArr5, 0, i6);
            int i16 = i6 - i8;
            System.arraycopy(cArr5, 0, cArr3, i16, i8);
            System.arraycopy(cArr5, i8, cArr3, 0, i16);
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
                cArr6[onpostmessage.a] = cArr3[(i6 - onpostmessage.a) - 1];
                i = onpostmessage.a + 1;
            }
            cArr3 = cArr6;
        }
        if (i7 > 0) {
            onpostmessage.a = 0;
            while (onpostmessage.a < i6) {
                cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                onpostmessage.a++;
                int i17 = $11 + 73;
                $10 = i17 % 128;
                int i18 = i17 % 2;
            }
        }
        objArr[0] = new String(cArr3);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x014f  */
    /* JADX WARN: Code duplicated, block: B:16:0x01b8 A[Catch: all -> 0x08ad, TryCatch #2 {all -> 0x08ad, blocks: (B:51:0x05da, B:53:0x05ee, B:54:0x061f, B:14:0x0198, B:16:0x01b8, B:17:0x0205), top: B:95:0x0198 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0217  */
    /* JADX WARN: Code duplicated, block: B:25:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:50:0x0592  */
    /* JADX WARN: Code duplicated, block: B:53:0x05ee A[Catch: all -> 0x08ad, TryCatch #2 {all -> 0x08ad, blocks: (B:51:0x05da, B:53:0x05ee, B:54:0x061f, B:14:0x0198, B:16:0x01b8, B:17:0x0205), top: B:95:0x0198 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0635  */
    /* JADX WARN: Code duplicated, block: B:62:0x06bd  */
    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object[] objArr2;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int i2 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 24;
            char keyRepeatTimeout = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
            int iIndexOf = 815 - TextUtils.indexOf((CharSequence) "", '0');
            byte[] bArr = $$a;
            byte b = bArr[0];
            Object[] objArr3 = new Object[1];
            a(b, b, bArr[22], objArr3);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i2, keyRepeatTimeout, iIndexOf, 721586079, false, (String) objArr3[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 1907;
            Object[] objArr4 = new Object[1];
            b(new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, new int[]{0, 22, 0, 0}, false, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            b(new byte[]{0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1}, new int[]{22, 15, 0, 2}, true, objArr5);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int iMyTid = (Process.myTid() >> 22) + 25;
                    char c = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 30067);
                    int i3 = 817 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    byte[] bArr2 = $$a;
                    byte b2 = bArr2[0];
                    Object[] objArr6 = new Object[1];
                    a(b2, b2, bArr2[12], objArr6);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iMyTid, c, i3, 891606461, false, (String) objArr6[0], null);
                }
                Object[] objArr7 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i4 = ((int[]) objArr7[0])[0];
                int i5 = ((int[]) objArr7[1])[0];
                String[] strArr = (String[]) objArr7[2];
                int i6 = ~(new Random().nextInt(2077309692) | 750573540);
                int i7 = (((-206581491) | i6) * (-658)) + 134290197 + ((i6 | (-754778103)) * 658) + 1639229050;
                int i8 = (i7 << 13) ^ i7;
                int i9 = i8 ^ (i8 >>> 17);
                ((int[]) objArr[3])[0] = i9 ^ (i9 << 5);
            } else {
                Object[] objArr8 = new Object[1];
                b(new byte[]{0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0}, new int[]{37, 16, 0, 0}, false, objArr8);
                Class<?> cls2 = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                b(new byte[]{1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1}, new int[]{53, 16, 30, 0}, true, objArr9);
                try {
                    Object[] objArr10 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr9[0], Object.class).invoke(null, this)).intValue()), 0, 1639229050};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int iArgb = Color.argb(0, 0, 0, 0) + 25;
                        char c2 = (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 30068);
                        int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 816;
                        byte[] bArr3 = $$a;
                        byte b3 = bArr3[6];
                        Object[] objArr11 = new Object[1];
                        a(b3, b3, (byte) (-bArr3[20]), objArr11);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iArgb, c2, maximumDrawingCacheSize, -797394565, false, (String) objArr11[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr10);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int i10 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 24;
                        char fadingEdgeLength = (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 30068);
                        int iAlpha = 816 - Color.alpha(0);
                        byte[] bArr4 = $$a;
                        byte b4 = bArr4[0];
                        Object[] objArr12 = new Object[1];
                        a(b4, b4, bArr4[12], objArr12);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i10, fadingEdgeLength, iAlpha, 891606461, false, (String) objArr12[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr13 = new Object[1];
                        b(new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, new int[]{0, 22, 0, 0}, false, objArr13);
                        Class<?> cls3 = Class.forName((String) objArr13[0]);
                        Object[] objArr14 = new Object[1];
                        b(new byte[]{0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1}, new int[]{22, 15, 0, 2}, true, objArr14);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr14[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0) + 26;
                            char maximumDrawingCacheSize2 = (char) (30068 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                            int gidForName = Process.getGidForName("") + 817;
                            byte[] bArr5 = $$a;
                            byte b5 = bArr5[0];
                            Object[] objArr15 = new Object[1];
                            a(b5, b5, bArr5[22], objArr15);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf2, maximumDrawingCacheSize2, gidForName, 721586079, false, (String) objArr15[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
        } else {
            Object[] objArr16 = new Object[1];
            b(new byte[]{0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0}, new int[]{37, 16, 0, 0}, false, objArr16);
            Class<?> cls4 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            b(new byte[]{1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1}, new int[]{53, 16, 30, 0}, true, objArr17);
            Object[] objArr18 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue()), 0, 1639229050};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int iArgb2 = Color.argb(0, 0, 0, 0) + 25;
                char c3 = (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 30068);
                int maximumDrawingCacheSize3 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 816;
                byte[] bArr6 = $$a;
                byte b6 = bArr6[6];
                Object[] objArr19 = new Object[1];
                a(b6, b6, (byte) (-bArr6[20]), objArr19);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iArgb2, c3, maximumDrawingCacheSize3, -797394565, false, (String) objArr19[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr18);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int i11 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 24;
                char fadingEdgeLength2 = (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 30068);
                int iAlpha2 = 816 - Color.alpha(0);
                byte[] bArr7 = $$a;
                byte b7 = bArr7[0];
                Object[] objArr110 = new Object[1];
                a(b7, b7, bArr7[12], objArr110);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i11, fadingEdgeLength2, iAlpha2, 891606461, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr111 = new Object[1];
            b(new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, new int[]{0, 22, 0, 0}, false, objArr111);
            Class<?> cls5 = Class.forName((String) objArr111[0]);
            Object[] objArr112 = new Object[1];
            b(new byte[]{0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1}, new int[]{22, 15, 0, 2}, true, objArr112);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr112[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0) + 26;
                char maximumDrawingCacheSize4 = (char) (30068 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                int gidForName2 = Process.getGidForName("") + 817;
                byte[] bArr8 = $$a;
                byte b8 = bArr8[0];
                Object[] objArr113 = new Object[1];
                a(b8, b8, bArr8[22], objArr113);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf3, maximumDrawingCacheSize4, gidForName2, 721586079, false, (String) objArr113[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i12 = ((int[]) objArr[1])[0];
        int i13 = ((int[]) objArr[0])[0];
        if (i13 == i12) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i14 = ((int[]) objArr[3])[0];
            int i15 = ((int[]) objArr[0])[0];
            int i16 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int i17 = ~((int) Runtime.getRuntime().maxMemory());
            int i18 = i14 + (((~((-444652082) | i17)) | 268435472) * (-241)) + 7120401 + (((~(i17 | (-176216610))) | (-514915188)) * 241);
            int i19 = (i18 << 13) ^ i18;
            int i20 = i19 ^ (i19 >>> 17);
            ((int[]) objArr20[3])[0] = i20 ^ (i20 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                int i21 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                artificialFrame = i21 % 128;
                int i22 = i21 % 2;
                for (String str : strArr3) {
                    int i23 = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
                    artificialFrame = i23 % 128;
                    int i24 = i23 % 2;
                    arrayList.add(str);
                }
            }
            long j3 = (((long) (-1132329474)) << 32) ^ ((long) (i12 ^ i13));
            long j4 = -1132329473;
            int i25 = artificialFrame;
            int i26 = i25 + 87;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i26 % 128;
            int i27 = i26 % 2;
            int i28 = i25 + 115;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i28 % 128;
            int i29 = i28 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte b9 = (byte) ($$e & 165);
                byte[] bArr9 = $$d;
                Object[] objArr22 = new Object[1];
                c(b9, bArr9[33], bArr9[5], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c(bArr9[74], bArr9[19], bArr9[31], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i30 = ((int[]) objArr[3])[0];
                int i31 = ((int[]) objArr[0])[0];
                int i32 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i33 = ~iIdentityHashCode;
                int i34 = i30 + 733188631 + (((~((-270541583) | iIdentityHashCode)) | (~(i33 | (-668685377))) | 72369216) * 717) + (((~(iIdentityHashCode | (-668685377))) | (~(i33 | (-270541583))) | 72369216) * 717);
                int i35 = (i34 << 13) ^ i34;
                int i36 = i35 ^ (i35 >>> 17);
                ((int[]) objArr24[3])[0] = i36 ^ (i36 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame9 == null) {
            int tapTimeout = 26 - (ViewConfiguration.getTapTimeout() >> 16);
            char c4 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
            int packedPositionChild = 1040 - ExpandableListView.getPackedPositionChild(0L);
            byte[] bArr10 = $$a;
            byte b10 = bArr10[0];
            Object[] objArr25 = new Object[1];
            a(b10, b10, bArr10[22], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(tapTimeout, c4, packedPositionChild, 2061780482, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            long j6 = j5 + 4611686018427387861L;
            Object[] objArr26 = new Object[1];
            b(new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, new int[]{0, 22, 0, 0}, false, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b(new byte[]{0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1}, new int[]{22, 15, 0, 2}, true, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int packedPositionGroup = 26 - ExpandableListView.getPackedPositionGroup(0L);
                    char c5 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int iMyTid2 = 1041 - (Process.myTid() >> 22);
                    byte[] bArr11 = $$a;
                    byte b11 = bArr11[0];
                    Object[] objArr28 = new Object[1];
                    a(b11, b11, bArr11[12], objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, c5, iMyTid2, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr2 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i37 = ((int[]) objArr29[3])[0];
                int i38 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i39 = 545242574 + (((~(650838150 | iIdentityHashCode2)) | 154191105) * 104) + ((~((~iIdentityHashCode2) | (-76087299))) * (-104)) + ((iIdentityHashCode2 | 728941957) * 104) + 301664292;
                int i40 = (i39 << 13) ^ i39;
                int i41 = i40 ^ (i40 >>> 17);
                ((int[]) objArr2[1])[0] = i41 ^ (i41 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                b(new byte[]{0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0}, new int[]{37, 16, 0, 0}, false, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b(new byte[]{1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1}, new int[]{53, 16, 30, 0}, true, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {-1538585176};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (22251 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), 1033 - Drawable.resolveOpacity(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                Object[] objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 301664292, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int iKeyCodeFromString = 26 - KeyEvent.keyCodeFromString("");
                    char c6 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                    int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 1041;
                    byte[] bArr12 = $$a;
                    byte b12 = bArr12[0];
                    Object[] objArr33 = new Object[1];
                    a(b12, b12, bArr12[12], objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, c6, jumpTapTimeout, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    b(new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, new int[]{0, 22, 0, 0}, false, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    b(new byte[]{0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1}, new int[]{22, 15, 0, 2}, true, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int i42 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 25;
                        char defaultSize = (char) View.getDefaultSize(0, 0);
                        int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1041;
                        byte[] bArr13 = $$a;
                        byte b13 = bArr13[0];
                        Object[] objArr36 = new Object[1];
                        a(b13, b13, bArr13[22], objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i42, defaultSize, scrollDefaultDelay, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    objArr2 = objArrAccessartificialFrame$78cbbd35;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            b(new byte[]{0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0}, new int[]{37, 16, 0, 0}, false, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            b(new byte[]{1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1}, new int[]{53, 16, 30, 0}, true, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {-1538585176};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (22251 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), 1033 - Drawable.resolveOpacity(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd36 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 301664292, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int iKeyCodeFromString2 = 26 - KeyEvent.keyCodeFromString("");
                char c7 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                int jumpTapTimeout2 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 1041;
                byte[] bArr14 = $$a;
                byte b14 = bArr14[0];
                Object[] objArr310 = new Object[1];
                a(b14, b14, bArr14[12], objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString2, c7, jumpTapTimeout2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd36);
            Object[] objArr311 = new Object[1];
            b(new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, new int[]{0, 22, 0, 0}, false, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            b(new byte[]{0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1}, new int[]{22, 15, 0, 2}, true, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int i43 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 25;
                char defaultSize2 = (char) View.getDefaultSize(0, 0);
                int scrollDefaultDelay2 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1041;
                byte[] bArr15 = $$a;
                byte b15 = bArr15[0];
                Object[] objArr313 = new Object[1];
                a(b15, b15, bArr15[22], objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i43, defaultSize2, scrollDefaultDelay2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            objArr2 = objArrAccessartificialFrame$78cbbd36;
        }
        int i44 = ((int[]) objArr2[2])[0];
        int i45 = ((int[]) objArr2[3])[0];
        if (i45 == i44) {
            int i46 = artificialFrame + 65;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i46 % 128;
            int i47 = i46 % 2;
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i48 = ((int[]) objArr2[1])[0];
            int i49 = ((int[]) objArr2[3])[0];
            int i50 = ((int[]) objArr2[2])[0];
            String[] strArr6 = (String[]) objArr2[0];
            int i51 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
            int i52 = ~i51;
            int i53 = i48 + (((~(653871564 | i52)) | (~(i51 | 731975371))) * 959) + 1960421925 + (((~(i51 | 653871564)) | (~(i52 | 731975371))) * 959);
            int i54 = (i53 << 13) ^ i53;
            int i55 = i54 ^ (i54 >>> 17);
            ((int[]) objArr40[1])[0] = i55 ^ (i55 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr2[0];
        if (strArr7 != null) {
            int i56 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
            artificialFrame = i56 % 128;
            int i57 = i56 % 2;
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i44 ^ i45)) ^ (((long) (-204234579)) << 32)), Long.valueOf(-204234577)};
        byte[] bArr16 = $$d;
        byte b16 = (byte) (bArr16[32] - 1);
        byte b17 = bArr16[74];
        Object[] objArr42 = new Object[1];
        c(b16, b17, b17, objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c(bArr16[74], bArr16[19], bArr16[31], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i58 = ((int[]) objArr2[1])[0];
        int i59 = ((int[]) objArr2[3])[0];
        int i60 = ((int[]) objArr2[2])[0];
        String[] strArr8 = (String[]) objArr2[0];
        int i61 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
        int i62 = ~i61;
        int i63 = i58 + 2083863768 + (((~(i62 | (-32944454))) | 111048260) * (-1042)) + (((-32944454) | i61) * 521) + (((~(i61 | (-111048261))) | 101205504 | (~(i62 | (-23101698)))) * 521);
        int i64 = (i63 << 13) ^ i63;
        int i65 = i64 ^ (i64 >>> 17);
        ((int[]) objArr44[1])[0] = i65 ^ (i65 << 5);
    }
}
