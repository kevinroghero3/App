package com.google.android.gms.internal.mlkit_vision_common;

/* JADX INFO: loaded from: classes2.dex */
public final class zzms {
    private static zzmr zza;

    public static zzmj zza(zzme zzmeVar) {
        zzmj zzmjVar;
        synchronized (zzms.class) {
            if (zza == null) {
                zza = new zzmr(null);
            }
            zzmjVar = (zzmj) zza.get(zzmeVar);
        }
        return zzmjVar;
    }

    public static zzmj zzb(String str) {
        zzmj zzmjVarZza;
        synchronized (zzms.class) {
            zzmjVarZza = zza(zzme.zzd("vision-common").zzd());
        }
        return zzmjVarZza;
    }
}
