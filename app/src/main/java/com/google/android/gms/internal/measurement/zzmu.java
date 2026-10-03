package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
abstract class zzmu<T, B> {
    zzmu() {
    }

    abstract int zza(T t);

    abstract B zza();

    abstract T zza(T t, T t2);

    abstract void zza(B b, int i, int i2);

    abstract void zza(B b, int i, long j);

    abstract void zza(B b, int i, zzih zzihVar);

    abstract void zza(B b, int i, T t);

    abstract void zza(T t, zznu zznuVar) throws IOException;

    abstract boolean zza(zzlw zzlwVar);

    abstract int zzb(T t);

    abstract void zzb(B b, int i, long j);

    abstract void zzb(T t, zznu zznuVar) throws IOException;

    abstract void zzb(Object obj, B b);

    abstract B zzc(Object obj);

    abstract void zzc(Object obj, T t);

    abstract T zzd(Object obj);

    abstract T zze(B b);

    abstract void zzf(Object obj);

    final boolean zza(B b, zzlw zzlwVar) throws IOException {
        int iZzd = zzlwVar.zzd();
        int i = iZzd >>> 3;
        int i2 = iZzd & 7;
        if (i2 == 0) {
            zzb(b, i, zzlwVar.zzl());
            return true;
        }
        if (i2 == 1) {
            zza(b, i, zzlwVar.zzk());
            return true;
        }
        if (i2 == 2) {
            zza((Object) b, i, zzlwVar.zzp());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzkc.zza();
            }
            zza((Object) b, i, zzlwVar.zzf());
            return true;
        }
        B bZza = zza();
        while (zzlwVar.zzc() != Integer.MAX_VALUE && zza((Object) bZza, zzlwVar)) {
        }
        if ((4 | (i << 3)) != zzlwVar.zzd()) {
            throw zzkc.zzb();
        }
        zza(b, i, zze(bZza));
        return true;
    }
}
