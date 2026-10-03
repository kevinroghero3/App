package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjm;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
abstract class zzjj<T extends zzjm<T>> {
    zzjj() {
    }

    abstract int zza(Map.Entry<?, ?> entry);

    abstract zzjk<T> zza(Object obj);

    abstract Object zza(zzjh zzjhVar, zzlh zzlhVar, int i);

    abstract <UT, UB> UB zza(Object obj, zzlw zzlwVar, Object obj2, zzjh zzjhVar, zzjk<T> zzjkVar, UB ub, zzmu<UT, UB> zzmuVar) throws IOException;

    abstract void zza(zzih zzihVar, Object obj, zzjh zzjhVar, zzjk<T> zzjkVar) throws IOException;

    abstract void zza(zzlw zzlwVar, Object obj, zzjh zzjhVar, zzjk<T> zzjkVar) throws IOException;

    abstract void zza(zznu zznuVar, Map.Entry<?, ?> entry) throws IOException;

    abstract boolean zza(zzlh zzlhVar);

    abstract zzjk<T> zzb(Object obj);

    abstract void zzc(Object obj);
}
