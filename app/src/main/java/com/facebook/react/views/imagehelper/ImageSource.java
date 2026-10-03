package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.net.Uri;
import com.facebook.react.modules.fresco.ImageCacheControl;
import java.util.Objects;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ImageSource {
    public static final Companion Companion = new Companion(null);
    private static final String TRANSPARENT_BITMAP_URI = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII=";
    private boolean _isResource;
    private final ImageCacheControl cacheControl;
    private final double size;
    private final String source;
    private final Uri uri;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageSource(@NotNull Context context, @Nullable String str) {
        this(context, str, 0.0d, 0.0d, null, 28, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageSource(@NotNull Context context, @Nullable String str, double d) {
        this(context, str, d, 0.0d, null, 24, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageSource(@NotNull Context context, @Nullable String str, double d, double d2) {
        this(context, str, d, d2, null, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @JvmStatic
    public static final ImageSource getTransparentBitmapImageSource(@NotNull Context context) {
        return Companion.getTransparentBitmapImageSource(context);
    }

    public ImageSource(@NotNull Context context, @Nullable String str, double d, double d2, @NotNull ImageCacheControl cacheControl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
        this.source = str;
        this.cacheControl = cacheControl;
        this.uri = computeUri(context);
        this.size = d * d2;
    }

    public final String getSource() {
        return this.source;
    }

    public /* synthetic */ ImageSource(Context context, String str, double d, double d2, ImageCacheControl imageCacheControl, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? 0.0d : d, (i & 8) != 0 ? 0.0d : d2, (i & 16) != 0 ? ImageCacheControl.DEFAULT : imageCacheControl);
    }

    public final ImageCacheControl getCacheControl() {
        return this.cacheControl;
    }

    public Uri getUri() {
        return this.uri;
    }

    public final double getSize() {
        return this.size;
    }

    public boolean isResource() {
        return this._isResource;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(getClass(), obj.getClass())) {
            return false;
        }
        ImageSource imageSource = (ImageSource) obj;
        return Double.compare(imageSource.size, this.size) == 0 && isResource() == imageSource.isResource() && Intrinsics.areEqual(getUri(), imageSource.getUri()) && Intrinsics.areEqual(this.source, imageSource.source) && this.cacheControl == imageSource.cacheControl;
    }

    public int hashCode() {
        Uri uri = getUri();
        String str = this.source;
        double d = this.size;
        boolean zIsResource = isResource();
        return Objects.hash(uri, str, Double.valueOf(d), Boolean.valueOf(zIsResource), this.cacheControl);
    }

    private final Uri computeUri(Context context) {
        try {
            Uri uri = Uri.parse(this.source);
            return uri.getScheme() == null ? computeLocalUri(context) : uri;
        } catch (NullPointerException unused) {
            return computeLocalUri(context);
        }
    }

    private final Uri computeLocalUri(Context context) {
        this._isResource = true;
        return ResourceDrawableIdHelper.Companion.getInstance().getResourceDrawableUri(context, this.source);
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ImageSource getTransparentBitmapImageSource(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new ImageSource(context, ImageSource.TRANSPARENT_BITMAP_URI, 0.0d, 0.0d, ImageCacheControl.DEFAULT, 12, null);
        }
    }
}
