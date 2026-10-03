package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzqz implements zzra {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Boolean> zzb;
    private static final zzhi<Long> zzc;

    @Override // com.google.android.gms.internal.measurement.zzra
    public final boolean zza() {
        return true;
    }

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.tcf.client", false);
        zzb = zzhqVarZza.zza("measurement.tcf.service", false);
        zzc = zzhqVarZza.zza("measurement.id.tcf.service", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzra
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzra
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }
}
