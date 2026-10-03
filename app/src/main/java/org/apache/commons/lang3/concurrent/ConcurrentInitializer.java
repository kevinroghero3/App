package org.apache.commons.lang3.concurrent;

/* JADX INFO: loaded from: classes6.dex */
public interface ConcurrentInitializer<T> {
    T get() throws ConcurrentException;
}
