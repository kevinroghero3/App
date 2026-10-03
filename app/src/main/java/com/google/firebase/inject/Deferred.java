package com.google.firebase.inject;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public interface Deferred<T> {

    public interface DeferredHandler<T> {
        void handle(Provider<T> provider);
    }

    void whenAvailable(@NonNull DeferredHandler<T> deferredHandler);
}
