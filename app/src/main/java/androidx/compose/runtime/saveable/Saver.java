package androidx.compose.runtime.saveable;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface Saver<Original, Saveable> {
    Original restore(@NotNull Saveable saveable);

    Saveable save(@NotNull SaverScope saverScope, Original original);
}
