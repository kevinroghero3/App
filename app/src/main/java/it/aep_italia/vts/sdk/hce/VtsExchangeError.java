package it.aep_italia.vts.sdk.hce;

import androidx.appcompat.app.AppCompatDelegate;
import ch.qos.logback.core.net.SyslogConstants;
import com.salesforce.marketingcloud.analytics.stats.b;

/* JADX INFO: loaded from: classes6.dex */
public enum VtsExchangeError {
    UNRECOGNIZED_COMMAND(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 0),
    WRONG_P1_P2_FIELDS(107, 0),
    WRONG_LE_FIELD(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 8),
    OUT_OF_ORDER_COMMAND(105, 129),
    EXCHANGE_FAILED(b.f40o, 0),
    MALFORMED_AID(104, 0),
    WRONG_COMMAND_LENGTH(b.i, 0),
    WRONG_RESPONSE_LENGTH(104, 0),
    UNSUPPORTED_CYPHER(105, 132),
    WRONG_SECURITY_CODE(0, 0),
    COULD_NOT_ENCRYPT_DATA(105, SyslogConstants.LOG_LOCAL1),
    COULD_NOT_DECRYPT_DATA(105, SyslogConstants.LOG_LOCAL1),
    KEY_NOT_FOUND(105, 137),
    SDK_NOT_READY(b.l, 130),
    NO_TICKET_SELECTED(b.l, 130),
    COULD_NOT_SERIALIZE_REQUEST(0, 0),
    COULD_NOT_PARSE_RESPONSE(0, 0),
    COULD_NOT_PROCESS_DATA(0, 0),
    COULD_NOT_PARSE_REQUEST(b.f40o, 0);

    protected byte SW1;
    protected byte SW2;

    VtsExchangeError(int i, int i2) {
        this.SW1 = (byte) i;
        this.SW2 = (byte) i2;
    }

    public byte getSW1() {
        return this.SW1;
    }

    public byte getSW2() {
        return this.SW2;
    }
}
