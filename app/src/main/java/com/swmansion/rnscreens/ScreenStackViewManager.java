package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenStackManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenStackManagerInterface;
import com.swmansion.rnscreens.events.StackFinishTransitioningEvent;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = ScreenStackViewManager.REACT_CLASS)
public final class ScreenStackViewManager extends ViewGroupManager<ScreenStack> implements RNSScreenStackManagerInterface<ScreenStack> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNSScreenStack";
    private final ViewManagerDelegate<ScreenStack> delegate = new RNSScreenStackManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ScreenStack createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ScreenStack(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(@NotNull ScreenStack parent, @NotNull View child, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (!(child instanceof Screen)) {
            throw new IllegalArgumentException("Attempt attach child that is not of type Screen");
        }
        Screen screen = (Screen) child;
        NativeProxy.Companion.addScreenToMap(screen.getId(), screen);
        parent.addScreen(screen, i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(@NotNull ScreenStack parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Screen screenAt = parent.getScreenAt(i);
        prepareOutTransition(screenAt);
        parent.removeScreenAt(i);
        NativeProxy.Companion.removeScreenFromMap(screenAt.getId());
    }

    private final void prepareOutTransition(Screen screen) {
        if (screen != null) {
            screen.startRemovalTransition();
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        NativeProxy.Companion.clearMapOnInvalidate();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(@NotNull ScreenStack parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getScreenCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(@NotNull ScreenStack parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getScreenAt(i);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance(@NotNull ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ScreensShadowNode(context);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<ScreenStack> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to(StackFinishTransitioningEvent.EVENT_NAME, MapsKt__MapsKt.mutableMapOf(TuplesKt.to("registrationName", "onFinishTransitioning"))));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
