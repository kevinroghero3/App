package com.facebook.reactnative.androidsdk;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* JADX INFO: loaded from: classes2.dex */
public class RCTLoginButtonEvent extends Event<RCTLoginButtonEvent> {
    public static final String EVENT_NAME = "topChange";
    private final WritableMap mEvent;

    public RCTLoginButtonEvent(int i, int i2, WritableMap writableMap) {
        super(i, i2);
        this.mEvent = writableMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        return this.mEvent;
    }
}
