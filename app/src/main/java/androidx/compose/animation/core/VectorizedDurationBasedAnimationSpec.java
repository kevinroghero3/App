package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface VectorizedDurationBasedAnimationSpec<V extends AnimationVector> extends VectorizedFiniteAnimationSpec<V> {
    int getDelayMillis();

    int getDurationMillis();

    /* JADX INFO: loaded from: classes3.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <V extends AnimationVector> V getEndVelocity(@NotNull VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec, @NotNull V v, @NotNull V v2, @NotNull V v3) {
            return (V) VectorizedDurationBasedAnimationSpec.super.getEndVelocity(v, v2, v3);
        }

        @Deprecated
        public static <V extends AnimationVector> boolean isInfinite(@NotNull VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec) {
            return VectorizedDurationBasedAnimationSpec.super.isInfinite();
        }

        @Deprecated
        public static <V extends AnimationVector> long getDurationNanos(@NotNull VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec, @NotNull V v, @NotNull V v2, @NotNull V v3) {
            return VectorizedDurationBasedAnimationSpec.super.getDurationNanos(v, v2, v3);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    default long getDurationNanos(@NotNull V v, @NotNull V v2, @NotNull V v3) {
        return ((long) (getDelayMillis() + getDurationMillis())) * AnimationKt.MillisToNanos;
    }
}
