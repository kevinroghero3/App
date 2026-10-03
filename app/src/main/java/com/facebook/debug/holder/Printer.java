package com.facebook.debug.holder;

import com.facebook.debug.debugoverlay.model.DebugOverlayTag;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface Printer {
    void logMessage(@NotNull DebugOverlayTag debugOverlayTag, @NotNull String str);

    void logMessage(@NotNull DebugOverlayTag debugOverlayTag, @NotNull String str, @NotNull Object... objArr);

    boolean shouldDisplayLogMessage(@NotNull DebugOverlayTag debugOverlayTag);
}
