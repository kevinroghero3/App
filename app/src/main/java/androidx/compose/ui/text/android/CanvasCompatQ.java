package androidx.compose.ui.text.android;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.RenderNode;
import android.graphics.text.MeasuredText;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
final class CanvasCompatQ {
    public static final CanvasCompatQ INSTANCE = new CanvasCompatQ();

    private CanvasCompatQ() {
    }

    public final void enableZ(@NotNull Canvas canvas) {
        canvas.enableZ();
    }

    public final void disableZ(@NotNull Canvas canvas) {
        canvas.disableZ();
    }

    public final void drawColor(@NotNull Canvas canvas, long j) {
        canvas.drawColor(j);
    }

    public final void drawColor(@NotNull Canvas canvas, int i, @NotNull BlendMode blendMode) {
        canvas.drawColor(i, blendMode);
    }

    public final void drawColor(@NotNull Canvas canvas, long j, @NotNull BlendMode blendMode) {
        canvas.drawColor(j, blendMode);
    }

    public final void drawDoubleRoundRect(@NotNull Canvas canvas, @NotNull RectF rectF, float f, float f2, @NotNull RectF rectF2, float f3, float f4, @NotNull Paint paint) {
        canvas.drawDoubleRoundRect(rectF, f, f2, rectF2, f3, f4, paint);
    }

    public final void drawDoubleRoundRect(@NotNull Canvas canvas, @NotNull RectF rectF, @NotNull float[] fArr, @NotNull RectF rectF2, @NotNull float[] fArr2, @NotNull Paint paint) {
        canvas.drawDoubleRoundRect(rectF, fArr, rectF2, fArr2, paint);
    }

    public final void drawTextRun(@NotNull Canvas canvas, @NotNull MeasuredText measuredText, int i, int i2, int i3, int i4, float f, float f2, boolean z, @NotNull Paint paint) {
        canvas.drawTextRun(measuredText, i, i2, i3, i4, f, f2, z, paint);
    }

    public final void drawRenderNode(@NotNull Canvas canvas, @NotNull RenderNode renderNode) {
        canvas.drawRenderNode(renderNode);
    }
}
