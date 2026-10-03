package io.sentry.instrumentation.file;

import io.sentry.IScopes;
import io.sentry.ISpan;
import io.sentry.SentryIntegrationPackageStorage;
import io.sentry.SentryOptions;
import io.sentry.SentryStackTraceFactory;
import io.sentry.SpanDataConvention;
import io.sentry.SpanStatus;
import io.sentry.util.Platform;
import io.sentry.util.StringUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class FileIOSpanManager {
    private long byteCount;
    private final ISpan currentSpan;
    private final File file;
    private final SentryOptions options;
    private SpanStatus spanStatus = SpanStatus.OK;
    private final SentryStackTraceFactory stackTraceFactory;

    @FunctionalInterface
    interface FileIOCallable<T> {
        T call() throws IOException;
    }

    static ISpan startSpan(@NotNull IScopes iScopes, @NotNull String str) {
        ISpan transaction = Platform.isAndroid() ? iScopes.getTransaction() : iScopes.getSpan();
        if (transaction != null) {
            return transaction.startChild(str);
        }
        return null;
    }

    FileIOSpanManager(@Nullable ISpan iSpan, @Nullable File file, @NotNull SentryOptions sentryOptions) {
        this.currentSpan = iSpan;
        this.file = file;
        this.options = sentryOptions;
        this.stackTraceFactory = new SentryStackTraceFactory(sentryOptions);
        SentryIntegrationPackageStorage.getInstance().addIntegration("FileIO");
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T> T performIO(@NotNull FileIOCallable<T> fileIOCallable) throws IOException {
        try {
            T tCall = fileIOCallable.call();
            if (tCall instanceof Integer) {
                int iIntValue = ((Integer) tCall).intValue();
                if (iIntValue != -1) {
                    this.byteCount += (long) iIntValue;
                }
            } else if (tCall instanceof Long) {
                long jLongValue = ((Long) tCall).longValue();
                if (jLongValue != -1) {
                    this.byteCount += jLongValue;
                }
            }
            return tCall;
        } catch (IOException e) {
            this.spanStatus = SpanStatus.INTERNAL_ERROR;
            ISpan iSpan = this.currentSpan;
            if (iSpan != null) {
                iSpan.setThrowable(e);
            }
            throw e;
        }
    }

    void finish(@NotNull Closeable closeable) throws IOException {
        try {
            try {
                closeable.close();
                finishSpan();
            } catch (IOException e) {
                this.spanStatus = SpanStatus.INTERNAL_ERROR;
                if (this.currentSpan != null) {
                    this.currentSpan.setThrowable(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            finishSpan();
            throw th;
        }
    }

    private void finishSpan() {
        if (this.currentSpan != null) {
            String strByteCountToString = StringUtils.byteCountToString(this.byteCount);
            File file = this.file;
            if (file != null) {
                this.currentSpan.setDescription(getDescription(file));
                if (this.options.isSendDefaultPii()) {
                    this.currentSpan.setData("file.path", this.file.getAbsolutePath());
                }
            } else {
                this.currentSpan.setDescription(strByteCountToString);
            }
            this.currentSpan.setData("file.size", Long.valueOf(this.byteCount));
            boolean zIsMainThread = this.options.getThreadChecker().isMainThread();
            this.currentSpan.setData(SpanDataConvention.BLOCKED_MAIN_THREAD_KEY, Boolean.valueOf(zIsMainThread));
            if (zIsMainThread) {
                this.currentSpan.setData(SpanDataConvention.CALL_STACK_KEY, this.stackTraceFactory.getInAppCallStack());
            }
            this.currentSpan.finish(this.spanStatus);
        }
    }

    private String getDescription(@NotNull File file) {
        String strByteCountToString = StringUtils.byteCountToString(this.byteCount);
        if (this.options.isSendDefaultPii()) {
            return file.getName() + " (" + strByteCountToString + ")";
        }
        int iLastIndexOf = file.getName().lastIndexOf(46);
        if (iLastIndexOf > 0 && iLastIndexOf < file.getName().length() - 1) {
            return "***" + file.getName().substring(iLastIndexOf) + " (" + strByteCountToString + ")";
        }
        return "*** (" + strByteCountToString + ")";
    }
}
