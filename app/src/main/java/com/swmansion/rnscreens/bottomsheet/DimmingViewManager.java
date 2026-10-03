package com.swmansion.rnscreens.bottomsheet;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenStackFragment;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class DimmingViewManager {
    private final DimmingView dimmingView;
    private BottomSheetBehavior.BottomSheetCallback dimmingViewCallback;
    private final float maxAlpha;
    private final ThemedReactContext reactContext;

    public DimmingViewManager(@NotNull ThemedReactContext reactContext, @NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.reactContext = reactContext;
        this.dimmingView = createDimmingView(screen);
        this.maxAlpha = 0.3f;
    }

    public final ThemedReactContext getReactContext() {
        return this.reactContext;
    }

    public final DimmingView getDimmingView$react_native_screens_release() {
        return this.dimmingView;
    }

    public final float getMaxAlpha$react_native_screens_release() {
        return this.maxAlpha;
    }

    public final void onViewHierarchyCreated(@NotNull Screen screen, @NotNull ViewGroup root) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(root, "root");
        root.addView(this.dimmingView, 0);
        if (!willDimForDetentIndex(screen, screen.getSheetInitialDetentIndex())) {
            this.dimmingView.setAlpha(0.0f);
        } else {
            this.dimmingView.setAlpha(this.maxAlpha);
        }
    }

    public final void onBehaviourAttached(@NotNull Screen screen, @NotNull BottomSheetBehavior<Screen> behavior) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        behavior.addBottomSheetCallback(requireBottomSheetCallback(screen, true));
    }

    public final boolean willDimForDetentIndex(@NotNull Screen screen, int i) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        return i > screen.getSheetLargestUndimmedDetentIndex();
    }

    public final void invalidate(@Nullable BottomSheetBehavior<Screen> bottomSheetBehavior) {
        BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = this.dimmingViewCallback;
        if (bottomSheetCallback == null || bottomSheetBehavior == null) {
            return;
        }
        bottomSheetBehavior.removeBottomSheetCallback(bottomSheetCallback);
    }

    static final class AnimateDimmingViewCallback extends BottomSheetBehavior.BottomSheetCallback {
        private final ValueAnimator animator;
        private float firstDimmedOffset;
        private float intervalLength;
        private float largestUndimmedOffset;
        private final float maxAlpha;
        private final Screen screen;
        private final View viewToAnimate;

        public final Screen getScreen() {
            return this.screen;
        }

        public final View getViewToAnimate() {
            return this.viewToAnimate;
        }

        public final float getMaxAlpha() {
            return this.maxAlpha;
        }

        public AnimateDimmingViewCallback(@NotNull Screen screen, @NotNull View viewToAnimate, float f) {
            Intrinsics.checkNotNullParameter(screen, "screen");
            Intrinsics.checkNotNullParameter(viewToAnimate, "viewToAnimate");
            this.screen = screen;
            this.viewToAnimate = viewToAnimate;
            this.maxAlpha = f;
            this.largestUndimmedOffset = computeOffsetFromDetentIndex(screen.getSheetLargestUndimmedDetentIndex());
            float fComputeOffsetFromDetentIndex = computeOffsetFromDetentIndex(RangesKt___RangesKt.coerceIn(screen.getSheetLargestUndimmedDetentIndex() + 1, 0, screen.getSheetDetents().size() - 1));
            this.firstDimmedOffset = fComputeOffsetFromDetentIndex;
            this.intervalLength = fComputeOffsetFromDetentIndex - this.largestUndimmedOffset;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, f);
            valueAnimatorOfFloat.setDuration(1L);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.swmansion.rnscreens.bottomsheet.DimmingViewManager$AnimateDimmingViewCallback$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DimmingViewManager.AnimateDimmingViewCallback.animator$lambda$1$lambda$0(this.f$0, valueAnimator);
                }
            });
            this.animator = valueAnimatorOfFloat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void animator$lambda$1$lambda$0(AnimateDimmingViewCallback animateDimmingViewCallback, ValueAnimator it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            View view = animateDimmingViewCallback.viewToAnimate;
            Object animatedValue = it2.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            view.setAlpha(((Float) animatedValue).floatValue());
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@NotNull View bottomSheet, int i) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (i == 1 || i == 2) {
                this.largestUndimmedOffset = computeOffsetFromDetentIndex(this.screen.getSheetLargestUndimmedDetentIndex());
                float fComputeOffsetFromDetentIndex = computeOffsetFromDetentIndex(RangesKt___RangesKt.coerceIn(this.screen.getSheetLargestUndimmedDetentIndex() + 1, 0, this.screen.getSheetDetents().size() - 1));
                this.firstDimmedOffset = fComputeOffsetFromDetentIndex;
                this.intervalLength = fComputeOffsetFromDetentIndex - this.largestUndimmedOffset;
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@NotNull View bottomSheet, float f) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            float f2 = this.largestUndimmedOffset;
            if (f2 >= f || f >= this.firstDimmedOffset) {
                return;
            }
            this.animator.setCurrentFraction((f - f2) / this.intervalLength);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x003a A[RETURN, SYNTHETIC] */
        private final float computeOffsetFromDetentIndex(int i) {
            int size = this.screen.getSheetDetents().size();
            if (size == 1) {
                if (i == -1 || i != 0) {
                    return -1.0f;
                }
                return 1.0f;
            }
            if (size == 2) {
                if (i != -1) {
                    if (i != 0) {
                        if (i == 1) {
                            return 1.0f;
                        }
                    }
                    return 0.0f;
                }
                return -1.0f;
            }
            if (size == 3 && i != -1) {
                if (i != 0) {
                    if (i == 1) {
                        BottomSheetBehavior<Screen> sheetBehavior = this.screen.getSheetBehavior();
                        Intrinsics.checkNotNull(sheetBehavior);
                        return sheetBehavior.getHalfExpandedRatio();
                    }
                    if (i == 2) {
                        return 1.0f;
                    }
                }
                return 0.0f;
            }
            return -1.0f;
        }
    }

    private final DimmingView createDimmingView(final Screen screen) {
        DimmingView dimmingView = new DimmingView(this.reactContext, this.maxAlpha);
        dimmingView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        dimmingView.setOnClickListener(new View.OnClickListener() { // from class: com.swmansion.rnscreens.bottomsheet.DimmingViewManager$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DimmingViewManager.createDimmingView$lambda$2$lambda$1(screen, view);
            }
        });
        return dimmingView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDimmingView$lambda$2$lambda$1(Screen screen, View view) {
        if (screen.getSheetClosesOnTouchOutside()) {
            Fragment fragment = screen.getFragment();
            Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.swmansion.rnscreens.ScreenStackFragment");
            ((ScreenStackFragment) fragment).dismissSelf$react_native_screens_release();
        }
    }

    static /* synthetic */ BottomSheetBehavior.BottomSheetCallback requireBottomSheetCallback$default(DimmingViewManager dimmingViewManager, Screen screen, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return dimmingViewManager.requireBottomSheetCallback(screen, z);
    }

    private final BottomSheetBehavior.BottomSheetCallback requireBottomSheetCallback(Screen screen, boolean z) {
        if (this.dimmingViewCallback == null || z) {
            this.dimmingViewCallback = new AnimateDimmingViewCallback(screen, this.dimmingView, this.maxAlpha);
        }
        BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = this.dimmingViewCallback;
        Intrinsics.checkNotNull(bottomSheetCallback);
        return bottomSheetCallback;
    }
}
