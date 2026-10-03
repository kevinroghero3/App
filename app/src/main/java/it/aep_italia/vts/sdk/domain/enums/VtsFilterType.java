package it.aep_italia.vts.sdk.domain.enums;

/* JADX INFO: loaded from: classes6.dex */
public enum VtsFilterType {
    BY_OPERATOR(1),
    BY_PROVIDER(2),
    BY_TARIFF(3),
    BY_AVM_TYPE(3),
    BY_CURRENT_LOCATION(10),
    BY_ORIGIN_LOCATION(11),
    BY_SBE_RIDE_ID(20),
    BY_AVM_RIDE_ID(21),
    BY_AVM_STOP_ID(22),
    BY_GPS_POSITION(30);

    private int value;

    VtsFilterType(int i) {
        this.value = i;
    }

    public static VtsFilterType parse(int i) {
        for (VtsFilterType vtsFilterType : values()) {
            if (vtsFilterType.value == i) {
                return vtsFilterType;
            }
        }
        return null;
    }

    public int value() {
        return this.value;
    }
}
