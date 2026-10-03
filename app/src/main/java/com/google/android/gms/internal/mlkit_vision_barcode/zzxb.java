package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: loaded from: classes2.dex */
public final class zzxb {
    private static zzxb zza;

    private zzxb() {
    }

    public static zzxb zza() {
        zzxb zzxbVar;
        synchronized (zzxb.class) {
            if (zza == null) {
                zza = new zzxb();
            }
            zzxbVar = zza;
        }
        return zzxbVar;
    }
}
