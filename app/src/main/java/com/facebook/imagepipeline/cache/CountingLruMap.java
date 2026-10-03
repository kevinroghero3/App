package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class CountingLruMap<K, V> {
    private final LinkedHashMap<K, V> mMap = new LinkedHashMap<>();
    private int mSizeInBytes = 0;
    private final ValueDescriptor<V> mValueDescriptor;

    public CountingLruMap(ValueDescriptor<V> valueDescriptor) {
        this.mValueDescriptor = valueDescriptor;
    }

    ArrayList<K> getKeys() {
        ArrayList<K> arrayList;
        synchronized (this) {
            arrayList = new ArrayList<>(this.mMap.keySet());
        }
        return arrayList;
    }

    ArrayList<V> getValues() {
        ArrayList<V> arrayList;
        synchronized (this) {
            arrayList = new ArrayList<>((Collection<? extends V>) this.mMap.values());
        }
        return arrayList;
    }

    public int getCount() {
        int size;
        synchronized (this) {
            size = this.mMap.size();
        }
        return size;
    }

    public int getSizeInBytes() {
        int i;
        synchronized (this) {
            i = this.mSizeInBytes;
        }
        return i;
    }

    @Nullable
    public K getFirstKey() {
        K next;
        synchronized (this) {
            next = this.mMap.isEmpty() ? null : this.mMap.keySet().iterator().next();
        }
        return next;
    }

    public ArrayList<Map.Entry<K, V>> getMatchingEntries(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        synchronized (this) {
            arrayList = new ArrayList<>(this.mMap.entrySet().size());
            for (Map.Entry<K, V> entry : this.mMap.entrySet()) {
                if (predicate == null || predicate.apply(entry.getKey())) {
                    arrayList.add(entry);
                }
            }
        }
        return arrayList;
    }

    public boolean contains(K k) {
        boolean zContainsKey;
        synchronized (this) {
            zContainsKey = this.mMap.containsKey(k);
        }
        return zContainsKey;
    }

    @Nullable
    public V get(K k) {
        V v;
        synchronized (this) {
            v = this.mMap.get(k);
        }
        return v;
    }

    @Nullable
    public V put(K k, V v) {
        V vRemove;
        synchronized (this) {
            vRemove = this.mMap.remove(k);
            this.mSizeInBytes -= getValueSizeInBytes(vRemove);
            this.mMap.put(k, v);
            this.mSizeInBytes += getValueSizeInBytes(v);
        }
        return vRemove;
    }

    @Nullable
    public V remove(K k) {
        V vRemove;
        synchronized (this) {
            vRemove = this.mMap.remove(k);
            this.mSizeInBytes -= getValueSizeInBytes(vRemove);
        }
        return vRemove;
    }

    public ArrayList<V> removeAll(@Nullable Predicate<K> predicate) {
        ArrayList<V> arrayList;
        synchronized (this) {
            arrayList = new ArrayList<>();
            Iterator<Map.Entry<K, V>> it2 = this.mMap.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<K, V> next = it2.next();
                if (predicate == null || predicate.apply(next.getKey())) {
                    arrayList.add(next.getValue());
                    this.mSizeInBytes -= getValueSizeInBytes(next.getValue());
                    it2.remove();
                }
            }
        }
        return arrayList;
    }

    public ArrayList<V> clear() {
        ArrayList<V> arrayList;
        synchronized (this) {
            arrayList = new ArrayList<>((Collection<? extends V>) this.mMap.values());
            this.mMap.clear();
            this.mSizeInBytes = 0;
        }
        return arrayList;
    }

    public void resetSize() {
        synchronized (this) {
            if (this.mMap.isEmpty()) {
                this.mSizeInBytes = 0;
            }
        }
    }

    private int getValueSizeInBytes(@Nullable V v) {
        if (v == null) {
            return 0;
        }
        return this.mValueDescriptor.getSizeInBytes(v);
    }
}
