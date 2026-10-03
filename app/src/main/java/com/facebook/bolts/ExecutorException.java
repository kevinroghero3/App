package com.facebook.bolts;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ExecutorException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutorException(@NotNull Exception e) {
        super("An exception was thrown by an Executor", e);
        Intrinsics.checkNotNullParameter(e, "e");
    }
}
