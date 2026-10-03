package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class ComposeRuntimeError extends IllegalStateException {
    public static final int $stable = 0;
    private final String message;

    public ComposeRuntimeError(@NotNull String str) {
        this.message = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
