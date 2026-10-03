package org.parceler;

/* JADX INFO: loaded from: classes3.dex */
public class ParcelerRuntimeException extends RuntimeException {
    public ParcelerRuntimeException(String str) {
        super(str);
    }

    public ParcelerRuntimeException(String str, Exception exc) {
        super(str, exc);
    }

    public ParcelerRuntimeException(String str, Throwable th) {
        super(str, th);
    }
}
