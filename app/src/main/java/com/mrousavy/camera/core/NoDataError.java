package com.mrousavy.camera.core;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class NoDataError extends RecorderError {
    public NoDataError(@Nullable Throwable th) {
        super("no-data", "The Video Recording failed because no data was received! (" + (th != null ? th.getMessage() : null) + ") Did you stop the recording before any Frames arrived?", false, th);
    }
}
