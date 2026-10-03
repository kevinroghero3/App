package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class RectKt {
    public static final int component1(@NotNull Rect rect) {
        return rect.left;
    }

    public static final int component2(@NotNull Rect rect) {
        return rect.top;
    }

    public static final int component3(@NotNull Rect rect) {
        return rect.right;
    }

    public static final int component4(@NotNull Rect rect) {
        return rect.bottom;
    }

    public static final float component1(@NotNull RectF rectF) {
        return rectF.left;
    }

    public static final float component2(@NotNull RectF rectF) {
        return rectF.top;
    }

    public static final float component3(@NotNull RectF rectF) {
        return rectF.right;
    }

    public static final float component4(@NotNull RectF rectF) {
        return rectF.bottom;
    }

    public static final Rect plus(@NotNull Rect rect, @NotNull Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    public static final RectF plus(@NotNull RectF rectF, @NotNull RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    public static final Rect plus(@NotNull Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        rect2.offset(i, i);
        return rect2;
    }

    public static final RectF plus(@NotNull RectF rectF, float f) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f, f);
        return rectF2;
    }

    public static final Rect plus(@NotNull Rect rect, @NotNull Point point) {
        Rect rect2 = new Rect(rect);
        rect2.offset(point.x, point.y);
        return rect2;
    }

    public static final RectF plus(@NotNull RectF rectF, @NotNull PointF pointF) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(pointF.x, pointF.y);
        return rectF2;
    }

    public static final Region minus(@NotNull Rect rect, @NotNull Rect rect2) {
        Region region = new Region(rect);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Rect minus(@NotNull Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        int i2 = -i;
        rect2.offset(i2, i2);
        return rect2;
    }

    public static final RectF minus(@NotNull RectF rectF, float f) {
        RectF rectF2 = new RectF(rectF);
        float f2 = -f;
        rectF2.offset(f2, f2);
        return rectF2;
    }

    public static final Rect minus(@NotNull Rect rect, @NotNull Point point) {
        Rect rect2 = new Rect(rect);
        rect2.offset(-point.x, -point.y);
        return rect2;
    }

    public static final RectF minus(@NotNull RectF rectF, @NotNull PointF pointF) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-pointF.x, -pointF.y);
        return rectF2;
    }

    public static final Rect times(@NotNull Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        rect2.top *= i;
        rect2.left *= i;
        rect2.right *= i;
        rect2.bottom *= i;
        return rect2;
    }

    public static final RectF times(@NotNull RectF rectF, float f) {
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }

    public static final Rect and(@NotNull Rect rect, @NotNull Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        return rect3;
    }

    public static final RectF and(@NotNull RectF rectF, @NotNull RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.intersect(rectF2);
        return rectF3;
    }

    public static final Region xor(@NotNull Rect rect, @NotNull Rect rect2) {
        Region region = new Region(rect);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final boolean contains(@NotNull Rect rect, @NotNull Point point) {
        return rect.contains(point.x, point.y);
    }

    public static final boolean contains(@NotNull RectF rectF, @NotNull PointF pointF) {
        return rectF.contains(pointF.x, pointF.y);
    }

    public static final RectF toRectF(@NotNull Rect rect) {
        return new RectF(rect);
    }

    public static final Rect toRect(@NotNull RectF rectF) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    public static final Region toRegion(@NotNull Rect rect) {
        return new Region(rect);
    }

    public static final RectF transform(@NotNull RectF rectF, @NotNull Matrix matrix) {
        matrix.mapRect(rectF);
        return rectF;
    }

    public static final Region minus(@NotNull RectF rectF, @NotNull RectF rectF2) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    public static final RectF times(@NotNull RectF rectF, int i) {
        float f = i;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }

    public static final Rect or(@NotNull Rect rect, @NotNull Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    public static final RectF or(@NotNull RectF rectF, @NotNull RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    public static final Region xor(@NotNull RectF rectF, @NotNull RectF rectF2) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final Region toRegion(@NotNull RectF rectF) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }
}
