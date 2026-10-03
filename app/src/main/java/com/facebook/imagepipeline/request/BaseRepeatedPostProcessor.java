package com.facebook.imagepipeline.request;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseRepeatedPostProcessor extends BasePostprocessor implements RepeatedPostprocessor {
    private RepeatedPostprocessorRunner callback;

    @Override // com.facebook.imagepipeline.request.RepeatedPostprocessor
    public void setCallback(@NotNull RepeatedPostprocessorRunner runner) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(runner, "runner");
            this.callback = runner;
        }
    }

    public final void update() {
        RepeatedPostprocessorRunner repeatedPostprocessorRunner = this.callback;
        if (repeatedPostprocessorRunner != null) {
            repeatedPostprocessorRunner.update();
        }
    }
}
