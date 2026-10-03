package androidx.activity.contextaware;

import android.content.Context;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface ContextAware {
    void addOnContextAvailableListener(@NotNull OnContextAvailableListener onContextAvailableListener);

    Context peekAvailableContext();

    void removeOnContextAvailableListener(@NotNull OnContextAvailableListener onContextAvailableListener);
}
