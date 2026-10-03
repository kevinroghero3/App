package kotlinx.serialization;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class SerializationException extends IllegalArgumentException {
    public SerializationException() {
    }

    public SerializationException(@Nullable String str) {
        super(str);
    }

    public SerializationException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public SerializationException(@Nullable Throwable th) {
        super(th);
    }
}
