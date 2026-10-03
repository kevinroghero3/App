package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
final class ResumeOnCompletion extends JobNode {
    private final Continuation<Unit> continuation;

    @Override // kotlinx.coroutines.JobNode
    public boolean getOnCancelling() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeOnCompletion(@NotNull Continuation<? super Unit> continuation) {
        this.continuation = continuation;
    }

    @Override // kotlinx.coroutines.JobNode
    public void invoke(@Nullable Throwable th) {
        Continuation<Unit> continuation = this.continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m5472constructorimpl(Unit.INSTANCE));
    }
}
