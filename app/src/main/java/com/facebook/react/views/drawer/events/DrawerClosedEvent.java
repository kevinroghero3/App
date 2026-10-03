package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class DrawerClosedEvent extends Event<DrawerClosedEvent> {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_NAME = "topDrawerClose";

    @Deprecated(message = "Use constructor with surfaceId", replaceWith = @ReplaceWith(expression = "DrawerClosedEvent(surfaceId, viewId)", imports = {}))
    public DrawerClosedEvent(int i) {
        this(-1, i);
    }

    public DrawerClosedEvent(int i, int i2) {
        super(i, i2);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        return Arguments.createMap();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
