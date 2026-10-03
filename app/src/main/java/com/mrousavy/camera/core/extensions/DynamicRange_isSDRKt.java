package com.mrousavy.camera.core.extensions;

import androidx.camera.core.DynamicRange;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class DynamicRange_isSDRKt {
    public static final boolean isSDR(@NotNull DynamicRange dynamicRange) {
        Intrinsics.checkNotNullParameter(dynamicRange, "<this>");
        return dynamicRange.getEncoding() == 1 || dynamicRange.getEncoding() == 0;
    }
}
