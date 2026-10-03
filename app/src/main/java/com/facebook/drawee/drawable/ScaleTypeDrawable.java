package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Objects;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ScaleTypeDrawable extends ForwardingDrawable {
    public Matrix mDrawMatrix;
    public PointF mFocusPoint;
    private ScalingUtils.ScaleType mScaleType;
    public Object mScaleTypeState;
    public int mUnderlyingHeight;
    public int mUnderlyingWidth;
    private final Matrix tempMatrix;

    public static /* synthetic */ void getMDrawMatrix$annotations() {
    }

    public static /* synthetic */ void getMFocusPoint$annotations() {
    }

    public static /* synthetic */ void getMScaleType$annotations() {
    }

    public static /* synthetic */ void getMScaleTypeState$annotations() {
    }

    public static /* synthetic */ void getMUnderlyingHeight$annotations() {
    }

    public static /* synthetic */ void getMUnderlyingWidth$annotations() {
    }

    public final ScalingUtils.ScaleType getMScaleType() {
        return this.mScaleType;
    }

    public final void setMScaleType(@NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "<set-?>");
        this.mScaleType = scaleType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleTypeDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        super(drawable);
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.tempMatrix = new Matrix();
        this.mScaleType = scaleType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleTypeDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType, @Nullable PointF pointF) {
        super(drawable);
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.tempMatrix = new Matrix();
        this.mScaleType = scaleType;
        this.mFocusPoint = pointF;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    public Drawable setCurrent(@Nullable Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public final ScalingUtils.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public final void setScaleType(@NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        if (Objects.equal(this.mScaleType, scaleType)) {
            return;
        }
        this.mScaleType = scaleType;
        this.mScaleTypeState = null;
        configureBounds();
        invalidateSelf();
    }

    public final PointF getFocusPoint() {
        return this.mFocusPoint;
    }

    public final void setFocusPoint(@Nullable PointF pointF) {
        if (Objects.equal(this.mFocusPoint, pointF)) {
            return;
        }
        if (pointF == null) {
            this.mFocusPoint = null;
        } else {
            if (this.mFocusPoint == null) {
                this.mFocusPoint = new PointF();
            }
            PointF pointF2 = this.mFocusPoint;
            Intrinsics.checkNotNull(pointF2);
            pointF2.set(pointF);
        }
        configureBounds();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        configureBoundsIfUnderlyingChanged();
        if (this.mDrawMatrix != null) {
            int iSave = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.mDrawMatrix);
            super.draw(canvas);
            canvas.restoreToCount(iSave);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(@NotNull Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        configureBounds();
    }

    private final void configureBoundsIfUnderlyingChanged() {
        boolean z;
        ScalingUtils.ScaleType scaleType = this.mScaleType;
        if (scaleType instanceof ScalingUtils.StatefulScaleType) {
            Intrinsics.checkNotNull(scaleType, "null cannot be cast to non-null type com.facebook.drawee.drawable.ScalingUtils.StatefulScaleType");
            Object state = ((ScalingUtils.StatefulScaleType) scaleType).getState();
            Intrinsics.checkNotNullExpressionValue(state, "getState(...)");
            z = !Intrinsics.areEqual(state, this.mScaleTypeState);
            this.mScaleTypeState = state;
        } else {
            z = false;
        }
        Drawable current = getCurrent();
        if (current == null) {
            return;
        }
        if (this.mUnderlyingWidth == current.getIntrinsicWidth() && this.mUnderlyingHeight == current.getIntrinsicHeight() && !z) {
            return;
        }
        configureBounds();
    }

    public final void configureBounds() {
        float f;
        float f2;
        Drawable current = getCurrent();
        if (current == null) {
            this.mUnderlyingHeight = 0;
            this.mUnderlyingWidth = 0;
            this.mDrawMatrix = null;
            return;
        }
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.mUnderlyingWidth = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.mUnderlyingHeight = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
            return;
        }
        if (intrinsicWidth == iWidth && intrinsicHeight == iHeight) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
            return;
        }
        if (this.mScaleType == ScalingUtils.ScaleType.FIT_XY) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
            return;
        }
        current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        this.tempMatrix.reset();
        ScalingUtils.ScaleType scaleType = this.mScaleType;
        Matrix matrix = this.tempMatrix;
        PointF pointF = this.mFocusPoint;
        if (pointF != null) {
            Intrinsics.checkNotNull(pointF);
            f = pointF.x;
        } else {
            f = 0.5f;
        }
        PointF pointF2 = this.mFocusPoint;
        if (pointF2 != null) {
            Intrinsics.checkNotNull(pointF2);
            f2 = pointF2.y;
        } else {
            f2 = 0.5f;
        }
        scaleType.getTransform(matrix, bounds, intrinsicWidth, intrinsicHeight, f, f2);
        this.mDrawMatrix = this.tempMatrix;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(@NotNull Matrix transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        getParentTransform(transform);
        configureBoundsIfUnderlyingChanged();
        Matrix matrix = this.mDrawMatrix;
        if (matrix != null) {
            transform.preConcat(matrix);
        }
    }
}
