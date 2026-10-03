package org.parceler.converter;

import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HashSetParcelConverter<T> extends CollectionParcelConverter<T, HashSet<T>> {
    @Override // org.parceler.converter.CollectionParcelConverter
    public HashSet<T> createCollection() {
        return new HashSet<>();
    }
}
