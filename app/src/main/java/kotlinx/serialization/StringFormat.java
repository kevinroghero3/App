package kotlinx.serialization;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface StringFormat extends SerialFormat {
    <T> T decodeFromString(@NotNull DeserializationStrategy<? extends T> deserializationStrategy, @NotNull String str);

    <T> String encodeToString(@NotNull SerializationStrategy<? super T> serializationStrategy, T t);
}
