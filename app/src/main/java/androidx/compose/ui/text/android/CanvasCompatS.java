package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.fonts.Font;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
final class CanvasCompatS {
    public static final CanvasCompatS INSTANCE = new CanvasCompatS();

    private CanvasCompatS() {
    }

    public final void drawPatch(@NotNull Canvas canvas, @NotNull NinePatch ninePatch, @NotNull Rect rect, @Nullable Paint paint) {
        canvas.drawPatch(ninePatch, rect, paint);
    }

    public final void drawPatch(@NotNull Canvas canvas, @NotNull NinePatch ninePatch, @NotNull RectF rectF, @Nullable Paint paint) {
        canvas.drawPatch(ninePatch, rectF, paint);
    }

    public final void drawGlyphs(@NotNull Canvas canvas, @NotNull int[] iArr, int i, @NotNull float[] fArr, int i2, int i3, @NotNull Font font, @NotNull Paint paint) {
        canvas.drawGlyphs(iArr, i, fArr, i2, i3, font, paint);
    }
}
