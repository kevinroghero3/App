package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.Spacing;
import com.facebook.react.uimanager.style.BorderColors;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.ColorEdges;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import com.facebook.react.uimanager.style.LogicalEdge;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class BorderDrawable extends Drawable {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(BorderDrawable.class, "borderStyle", "getBorderStyle()Lcom/facebook/react/uimanager/style/BorderStyle;", 0))};
    private int borderAlpha;
    private Integer[] borderColors;
    private BorderInsets borderInsets;
    private final Paint borderPaint;
    private BorderRadiusStyle borderRadius;
    private final ReadWriteProperty borderStyle$delegate;
    private final Spacing borderWidth;
    private Path centerDrawPath;
    private ColorEdges computedBorderColors;
    private ComputedBorderRadius computedBorderRadius;
    private final Context context;
    private final float gapBetweenPaths;
    private PointF innerBottomLeftCorner;
    private PointF innerBottomRightCorner;
    private Path innerClipPathForBorderRadius;
    private RectF innerClipTempRectForBorderRadius;
    private PointF innerTopLeftCorner;
    private PointF innerTopRightCorner;
    private boolean needUpdatePath;
    private Path outerClipPathForBorderRadius;
    private RectF outerClipTempRectForBorderRadius;
    private Path pathForBorder;
    private Path pathForOutline;
    private Path pathForSingleBorder;
    private RectF tempRectForCenterDrawPath;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BorderStyle.values().length];
            try {
                iArr[BorderStyle.SOLID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BorderStyle.DASHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BorderStyle.DOTTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final int fastBorderCompatibleColorOrZero(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = (i4 > 0 ? i8 : -1) & (i > 0 ? i5 : -1) & (i2 > 0 ? i6 : -1) & (i3 > 0 ? i7 : -1);
        if (i <= 0) {
            i5 = 0;
        }
        if (i2 <= 0) {
            i6 = 0;
        }
        if (i3 <= 0) {
            i7 = 0;
        }
        if (i4 <= 0) {
            i8 = 0;
        }
        if (i9 == (i5 | i6 | i7 | i8)) {
            return i9;
        }
        return 0;
    }

    private final int multiplyColorAlpha(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & ViewCompat.MEASURED_SIZE_MASK;
        }
        return ((((i >>> 24) * ((i2 + (i2 >> 7)) >> 7)) >> 8) << 24) | (16777215 & i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public final Spacing getBorderWidth() {
        return this.borderWidth;
    }

    public final BorderRadiusStyle getBorderRadius() {
        return this.borderRadius;
    }

    public final void setBorderRadius(@Nullable BorderRadiusStyle borderRadiusStyle) {
        this.borderRadius = borderRadiusStyle;
    }

    public final BorderInsets getBorderInsets() {
        return this.borderInsets;
    }

    public final void setBorderInsets(@Nullable BorderInsets borderInsets) {
        this.borderInsets = borderInsets;
    }

    public BorderDrawable(@NotNull Context context, @Nullable Spacing spacing, @Nullable BorderRadiusStyle borderRadiusStyle, @Nullable BorderInsets borderInsets, @Nullable BorderStyle borderStyle) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.borderWidth = spacing;
        this.borderRadius = borderRadiusStyle;
        this.borderInsets = borderInsets;
        this.borderStyle$delegate = invalidatingAndPathChange(borderStyle);
        this.computedBorderColors = new ColorEdges(0, 0, 0, 0, 15, null);
        this.borderAlpha = 255;
        this.gapBetweenPaths = 0.8f;
        this.borderPaint = new Paint(1);
        this.needUpdatePath = true;
    }

    private final <T> ReadWriteProperty<Object, T> invalidatingAndPathChange(T t) {
        return new ObservableProperty<T>(t) { // from class: com.facebook.react.uimanager.drawable.BorderDrawable.invalidatingAndPathChange.1
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, T t2, T t3) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (Intrinsics.areEqual(t2, t3)) {
                    return;
                }
                this.needUpdatePath = true;
                this.invalidateSelf();
            }
        };
    }

    public final BorderStyle getBorderStyle() {
        return (BorderStyle) this.borderStyle$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setBorderStyle(@Nullable BorderStyle borderStyle) {
        this.borderStyle$delegate.setValue(this, $$delegatedProperties[0], borderStyle);
    }

    public final Path getInnerClipPathForBorderRadius() {
        return this.innerClipPathForBorderRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.needUpdatePath = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NotNull Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.needUpdatePath = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.borderAlpha = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        if (ComparisonsKt___ComparisonsJvmKt.maxOf(Color.alpha(multiplyColorAlpha(this.computedBorderColors.getLeft(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getTop(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getRight(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getBottom(), this.borderAlpha))) == 0) {
            return -2;
        }
        return ComparisonsKt___ComparisonsJvmKt.minOf(Color.alpha(multiplyColorAlpha(this.computedBorderColors.getLeft(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getTop(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getRight(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getBottom(), this.borderAlpha))) == 255 ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        ColorEdges colorEdgesM4690resolveimpl;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        updatePathEffect();
        Integer[] numArr = this.borderColors;
        if (numArr == null || (colorEdgesM4690resolveimpl = BorderColors.m4690resolveimpl(numArr, getLayoutDirection(), this.context)) == null) {
            colorEdgesM4690resolveimpl = this.computedBorderColors;
        }
        this.computedBorderColors = colorEdgesM4690resolveimpl;
        BorderRadiusStyle borderRadiusStyle = this.borderRadius;
        if (borderRadiusStyle != null && borderRadiusStyle.hasRoundedBorders()) {
            drawRoundedBorders(canvas);
        } else {
            drawRectangularBorders(canvas);
        }
    }

    private final float getInnerBorderRadius(float f, float f2) {
        return RangesKt___RangesKt.coerceAtLeast(f - f2, 0.0f);
    }

    public final void setBorderWidth(int i, float f) {
        Spacing spacing = this.borderWidth;
        if (FloatUtil.floatsEqual(spacing != null ? Float.valueOf(spacing.getRaw(i)) : null, Float.valueOf(f))) {
            return;
        }
        Spacing spacing2 = this.borderWidth;
        if (spacing2 != null) {
            spacing2.set(i, f);
        }
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) {
            this.needUpdatePath = true;
        }
        invalidateSelf();
    }

    public final void setBorderRadius(@NotNull BorderRadiusProp property, @Nullable LengthPercentage lengthPercentage) {
        Intrinsics.checkNotNullParameter(property, "property");
        BorderRadiusStyle borderRadiusStyle = this.borderRadius;
        if (Intrinsics.areEqual(lengthPercentage, borderRadiusStyle != null ? borderRadiusStyle.get(property) : null)) {
            return;
        }
        BorderRadiusStyle borderRadiusStyle2 = this.borderRadius;
        if (borderRadiusStyle2 != null) {
            borderRadiusStyle2.set(property, lengthPercentage);
        }
        this.needUpdatePath = true;
        invalidateSelf();
    }

    public final void setBorderStyle(@Nullable String str) {
        BorderStyle borderStyleValueOf;
        if (str == null) {
            borderStyleValueOf = null;
        } else {
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            borderStyleValueOf = BorderStyle.valueOf(upperCase);
        }
        setBorderStyle(borderStyleValueOf);
        this.needUpdatePath = true;
        invalidateSelf();
    }

    public final void setBorderColor(@NotNull LogicalEdge position, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(position, "position");
        Integer[] numArrM4686constructorimpl$default = this.borderColors;
        if (numArrM4686constructorimpl$default == null) {
            numArrM4686constructorimpl$default = BorderColors.m4686constructorimpl$default(null, 1, null);
        }
        this.borderColors = numArrM4686constructorimpl$default;
        if (numArrM4686constructorimpl$default != null) {
            numArrM4686constructorimpl$default[position.ordinal()] = num;
        }
        this.needUpdatePath = true;
        invalidateSelf();
    }

    public final int getBorderColor(@NotNull LogicalEdge position) {
        Integer num;
        Intrinsics.checkNotNullParameter(position, "position");
        Integer[] numArr = this.borderColors;
        return (numArr == null || (num = numArr[position.ordinal()]) == null) ? ViewCompat.MEASURED_STATE_MASK : num.intValue();
    }

    public final void invalidateSelfAndUpdatePath() {
        this.needUpdatePath = true;
        invalidateSelf();
    }

    private final void drawRectangularBorders(Canvas canvas) {
        RectF rectFComputeBorderInsets = computeBorderInsets();
        int iRoundToInt = MathKt__MathJVMKt.roundToInt(rectFComputeBorderInsets.left);
        int iRoundToInt2 = MathKt__MathJVMKt.roundToInt(rectFComputeBorderInsets.top);
        int iRoundToInt3 = MathKt__MathJVMKt.roundToInt(rectFComputeBorderInsets.right);
        int iRoundToInt4 = MathKt__MathJVMKt.roundToInt(rectFComputeBorderInsets.bottom);
        if (iRoundToInt > 0 || iRoundToInt3 > 0 || iRoundToInt2 > 0 || iRoundToInt4 > 0) {
            Rect bounds = getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            int i = bounds.left;
            int i2 = bounds.top;
            int iFastBorderCompatibleColorOrZero = fastBorderCompatibleColorOrZero(iRoundToInt, iRoundToInt2, iRoundToInt3, iRoundToInt4, this.computedBorderColors.getLeft(), this.computedBorderColors.getTop(), this.computedBorderColors.getRight(), this.computedBorderColors.getBottom());
            if (iFastBorderCompatibleColorOrZero != 0) {
                if (Color.alpha(iFastBorderCompatibleColorOrZero) != 0) {
                    int i3 = bounds.right;
                    int i4 = bounds.bottom;
                    this.borderPaint.setColor(multiplyColorAlpha(iFastBorderCompatibleColorOrZero, this.borderAlpha));
                    this.borderPaint.setStyle(Paint.Style.STROKE);
                    Path path = new Path();
                    this.pathForSingleBorder = path;
                    if (iRoundToInt > 0) {
                        path.reset();
                        int iRoundToInt5 = MathKt__MathJVMKt.roundToInt(rectFComputeBorderInsets.left);
                        updatePathEffect(iRoundToInt5);
                        this.borderPaint.setStrokeWidth(iRoundToInt5);
                        Path path2 = this.pathForSingleBorder;
                        if (path2 != null) {
                            path2.moveTo(i + (iRoundToInt5 / 2), i2);
                        }
                        Path path3 = this.pathForSingleBorder;
                        if (path3 != null) {
                            path3.lineTo(i + (iRoundToInt5 / 2), i4);
                        }
                        Path path4 = this.pathForSingleBorder;
                        if (path4 != null) {
                            canvas.drawPath(path4, this.borderPaint);
                        }
                    }
                    if (iRoundToInt2 > 0) {
                        Path path5 = this.pathForSingleBorder;
                        if (path5 != null) {
                            path5.reset();
                        }
                        int iRoundToInt6 = MathKt__MathJVMKt.roundToInt(rectFComputeBorderInsets.top);
                        updatePathEffect(iRoundToInt6);
                        this.borderPaint.setStrokeWidth(iRoundToInt6);
                        Path path6 = this.pathForSingleBorder;
                        if (path6 != null) {
                            path6.moveTo(i, i2 + (iRoundToInt6 / 2));
                        }
                        Path path7 = this.pathForSingleBorder;
                        if (path7 != null) {
                            path7.lineTo(i3, i2 + (iRoundToInt6 / 2));
                        }
                        Path path8 = this.pathForSingleBorder;
                        if (path8 != null) {
                            canvas.drawPath(path8, this.borderPaint);
                        }
                    }
                    if (iRoundToInt3 > 0) {
                        Path path9 = this.pathForSingleBorder;
                        if (path9 != null) {
                            path9.reset();
                        }
                        int iRoundToInt7 = MathKt__MathJVMKt.roundToInt(rectFComputeBorderInsets.right);
                        updatePathEffect(iRoundToInt7);
                        this.borderPaint.setStrokeWidth(iRoundToInt7);
                        Path path10 = this.pathForSingleBorder;
                        if (path10 != null) {
                            path10.moveTo(i3 - (iRoundToInt7 / 2), i2);
                        }
                        Path path11 = this.pathForSingleBorder;
                        if (path11 != null) {
                            path11.lineTo(i3 - (iRoundToInt7 / 2), i4);
                        }
                        Path path12 = this.pathForSingleBorder;
                        if (path12 != null) {
                            canvas.drawPath(path12, this.borderPaint);
                        }
                    }
                    if (iRoundToInt4 > 0) {
                        Path path13 = this.pathForSingleBorder;
                        if (path13 != null) {
                            path13.reset();
                        }
                        int iRoundToInt8 = MathKt__MathJVMKt.roundToInt(rectFComputeBorderInsets.bottom);
                        updatePathEffect(iRoundToInt8);
                        this.borderPaint.setStrokeWidth(iRoundToInt8);
                        Path path14 = this.pathForSingleBorder;
                        if (path14 != null) {
                            path14.moveTo(i, i4 - (iRoundToInt8 / 2));
                        }
                        Path path15 = this.pathForSingleBorder;
                        if (path15 != null) {
                            path15.lineTo(i3, i4 - (iRoundToInt8 / 2));
                        }
                        Path path16 = this.pathForSingleBorder;
                        if (path16 != null) {
                            canvas.drawPath(path16, this.borderPaint);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            this.borderPaint.setAntiAlias(false);
            int iWidth = bounds.width();
            int iHeight = bounds.height();
            if (iRoundToInt > 0) {
                float f = i;
                float f2 = i2;
                float f3 = i + iRoundToInt;
                int i5 = i2 + iHeight;
                drawQuadrilateral(canvas, this.computedBorderColors.getLeft(), f, f2, f3, i2 + iRoundToInt2, f3, i5 - iRoundToInt4, f, i5);
            }
            if (iRoundToInt2 > 0) {
                float f4 = i;
                float f5 = i2;
                float f6 = i + iRoundToInt;
                float f7 = i2 + iRoundToInt2;
                int i6 = i + iWidth;
                drawQuadrilateral(canvas, this.computedBorderColors.getTop(), f4, f5, f6, f7, i6 - iRoundToInt3, f7, i6, f5);
            }
            if (iRoundToInt3 > 0) {
                int i7 = i + iWidth;
                float f8 = i7;
                float f9 = i2;
                int i8 = i2 + iHeight;
                float f10 = i7 - iRoundToInt3;
                drawQuadrilateral(canvas, this.computedBorderColors.getRight(), f8, f9, f8, i8, f10, i8 - iRoundToInt4, f10, i2 + iRoundToInt2);
            }
            if (iRoundToInt4 > 0) {
                float f11 = i;
                int i9 = i2 + iHeight;
                float f12 = i9;
                int i10 = i + iWidth;
                float f13 = i9 - iRoundToInt4;
                drawQuadrilateral(canvas, this.computedBorderColors.getBottom(), f11, f12, i10, f12, i10 - iRoundToInt3, f13, i + iRoundToInt, f13);
            }
            this.borderPaint.setAntiAlias(true);
        }
    }

    private final void drawRoundedBorders(Canvas canvas) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3;
        PointF pointF4;
        CornerRadii topLeft;
        CornerRadii pixelFromDIP;
        CornerRadii topLeft2;
        CornerRadii pixelFromDIP2;
        updatePath();
        canvas.save();
        Path path = this.outerClipPathForBorderRadius;
        if (path == null) {
            throw new IllegalStateException("Required value was null.");
        }
        canvas.clipPath(path);
        RectF rectFComputeBorderInsets = computeBorderInsets();
        float vertical = 0.0f;
        if (rectFComputeBorderInsets.top > 0.0f || rectFComputeBorderInsets.bottom > 0.0f || rectFComputeBorderInsets.left > 0.0f || rectFComputeBorderInsets.right > 0.0f) {
            float fullBorderWidth = getFullBorderWidth();
            int borderColor = getBorderColor(LogicalEdge.ALL);
            if (rectFComputeBorderInsets.top != fullBorderWidth || rectFComputeBorderInsets.bottom != fullBorderWidth || rectFComputeBorderInsets.left != fullBorderWidth || rectFComputeBorderInsets.right != fullBorderWidth || this.computedBorderColors.getLeft() != borderColor || this.computedBorderColors.getTop() != borderColor || this.computedBorderColors.getRight() != borderColor || this.computedBorderColors.getBottom() != borderColor) {
                this.borderPaint.setStyle(Paint.Style.FILL);
                if (Build.VERSION.SDK_INT >= 26) {
                    Path path2 = this.innerClipPathForBorderRadius;
                    if (path2 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    canvas.clipOutPath(path2);
                } else {
                    Path path3 = this.innerClipPathForBorderRadius;
                    if (path3 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    canvas.clipPath(path3, Region.Op.DIFFERENCE);
                }
                RectF rectF = this.outerClipTempRectForBorderRadius;
                if (rectF == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                float f = rectF.left;
                float f2 = rectF.right;
                float f3 = rectF.top;
                float f4 = rectF.bottom;
                PointF pointF5 = this.innerTopLeftCorner;
                if (pointF5 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                PointF pointF6 = this.innerTopRightCorner;
                if (pointF6 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                PointF pointF7 = this.innerBottomLeftCorner;
                if (pointF7 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                PointF pointF8 = this.innerBottomRightCorner;
                if (pointF8 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                if (rectFComputeBorderInsets.left > 0.0f) {
                    float f5 = this.gapBetweenPaths;
                    pointF = pointF8;
                    pointF2 = pointF6;
                    drawQuadrilateral(canvas, this.computedBorderColors.getLeft(), f, f3 - f5, pointF5.x, pointF5.y - f5, pointF7.x, pointF7.y + f5, f, f4 + f5);
                } else {
                    pointF = pointF8;
                    pointF2 = pointF6;
                }
                if (rectFComputeBorderInsets.top > 0.0f) {
                    float f6 = this.gapBetweenPaths;
                    pointF3 = pointF2;
                    drawQuadrilateral(canvas, this.computedBorderColors.getTop(), f - f6, f3, pointF5.x - f6, pointF5.y, pointF3.x + f6, pointF3.y, f2 + f6, f3);
                } else {
                    pointF3 = pointF2;
                }
                if (rectFComputeBorderInsets.right > 0.0f) {
                    float f7 = this.gapBetweenPaths;
                    float f8 = pointF3.x;
                    float f9 = pointF3.y;
                    pointF4 = pointF;
                    drawQuadrilateral(canvas, this.computedBorderColors.getRight(), f2, f3 - f7, f8, f9 - f7, pointF4.x, pointF4.y + f7, f2, f4 + f7);
                } else {
                    pointF4 = pointF;
                }
                if (rectFComputeBorderInsets.bottom > 0.0f) {
                    float f10 = this.gapBetweenPaths;
                    drawQuadrilateral(canvas, this.computedBorderColors.getBottom(), f - f10, f4, pointF7.x - f10, pointF7.y, pointF4.x + f10, pointF4.y, f2 + f10, f4);
                }
            } else if (fullBorderWidth > 0.0f) {
                this.borderPaint.setColor(multiplyColorAlpha(borderColor, this.borderAlpha));
                this.borderPaint.setStyle(Paint.Style.STROKE);
                this.borderPaint.setStrokeWidth(fullBorderWidth);
                ComputedBorderRadius computedBorderRadius = this.computedBorderRadius;
                if (computedBorderRadius != null && computedBorderRadius.isUniform()) {
                    RectF rectF2 = this.tempRectForCenterDrawPath;
                    if (rectF2 != null) {
                        ComputedBorderRadius computedBorderRadius2 = this.computedBorderRadius;
                        float horizontal = (computedBorderRadius2 == null || (topLeft2 = computedBorderRadius2.getTopLeft()) == null || (pixelFromDIP2 = topLeft2.toPixelFromDIP()) == null) ? 0.0f : pixelFromDIP2.getHorizontal();
                        float f11 = rectFComputeBorderInsets.left;
                        ComputedBorderRadius computedBorderRadius3 = this.computedBorderRadius;
                        if (computedBorderRadius3 != null && (topLeft = computedBorderRadius3.getTopLeft()) != null && (pixelFromDIP = topLeft.toPixelFromDIP()) != null) {
                            vertical = pixelFromDIP.getVertical();
                        }
                        canvas.drawRoundRect(rectF2, horizontal - (f11 * 0.5f), vertical - (rectFComputeBorderInsets.top * 0.5f), this.borderPaint);
                    }
                } else {
                    Path path4 = this.centerDrawPath;
                    if (path4 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    canvas.drawPath(path4, this.borderPaint);
                }
            }
        }
        canvas.restore();
    }

    private final void drawQuadrilateral(Canvas canvas, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (i == 0) {
            return;
        }
        if (this.pathForBorder == null) {
            this.pathForBorder = new Path();
        }
        this.borderPaint.setColor(multiplyColorAlpha(i, this.borderAlpha));
        Path path = this.pathForBorder;
        if (path != null) {
            path.reset();
        }
        Path path2 = this.pathForBorder;
        if (path2 != null) {
            path2.moveTo(f, f2);
        }
        Path path3 = this.pathForBorder;
        if (path3 != null) {
            path3.lineTo(f3, f4);
        }
        Path path4 = this.pathForBorder;
        if (path4 != null) {
            path4.lineTo(f5, f6);
        }
        Path path5 = this.pathForBorder;
        if (path5 != null) {
            path5.lineTo(f7, f8);
        }
        Path path6 = this.pathForBorder;
        if (path6 != null) {
            path6.lineTo(f, f2);
        }
        Path path7 = this.pathForBorder;
        if (path7 != null) {
            canvas.drawPath(path7, this.borderPaint);
        }
    }

    private final RectF computeBorderInsets() {
        RectF rectFResolve;
        BorderInsets borderInsets = this.borderInsets;
        if (borderInsets != null && (rectFResolve = borderInsets.resolve(getLayoutDirection(), this.context)) != null) {
            return new RectF(Float.isNaN(rectFResolve.left) ? 0.0f : PixelUtil.INSTANCE.dpToPx(rectFResolve.left), Float.isNaN(rectFResolve.top) ? 0.0f : PixelUtil.INSTANCE.dpToPx(rectFResolve.top), Float.isNaN(rectFResolve.right) ? 0.0f : PixelUtil.INSTANCE.dpToPx(rectFResolve.right), Float.isNaN(rectFResolve.bottom) ? 0.0f : PixelUtil.INSTANCE.dpToPx(rectFResolve.bottom));
        }
        return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    private final float getFullBorderWidth() {
        Spacing spacing = this.borderWidth;
        float raw = spacing != null ? spacing.getRaw(8) : Float.NaN;
        if (Float.isNaN(raw)) {
            return 0.0f;
        }
        return raw;
    }

    private final void updatePathEffect() {
        BorderStyle borderStyle = getBorderStyle();
        if (borderStyle != null) {
            this.borderPaint.setPathEffect(getBorderStyle() != null ? getPathEffect(borderStyle, getFullBorderWidth()) : null);
        }
    }

    private final void updatePathEffect(int i) {
        BorderStyle borderStyle = getBorderStyle();
        if (borderStyle != null) {
            this.borderPaint.setPathEffect(getBorderStyle() != null ? getPathEffect(borderStyle, i) : null);
        }
    }

    private final PathEffect getPathEffect(BorderStyle borderStyle, float f) {
        int i = WhenMappings.$EnumSwitchMapping$0[borderStyle.ordinal()];
        if (i == 1) {
            return null;
        }
        if (i == 2) {
            float f2 = f * 3;
            return new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
        }
        if (i == 3) {
            return new DashPathEffect(new float[]{f, f, f, f}, 0.0f);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void getEllipseIntersectionWithLine(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, PointF pointF) {
        double d9 = 2;
        double d10 = (d + d3) / d9;
        double d11 = (d2 + d4) / d9;
        double d12 = d5 - d10;
        double d13 = d6 - d11;
        double dAbs = Math.abs(d3 - d) / d9;
        double dAbs2 = Math.abs(d4 - d2) / d9;
        double d14 = ((d8 - d11) - d13) / ((d7 - d10) - d12);
        double d15 = d13 - (d12 * d14);
        double d16 = dAbs2 * dAbs2;
        double d17 = dAbs * dAbs;
        double d18 = d16 + (d17 * d14 * d14);
        double d19 = d9 * dAbs * dAbs * d15 * d14;
        double d20 = d9 * d18;
        double dSqrt = ((-d19) / d20) - Math.sqrt(((-(d17 * ((d15 * d15) - d16))) / d18) + Math.pow(d19 / d20, 2.0d));
        double d21 = d10 + dSqrt;
        double d22 = (d14 * dSqrt) + d15 + d11;
        if (Double.isNaN(d21) || Double.isNaN(d22)) {
            return;
        }
        pointF.x = (float) d21;
        pointF.y = (float) d22;
    }

    /* JADX WARN: Code duplicated, block: B:155:0x037e  */
    private final void updatePath() {
        ComputedBorderRadius computedBorderRadiusResolve;
        CornerRadii cornerRadii;
        CornerRadii cornerRadii2;
        CornerRadii cornerRadii3;
        CornerRadii cornerRadii4;
        Path path;
        Path path2;
        Path path3;
        CornerRadii bottomRight;
        CornerRadii bottomLeft;
        CornerRadii topRight;
        CornerRadii topLeft;
        if (this.needUpdatePath) {
            this.needUpdatePath = false;
            Path path4 = this.innerClipPathForBorderRadius;
            if (path4 == null) {
                path4 = new Path();
            }
            this.innerClipPathForBorderRadius = path4;
            Path path5 = this.outerClipPathForBorderRadius;
            if (path5 == null) {
                path5 = new Path();
            }
            this.outerClipPathForBorderRadius = path5;
            this.pathForOutline = new Path();
            RectF rectF = this.innerClipTempRectForBorderRadius;
            if (rectF == null) {
                rectF = new RectF();
            }
            this.innerClipTempRectForBorderRadius = rectF;
            RectF rectF2 = this.outerClipTempRectForBorderRadius;
            if (rectF2 == null) {
                rectF2 = new RectF();
            }
            this.outerClipTempRectForBorderRadius = rectF2;
            RectF rectF3 = this.tempRectForCenterDrawPath;
            if (rectF3 == null) {
                rectF3 = new RectF();
            }
            this.tempRectForCenterDrawPath = rectF3;
            Path path6 = this.innerClipPathForBorderRadius;
            if (path6 != null) {
                path6.reset();
                Unit unit = Unit.INSTANCE;
            }
            Path path7 = this.outerClipPathForBorderRadius;
            if (path7 != null) {
                path7.reset();
                Unit unit2 = Unit.INSTANCE;
            }
            RectF rectF4 = this.innerClipTempRectForBorderRadius;
            if (rectF4 != null) {
                rectF4.set(getBounds());
                Unit unit3 = Unit.INSTANCE;
            }
            RectF rectF5 = this.outerClipTempRectForBorderRadius;
            if (rectF5 != null) {
                rectF5.set(getBounds());
                Unit unit4 = Unit.INSTANCE;
            }
            RectF rectF6 = this.tempRectForCenterDrawPath;
            if (rectF6 != null) {
                rectF6.set(getBounds());
                Unit unit5 = Unit.INSTANCE;
            }
            RectF rectFComputeBorderInsets = computeBorderInsets();
            if (Color.alpha(this.computedBorderColors.getLeft()) != 0 || Color.alpha(this.computedBorderColors.getTop()) != 0 || Color.alpha(this.computedBorderColors.getRight()) != 0 || Color.alpha(this.computedBorderColors.getBottom()) != 0) {
                RectF rectF7 = this.innerClipTempRectForBorderRadius;
                if (rectF7 != null) {
                    rectF7.top = rectF7 != null ? rectF7.top + rectFComputeBorderInsets.top : 0.0f;
                    Unit unit6 = Unit.INSTANCE;
                }
                if (rectF7 != null) {
                    rectF7.bottom = rectF7 != null ? rectF7.bottom - rectFComputeBorderInsets.bottom : 0.0f;
                    Unit unit7 = Unit.INSTANCE;
                }
                if (rectF7 != null) {
                    rectF7.left = rectF7 != null ? rectF7.left + rectFComputeBorderInsets.left : 0.0f;
                    Unit unit8 = Unit.INSTANCE;
                }
                if (rectF7 != null) {
                    rectF7.right = rectF7 != null ? rectF7.right - rectFComputeBorderInsets.right : 0.0f;
                    Unit unit9 = Unit.INSTANCE;
                }
            }
            RectF rectF8 = this.tempRectForCenterDrawPath;
            if (rectF8 != null) {
                rectF8.top = rectF8 != null ? rectF8.top + (rectFComputeBorderInsets.top * 0.5f) : 0.0f;
                Unit unit10 = Unit.INSTANCE;
            }
            if (rectF8 != null) {
                rectF8.bottom = rectF8 != null ? rectF8.bottom - (rectFComputeBorderInsets.bottom * 0.5f) : 0.0f;
                Unit unit11 = Unit.INSTANCE;
            }
            if (rectF8 != null) {
                rectF8.left = rectF8 != null ? rectF8.left + (rectFComputeBorderInsets.left * 0.5f) : 0.0f;
                Unit unit12 = Unit.INSTANCE;
            }
            if (rectF8 != null) {
                rectF8.right = rectF8 != null ? rectF8.right - (rectFComputeBorderInsets.right * 0.5f) : 0.0f;
                Unit unit13 = Unit.INSTANCE;
            }
            BorderRadiusStyle borderRadiusStyle = this.borderRadius;
            if (borderRadiusStyle != null) {
                int layoutDirection = getLayoutDirection();
                Context context = this.context;
                RectF rectF9 = this.outerClipTempRectForBorderRadius;
                float fPxToDp = rectF9 != null ? PixelUtil.INSTANCE.pxToDp(rectF9.width()) : 0.0f;
                RectF rectF10 = this.outerClipTempRectForBorderRadius;
                computedBorderRadiusResolve = borderRadiusStyle.resolve(layoutDirection, context, fPxToDp, rectF10 != null ? PixelUtil.INSTANCE.pxToDp(rectF10.height()) : 0.0f);
            } else {
                computedBorderRadiusResolve = null;
            }
            this.computedBorderRadius = computedBorderRadiusResolve;
            if (computedBorderRadiusResolve == null || (topLeft = computedBorderRadiusResolve.getTopLeft()) == null || (cornerRadii = topLeft.toPixelFromDIP()) == null) {
                cornerRadii = new CornerRadii(0.0f, 0.0f);
            }
            ComputedBorderRadius computedBorderRadius = this.computedBorderRadius;
            if (computedBorderRadius == null || (topRight = computedBorderRadius.getTopRight()) == null || (cornerRadii2 = topRight.toPixelFromDIP()) == null) {
                cornerRadii2 = new CornerRadii(0.0f, 0.0f);
            }
            ComputedBorderRadius computedBorderRadius2 = this.computedBorderRadius;
            if (computedBorderRadius2 == null || (bottomLeft = computedBorderRadius2.getBottomLeft()) == null || (cornerRadii3 = bottomLeft.toPixelFromDIP()) == null) {
                cornerRadii3 = new CornerRadii(0.0f, 0.0f);
            }
            ComputedBorderRadius computedBorderRadius3 = this.computedBorderRadius;
            if (computedBorderRadius3 == null || (bottomRight = computedBorderRadius3.getBottomRight()) == null || (cornerRadii4 = bottomRight.toPixelFromDIP()) == null) {
                cornerRadii4 = new CornerRadii(0.0f, 0.0f);
            }
            float innerBorderRadius = getInnerBorderRadius(cornerRadii.getHorizontal(), rectFComputeBorderInsets.left);
            float innerBorderRadius2 = getInnerBorderRadius(cornerRadii.getVertical(), rectFComputeBorderInsets.top);
            float innerBorderRadius3 = getInnerBorderRadius(cornerRadii2.getHorizontal(), rectFComputeBorderInsets.right);
            float innerBorderRadius4 = getInnerBorderRadius(cornerRadii2.getVertical(), rectFComputeBorderInsets.top);
            float innerBorderRadius5 = getInnerBorderRadius(cornerRadii4.getHorizontal(), rectFComputeBorderInsets.right);
            float innerBorderRadius6 = getInnerBorderRadius(cornerRadii4.getVertical(), rectFComputeBorderInsets.bottom);
            float innerBorderRadius7 = getInnerBorderRadius(cornerRadii3.getHorizontal(), rectFComputeBorderInsets.left);
            float innerBorderRadius8 = getInnerBorderRadius(cornerRadii3.getVertical(), rectFComputeBorderInsets.bottom);
            RectF rectF11 = this.innerClipTempRectForBorderRadius;
            if (rectF11 != null && (path3 = this.innerClipPathForBorderRadius) != null) {
                path3.addRoundRect(rectF11, new float[]{innerBorderRadius, innerBorderRadius2, innerBorderRadius3, innerBorderRadius4, innerBorderRadius5, innerBorderRadius6, innerBorderRadius7, innerBorderRadius8}, Path.Direction.CW);
                Unit unit14 = Unit.INSTANCE;
            }
            RectF rectF12 = this.outerClipTempRectForBorderRadius;
            if (rectF12 != null && (path2 = this.outerClipPathForBorderRadius) != null) {
                path2.addRoundRect(rectF12, new float[]{cornerRadii.getHorizontal(), cornerRadii.getVertical(), cornerRadii2.getHorizontal(), cornerRadii2.getVertical(), cornerRadii4.getHorizontal(), cornerRadii4.getVertical(), cornerRadii3.getHorizontal(), cornerRadii3.getVertical()}, Path.Direction.CW);
                Unit unit15 = Unit.INSTANCE;
            }
            Spacing spacing = this.borderWidth;
            float f = spacing != null ? spacing.get(8) / 2.0f : 0.0f;
            Path path8 = this.pathForOutline;
            if (path8 != null) {
                path8.addRoundRect(new RectF(getBounds()), new float[]{cornerRadii.getHorizontal() + f, cornerRadii.getVertical() + f, cornerRadii2.getHorizontal() + f, cornerRadii2.getVertical() + f, cornerRadii4.getHorizontal() + f, cornerRadii4.getVertical() + f, cornerRadii3.getHorizontal() + f, cornerRadii3.getVertical() + f}, Path.Direction.CW);
                Unit unit16 = Unit.INSTANCE;
            }
            ComputedBorderRadius computedBorderRadius4 = this.computedBorderRadius;
            if (computedBorderRadius4 == null || !computedBorderRadius4.isUniform()) {
                Path path9 = this.centerDrawPath;
                if (path9 == null) {
                    path9 = new Path();
                }
                this.centerDrawPath = path9;
                path9.reset();
                Unit unit17 = Unit.INSTANCE;
                RectF rectF13 = this.tempRectForCenterDrawPath;
                if (rectF13 != null && (path = this.centerDrawPath) != null) {
                    path.addRoundRect(rectF13, new float[]{cornerRadii.getHorizontal() - (rectFComputeBorderInsets.left * 0.5f), cornerRadii.getVertical() - (rectFComputeBorderInsets.top * 0.5f), cornerRadii2.getHorizontal() - (rectFComputeBorderInsets.right * 0.5f), cornerRadii2.getVertical() - (rectFComputeBorderInsets.top * 0.5f), cornerRadii4.getHorizontal() - (rectFComputeBorderInsets.right * 0.5f), cornerRadii4.getVertical() - (rectFComputeBorderInsets.bottom * 0.5f), cornerRadii3.getHorizontal() - (rectFComputeBorderInsets.left * 0.5f), cornerRadii3.getVertical() - (rectFComputeBorderInsets.bottom * 0.5f)}, Path.Direction.CW);
                    Unit unit18 = Unit.INSTANCE;
                }
            }
            RectF rectF14 = this.innerClipTempRectForBorderRadius;
            RectF rectF15 = this.outerClipTempRectForBorderRadius;
            if (rectF14 == null || rectF15 == null) {
                return;
            }
            PointF pointF = this.innerTopLeftCorner;
            if (pointF == null) {
                pointF = new PointF();
            }
            PointF pointF2 = pointF;
            this.innerTopLeftCorner = pointF2;
            pointF2.x = rectF14.left;
            Unit unit19 = Unit.INSTANCE;
            pointF2.y = rectF14.top;
            Unit unit20 = Unit.INSTANCE;
            float f2 = rectF14.left;
            double d = f2;
            float f3 = rectF14.top;
            double d2 = f3;
            float f4 = 2;
            getEllipseIntersectionWithLine(d, d2, (innerBorderRadius * f4) + f2, (f4 * innerBorderRadius2) + f3, rectF15.left, rectF15.top, d, d2, pointF2);
            Unit unit21 = Unit.INSTANCE;
            PointF pointF3 = this.innerBottomLeftCorner;
            if (pointF3 == null) {
                pointF3 = new PointF();
            }
            PointF pointF4 = pointF3;
            this.innerBottomLeftCorner = pointF4;
            pointF4.x = rectF14.left;
            Unit unit22 = Unit.INSTANCE;
            pointF4.y = rectF14.bottom;
            Unit unit23 = Unit.INSTANCE;
            float f5 = rectF14.left;
            double d3 = f5;
            float f6 = rectF14.bottom;
            double d4 = f6;
            getEllipseIntersectionWithLine(d3, f6 - (innerBorderRadius8 * f4), (f4 * innerBorderRadius7) + f5, d4, rectF15.left, rectF15.bottom, d3, d4, pointF4);
            Unit unit24 = Unit.INSTANCE;
            PointF pointF5 = this.innerTopRightCorner;
            if (pointF5 == null) {
                pointF5 = new PointF();
            }
            PointF pointF6 = pointF5;
            this.innerTopRightCorner = pointF6;
            pointF6.x = rectF14.right;
            Unit unit25 = Unit.INSTANCE;
            pointF6.y = rectF14.top;
            Unit unit26 = Unit.INSTANCE;
            float f7 = rectF14.right;
            double d5 = f7 - (innerBorderRadius3 * f4);
            float f8 = rectF14.top;
            double d6 = f8;
            double d7 = f7;
            getEllipseIntersectionWithLine(d5, d6, d7, (f4 * innerBorderRadius4) + f8, rectF15.right, rectF15.top, d7, d6, pointF6);
            Unit unit27 = Unit.INSTANCE;
            PointF pointF7 = this.innerBottomRightCorner;
            if (pointF7 == null) {
                pointF7 = new PointF();
            }
            PointF pointF8 = pointF7;
            this.innerBottomRightCorner = pointF8;
            pointF8.x = rectF14.right;
            Unit unit28 = Unit.INSTANCE;
            pointF8.y = rectF14.bottom;
            Unit unit29 = Unit.INSTANCE;
            float f9 = rectF14.right;
            double d8 = f9 - (innerBorderRadius5 * f4);
            float f10 = rectF14.bottom;
            double d9 = f10 - (f4 * innerBorderRadius6);
            double d10 = f9;
            double d11 = f10;
            getEllipseIntersectionWithLine(d8, d9, d10, d11, rectF15.right, rectF15.bottom, d10, d11, pointF8);
            Unit unit30 = Unit.INSTANCE;
        }
    }
}
