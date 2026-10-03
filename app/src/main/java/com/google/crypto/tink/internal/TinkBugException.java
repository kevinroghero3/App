package com.google.crypto.tink.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class TinkBugException extends RuntimeException {

    /* JADX INFO: loaded from: classes5.dex */
    public interface ThrowingRunnable {
        void run() throws Exception;
    }

    public interface ThrowingSupplier<T> {
        T get() throws Exception;
    }

    public TinkBugException(String str) {
        super(str);
    }

    public TinkBugException(String str, Throwable th) {
        super(str, th);
    }

    public TinkBugException(Throwable th) {
        super(th);
    }

    public static <T> T exceptionIsBug(ThrowingSupplier<T> throwingSupplier) {
        try {
            return throwingSupplier.get();
        } catch (Exception e) {
            throw new TinkBugException(e);
        }
    }

    public static void exceptionIsBug(ThrowingRunnable throwingRunnable) {
        try {
            throwingRunnable.run();
        } catch (Exception e) {
            throw new TinkBugException(e);
        }
    }
}
