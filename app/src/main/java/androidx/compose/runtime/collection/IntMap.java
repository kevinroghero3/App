package androidx.compose.runtime.collection;

import android.util.SparseArray;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class IntMap<E> {
    public static final int $stable = 8;
    private final SparseArray<E> sparseArray;

    private IntMap(SparseArray<E> sparseArray) {
        this.sparseArray = sparseArray;
    }

    public IntMap(int i) {
        this(new SparseArray(i));
    }

    public /* synthetic */ IntMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 10 : i);
    }

    public final boolean contains(int i) {
        return this.sparseArray.indexOfKey(i) >= 0;
    }

    public final E get(int i) {
        return this.sparseArray.get(i);
    }

    public final E get(int i, E e) {
        return this.sparseArray.get(i, e);
    }

    public final void set(int i, E e) {
        this.sparseArray.put(i, e);
    }

    public final void remove(int i) {
        this.sparseArray.remove(i);
    }

    public final void clear() {
        this.sparseArray.clear();
    }

    public final int getSize() {
        return this.sparseArray.size();
    }
}
