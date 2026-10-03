package androidx.compose.ui.platform;

import android.os.Build;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class GraphicsLayerOwnerLayer implements OwnedLayer, GraphicLayerInfo {
    public static final int $stable = 8;
    private final GraphicsContext context;
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithEnabledZ;
    private GraphicsLayer graphicsLayer;
    private Function0<Unit> invalidateParentLayer;
    private float[] inverseMatrixCache;
    private boolean isDestroyed;
    private boolean isDirty;
    private int mutatedFields;
    private Outline outline;
    private final AndroidComposeView ownerView;
    private Paint softwareLayerPaint;
    private Path tmpPath;
    private long size = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private final float[] matrixCache = Matrix.m1401constructorimpl$default(null, 1, null);
    private Density density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private final CanvasDrawScope scope = new CanvasDrawScope();
    private long transformOrigin = TransformOrigin.Companion.m1562getCenterSzJe1aQ();
    private final Function1<DrawScope, Unit> recordLambda = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.platform.GraphicsLayerOwnerLayer$recordLambda$1
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
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = this.this$0;
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            Function2 function2 = graphicsLayerOwnerLayer.drawBlock;
            if (function2 != null) {
                function2.invoke(canvas, drawScope.getDrawContext().getGraphicsLayer());
            }
        }
    };

    public GraphicsLayerOwnerLayer(@NotNull GraphicsLayer graphicsLayer, @Nullable GraphicsContext graphicsContext, @NotNull AndroidComposeView androidComposeView, @NotNull Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, @NotNull Function0<Unit> function0) {
        this.graphicsLayer = graphicsLayer;
        this.context = graphicsContext;
        this.ownerView = androidComposeView;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
    }

    private final void setDirty(boolean z) {
        if (z != this.isDirty) {
            this.isDirty = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateLayerProperties(@NotNull ReusableGraphicsLayerScope reusableGraphicsLayerScope) {
        boolean z;
        int iM1808getModulateAlphake2Ky5w;
        Function0<Unit> function0;
        int mutatedFields$ui_release = reusableGraphicsLayerScope.getMutatedFields$ui_release() | this.mutatedFields;
        this.layoutDirection = reusableGraphicsLayerScope.getLayoutDirection$ui_release();
        this.density = reusableGraphicsLayerScope.getGraphicsDensity$ui_release();
        int i = mutatedFields$ui_release & 4096;
        if (i != 0) {
            this.transformOrigin = reusableGraphicsLayerScope.mo1359getTransformOriginSzJe1aQ();
        }
        if ((mutatedFields$ui_release & 1) != 0) {
            this.graphicsLayer.setScaleX(reusableGraphicsLayerScope.getScaleX());
        }
        if ((mutatedFields$ui_release & 2) != 0) {
            this.graphicsLayer.setScaleY(reusableGraphicsLayerScope.getScaleY());
        }
        if ((mutatedFields$ui_release & 4) != 0) {
            this.graphicsLayer.setAlpha(reusableGraphicsLayerScope.getAlpha());
        }
        if ((mutatedFields$ui_release & 8) != 0) {
            this.graphicsLayer.setTranslationX(reusableGraphicsLayerScope.getTranslationX());
        }
        if ((mutatedFields$ui_release & 16) != 0) {
            this.graphicsLayer.setTranslationY(reusableGraphicsLayerScope.getTranslationY());
        }
        if ((mutatedFields$ui_release & 32) != 0) {
            this.graphicsLayer.setShadowElevation(reusableGraphicsLayerScope.getShadowElevation());
            if (reusableGraphicsLayerScope.getShadowElevation() > 0.0f && !this.drawnWithEnabledZ && (function0 = this.invalidateParentLayer) != null) {
                function0.invoke();
            }
        }
        if ((mutatedFields$ui_release & 64) != 0) {
            this.graphicsLayer.m1822setAmbientShadowColor8_81llA(reusableGraphicsLayerScope.mo1355getAmbientShadowColor0d7_KjU());
        }
        if ((mutatedFields$ui_release & 128) != 0) {
            this.graphicsLayer.m1828setSpotShadowColor8_81llA(reusableGraphicsLayerScope.mo1358getSpotShadowColor0d7_KjU());
        }
        if ((mutatedFields$ui_release & 1024) != 0) {
            this.graphicsLayer.setRotationZ(reusableGraphicsLayerScope.getRotationZ());
        }
        if ((mutatedFields$ui_release & 256) != 0) {
            this.graphicsLayer.setRotationX(reusableGraphicsLayerScope.getRotationX());
        }
        if ((mutatedFields$ui_release & 512) != 0) {
            this.graphicsLayer.setRotationY(reusableGraphicsLayerScope.getRotationY());
        }
        if ((mutatedFields$ui_release & 2048) != 0) {
            this.graphicsLayer.setCameraDistance(reusableGraphicsLayerScope.getCameraDistance());
        }
        if (i != 0) {
            if (TransformOrigin.m1556equalsimpl0(this.transformOrigin, TransformOrigin.Companion.m1562getCenterSzJe1aQ())) {
                this.graphicsLayer.m1825setPivotOffsetk4lQ0M(Offset.Companion.m943getUnspecifiedF1C5BW0());
            } else {
                this.graphicsLayer.m1825setPivotOffsetk4lQ0M(OffsetKt.Offset(TransformOrigin.m1557getPivotFractionXimpl(this.transformOrigin) * IntSize.m3820getWidthimpl(this.size), TransformOrigin.m1558getPivotFractionYimpl(this.transformOrigin) * IntSize.m3819getHeightimpl(this.size)));
            }
        }
        if ((mutatedFields$ui_release & 16384) != 0) {
            this.graphicsLayer.setClip(reusableGraphicsLayerScope.getClip());
        }
        if ((131072 & mutatedFields$ui_release) != 0) {
            this.graphicsLayer.setRenderEffect(reusableGraphicsLayerScope.getRenderEffect());
        }
        if ((32768 & mutatedFields$ui_release) != 0) {
            GraphicsLayer graphicsLayer = this.graphicsLayer;
            int iMo1356getCompositingStrategyNrFUSI = reusableGraphicsLayerScope.mo1356getCompositingStrategyNrFUSI();
            CompositingStrategy.Companion companion = CompositingStrategy.Companion;
            if (CompositingStrategy.m1255equalsimpl0(iMo1356getCompositingStrategyNrFUSI, companion.m1259getAutoNrFUSI())) {
                iM1808getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.Companion.m1807getAutoke2Ky5w();
            } else if (CompositingStrategy.m1255equalsimpl0(iMo1356getCompositingStrategyNrFUSI, companion.m1261getOffscreenNrFUSI())) {
                iM1808getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.Companion.m1809getOffscreenke2Ky5w();
            } else {
                if (!CompositingStrategy.m1255equalsimpl0(iMo1356getCompositingStrategyNrFUSI, companion.m1260getModulateAlphaNrFUSI())) {
                    throw new IllegalStateException("Not supported composition strategy");
                }
                iM1808getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.Companion.m1808getModulateAlphake2Ky5w();
            }
            graphicsLayer.m1824setCompositingStrategyWpw9cng(iM1808getModulateAlphake2Ky5w);
        }
        if (Intrinsics.areEqual(this.outline, reusableGraphicsLayerScope.getOutline$ui_release())) {
            z = false;
        } else {
            this.outline = reusableGraphicsLayerScope.getOutline$ui_release();
            updateOutline();
            z = true;
        }
        this.mutatedFields = reusableGraphicsLayerScope.getMutatedFields$ui_release();
        if (mutatedFields$ui_release != 0 || z) {
            triggerRepaint();
        }
    }

    private final void triggerRepaint() {
        if (Build.VERSION.SDK_INT >= 26) {
            WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
        } else {
            this.ownerView.invalidate();
        }
    }

    private final void updateOutline() {
        Function0<Unit> function0;
        Outline outline = this.outline;
        if (outline == null) {
            return;
        }
        GraphicsLayerKt.setOutline(this.graphicsLayer, outline);
        if (!(outline instanceof Outline.Generic) || Build.VERSION.SDK_INT >= 33 || (function0 = this.invalidateParentLayer) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: isInLayer-k-4lQ0M */
    public boolean mo2809isInLayerk4lQ0M(long j) {
        float fM928getXimpl = Offset.m928getXimpl(j);
        float fM929getYimpl = Offset.m929getYimpl(j);
        if (this.graphicsLayer.getClip()) {
            return ShapeContainingUtilKt.isInOutline$default(this.graphicsLayer.getOutline(), fM928getXimpl, fM929getYimpl, null, null, 24, null);
        }
        return true;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: move--gyyYBs */
    public void mo2811movegyyYBs(long j) {
        this.graphicsLayer.m1829setTopLeftgyyYBs(j);
        triggerRepaint();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: resize-ozmzZPI */
    public void mo2812resizeozmzZPI(long j) {
        if (IntSize.m3818equalsimpl0(j, this.size)) {
            return;
        }
        this.size = j;
        invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(@NotNull Canvas canvas, @Nullable GraphicsLayer graphicsLayer) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            this.drawnWithEnabledZ = this.graphicsLayer.getShadowElevation() > 0.0f;
            DrawContext drawContext = this.scope.getDrawContext();
            drawContext.setCanvas(canvas);
            drawContext.setGraphicsLayer(graphicsLayer);
            GraphicsLayerKt.drawLayer(this.scope, this.graphicsLayer);
            return;
        }
        float fM3778getXimpl = IntOffset.m3778getXimpl(this.graphicsLayer.m1820getTopLeftnOccac());
        float fM3779getYimpl = IntOffset.m3779getYimpl(this.graphicsLayer.m1820getTopLeftnOccac());
        float fM3820getWidthimpl = IntSize.m3820getWidthimpl(this.size);
        float fM3819getHeightimpl = IntSize.m3819getHeightimpl(this.size);
        if (this.graphicsLayer.getAlpha() < 1.0f) {
            Paint Paint = this.softwareLayerPaint;
            if (Paint == null) {
                Paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = Paint;
            }
            Paint.setAlpha(this.graphicsLayer.getAlpha());
            nativeCanvas.saveLayer(fM3778getXimpl, fM3779getYimpl, fM3778getXimpl + fM3820getWidthimpl, fM3779getYimpl + fM3819getHeightimpl, Paint.asFrameworkPaint());
        } else {
            canvas.save();
        }
        canvas.translate(fM3778getXimpl, fM3779getYimpl);
        canvas.mo1024concat58bKbWc(m2890getMatrixsQKQjiQ());
        if (this.graphicsLayer.getClip()) {
            clipManually(canvas);
        }
        Function2<? super Canvas, ? super GraphicsLayer, Unit> function2 = this.drawBlock;
        if (function2 != null) {
            function2.invoke(canvas, null);
        }
        canvas.restore();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.isDirty) {
            if (!TransformOrigin.m1556equalsimpl0(this.transformOrigin, TransformOrigin.Companion.m1562getCenterSzJe1aQ()) && !IntSize.m3818equalsimpl0(this.graphicsLayer.m1818getSizeYbymL2g(), this.size)) {
                this.graphicsLayer.m1825setPivotOffsetk4lQ0M(OffsetKt.Offset(TransformOrigin.m1557getPivotFractionXimpl(this.transformOrigin) * IntSize.m3820getWidthimpl(this.size), TransformOrigin.m1558getPivotFractionYimpl(this.transformOrigin) * IntSize.m3819getHeightimpl(this.size)));
            }
            this.graphicsLayer.m1821recordmLhObY(this.density, this.layoutDirection, this.size, this.recordLambda);
            setDirty(false);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        this.ownerView.invalidate();
        setDirty(true);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext != null) {
            graphicsContext.releaseGraphicsLayer(this.graphicsLayer);
            this.ownerView.recycle$ui_release(this);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: mapOffset-8S9VItk */
    public long mo2810mapOffset8S9VItk(long j, boolean z) {
        if (z) {
            float[] fArrM2889getInverseMatrix3i98HWw = m2889getInverseMatrix3i98HWw();
            return fArrM2889getInverseMatrix3i98HWw != null ? Matrix.m1407mapMKHz9U(fArrM2889getInverseMatrix3i98HWw, j) : Offset.Companion.m942getInfiniteF1C5BW0();
        }
        return Matrix.m1407mapMKHz9U(m2890getMatrixsQKQjiQ(), j);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(@NotNull MutableRect mutableRect, boolean z) {
        if (z) {
            float[] fArrM2889getInverseMatrix3i98HWw = m2889getInverseMatrix3i98HWw();
            if (fArrM2889getInverseMatrix3i98HWw == null) {
                mutableRect.set(0.0f, 0.0f, 0.0f, 0.0f);
                return;
            } else {
                Matrix.m1409mapimpl(fArrM2889getInverseMatrix3i98HWw, mutableRect);
                return;
            }
        }
        Matrix.m1409mapimpl(m2890getMatrixsQKQjiQ(), mutableRect);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(@NotNull Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, @NotNull Function0<Unit> function0) {
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext == null) {
            throw new IllegalArgumentException("currently reuse is only supported when we manage the layer lifecycle");
        }
        if (!this.graphicsLayer.isReleased()) {
            throw new IllegalArgumentException("layer should have been released before reuse");
        }
        this.graphicsLayer = graphicsContext.createGraphicsLayer();
        this.isDestroyed = false;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
        this.transformOrigin = TransformOrigin.Companion.m1562getCenterSzJe1aQ();
        this.drawnWithEnabledZ = false;
        this.size = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.outline = null;
        this.mutatedFields = 0;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: transform-58bKbWc */
    public void mo2813transform58bKbWc(@NotNull float[] fArr) {
        Matrix.m1418timesAssign58bKbWc(fArr, m2890getMatrixsQKQjiQ());
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: inverseTransform-58bKbWc */
    public void mo2808inverseTransform58bKbWc(@NotNull float[] fArr) {
        float[] fArrM2889getInverseMatrix3i98HWw = m2889getInverseMatrix3i98HWw();
        if (fArrM2889getInverseMatrix3i98HWw != null) {
            Matrix.m1418timesAssign58bKbWc(fArr, fArrM2889getInverseMatrix3i98HWw);
        }
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.graphicsLayer.getLayerId();
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        return this.graphicsLayer.getOwnerViewId();
    }

    /* JADX INFO: renamed from: getMatrix-sQKQjiQ, reason: not valid java name */
    private final float[] m2890getMatrixsQKQjiQ() {
        updateMatrix();
        return this.matrixCache;
    }

    /* JADX INFO: renamed from: getInverseMatrix-3i98HWw, reason: not valid java name */
    private final float[] m2889getInverseMatrix3i98HWw() {
        float[] fArrM2890getMatrixsQKQjiQ = m2890getMatrixsQKQjiQ();
        float[] fArrM1401constructorimpl$default = this.inverseMatrixCache;
        if (fArrM1401constructorimpl$default == null) {
            fArrM1401constructorimpl$default = Matrix.m1401constructorimpl$default(null, 1, null);
            this.inverseMatrixCache = fArrM1401constructorimpl$default;
        }
        if (InvertMatrixKt.m2891invertToJiSxe2E(fArrM2890getMatrixsQKQjiQ, fArrM1401constructorimpl$default)) {
            return fArrM1401constructorimpl$default;
        }
        return null;
    }

    private final void updateMatrix() {
        long jM1817getPivotOffsetF1C5BW0;
        GraphicsLayer graphicsLayer = this.graphicsLayer;
        if (OffsetKt.m949isUnspecifiedk4lQ0M(graphicsLayer.m1817getPivotOffsetF1C5BW0())) {
            jM1817getPivotOffsetF1C5BW0 = SizeKt.m1007getCenteruvyYCjk(IntSizeKt.m3832toSizeozmzZPI(this.size));
        } else {
            jM1817getPivotOffsetF1C5BW0 = graphicsLayer.m1817getPivotOffsetF1C5BW0();
        }
        Matrix.m1410resetimpl(this.matrixCache);
        float[] fArr = this.matrixCache;
        float[] fArrM1401constructorimpl$default = Matrix.m1401constructorimpl$default(null, 1, null);
        Matrix.m1421translateimpl$default(fArrM1401constructorimpl$default, -Offset.m928getXimpl(jM1817getPivotOffsetF1C5BW0), -Offset.m929getYimpl(jM1817getPivotOffsetF1C5BW0), 0.0f, 4, null);
        Matrix.m1418timesAssign58bKbWc(fArr, fArrM1401constructorimpl$default);
        float[] fArr2 = this.matrixCache;
        float[] fArrM1401constructorimpl$default2 = Matrix.m1401constructorimpl$default(null, 1, null);
        Matrix.m1421translateimpl$default(fArrM1401constructorimpl$default2, graphicsLayer.getTranslationX(), graphicsLayer.getTranslationY(), 0.0f, 4, null);
        Matrix.m1411rotateXimpl(fArrM1401constructorimpl$default2, graphicsLayer.getRotationX());
        Matrix.m1412rotateYimpl(fArrM1401constructorimpl$default2, graphicsLayer.getRotationY());
        Matrix.m1413rotateZimpl(fArrM1401constructorimpl$default2, graphicsLayer.getRotationZ());
        Matrix.m1415scaleimpl$default(fArrM1401constructorimpl$default2, graphicsLayer.getScaleX(), graphicsLayer.getScaleY(), 0.0f, 4, null);
        Matrix.m1418timesAssign58bKbWc(fArr2, fArrM1401constructorimpl$default2);
        float[] fArr3 = this.matrixCache;
        float[] fArrM1401constructorimpl$default3 = Matrix.m1401constructorimpl$default(null, 1, null);
        Matrix.m1421translateimpl$default(fArrM1401constructorimpl$default3, Offset.m928getXimpl(jM1817getPivotOffsetF1C5BW0), Offset.m929getYimpl(jM1817getPivotOffsetF1C5BW0), 0.0f, 4, null);
        Matrix.m1418timesAssign58bKbWc(fArr3, fArrM1401constructorimpl$default3);
    }

    private final void clipManually(Canvas canvas) {
        if (this.graphicsLayer.getClip()) {
            Outline outline = this.graphicsLayer.getOutline();
            if (outline instanceof Outline.Rectangle) {
                Canvas.m1142clipRectmtrdDE$default(canvas, ((Outline.Rectangle) outline).getRect(), 0, 2, null);
                return;
            }
            if (outline instanceof Outline.Rounded) {
                Path Path = this.tmpPath;
                if (Path == null) {
                    Path = AndroidPath_androidKt.Path();
                    this.tmpPath = Path;
                }
                Path.reset();
                Path.addRoundRect$default(Path, ((Outline.Rounded) outline).getRoundRect(), null, 2, null);
                Canvas.m1140clipPathmtrdDE$default(canvas, Path, 0, 2, null);
                return;
            }
            if (outline instanceof Outline.Generic) {
                Canvas.m1140clipPathmtrdDE$default(canvas, ((Outline.Generic) outline).getPath(), 0, 2, null);
            }
        }
    }
}
