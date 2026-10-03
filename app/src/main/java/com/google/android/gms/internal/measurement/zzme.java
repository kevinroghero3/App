package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class zzme extends zzmm {
    private final /* synthetic */ zzma zza;

    @Override // com.google.android.gms.internal.measurement.zzmm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<Object, Object>> iterator() {
        return new zzmc(this.zza);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzme(zzma zzmaVar) {
        super(zzmaVar);
        this.zza = zzmaVar;
    }
}
