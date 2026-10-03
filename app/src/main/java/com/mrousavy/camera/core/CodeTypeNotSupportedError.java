package com.mrousavy.camera.core;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class CodeTypeNotSupportedError extends CameraError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeTypeNotSupportedError(@NotNull String codeType) {
        super("code-scanner", "code-type-not-supported", "The codeType \"" + codeType + "\" is not supported by the Code Scanner!", null, 8, null);
        Intrinsics.checkNotNullParameter(codeType, "codeType");
    }
}
