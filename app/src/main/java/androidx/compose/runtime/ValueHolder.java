package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface ValueHolder<T> {
    T readValue(@NotNull PersistentCompositionLocalMap persistentCompositionLocalMap);

    ProvidedValue<T> toProvided(@NotNull CompositionLocal<T> compositionLocal);
}
