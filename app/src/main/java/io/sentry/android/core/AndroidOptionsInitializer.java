package io.sentry.android.core;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import io.sentry.DeduplicateMultithreadedEventProcessor;
import io.sentry.DefaultCompositePerformanceCollector;
import io.sentry.DefaultVersionDetector;
import io.sentry.IContinuousProfiler;
import io.sentry.ILogger;
import io.sentry.ISentryLifecycleToken;
import io.sentry.ITransactionProfiler;
import io.sentry.NoOpCompositePerformanceCollector;
import io.sentry.NoOpConnectionStatusProvider;
import io.sentry.NoOpContinuousProfiler;
import io.sentry.NoOpSocketTagger;
import io.sentry.NoOpTransactionProfiler;
import io.sentry.NoopVersionDetector;
import io.sentry.ScopeType;
import io.sentry.SendCachedEnvelopeFireAndForgetIntegration;
import io.sentry.SendFireAndForgetEnvelopeSender;
import io.sentry.SendFireAndForgetOutboxSender;
import io.sentry.SentryLevel;
import io.sentry.SentryOpenTelemetryMode;
import io.sentry.android.core.cache.AndroidEnvelopeCache;
import io.sentry.android.core.internal.debugmeta.AssetsDebugMetaLoader;
import io.sentry.android.core.internal.gestures.AndroidViewGestureTargetLocator;
import io.sentry.android.core.internal.modules.AssetsModulesLoader;
import io.sentry.android.core.internal.util.AndroidConnectionStatusProvider;
import io.sentry.android.core.internal.util.AndroidCurrentDateProvider;
import io.sentry.android.core.internal.util.AndroidThreadChecker;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import io.sentry.android.replay.DefaultReplayBreadcrumbConverter;
import io.sentry.android.replay.ReplayIntegration;
import io.sentry.android.timber.SentryTimberIntegration;
import io.sentry.cache.PersistingOptionsObserver;
import io.sentry.cache.PersistingScopeObserver;
import io.sentry.compose.gestures.ComposeGestureTargetLocator;
import io.sentry.compose.viewhierarchy.ComposeViewHierarchyExporter;
import io.sentry.internal.debugmeta.NoOpDebugMetaLoader;
import io.sentry.internal.modules.NoOpModulesLoader;
import io.sentry.transport.CurrentDateProvider;
import io.sentry.transport.NoOpEnvelopeCache;
import io.sentry.transport.NoOpTransportGate;
import io.sentry.util.LazyEvaluator;
import io.sentry.util.Objects;
import io.sentry.util.thread.NoOpThreadChecker;
import java.io.File;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes6.dex */
final class AndroidOptionsInitializer {
    static final String COMPOSE_CLASS_NAME = "androidx.compose.ui.node.Owner";
    static final long DEFAULT_FLUSH_TIMEOUT_MS = 4000;
    static final String SENTRY_COMPOSE_GESTURE_INTEGRATION_CLASS_NAME = "io.sentry.compose.gestures.ComposeGestureTargetLocator";
    static final String SENTRY_COMPOSE_VIEW_HIERARCHY_INTEGRATION_CLASS_NAME = "io.sentry.compose.viewhierarchy.ComposeViewHierarchyExporter";

    private AndroidOptionsInitializer() {
    }

    static void loadDefaultAndMetadataOptions(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull Context context) {
        AndroidLogger androidLogger = new AndroidLogger();
        loadDefaultAndMetadataOptions(sentryAndroidOptions, context, androidLogger, new BuildInfoProvider(androidLogger));
    }

    static void loadDefaultAndMetadataOptions(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull Context context, @NotNull ILogger iLogger, @NotNull BuildInfoProvider buildInfoProvider) {
        Objects.requireNonNull(context, "The context is required.");
        Context applicationContext = ContextUtils.getApplicationContext(context);
        Objects.requireNonNull(sentryAndroidOptions, "The options object is required.");
        Objects.requireNonNull(iLogger, "The ILogger object is required.");
        sentryAndroidOptions.setLogger(iLogger);
        sentryAndroidOptions.setFatalLogger(new AndroidFatalLogger());
        sentryAndroidOptions.setDefaultScopeType(ScopeType.CURRENT);
        sentryAndroidOptions.setOpenTelemetryMode(SentryOpenTelemetryMode.OFF);
        sentryAndroidOptions.setDateProvider(new SentryAndroidDateProvider());
        sentryAndroidOptions.setFlushTimeoutMillis(DEFAULT_FLUSH_TIMEOUT_MS);
        sentryAndroidOptions.setFrameMetricsCollector(new SentryFrameMetricsCollector(applicationContext, iLogger, buildInfoProvider));
        ManifestMetadataReader.applyMetadata(applicationContext, sentryAndroidOptions, buildInfoProvider);
        sentryAndroidOptions.setCacheDirPath(getCacheDir(applicationContext).getAbsolutePath());
        readDefaultOptionValues(sentryAndroidOptions, applicationContext, buildInfoProvider);
        AppState.getInstance().registerLifecycleObserver(sentryAndroidOptions);
    }

