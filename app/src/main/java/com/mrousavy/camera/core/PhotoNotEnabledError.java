package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes6.dex */
public final class PhotoNotEnabledError extends CameraError {
    public PhotoNotEnabledError() {
        super("capture", "photo-not-enabled", "Photo capture is disabled! Pass `photo={true}` to enable photo capture.", null, 8, null);
    }
}
