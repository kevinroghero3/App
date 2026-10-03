package com.facebook.react.uimanager;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ReactInvalidPropertyException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactInvalidPropertyException(@NotNull String property, @NotNull String value, @NotNull String expectedValues) {
        super("Invalid React property `" + property + "` with value `" + value + "`, expected " + expectedValues);
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(expectedValues, "expectedValues");
    }
}
