package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class SnapshotStateExtensionsKt {
    public static final IntState asIntState(@NotNull State<Integer> state) {
        return state instanceof IntState ? (IntState) state : new UnboxedIntState(state);
    }

    public static final LongState asLongState(@NotNull State<Long> state) {
        return state instanceof LongState ? (LongState) state : new UnboxedLongState(state);
    }

    public static final FloatState asFloatState(@NotNull State<Float> state) {
        return state instanceof FloatState ? (FloatState) state : new UnboxedFloatState(state);
    }

    public static final DoubleState asDoubleState(@NotNull State<Double> state) {
        return state instanceof DoubleState ? (DoubleState) state : new UnboxedDoubleState(state);
    }
}
