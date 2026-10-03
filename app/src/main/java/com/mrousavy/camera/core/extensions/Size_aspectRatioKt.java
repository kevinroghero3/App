package com.mrousavy.camera.core.extensions;

import android.util.Size;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class Size_aspectRatioKt {
    public static final float getAspectRatio(@NotNull Size size) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        return size.getWidth() / size.getHeight();
    }
}
