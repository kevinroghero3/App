package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzre implements zzrb {
    private static final zzhi<Boolean> zza = new zzhq(zzhf.zza("com.google.android.gms.measurement")).zzb().zza().zza("measurement.integration.disable_firebase_instance_id", false);

    @Override // com.google.android.gms.internal.measurement.zzrb
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzrb
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }
}
