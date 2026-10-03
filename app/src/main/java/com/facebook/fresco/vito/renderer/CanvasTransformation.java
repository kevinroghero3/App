package com.facebook.fresco.vito.renderer;

import android.graphics.Matrix;
import android.graphics.Rect;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface CanvasTransformation {
    Matrix calculateTransformation(@NotNull Matrix matrix, @NotNull Rect rect, int i, int i2);
}
