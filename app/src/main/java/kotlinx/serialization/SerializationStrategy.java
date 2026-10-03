package kotlinx.serialization;

import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface SerializationStrategy<T> {
    SerialDescriptor getDescriptor();

    void serialize(@NotNull Encoder encoder, T t);
}
