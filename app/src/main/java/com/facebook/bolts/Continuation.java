package com.facebook.bolts;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface Continuation<TTaskResult, TContinuationResult> {
    TContinuationResult then(@NotNull Task<TTaskResult> task) throws Exception;
}
