package com.swmansion.rnscreens;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenFooterManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenFooterManagerInterface;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = ScreenFooterManager.REACT_CLASS)
public final class ScreenFooterManager extends ViewGroupManager<ScreenFooter> implements RNSScreenFooterManagerInterface<ScreenFooter> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNSScreenFooter";
    private final ViewManagerDelegate<ScreenFooter> delegate = new RNSScreenFooterManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ScreenFooter createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ScreenFooter(context);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<ScreenFooter> getDelegate() {
        return this.delegate;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
