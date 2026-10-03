package com.facebook.fresco.ui.common;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface ImagePerfDataListener {
    void onImageLoadStatusUpdated(@NotNull ImagePerfData imagePerfData, @NotNull ImageLoadStatus imageLoadStatus);

    void onImageVisibilityUpdated(@NotNull ImagePerfData imagePerfData, @NotNull VisibilityState visibilityState);
}
