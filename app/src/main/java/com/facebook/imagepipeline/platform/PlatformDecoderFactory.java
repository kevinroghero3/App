package com.facebook.imagepipeline.platform;

import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.common.memory.DecodeBufferHelper;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.memory.PoolFactory;
import java.nio.ByteBuffer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class PlatformDecoderFactory {
    public static final PlatformDecoderFactory INSTANCE = new PlatformDecoderFactory();

    @JvmStatic
    public static final PlatformDecoder buildPlatformDecoder(@NotNull PoolFactory poolFactory, boolean z, @NotNull PlatformDecoderOptions platformDecoderOptions) {
        Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
        return buildPlatformDecoder$default(poolFactory, z, false, platformDecoderOptions, 4, null);
    }

    private PlatformDecoderFactory() {
    }

    public static /* synthetic */ PlatformDecoder buildPlatformDecoder$default(PoolFactory poolFactory, boolean z, boolean z2, PlatformDecoderOptions platformDecoderOptions, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return buildPlatformDecoder(poolFactory, z, z2, platformDecoderOptions);
    }

    @JvmStatic
    public static final PlatformDecoder buildPlatformDecoder(@NotNull PoolFactory poolFactory, boolean z, boolean z2, @NotNull PlatformDecoderOptions platformDecoderOptions) {
        Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
        if (Build.VERSION.SDK_INT >= 26) {
            BitmapPool bitmapPool = poolFactory.getBitmapPool();
            Intrinsics.checkNotNullExpressionValue(bitmapPool, "getBitmapPool(...)");
            return new OreoDecoder(bitmapPool, createPool(poolFactory, z2), platformDecoderOptions);
        }
        BitmapPool bitmapPool2 = poolFactory.getBitmapPool();
        Intrinsics.checkNotNullExpressionValue(bitmapPool2, "getBitmapPool(...)");
        return new ArtDecoder(bitmapPool2, createPool(poolFactory, z2), platformDecoderOptions);
    }

    @JvmStatic
    public static final Pools.Pool<ByteBuffer> createPool(@NotNull PoolFactory poolFactory, boolean z) {
        Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        if (z) {
            DecodeBufferHelper INSTANCE2 = DecodeBufferHelper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
            return INSTANCE2;
        }
        int flexByteArrayPoolMaxNumThreads = poolFactory.getFlexByteArrayPoolMaxNumThreads();
        Pools.SynchronizedPool synchronizedPool = new Pools.SynchronizedPool(flexByteArrayPoolMaxNumThreads);
        for (int i = 0; i < flexByteArrayPoolMaxNumThreads; i++) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(DecodeBufferHelper.getRecommendedDecodeBufferSize());
            Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
            synchronizedPool.release(byteBufferAllocate);
        }
        return synchronizedPool;
    }
}
