package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzij implements Runnable {
    private final /* synthetic */ zznv zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzhs zzc;

    zzij(zzhs zzhsVar, zznv zznvVar, zzn zznVar) {
        this.zza = zznvVar;
        this.zzb = zznVar;
        this.zzc = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzr();
        if (this.zza.zza() == null) {
            this.zzc.zza.zza(this.zza.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
