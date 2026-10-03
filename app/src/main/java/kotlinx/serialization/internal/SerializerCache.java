package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface SerializerCache<T> {

    public static final class DefaultImpls {
        public static <T> boolean isStored(@NotNull SerializerCache<T> serializerCache, @NotNull KClass<?> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return false;
        }
    }

    KSerializer<T> get(@NotNull KClass<Object> kClass);

    boolean isStored(@NotNull KClass<?> kClass);
}
