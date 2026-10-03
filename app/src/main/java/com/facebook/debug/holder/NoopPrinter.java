package com.facebook.debug.holder;

import com.facebook.debug.debugoverlay.model.DebugOverlayTag;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class NoopPrinter implements Printer {
    public static final NoopPrinter INSTANCE = new NoopPrinter();

    @Override // com.facebook.debug.holder.Printer
    public void logMessage(@NotNull DebugOverlayTag tag, @NotNull String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Override // com.facebook.debug.holder.Printer
    public void logMessage(@NotNull DebugOverlayTag tag, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
    }

    @Override // com.facebook.debug.holder.Printer
    public boolean shouldDisplayLogMessage(@NotNull DebugOverlayTag tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return false;
    }

    private NoopPrinter() {
    }
}
