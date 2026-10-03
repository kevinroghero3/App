package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.io.Closeable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class AnimationBitmapFrame implements Closeable {
    private final CloseableReference<Bitmap> bitmap;
    private int frameNumber;

    public AnimationBitmapFrame(int i, @NotNull CloseableReference<Bitmap> bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.frameNumber = i;
        this.bitmap = bitmap;
    }

    public final CloseableReference<Bitmap> getBitmap() {
        return this.bitmap;
    }

    public final int getFrameNumber() {
        return this.frameNumber;
    }

    public final void setFrameNumber(int i) {
        this.frameNumber = i;
    }

    public final boolean isValidFor(int i) {
        return this.frameNumber == i && this.bitmap.isValid();
    }

    public final boolean isValid() {
        return this.bitmap.isValid();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.bitmap.close();
    }
}
