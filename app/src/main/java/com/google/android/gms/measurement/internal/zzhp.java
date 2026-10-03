package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzhp implements Runnable {
    private final /* synthetic */ zziy zza;
    private final /* synthetic */ zzho zzb;

    zzhp(zzho zzhoVar, zziy zziyVar) {
        this.zza = zziyVar;
        this.zzb = zzhoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzho.zza(this.zzb, this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}
