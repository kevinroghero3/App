package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraPermissionError extends CameraError {
    public CameraPermissionError() {
        super("permission", "camera-permission-denied", "The Camera permission was denied!", null, 8, null);
    }
}
