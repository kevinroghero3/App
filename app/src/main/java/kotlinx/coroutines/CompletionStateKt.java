package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class CompletionStateKt {
    public static final <T> Object toState(@NotNull Object obj) {
        Throwable thM5475exceptionOrNullimpl = Result.m5475exceptionOrNullimpl(obj);
        return thM5475exceptionOrNullimpl == null ? obj : new CompletedExceptionally(thM5475exceptionOrNullimpl, false, 2, null);
    }

    public static final <T> Object toState(@NotNull Object obj, @NotNull CancellableContinuation<?> cancellableContinuation) {
        Throwable thM5475exceptionOrNullimpl = Result.m5475exceptionOrNullimpl(obj);
        return thM5475exceptionOrNullimpl == null ? obj : new CompletedExceptionally(thM5475exceptionOrNullimpl, false, 2, null);
    }

    public static final <T> Object recoverResult(@Nullable Object obj, @NotNull Continuation<? super T> continuation) {
        if (obj instanceof CompletedExceptionally) {
            Result.Companion companion = Result.Companion;
            return Result.m5472constructorimpl(ResultKt.createFailure(((CompletedExceptionally) obj).cause));
        }
        Result.Companion companion2 = Result.Companion;
        return Result.m5472constructorimpl(obj);
    }
}
