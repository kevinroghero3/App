package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzla implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzkw zzb;

    zzla(zzkw zzkwVar, long j) {
        this.zza = j;
        this.zzb = zzkwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc().zza(this.zza);
        this.zzb.zza = null;
    }
}
