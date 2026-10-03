package com.facebook.imagepipeline.drawable;

import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.image.CloseableImage;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface DrawableFactory {
    Drawable createDrawable(@NotNull CloseableImage closeableImage);

    boolean supportsImageType(@NotNull CloseableImage closeableImage);
}
