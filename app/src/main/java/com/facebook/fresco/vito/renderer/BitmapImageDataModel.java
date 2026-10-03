package com.facebook.fresco.vito.renderer;

import android.graphics.Bitmap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class BitmapImageDataModel extends ImageDataModel {
    private final Bitmap bitmap;
    private final int defaultPaintFlags;
    private final int height;
    private final boolean isBitmapCircular;
    private final int width;

    public /* synthetic */ BitmapImageDataModel(Bitmap bitmap, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bitmap, (i & 2) != 0 ? false : z);
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final boolean isBitmapCircular() {
        return this.isBitmapCircular;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BitmapImageDataModel(@NotNull Bitmap bitmap, boolean z) {
        super(null);
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.bitmap = bitmap;
        this.isBitmapCircular = z;
        this.width = bitmap.getWidth();
        this.height = bitmap.getHeight();
        this.defaultPaintFlags = 6;
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
    public int getDefaultPaintFlags() {
        return this.defaultPaintFlags;
    }
}
