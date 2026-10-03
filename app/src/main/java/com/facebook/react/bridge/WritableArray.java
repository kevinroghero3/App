package com.facebook.react.bridge;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface WritableArray extends ReadableArray {
    void pushArray(@Nullable ReadableArray readableArray);

    void pushBoolean(boolean z);

    void pushDouble(double d);

    void pushInt(int i);

    void pushLong(long j);

    void pushMap(@Nullable ReadableMap readableMap);

    void pushNull();

    void pushString(@Nullable String str);
}
