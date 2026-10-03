package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzql;

/* JADX INFO: loaded from: classes5.dex */
final class zzkn implements Runnable {
    private final /* synthetic */ zzis zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzis zzd;
    private final /* synthetic */ zzja zze;

    zzkn(zzja zzjaVar, zzis zzisVar, long j, boolean z, zzis zzisVar2) {
        this.zza = zzisVar;
        this.zzb = j;
        this.zzc = z;
        this.zzd = zzisVar2;
        this.zze = zzjaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza(this.zza);
        zzja.zza(this.zze, this.zza, this.zzb, false, this.zzc);
        if (zzql.zza() && this.zze.zze().zza(zzbh.zzbr)) {
            zzja.zza(this.zze, this.zza, this.zzd);
        }
    }
}
