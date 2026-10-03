package org.parceler.converter;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ArrayListParcelConverter<T> extends CollectionParcelConverter<T, ArrayList<T>> {
    @Override // org.parceler.converter.CollectionParcelConverter
    public ArrayList<T> createCollection() {
        return new ArrayList<>();
    }
}
