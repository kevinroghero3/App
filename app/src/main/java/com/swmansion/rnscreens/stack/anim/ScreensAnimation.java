package com.swmansion.rnscreens.stack.anim;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.swmansion.rnscreens.ScreenFragment;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ScreensAnimation extends Animation {
    private final ScreenFragment mFragment;

    public ScreensAnimation(@NotNull ScreenFragment mFragment) {
        Intrinsics.checkNotNullParameter(mFragment, "mFragment");
        this.mFragment = mFragment;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, @NotNull Transformation t) {
        Intrinsics.checkNotNullParameter(t, "t");
        super.applyTransformation(f, t);
        ScreenFragment screenFragment = this.mFragment;
        screenFragment.dispatchTransitionProgressEvent(f, !screenFragment.isResumed());
    }
}
