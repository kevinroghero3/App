package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface SharedFlow<T> extends Flow<T> {
    @Override // kotlinx.coroutines.flow.Flow
    Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<?> continuation);

    List<T> getReplayCache();
}
