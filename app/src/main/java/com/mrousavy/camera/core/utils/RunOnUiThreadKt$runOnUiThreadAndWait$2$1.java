package com.mrousavy.camera.core.utils;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: loaded from: classes6.dex */
public final class RunOnUiThreadKt$runOnUiThreadAndWait$2$1 implements Runnable {
    final /* synthetic */ CancellableContinuation<T> $continuation;
    final /* synthetic */ Function0<T> $function;

    /* JADX WARN: Multi-variable type inference failed */
    public RunOnUiThreadKt$runOnUiThreadAndWait$2$1(CancellableContinuation<? super T> cancellableContinuation, Function0<? extends T> function0) {
        this.$continuation = cancellableContinuation;
        this.$function = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.$continuation.isCancelled()) {
            throw new CancellationException();
        }
        Object objInvoke = this.$function.invoke();
        Continuation continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m5472constructorimpl(objInvoke));
    }
}
