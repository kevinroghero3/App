package io.sentry.instrumentation.file;

import io.sentry.ISpan;
import io.sentry.SentryOptions;
import java.io.File;
import java.io.FileInputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class FileInputStreamInitData {
    final FileInputStream delegate;
    final File file;
    final SentryOptions options;
    final ISpan span;

    FileInputStreamInitData(@Nullable File file, @Nullable ISpan iSpan, @NotNull FileInputStream fileInputStream, @NotNull SentryOptions sentryOptions) {
        this.file = file;
        this.span = iSpan;
        this.delegate = fileInputStream;
        this.options = sentryOptions;
    }
}
