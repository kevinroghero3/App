package com.facebook.react.interfaces.fabric;

import com.facebook.react.bridge.NativeMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface SurfaceHandler {
    String getModuleName();

    int getSurfaceId();

    boolean isRunning();

    void setLayoutConstraints(int i, int i2, int i3, int i4, boolean z, boolean z2, float f);

    void setMountable(boolean z);

    void setProps(@NotNull NativeMap nativeMap);
}
