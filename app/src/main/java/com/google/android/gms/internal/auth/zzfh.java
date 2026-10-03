package com.google.android.gms.internal.auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class zzfh extends zzfl {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzfh() {
        super(null);
    }

    /* synthetic */ zzfh(zzfg zzfgVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.auth.zzfl
    final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzhj.zzf(obj, j);
        if (list instanceof zzff) {
            objUnmodifiableList = ((zzff) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzge) && (list instanceof zzez)) {
                zzez zzezVar = (zzez) list;
                if (zzezVar.zzc()) {
                    zzezVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzhj.zzp(obj, j, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.auth.zzfl
    final void zzb(Object obj, Object obj2, long j) {
        List list;
        List list2;
        List listZzd;
        List list3 = (List) zzhj.zzf(obj2, j);
        int size = list3.size();
        List list4 = (List) zzhj.zzf(obj, j);
        if (list4.isEmpty()) {
            if (list4 instanceof zzff) {
                listZzd = new zzfe(size);
            } else {
                listZzd = ((list4 instanceof zzge) && (list4 instanceof zzez)) ? ((zzez) list4).zzd(size) : new ArrayList(size);
            }
            zzhj.zzp(obj, j, listZzd);
            list2 = listZzd;
        } else {
            if (zza.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                zzhj.zzp(obj, j, arrayList);
                list = arrayList;
            } else if (list4 instanceof zzhe) {
                zzfe zzfeVar = new zzfe(list4.size() + size);
                zzfeVar.addAll(zzfeVar.size(), (zzhe) list4);
                zzhj.zzp(obj, j, zzfeVar);
                list = zzfeVar;
            } else if ((list4 instanceof zzge) && (list4 instanceof zzez)) {
                zzez zzezVar = (zzez) list4;
                if (!zzezVar.zzc()) {
                    list2 = list4;
                    list2 = list4;
                    list2 = list4;
                    zzez zzezVarZzd = zzezVar.zzd(list4.size() + size);
                    zzhj.zzp(obj, j, zzezVarZzd);
                    list2 = zzezVarZzd;
                }
            }
            list2 = list;
        }
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        int size2 = list2.size();
        int size3 = list3.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list3);
        }
        if (size2 > 0) {
            list3 = list2;
        }
        zzhj.zzp(obj, j, list3);
    }
}
