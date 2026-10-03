package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface ImageDecoder {
    CloseableImage decode(@NotNull EncodedImage encodedImage, int i, @NotNull QualityInfo qualityInfo, @NotNull ImageDecodeOptions imageDecodeOptions);
}
