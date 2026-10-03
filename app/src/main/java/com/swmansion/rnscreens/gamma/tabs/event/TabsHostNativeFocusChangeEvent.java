package com.swmansion.rnscreens.gamma.tabs.event;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.rnscreens.gamma.common.NamingAwareEventType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class TabsHostNativeFocusChangeEvent extends Event<TabScreenDidAppearEvent> implements NamingAwareEventType {
    public static final Companion Companion = new Companion(null);
    private static final String EVENT_KEY_TAB_KEY = "tabKey";
    public static final String EVENT_NAME = "topNativeFocusChange";
    public static final String EVENT_REGISTRATION_NAME = "onNativeFocusChange";
    private final String tabKey;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    public final String getTabKey() {
        return this.tabKey;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostNativeFocusChangeEvent(int i, int i2, @NotNull String tabKey) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(tabKey, "tabKey");
        this.tabKey = tabKey;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.swmansion.rnscreens.gamma.common.NamingAwareEventType
    public String getEventRegistrationName() {
        return EVENT_REGISTRATION_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(EVENT_KEY_TAB_KEY, this.tabKey);
        return writableMapCreateMap;
    }

    public static final class Companion implements NamingAwareEventType {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.swmansion.rnscreens.gamma.common.NamingAwareEventType
        public String getEventName() {
            return TabsHostNativeFocusChangeEvent.EVENT_NAME;
        }

        @Override // com.swmansion.rnscreens.gamma.common.NamingAwareEventType
        public String getEventRegistrationName() {
            return TabsHostNativeFocusChangeEvent.EVENT_REGISTRATION_NAME;
        }
    }
}
