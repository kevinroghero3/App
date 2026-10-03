package com.facebook.fresco.animation.drawable.animator;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class AnimatedDrawable2ValueAnimatorHelper {
    public static final AnimatedDrawable2ValueAnimatorHelper INSTANCE = new AnimatedDrawable2ValueAnimatorHelper();

    private AnimatedDrawable2ValueAnimatorHelper() {
    }

    @JvmStatic
    public static final ValueAnimator createValueAnimator(@NotNull AnimatedDrawable2 animatedDrawable, int i) {
        Intrinsics.checkNotNullParameter(animatedDrawable, "animatedDrawable");
        ValueAnimator valueAnimatorCreateValueAnimator = createValueAnimator(animatedDrawable, animatedDrawable.getLoopCount(), animatedDrawable.getLoopDurationMs());
        if (valueAnimatorCreateValueAnimator == null) {
            return null;
        }
        valueAnimatorCreateValueAnimator.setRepeatCount((int) Math.max(((long) i) / animatedDrawable.getLoopDurationMs(), 1L));
        return valueAnimatorCreateValueAnimator;
    }

    @JvmStatic
    public static final ValueAnimator createValueAnimator(@NotNull Drawable animatedDrawable, int i, long j) {
        Intrinsics.checkNotNullParameter(animatedDrawable, "animatedDrawable");
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, (int) j);
        valueAnimator.setDuration(j);
        if (i == 0) {
            i = -1;
        }
        valueAnimator.setRepeatCount(i);
        valueAnimator.setRepeatMode(1);
        valueAnimator.setInterpolator(null);
        valueAnimator.addUpdateListener(createAnimatorUpdateListener(animatedDrawable));
        return valueAnimator;
    }

    @JvmStatic
    public static final ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener(@NotNull final Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.facebook.fresco.animation.drawable.animator.AnimatedDrawable2ValueAnimatorHelper$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimatedDrawable2ValueAnimatorHelper.createAnimatorUpdateListener$lambda$0(drawable, valueAnimator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAnimatorUpdateListener$lambda$0(Drawable drawable, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(drawable, "$drawable");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        drawable.setLevel(((Integer) animatedValue).intValue());
    }
}
