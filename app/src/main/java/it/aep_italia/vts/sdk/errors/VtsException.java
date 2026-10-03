package it.aep_italia.vts.sdk.errors;

/* JADX INFO: loaded from: classes6.dex */
public class VtsException extends RuntimeException {
    public VtsError error;

    public VtsException(VtsError vtsError) {
        setError(vtsError);
    }

    public VtsException(VtsError vtsError, String str, Object... objArr) {
        super(String.format(str, objArr));
        setError(vtsError);
    }

    public VtsException(VtsError vtsError, Throwable th) {
        super(th);
        this.error = vtsError;
    }

    public VtsError getError() {
        return this.error;
    }

    public void setError(VtsError vtsError) {
        this.error = vtsError;
    }
}
