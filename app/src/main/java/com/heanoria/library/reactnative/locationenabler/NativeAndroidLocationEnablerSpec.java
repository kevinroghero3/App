package com.heanoria.library.reactnative.locationenabler;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class NativeAndroidLocationEnablerSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "AndroidLocationEnabler";

    @ReactMethod
    public abstract void isLocationEnabled(Promise promise);

    @ReactMethod
    public abstract void promptForEnableLocationIfNeeded(@Nullable ReadableMap readableMap, Promise promise);

    public NativeAndroidLocationEnablerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "AndroidLocationEnabler";
    }
}
