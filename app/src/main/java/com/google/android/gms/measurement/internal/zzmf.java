package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzmf implements Runnable {
    private final /* synthetic */ zzfq zza;
    private final /* synthetic */ zzma zzb;

    zzmf(zzma zzmaVar, zzfq zzfqVar) {
        this.zza = zzfqVar;
        this.zzb = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzak()) {
                this.zzb.zza.zzj().zzc().zza("Connected to remote service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
