package com.facebook.common.util;

/* JADX INFO: loaded from: classes2.dex */
public class ExceptionWithNoStacktrace extends Exception {
    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        synchronized (this) {
        }
        return this;
    }

    public ExceptionWithNoStacktrace(String str) {
        super(str);
    }
}
