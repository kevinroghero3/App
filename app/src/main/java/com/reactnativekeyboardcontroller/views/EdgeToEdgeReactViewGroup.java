package com.reactnativekeyboardcontroller.views;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactnativekeyboardcontroller.extensions.ReactContextKt;
import com.reactnativekeyboardcontroller.extensions.ViewGroupKt;
import com.reactnativekeyboardcontroller.extensions.ViewKt;
import com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallback;
import com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallbackConfig;
import com.reactnativekeyboardcontroller.log.Logger;
import com.reactnativekeyboardcontroller.modal.ModalAttachedWatcher;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class EdgeToEdgeReactViewGroup extends ReactViewGroup {
    private boolean active;
    private KeyboardAnimationCallback callback;
    private final KeyboardAnimationCallbackConfig config;
    private ReactViewGroup eventView;
    private boolean isEdgeToEdge;
    private boolean isNavigationBarTranslucent;
    private boolean isPreservingEdgeToEdge;
    private boolean isStatusBarTranslucent;
    private final ModalAttachedWatcher modalAttachedWatcher;
    private final ThemedReactContext reactContext;
    private boolean wasMounted;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EdgeToEdgeReactViewGroup(@NotNull ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        KeyboardAnimationCallbackConfig keyboardAnimationCallbackConfig = new KeyboardAnimationCallbackConfig(WindowInsetsCompat.Type.systemBars(), WindowInsetsCompat.Type.ime(), 1, this.isNavigationBarTranslucent);
        this.config = keyboardAnimationCallbackConfig;
        this.modalAttachedWatcher = new ModalAttachedWatcher(this, reactContext, keyboardAnimationCallbackConfig, new EdgeToEdgeReactViewGroup$modalAttachedWatcher$1(this));
        EdgeToEdgeViewRegistry.INSTANCE.register(this);
    }

    public final boolean getActive() {
        return this.active;
    }

    public final void setActive(boolean z) {
        this.active = z;
        if (z) {
            enable();
        } else {
            disable();
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.wasMounted) {
            this.wasMounted = true;
        } else {
            activate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        deactivate();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration configuration) {
        reApplyWindowInsets();
    }

    private final void setupWindowInsets() {
        View rootView = ReactContextKt.getRootView(this.reactContext);
        if (rootView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(rootView, new OnApplyWindowInsetsListener() { // from class: com.reactnativekeyboardcontroller.views.EdgeToEdgeReactViewGroup$$ExternalSyntheticLambda0
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return EdgeToEdgeReactViewGroup.setupWindowInsets$lambda$0(this.f$0, view, windowInsetsCompat);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat setupWindowInsets$lambda$0(EdgeToEdgeReactViewGroup edgeToEdgeReactViewGroup, View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        ViewGroup content = ReactContextKt.getContent(edgeToEdgeReactViewGroup.reactContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        boolean z = edgeToEdgeReactViewGroup.active;
        boolean z2 = true;
        boolean z3 = !z || edgeToEdgeReactViewGroup.isStatusBarTranslucent;
        if (z && !edgeToEdgeReactViewGroup.isNavigationBarTranslucent) {
            z2 = false;
        }
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        Insets insets3 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets3, "getInsets(...)");
        layoutParams.setMargins(insets2.left, z3 ? 0 : insets3.top, insets2.right, z2 ? 0 : insets2.bottom);
        if (content != null) {
            content.setLayoutParams(layoutParams);
        }
        WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = ViewCompat.onApplyWindowInsets(v, insets);
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatOnApplyWindowInsets, "onApplyWindowInsets(...)");
        return windowInsetsCompatOnApplyWindowInsets.replaceSystemWindowInsets(windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetLeft(), edgeToEdgeReactViewGroup.isStatusBarTranslucent ? 0 : windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetTop(), windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetRight(), windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetBottom());
    }

    public final void setEdgeToEdge() {
        boolean z = this.active || this.isPreservingEdgeToEdge;
        if (this.isEdgeToEdge != z) {
            this.isEdgeToEdge = z;
            Activity currentActivity = this.reactContext.getCurrentActivity();
            if (currentActivity != null) {
                WindowCompat.setDecorFitsSystemWindows(currentActivity.getWindow(), true ^ this.isEdgeToEdge);
            }
        }
    }

    private final void setupKeyboardCallbacks() {
        if (this.reactContext.getCurrentActivity() == null) {
            Logger.w$default(Logger.INSTANCE, EdgeToEdgeReactViewGroupKt.TAG, "Can not setup keyboard animation listener, since `currentActivity` is null", null, 4, null);
            return;
        }
        this.eventView = new ReactViewGroup(getContext());
        ViewGroup content = ReactContextKt.getContent(this.reactContext);
        if (content != null) {
            content.addView(this.eventView);
        }
        KeyboardAnimationCallback keyboardAnimationCallback = new KeyboardAnimationCallback(this, this, this.reactContext, this.config);
        this.callback = keyboardAnimationCallback;
        ReactViewGroup reactViewGroup = this.eventView;
        if (reactViewGroup != null) {
            ViewCompat.setWindowInsetsAnimationCallback(reactViewGroup, keyboardAnimationCallback);
            ViewCompat.setOnApplyWindowInsetsListener(reactViewGroup, this.callback);
            ViewKt.requestApplyInsetsWhenAttached(reactViewGroup);
        }
    }

    private final void removeKeyboardCallbacks() {
        KeyboardAnimationCallback keyboardAnimationCallback = this.callback;
        if (keyboardAnimationCallback != null) {
            keyboardAnimationCallback.destroy();
        }
        final ReactViewGroup reactViewGroup = this.eventView;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.reactnativekeyboardcontroller.views.EdgeToEdgeReactViewGroup$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ViewGroupKt.removeSelf(reactViewGroup);
            }
        });
    }

    private final void reApplyWindowInsets() {
        setupWindowInsets();
        ViewKt.requestApplyInsetsWhenAttached(this);
    }

    private final void enable() {
        setupWindowInsets();
        activate();
    }

    private final void disable() {
        setupWindowInsets();
        deactivate();
    }

    private final void activate() {
        setupKeyboardCallbacks();
        this.modalAttachedWatcher.enable();
    }

    private final void deactivate() {
        removeKeyboardCallbacks();
        this.modalAttachedWatcher.disable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KeyboardAnimationCallback getKeyboardCallback() {
        return this.callback;
    }

    public final void setStatusBarTranslucent(boolean z) {
        this.isStatusBarTranslucent = z;
    }

    public final void setNavigationBarTranslucent(boolean z) {
        this.isNavigationBarTranslucent = z;
        this.config.setHasTranslucentNavigationBar(z);
    }

    public final void setPreserveEdgeToEdge(boolean z) {
        this.isPreservingEdgeToEdge = z;
    }

    public final void forceStatusBarTranslucent(boolean z) {
        if (!this.active || this.isStatusBarTranslucent == z) {
            return;
        }
        this.isStatusBarTranslucent = z;
        reApplyWindowInsets();
    }
}
