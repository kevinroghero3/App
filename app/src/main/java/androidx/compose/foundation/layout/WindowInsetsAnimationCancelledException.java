package androidx.compose.foundation.layout;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
final class WindowInsetsAnimationCancelledException extends CancellationException {
    public WindowInsetsAnimationCancelledException() {
        super("Window insets animation cancelled");
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
