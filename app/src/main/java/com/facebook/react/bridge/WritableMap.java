package com.facebook.react.bridge;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface WritableMap extends ReadableMap {
    WritableMap copy();

    void merge(@NotNull ReadableMap readableMap);

    void putArray(@NotNull String str, @Nullable ReadableArray readableArray);

    void putBoolean(@NotNull String str, boolean z);

    void putDouble(@NotNull String str, double d);

    void putInt(@NotNull String str, int i);

    void putLong(@NotNull String str, long j);

    void putMap(@NotNull String str, @Nullable ReadableMap readableMap);

    void putNull(@NotNull String str);

    void putString(@NotNull String str, @Nullable String str2);
}
