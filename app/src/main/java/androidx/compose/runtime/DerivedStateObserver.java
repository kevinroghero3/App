package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface DerivedStateObserver {
    void done(@NotNull DerivedState<?> derivedState);

    void start(@NotNull DerivedState<?> derivedState);
}
