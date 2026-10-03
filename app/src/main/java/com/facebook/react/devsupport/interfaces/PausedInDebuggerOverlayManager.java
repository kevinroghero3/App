package com.facebook.react.devsupport.interfaces;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface PausedInDebuggerOverlayManager {
    void hidePausedInDebuggerOverlay();

    void showPausedInDebuggerOverlay(@NotNull String str, @NotNull DevSupportManager.PausedInDebuggerOverlayCommandListener pausedInDebuggerOverlayCommandListener);
}
