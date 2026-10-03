package com.swmansion.rnscreens;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.Window;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JSExceptionHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ScreenWindowTraits$setColor$1 extends GuardedRunnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ boolean $animated;
    final /* synthetic */ Integer $color;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScreenWindowTraits$setColor$1(Activity activity, Integer num, boolean z, JSExceptionHandler jSExceptionHandler) {
        super(jSExceptionHandler);
        this.$activity = activity;
        this.$color = num;
        this.$animated = z;
    }

    @Override // com.facebook.react.bridge.GuardedRunnable
    public void runGuarded() {
        final Window window = this.$activity.getWindow();
        int statusBarColor = window.getStatusBarColor();
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(statusBarColor), this.$color);
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.swmansion.rnscreens.ScreenWindowTraits$setColor$1$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScreenWindowTraits$setColor$1.runGuarded$lambda$0(window, valueAnimator);
            }
        });
        if (this.$animated) {
            valueAnimatorOfObject.setDuration(300L).setStartDelay(0L);
        } else {
            valueAnimatorOfObject.setDuration(0L).setStartDelay(300L);
        }
        valueAnimatorOfObject.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runGuarded$lambda$0(Window window, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        window.setStatusBarColor(((Integer) animatedValue).intValue());
    }
}
