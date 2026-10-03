package com.facebook.fresco.vito.options;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.DownsampleMode;
import com.facebook.imagepipeline.request.Postprocessor;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class DecodedImageOptions extends EncodedImageOptions {
    private final PointF actualImageFocusPoint;
    private final ScalingUtils.ScaleType actualImageScaleType;
    private final Bitmap.Config bitmapConfig;
    private final BorderOptions borderOptions;
    private final DownsampleMode downsampleOverride;
    private final ImageDecodeOptions imageDecodeOptions;
    private final Boolean isProgressiveDecodingEnabled;
    private final boolean loadThumbnailOnly;
    private final boolean mLocalThumbnailPreviewsEnabled;
    private final Postprocessor postprocessor;
    private final ResizeOptions resizeOptions;
    private final RotationOptions rotationOptions;
    private final RoundingOptions roundingOptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecodedImageOptions(@NotNull Builder<?> builder) {
        super(builder);
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.resizeOptions = builder.getResizeOptions$options_release();
        this.downsampleOverride = builder.getDownsampleOverride$options_release();
        this.rotationOptions = builder.getRotationOptions$options_release();
        this.postprocessor = builder.getPostprocessor$options_release();
        this.imageDecodeOptions = builder.getImageDecodeOptions$options_release();
        this.roundingOptions = builder.getRoundingOptions$options_release();
        this.borderOptions = builder.getBorderOptions$options_release();
        this.actualImageScaleType = builder.getActualImageScaleType$options_release();
        this.actualImageFocusPoint = builder.getActualFocusPoint$options_release();
        this.mLocalThumbnailPreviewsEnabled = builder.getLocalThumbnailPreviewsEnabled$options_release();
        this.loadThumbnailOnly = builder.getLoadThumbnailOnly$options_release();
        this.bitmapConfig = builder.getBitmapConfig$options_release();
        this.isProgressiveDecodingEnabled = builder.getProgressiveDecodingEnabled$options_release();
    }

    public final ResizeOptions getResizeOptions() {
        return this.resizeOptions;
    }

    public final DownsampleMode getDownsampleOverride() {
        return this.downsampleOverride;
    }

    public final RotationOptions getRotationOptions() {
        return this.rotationOptions;
    }

    public final Postprocessor getPostprocessor() {
        return this.postprocessor;
    }

    public final ImageDecodeOptions getImageDecodeOptions() {
        return this.imageDecodeOptions;
    }

    public final RoundingOptions getRoundingOptions() {
        return this.roundingOptions;
    }

    public final BorderOptions getBorderOptions() {
        return this.borderOptions;
    }

    public final ScalingUtils.ScaleType getActualImageScaleType() {
        return this.actualImageScaleType;
    }

    public final PointF getActualImageFocusPoint() {
        return this.actualImageFocusPoint;
    }

    public final boolean getMLocalThumbnailPreviewsEnabled() {
        return this.mLocalThumbnailPreviewsEnabled;
    }

    public final boolean getLoadThumbnailOnly() {
        return this.loadThumbnailOnly;
    }

    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    public final Boolean isProgressiveDecodingEnabled() {
        return this.isProgressiveDecodingEnabled;
    }

    public final boolean areLocalThumbnailPreviewsEnabled() {
        return this.mLocalThumbnailPreviewsEnabled;
    }

    @Override // com.facebook.fresco.vito.options.EncodedImageOptions
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(getClass(), obj.getClass())) {
            return false;
        }
        return equalDecodedOptions((DecodedImageOptions) obj);
    }

    protected final boolean equalDecodedOptions(@NotNull DecodedImageOptions other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (Objects.equal(this.resizeOptions, other.resizeOptions) && Objects.equal(this.downsampleOverride, other.downsampleOverride) && Objects.equal(this.rotationOptions, other.rotationOptions) && Objects.equal(this.postprocessor, other.postprocessor) && Objects.equal(this.imageDecodeOptions, other.imageDecodeOptions) && Objects.equal(this.roundingOptions, other.roundingOptions) && Objects.equal(this.borderOptions, other.borderOptions) && Objects.equal(this.actualImageScaleType, other.actualImageScaleType) && Objects.equal(this.actualImageFocusPoint, other.actualImageFocusPoint) && this.mLocalThumbnailPreviewsEnabled == other.mLocalThumbnailPreviewsEnabled && this.loadThumbnailOnly == other.loadThumbnailOnly && this.isProgressiveDecodingEnabled == other.isProgressiveDecodingEnabled && Objects.equal(this.bitmapConfig, other.bitmapConfig)) {
            return equalEncodedOptions(other);
        }
        return false;
    }

    @Override // com.facebook.fresco.vito.options.EncodedImageOptions
    public int hashCode() {
        int iHashCode = super.hashCode();
        ResizeOptions resizeOptions = this.resizeOptions;
        int iHashCode2 = resizeOptions != null ? resizeOptions.hashCode() : 0;
        DownsampleMode downsampleMode = this.downsampleOverride;
        int iHashCode3 = downsampleMode != null ? downsampleMode.hashCode() : 0;
        RotationOptions rotationOptions = this.rotationOptions;
        int iHashCode4 = rotationOptions != null ? rotationOptions.hashCode() : 0;
        Postprocessor postprocessor = this.postprocessor;
        int iHashCode5 = postprocessor != null ? postprocessor.hashCode() : 0;
        ImageDecodeOptions imageDecodeOptions = this.imageDecodeOptions;
        int iHashCode6 = imageDecodeOptions != null ? imageDecodeOptions.hashCode() : 0;
        RoundingOptions roundingOptions = this.roundingOptions;
        int iHashCode7 = roundingOptions != null ? roundingOptions.hashCode() : 0;
        BorderOptions borderOptions = this.borderOptions;
        int iHashCode8 = borderOptions != null ? borderOptions.hashCode() : 0;
        int iHashCode9 = this.actualImageScaleType.hashCode();
        PointF pointF = this.actualImageFocusPoint;
        int iHashCode10 = pointF != null ? pointF.hashCode() : 0;
        boolean z = this.mLocalThumbnailPreviewsEnabled;
        boolean z2 = this.loadThumbnailOnly;
        Bitmap.Config config = this.bitmapConfig;
        int iHashCode11 = config != null ? config.hashCode() : 0;
        Boolean bool = this.isProgressiveDecodingEnabled;
        return (((((((((((((((((((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + iHashCode9) * 31) + iHashCode10) * 31) + (z ? 1 : 0)) * 31) + (z2 ? 1 : 0)) * 31) + iHashCode11) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    @Override // com.facebook.fresco.vito.options.EncodedImageOptions
    public String toString() {
        return "DecodedImageOptions{" + toStringHelper() + "}";
    }

    @Override // com.facebook.fresco.vito.options.EncodedImageOptions
    protected Objects.ToStringHelper toStringHelper() {
        Objects.ToStringHelper toStringHelperAdd = super.toStringHelper().add("resizeOptions", this.resizeOptions).add("downsampleOverride", this.downsampleOverride).add("rotationOptions", this.rotationOptions).add("postprocessor", this.postprocessor).add("imageDecodeOptions", this.imageDecodeOptions).add("roundingOptions", this.roundingOptions).add("borderOptions", this.borderOptions).add("actualImageScaleType", this.actualImageScaleType).add("actualImageFocusPoint", this.actualImageFocusPoint).add("localThumbnailPreviewsEnabled", this.mLocalThumbnailPreviewsEnabled).add("loadThumbnailOnly", this.loadThumbnailOnly).add("bitmapConfig", this.bitmapConfig).add("progressiveRenderingEnabled", this.isProgressiveDecodingEnabled);
        Intrinsics.checkNotNullExpressionValue(toStringHelperAdd, "add(...)");
        return toStringHelperAdd;
    }

    public static class Builder<T extends Builder<T>> extends EncodedImageOptions.Builder<T> {
        private PointF actualFocusPoint;
        private ScalingUtils.ScaleType actualImageScaleType;
        private Bitmap.Config bitmapConfig;
        private BorderOptions borderOptions;
        private DownsampleMode downsampleOverride;
        private ImageDecodeOptions imageDecodeOptions;
        private boolean loadThumbnailOnly;
        private boolean localThumbnailPreviewsEnabled;
        private Postprocessor postprocessor;
        private Boolean progressiveDecodingEnabled;
        private ResizeOptions resizeOptions;
        private RotationOptions rotationOptions;
        private RoundingOptions roundingOptions;

        public final ResizeOptions getResizeOptions$options_release() {
            return this.resizeOptions;
        }

        public final void setResizeOptions$options_release(@Nullable ResizeOptions resizeOptions) {
            this.resizeOptions = resizeOptions;
        }

        public final DownsampleMode getDownsampleOverride$options_release() {
            return this.downsampleOverride;
        }

        public final void setDownsampleOverride$options_release(@Nullable DownsampleMode downsampleMode) {
            this.downsampleOverride = downsampleMode;
        }

        public final RotationOptions getRotationOptions$options_release() {
            return this.rotationOptions;
        }

        public final void setRotationOptions$options_release(@Nullable RotationOptions rotationOptions) {
            this.rotationOptions = rotationOptions;
        }

        public final Postprocessor getPostprocessor$options_release() {
            return this.postprocessor;
        }

        public final void setPostprocessor$options_release(@Nullable Postprocessor postprocessor) {
            this.postprocessor = postprocessor;
        }

        public final ImageDecodeOptions getImageDecodeOptions$options_release() {
            return this.imageDecodeOptions;
        }

        public final void setImageDecodeOptions$options_release(@Nullable ImageDecodeOptions imageDecodeOptions) {
            this.imageDecodeOptions = imageDecodeOptions;
        }

        public final RoundingOptions getRoundingOptions$options_release() {
            return this.roundingOptions;
        }

        public final void setRoundingOptions$options_release(@Nullable RoundingOptions roundingOptions) {
            this.roundingOptions = roundingOptions;
        }

        public final BorderOptions getBorderOptions$options_release() {
            return this.borderOptions;
        }

        public final void setBorderOptions$options_release(@Nullable BorderOptions borderOptions) {
            this.borderOptions = borderOptions;
        }

        public final ScalingUtils.ScaleType getActualImageScaleType$options_release() {
            return this.actualImageScaleType;
        }

        public final void setActualImageScaleType$options_release(@NotNull ScalingUtils.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "<set-?>");
            this.actualImageScaleType = scaleType;
        }

        public final PointF getActualFocusPoint$options_release() {
            return this.actualFocusPoint;
        }

        public final void setActualFocusPoint$options_release(@Nullable PointF pointF) {
            this.actualFocusPoint = pointF;
        }

        public final boolean getLocalThumbnailPreviewsEnabled$options_release() {
            return this.localThumbnailPreviewsEnabled;
        }

        public final void setLocalThumbnailPreviewsEnabled$options_release(boolean z) {
            this.localThumbnailPreviewsEnabled = z;
        }

        public final boolean getLoadThumbnailOnly$options_release() {
            return this.loadThumbnailOnly;
        }

        public final void setLoadThumbnailOnly$options_release(boolean z) {
            this.loadThumbnailOnly = z;
        }

        public final Bitmap.Config getBitmapConfig$options_release() {
            return this.bitmapConfig;
        }

        public final void setBitmapConfig$options_release(@Nullable Bitmap.Config config) {
            this.bitmapConfig = config;
        }

        public final Boolean getProgressiveDecodingEnabled$options_release() {
            return this.progressiveDecodingEnabled;
        }

        public final void setProgressiveDecodingEnabled$options_release(@Nullable Boolean bool) {
            this.progressiveDecodingEnabled = bool;
        }

        public Builder() {
            ScalingUtils.ScaleType CENTER_CROP = ScalingUtils.ScaleType.CENTER_CROP;
            Intrinsics.checkNotNullExpressionValue(CENTER_CROP, "CENTER_CROP");
            this.actualImageScaleType = CENTER_CROP;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull DecodedImageOptions decodedImageOptions) {
            super(decodedImageOptions);
            Intrinsics.checkNotNullParameter(decodedImageOptions, "decodedImageOptions");
            ScalingUtils.ScaleType CENTER_CROP = ScalingUtils.ScaleType.CENTER_CROP;
            Intrinsics.checkNotNullExpressionValue(CENTER_CROP, "CENTER_CROP");
            this.actualImageScaleType = CENTER_CROP;
            this.resizeOptions = decodedImageOptions.getResizeOptions();
            this.downsampleOverride = decodedImageOptions.getDownsampleOverride();
            this.rotationOptions = decodedImageOptions.getRotationOptions();
            this.postprocessor = decodedImageOptions.getPostprocessor();
            this.imageDecodeOptions = decodedImageOptions.getImageDecodeOptions();
            this.roundingOptions = decodedImageOptions.getRoundingOptions();
            this.borderOptions = decodedImageOptions.getBorderOptions();
            this.actualImageScaleType = decodedImageOptions.getActualImageScaleType();
            this.actualFocusPoint = decodedImageOptions.getActualImageFocusPoint();
            this.localThumbnailPreviewsEnabled = decodedImageOptions.areLocalThumbnailPreviewsEnabled();
            this.loadThumbnailOnly = decodedImageOptions.getLoadThumbnailOnly();
            this.bitmapConfig = decodedImageOptions.getBitmapConfig();
            this.progressiveDecodingEnabled = decodedImageOptions.isProgressiveDecodingEnabled();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull ImageOptions defaultOptions) {
            this((DecodedImageOptions) defaultOptions);
            Intrinsics.checkNotNullParameter(defaultOptions, "defaultOptions");
        }

        public final T resize(@Nullable ResizeOptions resizeOptions) {
            this.resizeOptions = resizeOptions;
            return getThis();
        }

        public final T downsampleOverride(@Nullable DownsampleMode downsampleMode) {
            this.downsampleOverride = downsampleMode;
            return getThis();
        }

        public final T rotate(@Nullable RotationOptions rotationOptions) {
            this.rotationOptions = rotationOptions;
            return getThis();
        }

        public final T postprocess(@Nullable Postprocessor postprocessor) {
            this.postprocessor = postprocessor;
            return getThis();
        }

        public final T imageDecodeOptions(@Nullable ImageDecodeOptions imageDecodeOptions) {
            this.imageDecodeOptions = imageDecodeOptions;
            return getThis();
        }

        public final T round(@Nullable RoundingOptions roundingOptions) {
            this.roundingOptions = roundingOptions;
            return getThis();
        }

        public final T borders(@Nullable BorderOptions borderOptions) {
            this.borderOptions = borderOptions;
            return getThis();
        }

        public final T scale(@Nullable ScalingUtils.ScaleType scaleType) {
            if (scaleType == null) {
                scaleType = ImageOptions.Companion.defaults().getActualImageScaleType();
            }
            this.actualImageScaleType = scaleType;
            return getThis();
        }

        public final T focusPoint(@Nullable PointF pointF) {
            this.actualFocusPoint = pointF;
            return getThis();
        }

        public final T localThumbnailPreviewsEnabled(boolean z) {
            this.localThumbnailPreviewsEnabled = z;
            return getThis();
        }

        public final T loadThumbnailOnly(boolean z) {
            this.loadThumbnailOnly = z;
            return getThis();
        }

        public final T bitmapConfig(@Nullable Bitmap.Config config) {
            this.bitmapConfig = config;
            return getThis();
        }

        public final T progressiveRendering(@Nullable Boolean bool) {
            this.progressiveDecodingEnabled = bool;
            return getThis();
        }

        @Override // com.facebook.fresco.vito.options.EncodedImageOptions.Builder
        public DecodedImageOptions build() {
            return new DecodedImageOptions(this);
        }

        private final T modify(Function1<? super Builder<T>, Unit> function1) {
            function1.invoke(this);
            return getThis();
        }
    }
}
