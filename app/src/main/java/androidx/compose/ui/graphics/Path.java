package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface Path {
    public static final Companion Companion = Companion.$$INSTANCE;

    public enum Direction {
        CounterClockwise,
        Clockwise
    }

    void addArc(@NotNull Rect rect, float f, float f2);

    void addArcRad(@NotNull Rect rect, float f, float f2);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of addOval() with a winding direction", replaceWith = @ReplaceWith(expression = "addOval(oval)", imports = {}))
    /* synthetic */ void addOval(Rect rect);

    void addOval(@NotNull Rect rect, @NotNull Direction direction);

    /* JADX INFO: renamed from: addPath-Uv8p0NA */
    void mo1059addPathUv8p0NA(@NotNull Path path, long j);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of addRect() with a winding direction", replaceWith = @ReplaceWith(expression = "addRect(rect)", imports = {}))
    /* synthetic */ void addRect(Rect rect);

    void addRect(@NotNull Rect rect, @NotNull Direction direction);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of addRoundRect() with a winding direction", replaceWith = @ReplaceWith(expression = "addRoundRect(roundRect)", imports = {}))
    /* synthetic */ void addRoundRect(RoundRect roundRect);

    void addRoundRect(@NotNull RoundRect roundRect, @NotNull Direction direction);

    void arcTo(@NotNull Rect rect, float f, float f2, boolean z);

    void close();

    void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

    Rect getBounds();

    /* JADX INFO: renamed from: getFillType-Rg-k1Os */
    int mo1060getFillTypeRgk1Os();

    boolean isConvex();

    boolean isEmpty();

    void lineTo(float f, float f2);

    void moveTo(float f, float f2);

    /* JADX INFO: renamed from: op-N5in7k0 */
    boolean mo1061opN5in7k0(@NotNull Path path, @NotNull Path path2, int i);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use quadraticTo() for consistency with cubicTo()", replaceWith = @ReplaceWith(expression = "quadraticTo(x1, y1, x2, y2)", imports = {}))
    void quadraticBezierTo(float f, float f2, float f3, float f4);

    void relativeCubicTo(float f, float f2, float f3, float f4, float f5, float f6);

    void relativeLineTo(float f, float f2);

    void relativeMoveTo(float f, float f2);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use relativeQuadraticTo() for consistency with relativeCubicTo()", replaceWith = @ReplaceWith(expression = "relativeQuadraticTo(dx1, dy1, dx2, dy2)", imports = {}))
    void relativeQuadraticBezierTo(float f, float f2, float f3, float f4);

    void reset();

    /* JADX INFO: renamed from: setFillType-oQ8Xj4U */
    void mo1062setFillTypeoQ8Xj4U(int i);

    /* JADX INFO: renamed from: transform-58bKbWc */
    default void mo1063transform58bKbWc(@NotNull float[] fArr) {
    }

    /* JADX INFO: renamed from: translate-k-4lQ0M */
    void mo1064translatek4lQ0M(long j);

    public static final class DefaultImpls {
        @Deprecated
        public static void quadraticTo(@NotNull Path path, float f, float f2, float f3, float f4) {
            Path.super.quadraticTo(f, f2, f3, f4);
        }

        @Deprecated
        public static void relativeQuadraticTo(@NotNull Path path, float f, float f2, float f3, float f4) {
            Path.super.relativeQuadraticTo(f, f2, f3, f4);
        }

        @Deprecated
        public static void arcToRad(@NotNull Path path, @NotNull Rect rect, float f, float f2, boolean z) {
            Path.super.arcToRad(rect, f, f2, z);
        }

        @Deprecated
        public static void rewind(@NotNull Path path) {
            Path.super.rewind();
        }

        @Deprecated
        /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
        public static void m1443transform58bKbWc(@NotNull Path path, @NotNull float[] fArr) {
            Path.super.mo1063transform58bKbWc(fArr);
        }

        @Deprecated
        public static PathIterator iterator(@NotNull Path path) {
            return Path.super.iterator();
        }

        @Deprecated
        public static PathIterator iterator(@NotNull Path path, @NotNull PathIterator.ConicEvaluation conicEvaluation, float f) {
            return Path.super.iterator(conicEvaluation, f);
        }

        @Deprecated
        public static Path plus(@NotNull Path path, @NotNull Path path2) {
            return Path.super.plus(path2);
        }

        @Deprecated
        public static Path minus(@NotNull Path path, @NotNull Path path2) {
            return Path.super.minus(path2);
        }

        @Deprecated
        public static Path or(@NotNull Path path, @NotNull Path path2) {
            return Path.super.or(path2);
        }

        @Deprecated
        public static Path and(@NotNull Path path, @NotNull Path path2) {
            return Path.super.and(path2);
        }

        @Deprecated
        public static Path xor(@NotNull Path path, @NotNull Path path2) {
            return Path.super.xor(path2);
        }
    }

    default void quadraticTo(float f, float f2, float f3, float f4) {
        quadraticBezierTo(f, f2, f3, f4);
    }

    default void relativeQuadraticTo(float f, float f2, float f3, float f4) {
        relativeQuadraticBezierTo(f, f2, f3, f4);
    }

    default void arcToRad(@NotNull Rect rect, float f, float f2, boolean z) {
        arcTo(rect, DegreesKt.degrees(f), DegreesKt.degrees(f2), z);
    }

    static /* synthetic */ void addRect$default(Path path, Rect rect, Direction direction, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRect");
        }
        if ((i & 2) != 0) {
            direction = Direction.CounterClockwise;
        }
        path.addRect(rect, direction);
    }

    static /* synthetic */ void addOval$default(Path path, Rect rect, Direction direction, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addOval");
        }
        if ((i & 2) != 0) {
            direction = Direction.CounterClockwise;
        }
        path.addOval(rect, direction);
    }

    static /* synthetic */ void addRoundRect$default(Path path, RoundRect roundRect, Direction direction, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRoundRect");
        }
        if ((i & 2) != 0) {
            direction = Direction.CounterClockwise;
        }
        path.addRoundRect(roundRect, direction);
    }

    /* JADX INFO: renamed from: addPath-Uv8p0NA$default, reason: not valid java name */
    static /* synthetic */ void m1440addPathUv8p0NA$default(Path path, Path path2, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPath-Uv8p0NA");
        }
        if ((i & 2) != 0) {
            j = Offset.Companion.m944getZeroF1C5BW0();
        }
        path.mo1059addPathUv8p0NA(path2, j);
    }

    default void rewind() {
        reset();
    }

    default PathIterator iterator() {
        return AndroidPathIterator_androidKt.PathIterator$default(this, null, 0.0f, 6, null);
    }

    static /* synthetic */ PathIterator iterator$default(Path path, PathIterator.ConicEvaluation conicEvaluation, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: iterator");
        }
        if ((i & 2) != 0) {
            f = 0.25f;
        }
        return path.iterator(conicEvaluation, f);
    }

    default PathIterator iterator(@NotNull PathIterator.ConicEvaluation conicEvaluation, float f) {
        return AndroidPathIterator_androidKt.PathIterator(this, conicEvaluation, f);
    }

    default Path plus(@NotNull Path path) {
        Path Path = AndroidPath_androidKt.Path();
        Path.mo1061opN5in7k0(this, path, PathOperation.Companion.m1465getUnionb3I0S0c());
        return Path;
    }

    default Path minus(@NotNull Path path) {
        Path Path = AndroidPath_androidKt.Path();
        Path.mo1061opN5in7k0(this, path, PathOperation.Companion.m1462getDifferenceb3I0S0c());
        return Path;
    }

    default Path or(@NotNull Path path) {
        return plus(path);
    }

    default Path and(@NotNull Path path) {
        Path Path = AndroidPath_androidKt.Path();
        Path.mo1061opN5in7k0(this, path, PathOperation.Companion.m1463getIntersectb3I0S0c());
        return Path;
    }

    default Path xor(@NotNull Path path) {
        Path Path = AndroidPath_androidKt.Path();
        Path.mo1061opN5in7k0(this, path, PathOperation.Companion.m1466getXorb3I0S0c());
        return Path;
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX INFO: renamed from: combine-xh6zSI8, reason: not valid java name */
        public final Path m1441combinexh6zSI8(int i, @NotNull Path path, @NotNull Path path2) {
            Path Path = AndroidPath_androidKt.Path();
            if (Path.mo1061opN5in7k0(path, path2, i)) {
                return Path;
            }
            throw new IllegalArgumentException("Path.combine() failed.  This may be due an invalid path; in particular, check for NaN values.");
        }
    }
}
