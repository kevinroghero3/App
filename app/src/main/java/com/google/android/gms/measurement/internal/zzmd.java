package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzmd implements Runnable {
    private final /* synthetic */ zzfq zza;
    private final /* synthetic */ zzma zzb;

    zzmd(zzma zzmaVar, zzfq zzfqVar) {
        this.zza = zzfqVar;
        this.zzb = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzak()) {
                this.zzb.zza.zzj().zzp().zza("Connected to service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
