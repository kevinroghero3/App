package androidx.compose.animation;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
final class ExitTransitionImpl extends ExitTransition {
    private final TransitionData data;

    public ExitTransitionImpl(@NotNull TransitionData transitionData) {
        super(null);
        this.data = transitionData;
    }

    @Override // androidx.compose.animation.ExitTransition
    public TransitionData getData$animation_release() {
        return this.data;
    }
}
