package com.facebook.react.views.unimplementedview;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.UnimplementedNativeViewManagerDelegate;
import com.facebook.react.viewmanagers.UnimplementedNativeViewManagerInterface;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@ReactModule(name = ReactUnimplementedViewManager.REACT_CLASS)
public final class ReactUnimplementedViewManager extends ViewGroupManager<ReactUnimplementedView> implements UnimplementedNativeViewManagerInterface<ReactUnimplementedView> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "UnimplementedNativeView";
    private final ViewManagerDelegate<ReactUnimplementedView> delegate = new UnimplementedNativeViewManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<ReactUnimplementedView> getDelegate() {
        return this.delegate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactUnimplementedView createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ReactUnimplementedView(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.viewmanagers.UnimplementedNativeViewManagerInterface
    @ReactProp(name = "name")
    public void setName(@NotNull ReactUnimplementedView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str == null) {
            str = "<null component name>";
        }
        view.setName$ReactAndroid_release(str);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
