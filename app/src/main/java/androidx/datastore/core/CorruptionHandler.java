package androidx.datastore.core;

import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface CorruptionHandler<T> {
    Object handleCorruption(@NotNull CorruptionException corruptionException, @NotNull Continuation<? super T> continuation);
}
