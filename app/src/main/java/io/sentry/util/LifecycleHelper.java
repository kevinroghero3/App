package io.sentry.util;

import io.sentry.ISentryLifecycleToken;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class LifecycleHelper {
    public static void close(@Nullable Object obj) {
        if (obj == null || !(obj instanceof ISentryLifecycleToken)) {
            return;
        }
        ((ISentryLifecycleToken) obj).close();
    }
}
