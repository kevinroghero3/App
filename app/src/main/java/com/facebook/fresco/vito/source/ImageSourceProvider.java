package com.facebook.fresco.vito.source;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.util.Map;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageSourceProvider {
    public static final ImageSourceProvider INSTANCE = new ImageSourceProvider();
    private static Function1<? super String, ? extends Uri> uriParser = new Function1() { // from class: com.facebook.fresco.vito.source.ImageSourceProvider$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return ImageSourceProvider.uriParser$lambda$0((String) obj);
        }
    };

    @JvmStatic
    public static final ImageSource forUri(@Nullable Uri uri) {
        return forUri$default(uri, (Map) null, 2, (Object) null);
    }

    @JvmStatic
    public static final ImageSource forUri(@Nullable String str) {
        return forUri$default(str, (Map) null, 2, (Object) null);
    }

    private ImageSourceProvider() {
    }

    public final Function1<String, Uri> getUriParser() {
        return uriParser;
    }

    public final void setUriParser(@NotNull Function1<? super String, ? extends Uri> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        uriParser = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri uriParser$lambda$0(String it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        Uri uri = Uri.parse(it2);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        return uri;
    }

    @JvmStatic
    public static final ImageSource emptySource() {
        return EmptyImageSource.INSTANCE;
    }

    public static /* synthetic */ ImageSource forUri$default(Uri uri, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        return forUri(uri, (Map<String, ? extends Object>) map);
    }

    @JvmStatic
    public static final ImageSource forUri(@Nullable Uri uri, @Nullable Map<String, ? extends Object> map) {
        if (uri == null) {
            return emptySource();
        }
        Map mapCreateMapBuilder = MapsKt__MapsJVMKt.createMapBuilder();
        if (map != null) {
            mapCreateMapBuilder.putAll(map);
        }
        mapCreateMapBuilder.put("uri_source", uri);
        return new SingleImageSourceImpl(uri, MapsKt__MapsJVMKt.build(mapCreateMapBuilder));
    }

    public static /* synthetic */ ImageSource forUri$default(String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        return forUri(str, (Map<String, ? extends Object>) map);
    }

    @JvmStatic
    public static final ImageSource forUri(@Nullable String str, @Nullable Map<String, ? extends Object> map) {
        return forUri(str != null ? uriParser.invoke(str) : null, map);
    }

    @JvmStatic
    public static final ImageSource firstAvailable(@NotNull ImageSource... imageSources) {
        Intrinsics.checkNotNullParameter(imageSources, "imageSources");
        return new FirstAvailableImageSource(imageSources);
    }

    @JvmStatic
    public static final ImageSource increasingQuality(@NotNull ImageSource lowResImageSource, @NotNull ImageSource highResImageSource) {
        Intrinsics.checkNotNullParameter(lowResImageSource, "lowResImageSource");
        Intrinsics.checkNotNullParameter(highResImageSource, "highResImageSource");
        return new IncreasingQualityImageSource(lowResImageSource, highResImageSource, null);
    }

    public static /* synthetic */ ImageSource increasingQuality$default(ImageSource imageSource, ImageSource imageSource2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        return increasingQuality(imageSource, imageSource2, map);
    }

    @JvmStatic
    public static final ImageSource increasingQuality(@NotNull ImageSource lowResImageSource, @NotNull ImageSource highResImageSource, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(lowResImageSource, "lowResImageSource");
        Intrinsics.checkNotNullParameter(highResImageSource, "highResImageSource");
        return new IncreasingQualityImageSource(lowResImageSource, highResImageSource, map);
    }

    @JvmStatic
    public static final ImageSource increasingQuality(@Nullable Uri uri, @Nullable Uri uri2) {
        if (uri == null) {
            return forUri$default(uri2, (Map) null, 2, (Object) null);
        }
        return new IncreasingQualityImageSource(forUri$default(uri, (Map) null, 2, (Object) null), forUri$default(uri2, (Map) null, 2, (Object) null), null, 4, null);
    }

    @JvmStatic
    public static final ImageSource bitmap(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return new BitmapImageSource(bitmap);
    }

    @JvmStatic
    public static final ImageSource drawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return new DrawableImageSource(drawable);
    }
}
