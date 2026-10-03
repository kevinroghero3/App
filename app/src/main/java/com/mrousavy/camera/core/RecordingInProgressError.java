package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes6.dex */
public final class RecordingInProgressError extends CameraError {
    public RecordingInProgressError() {
        super("capture", "recording-in-progress", "There is already an active video recording in progress! Did you call startRecording() twice?", null, 8, null);
    }
}
