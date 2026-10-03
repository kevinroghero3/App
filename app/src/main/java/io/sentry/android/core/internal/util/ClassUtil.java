package io.sentry.android.core.internal.util;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class ClassUtil {
    public static String getClassName(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        String canonicalName = obj.getClass().getCanonicalName();
        return canonicalName != null ? canonicalName : obj.getClass().getSimpleName();
    }
}
