package it.aep_italia.vts.sdk.domain.enums;

import it.aep_italia.vts.sdk.core.VtsLog;
import java.util.IllegalFormatException;

/* JADX INFO: loaded from: classes6.dex */
public enum VtsVTokenClassID {
    UNKNOWN(0),
    AUTOMATIC_SALE_BOX(4),
    F3A_VALIDATOR_OR_THALES_GATE(5),
    COMPANY_TICKETING(6),
    VERIFICATION_TERMINAL(8),
    RESALE_TERMINAL(12),
    DRIVER_TERMINAL(21),
    TYPE_VALIDATOR(22),
    VTS_SERVER(29);

    private int value;

    VtsVTokenClassID(int i) {
        this.value = i;
    }

    public static VtsVTokenClassID parse(int i) throws IllegalFormatException {
        for (VtsVTokenClassID vtsVTokenClassID : values()) {
            if (vtsVTokenClassID.value() == i) {
                return vtsVTokenClassID;
            }
        }
        VtsLog.e("Unrecognized ClassID value " + i, new Object[0]);
        return UNKNOWN;
    }

    public int value() {
        return this.value;
    }
}
