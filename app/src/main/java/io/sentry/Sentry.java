package io.sentry;

import io.sentry.backpressure.BackpressureMonitor;
import io.sentry.backpressure.NoOpBackpressureMonitor;
import io.sentry.cache.EnvelopeCache;
import io.sentry.cache.PersistingScopeObserver;
import io.sentry.config.PropertiesProviderFactory;
import io.sentry.internal.debugmeta.NoOpDebugMetaLoader;
import io.sentry.internal.debugmeta.ResourcesDebugMetaLoader;
import io.sentry.internal.modules.CompositeModulesLoader;
import io.sentry.internal.modules.IModulesLoader;
import io.sentry.internal.modules.ManifestModulesLoader;
import io.sentry.internal.modules.NoOpModulesLoader;
import io.sentry.internal.modules.ResourcesModulesLoader;
import io.sentry.logger.ILoggerApi;
import io.sentry.opentelemetry.OpenTelemetryUtil;
import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import io.sentry.transport.NoOpEnvelopeCache;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.DebugMetaPropertiesApplier;
import io.sentry.util.FileUtils;
import io.sentry.util.InitUtil;
import io.sentry.util.LoadClass;
import io.sentry.util.Platform;
import io.sentry.util.SentryRandom;
import io.sentry.util.thread.NoOpThreadChecker;
import io.sentry.util.thread.ThreadChecker;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class Sentry {
    public static final String APP_START_PROFILING_CONFIG_FILE_NAME = "app_start_profiling_config";
    private static final boolean GLOBAL_HUB_DEFAULT_MODE = false;
    private static volatile IScopesStorage scopesStorage = NoOpScopesStorage.getInstance();
    private static volatile IScopes rootScopes = NoOpScopes.getInstance();
    private static final IScope globalScope = new Scope(SentryOptions.empty());
    private static volatile boolean globalHubMode = false;
    private static final Charset UTF_8 = Charset.forName(CharEncoding.UTF_8);
    private static final long classCreationTimestamp = System.currentTimeMillis();
    private static final AutoClosableReentrantLock lock = new AutoClosableReentrantLock();

    /* JADX INFO: loaded from: classes6.dex */
    public interface OptionsConfiguration<T extends SentryOptions> {
        void configure(@NotNull T t);
    }

    private Sentry() {
    }

    @Deprecated
    public static IHub getCurrentHub() {
        return new HubScopesWrapper(getCurrentScopes());
    }

    public static IScopes getCurrentScopes() {
        if (globalHubMode) {
            return rootScopes;
        }
        IScopes iScopes = getScopesStorage().get();
        if (iScopes != null && !iScopes.isNoOp()) {
            return iScopes;
        }
        IScopes iScopesForkedScopes = rootScopes.forkedScopes("getCurrentScopes");
        getScopesStorage().set(iScopesForkedScopes);
        return iScopesForkedScopes;
    }

    private static IScopesStorage getScopesStorage() {
        return scopesStorage;
    }

    public static IScopes forkedRootScopes(@NotNull String str) {
        if (globalHubMode) {
            return rootScopes;
        }
        return rootScopes.forkedScopes(str);
    }

    public static IScopes forkedScopes(@NotNull String str) {
        return getCurrentScopes().forkedScopes(str);
    }

    public static IScopes forkedCurrentScope(@NotNull String str) {
        return getCurrentScopes().forkedCurrentScope(str);
    }

    @Deprecated
    public static ISentryLifecycleToken setCurrentHub(@NotNull IHub iHub) {
        return setCurrentScopes(iHub);
    }

    public static ISentryLifecycleToken setCurrentScopes(@NotNull IScopes iScopes) {
        return getScopesStorage().set(iScopes);
    }

    public static IScope getGlobalScope() {
        return globalScope;
    }

    public static boolean isEnabled() {
        return getCurrentScopes().isEnabled();
    }

    public static void init() {
        init((OptionsConfiguration<SentryOptions>) new OptionsConfiguration() { // from class: io.sentry.Sentry$$ExternalSyntheticLambda2
            @Override // io.sentry.Sentry.OptionsConfiguration
            public final void configure(SentryOptions sentryOptions) {
                sentryOptions.setEnableExternalConfiguration(true);
            }
        }, false);
    }

    public static void init(@NotNull final String str) {
        init((OptionsConfiguration<SentryOptions>) new OptionsConfiguration() { // from class: io.sentry.Sentry$$ExternalSyntheticLambda5
            @Override // io.sentry.Sentry.OptionsConfiguration
            public final void configure(SentryOptions sentryOptions) {
                sentryOptions.setDsn(str);
            }
        });
    }

    public static <T extends SentryOptions> void init(@NotNull OptionsContainer<T> optionsContainer, @NotNull OptionsConfiguration<T> optionsConfiguration) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        init(optionsContainer, optionsConfiguration, false);
    }

    public static <T extends SentryOptions> void init(@NotNull OptionsContainer<T> optionsContainer, @NotNull OptionsConfiguration<T> optionsConfiguration, boolean z) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        T tCreateInstance = optionsContainer.createInstance();
        applyOptionsConfiguration(optionsConfiguration, tCreateInstance);
        init(tCreateInstance, z);
    }

    public static void init(@NotNull OptionsConfiguration<SentryOptions> optionsConfiguration) {
        init(optionsConfiguration, false);
    }

    public static void init(@NotNull OptionsConfiguration<SentryOptions> optionsConfiguration, boolean z) {
        SentryOptions sentryOptions = new SentryOptions();
        applyOptionsConfiguration(optionsConfiguration, sentryOptions);
        init(sentryOptions, z);
    }

    private static <T extends SentryOptions> void applyOptionsConfiguration(OptionsConfiguration<T> optionsConfiguration, T t) {
        try {
            optionsConfiguration.configure(t);
        } catch (Throwable th) {
            t.getLogger().log(SentryLevel.ERROR, "Error in the 'OptionsConfiguration.configure' callback.", th);
        }
    }

    public static void init(@NotNull SentryOptions sentryOptions) {
        init(sentryOptions, false);
    }

    private static void init(@NotNull final SentryOptions sentryOptions, boolean z) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = lock.acquire();
        try {
            if (!sentryOptions.getClass().getName().equals("io.sentry.android.core.SentryAndroidOptions") && Platform.isAndroid()) {
                throw new IllegalArgumentException("You are running Android. Please, use SentryAndroid.init. " + sentryOptions.getClass().getName());
            }
            if (!preInitConfigurations(sentryOptions)) {
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                    return;
                }
                return;
            }
            Boolean boolIsGlobalHubMode = sentryOptions.isGlobalHubMode();
            if (boolIsGlobalHubMode != null) {
                z = boolIsGlobalHubMode.booleanValue();
            }
            sentryOptions.getLogger().log(SentryLevel.INFO, "GlobalHubMode: '%s'", String.valueOf(z));
            globalHubMode = z;
            initFatalLogger(sentryOptions);
            if (InitUtil.shouldInit(globalScope.getOptions(), sentryOptions, isEnabled())) {
                if (isEnabled()) {
                    sentryOptions.getLogger().log(SentryLevel.WARNING, "Sentry has been already initialized. Previous configuration will be overwritten.", new Object[0]);
                }
                try {
                    sentryOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.Sentry$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            sentryOptions.loadLazyFields();
                        }
                    });
                } catch (RejectedExecutionException e) {
                    sentryOptions.getLogger().log(SentryLevel.DEBUG, "Failed to call the executor. Lazy fields will not be loaded. Did you call Sentry.close()?", e);
                }
                getCurrentScopes().close(true);
                IScope iScope = globalScope;
                iScope.replaceOptions(sentryOptions);
                rootScopes = new Scopes(new Scope(sentryOptions), new Scope(sentryOptions), iScope, "Sentry.init");
                initLogger(sentryOptions);
                initForOpenTelemetryMaybe(sentryOptions);
                getScopesStorage().set(rootScopes);
                initConfigurations(sentryOptions);
                iScope.bindClient(new SentryClient(sentryOptions));
                if (sentryOptions.getExecutorService().isClosed()) {
                    sentryOptions.setExecutorService(new SentryExecutorService(sentryOptions));
                    sentryOptions.getExecutorService().prewarm();
                }
                movePreviousSession(sentryOptions);
                for (Integration integration : sentryOptions.getIntegrations()) {
                    try {
                        integration.register(ScopesAdapter.getInstance(), sentryOptions);
                    } catch (Throwable th) {
                        sentryOptions.getLogger().log(SentryLevel.WARNING, "Failed to register the integration " + integration.getClass().getName(), th);
                    }
                }
                notifyOptionsObservers(sentryOptions);
                finalizePreviousSession(sentryOptions, ScopesAdapter.getInstance());
                handleAppStartProfilingConfig(sentryOptions, sentryOptions.getExecutorService());
                ILogger logger = sentryOptions.getLogger();
                SentryLevel sentryLevel = SentryLevel.DEBUG;
                logger.log(sentryLevel, "Using openTelemetryMode %s", sentryOptions.getOpenTelemetryMode());
                sentryOptions.getLogger().log(sentryLevel, "Using span factory %s", sentryOptions.getSpanFactory().getClass().getName());
                sentryOptions.getLogger().log(sentryLevel, "Using scopes storage %s", scopesStorage.getClass().getName());
            } else {
                sentryOptions.getLogger().log(SentryLevel.WARNING, "This init call has been ignored due to priority being too low.", new Object[0]);
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th2) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    private static void initForOpenTelemetryMaybe(SentryOptions sentryOptions) {
        OpenTelemetryUtil.updateOpenTelemetryModeIfAuto(sentryOptions, new LoadClass());
        if (SentryOpenTelemetryMode.OFF == sentryOptions.getOpenTelemetryMode()) {
            sentryOptions.setSpanFactory(new DefaultSpanFactory());
        }
        initScopesStorage(sentryOptions);
        OpenTelemetryUtil.applyIgnoredSpanOrigins(sentryOptions);
    }

    private static void initLogger(@NotNull SentryOptions sentryOptions) {
        if (sentryOptions.isDebug() && (sentryOptions.getLogger() instanceof NoOpLogger)) {
            sentryOptions.setLogger(new SystemOutLogger());
        }
    }

    private static void initFatalLogger(@NotNull SentryOptions sentryOptions) {
        if (sentryOptions.getFatalLogger() instanceof NoOpLogger) {
            sentryOptions.setFatalLogger(new SystemOutLogger());
        }
    }

    private static void initScopesStorage(SentryOptions sentryOptions) {
        getScopesStorage().close();
        if (SentryOpenTelemetryMode.OFF == sentryOptions.getOpenTelemetryMode()) {
            scopesStorage = new DefaultScopesStorage();
        } else {
            scopesStorage = ScopesStorageFactory.create(new LoadClass(), NoOpLogger.getInstance());
        }
    }

    private static void handleAppStartProfilingConfig(@NotNull final SentryOptions sentryOptions, @NotNull ISentryExecutorService iSentryExecutorService) {
        try {
            iSentryExecutorService.submit(new Runnable() { // from class: io.sentry.Sentry$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Sentry.lambda$handleAppStartProfilingConfig$3(sentryOptions);
                }
            });
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed to call the executor. App start profiling config will not be changed. Did you call Sentry.close()?", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleAppStartProfilingConfig$3(SentryOptions sentryOptions) {
        TracesSamplingDecision tracesSamplingDecision;
        String cacheDirPathWithoutDsn = sentryOptions.getCacheDirPathWithoutDsn();
        if (cacheDirPathWithoutDsn != null) {
            File file = new File(cacheDirPathWithoutDsn, APP_START_PROFILING_CONFIG_FILE_NAME);
            try {
                FileUtils.deleteRecursively(file);
                if (sentryOptions.isEnableAppStartProfiling() || sentryOptions.isStartProfilerOnAppStart()) {
                    if (!sentryOptions.isStartProfilerOnAppStart() && !sentryOptions.isTracingEnabled()) {
                        sentryOptions.getLogger().log(SentryLevel.INFO, "Tracing is disabled and app start profiling will not start.", new Object[0]);
                        return;
                    }
                    if (file.createNewFile()) {
                        if (sentryOptions.isEnableAppStartProfiling()) {
                            tracesSamplingDecision = sampleAppStartProfiling(sentryOptions);
                        } else {
                            tracesSamplingDecision = new TracesSamplingDecision(Boolean.FALSE);
                        }
                        SentryAppStartProfilingOptions sentryAppStartProfilingOptions = new SentryAppStartProfilingOptions(sentryOptions, tracesSamplingDecision);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, UTF_8));
                            try {
                                sentryOptions.getSerializer().serialize(sentryAppStartProfilingOptions, bufferedWriter);
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
                    }
                }
            } catch (Throwable th5) {
                sentryOptions.getLogger().log(SentryLevel.ERROR, "Unable to create app start profiling config file. ", th5);
            }
        }
    }

    private static TracesSamplingDecision sampleAppStartProfiling(@NotNull SentryOptions sentryOptions) {
        TransactionContext transactionContext = new TransactionContext("app.launch", "profile");
        transactionContext.setForNextAppStart(true);
        return sentryOptions.getInternalTracesSampler().sample(new SamplingContext(transactionContext, null, Double.valueOf(SentryRandom.current().nextDouble()), null));
    }

    private static void movePreviousSession(@NotNull SentryOptions sentryOptions) {
        try {
            sentryOptions.getExecutorService().submit(new MovePreviousSession(sentryOptions));
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "Failed to move previous session.", th);
        }
    }

    private static void finalizePreviousSession(@NotNull SentryOptions sentryOptions, @NotNull IScopes iScopes) {
        try {
            sentryOptions.getExecutorService().submit(new PreviousSessionFinalizer(sentryOptions, iScopes));
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "Failed to finalize previous session.", th);
        }
    }

    private static void notifyOptionsObservers(@NotNull final SentryOptions sentryOptions) {
        try {
            sentryOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.Sentry$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    Sentry.lambda$notifyOptionsObservers$4(sentryOptions);
                }
            });
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "Failed to notify options observers.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyOptionsObservers$4(SentryOptions sentryOptions) {
        for (IOptionsObserver iOptionsObserver : sentryOptions.getOptionsObservers()) {
            iOptionsObserver.setRelease(sentryOptions.getRelease());
            iOptionsObserver.setProguardUuid(sentryOptions.getProguardUuid());
            iOptionsObserver.setSdkVersion(sentryOptions.getSdkVersion());
            iOptionsObserver.setDist(sentryOptions.getDist());
            iOptionsObserver.setEnvironment(sentryOptions.getEnvironment());
            iOptionsObserver.setTags(sentryOptions.getTags());
            iOptionsObserver.setReplayErrorSampleRate(sentryOptions.getSessionReplay().getOnErrorSampleRate());
        }
        PersistingScopeObserver persistingScopeObserverFindPersistingScopeObserver = sentryOptions.findPersistingScopeObserver();
        if (persistingScopeObserverFindPersistingScopeObserver != null) {
            persistingScopeObserverFindPersistingScopeObserver.resetCache();
        }
    }

    private static boolean preInitConfigurations(@NotNull SentryOptions sentryOptions) {
        if (sentryOptions.isEnableExternalConfiguration()) {
            sentryOptions.merge(ExternalOptions.from(PropertiesProviderFactory.create(), sentryOptions.getLogger()));
        }
        String dsn = sentryOptions.getDsn();
        if (!sentryOptions.isEnabled() || (dsn != null && dsn.isEmpty())) {
            close();
            return false;
        }
        if (dsn == null) {
            throw new IllegalArgumentException("DSN is required. Use empty string or set enabled to false in SentryOptions to disable SDK.");
        }
        sentryOptions.retrieveParsedDsn();
        return true;
    }

    private static void initConfigurations(@NotNull SentryOptions sentryOptions) {
        ILogger logger = sentryOptions.getLogger();
        SentryLevel sentryLevel = SentryLevel.INFO;
        logger.log(sentryLevel, "Initializing SDK with DSN: '%s'", sentryOptions.getDsn());
        String outboxPath = sentryOptions.getOutboxPath();
        if (outboxPath != null) {
            new File(outboxPath).mkdirs();
        } else {
            logger.log(sentryLevel, "No outbox dir path is defined in options.", new Object[0]);
        }
        String cacheDirPath = sentryOptions.getCacheDirPath();
        if (cacheDirPath != null) {
            new File(cacheDirPath).mkdirs();
            if (sentryOptions.getEnvelopeDiskCache() instanceof NoOpEnvelopeCache) {
                sentryOptions.setEnvelopeDiskCache(EnvelopeCache.create(sentryOptions));
            }
        }
        String profilingTracesDirPath = sentryOptions.getProfilingTracesDirPath();
        if ((sentryOptions.isProfilingEnabled() || sentryOptions.isContinuousProfilingEnabled()) && profilingTracesDirPath != null) {
            final File file = new File(profilingTracesDirPath);
            file.mkdirs();
            try {
                sentryOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.Sentry$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Sentry.lambda$initConfigurations$5(file);
                    }
                });
            } catch (RejectedExecutionException e) {
                sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed to call the executor. Old profiles will not be deleted. Did you call Sentry.close()?", e);
            }
        }
        IModulesLoader modulesLoader = sentryOptions.getModulesLoader();
        if (!sentryOptions.isSendModules()) {
            sentryOptions.setModulesLoader(NoOpModulesLoader.getInstance());
        } else if (modulesLoader instanceof NoOpModulesLoader) {
            sentryOptions.setModulesLoader(new CompositeModulesLoader(Arrays.asList(new ManifestModulesLoader(sentryOptions.getLogger()), new ResourcesModulesLoader(sentryOptions.getLogger())), sentryOptions.getLogger()));
        }
        if (sentryOptions.getDebugMetaLoader() instanceof NoOpDebugMetaLoader) {
            sentryOptions.setDebugMetaLoader(new ResourcesDebugMetaLoader(sentryOptions.getLogger()));
        }
        DebugMetaPropertiesApplier.apply(sentryOptions, sentryOptions.getDebugMetaLoader().loadDebugMeta());
        if (sentryOptions.getThreadChecker() instanceof NoOpThreadChecker) {
            sentryOptions.setThreadChecker(ThreadChecker.getInstance());
        }
        if (sentryOptions.getPerformanceCollectors().isEmpty()) {
            sentryOptions.addPerformanceCollector(new JavaMemoryCollector());
        }
        if (sentryOptions.isEnableBackpressureHandling() && Platform.isJvm()) {
            if (sentryOptions.getBackpressureMonitor() instanceof NoOpBackpressureMonitor) {
                sentryOptions.setBackpressureMonitor(new BackpressureMonitor(sentryOptions, ScopesAdapter.getInstance()));
            }
            sentryOptions.getBackpressureMonitor().start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initConfigurations$5(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.lastModified() < classCreationTimestamp - TimeUnit.MINUTES.toMillis(5L)) {
                FileUtils.deleteRecursively(file2);
            }
        }
    }

    public static void close() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = lock.acquire();
        try {
            IScopes currentScopes = getCurrentScopes();
            rootScopes = NoOpScopes.getInstance();
            getScopesStorage().close();
            currentScopes.close(false);
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

    public static SentryId captureEvent(@NotNull SentryEvent sentryEvent) {
        return getCurrentScopes().captureEvent(sentryEvent);
    }

    public static SentryId captureEvent(@NotNull SentryEvent sentryEvent, @NotNull ScopeCallback scopeCallback) {
        return getCurrentScopes().captureEvent(sentryEvent, scopeCallback);
    }

    public static SentryId captureEvent(@NotNull SentryEvent sentryEvent, @Nullable Hint hint) {
        return getCurrentScopes().captureEvent(sentryEvent, hint);
    }

    public static SentryId captureEvent(@NotNull SentryEvent sentryEvent, @Nullable Hint hint, @NotNull ScopeCallback scopeCallback) {
        return getCurrentScopes().captureEvent(sentryEvent, hint, scopeCallback);
    }

    public static SentryId captureMessage(@NotNull String str) {
        return getCurrentScopes().captureMessage(str);
    }

    public static SentryId captureMessage(@NotNull String str, @NotNull ScopeCallback scopeCallback) {
        return getCurrentScopes().captureMessage(str, scopeCallback);
    }

    public static SentryId captureMessage(@NotNull String str, @NotNull SentryLevel sentryLevel) {
        return getCurrentScopes().captureMessage(str, sentryLevel);
    }

    public static SentryId captureMessage(@NotNull String str, @NotNull SentryLevel sentryLevel, @NotNull ScopeCallback scopeCallback) {
        return getCurrentScopes().captureMessage(str, sentryLevel, scopeCallback);
    }

    public static SentryId captureFeedback(@NotNull Feedback feedback) {
        return getCurrentScopes().captureFeedback(feedback);
    }

    public static SentryId captureFeedback(@NotNull Feedback feedback, @Nullable Hint hint) {
        return getCurrentScopes().captureFeedback(feedback, hint);
    }

    public static SentryId captureFeedback(@NotNull Feedback feedback, @Nullable Hint hint, @Nullable ScopeCallback scopeCallback) {
        return getCurrentScopes().captureFeedback(feedback, hint, scopeCallback);
    }

    public static SentryId captureException(@NotNull Throwable th) {
        return getCurrentScopes().captureException(th);
    }

    public static SentryId captureException(@NotNull Throwable th, @NotNull ScopeCallback scopeCallback) {
        return getCurrentScopes().captureException(th, scopeCallback);
    }

    public static SentryId captureException(@NotNull Throwable th, @Nullable Hint hint) {
        return getCurrentScopes().captureException(th, hint);
    }

    public static SentryId captureException(@NotNull Throwable th, @Nullable Hint hint, @NotNull ScopeCallback scopeCallback) {
        return getCurrentScopes().captureException(th, hint, scopeCallback);
    }

    public static void captureUserFeedback(@NotNull UserFeedback userFeedback) {
        getCurrentScopes().captureUserFeedback(userFeedback);
    }

    public static void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable Hint hint) {
        getCurrentScopes().addBreadcrumb(breadcrumb, hint);
    }

    public static void addBreadcrumb(@NotNull Breadcrumb breadcrumb) {
        getCurrentScopes().addBreadcrumb(breadcrumb);
    }

    public static void addBreadcrumb(@NotNull String str) {
        getCurrentScopes().addBreadcrumb(str);
    }

    public static void addBreadcrumb(@NotNull String str, @NotNull String str2) {
        getCurrentScopes().addBreadcrumb(str, str2);
    }

    public static void setLevel(@Nullable SentryLevel sentryLevel) {
        getCurrentScopes().setLevel(sentryLevel);
    }

    public static void setTransaction(@Nullable String str) {
        getCurrentScopes().setTransaction(str);
    }

    public static void setUser(@Nullable User user) {
        getCurrentScopes().setUser(user);
    }

    public static void setFingerprint(@NotNull List<String> list) {
        getCurrentScopes().setFingerprint(list);
    }

    public static void clearBreadcrumbs() {
        getCurrentScopes().clearBreadcrumbs();
    }

    public static void setTag(@Nullable String str, @Nullable String str2) {
        getCurrentScopes().setTag(str, str2);
    }

    public static void removeTag(@Nullable String str) {
        getCurrentScopes().removeTag(str);
    }

    public static void setExtra(@Nullable String str, @Nullable String str2) {
        getCurrentScopes().setExtra(str, str2);
    }

    public static void removeExtra(@Nullable String str) {
        getCurrentScopes().removeExtra(str);
    }

    public static SentryId getLastEventId() {
        return getCurrentScopes().getLastEventId();
    }

    public static ISentryLifecycleToken pushScope() {
        if (!globalHubMode) {
            return getCurrentScopes().pushScope();
        }
        return NoOpScopesLifecycleToken.getInstance();
    }

    public static ISentryLifecycleToken pushIsolationScope() {
        if (!globalHubMode) {
            return getCurrentScopes().pushIsolationScope();
        }
        return NoOpScopesLifecycleToken.getInstance();
    }

    @Deprecated
    public static void popScope() {
        if (globalHubMode) {
            return;
        }
        getCurrentScopes().popScope();
    }

    public static void withScope(@NotNull ScopeCallback scopeCallback) {
        getCurrentScopes().withScope(scopeCallback);
    }

    public static void withIsolationScope(@NotNull ScopeCallback scopeCallback) {
        getCurrentScopes().withIsolationScope(scopeCallback);
    }

    public static void configureScope(@NotNull ScopeCallback scopeCallback) {
        configureScope(null, scopeCallback);
    }

    public static void configureScope(@Nullable ScopeType scopeType, @NotNull ScopeCallback scopeCallback) {
        getCurrentScopes().configureScope(scopeType, scopeCallback);
    }

    public static void bindClient(@NotNull ISentryClient iSentryClient) {
        getCurrentScopes().bindClient(iSentryClient);
    }

    public static boolean isHealthy() {
        return getCurrentScopes().isHealthy();
    }

    public static void flush(long j) {
        getCurrentScopes().flush(j);
    }

    public static void startSession() {
        getCurrentScopes().startSession();
    }

    public static void endSession() {
        getCurrentScopes().endSession();
    }

    public static ITransaction startTransaction(@NotNull String str, @NotNull String str2) {
        return getCurrentScopes().startTransaction(str, str2);
    }

    public static ITransaction startTransaction(@NotNull String str, @NotNull String str2, @NotNull TransactionOptions transactionOptions) {
        return getCurrentScopes().startTransaction(str, str2, transactionOptions);
    }

    public static ITransaction startTransaction(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull TransactionOptions transactionOptions) {
        ITransaction iTransactionStartTransaction = getCurrentScopes().startTransaction(str, str2, transactionOptions);
        iTransactionStartTransaction.setDescription(str3);
        return iTransactionStartTransaction;
    }

    public static ITransaction startTransaction(@NotNull TransactionContext transactionContext) {
        return getCurrentScopes().startTransaction(transactionContext);
    }

    public static ITransaction startTransaction(@NotNull TransactionContext transactionContext, @NotNull TransactionOptions transactionOptions) {
        return getCurrentScopes().startTransaction(transactionContext, transactionOptions);
    }

    public static void startProfiler() {
        getCurrentScopes().startProfiler();
    }

    public static void stopProfiler() {
        getCurrentScopes().stopProfiler();
    }

    public static ISpan getSpan() {
        if (globalHubMode && Platform.isAndroid()) {
            return getCurrentScopes().getTransaction();
        }
        return getCurrentScopes().getSpan();
    }

    public static Boolean isCrashedLastRun() {
        return getCurrentScopes().isCrashedLastRun();
    }

    public static void reportFullyDisplayed() {
        getCurrentScopes().reportFullyDisplayed();
    }

    public static TransactionContext continueTrace(@Nullable String str, @Nullable List<String> list) {
        return getCurrentScopes().continueTrace(str, list);
    }

    public static SentryTraceHeader getTraceparent() {
        return getCurrentScopes().getTraceparent();
    }

    public static BaggageHeader getBaggage() {
        return getCurrentScopes().getBaggage();
    }

    public static SentryId captureCheckIn(@NotNull CheckIn checkIn) {
        return getCurrentScopes().captureCheckIn(checkIn);
    }

    public static ILoggerApi logger() {
        return getCurrentScopes().logger();
    }

    public static IReplayApi replay() {
        return getCurrentScopes().getScope().getOptions().getReplayController();
    }

    public static void showUserFeedbackDialog() {
        showUserFeedbackDialog(null);
    }

    public static void showUserFeedbackDialog(@Nullable SentryFeedbackOptions.OptionsConfigurator optionsConfigurator) {
        showUserFeedbackDialog(null, optionsConfigurator);
    }

    public static void showUserFeedbackDialog(@Nullable SentryId sentryId, @Nullable SentryFeedbackOptions.OptionsConfigurator optionsConfigurator) {
        getCurrentScopes().getOptions().getFeedbackOptions().getDialogHandler().showDialog(sentryId, optionsConfigurator);
    }
}
