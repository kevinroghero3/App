package androidx.compose.runtime.snapshots;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class SnapshotApplyConflictException extends Exception {
    public static final int $stable = 8;
    private final Snapshot snapshot;

    public final Snapshot getSnapshot() {
        return this.snapshot;
    }

    public SnapshotApplyConflictException(@NotNull Snapshot snapshot) {
        this.snapshot = snapshot;
    }
}
