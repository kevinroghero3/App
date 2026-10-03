package io.sentry;

import java.lang.reflect.InvocationTargetException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class OptionsContainer<T> {
    private final Class<T> clazz;

    public static <T> OptionsContainer<T> create(@NotNull Class<T> cls) {
        return new OptionsContainer<>(cls);
    }

    private OptionsContainer(@NotNull Class<T> cls) {
        this.clazz = cls;
    }

    public T createInstance() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        return this.clazz.getDeclaredConstructor(null).newInstance(null);
    }
}
