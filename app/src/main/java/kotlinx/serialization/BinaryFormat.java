package kotlinx.serialization;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface BinaryFormat extends SerialFormat {
    <T> T decodeFromByteArray(@NotNull DeserializationStrategy<? extends T> deserializationStrategy, @NotNull byte[] bArr);

    <T> byte[] encodeToByteArray(@NotNull SerializationStrategy<? super T> serializationStrategy, T t);
}
