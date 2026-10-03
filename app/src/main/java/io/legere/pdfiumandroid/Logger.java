package io.legere.pdfiumandroid;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class Logger implements LoggerInterface {
    public static final Logger INSTANCE = new Logger();
    private static LoggerInterface logger;

    private Logger() {
    }

    @Override // io.legere.pdfiumandroid.LoggerInterface
    public void d(@NotNull String tag, @Nullable String str) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerInterface loggerInterface = logger;
        if (loggerInterface != null) {
            loggerInterface.d(tag, str);
        }
    }

    @Override // io.legere.pdfiumandroid.LoggerInterface
    public void e(@NotNull String tag, @Nullable Throwable th, @Nullable String str) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        LoggerInterface loggerInterface = logger;
        if (loggerInterface != null) {
            loggerInterface.e(tag, th, str);
        }
    }

    public final void setLogger(@NotNull LoggerInterface logger2) {
        Intrinsics.checkNotNullParameter(logger2, "logger");
        logger = logger2;
    }
}
