package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.RectF;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface TransformCallback {
    void getRootBounds(@NotNull RectF rectF);

    void getTransform(@NotNull Matrix matrix);
}
