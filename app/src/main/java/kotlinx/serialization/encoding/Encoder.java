package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface Encoder {
    CompositeEncoder beginCollection(@NotNull SerialDescriptor serialDescriptor, int i);

    CompositeEncoder beginStructure(@NotNull SerialDescriptor serialDescriptor);

    void encodeBoolean(boolean z);

    void encodeByte(byte b);

    void encodeChar(char c);

    void encodeDouble(double d);

    void encodeEnum(@NotNull SerialDescriptor serialDescriptor, int i);

    void encodeFloat(float f);

    Encoder encodeInline(@NotNull SerialDescriptor serialDescriptor);

    void encodeInt(int i);

    void encodeLong(long j);

    @ExperimentalSerializationApi
    void encodeNotNullMark();

    @ExperimentalSerializationApi
    void encodeNull();

    @ExperimentalSerializationApi
    <T> void encodeNullableSerializableValue(@NotNull SerializationStrategy<? super T> serializationStrategy, @Nullable T t);

    <T> void encodeSerializableValue(@NotNull SerializationStrategy<? super T> serializationStrategy, T t);

    void encodeShort(short s);

    void encodeString(@NotNull String str);

    SerializersModule getSerializersModule();

    /* JADX INFO: loaded from: classes6.dex */
    public static final class DefaultImpls {
        @ExperimentalSerializationApi
        public static void encodeNotNullMark(@NotNull Encoder encoder) {
        }

        public static CompositeEncoder beginCollection(@NotNull Encoder encoder, @NotNull SerialDescriptor descriptor, int i) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return encoder.beginStructure(descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T> void encodeSerializableValue(@NotNull Encoder encoder, @NotNull SerializationStrategy<? super T> serializer, T t) {
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            serializer.serialize(encoder, t);
        }

        @ExperimentalSerializationApi
        public static <T> void encodeNullableSerializableValue(@NotNull Encoder encoder, @NotNull SerializationStrategy<? super T> serializer, @Nullable T t) {
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            if (serializer.getDescriptor().isNullable()) {
                encoder.encodeSerializableValue(serializer, t);
            } else if (t == null) {
                encoder.encodeNull();
            } else {
                encoder.encodeNotNullMark();
                encoder.encodeSerializableValue(serializer, t);
            }
        }
    }
}
