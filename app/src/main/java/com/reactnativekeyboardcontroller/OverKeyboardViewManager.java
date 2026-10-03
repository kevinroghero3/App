package com.reactnativekeyboardcontroller;

import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.reactnativekeyboardcontroller.managers.OverKeyboardViewManagerImpl;
import com.reactnativekeyboardcontroller.views.overlay.OverKeyboardHostShadowNode;
import com.reactnativekeyboardcontroller.views.overlay.OverKeyboardHostView;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class OverKeyboardViewManager extends ViewGroupManager<OverKeyboardHostView> {
    private final OverKeyboardViewManagerImpl manager = new OverKeyboardViewManagerImpl();

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return OverKeyboardViewManagerImpl.NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public OverKeyboardHostView createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return this.manager.createViewInstance(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new OverKeyboardHostShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return OverKeyboardHostShadowNode.class;
    }

    @ReactProp(name = ViewProps.VISIBLE)
    public final void setVisible(@NotNull OverKeyboardHostView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setVisible(view, z);
    }
}
