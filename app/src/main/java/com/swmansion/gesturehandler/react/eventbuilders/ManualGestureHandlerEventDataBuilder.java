package com.swmansion.gesturehandler.react.eventbuilders;

import com.swmansion.gesturehandler.core.ManualGestureHandler;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ManualGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder<ManualGestureHandler> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManualGestureHandlerEventDataBuilder(@NotNull ManualGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
    }
}
