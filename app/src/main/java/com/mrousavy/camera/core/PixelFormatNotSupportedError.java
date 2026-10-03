package com.mrousavy.camera.core;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class PixelFormatNotSupportedError extends CameraError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PixelFormatNotSupportedError(@NotNull String format) {
        super("device", "pixel-format-not-supported", "The pixelFormat " + format + " is not supported on the given Camera Device!", null, 8, null);
        Intrinsics.checkNotNullParameter(format, "format");
    }
}
