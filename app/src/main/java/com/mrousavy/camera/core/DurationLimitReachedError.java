package com.mrousavy.camera.core;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class DurationLimitReachedError extends RecorderError {
    public DurationLimitReachedError(@Nullable Throwable th) {
        super("duration-limit-reached", "The Video Recording was stopped because the duration limit was reached. The output file may still be valid.", true, th);
    }
}
