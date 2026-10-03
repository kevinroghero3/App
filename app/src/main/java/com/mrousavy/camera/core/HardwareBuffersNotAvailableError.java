package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes6.dex */
public final class HardwareBuffersNotAvailableError extends CameraError {
    public HardwareBuffersNotAvailableError() {
        super("system", "hardware-buffers-unavailable", "HardwareBuffers are only available on API 28 or higher!", null, 8, null);
    }
}
