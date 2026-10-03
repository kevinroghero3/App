package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface OnTouchEventListener {
    <T extends GestureHandler> void onHandlerUpdate(@NotNull T t, @NotNull MotionEvent motionEvent);

    <T extends GestureHandler> void onStateChange(@NotNull T t, int i, int i2);

    <T extends GestureHandler> void onTouchEvent(@NotNull T t);
}
