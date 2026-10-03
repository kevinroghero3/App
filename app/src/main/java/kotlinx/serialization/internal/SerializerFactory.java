package kotlinx.serialization.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(level = DeprecationLevel.HIDDEN, message = "Inserted into generated code and should not be used directly")
public interface SerializerFactory {
    KSerializer<?> serializer(@NotNull KSerializer<?>... kSerializerArr);
}
