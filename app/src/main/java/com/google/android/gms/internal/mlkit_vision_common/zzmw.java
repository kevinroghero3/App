package com.google.android.gms.internal.mlkit_vision_common;

/* JADX INFO: loaded from: classes2.dex */
public final class zzmw {
    private static zzmw zza;

    private zzmw() {
    }

    public static zzmw zza() {
        zzmw zzmwVar;
        synchronized (zzmw.class) {
            if (zza == null) {
                zza = new zzmw();
            }
            zzmwVar = zza;
        }
        return zzmwVar;
    }

    public static final boolean zzb() {
        return zzmv.zza("mlkit-dev-profiling");
    }
}
