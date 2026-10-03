package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface VectorizedAnimationSpec<V extends AnimationVector> {
    long getDurationNanos(@NotNull V v, @NotNull V v2, @NotNull V v3);

    V getValueFromNanos(long j, @NotNull V v, @NotNull V v2, @NotNull V v3);

    V getVelocityFromNanos(long j, @NotNull V v, @NotNull V v2, @NotNull V v3);

    boolean isInfinite();

    /* JADX INFO: loaded from: classes3.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <V extends AnimationVector> V getEndVelocity(@NotNull VectorizedAnimationSpec<V> vectorizedAnimationSpec, @NotNull V v, @NotNull V v2, @NotNull V v3) {
            return (V) VectorizedAnimationSpec.super.getEndVelocity(v, v2, v3);
        }
    }

    default V getEndVelocity(@NotNull V v, @NotNull V v2, @NotNull V v3) {
        return (V) getVelocityFromNanos(getDurationNanos(v, v2, v3), v, v2, v3);
    }
}
