package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
final class zzlk implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zznv zzc;
    private final /* synthetic */ zzlf zzd;

    zzlk(zzlf zzlfVar, zzn zznVar, boolean z, zznv zznvVar) {
        this.zza = zznVar;
        this.zzb = z;
        this.zzc = zznvVar;
        this.zzd = zzlfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfq zzfqVar = this.zzd.zzb;
        if (zzfqVar == null) {
            this.zzd.zzj().zzg().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        this.zzd.zza(zzfqVar, this.zzb ? null : this.zzc, this.zza);
        this.zzd.zzaq();
    }
}
