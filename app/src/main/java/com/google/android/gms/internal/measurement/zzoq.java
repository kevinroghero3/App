package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzoq implements zzon {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Boolean> zzb;
    private static final zzhi<Boolean> zzc;
    private static final zzhi<Boolean> zzd;
    private static final zzhi<Boolean> zze;
    private static final zzhi<Boolean> zzf;
    private static final zzhi<Boolean> zzg;
    private static final zzhi<Boolean> zzh;
    private static final zzhi<Long> zzi;
    private static final zzhi<Long> zzj;

    @Override // com.google.android.gms.internal.measurement.zzon
    public final boolean zza() {
        return true;
    }

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.dma_consent.client", true);
        zzb = zzhqVarZza.zza("measurement.dma_consent.client_bow_check2", true);
        zzc = zzhqVarZza.zza("measurement.dma_consent.separate_service_calls_fix", false);
        zzd = zzhqVarZza.zza("measurement.dma_consent.service", true);
        zze = zzhqVarZza.zza("measurement.dma_consent.service_dcu_event", true);
        zzf = zzhqVarZza.zza("measurement.dma_consent.service_npa_remote_default", true);
        zzg = zzhqVarZza.zza("measurement.dma_consent.service_split_batch_on_consent", true);
        zzh = zzhqVarZza.zza("measurement.dma_consent.set_consent_inline_on_worker", false);
        zzi = zzhqVarZza.zza("measurement.id.dma_consent.separate_service_calls_fix", 0L);
        zzj = zzhqVarZza.zza("measurement.id.dma_consent.service_dcu_event", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final boolean zzb() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final boolean zzc() {
        return zzc.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final boolean zzd() {
        return zze.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final boolean zze() {
        return zzh.zza().booleanValue();
    }
}
