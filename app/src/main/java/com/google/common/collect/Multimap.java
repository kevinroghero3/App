package com.google.common.collect;

import androidx.exifinterface.media.ExifInterface;
import com.google.errorprone.annotations.CompatibleWith;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes2.dex */
@DoNotMock("Use ImmutableMultimap, HashMultimap, or another implementation")
@ElementTypesAreNonnullByDefault
public interface Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(@CheckForNull @CompatibleWith("K") Object obj, @CheckForNull @CompatibleWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED) Object obj2);

    boolean containsKey(@CheckForNull @CompatibleWith("K") Object obj);

    boolean containsValue(@CheckForNull @CompatibleWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED) Object obj);

    Collection<Map.Entry<K, V>> entries();

    boolean equals(@CheckForNull Object obj);

    Collection<V> get(@ParametricNullness K k);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    Multiset<K> keys();

    boolean put(@ParametricNullness K k, @ParametricNullness V v);

    boolean putAll(Multimap<? extends K, ? extends V> multimap);

    boolean putAll(@ParametricNullness K k, Iterable<? extends V> iterable);

    boolean remove(@CheckForNull @CompatibleWith("K") Object obj, @CheckForNull @CompatibleWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED) Object obj2);

    Collection<V> removeAll(@CheckForNull @CompatibleWith("K") Object obj);

    Collection<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable);

    int size();

    Collection<V> values();
}
