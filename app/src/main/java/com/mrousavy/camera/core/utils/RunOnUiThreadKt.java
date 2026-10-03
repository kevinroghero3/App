package com.mrousavy.camera.core.utils;

import com.facebook.react.bridge.UiThreadUtil;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class RunOnUiThreadKt {
    public static final <T> Object runOnUiThreadAndWait(@NotNull Function0<? extends T> function0, @NotNull Continuation<? super T> continuation) {
        if (UiThreadUtil.isOnUiThread()) {
            return function0.invoke();
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        UiThreadUtil.runOnUiThread(new RunOnUiThreadKt$runOnUiThreadAndWait$2$1(cancellableContinuationImpl, function0));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private static final <T> Object runOnUiThreadAndWait$$forInline(Function0<? extends T> function0, Continuation<? super T> continuation) {
        if (UiThreadUtil.isOnUiThread()) {
            return function0.invoke();
        }
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        UiThreadUtil.runOnUiThread(new RunOnUiThreadKt$runOnUiThreadAndWait$2$1(cancellableContinuationImpl, function0));
        Unit unit = Unit.INSTANCE;
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }

    public static final void runOnUiThread(@NotNull final Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        if (UiThreadUtil.isOnUiThread()) {
            function.invoke();
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.core.utils.RunOnUiThreadKt.runOnUiThread.1
                @Override // java.lang.Runnable
                public final void run() {
                    function.invoke();
                }
            });
        }
    }
}
