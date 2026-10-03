package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
abstract class zzkm {
    private static final zzkm zza = new zzkp();
    private static final zzkm zzb = new zzkr();

    static zzkm zza() {
        return zza;
    }

    abstract <L> List<L> zza(Object obj, long j);

    abstract <L> void zza(Object obj, Object obj2, long j);

    abstract void zzb(Object obj, long j);

    static zzkm zzb() {
        return zzb;
    }

    private zzkm() {
    }
}
