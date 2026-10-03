package org.parceler.converter;

import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TreeMapParcelConverter<K, V> extends MapParcelConverter<K, V, TreeMap<K, V>> {
    @Override // org.parceler.converter.MapParcelConverter
    public TreeMap<K, V> createMap() {
        return new TreeMap<>();
    }
}
