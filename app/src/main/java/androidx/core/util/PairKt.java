package androidx.core.util;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class PairKt {
    public static final <F, S> F component1(@NotNull Pair<F, S> pair) {
        return pair.first;
    }

    public static final <F, S> S component2(@NotNull Pair<F, S> pair) {
        return pair.second;
    }

    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(@NotNull Pair<F, S> pair) {
        return new kotlin.Pair<>(pair.first, pair.second);
    }

    public static final <F, S> Pair<F, S> toAndroidXPair(@NotNull kotlin.Pair<? extends F, ? extends S> pair) {
        return new Pair<>(pair.getFirst(), pair.getSecond());
    }

    public static final <F, S> F component1(@NotNull android.util.Pair<F, S> pair) {
        return (F) pair.first;
    }

    public static final <F, S> S component2(@NotNull android.util.Pair<F, S> pair) {
        return (S) pair.second;
    }

    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(@NotNull android.util.Pair<F, S> pair) {
        return new kotlin.Pair<>(pair.first, pair.second);
    }

    public static final <F, S> android.util.Pair<F, S> toAndroidPair(@NotNull kotlin.Pair<? extends F, ? extends S> pair) {
        return new android.util.Pair<>(pair.getFirst(), pair.getSecond());
    }
}
