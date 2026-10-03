package com.mrousavy.camera.core;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class FileSizeLimitReachedError extends RecorderError {
    public FileSizeLimitReachedError(@Nullable Throwable th) {
        super("file-size-limit-reached", "The Video Recording was stopped because the file size limit was reached. The output file may still be valid.", true, th);
    }
}
