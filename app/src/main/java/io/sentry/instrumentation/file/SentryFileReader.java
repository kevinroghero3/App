package io.sentry.instrumentation.file;

import io.sentry.IScopes;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class SentryFileReader extends InputStreamReader {
    public SentryFileReader(@NotNull String str) throws FileNotFoundException {
        super(new SentryFileInputStream(str));
    }

    public SentryFileReader(@NotNull File file) throws FileNotFoundException {
        super(new SentryFileInputStream(file));
    }

    public SentryFileReader(@NotNull FileDescriptor fileDescriptor) {
        super(new SentryFileInputStream(fileDescriptor));
    }

    SentryFileReader(@NotNull File file, @NotNull IScopes iScopes) throws FileNotFoundException {
        super(new SentryFileInputStream(file, iScopes));
    }
}
