package androidx.datastore.core;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface Serializer<T> {
    T getDefaultValue();

    Object readFrom(@NotNull InputStream inputStream, @NotNull Continuation<? super T> continuation);

    Object writeTo(T t, @NotNull OutputStream outputStream, @NotNull Continuation<? super Unit> continuation);
}
