package com.facebook.imageutils;

import android.graphics.ColorSpace;
import kotlin.Pair;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ImageMetaData {
    private final ColorSpace colorSpace;
    private final Pair<Integer, Integer> dimensions;

    public ImageMetaData(int i, int i2, @Nullable ColorSpace colorSpace) {
        this.colorSpace = colorSpace;
        this.dimensions = (i == -1 || i2 == -1) ? null : new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final ColorSpace getColorSpace() {
        return this.colorSpace;
    }

    public final Pair<Integer, Integer> getDimensions() {
        return this.dimensions;
    }
}
