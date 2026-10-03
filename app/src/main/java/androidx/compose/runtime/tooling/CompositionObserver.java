package androidx.compose.runtime.tooling;

import androidx.compose.runtime.Composition;
import androidx.compose.runtime.RecomposeScope;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface CompositionObserver {
    void onBeginComposition(@NotNull Composition composition, @NotNull Map<RecomposeScope, ? extends Set<? extends Object>> map);

    void onEndComposition(@NotNull Composition composition);
}
