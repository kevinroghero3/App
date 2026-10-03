package com.mrousavy.camera.core;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraIsRestrictedError extends CameraError {
    public CameraIsRestrictedError(@Nullable Throwable th) {
        super("system", "camera-is-restricted", "Camera functionality is not available because it has been restricted by the operating system, possibly due to a device policy.", th);
    }
}
