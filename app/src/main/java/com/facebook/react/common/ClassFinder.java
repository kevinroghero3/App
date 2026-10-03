package com.facebook.react.common;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class ClassFinder {
    public static final ClassFinder INSTANCE = new ClassFinder();

    @JvmStatic
    public static final boolean canLoadClassesFromAnnotationProcessors() {
        return false;
    }

    private ClassFinder() {
    }

    @JvmStatic
    public static final Class<?> findClass(@NotNull String className) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(className, "className");
        if (canLoadClassesFromAnnotationProcessors()) {
            return Class.forName(className);
        }
        return null;
    }
}
