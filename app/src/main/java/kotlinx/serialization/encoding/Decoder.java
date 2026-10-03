package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface Decoder {
    CompositeDecoder beginStructure(@NotNull SerialDescriptor serialDescriptor);

    boolean decodeBoolean();

    byte decodeByte();

    char decodeChar();

    double decodeDouble();

    int decodeEnum(@NotNull SerialDescriptor serialDescriptor);

    float decodeFloat();

    Decoder decodeInline(@NotNull SerialDescriptor serialDescriptor);

    int decodeInt();

    long decodeLong();

    @ExperimentalSerializationApi
    boolean decodeNotNullMark();

    @ExperimentalSerializationApi
    Void decodeNull();

    @ExperimentalSerializationApi
    <T> T decodeNullableSerializableValue(@NotNull DeserializationStrategy<? extends T> deserializationStrategy);

    <T> T decodeSerializableValue(@NotNull DeserializationStrategy<? extends T> deserializationStrategy);

    short decodeShort();

    String decodeString();

    SerializersModule getSerializersModule();

    /* JADX INFO: loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static <T> T decodeSerializableValue(@NotNull Decoder decoder, @NotNull DeserializationStrategy<? extends T> deserializer) {
            Intrinsics.checkNotNullParameter(deserializer, "deserializer");
            return deserializer.deserialize(decoder);
        }

        @ExperimentalSerializationApi
        public static <T> T decodeNullableSerializableValue(@NotNull Decoder decoder, @NotNull DeserializationStrategy<? extends T> deserializer) {
            Intrinsics.checkNotNullParameter(deserializer, "deserializer");
            return (deserializer.getDescriptor().isNullable() || decoder.decodeNotNullMark()) ? (T) decoder.decodeSerializableValue(deserializer) : (T) decoder.decodeNull();
        }
    }
}
