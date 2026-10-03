package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes6.dex */
public final class NoRecordingInProgressError extends CameraError {
    public NoRecordingInProgressError() {
        super("capture", "no-recording-in-progress", "There was no active video recording in progress! Did you call stopRecording() twice?", null, 8, null);
    }
}
