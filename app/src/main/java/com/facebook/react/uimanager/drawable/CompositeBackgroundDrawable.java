package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.reflect.KMutableProperty0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class CompositeBackgroundDrawable extends LayerDrawable {
    private static final int BACKGROUND_ID = 3;
    private static final int BORDER_ID = 4;
    private static final int CSS_BACKGROUND_ID = 2;
    private static final Companion Companion = new Companion(null);
    private static final int FEEDBACK_UNDERLAY_ID = 5;
    private static final int INNER_SHADOWS_ID = 6;
    private static final int ORIGINAL_BACKGROUND_ID = 0;
    private static final int OUTER_SHADOWS_ID = 1;
    private static final int OUTLINE_ID = 7;
    private BackgroundDrawable background;
    private BorderDrawable border;
    private BorderInsets borderInsets;
    private BorderRadiusStyle borderRadius;
    private final Context context;
    private final CSSBackgroundDrawable cssBackground;
    private Drawable feedbackUnderlay;
    private LayerDrawable innerShadows;
    private final Drawable originalBackground;
    private LayerDrawable outerShadows;
    private OutlineDrawable outline;

    public /* synthetic */ CompositeBackgroundDrawable(Context context, Drawable drawable, LayerDrawable layerDrawable, CSSBackgroundDrawable cSSBackgroundDrawable, BackgroundDrawable backgroundDrawable, BorderDrawable borderDrawable, Drawable drawable2, LayerDrawable layerDrawable2, OutlineDrawable outlineDrawable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : drawable, (i & 4) != 0 ? null : layerDrawable, (i & 8) != 0 ? null : cSSBackgroundDrawable, (i & 16) != 0 ? null : backgroundDrawable, (i & 32) != 0 ? null : borderDrawable, (i & 64) != 0 ? null : drawable2, (i & 128) != 0 ? null : layerDrawable2, (i & 256) == 0 ? outlineDrawable : null);
    }

    public final Drawable getOriginalBackground() {
        return this.originalBackground;
    }

    public final CSSBackgroundDrawable getCssBackground() {
        return this.cssBackground;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompositeBackgroundDrawable(@NotNull Context context, @Nullable Drawable drawable, @Nullable LayerDrawable layerDrawable, @Nullable CSSBackgroundDrawable cSSBackgroundDrawable, @Nullable BackgroundDrawable backgroundDrawable, @Nullable BorderDrawable borderDrawable, @Nullable Drawable drawable2, @Nullable LayerDrawable layerDrawable2, @Nullable OutlineDrawable outlineDrawable) {
        super(new Drawable[0]);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.originalBackground = drawable;
        this.cssBackground = cSSBackgroundDrawable;
        this.outerShadows = layerDrawable;
        this.background = backgroundDrawable;
        this.border = borderDrawable;
        this.feedbackUnderlay = drawable2;
        this.innerShadows = layerDrawable2;
        this.outline = outlineDrawable;
        setPaddingMode(1);
        addLayer(drawable, 0);
        addLayer(layerDrawable, 1);
        addLayer(cSSBackgroundDrawable, 2);
        addLayer(backgroundDrawable, 3);
        addLayer(borderDrawable, 4);
        addLayer(drawable2, 5);
        addLayer(layerDrawable2, 6);
        addLayer(outlineDrawable, 7);
    }

    public final LayerDrawable getOuterShadows() {
        return this.outerShadows;
    }

    public final BackgroundDrawable getBackground() {
        return this.background;
    }

    public final BorderDrawable getBorder() {
        return this.border;
    }

    public final Drawable getFeedbackUnderlay() {
        return this.feedbackUnderlay;
    }

    public final LayerDrawable getInnerShadows() {
        return this.innerShadows;
    }

    public final OutlineDrawable getOutline() {
        return this.outline;
    }

    public final BorderInsets getBorderInsets() {
        return this.borderInsets;
    }

    public final void setBorderInsets(@Nullable BorderInsets borderInsets) {
        this.borderInsets = borderInsets;
    }

    public final BorderRadiusStyle getBorderRadius() {
        return this.borderRadius;
    }

    public final void setBorderRadius(@Nullable BorderRadiusStyle borderRadiusStyle) {
        this.borderRadius = borderRadiusStyle;
    }

    public final CompositeBackgroundDrawable withNewCssBackground(@Nullable CSSBackgroundDrawable cSSBackgroundDrawable) {
        CompositeBackgroundDrawable compositeBackgroundDrawable = new CompositeBackgroundDrawable(this.context, this.originalBackground, this.outerShadows, cSSBackgroundDrawable, this.background, this.border, this.feedbackUnderlay, this.innerShadows, this.outline);
        compositeBackgroundDrawable.borderInsets = this.borderInsets;
        compositeBackgroundDrawable.borderRadius = this.borderRadius;
        return compositeBackgroundDrawable;
    }

    /* JADX INFO: renamed from: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable$withNewOuterShadow$1, reason: invalid class name and case insensitive filesystem */
    final /* synthetic */ class C03261 extends FunctionReferenceImpl implements Function1<LayerDrawable, Unit> {
        C03261(Object obj) {
            super(1, obj, KMutableProperty0.class, "set", "set(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LayerDrawable layerDrawable) {
            invoke2(layerDrawable);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LayerDrawable layerDrawable) {
            ((KMutableProperty0) this.receiver).set(layerDrawable);
        }
    }

    public final CompositeBackgroundDrawable withNewOuterShadow(@Nullable LayerDrawable layerDrawable) {
        return withNewLayer(layerDrawable, 1, new C03261(new MutablePropertyReference0Impl(this) { // from class: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable.withNewOuterShadow.2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((CompositeBackgroundDrawable) this.receiver).getOuterShadows();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((CompositeBackgroundDrawable) this.receiver).outerShadows = (LayerDrawable) obj;
            }
        }));
    }

    /* JADX INFO: renamed from: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable$withNewBackground$1, reason: invalid class name */
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<BackgroundDrawable, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, KMutableProperty0.class, "set", "set(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BackgroundDrawable backgroundDrawable) {
            invoke2(backgroundDrawable);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BackgroundDrawable backgroundDrawable) {
            ((KMutableProperty0) this.receiver).set(backgroundDrawable);
        }
    }

    public final CompositeBackgroundDrawable withNewBackground(@Nullable BackgroundDrawable backgroundDrawable) {
        return withNewLayer(backgroundDrawable, 3, new AnonymousClass1(new MutablePropertyReference0Impl(this) { // from class: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable.withNewBackground.2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((CompositeBackgroundDrawable) this.receiver).getBackground();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((CompositeBackgroundDrawable) this.receiver).background = (BackgroundDrawable) obj;
            }
        }));
    }

    /* JADX INFO: renamed from: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable$withNewBorder$1, reason: invalid class name and case insensitive filesystem */
    final /* synthetic */ class C03201 extends FunctionReferenceImpl implements Function1<BorderDrawable, Unit> {
        C03201(Object obj) {
            super(1, obj, KMutableProperty0.class, "set", "set(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BorderDrawable borderDrawable) {
            invoke2(borderDrawable);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BorderDrawable borderDrawable) {
            ((KMutableProperty0) this.receiver).set(borderDrawable);
        }
    }

    public final CompositeBackgroundDrawable withNewBorder(@Nullable BorderDrawable borderDrawable) {
        return withNewLayer(borderDrawable, 4, new C03201(new MutablePropertyReference0Impl(this) { // from class: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable.withNewBorder.2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((CompositeBackgroundDrawable) this.receiver).getBorder();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((CompositeBackgroundDrawable) this.receiver).border = (BorderDrawable) obj;
            }
        }));
    }

    /* JADX INFO: renamed from: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable$withNewFeedbackUnderlay$1, reason: invalid class name and case insensitive filesystem */
    final /* synthetic */ class C03221 extends FunctionReferenceImpl implements Function1<Drawable, Unit> {
        C03221(Object obj) {
            super(1, obj, KMutableProperty0.class, "set", "set(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
            invoke2(drawable);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Drawable drawable) {
            ((KMutableProperty0) this.receiver).set(drawable);
        }
    }

    public final CompositeBackgroundDrawable withNewFeedbackUnderlay(@Nullable Drawable drawable) {
        return withNewLayer(drawable, 5, new C03221(new MutablePropertyReference0Impl(this) { // from class: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable.withNewFeedbackUnderlay.2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((CompositeBackgroundDrawable) this.receiver).getFeedbackUnderlay();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((CompositeBackgroundDrawable) this.receiver).feedbackUnderlay = (Drawable) obj;
            }
        }));
    }

    /* JADX INFO: renamed from: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable$withNewInnerShadow$1, reason: invalid class name and case insensitive filesystem */
    final /* synthetic */ class C03241 extends FunctionReferenceImpl implements Function1<LayerDrawable, Unit> {
        C03241(Object obj) {
            super(1, obj, KMutableProperty0.class, "set", "set(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LayerDrawable layerDrawable) {
            invoke2(layerDrawable);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LayerDrawable layerDrawable) {
            ((KMutableProperty0) this.receiver).set(layerDrawable);
        }
    }

    public final CompositeBackgroundDrawable withNewInnerShadow(@Nullable LayerDrawable layerDrawable) {
        return withNewLayer(layerDrawable, 6, new C03241(new MutablePropertyReference0Impl(this) { // from class: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable.withNewInnerShadow.2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((CompositeBackgroundDrawable) this.receiver).getInnerShadows();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((CompositeBackgroundDrawable) this.receiver).innerShadows = (LayerDrawable) obj;
            }
        }));
    }

    /* JADX INFO: renamed from: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable$withNewOutline$1, reason: invalid class name and case insensitive filesystem */
    final /* synthetic */ class C03281 extends FunctionReferenceImpl implements Function1<OutlineDrawable, Unit> {
        C03281(Object obj) {
            super(1, obj, KMutableProperty0.class, "set", "set(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OutlineDrawable outlineDrawable) {
            invoke2(outlineDrawable);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OutlineDrawable outlineDrawable) {
            ((KMutableProperty0) this.receiver).set(outlineDrawable);
        }
    }

    public final CompositeBackgroundDrawable withNewOutline(@Nullable OutlineDrawable outlineDrawable) {
        return withNewLayer(outlineDrawable, 7, new C03281(new MutablePropertyReference0Impl(this) { // from class: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable.withNewOutline.2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((CompositeBackgroundDrawable) this.receiver).getOutline();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((CompositeBackgroundDrawable) this.receiver).outline = (OutlineDrawable) obj;
            }
        }));
    }

    private final boolean updateLayer(Drawable drawable, int i) {
        if (drawable == null) {
            return findDrawableByLayerId(i) == null;
        }
        if (findDrawableByLayerId(i) == null) {
            insertNewLayer(drawable, i);
        } else {
            setDrawableByLayerId(i, drawable);
        }
        invalidateSelf();
        return true;
    }

    private final void insertNewLayer(Drawable drawable, int i) {
        if (drawable == null) {
            return;
        }
        if (getNumberOfLayers() == 0) {
            addLayer(drawable, i);
            return;
        }
        int numberOfLayers = getNumberOfLayers();
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            if (i < getId(i2)) {
                Drawable drawable2 = getDrawable(i2);
                Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(...)");
                int id = getId(i2);
                setDrawable(i2, drawable);
                setId(i2, i);
                insertNewLayer(drawable2, id);
                return;
            }
            if (i2 == getNumberOfLayers() - 1) {
                addLayer(drawable, i);
                return;
            }
        }
    }

    private final void addLayer(Drawable drawable, int i) {
        if (drawable == null) {
            return;
        }
        addLayer(drawable);
        drawable.setCallback(this);
        setId(getNumberOfLayers() - 1, i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void getOutline(@NotNull Outline outline) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        BorderRadiusStyle borderRadiusStyle = this.borderRadius;
        if (borderRadiusStyle != null && borderRadiusStyle.hasRoundedBorders()) {
            Path path = new Path();
            BorderRadiusStyle borderRadiusStyle2 = this.borderRadius;
            ComputedBorderRadius computedBorderRadiusResolve = borderRadiusStyle2 != null ? borderRadiusStyle2.resolve(getLayoutDirection(), this.context, getBounds().width(), getBounds().height()) : null;
            BorderInsets borderInsets = this.borderInsets;
            RectF rectFResolve = borderInsets != null ? borderInsets.resolve(getLayoutDirection(), this.context) : null;
            if (computedBorderRadiusResolve != null) {
                RectF rectF = new RectF(getBounds());
                PixelUtil pixelUtil = PixelUtil.INSTANCE;
                path.addRoundRect(rectF, new float[]{pixelUtil.dpToPx(computedBorderRadiusResolve.getTopLeft().getHorizontal() + (rectFResolve != null ? rectFResolve.left : 0.0f)), pixelUtil.dpToPx(computedBorderRadiusResolve.getTopLeft().getVertical() + (rectFResolve != null ? rectFResolve.top : 0.0f)), pixelUtil.dpToPx(computedBorderRadiusResolve.getTopRight().getHorizontal() + (rectFResolve != null ? rectFResolve.right : 0.0f)), pixelUtil.dpToPx(computedBorderRadiusResolve.getTopRight().getVertical() + (rectFResolve != null ? rectFResolve.top : 0.0f)), pixelUtil.dpToPx(computedBorderRadiusResolve.getBottomRight().getHorizontal() + (rectFResolve != null ? rectFResolve.right : 0.0f)), pixelUtil.dpToPx(computedBorderRadiusResolve.getBottomRight().getVertical() + (rectFResolve != null ? rectFResolve.bottom : 0.0f)), pixelUtil.dpToPx(computedBorderRadiusResolve.getBottomLeft().getHorizontal() + (rectFResolve != null ? rectFResolve.left : 0.0f)), pixelUtil.dpToPx(computedBorderRadiusResolve.getBottomLeft().getVertical() + (rectFResolve != null ? rectFResolve.bottom : 0.0f))}, Path.Direction.CW);
            }
            if (Build.VERSION.SDK_INT >= 30) {
                outline.setPath(path);
                return;
            } else {
                outline.setConvexPath(path);
                return;
            }
        }
        outline.setRect(getBounds());
    }

    private final <T extends Drawable> CompositeBackgroundDrawable withNewLayer(T t, int i, Function1<? super T, Unit> function1) {
        function1.invoke(t);
        if (ReactNativeFeatureFlags.enableNewBackgroundAndBorderDrawables() && updateLayer(t, i)) {
            return this;
        }
        CompositeBackgroundDrawable compositeBackgroundDrawable = new CompositeBackgroundDrawable(this.context, this.originalBackground, this.outerShadows, this.cssBackground, this.background, this.border, this.feedbackUnderlay, this.innerShadows, this.outline);
        compositeBackgroundDrawable.borderInsets = this.borderInsets;
        compositeBackgroundDrawable.borderRadius = this.borderRadius;
        return compositeBackgroundDrawable;
    }

    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
