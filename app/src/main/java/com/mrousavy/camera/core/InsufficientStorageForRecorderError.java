package com.mrousavy.camera.core;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class InsufficientStorageForRecorderError extends RecorderError {
    public InsufficientStorageForRecorderError(@Nullable Throwable th) {
        super("insufficient-storage", "There is not enough storage space available for a Video Recording.", false, th);
    }
}
