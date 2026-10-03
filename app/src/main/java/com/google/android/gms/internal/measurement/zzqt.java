package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzqt implements zzqu {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Boolean> zzb;

    @Override // com.google.android.gms.internal.measurement.zzqu
    public final boolean zza() {
        return true;
    }

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.sfmc.client", true);
        zzb = zzhqVarZza.zza("measurement.sfmc.service", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzqu
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqu
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }
}
