package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import androidx.annotation.ColorInt;
import androidx.core.graphics.ColorUtils;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.BasePostprocessor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class TintPostProcessor extends BasePostprocessor {
    private final CacheKey cacheKey;
    private final PorterDuff.Mode porterDuffMode;
    private final int tintColor;

    public /* synthetic */ TintPostProcessor(int i, Float f, PorterDuff.Mode mode, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : f, (i2 & 4) != 0 ? null : mode);
    }

    public TintPostProcessor(@ColorInt int i, @Nullable Float f, @Nullable PorterDuff.Mode mode) {
        this.porterDuffMode = mode;
        i = f != null ? ColorUtils.setAlphaComponent(i, RangesKt___RangesKt.coerceIn((int) (f.floatValue() * 255), 0, 255)) : i;
        this.tintColor = i;
        this.cacheKey = new SimpleCacheKey("Tint. tintColor=" + i + ", mode=" + mode);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(@NotNull Bitmap sourceBitmap) {
        Intrinsics.checkNotNullParameter(sourceBitmap, "sourceBitmap");
        if (this.porterDuffMode == null) {
            new Canvas(sourceBitmap).drawColor(this.tintColor);
        } else {
            new Canvas(sourceBitmap).drawColor(this.tintColor, this.porterDuffMode);
        }
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        return Reflection.getOrCreateKotlinClass(TintPostProcessor.class).toString();
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        return this.cacheKey;
    }
}
