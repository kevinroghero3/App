package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes6.dex */
public final class VideoNotEnabledError extends CameraError {
    public VideoNotEnabledError() {
        super("capture", "video-not-enabled", "Video capture is disabled! Pass `video={true}` to enable video recordings.", null, 8, null);
    }
}
