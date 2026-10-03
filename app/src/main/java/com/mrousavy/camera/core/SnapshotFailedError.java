package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes6.dex */
public final class SnapshotFailedError extends CameraError {
    public SnapshotFailedError() {
        super("capture", "snapshot-failed", "Failed to take a Snapshot of the Preview View! Try using takePhoto() instead.", null, 8, null);
    }
}
