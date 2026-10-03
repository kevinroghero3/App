package com.facebook.react.modules.fresco;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactNetworkImageRequest extends ImageRequest {
    public static final Companion Companion = new Companion(null);
    private final ImageCacheControl cacheControl;
    private final ReadableMap headers;

    public /* synthetic */ ReactNetworkImageRequest(ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap, ImageCacheControl imageCacheControl, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageRequestBuilder, readableMap, imageCacheControl);
    }

    @JvmStatic
    public static final ReactNetworkImageRequest fromBuilderWithHeaders(@NotNull ImageRequestBuilder imageRequestBuilder, @Nullable ReadableMap readableMap) {
        return Companion.fromBuilderWithHeaders(imageRequestBuilder, readableMap);
    }

    @JvmStatic
    public static final ReactNetworkImageRequest fromBuilderWithHeaders(@NotNull ImageRequestBuilder imageRequestBuilder, @Nullable ReadableMap readableMap, @NotNull ImageCacheControl imageCacheControl) {
        return Companion.fromBuilderWithHeaders(imageRequestBuilder, readableMap, imageCacheControl);
    }

    public final ReadableMap getHeaders$ReactAndroid_release() {
        return this.headers;
    }

    public final ImageCacheControl getCacheControl$ReactAndroid_release() {
        return this.cacheControl;
    }

    private ReactNetworkImageRequest(ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap, ImageCacheControl imageCacheControl) {
        super(imageRequestBuilder);
        this.headers = readableMap;
        this.cacheControl = imageCacheControl;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ReactNetworkImageRequest fromBuilderWithHeaders(@NotNull ImageRequestBuilder builder, @Nullable ReadableMap readableMap) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            return fromBuilderWithHeaders$default(this, builder, readableMap, null, 4, null);
        }

        private Companion() {
        }

        public static /* synthetic */ ReactNetworkImageRequest fromBuilderWithHeaders$default(Companion companion, ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap, ImageCacheControl imageCacheControl, int i, Object obj) {
            if ((i & 4) != 0) {
                imageCacheControl = ImageCacheControl.DEFAULT;
            }
            return companion.fromBuilderWithHeaders(imageRequestBuilder, readableMap, imageCacheControl);
        }

        @JvmStatic
        public final ReactNetworkImageRequest fromBuilderWithHeaders(@NotNull ImageRequestBuilder builder, @Nullable ReadableMap readableMap, @NotNull ImageCacheControl cacheControl) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
            return new ReactNetworkImageRequest(builder, readableMap, cacheControl, null);
        }
    }
}
