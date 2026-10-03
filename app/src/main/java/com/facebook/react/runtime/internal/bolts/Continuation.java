package com.facebook.react.runtime.internal.bolts;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface Continuation<TTaskResult, TContinuationResult> {
    TContinuationResult then(@NotNull Task<TTaskResult> task) throws Exception;
}
