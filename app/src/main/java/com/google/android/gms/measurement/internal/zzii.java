package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzii implements Runnable {
    private final /* synthetic */ zzbf zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzhs zzc;

    zzii(zzhs zzhsVar, zzbf zzbfVar, zzn zznVar) {
        this.zza = zzbfVar;
        this.zzb = zznVar;
        this.zzc = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzc(this.zzc.zzb(this.zza, this.zzb), this.zzb);
    }
}
