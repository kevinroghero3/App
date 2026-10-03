package androidx.compose.ui.text.caches;

import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class LruCache<K, V> {
    public static final int $stable = 8;
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashSet<K> keySet;
    private final HashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private final SynchronizedObject monitor = Synchronization_jvmKt.createSynchronizedObject();
    private int putCount;
    private int size;

    protected V create(K k) {
        return null;
    }

    protected void entryRemoved(boolean z, K k, V v, @Nullable V v2) {
    }

    protected int sizeOf(K k, V v) {
        return 1;
    }

    public LruCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new HashMap<>(0, 0.75f);
        this.keySet = new LinkedHashSet<>();
    }

    public void resize(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this.monitor) {
            this.maxSize = i;
            Unit unit = Unit.INSTANCE;
        }
        trimToSize(i);
    }

    public final V get(K k) {
        synchronized (this.monitor) {
            V v = this.map.get(k);
            if (v != null) {
                this.keySet.remove(k);
                this.keySet.add(k);
                this.hitCount++;
                return v;
            }
            this.missCount++;
            V vCreate = create(k);
            if (vCreate == null) {
                return null;
            }
            synchronized (this.monitor) {
                this.createCount++;
                V vPut = this.map.put(k, vCreate);
                this.keySet.remove(k);
                this.keySet.add(k);
                if (vPut != null) {
                    this.map.put(k, vPut);
                    v = vPut;
                } else {
                    this.size = size() + safeSizeOf(k, vCreate);
                }
                Unit unit = Unit.INSTANCE;
            }
            if (v != null) {
                entryRemoved(false, k, vCreate, v);
                return v;
            }
            trimToSize(this.maxSize);
            return vCreate;
        }
    }

    public final V put(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw null;
        }
        synchronized (this.monitor) {
            this.putCount++;
            this.size = size() + safeSizeOf(k, v);
            vPut = this.map.put(k, v);
            if (vPut != null) {
                this.size = size() - safeSizeOf(k, vPut);
            }
            if (this.keySet.contains(k)) {
                this.keySet.remove(k);
            }
            this.keySet.add(k);
        }
        if (vPut != null) {
            entryRemoved(false, k, vPut, v);
        }
        trimToSize(this.maxSize);
        return vPut;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void trimToSize(int i) {
        Object objFirst;
        V v;
        while (true) {
            synchronized (this.monitor) {
                if (size() < 0 || ((this.map.isEmpty() && size() != 0) || this.map.isEmpty() != this.keySet.isEmpty())) {
                    break;
                }
                if (size() <= i || this.map.isEmpty()) {
                    objFirst = null;
                    v = null;
                } else {
                    objFirst = CollectionsKt___CollectionsKt.first(this.keySet);
                    v = this.map.get(objFirst);
                    if (v == null) {
                        throw new IllegalStateException("inconsistent state");
                    }
                    TypeIntrinsics.asMutableMap(this.map).remove(objFirst);
                    TypeIntrinsics.asMutableCollection(this.keySet).remove(objFirst);
                    int size = size();
                    Intrinsics.checkNotNull(objFirst);
                    Intrinsics.checkNotNull(v);
                    this.size = size - safeSizeOf(objFirst, v);
                    this.evictionCount++;
                }
                Unit unit = Unit.INSTANCE;
            }
            if (objFirst == null && v == null) {
                return;
            }
            Intrinsics.checkNotNull(objFirst);
            Intrinsics.checkNotNull(v);
            entryRemoved(true, objFirst, v, null);
        }
        throw new IllegalStateException("map/keySet size inconsistency");
    }

    public final V remove(K k) {
        V vRemove;
        k.getClass();
        synchronized (this.monitor) {
            vRemove = this.map.remove(k);
            this.keySet.remove(k);
            if (vRemove != null) {
                this.size = size() - safeSizeOf(k, vRemove);
            }
            Unit unit = Unit.INSTANCE;
        }
        if (vRemove != null) {
            entryRemoved(false, k, vRemove, null);
        }
        return vRemove;
    }

    private final int safeSizeOf(K k, V v) {
        int iSizeOf = sizeOf(k, v);
        if (iSizeOf >= 0) {
            return iSizeOf;
        }
        throw new IllegalStateException(("Negative size: " + k + '=' + v).toString());
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap;
        synchronized (this.monitor) {
            linkedHashMap = new LinkedHashMap();
            for (K k : this.keySet) {
                V v = this.map.get(k);
                Intrinsics.checkNotNull(v);
                linkedHashMap.put(k, v);
            }
        }
        return linkedHashMap;
    }

    public String toString() {
        String str;
        synchronized (this.monitor) {
            int i = this.hitCount;
            int i2 = this.missCount + i;
            str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
        }
        return str;
    }

    public final <R> R synchronizedValue$ui_text_release(@NotNull Function0<? extends R> function0) {
        R rInvoke;
        synchronized (this.monitor) {
            try {
                rInvoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } finally {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
            }
        }
        return rInvoke;
    }

    public final int size() {
        int i;
        synchronized (this.monitor) {
            i = this.size;
        }
        return i;
    }

    public final int maxSize() {
        int i;
        synchronized (this.monitor) {
            i = this.maxSize;
        }
        return i;
    }

    public final int hitCount() {
        int i;
        synchronized (this.monitor) {
            i = this.hitCount;
        }
        return i;
    }

    public final int missCount() {
        int i;
        synchronized (this.monitor) {
            i = this.missCount;
        }
        return i;
    }

    public final int createCount() {
        int i;
        synchronized (this.monitor) {
            i = this.createCount;
        }
        return i;
    }

    public final int putCount() {
        int i;
        synchronized (this.monitor) {
            i = this.putCount;
        }
        return i;
    }

    public final int evictionCount() {
        int i;
        synchronized (this.monitor) {
            i = this.evictionCount;
        }
        return i;
    }
}
