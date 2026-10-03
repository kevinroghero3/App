package it.aep_italia.vts.sdk.domain.enums;

import it.aep_italia.vts.sdk.core.VtsLog;
import java.util.IllegalFormatException;

/* JADX INFO: loaded from: classes6.dex */
public enum VtsVTokenType {
    UNKNOWN(0),
    STANDARD(1),
    LIGHT(2),
    SNAPSHOT(3);

    private int value;

    VtsVTokenType(int i) {
        this.value = i;
    }

    public static VtsVTokenType parse(int i) throws IllegalFormatException {
        for (VtsVTokenType vtsVTokenType : values()) {
            if (vtsVTokenType.value() == i) {
                return vtsVTokenType;
            }
        }
        VtsLog.e("Unrecognized TokenType value " + i, new Object[0]);
        return UNKNOWN;
    }

    public int value() {
        return this.value;
    }
}
