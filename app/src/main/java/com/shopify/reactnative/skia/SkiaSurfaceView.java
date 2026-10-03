package com.shopify.reactnative.skia;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class SkiaSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    SkiaViewAPI mApi;
    boolean mDebug;

    public SkiaSurfaceView(Context context, SkiaViewAPI skiaViewAPI, boolean z) {
        super(context);
        this.mApi = skiaViewAPI;
        this.mDebug = z;
        getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mApi.onSurfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        this.mApi.onSurfaceCreated(surfaceHolder.getSurface(), getWidth(), getHeight());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.mApi.onSurfaceChanged(surfaceHolder.getSurface(), getWidth(), getHeight());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        this.mApi.onSurfaceDestroyed();
    }
}
