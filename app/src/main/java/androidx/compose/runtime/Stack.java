package androidx.compose.runtime;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class Stack<T> {
    public static final int $stable = 8;
    private final ArrayList<T> backing = new ArrayList<>();

    public final int getSize() {
        return this.backing.size();
    }

    public final boolean push(T t) {
        return this.backing.add(t);
    }

    public final T pop() {
        return this.backing.remove(getSize() - 1);
    }

    public final T peek() {
        return this.backing.get(getSize() - 1);
    }

    public final T peek(int i) {
        return this.backing.get(i);
    }

    public final boolean isEmpty() {
        return this.backing.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    public final void clear() {
        this.backing.clear();
    }

    public final T[] toArray() {
        int size = this.backing.size();
        T[] tArr = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            tArr[i] = this.backing.get(i);
        }
        return tArr;
    }
}
