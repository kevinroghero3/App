package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import com.facebook.react.R;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerDelegate;
import com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = RNGestureHandlerButtonViewManager.REACT_CLASS)
public final class RNGestureHandlerButtonViewManager extends ViewGroupManager<ButtonViewGroup> implements RNGestureHandlerButtonManagerInterface<ButtonViewGroup> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNGestureHandlerButton";
    private final ViewManagerDelegate<ButtonViewGroup> mDelegate = new RNGestureHandlerButtonManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ButtonViewGroup createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ButtonViewGroup(context);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "foreground")
    public void setForeground(@NotNull ButtonViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setUseDrawableOnForeground(z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = ViewProps.BACKGROUND_COLOR)
    public void setBackgroundColor(@NotNull ButtonViewGroup view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackgroundColor(i);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "borderless")
    public void setBorderless(@NotNull ButtonViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setUseBorderlessDrawable(z);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.ENABLED)
    public void setEnabled(@NotNull ButtonViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnabled(z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = "borderRadius")
    public void setBorderRadius(@NotNull ButtonViewGroup view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderRadius(f);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = "borderTopLeftRadius")
    public void setBorderTopLeftRadius(@NotNull ButtonViewGroup view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderTopLeftRadius(f);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = "borderTopRightRadius")
    public void setBorderTopRightRadius(@NotNull ButtonViewGroup view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderTopRightRadius(f);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = "borderBottomLeftRadius")
    public void setBorderBottomLeftRadius(@NotNull ButtonViewGroup view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderBottomLeftRadius(f);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = "borderBottomRightRadius")
    public void setBorderBottomRightRadius(@NotNull ButtonViewGroup view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderBottomRightRadius(f);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_WIDTH)
    public void setBorderWidth(@NotNull ButtonViewGroup view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderWidth(f);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_COLOR)
    public void setBorderColor(@NotNull ButtonViewGroup view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "borderStyle")
    public void setBorderStyle(@NotNull ButtonViewGroup view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderStyle(str);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "rippleColor")
    public void setRippleColor(@NotNull ButtonViewGroup view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setRippleColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "rippleRadius")
    public void setRippleRadius(@NotNull ButtonViewGroup view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setRippleRadius(Integer.valueOf(i));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "exclusive")
    public void setExclusive(@NotNull ButtonViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setExclusive(z);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "touchSoundDisabled")
    public void setTouchSoundDisabled(@NotNull ButtonViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSoundEffectsEnabled(!z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NotNull ButtonViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        view.updateBackground();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<ButtonViewGroup> getDelegate() {
        return this.mDelegate;
    }

    public static final class ButtonViewGroup extends ViewGroup implements NativeViewGestureHandler.NativeViewGestureHandlerHook {
        private static ButtonViewGroup soundResponder;
        private static ButtonViewGroup touchResponder;
        private float borderBottomLeftRadius;
        private float borderBottomRightRadius;
        private Integer borderColor;
        private float borderRadius;
        private String borderStyle;
        private float borderTopLeftRadius;
        private float borderTopRightRadius;
        private float borderWidth;
        private int buttonBackgroundColor;
        private boolean exclusive;
        private boolean isTouched;
        private int lastAction;
        private long lastEventTime;
        private boolean needBackgroundUpdate;
        private boolean receivedKeyEvent;
        private Integer rippleColor;
        private Integer rippleRadius;
        private boolean useBorderlessDrawable;
        private boolean useDrawableOnForeground;
        public static final Companion Companion = new Companion(null);
        private static TypedValue resolveOutValue = new TypedValue();
        private static View.OnClickListener dummyClickListener = new View.OnClickListener() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RNGestureHandlerButtonViewManager.ButtonViewGroup.dummyClickListener$lambda$14(view);
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public static final void dummyClickListener$lambda$14(View view) {
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDrawableHotspotChanged(float f, float f2) {
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canActivate(@NotNull View view) {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.canActivate(this, view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void handleEventBeforeActivation(@NotNull MotionEvent motionEvent) {
            NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.handleEventBeforeActivation(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean sendTouchEvent(@Nullable View view, @NotNull MotionEvent motionEvent) {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.sendTouchEvent(this, view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.shouldCancelRootViewGestureHandlerIfNecessary(this);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean shouldRecognizeSimultaneously(@NotNull GestureHandler gestureHandler) {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.shouldRecognizeSimultaneously(this, gestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean wantsToHandleEventBeforeActivation() {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.wantsToHandleEventBeforeActivation(this);
        }

        public ButtonViewGroup(@Nullable Context context) {
            super(context);
            this.borderStyle = "solid";
            this.exclusive = true;
            this.lastEventTime = -1L;
            this.lastAction = -1;
            setOnClickListener(dummyClickListener);
            setClickable(true);
            setFocusable(true);
            this.needBackgroundUpdate = true;
            setClipChildren(false);
        }

        public final Integer getRippleColor() {
            return this.rippleColor;
        }

        public final void setRippleColor(@Nullable Integer num) {
            this.rippleColor = num;
            this.needBackgroundUpdate = true;
        }

        public final Integer getRippleRadius() {
            return this.rippleRadius;
        }

        public final void setRippleRadius(@Nullable Integer num) {
            this.rippleRadius = num;
            this.needBackgroundUpdate = true;
        }

        public final boolean getUseDrawableOnForeground() {
            return this.useDrawableOnForeground;
        }

        public final void setUseDrawableOnForeground(boolean z) {
            this.useDrawableOnForeground = z;
            this.needBackgroundUpdate = true;
        }

        public final boolean getUseBorderlessDrawable() {
            return this.useBorderlessDrawable;
        }

        public final void setUseBorderlessDrawable(boolean z) {
            this.useBorderlessDrawable = z;
        }

        public final float getBorderRadius() {
            return this.borderRadius;
        }

        public final void setBorderRadius(float f) {
            this.borderRadius = f * getResources().getDisplayMetrics().density;
            this.needBackgroundUpdate = true;
        }

        public final float getBorderTopLeftRadius() {
            return this.borderTopLeftRadius;
        }

        public final void setBorderTopLeftRadius(float f) {
            this.borderTopLeftRadius = f * getResources().getDisplayMetrics().density;
            this.needBackgroundUpdate = true;
        }

        public final float getBorderTopRightRadius() {
            return this.borderTopRightRadius;
        }

        public final void setBorderTopRightRadius(float f) {
            this.borderTopRightRadius = f * getResources().getDisplayMetrics().density;
            this.needBackgroundUpdate = true;
        }

        public final float getBorderBottomLeftRadius() {
            return this.borderBottomLeftRadius;
        }

        public final void setBorderBottomLeftRadius(float f) {
            this.borderBottomLeftRadius = f * getResources().getDisplayMetrics().density;
            this.needBackgroundUpdate = true;
        }

        public final float getBorderBottomRightRadius() {
            return this.borderBottomRightRadius;
        }

        public final void setBorderBottomRightRadius(float f) {
            this.borderBottomRightRadius = f * getResources().getDisplayMetrics().density;
            this.needBackgroundUpdate = true;
        }

        public final float getBorderWidth() {
            return this.borderWidth;
        }

        public final void setBorderWidth(float f) {
            this.borderWidth = f * getResources().getDisplayMetrics().density;
            this.needBackgroundUpdate = true;
        }

        public final Integer getBorderColor() {
            return this.borderColor;
        }

        public final void setBorderColor(@Nullable Integer num) {
            this.borderColor = num;
            this.needBackgroundUpdate = true;
        }

        public final String getBorderStyle() {
            return this.borderStyle;
        }

        public final void setBorderStyle(@Nullable String str) {
            this.borderStyle = str;
            this.needBackgroundUpdate = true;
        }

        private final boolean getHasBorderRadii() {
            return (this.borderRadius == 0.0f && this.borderTopLeftRadius == 0.0f && this.borderTopRightRadius == 0.0f && this.borderBottomLeftRadius == 0.0f && this.borderBottomRightRadius == 0.0f) ? false : true;
        }

        public final boolean getExclusive() {
            return this.exclusive;
        }

        public final void setExclusive(boolean z) {
            this.exclusive = z;
        }

        public final boolean isTouched() {
            return this.isTouched;
        }

        public final void setTouched(boolean z) {
            this.isTouched = z;
        }

        private final void withBackgroundUpdate(Function0<Unit> function0) {
            function0.invoke();
            this.needBackgroundUpdate = true;
        }

        private final float[] buildBorderRadii() {
            float f = this.borderTopLeftRadius;
            float f2 = this.borderTopRightRadius;
            float f3 = this.borderBottomRightRadius;
            float f4 = this.borderBottomLeftRadius;
            float[] fArr = {f, f, f2, f2, f3, f3, f4, f4};
            ArrayList arrayList = new ArrayList(8);
            for (int i = 0; i < 8; i++) {
                float f5 = fArr[i];
                if (f5 == 0.0f) {
                    f5 = this.borderRadius;
                }
                arrayList.add(Float.valueOf(f5));
            }
            return CollectionsKt___CollectionsKt.toFloatArray(arrayList);
        }

        private final PathEffect buildBorderStyle() {
            String str = this.borderStyle;
            if (Intrinsics.areEqual(str, "dotted")) {
                float f = this.borderWidth;
                return new DashPathEffect(new float[]{f, f, f, f}, 0.0f);
            }
            if (!Intrinsics.areEqual(str, "dashed")) {
                return null;
            }
            float f2 = this.borderWidth * 3;
            return new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
        }

        @Override // android.view.View
        public void setBackgroundColor(int i) {
            this.buttonBackgroundColor = i;
            this.needBackgroundUpdate = true;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NotNull AccessibilityNodeInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(info);
            Object tag = super.getTag(R.id.react_test_id);
            if (tag instanceof String) {
                info.setViewIdResourceName((String) tag);
            }
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (super.onInterceptTouchEvent(event)) {
                return true;
            }
            onTouchEvent(event);
            return isPressed();
        }

        @Override // android.view.View
        public boolean onTouchEvent(@NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            long eventTime = event.getEventTime();
            int action = event.getAction();
            ButtonViewGroup buttonViewGroup = touchResponder;
            if (buttonViewGroup != null && buttonViewGroup != this) {
                Intrinsics.checkNotNull(buttonViewGroup);
                if (buttonViewGroup.exclusive) {
                    if (isPressed()) {
                        setPressed(false);
                    }
                    this.lastEventTime = eventTime;
                    this.lastAction = action;
                    return false;
                }
            }
            if (event.getAction() == 3) {
                tryFreeingResponder();
            }
            if (this.lastEventTime == eventTime && this.lastAction == action && action != 3) {
                return false;
            }
            this.lastEventTime = eventTime;
            this.lastAction = action;
            return super.onTouchEvent(event);
        }

        private final void updateBackgroundColor(int i, Drawable drawable, Drawable drawable2) {
            Drawable[] drawableArr;
            PaintDrawable paintDrawable = new PaintDrawable(i);
            if (getHasBorderRadii()) {
                paintDrawable.setCornerRadii(buildBorderRadii());
            }
            if (drawable2 != null) {
                drawableArr = new Drawable[]{paintDrawable, drawable2, drawable};
            } else {
                drawableArr = new Drawable[]{paintDrawable, drawable};
            }
            setBackground(new LayerDrawable(drawableArr));
        }

        public final void updateBackground() {
            if (this.needBackgroundUpdate) {
                this.needBackgroundUpdate = false;
                if (this.buttonBackgroundColor == 0) {
                    setBackground(null);
                }
                setForeground(null);
                Drawable drawableCreateSelectableDrawable = createSelectableDrawable();
                Drawable drawableCreateBorderDrawable = createBorderDrawable();
                if (getHasBorderRadii() && (drawableCreateSelectableDrawable instanceof RippleDrawable)) {
                    PaintDrawable paintDrawable = new PaintDrawable(-1);
                    paintDrawable.setCornerRadii(buildBorderRadii());
                    ((RippleDrawable) drawableCreateSelectableDrawable).setDrawableByLayerId(android.R.id.mask, paintDrawable);
                }
                if (this.useDrawableOnForeground) {
                    setForeground(drawableCreateSelectableDrawable);
                    int i = this.buttonBackgroundColor;
                    if (i != 0) {
                        updateBackgroundColor(i, drawableCreateBorderDrawable, null);
                        return;
                    }
                    return;
                }
                int i2 = this.buttonBackgroundColor;
                if (i2 == 0 && this.rippleColor == null) {
                    setBackground(new LayerDrawable(new Drawable[]{drawableCreateSelectableDrawable, drawableCreateBorderDrawable}));
                } else {
                    updateBackgroundColor(i2, drawableCreateBorderDrawable, drawableCreateSelectableDrawable);
                }
            }
        }

        private final Drawable createBorderDrawable() {
            PaintDrawable paintDrawable = new PaintDrawable(0);
            if (getHasBorderRadii()) {
                paintDrawable.setCornerRadii(buildBorderRadii());
            }
            if (this.borderWidth > 0.0f) {
                Paint paint = paintDrawable.getPaint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(this.borderWidth);
                Integer num = this.borderColor;
                paint.setColor(num != null ? num.intValue() : ViewCompat.MEASURED_STATE_MASK);
                paint.setPathEffect(buildBorderStyle());
            }
            return paintDrawable;
        }

        private final Drawable createSelectableDrawable() {
            ColorStateList colorStateList;
            Integer num = this.rippleColor;
            if (num != null && num.intValue() == 0) {
                return null;
            }
            int[][] iArr = {new int[]{android.R.attr.state_enabled}};
            Integer num2 = this.rippleRadius;
            Integer num3 = this.rippleColor;
            if (num3 != null) {
                Intrinsics.checkNotNull(num3);
                colorStateList = new ColorStateList(iArr, new int[]{num3.intValue()});
            } else {
                getContext().getTheme().resolveAttribute(android.R.attr.colorControlHighlight, resolveOutValue, true);
                colorStateList = new ColorStateList(iArr, new int[]{resolveOutValue.data});
            }
            RippleDrawable rippleDrawable = new RippleDrawable(colorStateList, null, this.useBorderlessDrawable ? null : new ShapeDrawable(new RectShape()));
            if (num2 != null) {
                rippleDrawable.setRadius((int) PixelUtil.toPixelFromDIP(num2.intValue()));
            }
            return rippleDrawable;
        }

        @Override // android.view.View
        public void drawableHotspotChanged(float f, float f2) {
            ButtonViewGroup buttonViewGroup = touchResponder;
            if (buttonViewGroup == null || buttonViewGroup == this) {
                super.drawableHotspotChanged(f, f2);
            }
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canBegin(@NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getAction() == 3 || event.getAction() == 1 || event.getActionMasked() == 6) {
                return false;
            }
            boolean zTryGrabbingResponder = tryGrabbingResponder();
            if (zTryGrabbingResponder) {
                this.isTouched = true;
            }
            return zTryGrabbingResponder;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void afterGestureEnd(@NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            tryFreeingResponder();
            this.isTouched = false;
        }

        private final void tryFreeingResponder() {
            if (touchResponder == this) {
                touchResponder = null;
                soundResponder = this;
            }
        }

        private final boolean tryGrabbingResponder() {
            if (isChildTouched$default(this, null, 1, null)) {
                return false;
            }
            ButtonViewGroup buttonViewGroup = touchResponder;
            if (buttonViewGroup == null) {
                touchResponder = this;
                return true;
            }
            if (this.exclusive) {
                if (buttonViewGroup == this) {
                    return true;
                }
            } else if (buttonViewGroup == null || !buttonViewGroup.exclusive) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ boolean isChildTouched$default(ButtonViewGroup buttonViewGroup, Sequence sequence, int i, Object obj) {
            if ((i & 1) != 0) {
                sequence = ViewGroupKt.getChildren(buttonViewGroup);
            }
            return buttonViewGroup.isChildTouched(sequence);
        }

        private final boolean isChildTouched(Sequence<? extends View> sequence) {
            for (View view : sequence) {
                if (view instanceof ButtonViewGroup) {
                    ButtonViewGroup buttonViewGroup = (ButtonViewGroup) view;
                    if (buttonViewGroup.isTouched || buttonViewGroup.isPressed()) {
                        return true;
                    }
                }
                if ((view instanceof ViewGroup) && isChildTouched(ViewGroupKt.getChildren((ViewGroup) view))) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyUp(int i, @Nullable KeyEvent keyEvent) {
            this.receivedKeyEvent = true;
            return super.onKeyUp(i, keyEvent);
        }

        @Override // android.view.View
        public boolean performClick() {
            if (isChildTouched$default(this, null, 1, null)) {
                return false;
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (ExtensionsKt.isScreenReaderOn(context)) {
                RNGestureHandlerRootView rNGestureHandlerRootViewFindGestureHandlerRootView = findGestureHandlerRootView();
                if (rNGestureHandlerRootViewFindGestureHandlerRootView != null) {
                    rNGestureHandlerRootViewFindGestureHandlerRootView.activateNativeHandlers(this);
                }
            } else if (this.receivedKeyEvent) {
                RNGestureHandlerRootView rNGestureHandlerRootViewFindGestureHandlerRootView2 = findGestureHandlerRootView();
                if (rNGestureHandlerRootViewFindGestureHandlerRootView2 != null) {
                    rNGestureHandlerRootViewFindGestureHandlerRootView2.activateNativeHandlers(this);
                }
                this.receivedKeyEvent = false;
            }
            if (soundResponder != this) {
                return false;
            }
            tryFreeingResponder();
            soundResponder = null;
            return super.performClick();
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0017  */
        @Override // android.view.View
        public void setPressed(boolean z) {
            boolean z2;
            if (!this.exclusive) {
                ButtonViewGroup buttonViewGroup = touchResponder;
                z2 = (buttonViewGroup == null || !buttonViewGroup.exclusive) && !isChildTouched$default(this, null, 1, null);
            }
            if (!z || touchResponder == this || z2) {
                this.isTouched = z;
                super.setPressed(z);
            }
            if (z || touchResponder != this) {
                return;
            }
            this.isTouched = false;
        }

        private final RNGestureHandlerRootView findGestureHandlerRootView() {
            RNGestureHandlerRootView rNGestureHandlerRootView = null;
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof RNGestureHandlerRootView) {
                    rNGestureHandlerRootView = (RNGestureHandlerRootView) parent;
                }
            }
            return rNGestureHandlerRootView;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final TypedValue getResolveOutValue() {
                return ButtonViewGroup.resolveOutValue;
            }

            public final void setResolveOutValue(@NotNull TypedValue typedValue) {
                Intrinsics.checkNotNullParameter(typedValue, "<set-?>");
                ButtonViewGroup.resolveOutValue = typedValue;
            }

            public final ButtonViewGroup getTouchResponder() {
                return ButtonViewGroup.touchResponder;
            }

            public final void setTouchResponder(@Nullable ButtonViewGroup buttonViewGroup) {
                ButtonViewGroup.touchResponder = buttonViewGroup;
            }

            public final ButtonViewGroup getSoundResponder() {
                return ButtonViewGroup.soundResponder;
            }

            public final void setSoundResponder(@Nullable ButtonViewGroup buttonViewGroup) {
                ButtonViewGroup.soundResponder = buttonViewGroup;
            }

            public final View.OnClickListener getDummyClickListener() {
                return ButtonViewGroup.dummyClickListener;
            }

            public final void setDummyClickListener(@NotNull View.OnClickListener onClickListener) {
                Intrinsics.checkNotNullParameter(onClickListener, "<set-?>");
                ButtonViewGroup.dummyClickListener = onClickListener;
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
