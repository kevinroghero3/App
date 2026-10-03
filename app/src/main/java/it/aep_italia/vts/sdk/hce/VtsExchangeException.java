package it.aep_italia.vts.sdk.hce;

/* JADX INFO: loaded from: classes6.dex */
public class VtsExchangeException extends RuntimeException {
    protected VtsExchangeError error;

    public VtsExchangeException(VtsExchangeError vtsExchangeError) {
        super(null, null);
        this.error = vtsExchangeError;
    }

    public VtsExchangeException(VtsExchangeError vtsExchangeError, String str) {
        super(str, null);
        this.error = vtsExchangeError;
    }

    public VtsExchangeException(VtsExchangeError vtsExchangeError, String str, Object... objArr) {
        super(String.format(str, objArr), null);
        this.error = vtsExchangeError;
    }

    public VtsExchangeError getError() {
        return this.error;
    }
}
