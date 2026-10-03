package com.reactnativekeyboardcontroller;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewManager;
import com.reactnativekeyboardcontroller.managers.KeyboardGestureAreaViewManagerImpl;
import com.reactnativekeyboardcontroller.views.KeyboardGestureAreaReactViewGroup;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class KeyboardGestureAreaViewManager extends ReactViewManager {
    private final KeyboardGestureAreaViewManagerImpl manager = new KeyboardGestureAreaViewManagerImpl();

    @ReactProp(name = "textInputNativeID")
    public final void setTextInputNativeID(@NotNull KeyboardGestureAreaReactViewGroup view, @NotNull String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return KeyboardGestureAreaViewManagerImpl.NAME;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public KeyboardGestureAreaReactViewGroup createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return this.manager.createViewInstance(reactContext);
    }

    @ReactProp(name = TypedValues.CycleType.S_WAVE_OFFSET)
    public final void setInterpolator(@NotNull KeyboardGestureAreaReactViewGroup view, double d) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setOffset(view, d);
    }

    @ReactProp(name = "interpolator")
    public final void setInterpolator(@NotNull KeyboardGestureAreaReactViewGroup view, @NotNull String interpolator) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        this.manager.setInterpolator(view, interpolator);
    }

    @ReactProp(name = "showOnSwipeUp")
    public final void setScrollKeyboardOnScreenWhenNotVisible(@NotNull KeyboardGestureAreaReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setScrollKeyboardOnScreenWhenNotVisible(view, z);
    }

    @ReactProp(name = "enableSwipeToDismiss")
    public final void setScrollKeyboardOffScreenWhenVisible(@NotNull KeyboardGestureAreaReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setScrollKeyboardOffScreenWhenVisible(view, z);
    }
}
