package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ProbesSupportKt {
    public static final <T> Continuation<T> probeCoroutineCreated(@NotNull Continuation<? super T> continuation) {
        return DebugProbesKt.probeCoroutineCreated(continuation);
    }

    public static final <T> void probeCoroutineResumed(@NotNull Continuation<? super T> continuation) {
        DebugProbesKt.probeCoroutineResumed(continuation);
    }
}
