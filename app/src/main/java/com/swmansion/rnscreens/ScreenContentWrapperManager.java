package com.swmansion.rnscreens;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenContentWrapperManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenContentWrapperManagerInterface;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = ScreenContentWrapperManager.REACT_CLASS)
public final class ScreenContentWrapperManager extends ViewGroupManager<ScreenContentWrapper> implements RNSScreenContentWrapperManagerInterface<ScreenContentWrapper> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNSScreenContentWrapper";
    private final ViewManagerDelegate<ScreenContentWrapper> delegate = new RNSScreenContentWrapperManagerDelegate(this);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ScreenContentWrapper createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ScreenContentWrapper(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<ScreenContentWrapper> getDelegate() {
        return this.delegate;
    }
}
