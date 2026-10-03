package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class DiskCacheDecision {
    public static final DiskCacheDecision INSTANCE = new DiskCacheDecision();

    private DiskCacheDecision() {
    }

    @JvmStatic
    public static final BufferedDiskCache chooseDiskCacheForRequest(@NotNull ImageRequest imageRequest, @Nullable BufferedDiskCache bufferedDiskCache, @Nullable BufferedDiskCache bufferedDiskCache2, @Nullable Map<String, BufferedDiskCache> map) {
        String diskCacheId;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL) {
            return bufferedDiskCache;
        }
        if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.DEFAULT) {
            return bufferedDiskCache2;
        }
        if (imageRequest.getCacheChoice() != ImageRequest.CacheChoice.DYNAMIC || map == null || (diskCacheId = imageRequest.getDiskCacheId()) == null) {
            return null;
        }
        return map.get(diskCacheId);
    }

    public static final class DiskCacheDecisionNoDiskCacheChosenException extends Exception {
        public DiskCacheDecisionNoDiskCacheChosenException(@Nullable String str) {
            super(str);
        }
    }
}
