package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
final class DisposeOnCompletion extends JobNode {
    private final DisposableHandle handle;

    @Override // kotlinx.coroutines.JobNode
    public boolean getOnCancelling() {
        return false;
    }

    public DisposeOnCompletion(@NotNull DisposableHandle disposableHandle) {
        this.handle = disposableHandle;
    }

    @Override // kotlinx.coroutines.JobNode
    public void invoke(@Nullable Throwable th) {
        this.handle.dispose();
    }
}
