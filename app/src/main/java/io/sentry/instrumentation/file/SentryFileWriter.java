package io.sentry.instrumentation.file;

import io.sentry.IScopes;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class SentryFileWriter extends OutputStreamWriter {
    public SentryFileWriter(@NotNull String str) throws FileNotFoundException {
        super(new SentryFileOutputStream(str));
    }

    public SentryFileWriter(@NotNull String str, boolean z) throws FileNotFoundException {
        super(new SentryFileOutputStream(str, z));
    }

    public SentryFileWriter(@NotNull File file) throws FileNotFoundException {
        super(new SentryFileOutputStream(file));
    }

    public SentryFileWriter(@NotNull File file, boolean z) throws FileNotFoundException {
        super(new SentryFileOutputStream(file, z));
    }

    public SentryFileWriter(@NotNull FileDescriptor fileDescriptor) {
        super(new SentryFileOutputStream(fileDescriptor));
    }

    SentryFileWriter(@NotNull File file, boolean z, @NotNull IScopes iScopes) throws FileNotFoundException {
        super(new SentryFileOutputStream(file, z, iScopes));
    }
}
