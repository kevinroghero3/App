package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes4.dex */
public final class zzjx {
    public static final byte[] zzb;
    private static final ByteBuffer zze;
    private static final zziv zzf;
    private static final Charset zzc = Charset.forName(CharEncoding.US_ASCII);
    static final Charset zza = Charset.forName(CharEncoding.UTF_8);
    private static final Charset zzd = Charset.forName(CharEncoding.ISO_8859_1);

    public static int zza(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        int iZza = zza(length, bArr, 0, length);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static <T> T zza(T t) {
        t.getClass();
        return t;
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static String zzb(byte[] bArr) {
        return new String(bArr, zza);
    }

    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        zze = ByteBuffer.wrap(bArr);
        zzf = zziv.zza(bArr, 0, 0, false);
    }

    static boolean zza(zzlh zzlhVar) {
        boolean z = zzlhVar instanceof zzhz;
        return false;
    }

    public static boolean zzc(byte[] bArr) {
        return zzne.zza(bArr);
    }
}
