package org.parceler.converter;

import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TreeSetParcelConverter<T> extends CollectionParcelConverter<T, TreeSet<T>> {
    @Override // org.parceler.converter.CollectionParcelConverter
    public TreeSet<T> createCollection() {
        return new TreeSet<>();
    }
}
