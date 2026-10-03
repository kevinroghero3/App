package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface PlatformDecoder {
    CloseableReference<Bitmap> decodeFromEncodedImage(@NotNull EncodedImage encodedImage, @NotNull Bitmap.Config config, @Nullable Rect rect);

    CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(@NotNull EncodedImage encodedImage, @NotNull Bitmap.Config config, @Nullable Rect rect, @Nullable ColorSpace colorSpace);

    CloseableReference<Bitmap> decodeJPEGFromEncodedImage(@NotNull EncodedImage encodedImage, @NotNull Bitmap.Config config, @Nullable Rect rect, int i);

    CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(@NotNull EncodedImage encodedImage, @NotNull Bitmap.Config config, @Nullable Rect rect, int i, @Nullable ColorSpace colorSpace);
}
