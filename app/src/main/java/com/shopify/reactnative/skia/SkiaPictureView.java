package com.shopify.reactnative.skia;

import android.content.Context;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.ReactContext;

/* JADX INFO: loaded from: classes3.dex */
public class SkiaPictureView extends SkiaBaseView {
    private HybridData mHybridData;

    private native HybridData initHybrid(SkiaManager skiaManager);

    @Override // com.shopify.reactnative.skia.SkiaBaseView
    protected native void registerView(int i);

    protected native void setBgColor(int i);

    @Override // com.shopify.reactnative.skia.SkiaBaseView
    protected native void setDebugMode(boolean z);

    @Override // com.shopify.reactnative.skia.SkiaBaseView
    protected native void surfaceAvailable(Object obj, int i, int i2, boolean z);

    @Override // com.shopify.reactnative.skia.SkiaBaseView
    protected native void surfaceDestroyed();

    @Override // com.shopify.reactnative.skia.SkiaBaseView
    protected native void surfaceSizeChanged(Object obj, int i, int i2, boolean z);

    @Override // com.shopify.reactnative.skia.SkiaBaseView
    protected native void unregisterView();

    public SkiaPictureView(Context context) {
        super(context);
        this.mHybridData = initHybrid(((RNSkiaModule) ((ReactContext) context).getNativeModule(RNSkiaModule.class)).getSkiaManager());
    }

    protected void finalize() throws Throwable {
        super.finalize();
        this.mHybridData.resetNative();
    }
}
