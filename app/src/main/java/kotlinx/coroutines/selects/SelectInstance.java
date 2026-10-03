package kotlinx.coroutines.selects;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface SelectInstance<R> {
    void disposeOnCompletion(@NotNull DisposableHandle disposableHandle);

    CoroutineContext getContext();

    void selectInRegistrationPhase(@Nullable Object obj);

    boolean trySelect(@NotNull Object obj, @Nullable Object obj2);
}
