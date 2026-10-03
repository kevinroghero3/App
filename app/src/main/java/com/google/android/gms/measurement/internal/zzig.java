package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzod;

/* JADX INFO: loaded from: classes5.dex */
final class zzig implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzhs zzb;

    zzig(zzhs zzhsVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.zzb.zza.zzr();
        zzng zzngVar = this.zzb.zza;
        zzn zznVar = this.zza;
        zzngVar.zzl().zzt();
        zzngVar.zzs();
        Preconditions.checkNotEmpty(zznVar.zza);
        if (zzngVar.zze().zza(zzbh.zzcp)) {
            zzngVar.zzf(zznVar);
            zzngVar.zze(zznVar);
            return;
        }
        zzis zzisVarZza = zzis.zza(zznVar.zzt, zznVar.zzy);
        zzis zzisVarZzb = zzngVar.zzb(zznVar.zza);
        zzngVar.zzj().zzp().zza("Setting consent, package, consent", zznVar.zza, zzisVarZza);
        zzngVar.zza(zznVar.zza, zzisVarZza);
        if ((!zzod.zza() || !zzngVar.zze().zza(zzbh.zzdg)) && zzisVarZza.zzc(zzisVarZzb)) {
            zzngVar.zzd(zznVar);
        }
        zzax zzaxVarZza = zzax.zza(zznVar.zzz);
        if (zzax.zza.equals(zzaxVarZza)) {
            return;
        }
        zzngVar.zzj().zzp().zza("Setting DMA consent. package, consent", zznVar.zza, zzaxVarZza);
        zzngVar.zza(zznVar.zza, zzaxVarZza);
    }
}
