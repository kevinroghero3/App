package androidx.compose.ui.graphics.drawscope;

import androidx.annotation.FloatRange;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import ch.qos.logback.core.CoreConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class CanvasDrawScope implements DrawScope {
    private Paint fillPaint;
    private Paint strokePaint;
    private final DrawParams drawParams = new DrawParams(null, null, null, 0, 15, null);
    private final DrawContext drawContext = new DrawContext() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1
        private GraphicsLayer graphicsLayer;
        private final DrawTransform transform = CanvasDrawScopeKt.asDrawTransform(this);

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public Canvas getCanvas() {
            return this.this$0.getDrawParams().getCanvas();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void setCanvas(@NotNull Canvas canvas) {
            this.this$0.getDrawParams().setCanvas(canvas);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public long mo1648getSizeNHjbRc() {
            return this.this$0.getDrawParams().m1646getSizeNHjbRc();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
        public void mo1649setSizeuvyYCjk(long j) {
            this.this$0.getDrawParams().m1647setSizeuvyYCjk(j);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public DrawTransform getTransform() {
            return this.transform;
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public LayoutDirection getLayoutDirection() {
            return this.this$0.getDrawParams().getLayoutDirection();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void setLayoutDirection(@NotNull LayoutDirection layoutDirection) {
            this.this$0.getDrawParams().setLayoutDirection(layoutDirection);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public Density getDensity() {
            return this.this$0.getDrawParams().getDensity();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void setDensity(@NotNull Density density) {
            this.this$0.getDrawParams().setDensity(density);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public GraphicsLayer getGraphicsLayer() {
            return this.graphicsLayer;
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void setGraphicsLayer(@Nullable GraphicsLayer graphicsLayer) {
            this.graphicsLayer = graphicsLayer;
        }
    };

    public static /* synthetic */ void getDrawParams$annotations() {
    }

    public final DrawParams getDrawParams() {
        return this.drawParams;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public LayoutDirection getLayoutDirection() {
        return this.drawParams.getLayoutDirection();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.drawParams.getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.drawParams.getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public DrawContext getDrawContext() {
        return this.drawContext;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-1RTmtNc, reason: not valid java name */
    public void mo1631drawLine1RTmtNc(@NotNull Brush brush, long j, long j2, float f, int i, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float f2, @Nullable ColorFilter colorFilter, int i2) {
        this.drawParams.getCanvas().mo1028drawLineWko1d7g(j, j2, m1621configureStrokePaintho4zsrM$default(this, brush, f, 4.0f, i, StrokeJoin.Companion.m1535getMiterLxFBmk8(), pathEffect, f2, colorFilter, i2, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-NGM6Ib0, reason: not valid java name */
    public void mo1632drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float f2, @Nullable ColorFilter colorFilter, int i2) {
        this.drawParams.getCanvas().mo1028drawLineWko1d7g(j2, j3, m1619configureStrokePaintQ_0CZUI$default(this, j, f, 4.0f, i, StrokeJoin.Companion.m1535getMiterLxFBmk8(), pathEffect, f2, colorFilter, i2, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-AsUm42w, reason: not valid java name */
    public void mo1639drawRectAsUm42w(@NotNull Brush brush, long j, long j2, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Canvas canvas = this.drawParams.getCanvas();
        float fM928getXimpl = Offset.m928getXimpl(j);
        float fM929getYimpl = Offset.m929getYimpl(j);
        float fM928getXimpl2 = Offset.m928getXimpl(j);
        float fM997getWidthimpl = Size.m997getWidthimpl(j2);
        canvas.drawRect(fM928getXimpl, fM929getYimpl, fM928getXimpl2 + fM997getWidthimpl, Offset.m929getYimpl(j) + Size.m994getHeightimpl(j2), m1617configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-n-J9OG0, reason: not valid java name */
    public void mo1640drawRectnJ9OG0(long j, long j2, long j3, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Canvas canvas = this.drawParams.getCanvas();
        float fM928getXimpl = Offset.m928getXimpl(j2);
        float fM929getYimpl = Offset.m929getYimpl(j2);
        float fM928getXimpl2 = Offset.m928getXimpl(j2);
        float fM997getWidthimpl = Size.m997getWidthimpl(j3);
        canvas.drawRect(fM928getXimpl, fM929getYimpl, fM928getXimpl2 + fM997getWidthimpl, Offset.m929getYimpl(j2) + Size.m994getHeightimpl(j3), m1615configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-gbVJVH8, reason: not valid java name */
    public void mo1630drawImagegbVJVH8(@NotNull ImageBitmap imageBitmap, long j, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().mo1026drawImaged4ec7I(imageBitmap, j, m1617configurePaintswdJneE$default(this, null, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* JADX INFO: renamed from: drawImage-9jGpkUE, reason: not valid java name */
    public /* synthetic */ void mo1628drawImage9jGpkUE(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, @FloatRange(from = 0.0d, to = 1.0d) float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().mo1027drawImageRectHPBpro0(imageBitmap, j, j2, j3, j4, m1617configurePaintswdJneE$default(this, null, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
    public void mo1629drawImageAZ2fEMs(@NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i, int i2) {
        this.drawParams.getCanvas().mo1027drawImageRectHPBpro0(imageBitmap, j, j2, j3, j4, m1616configurePaintswdJneE(null, drawStyle, f, colorFilter, i, i2));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ, reason: not valid java name */
    public void mo1641drawRoundRectZuiqVtQ(@NotNull Brush brush, long j, long j2, long j3, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Canvas canvas = this.drawParams.getCanvas();
        float fM928getXimpl = Offset.m928getXimpl(j);
        float fM929getYimpl = Offset.m929getYimpl(j);
        float fM928getXimpl2 = Offset.m928getXimpl(j);
        float fM997getWidthimpl = Size.m997getWidthimpl(j2);
        canvas.drawRoundRect(fM928getXimpl, fM929getYimpl, fM928getXimpl2 + fM997getWidthimpl, Offset.m929getYimpl(j) + Size.m994getHeightimpl(j2), CornerRadius.m903getXimpl(j3), CornerRadius.m904getYimpl(j3), m1617configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA, reason: not valid java name */
    public void mo1642drawRoundRectuAw5IA(long j, long j2, long j3, long j4, @NotNull DrawStyle drawStyle, @FloatRange(from = 0.0d, to = 1.0d) float f, @Nullable ColorFilter colorFilter, int i) {
        Canvas canvas = this.drawParams.getCanvas();
        float fM928getXimpl = Offset.m928getXimpl(j2);
        float fM929getYimpl = Offset.m929getYimpl(j2);
        float fM928getXimpl2 = Offset.m928getXimpl(j2);
        float fM997getWidthimpl = Size.m997getWidthimpl(j3);
        canvas.drawRoundRect(fM928getXimpl, fM929getYimpl, fM928getXimpl2 + fM997getWidthimpl, Offset.m929getYimpl(j2) + Size.m994getHeightimpl(j3), CornerRadius.m903getXimpl(j4), CornerRadius.m904getYimpl(j4), m1615configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-V9BoPsw, reason: not valid java name */
    public void mo1626drawCircleV9BoPsw(@NotNull Brush brush, float f, long j, @FloatRange(from = 0.0d, to = 1.0d) float f2, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().mo1025drawCircle9KIMszo(j, f, m1617configurePaintswdJneE$default(this, brush, drawStyle, f2, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg, reason: not valid java name */
    public void mo1627drawCircleVaOC9Bg(long j, float f, long j2, @FloatRange(from = 0.0d, to = 1.0d) float f2, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().mo1025drawCircle9KIMszo(j2, f, m1615configurePaint2qPWKa0$default(this, j, drawStyle, f2, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-AsUm42w, reason: not valid java name */
    public void mo1633drawOvalAsUm42w(@NotNull Brush brush, long j, long j2, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Canvas canvas = this.drawParams.getCanvas();
        float fM928getXimpl = Offset.m928getXimpl(j);
        float fM929getYimpl = Offset.m929getYimpl(j);
        float fM928getXimpl2 = Offset.m928getXimpl(j);
        float fM997getWidthimpl = Size.m997getWidthimpl(j2);
        canvas.drawOval(fM928getXimpl, fM929getYimpl, fM928getXimpl2 + fM997getWidthimpl, Offset.m929getYimpl(j) + Size.m994getHeightimpl(j2), m1617configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-n-J9OG0, reason: not valid java name */
    public void mo1634drawOvalnJ9OG0(long j, long j2, long j3, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Canvas canvas = this.drawParams.getCanvas();
        float fM928getXimpl = Offset.m928getXimpl(j2);
        float fM929getYimpl = Offset.m929getYimpl(j2);
        float fM928getXimpl2 = Offset.m928getXimpl(j2);
        float fM997getWidthimpl = Size.m997getWidthimpl(j3);
        canvas.drawOval(fM928getXimpl, fM929getYimpl, fM928getXimpl2 + fM997getWidthimpl, Offset.m929getYimpl(j2) + Size.m994getHeightimpl(j3), m1615configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-illE91I, reason: not valid java name */
    public void mo1624drawArcillE91I(@NotNull Brush brush, float f, float f2, boolean z, long j, long j2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Canvas canvas = this.drawParams.getCanvas();
        float fM928getXimpl = Offset.m928getXimpl(j);
        float fM929getYimpl = Offset.m929getYimpl(j);
        float fM928getXimpl2 = Offset.m928getXimpl(j);
        float fM997getWidthimpl = Size.m997getWidthimpl(j2);
        canvas.drawArc(fM928getXimpl, fM929getYimpl, fM928getXimpl2 + fM997getWidthimpl, Offset.m929getYimpl(j) + Size.m994getHeightimpl(j2), f, f2, z, m1617configurePaintswdJneE$default(this, brush, drawStyle, f3, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-yD3GUKo, reason: not valid java name */
    public void mo1625drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, @FloatRange(from = 0.0d, to = 1.0d) float f3, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Canvas canvas = this.drawParams.getCanvas();
        float fM928getXimpl = Offset.m928getXimpl(j2);
        float fM929getYimpl = Offset.m929getYimpl(j2);
        float fM928getXimpl2 = Offset.m928getXimpl(j2);
        float fM997getWidthimpl = Size.m997getWidthimpl(j3);
        canvas.drawArc(fM928getXimpl, fM929getYimpl, fM928getXimpl2 + fM997getWidthimpl, Offset.m929getYimpl(j2) + Size.m994getHeightimpl(j3), f, f2, z, m1615configurePaint2qPWKa0$default(this, j, drawStyle, f3, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-LG529CI, reason: not valid java name */
    public void mo1636drawPathLG529CI(@NotNull Path path, long j, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawPath(path, m1615configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-GBMwjPU, reason: not valid java name */
    public void mo1635drawPathGBMwjPU(@NotNull Path path, @NotNull Brush brush, @FloatRange(from = 0.0d, to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawPath(path, m1617configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-F8ZwMP8, reason: not valid java name */
    public void mo1637drawPointsF8ZwMP8(@NotNull List<Offset> list, int i, long j, float f, int i2, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float f2, @Nullable ColorFilter colorFilter, int i3) {
        this.drawParams.getCanvas().mo1029drawPointsO7TthRY(i, list, m1619configureStrokePaintQ_0CZUI$default(this, j, f, 4.0f, i2, StrokeJoin.Companion.m1535getMiterLxFBmk8(), pathEffect, f2, colorFilter, i3, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-Gsft0Ws, reason: not valid java name */
    public void mo1638drawPointsGsft0Ws(@NotNull List<Offset> list, int i, @NotNull Brush brush, float f, int i2, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float f2, @Nullable ColorFilter colorFilter, int i3) {
        this.drawParams.getCanvas().mo1029drawPointsO7TthRY(i, list, m1621configureStrokePaintho4zsrM$default(this, brush, f, 4.0f, i2, StrokeJoin.Companion.m1535getMiterLxFBmk8(), pathEffect, f2, colorFilter, i3, 0, 512, null));
    }

    /* JADX INFO: renamed from: draw-yzxVdVo, reason: not valid java name */
    public final void m1623drawyzxVdVo(@NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull Canvas canvas, long j, @NotNull Function1<? super DrawScope, Unit> function1) {
        DrawParams drawParams = getDrawParams();
        Density densityComponent1 = drawParams.component1();
        LayoutDirection layoutDirectionComponent2 = drawParams.component2();
        Canvas canvasComponent3 = drawParams.component3();
        long jM1644component4NHjbRc = drawParams.m1644component4NHjbRc();
        DrawParams drawParams2 = getDrawParams();
        drawParams2.setDensity(density);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m1647setSizeuvyYCjk(j);
        canvas.save();
        function1.invoke(this);
        canvas.restore();
        DrawParams drawParams3 = getDrawParams();
        drawParams3.setDensity(densityComponent1);
        drawParams3.setLayoutDirection(layoutDirectionComponent2);
        drawParams3.setCanvas(canvasComponent3);
        drawParams3.m1647setSizeuvyYCjk(jM1644component4NHjbRc);
    }

    private final Paint obtainFillPaint() {
        Paint paint = this.fillPaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo1052setStylek9PVt8s(PaintingStyle.Companion.m1437getFillTiuSbCo());
        this.fillPaint = Paint;
        return Paint;
    }

    private final Paint obtainStrokePaint() {
        Paint paint = this.strokePaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo1052setStylek9PVt8s(PaintingStyle.Companion.m1438getStrokeTiuSbCo());
        this.strokePaint = Paint;
        return Paint;
    }

    private final Paint selectPaint(DrawStyle drawStyle) {
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            return obtainFillPaint();
        }
        if (drawStyle instanceof Stroke) {
            Paint paintObtainStrokePaint = obtainStrokePaint();
            Stroke stroke = (Stroke) drawStyle;
            if (paintObtainStrokePaint.getStrokeWidth() != stroke.getWidth()) {
                paintObtainStrokePaint.setStrokeWidth(stroke.getWidth());
            }
            if (!StrokeCap.m1520equalsimpl0(paintObtainStrokePaint.mo1044getStrokeCapKaPHkGw(), stroke.m1796getCapKaPHkGw())) {
                paintObtainStrokePaint.mo1050setStrokeCapBeK7IIE(stroke.m1796getCapKaPHkGw());
            }
            if (paintObtainStrokePaint.getStrokeMiterLimit() != stroke.getMiter()) {
                paintObtainStrokePaint.setStrokeMiterLimit(stroke.getMiter());
            }
            if (!StrokeJoin.m1530equalsimpl0(paintObtainStrokePaint.mo1045getStrokeJoinLxFBmk8(), stroke.m1797getJoinLxFBmk8())) {
                paintObtainStrokePaint.mo1051setStrokeJoinWw9F2mQ(stroke.m1797getJoinLxFBmk8());
            }
            if (!Intrinsics.areEqual(paintObtainStrokePaint.getPathEffect(), stroke.getPathEffect())) {
                paintObtainStrokePaint.setPathEffect(stroke.getPathEffect());
            }
            return paintObtainStrokePaint;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE$default, reason: not valid java name */
    static /* synthetic */ Paint m1617configurePaintswdJneE$default(CanvasDrawScope canvasDrawScope, Brush brush, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            i2 = DrawScope.Companion.m1730getDefaultFilterQualityfv9h1I();
        }
        return canvasDrawScope.m1616configurePaintswdJneE(brush, drawStyle, f, colorFilter, i, i2);
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE, reason: not valid java name */
    private final Paint m1616configurePaintswdJneE(Brush brush, DrawStyle drawStyle, @FloatRange(from = 0.0d, to = 1.0d) float f, ColorFilter colorFilter, int i, int i2) {
        Paint paintSelectPaint = selectPaint(drawStyle);
        if (brush != null) {
            brush.mo1116applyToPq9zytI(mo1727getSizeNHjbRc(), paintSelectPaint, f);
        } else {
            if (paintSelectPaint.getShader() != null) {
                paintSelectPaint.setShader(null);
            }
            long jMo1042getColor0d7_KjU = paintSelectPaint.mo1042getColor0d7_KjU();
            Color.Companion companion = Color.Companion;
            if (!Color.m1170equalsimpl0(jMo1042getColor0d7_KjU, companion.m1195getBlack0d7_KjU())) {
                paintSelectPaint.mo1048setColor8_81llA(companion.m1195getBlack0d7_KjU());
            }
            if (paintSelectPaint.getAlpha() != f) {
                paintSelectPaint.setAlpha(f);
            }
        }
        if (!Intrinsics.areEqual(paintSelectPaint.getColorFilter(), colorFilter)) {
            paintSelectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1080equalsimpl0(paintSelectPaint.mo1041getBlendMode0nO6VwU(), i)) {
            paintSelectPaint.mo1047setBlendModes9anfk8(i);
        }
        if (!FilterQuality.m1265equalsimpl0(paintSelectPaint.mo1043getFilterQualityfv9h1I(), i2)) {
            paintSelectPaint.mo1049setFilterQualityvDHp3xo(i2);
        }
        return paintSelectPaint;
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0$default, reason: not valid java name */
    static /* synthetic */ Paint m1615configurePaint2qPWKa0$default(CanvasDrawScope canvasDrawScope, long j, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        return canvasDrawScope.m1614configurePaint2qPWKa0(j, drawStyle, f, colorFilter, i, (i3 & 32) != 0 ? DrawScope.Companion.m1730getDefaultFilterQualityfv9h1I() : i2);
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0, reason: not valid java name */
    private final Paint m1614configurePaint2qPWKa0(long j, DrawStyle drawStyle, @FloatRange(from = 0.0d, to = 1.0d) float f, ColorFilter colorFilter, int i, int i2) {
        Paint paintSelectPaint = selectPaint(drawStyle);
        long jM1622modulate5vOe2sY = m1622modulate5vOe2sY(j, f);
        if (!Color.m1170equalsimpl0(paintSelectPaint.mo1042getColor0d7_KjU(), jM1622modulate5vOe2sY)) {
            paintSelectPaint.mo1048setColor8_81llA(jM1622modulate5vOe2sY);
        }
        if (paintSelectPaint.getShader() != null) {
            paintSelectPaint.setShader(null);
        }
        if (!Intrinsics.areEqual(paintSelectPaint.getColorFilter(), colorFilter)) {
            paintSelectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1080equalsimpl0(paintSelectPaint.mo1041getBlendMode0nO6VwU(), i)) {
            paintSelectPaint.mo1047setBlendModes9anfk8(i);
        }
        if (!FilterQuality.m1265equalsimpl0(paintSelectPaint.mo1043getFilterQualityfv9h1I(), i2)) {
            paintSelectPaint.mo1049setFilterQualityvDHp3xo(i2);
        }
        return paintSelectPaint;
    }

    /* JADX INFO: renamed from: configureStrokePaint-Q_0CZUI$default, reason: not valid java name */
    static /* synthetic */ Paint m1619configureStrokePaintQ_0CZUI$default(CanvasDrawScope canvasDrawScope, long j, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        return canvasDrawScope.m1618configureStrokePaintQ_0CZUI(j, f, f2, i, i2, pathEffect, f3, colorFilter, i3, (i5 & 512) != 0 ? DrawScope.Companion.m1730getDefaultFilterQualityfv9h1I() : i4);
    }

    /* JADX INFO: renamed from: configureStrokePaint-Q_0CZUI, reason: not valid java name */
    private final Paint m1618configureStrokePaintQ_0CZUI(long j, float f, float f2, int i, int i2, PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float f3, ColorFilter colorFilter, int i3, int i4) {
        Paint paintObtainStrokePaint = obtainStrokePaint();
        long jM1622modulate5vOe2sY = m1622modulate5vOe2sY(j, f3);
        if (!Color.m1170equalsimpl0(paintObtainStrokePaint.mo1042getColor0d7_KjU(), jM1622modulate5vOe2sY)) {
            paintObtainStrokePaint.mo1048setColor8_81llA(jM1622modulate5vOe2sY);
        }
        if (paintObtainStrokePaint.getShader() != null) {
            paintObtainStrokePaint.setShader(null);
        }
        if (!Intrinsics.areEqual(paintObtainStrokePaint.getColorFilter(), colorFilter)) {
            paintObtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1080equalsimpl0(paintObtainStrokePaint.mo1041getBlendMode0nO6VwU(), i3)) {
            paintObtainStrokePaint.mo1047setBlendModes9anfk8(i3);
        }
        if (paintObtainStrokePaint.getStrokeWidth() != f) {
            paintObtainStrokePaint.setStrokeWidth(f);
        }
        if (paintObtainStrokePaint.getStrokeMiterLimit() != f2) {
            paintObtainStrokePaint.setStrokeMiterLimit(f2);
        }
        if (!StrokeCap.m1520equalsimpl0(paintObtainStrokePaint.mo1044getStrokeCapKaPHkGw(), i)) {
            paintObtainStrokePaint.mo1050setStrokeCapBeK7IIE(i);
        }
        if (!StrokeJoin.m1530equalsimpl0(paintObtainStrokePaint.mo1045getStrokeJoinLxFBmk8(), i2)) {
            paintObtainStrokePaint.mo1051setStrokeJoinWw9F2mQ(i2);
        }
        if (!Intrinsics.areEqual(paintObtainStrokePaint.getPathEffect(), pathEffect)) {
            paintObtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m1265equalsimpl0(paintObtainStrokePaint.mo1043getFilterQualityfv9h1I(), i4)) {
            paintObtainStrokePaint.mo1049setFilterQualityvDHp3xo(i4);
        }
        return paintObtainStrokePaint;
    }

    /* JADX INFO: renamed from: configureStrokePaint-ho4zsrM$default, reason: not valid java name */
    static /* synthetic */ Paint m1621configureStrokePaintho4zsrM$default(CanvasDrawScope canvasDrawScope, Brush brush, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        return canvasDrawScope.m1620configureStrokePaintho4zsrM(brush, f, f2, i, i2, pathEffect, f3, colorFilter, i3, (i5 & 512) != 0 ? DrawScope.Companion.m1730getDefaultFilterQualityfv9h1I() : i4);
    }

    /* JADX INFO: renamed from: configureStrokePaint-ho4zsrM, reason: not valid java name */
    private final Paint m1620configureStrokePaintho4zsrM(Brush brush, float f, float f2, int i, int i2, PathEffect pathEffect, @FloatRange(from = 0.0d, to = 1.0d) float f3, ColorFilter colorFilter, int i3, int i4) {
        Paint paintObtainStrokePaint = obtainStrokePaint();
        if (brush != null) {
            brush.mo1116applyToPq9zytI(mo1727getSizeNHjbRc(), paintObtainStrokePaint, f3);
        } else if (paintObtainStrokePaint.getAlpha() != f3) {
            paintObtainStrokePaint.setAlpha(f3);
        }
        if (!Intrinsics.areEqual(paintObtainStrokePaint.getColorFilter(), colorFilter)) {
            paintObtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1080equalsimpl0(paintObtainStrokePaint.mo1041getBlendMode0nO6VwU(), i3)) {
            paintObtainStrokePaint.mo1047setBlendModes9anfk8(i3);
        }
        if (paintObtainStrokePaint.getStrokeWidth() != f) {
            paintObtainStrokePaint.setStrokeWidth(f);
        }
        if (paintObtainStrokePaint.getStrokeMiterLimit() != f2) {
            paintObtainStrokePaint.setStrokeMiterLimit(f2);
        }
        if (!StrokeCap.m1520equalsimpl0(paintObtainStrokePaint.mo1044getStrokeCapKaPHkGw(), i)) {
            paintObtainStrokePaint.mo1050setStrokeCapBeK7IIE(i);
        }
        if (!StrokeJoin.m1530equalsimpl0(paintObtainStrokePaint.mo1045getStrokeJoinLxFBmk8(), i2)) {
            paintObtainStrokePaint.mo1051setStrokeJoinWw9F2mQ(i2);
        }
        if (!Intrinsics.areEqual(paintObtainStrokePaint.getPathEffect(), pathEffect)) {
            paintObtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m1265equalsimpl0(paintObtainStrokePaint.mo1043getFilterQualityfv9h1I(), i4)) {
            paintObtainStrokePaint.mo1049setFilterQualityvDHp3xo(i4);
        }
        return paintObtainStrokePaint;
    }

    /* JADX INFO: renamed from: modulate-5vOe2sY, reason: not valid java name */
    private final long m1622modulate5vOe2sY(long j, float f) {
        return f == 1.0f ? j : Color.m1168copywmQWz5c$default(j, Color.m1171getAlphaimpl(j) * f, 0.0f, 0.0f, 0.0f, 14, null);
    }

    public static final class DrawParams {
        private Canvas canvas;
        private Density density;
        private LayoutDirection layoutDirection;
        private long size;

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(density, layoutDirection, canvas, j);
        }

        /* JADX INFO: renamed from: copy-Ug5Nnss$default, reason: not valid java name */
        public static /* synthetic */ DrawParams m1643copyUg5Nnss$default(DrawParams drawParams, Density density, LayoutDirection layoutDirection, Canvas canvas, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                density = drawParams.density;
            }
            if ((i & 2) != 0) {
                layoutDirection = drawParams.layoutDirection;
            }
            LayoutDirection layoutDirection2 = layoutDirection;
            if ((i & 4) != 0) {
                canvas = drawParams.canvas;
            }
            Canvas canvas2 = canvas;
            if ((i & 8) != 0) {
                j = drawParams.size;
            }
            return drawParams.m1645copyUg5Nnss(density, layoutDirection2, canvas2, j);
        }

        public final Density component1() {
            return this.density;
        }

        public final LayoutDirection component2() {
            return this.layoutDirection;
        }

        public final Canvas component3() {
            return this.canvas;
        }

        /* JADX INFO: renamed from: component4-NH-jbRc, reason: not valid java name */
        public final long m1644component4NHjbRc() {
            return this.size;
        }

        /* JADX INFO: renamed from: copy-Ug5Nnss, reason: not valid java name */
        public final DrawParams m1645copyUg5Nnss(@NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull Canvas canvas, long j) {
            return new DrawParams(density, layoutDirection, canvas, j, null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) obj;
            return Intrinsics.areEqual(this.density, drawParams.density) && this.layoutDirection == drawParams.layoutDirection && Intrinsics.areEqual(this.canvas, drawParams.canvas) && Size.m993equalsimpl0(this.size, drawParams.size);
        }

        public int hashCode() {
            return (((((this.density.hashCode() * 31) + this.layoutDirection.hashCode()) * 31) + this.canvas.hashCode()) * 31) + Size.m998hashCodeimpl(this.size);
        }

        public String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + ((Object) Size.m1001toStringimpl(this.size)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        private DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j) {
            this.density = density;
            this.layoutDirection = layoutDirection;
            this.canvas = canvas;
            this.size = j;
        }

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? DrawContextKt.getDefaultDensity() : density, (i & 2) != 0 ? LayoutDirection.Ltr : layoutDirection, (i & 4) != 0 ? new EmptyCanvas() : canvas, (i & 8) != 0 ? Size.Companion.m1006getZeroNHjbRc() : j, null);
        }

        public final Density getDensity() {
            return this.density;
        }

        public final void setDensity(@NotNull Density density) {
            this.density = density;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public final void setLayoutDirection(@NotNull LayoutDirection layoutDirection) {
            this.layoutDirection = layoutDirection;
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final void setCanvas(@NotNull Canvas canvas) {
            this.canvas = canvas;
        }

        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public final long m1646getSizeNHjbRc() {
            return this.size;
        }

        /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
        public final void m1647setSizeuvyYCjk(long j) {
            this.size = j;
        }
    }
}
