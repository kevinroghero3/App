package it.aep_italia.vts.sdk.domain.enums;

/* JADX INFO: loaded from: classes6.dex */
public enum VtsVTokenStatus {
    ACTIVE(0),
    DELETED(1),
    EXPIRED(2),
    TRANSACTION_PENDING(3),
    BLACKLISTED(4),
    DISTRIBUTION_PENDING(5),
    TRANSFERRED(6),
    SUSPENDED(7),
    UNDEMATERIALIZE_PENDING(8);

    private int value;

    VtsVTokenStatus(int i) {
        this.value = i;
    }

    public static VtsVTokenStatus parse(int i) {
        for (VtsVTokenStatus vtsVTokenStatus : values()) {
            if (vtsVTokenStatus.value == i) {
                return vtsVTokenStatus;
            }
        }
        return null;
    }

    public int value() {
        return this.value;
    }
}
