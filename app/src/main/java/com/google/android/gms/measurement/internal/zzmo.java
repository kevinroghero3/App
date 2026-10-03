package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzmo implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzmp zzb;

    zzmo(zzmp zzmpVar, long j) {
        this.zza = j;
        this.zzb = zzmpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzmp.zzb(this.zzb, this.zza);
    }
}
