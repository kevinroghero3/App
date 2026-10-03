package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder<NativeViewGestureHandler> {
    private final boolean pointerInside;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeGestureHandlerEventDataBuilder(@NotNull NativeViewGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.pointerInside = handler.isWithinBounds();
    }

    @Override // com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder
    public void buildEventData(@NotNull WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.buildEventData(eventData);
        eventData.putBoolean("pointerInside", this.pointerInside);
    }
}
