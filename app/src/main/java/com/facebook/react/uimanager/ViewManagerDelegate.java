package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface ViewManagerDelegate<T extends View> {
    void receiveCommand(@NotNull T t, @Nullable String str, @Nullable ReadableArray readableArray);

    void setProperty(@NotNull T t, @Nullable String str, @Nullable Object obj);
}
