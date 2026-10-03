package com.facebook.debug.debugoverlay.model;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class DebugOverlayTag {
    private final int color;
    private final String description;
    private final String name;

    public DebugOverlayTag(@NotNull String name, @NotNull String description, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        this.name = name;
        this.description = description;
        this.color = i;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getColor() {
        return this.color;
    }
}
