package io.sentry;

import app.notifee.core.event.LogEvent;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.config.PropertiesProvider;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class ExternalOptions {
    private static final String PROXY_PORT_DEFAULT = "80";
    private Boolean captureOpenTelemetryEvents;
    private SentryOptions.Cron cron;
    private Boolean debug;
    private String dist;
    private String dsn;
    private Boolean enableBackpressureHandling;
    private Boolean enableDeduplication;
    private Boolean enableLogs;
    private Boolean enablePrettySerializationOutput;
    private Boolean enableSpotlight;
    private Boolean enableUncaughtExceptionHandler;
    private Boolean enabled;
    private String environment;
    private Boolean forceInit;
    private Boolean globalHubMode;
    private Long idleTimeout;
    private List<String> ignoredCheckIns;
    private List<String> ignoredErrors;
    private List<String> ignoredTransactions;
    private SentryOptions.RequestSize maxRequestBodySize;
    private Boolean printUncaughtStackTrace;
    private Double profilesSampleRate;
    private String proguardUuid;
    private SentryOptions.Proxy proxy;
    private String release;
    private Boolean sendClientReports;
    private Boolean sendDefaultPii;
    private Boolean sendModules;
    private String serverName;
    private String spotlightConnectionUrl;
    private Double tracesSampleRate;
    private final Map<String, String> tags = new ConcurrentHashMap();
    private final List<String> inAppExcludes = new CopyOnWriteArrayList();
    private final List<String> inAppIncludes = new CopyOnWriteArrayList();
    private List<String> tracePropagationTargets = null;
    private final List<String> contextTags = new CopyOnWriteArrayList();
    private final Set<Class<? extends Throwable>> ignoredExceptionsForType = new CopyOnWriteArraySet();
    private Set<String> bundleIds = new CopyOnWriteArraySet();

    /* JADX WARN: Multi-variable type inference failed */
    public static ExternalOptions from(@NotNull PropertiesProvider propertiesProvider, @NotNull ILogger iLogger) {
        ExternalOptions externalOptions = new ExternalOptions();
        externalOptions.setDsn(propertiesProvider.getProperty("dsn"));
        externalOptions.setEnvironment(propertiesProvider.getProperty("environment"));
        externalOptions.setRelease(propertiesProvider.getProperty("release"));
        externalOptions.setDist(propertiesProvider.getProperty(SentryBaseEvent.JsonKeys.DIST));
        externalOptions.setServerName(propertiesProvider.getProperty("servername"));
        externalOptions.setEnableUncaughtExceptionHandler(propertiesProvider.getBooleanProperty("uncaught.handler.enabled"));
        externalOptions.setPrintUncaughtStackTrace(propertiesProvider.getBooleanProperty("uncaught.handler.print-stacktrace"));
        externalOptions.setTracesSampleRate(propertiesProvider.getDoubleProperty("traces-sample-rate"));
        externalOptions.setProfilesSampleRate(propertiesProvider.getDoubleProperty("profiles-sample-rate"));
        externalOptions.setDebug(propertiesProvider.getBooleanProperty(LogEvent.LEVEL_DEBUG));
        externalOptions.setEnableDeduplication(propertiesProvider.getBooleanProperty("enable-deduplication"));
        externalOptions.setSendClientReports(propertiesProvider.getBooleanProperty("send-client-reports"));
        externalOptions.setForceInit(propertiesProvider.getBooleanProperty("force-init"));
        String property = propertiesProvider.getProperty("max-request-body-size");
        if (property != null) {
            externalOptions.setMaxRequestBodySize(SentryOptions.RequestSize.valueOf(property.toUpperCase(Locale.ROOT)));
        }
        for (Map.Entry<String, String> entry : propertiesProvider.getMap("tags").entrySet()) {
            externalOptions.setTag(entry.getKey(), entry.getValue());
        }
        String property2 = propertiesProvider.getProperty("proxy.host");
        String property3 = propertiesProvider.getProperty("proxy.user");
        String property4 = propertiesProvider.getProperty("proxy.pass");
        String property5 = propertiesProvider.getProperty("proxy.port", PROXY_PORT_DEFAULT);
        if (property2 != null) {
            externalOptions.setProxy(new SentryOptions.Proxy(property2, property5, property3, property4));
        }
        Iterator<String> it2 = propertiesProvider.getList("in-app-includes").iterator();
        while (it2.hasNext()) {
            externalOptions.addInAppInclude(it2.next());
        }
        Iterator<String> it3 = propertiesProvider.getList("in-app-excludes").iterator();
        while (it3.hasNext()) {
            externalOptions.addInAppExclude(it3.next());
        }
        List<String> list = propertiesProvider.getProperty("trace-propagation-targets") != null ? propertiesProvider.getList("trace-propagation-targets") : null;
        if (list == null && propertiesProvider.getProperty("tracing-origins") != null) {
            list = propertiesProvider.getList("tracing-origins");
        }
        if (list != null) {
            Iterator<String> it4 = list.iterator();
            while (it4.hasNext()) {
                externalOptions.addTracePropagationTarget(it4.next());
            }
        }
        Iterator<String> it5 = propertiesProvider.getList("context-tags").iterator();
        while (it5.hasNext()) {
            externalOptions.addContextTag(it5.next());
        }
        externalOptions.setProguardUuid(propertiesProvider.getProperty("proguard-uuid"));
        Iterator<String> it6 = propertiesProvider.getList("bundle-ids").iterator();
        while (it6.hasNext()) {
            externalOptions.addBundleId(it6.next());
        }
        externalOptions.setIdleTimeout(propertiesProvider.getLongProperty("idle-timeout"));
        externalOptions.setIgnoredErrors(propertiesProvider.getListOrNull("ignored-errors"));
        externalOptions.setEnabled(propertiesProvider.getBooleanProperty(ViewProps.ENABLED));
        externalOptions.setEnablePrettySerializationOutput(propertiesProvider.getBooleanProperty("enable-pretty-serialization-output"));
        externalOptions.setSendModules(propertiesProvider.getBooleanProperty("send-modules"));
        externalOptions.setSendDefaultPii(propertiesProvider.getBooleanProperty("send-default-pii"));
        externalOptions.setIgnoredCheckIns(propertiesProvider.getListOrNull("ignored-checkins"));
        externalOptions.setIgnoredTransactions(propertiesProvider.getListOrNull("ignored-transactions"));
        externalOptions.setEnableBackpressureHandling(propertiesProvider.getBooleanProperty("enable-backpressure-handling"));
        externalOptions.setGlobalHubMode(propertiesProvider.getBooleanProperty("global-hub-mode"));
        externalOptions.setCaptureOpenTelemetryEvents(propertiesProvider.getBooleanProperty("capture-open-telemetry-events"));
        externalOptions.setEnableLogs(propertiesProvider.getBooleanProperty("logs.enabled"));
        for (String str : propertiesProvider.getList("ignored-exceptions-for-type")) {
            try {
                Class<?> cls = Class.forName(str);
                if (Throwable.class.isAssignableFrom(cls)) {
                    externalOptions.addIgnoredExceptionForType(cls);
                } else {
                    iLogger.log(SentryLevel.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s does not extend Throwable", str, str);
                }
            } catch (ClassNotFoundException unused) {
                iLogger.log(SentryLevel.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s class is not found", str, str);
            }
        }
        Long longProperty = propertiesProvider.getLongProperty("cron.default-checkin-margin");
        Long longProperty2 = propertiesProvider.getLongProperty("cron.default-max-runtime");
        String property6 = propertiesProvider.getProperty("cron.default-timezone");
        Long longProperty3 = propertiesProvider.getLongProperty("cron.default-failure-issue-threshold");
        Long longProperty4 = propertiesProvider.getLongProperty("cron.default-recovery-threshold");
        if (longProperty != null || longProperty2 != null || property6 != null || longProperty3 != null || longProperty4 != null) {
            SentryOptions.Cron cron = new SentryOptions.Cron();
            cron.setDefaultCheckinMargin(longProperty);
            cron.setDefaultMaxRuntime(longProperty2);
            cron.setDefaultTimezone(property6);
            cron.setDefaultFailureIssueThreshold(longProperty3);
            cron.setDefaultRecoveryThreshold(longProperty4);
            externalOptions.setCron(cron);
        }
        externalOptions.setEnableSpotlight(propertiesProvider.getBooleanProperty("enable-spotlight"));
        externalOptions.setSpotlightConnectionUrl(propertiesProvider.getProperty("spotlight-connection-url"));
        return externalOptions;
    }

    public String getDsn() {
        return this.dsn;
    }

    public void setDsn(@Nullable String str) {
        this.dsn = str;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(@Nullable String str) {
        this.environment = str;
    }

    public String getRelease() {
        return this.release;
    }

    public void setRelease(@Nullable String str) {
        this.release = str;
    }

    public String getDist() {
        return this.dist;
    }

    public void setDist(@Nullable String str) {
        this.dist = str;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(@Nullable String str) {
        this.serverName = str;
    }

    public Boolean getEnableUncaughtExceptionHandler() {
        return this.enableUncaughtExceptionHandler;
    }

    public void setEnableUncaughtExceptionHandler(@Nullable Boolean bool) {
        this.enableUncaughtExceptionHandler = bool;
    }

    public List<String> getTracePropagationTargets() {
        return this.tracePropagationTargets;
    }

    public Boolean getDebug() {
        return this.debug;
    }

    public void setDebug(@Nullable Boolean bool) {
        this.debug = bool;
    }

    public Boolean getEnableDeduplication() {
        return this.enableDeduplication;
    }

    public void setEnableDeduplication(@Nullable Boolean bool) {
        this.enableDeduplication = bool;
    }

    public Double getTracesSampleRate() {
        return this.tracesSampleRate;
    }

    public void setTracesSampleRate(@Nullable Double d) {
        this.tracesSampleRate = d;
    }

    public Double getProfilesSampleRate() {
        return this.profilesSampleRate;
    }

    public void setProfilesSampleRate(@Nullable Double d) {
        this.profilesSampleRate = d;
    }

    public SentryOptions.RequestSize getMaxRequestBodySize() {
        return this.maxRequestBodySize;
    }

    public void setMaxRequestBodySize(@Nullable SentryOptions.RequestSize requestSize) {
        this.maxRequestBodySize = requestSize;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public SentryOptions.Proxy getProxy() {
        return this.proxy;
    }

    public void setProxy(@Nullable SentryOptions.Proxy proxy) {
        this.proxy = proxy;
    }

    public List<String> getInAppExcludes() {
        return this.inAppExcludes;
    }

    public List<String> getInAppIncludes() {
        return this.inAppIncludes;
    }

    public List<String> getContextTags() {
        return this.contextTags;
    }

    public String getProguardUuid() {
        return this.proguardUuid;
    }

    public void setProguardUuid(@Nullable String str) {
        this.proguardUuid = str;
    }

    public Set<Class<? extends Throwable>> getIgnoredExceptionsForType() {
        return this.ignoredExceptionsForType;
    }

    public void addInAppInclude(@NotNull String str) {
        this.inAppIncludes.add(str);
    }

    public void addInAppExclude(@NotNull String str) {
        this.inAppExcludes.add(str);
    }

    public void addTracePropagationTarget(@NotNull String str) {
        if (this.tracePropagationTargets == null) {
            this.tracePropagationTargets = new CopyOnWriteArrayList();
        }
        if (str.isEmpty()) {
            return;
        }
        this.tracePropagationTargets.add(str);
    }

    public void addContextTag(@NotNull String str) {
        this.contextTags.add(str);
    }

    public void addIgnoredExceptionForType(@NotNull Class<? extends Throwable> cls) {
        this.ignoredExceptionsForType.add(cls);
    }

    public void setTag(@NotNull String str, @NotNull String str2) {
        this.tags.put(str, str2);
    }

    public Boolean getPrintUncaughtStackTrace() {
        return this.printUncaughtStackTrace;
    }

    public void setPrintUncaughtStackTrace(@Nullable Boolean bool) {
        this.printUncaughtStackTrace = bool;
    }

    public Long getIdleTimeout() {
        return this.idleTimeout;
    }

    public void setIdleTimeout(@Nullable Long l) {
        this.idleTimeout = l;
    }

    public List<String> getIgnoredErrors() {
        return this.ignoredErrors;
    }

    public void setIgnoredErrors(@Nullable List<String> list) {
        this.ignoredErrors = list;
    }

    public Boolean getSendClientReports() {
        return this.sendClientReports;
    }

    public void setSendClientReports(@Nullable Boolean bool) {
        this.sendClientReports = bool;
    }

    public Set<String> getBundleIds() {
        return this.bundleIds;
    }

    public void addBundleId(@NotNull String str) {
        this.bundleIds.add(str);
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public Boolean isEnablePrettySerializationOutput() {
        return this.enablePrettySerializationOutput;
    }

    public void setEnablePrettySerializationOutput(@Nullable Boolean bool) {
        this.enablePrettySerializationOutput = bool;
    }

    public Boolean isSendModules() {
        return this.sendModules;
    }

    public void setSendModules(@Nullable Boolean bool) {
        this.sendModules = bool;
    }

    public Boolean isSendDefaultPii() {
        return this.sendDefaultPii;
    }

    public void setSendDefaultPii(@Nullable Boolean bool) {
        this.sendDefaultPii = bool;
    }

    public void setIgnoredCheckIns(@Nullable List<String> list) {
        this.ignoredCheckIns = list;
    }

    public List<String> getIgnoredCheckIns() {
        return this.ignoredCheckIns;
    }

    public void setIgnoredTransactions(@Nullable List<String> list) {
        this.ignoredTransactions = list;
    }

    public List<String> getIgnoredTransactions() {
        return this.ignoredTransactions;
    }

    public void setEnableBackpressureHandling(@Nullable Boolean bool) {
        this.enableBackpressureHandling = bool;
    }

    public Boolean isEnableBackpressureHandling() {
        return this.enableBackpressureHandling;
    }

    public void setGlobalHubMode(@Nullable Boolean bool) {
        this.globalHubMode = bool;
    }

    public Boolean isGlobalHubMode() {
        return this.globalHubMode;
    }

    public void setForceInit(@Nullable Boolean bool) {
        this.forceInit = bool;
    }

    public Boolean isForceInit() {
        return this.forceInit;
    }

    public SentryOptions.Cron getCron() {
        return this.cron;
    }

    public void setCron(@Nullable SentryOptions.Cron cron) {
        this.cron = cron;
    }

    public void setEnableSpotlight(@Nullable Boolean bool) {
        this.enableSpotlight = bool;
    }

    public Boolean isEnableSpotlight() {
        return this.enableSpotlight;
    }

    public String getSpotlightConnectionUrl() {
        return this.spotlightConnectionUrl;
    }

    public void setSpotlightConnectionUrl(@Nullable String str) {
        this.spotlightConnectionUrl = str;
    }

    public void setCaptureOpenTelemetryEvents(@Nullable Boolean bool) {
        this.captureOpenTelemetryEvents = bool;
    }

    public Boolean isCaptureOpenTelemetryEvents() {
        return this.captureOpenTelemetryEvents;
    }

    public void setEnableLogs(@Nullable Boolean bool) {
        this.enableLogs = bool;
    }

    public Boolean isEnableLogs() {
        return this.enableLogs;
    }
}
