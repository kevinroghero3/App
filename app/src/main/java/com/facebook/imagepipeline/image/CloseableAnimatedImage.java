package com.facebook.imagepipeline.image;

import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class CloseableAnimatedImage extends DefaultCloseableImage {

    @Nullable
    private AnimatedImageResult mImageResult;
    private boolean mIsStateful;

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult) {
        this(animatedImageResult, true);
    }

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult, boolean z) {
        this.mImageResult = animatedImageResult;
        this.mIsStateful = z;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        int width;
        synchronized (this) {
            AnimatedImageResult animatedImageResult = this.mImageResult;
            width = animatedImageResult == null ? 0 : animatedImageResult.getImage().getWidth();
        }
        return width;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        int height;
        synchronized (this) {
            AnimatedImageResult animatedImageResult = this.mImageResult;
            height = animatedImageResult == null ? 0 : animatedImageResult.getImage().getHeight();
        }
        return height;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            AnimatedImageResult animatedImageResult = this.mImageResult;
            if (animatedImageResult == null) {
                return;
            }
            this.mImageResult = null;
            animatedImageResult.dispose();
        }
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mImageResult == null;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public int getSizeInBytes() {
        int sizeInBytes;
        synchronized (this) {
            AnimatedImageResult animatedImageResult = this.mImageResult;
            sizeInBytes = animatedImageResult == null ? 0 : animatedImageResult.getImage().getSizeInBytes();
        }
        return sizeInBytes;
    }

    @Override // com.facebook.imagepipeline.image.BaseCloseableImage, com.facebook.imagepipeline.image.CloseableImage
    public boolean isStateful() {
        return this.mIsStateful;
    }

    @Nullable
    public AnimatedImageResult getImageResult() {
        AnimatedImageResult animatedImageResult;
        synchronized (this) {
            animatedImageResult = this.mImageResult;
        }
        return animatedImageResult;
    }

    @Nullable
    public AnimatedImage getImage() {
        AnimatedImage image;
        synchronized (this) {
            AnimatedImageResult animatedImageResult = this.mImageResult;
            image = animatedImageResult == null ? null : animatedImageResult.getImage();
        }
        return image;
    }
}
