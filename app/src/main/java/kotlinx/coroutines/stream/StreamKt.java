package kotlinx.coroutines.stream;

import java.util.stream.Stream;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class StreamKt {
    public static final <T> Flow<T> consumeAsFlow(@NotNull Stream<T> stream) {
        return new StreamFlow(stream);
    }
}
