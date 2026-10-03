package com.mrousavy.camera.core;

import io.sentry.cache.EnvelopeCache;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraNotReadyError extends CameraError {
    public CameraNotReadyError() {
        super(EnvelopeCache.PREFIX_CURRENT_SESSION_FILE, "camera-not-ready", "The Camera is not ready yet! Wait for the onInitialized() callback!", null, 8, null);
    }
}
