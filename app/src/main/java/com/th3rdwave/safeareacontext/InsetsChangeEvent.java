package com.th3rdwave.safeareacontext;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class InsetsChangeEvent extends Event<InsetsChangeEvent> {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_NAME = "topInsetsChange";
    private final Rect mFrame;
    private final EdgeInsets mInsets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InsetsChangeEvent(int i, int i2, @NotNull EdgeInsets mInsets, @NotNull Rect mFrame) {
        super(i2);
        Intrinsics.checkNotNullParameter(mInsets, "mInsets");
        Intrinsics.checkNotNullParameter(mFrame, "mFrame");
        this.mInsets = mInsets;
        this.mFrame = mFrame;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(@NotNull RCTEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putMap("insets", SerializationUtilsKt.edgeInsetsToJsMap(this.mInsets));
        writableMapCreateMap.putMap(TypedValues.AttributesType.S_FRAME, SerializationUtilsKt.rectToJsMap(this.mFrame));
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), writableMapCreateMap);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
