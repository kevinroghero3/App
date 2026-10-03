package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface CompositeEncoder {

    /* JADX INFO: loaded from: classes6.dex */
    public static final class DefaultImpls {
        @ExperimentalSerializationApi
        public static boolean shouldEncodeElementDefault(@NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor descriptor, int i) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return true;
        }
    }

    void encodeBooleanElement(@NotNull SerialDescriptor serialDescriptor, int i, boolean z);

    void encodeByteElement(@NotNull SerialDescriptor serialDescriptor, int i, byte b);

    void encodeCharElement(@NotNull SerialDescriptor serialDescriptor, int i, char c);

    void encodeDoubleElement(@NotNull SerialDescriptor serialDescriptor, int i, double d);

    void encodeFloatElement(@NotNull SerialDescriptor serialDescriptor, int i, float f);

    Encoder encodeInlineElement(@NotNull SerialDescriptor serialDescriptor, int i);

    void encodeIntElement(@NotNull SerialDescriptor serialDescriptor, int i, int i2);

    void encodeLongElement(@NotNull SerialDescriptor serialDescriptor, int i, long j);

    @ExperimentalSerializationApi
    <T> void encodeNullableSerializableElement(@NotNull SerialDescriptor serialDescriptor, int i, @NotNull SerializationStrategy<? super T> serializationStrategy, @Nullable T t);

    <T> void encodeSerializableElement(@NotNull SerialDescriptor serialDescriptor, int i, @NotNull SerializationStrategy<? super T> serializationStrategy, T t);

    void encodeShortElement(@NotNull SerialDescriptor serialDescriptor, int i, short s);

    void encodeStringElement(@NotNull SerialDescriptor serialDescriptor, int i, @NotNull String str);

    void endStructure(@NotNull SerialDescriptor serialDescriptor);

    SerializersModule getSerializersModule();

    @ExperimentalSerializationApi
    boolean shouldEncodeElementDefault(@NotNull SerialDescriptor serialDescriptor, int i);
}
