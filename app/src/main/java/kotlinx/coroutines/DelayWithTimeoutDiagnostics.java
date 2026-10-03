package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface DelayWithTimeoutDiagnostics extends Delay {
    /* JADX INFO: renamed from: timeoutMessage-LRDsOJo, reason: not valid java name */
    String m6978timeoutMessageLRDsOJo(long j);

    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
        public static Object delay(@NotNull DelayWithTimeoutDiagnostics delayWithTimeoutDiagnostics, long j, @NotNull Continuation<? super Unit> continuation) {
            Object objDelay = Delay.DefaultImpls.delay(delayWithTimeoutDiagnostics, j, continuation);
            return objDelay == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDelay : Unit.INSTANCE;
        }

        public static DisposableHandle invokeOnTimeout(@NotNull DelayWithTimeoutDiagnostics delayWithTimeoutDiagnostics, long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
            return Delay.DefaultImpls.invokeOnTimeout(delayWithTimeoutDiagnostics, j, runnable, coroutineContext);
        }
    }
}
