package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzkl implements Runnable {
    private final /* synthetic */ zzax zza;
    private final /* synthetic */ zzja zzb;

    zzkl(zzja zzjaVar, zzax zzaxVar) {
        this.zza = zzaxVar;
        this.zzb = zzjaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.zzb.zzk().zza(this.zza)) {
            this.zzb.zzj().zzn().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(this.zza.zza()));
        } else if (this.zzb.zze().zza(zzbh.zzcp) && this.zzb.zzo().zzan()) {
            this.zzb.zzo().zzai();
        } else {
            this.zzb.zzo().zza(false);
        }
    }
}
