package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface ImageTranscoderFactory {
    ImageTranscoder createImageTranscoder(@NotNull ImageFormat imageFormat, boolean z);
}
