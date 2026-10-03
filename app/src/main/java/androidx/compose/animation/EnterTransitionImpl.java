package androidx.compose.animation;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
final class EnterTransitionImpl extends EnterTransition {
    private final TransitionData data;

    public EnterTransitionImpl(@NotNull TransitionData transitionData) {
        super(null);
        this.data = transitionData;
    }

    @Override // androidx.compose.animation.EnterTransition
    public TransitionData getData$animation_release() {
        return this.data;
    }
}
