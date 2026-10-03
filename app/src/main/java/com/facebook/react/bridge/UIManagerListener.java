package com.facebook.react.bridge;

import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@UnstableReactNativeAPI
public interface UIManagerListener {
    void didDispatchMountItems(@NotNull UIManager uIManager);

    void didMountItems(@NotNull UIManager uIManager);

    void didScheduleMountItems(@NotNull UIManager uIManager);

    void willDispatchViewUpdates(@NotNull UIManager uIManager);

    void willMountItems(@NotNull UIManager uIManager);
}
