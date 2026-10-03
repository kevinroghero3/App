package io.sentry.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class CollectionUtils {

    /* JADX INFO: loaded from: classes6.dex */
    public interface Mapper<T, R> {
        R map(T t);
    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    private CollectionUtils() {
    }

    public static int size(@NotNull Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        Iterator<?> it2 = iterable.iterator();
        int i = 0;
        while (it2.hasNext()) {
            it2.next();
            i++;
        }
        return i;
    }

    public static <K, V> Map<K, V> newConcurrentHashMap(@Nullable Map<K, V> map) {
        if (map == null) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                concurrentHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return concurrentHashMap;
    }

    public static <K, V> Map<K, V> newHashMap(@Nullable Map<K, V> map) {
        if (map != null) {
            return new HashMap(map);
        }
        return null;
    }

    public static <T> List<T> newArrayList(@Nullable List<T> list) {
        if (list != null) {
            return new ArrayList(list);
        }
        return null;
    }

    public static <K, V> Map<K, V> filterMapEntries(@NotNull Map<K, V> map, @NotNull Predicate<Map.Entry<K, V>> predicate) {
        HashMap map2 = new HashMap();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (predicate.test(entry)) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        return map2;
    }

    public static <T, R> List<R> map(@NotNull List<T> list, @NotNull Mapper<T, R> mapper) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(mapper.map(it2.next()));
        }
        return arrayList;
    }

    public static <T> List<T> filterListEntries(@NotNull List<T> list, @NotNull Predicate<T> predicate) {
        ArrayList arrayList = new ArrayList(list.size());
        for (T t : list) {
            if (predicate.test(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static <T> boolean contains(@NotNull T[] tArr, @NotNull T t) {
        for (T t2 : tArr) {
            if (t.equals(t2)) {
                return true;
            }
        }
        return false;
    }

    public static <T> ListIterator<T> reverseListIterator(@NotNull CopyOnWriteArrayList<T> copyOnWriteArrayList) {
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(copyOnWriteArrayList);
        return copyOnWriteArrayList2.listIterator(copyOnWriteArrayList2.size());
    }
}
