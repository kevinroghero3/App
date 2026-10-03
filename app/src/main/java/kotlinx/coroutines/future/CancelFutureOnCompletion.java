package kotlinx.coroutines.future;

import java.util.concurrent.Future;
import kotlinx.coroutines.JobNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
final class CancelFutureOnCompletion extends JobNode {
    private final Future<?> future;

    @Override // kotlinx.coroutines.JobNode
    public boolean getOnCancelling() {
        return false;
    }

    public CancelFutureOnCompletion(@NotNull Future<?> future) {
        this.future = future;
    }

    @Override // kotlinx.coroutines.JobNode
    public void invoke(@Nullable Throwable th) {
        if (th == null || this.future.isDone()) {
            return;
        }
        this.future.cancel(false);
    }
}
