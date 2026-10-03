package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzia implements Runnable {
    private final /* synthetic */ zzac zza;
    private final /* synthetic */ zzhs zzb;

    zzia(zzhs zzhsVar, zzac zzacVar) {
        this.zza = zzacVar;
        this.zzb = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzr();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zza(this.zza);
        } else {
            this.zzb.zza.zzb(this.zza);
        }
    }
}
