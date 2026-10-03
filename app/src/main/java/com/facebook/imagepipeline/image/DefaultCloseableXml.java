package com.facebook.imagepipeline.image;

import android.graphics.drawable.Drawable;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultCloseableXml extends DefaultCloseableImage implements CloseableXml {
    private boolean closed;
    private Drawable drawable;

    public DefaultCloseableXml(@Nullable Drawable drawable) {
        this.drawable = drawable;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public int getSizeInBytes() {
        return getWidth() * getHeight() * 4;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.drawable = null;
        this.closed = true;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public boolean isClosed() {
        return this.closed;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        Drawable drawable = this.drawable;
        if (drawable != null) {
            Integer numValueOf = Integer.valueOf(drawable.getIntrinsicWidth());
            if (numValueOf.intValue() < 0) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                return numValueOf.intValue();
            }
        }
        return 0;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        Drawable drawable = this.drawable;
        if (drawable != null) {
            Integer numValueOf = Integer.valueOf(drawable.getIntrinsicHeight());
            if (numValueOf.intValue() < 0) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                return numValueOf.intValue();
            }
        }
        return 0;
    }

    @Override // com.facebook.imagepipeline.image.CloseableXml
    public Drawable buildDrawable() {
        Drawable.ConstantState constantState;
        Drawable drawable = this.drawable;
        if (drawable == null || (constantState = drawable.getConstantState()) == null) {
            return null;
        }
        return constantState.newDrawable();
    }
}
