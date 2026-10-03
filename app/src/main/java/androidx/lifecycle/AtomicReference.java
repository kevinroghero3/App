package androidx.lifecycle;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;

/* JADX INFO: loaded from: classes2.dex */
public final class AtomicReference<V> {
    private final java.util.concurrent.atomic.AtomicReference<V> base;

    public AtomicReference(V v) {
        this.base = new java.util.concurrent.atomic.AtomicReference<>(v);
    }

    public final V get() {
        return this.base.get();
    }

    public final boolean compareAndSet(V v, V v2) {
        return PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.base, v, v2);
    }
}
