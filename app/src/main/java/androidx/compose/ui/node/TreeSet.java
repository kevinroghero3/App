package androidx.compose.ui.node;

import java.util.Comparator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class TreeSet<E> extends java.util.TreeSet<E> {
    public static final int $stable = 0;

    public int getSize() {
        return super.size();
    }

    @Override // java.util.TreeSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return getSize();
    }

    public TreeSet(@NotNull Comparator<? super E> comparator) {
        super(comparator);
    }
}
