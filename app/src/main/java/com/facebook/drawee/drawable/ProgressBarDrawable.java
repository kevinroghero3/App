package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ProgressBarDrawable extends Drawable implements CloneableDrawable {
    private boolean _isVertical;
    private int _radius;
    private boolean hideWhenZero;
    private int level;
    private final Paint paint = new Paint(1);
    private final Path path = new Path();
    private final RectF rect = new RectF();
    private int _backgroundColor = Integer.MIN_VALUE;
    private int _color = -2147450625;
    private int _padding = 10;
    private int _barWidth = 20;

    public final boolean getHideWhenZero() {
        return this.hideWhenZero;
    }

    public final void setHideWhenZero(boolean z) {
        this.hideWhenZero = z;
    }

    public final int getColor() {
        return this._color;
    }

    public final void setColor(int i) {
        if (this._color != i) {
            this._color = i;
            invalidateSelf();
        }
    }

    public final int getBackgroundColor() {
        return this._backgroundColor;
    }

    public final void setBackgroundColor(int i) {
        if (this._backgroundColor != i) {
            this._backgroundColor = i;
            invalidateSelf();
        }
    }

    public final void setPadding(int i) {
        if (this._padding != i) {
            this._padding = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NotNull Rect padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        int i = this._padding;
        padding.set(i, i, i, i);
        return this._padding != 0;
    }

    public final int getBarWidth() {
        return this._barWidth;
    }

    public final void setBarWidth(int i) {
        if (this._barWidth != i) {
            this._barWidth = i;
            invalidateSelf();
        }
    }

    public final int getRadius() {
        return this._radius;
    }

    public final void setRadius(int i) {
        if (this._radius != i) {
            this._radius = i;
            invalidateSelf();
        }
    }

    public final boolean isVertical() {
        return this._isVertical;
    }

    public final void setVertical(boolean z) {
        if (this._isVertical != z) {
            this._isVertical = z;
            invalidateSelf();
        }
    }

    public final void setIsVertical(boolean z) {
        setVertical(z);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        this.level = i;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return DrawableUtils.getOpacityFromColor(this.paint.getColor());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.hideWhenZero && this.level == 0) {
            return;
        }
        if (this._isVertical) {
            drawVerticalBar(canvas, 10000, this._backgroundColor);
            drawVerticalBar(canvas, this.level, this._color);
        } else {
            drawHorizontalBar(canvas, 10000, this._backgroundColor);
            drawHorizontalBar(canvas, this.level, this._color);
        }
    }

    @Override // com.facebook.drawee.drawable.CloneableDrawable
    public Drawable cloneDrawable() {
        ProgressBarDrawable progressBarDrawable = new ProgressBarDrawable();
        progressBarDrawable._backgroundColor = this._backgroundColor;
        progressBarDrawable._color = this._color;
        progressBarDrawable._padding = this._padding;
        progressBarDrawable._barWidth = this._barWidth;
        progressBarDrawable.level = this.level;
        progressBarDrawable._radius = this._radius;
        progressBarDrawable.hideWhenZero = this.hideWhenZero;
        progressBarDrawable._isVertical = this._isVertical;
        return progressBarDrawable;
    }

    private final void drawHorizontalBar(Canvas canvas, int i, int i2) {
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        int iWidth = bounds.width();
        int i3 = this._padding;
        int i4 = ((iWidth - (i3 * 2)) * i) / 10000;
        int i5 = bounds.left + i3;
        int i6 = bounds.bottom;
        int i7 = this._barWidth;
        int i8 = (i6 - i3) - i7;
        this.rect.set(i5, i8, i5 + i4, i8 + i7);
        drawBar(canvas, i2);
    }

    private final void drawVerticalBar(Canvas canvas, int i, int i2) {
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        int iHeight = bounds.height();
        int i3 = this._padding;
        int i4 = ((iHeight - (i3 * 2)) * i) / 10000;
        int i5 = bounds.left + i3;
        int i6 = bounds.top + i3;
        this.rect.set(i5, i6, i5 + this._barWidth, i6 + i4);
        drawBar(canvas, i2);
    }

    private final void drawBar(Canvas canvas, int i) {
        this.paint.setColor(i);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.path.reset();
        this.path.setFillType(Path.FillType.EVEN_ODD);
        this.path.addRoundRect(this.rect, (float) Math.min(this._radius, this._barWidth / 2), (float) Math.min(this._radius, this._barWidth / 2), Path.Direction.CW);
        canvas.drawPath(this.path, this.paint);
    }
}
