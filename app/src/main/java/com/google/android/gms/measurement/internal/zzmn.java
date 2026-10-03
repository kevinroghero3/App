package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzmn implements Runnable {
    private final /* synthetic */ zzng zza;
    private final /* synthetic */ Runnable zzb;

    zzmn(zzmi zzmiVar, zzng zzngVar, Runnable runnable) {
        this.zza = zzngVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzr();
        this.zza.zza(this.zzb);
        this.zza.zzw();
    }
}
