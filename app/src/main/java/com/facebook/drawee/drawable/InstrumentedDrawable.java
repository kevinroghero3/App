package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class InstrumentedDrawable extends ForwardingDrawable {
    private final String _scaleType;
    private boolean isChecked;
    private final Listener listener;

    public interface Listener {
        void track(int i, int i2, int i3, int i4, int i5, int i6, @Nullable String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstrumentedDrawable(@NotNull Drawable drawable, @Nullable Listener listener) {
        super(drawable);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.listener = listener;
        this._scaleType = getScaleType(drawable);
    }

    private final String getScaleType(Drawable drawable) {
        if (drawable instanceof ScaleTypeDrawable) {
            return ((ScaleTypeDrawable) drawable).getScaleType().toString();
        }
        return "none";
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!this.isChecked) {
            this.isChecked = true;
            RectF rectF = new RectF();
            getRootBounds(rectF);
            int iWidth = (int) rectF.width();
            int iHeight = (int) rectF.height();
            getTransformedBounds(rectF);
            int iWidth2 = (int) rectF.width();
            int iHeight2 = (int) rectF.height();
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Listener listener = this.listener;
            if (listener != null) {
                listener.track(iWidth, iHeight, intrinsicWidth, intrinsicHeight, iWidth2, iHeight2, this._scaleType);
            }
        }
        super.draw(canvas);
    }
}
