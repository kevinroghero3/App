package com.swmansion.gesturehandler.react;

import android.view.MotionEvent;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.gesturehandler.ReactContextExtensionsKt;
import com.swmansion.gesturehandler.ReanimatedEventDispatcher;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.OnTouchEventListener;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class RNGestureHandlerEventDispatcher implements OnTouchEventListener {
    private final ReactApplicationContext reactApplicationContext;
    private final ReanimatedEventDispatcher reanimatedEventDispatcher;

    public RNGestureHandlerEventDispatcher(@NotNull ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        this.reactApplicationContext = reactApplicationContext;
        this.reanimatedEventDispatcher = new ReanimatedEventDispatcher();
    }

    @Override // com.swmansion.gesturehandler.core.OnTouchEventListener
    public <T extends GestureHandler> void onHandlerUpdate(@NotNull T handler, @NotNull MotionEvent event) throws Exception {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(event, "event");
        dispatchHandlerUpdateEvent(handler);
    }

    @Override // com.swmansion.gesturehandler.core.OnTouchEventListener
    public <T extends GestureHandler> void onStateChange(@NotNull T handler, int i, int i2) throws Exception {
        Intrinsics.checkNotNullParameter(handler, "handler");
        dispatchStateChangeEvent(handler, i, i2);
    }

    @Override // com.swmansion.gesturehandler.core.OnTouchEventListener
    public <T extends GestureHandler> void onTouchEvent(@NotNull T handler) throws Exception {
        Intrinsics.checkNotNullParameter(handler, "handler");
        dispatchTouchEvent(handler);
    }

    private final <T extends GestureHandler> void dispatchHandlerUpdateEvent(T t) throws Exception {
        GestureHandler.Factory<GestureHandler> factoryFindFactoryForHandler;
        if (t.getTag() < 0 || t.getState() != 4 || (factoryFindFactoryForHandler = RNGestureHandlerFactoryUtil.INSTANCE.findFactoryForHandler(t)) == null) {
            return;
        }
        int actionType = t.getActionType();
        if (actionType == 1) {
            sendEventForReanimated(RNGestureHandlerEvent.Companion.obtain$default(RNGestureHandlerEvent.Companion, t, factoryFindFactoryForHandler.createEventBuilder(t), false, 4, null));
            return;
        }
        if (actionType == 2) {
            sendEventForNativeAnimatedEvent(RNGestureHandlerEvent.Companion.obtain(t, factoryFindFactoryForHandler.createEventBuilder(t), true));
        } else if (actionType == 3) {
            sendEventForDirectEvent(RNGestureHandlerEvent.Companion.obtain$default(RNGestureHandlerEvent.Companion, t, factoryFindFactoryForHandler.createEventBuilder(t), false, 4, null));
        } else {
            if (actionType != 4) {
                return;
            }
            sendEventForDeviceEvent("onGestureHandlerEvent", RNGestureHandlerEvent.Companion.createEventData(factoryFindFactoryForHandler.createEventBuilder(t)));
        }
    }

    private final <T extends GestureHandler> void dispatchStateChangeEvent(T t, int i, int i2) throws Exception {
        GestureHandler.Factory<GestureHandler> factoryFindFactoryForHandler;
        if (t.getTag() >= 0 && (factoryFindFactoryForHandler = RNGestureHandlerFactoryUtil.INSTANCE.findFactoryForHandler(t)) != null) {
            int actionType = t.getActionType();
            if (actionType == 1) {
                sendEventForReanimated(RNGestureHandlerStateChangeEvent.Companion.obtain(t, i, i2, factoryFindFactoryForHandler.createEventBuilder(t)));
                return;
            }
            if (actionType == 2 || actionType == 3) {
                sendEventForDirectEvent(RNGestureHandlerStateChangeEvent.Companion.obtain(t, i, i2, factoryFindFactoryForHandler.createEventBuilder(t)));
            } else {
                if (actionType != 4) {
                    return;
                }
                sendEventForDeviceEvent(RNGestureHandlerStateChangeEvent.EVENT_NAME, RNGestureHandlerStateChangeEvent.Companion.createEventData(factoryFindFactoryForHandler.createEventBuilder(t), i, i2));
            }
        }
    }

    private final <T extends GestureHandler> void dispatchTouchEvent(T t) throws Exception {
        if (t.getTag() < 0) {
            return;
        }
        if (t.getState() == 2 || t.getState() == 4 || t.getState() == 0 || t.getView() != null) {
            int actionType = t.getActionType();
            if (actionType == 1) {
                sendEventForReanimated(RNGestureHandlerTouchEvent.Companion.obtain(t));
            } else {
                if (actionType != 4) {
                    return;
                }
                sendEventForDeviceEvent("onGestureHandlerEvent", RNGestureHandlerTouchEvent.Companion.createEventData(t));
            }
        }
    }

    private final <T extends Event<T>> void sendEventForReanimated(T t) throws Exception {
        sendEventForDirectEvent(t);
    }

    private final void sendEventForNativeAnimatedEvent(RNGestureHandlerEvent rNGestureHandlerEvent) throws Exception {
        ReactContextExtensionsKt.dispatchEvent(this.reactApplicationContext, rNGestureHandlerEvent);
    }

    private final <T extends Event<T>> void sendEventForDirectEvent(T t) throws Exception {
        ReactContextExtensionsKt.dispatchEvent(this.reactApplicationContext, t);
    }

    private final void sendEventForDeviceEvent(String str, WritableMap writableMap) {
        ExtensionsKt.getDeviceEventEmitter(this.reactApplicationContext).emit(str, writableMap);
    }
}
