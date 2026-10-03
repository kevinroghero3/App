package com.facebook.fresco.vito.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class RoundedRectShape extends Shape {
    private final RectF rect;
    private final float rx;
    private final float ry;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedRectShape(@NotNull RectF rect, float f, float f2) {
        super(null);
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.rect = rect;
        this.rx = f;
        this.ry = f2;
    }

    public final RectF getRect() {
        return this.rect;
    }

    public final float getRx() {
        return this.rx;
    }

    public final float getRy() {
        return this.ry;
    }

    @Override // com.facebook.fresco.vito.renderer.Shape
    public void draw(@NotNull Canvas canvas, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawRoundRect(this.rect, this.rx, this.ry, paint);
    }
}
