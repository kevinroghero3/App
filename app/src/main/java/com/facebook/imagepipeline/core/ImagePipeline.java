package com.facebook.imagepipeline.core;

import android.net.Uri;
import android.os.StrictMode;
import bolts.CancellationTokenSource;
import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.fresco.urimod.UriModifier;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener2;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.InternalRequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ImagePipeline {
    private final MemoryCache<CacheKey, CloseableImage> bitmapMemoryCache;
    private final CacheKeyFactory cacheKeyFactory;
    private final CallerContextVerifier callerContextVerifier;
    private final ImagePipelineConfigInterface config;
    private final Supplier<DiskCachesStore> diskCachesStoreSupplier;
    private final MemoryCache<CacheKey, PooledByteBuffer> encodedMemoryCache;
    private final AtomicLong idCounter;
    private final Supplier<Boolean> isLazyDataSource;
    private final Supplier<Boolean> isPrefetchEnabledSupplier;
    private final ProducerSequenceFactory producerSequenceFactory;
    private final RequestListener requestListener;
    private final RequestListener2 requestListener2;
    private final Supplier<Boolean> suppressBitmapPrefetchingSupplier;
    private final ThreadHandoffProducerQueue threadHandoffProducerQueue;
    public static final Companion Companion = new Companion(null);
    private static final CancellationException PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
    private static final CancellationException NULL_IMAGEREQUEST_EXCEPTION = new CancellationException("ImageRequest is null");
    private static final CancellationException MODIFIED_URL_IS_NULL = new CancellationException("Modified URL is null");

    /* JADX INFO: loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageRequest.CacheChoice.values().length];
            try {
                iArr[ImageRequest.CacheChoice.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageRequest.CacheChoice.SMALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageRequest.CacheChoice.DYNAMIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clearMemoryCaches$lambda$3(CacheKey it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return true;
    }

    public final void init() {
    }

    public final DataSource<Void> prefetchToEncodedCache(@Nullable ImageRequest imageRequest, @Nullable Object obj) {
        return prefetchToEncodedCache$default(this, imageRequest, obj, null, null, 12, null);
    }

    public final DataSource<Void> prefetchToEncodedCache(@Nullable ImageRequest imageRequest, @Nullable Object obj, @NotNull Priority priority) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        return prefetchToEncodedCache$default(this, imageRequest, obj, priority, null, 8, null);
    }

    public ImagePipeline(@NotNull ProducerSequenceFactory producerSequenceFactory, @NotNull Set<? extends RequestListener> requestListeners, @NotNull Set<? extends RequestListener2> requestListener2s, @NotNull Supplier<Boolean> isPrefetchEnabledSupplier, @NotNull MemoryCache<CacheKey, CloseableImage> bitmapMemoryCache, @NotNull MemoryCache<CacheKey, PooledByteBuffer> encodedMemoryCache, @NotNull Supplier<DiskCachesStore> diskCachesStoreSupplier, @NotNull CacheKeyFactory cacheKeyFactory, @NotNull ThreadHandoffProducerQueue threadHandoffProducerQueue, @NotNull Supplier<Boolean> suppressBitmapPrefetchingSupplier, @NotNull Supplier<Boolean> lazyDataSource, @Nullable CallerContextVerifier callerContextVerifier, @NotNull ImagePipelineConfigInterface config) {
        Intrinsics.checkNotNullParameter(producerSequenceFactory, "producerSequenceFactory");
        Intrinsics.checkNotNullParameter(requestListeners, "requestListeners");
        Intrinsics.checkNotNullParameter(requestListener2s, "requestListener2s");
        Intrinsics.checkNotNullParameter(isPrefetchEnabledSupplier, "isPrefetchEnabledSupplier");
        Intrinsics.checkNotNullParameter(bitmapMemoryCache, "bitmapMemoryCache");
        Intrinsics.checkNotNullParameter(encodedMemoryCache, "encodedMemoryCache");
        Intrinsics.checkNotNullParameter(diskCachesStoreSupplier, "diskCachesStoreSupplier");
        Intrinsics.checkNotNullParameter(cacheKeyFactory, "cacheKeyFactory");
        Intrinsics.checkNotNullParameter(threadHandoffProducerQueue, "threadHandoffProducerQueue");
        Intrinsics.checkNotNullParameter(suppressBitmapPrefetchingSupplier, "suppressBitmapPrefetchingSupplier");
        Intrinsics.checkNotNullParameter(lazyDataSource, "lazyDataSource");
        Intrinsics.checkNotNullParameter(config, "config");
        this.producerSequenceFactory = producerSequenceFactory;
        this.isPrefetchEnabledSupplier = isPrefetchEnabledSupplier;
        this.diskCachesStoreSupplier = diskCachesStoreSupplier;
        this.requestListener = new ForwardingRequestListener((Set<RequestListener>) requestListeners);
        this.requestListener2 = new ForwardingRequestListener2(requestListener2s);
        this.idCounter = new AtomicLong();
        this.bitmapMemoryCache = bitmapMemoryCache;
        this.encodedMemoryCache = encodedMemoryCache;
        this.cacheKeyFactory = cacheKeyFactory;
        this.threadHandoffProducerQueue = threadHandoffProducerQueue;
        this.suppressBitmapPrefetchingSupplier = suppressBitmapPrefetchingSupplier;
        this.isLazyDataSource = lazyDataSource;
        this.callerContextVerifier = callerContextVerifier;
        this.config = config;
    }

    public final ProducerSequenceFactory getProducerSequenceFactory() {
        return this.producerSequenceFactory;
    }

    public final MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        return this.bitmapMemoryCache;
    }

    public final CacheKeyFactory getCacheKeyFactory() {
        return this.cacheKeyFactory;
    }

    public final Supplier<Boolean> isLazyDataSource() {
        return this.isLazyDataSource;
    }

    public final ImagePipelineConfigInterface getConfig() {
        return this.config;
    }

    public final String generateUniqueFutureId() {
        return String.valueOf(this.idCounter.getAndIncrement());
    }

    public final Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(@NotNull final ImageRequest imageRequest, @Nullable final Object obj, @Nullable final ImageRequest.RequestLevel requestLevel) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getDataSourceSupplier.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.fetchDecodedImage$default(ImagePipeline.this, imageRequest, obj, requestLevel, null, null, 24, null);
            }

            public String toString() {
                String string = Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    public final Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(@NotNull final ImageRequest imageRequest, @Nullable final Object obj, @Nullable final ImageRequest.RequestLevel requestLevel, @Nullable final RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getDataSourceSupplier.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.fetchDecodedImage$default(ImagePipeline.this, imageRequest, obj, requestLevel, requestListener, null, 16, null);
            }

            public String toString() {
                String string = Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    public final Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(@NotNull final ImageRequest imageRequest, @Nullable final Object obj, @Nullable final ImageRequest.RequestLevel requestLevel, @Nullable final RequestListener requestListener, @Nullable final String str) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getDataSourceSupplier.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.this.fetchDecodedImage(imageRequest, obj, requestLevel, requestListener, str);
            }

            public String toString() {
                String string = Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    public final Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(@NotNull final ImageRequest imageRequest, @Nullable final Object obj) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new Supplier<DataSource<CloseableReference<PooledByteBuffer>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getEncodedImageDataSourceSupplier.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<PooledByteBuffer>> get() {
                return ImagePipeline.this.fetchEncodedImage(imageRequest, obj);
            }

            public String toString() {
                String string = Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    public final DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(@NotNull ImageRequest imageRequest, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public static /* synthetic */ DataSource fetchDecodedImage$default(ImagePipeline imagePipeline, ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, RequestListener requestListener, String str, int i, Object obj2) {
        return imagePipeline.fetchDecodedImage(imageRequest, obj, (i & 4) != 0 ? null : requestLevel, (i & 8) != 0 ? null : requestListener, (i & 16) != 0 ? null : str);
    }

    public final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(@Nullable ImageRequest imageRequest, @Nullable Object obj, @Nullable ImageRequest.RequestLevel requestLevel, @Nullable RequestListener requestListener, @Nullable String str) {
        if (imageRequest == null) {
            DataSource<CloseableReference<CloseableImage>> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(new NullPointerException());
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        try {
            Producer<CloseableReference<CloseableImage>> decodedImageProducerSequence = this.producerSequenceFactory.getDecodedImageProducerSequence(imageRequest);
            if (requestLevel == null) {
                requestLevel = ImageRequest.RequestLevel.FULL_FETCH;
            }
            return submitFetchRequest(decodedImageProducerSequence, imageRequest, requestLevel, obj, requestListener, str);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(@Nullable ImageRequest imageRequest, @Nullable Object obj) {
        return fetchDecodedImage$default(this, imageRequest, obj, null, null, null, 24, null);
    }

    public final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(@Nullable ImageRequest imageRequest, @Nullable Object obj, @NotNull RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        return fetchDecodedImage$default(this, imageRequest, obj, null, requestListener, null, 16, null);
    }

    public final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(@Nullable ImageRequest imageRequest, @Nullable Object obj, @NotNull ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit) {
        Intrinsics.checkNotNullParameter(lowestPermittedRequestLevelOnSubmit, "lowestPermittedRequestLevelOnSubmit");
        return fetchDecodedImage$default(this, imageRequest, obj, lowestPermittedRequestLevelOnSubmit, null, null, 16, null);
    }

    public final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(@Nullable ImageRequest imageRequest, @Nullable Object obj, @NotNull ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, @Nullable RequestListener requestListener, @Nullable String str, @Nullable Map<String, ?> map) {
        Intrinsics.checkNotNullParameter(lowestPermittedRequestLevelOnSubmit, "lowestPermittedRequestLevelOnSubmit");
        if (imageRequest == null) {
            DataSource<CloseableReference<CloseableImage>> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(new NullPointerException());
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        try {
            return submitFetchRequest(this.producerSequenceFactory.getDecodedImageProducerSequence(imageRequest), imageRequest, lowestPermittedRequestLevelOnSubmit, obj, requestListener, str, map);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public final DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(@NotNull ImageRequest imageRequest, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return fetchEncodedImage(imageRequest, obj, null);
    }

    public final DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(@NotNull ImageRequest imageRequest, @Nullable Object obj, @Nullable RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        if (imageRequest.getSourceUri() == null) {
            throw new IllegalStateException("Required value was null.");
        }
        try {
            Producer<CloseableReference<PooledByteBuffer>> encodedImageProducerSequence = this.producerSequenceFactory.getEncodedImageProducerSequence(imageRequest);
            if (imageRequest.getResizeOptions() != null) {
                imageRequest = ImageRequestBuilder.fromRequest(imageRequest).setResizeOptions(null).build();
            }
            return submitFetchRequest(encodedImageProducerSequence, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, requestListener, null, null);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public final DataSource<Void> prefetchToBitmapCache(@Nullable ImageRequest imageRequest, @Nullable Object obj) {
        return prefetchToBitmapCache(imageRequest, obj, null);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0069 A[Catch: Exception -> 0x0084, TryCatch #2 {Exception -> 0x0084, blocks: (B:8:0x0028, B:10:0x0034, B:12:0x003a, B:15:0x0044, B:17:0x004a, B:22:0x0062, B:24:0x006f, B:23:0x0069, B:20:0x0051, B:25:0x007e, B:26:0x0083), top: B:64:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ef A[Catch: Exception -> 0x0109, all -> 0x0112, TryCatch #1 {Exception -> 0x0109, blocks: (B:35:0x00ab, B:37:0x00b7, B:39:0x00bd, B:43:0x00ca, B:45:0x00d0, B:50:0x00e8, B:52:0x00f5, B:51:0x00ef, B:48:0x00d7, B:53:0x0103, B:54:0x0108), top: B:63:0x00ab, outer: #0 }] */
    public final DataSource<Void> prefetchToBitmapCache(@Nullable ImageRequest imageRequest, @Nullable Object obj, @Nullable RequestListener requestListener) {
        DataSource<Void> dataSourceImmediateFailedDataSource;
        Producer<Void> decodedImagePrefetchProducerSequence;
        Producer<Void> decodedImagePrefetchProducerSequence2;
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            if (!this.isPrefetchEnabledSupplier.get().booleanValue()) {
                DataSource<Void> dataSourceImmediateFailedDataSource2 = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource2, "immediateFailedDataSource(...)");
                return dataSourceImmediateFailedDataSource2;
            }
            try {
                if (this.config.getExperiments().getPrefetchShortcutEnabled() && isInBitmapMemoryCache(imageRequest)) {
                    DataSource<Void> dataSourceImmediateSuccessfulDataSource = DataSources.immediateSuccessfulDataSource();
                    Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource, "immediateSuccessfulDataSource(...)");
                    return dataSourceImmediateSuccessfulDataSource;
                }
                if (imageRequest == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                Boolean boolShouldDecodePrefetches = imageRequest.shouldDecodePrefetches();
                if (boolShouldDecodePrefetches != null) {
                    if (!boolShouldDecodePrefetches.booleanValue()) {
                        decodedImagePrefetchProducerSequence2 = this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest);
                    } else {
                        decodedImagePrefetchProducerSequence2 = this.producerSequenceFactory.getDecodedImagePrefetchProducerSequence(imageRequest);
                    }
                } else {
                    Boolean bool = this.suppressBitmapPrefetchingSupplier.get();
                    Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
                    if (bool.booleanValue()) {
                        decodedImagePrefetchProducerSequence2 = this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest);
                    } else {
                        decodedImagePrefetchProducerSequence2 = this.producerSequenceFactory.getDecodedImagePrefetchProducerSequence(imageRequest);
                    }
                }
                return submitPrefetchRequest(decodedImagePrefetchProducerSequence2, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM, requestListener);
            } catch (Exception e) {
                return DataSources.immediateFailedDataSource(e);
            }
        }
        FrescoSystrace.beginSection("ImagePipeline#prefetchToBitmapCache");
        try {
            if (!this.isPrefetchEnabledSupplier.get().booleanValue()) {
                DataSource<Void> dataSourceImmediateFailedDataSource3 = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource3, "immediateFailedDataSource(...)");
                FrescoSystrace.endSection();
                return dataSourceImmediateFailedDataSource3;
            }
            try {
                if (this.config.getExperiments().getPrefetchShortcutEnabled() && isInBitmapMemoryCache(imageRequest)) {
                    DataSource<Void> dataSourceImmediateSuccessfulDataSource2 = DataSources.immediateSuccessfulDataSource();
                    Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource2, "immediateSuccessfulDataSource(...)");
                    FrescoSystrace.endSection();
                    return dataSourceImmediateSuccessfulDataSource2;
                }
                if (imageRequest == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                Boolean boolShouldDecodePrefetches2 = imageRequest.shouldDecodePrefetches();
                if (boolShouldDecodePrefetches2 != null) {
                    if (!boolShouldDecodePrefetches2.booleanValue()) {
                        decodedImagePrefetchProducerSequence = this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest);
                    } else {
                        decodedImagePrefetchProducerSequence = this.producerSequenceFactory.getDecodedImagePrefetchProducerSequence(imageRequest);
                    }
                } else {
                    Boolean bool2 = this.suppressBitmapPrefetchingSupplier.get();
                    Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
                    if (bool2.booleanValue()) {
                        decodedImagePrefetchProducerSequence = this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest);
                    } else {
                        decodedImagePrefetchProducerSequence = this.producerSequenceFactory.getDecodedImagePrefetchProducerSequence(imageRequest);
                    }
                }
                dataSourceImmediateFailedDataSource = submitPrefetchRequest(decodedImagePrefetchProducerSequence, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM, requestListener);
                FrescoSystrace.endSection();
                return dataSourceImmediateFailedDataSource;
            } catch (Exception e2) {
                dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(e2);
            }
        } catch (Throwable th) {
            FrescoSystrace.endSection();
            throw th;
        }
    }

    public final DataSource<Void> prefetchToDiskCache(@Nullable ImageRequest imageRequest, @Nullable Object obj, @Nullable RequestListener requestListener) {
        return prefetchToDiskCache(imageRequest, obj, Priority.MEDIUM, requestListener);
    }

    public final DataSource<Void> prefetchToDiskCache(@Nullable ImageRequest imageRequest, @Nullable Object obj) {
        return prefetchToDiskCache(imageRequest, obj, Priority.MEDIUM, null);
    }

    public final DataSource<Void> prefetchToDiskCache(@Nullable ImageRequest imageRequest, @Nullable Object obj, @NotNull Priority priority) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        return prefetchToDiskCache(imageRequest, obj, priority, null);
    }

    public final DataSource<Void> prefetchToDiskCache(@Nullable ImageRequest imageRequest, @Nullable Object obj, @NotNull Priority priority, @Nullable RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        if (!this.isPrefetchEnabledSupplier.get().booleanValue()) {
            DataSource<Void> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        if (imageRequest == null) {
            DataSource<Void> dataSourceImmediateFailedDataSource2 = DataSources.immediateFailedDataSource(new NullPointerException("imageRequest is null"));
            Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource2);
            return dataSourceImmediateFailedDataSource2;
        }
        try {
            return submitPrefetchRequest(this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority, requestListener);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public final DataSource<Void> prefetchToEncodedCache(@Nullable ImageRequest imageRequest, @Nullable Object obj, @Nullable RequestListener requestListener) {
        return prefetchToEncodedCache(imageRequest, obj, Priority.MEDIUM, requestListener);
    }

    public static /* synthetic */ DataSource prefetchToEncodedCache$default(ImagePipeline imagePipeline, ImageRequest imageRequest, Object obj, Priority priority, RequestListener requestListener, int i, Object obj2) {
        if ((i & 4) != 0) {
            priority = Priority.MEDIUM;
        }
        if ((i & 8) != 0) {
            requestListener = null;
        }
        return imagePipeline.prefetchToEncodedCache(imageRequest, obj, priority, requestListener);
    }

    public final DataSource<Void> prefetchToEncodedCache(@Nullable ImageRequest imageRequest, @Nullable Object obj, @NotNull Priority priority, @Nullable RequestListener requestListener) {
        DataSource<Void> dataSourceImmediateFailedDataSource;
        Intrinsics.checkNotNullParameter(priority, "priority");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            if (!this.isPrefetchEnabledSupplier.get().booleanValue()) {
                DataSource<Void> dataSourceImmediateFailedDataSource2 = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource2, "immediateFailedDataSource(...)");
                return dataSourceImmediateFailedDataSource2;
            }
            if (imageRequest == null) {
                DataSource<Void> dataSourceImmediateFailedDataSource3 = DataSources.immediateFailedDataSource(NULL_IMAGEREQUEST_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource3, "immediateFailedDataSource(...)");
                return dataSourceImmediateFailedDataSource3;
            }
            try {
                if (!this.config.getExperiments().getPrefetchShortcutEnabled() || !isInEncodedMemoryCache(imageRequest)) {
                    return submitPrefetchRequest(this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority, requestListener);
                }
                DataSource<Void> dataSourceImmediateSuccessfulDataSource = DataSources.immediateSuccessfulDataSource();
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource, "immediateSuccessfulDataSource(...)");
                return dataSourceImmediateSuccessfulDataSource;
            } catch (Exception e) {
                return DataSources.immediateFailedDataSource(e);
            }
        }
        FrescoSystrace.beginSection("ImagePipeline#prefetchToEncodedCache");
        try {
            if (!this.isPrefetchEnabledSupplier.get().booleanValue()) {
                DataSource<Void> dataSourceImmediateFailedDataSource4 = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource4, "immediateFailedDataSource(...)");
                return dataSourceImmediateFailedDataSource4;
            }
            if (imageRequest == null) {
                DataSource<Void> dataSourceImmediateFailedDataSource5 = DataSources.immediateFailedDataSource(NULL_IMAGEREQUEST_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource5, "immediateFailedDataSource(...)");
                return dataSourceImmediateFailedDataSource5;
            }
            try {
                if (!this.config.getExperiments().getPrefetchShortcutEnabled() || !isInEncodedMemoryCache(imageRequest)) {
                    dataSourceImmediateFailedDataSource = submitPrefetchRequest(this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority, requestListener);
                    return dataSourceImmediateFailedDataSource;
                }
                DataSource<Void> dataSourceImmediateSuccessfulDataSource2 = DataSources.immediateSuccessfulDataSource();
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource2, "immediateSuccessfulDataSource(...)");
                return dataSourceImmediateSuccessfulDataSource2;
            } catch (Exception e2) {
                dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(e2);
            }
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final void evictFromMemoryCache(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Predicate<CacheKey> predicatePredicateForUri = predicateForUri(uri);
        this.bitmapMemoryCache.removeAll(predicatePredicateForUri);
        this.encodedMemoryCache.removeAll(predicatePredicateForUri);
    }

    public final void evictFromDiskCache(@Nullable Uri uri) {
        ImageRequest imageRequestFromUri = ImageRequest.fromUri(uri);
        if (imageRequestFromUri == null) {
            throw new IllegalStateException("Required value was null.");
        }
        evictFromDiskCache(imageRequestFromUri);
    }

    public final void evictFromDiskCache(@Nullable ImageRequest imageRequest) {
        if (imageRequest == null) {
            return;
        }
        CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        DiskCachesStore diskCachesStore2 = diskCachesStore;
        BufferedDiskCache mainBufferedDiskCache = diskCachesStore2.getMainBufferedDiskCache();
        Intrinsics.checkNotNull(encodedCacheKey);
        mainBufferedDiskCache.remove(encodedCacheKey);
        diskCachesStore2.getSmallImageBufferedDiskCache().remove(encodedCacheKey);
        Iterator<Map.Entry<String, BufferedDiskCache>> it2 = diskCachesStore2.getDynamicBufferedDiskCaches().entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().remove(encodedCacheKey);
        }
    }

    public final void evictFromCache(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        evictFromMemoryCache(uri);
        evictFromDiskCache(uri);
    }

    public final void clearMemoryCaches() {
        Predicate<CacheKey> predicate = new Predicate() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda5
            @Override // com.facebook.common.internal.Predicate
            public final boolean apply(Object obj) {
                return ImagePipeline.clearMemoryCaches$lambda$3((CacheKey) obj);
            }
        };
        this.bitmapMemoryCache.removeAll(predicate);
        this.encodedMemoryCache.removeAll(predicate);
    }

    public final void clearDiskCaches() {
        DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        DiskCachesStore diskCachesStore2 = diskCachesStore;
        diskCachesStore2.getMainBufferedDiskCache().clearAll();
        diskCachesStore2.getSmallImageBufferedDiskCache().clearAll();
        Iterator<Map.Entry<String, BufferedDiskCache>> it2 = diskCachesStore2.getDynamicBufferedDiskCaches().entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().clearAll();
        }
    }

    public final long getUsedDiskCacheSize() {
        DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        DiskCachesStore diskCachesStore2 = diskCachesStore;
        long size = diskCachesStore2.getMainBufferedDiskCache().getSize();
        long size2 = diskCachesStore2.getSmallImageBufferedDiskCache().getSize();
        Collection<BufferedDiskCache> collectionValues = diskCachesStore2.getDynamicBufferedDiskCaches().values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        Iterator<T> it2 = collectionValues.iterator();
        long size3 = 0;
        while (it2.hasNext()) {
            size3 += ((BufferedDiskCache) it2.next()).getSize();
        }
        return size + size2 + size3;
    }

    public final void clearCaches() {
        clearMemoryCaches();
        clearDiskCaches();
    }

    public final boolean isInBitmapMemoryCache(@Nullable Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.bitmapMemoryCache.contains(predicateForUri(uri));
    }

    public final boolean isInBitmapMemoryCache(@Nullable ImageRequest imageRequest) {
        if (imageRequest == null) {
            return false;
        }
        CacheKey bitmapCacheKey = this.cacheKeyFactory.getBitmapCacheKey(imageRequest, null);
        MemoryCache<CacheKey, CloseableImage> memoryCache = this.bitmapMemoryCache;
        Intrinsics.checkNotNull(bitmapCacheKey);
        CloseableReference<CloseableImage> closeableReference = memoryCache.get(bitmapCacheKey);
        try {
            return CloseableReference.isValid(closeableReference);
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }

    public final boolean isInEncodedMemoryCache(@Nullable Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.encodedMemoryCache.contains(predicateForUri(uri));
    }

    public final boolean isInEncodedMemoryCache(@Nullable ImageRequest imageRequest) {
        if (imageRequest == null) {
            return false;
        }
        CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        MemoryCache<CacheKey, PooledByteBuffer> memoryCache = this.encodedMemoryCache;
        Intrinsics.checkNotNull(encodedCacheKey);
        CloseableReference<PooledByteBuffer> closeableReference = memoryCache.get(encodedCacheKey);
        try {
            return CloseableReference.isValid(closeableReference);
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }

    public final boolean isInDiskCacheSync(@Nullable Uri uri) {
        return isInDiskCacheSync(uri, ImageRequest.CacheChoice.SMALL) || isInDiskCacheSync(uri, ImageRequest.CacheChoice.DEFAULT) || isInDiskCacheSync(uri, ImageRequest.CacheChoice.DYNAMIC);
    }

    public final boolean isInDiskCacheSync(@Nullable Uri uri, @Nullable ImageRequest.CacheChoice cacheChoice) {
        ImageRequest imageRequestBuild = ImageRequestBuilder.newBuilderWithSource(uri).setCacheChoice(cacheChoice).build();
        Intrinsics.checkNotNull(imageRequestBuild);
        return isInDiskCacheSync(imageRequestBuild);
    }

    private final boolean isInDynamicDiskCachesSync(ImageRequest imageRequest) {
        DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        DiskCachesStore diskCachesStore2 = diskCachesStore;
        CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        String diskCacheId = imageRequest.getDiskCacheId();
        if (diskCacheId != null) {
            BufferedDiskCache bufferedDiskCache = diskCachesStore2.getDynamicBufferedDiskCaches().get(diskCacheId);
            if (bufferedDiskCache == null) {
                return false;
            }
            Intrinsics.checkNotNull(encodedCacheKey);
            return bufferedDiskCache.diskCheckSync(encodedCacheKey);
        }
        Iterator<Map.Entry<String, BufferedDiskCache>> it2 = diskCachesStore2.getDynamicBufferedDiskCaches().entrySet().iterator();
        while (it2.hasNext()) {
            BufferedDiskCache value = it2.next().getValue();
            Intrinsics.checkNotNull(encodedCacheKey);
            if (value.diskCheckSync(encodedCacheKey)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isInDiskCacheSync(@NotNull ImageRequest imageRequest) {
        boolean zDiskCheckSync;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        DiskCachesStore diskCachesStore2 = diskCachesStore;
        CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        ImageRequest.CacheChoice cacheChoice = imageRequest.getCacheChoice();
        Intrinsics.checkNotNullExpressionValue(cacheChoice, "getCacheChoice(...)");
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[cacheChoice.ordinal()];
            if (i == 1) {
                BufferedDiskCache mainBufferedDiskCache = diskCachesStore2.getMainBufferedDiskCache();
                Intrinsics.checkNotNull(encodedCacheKey);
                zDiskCheckSync = mainBufferedDiskCache.diskCheckSync(encodedCacheKey);
            } else if (i == 2) {
                BufferedDiskCache smallImageBufferedDiskCache = diskCachesStore2.getSmallImageBufferedDiskCache();
                Intrinsics.checkNotNull(encodedCacheKey);
                zDiskCheckSync = smallImageBufferedDiskCache.diskCheckSync(encodedCacheKey);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                zDiskCheckSync = isInDynamicDiskCachesSync(imageRequest);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return zDiskCheckSync;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    public final DataSource<Boolean> isInDiskCache(@Nullable Uri uri) {
        ImageRequest imageRequestFromUri = ImageRequest.fromUri(uri);
        if (imageRequestFromUri != null) {
            return isInDiskCache(imageRequestFromUri);
        }
        throw new IllegalStateException("Required value was null.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, bolts.Task, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v5, types: [bolts.Task, bolts.Task<java.lang.Boolean>] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v5, types: [T, bolts.Task] */
    private final Task<Boolean> isInDynamicDiskCaches(ImageRequest imageRequest, CacheKey cacheKey, final Continuation<Boolean, Void> continuation, final CancellationTokenSource cancellationTokenSource) {
        Task<Boolean> taskContains;
        DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        DiskCachesStore diskCachesStore2 = diskCachesStore;
        String diskCacheId = imageRequest != null ? imageRequest.getDiskCacheId() : null;
        if (diskCacheId != null) {
            BufferedDiskCache bufferedDiskCache = diskCachesStore2.getDynamicBufferedDiskCaches().get(diskCacheId);
            if (bufferedDiskCache != null && (taskContains = bufferedDiskCache.contains(cacheKey)) != null) {
                return taskContains;
            }
            Task<Boolean> taskForResult = Task.forResult(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(taskForResult, "forResult(...)");
            return taskForResult;
        }
        if (diskCachesStore2.getDynamicBufferedDiskCaches().size() == 0) {
            Task<Boolean> taskForResult2 = Task.forResult(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(taskForResult2, "forResult(...)");
            return taskForResult2;
        }
        Iterator<Map.Entry<String, BufferedDiskCache>> it2 = diskCachesStore2.getDynamicBufferedDiskCaches().entrySet().iterator();
        ?? ForResult = Task.forResult(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(ForResult, "forResult(...)");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = ForResult;
        ?? r0 = ForResult;
        while (it2.hasNext()) {
            objectRef.element = it2.next().getValue().contains(cacheKey);
            r0.continueWithTask(new Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline.isInDynamicDiskCaches.1
                @Override // bolts.Continuation
                public /* bridge */ /* synthetic */ Object then(Task task) {
                    return then((Task<Boolean>) task);
                }

                @Override // bolts.Continuation
                public final Task<? extends Object> then(Task<Boolean> task) {
                    if (!task.isCancelled() && !task.isFaulted() && task.getResult().booleanValue()) {
                        cancellationTokenSource.cancel();
                        return Task.forResult(Boolean.TRUE).continueWith(continuation);
                    }
                    if (task.isCancelled()) {
                        return Task.forResult(Boolean.FALSE);
                    }
                    return objectRef.element;
                }
            }, cancellationTokenSource.getToken());
            r0 = (Task) objectRef.element;
        }
        return r0;
    }

    public final DataSource<Boolean> isInDiskCache(@Nullable final ImageRequest imageRequest) {
        DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
        final DiskCachesStore diskCachesStore2 = diskCachesStore;
        final CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        final SimpleDataSource simpleDataSourceCreate = SimpleDataSource.create();
        final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        Continuation continuation = new Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda0
            @Override // bolts.Continuation
            public final Object then(Task task) {
                return ImagePipeline.isInDiskCache$lambda$7(simpleDataSourceCreate, task);
            }
        };
        final Continuation continuation2 = new Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda1
            @Override // bolts.Continuation
            public final Object then(Task task) {
                return ImagePipeline.isInDiskCache$lambda$8(simpleDataSourceCreate, task);
            }
        };
        BufferedDiskCache mainBufferedDiskCache = diskCachesStore2.getMainBufferedDiskCache();
        Intrinsics.checkNotNull(encodedCacheKey);
        mainBufferedDiskCache.contains(encodedCacheKey).continueWithTask(new Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda2
            @Override // bolts.Continuation
            public final Object then(Task task) {
                return ImagePipeline.isInDiskCache$lambda$9(diskCachesStore2, encodedCacheKey, task);
            }
        }).continueWithTask((Continuation<TContinuationResult, Task<TContinuationResult>>) new Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda3
            @Override // bolts.Continuation
            public final Object then(Task task) {
                return ImagePipeline.isInDiskCache$lambda$10(this.f$0, imageRequest, encodedCacheKey, continuation2, cancellationTokenSource, task);
            }
        }, cancellationTokenSource.getToken()).continueWith(continuation);
        Intrinsics.checkNotNull(simpleDataSourceCreate);
        return simpleDataSourceCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Void isInDiskCache$lambda$7(SimpleDataSource simpleDataSource, Task task) {
        Boolean bool = (Boolean) simpleDataSource.getResult();
        simpleDataSource.setResult(Boolean.valueOf((bool != null && bool.booleanValue()) || !(task.isCancelled() || task.isFaulted() || !((Boolean) task.getResult()).booleanValue())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Void isInDiskCache$lambda$8(SimpleDataSource simpleDataSource, Task task) {
        Boolean bool = (Boolean) simpleDataSource.getResult();
        simpleDataSource.setResult(Boolean.valueOf((bool != null && bool.booleanValue()) || !(task.isCancelled() || task.isFaulted() || !((Boolean) task.getResult()).booleanValue())), false);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task isInDiskCache$lambda$9(DiskCachesStore diskCachesStore, CacheKey cacheKey, Task task) {
        Intrinsics.checkNotNullParameter(diskCachesStore, "$diskCachesStore");
        if (!task.isCancelled() && !task.isFaulted() && ((Boolean) task.getResult()).booleanValue()) {
            return Task.forResult(Boolean.TRUE);
        }
        BufferedDiskCache smallImageBufferedDiskCache = diskCachesStore.getSmallImageBufferedDiskCache();
        Intrinsics.checkNotNull(cacheKey);
        return smallImageBufferedDiskCache.contains(cacheKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task isInDiskCache$lambda$10(ImagePipeline this$0, ImageRequest imageRequest, CacheKey cacheKey, Continuation intermediateContinuation, CancellationTokenSource cts, Task task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intermediateContinuation, "$intermediateContinuation");
        Intrinsics.checkNotNullParameter(cts, "$cts");
        if (!task.isCancelled() && !task.isFaulted() && ((Boolean) task.getResult()).booleanValue()) {
            return Task.forResult(Boolean.TRUE);
        }
        Intrinsics.checkNotNull(cacheKey);
        return this$0.isInDynamicDiskCaches(imageRequest, cacheKey, intermediateContinuation, cts);
    }

    public final CacheKey getCacheKey(@Nullable ImageRequest imageRequest, @Nullable Object obj) {
        CacheKey bitmapCacheKey;
        CacheKey bitmapCacheKey2;
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        CacheKey cacheKey = null;
        if (!FrescoSystrace.isTracing()) {
            if (imageRequest == null) {
                return null;
            }
            if (imageRequest.getPostprocessor() != null) {
                bitmapCacheKey2 = this.cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, obj);
            } else {
                bitmapCacheKey2 = this.cacheKeyFactory.getBitmapCacheKey(imageRequest, obj);
            }
            return bitmapCacheKey2;
        }
        FrescoSystrace.beginSection("ImagePipeline#getCacheKey");
        if (imageRequest != null) {
            try {
                if (imageRequest.getPostprocessor() != null) {
                    bitmapCacheKey = this.cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, obj);
                } else {
                    bitmapCacheKey = this.cacheKeyFactory.getBitmapCacheKey(imageRequest, obj);
                }
                cacheKey = bitmapCacheKey;
            } finally {
                FrescoSystrace.endSection();
            }
        }
        return cacheKey;
    }

    public final CloseableReference<CloseableImage> getCachedImage(@Nullable CacheKey cacheKey) {
        if (cacheKey == null) {
            return null;
        }
        CloseableReference<CloseableImage> closeableReference = this.bitmapMemoryCache.get(cacheKey);
        if (closeableReference == null || closeableReference.get().getQualityInfo().isOfFullQuality()) {
            return closeableReference;
        }
        closeableReference.close();
        return null;
    }

    public final boolean hasCachedImage(@Nullable CacheKey cacheKey) {
        if (cacheKey == null) {
            return false;
        }
        return this.bitmapMemoryCache.contains(cacheKey);
    }

    private final <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, RequestListener requestListener, String str) {
        return submitFetchRequest(producer, imageRequest, requestLevel, obj, requestListener, str, null);
    }

    private final <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, RequestListener requestListener, String str, Map<String, ?> map) {
        DataSource<CloseableReference<T>> dataSourceImmediateFailedDataSource;
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            InternalRequestListener internalRequestListener = new InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
            CallerContextVerifier callerContextVerifier = this.callerContextVerifier;
            if (callerContextVerifier != null) {
                callerContextVerifier.verifyCallerContext(obj, false);
            }
            try {
                ImageRequest.RequestLevel max = ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel);
                Intrinsics.checkNotNullExpressionValue(max, "getMax(...)");
                SettableProducerContext settableProducerContext = new SettableProducerContext(imageRequest, generateUniqueFutureId(), str, internalRequestListener, obj, max, false, imageRequest.getProgressiveRenderingEnabled() || !UriUtil.isNetworkUri(imageRequest.getSourceUri()), imageRequest.getPriority(), this.config);
                settableProducerContext.putExtras(map);
                return CloseableProducerToDataSourceAdapter.create(producer, settableProducerContext, internalRequestListener);
            } catch (Exception e) {
                return DataSources.immediateFailedDataSource(e);
            }
        }
        FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
        try {
            InternalRequestListener internalRequestListener2 = new InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
            CallerContextVerifier callerContextVerifier2 = this.callerContextVerifier;
            if (callerContextVerifier2 != null) {
                callerContextVerifier2.verifyCallerContext(obj, false);
            }
            try {
                ImageRequest.RequestLevel max2 = ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel);
                Intrinsics.checkNotNullExpressionValue(max2, "getMax(...)");
                SettableProducerContext settableProducerContext2 = new SettableProducerContext(imageRequest, generateUniqueFutureId(), str, internalRequestListener2, obj, max2, false, imageRequest.getProgressiveRenderingEnabled() || !UriUtil.isNetworkUri(imageRequest.getSourceUri()), imageRequest.getPriority(), this.config);
                settableProducerContext2.putExtras(map);
                dataSourceImmediateFailedDataSource = CloseableProducerToDataSourceAdapter.create(producer, settableProducerContext2, internalRequestListener2);
            } catch (Exception e2) {
                dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(e2);
            }
            FrescoSystrace.endSection();
            return dataSourceImmediateFailedDataSource;
        } catch (Throwable th) {
            FrescoSystrace.endSection();
            throw th;
        }
    }

    private final <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, RequestListener requestListener, Map<String, ?> map) {
        DataSource<CloseableReference<T>> dataSourceImmediateFailedDataSource;
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            InternalRequestListener internalRequestListener = new InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
            CallerContextVerifier callerContextVerifier = this.callerContextVerifier;
            if (callerContextVerifier != null) {
                callerContextVerifier.verifyCallerContext(obj, false);
            }
            try {
                ImageRequest.RequestLevel max = ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel);
                Intrinsics.checkNotNullExpressionValue(max, "getMax(...)");
                return CloseableProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId(), null, internalRequestListener, obj, max, false, imageRequest.getProgressiveRenderingEnabled() || !UriUtil.isNetworkUri(imageRequest.getSourceUri()), imageRequest.getPriority(), this.config), internalRequestListener);
            } catch (Exception e) {
                return DataSources.immediateFailedDataSource(e);
            }
        }
        FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
        try {
            InternalRequestListener internalRequestListener2 = new InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
            CallerContextVerifier callerContextVerifier2 = this.callerContextVerifier;
            if (callerContextVerifier2 != null) {
                callerContextVerifier2.verifyCallerContext(obj, false);
            }
            try {
                ImageRequest.RequestLevel max2 = ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel);
                Intrinsics.checkNotNullExpressionValue(max2, "getMax(...)");
                dataSourceImmediateFailedDataSource = CloseableProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId(), null, internalRequestListener2, obj, max2, false, imageRequest.getProgressiveRenderingEnabled() || !UriUtil.isNetworkUri(imageRequest.getSourceUri()), imageRequest.getPriority(), this.config), internalRequestListener2);
            } catch (Exception e2) {
                dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(e2);
            }
            FrescoSystrace.endSection();
            return dataSourceImmediateFailedDataSource;
        } catch (Throwable th) {
            FrescoSystrace.endSection();
            throw th;
        }
    }

    public final <T> DataSource<CloseableReference<T>> submitFetchRequest(@NotNull Producer<CloseableReference<T>> producerSequence, @NotNull SettableProducerContext settableProducerContext, @Nullable RequestListener requestListener) {
        DataSource<CloseableReference<T>> dataSourceImmediateFailedDataSource;
        Intrinsics.checkNotNullParameter(producerSequence, "producerSequence");
        Intrinsics.checkNotNullParameter(settableProducerContext, "settableProducerContext");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            try {
                return CloseableProducerToDataSourceAdapter.create(producerSequence, settableProducerContext, new InternalRequestListener(requestListener, this.requestListener2));
            } catch (Exception e) {
                return DataSources.immediateFailedDataSource(e);
            }
        }
        FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
        try {
            try {
                dataSourceImmediateFailedDataSource = CloseableProducerToDataSourceAdapter.create(producerSequence, settableProducerContext, new InternalRequestListener(requestListener, this.requestListener2));
            } catch (Exception e2) {
                dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(e2);
            }
            return dataSourceImmediateFailedDataSource;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    private final DataSource<Void> submitPrefetchRequest(Producer<Void> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority, RequestListener requestListener) {
        ImageRequest imageRequestBuild = imageRequest;
        InternalRequestListener internalRequestListener = new InternalRequestListener(getRequestListenerForRequest(imageRequestBuild, requestListener), this.requestListener2);
        CallerContextVerifier callerContextVerifier = this.callerContextVerifier;
        if (callerContextVerifier != null) {
            callerContextVerifier.verifyCallerContext(obj, true);
        }
        Uri sourceUri = imageRequest.getSourceUri();
        Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
        Uri uriModifyPrefetchUri = UriModifier.f8INSTANCE.modifyPrefetchUri(sourceUri, obj);
        if (uriModifyPrefetchUri == null) {
            DataSource<Void> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(MODIFIED_URL_IS_NULL);
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        if (!Intrinsics.areEqual(sourceUri, uriModifyPrefetchUri)) {
            imageRequestBuild = ImageRequestBuilder.fromRequest(imageRequest).setSource(uriModifyPrefetchUri).build();
        }
        ImageRequest imageRequest2 = imageRequestBuild;
        try {
            ImageRequest.RequestLevel max = ImageRequest.RequestLevel.getMax(imageRequest2.getLowestPermittedRequestLevel(), requestLevel);
            Intrinsics.checkNotNullExpressionValue(max, "getMax(...)");
            String strGenerateUniqueFutureId = generateUniqueFutureId();
            ImagePipelineExperiments experiments = this.config.getExperiments();
            return ProducerToDataSourceAdapter.Companion.create(producer, new SettableProducerContext(imageRequest2, strGenerateUniqueFutureId, internalRequestListener, obj, max, true, experiments != null && experiments.getAllowProgressiveOnPrefetch() && imageRequest2.getProgressiveRenderingEnabled(), priority, this.config), internalRequestListener);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public final RequestListener getRequestListenerForRequest(@Nullable ImageRequest imageRequest, @Nullable RequestListener requestListener) {
        ForwardingRequestListener forwardingRequestListener;
        if (imageRequest == null) {
            throw new IllegalStateException("Required value was null.");
        }
        if (requestListener == null) {
            if (imageRequest.getRequestListener() == null) {
                return this.requestListener;
            }
            forwardingRequestListener = new ForwardingRequestListener(this.requestListener, imageRequest.getRequestListener());
        } else if (imageRequest.getRequestListener() == null) {
            forwardingRequestListener = new ForwardingRequestListener(this.requestListener, requestListener);
        } else {
            forwardingRequestListener = new ForwardingRequestListener(this.requestListener, requestListener, imageRequest.getRequestListener());
        }
        return forwardingRequestListener;
    }

    public final RequestListener getCombinedRequestListener(@Nullable RequestListener requestListener) {
        return requestListener != null ? new ForwardingRequestListener(this.requestListener, requestListener) : this.requestListener;
    }

    private final Predicate<CacheKey> predicateForUri(final Uri uri) {
        return new Predicate() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda4
            @Override // com.facebook.common.internal.Predicate
            public final boolean apply(Object obj) {
                return ImagePipeline.predicateForUri$lambda$16(uri, (CacheKey) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean predicateForUri$lambda$16(Uri uri, CacheKey key) {
        Intrinsics.checkNotNullParameter(uri, "$uri");
        Intrinsics.checkNotNullParameter(key, "key");
        return key.containsUri(uri);
    }

    public final void pause() {
        this.threadHandoffProducerQueue.startQueueing();
    }

    public final void resume() {
        this.threadHandoffProducerQueue.stopQueuing();
    }

    public final boolean isPaused() {
        return this.threadHandoffProducerQueue.isQueueing();
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
