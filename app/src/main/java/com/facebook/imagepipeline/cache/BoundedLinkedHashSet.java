package com.facebook.imagepipeline.cache;

import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class BoundedLinkedHashSet<E> {
    private final LinkedHashSet<E> linkedHashSet;
    private final int maxSize;

    public BoundedLinkedHashSet(int i) {
        this.maxSize = i;
        this.linkedHashSet = new LinkedHashSet<>(i);
    }

    public final boolean contains(E e) {
        boolean zContains;
        synchronized (this) {
            zContains = this.linkedHashSet.contains(e);
        }
        return zContains;
    }

    public final boolean add(E e) {
        boolean zAdd;
        synchronized (this) {
            if (this.linkedHashSet.size() == this.maxSize) {
                LinkedHashSet<E> linkedHashSet = this.linkedHashSet;
                linkedHashSet.remove(linkedHashSet.iterator().next());
            }
            this.linkedHashSet.remove(e);
            zAdd = this.linkedHashSet.add(e);
        }
        return zAdd;
    }
}
