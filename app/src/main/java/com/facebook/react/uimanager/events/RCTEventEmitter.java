package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "Use [RCTModernEventEmitter] instead")
public interface RCTEventEmitter extends JavaScriptModule {
    @Deprecated(message = "Use [RCTModernEventEmitter.receiveEvent] instead")
    void receiveEvent(int i, @NotNull String str, @Nullable WritableMap writableMap);

    @Deprecated(message = "Dispatch the TouchEvent using [EventDispatcher] instead")
    void receiveTouches(@NotNull String str, @NotNull WritableArray writableArray, @NotNull WritableArray writableArray2);
}
