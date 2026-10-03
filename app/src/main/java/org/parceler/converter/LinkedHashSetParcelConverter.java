package org.parceler.converter;

import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LinkedHashSetParcelConverter<T> extends CollectionParcelConverter<T, LinkedHashSet<T>> {
    @Override // org.parceler.converter.CollectionParcelConverter
    public LinkedHashSet<T> createCollection() {
        return new LinkedHashSet<>();
    }
}
