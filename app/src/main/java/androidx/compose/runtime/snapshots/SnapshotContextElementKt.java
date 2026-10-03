package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.SnapshotContextElementImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class SnapshotContextElementKt {
    public static final SnapshotContextElement asContextElement(@NotNull Snapshot snapshot) {
        return new SnapshotContextElementImpl(snapshot);
    }
}
