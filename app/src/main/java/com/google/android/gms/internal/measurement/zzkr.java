package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class zzkr extends zzkm {
    private static <E> zzkd<E> zzc(Object obj, long j) {
        return (zzkd) zzna.zze(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    final <L> List<L> zza(Object obj, long j) {
        zzkd zzkdVarZzc = zzc(obj, j);
        if (zzkdVarZzc.zzc()) {
            return zzkdVarZzc;
        }
        int size = zzkdVarZzc.size();
        zzkd zzkdVarZza = zzkdVarZzc.zza(size == 0 ? 10 : size << 1);
        zzna.zza(obj, j, zzkdVarZza);
        return zzkdVarZza;
    }

    private zzkr() {
        super();
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    final <E> void zza(Object obj, Object obj2, long j) {
        zzkd zzkdVarZzc = zzc(obj, j);
        zzkd zzkdVarZzc2 = zzc(obj2, j);
        int size = zzkdVarZzc.size();
        int size2 = zzkdVarZzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzkdVarZzc.zzc()) {
                zzkdVarZzc = zzkdVarZzc.zza(size2 + size);
            }
            zzkdVarZzc.addAll(zzkdVarZzc2);
        }
        if (size > 0) {
            zzkdVarZzc2 = zzkdVarZzc;
        }
        zzna.zza(obj, j, zzkdVarZzc2);
    }
}
