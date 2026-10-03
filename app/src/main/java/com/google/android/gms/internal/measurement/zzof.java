package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzof implements zzog {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Boolean> zzb;

    @Override // com.google.android.gms.internal.measurement.zzog
    public final boolean zza() {
        return true;
    }

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.consent.stop_reset_on_storage_denied.client.dev", false);
        zzb = zzhqVarZza.zza("measurement.consent.stop_reset_on_storage_denied.service", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzog
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzog
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }
}
