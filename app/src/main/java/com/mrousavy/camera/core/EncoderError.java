package com.mrousavy.camera.core;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class EncoderError extends RecorderError {
    public EncoderError(@Nullable Throwable th) {
        super("encoder-error", "The Video Encoder encountered an error occurred while recording a video!", false, th);
    }
}
