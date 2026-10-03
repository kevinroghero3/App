package androidx.compose.ui.graphics.drawscope;

import androidx.annotation.FloatRange;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@DrawScopeMarker
public interface DrawScope extends Density {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: renamed from: drawArc-illE91I */
    void mo1624drawArcillE91I(@NotNull Brush brush, float f, float f2, boolean z, long j, long j2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* JADX INFO: renamed from: drawArc-yD3GUKo */
    void mo1625drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, @FloatRange(from = 0.0d, to = 1.0d) float f3, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* JADX INFO: renamed from: drawCircle-V9BoPsw */
    void mo1626drawCircleV9BoPsw(@NotNull Brush brush, float f, long j, @FloatRange(from = 0.0d, to = 1.0d) float f2, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* JADX INFO: renamed from: drawCircle-VaOC9Bg */
    void mo1627drawCircleVaOC9Bg(long j, float f, long j2, @FloatRange(from = 0.0d, to = 1.0d) float f2, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* JADX INFO: renamed from: drawImage-9jGpkUE */
    /* synthetic */ void mo1628drawImage9jGpkUE(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, @FloatRange(from = 0.0d, to = 1.0d) float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* JADX INFO: renamed from: drawImage-gbVJVH8 */
    void mo1630drawImagegbVJVH8(@NotNull ImageBitmap imageBitmap, long j, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* JADX INFO: renamed from: drawLine-1RTmtNc */
    void mo1631drawLine1RTmtNc(@NotNull Brush brush, long j, long j2, float f, int i, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float f2, @Nullable ColorFilter colorFilter, int i2);

    /* JADX INFO: renamed from: drawLine-NGM6Ib0 */
    void mo1632drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float f2, @Nullable ColorFilter colorFilter, int i2);

    /* JADX INFO: renamed from: drawOval-AsUm42w */
    void mo1633drawOvalAsUm42w(@NotNull Brush brush, long j, long j2, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* JADX INFO: renamed from: drawOval-n-J9OG0 */
    void mo1634drawOvalnJ9OG0(long j, long j2, long j3, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* JADX INFO: renamed from: drawPath-GBMwjPU */
    void mo1635drawPathGBMwjPU(@NotNull Path path, @NotNull Brush brush, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* JADX INFO: renamed from: drawPath-LG529CI */
    void mo1636drawPathLG529CI(@NotNull Path path, long j, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* JADX INFO: renamed from: drawPoints-F8ZwMP8 */
    void mo1637drawPointsF8ZwMP8(@NotNull List<Offset> list, int i, long j, float f, int i2, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float f2, @Nullable ColorFilter colorFilter, int i3);

    /* JADX INFO: renamed from: drawPoints-Gsft0Ws */
    void mo1638drawPointsGsft0Ws(@NotNull List<Offset> list, int i, @NotNull Brush brush, float f, int i2, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float f2, @Nullable ColorFilter colorFilter, int i3);

    /* JADX INFO: renamed from: drawRect-AsUm42w */
    void mo1639drawRectAsUm42w(@NotNull Brush brush, long j, long j2, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* JADX INFO: renamed from: drawRect-n-J9OG0 */
    void mo1640drawRectnJ9OG0(long j, long j2, long j3, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ */
    void mo1641drawRoundRectZuiqVtQ(@NotNull Brush brush, long j, long j2, long j3, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA */
    void mo1642drawRoundRectuAw5IA(long j, long j2, long j3, long j4, @NotNull DrawStyle drawStyle, @FloatRange(from = 0.0d, to = 1.0d) float f, @Nullable ColorFilter colorFilter, int i);

    DrawContext getDrawContext();

    LayoutDirection getLayoutDirection();

    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m1755roundToPxR2X_6o(@NotNull DrawScope drawScope, long j) {
            return DrawScope.super.mo2476roundToPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m1756roundToPx0680j_4(@NotNull DrawScope drawScope, float f) {
            return DrawScope.super.mo2477roundToPx0680j_4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m1757toDpGaN1DYA(@NotNull DrawScope drawScope, long j) {
            return DrawScope.super.mo2478toDpGaN1DYA(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m1758toDpu2uoSUM(@NotNull DrawScope drawScope, float f) {
            return DrawScope.super.mo2479toDpu2uoSUM(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m1759toDpu2uoSUM(@NotNull DrawScope drawScope, int i) {
            return DrawScope.super.mo2480toDpu2uoSUM(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m1760toDpSizekrfVVM(@NotNull DrawScope drawScope, long j) {
            return DrawScope.super.mo2481toDpSizekrfVVM(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m1761toPxR2X_6o(@NotNull DrawScope drawScope, long j) {
            return DrawScope.super.mo2482toPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m1762toPx0680j_4(@NotNull DrawScope drawScope, float f) {
            return DrawScope.super.mo2483toPx0680j_4(f);
        }

        @Deprecated
        public static Rect toRect(@NotNull DrawScope drawScope, @NotNull DpRect dpRect) {
            return DrawScope.super.toRect(dpRect);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m1763toSizeXkaWNTQ(@NotNull DrawScope drawScope, long j) {
            return DrawScope.super.mo2484toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m1764toSp0xMU5do(@NotNull DrawScope drawScope, float f) {
            return DrawScope.super.mo2485toSp0xMU5do(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m1765toSpkPz2Gy4(@NotNull DrawScope drawScope, float f) {
            return DrawScope.super.mo2486toSpkPz2Gy4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m1766toSpkPz2Gy4(@NotNull DrawScope drawScope, int i) {
            return DrawScope.super.mo2487toSpkPz2Gy4(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m1751getCenterF1C5BW0(@NotNull DrawScope drawScope) {
            return DrawScope.super.mo1726getCenterF1C5BW0();
        }

        @Deprecated
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m1752getSizeNHjbRc(@NotNull DrawScope drawScope) {
            return DrawScope.super.mo1727getSizeNHjbRc();
        }

        @Deprecated
        /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m1736drawImageAZ2fEMs(@NotNull DrawScope drawScope, @NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i, int i2) {
            DrawScope.super.mo1629drawImageAZ2fEMs(imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, i2);
        }

        @Deprecated
        /* JADX INFO: renamed from: record-JVtK1S4, reason: not valid java name */
        public static void m1753recordJVtK1S4(@NotNull DrawScope drawScope, @NotNull GraphicsLayer graphicsLayer, long j, @NotNull Function1<? super DrawScope, Unit> function1) {
            DrawScope.super.mo1728recordJVtK1S4(graphicsLayer, j, function1);
        }
    }

    /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
    default long mo1726getCenterF1C5BW0() {
        return SizeKt.m1007getCenteruvyYCjk(getDrawContext().mo1648getSizeNHjbRc());
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    default long mo1727getSizeNHjbRc() {
        return getDrawContext().mo1648getSizeNHjbRc();
    }

    /* JADX INFO: renamed from: drawLine-1RTmtNc$default, reason: not valid java name */
    static /* synthetic */ void m1712drawLine1RTmtNc$default(DrawScope drawScope, Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-1RTmtNc");
        }
        drawScope.mo1631drawLine1RTmtNc(brush, j, j2, (i3 & 8) != 0 ? 0.0f : f, (i3 & 16) != 0 ? Stroke.Companion.m1798getDefaultCapKaPHkGw() : i, (i3 & 32) != 0 ? null : pathEffect, (i3 & 64) != 0 ? 1.0f : f2, (i3 & 128) != 0 ? null : colorFilter, (i3 & 256) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i2);
    }

    /* JADX INFO: renamed from: drawLine-NGM6Ib0$default, reason: not valid java name */
    static /* synthetic */ void m1713drawLineNGM6Ib0$default(DrawScope drawScope, long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
        }
        drawScope.mo1632drawLineNGM6Ib0(j, j2, j3, (i3 & 8) != 0 ? 0.0f : f, (i3 & 16) != 0 ? Stroke.Companion.m1798getDefaultCapKaPHkGw() : i, (i3 & 32) != 0 ? null : pathEffect, (i3 & 64) != 0 ? 1.0f : f2, (i3 & 128) != 0 ? null : colorFilter, (i3 & 256) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i2);
    }

    /* JADX INFO: renamed from: drawRect-AsUm42w$default, reason: not valid java name */
    static /* synthetic */ void m1720drawRectAsUm42w$default(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
        }
        long jM944getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m944getZeroF1C5BW0() : j;
        drawScope.mo1639drawRectAsUm42w(brush, jM944getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m1724offsetSizePENXr5M(drawScope.mo1727getSizeNHjbRc(), jM944getZeroF1C5BW0) : j2, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawRect-n-J9OG0$default, reason: not valid java name */
    static /* synthetic */ void m1721drawRectnJ9OG0$default(DrawScope drawScope, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
        }
        long jM944getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m944getZeroF1C5BW0() : j2;
        drawScope.mo1640drawRectnJ9OG0(j, jM944getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m1724offsetSizePENXr5M(drawScope.mo1727getSizeNHjbRc(), jM944getZeroF1C5BW0) : j3, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawImage-gbVJVH8$default, reason: not valid java name */
    static /* synthetic */ void m1711drawImagegbVJVH8$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-gbVJVH8");
        }
        drawScope.mo1630drawImagegbVJVH8(imageBitmap, (i2 & 2) != 0 ? Offset.Companion.m944getZeroF1C5BW0() : j, (i2 & 4) != 0 ? 1.0f : f, (i2 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 16) != 0 ? null : colorFilter, (i2 & 32) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawImage-9jGpkUE$default, reason: not valid java name */
    static /* synthetic */ void m1709drawImage9jGpkUE$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-9jGpkUE");
        }
        long jM3788getZeronOccac = (i2 & 2) != 0 ? IntOffset.Companion.m3788getZeronOccac() : j;
        long jIntSize = (i2 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2;
        drawScope.mo1628drawImage9jGpkUE(imageBitmap, jM3788getZeronOccac, jIntSize, (i2 & 8) != 0 ? IntOffset.Companion.m3788getZeronOccac() : j3, (i2 & 16) != 0 ? jIntSize : j4, (i2 & 32) != 0 ? 1.0f : f, (i2 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 128) != 0 ? null : colorFilter, (i2 & 256) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawImage-AZ2fEMs$default, reason: not valid java name */
    static /* synthetic */ void m1710drawImageAZ2fEMs$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
        }
        long jM3788getZeronOccac = (i3 & 2) != 0 ? IntOffset.Companion.m3788getZeronOccac() : j;
        long jIntSize = (i3 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2;
        drawScope.mo1629drawImageAZ2fEMs(imageBitmap, jM3788getZeronOccac, jIntSize, (i3 & 8) != 0 ? IntOffset.Companion.m3788getZeronOccac() : j3, (i3 & 16) != 0 ? jIntSize : j4, (i3 & 32) != 0 ? 1.0f : f, (i3 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i3 & 128) != 0 ? null : colorFilter, (i3 & 256) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i, (i3 & 512) != 0 ? Companion.m1730getDefaultFilterQualityfv9h1I() : i2);
    }

    /* JADX INFO: renamed from: drawImage-AZ2fEMs */
    default void mo1629drawImageAZ2fEMs(@NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i, int i2) {
        m1710drawImageAZ2fEMs$default(this, imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, 0, 512, null);
    }

    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ$default, reason: not valid java name */
    static /* synthetic */ void m1722drawRoundRectZuiqVtQ$default(DrawScope drawScope, Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
        }
        long jM944getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m944getZeroF1C5BW0() : j;
        drawScope.mo1641drawRoundRectZuiqVtQ(brush, jM944getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m1724offsetSizePENXr5M(drawScope.mo1727getSizeNHjbRc(), jM944getZeroF1C5BW0) : j2, (i2 & 8) != 0 ? CornerRadius.Companion.m913getZerokKHJgLs() : j3, (i2 & 16) != 0 ? 1.0f : f, (i2 & 32) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 64) != 0 ? null : colorFilter, (i2 & 128) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA$default, reason: not valid java name */
    static /* synthetic */ void m1723drawRoundRectuAw5IA$default(DrawScope drawScope, long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-u-Aw5IA");
        }
        long jM944getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m944getZeroF1C5BW0() : j2;
        drawScope.mo1642drawRoundRectuAw5IA(j, jM944getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m1724offsetSizePENXr5M(drawScope.mo1727getSizeNHjbRc(), jM944getZeroF1C5BW0) : j3, (i2 & 8) != 0 ? CornerRadius.Companion.m913getZerokKHJgLs() : j4, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? 1.0f : f, (i2 & 64) != 0 ? null : colorFilter, (i2 & 128) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawCircle-V9BoPsw$default, reason: not valid java name */
    static /* synthetic */ void m1707drawCircleV9BoPsw$default(DrawScope drawScope, Brush brush, float f, long j, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-V9BoPsw");
        }
        drawScope.mo1626drawCircleV9BoPsw(brush, (i2 & 2) != 0 ? Size.m996getMinDimensionimpl(drawScope.mo1727getSizeNHjbRc()) / 2.0f : f, (i2 & 4) != 0 ? drawScope.mo1726getCenterF1C5BW0() : j, (i2 & 8) != 0 ? 1.0f : f2, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawCircle-VaOC9Bg$default, reason: not valid java name */
    static /* synthetic */ void m1708drawCircleVaOC9Bg$default(DrawScope drawScope, long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
        }
        drawScope.mo1627drawCircleVaOC9Bg(j, (i2 & 2) != 0 ? Size.m996getMinDimensionimpl(drawScope.mo1727getSizeNHjbRc()) / 2.0f : f, (i2 & 4) != 0 ? drawScope.mo1726getCenterF1C5BW0() : j2, (i2 & 8) != 0 ? 1.0f : f2, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawOval-AsUm42w$default, reason: not valid java name */
    static /* synthetic */ void m1714drawOvalAsUm42w$default(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-AsUm42w");
        }
        long jM944getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m944getZeroF1C5BW0() : j;
        drawScope.mo1633drawOvalAsUm42w(brush, jM944getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m1724offsetSizePENXr5M(drawScope.mo1727getSizeNHjbRc(), jM944getZeroF1C5BW0) : j2, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawOval-n-J9OG0$default, reason: not valid java name */
    static /* synthetic */ void m1715drawOvalnJ9OG0$default(DrawScope drawScope, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-n-J9OG0");
        }
        long jM944getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.Companion.m944getZeroF1C5BW0() : j2;
        drawScope.mo1634drawOvalnJ9OG0(j, jM944getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m1724offsetSizePENXr5M(drawScope.mo1727getSizeNHjbRc(), jM944getZeroF1C5BW0) : j3, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawArc-illE91I$default, reason: not valid java name */
    static /* synthetic */ void m1705drawArcillE91I$default(DrawScope drawScope, Brush brush, float f, float f2, boolean z, long j, long j2, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-illE91I");
        }
        long jM944getZeroF1C5BW0 = (i2 & 16) != 0 ? Offset.Companion.m944getZeroF1C5BW0() : j;
        drawScope.mo1624drawArcillE91I(brush, f, f2, z, jM944getZeroF1C5BW0, (i2 & 32) != 0 ? drawScope.m1724offsetSizePENXr5M(drawScope.mo1727getSizeNHjbRc(), jM944getZeroF1C5BW0) : j2, (i2 & 64) != 0 ? 1.0f : f3, (i2 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 256) != 0 ? null : colorFilter, (i2 & 512) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawArc-yD3GUKo$default, reason: not valid java name */
    static /* synthetic */ void m1706drawArcyD3GUKo$default(DrawScope drawScope, long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-yD3GUKo");
        }
        long jM944getZeroF1C5BW0 = (i2 & 16) != 0 ? Offset.Companion.m944getZeroF1C5BW0() : j2;
        drawScope.mo1625drawArcyD3GUKo(j, f, f2, z, jM944getZeroF1C5BW0, (i2 & 32) != 0 ? drawScope.m1724offsetSizePENXr5M(drawScope.mo1727getSizeNHjbRc(), jM944getZeroF1C5BW0) : j3, (i2 & 64) != 0 ? 1.0f : f3, (i2 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 256) != 0 ? null : colorFilter, (i2 & 512) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawPath-LG529CI$default, reason: not valid java name */
    static /* synthetic */ void m1717drawPathLG529CI$default(DrawScope drawScope, Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-LG529CI");
        }
        drawScope.mo1636drawPathLG529CI(path, j, (i2 & 4) != 0 ? 1.0f : f, (i2 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 16) != 0 ? null : colorFilter, (i2 & 32) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawPath-GBMwjPU$default, reason: not valid java name */
    static /* synthetic */ void m1716drawPathGBMwjPU$default(DrawScope drawScope, Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
        }
        if ((i2 & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i2 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i2 & 16) != 0) {
            colorFilter = null;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i2 & 32) != 0) {
            i = Companion.m1729getDefaultBlendMode0nO6VwU();
        }
        drawScope.mo1635drawPathGBMwjPU(path, brush, f2, drawStyle2, colorFilter2, i);
    }

    /* JADX INFO: renamed from: drawPoints-F8ZwMP8$default, reason: not valid java name */
    static /* synthetic */ void m1718drawPointsF8ZwMP8$default(DrawScope drawScope, List list, int i, long j, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-F8ZwMP8");
        }
        drawScope.mo1637drawPointsF8ZwMP8(list, i, j, (i4 & 8) != 0 ? 0.0f : f, (i4 & 16) != 0 ? StrokeCap.Companion.m1524getButtKaPHkGw() : i2, (i4 & 32) != 0 ? null : pathEffect, (i4 & 64) != 0 ? 1.0f : f2, (i4 & 128) != 0 ? null : colorFilter, (i4 & 256) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i3);
    }

    /* JADX INFO: renamed from: drawPoints-Gsft0Ws$default, reason: not valid java name */
    static /* synthetic */ void m1719drawPointsGsft0Ws$default(DrawScope drawScope, List list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-Gsft0Ws");
        }
        drawScope.mo1638drawPointsGsft0Ws(list, i, brush, (i4 & 8) != 0 ? 0.0f : f, (i4 & 16) != 0 ? StrokeCap.Companion.m1524getButtKaPHkGw() : i2, (i4 & 32) != 0 ? null : pathEffect, (i4 & 64) != 0 ? 1.0f : f2, (i4 & 128) != 0 ? null : colorFilter, (i4 & 256) != 0 ? Companion.m1729getDefaultBlendMode0nO6VwU() : i3);
    }

    /* JADX INFO: renamed from: record-JVtK1S4$default, reason: not valid java name */
    static /* synthetic */ void m1725recordJVtK1S4$default(DrawScope drawScope, GraphicsLayer graphicsLayer, long j, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: record-JVtK1S4");
        }
        if ((i & 1) != 0) {
            j = IntSizeKt.m3831toIntSizeuvyYCjk(drawScope.mo1727getSizeNHjbRc());
        }
        drawScope.mo1728recordJVtK1S4(graphicsLayer, j, function1);
    }

    /* JADX INFO: renamed from: record-JVtK1S4, reason: not valid java name */
    default void mo1728recordJVtK1S4(@NotNull GraphicsLayer graphicsLayer, long j, @NotNull final Function1<? super DrawScope, Unit> function1) {
        graphicsLayer.m1821recordmLhObY(this, getLayoutDirection(), j, new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.drawscope.DrawScope$record$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DrawScope drawScope) {
                DrawScope drawScope2 = this.this$0;
                Density density = drawScope.getDrawContext().getDensity();
                LayoutDirection layoutDirection = drawScope.getDrawContext().getLayoutDirection();
                Canvas canvas = drawScope.getDrawContext().getCanvas();
                long jMo1648getSizeNHjbRc = drawScope.getDrawContext().mo1648getSizeNHjbRc();
                GraphicsLayer graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
                Function1<DrawScope, Unit> function2 = function1;
                Density density2 = drawScope2.getDrawContext().getDensity();
                LayoutDirection layoutDirection2 = drawScope2.getDrawContext().getLayoutDirection();
                Canvas canvas2 = drawScope2.getDrawContext().getCanvas();
                long jMo1648getSizeNHjbRc2 = drawScope2.getDrawContext().mo1648getSizeNHjbRc();
                GraphicsLayer graphicsLayer3 = drawScope2.getDrawContext().getGraphicsLayer();
                DrawContext drawContext = drawScope2.getDrawContext();
                drawContext.setDensity(density);
                drawContext.setLayoutDirection(layoutDirection);
                drawContext.setCanvas(canvas);
                drawContext.mo1649setSizeuvyYCjk(jMo1648getSizeNHjbRc);
                drawContext.setGraphicsLayer(graphicsLayer2);
                canvas.save();
                try {
                    function2.invoke(drawScope2);
                } finally {
                    canvas.restore();
                    DrawContext drawContext2 = drawScope2.getDrawContext();
                    drawContext2.setDensity(density2);
                    drawContext2.setLayoutDirection(layoutDirection2);
                    drawContext2.setCanvas(canvas2);
                    drawContext2.mo1649setSizeuvyYCjk(jMo1648getSizeNHjbRc2);
                    drawContext2.setGraphicsLayer(graphicsLayer3);
                }
            }
        });
    }

    /* JADX INFO: renamed from: offsetSize-PENXr5M, reason: not valid java name */
    private default long m1724offsetSizePENXr5M(long j, long j2) {
        return SizeKt.Size(Size.m997getWidthimpl(j) - Offset.m928getXimpl(j2), Size.m994getHeightimpl(j) - Offset.m929getYimpl(j2));
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int DefaultBlendMode = BlendMode.Companion.m1111getSrcOver0nO6VwU();
        private static final int DefaultFilterQuality = FilterQuality.Companion.m1270getLowfv9h1I();

        private Companion() {
        }

        /* JADX INFO: renamed from: getDefaultBlendMode-0nO6VwU, reason: not valid java name */
        public final int m1729getDefaultBlendMode0nO6VwU() {
            return DefaultBlendMode;
        }

        /* JADX INFO: renamed from: getDefaultFilterQuality-f-v9h1I, reason: not valid java name */
        public final int m1730getDefaultFilterQualityfv9h1I() {
            return DefaultFilterQuality;
        }
    }
}
