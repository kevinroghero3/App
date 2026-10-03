package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzld implements Runnable {
    private final /* synthetic */ zzkx zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzkw zzc;

    zzld(zzkw zzkwVar, zzkx zzkxVar, long j) {
        this.zza = zzkxVar;
        this.zzb = j;
        this.zzc = zzkwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        zzkw zzkwVar = this.zzc;
        zzkwVar.zza = null;
        zzkwVar.zzo().zza((zzkx) null);
    }
}
