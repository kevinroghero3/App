package kotlinx.serialization;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class UnknownFieldException extends SerializationException {
    public UnknownFieldException(@Nullable String str) {
        super(str);
    }

    public UnknownFieldException(int i) {
        this("An unknown field for index " + i);
    }
}
