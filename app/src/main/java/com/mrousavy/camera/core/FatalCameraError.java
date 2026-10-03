package com.mrousavy.camera.core;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class FatalCameraError extends CameraError {
    public FatalCameraError(@Nullable Throwable th) {
        super("device", "fatal-error", "An unknown fatal error occurred in the Camera HAL! Try restarting the phone.", th);
    }
}
