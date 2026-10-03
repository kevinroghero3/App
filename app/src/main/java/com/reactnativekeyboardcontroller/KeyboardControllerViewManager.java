package com.reactnativekeyboardcontroller;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import com.reactnativekeyboardcontroller.managers.KeyboardControllerViewManagerImpl;
import com.reactnativekeyboardcontroller.views.EdgeToEdgeReactViewGroup;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class KeyboardControllerViewManager extends ReactViewManager {
    private final KeyboardControllerViewManagerImpl manager = new KeyboardControllerViewManagerImpl();

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public ReactViewGroup createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.manager.createViewInstance(context);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        this.manager.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NotNull ReactViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        this.manager.setEdgeToEdge((EdgeToEdgeReactViewGroup) view);
    }

    @ReactProp(name = ViewProps.ENABLED)
    public final void setEnabled(@NotNull EdgeToEdgeReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setEnabled(view, z);
    }

    @ReactProp(name = "statusBarTranslucent")
    public final void setStatusBarTranslucent(@NotNull EdgeToEdgeReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setStatusBarTranslucent(view, z);
    }

    @ReactProp(name = "navigationBarTranslucent")
    public final void setNavigationBarTranslucent(@NotNull EdgeToEdgeReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setNavigationBarTranslucent(view, z);
    }

    @ReactProp(name = "preserveEdgeToEdge")
    public final void setPreserveEdgeToEdge(@NotNull EdgeToEdgeReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setPreserveEdgeToEdge(view, z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return this.manager.getExportedCustomDirectEventTypeConstants();
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return KeyboardControllerViewManagerImpl.NAME;
    }
}
