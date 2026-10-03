package it.aep_italia.vts.sdk.dto.soap;

/* JADX INFO: loaded from: classes6.dex */
public enum VtsSoapReturnCode {
    NO_ERROR(0),
    TIMEOUT(1),
    INVALID_SESSION(2),
    WRONT_DATAIN_ENCODING(3),
    INVALID_DATAIN_PARAMETER(4),
    INTERNAL_SERVER_ERROR(5),
    INVALID_API(6),
    UNAUTHORIZED(7),
    UNSUPPORTED_API_OR_FUNCTION(8),
    NO_RESOURCES_AVAILABLE(9),
    NO_PAYMENT_DONE(10);

    private int value;

    VtsSoapReturnCode(int i) {
        this.value = i;
    }

    public static VtsSoapReturnCode parse(Integer num) {
        if (num == null) {
            return null;
        }
        for (VtsSoapReturnCode vtsSoapReturnCode : values()) {
            if (num.intValue() == vtsSoapReturnCode.value) {
                return vtsSoapReturnCode;
            }
        }
        return null;
    }

    public int value() {
        return this.value;
    }
}
