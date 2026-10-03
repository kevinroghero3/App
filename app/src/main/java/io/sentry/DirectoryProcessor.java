package io.sentry;

import io.sentry.hints.Cached;
import io.sentry.hints.Enqueable;
import io.sentry.hints.Flushable;
import io.sentry.hints.Retryable;
import io.sentry.hints.SubmissionResult;
import io.sentry.transport.RateLimiter;
import io.sentry.util.HintUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
abstract class DirectoryProcessor {
    private static final long ENVELOPE_PROCESSING_DELAY = 100;
    private final long flushTimeoutMillis;
    private final ILogger logger;
    private final Queue<String> processedEnvelopes;
    private final IScopes scopes;

    protected abstract boolean isRelevantFileName(String str);

    protected abstract void processFile(@NotNull File file, @NotNull Hint hint);

    DirectoryProcessor(@NotNull IScopes iScopes, @NotNull ILogger iLogger, long j, int i) {
        this.scopes = iScopes;
        this.logger = iLogger;
        this.flushTimeoutMillis = j;
        this.processedEnvelopes = SynchronizedQueue.synchronizedQueue(new CircularFifoQueue(i));
    }

    public void processDirectory(@NotNull File file) {
        try {
            ILogger iLogger = this.logger;
            SentryLevel sentryLevel = SentryLevel.DEBUG;
            iLogger.log(sentryLevel, "Processing dir. %s", file.getAbsolutePath());
            if (!file.exists()) {
                this.logger.log(SentryLevel.WARNING, "Directory '%s' doesn't exist. No cached events to send.", file.getAbsolutePath());
                return;
            }
            if (!file.isDirectory()) {
                this.logger.log(SentryLevel.ERROR, "Cache dir %s is not a directory.", file.getAbsolutePath());
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                this.logger.log(SentryLevel.ERROR, "Cache dir %s is null.", file.getAbsolutePath());
                return;
            }
            File[] fileArrListFiles2 = file.listFiles(new FilenameFilter() { // from class: io.sentry.DirectoryProcessor$$ExternalSyntheticLambda0
                @Override // java.io.FilenameFilter
                public final boolean accept(File file2, String str) {
                    return this.f$0.lambda$processDirectory$0(file2, str);
                }
            });
            this.logger.log(sentryLevel, "Processing %d items from cache dir %s", Integer.valueOf(fileArrListFiles2 != null ? fileArrListFiles2.length : 0), file.getAbsolutePath());
            for (File file2 : fileArrListFiles) {
                if (!file2.isFile()) {
                    this.logger.log(SentryLevel.DEBUG, "File %s is not a File.", file2.getAbsolutePath());
                } else {
                    String absolutePath = file2.getAbsolutePath();
                    if (this.processedEnvelopes.contains(absolutePath)) {
                        this.logger.log(SentryLevel.DEBUG, "File '%s' has already been processed so it will not be processed again.", absolutePath);
                    } else {
                        RateLimiter rateLimiter = this.scopes.getRateLimiter();
                        if (rateLimiter != null && rateLimiter.isActiveForCategory(DataCategory.All)) {
                            this.logger.log(SentryLevel.INFO, "DirectoryProcessor, rate limiting active.", new Object[0]);
                            return;
                        } else {
                            this.logger.log(SentryLevel.DEBUG, "Processing file: %s", absolutePath);
                            processFile(file2, HintUtils.createWithTypeCheckHint(new SendCachedEnvelopeHint(this.flushTimeoutMillis, this.logger, absolutePath, this.processedEnvelopes)));
                            Thread.sleep(ENVELOPE_PROCESSING_DELAY);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            this.logger.log(SentryLevel.ERROR, th, "Failed processing '%s'", file.getAbsolutePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$processDirectory$0(File file, String str) {
        return isRelevantFileName(str);
    }

    static final class SendCachedEnvelopeHint implements Cached, Retryable, SubmissionResult, Flushable, Enqueable {
        private final String filePath;
        private final long flushTimeoutMillis;
        private final ILogger logger;
        private final Queue<String> processedEnvelopes;
        boolean retry = false;
        boolean succeeded = false;
        private final CountDownLatch latch = new CountDownLatch(1);

        public SendCachedEnvelopeHint(long j, @NotNull ILogger iLogger, @NotNull String str, @NotNull Queue<String> queue) {
            this.flushTimeoutMillis = j;
            this.filePath = str;
            this.processedEnvelopes = queue;
            this.logger = iLogger;
        }

        @Override // io.sentry.hints.Retryable
        public boolean isRetry() {
            return this.retry;
        }

        @Override // io.sentry.hints.Retryable
        public void setRetry(boolean z) {
            this.retry = z;
        }

        @Override // io.sentry.hints.Flushable
        public boolean waitFlush() {
            try {
                return this.latch.await(this.flushTimeoutMillis, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                this.logger.log(SentryLevel.ERROR, "Exception while awaiting on lock.", e);
                return false;
            }
        }

        @Override // io.sentry.hints.SubmissionResult
        public void setResult(boolean z) {
            this.succeeded = z;
            this.latch.countDown();
        }

        @Override // io.sentry.hints.SubmissionResult
        public boolean isSuccess() {
            return this.succeeded;
        }

        @Override // io.sentry.hints.Enqueable
        public void markEnqueued() {
            this.processedEnvelopes.add(this.filePath);
        }
    }
}
