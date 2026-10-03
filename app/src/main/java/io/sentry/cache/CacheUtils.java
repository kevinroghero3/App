package io.sentry.cache;

import io.sentry.JsonDeserializer;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
final class CacheUtils {
    private static final Charset UTF_8 = Charset.forName(CharEncoding.UTF_8);

    CacheUtils() {
    }

    static <T> void store(@NotNull SentryOptions sentryOptions, @NotNull T t, @NotNull String str, @NotNull String str2) {
        File fileEnsureCacheDir = ensureCacheDir(sentryOptions, str);
        if (fileEnsureCacheDir == null) {
            sentryOptions.getLogger().log(SentryLevel.INFO, "Cache dir is not set, cannot store in scope cache", new Object[0]);
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileEnsureCacheDir, str2));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, UTF_8));
                try {
                    sentryOptions.getSerializer().serialize(t, bufferedWriter);
                    bufferedWriter.close();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedWriter.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Throwable th5) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, th5, "Error persisting entity: %s", str2);
        }
    }

    static void delete(@NotNull SentryOptions sentryOptions, @NotNull String str, @NotNull String str2) {
        File fileEnsureCacheDir = ensureCacheDir(sentryOptions, str);
        if (fileEnsureCacheDir == null) {
            sentryOptions.getLogger().log(SentryLevel.INFO, "Cache dir is not set, cannot delete from scope cache", new Object[0]);
            return;
        }
        File file = new File(fileEnsureCacheDir, str2);
        sentryOptions.getLogger().log(SentryLevel.DEBUG, "Deleting %s from scope cache", str2);
        if (file.delete()) {
            return;
        }
        sentryOptions.getLogger().log(SentryLevel.INFO, "Failed to delete: %s", file.getAbsolutePath());
    }

    static <T, R> T read(@NotNull SentryOptions sentryOptions, @NotNull String str, @NotNull String str2, @NotNull Class<T> cls, @Nullable JsonDeserializer<R> jsonDeserializer) {
        File fileEnsureCacheDir = ensureCacheDir(sentryOptions, str);
        if (fileEnsureCacheDir == null) {
            sentryOptions.getLogger().log(SentryLevel.INFO, "Cache dir is not set, cannot read from scope cache", new Object[0]);
            return null;
        }
        File file = new File(fileEnsureCacheDir, str2);
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), UTF_8));
                try {
                    if (jsonDeserializer == null) {
                        T t = (T) sentryOptions.getSerializer().deserialize(bufferedReader, cls);
                        bufferedReader.close();
                        return t;
                    }
                    T t2 = (T) sentryOptions.getSerializer().deserializeCollection(bufferedReader, cls, jsonDeserializer);
                    bufferedReader.close();
                    return t2;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                sentryOptions.getLogger().log(SentryLevel.ERROR, th3, "Error reading entity from scope cache: %s", str2);
            }
        } else {
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "No entry stored for %s", str2);
        }
        return null;
    }

    static File ensureCacheDir(@NotNull SentryOptions sentryOptions, @NotNull String str) {
        String cacheDirPath = sentryOptions.getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        File file = new File(cacheDirPath, str);
        file.mkdirs();
        return file;
    }
}
