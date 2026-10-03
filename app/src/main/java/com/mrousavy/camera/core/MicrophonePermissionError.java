package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes6.dex */
public final class MicrophonePermissionError extends CameraError {
    public MicrophonePermissionError() {
        super("permission", "microphone-permission-denied", "The Microphone permission was denied! If you want to record Video without sound, pass `audio={false}`.", null, 8, null);
    }
}
