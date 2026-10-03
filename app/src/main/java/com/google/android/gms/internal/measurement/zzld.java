package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class zzld implements zzla {
    @Override // com.google.android.gms.internal.measurement.zzla
    public final int zza(int i, Object obj, Object obj2) {
        zzlb zzlbVar = (zzlb) obj;
        if (zzlbVar.isEmpty()) {
            return 0;
        }
        Iterator it2 = zzlbVar.entrySet().iterator();
        if (!it2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final zzky<?, ?> zza(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final Object zza(Object obj, Object obj2) {
        zzlb zzlbVarZzb = (zzlb) obj;
        zzlb zzlbVar = (zzlb) obj2;
        if (!zzlbVar.isEmpty()) {
            if (!zzlbVarZzb.zzd()) {
                zzlbVarZzb = zzlbVarZzb.zzb();
            }
            zzlbVarZzb.zza(zzlbVar);
        }
        return zzlbVarZzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final Object zzb(Object obj) {
        return zzlb.zza().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final Object zzc(Object obj) {
        ((zzlb) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final Map<?, ?> zzd(Object obj) {
        return (zzlb) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final Map<?, ?> zze(Object obj) {
        return (zzlb) obj;
    }

    zzld() {
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final boolean zzf(Object obj) {
        return !((zzlb) obj).zzd();
    }
}
