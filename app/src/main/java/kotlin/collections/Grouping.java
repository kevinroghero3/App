package kotlin.collections;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public interface Grouping<T, K> {
    K keyOf(T t);

    Iterator<T> sourceIterator();
}
