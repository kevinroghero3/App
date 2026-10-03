package kotlinx.serialization;

import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface DeserializationStrategy<T> {
    T deserialize(@NotNull Decoder decoder);

    SerialDescriptor getDescriptor();
}
