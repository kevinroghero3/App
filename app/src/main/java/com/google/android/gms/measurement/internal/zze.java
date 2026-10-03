package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zze implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zza zzb;

    zze(zza zzaVar, long j) {
        this.zza = j;
        this.zzb = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
