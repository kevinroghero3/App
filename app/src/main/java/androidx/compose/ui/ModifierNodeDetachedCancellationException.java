package androidx.compose.ui;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes4.dex */
public final class ModifierNodeDetachedCancellationException extends CancellationException {
    public static final int $stable = 0;

    public ModifierNodeDetachedCancellationException() {
        super("The Modifier.Node was detached");
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(Modifier_jvmKt.EmptyStackTraceElements);
        return this;
    }
}
