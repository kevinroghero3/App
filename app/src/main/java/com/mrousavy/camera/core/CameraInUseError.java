package com.mrousavy.camera.core;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraInUseError extends CameraError {
    public CameraInUseError(@Nullable Throwable th) {
        super("device", "camera-already-in-use", "The given Camera Device is already in use!", th);
    }
}
