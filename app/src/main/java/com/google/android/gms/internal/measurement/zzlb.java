package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class zzlb<K, V> extends LinkedHashMap<K, V> {
    private static final zzlb<?, ?> zza;
    private boolean zzb;

    private static int zza(Object obj) {
        if (obj instanceof byte[]) {
            return zzjx.zza((byte[]) obj);
        }
        if (obj instanceof zzjw) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iZza = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            iZza += zza(entry.getValue()) ^ zza(entry.getKey());
        }
        return iZza;
    }

    public static <K, V> zzlb<K, V> zza() {
        return (zzlb<K, V>) zza;
    }

    public final zzlb<K, V> zzb() {
        return isEmpty() ? new zzlb<>() : new zzlb<>(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        zze();
        zzjx.zza(k);
        zzjx.zza(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zze();
        return (V) super.remove(obj);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    static {
        zzlb<?, ?> zzlbVar = new zzlb<>();
        zza = zzlbVar;
        ((zzlb) zzlbVar).zzb = false;
    }

    private zzlb() {
        this.zzb = true;
    }

    private zzlb(Map<K, V> map) {
        super(map);
        this.zzb = true;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zze();
        super.clear();
    }

    private final void zze() {
        if (!this.zzb) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzc() {
        this.zzb = false;
    }

    public final void zza(zzlb<K, V> zzlbVar) {
        zze();
        if (zzlbVar.isEmpty()) {
            return;
        }
        putAll(zzlbVar);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zze();
        for (K k : map.keySet()) {
            zzjx.zza(k);
            zzjx.zza(map.get(k));
        }
        super.putAll(map);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        boolean zEquals;
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            V value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if ((value instanceof byte[]) && (obj2 instanceof byte[])) {
                zEquals = Arrays.equals((byte[]) value, (byte[]) obj2);
            } else {
                zEquals = value.equals(obj2);
            }
            if (!zEquals) {
                return false;
            }
        }
        return true;
    }

    public final boolean zzd() {
        return this.zzb;
    }
}
