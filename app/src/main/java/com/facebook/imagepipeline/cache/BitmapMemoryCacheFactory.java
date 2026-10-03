package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.image.CloseableImage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface BitmapMemoryCacheFactory {
    CountingMemoryCache<CacheKey, CloseableImage> create(@NotNull Supplier<MemoryCacheParams> supplier, @NotNull MemoryTrimmableRegistry memoryTrimmableRegistry, @NotNull MemoryCache.CacheTrimStrategy cacheTrimStrategy, boolean z, boolean z2, @Nullable CountingMemoryCache.EntryStateObserver<CacheKey> entryStateObserver);
}
