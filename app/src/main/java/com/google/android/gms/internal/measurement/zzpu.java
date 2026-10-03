package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzpu implements zzpr {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Boolean> zzb;
    private static final zzhi<Boolean> zzc;
    private static final zzhi<Long> zzd;

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzb = zzhqVarZza.zza("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzc = zzhqVarZza.zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzd = zzhqVarZza.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzpr
    public final boolean zza() {
        return zzc.zza().booleanValue();
    }
}
