package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.core.RotationGestureHandler;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class RotationGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder<RotationGestureHandler> {
    private final float anchorX;
    private final float anchorY;
    private final double rotation;
    private final double velocity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RotationGestureHandlerEventDataBuilder(@NotNull RotationGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.rotation = handler.getRotation();
        this.anchorX = handler.getAnchorX();
        this.anchorY = handler.getAnchorY();
        this.velocity = handler.getVelocity();
    }

    @Override // com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder
    public void buildEventData(@NotNull WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.buildEventData(eventData);
        eventData.putDouble("rotation", this.rotation);
        eventData.putDouble("anchorX", PixelUtil.toDIPFromPixel(this.anchorX));
        eventData.putDouble("anchorY", PixelUtil.toDIPFromPixel(this.anchorY));
        eventData.putDouble("velocity", this.velocity);
    }
}
