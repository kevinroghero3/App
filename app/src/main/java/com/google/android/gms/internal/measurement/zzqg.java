package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzqg implements zzqd {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Boolean> zzb;
    private static final zzhi<Boolean> zzc;
    private static final zzhi<Boolean> zzd;
    private static final zzhi<Boolean> zze;
    private static final zzhi<Boolean> zzf;
    private static final zzhi<Boolean> zzg;
    private static final zzhi<Boolean> zzh;
    private static final zzhi<Boolean> zzi;
    private static final zzhi<Boolean> zzj;
    private static final zzhi<Boolean> zzk;
    private static final zzhi<Boolean> zzl;
    private static final zzhi<Boolean> zzm;
    private static final zzhi<Boolean> zzn;

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.redaction.app_instance_id", true);
        zzb = zzhqVarZza.zza("measurement.redaction.client_ephemeral_aiid_generation", true);
        zzc = zzhqVarZza.zza("measurement.redaction.config_redacted_fields", true);
        zzd = zzhqVarZza.zza("measurement.redaction.device_info", true);
        zze = zzhqVarZza.zza("measurement.redaction.e_tag", true);
        zzf = zzhqVarZza.zza("measurement.redaction.enhanced_uid", true);
        zzg = zzhqVarZza.zza("measurement.redaction.populate_ephemeral_app_instance_id", true);
        zzh = zzhqVarZza.zza("measurement.redaction.google_signals", true);
        zzi = zzhqVarZza.zza("measurement.redaction.no_aiid_in_config_request", true);
        zzj = zzhqVarZza.zza("measurement.redaction.retain_major_os_version", true);
        zzk = zzhqVarZza.zza("measurement.redaction.scion_payload_generator", true);
        zzl = zzhqVarZza.zza("measurement.redaction.upload_redacted_fields", true);
        zzm = zzhqVarZza.zza("measurement.redaction.upload_subdomain_override", true);
        zzn = zzhqVarZza.zza("measurement.redaction.user_id", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzqd
    public final boolean zza() {
        return zzj.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqd
    public final boolean zzb() {
        return zzk.zza().booleanValue();
    }
}
