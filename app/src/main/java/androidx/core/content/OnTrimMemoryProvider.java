package androidx.core.content;

import androidx.core.util.Consumer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface OnTrimMemoryProvider {
    void addOnTrimMemoryListener(@NotNull Consumer<Integer> consumer);

    void removeOnTrimMemoryListener(@NotNull Consumer<Integer> consumer);
}
