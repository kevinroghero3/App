package com.reactnativekeyboardcontroller.modules.statusbar;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.Window;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.reactnativekeyboardcontroller.log.Logger;
import com.reactnativekeyboardcontroller.views.EdgeToEdgeReactViewGroup;
import com.reactnativekeyboardcontroller.views.EdgeToEdgeViewRegistry;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class StatusBarManagerCompatModuleImpl {
    public static final Companion Companion = new Companion(null);
    private static final long DEFAULT_ANIMATION_TIME = 300;
    public static final String NAME = "StatusBarManager";
    private WindowInsetsControllerCompat controller;
    private WeakReference<Activity> lastActivity;
    private final ReactApplicationContext mReactContext;
    private StatusBarModuleProxy original;

    public StatusBarManagerCompatModuleImpl(@NotNull ReactApplicationContext mReactContext) {
        Intrinsics.checkNotNullParameter(mReactContext, "mReactContext");
        this.mReactContext = mReactContext;
        this.original = new StatusBarModuleProxy(mReactContext);
        this.lastActivity = new WeakReference<>(null);
    }

    public final void setHidden(final boolean z) {
        if (!isEnabled()) {
            this.original.setHidden(z);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.statusbar.StatusBarManagerCompatModuleImpl$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    StatusBarManagerCompatModuleImpl.setHidden$lambda$0(z, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHidden$lambda$0(boolean z, StatusBarManagerCompatModuleImpl statusBarManagerCompatModuleImpl) {
        if (z) {
            WindowInsetsControllerCompat controller = statusBarManagerCompatModuleImpl.getController();
            if (controller != null) {
                controller.hide(WindowInsetsCompat.Type.statusBars());
                return;
            }
            return;
        }
        WindowInsetsControllerCompat controller2 = statusBarManagerCompatModuleImpl.getController();
        if (controller2 != null) {
            controller2.show(WindowInsetsCompat.Type.statusBars());
        }
    }

    public final void setColor(final int i, final boolean z) {
        if (!isEnabled()) {
            this.original.setColor(i, z);
            return;
        }
        final Activity currentActivity = this.mReactContext.getCurrentActivity();
        if (currentActivity == null) {
            Logger.w$default(Logger.INSTANCE, StatusBarManagerCompatModuleImplKt.TAG, "StatusBarManagerCompatModule: Ignored status bar change, current activity is null.", null, 4, null);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.statusbar.StatusBarManagerCompatModuleImpl$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    StatusBarManagerCompatModuleImpl.setColor$lambda$2(currentActivity, z, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setColor$lambda$2(Activity activity, boolean z, int i) {
        final Window window = activity.getWindow();
        if (z) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(window.getStatusBarColor()), Integer.valueOf(i));
            valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.reactnativekeyboardcontroller.modules.statusbar.StatusBarManagerCompatModuleImpl$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    StatusBarManagerCompatModuleImpl.setColor$lambda$2$lambda$1(window, valueAnimator);
                }
            });
            valueAnimatorOfObject.setDuration(DEFAULT_ANIMATION_TIME).setStartDelay(0L);
            valueAnimatorOfObject.start();
            return;
        }
        window.setStatusBarColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setColor$lambda$2$lambda$1(Window window, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        window.setStatusBarColor(((Integer) animatedValue).intValue());
    }

    public final void setTranslucent(final boolean z) {
        if (!isEnabled()) {
            this.original.setTranslucent(z);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.statusbar.StatusBarManagerCompatModuleImpl$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    StatusBarManagerCompatModuleImpl.setTranslucent$lambda$3(this.f$0, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTranslucent$lambda$3(StatusBarManagerCompatModuleImpl statusBarManagerCompatModuleImpl, boolean z) {
        EdgeToEdgeReactViewGroup edgeToEdgeReactViewGroupView = statusBarManagerCompatModuleImpl.view();
        if (edgeToEdgeReactViewGroupView != null) {
            edgeToEdgeReactViewGroupView.forceStatusBarTranslucent(z);
        }
    }

    public final void setStyle(@NotNull final String style) {
        Intrinsics.checkNotNullParameter(style, "style");
        if (!isEnabled()) {
            this.original.setStyle(style);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.statusbar.StatusBarManagerCompatModuleImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    StatusBarManagerCompatModuleImpl.setStyle$lambda$4(this.f$0, style);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStyle$lambda$4(StatusBarManagerCompatModuleImpl statusBarManagerCompatModuleImpl, String str) {
        WindowInsetsControllerCompat controller = statusBarManagerCompatModuleImpl.getController();
        if (controller != null) {
            controller.setAppearanceLightStatusBars(Intrinsics.areEqual(str, "dark-content"));
        }
    }

    public final Map<String, Object> getConstants() {
        return this.original.getConstants();
    }

    private final WindowInsetsControllerCompat getController() {
        Activity currentActivity = this.mReactContext.getCurrentActivity();
        if (this.controller == null || !Intrinsics.areEqual(currentActivity, this.lastActivity.get())) {
            if (currentActivity == null) {
                Logger.w$default(Logger.INSTANCE, StatusBarManagerCompatModuleImplKt.TAG, "StatusBarManagerCompatModule: can not get `WindowInsetsControllerCompat` because current activity is null.", null, 4, null);
                return this.controller;
            }
            Window window = currentActivity.getWindow();
            this.lastActivity = new WeakReference<>(currentActivity);
            this.controller = new WindowInsetsControllerCompat(window, window.getDecorView());
        }
        return this.controller;
    }

    private final boolean isEnabled() {
        EdgeToEdgeReactViewGroup edgeToEdgeReactViewGroupView = view();
        if (edgeToEdgeReactViewGroupView != null) {
            return edgeToEdgeReactViewGroupView.getActive();
        }
        return false;
    }

    private final EdgeToEdgeReactViewGroup view() {
        return EdgeToEdgeViewRegistry.INSTANCE.get();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
