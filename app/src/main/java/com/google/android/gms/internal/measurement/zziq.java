package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
final class zziq {
    private final zzjb zza;
    private final byte[] zzb;

    public final zzih zza() {
        this.zza.zzb();
        return new zziu(this.zzb);
    }

    public final zzjb zzb() {
        return this.zza;
    }

    private zziq(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzjb.zzb(bArr);
    }
}
