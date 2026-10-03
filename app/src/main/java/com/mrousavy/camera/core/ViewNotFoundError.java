package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes6.dex */
public final class ViewNotFoundError extends CameraError {
    public ViewNotFoundError(int i) {
        super("system", "view-not-found", "The given view (ID " + i + ") was not found in the view manager.", null, 8, null);
    }
}
