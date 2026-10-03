package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzjt implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzja zzb;

    zzjt(zzja zzjaVar, long j) {
        this.zza = j;
        this.zzb = zzjaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzk().zzf.zza(this.zza);
        this.zzb.zzj().zzc().zza("Session timeout duration set", Long.valueOf(this.zza));
    }
}
