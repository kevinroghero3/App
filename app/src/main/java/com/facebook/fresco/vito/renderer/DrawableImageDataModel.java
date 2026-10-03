package com.facebook.fresco.vito.renderer;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class DrawableImageDataModel extends ImageDataModel {
    private final Drawable drawable;
    private final int height;
    private final int width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawableImageDataModel(@NotNull Drawable drawable) {
        super(null);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.drawable = drawable;
        boolean z = drawable instanceof NinePatchDrawable;
        this.width = z ? -1 : drawable.getIntrinsicWidth();
        this.height = z ? -1 : drawable.getIntrinsicHeight();
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    @Override // com.facebook.fresco.vito.renderer.ImageDataModel
    public int getWidth() {
        return this.width;
    }

    @Override // com.facebook.fresco.vito.renderer.ImageDataModel
    public int getHeight() {
        return this.height;
    }

    @Override // com.facebook.fresco.vito.renderer.ImageDataModel
    public void setCallback(@Nullable Drawable.Callback callback) {
        this.drawable.setCallback(callback);
    }
}
