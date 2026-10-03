package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: loaded from: classes2.dex */
public final class zzxa {
    private static zzwz zza;

    public static zzwp zza(zzwh zzwhVar) {
        zzwp zzwpVar;
        synchronized (zzxa.class) {
            if (zza == null) {
                zza = new zzwz(null);
            }
            zzwpVar = (zzwp) zza.get(zzwhVar);
        }
        return zzwpVar;
    }

    public static zzwp zzb(String str) {
        zzwp zzwpVarZza;
        synchronized (zzxa.class) {
            zzwpVarZza = zza(zzwh.zzd(str).zzd());
        }
        return zzwpVarZza;
    }
}
