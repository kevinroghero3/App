package io.sentry.android.core;

import android.app.Application;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.IContinuousProfiler;
import io.sentry.ILogger;
import io.sentry.ISentryLifecycleToken;
import io.sentry.ITransactionProfiler;
import io.sentry.JsonSerializer;
import io.sentry.Sentry;
import io.sentry.SentryAppStartProfilingOptions;
import io.sentry.SentryExecutorService;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.TracesSampler;
import io.sentry.TracesSamplingDecision;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.util.AutoClosableReentrantLock;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SentryPerformanceProvider extends EmptySecureContentProvider {
    private static final long sdkInitMillis = SystemClock.uptimeMillis();

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private Application f126app;
    private final BuildInfoProvider buildInfoProvider;
    private final AutoClosableReentrantLock lock = new AutoClosableReentrantLock();
    private final ILogger logger;

    @Override // android.content.ContentProvider
    public String getType(@NotNull Uri uri) {
        return null;
    }

    SentryPerformanceProvider(@NotNull ILogger iLogger, @NotNull BuildInfoProvider buildInfoProvider) {
        this.logger = iLogger;
        this.buildInfoProvider = buildInfoProvider;
    }

    public SentryPerformanceProvider() {
        AndroidLogger androidLogger = new AndroidLogger();
        this.logger = androidLogger;
        this.buildInfoProvider = new BuildInfoProvider(androidLogger);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        AppStartMetrics.onContentProviderCreate(this);
        AppStartMetrics appStartMetrics = AppStartMetrics.getInstance();
        onAppLaunched(getContext(), appStartMetrics);
        launchAppStartProfiler(appStartMetrics);
        AppStartMetrics.onContentProviderPostCreate(this);
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (SentryPerformanceProvider.class.getName().equals(providerInfo.authority)) {
            throw new IllegalStateException("An applicationId is required to fulfill the manifest placeholder.");
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public void shutdown() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = AppStartMetrics.staticLock.acquire();
        try {
            ITransactionProfiler appStartProfiler = AppStartMetrics.getInstance().getAppStartProfiler();
            if (appStartProfiler != null) {
                appStartProfiler.close();
            }
            IContinuousProfiler appStartContinuousProfiler = AppStartMetrics.getInstance().getAppStartContinuousProfiler();
            if (appStartContinuousProfiler != null) {
                appStartContinuousProfiler.close(true);
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void launchAppStartProfiler(@NotNull AppStartMetrics appStartMetrics) {
        Context context = getContext();
        if (context == null) {
            this.logger.log(SentryLevel.FATAL, "App. Context from ContentProvider is null", new Object[0]);
            return;
        }
        File file = new File(AndroidOptionsInitializer.getCacheDir(context), Sentry.APP_START_PROFILING_CONFIG_FILE_NAME);
        if (file.exists() && file.canRead()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    SentryAppStartProfilingOptions sentryAppStartProfilingOptions = (SentryAppStartProfilingOptions) new JsonSerializer(SentryOptions.empty()).deserialize(bufferedReader, SentryAppStartProfilingOptions.class);
                    if (sentryAppStartProfilingOptions == null) {
                        this.logger.log(SentryLevel.WARNING, "Unable to deserialize the SentryAppStartProfilingOptions. App start profiling will not start.", new Object[0]);
                        bufferedReader.close();
                        return;
                    }
                    if (sentryAppStartProfilingOptions.isContinuousProfilingEnabled() && sentryAppStartProfilingOptions.isStartProfilerOnAppStart()) {
                        createAndStartContinuousProfiler(context, sentryAppStartProfilingOptions, appStartMetrics);
                        bufferedReader.close();
                    } else if (!sentryAppStartProfilingOptions.isProfilingEnabled()) {
                        this.logger.log(SentryLevel.INFO, "Profiling is not enabled. App start profiling will not start.", new Object[0]);
                        bufferedReader.close();
                    } else {
                        if (sentryAppStartProfilingOptions.isEnableAppStartProfiling()) {
                            createAndStartTransactionProfiler(context, sentryAppStartProfilingOptions, appStartMetrics);
                        }
                        bufferedReader.close();
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException e) {
                this.logger.log(SentryLevel.ERROR, "App start profiling config file not found. ", e);
            } catch (Throwable th3) {
                this.logger.log(SentryLevel.ERROR, "Error reading app start profiling config file. ", th3);
            }
        }
    }

    private void createAndStartContinuousProfiler(@NotNull Context context, @NotNull SentryAppStartProfilingOptions sentryAppStartProfilingOptions, @NotNull AppStartMetrics appStartMetrics) {
        if (!sentryAppStartProfilingOptions.isContinuousProfileSampled()) {
            this.logger.log(SentryLevel.DEBUG, "App start profiling was not sampled. It will not start.", new Object[0]);
            return;
        }
        AndroidContinuousProfiler androidContinuousProfiler = new AndroidContinuousProfiler(this.buildInfoProvider, new SentryFrameMetricsCollector(context.getApplicationContext(), this.logger, this.buildInfoProvider), this.logger, sentryAppStartProfilingOptions.getProfilingTracesDirPath(), sentryAppStartProfilingOptions.getProfilingTracesHz(), new SentryExecutorService());
        appStartMetrics.setAppStartProfiler(null);
        appStartMetrics.setAppStartContinuousProfiler(androidContinuousProfiler);
        this.logger.log(SentryLevel.DEBUG, "App start continuous profiling started.", new Object[0]);
        SentryOptions sentryOptionsEmpty = SentryOptions.empty();
        sentryOptionsEmpty.setProfileSessionSampleRate(Double.valueOf(sentryAppStartProfilingOptions.isContinuousProfileSampled() ? 1.0d : 0.0d));
        androidContinuousProfiler.startProfiler(sentryAppStartProfilingOptions.getProfileLifecycle(), new TracesSampler(sentryOptionsEmpty));
    }

    private void createAndStartTransactionProfiler(@NotNull Context context, @NotNull SentryAppStartProfilingOptions sentryAppStartProfilingOptions, @NotNull AppStartMetrics appStartMetrics) {
        boolean zIsTraceSampled = sentryAppStartProfilingOptions.isTraceSampled();
        TracesSamplingDecision tracesSamplingDecision = new TracesSamplingDecision(Boolean.valueOf(zIsTraceSampled), sentryAppStartProfilingOptions.getTraceSampleRate(), Boolean.valueOf(sentryAppStartProfilingOptions.isProfileSampled()), sentryAppStartProfilingOptions.getProfileSampleRate());
        appStartMetrics.setAppStartSamplingDecision(tracesSamplingDecision);
        if (!tracesSamplingDecision.getProfileSampled().booleanValue() || !tracesSamplingDecision.getSampled().booleanValue()) {
            this.logger.log(SentryLevel.DEBUG, "App start profiling was not sampled. It will not start.", new Object[0]);
            return;
        }
        AndroidTransactionProfiler androidTransactionProfiler = new AndroidTransactionProfiler(context, this.buildInfoProvider, new SentryFrameMetricsCollector(context, this.logger, this.buildInfoProvider), this.logger, sentryAppStartProfilingOptions.getProfilingTracesDirPath(), sentryAppStartProfilingOptions.isProfilingEnabled(), sentryAppStartProfilingOptions.getProfilingTracesHz(), new SentryExecutorService());
        appStartMetrics.setAppStartContinuousProfiler(null);
        appStartMetrics.setAppStartProfiler(androidTransactionProfiler);
        this.logger.log(SentryLevel.DEBUG, "App start profiling started.", new Object[0]);
        androidTransactionProfiler.start();
    }

    private void onAppLaunched(@Nullable Context context, @NotNull AppStartMetrics appStartMetrics) {
        appStartMetrics.getSdkInitTimeSpan().setStartedAt(sdkInitMillis);
        if (this.buildInfoProvider.getSdkInfoVersion() >= 24) {
            appStartMetrics.getAppStartTimeSpan().setStartedAt(Process.getStartUptimeMillis());
        }
        if (context instanceof Application) {
            this.f126app = (Application) context;
        }
        Application application = this.f126app;
        if (application == null) {
            return;
        }
        appStartMetrics.registerLifecycleCallbacks(application);
    }
}
