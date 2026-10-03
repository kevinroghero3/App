package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzqs implements zzqp {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Boolean> zzb;
    private static final zzhi<Boolean> zzc;
    private static final zzhi<Boolean> zzd;
    private static final zzhi<Boolean> zze;
    private static final zzhi<Long> zzf;

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.client.sessions.background_sessions_enabled", true);
        zzb = zzhqVarZza.zza("measurement.client.sessions.enable_fix_background_engagement", false);
        zzc = zzhqVarZza.zza("measurement.client.sessions.immediate_start_enabled_foreground", true);
        zzd = zzhqVarZza.zza("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        zze = zzhqVarZza.zza("measurement.client.sessions.session_id_enabled", true);
        zzf = zzhqVarZza.zza("measurement.id.client.sessions.enable_fix_background_engagement", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzqp
    public final boolean zza() {
        return zzb.zza().booleanValue();
    }
}
