package com.facebook.react.views.view;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Deprecated;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupClickEvent extends Event<ViewGroupClickEvent> {
    private static final Companion Companion = new Companion(null);
    private static final String EVENT_NAME = "topClick";

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    public ViewGroupClickEvent(int i, int i2) {
        super(i, i2);
    }

    @Deprecated(message = "Use the constructor with surfaceId and viewId parameters.")
    public ViewGroupClickEvent(int i) {
        this(-1, i);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topClick";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        return writableMapCreateMap;
    }

    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
