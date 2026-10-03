package com.zoontek.rnbootsplash;

import java.util.Vector;

/* JADX INFO: loaded from: classes3.dex */
public final class RNBootSplashQueue<E> extends Vector<E> {
    public int getSize() {
        return super.size();
    }

    @Override // java.util.Vector, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        return (E) removeAt(i);
    }

    public Object removeAt(int i) {
        return super.remove(i);
    }

    @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return getSize();
    }

    public final E shift() {
        synchronized (this) {
            if (size() == 0) {
                return null;
            }
            E eElementAt = elementAt(0);
            removeElementAt(0);
            return eElementAt;
        }
    }

    public final void push(E e) {
        addElement(e);
    }
}
