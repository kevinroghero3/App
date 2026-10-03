package com.facebook.fresco.vito.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class CircleShape extends Shape {
    private final Boolean antiAliased;
    private final float cx;
    private final float cy;
    private final float radius;

    public /* synthetic */ CircleShape(float f, float f2, float f3, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, (i & 8) != 0 ? null : bool);
    }

    public CircleShape(float f, float f2, float f3, @Nullable Boolean bool) {
        super(null);
        this.cx = f;
        this.cy = f2;
        this.radius = f3;
        this.antiAliased = bool;
    }

    @Override // com.facebook.fresco.vito.renderer.Shape
    public void draw(@NotNull Canvas canvas, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (this.antiAliased != null) {
            boolean zIsAntiAlias = paint.isAntiAlias();
            paint.setAntiAlias(this.antiAliased.booleanValue());
            canvas.drawCircle(this.cx, this.cy, this.radius, paint);
            paint.setAntiAlias(zIsAntiAlias);
            return;
        }
        canvas.drawCircle(this.cx, this.cy, this.radius, paint);
    }
}
