package androidx.compose.runtime;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class ReferentialEqualityPolicy implements SnapshotMutationPolicy<Object> {
    public static final ReferentialEqualityPolicy INSTANCE = new ReferentialEqualityPolicy();

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public boolean equivalent(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2;
    }

    private ReferentialEqualityPolicy() {
    }

    public String toString() {
        return "ReferentialEqualityPolicy";
    }
}
