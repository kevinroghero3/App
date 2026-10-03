package com.facebook.imagepipeline.transcoder;

import android.graphics.ColorSpace;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.OutputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface ImageTranscoder {
    boolean canResize(@NotNull EncodedImage encodedImage, @Nullable RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions);

    boolean canTranscode(@NotNull ImageFormat imageFormat);

    String getIdentifier();

    ImageTranscodeResult transcode(@NotNull EncodedImage encodedImage, @NotNull OutputStream outputStream, @Nullable RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, @Nullable ImageFormat imageFormat, @Nullable Integer num, @Nullable ColorSpace colorSpace) throws IOException;
}
