package com.facebook.react.uimanager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.drawable.BackgroundDrawable;
import com.facebook.react.uimanager.drawable.BorderDrawable;
import com.facebook.react.uimanager.drawable.CSSBackgroundDrawable;
import com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable;
import com.facebook.react.uimanager.drawable.InsetBoxShadowDrawable;
import com.facebook.react.uimanager.drawable.OutlineDrawable;
import com.facebook.react.uimanager.drawable.OutsetBoxShadowDrawable;
import com.facebook.react.uimanager.style.BackgroundImageLayer;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.BoxShadow;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.uimanager.style.OutlineStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class BackgroundStyleApplicator {
    public static final BackgroundStyleApplicator INSTANCE = new BackgroundStyleApplicator();

    private BackgroundStyleApplicator() {
    }

    @JvmStatic
    public static final void setBackgroundColor(@NotNull View view, @ColorInt @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        if ((num == null || num.intValue() == 0) && !(view.getBackground() instanceof CompositeBackgroundDrawable)) {
            return;
        }
        if (ReactNativeFeatureFlags.enableNewBackgroundAndBorderDrawables()) {
            INSTANCE.ensureBackgroundDrawable(view).setBackgroundColor(num != null ? num.intValue() : 0);
        } else {
            INSTANCE.ensureCSSBackground(view).setColor(num != null ? num.intValue() : 0);
        }
    }

    @JvmStatic
    public static final void setBackgroundImage(@NotNull View view, @Nullable List<BackgroundImageLayer> list) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ReactNativeFeatureFlags.enableNewBackgroundAndBorderDrawables()) {
            INSTANCE.ensureBackgroundDrawable(view).setBackgroundImageLayers(list);
        } else {
            INSTANCE.ensureCSSBackground(view).setBackgroundImage(list);
        }
    }

    @JvmStatic
    public static final Integer getBackgroundColor(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ReactNativeFeatureFlags.enableNewBackgroundAndBorderDrawables()) {
            BackgroundDrawable background = INSTANCE.getBackground(view);
            if (background != null) {
                return Integer.valueOf(background.getBackgroundColor());
            }
        } else {
            CSSBackgroundDrawable cSSBackground = INSTANCE.getCSSBackground(view);
            if (cSSBackground != null) {
                return Integer.valueOf(cSSBackground.getColor());
            }
        }
        return null;
    }

    @JvmStatic
    public static final void setBorderWidth(@NotNull View view, @NotNull LogicalEdge edge, @Nullable Float f) {
        LayerDrawable innerShadows;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(edge, "edge");
        BackgroundStyleApplicator backgroundStyleApplicator = INSTANCE;
        CompositeBackgroundDrawable compositeBackgroundDrawableEnsureCompositeBackgroundDrawable = backgroundStyleApplicator.ensureCompositeBackgroundDrawable(view);
        BorderInsets borderInsets = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets();
        if (borderInsets == null) {
            borderInsets = new BorderInsets();
        }
        compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.setBorderInsets(borderInsets);
        BorderInsets borderInsets2 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets();
        if (borderInsets2 != null) {
            borderInsets2.setBorderWidth(edge, f);
        }
        if (ReactNativeFeatureFlags.enableNewBackgroundAndBorderDrawables()) {
            backgroundStyleApplicator.ensureBorderDrawable(view).setBorderWidth(edge.toSpacingType(), f != null ? PixelUtil.INSTANCE.dpToPx(f.floatValue()) : Float.NaN);
            BackgroundDrawable background = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBackground();
            if (background != null) {
                background.setBorderInsets(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets());
            }
            BorderDrawable border = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorder();
            if (border != null) {
                border.setBorderInsets(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets());
            }
            BackgroundDrawable background2 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBackground();
            if (background2 != null) {
                background2.invalidateSelf();
            }
            BorderDrawable border2 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorder();
            if (border2 != null) {
                border2.invalidateSelf();
            }
        } else {
            backgroundStyleApplicator.ensureCSSBackground(view).setBorderWidth(edge.toSpacingType(), f != null ? PixelUtil.INSTANCE.dpToPx(f.floatValue()) : Float.NaN);
        }
        BorderInsets borderInsets3 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets();
        if (borderInsets3 == null) {
            borderInsets3 = new BorderInsets();
        }
        compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.setBorderInsets(borderInsets3);
        BorderInsets borderInsets4 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets();
        if (borderInsets4 != null) {
            borderInsets4.setBorderWidth(edge, f);
        }
        if (Build.VERSION.SDK_INT < 29 || (innerShadows = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getInnerShadows()) == null) {
            return;
        }
        int numberOfLayers = innerShadows.getNumberOfLayers();
        for (int i = 0; i < numberOfLayers; i++) {
            Drawable drawable = innerShadows.getDrawable(i);
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.facebook.react.uimanager.drawable.InsetBoxShadowDrawable");
            InsetBoxShadowDrawable insetBoxShadowDrawable = (InsetBoxShadowDrawable) drawable;
            insetBoxShadowDrawable.setBorderInsets(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets());
            insetBoxShadowDrawable.invalidateSelf();
        }
    }

    @JvmStatic
    public static final Float getBorderWidth(@NotNull View view, @NotNull LogicalEdge edge) {
        Spacing borderWidth;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(edge, "edge");
        if (ReactNativeFeatureFlags.enableNewBackgroundAndBorderDrawables()) {
            BorderDrawable border = INSTANCE.getBorder(view);
            Float fValueOf = (border == null || (borderWidth = border.getBorderWidth()) == null) ? null : Float.valueOf(borderWidth.getRaw(edge.toSpacingType()));
            if (fValueOf == null || Float.isNaN(fValueOf.floatValue())) {
                return null;
            }
            return Float.valueOf(PixelUtil.INSTANCE.pxToDp(fValueOf.floatValue()));
        }
        CSSBackgroundDrawable cSSBackground = INSTANCE.getCSSBackground(view);
        Float borderWidth2 = cSSBackground != null ? cSSBackground.getBorderWidth(edge.toSpacingType()) : null;
        if (borderWidth2 == null || Float.isNaN(borderWidth2.floatValue())) {
            return null;
        }
        return Float.valueOf(PixelUtil.INSTANCE.pxToDp(borderWidth2.floatValue()));
    }

    @JvmStatic
    public static final void setBorderColor(@NotNull View view, @NotNull LogicalEdge edge, @ColorInt @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(edge, "edge");
        if (ReactNativeFeatureFlags.enableNewBackgroundAndBorderDrawables()) {
            INSTANCE.ensureBorderDrawable(view).setBorderColor(edge, num);
        } else {
            INSTANCE.ensureCSSBackground(view).setBorderColor(edge.toSpacingType(), num);
        }
    }

    @JvmStatic
    public static final Integer getBorderColor(@NotNull View view, @NotNull LogicalEdge edge) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(edge, "edge");
        if (ReactNativeFeatureFlags.enableNewBackgroundAndBorderDrawables()) {
            BorderDrawable border = INSTANCE.getBorder(view);
            if (border != null) {
                return Integer.valueOf(border.getBorderColor(edge));
            }
        } else {
            CSSBackgroundDrawable cSSBackground = INSTANCE.getCSSBackground(view);
            if (cSSBackground != null) {
                return Integer.valueOf(cSSBackground.getBorderColor(edge.toSpacingType()));
            }
        }
        return null;
    }

    @JvmStatic
    public static final void setBorderRadius(@NotNull View view, @NotNull BorderRadiusProp corner, @Nullable LengthPercentage lengthPercentage) {
        LayerDrawable innerShadows;
        LayerDrawable outerShadows;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(corner, "corner");
        BackgroundStyleApplicator backgroundStyleApplicator = INSTANCE;
        CompositeBackgroundDrawable compositeBackgroundDrawableEnsureCompositeBackgroundDrawable = backgroundStyleApplicator.ensureCompositeBackgroundDrawable(view);
        BorderRadiusStyle borderRadius = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius();
        if (borderRadius == null) {
            borderRadius = new BorderRadiusStyle(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
        }
        compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.setBorderRadius(borderRadius);
        BorderRadiusStyle borderRadius2 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius();
        if (borderRadius2 != null) {
            borderRadius2.set(corner, lengthPercentage);
        }
        if (ReactNativeFeatureFlags.enableNewBackgroundAndBorderDrawables()) {
            if (view instanceof ImageView) {
                backgroundStyleApplicator.ensureBackgroundDrawable(view);
            }
            BackgroundDrawable background = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBackground();
            if (background != null) {
                background.setBorderRadius(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius());
            }
            BorderDrawable border = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorder();
            if (border != null) {
                border.setBorderRadius(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius());
            }
            BackgroundDrawable background2 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBackground();
            if (background2 != null) {
                background2.invalidateSelf();
            }
            BorderDrawable border2 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorder();
            if (border2 != null) {
                border2.invalidateSelf();
            }
        } else {
            backgroundStyleApplicator.ensureCSSBackground(view).setBorderRadius(corner, lengthPercentage);
        }
        if (Build.VERSION.SDK_INT >= 28 && (outerShadows = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getOuterShadows()) != null) {
            int numberOfLayers = outerShadows.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                Drawable drawable = outerShadows.getDrawable(i);
                if (drawable instanceof OutsetBoxShadowDrawable) {
                    OutsetBoxShadowDrawable outsetBoxShadowDrawable = (OutsetBoxShadowDrawable) drawable;
                    BorderRadiusStyle borderRadius3 = outsetBoxShadowDrawable.getBorderRadius();
                    if (borderRadius3 == null) {
                        borderRadius3 = new BorderRadiusStyle(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
                    }
                    outsetBoxShadowDrawable.setBorderRadius(borderRadius3);
                    BorderRadiusStyle borderRadius4 = outsetBoxShadowDrawable.getBorderRadius();
                    if (borderRadius4 != null) {
                        borderRadius4.set(corner, lengthPercentage);
                    }
                    outsetBoxShadowDrawable.invalidateSelf();
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29 && (innerShadows = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getInnerShadows()) != null) {
            int numberOfLayers2 = innerShadows.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers2; i2++) {
                Drawable drawable2 = innerShadows.getDrawable(i2);
                if (drawable2 instanceof InsetBoxShadowDrawable) {
                    InsetBoxShadowDrawable insetBoxShadowDrawable = (InsetBoxShadowDrawable) drawable2;
                    BorderRadiusStyle borderRadius5 = insetBoxShadowDrawable.getBorderRadius();
                    if (borderRadius5 == null) {
                        borderRadius5 = new BorderRadiusStyle(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
                    }
                    insetBoxShadowDrawable.setBorderRadius(borderRadius5);
                    BorderRadiusStyle borderRadius6 = insetBoxShadowDrawable.getBorderRadius();
                    if (borderRadius6 != null) {
                        borderRadius6.set(corner, lengthPercentage);
                    }
                    insetBoxShadowDrawable.invalidateSelf();
                }
            }
        }
        OutlineDrawable outline = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getOutline();
        if (outline != null) {
            outline.setBorderRadius(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius());
        }
        compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.invalidateSelf();
    }

    @JvmStatic
    public static final LengthPercentage getBorderRadius(@NotNull View view, @NotNull BorderRadiusProp corner) {
        BorderRadiusStyle borderRadius;
        BorderRadiusStyle borderRadius2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(corner, "corner");
        if (ReactNativeFeatureFlags.enableNewBackgroundAndBorderDrawables()) {
            CompositeBackgroundDrawable compositeBackgroundDrawable = INSTANCE.getCompositeBackgroundDrawable(view);
            if (compositeBackgroundDrawable != null && (borderRadius2 = compositeBackgroundDrawable.getBorderRadius()) != null) {
                return borderRadius2.get(corner);
            }
        } else {
            CSSBackgroundDrawable cSSBackground = INSTANCE.getCSSBackground(view);
            if (cSSBackground != null && (borderRadius = cSSBackground.getBorderRadius()) != null) {
                return borderRadius.get(corner);
            }
        }
        return null;
    }

    @JvmStatic
    public static final void setBorderStyle(@NotNull View view, @Nullable BorderStyle borderStyle) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ReactNativeFeatureFlags.enableNewBackgroundAndBorderDrawables()) {
            INSTANCE.ensureBorderDrawable(view).setBorderStyle(borderStyle);
        } else {
            INSTANCE.ensureCSSBackground(view).setBorderStyle(borderStyle);
        }
    }

    @JvmStatic
    public static final BorderStyle getBorderStyle(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ReactNativeFeatureFlags.enableNewBackgroundAndBorderDrawables()) {
            BorderDrawable border = INSTANCE.getBorder(view);
            if (border != null) {
                return border.getBorderStyle();
            }
        } else {
            CSSBackgroundDrawable cSSBackground = INSTANCE.getCSSBackground(view);
            if (cSSBackground != null) {
                return cSSBackground.getBorderStyle();
            }
        }
        return null;
    }

    @JvmStatic
    public static final void setOutlineColor(@NotNull View view, @ColorInt @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ViewUtil.getUIManagerType(view) != 2) {
            return;
        }
        OutlineDrawable outlineDrawableEnsureOutlineDrawable = INSTANCE.ensureOutlineDrawable(view);
        if (num != null) {
            outlineDrawableEnsureOutlineDrawable.setOutlineColor(num.intValue());
        }
    }

    @JvmStatic
    public static final Integer getOutlineColor(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        OutlineDrawable outlineDrawable = INSTANCE.getOutlineDrawable(view);
        if (outlineDrawable != null) {
            return Integer.valueOf(outlineDrawable.getOutlineColor());
        }
        return null;
    }

    @JvmStatic
    public static final void setOutlineOffset(@NotNull View view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ViewUtil.getUIManagerType(view) != 2) {
            return;
        }
        INSTANCE.ensureOutlineDrawable(view).setOutlineOffset(PixelUtil.INSTANCE.dpToPx(f));
    }

    public final Float getOutlineOffset(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        OutlineDrawable outlineDrawable = getOutlineDrawable(view);
        if (outlineDrawable != null) {
            return Float.valueOf(outlineDrawable.getOutlineOffset());
        }
        return null;
    }

    @JvmStatic
    public static final void setOutlineStyle(@NotNull View view, @Nullable OutlineStyle outlineStyle) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ViewUtil.getUIManagerType(view) != 2) {
            return;
        }
        OutlineDrawable outlineDrawableEnsureOutlineDrawable = INSTANCE.ensureOutlineDrawable(view);
        if (outlineStyle != null) {
            outlineDrawableEnsureOutlineDrawable.setOutlineStyle(outlineStyle);
        }
    }

    public final OutlineStyle getOutlineStyle(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        OutlineDrawable outlineDrawable = getOutlineDrawable(view);
        if (outlineDrawable != null) {
            return outlineDrawable.getOutlineStyle();
        }
        return null;
    }

    @JvmStatic
    public static final void setOutlineWidth(@NotNull View view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ViewUtil.getUIManagerType(view) != 2) {
            return;
        }
        INSTANCE.ensureOutlineDrawable(view).setOutlineWidth(PixelUtil.INSTANCE.dpToPx(f));
    }

    public final Float getOutlineWidth(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        OutlineDrawable outlineDrawable = getOutlineDrawable(view);
        if (outlineDrawable != null) {
            return Float.valueOf(outlineDrawable.getOutlineOffset());
        }
        return null;
    }

    @JvmStatic
    public static final void setBoxShadow(@NotNull View view, @NotNull List<BoxShadow> shadows) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(shadows, "shadows");
        if (ViewUtil.getUIManagerType(view) != 2) {
            return;
        }
        CompositeBackgroundDrawable compositeBackgroundDrawableEnsureCompositeBackgroundDrawable = INSTANCE.ensureCompositeBackgroundDrawable(view);
        BorderInsets borderInsets = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets();
        BorderRadiusStyle borderRadius = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius();
        LayerDrawable layerDrawable = null;
        LayerDrawable layerDrawable2 = null;
        for (BoxShadow boxShadow : CollectionsKt__ReversedViewsKt.asReversed(shadows)) {
            float offsetX = boxShadow.getOffsetX();
            float offsetY = boxShadow.getOffsetY();
            Integer color = boxShadow.getColor();
            int iIntValue = color != null ? color.intValue() : ViewCompat.MEASURED_STATE_MASK;
            Float blurRadius = boxShadow.getBlurRadius();
            float fFloatValue = blurRadius != null ? blurRadius.floatValue() : 0.0f;
            Float spreadDistance = boxShadow.getSpreadDistance();
            float fFloatValue2 = spreadDistance != null ? spreadDistance.floatValue() : 0.0f;
            Boolean inset = boxShadow.getInset();
            boolean zBooleanValue = inset != null ? inset.booleanValue() : false;
            if (zBooleanValue && Build.VERSION.SDK_INT >= 29) {
                LayerDrawable layerDrawable3 = layerDrawable == null ? new LayerDrawable(new Drawable[0]) : layerDrawable;
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                layerDrawable3.addLayer(new InsetBoxShadowDrawable(context, iIntValue, offsetX, offsetY, fFloatValue, fFloatValue2, borderInsets, borderRadius));
                layerDrawable = layerDrawable3;
            } else if (!zBooleanValue && Build.VERSION.SDK_INT >= 28) {
                if (layerDrawable2 == null) {
                    layerDrawable2 = new LayerDrawable(new Drawable[0]);
                }
                Context context2 = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                layerDrawable2.addLayer(new OutsetBoxShadowDrawable(context2, iIntValue, offsetX, offsetY, fFloatValue, fFloatValue2, borderRadius));
            }
        }
        BackgroundStyleApplicator backgroundStyleApplicator = INSTANCE;
        view.setBackground(backgroundStyleApplicator.ensureCompositeBackgroundDrawable(view).withNewOuterShadow(layerDrawable2));
        view.setBackground(backgroundStyleApplicator.ensureCompositeBackgroundDrawable(view).withNewInnerShadow(layerDrawable));
    }

    @JvmStatic
    public static final void setBoxShadow(@NotNull View view, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (readableArray == null) {
            setBoxShadow(view, (List<BoxShadow>) CollectionsKt__CollectionsKt.emptyList());
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            BoxShadow.Companion companion = BoxShadow.Companion;
            ReadableMap map = readableArray.getMap(i);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            BoxShadow boxShadow = companion.parse(map, context);
            if (boxShadow == null) {
                throw new IllegalStateException("Required value was null.");
            }
            arrayList.add(boxShadow);
        }
        setBoxShadow(view, arrayList);
    }

    @JvmStatic
    public static final void setFeedbackUnderlay(@NotNull View view, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ReactNativeFeatureFlags.enableNewBackgroundAndBorderDrawables()) {
            INSTANCE.ensureCompositeBackgroundDrawable(view).withNewFeedbackUnderlay(drawable);
        } else {
            view.setBackground(INSTANCE.ensureCompositeBackgroundDrawable(view).withNewFeedbackUnderlay(drawable));
        }
    }

    @JvmStatic
    public static final void clipToPaddingBox(@NotNull View view, @NotNull Canvas canvas) {
        RectF rectFResolve;
        float fDpToPx;
        float fDpToPx2;
        float fDpToPx3;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (ReactNativeFeatureFlags.enableNewBackgroundAndBorderDrawables()) {
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            BackgroundStyleApplicator backgroundStyleApplicator = INSTANCE;
            CompositeBackgroundDrawable compositeBackgroundDrawableEnsureCompositeBackgroundDrawable = backgroundStyleApplicator.ensureCompositeBackgroundDrawable(view);
            RectF rectF = new RectF();
            BorderInsets borderInsets = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets();
            if (borderInsets != null) {
                int layoutDirection = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getLayoutDirection();
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                rectFResolve = borderInsets.resolve(layoutDirection, context);
            } else {
                rectFResolve = null;
            }
            float f = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBounds().left;
            float fDpToPx4 = 0.0f;
            if (rectFResolve != null) {
                fDpToPx = PixelUtil.INSTANCE.dpToPx(rectFResolve.left);
            } else {
                fDpToPx = 0.0f;
            }
            rectF.left = f + fDpToPx;
            float f2 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBounds().top;
            if (rectFResolve != null) {
                fDpToPx2 = PixelUtil.INSTANCE.dpToPx(rectFResolve.top);
            } else {
                fDpToPx2 = 0.0f;
            }
            rectF.top = f2 + fDpToPx2;
            float f3 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBounds().right;
            if (rectFResolve != null) {
                fDpToPx3 = PixelUtil.INSTANCE.dpToPx(rectFResolve.right);
            } else {
                fDpToPx3 = 0.0f;
            }
            rectF.right = f3 - fDpToPx3;
            float f4 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBounds().bottom;
            if (rectFResolve != null) {
                fDpToPx4 = PixelUtil.INSTANCE.dpToPx(rectFResolve.bottom);
            }
            rectF.bottom = f4 - fDpToPx4;
            BorderRadiusStyle borderRadius = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius();
            if (borderRadius != null && borderRadius.hasRoundedBorders()) {
                Path pathCreatePaddingBoxPath = backgroundStyleApplicator.createPaddingBoxPath(view, compositeBackgroundDrawableEnsureCompositeBackgroundDrawable, rectF, rectFResolve);
                pathCreatePaddingBoxPath.offset(rect.left, rect.top);
                canvas.clipPath(pathCreatePaddingBoxPath);
                return;
            } else {
                rectF.offset(rect.left, rect.top);
                canvas.clipRect(rectF);
                return;
            }
        }
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        CSSBackgroundDrawable cSSBackground = INSTANCE.getCSSBackground(view);
        if (cSSBackground == null) {
            canvas.clipRect(rect2);
            return;
        }
        Path paddingBoxPath = cSSBackground.getPaddingBoxPath();
        if (paddingBoxPath != null) {
            paddingBoxPath.offset(rect2.left, rect2.top);
            canvas.clipPath(paddingBoxPath);
        } else {
            RectF paddingBoxRect = cSSBackground.getPaddingBoxRect();
            Intrinsics.checkNotNullExpressionValue(paddingBoxRect, "getPaddingBoxRect(...)");
            paddingBoxRect.offset(rect2.left, rect2.top);
            canvas.clipRect(paddingBoxRect);
        }
    }

    @JvmStatic
    public static final void reset(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getBackground() instanceof CompositeBackgroundDrawable) {
            Drawable background = view.getBackground();
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable");
            view.setBackground(((CompositeBackgroundDrawable) background).getOriginalBackground());
        }
    }

    private final CompositeBackgroundDrawable ensureCompositeBackgroundDrawable(View view) {
        if (view.getBackground() instanceof CompositeBackgroundDrawable) {
            Drawable background = view.getBackground();
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable");
            return (CompositeBackgroundDrawable) background;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        CompositeBackgroundDrawable compositeBackgroundDrawable = new CompositeBackgroundDrawable(context, view.getBackground(), null, null, null, null, null, null, null, TypedValues.PositionType.TYPE_CURVE_FIT, null);
        view.setBackground(compositeBackgroundDrawable);
        return compositeBackgroundDrawable;
    }

    private final CompositeBackgroundDrawable getCompositeBackgroundDrawable(View view) {
        Drawable background = view.getBackground();
        if (background instanceof CompositeBackgroundDrawable) {
            return (CompositeBackgroundDrawable) background;
        }
        return null;
    }

    private final CSSBackgroundDrawable ensureCSSBackground(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawableEnsureCompositeBackgroundDrawable = ensureCompositeBackgroundDrawable(view);
        CSSBackgroundDrawable cssBackground = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getCssBackground();
        if (cssBackground != null) {
            return cssBackground;
        }
        CSSBackgroundDrawable cSSBackgroundDrawable = new CSSBackgroundDrawable(view.getContext());
        view.setBackground(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.withNewCssBackground(cSSBackgroundDrawable));
        return cSSBackgroundDrawable;
    }

    private final BackgroundDrawable ensureBackgroundDrawable(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawableEnsureCompositeBackgroundDrawable = ensureCompositeBackgroundDrawable(view);
        BackgroundDrawable background = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBackground();
        if (background != null) {
            return background;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        BackgroundDrawable backgroundDrawable = new BackgroundDrawable(context, compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius(), compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets());
        view.setBackground(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.withNewBackground(backgroundDrawable));
        return backgroundDrawable;
    }

    private final CSSBackgroundDrawable getCSSBackground(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawable = getCompositeBackgroundDrawable(view);
        if (compositeBackgroundDrawable != null) {
            return compositeBackgroundDrawable.getCssBackground();
        }
        return null;
    }

    private final BackgroundDrawable getBackground(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawable = getCompositeBackgroundDrawable(view);
        if (compositeBackgroundDrawable != null) {
            return compositeBackgroundDrawable.getBackground();
        }
        return null;
    }

    private final BorderDrawable getBorder(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawable = getCompositeBackgroundDrawable(view);
        if (compositeBackgroundDrawable != null) {
            return compositeBackgroundDrawable.getBorder();
        }
        return null;
    }

    private final BorderDrawable ensureBorderDrawable(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawableEnsureCompositeBackgroundDrawable = ensureCompositeBackgroundDrawable(view);
        BorderDrawable border = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorder();
        if (border != null) {
            return border;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        BorderRadiusStyle borderRadius = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius();
        BorderDrawable borderDrawable = new BorderDrawable(context, new Spacing(0.0f), borderRadius, compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets(), BorderStyle.SOLID);
        view.setBackground(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.withNewBorder(borderDrawable));
        return borderDrawable;
    }

    private final OutlineDrawable ensureOutlineDrawable(View view) {
        BorderRadiusStyle borderRadius;
        CompositeBackgroundDrawable compositeBackgroundDrawableEnsureCompositeBackgroundDrawable = ensureCompositeBackgroundDrawable(view);
        OutlineDrawable outline = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getOutline();
        if (outline != null) {
            return outline;
        }
        if (ReactNativeFeatureFlags.enableNewBackgroundAndBorderDrawables()) {
            borderRadius = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius();
        } else {
            borderRadius = ensureCSSBackground(view).getBorderRadius();
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        OutlineDrawable outlineDrawable = new OutlineDrawable(context, borderRadius, ViewCompat.MEASURED_STATE_MASK, 0.0f, OutlineStyle.SOLID, 0.0f);
        view.setBackground(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.withNewOutline(outlineDrawable));
        return outlineDrawable;
    }

    private final OutlineDrawable getOutlineDrawable(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawable = getCompositeBackgroundDrawable(view);
        if (compositeBackgroundDrawable != null) {
            return compositeBackgroundDrawable.getOutline();
        }
        return null;
    }

    private final float getInnerBorderRadius(Float f, Float f2) {
        return RangesKt___RangesKt.coerceAtLeast((f != null ? f.floatValue() : 0.0f) - (f2 != null ? f2.floatValue() : 0.0f), 0.0f);
    }

    private final Path createPaddingBoxPath(View view, CompositeBackgroundDrawable compositeBackgroundDrawable, RectF rectF, RectF rectF2) {
        ComputedBorderRadius computedBorderRadiusResolve;
        CornerRadii bottomLeft;
        CornerRadii bottomLeft2;
        CornerRadii bottomRight;
        CornerRadii bottomRight2;
        CornerRadii topRight;
        CornerRadii topRight2;
        CornerRadii topLeft;
        CornerRadii topLeft2;
        BorderRadiusStyle borderRadius = compositeBackgroundDrawable.getBorderRadius();
        if (borderRadius != null) {
            int layoutDirection = compositeBackgroundDrawable.getLayoutDirection();
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            computedBorderRadiusResolve = borderRadius.resolve(layoutDirection, context, PixelUtil.toDIPFromPixel(compositeBackgroundDrawable.getBounds().width()), PixelUtil.toDIPFromPixel(compositeBackgroundDrawable.getBounds().height()));
        } else {
            computedBorderRadiusResolve = null;
        }
        Path path = new Path();
        path.addRoundRect(rectF, new float[]{getInnerBorderRadius((computedBorderRadiusResolve == null || (topLeft2 = computedBorderRadiusResolve.getTopLeft()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(topLeft2.getHorizontal())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.left)) : null), getInnerBorderRadius((computedBorderRadiusResolve == null || (topLeft = computedBorderRadiusResolve.getTopLeft()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(topLeft.getVertical())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.top)) : null), getInnerBorderRadius((computedBorderRadiusResolve == null || (topRight2 = computedBorderRadiusResolve.getTopRight()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(topRight2.getHorizontal())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.right)) : null), getInnerBorderRadius((computedBorderRadiusResolve == null || (topRight = computedBorderRadiusResolve.getTopRight()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(topRight.getVertical())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.top)) : null), getInnerBorderRadius((computedBorderRadiusResolve == null || (bottomRight2 = computedBorderRadiusResolve.getBottomRight()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(bottomRight2.getHorizontal())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.right)) : null), getInnerBorderRadius((computedBorderRadiusResolve == null || (bottomRight = computedBorderRadiusResolve.getBottomRight()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(bottomRight.getVertical())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.bottom)) : null), getInnerBorderRadius((computedBorderRadiusResolve == null || (bottomLeft2 = computedBorderRadiusResolve.getBottomLeft()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(bottomLeft2.getHorizontal())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.left)) : null), getInnerBorderRadius((computedBorderRadiusResolve == null || (bottomLeft = computedBorderRadiusResolve.getBottomLeft()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(bottomLeft.getVertical())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.bottom)) : null)}, Path.Direction.CW);
        return path;
    }
}
