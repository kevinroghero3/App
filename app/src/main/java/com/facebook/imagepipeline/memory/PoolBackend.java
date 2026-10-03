package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes2.dex */
public interface PoolBackend<T> {
    T get(int i);

    int getSize(T t);

    T pop();

    void put(T t);
}
