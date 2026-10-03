package com.reactnativekeyboardcontroller;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewManager;
import com.reactnativekeyboardcontroller.managers.KeyboardBackgroundViewManagerImpl;
import com.reactnativekeyboardcontroller.views.background.KeyboardBackgroundViewGroup;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class KeyboardBackgroundViewManager extends ReactViewManager {
    private final KeyboardBackgroundViewManagerImpl manager = new KeyboardBackgroundViewManagerImpl();

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return KeyboardBackgroundViewManagerImpl.NAME;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public KeyboardBackgroundViewGroup createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return this.manager.createViewInstance(reactContext);
    }
}
