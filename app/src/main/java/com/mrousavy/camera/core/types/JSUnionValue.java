package com.mrousavy.camera.core.types;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface JSUnionValue {

    public interface Companion<T> {
        T fromUnionValue(@Nullable String str);
    }

    String getUnionValue();
}
