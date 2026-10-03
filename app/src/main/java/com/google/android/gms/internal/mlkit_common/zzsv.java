package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: loaded from: classes2.dex */
public final class zzsv {
    private static zzsv zza;

    private zzsv() {
    }

    public static zzsv zza() {
        zzsv zzsvVar;
        synchronized (zzsv.class) {
            if (zza == null) {
                zza = new zzsv();
            }
            zzsvVar = zza;
        }
        return zzsvVar;
    }

    public static void zzb() {
        zzsu.zza();
    }
}
