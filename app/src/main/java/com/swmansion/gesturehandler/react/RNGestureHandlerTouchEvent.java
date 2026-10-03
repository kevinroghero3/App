package com.swmansion.gesturehandler.react;

import android.view.View;
import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.gesturehandler.core.GestureHandler;
import io.sentry.rrweb.RRWebInteractionEvent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class RNGestureHandlerTouchEvent extends Event<RNGestureHandlerTouchEvent> {
    public static final Companion Companion = new Companion(null);
    private static final Pools.SynchronizedPool<RNGestureHandlerTouchEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(7);
    public static final String EVENT_NAME = "onGestureHandlerEvent";
    public static final int EVENT_TOUCH_CANCELLED = 4;
    public static final int EVENT_TOUCH_DOWN = 1;
    public static final int EVENT_TOUCH_MOVE = 2;
    public static final int EVENT_TOUCH_UP = 3;
    public static final int EVENT_UNDETERMINED = 0;
    private static final int TOUCH_EVENTS_POOL_SIZE = 7;
    private short coalescingKey;
    private WritableMap extraData;

    public /* synthetic */ RNGestureHandlerTouchEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return true;
    }

    private RNGestureHandlerTouchEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends GestureHandler> void init(T t) {
        View view = t.getView();
        Intrinsics.checkNotNull(view);
        super.init(UIManagerHelper.getSurfaceId(view), view.getId());
        this.extraData = Companion.createEventData(t);
        this.coalescingKey = t.getEventCoalescingKey();
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        this.extraData = null;
        EVENTS_POOL.release(this);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onGestureHandlerEvent";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return this.coalescingKey;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        return this.extraData;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T extends GestureHandler> RNGestureHandlerTouchEvent obtain(@NotNull T handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            RNGestureHandlerTouchEvent rNGestureHandlerTouchEvent = (RNGestureHandlerTouchEvent) RNGestureHandlerTouchEvent.EVENTS_POOL.acquire();
            if (rNGestureHandlerTouchEvent == null) {
                rNGestureHandlerTouchEvent = new RNGestureHandlerTouchEvent(null);
            }
            rNGestureHandlerTouchEvent.init(handler);
            return rNGestureHandlerTouchEvent;
        }

        public final <T extends GestureHandler> WritableMap createEventData(@NotNull T handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putInt("handlerTag", handler.getTag());
            writableMapCreateMap.putInt("state", handler.getState());
            writableMapCreateMap.putInt("numberOfTouches", handler.getTrackedPointersCount());
            writableMapCreateMap.putInt("eventType", handler.getTouchEventType());
            writableMapCreateMap.putInt(RRWebInteractionEvent.JsonKeys.POINTER_TYPE, handler.getPointerType());
            WritableArray writableArrayConsumeChangedTouchesPayload = handler.consumeChangedTouchesPayload();
            if (writableArrayConsumeChangedTouchesPayload != null) {
                writableMapCreateMap.putArray("changedTouches", writableArrayConsumeChangedTouchesPayload);
            }
            WritableArray writableArrayConsumeAllTouchesPayload = handler.consumeAllTouchesPayload();
            if (writableArrayConsumeAllTouchesPayload != null) {
                writableMapCreateMap.putArray("allTouches", writableArrayConsumeAllTouchesPayload);
            }
            if (handler.isAwaiting() && handler.getState() == 4) {
                writableMapCreateMap.putInt("state", 2);
            }
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "apply(...)");
            return writableMapCreateMap;
        }
    }
}
