package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
final class zzij implements Comparator<zzih> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzih zzihVar, zzih zzihVar2) {
        zzih zzihVar3 = zzihVar;
        zzih zzihVar4 = zzihVar2;
        zzin zzinVar = (zzin) zzihVar3.iterator();
        zzin zzinVar2 = (zzin) zzihVar4.iterator();
        while (zzinVar.hasNext() && zzinVar2.hasNext()) {
            int iCompareTo = Integer.valueOf(zzih.zza(zzinVar.zza())).compareTo(Integer.valueOf(zzih.zza(zzinVar2.zza())));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzihVar3.zzb()).compareTo(Integer.valueOf(zzihVar4.zzb()));
    }

    zzij() {
    }
}
