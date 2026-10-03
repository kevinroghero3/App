package kotlinx.coroutines.internal;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CtorCache {
    public abstract Function1<Throwable, Throwable> get(@NotNull Class<? extends Throwable> cls);
}
