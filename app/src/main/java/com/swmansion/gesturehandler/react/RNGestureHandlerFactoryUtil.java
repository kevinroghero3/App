package com.swmansion.gesturehandler.react;

import com.swmansion.gesturehandler.core.FlingGestureHandler;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.HoverGestureHandler;
import com.swmansion.gesturehandler.core.LongPressGestureHandler;
import com.swmansion.gesturehandler.core.ManualGestureHandler;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import com.swmansion.gesturehandler.core.PanGestureHandler;
import com.swmansion.gesturehandler.core.PinchGestureHandler;
import com.swmansion.gesturehandler.core.RotationGestureHandler;
import com.swmansion.gesturehandler.core.TapGestureHandler;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class RNGestureHandlerFactoryUtil {
    public static final RNGestureHandlerFactoryUtil INSTANCE = new RNGestureHandlerFactoryUtil();
    private static final GestureHandler.Factory<?>[] handlerFactories = {new NativeViewGestureHandler.Factory(), new TapGestureHandler.Factory(), new LongPressGestureHandler.Factory(), new PanGestureHandler.Factory(), new PinchGestureHandler.Factory(), new RotationGestureHandler.Factory(), new FlingGestureHandler.Factory(), new ManualGestureHandler.Factory(), new HoverGestureHandler.Factory()};

    private RNGestureHandlerFactoryUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends GestureHandler> GestureHandler.Factory<GestureHandler> findFactoryForHandler(@NotNull GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        for (FlingGestureHandler.Factory factory : handlerFactories) {
            if (Intrinsics.areEqual(factory.getType(), handler.getClass())) {
                return factory;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends GestureHandler> GestureHandler.Factory<GestureHandler> findFactoryForName(@NotNull String handlerName) {
        Intrinsics.checkNotNullParameter(handlerName, "handlerName");
        for (FlingGestureHandler.Factory factory : handlerFactories) {
            if (Intrinsics.areEqual(factory.getName(), handlerName)) {
                return factory;
            }
        }
        return null;
    }
}
