package com.reactnativekeyboardcontroller;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.reactnativekeyboardcontroller.modules.statusbar.StatusBarManagerCompatModuleImpl;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class StatusBarManagerCompatModule extends ReactContextBaseJavaModule {
    private final StatusBarManagerCompatModuleImpl module;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusBarManagerCompatModule(@NotNull ReactApplicationContext mReactContext) {
        super(mReactContext);
        Intrinsics.checkNotNullParameter(mReactContext, "mReactContext");
        this.module = new StatusBarManagerCompatModuleImpl(mReactContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "StatusBarManager";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return this.module.getConstants();
    }

    @ReactMethod
    private final void setHidden(boolean z) {
        this.module.setHidden(z);
    }

    @ReactMethod
    private final void setColor(int i, boolean z) {
        this.module.setColor(i, z);
    }

    @ReactMethod
    private final void setTranslucent(boolean z) {
        this.module.setTranslucent(z);
    }

    @ReactMethod
    private final void setStyle(String str) {
        this.module.setStyle(str);
    }
}