    static void initializeIntegrationsAndProcessors(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull Context context, @NotNull io.sentry.util.LoadClass loadClass, @NotNull ActivityFramesTracker activityFramesTracker) {
        initializeIntegrationsAndProcessors(sentryAndroidOptions, context, new BuildInfoProvider(new AndroidLogger()), loadClass, activityFramesTracker);
    }

    static void initializeIntegrationsAndProcessors(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull Context context, @NotNull BuildInfoProvider buildInfoProvider, @NotNull io.sentry.util.LoadClass loadClass, @NotNull ActivityFramesTracker activityFramesTracker) {
        if (sentryAndroidOptions.getCacheDirPath() != null && (sentryAndroidOptions.getEnvelopeDiskCache() instanceof NoOpEnvelopeCache)) {
            sentryAndroidOptions.setEnvelopeDiskCache(new AndroidEnvelopeCache(sentryAndroidOptions));
        }
        if (sentryAndroidOptions.getConnectionStatusProvider() instanceof NoOpConnectionStatusProvider) {
            sentryAndroidOptions.setConnectionStatusProvider(new AndroidConnectionStatusProvider(context, sentryAndroidOptions, buildInfoProvider, AndroidCurrentDateProvider.getInstance()));
        }
        if (sentryAndroidOptions.getCacheDirPath() != null) {
            sentryAndroidOptions.addScopeObserver(new PersistingScopeObserver(sentryAndroidOptions));
            sentryAndroidOptions.addOptionsObserver(new PersistingOptionsObserver(sentryAndroidOptions));
        }
        sentryAndroidOptions.addEventProcessor(new DeduplicateMultithreadedEventProcessor(sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new DefaultAndroidEventProcessor(context, buildInfoProvider, sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new PerformanceAndroidEventProcessor(sentryAndroidOptions, activityFramesTracker));
        sentryAndroidOptions.addEventProcessor(new ScreenshotEventProcessor(sentryAndroidOptions, buildInfoProvider));
        sentryAndroidOptions.addEventProcessor(new ViewHierarchyEventProcessor(sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new AnrV2EventProcessor(context, sentryAndroidOptions, buildInfoProvider));
        if (sentryAndroidOptions.getTransportGate() instanceof NoOpTransportGate) {
            sentryAndroidOptions.setTransportGate(new AndroidTransportGate(sentryAndroidOptions));
        }
        AppStartMetrics appStartMetrics = AppStartMetrics.getInstance();
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = AppStartMetrics.staticLock.acquire();
        try {
            ITransactionProfiler appStartProfiler = appStartMetrics.getAppStartProfiler();
            IContinuousProfiler appStartContinuousProfiler = appStartMetrics.getAppStartContinuousProfiler();
            appStartMetrics.setAppStartProfiler(null);
            appStartMetrics.setAppStartContinuousProfiler(null);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            setupProfiler(sentryAndroidOptions, context, buildInfoProvider, appStartProfiler, appStartContinuousProfiler);
            if (sentryAndroidOptions.getModulesLoader() instanceof NoOpModulesLoader) {
                sentryAndroidOptions.setModulesLoader(new AssetsModulesLoader(context, sentryAndroidOptions.getLogger()));
            }
            if (sentryAndroidOptions.getDebugMetaLoader() instanceof NoOpDebugMetaLoader) {
                sentryAndroidOptions.setDebugMetaLoader(new AssetsDebugMetaLoader(context, sentryAndroidOptions.getLogger()));
            }
            if (sentryAndroidOptions.getVersionDetector() instanceof NoopVersionDetector) {
                sentryAndroidOptions.setVersionDetector(new DefaultVersionDetector(sentryAndroidOptions));
            }
            boolean zIsClassAvailable = loadClass.isClassAvailable("androidx.core.view.ScrollingView", sentryAndroidOptions);
            boolean zIsClassAvailable2 = loadClass.isClassAvailable(COMPOSE_CLASS_NAME, sentryAndroidOptions);
            if (sentryAndroidOptions.getGestureTargetLocators().isEmpty()) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(new AndroidViewGestureTargetLocator(zIsClassAvailable));
                if (zIsClassAvailable2 && loadClass.isClassAvailable(SENTRY_COMPOSE_GESTURE_INTEGRATION_CLASS_NAME, sentryAndroidOptions)) {
                    arrayList.add(new ComposeGestureTargetLocator(sentryAndroidOptions.getLogger()));
                }
                sentryAndroidOptions.setGestureTargetLocators(arrayList);
            }
            if (sentryAndroidOptions.getViewHierarchyExporters().isEmpty() && zIsClassAvailable2 && loadClass.isClassAvailable(SENTRY_COMPOSE_VIEW_HIERARCHY_INTEGRATION_CLASS_NAME, sentryAndroidOptions)) {
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(new ComposeViewHierarchyExporter(sentryAndroidOptions.getLogger()));
                sentryAndroidOptions.setViewHierarchyExporters(arrayList2);
            }
            if (sentryAndroidOptions.getThreadChecker() instanceof NoOpThreadChecker) {
                sentryAndroidOptions.setThreadChecker(AndroidThreadChecker.getInstance());
            }
            if (sentryAndroidOptions.getSocketTagger() instanceof NoOpSocketTagger) {
                sentryAndroidOptions.setSocketTagger(AndroidSocketTagger.getInstance());
            }
            if (sentryAndroidOptions.getPerformanceCollectors().isEmpty()) {
                sentryAndroidOptions.addPerformanceCollector(new AndroidMemoryCollector());
                sentryAndroidOptions.addPerformanceCollector(new AndroidCpuCollector(sentryAndroidOptions.getLogger()));
                if (sentryAndroidOptions.isEnablePerformanceV2()) {
                    sentryAndroidOptions.addPerformanceCollector(new SpanFrameMetricsCollector(sentryAndroidOptions, (SentryFrameMetricsCollector) Objects.requireNonNull(sentryAndroidOptions.getFrameMetricsCollector(), "options.getFrameMetricsCollector is required")));
                }
            }
            if (sentryAndroidOptions.getCompositePerformanceCollector() instanceof NoOpCompositePerformanceCollector) {
                sentryAndroidOptions.setCompositePerformanceCollector(new DefaultCompositePerformanceCollector(sentryAndroidOptions));
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

    private static void setupProfiler(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull Context context, @NotNull BuildInfoProvider buildInfoProvider, @Nullable ITransactionProfiler iTransactionProfiler, @Nullable IContinuousProfiler iContinuousProfiler) {
        if (sentryAndroidOptions.isProfilingEnabled() || sentryAndroidOptions.getProfilesSampleRate() != null) {
            sentryAndroidOptions.setContinuousProfiler(NoOpContinuousProfiler.getInstance());
            if (iContinuousProfiler != null) {
                iContinuousProfiler.close(true);
            }
            if (iTransactionProfiler != null) {
                sentryAndroidOptions.setTransactionProfiler(iTransactionProfiler);
                return;
            } else {
                sentryAndroidOptions.setTransactionProfiler(new AndroidTransactionProfiler(context, sentryAndroidOptions, buildInfoProvider, (SentryFrameMetricsCollector) Objects.requireNonNull(sentryAndroidOptions.getFrameMetricsCollector(), "options.getFrameMetricsCollector is required")));
                return;
            }
        }
        sentryAndroidOptions.setTransactionProfiler(NoOpTransactionProfiler.getInstance());
        if (iTransactionProfiler != null) {
            iTransactionProfiler.close();
        }
        if (iContinuousProfiler != null) {
            sentryAndroidOptions.setContinuousProfiler(iContinuousProfiler);
        } else {
            sentryAndroidOptions.setContinuousProfiler(new AndroidContinuousProfiler(buildInfoProvider, (SentryFrameMetricsCollector) Objects.requireNonNull(sentryAndroidOptions.getFrameMetricsCollector(), "options.getFrameMetricsCollector is required"), sentryAndroidOptions.getLogger(), sentryAndroidOptions.getProfilingTracesDirPath(), sentryAndroidOptions.getProfilingTracesHz(), sentryAndroidOptions.getExecutorService()));
        }
    }

    static void installDefaultIntegrations(@NotNull Context context, @NotNull final SentryAndroidOptions sentryAndroidOptions, @NotNull BuildInfoProvider buildInfoProvider, @NotNull io.sentry.util.LoadClass loadClass, @NotNull ActivityFramesTracker activityFramesTracker, boolean z, boolean z2, boolean z3) {
        LazyEvaluator lazyEvaluator = new LazyEvaluator(new LazyEvaluator.Evaluator() { // from class: io.sentry.android.core.AndroidOptionsInitializer$$ExternalSyntheticLambda0
            @Override // io.sentry.util.LazyEvaluator.Evaluator
            public final Object evaluate() {
                return AndroidOptionsInitializer.lambda$installDefaultIntegrations$0(sentryAndroidOptions);
            }
        });
        sentryAndroidOptions.addIntegration(new SendCachedEnvelopeIntegration(new SendFireAndForgetEnvelopeSender(new SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetDirPath() { // from class: io.sentry.android.core.AndroidOptionsInitializer$$ExternalSyntheticLambda1
            @Override // io.sentry.SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetDirPath
            public final String getDirPath() {
                return sentryAndroidOptions.getCacheDirPath();
            }
        }), lazyEvaluator));
        sentryAndroidOptions.addIntegration(new NdkIntegration(loadClass.loadClass(NdkIntegration.SENTRY_NDK_CLASS_NAME, sentryAndroidOptions.getLogger())));
        sentryAndroidOptions.addIntegration(EnvelopeFileObserverIntegration.getOutboxFileObserver());
        sentryAndroidOptions.addIntegration(new SendCachedEnvelopeIntegration(new SendFireAndForgetOutboxSender(new SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetDirPath() { // from class: io.sentry.android.core.AndroidOptionsInitializer$$ExternalSyntheticLambda2
            @Override // io.sentry.SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetDirPath
            public final String getDirPath() {
                return sentryAndroidOptions.getOutboxPath();
            }
        }), lazyEvaluator));
        sentryAndroidOptions.addIntegration(new AppLifecycleIntegration());
        sentryAndroidOptions.addIntegration(AnrIntegrationFactory.create(context, buildInfoProvider));
        if (context instanceof Application) {
            Application application = (Application) context;
            sentryAndroidOptions.addIntegration(new ActivityLifecycleIntegration(application, buildInfoProvider, activityFramesTracker));
            sentryAndroidOptions.addIntegration(new ActivityBreadcrumbsIntegration(application));
            sentryAndroidOptions.addIntegration(new UserInteractionIntegration(application, loadClass));
            if (z) {
                sentryAndroidOptions.addIntegration(new FragmentLifecycleIntegration(application, true, true));
            }
        } else {
            sentryAndroidOptions.getLogger().log(SentryLevel.WARNING, "ActivityLifecycle, FragmentLifecycle and UserInteraction Integrations need an Application class to be installed.", new Object[0]);
        }
        if (z2) {
            sentryAndroidOptions.addIntegration(new SentryTimberIntegration());
        }
        sentryAndroidOptions.addIntegration(new AppComponentsBreadcrumbsIntegration(context));
        sentryAndroidOptions.addIntegration(new SystemEventsBreadcrumbsIntegration(context));
        sentryAndroidOptions.addIntegration(new NetworkBreadcrumbsIntegration(context, buildInfoProvider));
        if (z3) {
            ReplayIntegration replayIntegration = new ReplayIntegration(context, CurrentDateProvider.getInstance());
            replayIntegration.setBreadcrumbConverter(new DefaultReplayBreadcrumbConverter());
            sentryAndroidOptions.addIntegration(replayIntegration);
            sentryAndroidOptions.setReplayController(replayIntegration);
        }
        sentryAndroidOptions.getFeedbackOptions().setDialogHandler(new SentryAndroidOptions.AndroidUserFeedbackIDialogHandler());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$installDefaultIntegrations$0(SentryAndroidOptions sentryAndroidOptions) {
        return Boolean.valueOf(AndroidEnvelopeCache.hasStartupCrashMarker(sentryAndroidOptions));
    }

    private static void readDefaultOptionValues(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull Context context, @NotNull BuildInfoProvider buildInfoProvider) {
        PackageInfo packageInfo = ContextUtils.getPackageInfo(context, buildInfoProvider);
        if (packageInfo != null) {
            if (sentryAndroidOptions.getRelease() == null) {
                sentryAndroidOptions.setRelease(getSentryReleaseVersion(packageInfo, ContextUtils.getVersionCode(packageInfo, buildInfoProvider)));
            }
            String str = packageInfo.packageName;
            if (str != null && !str.startsWith("android.")) {
                sentryAndroidOptions.addInAppInclude(str);
            }
        }
        if (sentryAndroidOptions.getDistinctId() == null) {
            try {
                sentryAndroidOptions.setDistinctId(Installation.id(context));
            } catch (RuntimeException e) {
                sentryAndroidOptions.getLogger().log(SentryLevel.ERROR, "Could not generate distinct Id.", e);
            }
        }
    }

    private static String getSentryReleaseVersion(@NotNull PackageInfo packageInfo, @NotNull String str) {
        return packageInfo.packageName + "@" + packageInfo.versionName + Marker.ANY_NON_NULL_MARKER + str;
    }

    static File getCacheDir(@NotNull Context context) {
        return new File(context.getCacheDir(), "sentry");
    }
}
