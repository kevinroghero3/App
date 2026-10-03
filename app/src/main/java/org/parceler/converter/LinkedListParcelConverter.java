package org.parceler.converter;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LinkedListParcelConverter<T> extends CollectionParcelConverter<T, LinkedList<T>> {
    @Override // org.parceler.converter.CollectionParcelConverter
    public LinkedList<T> createCollection() {
        return new LinkedList<>();
    }
}
