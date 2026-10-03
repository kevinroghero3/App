package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenContainerManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenContainerManagerInterface;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = ScreenContainerViewManager.REACT_CLASS)
public final class ScreenContainerViewManager extends ViewGroupManager<ScreenContainer> implements RNSScreenContainerManagerInterface<ScreenContainer> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNSScreenContainer";
    private final ViewManagerDelegate<ScreenContainer> delegate = new RNSScreenContainerManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<ScreenContainer> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ScreenContainer createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ScreenContainer(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(@NotNull ScreenContainer parent, @NotNull View child, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (!(child instanceof Screen)) {
            throw new IllegalArgumentException("Attempt attach child that is not of type RNScreens");
        }
        parent.addScreen((Screen) child, i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(@NotNull ScreenContainer parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.removeScreenAt(i);
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(@NotNull ScreenContainer parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.removeAllScreens();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(@NotNull ScreenContainer parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getScreenCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(@NotNull ScreenContainer parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getScreenAt(i);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance(@NotNull ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ScreensShadowNode(context);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
