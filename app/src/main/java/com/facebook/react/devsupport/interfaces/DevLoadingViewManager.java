package com.facebook.react.devsupport.interfaces;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface DevLoadingViewManager {
    void hide();

    void showMessage(@NotNull String str);

    void updateProgress(@Nullable String str, @Nullable Integer num, @Nullable Integer num2);
}
