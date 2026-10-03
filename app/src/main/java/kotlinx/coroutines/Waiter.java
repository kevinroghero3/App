package kotlinx.coroutines;

import kotlinx.coroutines.internal.Segment;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface Waiter {
    void invokeOnCancellation(@NotNull Segment<?> segment, int i);
}
