package com.facebook.react.internal.interop;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class InteropEvent extends Event<InteropEvent> {
    private final WritableMap eventData;
    private final String eventName;

    public final String eventName() {
        return this.eventName;
    }

    public final WritableMap eventData() {
        return this.eventData;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteropEvent(@NotNull String eventName, @Nullable WritableMap writableMap, int i, int i2) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventName = eventName;
        this.eventData = writableMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return this.eventName;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        return this.eventData;
    }
}
