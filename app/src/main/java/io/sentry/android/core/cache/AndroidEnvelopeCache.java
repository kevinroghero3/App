package io.sentry.android.core.cache;

import com.google.maps.android.BuildConfig;
import io.sentry.Hint;
import io.sentry.SentryEnvelope;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.android.core.AnrV2Integration;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.internal.util.AndroidCurrentDateProvider;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.android.core.performance.TimeSpan;
import io.sentry.cache.EnvelopeCache;
import io.sentry.transport.ICurrentDateProvider;
import io.sentry.util.FileUtils;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import java.io.File;
import java.io.FileOutputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class AndroidEnvelopeCache extends EnvelopeCache {
    public static final String LAST_ANR_REPORT = "last_anr_report";
    private final ICurrentDateProvider currentDateProvider;

    public AndroidEnvelopeCache(@NotNull SentryAndroidOptions sentryAndroidOptions) {
        this(sentryAndroidOptions, AndroidCurrentDateProvider.getInstance());
    }

    AndroidEnvelopeCache(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull ICurrentDateProvider iCurrentDateProvider) {
        super(sentryAndroidOptions, (String) Objects.requireNonNull(sentryAndroidOptions.getCacheDirPath(), "cacheDirPath must not be null"), sentryAndroidOptions.getMaxCacheItems());
        this.currentDateProvider = iCurrentDateProvider;
    }

    @Override // io.sentry.cache.EnvelopeCache, io.sentry.cache.IEnvelopeCache
    public void store(@NotNull SentryEnvelope sentryEnvelope, @NotNull Hint hint) {
        storeInternalAndroid(sentryEnvelope, hint);
    }

    @Override // io.sentry.cache.EnvelopeCache, io.sentry.cache.IEnvelopeCache
    public boolean storeEnvelope(@NotNull SentryEnvelope sentryEnvelope, @NotNull Hint hint) {
        return storeInternalAndroid(sentryEnvelope, hint);
    }

    private boolean storeInternalAndroid(@NotNull SentryEnvelope sentryEnvelope, @NotNull Hint hint) {
        boolean zStoreEnvelope = super.storeEnvelope(sentryEnvelope, hint);
        final SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.options;
        TimeSpan sdkInitTimeSpan = AppStartMetrics.getInstance().getSdkInitTimeSpan();
        if (HintUtils.hasType(hint, UncaughtExceptionHandlerIntegration.UncaughtExceptionHint.class) && sdkInitTimeSpan.hasStarted()) {
            long currentTimeMillis = this.currentDateProvider.getCurrentTimeMillis() - sdkInitTimeSpan.getStartUptimeMs();
            if (currentTimeMillis <= sentryAndroidOptions.getStartupCrashDurationThresholdMillis()) {
                sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "Startup Crash detected %d milliseconds after SDK init. Writing a startup crash marker file to disk.", Long.valueOf(currentTimeMillis));
                writeStartupCrashMarkerFile();
            }
        }
        HintUtils.runIfHasType(hint, AnrV2Integration.AnrV2Hint.class, new HintUtils.SentryConsumer() { // from class: io.sentry.android.core.cache.AndroidEnvelopeCache$$ExternalSyntheticLambda0
            @Override // io.sentry.util.HintUtils.SentryConsumer
            public final void accept(Object obj) {
                this.f$0.lambda$storeInternalAndroid$0(sentryAndroidOptions, (AnrV2Integration.AnrV2Hint) obj);
            }
        });
        return zStoreEnvelope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$storeInternalAndroid$0(SentryAndroidOptions sentryAndroidOptions, AnrV2Integration.AnrV2Hint anrV2Hint) {
        Long lTimestamp = anrV2Hint.timestamp();
        sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "Writing last reported ANR marker with timestamp %d", lTimestamp);
        writeLastReportedAnrMarker(lTimestamp);
    }

    public File getDirectory() {
        return this.directory;
    }

    private void writeStartupCrashMarkerFile() {
        String outboxPath = this.options.getOutboxPath();
        if (outboxPath == null) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Outbox path is null, the startup crash marker file will not be written", new Object[0]);
            return;
        }
        try {
            new File(outboxPath, EnvelopeCache.STARTUP_CRASH_MARKER_FILE).createNewFile();
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error writing the startup crash marker file to the disk", th);
        }
    }

    public static boolean hasStartupCrashMarker(@NotNull SentryOptions sentryOptions) {
        String outboxPath = sentryOptions.getOutboxPath();
        if (outboxPath == null) {
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "Outbox path is null, the startup crash marker file does not exist", new Object[0]);
            return false;
        }
        File file = new File(outboxPath, EnvelopeCache.STARTUP_CRASH_MARKER_FILE);
        try {
            boolean zExists = file.exists();
            if (zExists && !file.delete()) {
                sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed to delete the startup crash marker file. %s.", file.getAbsolutePath());
            }
            return zExists;
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Error reading/deleting the startup crash marker file on the disk", th);
            return false;
        }
    }

    public static Long lastReportedAnr(@NotNull SentryOptions sentryOptions) {
        File file = new File((String) Objects.requireNonNull(sentryOptions.getCacheDirPath(), "Cache dir path should be set for getting ANRs reported"), LAST_ANR_REPORT);
        try {
            if (file.exists() && file.canRead()) {
                String text = FileUtils.readText(file);
                if (text.equals(BuildConfig.TRAVIS)) {
                    return null;
                }
                return Long.valueOf(Long.parseLong(text.trim()));
            }
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "Last ANR marker does not exist. %s.", file.getAbsolutePath());
            return null;
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Error reading last ANR marker", th);
        }
    }

    private void writeLastReportedAnrMarker(@Nullable Long l) {
        String cacheDirPath = this.options.getCacheDirPath();
        if (cacheDirPath == null) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Cache dir path is null, the ANR marker will not be written", new Object[0]);
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(cacheDirPath, LAST_ANR_REPORT));
            try {
                fileOutputStream.write(String.valueOf(l).getBytes(UTF_8));
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error writing the ANR marker to the disk", th3);
        }
    }
}
