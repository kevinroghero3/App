package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class WritableNativeMap extends ReadableNativeMap implements WritableMap {
    private final native void initHybrid();

    private final native void mergeNativeMap(ReadableNativeMap readableNativeMap);

    private final native void putNativeArray(String str, ReadableNativeArray readableNativeArray);

    private final native void putNativeMap(String str, ReadableNativeMap readableNativeMap);

    @Override // com.facebook.react.bridge.WritableMap
    public native void putBoolean(@NotNull String str, boolean z);

    @Override // com.facebook.react.bridge.WritableMap
    public native void putDouble(@NotNull String str, double d);

    @Override // com.facebook.react.bridge.WritableMap
    public native void putInt(@NotNull String str, int i);

    @Override // com.facebook.react.bridge.WritableMap
    public native void putLong(@NotNull String str, long j);

    @Override // com.facebook.react.bridge.WritableMap
    public native void putNull(@NotNull String str);

    @Override // com.facebook.react.bridge.WritableMap
    public native void putString(@NotNull String str, @Nullable String str2);

    public WritableNativeMap() {
        initHybrid();
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putMap(@NotNull String key, @Nullable ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(key, "key");
        Assertions.assertCondition(readableMap == null || (readableMap instanceof ReadableNativeMap), "Illegal type provided");
        putNativeMap(key, (ReadableNativeMap) readableMap);
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putArray(@NotNull String key, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(key, "key");
        Assertions.assertCondition(readableArray == null || (readableArray instanceof ReadableNativeArray), "Illegal type provided");
        putNativeArray(key, (ReadableNativeArray) readableArray);
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void merge(@NotNull ReadableMap source) {
        Intrinsics.checkNotNullParameter(source, "source");
        Assertions.assertCondition(source instanceof ReadableNativeMap, "Illegal type provided");
        mergeNativeMap((ReadableNativeMap) source);
    }

    @Override // com.facebook.react.bridge.WritableMap
    public WritableMap copy() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.merge(this);
        return writableNativeMap;
    }
}
