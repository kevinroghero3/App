package org.parceler.converter;

import android.os.Parcel;
import java.util.Collection;
import java.util.Iterator;
import org.parceler.TypeRangeParcelConverter;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CollectionParcelConverter<T, C extends Collection<T>> implements TypeRangeParcelConverter<Collection<T>, C> {
    private static final int NULL = -1;

    public abstract C createCollection();

    public abstract T itemFromParcel(Parcel parcel);

    public abstract void itemToParcel(T t, Parcel parcel);

    @Override // org.parceler.TypeRangeParcelConverter
    public void toParcel(Collection<T> collection, Parcel parcel) {
        if (collection == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(collection.size());
        Iterator<T> it2 = collection.iterator();
        while (it2.hasNext()) {
            itemToParcel(it2.next(), parcel);
        }
    }

    @Override // org.parceler.TypeRangeParcelConverter
    public C fromParcel(Parcel parcel) {
        int i = parcel.readInt();
        if (i == -1) {
            return null;
        }
        C c = (C) createCollection();
        for (int i2 = 0; i2 < i; i2++) {
            c.add(itemFromParcel(parcel));
        }
        return c;
    }
}
