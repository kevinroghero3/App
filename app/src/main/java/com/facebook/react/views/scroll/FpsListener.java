package com.facebook.react.views.scroll;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface FpsListener {
    void disable(@NotNull String str);

    void enable(@NotNull String str);

    boolean isEnabled();
}
