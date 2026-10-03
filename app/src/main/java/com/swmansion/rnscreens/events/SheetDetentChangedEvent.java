package com.swmansion.rnscreens.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class SheetDetentChangedEvent extends Event<SheetDetentChangedEvent> {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_NAME = "topSheetDetentChanged";
    private final int index;
    private final boolean isStable;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean isStable() {
        return this.isStable;
    }

    public SheetDetentChangedEvent(int i, int i2, int i3, boolean z) {
        super(i, i2);
        this.index = i3;
        this.isStable = z;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt(FirebaseAnalytics.Param.INDEX, this.index);
        writableMapCreateMap.putBoolean("isStable", this.isStable);
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
