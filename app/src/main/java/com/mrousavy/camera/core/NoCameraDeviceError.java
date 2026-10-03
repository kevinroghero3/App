package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes3.dex */
public final class NoCameraDeviceError extends CameraError {
    public NoCameraDeviceError() {
        super("device", "no-device", "No device was set! Use `useCameraDevice(..)` or `Camera.getAvailableCameraDevices()` to select a suitable Camera device.", null, 8, null);
    }
}
