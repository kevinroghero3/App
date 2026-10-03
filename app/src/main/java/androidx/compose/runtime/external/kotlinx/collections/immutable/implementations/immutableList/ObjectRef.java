package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ObjectRef {
    public static final int $stable = 8;
    private Object value;

    public ObjectRef(@Nullable Object obj) {
        this.value = obj;
    }

    public final Object getValue() {
        return this.value;
    }

    public final void setValue(@Nullable Object obj) {
        this.value = obj;
    }
}
