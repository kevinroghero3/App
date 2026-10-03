package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface DiskCachesStore {
    ImmutableMap<String, BufferedDiskCache> getDynamicBufferedDiskCaches();

    Map<String, FileCache> getDynamicFileCaches();

    BufferedDiskCache getMainBufferedDiskCache();

    FileCache getMainFileCache();

    BufferedDiskCache getSmallImageBufferedDiskCache();

    FileCache getSmallImageFileCache();
}
