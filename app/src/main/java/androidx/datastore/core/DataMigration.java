package androidx.datastore.core;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface DataMigration<T> {
    Object cleanUp(@NotNull Continuation<? super Unit> continuation);

    Object migrate(T t, @NotNull Continuation<? super T> continuation);

    Object shouldMigrate(T t, @NotNull Continuation<? super Boolean> continuation);
}
