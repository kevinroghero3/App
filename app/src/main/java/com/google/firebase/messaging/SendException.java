package com.google.firebase.messaging;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class SendException extends Exception {
    public static final int ERROR_INVALID_PARAMETERS = 1;
    public static final int ERROR_SIZE = 2;
    public static final int ERROR_TOO_MANY_MESSAGES = 4;
    public static final int ERROR_TTL_EXCEEDED = 3;
    public static final int ERROR_UNKNOWN = 0;
    private final int errorCode;

    SendException(String str) {
        super(str);
        this.errorCode = parseErrorCode(str);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x0050  */
    private int parseErrorCode(String str) {
        byte b;
        if (str == null) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        lowerCase.hashCode();
        switch (lowerCase) {
            case "service_not_available":
                b = 0;
                break;
            case "toomanymessages":
                b = 1;
                break;
            case "invalid_parameters":
                b = 2;
                break;
            case "messagetoobig":
                b = 3;
                break;
            case "missing_to":
                b = 4;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return 3;
        }
        if (b == 1) {
            return 4;
        }
        if (b != 2) {
            if (b == 3) {
                return 2;
            }
            if (b != 4) {
                return 0;
            }
        }
        return 1;
    }
}
