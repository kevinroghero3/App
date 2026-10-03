package it.aep_italia.vts.sdk.domain.enums;

import it.aep_italia.vts.sdk.core.VtsLog;
import java.util.IllegalFormatException;

/* JADX INFO: loaded from: classes6.dex */
public enum VtsObjectTypeFormat {
    UNKNOWN(0),
    ROW_FORMAT(1),
    PLAINTEXT(10),
    CSV_SEMICOLON_SEPARATOR(11),
    CSV_COMMA_SEPARATOR(12),
    CSV_COLON_SEPARATOR(13),
    XML(14),
    HTML(15),
    PDF(16),
    BMP(20),
    PNG(21),
    JPEG(22);

    private int value;

    VtsObjectTypeFormat(int i) {
        this.value = i;
    }

    public static VtsObjectTypeFormat parse(int i) throws IllegalFormatException {
        for (VtsObjectTypeFormat vtsObjectTypeFormat : values()) {
            if (vtsObjectTypeFormat.value() == i) {
                return vtsObjectTypeFormat;
            }
        }
        VtsLog.e("Unrecognized ObjectTypeFormat value " + i, new Object[0]);
        return UNKNOWN;
    }

    public int value() {
        return this.value;
    }
}
