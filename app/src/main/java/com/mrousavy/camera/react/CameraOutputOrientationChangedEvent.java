package com.mrousavy.camera.react;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraOutputOrientationChangedEvent extends Event<CameraOutputOrientationChangedEvent> {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_NAME = "topCameraOutputOrientationChanged";
    private final WritableMap data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraOutputOrientationChangedEvent(int i, int i2, @NotNull WritableMap data) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        return this.data;
    }
}
