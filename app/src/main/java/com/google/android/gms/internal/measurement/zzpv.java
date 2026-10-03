package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzpv implements zzpw {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Double> zzb;
    private static final zzhi<Long> zzc;
    private static final zzhi<Long> zzd;
    private static final zzhi<String> zze;

    @Override // com.google.android.gms.internal.measurement.zzpw
    public final double zza() {
        return zzb.zza().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpw
    public final long zzb() {
        return zzc.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpw
    public final long zzc() {
        return zzd.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpw
    public final String zzd() {
        return zze.zza();
    }

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.test.boolean_flag", false);
        zzb = zzhqVarZza.zza("measurement.test.double_flag", -3.0d);
        zzc = zzhqVarZza.zza("measurement.test.int_flag", -2L);
        zzd = zzhqVarZza.zza("measurement.test.long_flag", -1L);
        zze = zzhqVarZza.zza("measurement.test.string_flag", "---");
    }

    @Override // com.google.android.gms.internal.measurement.zzpw
    public final boolean zze() {
        return zza.zza().booleanValue();
    }
}
