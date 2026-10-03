package com.google.maps.android.data.geojson;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class BiMultiMap<K> extends HashMap<K, Object> {
    private final Map<Object, K> mValuesToKeys = new HashMap();

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ?> map) {
        for (Map.Entry<? extends K, ?> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(K k, Object obj) {
        if (obj instanceof Collection) {
            return put((Object) k, (Collection) obj);
        }
        this.mValuesToKeys.put(obj, k);
        return super.put(k, obj);
    }

    public Object put(K k, Collection collection) {
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            this.mValuesToKeys.put(it2.next(), k);
        }
        return super.put((Object) k, collection);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Object objRemove = super.remove(obj);
        if (objRemove instanceof Collection) {
            Iterator it2 = ((Collection) objRemove).iterator();
            while (it2.hasNext()) {
                this.mValuesToKeys.remove(it2.next());
            }
        } else {
            this.mValuesToKeys.remove(objRemove);
        }
        return objRemove;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        this.mValuesToKeys.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap
    public BiMultiMap<K> clone() {
        BiMultiMap<K> biMultiMap = new BiMultiMap<>();
        biMultiMap.putAll((Map) super.clone());
        return biMultiMap;
    }

    public K getKey(Object obj) {
        return this.mValuesToKeys.get(obj);
    }
}
