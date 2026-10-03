package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes6.dex */
public final class FocusNotSupportedError extends CameraError {
    public FocusNotSupportedError() {
        super("device", "focus-not-supported", "The currently selected camera device does not support focusing!", null, 8, null);
    }
}
