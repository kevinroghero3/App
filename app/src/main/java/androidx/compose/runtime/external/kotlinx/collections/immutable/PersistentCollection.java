package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMutableCollection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface PersistentCollection<E> extends ImmutableCollection<E> {

    public interface Builder<E> extends Collection<E>, KMutableCollection {
        PersistentCollection<E> build();
    }

    @Override // java.util.Collection
    PersistentCollection<E> add(E e);

    @Override // java.util.Collection
    PersistentCollection<E> addAll(@NotNull Collection<? extends E> collection);

    Builder<E> builder();

    @Override // java.util.Collection
    PersistentCollection<E> clear();

    @Override // java.util.Collection
    PersistentCollection<E> remove(E e);

    @Override // java.util.Collection
    PersistentCollection<E> removeAll(@NotNull Collection<? extends E> collection);

    PersistentCollection<E> removeAll(@NotNull Function1<? super E, Boolean> function1);

    @Override // java.util.Collection
    PersistentCollection<E> retainAll(@NotNull Collection<? extends E> collection);
}
