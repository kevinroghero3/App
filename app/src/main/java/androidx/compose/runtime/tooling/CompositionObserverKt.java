package androidx.compose.runtime.tooling;

import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionImpl;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class CompositionObserverKt {
    public static final CompositionObserverHandle observe(@NotNull Composition composition, @NotNull CompositionObserver compositionObserver) {
        CompositionImpl compositionImpl = (CompositionImpl) CompositionKt.getCompositionService(composition, CompositionKt.getCompositionImplServiceKey());
        if (compositionImpl != null) {
            return compositionImpl.observe$runtime_release(compositionObserver);
        }
        return null;
    }

    public static final CompositionObserverHandle observe(@NotNull RecomposeScope recomposeScope, @NotNull RecomposeScopeObserver recomposeScopeObserver) {
        Intrinsics.checkNotNull(recomposeScope, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
        return ((RecomposeScopeImpl) recomposeScope).observe$runtime_release(recomposeScopeObserver);
    }
}
