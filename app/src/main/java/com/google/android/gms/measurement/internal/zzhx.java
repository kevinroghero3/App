package com.google.android.gms.measurement.internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o._CREATION;

/* JADX INFO: loaded from: classes5.dex */
public final class zzhx implements Runnable {
    private final /* synthetic */ zzac zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzhs zzc;
    private static final byte[] $$c = {98, -62, -118, -34};
    private static final int $$d = 82;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {5, -37, 48, 84, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, 50, Ascii.SO, -50, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4};
    private static final int $$b = 8;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] _CREATION = {6559, 62004, 52946, 56160, 46849, 33699, 40002, 26796, 17597, 20821, 11768, 14726, 4651, 61124, 64370, 55116, 41981, 48245, 34840, 25766, 29003, 19954, 22930, 6553, 62015, 52930, 56147, 46878, 33722, 40010, 26859, 17597, 20827, 11746, 14747, 4641, 61124, 64335, 55052, 41944, 48245, 48229, 22478, 27432, 32410, 4859, 9817, 14776, 52566, 57671, 62639, 34818, 40060, 47057, 19262, 24200, 29366, 1588, 6541, 11682, 49513, 54436, 59392, 64624, 38865, 43783, 48993, 21208, 26145, 31131, 3582, 8565, 13494, 51426, 56399, 11359, 51185, 64272, 61106, 33498, 6609, 62015, 52930, 56177, 46913, 33699, 40008, 26859, 17578, 20757, 11770, 14750, 4645, 61134, 64299, 55046, 41947, 48248, 34819, 25781, 29001, 19947, 22916, 12846, 3835, 6868, 63268, 50129, 6540, 62005, 52888, 56182, 46859, 33704, 40019, 26853, 17593, 20827, 11764, 14750, 4651, 26445};
    private static long _BOUNDARY = -2411184653248695718L;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0024). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r6, byte r7, int r8) {
        /*
            int r6 = r6 + 103
            int r7 = r7 * 3
            int r7 = r7 + 1
            int r8 = r8 * 2
            int r8 = 4 - r8
            byte[] r0 = com.google.android.gms.measurement.internal.zzhx.$$c
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r7
            r5 = r2
            goto L24
        L14:
            r3 = r2
        L15:
            byte r4 = (byte) r6
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L22:
            r3 = r0[r8]
        L24:
            int r3 = -r3
            int r6 = r6 + r3
            int r8 = r8 + 1
            r3 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhx.$$e(short, byte, int):java.lang.String");
    }

    zzhx(zzhs zzhsVar, zzac zzacVar, zzn zznVar) {
        this.zza = zzacVar;
        this.zzb = zznVar;
        this.zzc = zzhsVar;
    }

    private static void b(byte b, short s, byte b2, Object[] objArr) {
        int i = s + 66;
        byte[] bArr = $$a;
        int i2 = b + 4;
        byte[] bArr2 = new byte[28 - b2];
        int i3 = 27 - b2;
        int i4 = -1;
        if (bArr == null) {
            i = (i2 + i) - 5;
            i2 = i2;
        }
        while (true) {
            int i5 = i2 + 1;
            i4++;
            bArr2[i4] = (byte) i;
            if (i4 == i3) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                i = (i + bArr[i5]) - 5;
                i2 = i5;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzr();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zza(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzb(this.zza, this.zzb);
        }
    }

    private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i4 = _creation.b;
            try {
                Object[] objArr2 = {Integer.valueOf(_CREATION[i + i4])};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 1;
                    byte b2 = (byte) (b - 1);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, (char) (ImageFormat.getBitsPerPixel(0) + 9280), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1977, 1113883676, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                }
                try {
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i4), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 3;
                        byte b4 = (byte) (b3 - 3);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(29 - TextUtils.lastIndexOf("", '0'), (char) (49362 - KeyEvent.normalizeMetaState(0)), TextUtils.indexOf((CharSequence) "", '0') + 685, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i4] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    try {
                        Object[] objArr4 = {_creation, _creation};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            byte b6 = b5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 26, (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 30068), Color.alpha(0) + 816, 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
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
            cArr[_creation.b] = (char) jArr[_creation.b];
            try {
                Object[] objArr5 = {_creation, _creation};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) 0;
                    byte b8 = b7;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(24 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 30067), Process.getGidForName("") + 817, 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                int i5 = $10 + 81;
                $11 = i5 % 128;
                int i6 = i5 % 2;
            } catch (Throwable th4) {
                Throwable cause4 = th4.getCause();
                if (cause4 == null) {
                    throw th4;
                }
                throw cause4;
            }
        }
        String str = new String(cArr);
        int i7 = $11 + 115;
        $10 = i7 % 128;
        if (i7 % 2 == 0) {
            objArr[0] = str;
        } else {
            int i8 = 42 / 0;
            objArr[0] = str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x09d4  */
    /* JADX WARN: Code duplicated, block: B:104:0x09e6  */
    /* JADX WARN: Code duplicated, block: B:45:0x0613  */
    /* JADX WARN: Code duplicated, block: B:47:0x0619  */
    /* JADX WARN: Code duplicated, block: B:61:0x0722  */
    /* JADX WARN: Code duplicated, block: B:62:0x0735  */
    /* JADX WARN: Code duplicated, block: B:67:0x076b A[Catch: Exception -> 0x0a95, TRY_ENTER, TryCatch #2 {Exception -> 0x0a95, blocks: (B:52:0x06f2, B:58:0x0702, B:64:0x0750, B:67:0x076b, B:75:0x07f1, B:81:0x0865, B:68:0x0782, B:56:0x06fe), top: B:138:0x06f0 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0782 A[Catch: Exception -> 0x0a95, TRY_LEAVE, TryCatch #2 {Exception -> 0x0a95, blocks: (B:52:0x06f2, B:58:0x0702, B:64:0x0750, B:67:0x076b, B:75:0x07f1, B:81:0x0865, B:68:0x0782, B:56:0x06fe), top: B:138:0x06f0 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x07c1  */
    /* JADX WARN: Code duplicated, block: B:73:0x07d0  */
    /* JADX WARN: Code duplicated, block: B:78:0x0807 A[Catch: all -> 0x090d, TryCatch #5 {all -> 0x090d, blocks: (B:76:0x07fa, B:78:0x0807, B:79:0x0854), top: B:144:0x07fa, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x094d A[Catch: all -> 0x0a8c, TryCatch #4 {all -> 0x0a8c, blocks: (B:93:0x0940, B:95:0x094d, B:96:0x0993), top: B:142:0x0940, outer: #1 }] */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0a20, code lost:
    
        if (r0.equals((java.lang.String) r6[0]) != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0a22, code lost:
    
        r1 = new java.lang.Object[]{new int[]{r34}, new int[]{(r34 & (-11)) | (r20 & 10)}, new int[1], null};
        r0 = ~(new java.util.Random().nextInt() | 780073113);
        r0 = (r36 - (~(((((606754840 | r0) * (-196)) + 32844986) + ((r0 | 173318273) * 196)) + 16))) - 1;
        r2 = r0 << 13;
        r0 = ((~r0) & r2) | ((~r2) & r0);
        r2 = r0 >>> 17;
        r0 = (r0 | r2) & (~(r0 & r2));
        r2 = r0 << 5;
        ((int[]) r1[2])[0] = ((~r0) & r2) | ((~r2) & r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0909, code lost:
    
        if (((r0 & r1) | (r0 ^ r1)) == 1) goto L108;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r33, int r34, int r35, int r36) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3053
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhx.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
