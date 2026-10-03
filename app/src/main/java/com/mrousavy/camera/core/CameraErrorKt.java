package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes6.dex */
public final class CameraErrorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String getVideoCapturedMessage(boolean z) {
        if (z) {
            return "The output file was generated, so the recording may be valid.";
        }
        return "The output file was generated but the recording will not be valid, so you should delete the file.";
    }
}
