package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzpd implements zzpe {
    private static final zzhi<Boolean> zza;
    private static final zzhi<Boolean> zzb;
    private static final zzhi<Boolean> zzc;

    @Override // com.google.android.gms.internal.measurement.zzpe
    public final boolean zza() {
        return true;
    }

    static {
        zzhq zzhqVarZza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhqVarZza.zza("measurement.client.sessions.check_on_reset_and_enable2", true);
        zzb = zzhqVarZza.zza("measurement.client.sessions.check_on_startup", true);
        zzc = zzhqVarZza.zza("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzpe
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }
}
