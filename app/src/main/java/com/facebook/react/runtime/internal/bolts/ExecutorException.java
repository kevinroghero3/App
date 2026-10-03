package com.facebook.react.runtime.internal.bolts;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ExecutorException extends RuntimeException {
    public ExecutorException(@Nullable Exception exc) {
        super("An exception was thrown by an Executor", exc);
    }
}
