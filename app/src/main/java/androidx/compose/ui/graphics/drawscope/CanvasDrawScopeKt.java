package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import androidx.compose.ui.graphics.Path;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class CanvasDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(final DrawContext drawContext) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt.asDrawTransform.1
            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
            public long mo1653getSizeNHjbRc() {
                return drawContext.mo1648getSizeNHjbRc();
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
            public long mo1652getCenterF1C5BW0() {
                return SizeKt.m1007getCenteruvyYCjk(mo1653getSizeNHjbRc());
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void inset(float f, float f2, float f3, float f4) {
                Canvas canvas = drawContext.getCanvas();
                DrawContext drawContext2 = drawContext;
                long jSize = SizeKt.Size(Size.m997getWidthimpl(mo1653getSizeNHjbRc()) - (f3 + f), Size.m994getHeightimpl(mo1653getSizeNHjbRc()) - (f4 + f2));
                if (Size.m997getWidthimpl(jSize) < 0.0f || Size.m994getHeightimpl(jSize) < 0.0f) {
                    InlineClassHelperKt.throwIllegalArgumentException("Width and height must be greater than or equal to zero");
                }
                drawContext2.mo1649setSizeuvyYCjk(jSize);
                canvas.translate(f, f2);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
            public void mo1651clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
                drawContext.getCanvas().mo1023clipRectN_I0leg(f, f2, f3, f4, i);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: clipPath-mtrdD-E, reason: not valid java name */
            public void mo1650clipPathmtrdDE(@NotNull Path path, int i) {
                drawContext.getCanvas().mo1022clipPathmtrdDE(path, i);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void translate(float f, float f2) {
                drawContext.getCanvas().translate(f, f2);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: rotate-Uv8p0NA, reason: not valid java name */
            public void mo1654rotateUv8p0NA(float f, long j) {
                Canvas canvas = drawContext.getCanvas();
                canvas.translate(Offset.m928getXimpl(j), Offset.m929getYimpl(j));
                canvas.rotate(f);
                canvas.translate(-Offset.m928getXimpl(j), -Offset.m929getYimpl(j));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: scale-0AR0LA0, reason: not valid java name */
            public void mo1655scale0AR0LA0(float f, float f2, long j) {
                Canvas canvas = drawContext.getCanvas();
                canvas.translate(Offset.m928getXimpl(j), Offset.m929getYimpl(j));
                canvas.scale(f, f2);
                canvas.translate(-Offset.m928getXimpl(j), -Offset.m929getYimpl(j));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
            public void mo1656transform58bKbWc(@NotNull float[] fArr) {
                drawContext.getCanvas().mo1024concat58bKbWc(fArr);
            }
        };
    }
}
