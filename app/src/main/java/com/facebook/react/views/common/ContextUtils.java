package com.facebook.react.views.common;

import android.content.Context;
import android.content.ContextWrapper;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ContextUtils {
    public static final ContextUtils INSTANCE = new ContextUtils();

    private ContextUtils() {
    }

    @JvmStatic
    public static final <T> T findContextOfType(@Nullable Context context, @NotNull Class<? extends T> clazz) {
        Context baseContext;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Object obj = context;
        while (!clazz.isInstance(obj)) {
            if (!(obj instanceof ContextWrapper) || obj == (baseContext = obj.getBaseContext())) {
                return null;
            }
            obj = (T) baseContext;
        }
        return (T) obj;
    }
}
