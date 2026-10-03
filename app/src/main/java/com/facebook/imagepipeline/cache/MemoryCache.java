package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.HasDebugData;
import com.facebook.common.internal.Predicate;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface MemoryCache<K, V> extends MemoryTrimmable, HasDebugData {

    public interface CacheTrimStrategy {
        double getTrimRatio(@NotNull MemoryTrimType memoryTrimType);
    }

    CloseableReference<V> cache(K k, @NotNull CloseableReference<V> closeableReference);

    boolean contains(@NotNull Predicate<K> predicate);

    boolean contains(K k);

    CloseableReference<V> get(K k);

    int getCount();

    int getSizeInBytes();

    V inspect(K k);

    void probe(K k);

    int removeAll(@NotNull Predicate<K> predicate);
}
