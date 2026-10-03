package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzmq {
    final /* synthetic */ zzmp zza;
    private zzmt zzb;

    zzmq(zzmp zzmpVar) {
        this.zza = zzmpVar;
    }

    final void zza(long j) {
        this.zzb = new zzmt(this, this.zza.zzb().currentTimeMillis(), j);
        this.zza.zzc.postDelayed(this.zzb, 2000L);
    }

    final void zza() {
        this.zza.zzt();
        if (this.zzb != null) {
            this.zza.zzc.removeCallbacks(this.zzb);
        }
        this.zza.zzk().zzn.zza(false);
        this.zza.zza(false);
    }
}
