package com.facebook.imagepipeline.bitmaps;

import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class PlatformBitmapFactoryProvider {
    public static final PlatformBitmapFactoryProvider INSTANCE = new PlatformBitmapFactoryProvider();

    private PlatformBitmapFactoryProvider() {
    }

    @JvmStatic
    public static final PlatformBitmapFactory buildPlatformBitmapFactory(@NotNull PoolFactory poolFactory, @NotNull PlatformDecoder platformDecoder, @NotNull CloseableReferenceFactory closeableReferenceFactory) {
        Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        Intrinsics.checkNotNullParameter(platformDecoder, "platformDecoder");
        Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
        BitmapPool bitmapPool = poolFactory.getBitmapPool();
        Intrinsics.checkNotNullExpressionValue(bitmapPool, "getBitmapPool(...)");
        return new ArtBitmapFactory(bitmapPool, closeableReferenceFactory);
    }
}
