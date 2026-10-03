package com.facebook.imagepipeline.animated.factory;

import android.content.Context;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface AnimatedFactory {
    DrawableFactory getAnimatedDrawableFactory(@Nullable Context context);

    ImageDecoder getGifDecoder();

    ImageDecoder getWebPDecoder();
}
