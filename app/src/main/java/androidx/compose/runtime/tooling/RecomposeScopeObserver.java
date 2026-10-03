package androidx.compose.runtime.tooling;

import androidx.compose.runtime.RecomposeScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface RecomposeScopeObserver {
    void onBeginScopeComposition(@NotNull RecomposeScope recomposeScope);

    void onEndScopeComposition(@NotNull RecomposeScope recomposeScope);

    void onScopeDisposed(@NotNull RecomposeScope recomposeScope);
}
