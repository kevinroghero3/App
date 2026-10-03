package kotlinx.serialization.internal;

import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
final class CacheEntry<T> {
    public final KSerializer<T> serializer;

    public CacheEntry(@Nullable KSerializer<T> kSerializer) {
        this.serializer = kSerializer;
    }
}
