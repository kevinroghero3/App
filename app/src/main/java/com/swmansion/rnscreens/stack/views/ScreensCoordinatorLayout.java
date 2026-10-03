package com.swmansion.rnscreens.stack.views;

import android.content.Context;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.swmansion.rnscreens.PointerEventsBoxNoneImpl;
import com.swmansion.rnscreens.ScreenStackFragment;
import com.swmansion.rnscreens.bottomsheet.SheetUtilsKt;
import com.swmansion.rnscreens.stack.anim.ScreensAnimation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class ScreensCoordinatorLayout extends CoordinatorLayout implements ReactPointerEventsView {
    private final Animation.AnimationListener animationListener;
    private final ScreenStackFragment fragment;
    private final ReactPointerEventsView pointerEventsImpl;

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        return this.pointerEventsImpl.getPointerEvents();
    }

    public final ScreenStackFragment getFragment$react_native_screens_release() {
        return this.fragment;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreensCoordinatorLayout(@NotNull Context context, @NotNull ScreenStackFragment fragment, @NotNull ReactPointerEventsView pointerEventsImpl) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(pointerEventsImpl, "pointerEventsImpl");
        this.fragment = fragment;
        this.pointerEventsImpl = pointerEventsImpl;
        this.animationListener = new Animation.AnimationListener() { // from class: com.swmansion.rnscreens.stack.views.ScreensCoordinatorLayout$animationListener$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.getFragment$react_native_screens_release().onViewAnimationStart();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.getFragment$react_native_screens_release().onViewAnimationEnd();
            }
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScreensCoordinatorLayout(@NotNull Context context, @NotNull ScreenStackFragment fragment) {
        this(context, fragment, new PointerEventsBoxNoneImpl());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(@Nullable WindowInsets windowInsets) {
        WindowInsets windowInsetsOnApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        Intrinsics.checkNotNullExpressionValue(windowInsetsOnApplyWindowInsets, "onApplyWindowInsets(...)");
        return windowInsetsOnApplyWindowInsets;
    }

    @Override // android.view.View
    public void startAnimation(@NotNull Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        ScreensAnimation screensAnimation = new ScreensAnimation(this.fragment);
        screensAnimation.setDuration(animation.getDuration());
        if ((animation instanceof AnimationSet) && !this.fragment.isRemoving()) {
            AnimationSet animationSet = (AnimationSet) animation;
            animationSet.addAnimation(screensAnimation);
            animationSet.setAnimationListener(this.animationListener);
            super.startAnimation(animationSet);
            return;
        }
        AnimationSet animationSet2 = new AnimationSet(true);
        animationSet2.addAnimation(animation);
        animationSet2.addAnimation(screensAnimation);
        animationSet2.setAnimationListener(this.animationListener);
        super.startAnimation(animationSet2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        if (getVisibility() != 4) {
            super.clearFocus();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (SheetUtilsKt.usesFormSheetPresentation(this.fragment.getScreen())) {
            this.fragment.getScreen().onBottomSheetBehaviorDidLayout$react_native_screens_release(z);
        }
    }
}
