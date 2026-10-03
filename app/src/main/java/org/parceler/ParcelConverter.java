package org.parceler;

/* JADX INFO: loaded from: classes3.dex */
public interface ParcelConverter<T> extends TypeRangeParcelConverter<T, T> {
    public static final String CONVERT_FROM_PARCEL = "fromParcel";
    public static final String CONVERT_TO_PARCEL = "toParcel";

    /* JADX INFO: loaded from: classes6.dex */
    public static class EmptyConverter implements ParcelConverter<Object> {
        @Override // org.parceler.TypeRangeParcelConverter
        public void toParcel(Object obj, android.os.Parcel parcel) {
            throw new ParcelerRuntimeException("Empty Converter should not be used.");
        }

        @Override // org.parceler.TypeRangeParcelConverter
        public Object fromParcel(android.os.Parcel parcel) {
            throw new ParcelerRuntimeException("Empty Converter should not be used.");
        }
    }
}
