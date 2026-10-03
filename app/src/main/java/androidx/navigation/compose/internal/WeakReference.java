package androidx.navigation.compose.internal;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class WeakReference<T> {
    public static final int $stable = 8;
    private final java.lang.ref.WeakReference<T> weakReference;

    public WeakReference(@NotNull T t) {
        this.weakReference = new java.lang.ref.WeakReference<>(t);
    }

    public final T get() {
        return this.weakReference.get();
    }

    public final void clear() {
        this.weakReference.clear();
    }
}
