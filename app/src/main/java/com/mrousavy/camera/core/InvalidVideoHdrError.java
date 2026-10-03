package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes3.dex */
public final class InvalidVideoHdrError extends CameraError {
    public InvalidVideoHdrError() {
        super("format", "invalid-video-hdr", "The given format does not support videoHdr! Select a format where `format.supportsVideoHdr` is true.", null, 8, null);
    }
}
