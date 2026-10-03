package io.sentry;

import io.sentry.util.LoadClass;
import io.sentry.util.Platform;
import java.lang.reflect.InvocationTargetException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ScopesStorageFactory {
    private static final String OTEL_SCOPES_STORAGE = "io.sentry.opentelemetry.OtelContextScopesStorage";

    public static IScopesStorage create(@NotNull LoadClass loadClass, @NotNull ILogger iLogger) {
        IScopesStorage iScopesStorageCreateInternal = createInternal(loadClass, iLogger);
        iScopesStorageCreateInternal.init();
        return iScopesStorageCreateInternal;
    }

    private static IScopesStorage createInternal(@NotNull LoadClass loadClass, @NotNull ILogger iLogger) {
        Class<?> clsLoadClass;
        if (Platform.isJvm() && loadClass.isClassAvailable(OTEL_SCOPES_STORAGE, iLogger) && (clsLoadClass = loadClass.loadClass(OTEL_SCOPES_STORAGE, iLogger)) != null) {
            try {
                Object objNewInstance = clsLoadClass.getDeclaredConstructor(null).newInstance(null);
                if (objNewInstance != null && (objNewInstance instanceof IScopesStorage)) {
                    return (IScopesStorage) objNewInstance;
                }
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return new DefaultScopesStorage();
    }
}
