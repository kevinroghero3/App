package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface FlowCollector<T> {
    Object emit(T t, @NotNull Continuation<? super Unit> continuation);
}
