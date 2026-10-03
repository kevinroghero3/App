package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zznj implements Runnable {
    private final /* synthetic */ zznq zza;
    private final /* synthetic */ zzng zzb;

    zznj(zzng zzngVar, zznq zznqVar) {
        this.zza = zznqVar;
        this.zzb = zzngVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzng.zza(this.zzb, this.zza);
        this.zzb.zzv();
    }
}
