package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface ProduceStateScope<T> extends MutableState<T>, CoroutineScope {
    Object awaitDispose(@NotNull Function0<Unit> function0, @NotNull Continuation<?> continuation);
}
