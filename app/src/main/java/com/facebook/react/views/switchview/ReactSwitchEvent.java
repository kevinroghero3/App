package com.facebook.react.views.switchview;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class ReactSwitchEvent extends Event<ReactSwitchEvent> {
    private static final Companion Companion = new Companion(null);
    private static final String EVENT_NAME = "topChange";
    private final boolean isChecked;

    public ReactSwitchEvent(int i, int i2, boolean z) {
        super(i, i2);
        this.isChecked = z;
    }

    @Deprecated(message = "Use the constructor with surfaceId, viewId and isChecked parameters.", replaceWith = @ReplaceWith(expression = "ReactSwitchEvent(surfaceId, viewId, isChecked)", imports = {}))
    public ReactSwitchEvent(int i, boolean z) {
        this(-1, i, z);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt(TypedValues.AttributesType.S_TARGET, getViewTag());
        writableMapCreateMap.putBoolean("value", this.isChecked);
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
