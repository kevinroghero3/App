package com.facebook.fresco.vito.renderer;

import android.graphics.Matrix;
import android.graphics.Rect;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class CanvasTransformationHandler {
    private CanvasTransformation canvasTransformation;
    private Matrix drawMatrix;
    private final Matrix tempMatrix;

    public CanvasTransformationHandler() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CanvasTransformationHandler(@Nullable CanvasTransformation canvasTransformation) {
        this.canvasTransformation = canvasTransformation;
        this.tempMatrix = new Matrix();
    }

    public /* synthetic */ CanvasTransformationHandler(CanvasTransformation canvasTransformation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : canvasTransformation);
    }

    public final CanvasTransformation getCanvasTransformation() {
        return this.canvasTransformation;
    }

    public final void setCanvasTransformation(@Nullable CanvasTransformation canvasTransformation) {
        this.canvasTransformation = canvasTransformation;
    }

    public final Matrix getMatrix() {
        return this.drawMatrix;
    }

    public final void configure(@NotNull Rect bounds, int i, int i2) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (i <= 0 || i2 <= 0) {
            this.drawMatrix = null;
        } else {
            CanvasTransformation canvasTransformation = this.canvasTransformation;
            this.drawMatrix = canvasTransformation != null ? canvasTransformation.calculateTransformation(this.tempMatrix, bounds, i, i2) : null;
        }
    }
}
