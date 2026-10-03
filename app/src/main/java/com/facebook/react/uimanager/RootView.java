package com.facebook.react.uimanager;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface RootView {
    void handleException(@NotNull Throwable th);

    void onChildEndedNativeGesture(@NotNull View view, @NotNull MotionEvent motionEvent);

    void onChildStartedNativeGesture(@Nullable View view, @NotNull MotionEvent motionEvent);

    @Deprecated(message = "Use onChildStartedNativeGesture with a childView parameter.", replaceWith = @ReplaceWith(expression = "onChildStartedNativeGesture", imports = {}))
    default void onChildStartedNativeGesture(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        onChildStartedNativeGesture(null, ev);
    }
}
