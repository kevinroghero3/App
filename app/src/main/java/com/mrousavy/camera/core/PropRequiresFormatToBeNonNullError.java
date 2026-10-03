package com.mrousavy.camera.core;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class PropRequiresFormatToBeNonNullError extends CameraError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropRequiresFormatToBeNonNullError(@NotNull String propName) {
        super("format", "format-required", "The prop \"" + propName + "\" requires a format to be set, but format was null!", null, 8, null);
        Intrinsics.checkNotNullParameter(propName, "propName");
    }
}
