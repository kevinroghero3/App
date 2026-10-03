package com.facebook.fresco.vito.options;

import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.common.Priority;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ImageOptions extends DecodedImageOptions {
    public static final Companion Companion = new Companion(null);
    private static ImageOptions defaultImageOptions;
    private final boolean _autoPlay;
    private final boolean _autoStop;
    private final boolean _resizeToViewport;
    private final ColorFilter actualImageColorFilter;
    private final Drawable backgroundDrawable;
    private final ImageOptionsDrawableFactory customDrawableFactory;
    private final boolean errorApplyRoundingOptions;
    private final Integer errorColor;
    private final Drawable errorDrawable;
    private final PointF errorFocusPoint;
    private final int errorRes;
    private final ScalingUtils.ScaleType errorScaleType;
    private final int fadeDurationMs;
    private final boolean isPerfMediaRemountInstrumentationFix;
    private final Drawable overlayDrawable;
    private final int overlayRes;
    private final boolean placeholderApplyRoundingOptions;
    private final Integer placeholderColor;
    private final Drawable placeholderDrawable;
    private final PointF placeholderFocusPoint;
    private final int placeholderRes;
    private final ScalingUtils.ScaleType placeholderScaleType;
    private final Drawable progressDrawable;
    private final int progressRes;
    private final ScalingUtils.ScaleType progressScaleType;

    @JvmStatic
    public static final Builder create() {
        return Companion.create();
    }

    @JvmStatic
    public static final ImageOptions defaults() {
        return Companion.defaults();
    }

    @JvmStatic
    public static final Builder extend(@NotNull ImageOptions imageOptions) {
        return Companion.extend(imageOptions);
    }

    @JvmStatic
    public static final void setDefaults(@NotNull ImageOptions imageOptions) {
        Companion.setDefaults(imageOptions);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageOptions(@NotNull Builder builder) {
        super(builder);
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.placeholderColor = builder.get_placeholderColor$options_release();
        this.placeholderRes = builder.get_placeholderRes$options_release();
        this.placeholderDrawable = builder.get_placeholderDrawable$options_release();
        this.placeholderScaleType = builder.get_placeholderScaleType$options_release();
        this.placeholderFocusPoint = builder.get_placeholderFocusPoint$options_release();
        this.placeholderApplyRoundingOptions = builder.get_placeholderApplyRoundingOptions$options_release();
        this.progressRes = builder.get_progressRes$options_release();
        this.progressDrawable = builder.get_progressDrawable$options_release();
        this.progressScaleType = builder.get_progressScaleType$options_release();
        this.errorColor = builder.get_errorColor$options_release();
        this.errorRes = builder.get_errorRes$options_release();
        this.errorScaleType = builder.get_errorScaleType$options_release();
        this.errorFocusPoint = builder.get_errorFocusPoint$options_release();
        this.errorDrawable = builder.get_errorDrawable$options_release();
        this.errorApplyRoundingOptions = builder.get_errorApplyRoundingOptions$options_release();
        this.actualImageColorFilter = builder.get_actualImageColorFilter$options_release();
        this.overlayRes = builder.get_overlayRes$options_release();
        this.overlayDrawable = builder.get_overlayDrawable$options_release();
        this.backgroundDrawable = builder.get_backgroundDrawable$options_release();
        this._resizeToViewport = builder.get_resizeToViewport$options_release();
        this.fadeDurationMs = builder.get_fadeDurationMs$options_release();
        this._autoPlay = builder.get_autoPlay$options_release();
        this._autoStop = builder.get_autoStop$options_release();
        this.isPerfMediaRemountInstrumentationFix = builder.get_perfMediaRemountInstrumentationFix$options_release();
        this.customDrawableFactory = builder.get_customDrawableFactory$options_release();
    }

    public final Integer getPlaceholderColor() {
        return this.placeholderColor;
    }

    public final int getPlaceholderRes() {
        return this.placeholderRes;
    }

    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final ScalingUtils.ScaleType getPlaceholderScaleType() {
        return this.placeholderScaleType;
    }

    public final PointF getPlaceholderFocusPoint() {
        return this.placeholderFocusPoint;
    }

    public final boolean getPlaceholderApplyRoundingOptions() {
        return this.placeholderApplyRoundingOptions;
    }

    public final int getProgressRes() {
        return this.progressRes;
    }

    public final Drawable getProgressDrawable() {
        return this.progressDrawable;
    }

    public final ScalingUtils.ScaleType getProgressScaleType() {
        return this.progressScaleType;
    }

    public final Integer getErrorColor() {
        return this.errorColor;
    }

    public final int getErrorRes() {
        return this.errorRes;
    }

    public final ScalingUtils.ScaleType getErrorScaleType() {
        return this.errorScaleType;
    }

    public final PointF getErrorFocusPoint() {
        return this.errorFocusPoint;
    }

    public final Drawable getErrorDrawable() {
        return this.errorDrawable;
    }

    public final boolean getErrorApplyRoundingOptions() {
        return this.errorApplyRoundingOptions;
    }

    public final ColorFilter getActualImageColorFilter() {
        return this.actualImageColorFilter;
    }

    public final int getOverlayRes() {
        return this.overlayRes;
    }

    public final Drawable getOverlayDrawable() {
        return this.overlayDrawable;
    }

    public final Drawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    public final int getFadeDurationMs() {
        return this.fadeDurationMs;
    }

    public final boolean isPerfMediaRemountInstrumentationFix() {
        return this.isPerfMediaRemountInstrumentationFix;
    }

    public final ImageOptionsDrawableFactory getCustomDrawableFactory() {
        return this.customDrawableFactory;
    }

    public final Builder extend() {
        return Companion.extend(this);
    }

    public final boolean shouldAutoPlay() {
        return this._autoPlay;
    }

    public final boolean shouldAutoStop() {
        return this._autoStop;
    }

    public final boolean shouldResizeToViewport() {
        return this._resizeToViewport;
    }

    public final boolean equalsForActualImage(@NotNull ImageOptions other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this == other) {
            return true;
        }
        if (this.isPerfMediaRemountInstrumentationFix) {
            if (this.overlayRes != other.overlayRes || !Objects.equal(this.overlayDrawable, other.overlayDrawable) || !Objects.equal(this.backgroundDrawable, other.backgroundDrawable) || !Objects.equal(this.actualImageColorFilter, other.actualImageColorFilter) || this._resizeToViewport != other._resizeToViewport || this._autoPlay != other._autoPlay || this._autoStop != other._autoStop || !Objects.equal(this.customDrawableFactory, other.customDrawableFactory) || this.isPerfMediaRemountInstrumentationFix != other.isPerfMediaRemountInstrumentationFix) {
                return false;
            }
        } else if (this.overlayRes != other.overlayRes || !Objects.equal(this.overlayDrawable, other.overlayDrawable) || !Objects.equal(this.backgroundDrawable, other.backgroundDrawable) || !Objects.equal(this.actualImageColorFilter, other.actualImageColorFilter) || this._resizeToViewport != other._resizeToViewport || !Objects.equal(this.customDrawableFactory, other.customDrawableFactory)) {
            return false;
        }
        return equalDecodedOptions(other);
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x01a4, code lost:
    
        if (r3.errorDrawable == r4.errorDrawable) goto L112;
     */
    @Override // com.facebook.fresco.vito.options.DecodedImageOptions, com.facebook.fresco.vito.options.EncodedImageOptions
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r4) {
        /*
            Method dump skipped, instruction units count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.vito.options.ImageOptions.equals(java.lang.Object):boolean");
    }

    @Override // com.facebook.fresco.vito.options.DecodedImageOptions, com.facebook.fresco.vito.options.EncodedImageOptions
    public int hashCode() {
        int iHashCode = super.hashCode();
        Integer num = this.placeholderColor;
        int iIntValue = num != null ? num.intValue() : 0;
        int i = this.placeholderRes;
        Drawable drawable = this.placeholderDrawable;
        int iHashCode2 = drawable != null ? drawable.hashCode() : 0;
        ScalingUtils.ScaleType scaleType = this.placeholderScaleType;
        int iHashCode3 = scaleType != null ? scaleType.hashCode() : 0;
        PointF pointF = this.placeholderFocusPoint;
        int iHashCode4 = pointF != null ? pointF.hashCode() : 0;
        boolean z = this.placeholderApplyRoundingOptions;
        Integer num2 = this.errorColor;
        int iIntValue2 = num2 != null ? num2.intValue() : 0;
        int i2 = this.errorRes;
        ScalingUtils.ScaleType scaleType2 = this.errorScaleType;
        int iHashCode5 = scaleType2 != null ? scaleType2.hashCode() : 0;
        PointF pointF2 = this.errorFocusPoint;
        int iHashCode6 = pointF2 != null ? pointF2.hashCode() : 0;
        Drawable drawable2 = this.errorDrawable;
        int iHashCode7 = drawable2 != null ? drawable2.hashCode() : 0;
        boolean z2 = this.errorApplyRoundingOptions;
        int i3 = this.overlayRes;
        Drawable drawable3 = this.overlayDrawable;
        int iHashCode8 = drawable3 != null ? drawable3.hashCode() : 0;
        Drawable drawable4 = this.backgroundDrawable;
        int iHashCode9 = drawable4 != null ? drawable4.hashCode() : 0;
        Drawable drawable5 = this.progressDrawable;
        int iHashCode10 = drawable5 != null ? drawable5.hashCode() : 0;
        ScalingUtils.ScaleType scaleType3 = this.progressScaleType;
        int iHashCode11 = scaleType3 != null ? scaleType3.hashCode() : 0;
        ColorFilter colorFilter = this.actualImageColorFilter;
        int iHashCode12 = colorFilter != null ? colorFilter.hashCode() : 0;
        boolean z3 = this._resizeToViewport;
        int i4 = this.fadeDurationMs;
        boolean z4 = this._autoPlay;
        boolean z5 = this._autoStop;
        boolean z6 = this.isPerfMediaRemountInstrumentationFix;
        int i5 = this.progressRes;
        ImageOptionsDrawableFactory imageOptionsDrawableFactory = this.customDrawableFactory;
        return (((((((((((((((((((((((((((((((((((((((((((((((((iHashCode * 31) + iIntValue) * 31) + i) * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + (z ? 1 : 0)) * 31) + iIntValue2) * 31) + i2) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + (z2 ? 1 : 0)) * 31) + i3) * 31) + iHashCode8) * 31) + iHashCode9) * 31) + iHashCode10) * 31) + iHashCode11) * 31) + iHashCode12) * 31) + (z3 ? 1 : 0)) * 31) + i4) * 31) + (z4 ? 1 : 0)) * 31) + (z5 ? 1 : 0)) * 31) + (z6 ? 1 : 0)) * 31) + i5) * 31) + (imageOptionsDrawableFactory != null ? imageOptionsDrawableFactory.hashCode() : 0);
    }

    @Override // com.facebook.fresco.vito.options.DecodedImageOptions, com.facebook.fresco.vito.options.EncodedImageOptions
    public String toString() {
        return "ImageOptions{" + toStringHelper() + "}";
    }

    @Override // com.facebook.fresco.vito.options.DecodedImageOptions, com.facebook.fresco.vito.options.EncodedImageOptions
    protected Objects.ToStringHelper toStringHelper() {
        Objects.ToStringHelper toStringHelperAdd = super.toStringHelper().add("placeholderColor", this.placeholderColor).add("placeholderRes", this.placeholderRes).add("placeholderDrawable", this.placeholderDrawable).add("placeholderScaleType", this.placeholderScaleType).add("placeholderFocusPoint", this.placeholderFocusPoint).add("placeholderApplyRoundingOptions", this.placeholderApplyRoundingOptions).add("progressRes", this.progressRes).add("progressDrawable", this.progressDrawable).add("progressScaleType", this.progressScaleType).add("errorColor", this.errorColor).add("errorRes", this.errorRes).add("errorScaleType", this.errorScaleType).add("errorFocusPoint", this.errorFocusPoint).add("errorDrawable", this.errorDrawable).add("errorApplyRoundingOptions", this.errorApplyRoundingOptions).add("actualImageColorFilter", this.actualImageColorFilter).add("overlayRes", this.overlayRes).add("overlayDrawable", this.overlayDrawable).add("backgroundDrawable", this.backgroundDrawable).add("resizeToViewport", this._resizeToViewport).add("autoPlay", this._autoPlay).add("autoStop", this._autoStop).add("mPerfMediaRemountInstrumentationFix", this.isPerfMediaRemountInstrumentationFix).add("fadeDurationMs", this.fadeDurationMs).add("customDrawableFactory", this.customDrawableFactory);
        Intrinsics.checkNotNullExpressionValue(toStringHelperAdd, "add(...)");
        return toStringHelperAdd;
    }

    public static final class Builder extends DecodedImageOptions.Builder<Builder> {
        private ColorFilter _actualImageColorFilter;
        private boolean _autoPlay;
        private boolean _autoStop;
        private Drawable _backgroundDrawable;
        private ImageOptionsDrawableFactory _customDrawableFactory;
        private boolean _errorApplyRoundingOptions;
        private Integer _errorColor;
        private Drawable _errorDrawable;
        private PointF _errorFocusPoint;
        private int _errorRes;
        private ScalingUtils.ScaleType _errorScaleType;
        private int _fadeDurationMs;
        private Drawable _overlayDrawable;
        private int _overlayRes;
        private boolean _perfMediaRemountInstrumentationFix;
        private boolean _placeholderApplyRoundingOptions;
        private Integer _placeholderColor;
        private Drawable _placeholderDrawable;
        private PointF _placeholderFocusPoint;
        private int _placeholderRes;
        private ScalingUtils.ScaleType _placeholderScaleType;
        private Drawable _progressDrawable;
        private int _progressRes;
        private ScalingUtils.ScaleType _progressScaleType;
        private boolean _resizeToViewport;

        public final Integer get_placeholderColor$options_release() {
            return this._placeholderColor;
        }

        public final void set_placeholderColor$options_release(@Nullable Integer num) {
            this._placeholderColor = num;
        }

        public final int get_placeholderRes$options_release() {
            return this._placeholderRes;
        }

        public final void set_placeholderRes$options_release(int i) {
            this._placeholderRes = i;
        }

        public final Drawable get_placeholderDrawable$options_release() {
            return this._placeholderDrawable;
        }

        public final void set_placeholderDrawable$options_release(@Nullable Drawable drawable) {
            this._placeholderDrawable = drawable;
        }

        public final ScalingUtils.ScaleType get_placeholderScaleType$options_release() {
            return this._placeholderScaleType;
        }

        public final void set_placeholderScaleType$options_release(@Nullable ScalingUtils.ScaleType scaleType) {
            this._placeholderScaleType = scaleType;
        }

        public final PointF get_placeholderFocusPoint$options_release() {
            return this._placeholderFocusPoint;
        }

        public final void set_placeholderFocusPoint$options_release(@Nullable PointF pointF) {
            this._placeholderFocusPoint = pointF;
        }

        public final boolean get_placeholderApplyRoundingOptions$options_release() {
            return this._placeholderApplyRoundingOptions;
        }

        public final void set_placeholderApplyRoundingOptions$options_release(boolean z) {
            this._placeholderApplyRoundingOptions = z;
        }

        public final int get_progressRes$options_release() {
            return this._progressRes;
        }

        public final void set_progressRes$options_release(int i) {
            this._progressRes = i;
        }

        public final Drawable get_progressDrawable$options_release() {
            return this._progressDrawable;
        }

        public final void set_progressDrawable$options_release(@Nullable Drawable drawable) {
            this._progressDrawable = drawable;
        }

        public final ScalingUtils.ScaleType get_progressScaleType$options_release() {
            return this._progressScaleType;
        }

        public final void set_progressScaleType$options_release(@Nullable ScalingUtils.ScaleType scaleType) {
            this._progressScaleType = scaleType;
        }

        public final Integer get_errorColor$options_release() {
            return this._errorColor;
        }

        public final void set_errorColor$options_release(@Nullable Integer num) {
            this._errorColor = num;
        }

        public final int get_errorRes$options_release() {
            return this._errorRes;
        }

        public final void set_errorRes$options_release(int i) {
            this._errorRes = i;
        }

        public final ScalingUtils.ScaleType get_errorScaleType$options_release() {
            return this._errorScaleType;
        }

        public final void set_errorScaleType$options_release(@Nullable ScalingUtils.ScaleType scaleType) {
            this._errorScaleType = scaleType;
        }

        public final PointF get_errorFocusPoint$options_release() {
            return this._errorFocusPoint;
        }

        public final void set_errorFocusPoint$options_release(@Nullable PointF pointF) {
            this._errorFocusPoint = pointF;
        }

        public final Drawable get_errorDrawable$options_release() {
            return this._errorDrawable;
        }

        public final void set_errorDrawable$options_release(@Nullable Drawable drawable) {
            this._errorDrawable = drawable;
        }

        public final boolean get_errorApplyRoundingOptions$options_release() {
            return this._errorApplyRoundingOptions;
        }

        public final void set_errorApplyRoundingOptions$options_release(boolean z) {
            this._errorApplyRoundingOptions = z;
        }

        public final ColorFilter get_actualImageColorFilter$options_release() {
            return this._actualImageColorFilter;
        }

        public final void set_actualImageColorFilter$options_release(@Nullable ColorFilter colorFilter) {
            this._actualImageColorFilter = colorFilter;
        }

        public final int get_overlayRes$options_release() {
            return this._overlayRes;
        }

        public final void set_overlayRes$options_release(int i) {
            this._overlayRes = i;
        }

        public final Drawable get_overlayDrawable$options_release() {
            return this._overlayDrawable;
        }

        public final void set_overlayDrawable$options_release(@Nullable Drawable drawable) {
            this._overlayDrawable = drawable;
        }

        public final Drawable get_backgroundDrawable$options_release() {
            return this._backgroundDrawable;
        }

        public final void set_backgroundDrawable$options_release(@Nullable Drawable drawable) {
            this._backgroundDrawable = drawable;
        }

        public final boolean get_resizeToViewport$options_release() {
            return this._resizeToViewport;
        }

        public final void set_resizeToViewport$options_release(boolean z) {
            this._resizeToViewport = z;
        }

        public final boolean get_autoPlay$options_release() {
            return this._autoPlay;
        }

        public final void set_autoPlay$options_release(boolean z) {
            this._autoPlay = z;
        }

        public final boolean get_autoStop$options_release() {
            return this._autoStop;
        }

        public final void set_autoStop$options_release(boolean z) {
            this._autoStop = z;
        }

        public final boolean get_perfMediaRemountInstrumentationFix$options_release() {
            return this._perfMediaRemountInstrumentationFix;
        }

        public final void set_perfMediaRemountInstrumentationFix$options_release(boolean z) {
            this._perfMediaRemountInstrumentationFix = z;
        }

        public final int get_fadeDurationMs$options_release() {
            return this._fadeDurationMs;
        }

        public final void set_fadeDurationMs$options_release(int i) {
            this._fadeDurationMs = i;
        }

        public final ImageOptionsDrawableFactory get_customDrawableFactory$options_release() {
            return this._customDrawableFactory;
        }

        public final void set_customDrawableFactory$options_release(@Nullable ImageOptionsDrawableFactory imageOptionsDrawableFactory) {
            this._customDrawableFactory = imageOptionsDrawableFactory;
        }

        public Builder() {
            this._autoStop = true;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull ImageOptions defaultOptions) {
            super(defaultOptions);
            Intrinsics.checkNotNullParameter(defaultOptions, "defaultOptions");
            this._autoStop = true;
            this._placeholderColor = defaultOptions.getPlaceholderColor();
            this._placeholderRes = defaultOptions.getPlaceholderRes();
            this._placeholderDrawable = defaultOptions.getPlaceholderDrawable();
            this._placeholderScaleType = defaultOptions.getPlaceholderScaleType();
            this._placeholderFocusPoint = defaultOptions.getPlaceholderFocusPoint();
            this._placeholderApplyRoundingOptions = defaultOptions.getPlaceholderApplyRoundingOptions();
            this._progressRes = defaultOptions.getProgressRes();
            this._progressDrawable = defaultOptions.getProgressDrawable();
            this._progressScaleType = defaultOptions.getProgressScaleType();
            this._errorColor = defaultOptions.getErrorColor();
            this._errorRes = defaultOptions.getErrorRes();
            this._errorScaleType = defaultOptions.getErrorScaleType();
            this._errorFocusPoint = defaultOptions.getErrorFocusPoint();
            this._errorDrawable = defaultOptions.getErrorDrawable();
            this._errorApplyRoundingOptions = defaultOptions.getErrorApplyRoundingOptions();
            this._actualImageColorFilter = defaultOptions.getActualImageColorFilter();
            this._overlayRes = defaultOptions.getOverlayRes();
            this._overlayDrawable = defaultOptions.getOverlayDrawable();
            this._resizeToViewport = defaultOptions.shouldResizeToViewport();
            this._autoPlay = defaultOptions.shouldAutoPlay();
            this._autoStop = defaultOptions.shouldAutoStop();
            this._fadeDurationMs = defaultOptions.getFadeDurationMs();
            this._customDrawableFactory = defaultOptions.getCustomDrawableFactory();
        }

        public final Builder placeholder(@Nullable Drawable drawable) {
            this._placeholderDrawable = drawable;
            this._placeholderColor = null;
            this._placeholderRes = 0;
            return this;
        }

        public final Builder placeholder(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
            this._placeholderDrawable = drawable;
            this._placeholderScaleType = scaleType;
            this._placeholderColor = null;
            this._placeholderRes = 0;
            return this;
        }

        public final Builder placeholderColor(@ColorInt int i) {
            this._placeholderColor = Integer.valueOf(i);
            this._placeholderRes = 0;
            this._placeholderDrawable = null;
            return this;
        }

        public final Builder placeholderRes(@DrawableRes int i) {
            this._placeholderRes = i;
            this._placeholderColor = null;
            this._placeholderDrawable = null;
            return this;
        }

        public final Builder placeholderRes(@DrawableRes int i, @Nullable ScalingUtils.ScaleType scaleType) {
            this._placeholderRes = i;
            this._placeholderScaleType = scaleType;
            this._placeholderColor = null;
            this._placeholderDrawable = null;
            return this;
        }

        public final Builder placeholderScaleType(@Nullable ScalingUtils.ScaleType scaleType) {
            this._placeholderScaleType = scaleType;
            return this;
        }

        public final Builder placeholderFocusPoint(@Nullable PointF pointF) {
            this._placeholderFocusPoint = pointF;
            return this;
        }

        public final Builder placeholderApplyRoundingOptions(boolean z) {
            this._placeholderApplyRoundingOptions = z;
            return this;
        }

        public final Builder errorColor(@ColorInt int i) {
            this._errorColor = Integer.valueOf(i);
            this._errorRes = 0;
            this._errorDrawable = null;
            return this;
        }

        public final Builder errorRes(@DrawableRes int i) {
            this._errorColor = null;
            this._errorRes = i;
            this._errorDrawable = null;
            return this;
        }

        public final Builder errorScaleType(@Nullable ScalingUtils.ScaleType scaleType) {
            this._errorScaleType = scaleType;
            return this;
        }

        public final Builder errorFocusPoint(@Nullable PointF pointF) {
            this._errorFocusPoint = pointF;
            return this;
        }

        public final Builder errorDrawable(@Nullable Drawable drawable) {
            this._errorColor = null;
            this._errorRes = 0;
            this._errorDrawable = drawable;
            return this;
        }

        public final Builder errorApplyRoundingOptions(boolean z) {
            this._errorApplyRoundingOptions = z;
            return this;
        }

        public final Builder progress(@Nullable Drawable drawable) {
            this._progressDrawable = drawable;
            return this;
        }

        public final Builder progress(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
            this._progressDrawable = drawable;
            this._progressScaleType = scaleType;
            return this;
        }

        public final Builder progressRes(@DrawableRes int i) {
            this._progressRes = i;
            return this;
        }

        public final Builder progressRes(@DrawableRes int i, @Nullable ScalingUtils.ScaleType scaleType) {
            this._progressRes = i;
            this._progressScaleType = scaleType;
            return this;
        }

        public final Builder progressScaleType(@Nullable ScalingUtils.ScaleType scaleType) {
            this._progressScaleType = scaleType;
            return this;
        }

        public final Builder overlayRes(@DrawableRes int i) {
            this._overlayRes = i;
            this._overlayDrawable = null;
            return this;
        }

        public final Builder overlay(@Nullable Drawable drawable) {
            this._overlayDrawable = drawable;
            this._overlayRes = 0;
            return this;
        }

        public final Builder background(@Nullable Drawable drawable) {
            this._backgroundDrawable = drawable;
            return this;
        }

        public final Builder colorFilter(@Nullable ColorFilter colorFilter) {
            this._actualImageColorFilter = colorFilter;
            return this;
        }

        public final Builder autoPlay(boolean z) {
            this._autoPlay = z;
            return this;
        }

        public final Builder autoStop(boolean z) {
            this._autoStop = z;
            return this;
        }

        public final Builder perfMediaRemountInstrumentationFix(boolean z) {
            this._perfMediaRemountInstrumentationFix = z;
            return this;
        }

        public final Builder resizeToViewport(boolean z) {
            this._resizeToViewport = z;
            return this;
        }

        public final Builder fadeDurationMs(int i) {
            this._fadeDurationMs = i;
            return this;
        }

        public final Builder customDrawableFactory(@Nullable ImageOptionsDrawableFactory imageOptionsDrawableFactory) {
            this._customDrawableFactory = imageOptionsDrawableFactory;
            return this;
        }

        @Override // com.facebook.fresco.vito.options.DecodedImageOptions.Builder, com.facebook.fresco.vito.options.EncodedImageOptions.Builder
        public ImageOptions build() {
            return new ImageOptions(this);
        }

        private final Builder modify(Function1<? super Builder, Unit> function1) {
            function1.invoke(this);
            return this;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ImageOptions defaults() {
            return ImageOptions.defaultImageOptions;
        }

        @JvmStatic
        public final void setDefaults(@NotNull ImageOptions imageOptions) {
            Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
            ImageOptions.defaultImageOptions = imageOptions;
        }

        @JvmStatic
        public final Builder extend(@NotNull ImageOptions imageOptions) {
            Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
            return new Builder(imageOptions);
        }

        @JvmStatic
        public final Builder create() {
            return extend(defaults());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Builder builder = new Builder();
        ScalingUtils.ScaleType scaleType = ScalingUtils.ScaleType.CENTER_INSIDE;
        defaultImageOptions = ((Builder) builder.placeholderScaleType(scaleType).progressScaleType(scaleType).errorScaleType(scaleType).priority(Priority.HIGH)).build();
    }
}
