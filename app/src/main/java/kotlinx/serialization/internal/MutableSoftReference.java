package kotlinx.serialization.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
final class MutableSoftReference<T> {
    public volatile SoftReference<T> reference = new SoftReference<>(null);

    public final T getOrSetWithLock(@NotNull Function0<? extends T> factory) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(factory, "factory");
            T t = this.reference.get();
            if (t != null) {
                return t;
            }
            T tInvoke = factory.invoke();
            this.reference = new SoftReference<>(tInvoke);
            return tInvoke;
        }
    }
}
