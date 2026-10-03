package com.reactnativekeyboardcontroller.events;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class FocusedInputSelectionChangedEvent extends Event<FocusedInputSelectionChangedEvent> {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_NAME = "topFocusedInputSelectionChanged";
    private final FocusedInputSelectionChangedEventData event;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusedInputSelectionChangedEvent(int i, int i2, @NotNull FocusedInputSelectionChangedEventData event) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(event, "event");
        this.event = event;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt(TypedValues.AttributesType.S_TARGET, this.event.getTarget());
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        WritableMap writableMapCreateMap3 = Arguments.createMap();
        writableMapCreateMap3.putDouble("x", this.event.getStartX());
        writableMapCreateMap3.putDouble("y", this.event.getStartY());
        writableMapCreateMap3.putInt(ViewProps.POSITION, this.event.getStart());
        Unit unit = Unit.INSTANCE;
        writableMapCreateMap2.putMap("start", writableMapCreateMap3);
        WritableMap writableMapCreateMap4 = Arguments.createMap();
        writableMapCreateMap4.putDouble("x", this.event.getEndX());
        writableMapCreateMap4.putDouble("y", this.event.getEndY());
        writableMapCreateMap4.putInt(ViewProps.POSITION, this.event.getEnd());
        writableMapCreateMap2.putMap(ViewProps.END, writableMapCreateMap4);
        writableMapCreateMap.putMap("selection", writableMapCreateMap2);
        return writableMapCreateMap;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
