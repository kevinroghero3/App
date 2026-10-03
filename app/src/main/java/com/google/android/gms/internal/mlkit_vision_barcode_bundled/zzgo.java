package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes4.dex */
class zzgo extends AbstractMap {
    private Object[] zza;
    private int zzb;
    private boolean zzd;
    private volatile zzgm zze;
    private Map zzc = Collections.emptyMap();
    private Map zzf = Collections.emptyMap();

    private zzgo() {
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0021  */
    /* JADX WARN: Code duplicated, block: B:17:0x003a  */
    /* JADX WARN: Code duplicated, block: B:20:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x003d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0035 A[SYNTHETIC] */
    private final int zzl(Comparable comparable) {
        int i;
        int iCompareTo;
        int i2 = this.zzb;
        int i3 = i2 - 1;
        if (i3 < 0) {
            i2 = 0;
            while (i2 <= i3) {
                i = (i2 + i3) / 2;
                iCompareTo = comparable.compareTo(((zzgi) this.zza[i]).zza());
                if (iCompareTo < 0) {
                    i3 = i - 1;
                } else {
                    if (iCompareTo > 0) {
                        return i;
                    }
                    i2 = i + 1;
                }
            }
        } else {
            int iCompareTo2 = comparable.compareTo(((zzgi) this.zza[i3]).zza());
            if (iCompareTo2 <= 0) {
                if (iCompareTo2 == 0) {
                    return i3;
                }
                i2 = 0;
                while (i2 <= i3) {
                    i = (i2 + i3) / 2;
                    iCompareTo = comparable.compareTo(((zzgi) this.zza[i]).zza());
                    if (iCompareTo < 0) {
                        i3 = i - 1;
                    } else {
                        if (iCompareTo > 0) {
                            return i;
                        }
                        i2 = i + 1;
                    }
                }
            }
        }
        return -(i2 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzm(int i) {
        zzo();
        Object value = ((zzgi) this.zza[i]).getValue();
        Object[] objArr = this.zza;
        System.arraycopy(objArr, i + 1, objArr, i, (this.zzb - i) - 1);
        this.zzb--;
        if (!this.zzc.isEmpty()) {
            Iterator it2 = zzn().entrySet().iterator();
            Object[] objArr2 = this.zza;
            int i2 = this.zzb;
            Map.Entry entry = (Map.Entry) it2.next();
            objArr2[i2] = new zzgi(this, (Comparable) entry.getKey(), entry.getValue());
            this.zzb++;
            it2.remove();
        }
        return value;
    }

    private final SortedMap zzn() {
        zzo();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzo() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzo();
        if (this.zzb != 0) {
            this.zza = null;
            this.zzb = 0;
        }
        if (this.zzc.isEmpty()) {
            return;
        }
        this.zzc.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zzl(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.zze == null) {
            this.zze = new zzgm(this, null);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgo)) {
            return super.equals(obj);
        }
        zzgo zzgoVar = (zzgo) obj;
        int size = size();
        if (size != zzgoVar.size()) {
            return false;
        }
        int i = this.zzb;
        if (i != zzgoVar.zzb) {
            return entrySet().equals(zzgoVar.entrySet());
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzg(i2).equals(zzgoVar.zzg(i2))) {
                return false;
            }
        }
        if (i != size) {
            return this.zzc.equals(zzgoVar.zzc);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZzl = zzl(comparable);
        return iZzl >= 0 ? ((zzgi) this.zza[iZzl]).getValue() : this.zzc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i = this.zzb;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode += this.zza[i2].hashCode();
        }
        return this.zzc.size() > 0 ? iHashCode + this.zzc.hashCode() : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzo();
        Comparable comparable = (Comparable) obj;
        int iZzl = zzl(comparable);
        if (iZzl >= 0) {
            return zzm(iZzl);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb + this.zzc.size();
    }

    public void zza() {
        if (this.zzd) {
            return;
        }
        this.zzc = this.zzc.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzc);
        this.zzf = this.zzf.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzf);
        this.zzd = true;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final Iterable zzd() {
        return this.zzc.isEmpty() ? Collections.emptySet() : this.zzc.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        zzo();
        int iZzl = zzl(comparable);
        if (iZzl >= 0) {
            return ((zzgi) this.zza[iZzl]).setValue(obj);
        }
        zzo();
        if (this.zza == null) {
            this.zza = new Object[16];
        }
        int i = -(iZzl + 1);
        if (i >= 16) {
            return zzn().put(comparable, obj);
        }
        if (this.zzb == 16) {
            zzgi zzgiVar = (zzgi) this.zza[15];
            this.zzb = 15;
            zzn().put(zzgiVar.zza(), zzgiVar.getValue());
        }
        Object[] objArr = this.zza;
        int length = objArr.length;
        System.arraycopy(objArr, i, objArr, i + 1, 15 - i);
        this.zza[i] = new zzgi(this, comparable, obj);
        this.zzb++;
        return null;
    }

    public final Map.Entry zzg(int i) {
        if (i < this.zzb) {
            return (zzgi) this.zza[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public final boolean zzj() {
        return this.zzd;
    }

    /* synthetic */ zzgo(zzgn zzgnVar) {
    }
}
