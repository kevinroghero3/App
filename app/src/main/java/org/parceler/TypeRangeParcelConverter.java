package org.parceler;

/* JADX INFO: loaded from: classes3.dex */
public interface TypeRangeParcelConverter<L, U extends L> {
    U fromParcel(android.os.Parcel parcel);

    void toParcel(L l, android.os.Parcel parcel);
}
