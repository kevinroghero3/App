package com.zoontek.rnbootsplash;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = RNBootSplashModuleImpl.NAME)
public final class RNBootSplashModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNBootSplashModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        reactContext.addLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return RNBootSplashModuleImpl.NAME;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        RNBootSplashModuleImpl.INSTANCE.onHostDestroy$react_native_bootsplash_release();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        RNBootSplashModuleImpl rNBootSplashModuleImpl = RNBootSplashModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNBootSplashModuleImpl.getConstants(reactApplicationContext);
    }

    @ReactMethod
    public final void hide(boolean z, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNBootSplashModuleImpl rNBootSplashModuleImpl = RNBootSplashModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNBootSplashModuleImpl.hide(reactApplicationContext, z, promise);
    }

    @ReactMethod
    public final void isVisible(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNBootSplashModuleImpl.INSTANCE.isVisible(promise);
    }
}
