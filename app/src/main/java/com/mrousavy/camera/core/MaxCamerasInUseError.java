package com.mrousavy.camera.core;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class MaxCamerasInUseError extends CameraError {
    public MaxCamerasInUseError(@Nullable Throwable th) {
        super("system", "max-cameras-in-use", "The maximum amount of Cameras available for simultaneous use has been reached!", th);
    }
}
