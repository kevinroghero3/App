package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface MountItem {
    void execute(@NotNull MountingManager mountingManager);

    int getSurfaceId();
}
