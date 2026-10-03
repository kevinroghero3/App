package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzau implements Runnable {
    private final /* synthetic */ zziq zza;
    private final /* synthetic */ zzav zzb;

    zzau(zzav zzavVar, zziq zziqVar) {
        this.zza = zziqVar;
        this.zzb = zzavVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzd();
        if (zzad.zza()) {
            this.zza.zzl().zzb(this);
            return;
        }
        boolean zZzc = this.zzb.zzc();
        this.zzb.zzd = 0L;
        if (zZzc) {
            this.zzb.zzb();
        }
    }
}
