package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface RecomposeScopeOwner {
    InvalidationResult invalidate(@NotNull RecomposeScopeImpl recomposeScopeImpl, @Nullable Object obj);

    void recomposeScopeReleased(@NotNull RecomposeScopeImpl recomposeScopeImpl);

    void recordReadOf(@NotNull Object obj);
}
