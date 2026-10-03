package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface CompositeDecoder {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DECODE_DONE = -1;
    public static final int UNKNOWN_NAME = -3;

    boolean decodeBooleanElement(@NotNull SerialDescriptor serialDescriptor, int i);

    byte decodeByteElement(@NotNull SerialDescriptor serialDescriptor, int i);

    char decodeCharElement(@NotNull SerialDescriptor serialDescriptor, int i);

    int decodeCollectionSize(@NotNull SerialDescriptor serialDescriptor);

    double decodeDoubleElement(@NotNull SerialDescriptor serialDescriptor, int i);

    int decodeElementIndex(@NotNull SerialDescriptor serialDescriptor);

    float decodeFloatElement(@NotNull SerialDescriptor serialDescriptor, int i);

    Decoder decodeInlineElement(@NotNull SerialDescriptor serialDescriptor, int i);

    int decodeIntElement(@NotNull SerialDescriptor serialDescriptor, int i);

    long decodeLongElement(@NotNull SerialDescriptor serialDescriptor, int i);

    @ExperimentalSerializationApi
    <T> T decodeNullableSerializableElement(@NotNull SerialDescriptor serialDescriptor, int i, @NotNull DeserializationStrategy<? extends T> deserializationStrategy, @Nullable T t);

    @ExperimentalSerializationApi
    boolean decodeSequentially();

    <T> T decodeSerializableElement(@NotNull SerialDescriptor serialDescriptor, int i, @NotNull DeserializationStrategy<? extends T> deserializationStrategy, @Nullable T t);

    short decodeShortElement(@NotNull SerialDescriptor serialDescriptor, int i);

    String decodeStringElement(@NotNull SerialDescriptor serialDescriptor, int i);

    void endStructure(@NotNull SerialDescriptor serialDescriptor);

    SerializersModule getSerializersModule();

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DECODE_DONE = -1;
        public static final int UNKNOWN_NAME = -3;

        private Companion() {
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static int decodeCollectionSize(@NotNull CompositeDecoder compositeDecoder, @NotNull SerialDescriptor descriptor) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return -1;
        }

        @ExperimentalSerializationApi
        public static boolean decodeSequentially(@NotNull CompositeDecoder compositeDecoder) {
            return false;
        }

        public static /* synthetic */ Object decodeSerializableElement$default(CompositeDecoder compositeDecoder, SerialDescriptor serialDescriptor, int i, DeserializationStrategy deserializationStrategy, Object obj, int i2, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
            }
            if ((i2 & 8) != 0) {
                obj = null;
            }
            return compositeDecoder.decodeSerializableElement(serialDescriptor, i, deserializationStrategy, obj);
        }

        public static /* synthetic */ Object decodeNullableSerializableElement$default(CompositeDecoder compositeDecoder, SerialDescriptor serialDescriptor, int i, DeserializationStrategy deserializationStrategy, Object obj, int i2, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeNullableSerializableElement");
            }
            if ((i2 & 8) != 0) {
                obj = null;
            }
            return compositeDecoder.decodeNullableSerializableElement(serialDescriptor, i, deserializationStrategy, obj);
        }
    }
}
