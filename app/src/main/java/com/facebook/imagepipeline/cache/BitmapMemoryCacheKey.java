package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class BitmapMemoryCacheKey implements CacheKey {
    private Object callerContext;
    private final int hash;
    private final ImageDecodeOptions imageDecodeOptions;
    private final long inBitmapCacheSince;
    private final CacheKey postprocessorCacheKey;
    private final String postprocessorName;
    private final ResizeOptions resizeOptions;
    private final RotationOptions rotationOptions;
    private final String sourceString;

    public static /* synthetic */ BitmapMemoryCacheKey copy$default(BitmapMemoryCacheKey bitmapMemoryCacheKey, String str, ResizeOptions resizeOptions, RotationOptions rotationOptions, ImageDecodeOptions imageDecodeOptions, CacheKey cacheKey, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bitmapMemoryCacheKey.sourceString;
        }
        if ((i & 2) != 0) {
            resizeOptions = bitmapMemoryCacheKey.resizeOptions;
        }
        ResizeOptions resizeOptions2 = resizeOptions;
        if ((i & 4) != 0) {
            rotationOptions = bitmapMemoryCacheKey.rotationOptions;
        }
        RotationOptions rotationOptions2 = rotationOptions;
        if ((i & 8) != 0) {
            imageDecodeOptions = bitmapMemoryCacheKey.imageDecodeOptions;
        }
        ImageDecodeOptions imageDecodeOptions2 = imageDecodeOptions;
        if ((i & 16) != 0) {
            cacheKey = bitmapMemoryCacheKey.postprocessorCacheKey;
        }
        CacheKey cacheKey2 = cacheKey;
        if ((i & 32) != 0) {
            str2 = bitmapMemoryCacheKey.postprocessorName;
        }
        return bitmapMemoryCacheKey.copy(str, resizeOptions2, rotationOptions2, imageDecodeOptions2, cacheKey2, str2);
    }

    public final String component1() {
        return this.sourceString;
    }

    public final ResizeOptions component2() {
        return this.resizeOptions;
    }

    public final RotationOptions component3() {
        return this.rotationOptions;
    }

    public final ImageDecodeOptions component4() {
        return this.imageDecodeOptions;
    }

    public final CacheKey component5() {
        return this.postprocessorCacheKey;
    }

    public final String component6() {
        return this.postprocessorName;
    }

    public final BitmapMemoryCacheKey copy(@NotNull String sourceString, @Nullable ResizeOptions resizeOptions, @NotNull RotationOptions rotationOptions, @NotNull ImageDecodeOptions imageDecodeOptions, @Nullable CacheKey cacheKey, @Nullable String str) {
        Intrinsics.checkNotNullParameter(sourceString, "sourceString");
        Intrinsics.checkNotNullParameter(rotationOptions, "rotationOptions");
        Intrinsics.checkNotNullParameter(imageDecodeOptions, "imageDecodeOptions");
        return new BitmapMemoryCacheKey(sourceString, resizeOptions, rotationOptions, imageDecodeOptions, cacheKey, str);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean isResourceIdForDebugging() {
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        return "BitmapMemoryCacheKey(sourceString=" + this.sourceString + ", resizeOptions=" + this.resizeOptions + ", rotationOptions=" + this.rotationOptions + ", imageDecodeOptions=" + this.imageDecodeOptions + ", postprocessorCacheKey=" + this.postprocessorCacheKey + ", postprocessorName=" + this.postprocessorName + ")";
    }

    public BitmapMemoryCacheKey(@NotNull String sourceString, @Nullable ResizeOptions resizeOptions, @NotNull RotationOptions rotationOptions, @NotNull ImageDecodeOptions imageDecodeOptions, @Nullable CacheKey cacheKey, @Nullable String str) {
        Intrinsics.checkNotNullParameter(sourceString, "sourceString");
        Intrinsics.checkNotNullParameter(rotationOptions, "rotationOptions");
        Intrinsics.checkNotNullParameter(imageDecodeOptions, "imageDecodeOptions");
        this.sourceString = sourceString;
        this.resizeOptions = resizeOptions;
        this.rotationOptions = rotationOptions;
        this.imageDecodeOptions = imageDecodeOptions;
        this.postprocessorCacheKey = cacheKey;
        this.postprocessorName = str;
        int iHashCode = sourceString.hashCode();
        int iHashCode2 = resizeOptions != null ? resizeOptions.hashCode() : 0;
        int iHashCode3 = rotationOptions.hashCode();
        int iHashCode4 = imageDecodeOptions.hashCode();
        this.hash = (((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + (cacheKey != null ? cacheKey.hashCode() : 0)) * 31) + (str != null ? str.hashCode() : 0);
        this.inBitmapCacheSince = RealtimeSinceBootClock.get().now();
    }

    public final String getSourceString() {
        return this.sourceString;
    }

    public final ResizeOptions getResizeOptions() {
        return this.resizeOptions;
    }

    public final RotationOptions getRotationOptions() {
        return this.rotationOptions;
    }

    public final ImageDecodeOptions getImageDecodeOptions() {
        return this.imageDecodeOptions;
    }

    public final CacheKey getPostprocessorCacheKey() {
        return this.postprocessorCacheKey;
    }

    public final String getPostprocessorName() {
        return this.postprocessorName;
    }

    public final Object getCallerContext() {
        return this.callerContext;
    }

    public final void setCallerContext(@Nullable Object obj) {
        this.callerContext = obj;
    }

    public final long getInBitmapCacheSince() {
        return this.inBitmapCacheSince;
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.hash;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String uriString = getUriString();
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt__StringsKt.contains$default((CharSequence) uriString, (CharSequence) string, false, 2, (Object) null);
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return this.sourceString;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(BitmapMemoryCacheKey.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.imagepipeline.cache.BitmapMemoryCacheKey");
        BitmapMemoryCacheKey bitmapMemoryCacheKey = (BitmapMemoryCacheKey) obj;
        return Intrinsics.areEqual(this.sourceString, bitmapMemoryCacheKey.sourceString) && Intrinsics.areEqual(this.resizeOptions, bitmapMemoryCacheKey.resizeOptions) && Intrinsics.areEqual(this.rotationOptions, bitmapMemoryCacheKey.rotationOptions) && Intrinsics.areEqual(this.imageDecodeOptions, bitmapMemoryCacheKey.imageDecodeOptions) && Intrinsics.areEqual(this.postprocessorCacheKey, bitmapMemoryCacheKey.postprocessorCacheKey) && Intrinsics.areEqual(this.postprocessorName, bitmapMemoryCacheKey.postprocessorName);
    }
}
