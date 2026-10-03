package com.reactnativekeyboardcontroller.views.overlay;

import android.view.MotionEvent;
import com.facebook.react.uimanager.RootView;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface RootViewCompat extends RootView {
    @Override // com.facebook.react.uimanager.RootView
    @Deprecated(message = "This method shouldn't be used anymore.", replaceWith = @ReplaceWith(expression = "onChildStartedNativeGesture(View childView, MotionEvent ev)", imports = {}))
    void onChildStartedNativeGesture(@NotNull MotionEvent motionEvent);

    public static final class DefaultImpls {
        @Deprecated(message = "This method shouldn't be used anymore.", replaceWith = @ReplaceWith(expression = "onChildStartedNativeGesture(View childView, MotionEvent ev)", imports = {}))
        public static void onChildStartedNativeGesture(@NotNull RootViewCompat rootViewCompat, @NotNull MotionEvent ev) {
            Intrinsics.checkNotNullParameter(ev, "ev");
            rootViewCompat.onChildStartedNativeGesture(null, ev);
        }
    }
}
