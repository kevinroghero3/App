package com.mrousavy.camera.core;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class InvalidTypeScriptUnionError extends CameraError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidTypeScriptUnionError(@NotNull String unionName, @Nullable String str) {
        super("parameter", "invalid-parameter", "The given value for " + unionName + " could not be parsed! (Received: " + str + ")", null, 8, null);
        Intrinsics.checkNotNullParameter(unionName, "unionName");
    }
}
