package com.facebook.react.bridge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface ReadableMap {
    ReadableArray getArray(@NotNull String str);

    boolean getBoolean(@NotNull String str);

    double getDouble(@NotNull String str);

    Dynamic getDynamic(@NotNull String str);

    Iterator<Map.Entry<String, Object>> getEntryIterator();

    int getInt(@NotNull String str);

    long getLong(@NotNull String str);

    ReadableMap getMap(@NotNull String str);

    String getString(@NotNull String str);

    ReadableType getType(@NotNull String str);

    boolean hasKey(@NotNull String str);

    boolean isNull(@NotNull String str);

    ReadableMapKeySetIterator keySetIterator();

    HashMap<String, Object> toHashMap();
}
