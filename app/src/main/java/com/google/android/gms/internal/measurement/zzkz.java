package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class zzkz<K, V> {
    static <K, V> int zza(zzky<K, V> zzkyVar, K k, V v) {
        return zzjk.zza(zzkyVar.zza, 1, k) + zzjk.zza(zzkyVar.zzc, 2, v);
    }

    static <K, V> void zza(zzjb zzjbVar, zzky<K, V> zzkyVar, K k, V v) throws IOException {
        zzjk.zza(zzjbVar, zzkyVar.zza, 1, k);
        zzjk.zza(zzjbVar, zzkyVar.zzc, 2, v);
    }
}
