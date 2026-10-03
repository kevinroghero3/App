package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class zzmc implements Iterator<Map.Entry<Object, Object>> {
    private int zza;
    private Iterator<Map.Entry<Object, Object>> zzb;
    private final /* synthetic */ zzma zzc;

    @Override // java.util.Iterator
    public final /* synthetic */ Map.Entry<Object, Object> next() {
        if (zza().hasNext()) {
            return zza().next();
        }
        List list = this.zzc.zzb;
        int i = this.zza - 1;
        this.zza = i;
        return (Map.Entry) list.get(i);
    }

    private final Iterator<Map.Entry<Object, Object>> zza() {
        if (this.zzb == null) {
            this.zzb = this.zzc.zzf.entrySet().iterator();
        }
        return this.zzb;
    }

    private zzmc(zzma zzmaVar) {
        this.zzc = zzmaVar;
        this.zza = zzmaVar.zzb.size();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zza;
        return (i > 0 && i <= this.zzc.zzb.size()) || zza().hasNext();
    }
}
