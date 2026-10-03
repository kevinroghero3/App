package com.swmansion.rnscreens.events;

import android.animation.Animator;
import com.swmansion.rnscreens.ScreenStackFragmentWrapper;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class ScreenAnimationDelegate implements Animator.AnimatorListener {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "ScreenEventDelegate";
    private final AnimationType animationType;
    private LifecycleState currentState;
    private final ScreenEventEmitter eventEmitter;
    private final ScreenStackFragmentWrapper wrapper;

    public enum AnimationType {
        ENTER,
        EXIT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<AnimationType> getEntries() {
            return $ENTRIES;
        }
    }

    enum LifecycleState {
        INITIALIZED,
        START_DISPATCHED,
        END_DISPATCHED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<LifecycleState> getEntries() {
            return $ENTRIES;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LifecycleState.values().length];
            try {
                iArr[LifecycleState.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LifecycleState.START_DISPATCHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LifecycleState.END_DISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AnimationType.values().length];
            try {
                iArr2[AnimationType.ENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[AnimationType.EXIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@NotNull Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@NotNull Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public ScreenAnimationDelegate(@NotNull ScreenStackFragmentWrapper wrapper, @Nullable ScreenEventEmitter screenEventEmitter, @NotNull AnimationType animationType) {
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        Intrinsics.checkNotNullParameter(animationType, "animationType");
        this.wrapper = wrapper;
        this.eventEmitter = screenEventEmitter;
        this.animationType = animationType;
        this.currentState = LifecycleState.INITIALIZED;
    }

    private final void progressState() {
        LifecycleState lifecycleState;
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentState.ordinal()];
        if (i == 1) {
            lifecycleState = LifecycleState.START_DISPATCHED;
        } else {
            if (i != 2 && i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            lifecycleState = LifecycleState.END_DISPATCHED;
        }
        this.currentState = lifecycleState;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@NotNull Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (this.currentState == LifecycleState.INITIALIZED) {
            progressState();
            int i = WhenMappings.$EnumSwitchMapping$1[this.animationType.ordinal()];
            if (i == 1) {
                ScreenEventEmitter screenEventEmitter = this.eventEmitter;
                if (screenEventEmitter != null) {
                    screenEventEmitter.dispatchOnWillAppear();
                }
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                ScreenEventEmitter screenEventEmitter2 = this.eventEmitter;
                if (screenEventEmitter2 != null) {
                    screenEventEmitter2.dispatchOnWillDisappear();
                }
            }
            boolean z = this.animationType == AnimationType.EXIT;
            ScreenEventEmitter screenEventEmitter3 = this.eventEmitter;
            if (screenEventEmitter3 != null) {
                screenEventEmitter3.dispatchTransitionProgress(0.0f, z, z);
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@NotNull Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (this.currentState == LifecycleState.START_DISPATCHED) {
            progressState();
            animation.removeListener(this);
            int i = WhenMappings.$EnumSwitchMapping$1[this.animationType.ordinal()];
            if (i == 1) {
                ScreenEventEmitter screenEventEmitter = this.eventEmitter;
                if (screenEventEmitter != null) {
                    screenEventEmitter.dispatchOnAppear();
                }
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                ScreenEventEmitter screenEventEmitter2 = this.eventEmitter;
                if (screenEventEmitter2 != null) {
                    screenEventEmitter2.dispatchOnDisappear();
                }
            }
            boolean z = this.animationType == AnimationType.EXIT;
            ScreenEventEmitter screenEventEmitter3 = this.eventEmitter;
            if (screenEventEmitter3 != null) {
                screenEventEmitter3.dispatchTransitionProgress(1.0f, z, z);
            }
            this.wrapper.getScreen().endRemovalTransition();
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
