package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzpo implements zzpl {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zzpl
    public final boolean zza() {
        return true;
    }

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.increase_param_lengths", false);
        zzb = zzhqVarZza.zza("measurement.id.increase_param_lengths", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzpl
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }
}
