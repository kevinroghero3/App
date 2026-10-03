package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes4.dex */
final class zzgh implements zzfu {
    private final zzfx zza;
    private final String zzb = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a";
    private final Object[] zzc;
    private final int zzd;

    zzgh(zzfx zzfxVar, String str, Object[] objArr) {
        this.zza = zzfxVar;
        this.zzc = objArr;
        char cCharAt = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a".charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            char cCharAt2 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a".charAt(i3);
            if (cCharAt2 < 55296) {
                this.zzd = (cCharAt2 << i2) | i;
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3++;
            }
        }
    }

    @Override // com.google.android.gms.internal.auth.zzfu
    public final zzfx zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.auth.zzfu
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.auth.zzfu
    public final int zzc() {
        return (this.zzd & 1) != 0 ? 1 : 2;
    }

    final String zzd() {
        return this.zzb;
    }

    final Object[] zze() {
        return this.zzc;
    }
}
