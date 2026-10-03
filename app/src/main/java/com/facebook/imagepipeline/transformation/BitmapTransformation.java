package com.facebook.imagepipeline.transformation;

import android.graphics.Bitmap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface BitmapTransformation {
    boolean modifiesTransparency();

    void transform(@NotNull Bitmap bitmap);
}
