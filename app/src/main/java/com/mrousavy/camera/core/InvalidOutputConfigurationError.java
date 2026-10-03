package com.mrousavy.camera.core;

import io.sentry.cache.EnvelopeCache;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class InvalidOutputConfigurationError extends CameraError {
    public InvalidOutputConfigurationError(@Nullable Throwable th) {
        super(EnvelopeCache.PREFIX_CURRENT_SESSION_FILE, "invalid-output-configuration", "Failed to configure the Camera Session because the output/stream configurations are invalid!", th);
    }
}
