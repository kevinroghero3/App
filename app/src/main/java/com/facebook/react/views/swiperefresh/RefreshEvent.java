package com.facebook.react.views.swiperefresh;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes.dex */
public final class RefreshEvent extends Event<RefreshEvent> {
    @Deprecated(message = "Use constructor with surfaceId", replaceWith = @ReplaceWith(expression = "RefreshEvent(surfaceId, viewTag)", imports = {}))
    public RefreshEvent(int i) {
        this(-1, i);
    }

    public RefreshEvent(int i, int i2) {
        super(i, i2);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topRefresh";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        return Arguments.createMap();
    }
}
