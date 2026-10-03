package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes6.dex */
public final class RecordingWhileFrameProcessingUnavailable extends CameraError {
    public RecordingWhileFrameProcessingUnavailable() {
        super("system", "recording-while-frame-processing-unavailable", "Video Recordings are not possible with a Frame Processor running, because the device is running on API 22 or lower and ImageWriters are not available.", null, 8, null);
    }
}
