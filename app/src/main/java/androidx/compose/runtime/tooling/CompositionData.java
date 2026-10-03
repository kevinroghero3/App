package androidx.compose.runtime.tooling;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface CompositionData {
    default CompositionGroup find(@NotNull Object obj) {
        return null;
    }

    Iterable<CompositionGroup> getCompositionGroups();

    boolean isEmpty();
}
