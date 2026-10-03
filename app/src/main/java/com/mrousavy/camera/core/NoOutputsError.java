package com.mrousavy.camera.core;

import io.sentry.cache.EnvelopeCache;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOutputsError extends CameraError {
    public NoOutputsError() {
        super(EnvelopeCache.PREFIX_CURRENT_SESSION_FILE, "no-outputs", "Cannot create a CameraCaptureSession without any outputs! (PREVIEW, PHOTO, VIDEO, ...)", null, 8, null);
    }
}
