package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
final class zzlx implements zzlf {
    private final zzlh zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    @Override // com.google.android.gms.internal.measurement.zzlf
    public final zzlh zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzlf
    public final zzls zzb() {
        int i = this.zzd;
        if ((i & 1) != 0) {
            return zzls.PROTO2;
        }
        return (i & 4) == 4 ? zzls.EDITIONS : zzls.PROTO3;
    }

    final String zzd() {
        return this.zzb;
    }

    zzlx(zzlh zzlhVar, String str, Object[] objArr) {
        this.zza = zzlhVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 1;
        int i3 = 13;
        while (true) {
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 < 55296) {
                this.zzd = i | (cCharAt2 << i3);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i2++;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlf
    public final boolean zzc() {
        return (this.zzd & 2) == 2;
    }

    final Object[] zze() {
        return this.zzc;
    }
}
