package com.facebook.react.bridge;

import android.view.View;
import com.facebook.react.uimanager.events.EventDispatcher;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface UIManager extends PerformanceCounter {
    @Deprecated(message = "")
    <T extends View> int addRootView(T t, @Nullable WritableMap writableMap);

    void addUIManagerEventListener(@Nullable UIManagerListener uIManagerListener);

    void dispatchCommand(int i, int i2, @Nullable ReadableArray readableArray);

    void dispatchCommand(int i, @NotNull String str, @Nullable ReadableArray readableArray);

    EventDispatcher getEventDispatcher();

    void initialize();

    void invalidate();

    void markActiveTouchForTag(int i, int i2);

    void receiveEvent(int i, int i2, @NotNull String str, @Nullable WritableMap writableMap);

    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "receiveEvent(surfaceId, reactTag, eventName, event)", imports = {}))
    void receiveEvent(int i, @NotNull String str, @Nullable WritableMap writableMap);

    void removeUIManagerEventListener(@Nullable UIManagerListener uIManagerListener);

    @Deprecated(message = "")
    String resolveCustomDirectEventName(@NotNull String str);

    View resolveView(int i);

    void sendAccessibilityEvent(int i, int i2);

    <T extends View> int startSurface(T t, @NotNull String str, @Nullable WritableMap writableMap, int i, int i2);

    void stopSurface(int i);

    void sweepActiveTouchForTag(int i, int i2);

    void synchronouslyUpdateViewOnUIThread(int i, @Nullable ReadableMap readableMap);

    void updateRootLayoutSpecs(int i, int i2, int i3, int i4, int i5);
}
