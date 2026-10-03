package com.mrousavy.camera.core;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class FileIOError extends CameraError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileIOError(@NotNull Throwable throwable) {
        super("capture", "file-io-error", "An unexpected File IO error occurred! Error: " + throwable.getMessage() + ".", throwable);
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }
}
