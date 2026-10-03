package com.facebook.fresco.vito.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class PathShape extends Shape {
    private final Path path;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathShape(@NotNull Path path) {
        super(null);
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
    }

    public final Path getPath() {
        return this.path;
    }

    @Override // com.facebook.fresco.vito.renderer.Shape
    public void draw(@NotNull Canvas canvas, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawPath(this.path, paint);
    }
}
