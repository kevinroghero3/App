package com.reactnativekeyboardcontroller.managers;

import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativekeyboardcontroller.views.KeyboardGestureAreaReactViewGroup;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class KeyboardGestureAreaViewManagerImpl {
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "KeyboardGestureArea";

    public final KeyboardGestureAreaReactViewGroup createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new KeyboardGestureAreaReactViewGroup(reactContext);
    }

    public final void setOffset(@NotNull KeyboardGestureAreaReactViewGroup view, double d) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOffset(d);
    }

    public final void setInterpolator(@NotNull KeyboardGestureAreaReactViewGroup view, @NotNull String interpolator) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        view.setInterpolator(interpolator);
    }

    public final void setScrollKeyboardOffScreenWhenVisible(@NotNull KeyboardGestureAreaReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollKeyboardOffScreenWhenVisible(z);
    }

    public final void setScrollKeyboardOnScreenWhenNotVisible(@NotNull KeyboardGestureAreaReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollKeyboardOnScreenWhenNotVisible(z);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
