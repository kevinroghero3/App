package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes6.dex */
public final class FrameInvalidError extends CameraError {
    public FrameInvalidError() {
        super("capture", "frame-invalid", "Trying to access an already closed Frame! Are you trying to access the Image data outside of a Frame Processor's lifetime?\n- If you want to use `console.log(frame)`, use `console.log(frame.toString())` instead.\n- If you want to do async processing, use `runAsync(...)` instead.\n- If you want to use runOnJS, increment it's ref-count: `frame.incrementRefCount()`", null, 8, null);
    }
}
