package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes4.dex */
class zzma<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zza;
    private List<zzml> zzb;
    private Map<K, V> zzc;
    private boolean zzd;
    private volatile zzmm zze;
    private Map<K, V> zzf;
    private volatile zzme zzg;

    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    /* JADX WARN: Code duplicated, block: B:15:0x0044  */
    /* JADX WARN: Code duplicated, block: B:20:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x003f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0047 A[SYNTHETIC] */
    private final int zza(K k) {
        int i;
        int iCompareTo;
        int size = this.zzb.size();
        int i2 = size - 1;
        if (i2 < 0) {
            size = 0;
            while (size <= i2) {
                i = (size + i2) / 2;
                iCompareTo = k.compareTo((Comparable) this.zzb.get(i).getKey());
                if (iCompareTo < 0) {
                    i2 = i - 1;
                } else {
                    if (iCompareTo > 0) {
                        return i;
                    }
                    size = i + 1;
                }
            }
        } else {
            int iCompareTo2 = k.compareTo((Comparable) this.zzb.get(i2).getKey());
            if (iCompareTo2 <= 0) {
                if (iCompareTo2 == 0) {
                    return i2;
                }
                size = 0;
                while (size <= i2) {
                    i = (size + i2) / 2;
                    iCompareTo = k.compareTo((Comparable) this.zzb.get(i).getKey());
                    if (iCompareTo < 0) {
                        i2 = i - 1;
                    } else {
                        if (iCompareTo > 0) {
                            return i;
                        }
                        size = i + 1;
                    }
                }
            }
        }
        return -(size + 1);
    }

    public final int zza() {
        return this.zzb.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iZza = zza();
        int iHashCode = 0;
        for (int i = 0; i < iZza; i++) {
            iHashCode += this.zzb.get(i).hashCode();
        }
        return this.zzc.size() > 0 ? iHashCode + this.zzc.hashCode() : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzb.size() + this.zzc.size();
    }

    static <FieldDescriptorType extends zzjm<FieldDescriptorType>> zzma<FieldDescriptorType, Object> zza(int i) {
        return new zzmd(i);
    }

    public final Iterable<Map.Entry<K, V>> zzb() {
        if (this.zzc.isEmpty()) {
            return zzmg.zza();
        }
        return this.zzc.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        if (iZza >= 0) {
            return (V) this.zzb.get(iZza).getValue();
        }
        return this.zzc.get(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final V put(K k, V v) {
        zzg();
        int iZza = zza(k);
        if (iZza >= 0) {
            return (V) this.zzb.get(iZza).setValue(v);
        }
        zzg();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i = -(iZza + 1);
        if (i >= this.zza) {
            return zzf().put(k, v);
        }
        int size = this.zzb.size();
        int i2 = this.zza;
        if (size == i2) {
            zzml zzmlVarRemove = this.zzb.remove(i2 - 1);
            zzf().put((Comparable) zzmlVarRemove.getKey(), zzmlVarRemove.getValue());
        }
        this.zzb.add(i, new zzml(this, k, v));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzg();
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        if (iZza >= 0) {
            return zzc(iZza);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzc(int i) {
        zzg();
        V v = (V) this.zzb.remove(i).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator<Map.Entry<K, V>> it2 = zzf().entrySet().iterator();
            this.zzb.add(new zzml(this, it2.next()));
            it2.remove();
        }
        return v;
    }

    public final Map.Entry<K, V> zzb(int i) {
        return this.zzb.get(i);
    }

    final Set<Map.Entry<K, V>> zzc() {
        if (this.zzg == null) {
            this.zzg = new zzme(this);
        }
        return this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzmm(this);
        }
        return this.zze;
    }

    private final SortedMap<K, V> zzf() {
        zzg();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    private zzma(int i) {
        this.zza = i;
        this.zzb = Collections.emptyList();
        this.zzc = Collections.emptyMap();
        this.zzf = Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzg();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (this.zzc.isEmpty()) {
            return;
        }
        this.zzc.clear();
    }

    public void zzd() {
        Map<K, V> mapUnmodifiableMap;
        Map<K, V> mapUnmodifiableMap2;
        if (this.zzd) {
            return;
        }
        if (this.zzc.isEmpty()) {
            mapUnmodifiableMap = Collections.emptyMap();
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(this.zzc);
        }
        this.zzc = mapUnmodifiableMap;
        if (this.zzf.isEmpty()) {
            mapUnmodifiableMap2 = Collections.emptyMap();
        } else {
            mapUnmodifiableMap2 = Collections.unmodifiableMap(this.zzf);
        }
        this.zzf = mapUnmodifiableMap2;
        this.zzd = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzma)) {
            return super.equals(obj);
        }
        zzma zzmaVar = (zzma) obj;
        int size = size();
        if (size != zzmaVar.size()) {
            return false;
        }
        int iZza = zza();
        if (iZza != zzmaVar.zza()) {
            return entrySet().equals(zzmaVar.entrySet());
        }
        for (int i = 0; i < iZza; i++) {
            if (!zzb(i).equals(zzmaVar.zzb(i))) {
                return false;
            }
        }
        if (iZza != size) {
            return this.zzc.equals(zzmaVar.zzc);
        }
        return true;
    }

    public final boolean zze() {
        return this.zzd;
    }
}
