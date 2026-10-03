package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface VectorizedDecayAnimationSpec<V extends AnimationVector> {
    float getAbsVelocityThreshold();

    long getDurationNanos(@NotNull V v, @NotNull V v2);

    V getTargetValue(@NotNull V v, @NotNull V v2);

    V getValueFromNanos(long j, @NotNull V v, @NotNull V v2);

    V getVelocityFromNanos(long j, @NotNull V v, @NotNull V v2);
}
