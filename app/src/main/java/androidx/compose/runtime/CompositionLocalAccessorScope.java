package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface CompositionLocalAccessorScope {
    <T> T getCurrentValue(@NotNull CompositionLocal<T> compositionLocal);
}
