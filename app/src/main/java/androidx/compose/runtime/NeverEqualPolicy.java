package androidx.compose.runtime;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class NeverEqualPolicy implements SnapshotMutationPolicy<Object> {
    public static final NeverEqualPolicy INSTANCE = new NeverEqualPolicy();

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public boolean equivalent(@Nullable Object obj, @Nullable Object obj2) {
        return false;
    }

    private NeverEqualPolicy() {
    }

    public String toString() {
        return "NeverEqualPolicy";
    }
}
