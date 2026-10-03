package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.facebook.cache.common.HasDebugData;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class LruCountingMemoryCache<K, V> implements CountingMemoryCache<K, V>, MemoryCache<K, V>, HasDebugData {
    private final MemoryCache.CacheTrimStrategy mCacheTrimStrategy;
    final CountingLruMap<K, CountingMemoryCache.Entry<K, V>> mCachedEntries;

    @Nullable
    private final CountingMemoryCache.EntryStateObserver<K> mEntryStateObserver;
    final CountingLruMap<K, CountingMemoryCache.Entry<K, V>> mExclusiveEntries;
    private final boolean mIgnoreSizeMismatch;
    protected MemoryCacheParams mMemoryCacheParams;
    private final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;
    private final boolean mStoreEntrySize;
    private final ValueDescriptor<V> mValueDescriptor;
    final Map<Bitmap, Object> mOtherEntries = new WeakHashMap();
    private long mLastCacheParamsCheck = SystemClock.uptimeMillis();

    public LruCountingMemoryCache(ValueDescriptor<V> valueDescriptor, MemoryCache.CacheTrimStrategy cacheTrimStrategy, Supplier<MemoryCacheParams> supplier, @Nullable CountingMemoryCache.EntryStateObserver<K> entryStateObserver, boolean z, boolean z2) {
        this.mValueDescriptor = valueDescriptor;
        this.mExclusiveEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCachedEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCacheTrimStrategy = cacheTrimStrategy;
        this.mMemoryCacheParamsSupplier = supplier;
        this.mMemoryCacheParams = (MemoryCacheParams) Preconditions.checkNotNull(supplier.get(), "mMemoryCacheParamsSupplier returned null");
        this.mEntryStateObserver = entryStateObserver;
        this.mStoreEntrySize = z;
        this.mIgnoreSizeMismatch = z2;
    }

    private ValueDescriptor<CountingMemoryCache.Entry<K, V>> wrapValueDescriptor(final ValueDescriptor<V> valueDescriptor) {
        return new ValueDescriptor<CountingMemoryCache.Entry<K, V>>() { // from class: com.facebook.imagepipeline.cache.LruCountingMemoryCache.1
            @Override // com.facebook.imagepipeline.cache.ValueDescriptor
            public int getSizeInBytes(CountingMemoryCache.Entry<K, V> entry) {
                if (LruCountingMemoryCache.this.mStoreEntrySize) {
                    return entry.size;
                }
                return valueDescriptor.getSizeInBytes(entry.valueRef.get());
            }
        };
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @Nullable
    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference) {
        return cache(k, closeableReference, this.mEntryStateObserver);
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    @Nullable
    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference, @Nullable CountingMemoryCache.EntryStateObserver<K> entryStateObserver) {
        CountingMemoryCache.Entry<K, V> entryRemove;
        CloseableReference<V> closeableReferenceNewClientReference;
        CloseableReference<V> closeableReferenceReferenceToClose;
        CountingMemoryCache.Entry<K, V> entryOf;
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(closeableReference);
        maybeUpdateCacheParams();
        synchronized (this) {
            entryRemove = this.mExclusiveEntries.remove(k);
            CountingMemoryCache.Entry<K, V> entryRemove2 = this.mCachedEntries.remove(k);
            closeableReferenceNewClientReference = null;
            if (entryRemove2 != null) {
                makeOrphan(entryRemove2);
                closeableReferenceReferenceToClose = referenceToClose(entryRemove2);
            } else {
                closeableReferenceReferenceToClose = null;
            }
            int sizeInBytes = this.mValueDescriptor.getSizeInBytes(closeableReference.get());
            if (canCacheNewValueOfSize(sizeInBytes)) {
                if (this.mStoreEntrySize) {
                    entryOf = CountingMemoryCache.Entry.of(k, closeableReference, sizeInBytes, entryStateObserver);
                } else {
                    entryOf = CountingMemoryCache.Entry.of(k, closeableReference, entryStateObserver);
                }
                this.mCachedEntries.put(k, entryOf);
                closeableReferenceNewClientReference = newClientReference(entryOf);
            }
        }
        CloseableReference.closeSafely((CloseableReference<?>) closeableReferenceReferenceToClose);
        maybeNotifyExclusiveEntryRemoval(entryRemove);
        maybeEvictEntries();
        return closeableReferenceNewClientReference;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001f  */
    private boolean canCacheNewValueOfSize(int i) {
        boolean z;
        synchronized (this) {
            if (i <= this.mMemoryCacheParams.maxCacheEntrySize) {
                z = getInUseCount() <= this.mMemoryCacheParams.maxCacheEntries - 1 && getInUseSizeInBytes() <= this.mMemoryCacheParams.maxCacheSize - i;
            }
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @Nullable
    public CloseableReference<V> get(K k) {
        CountingMemoryCache.Entry<K, V> entryRemove;
        CloseableReference<V> closeableReferenceNewClientReference;
        Preconditions.checkNotNull(k);
        synchronized (this) {
            entryRemove = this.mExclusiveEntries.remove(k);
            CountingMemoryCache.Entry<K, V> entry = this.mCachedEntries.get(k);
            closeableReferenceNewClientReference = entry != null ? newClientReference(entry) : null;
        }
        maybeNotifyExclusiveEntryRemoval(entryRemove);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return closeableReferenceNewClientReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @Nullable
    public V inspect(K k) {
        synchronized (this) {
            CountingMemoryCache.Entry<K, V> entry = this.mCachedEntries.get(k);
            if (entry == null) {
                return null;
            }
            return entry.valueRef.get();
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public void probe(K k) {
        Preconditions.checkNotNull(k);
        synchronized (this) {
            CountingMemoryCache.Entry<K, V> entryRemove = this.mExclusiveEntries.remove(k);
            if (entryRemove != null) {
                this.mExclusiveEntries.put(k, entryRemove);
            }
        }
    }

    private CloseableReference<V> newClientReference(final CountingMemoryCache.Entry<K, V> entry) {
        CloseableReference<V> closeableReferenceOf;
        synchronized (this) {
            increaseClientCount(entry);
            closeableReferenceOf = CloseableReference.of(entry.valueRef.get(), new ResourceReleaser<V>() { // from class: com.facebook.imagepipeline.cache.LruCountingMemoryCache.2
                @Override // com.facebook.common.references.ResourceReleaser
                public void release(V v) {
                    LruCountingMemoryCache.this.releaseClientReference(entry);
                }
            });
        }
        return closeableReferenceOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseClientReference(CountingMemoryCache.Entry<K, V> entry) {
        boolean zMaybeAddToExclusives;
        CloseableReference<V> closeableReferenceReferenceToClose;
        Preconditions.checkNotNull(entry);
        synchronized (this) {
            decreaseClientCount(entry);
            zMaybeAddToExclusives = maybeAddToExclusives(entry);
            closeableReferenceReferenceToClose = referenceToClose(entry);
        }
        CloseableReference.closeSafely((CloseableReference<?>) closeableReferenceReferenceToClose);
        if (!zMaybeAddToExclusives) {
            entry = null;
        }
        maybeNotifyExclusiveEntryInsertion(entry);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    private boolean maybeAddToExclusives(CountingMemoryCache.Entry<K, V> entry) {
        synchronized (this) {
            if (entry.isOrphan || entry.clientCount != 0) {
                return false;
            }
            this.mExclusiveEntries.put(entry.key, entry);
            return true;
        }
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    @Nullable
    public CloseableReference<V> reuse(K k) {
        CountingMemoryCache.Entry<K, V> entryRemove;
        boolean z;
        CloseableReference<V> closeableReference;
        Preconditions.checkNotNull(k);
        synchronized (this) {
            entryRemove = this.mExclusiveEntries.remove(k);
            z = false;
            if (entryRemove != null) {
                CountingMemoryCache.Entry<K, V> entryRemove2 = this.mCachedEntries.remove(k);
                Preconditions.checkNotNull(entryRemove2);
                Preconditions.checkState(entryRemove2.clientCount == 0);
                closeableReference = entryRemove2.valueRef;
                z = true;
            } else {
                closeableReference = null;
            }
        }
        if (z) {
            maybeNotifyExclusiveEntryRemoval(entryRemove);
        }
        return closeableReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate<K> predicate) {
        ArrayList<CountingMemoryCache.Entry<K, V>> arrayListRemoveAll;
        ArrayList<CountingMemoryCache.Entry<K, V>> arrayListRemoveAll2;
        synchronized (this) {
            arrayListRemoveAll = this.mExclusiveEntries.removeAll(predicate);
            arrayListRemoveAll2 = this.mCachedEntries.removeAll(predicate);
            makeOrphans(arrayListRemoveAll2);
        }
        maybeClose(arrayListRemoveAll2);
        maybeNotifyExclusiveEntryRemoval(arrayListRemoveAll);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return arrayListRemoveAll2.size();
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public void clear() {
        ArrayList<CountingMemoryCache.Entry<K, V>> arrayListClear;
        ArrayList<CountingMemoryCache.Entry<K, V>> arrayListClear2;
        synchronized (this) {
            arrayListClear = this.mExclusiveEntries.clear();
            arrayListClear2 = this.mCachedEntries.clear();
            makeOrphans(arrayListClear2);
        }
        maybeClose(arrayListClear2);
        maybeNotifyExclusiveEntryRemoval(arrayListClear);
        maybeUpdateCacheParams();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public boolean contains(Predicate<K> predicate) {
        boolean zIsEmpty;
        synchronized (this) {
            zIsEmpty = this.mCachedEntries.getMatchingEntries(predicate).isEmpty();
        }
        return !zIsEmpty;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public boolean contains(K k) {
        boolean zContains;
        synchronized (this) {
            zContains = this.mCachedEntries.contains(k);
        }
        return zContains;
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        ArrayList<CountingMemoryCache.Entry<K, V>> arrayListTrimExclusivelyOwnedEntries;
        double trimRatio = this.mCacheTrimStrategy.getTrimRatio(memoryTrimType);
        synchronized (this) {
            arrayListTrimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, Math.max(0, ((int) (((double) this.mCachedEntries.getSizeInBytes()) * (1.0d - trimRatio))) - getInUseSizeInBytes()));
            makeOrphans(arrayListTrimExclusivelyOwnedEntries);
        }
        maybeClose(arrayListTrimExclusivelyOwnedEntries);
        maybeNotifyExclusiveEntryRemoval(arrayListTrimExclusivelyOwnedEntries);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    private void maybeUpdateCacheParams() {
        synchronized (this) {
            if (this.mLastCacheParamsCheck + this.mMemoryCacheParams.paramsCheckIntervalMs > SystemClock.uptimeMillis()) {
                return;
            }
            this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
            this.mMemoryCacheParams = (MemoryCacheParams) Preconditions.checkNotNull(this.mMemoryCacheParamsSupplier.get(), "mMemoryCacheParamsSupplier returned null");
        }
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public MemoryCacheParams getMemoryCacheParams() {
        return this.mMemoryCacheParams;
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public CountingLruMap<K, CountingMemoryCache.Entry<K, V>> getCachedEntries() {
        return this.mCachedEntries;
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public Map<Bitmap, Object> getOtherEntries() {
        return this.mOtherEntries;
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public void maybeEvictEntries() {
        ArrayList<CountingMemoryCache.Entry<K, V>> arrayListTrimExclusivelyOwnedEntries;
        synchronized (this) {
            MemoryCacheParams memoryCacheParams = this.mMemoryCacheParams;
            int iMin = Math.min(memoryCacheParams.maxEvictionQueueEntries, memoryCacheParams.maxCacheEntries - getInUseCount());
            MemoryCacheParams memoryCacheParams2 = this.mMemoryCacheParams;
            arrayListTrimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(iMin, Math.min(memoryCacheParams2.maxEvictionQueueSize, memoryCacheParams2.maxCacheSize - getInUseSizeInBytes()));
            makeOrphans(arrayListTrimExclusivelyOwnedEntries);
        }
        maybeClose(arrayListTrimExclusivelyOwnedEntries);
        maybeNotifyExclusiveEntryRemoval(arrayListTrimExclusivelyOwnedEntries);
    }

    @Nullable
    private ArrayList<CountingMemoryCache.Entry<K, V>> trimExclusivelyOwnedEntries(int i, int i2) {
        synchronized (this) {
            int iMax = Math.max(i, 0);
            int iMax2 = Math.max(i2, 0);
            if (this.mExclusiveEntries.getCount() <= iMax && this.mExclusiveEntries.getSizeInBytes() <= iMax2) {
                return null;
            }
            ArrayList<CountingMemoryCache.Entry<K, V>> arrayList = new ArrayList<>();
            while (true) {
                if (this.mExclusiveEntries.getCount() <= iMax && this.mExclusiveEntries.getSizeInBytes() <= iMax2) {
                    break;
                }
                K firstKey = this.mExclusiveEntries.getFirstKey();
                if (firstKey == null) {
                    if (this.mIgnoreSizeMismatch) {
                        this.mExclusiveEntries.resetSize();
                        break;
                    }
                    throw new IllegalStateException(String.format("key is null, but exclusiveEntries count: %d, size: %d", Integer.valueOf(this.mExclusiveEntries.getCount()), Integer.valueOf(this.mExclusiveEntries.getSizeInBytes())));
                }
                this.mExclusiveEntries.remove(firstKey);
                arrayList.add(this.mCachedEntries.remove(firstKey));
            }
            return arrayList;
        }
    }

    private void maybeClose(@Nullable ArrayList<CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.Entry<K, V>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CloseableReference.closeSafely((CloseableReference<?>) referenceToClose(it2.next()));
            }
        }
    }

    private void maybeNotifyExclusiveEntryRemoval(@Nullable ArrayList<CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.Entry<K, V>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                maybeNotifyExclusiveEntryRemoval(it2.next());
            }
        }
    }

    private static <K, V> void maybeNotifyExclusiveEntryRemoval(@Nullable CountingMemoryCache.Entry<K, V> entry) {
        CountingMemoryCache.EntryStateObserver<K> entryStateObserver;
        if (entry == null || (entryStateObserver = entry.observer) == null) {
            return;
        }
        entryStateObserver.onExclusivityChanged(entry.key, false);
    }

    private static <K, V> void maybeNotifyExclusiveEntryInsertion(@Nullable CountingMemoryCache.Entry<K, V> entry) {
        CountingMemoryCache.EntryStateObserver<K> entryStateObserver;
        if (entry == null || (entryStateObserver = entry.observer) == null) {
            return;
        }
        entryStateObserver.onExclusivityChanged(entry.key, true);
    }

    private void makeOrphans(@Nullable ArrayList<CountingMemoryCache.Entry<K, V>> arrayList) {
        synchronized (this) {
            if (arrayList != null) {
                Iterator<CountingMemoryCache.Entry<K, V>> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    makeOrphan(it2.next());
                }
            }
        }
    }

    private void makeOrphan(CountingMemoryCache.Entry<K, V> entry) {
        synchronized (this) {
            Preconditions.checkNotNull(entry);
            Preconditions.checkState(!entry.isOrphan);
            entry.isOrphan = true;
        }
    }

    private void increaseClientCount(CountingMemoryCache.Entry<K, V> entry) {
        synchronized (this) {
            Preconditions.checkNotNull(entry);
            Preconditions.checkState(!entry.isOrphan);
            entry.clientCount++;
        }
    }

    private void decreaseClientCount(CountingMemoryCache.Entry<K, V> entry) {
        synchronized (this) {
            Preconditions.checkNotNull(entry);
            Preconditions.checkState(entry.clientCount > 0);
            entry.clientCount--;
        }
    }

    @Nullable
    private CloseableReference<V> referenceToClose(CountingMemoryCache.Entry<K, V> entry) {
        CloseableReference<V> closeableReference;
        synchronized (this) {
            Preconditions.checkNotNull(entry);
            closeableReference = (entry.isOrphan && entry.clientCount == 0) ? entry.valueRef : null;
        }
        return closeableReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int getCount() {
        int count;
        synchronized (this) {
            count = this.mCachedEntries.getCount();
        }
        return count;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int getSizeInBytes() {
        int sizeInBytes;
        synchronized (this) {
            sizeInBytes = this.mCachedEntries.getSizeInBytes();
        }
        return sizeInBytes;
    }

    public int getInUseCount() {
        int count;
        int count2;
        synchronized (this) {
            count = this.mCachedEntries.getCount();
            count2 = this.mExclusiveEntries.getCount();
        }
        return count - count2;
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public int getInUseSizeInBytes() {
        int sizeInBytes;
        int sizeInBytes2;
        synchronized (this) {
            sizeInBytes = this.mCachedEntries.getSizeInBytes();
            sizeInBytes2 = this.mExclusiveEntries.getSizeInBytes();
        }
        return sizeInBytes - sizeInBytes2;
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public int getEvictionQueueCount() {
        int count;
        synchronized (this) {
            count = this.mExclusiveEntries.getCount();
        }
        return count;
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public int getEvictionQueueSizeInBytes() {
        int sizeInBytes;
        synchronized (this) {
            sizeInBytes = this.mExclusiveEntries.getSizeInBytes();
        }
        return sizeInBytes;
    }

    @Override // com.facebook.cache.common.HasDebugData
    @Nullable
    public String getDebugData() {
        String string;
        synchronized (this) {
            string = Objects.toStringHelper("CountingMemoryCache").add("cached_entries_count", this.mCachedEntries.getCount()).add("cached_entries_size_bytes", this.mCachedEntries.getSizeInBytes()).add("exclusive_entries_count", this.mExclusiveEntries.getCount()).add("exclusive_entries_size_bytes", this.mExclusiveEntries.getSizeInBytes()).toString();
        }
        return string;
    }
}
