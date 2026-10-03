package com.swmansion.rnscreens.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class HeaderHeightChangeEvent extends Event<HeaderHeightChangeEvent> {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_NAME = "topHeaderHeightChange";
    private final int headerHeight;

    public HeaderHeightChangeEvent(int i, int i2, int i3) {
        super(i, i2);
        this.headerHeight = i3;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) this.headerHeight;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("headerHeight", this.headerHeight);
        return writableMapCreateMap;
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
