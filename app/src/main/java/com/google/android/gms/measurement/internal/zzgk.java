package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzgk implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzgl zzb;

    zzgk(zzgl zzglVar, boolean z) {
        this.zza = z;
        this.zzb = zzglVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zza(this.zza);
    }
}
