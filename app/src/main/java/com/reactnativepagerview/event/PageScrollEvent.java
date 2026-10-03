package com.reactnativepagerview.event;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class PageScrollEvent extends Event<PageScrollEvent> {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_NAME = "topPageScroll";
    private final float mOffset;
    private final int mPosition;

    public PageScrollEvent(int i, int i2, float f) {
        super(i);
        this.mPosition = i2;
        this.mOffset = (Float.isInfinite(f) || Float.isNaN(f)) ? 0.0f : f;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(@NotNull RCTEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private final WritableMap serializeEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt(ViewProps.POSITION, this.mPosition);
        writableMapCreateMap.putDouble(TypedValues.CycleType.S_WAVE_OFFSET, this.mOffset);
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
