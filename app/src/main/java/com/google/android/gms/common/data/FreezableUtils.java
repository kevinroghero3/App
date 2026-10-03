package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.facebook.common.internal.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull ArrayList<E> arrayList) {
        ImmutableList immutableList = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            immutableList.add(arrayList.get(i).freeze());
        }
        return immutableList;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(@NonNull Iterable<E> iterable) {
        ImmutableList immutableList = (ArrayList<T>) new ArrayList();
        Iterator<E> it2 = iterable.iterator();
        while (it2.hasNext()) {
            immutableList.add(it2.next().freeze());
        }
        return immutableList;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull E[] eArr) {
        ImmutableList immutableList = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            immutableList.add(e.freeze());
        }
        return immutableList;
    }
}
