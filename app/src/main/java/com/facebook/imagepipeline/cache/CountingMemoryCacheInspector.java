package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class CountingMemoryCacheInspector<K, V> {
    private final CountingMemoryCache<K, V> countingBitmapCache;

    public CountingMemoryCacheInspector(@NotNull CountingMemoryCache<K, V> countingBitmapCache) {
        Intrinsics.checkNotNullParameter(countingBitmapCache, "countingBitmapCache");
        this.countingBitmapCache = countingBitmapCache;
    }

    public static final class DumpInfoEntry<K, V> {
        public final K key;
        public final CloseableReference<V> value;

        public DumpInfoEntry(K k, @Nullable CloseableReference<V> closeableReference) {
            if (k != null) {
                this.key = k;
                this.value = CloseableReference.cloneOrNull(closeableReference);
                return;
            }
            throw new IllegalStateException("Required value was null.");
        }

        public final void release() {
            CloseableReference.closeSafely((CloseableReference<?>) this.value);
        }
    }

    public static final class DumpInfo<K, V> {
        public final List<DumpInfoEntry<K, V>> lruEntries;
        public final int lruSize;
        public final int maxEntriesCount;
        public final int maxEntrySize;
        public final int maxSize;
        public final Map<Bitmap, Object> otherEntries;
        public final List<DumpInfoEntry<K, V>> sharedEntries;
        public final int size;

        public DumpInfo(int i, int i2, @NotNull MemoryCacheParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            this.maxSize = params.maxCacheSize;
            this.maxEntriesCount = params.maxCacheEntries;
            this.maxEntrySize = params.maxCacheEntrySize;
            this.size = i;
            this.lruSize = i2;
            this.lruEntries = new ArrayList();
            this.sharedEntries = new ArrayList();
            this.otherEntries = new HashMap();
        }

        public final void release() {
            Iterator<DumpInfoEntry<K, V>> it2 = this.lruEntries.iterator();
            while (it2.hasNext()) {
                it2.next().release();
            }
            Iterator<DumpInfoEntry<K, V>> it3 = this.sharedEntries.iterator();
            while (it3.hasNext()) {
                it3.next().release();
            }
        }
    }

    public final DumpInfo<K, V> dumpCacheContent() {
        synchronized (this.countingBitmapCache) {
            int sizeInBytes = this.countingBitmapCache.getSizeInBytes();
            int evictionQueueSizeInBytes = this.countingBitmapCache.getEvictionQueueSizeInBytes();
            MemoryCacheParams memoryCacheParams = this.countingBitmapCache.getMemoryCacheParams();
            Intrinsics.checkNotNullExpressionValue(memoryCacheParams, "getMemoryCacheParams(...)");
            DumpInfo<K, V> dumpInfo = new DumpInfo<>(sizeInBytes, evictionQueueSizeInBytes, memoryCacheParams);
            CountingLruMap<K, CountingMemoryCache.Entry<K, V>> cachedEntries = this.countingBitmapCache.getCachedEntries();
            if (cachedEntries == null) {
                return dumpInfo;
            }
            ArrayList<Map.Entry<K, CountingMemoryCache.Entry<K, V>>> matchingEntries = cachedEntries.getMatchingEntries(null);
            Intrinsics.checkNotNullExpressionValue(matchingEntries, "getMatchingEntries(...)");
            Iterator<Map.Entry<K, CountingMemoryCache.Entry<K, V>>> it2 = matchingEntries.iterator();
            while (it2.hasNext()) {
                CountingMemoryCache.Entry<K, V> value = it2.next().getValue();
                DumpInfoEntry<K, V> dumpInfoEntry = new DumpInfoEntry<>(value.key, value.valueRef);
                if (value.clientCount > 0) {
                    dumpInfo.sharedEntries.add(dumpInfoEntry);
                } else {
                    dumpInfo.lruEntries.add(dumpInfoEntry);
                }
            }
            Map<Bitmap, Object> otherEntries = this.countingBitmapCache.getOtherEntries();
            if (otherEntries != null) {
                for (Map.Entry<Bitmap, Object> entry : otherEntries.entrySet()) {
                    if (entry != null && !entry.getKey().isRecycled()) {
                        dumpInfo.otherEntries.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            return dumpInfo;
        }
    }
}
