package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import ch.qos.logback.core.CoreConstants;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class AnimationResult<T, V extends AnimationVector> {
    public static final int $stable = 0;
    private final AnimationEndReason endReason;
    private final AnimationState<T, V> endState;

    public AnimationResult(@NotNull AnimationState<T, V> animationState, @NotNull AnimationEndReason animationEndReason) {
        this.endState = animationState;
        this.endReason = animationEndReason;
    }

    public final AnimationState<T, V> getEndState() {
        return this.endState;
    }

    public final AnimationEndReason getEndReason() {
        return this.endReason;
    }

    public String toString() {
        return "AnimationResult(endReason=" + this.endReason + ", endState=" + this.endState + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
