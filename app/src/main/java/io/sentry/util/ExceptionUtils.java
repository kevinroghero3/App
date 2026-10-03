package io.sentry.util;

import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ExceptionUtils {
    public static Throwable findRootCause(@NotNull Throwable th) {
        Objects.requireNonNull(th, "throwable cannot be null");
        while (th.getCause() != null && th.getCause() != th) {
            th = th.getCause();
        }
        return th;
    }

    public static boolean isIgnored(@NotNull Set<Class<? extends Throwable>> set, @NotNull Throwable th) {
        return set.contains(th.getClass());
    }
}
