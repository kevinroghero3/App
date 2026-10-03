package com.facebook.react.uimanager.events;

import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface EventDispatcher {
    void addBatchEventDispatchedListener(@NotNull BatchEventDispatchedListener batchEventDispatchedListener);

    void addListener(@NotNull EventDispatcherListener eventDispatcherListener);

    void dispatchAllEvents();

    void dispatchEvent(@NotNull Event<?> event);

    void onCatalystInstanceDestroyed();

    @Deprecated(message = "Use the modern version with RCTModernEventEmitter")
    void registerEventEmitter(int i, @NotNull RCTEventEmitter rCTEventEmitter);

    void registerEventEmitter(int i, @NotNull RCTModernEventEmitter rCTModernEventEmitter);

    void removeBatchEventDispatchedListener(@NotNull BatchEventDispatchedListener batchEventDispatchedListener);

    void removeListener(@NotNull EventDispatcherListener eventDispatcherListener);

    void unregisterEventEmitter(int i);
}
