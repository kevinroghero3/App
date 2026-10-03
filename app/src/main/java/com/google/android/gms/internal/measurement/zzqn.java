package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzqn implements zzqo {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Boolean> zzb;
    private static final zzhi<Boolean> zzc;
    private static final zzhi<Boolean> zzd;

    @Override // com.google.android.gms.internal.measurement.zzqo
    public final boolean zza() {
        return true;
    }

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.collection.enable_session_stitching_token.client.dev", true);
        zzb = zzhqVarZza.zza("measurement.collection.enable_session_stitching_token.first_open_fix", true);
        zzc = zzhqVarZza.zza("measurement.session_stitching_token_enabled", false);
        zzd = zzhqVarZza.zza("measurement.link_sst_to_sid", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzqo
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqo
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqo
    public final boolean zzd() {
        return zzc.zza().booleanValue();
    }
}
