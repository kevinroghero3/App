package it.aep_italia.vts.sdk.domain.enums;

/* JADX INFO: loaded from: classes6.dex */
public enum VtsTariffFamilyType {
    NONE(0),
    FLAT(1),
    POINT_TO_POINT(2),
    DISTANCE(3),
    ZONAL(4),
    SMARCARD_SELLING(5),
    STORED_VALUE_SELLING(6);

    private int value;

    VtsTariffFamilyType(int i) {
        this.value = i;
    }

    public static VtsTariffFamilyType parse(int i) {
        for (VtsTariffFamilyType vtsTariffFamilyType : values()) {
            if (vtsTariffFamilyType.value == i) {
                return vtsTariffFamilyType;
            }
        }
        return FLAT;
    }

    public int value() {
        return this.value;
    }
}
