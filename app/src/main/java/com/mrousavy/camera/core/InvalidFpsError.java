package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes3.dex */
public final class InvalidFpsError extends CameraError {
    public InvalidFpsError(int i) {
        super("format", "invalid-fps", "The given format cannot run at " + i + " FPS! Make sure your FPS is lower than `format.maxFps` but higher than `format.minFps`.", null, 8, null);
    }
}
