package com.facebook.imagepipeline.animated.factory;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AnimatedFactoryProvider {
    public static final AnimatedFactoryProvider INSTANCE = new AnimatedFactoryProvider();
    private static AnimatedFactory impl;
    private static boolean implLoaded;

    private AnimatedFactoryProvider() {
    }

    @JvmStatic
    public static final AnimatedFactory getAnimatedFactory(@Nullable PlatformBitmapFactory platformBitmapFactory, @Nullable ExecutorSupplier executorSupplier, @Nullable CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, boolean z, boolean z2, int i, int i2, @Nullable ExecutorService executorService) {
        if (!implLoaded) {
            try {
                Class cls = Boolean.TYPE;
                Class cls2 = Integer.TYPE;
                Object objNewInstance = AnimatedFactoryV2Impl.class.getConstructor(PlatformBitmapFactory.class, ExecutorSupplier.class, CountingMemoryCache.class, cls, cls, cls2, cls2, SerialExecutorService.class).newInstance(platformBitmapFactory, executorSupplier, countingMemoryCache, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), executorService);
                Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.facebook.imagepipeline.animated.factory.AnimatedFactory");
                impl = (AnimatedFactory) objNewInstance;
            } catch (Throwable unused) {
            }
            if (impl != null) {
                implLoaded = true;
            }
        }
        return impl;
    }
}
