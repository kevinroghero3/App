package org.parceler.converter;

import android.os.Parcel;
import android.util.SparseArray;
import org.parceler.ParcelConverter;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SparseArrayParcelConverter<T> implements ParcelConverter<SparseArray<T>> {
    public abstract T itemFromParcel(Parcel parcel);

    public abstract void itemToParcel(T t, Parcel parcel);

    @Override // org.parceler.TypeRangeParcelConverter
    public void toParcel(SparseArray<T> sparseArray, Parcel parcel) {
        if (sparseArray == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            parcel.writeInt(sparseArray.keyAt(i));
            itemToParcel(sparseArray.valueAt(i), parcel);
        }
    }

    @Override // org.parceler.TypeRangeParcelConverter
    public SparseArray<T> fromParcel(Parcel parcel) {
        int i = parcel.readInt();
        if (i < 0) {
            return null;
        }
        SparseArray<T> sparseArray = new SparseArray<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            sparseArray.append(parcel.readInt(), itemFromParcel(parcel));
        }
        return sparseArray;
    }
}
