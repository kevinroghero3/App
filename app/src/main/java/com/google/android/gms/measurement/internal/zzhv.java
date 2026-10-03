package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzhv implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzhs zzb;

    zzhv(zzhs zzhsVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.zzb.zza.zzr();
        this.zzb.zza.zzc(this.zza);
    }
}
