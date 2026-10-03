package com.mrousavy.camera.core;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class UnknownCameraError extends CameraError {
    public UnknownCameraError(@Nullable Throwable th) {
        String message;
        super("unknown", "unknown", (th == null || (message = th.getMessage()) == null) ? "An unknown camera error occured." : message, th);
    }
}
