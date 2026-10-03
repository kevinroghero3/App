package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes6.dex */
public final class SnapshotFailedPreviewNotEnabledError extends CameraError {
    public SnapshotFailedPreviewNotEnabledError() {
        super("capture", "snapshot-failed-preview-not-enabled", "Failed to take a Snapshot because preview={...} was disabled! Enable preview and try again.", null, 8, null);
    }
}
