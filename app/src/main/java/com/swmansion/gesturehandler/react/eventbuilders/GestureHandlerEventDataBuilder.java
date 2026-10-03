package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.swmansion.gesturehandler.core.GestureHandler;
import io.sentry.rrweb.RRWebInteractionEvent;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GestureHandlerEventDataBuilder<T extends GestureHandler> {
    private final int handlerTag;
    private final int numberOfPointers;
    private final int pointerType;
    private final int state;

    public GestureHandlerEventDataBuilder(@NotNull T handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.numberOfPointers = handler.getNumberOfPointers();
        this.handlerTag = handler.getTag();
        this.state = handler.getState();
        this.pointerType = handler.getPointerType();
    }

    public void buildEventData(@NotNull WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        eventData.putInt("numberOfPointers", this.numberOfPointers);
        eventData.putInt("handlerTag", this.handlerTag);
        eventData.putInt("state", this.state);
        eventData.putInt(RRWebInteractionEvent.JsonKeys.POINTER_TYPE, this.pointerType);
    }
}
