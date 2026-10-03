package com.facebook.imagepipeline.request;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface RepeatedPostprocessor extends Postprocessor {
    void setCallback(@NotNull RepeatedPostprocessorRunner repeatedPostprocessorRunner);
}
