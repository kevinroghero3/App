package com.facebook.react.common;

import androidx.core.util.Pools;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class ClearableSynchronizedPool<T> implements Pools.Pool<T> {
    private final Object[] pool;
    private int size;

    public ClearableSynchronizedPool(int i) {
        this.pool = new Object[i];
    }

    @Override // androidx.core.util.Pools.Pool
    public T acquire() {
        synchronized (this) {
            int i = this.size;
            if (i == 0) {
                return null;
            }
            int i2 = i - 1;
            this.size = i2;
            T t = (T) this.pool[i2];
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of com.facebook.react.common.ClearableSynchronizedPool");
            this.pool[i2] = null;
            return t;
        }
    }

    @Override // androidx.core.util.Pools.Pool
    public boolean release(@NotNull T instance) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            int i = this.size;
            Object[] objArr = this.pool;
            if (i == objArr.length) {
                return false;
            }
            objArr[i] = instance;
            this.size = i + 1;
            return true;
        }
    }

    public final void clear() {
        synchronized (this) {
            int i = this.size;
            for (int i2 = 0; i2 < i; i2++) {
                this.pool[i2] = null;
            }
            this.size = 0;
        }
    }
}
