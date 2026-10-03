package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import androidx.core.view.ViewCompat;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class XferRoundFilter {
    public static final XferRoundFilter INSTANCE = new XferRoundFilter();

    private XferRoundFilter() {
    }

    @JvmStatic
    public static final void xferRoundBitmap(@NotNull Bitmap output, @NotNull Bitmap source, boolean z) {
        Paint paint;
        Paint paint2;
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(source, "source");
        output.setHasAlpha(true);
        if (z) {
            paint = new Paint(1);
            paint2 = new Paint(1);
        } else {
            paint = new Paint();
            paint2 = new Paint();
        }
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        float width = source.getWidth() / 2.0f;
        float height = source.getHeight() / 2.0f;
        Canvas canvas = new Canvas(output);
        canvas.drawCircle(width, height, Math.min(width, height), paint);
        canvas.drawBitmap(source, 0.0f, 0.0f, paint2);
    }
}
