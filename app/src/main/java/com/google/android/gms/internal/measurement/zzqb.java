package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzqb implements zzqc {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Boolean> zzb;
    private static final zzhi<Boolean> zzc;
    private static final zzhi<Boolean> zzd;
    private static final zzhi<Boolean> zze;
    private static final zzhi<Boolean> zzf;
    private static final zzhi<Boolean> zzg;
    private static final zzhi<Long> zzh;
    private static final zzhi<Boolean> zzi;

    @Override // com.google.android.gms.internal.measurement.zzqc
    public final boolean zza() {
        return true;
    }

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.rb.attribution.client2", true);
        zzb = zzhqVarZza.zza("measurement.rb.attribution.dma_fix", true);
        zzc = zzhqVarZza.zza("measurement.rb.attribution.followup1.service", false);
        zzd = zzhqVarZza.zza("measurement.rb.attribution.index_out_of_bounds_fix", false);
        zze = zzhqVarZza.zza("measurement.rb.attribution.service", true);
        zzf = zzhqVarZza.zza("measurement.rb.attribution.enable_trigger_redaction", true);
        zzg = zzhqVarZza.zza("measurement.rb.attribution.uuid_generation", true);
        zzh = zzhqVarZza.zza("measurement.id.rb.attribution.index_out_of_bounds_fix", 0L);
        zzi = zzhqVarZza.zza("measurement.rb.attribution.improved_retry", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzqc
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqc
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqc
    public final boolean zzd() {
        return zzc.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqc
    public final boolean zze() {
        return zzd.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqc
    public final boolean zzf() {
        return zze.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqc
    public final boolean zzg() {
        return zzf.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqc
    public final boolean zzh() {
        return zzg.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqc
    public final boolean zzi() {
        return zzi.zza().booleanValue();
    }
}
