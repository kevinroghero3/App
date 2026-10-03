package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzol implements zzom {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zzom
    public final boolean zza() {
        return true;
    }

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.disable_npa_for_dasher_and_unicorn", false);
        zzb = zzhqVarZza.zza("measurement.id.disable_npa_for_dasher_and_unicorn.client", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzom
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }
}
