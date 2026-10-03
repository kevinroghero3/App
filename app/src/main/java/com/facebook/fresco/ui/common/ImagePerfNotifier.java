package com.facebook.fresco.ui.common;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface ImagePerfNotifier {
    void notifyStatusUpdated(@NotNull ImagePerfState imagePerfState, @NotNull ImageLoadStatus imageLoadStatus);

    void notifyVisibilityUpdated(@NotNull ImagePerfState imagePerfState, @NotNull VisibilityState visibilityState);
}
