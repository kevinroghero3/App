package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes4.dex */
public final class zzkk extends zzib<String> implements zzkn, RandomAccess {
    private static final zzkk zza;

    @Deprecated
    private static final zzkn zzb;
    private final List<Object> zzc;

    @Override // com.google.android.gms.internal.measurement.zzib, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzkd
    public final /* synthetic */ zzkd zza(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzkk((ArrayList<Object>) arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final zzkn zzd() {
        return zzc() ? new zzmz(this) : this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzih) {
            zzih zzihVar = (zzih) obj;
            String strZzc = zzihVar.zzc();
            if (zzihVar.zzd()) {
                this.zzc.set(i, strZzc);
            }
            return strZzc;
        }
        byte[] bArr = (byte[]) obj;
        String strZzb = zzjx.zzb(bArr);
        if (zzjx.zzc(bArr)) {
            this.zzc.set(i, strZzb);
        }
        return strZzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final Object zzb(int i) {
        return this.zzc.get(i);
    }

    @Override // com.google.android.gms.internal.measurement.zzib, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zza();
        Object objRemove = this.zzc.remove(i);
        ((AbstractList) this).modCount++;
        return zza(objRemove);
    }

    @Override // com.google.android.gms.internal.measurement.zzib, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zza();
        return zza(this.zzc.set(i, (String) obj));
    }

    private static String zza(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzih) {
            return ((zzih) obj).zzc();
        }
        return zzjx.zzb((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final List<?> zze() {
        return Collections.unmodifiableList(this.zzc);
    }

    static {
        zzkk zzkkVar = new zzkk(false);
        zza = zzkkVar;
        zzb = zzkkVar;
    }

    public zzkk() {
        this(10);
    }

    public zzkk(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzkk(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    private zzkk(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final void zza(zzih zzihVar) {
        zza();
        this.zzc.add(zzihVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzib, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzib, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzib, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzib, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.measurement.zzib, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zza();
        if (collection instanceof zzkn) {
            collection = ((zzkn) collection).zze();
        }
        boolean zAddAll = this.zzc.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.measurement.zzib, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzib, com.google.android.gms.internal.measurement.zzkd
    public final /* bridge */ /* synthetic */ boolean zzc() {
        return super.zzc();
    }

    @Override // com.google.android.gms.internal.measurement.zzib, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzib, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.zzib, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }
}
