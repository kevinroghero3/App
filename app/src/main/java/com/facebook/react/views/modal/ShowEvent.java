package com.facebook.react.views.modal;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class ShowEvent extends Event<ShowEvent> {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_NAME = "topShow";

    public ShowEvent(int i, int i2) {
        super(i, i2);
    }

    @Deprecated(message = "Do not use this constructor, use the one with explicit surfaceId", replaceWith = @ReplaceWith(expression = "ShowEvent(surfaceId, viewTag)", imports = {}))
    public ShowEvent(int i) {
        this(-1, i);
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
