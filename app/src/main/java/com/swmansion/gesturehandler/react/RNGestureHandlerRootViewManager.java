package com.swmansion.gesturehandler.react;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNGestureHandlerRootViewManagerDelegate;
import com.facebook.react.viewmanagers.RNGestureHandlerRootViewManagerInterface;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = RNGestureHandlerRootViewManager.REACT_CLASS)
public final class RNGestureHandlerRootViewManager extends ViewGroupManager<RNGestureHandlerRootView> implements RNGestureHandlerRootViewManagerInterface<RNGestureHandlerRootView> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNGestureHandlerRootView";
    private final ViewManagerDelegate<RNGestureHandlerRootView> mDelegate = new RNGestureHandlerRootViewManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<RNGestureHandlerRootView> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RNGestureHandlerRootView createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new RNGestureHandlerRootView(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(@NotNull RNGestureHandlerRootView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.tearDown();
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerRootViewManagerInterface
    @ReactProp(name = "unstable_forceActive")
    public void setUnstable_forceActive(@NotNull RNGestureHandlerRootView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setUnstableForceActive(z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Map<String, String>> getExportedCustomDirectEventTypeConstants() {
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("onGestureHandlerEvent", MapsKt__MapsKt.mutableMapOf(TuplesKt.to("registrationName", "onGestureHandlerEvent"))), TuplesKt.to(RNGestureHandlerStateChangeEvent.EVENT_NAME, MapsKt__MapsKt.mutableMapOf(TuplesKt.to("registrationName", RNGestureHandlerStateChangeEvent.EVENT_NAME))));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
