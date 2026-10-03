package com.mrousavy.camera.core;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class InvalidPathError extends CameraError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidPathError(@NotNull String path) {
        super("capture", "invalid-path", "The given path (" + path + ") is invalid, or not writable!", null, 8, null);
        Intrinsics.checkNotNullParameter(path, "path");
    }
}
