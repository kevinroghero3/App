package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes3.dex */
public final class FlashUnavailableError extends CameraError {
    public FlashUnavailableError() {
        super("device", "flash-not-available", "The Camera Device does not have a flash unit! Make sure you select a device where `device.hasFlash`/`device.hasTorch` is true.", null, 8, null);
    }
}
