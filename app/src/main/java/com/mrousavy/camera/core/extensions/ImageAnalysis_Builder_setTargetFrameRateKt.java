package com.mrousavy.camera.core.extensions;

import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.camera.camera2.interop.Camera2Interop;
import androidx.camera.core.ImageAnalysis;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ImageAnalysis_Builder_setTargetFrameRateKt {
    public static final void setTargetFrameRate(@NotNull ImageAnalysis.Builder builder, @NotNull Range<Integer> frameRate) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(frameRate, "frameRate");
        new Camera2Interop.Extender(builder).setCaptureRequestOption(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, frameRate);
    }
}
