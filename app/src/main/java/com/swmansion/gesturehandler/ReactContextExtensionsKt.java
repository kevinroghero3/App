package com.swmansion.gesturehandler;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactContextExtensionsKt {
    public static final void dispatchEvent(@NotNull ReactContext reactContext, @NotNull Event<?> event) throws Exception {
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            NativeModule nativeModule = reactContext.getNativeModule((Class<NativeModule>) UIManagerModule.class);
            Intrinsics.checkNotNull(nativeModule);
            ((UIManagerModule) nativeModule).getEventDispatcher().dispatchEvent(event);
        } catch (NullPointerException e) {
            throw new Exception("Couldn't get an instance of UIManagerModule. Gesture Handler is unable to send an event.", e);
        }
    }
}
