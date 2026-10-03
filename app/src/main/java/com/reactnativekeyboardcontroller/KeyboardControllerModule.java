package com.reactnativekeyboardcontroller;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class KeyboardControllerModule extends ReactContextBaseJavaModule {
    private final KeyboardControllerModuleImpl module;

    @ReactMethod
    public final void addListener(@Nullable String str) {
    }

    @ReactMethod
    public final void removeListeners(@Nullable Integer num) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardControllerModule(@NotNull ReactApplicationContext mReactContext) {
        super(mReactContext);
        Intrinsics.checkNotNullParameter(mReactContext, "mReactContext");
        this.module = new KeyboardControllerModuleImpl(mReactContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return KeyboardControllerModuleImpl.NAME;
    }

    @ReactMethod
    public final void setInputMode(int i) {
        this.module.setInputMode(i);
    }

    @ReactMethod
    public final void setDefaultMode() {
        this.module.setDefaultMode();
    }

    @ReactMethod
    public final void preload() {
        this.module.preload();
    }

    @ReactMethod
    public final void dismiss(boolean z) {
        this.module.dismiss(z);
    }

    @ReactMethod
    public final void setFocusTo(@NotNull String direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.module.setFocusTo(direction);
    }
}
