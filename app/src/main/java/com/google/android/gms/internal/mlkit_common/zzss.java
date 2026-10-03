package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: loaded from: classes4.dex */
public final class zzss {
    private static zzsr zza;

    public static zzsh zza(zzsb zzsbVar) {
        zzsh zzshVar;
        synchronized (zzss.class) {
            if (zza == null) {
                zza = new zzsr(null);
            }
            zzshVar = (zzsh) zza.get(zzsbVar);
        }
        return zzshVar;
    }

    public static zzsh zzb(String str) {
        zzsh zzshVarZza;
        synchronized (zzss.class) {
            zzshVarZza = zza(zzsb.zzd("common").zzd());
        }
        return zzshVarZza;
    }
}
