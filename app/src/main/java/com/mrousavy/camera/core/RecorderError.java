package com.mrousavy.camera.core;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class RecorderError extends CameraError {
    private final boolean wasVideoRecorded;

    public final boolean getWasVideoRecorded() {
        return this.wasVideoRecorded;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecorderError(@NotNull String id, @NotNull String message, boolean z, @Nullable Throwable th) {
        super("capture", id, message, th);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(message, "message");
        this.wasVideoRecorded = z;
    }
}
