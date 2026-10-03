package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class zzmz extends AbstractList<String> implements zzkn, RandomAccess {
    private final zzkn zza;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final zzkn zzd() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zznb(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final List<?> zze() {
        return this.zza.zze();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzmy(this, i);
    }

    public zzmz(zzkn zzknVar) {
        this.zza = zzknVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final void zza(zzih zzihVar) {
        throw new UnsupportedOperationException();
    }
}
