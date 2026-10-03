package kotlinx.coroutines.internal;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ThreadLocalKt {
    public static /* synthetic */ void CommonThreadLocal$annotations() {
    }

    public static final <T> ThreadLocal<T> commonThreadLocal(@NotNull Symbol symbol) {
        return new ThreadLocal<>();
    }
}
