package com.mrousavy.camera.core;

import io.sentry.cache.EnvelopeCache;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class RecoverableError extends CameraError {
    public RecoverableError(@Nullable Throwable th) {
        super(EnvelopeCache.PREFIX_CURRENT_SESSION_FILE, "recoverable-error", "An unknown error occurred while creating the Camera Session, but the Camera can recover from it.", th);
    }
}
