package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzc implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zza zzc;

    zzc(zza zzaVar, String str, long j) {
        this.zza = str;
        this.zzb = j;
        this.zzc = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zza.zza(this.zzc, this.zza, this.zzb);
    }
}
