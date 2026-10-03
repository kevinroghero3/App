package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class PointKt {
    public static final int component1(@NotNull Point point) {
        return point.x;
    }

    public static final int component2(@NotNull Point point) {
        return point.y;
    }

    public static final float component1(@NotNull PointF pointF) {
        return pointF.x;
    }

    public static final float component2(@NotNull PointF pointF) {
        return pointF.y;
    }

    public static final Point plus(@NotNull Point point, @NotNull Point point2) {
        Point point3 = new Point(point.x, point.y);
        point3.offset(point2.x, point2.y);
        return point3;
    }

    public static final PointF plus(@NotNull PointF pointF, @NotNull PointF pointF2) {
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    public static final Point plus(@NotNull Point point, int i) {
        Point point2 = new Point(point.x, point.y);
        point2.offset(i, i);
        return point2;
    }

    public static final PointF plus(@NotNull PointF pointF, float f) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f, f);
        return pointF2;
    }

    public static final Point minus(@NotNull Point point, @NotNull Point point2) {
        Point point3 = new Point(point.x, point.y);
        point3.offset(-point2.x, -point2.y);
        return point3;
    }

    public static final PointF minus(@NotNull PointF pointF, @NotNull PointF pointF2) {
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    public static final Point minus(@NotNull Point point, int i) {
        Point point2 = new Point(point.x, point.y);
        int i2 = -i;
        point2.offset(i2, i2);
        return point2;
    }

    public static final PointF minus(@NotNull PointF pointF, float f) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f2 = -f;
        pointF2.offset(f2, f2);
        return pointF2;
    }

    public static final Point unaryMinus(@NotNull Point point) {
        return new Point(-point.x, -point.y);
    }

    public static final PointF unaryMinus(@NotNull PointF pointF) {
        return new PointF(-pointF.x, -pointF.y);
    }

    public static final Point times(@NotNull Point point, float f) {
        return new Point(Math.round(point.x * f), Math.round(point.y * f));
    }

    public static final PointF times(@NotNull PointF pointF, float f) {
        return new PointF(pointF.x * f, pointF.y * f);
    }

    public static final Point div(@NotNull Point point, float f) {
        return new Point(Math.round(point.x / f), Math.round(point.y / f));
    }

    public static final PointF div(@NotNull PointF pointF, float f) {
        return new PointF(pointF.x / f, pointF.y / f);
    }

    public static final PointF toPointF(@NotNull Point point) {
        return new PointF(point);
    }

    public static final Point toPoint(@NotNull PointF pointF) {
        return new Point((int) pointF.x, (int) pointF.y);
    }
}
