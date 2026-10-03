package com.swmansion.rnscreens.gamma.tabs.event;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.rnscreens.gamma.common.NamingAwareEventType;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class TabScreenWillDisappearEvent extends Event<TabScreenWillDisappearEvent> implements NamingAwareEventType {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_NAME = "topWillDisappear";
    public static final String EVENT_REGISTRATION_NAME = "onWillDisappear";

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    public TabScreenWillDisappearEvent(int i, int i2) {
        super(i, i2);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topWillDisappear";
    }

    @Override // com.swmansion.rnscreens.gamma.common.NamingAwareEventType
    public String getEventRegistrationName() {
        return EVENT_REGISTRATION_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        return Arguments.createMap();
    }

    public static final class Companion implements NamingAwareEventType {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.swmansion.rnscreens.gamma.common.NamingAwareEventType
        public String getEventName() {
            return "topWillDisappear";
        }

        @Override // com.swmansion.rnscreens.gamma.common.NamingAwareEventType
        public String getEventRegistrationName() {
            return TabScreenWillDisappearEvent.EVENT_REGISTRATION_NAME;
        }
    }
}
