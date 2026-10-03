package androidx.compose.ui.graphics.vector;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface VectorConfig {
    default <T> T getOrDefault(@NotNull VectorProperty<T> vectorProperty, T t) {
        return t;
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <T> T getOrDefault(@NotNull VectorConfig vectorConfig, @NotNull VectorProperty<T> vectorProperty, T t) {
            return (T) VectorConfig.super.getOrDefault(vectorProperty, t);
        }
    }
}
