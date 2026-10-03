package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.legacy.content.WakefulBroadcastReceiver;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.gms.measurement.internal.zzmi;
import com.google.android.gms.measurement.internal.zzmm;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.artificialFrame;

/* JADX INFO: loaded from: classes4.dex */
public final class AppMeasurementService extends Service implements zzmm {
    private zzmi<AppMeasurementService> zza;
    private static final byte[] $$c = {4, -94, -54, -39};
    private static final int $$f = 32;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$d = {73, -128, -106, 120, 19, 5, -56, SignedBytes.MAX_POWER_OF_TWO, Ascii.SI, 7, -1, Ascii.FF, 0, -48, 60, Ascii.SYN, Ascii.SO, -2, Ascii.VT, 2, -58, 77, -4, Ascii.FF, 4, -54, 58, Ascii.VT, 3, 10, -47, Ascii.SUB, 43, Ascii.NAK, -39, 35, Ascii.RS, -38, 33, Ascii.ESC, -78, Ascii.DC4, 7, 68, 3, 4, 19, 7, 3, -54, 2, 66, Ascii.FF, Ascii.CR, -8, Ascii.DC4, 3, -6, Ascii.DC2, -55, 73, 3, -4, Ascii.SUB, -7, Ascii.DLE, 10, 2, -56, 58, Ascii.DC4, -3, Ascii.NAK, 4, 1, 2, -47, Ascii.GS, 40, 8, 6, Ascii.DC4, 7, -6, 6, -10, 35, -5, Ascii.SI, 1, Ascii.SYN, -44, 42, 4, Ascii.SYN, Ascii.VT, -8, Ascii.DC4};
    private static final int $$e = 70;
    private static final byte[] $$a = {53, -94, -28, -114, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$b = 158;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int[] ICustomTabsCallbackStub = {900120763, 1801727779, 1934669205, -1280237923, -381121285, 625165149, -1467490451, -1662513796, -339371955, -1109798942, 1995405053, -1019181207, -1184844509, 1618048264, -639230372, -1540505911, 833751543, -88180167};

    private static String $$g(byte b, int i, int i2) {
        int i3 = 3 - (i2 * 2);
        int i4 = 115 - (i * 6);
        byte[] bArr = $$c;
        int i5 = b * 4;
        byte[] bArr2 = new byte[i5 + 1];
        int i6 = -1;
        if (bArr == null) {
            i4 = i5 + (-i3);
            i3 = i3;
            i6 = -1;
        }
        while (true) {
            int i7 = i6 + 1;
            int i8 = i3 + 1;
            bArr2[i7] = (byte) i4;
            if (i7 == i5) {
                return new String(bArr2, 0);
            }
            i4 += -bArr[i8];
            i3 = i8;
            i6 = i7;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0032). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.google.android.gms.measurement.AppMeasurementService.$$a
            int r7 = r7 * 8
            int r7 = 20 - r7
            int r8 = r8 * 3
            int r1 = 12 - r8
            int r6 = r6 * 28
            int r6 = r6 + 84
            byte[] r1 = new byte[r1]
            int r8 = 11 - r8
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r7
            r4 = r2
            goto L32
        L18:
            r3 = r2
        L19:
            r5 = r7
            r7 = r6
            r6 = r5
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L32:
            int r7 = r7 + 1
            int r6 = -r6
            int r6 = r6 + r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurementService.a(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.google.android.gms.measurement.AppMeasurementService.$$d
            int r8 = r8 * 3
            int r8 = 111 - r8
            int r6 = r6 * 2
            int r6 = 44 - r6
            int r7 = r7 * 4
            int r7 = 55 - r7
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r8
            r5 = r2
            r8 = r6
            goto L29
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r3 = r0[r6]
        L29:
            int r6 = r6 + 1
            int r8 = r8 + r3
            int r8 = r8 + (-7)
            r3 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurementService.c(short, short, int, java.lang.Object[]):void");
    }

    @Override // android.app.Service
    public final int onStartCommand(@NonNull Intent intent, int i, int i2) {
        return zza().zza(intent, i, i2);
    }

    @Override // android.app.Service
    public final IBinder onBind(@NonNull Intent intent) {
        return zza().zza(intent);
    }

    private final zzmi<AppMeasurementService> zza() {
        if (this.zza == null) {
            this.zza = new zzmi<>(this);
        }
        return this.zza;
    }

    @Override // com.google.android.gms.measurement.internal.zzmm
    public final void zza(@NonNull Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
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
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzmm
    public final boolean zza(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    public final boolean onUnbind(@NonNull Intent intent) {
        return zza().zzc(intent);
    }

    private static void b(int i, int[] iArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = ICustomTabsCallbackStub;
        int i3 = -1780896814;
        int i4 = 1;
        int i5 = 0;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i6 = 0;
            while (i6 < length) {
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i5] = Integer.valueOf(iArr2[i6]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i3);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i5;
                        byte b2 = (byte) (b + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getMode(i5) + 11, (char) TextUtils.indexOf("", "", i5, i5), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1562, 180153818, false, $$g(b, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE});
                    }
                    iArr3[i6] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i6++;
                    i3 = -1780896814;
                    i5 = 0;
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
        float f = 0.0f;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i7 = $11 + 89;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            int i9 = 0;
            while (i9 < length3) {
                try {
                    Object[] objArr3 = new Object[i4];
                    objArr3[0] = Integer.valueOf(iArr5[i9]);
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                    if (objAccessartificialFrame2 == null) {
                        int i10 = 11 - (PointF.length(f, f) > f ? 1 : (PointF.length(f, f) == f ? 0 : -1));
                        char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + i4);
                        int i11 = 1562 - (TypedValue.complexToFloat(0) > f ? 1 : (TypedValue.complexToFloat(0) == f ? 0 : -1));
                        byte b3 = (byte) 0;
                        byte b4 = (byte) (b3 + 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i10, modifierMetaStateMask, i11, 180153818, false, $$g(b3, b4, (byte) (b4 - 1)), new Class[]{Integer.TYPE});
                    }
                    iArr6[i9] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    i9++;
                    iArr5 = iArr5;
                    f = 0.0f;
                    i4 = 1;
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        artificialframe.e = 0;
        while (artificialframe.e < iArr.length) {
            int i12 = $11 + 107;
            $10 = i12 % 128;
            int i13 = i12 % 2;
            cArr[0] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr4);
            int i14 = 0;
            for (int i15 = 16; i14 < i15; i15 = 16) {
                artificialframe.c ^= iArr4[i14];
                Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 26, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16), TextUtils.indexOf((CharSequence) "", '0') + 1042, 995482881, false, $$g(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                artificialframe.c = artificialframe.b;
                artificialframe.b = iIntValue;
                i14++;
            }
            int i16 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i16;
            artificialframe.b ^= iArr4[16];
            artificialframe.c ^= iArr4[17];
            int i17 = artificialframe.c;
            int i18 = artificialframe.b;
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
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 37, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 28009), 306 - (ViewConfiguration.getScrollBarSize() >> 8), -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
        }
        String str = new String(cArr2, 0, i);
        int i19 = $10 + 25;
        $11 = i19 % 128;
        if (i19 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        objArr[0] = str;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:23:0x0271 A[Catch: all -> 0x0a57, TryCatch #0 {all -> 0x0a57, blocks: (B:58:0x07a3, B:60:0x07b7, B:61:0x07e8, B:21:0x0250, B:23:0x0271, B:24:0x02bb), top: B:101:0x0250 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:32:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:57:0x071b  */
    /* JADX WARN: Code duplicated, block: B:60:0x07b7 A[Catch: all -> 0x0a57, TryCatch #0 {all -> 0x0a57, blocks: (B:58:0x07a3, B:60:0x07b7, B:61:0x07e8, B:21:0x0250, B:23:0x0271, B:24:0x02bb), top: B:101:0x0250 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x07fe  */
    /* JADX WARN: Code duplicated, block: B:69:0x08ae  */
    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        char c;
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
        artificialFrame = i2 % 128;
        Object obj = null;
        if (i2 % 2 == 0) {
            super.attachBaseContext(context);
            Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame7 == null) {
                int iArgb = 25 - Color.argb(0, 0, 0, 0);
                char maximumDrawingCacheSize = (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 30068);
                int iBlue = 816 - Color.blue(0);
                byte[] bArr = $$a;
                byte b = bArr[5];
                Object[] objArr2 = new Object[1];
                a(b, bArr[8], b, objArr2);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iArgb, maximumDrawingCacheSize, iBlue, 721586079, false, (String) objArr2[0], null);
            }
            ((Field) objAccessartificialFrame7).getLong(null);
            obj.hashCode();
            throw null;
        }
        super.attachBaseContext(context);
        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame8 == null) {
            int iMyPid = 25 - (Process.myPid() >> 22);
            char trimmedLength = (char) (TextUtils.getTrimmedLength("") + 30068);
            int i3 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 815;
            byte[] bArr2 = $$a;
            byte b2 = bArr2[5];
            Object[] objArr3 = new Object[1];
            a(b2, bArr2[8], b2, objArr3);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iMyPid, trimmedLength, i3, 721586079, false, (String) objArr3[0], null);
        }
        long j = ((Field) objAccessartificialFrame8).getLong(null);
        if (j != -1) {
            long j2 = j + 2037;
            Object[] objArr4 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new int[]{-2137009245, 790321569, -772606928, -750986071, -1471581717, -322440595, 323699616, 2130370567, 1661915050, 754211122, 1242134731, -263337263}, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 11, new int[]{1143391130, 1552967265, 108790853, 644787323, 2106191008, -962888503, -443348057, 343964774}, objArr5);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame9 == null) {
                    int iIndexOf = TextUtils.indexOf("", "", 0) + 25;
                    char edgeSlop = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 30068);
                    int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0) + 817;
                    byte b3 = $$a[5];
                    byte b4 = b3;
                    Object[] objArr6 = new Object[1];
                    a(b3, b4, b4, objArr6);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iIndexOf, edgeSlop, iIndexOf2, 891606461, false, (String) objArr6[0], null);
                }
                Object[] objArr7 = (Object[]) ((Field) objAccessartificialFrame9).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i4 = ((int[]) objArr7[0])[0];
                int i5 = ((int[]) objArr7[1])[0];
                String[] strArr = (String[]) objArr7[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i6 = (((-270365738) + (((-59363465) | iIdentityHashCode) * (-381))) + (((~((~iIdentityHashCode) | (-465172699))) | 1009790834) * 381)) - 1801265263;
                int i7 = (i6 << 13) ^ i6;
                int i8 = i7 ^ (i7 >>> 17);
                ((int[]) objArr[3])[0] = i8 ^ (i8 << 5);
            } else {
                Object[] objArr8 = new Object[1];
                b(16 - Gravity.getAbsoluteGravity(0, 0), new int[]{-556236525, -1118060415, 1121749733, -291543876, 113440536, 16279054, 590696269, 1375495973}, objArr8);
                Class<?> cls2 = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, new int[]{1068666683, 1518085331, 1329103322, -876114632, 715667553, 1627073928, 69894152, -1689236600}, objArr9);
                try {
                    Object[] objArr10 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr9[0], Object.class).invoke(null, this)).intValue()), 0, 1351058729};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int i9 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 25;
                        char fadingEdgeLength = (char) (30068 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                        int iCombineMeasuredStates = 816 - View.combineMeasuredStates(0, 0);
                        byte b5 = (byte) ($$a[5] - 1);
                        byte b6 = b5;
                        Object[] objArr11 = new Object[1];
                        a(b5, b6, b6, objArr11);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i9, fadingEdgeLength, iCombineMeasuredStates, -797394565, false, (String) objArr11[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr10);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 25;
                        char touchSlop = (char) (30068 - (ViewConfiguration.getTouchSlop() >> 8));
                        int fadingEdgeLength2 = 816 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                        byte b7 = $$a[5];
                        byte b8 = b7;
                        Object[] objArr12 = new Object[1];
                        a(b7, b8, b8, objArr12);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(scrollBarSize, touchSlop, fadingEdgeLength2, 891606461, false, (String) objArr12[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr13 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new int[]{-2137009245, 790321569, -772606928, -750986071, -1471581717, -322440595, 323699616, 2130370567, 1661915050, 754211122, 1242134731, -263337263}, objArr13);
                        Class<?> cls3 = Class.forName((String) objArr13[0]);
                        Object[] objArr14 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 11, new int[]{1143391130, 1552967265, 108790853, 644787323, 2106191008, -962888503, -443348057, 343964774}, objArr14);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr14[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int iRgb = Color.rgb(0, 0, 0) + 16777241;
                            char minimumFlingVelocity = (char) (30068 - (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                            int iArgb2 = 816 - Color.argb(0, 0, 0, 0);
                            byte[] bArr3 = $$a;
                            byte b9 = bArr3[5];
                            Object[] objArr15 = new Object[1];
                            a(b9, bArr3[8], b9, objArr15);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iRgb, minimumFlingVelocity, iArgb2, 721586079, false, (String) objArr15[0], null);
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
            b(16 - Gravity.getAbsoluteGravity(0, 0), new int[]{-556236525, -1118060415, 1121749733, -291543876, 113440536, 16279054, 590696269, 1375495973}, objArr16);
            Class<?> cls4 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, new int[]{1068666683, 1518085331, 1329103322, -876114632, 715667553, 1627073928, 69894152, -1689236600}, objArr17);
            Object[] objArr18 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue()), 0, 1351058729};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int i10 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 25;
                char fadingEdgeLength3 = (char) (30068 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                int iCombineMeasuredStates2 = 816 - View.combineMeasuredStates(0, 0);
                byte b10 = (byte) ($$a[5] - 1);
                byte b11 = b10;
                Object[] objArr19 = new Object[1];
                a(b10, b11, b11, objArr19);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i10, fadingEdgeLength3, iCombineMeasuredStates2, -797394565, false, (String) objArr19[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr18);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 25;
                char touchSlop2 = (char) (30068 - (ViewConfiguration.getTouchSlop() >> 8));
                int fadingEdgeLength4 = 816 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                byte b12 = $$a[5];
                byte b13 = b12;
                Object[] objArr110 = new Object[1];
                a(b12, b13, b13, objArr110);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(scrollBarSize2, touchSlop2, fadingEdgeLength4, 891606461, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr111 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new int[]{-2137009245, 790321569, -772606928, -750986071, -1471581717, -322440595, 323699616, 2130370567, 1661915050, 754211122, 1242134731, -263337263}, objArr111);
            Class<?> cls5 = Class.forName((String) objArr111[0]);
            Object[] objArr112 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 11, new int[]{1143391130, 1552967265, 108790853, 644787323, 2106191008, -962888503, -443348057, 343964774}, objArr112);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr112[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int iRgb2 = Color.rgb(0, 0, 0) + 16777241;
                char minimumFlingVelocity2 = (char) (30068 - (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                int iArgb3 = 816 - Color.argb(0, 0, 0, 0);
                byte[] bArr4 = $$a;
                byte b14 = bArr4[5];
                Object[] objArr113 = new Object[1];
                a(b14, bArr4[8], b14, objArr113);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iRgb2, minimumFlingVelocity2, iArgb3, 721586079, false, (String) objArr113[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i11 = ((int[]) objArr[1])[0];
        int i12 = ((int[]) objArr[0])[0];
        if (i12 == i11) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i13 = ((int[]) objArr[3])[0];
            int i14 = ((int[]) objArr[0])[0];
            int i15 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int i16 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().heightPixels;
            int i17 = i13 + (((2015007117 + (((~((-190904591) | i16)) | 6349070) * 576)) + (((~((~i16) | (-184555521))) | 918705) * 576)) - 637902976);
            int i18 = (i17 << 13) ^ i17;
            int i19 = i18 ^ (i18 >>> 17);
            ((int[]) objArr20[3])[0] = i19 ^ (i19 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            long j3 = (((long) 259462616) << 32) ^ ((long) (i11 ^ i12));
            long j4 = 259462617;
            int i20 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
            artificialFrame = i20 % 128;
            int i21 = i20 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr5 = $$d;
                byte b15 = bArr5[41];
                byte b16 = bArr5[24];
                Object[] objArr22 = new Object[1];
                c(b15, b16, b16, objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c(bArr5[74], bArr5[53], (byte) (bArr5[31] - 1), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i22 = ((int[]) objArr[3])[0];
                int i23 = ((int[]) objArr[0])[0];
                int i24 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i25 = ~iIdentityHashCode2;
                int i26 = i22 + 1956901573 + (((~((-59530157) | i25)) | 51124776) * SyslogConstants.LOG_LOCAL7) + ((iIdentityHashCode2 | (-266107903)) * (-184)) + ((~((-257702523) | i25)) * SyslogConstants.LOG_LOCAL7);
                int i27 = (i26 << 13) ^ i26;
                int i28 = i27 ^ (i27 >>> 17);
                ((int[]) objArr24[3])[0] = i28 ^ (i28 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame10 == null) {
            int iLastIndexOf = 25 - TextUtils.lastIndexOf("", '0', 0, 0);
            char c2 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
            int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 1042;
            byte[] bArr6 = $$a;
            byte b17 = bArr6[5];
            Object[] objArr25 = new Object[1];
            a(b17, bArr6[8], b17, objArr25);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c2, bitsPerPixel, 2061780482, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j5 != -1) {
            int i29 = artificialFrame + 33;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i29 % 128;
            int i30 = i29 % 2;
            long j6 = j5 + 4611686018427387819L;
            Object[] objArr26 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1, new int[]{-2137009245, 790321569, -772606928, -750986071, -1471581717, -322440595, 323699616, 2130370567, 1661915050, 754211122, 1242134731, -263337263}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 100, new int[]{1143391130, 1552967265, 108790853, 644787323, 2106191008, -962888503, -443348057, 343964774}, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i31 = artificialFrame + 21;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i31 % 128;
                int i32 = i31 % 2;
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame11 == null) {
                    int iNormalizeMetaState = 26 - KeyEvent.normalizeMetaState(0);
                    char trimmedLength2 = (char) TextUtils.getTrimmedLength("");
                    int i33 = 1042 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    byte b18 = $$a[5];
                    byte b19 = b18;
                    Object[] objArr28 = new Object[1];
                    a(b18, b19, b19, objArr28);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, trimmedLength2, i33, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame11).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i34 = ((int[]) objArr29[3])[0];
                int i35 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int i36 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboardHidden;
                int i37 = ~i36;
                int i38 = ((((-1336005146) + ((528216021 | i36) * (-676))) + (((~(454160340 | i37)) | (-528216022)) * 676)) + (((~(i36 | (-74055682))) | ((~(i37 | 376056533)) | 152159488)) * 676)) - 381140483;
                int i39 = (i38 << 13) ^ i38;
                int i40 = i39 ^ (i39 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i40 ^ (i40 << 5);
                int i41 = artificialFrame + 65;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i41 % 128;
                int i42 = i41 % 2;
                c = 2;
            } else {
                Object[] objArr30 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 33, new int[]{-556236525, -1118060415, 1121749733, -291543876, 113440536, 16279054, 590696269, 1375495973}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) - 83, new int[]{1068666683, 1518085331, 1329103322, -876114632, 715667553, 1627073928, 69894152, -1689236600}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {836098489};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0) + 9, (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 22251), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = com.google.android.gms.stats.zza.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), -381140483, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int capsMode = 26 - TextUtils.getCapsMode("", 0, 0);
                    char mirror = (char) ('0' - AndroidCharacter.getMirror('0'));
                    int iAlpha = Color.alpha(0) + 1041;
                    byte b20 = $$a[5];
                    byte b21 = b20;
                    Object[] objArr33 = new Object[1];
                    a(b20, b21, b21, objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(capsMode, mirror, iAlpha, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new int[]{-2137009245, 790321569, -772606928, -750986071, -1471581717, -322440595, 323699616, 2130370567, 1661915050, 754211122, 1242134731, -263337263}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    b(14 - ImageFormat.getBitsPerPixel(0), new int[]{1143391130, 1552967265, 108790853, 644787323, 2106191008, -962888503, -443348057, 343964774}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int iIndexOf3 = TextUtils.indexOf("", "", 0) + 26;
                        char minimumFlingVelocity3 = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                        int iResolveSize = View.resolveSize(0, 0) + 1041;
                        byte[] bArr7 = $$a;
                        byte b22 = bArr7[5];
                        Object[] objArr36 = new Object[1];
                        a(b22, bArr7[8], b22, objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iIndexOf3, minimumFlingVelocity3, iResolveSize, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    int i43 = artificialFrame + 101;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i43 % 128;
                    c = 2;
                    int i44 = i43 % 2;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 33, new int[]{-556236525, -1118060415, 1121749733, -291543876, 113440536, 16279054, 590696269, 1375495973}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) - 83, new int[]{1068666683, 1518085331, 1329103322, -876114632, 715667553, 1627073928, 69894152, -1689236600}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {836098489};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0) + 9, (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 22251), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = com.google.android.gms.stats.zza.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), -381140483, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int capsMode2 = 26 - TextUtils.getCapsMode("", 0, 0);
                char mirror2 = (char) ('0' - AndroidCharacter.getMirror('0'));
                int iAlpha2 = Color.alpha(0) + 1041;
                byte b23 = $$a[5];
                byte b24 = b23;
                Object[] objArr310 = new Object[1];
                a(b23, b24, b24, objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(capsMode2, mirror2, iAlpha2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new int[]{-2137009245, 790321569, -772606928, -750986071, -1471581717, -322440595, 323699616, 2130370567, 1661915050, 754211122, 1242134731, -263337263}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            b(14 - ImageFormat.getBitsPerPixel(0), new int[]{1143391130, 1552967265, 108790853, 644787323, 2106191008, -962888503, -443348057, 343964774}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int iIndexOf4 = TextUtils.indexOf("", "", 0) + 26;
                char minimumFlingVelocity4 = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                int iResolveSize2 = View.resolveSize(0, 0) + 1041;
                byte[] bArr8 = $$a;
                byte b25 = bArr8[5];
                Object[] objArr313 = new Object[1];
                a(b25, bArr8[8], b25, objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iIndexOf4, minimumFlingVelocity4, iResolveSize2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            int i45 = artificialFrame + 101;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i45 % 128;
            c = 2;
            int i46 = i45 % 2;
        }
        int i47 = ((int[]) objArrAccessartificialFrame$78cbbd35[c])[0];
        int i48 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i48 == i47) {
            Object[] objArr40 = new Object[4];
            objArr40[1] = new int[1];
            objArr40[c] = new int[]{i};
            objArr40[3] = new int[]{i};
            int i49 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i50 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i51 = ((int[]) objArrAccessartificialFrame$78cbbd35[c])[0];
            objArr40[0] = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i52 = i49 + (-1290903070) + (((-34835109) | iIdentityHashCode3) * (-381)) + (((~((~iIdentityHashCode3) | (-244566695))) | 497566979) * 381) + 387274260;
            int i53 = (i52 << 13) ^ i52;
            int i54 = i53 ^ (i53 >>> 17);
            ((int[]) objArr40[1])[0] = i54 ^ (i54 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr6 != null) {
                for (String str2 : strArr6) {
                    arrayList2.add(str2);
                }
            }
            Object[] objArr41 = {Long.valueOf((((long) (-608238672)) << 32) ^ ((long) (i47 ^ i48))), Long.valueOf(-608238670)};
            byte[] bArr9 = $$d;
            byte b26 = bArr9[12];
            byte b27 = b26;
            Object[] objArr42 = new Object[1];
            c(b26, b27, b27, objArr42);
            Class<?> cls12 = Class.forName((String) objArr42[0]);
            Object[] objArr43 = new Object[1];
            c(bArr9[74], bArr9[53], (byte) (bArr9[31] - 1), objArr43);
            cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
            Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i55 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i56 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i57 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i58 = i55 + ((~((~iIdentityHashCode4) | 783932203)) * 130) + 1914559750 + (((~(iIdentityHashCode4 | 783932203)) | 571576360) * 130);
            int i59 = (i58 << 13) ^ i58;
            int i60 = i59 ^ (i59 >>> 17);
            ((int[]) objArr44[1])[0] = i60 ^ (i60 << 5);
        }
        int i61 = artificialFrame + 11;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i61 % 128;
        if (i61 % 2 != 0) {
            throw null;
        }
    }
}
