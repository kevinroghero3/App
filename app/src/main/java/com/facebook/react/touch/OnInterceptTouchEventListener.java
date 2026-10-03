package com.facebook.react.touch;

import android.view.MotionEvent;
import android.view.ViewGroup;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface OnInterceptTouchEventListener {
    boolean onInterceptTouchEvent(@NotNull ViewGroup viewGroup, @NotNull MotionEvent motionEvent);
}
