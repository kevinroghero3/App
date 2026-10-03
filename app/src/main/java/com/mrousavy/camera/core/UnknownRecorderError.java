package com.mrousavy.camera.core;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class UnknownRecorderError extends RecorderError {
    public UnknownRecorderError(boolean z, @Nullable Throwable th) {
        super("recorder-error", "An error occurred while recording a video! " + CameraErrorKt.getVideoCapturedMessage(z) + StringUtils.SPACE + (th != null ? th.getMessage() : null), z, th);
    }
}
