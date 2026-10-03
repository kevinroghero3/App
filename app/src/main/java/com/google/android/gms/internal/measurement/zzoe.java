package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzoe implements zzob {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Boolean> zzb;
    private static final zzhi<Boolean> zzc;
    private static final zzhi<Long> zzd;

    @Override // com.google.android.gms.internal.measurement.zzob
    public final long zza() {
        return zzd.zza().longValue();
    }

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.client.consent_state_v1", true);
        zzb = zzhqVarZza.zza("measurement.client.3p_consent_state_v1", true);
        zzc = zzhqVarZza.zza("measurement.service.consent_state_v1_W36", true);
        zzd = zzhqVarZza.zza("measurement.service.storage_consent_support_version", 203600L);
    }
}
