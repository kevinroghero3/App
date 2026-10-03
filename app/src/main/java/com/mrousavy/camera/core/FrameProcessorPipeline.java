package com.mrousavy.camera.core;

import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import com.mrousavy.camera.frameprocessors.Frame;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class FrameProcessorPipeline implements ImageAnalysis.Analyzer {
    private final CameraSession.Callback callback;

    public FrameProcessorPipeline(@NotNull CameraSession.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(@NotNull ImageProxy imageProxy) {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        Frame frame = new Frame(imageProxy);
        try {
            frame.incrementRefCount();
            this.callback.onFrame(frame);
        } finally {
            frame.decrementRefCount();
        }
    }
}
