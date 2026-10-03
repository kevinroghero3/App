package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzod;
import com.google.android.gms.internal.measurement.zzql;

/* JADX INFO: loaded from: classes5.dex */
final class zzkk implements Runnable {
    private final /* synthetic */ zzis zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzis zze;
    private final /* synthetic */ zzja zzf;

    zzkk(zzja zzjaVar, zzis zzisVar, long j, long j2, boolean z, zzis zzisVar2) {
        this.zza = zzisVar;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = z;
        this.zze = zzisVar2;
        this.zzf = zzjaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzf.zza(this.zza);
        if (!zzod.zza() || !this.zzf.zze().zza(zzbh.zzdf)) {
            this.zzf.zza(this.zzb, false);
        }
        zzja.zza(this.zzf, this.zza, this.zzc, true, this.zzd);
        if (zzql.zza() && this.zzf.zze().zza(zzbh.zzbr)) {
            zzja.zza(this.zzf, this.zza, this.zze);
        }
    }
}
