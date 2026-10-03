package com.facebook.fresco.animation.drawable.animator;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AnimatedDrawableValueAnimatorHelper {
    public static final AnimatedDrawableValueAnimatorHelper INSTANCE = new AnimatedDrawableValueAnimatorHelper();

    private AnimatedDrawableValueAnimatorHelper() {
    }

    @JvmStatic
    public static final ValueAnimator createValueAnimator(@Nullable Drawable drawable, int i) {
        if (drawable instanceof AnimatedDrawable2) {
            return AnimatedDrawable2ValueAnimatorHelper.createValueAnimator((AnimatedDrawable2) drawable, i);
        }
        return null;
    }

    @JvmStatic
    public static final ValueAnimator createValueAnimator(@Nullable Drawable drawable) {
        if (!(drawable instanceof AnimatedDrawable2)) {
            return null;
        }
        AnimatedDrawable2 animatedDrawable2 = (AnimatedDrawable2) drawable;
        return AnimatedDrawable2ValueAnimatorHelper.createValueAnimator(drawable, animatedDrawable2.getLoopCount(), animatedDrawable2.getLoopDurationMs());
    }

    @JvmStatic
    public static final ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener(@Nullable Drawable drawable) {
        if (drawable instanceof AnimatedDrawable2) {
            return AnimatedDrawable2ValueAnimatorHelper.createAnimatorUpdateListener((AnimatedDrawable2) drawable);
        }
        return null;
    }
}
