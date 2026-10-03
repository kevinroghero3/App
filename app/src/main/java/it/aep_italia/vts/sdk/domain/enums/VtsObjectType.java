package it.aep_italia.vts.sdk.domain.enums;

import ch.qos.logback.core.net.SyslogConstants;
import it.aep_italia.vts.sdk.core.VtsLog;
import java.util.IllegalFormatException;

/* JADX INFO: loaded from: classes6.dex */
public enum VtsObjectType {
    NONE(0),
    CALYPSO_SMARTCARD(1),
    SMART_TICKET_OR_COP_MIFARE_UL(2),
    GTML2_GTT_CARD(3),
    SINGLE_RIDE_TICKET(4),
    CRYPTOGRAM_OR_QR_CODE(5),
    USER_PICTURE(100),
    USER_DATA(101),
    SMARTCARD_DATA(150),
    MIFARE_1K_SMARTCARD(6),
    MAGNETIC_STRIPE_TICKET(7),
    INNOVATRON_CD97_SMARTCARD(8),
    GENERIC_IMAGE(150),
    FRONT_COP_IMAGE(151),
    BACK_COP_IMAGE(SyslogConstants.LOG_LOCAL3),
    SYSTEM_INDEPENT_DATA(153),
    VTOKEN_RECEIPT(200);

    private int value;

    VtsObjectType(int i) {
        this.value = i;
    }

    public static VtsObjectType parse(int i) throws IllegalFormatException {
        for (VtsObjectType vtsObjectType : values()) {
            if (vtsObjectType.value() == i) {
                return vtsObjectType;
            }
        }
        VtsLog.e("Unrecognized ObjectType value " + i, new Object[0]);
        return NONE;
    }

    public int value() {
        return this.value;
    }
}
