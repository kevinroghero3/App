package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface ImageCacheStatsTracker {
    void onBitmapCacheHit(@NotNull CacheKey cacheKey);

    void onBitmapCacheMiss(@NotNull CacheKey cacheKey);

    void onBitmapCachePut(@NotNull CacheKey cacheKey);

    void onDiskCacheGetFail(@NotNull CacheKey cacheKey);

    void onDiskCacheHit(@NotNull CacheKey cacheKey);

    void onDiskCacheMiss(@NotNull CacheKey cacheKey);

    void onDiskCachePut(@NotNull CacheKey cacheKey);

    void onMemoryCacheHit(@NotNull CacheKey cacheKey);

    void onMemoryCacheMiss(@NotNull CacheKey cacheKey);

    void onMemoryCachePut(@NotNull CacheKey cacheKey);

    void onStagingAreaHit(@NotNull CacheKey cacheKey);

    void onStagingAreaMiss(@NotNull CacheKey cacheKey);

    void registerBitmapMemoryCache(@NotNull MemoryCache<?, ?> memoryCache);

    void registerEncodedMemoryCache(@NotNull MemoryCache<?, ?> memoryCache);
}
