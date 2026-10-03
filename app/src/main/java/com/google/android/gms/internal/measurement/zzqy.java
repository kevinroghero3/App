package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzqy implements zzqv {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Boolean> zzb;

    @Override // com.google.android.gms.internal.measurement.zzqv
    public final boolean zza() {
        return true;
    }

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.sgtm.preview_mode_enabled", false);
        zzb = zzhqVarZza.zza("measurement.sgtm.service", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzqv
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqv
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }
}
