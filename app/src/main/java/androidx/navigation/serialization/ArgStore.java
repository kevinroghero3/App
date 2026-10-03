package androidx.navigation.serialization;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
abstract class ArgStore {
    public abstract boolean contains(@NotNull String str);

    public abstract Object get(@NotNull String str);
}
