package androidx.savedstate.compose.serialization.serializers;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class MutableStateSerializer<T> implements KSerializer<MutableState<T>> {
    private final SerialDescriptor descriptor;
    private final KSerializer<T> valueSerializer;

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    public MutableStateSerializer(@NotNull KSerializer<T> valueSerializer) {
        SerialDescriptor SerialDescriptor;
        Intrinsics.checkNotNullParameter(valueSerializer, "valueSerializer");
        this.valueSerializer = valueSerializer;
        SerialKind kind = valueSerializer.getDescriptor().getKind();
        if (kind instanceof PrimitiveKind) {
            SerialDescriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("androidx.compose.runtime.MutableState", (PrimitiveKind) kind);
        } else {
            SerialDescriptor = SerialDescriptorsKt.SerialDescriptor("androidx.compose.runtime.MutableState", valueSerializer.getDescriptor());
        }
        this.descriptor = SerialDescriptor;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(@NotNull Encoder encoder, @NotNull MutableState<T> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeSerializableValue(this.valueSerializer, value.getValue());
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public MutableState<T> deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(decoder.decodeSerializableValue(this.valueSerializer), null, 2, null);
    }
}
