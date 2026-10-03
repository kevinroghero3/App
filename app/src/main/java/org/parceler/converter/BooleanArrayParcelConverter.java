package org.parceler.converter;

import android.os.Parcel;
import org.parceler.ParcelConverter;

/* JADX INFO: loaded from: classes3.dex */
public class BooleanArrayParcelConverter implements ParcelConverter<boolean[]> {
    private static final int NULL = -1;

    @Override // org.parceler.TypeRangeParcelConverter
    public void toParcel(boolean[] zArr, Parcel parcel) {
        if (zArr == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(zArr.length);
            parcel.writeBooleanArray(zArr);
        }
    }

    @Override // org.parceler.TypeRangeParcelConverter
    public boolean[] fromParcel(Parcel parcel) {
        int i = parcel.readInt();
        if (i == -1) {
            return null;
        }
        boolean[] zArr = new boolean[i];
        parcel.readBooleanArray(zArr);
        return zArr;
    }
}
