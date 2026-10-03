package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class LinkedValue<V> {
    public static final int $stable = 8;
    private final Object next;
    private final Object previous;
    private final V value;

    public LinkedValue(V v, @Nullable Object obj, @Nullable Object obj2) {
        this.value = v;
        this.previous = obj;
        this.next = obj2;
    }

    public final Object getNext() {
        return this.next;
    }

    public final Object getPrevious() {
        return this.previous;
    }

    public final V getValue() {
        return this.value;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LinkedValue(V v) {
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        this(v, endOfChain, endOfChain);
    }

    public LinkedValue(V v, @Nullable Object obj) {
        this(v, obj, EndOfChain.INSTANCE);
    }

    public final LinkedValue<V> withValue(V v) {
        return new LinkedValue<>(v, this.previous, this.next);
    }

    public final LinkedValue<V> withPrevious(@Nullable Object obj) {
        return new LinkedValue<>(this.value, obj, this.next);
    }

    public final LinkedValue<V> withNext(@Nullable Object obj) {
        return new LinkedValue<>(this.value, this.previous, obj);
    }

    public final boolean getHasNext() {
        return this.next != EndOfChain.INSTANCE;
    }

    public final boolean getHasPrevious() {
        return this.previous != EndOfChain.INSTANCE;
    }
}
