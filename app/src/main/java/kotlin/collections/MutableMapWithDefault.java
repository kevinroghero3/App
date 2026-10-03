package kotlin.collections;

import java.util.Map;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes6.dex */
interface MutableMapWithDefault<K, V> extends Map<K, V>, MapWithDefault<K, V>, KMutableMap {
    @Override // kotlin.collections.MapWithDefault
    Map<K, V> getMap();
}
