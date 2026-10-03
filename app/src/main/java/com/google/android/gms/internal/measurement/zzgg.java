package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public final class zzgg {
    private static zzgj zza;

    public static zzgj zza() {
        zzgj zzgjVar;
        synchronized (zzgg.class) {
            if (zza == null) {
                zza(new zzgi());
            }
            zzgjVar = zza;
        }
        return zzgjVar;
    }

    private static void zza(zzgj zzgjVar) {
        synchronized (zzgg.class) {
            if (zza != null) {
                throw new IllegalStateException("init() already called");
            }
            zza = zzgjVar;
        }
    }
}
