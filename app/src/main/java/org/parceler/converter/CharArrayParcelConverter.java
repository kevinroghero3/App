package org.parceler.converter;

import android.os.Parcel;
import org.parceler.ParcelConverter;

/* JADX INFO: loaded from: classes3.dex */
public class CharArrayParcelConverter implements ParcelConverter<char[]> {
    private static final int NULL = -1;

    @Override // org.parceler.TypeRangeParcelConverter
    public void toParcel(char[] cArr, Parcel parcel) {
        if (cArr == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(cArr.length);
            parcel.writeCharArray(cArr);
        }
    }

    @Override // org.parceler.TypeRangeParcelConverter
    public char[] fromParcel(Parcel parcel) {
        int i = parcel.readInt();
        if (i == -1) {
            return null;
        }
        char[] cArr = new char[i];
        parcel.readCharArray(cArr);
        return cArr;
    }
}
