package androidx.camera.core;

import androidx.camera.core.impl.MutableConfig;

/* JADX INFO: loaded from: classes2.dex */
public interface ExtendableBuilder<T> {
    T build();

    MutableConfig getMutableConfig();
}
