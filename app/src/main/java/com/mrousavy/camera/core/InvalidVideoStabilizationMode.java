package com.mrousavy.camera.core;

import com.mrousavy.camera.core.types.VideoStabilizationMode;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class InvalidVideoStabilizationMode extends CameraError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidVideoStabilizationMode(@NotNull VideoStabilizationMode mode) {
        super("format", "invalid-video-stabilization-mode", "The given format does not support the videoStabilizationMode \"" + mode.getUnionValue() + "\"! Select a format that contains " + mode.getUnionValue() + " in `format.supportedVideoStabilizationModes`.", null, 8, null);
        Intrinsics.checkNotNullParameter(mode, "mode");
    }
}
