package androidx.compose.runtime;

import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class SnapshotIntStateKt__SnapshotIntStateKt {
    public static final MutableIntState mutableIntStateOf(int i) {
        return ActualAndroid_androidKt.createSnapshotMutableIntState(i);
    }

    public static final int getValue(@NotNull IntState intState, @Nullable Object obj, @NotNull KProperty<?> kProperty) {
        return intState.getIntValue();
    }

    public static final void setValue(@NotNull MutableIntState mutableIntState, @Nullable Object obj, @NotNull KProperty<?> kProperty, int i) {
        mutableIntState.setIntValue(i);
    }
}
