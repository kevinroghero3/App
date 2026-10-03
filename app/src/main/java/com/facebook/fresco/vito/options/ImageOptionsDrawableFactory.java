package com.facebook.fresco.vito.options;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.image.CloseableImage;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface ImageOptionsDrawableFactory {
    Drawable createDrawable(@NotNull Resources resources, @NotNull CloseableImage closeableImage, @NotNull ImageOptions imageOptions);
}
