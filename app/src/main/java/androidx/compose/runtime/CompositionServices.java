package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface CompositionServices {
    <T> T getCompositionService(@NotNull CompositionServiceKey<T> compositionServiceKey);
}
