package com.facebook.react.views.textinput;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* JADX INFO: loaded from: classes2.dex */
class ReactTextInputFocusEvent extends Event<ReactTextInputFocusEvent> {
    private static final String EVENT_NAME = "topFocus";

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    @Deprecated
    public ReactTextInputFocusEvent(int i) {
        this(-1, i);
    }

    public ReactTextInputFocusEvent(int i, int i2) {
        super(i, i2);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topFocus";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt(TypedValues.AttributesType.S_TARGET, getViewTag());
        return writableMapCreateMap;
    }
}
