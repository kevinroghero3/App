package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes3.dex */
public final class PhotoHdrAndVideoHdrNotSupportedSimultaneously extends CameraError {
    public PhotoHdrAndVideoHdrNotSupportedSimultaneously() {
        super("format", "photo-hdr-and-video-hdr-not-suppoted-simultaneously", "Photo HDR and Video HDR are not supported simultaneously! Disable either `videoHdr` or `photoHdr`.", null, 8, null);
    }
}
