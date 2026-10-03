package com.mrousavy.camera.core;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class InvalidRecorderConfigurationError extends RecorderError {
    public InvalidRecorderConfigurationError(@Nullable Throwable th) {
        super("invalid-recorder-configuration", "The Video Recording failed because it was configured with invalid settings! " + (th != null ? th.getMessage() : null), false, th);
    }
}
