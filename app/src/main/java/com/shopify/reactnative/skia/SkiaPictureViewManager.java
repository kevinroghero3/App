package com.shopify.reactnative.skia;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import app.notifee.core.event.LogEvent;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.SkiaPictureViewManagerDelegate;
import com.facebook.react.viewmanagers.SkiaPictureViewManagerInterface;

/* JADX INFO: loaded from: classes3.dex */
public class SkiaPictureViewManager extends SkiaBaseViewManager<SkiaPictureView> implements SkiaPictureViewManagerInterface<SkiaPictureView> {
    protected SkiaPictureViewManagerDelegate mDelegate = new SkiaPictureViewManagerDelegate(this);

    @Override // com.facebook.react.viewmanagers.SkiaPictureViewManagerInterface
    public void setColorSpace(SkiaPictureView skiaPictureView, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.SkiaPictureViewManagerInterface
    @ReactProp(name = LogEvent.LEVEL_DEBUG)
    public /* bridge */ /* synthetic */ void setDebug(View view, boolean z) {
        super.setDebug((SkiaBaseView) view, z);
    }

    @Override // com.facebook.react.viewmanagers.SkiaPictureViewManagerInterface
    @ReactProp(name = "opaque")
    public /* bridge */ /* synthetic */ void setOpaque(View view, boolean z) {
        super.setOpaque((SkiaBaseView) view, z);
    }

    SkiaPictureViewManager() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public SkiaPictureViewManagerDelegate getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "SkiaPictureView";
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public SkiaPictureView createViewInstance(@NonNull ThemedReactContext themedReactContext) {
        return new SkiaPictureView(themedReactContext);
    }
}
