package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzow implements zzot {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Boolean> zzb;
    private static final zzhi<Boolean> zzc;
    private static final zzhi<Boolean> zzd;
    private static final zzhi<Boolean> zze;
    private static final zzhi<Boolean> zzf;
    private static final zzhi<Long> zzg;

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.client.ad_id_consent_fix", true);
        zzb = zzhqVarZza.zza("measurement.service.consent.aiid_reset_fix", false);
        zzc = zzhqVarZza.zza("measurement.service.consent.aiid_reset_fix2", true);
        zzd = zzhqVarZza.zza("measurement.service.consent.app_start_fix", true);
        zze = zzhqVarZza.zza("measurement.service.consent.params_on_fx", false);
        zzf = zzhqVarZza.zza("measurement.service.consent.pfo_on_fx", true);
        zzg = zzhqVarZza.zza("measurement.id.service.consent.params_on_fx", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzot
    public final boolean zza() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzot
    public final boolean zzb() {
        return zzc.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzot
    public final boolean zzc() {
        return zzd.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzot
    public final boolean zzd() {
        return zze.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzot
    public final boolean zze() {
        return zzf.zza().booleanValue();
    }
}
