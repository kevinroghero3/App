package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class zzkp extends zzkm {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzna.zze(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        Object obj2;
        List<L> arrayList;
        List<L> listZzc = zzc(obj, j);
        if (listZzc.isEmpty()) {
            if (listZzc instanceof zzkn) {
                arrayList = new zzkk(i);
            } else if ((listZzc instanceof zzlt) && (listZzc instanceof zzkd)) {
                arrayList = ((zzkd) listZzc).zza(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            zzna.zza(obj, j, arrayList);
            return arrayList;
        }
        if (zza.isAssignableFrom(listZzc.getClass())) {
            ArrayList arrayList2 = new ArrayList(listZzc.size() + i);
            arrayList2.addAll(listZzc);
            zzna.zza(obj, j, arrayList2);
            obj2 = arrayList2;
        } else if (listZzc instanceof zzmz) {
            zzkk zzkkVar = new zzkk(listZzc.size() + i);
            zzkkVar.addAll((zzmz) listZzc);
            zzna.zza(obj, j, zzkkVar);
            obj2 = zzkkVar;
        } else {
            if (!(listZzc instanceof zzlt) || !(listZzc instanceof zzkd)) {
                return listZzc;
            }
            zzkd zzkdVar = (zzkd) listZzc;
            if (zzkdVar.zzc()) {
                return listZzc;
            }
            zzkd zzkdVarZza = zzkdVar.zza(listZzc.size() + i);
            zzna.zza(obj, j, zzkdVarZza);
            return zzkdVarZza;
        }
        return (List<L>) obj2;
    }

    private zzkp() {
        super();
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzna.zze(obj, j);
        if (list instanceof zzkn) {
            objUnmodifiableList = ((zzkn) list).zzd();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzlt) && (list instanceof zzkd)) {
                zzkd zzkdVar = (zzkd) list;
                if (zzkdVar.zzc()) {
                    zzkdVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzna.zza(obj, j, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    final <E> void zza(Object obj, Object obj2, long j) {
        List listZzc = zzc(obj2, j);
        List listZza = zza(obj, j, listZzc.size());
        int size = listZza.size();
        int size2 = listZzc.size();
        if (size > 0 && size2 > 0) {
            listZza.addAll(listZzc);
        }
        if (size > 0) {
            listZzc = listZza;
        }
        zzna.zza(obj, j, listZzc);
    }
}
