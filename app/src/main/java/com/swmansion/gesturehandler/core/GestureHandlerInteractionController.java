package com.swmansion.gesturehandler.core;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface GestureHandlerInteractionController {
    boolean shouldHandlerBeCancelledBy(@NotNull GestureHandler gestureHandler, @NotNull GestureHandler gestureHandler2);

    boolean shouldRecognizeSimultaneously(@NotNull GestureHandler gestureHandler, @NotNull GestureHandler gestureHandler2);

    boolean shouldRequireHandlerToWaitForFailure(@NotNull GestureHandler gestureHandler, @NotNull GestureHandler gestureHandler2);

    boolean shouldWaitForHandlerFailure(@NotNull GestureHandler gestureHandler, @NotNull GestureHandler gestureHandler2);
}
