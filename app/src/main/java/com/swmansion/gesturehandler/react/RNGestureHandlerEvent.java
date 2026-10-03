package com.swmansion.gesturehandler.react;

import android.view.View;
import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class RNGestureHandlerEvent extends Event<RNGestureHandlerEvent> {
    public static final Companion Companion = new Companion(null);
    private static final Pools.SynchronizedPool<RNGestureHandlerEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(7);
    public static final String EVENT_NAME = "onGestureHandlerEvent";
    public static final String NATIVE_ANIMATED_EVENT_NAME = "topGestureHandlerEvent";
    private static final int TOUCH_EVENTS_POOL_SIZE = 7;
    private short coalescingKey;
    private GestureHandlerEventDataBuilder<?> dataBuilder;
    private boolean useTopPrefixedName;

    public /* synthetic */ RNGestureHandlerEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return true;
    }

    private RNGestureHandlerEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends GestureHandler> void init(T t, GestureHandlerEventDataBuilder<T> gestureHandlerEventDataBuilder, boolean z) {
        View view = t.getView();
        Intrinsics.checkNotNull(view);
        super.init(UIManagerHelper.getSurfaceId(view), view.getId());
        this.dataBuilder = gestureHandlerEventDataBuilder;
        this.useTopPrefixedName = z;
        this.coalescingKey = t.getEventCoalescingKey();
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        this.dataBuilder = null;
        EVENTS_POOL.release(this);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        if (this.useTopPrefixedName) {
            return NATIVE_ANIMATED_EVENT_NAME;
        }
        return "onGestureHandlerEvent";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return this.coalescingKey;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        Companion companion = Companion;
        GestureHandlerEventDataBuilder<?> gestureHandlerEventDataBuilder = this.dataBuilder;
        Intrinsics.checkNotNull(gestureHandlerEventDataBuilder);
        return companion.createEventData(gestureHandlerEventDataBuilder);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ RNGestureHandlerEvent obtain$default(Companion companion, GestureHandler gestureHandler, GestureHandlerEventDataBuilder gestureHandlerEventDataBuilder, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.obtain(gestureHandler, gestureHandlerEventDataBuilder, z);
        }

        public final <T extends GestureHandler> RNGestureHandlerEvent obtain(@NotNull T handler, @NotNull GestureHandlerEventDataBuilder<T> dataBuilder, boolean z) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(dataBuilder, "dataBuilder");
            RNGestureHandlerEvent rNGestureHandlerEvent = (RNGestureHandlerEvent) RNGestureHandlerEvent.EVENTS_POOL.acquire();
            if (rNGestureHandlerEvent == null) {
                rNGestureHandlerEvent = new RNGestureHandlerEvent(null);
            }
            rNGestureHandlerEvent.init(handler, dataBuilder, z);
            return rNGestureHandlerEvent;
        }

        public final WritableMap createEventData(@NotNull GestureHandlerEventDataBuilder<?> dataBuilder) {
            Intrinsics.checkNotNullParameter(dataBuilder, "dataBuilder");
            WritableMap writableMapCreateMap = Arguments.createMap();
            Intrinsics.checkNotNull(writableMapCreateMap);
            dataBuilder.buildEventData(writableMapCreateMap);
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "apply(...)");
            return writableMapCreateMap;
        }
    }
}
