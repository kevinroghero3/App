package androidx.compose.animation.core;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public final class MutationInterruptedException extends CancellationException {
    public static final int $stable = 0;

    public MutationInterruptedException() {
        super("Mutation interrupted");
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
