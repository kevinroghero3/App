package androidx.camera.core.processing;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public interface Node<I, O> {
    void release();

    O transform(@NonNull I i);
}
