package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.WritableMap;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface RCTModernEventEmitter extends RCTEventEmitter {
    void receiveEvent(int i, int i2, @NotNull String str, @Nullable WritableMap writableMap);

    void receiveEvent(int i, int i2, @NotNull String str, boolean z, int i3, @Nullable WritableMap writableMap, int i4);

    @Deprecated(message = "Dispatch the TouchEvent using [EventDispatcher] instead")
    void receiveTouches(@NotNull TouchEvent touchEvent);
}
