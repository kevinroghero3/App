package io.sentry.react;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.FrameMetricsAggregator;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import app.notifee.core.event.LogEvent;
import com.facebook.hermes.instrumentation.HermesSamplingProfiler;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.JavascriptException;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.Breadcrumb;
import io.sentry.Hint;
import io.sentry.ILogger;
import io.sentry.IScope;
import io.sentry.ISentryExecutorService;
import io.sentry.Integration;
import io.sentry.ProfilingTraceData;
import io.sentry.ScopeCallback;
import io.sentry.ScopesAdapter;
import io.sentry.Sentry;
import io.sentry.SentryBaseEvent;
import io.sentry.SentryDateProvider;
import io.sentry.SentryEvent;
import io.sentry.SentryExecutorService;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryReplayOptions;
import io.sentry.Session;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.android.core.AndroidLogger;
import io.sentry.android.core.AndroidProfiler;
import io.sentry.android.core.AnrIntegration;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.android.core.CurrentActivityHolder;
import io.sentry.android.core.InternalSentrySdk;
import io.sentry.android.core.NdkIntegration;
import io.sentry.android.core.SentryAndroid;
import io.sentry.android.core.SentryAndroidDateProvider;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.ViewHierarchyEventProcessor;
import io.sentry.android.core.internal.debugmeta.AssetsDebugMetaLoader;
import io.sentry.android.core.internal.util.ScreenshotUtils;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryPackage;
import io.sentry.protocol.User;
import io.sentry.protocol.ViewHierarchy;
import io.sentry.react.replay.RNSentryReplayMask;
import io.sentry.react.replay.RNSentryReplayUnmask;
import io.sentry.util.DebugMetaPropertiesApplier;
import io.sentry.util.FileUtils;
import io.sentry.util.JsonSerializationUtils;
import io.sentry.vendor.Base64;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import o.ArtificialStackFrames;
import o.onPostMessage;
import o.onRelationshipValidationResult;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class RNSentryModuleImpl {
    private static final int FROZEN_FRAME_THRESHOLD = 700;
    public static final String NAME = "RNSentry";
    private static final int SCREENSHOT_TIMEOUT_SECONDS = 2;
    private static final int SLOW_FRAME_THRESHOLD = 16;
    private static final Charset UTF_8;
    private static final BuildInfoProvider buildInfo;
    static long lastStartTimestampMs = 0;
    private static final ILogger logger;
    private static final String modulesPath = "modules.json";
    private boolean androidXAvailable;
    private final PackageInfo packageInfo;
    private final ReactApplicationContext reactApplicationContext;
    private FrameMetricsAggregator frameMetricsAggregator = null;
    private int profilingTracesHz = 101;
    private AndroidProfiler androidProfiler = null;
    private boolean isProguardDebugMetaLoaded = false;
    private String proguardUuid = null;
    private String cacheDirPath = null;
    private ISentryExecutorService executorService = null;
    private long maxTraceFileSize = 5242880;
    private final Runnable emitNewFrameEvent = createEmitNewFrameEvent();
    private final SentryDateProvider dateProvider = new SentryAndroidDateProvider();

    private boolean checkAndroidXAvailability() {
        return true;
    }

    static {
        AndroidLogger androidLogger = new AndroidLogger(NAME);
        logger = androidLogger;
        buildInfo = new BuildInfoProvider(androidLogger);
        UTF_8 = Charset.forName(CharEncoding.UTF_8);
        lastStartTimestampMs = -1L;
    }

    public RNSentryModuleImpl(ReactApplicationContext reactApplicationContext) {
        this.packageInfo = getPackageInfo(reactApplicationContext);
        this.reactApplicationContext = reactApplicationContext;
    }

    private ReactApplicationContext getReactApplicationContext() {
        return this.reactApplicationContext;
    }

    private Activity getCurrentActivity() {
        return this.reactApplicationContext.getCurrentActivity();
    }

    private Runnable createEmitNewFrameEvent() {
        return new Runnable() { // from class: io.sentry.react.RNSentryModuleImpl$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createEmitNewFrameEvent$0();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createEmitNewFrameEvent$0() {
        RNSentryTimeToDisplay.putTimeToInitialDisplayForActiveSpan(Double.valueOf(this.dateProvider.now().nanoTimestamp() / 1.0E9d));
    }

    private void initFragmentInitialFrameTracking() {
        FragmentManager supportFragmentManager;
        RNSentryReactFragmentLifecycleTracer rNSentryReactFragmentLifecycleTracer = new RNSentryReactFragmentLifecycleTracer(buildInfo, this.emitNewFrameEvent, logger);
        FragmentActivity fragmentActivity = (FragmentActivity) getCurrentActivity();
        if (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null) {
            return;
        }
        supportFragmentManager.registerFragmentLifecycleCallbacks(rNSentryReactFragmentLifecycleTracer, true);
    }

    public void initNativeReactNavigationNewFrameTracking(Promise promise) {
        initFragmentInitialFrameTracking();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initNativeSdk$1(ReadableMap readableMap, SentryAndroidOptions sentryAndroidOptions) {
        getSentryAndroidOptions(sentryAndroidOptions, readableMap, logger);
    }

    public void initNativeSdk(final ReadableMap readableMap, Promise promise) {
        SentryAndroid.init(getApplicationContext(), (Sentry.OptionsConfiguration<SentryAndroidOptions>) new Sentry.OptionsConfiguration() { // from class: io.sentry.react.RNSentryModuleImpl$$ExternalSyntheticLambda4
            @Override // io.sentry.Sentry.OptionsConfiguration
            public final void configure(SentryOptions sentryOptions) {
                this.f$0.lambda$initNativeSdk$1(readableMap, (SentryAndroidOptions) sentryOptions);
            }
        });
        promise.resolve(Boolean.TRUE);
    }

    protected Context getApplicationContext() {
        Context applicationContext = getReactApplicationContext().getApplicationContext();
        if (applicationContext != null) {
            return applicationContext;
        }
        logger.log(SentryLevel.ERROR, "ApplicationContext is null, using ReactApplicationContext fallback.", new Object[0]);
        return getReactApplicationContext();
    }

    protected void getSentryAndroidOptions(@NotNull final SentryAndroidOptions sentryAndroidOptions, @NotNull ReadableMap readableMap, ILogger iLogger) {
        SdkVersion sdkVersion = sentryAndroidOptions.getSdkVersion();
        if (sdkVersion == null) {
            sdkVersion = new SdkVersion("sentry.java.android.react-native", "8.20.0");
        } else {
            sdkVersion.setName("sentry.java.android.react-native");
        }
        sdkVersion.addPackage("npm:@sentry/react-native", "7.0.1");
        sentryAndroidOptions.setSentryClientName(sdkVersion.getName() + RemoteSettings.FORWARD_SLASH_STRING + sdkVersion.getVersion());
        sentryAndroidOptions.setNativeSdkName("sentry.native.android.react-native");
        sentryAndroidOptions.setSdkVersion(sdkVersion);
        if (readableMap.hasKey(LogEvent.LEVEL_DEBUG) && readableMap.getBoolean(LogEvent.LEVEL_DEBUG)) {
            sentryAndroidOptions.setDebug(true);
        }
        if (readableMap.hasKey("dsn") && readableMap.getString("dsn") != null) {
            String string = readableMap.getString("dsn");
            iLogger.log(SentryLevel.INFO, String.format("Starting with DSN: '%s'", string), new Object[0]);
            sentryAndroidOptions.setDsn(string);
        } else {
            sentryAndroidOptions.setDsn("");
        }
        if (readableMap.hasKey("sampleRate")) {
            sentryAndroidOptions.setSampleRate(Double.valueOf(readableMap.getDouble("sampleRate")));
        }
        if (readableMap.hasKey("sendClientReports")) {
            sentryAndroidOptions.setSendClientReports(readableMap.getBoolean("sendClientReports"));
        }
        if (readableMap.hasKey("maxBreadcrumbs")) {
            sentryAndroidOptions.setMaxBreadcrumbs(readableMap.getInt("maxBreadcrumbs"));
        }
        if (readableMap.hasKey("maxCacheItems")) {
            sentryAndroidOptions.setMaxCacheItems(readableMap.getInt("maxCacheItems"));
        }
        if (readableMap.hasKey("environment") && readableMap.getString("environment") != null) {
            sentryAndroidOptions.setEnvironment(readableMap.getString("environment"));
        }
        if (readableMap.hasKey("release") && readableMap.getString("release") != null) {
            sentryAndroidOptions.setRelease(readableMap.getString("release"));
        }
        if (readableMap.hasKey(SentryBaseEvent.JsonKeys.DIST) && readableMap.getString(SentryBaseEvent.JsonKeys.DIST) != null) {
            sentryAndroidOptions.setDist(readableMap.getString(SentryBaseEvent.JsonKeys.DIST));
        }
        if (readableMap.hasKey("enableAutoSessionTracking")) {
            sentryAndroidOptions.setEnableAutoSessionTracking(readableMap.getBoolean("enableAutoSessionTracking"));
        }
        if (readableMap.hasKey("sessionTrackingIntervalMillis")) {
            sentryAndroidOptions.setSessionTrackingIntervalMillis(readableMap.getInt("sessionTrackingIntervalMillis"));
        }
        if (readableMap.hasKey("shutdownTimeout")) {
            sentryAndroidOptions.setShutdownTimeoutMillis(readableMap.getInt("shutdownTimeout"));
        }
        if (readableMap.hasKey("enableNdkScopeSync")) {
            sentryAndroidOptions.setEnableScopeSync(readableMap.getBoolean("enableNdkScopeSync"));
        }
        if (readableMap.hasKey("attachStacktrace")) {
            sentryAndroidOptions.setAttachStacktrace(readableMap.getBoolean("attachStacktrace"));
        }
        if (readableMap.hasKey("attachThreads")) {
            sentryAndroidOptions.setAttachThreads(readableMap.getBoolean("attachThreads"));
        }
        if (readableMap.hasKey("attachScreenshot")) {
            sentryAndroidOptions.setAttachScreenshot(readableMap.getBoolean("attachScreenshot"));
        }
        if (readableMap.hasKey("attachViewHierarchy")) {
            sentryAndroidOptions.setAttachViewHierarchy(readableMap.getBoolean("attachViewHierarchy"));
        }
        if (readableMap.hasKey("sendDefaultPii")) {
            sentryAndroidOptions.setSendDefaultPii(readableMap.getBoolean("sendDefaultPii"));
        }
        if (readableMap.hasKey("maxQueueSize")) {
            sentryAndroidOptions.setMaxQueueSize(readableMap.getInt("maxQueueSize"));
        }
        if (readableMap.hasKey("enableNdk")) {
            sentryAndroidOptions.setEnableNdk(readableMap.getBoolean("enableNdk"));
        }
        if (readableMap.hasKey("enableLogs")) {
            sentryAndroidOptions.getLogs().setEnabled(readableMap.getBoolean("enableLogs"));
        }
        if (readableMap.hasKey("spotlight")) {
            if (readableMap.getType("spotlight") == ReadableType.Boolean) {
                sentryAndroidOptions.setEnableSpotlight(readableMap.getBoolean("spotlight"));
                sentryAndroidOptions.setSpotlightConnectionUrl(readableMap.getString("defaultSidecarUrl"));
            } else if (readableMap.getType("spotlight") == ReadableType.String) {
                sentryAndroidOptions.setEnableSpotlight(true);
                sentryAndroidOptions.setSpotlightConnectionUrl(readableMap.getString("spotlight"));
            }
        }
        SentryReplayOptions replayOptions = getReplayOptions(readableMap);
        sentryAndroidOptions.setSessionReplay(replayOptions);
        if (isReplayEnabled(replayOptions)) {
            sentryAndroidOptions.getReplayController().setBreadcrumbConverter(new RNSentryReplayBreadcrumbConverter());
        }
        final String uRLFromDSN = getURLFromDSN(readableMap.getString("dsn"));
        final String string2 = readableMap.getString("devServerUrl");
        sentryAndroidOptions.setBeforeBreadcrumb(new SentryOptions.BeforeBreadcrumbCallback() { // from class: io.sentry.react.RNSentryModuleImpl$$ExternalSyntheticLambda1
            @Override // io.sentry.SentryOptions.BeforeBreadcrumbCallback
            public final Breadcrumb execute(Breadcrumb breadcrumb, Hint hint) {
                return RNSentryModuleImpl.lambda$getSentryAndroidOptions$2(uRLFromDSN, string2, breadcrumb, hint);
            }
        });
        sentryAndroidOptions.addIgnoredExceptionForType(JavascriptException.class);
        trySetIgnoreErrors(sentryAndroidOptions, readableMap);
        sentryAndroidOptions.setBeforeSend(new SentryOptions.BeforeSendCallback() { // from class: io.sentry.react.RNSentryModuleImpl$$ExternalSyntheticLambda2
            @Override // io.sentry.SentryOptions.BeforeSendCallback
            public final SentryEvent execute(SentryEvent sentryEvent, Hint hint) {
                return this.f$0.lambda$getSentryAndroidOptions$3(sentryAndroidOptions, sentryEvent, hint);
            }
        });
        if (readableMap.hasKey("enableNativeCrashHandling") && !readableMap.getBoolean("enableNativeCrashHandling")) {
            List<Integration> integrations = sentryAndroidOptions.getIntegrations();
            for (Integration integration : integrations) {
                if ((integration instanceof UncaughtExceptionHandlerIntegration) || (integration instanceof AnrIntegration) || (integration instanceof NdkIntegration)) {
                    integrations.remove(integration);
                }
            }
        }
        iLogger.log(SentryLevel.INFO, String.format("Native Integrations '%s'", sentryAndroidOptions.getIntegrations()), new Object[0]);
        CurrentActivityHolder currentActivityHolder = CurrentActivityHolder.getInstance();
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivityHolder.setActivity(currentActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Breadcrumb lambda$getSentryAndroidOptions$2(String str, String str2, Breadcrumb breadcrumb, Hint hint) {
        Object data = breadcrumb.getData("url");
        String str3 = data instanceof String ? (String) data : "";
        if ("http".equals(breadcrumb.getType())) {
            if (str != null && str3.startsWith(str)) {
                return null;
            }
            if (str2 != null && str3.startsWith(str2)) {
                return null;
            }
        }
        return breadcrumb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SentryEvent lambda$getSentryAndroidOptions$3(SentryAndroidOptions sentryAndroidOptions, SentryEvent sentryEvent, Hint hint) {
        setEventOriginTag(sentryEvent);
        addPackages(sentryEvent, sentryAndroidOptions.getSdkVersion());
        return sentryEvent;
    }

    private boolean isReplayEnabled(SentryReplayOptions sentryReplayOptions) {
        return (sentryReplayOptions.getSessionSampleRate() == null && sentryReplayOptions.getOnErrorSampleRate() == null) ? false : true;
    }

    private SentryReplayOptions getReplayOptions(@NotNull ReadableMap readableMap) {
        ReadableMap map;
        SentryReplayOptions sentryReplayOptions = new SentryReplayOptions(false, new SdkVersion("sentry.javascript.react-native", "7.0.1"));
        if (!readableMap.hasKey("replaysSessionSampleRate") && !readableMap.hasKey("replaysOnErrorSampleRate")) {
            return sentryReplayOptions;
        }
        sentryReplayOptions.setSessionSampleRate(readableMap.hasKey("replaysSessionSampleRate") ? Double.valueOf(readableMap.getDouble("replaysSessionSampleRate")) : null);
        sentryReplayOptions.setOnErrorSampleRate(readableMap.hasKey("replaysOnErrorSampleRate") ? Double.valueOf(readableMap.getDouble("replaysOnErrorSampleRate")) : null);
        if (readableMap.hasKey("replaysSessionQuality")) {
            sentryReplayOptions.setQuality(parseReplayQuality(readableMap.getString("replaysSessionQuality")));
        }
        if (!readableMap.hasKey("mobileReplayOptions") || (map = readableMap.getMap("mobileReplayOptions")) == null) {
            return sentryReplayOptions;
        }
        sentryReplayOptions.setMaskAllText(!map.hasKey("maskAllText") || map.getBoolean("maskAllText"));
        sentryReplayOptions.setMaskAllImages(!map.hasKey("maskAllImages") || map.getBoolean("maskAllImages"));
        if (!map.hasKey("maskAllVectors") || map.getBoolean("maskAllVectors")) {
            sentryReplayOptions.addMaskViewClass("com.horcrux.svg.SvgView");
        }
        sentryReplayOptions.setMaskViewContainerClass(RNSentryReplayMask.class.getName());
        sentryReplayOptions.setUnmaskViewContainerClass(RNSentryReplayUnmask.class.getName());
        return sentryReplayOptions;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    private SentryReplayOptions.SentryReplayQuality parseReplayQuality(@Nullable String str) {
        byte b;
        if (str == null) {
            return SentryReplayOptions.SentryReplayQuality.MEDIUM;
        }
        try {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1078030475) {
                if (iHashCode != 107348) {
                    if (iHashCode == 3202466 && lowerCase.equals("high")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (lowerCase.equals("low")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (lowerCase.equals("medium")) {
                b = 1;
            } else {
                b = -1;
            }
            if (b == 0) {
                return SentryReplayOptions.SentryReplayQuality.LOW;
            }
            if (b == 1) {
                return SentryReplayOptions.SentryReplayQuality.MEDIUM;
            }
            if (b == 2) {
                return SentryReplayOptions.SentryReplayQuality.HIGH;
            }
            return SentryReplayOptions.SentryReplayQuality.MEDIUM;
        } catch (Exception unused) {
            return SentryReplayOptions.SentryReplayQuality.MEDIUM;
        }
    }

    public void crash() {
        throw new RuntimeException("TEST - Sentry Client Crash (only works in release mode)");
    }

    public void addListener(String str) {
        logger.log(SentryLevel.ERROR, "addListener of NativeEventEmitter can't be used on Android!", new Object[0]);
    }

    public void removeListeners(double d) {
        logger.log(SentryLevel.ERROR, "removeListeners of NativeEventEmitter can't be used on Android!", new Object[0]);
    }

    public void fetchModules(Promise promise) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(getReactApplicationContext().getResources().getAssets().open(modulesPath));
            try {
                byte[] bArr = new byte[bufferedInputStream.available()];
                bufferedInputStream.read(bArr);
                bufferedInputStream.close();
                promise.resolve(new String(bArr, UTF_8));
                bufferedInputStream.close();
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (FileNotFoundException unused) {
            promise.resolve(null);
        } catch (Throwable unused2) {
            logger.log(SentryLevel.WARNING, "Fetching JS Modules failed.", new Object[0]);
            promise.resolve(null);
        }
    }

    public void fetchNativeRelease(Promise promise) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("id", this.packageInfo.packageName);
        writableMapCreateMap.putString("version", this.packageInfo.versionName);
        writableMapCreateMap.putString("build", String.valueOf(this.packageInfo.versionCode));
        promise.resolve(writableMapCreateMap);
    }

    public void fetchNativeAppStart(Promise promise) {
        fetchNativeAppStart(promise, AppStartMetrics.getInstance(), InternalSentrySdk.getAppStartMeasurement(), logger);
    }

    protected void fetchNativeAppStart(Promise promise, AppStartMetrics appStartMetrics, Map<String, Object> map, ILogger iLogger) {
        if (!appStartMetrics.isAppLaunchedInForeground()) {
            iLogger.log(SentryLevel.WARNING, "Invalid app start data: app not launched in foreground.", new Object[0]);
            promise.resolve(null);
            return;
        }
        WritableMap writableMap = (WritableMap) RNSentryMapConverter.convertToWritable(map);
        long startTimestampMs = appStartMetrics.getAppStartTimeSpan().getStartTimestampMs();
        long j = lastStartTimestampMs;
        boolean z = j > 0 && j == startTimestampMs;
        writableMap.putBoolean("has_fetched", z);
        if (lastStartTimestampMs < 0) {
            iLogger.log(SentryLevel.DEBUG, "App Start data reported to the RN layer for the first time.", new Object[0]);
        } else if (z) {
            iLogger.log(SentryLevel.DEBUG, "App Start data already fetched from native before.", new Object[0]);
        } else {
            iLogger.log(SentryLevel.DEBUG, "App Start data updated, reporting to the RN layer again.", new Object[0]);
        }
        lastStartTimestampMs = startTimestampMs;
        appStartMetrics.onAppStartSpansSent();
        promise.resolve(writableMap);
    }

    public void fetchNativeFrames(Promise promise) {
        int i;
        int i2;
        int i3;
        SparseIntArray sparseIntArray;
        if (!isFrameMetricsAggregatorAvailable()) {
            promise.resolve(null);
            return;
        }
        try {
            SparseIntArray[] metrics = this.frameMetricsAggregator.getMetrics();
            if (metrics == null || (sparseIntArray = metrics[0]) == null) {
                i = 0;
                i2 = 0;
                i3 = 0;
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                for (int i4 = 0; i4 < sparseIntArray.size(); i4++) {
                    int iKeyAt = sparseIntArray.keyAt(i4);
                    int iValueAt = sparseIntArray.valueAt(i4);
                    i += iValueAt;
                    if (iKeyAt > 700) {
                        i3 += iValueAt;
                    } else if (iKeyAt > 16) {
                        i2 += iValueAt;
                    }
                }
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putInt("totalFrames", i);
            writableMapCreateMap.putInt("slowFrames", i2);
            writableMapCreateMap.putInt("frozenFrames", i3);
            promise.resolve(writableMapCreateMap);
        } catch (Throwable unused) {
            logger.log(SentryLevel.WARNING, "Error fetching native frames.", new Object[0]);
            promise.resolve(null);
        }
    }

    public void captureReplay(boolean z, Promise promise) {
        Sentry.getCurrentScopes().getOptions().getReplayController().captureReplay(Boolean.valueOf(z));
        promise.resolve(getCurrentReplayId());
    }

    public String getCurrentReplayId() {
        SentryId replayId;
        IScope currentScope = InternalSentrySdk.getCurrentScope();
        if (currentScope == null || (replayId = currentScope.getReplayId()) == SentryId.EMPTY_ID) {
            return null;
        }
        return replayId.toString();
    }

    public void captureEnvelope(String str, ReadableMap readableMap, Promise promise) {
        try {
            InternalSentrySdk.captureEnvelope(Base64.decode(str, 0), (readableMap.hasKey("hardCrashed") && readableMap.getBoolean("hardCrashed")) ? false : true);
        } catch (Throwable unused) {
            logger.log(SentryLevel.ERROR, "Error while capturing envelope", new Object[0]);
            promise.resolve(Boolean.FALSE);
        }
        promise.resolve(Boolean.TRUE);
    }

    public void captureScreenshot(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            logger.log(SentryLevel.WARNING, "CurrentActivity is null, can't capture screenshot.", new Object[0]);
            promise.resolve(null);
            return;
        }
        byte[] bArrTakeScreenshotOnUiThread = takeScreenshotOnUiThread(currentActivity);
        if (bArrTakeScreenshotOnUiThread == null || bArrTakeScreenshotOnUiThread.length == 0) {
            logger.log(SentryLevel.WARNING, "Screenshot is null, screen was not captured.", new Object[0]);
            promise.resolve(null);
            return;
        }
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (byte b : bArrTakeScreenshotOnUiThread) {
            writableNativeArray.pushInt(b);
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("contentType", "image/png");
        writableNativeMap.putArray("data", writableNativeArray);
        writableNativeMap.putString("filename", "screenshot.png");
        WritableNativeArray writableNativeArray2 = new WritableNativeArray();
        writableNativeArray2.pushMap(writableNativeMap);
        promise.resolve(writableNativeArray2);
    }

    private static byte[] takeScreenshotOnUiThread(final Activity activity) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final byte[][] bArr = {new byte[0]};
        Runnable runnable = new Runnable() { // from class: io.sentry.react.RNSentryModuleImpl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                RNSentryModuleImpl.lambda$takeScreenshotOnUiThread$4(bArr, activity, countDownLatch);
            }
        };
        if (UiThreadUtil.isOnUiThread()) {
            runnable.run();
        } else {
            UiThreadUtil.runOnUiThread(runnable);
        }
        try {
            countDownLatch.await(2L, TimeUnit.SECONDS);
            return bArr[0];
        } catch (InterruptedException unused) {
            logger.log(SentryLevel.ERROR, "Screenshot process was interrupted.", new Object[0]);
            return new byte[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$takeScreenshotOnUiThread$4(byte[][] bArr, Activity activity, CountDownLatch countDownLatch) {
        bArr[0] = ScreenshotUtils.takeScreenshot(activity, logger, buildInfo);
        countDownLatch.countDown();
    }

    public void fetchViewHierarchy(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        ILogger iLogger = logger;
        ViewHierarchy viewHierarchySnapshotViewHierarchy = ViewHierarchyEventProcessor.snapshotViewHierarchy(currentActivity, iLogger);
        if (viewHierarchySnapshotViewHierarchy == null) {
            iLogger.log(SentryLevel.ERROR, "Could not get ViewHierarchy.", new Object[0]);
            promise.resolve(null);
            return;
        }
        byte[] bArrBytesFrom = JsonSerializationUtils.bytesFrom(ScopesAdapter.getInstance().getOptions().getSerializer(), iLogger, viewHierarchySnapshotViewHierarchy);
        if (bArrBytesFrom == null) {
            iLogger.log(SentryLevel.ERROR, "Could not serialize ViewHierarchy.", new Object[0]);
            promise.resolve(null);
        } else {
            if (bArrBytesFrom.length < 1) {
                iLogger.log(SentryLevel.ERROR, "Got empty bytes array after serializing ViewHierarchy.", new Object[0]);
                promise.resolve(null);
                return;
            }
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            for (byte b : bArrBytesFrom) {
                writableNativeArray.pushInt(b);
            }
            promise.resolve(writableNativeArray);
        }
    }

    private static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            logger.log(SentryLevel.WARNING, "Error getting package info.", new Object[0]);
            return null;
        }
    }

    public void setUser(final ReadableMap readableMap, final ReadableMap readableMap2) {
        Sentry.configureScope(new ScopeCallback() { // from class: io.sentry.react.RNSentryModuleImpl$$ExternalSyntheticLambda0
            private static final byte[] $$a = {SignedBytes.MAX_POWER_OF_TWO, -32, 40, -103};
            private static final int $$b = 15;
            private static int $10 = 0;
            private static int $11 = 1;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static long onPostMessage = -4102671437011825967L;
            private static char[] IPostMessageService = {38302, 38391, 38394, 38272, 38376, 38358, 38356, 38351, 38355, 38361, 38397, 38285, 38379, 38364, 38356, 38353, 38390, 38274, 38393, 38272, 38376, 38358, 38356, 38351, 38355, 38361, 38391, 38280, 38399, 38390, 38379, 38285, 38356, 38351, 38355, 38361, 38397, 38285, 38379, 38364, 38356, 38353, 38378, 38399, 38390, 38379, 38272, 38274, 38393, 38272, 38376, 38358, 38356, 38351, 38355, 38361, 38391, 38280, 38391, 38394, 38272, 38376, 38349, 38232, 38240, 38242, 38237, 38240, 38261, 38166, 38269, 38237, 38245, 38242, 38237, 38240, 38245, 38150, 38149, 38248, 38242, 38238, 38243, 38245, 38247, 38195, 38062, 38067, 38069, 38066, 38066, 38210, 38208, 38067, 38069, 38067, 38066, 38071, 38209, 38234, 38220, 38059, 38218, 38216, 38056, 38064, 38061, 38056, 38059, 38064, 38225, 38224, 38067, 38061, 38057, 38062, 38064, 38066, 38284, 38361, 38355, 38365, 38375, 38365, 38360, 38361, 38363, 38361, 38376, 38372, 38357, 38357, 38337, 38232, 38250, 38249, 38247, 38278, 38346, 38350, 38362, 38356, 38356, 38392, 38383, 38355, 38363, 38355, 38348, 38354, 38353, 38345, 38380, 38391, 38363, 38356, 38348, 38382, 38279, 38379, 38356, 38348, 38353, 38360, 38360, 38361, 38365, 38357, 38355, 38378, 38380, 38365, 38356, 38350, 38193, 38051, 38047, 38048, 38045, 38036, 38039, 38060, 38057, 38043, 38049, 38276, 38339, 38203, 38202, 38340, 38343, 38340, 38342, 38352, 38382, 38369, 38336, 38367, 38365, 38205, 38341, 38338, 38205, 38336, 38341, 38374, 38373, 38344, 38338, 38206, 38339, 38341, 38343, 38355, 38239, 38241, 38249, 38245, 38244, 38244, 38237, 38232, 38240, 38263, 38157, 38167, 38169, 38149, 38152, 38266, 38232, 38240, 38247, 38147, 38264, 38229, 38237, 38238, 38232, 38239, 38247, 38239, 38267, 38148, 38240, 38240, 38246, 38207, 38079, 38073, 38210, 38209, 38074, 38079, 38078, 38209, 38074, 38079, 38239, 38259, 38261, 38245, 38212, 38072, 38074, 38077, 38079, 38073, 38077, 38079};

            /* JADX WARN: Code duplicated, block: B:10:0x0021  */
            /* JADX WARN: Code duplicated, block: B:8:0x001b  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0029). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$c(byte r6, short r7, short r8) {
                /*
                    byte[] r0 = io.sentry.react.RNSentryModuleImpl$$ExternalSyntheticLambda0.$$a
                    int r6 = r6 + 65
                    int r8 = r8 * 3
                    int r1 = r8 + 1
                    int r7 = r7 * 4
                    int r7 = r7 + 4
                    byte[] r1 = new byte[r1]
                    r2 = 0
                    if (r0 != 0) goto L15
                    r3 = r7
                    r6 = r8
                    r4 = r2
                    goto L29
                L15:
                    r3 = r2
                L16:
                    byte r4 = (byte) r6
                    r1[r3] = r4
                    if (r3 != r8) goto L21
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r1, r2)
                    return r6
                L21:
                    r4 = r0[r7]
                    int r3 = r3 + 1
                    r5 = r3
                    r3 = r7
                    r7 = r4
                    r4 = r5
                L29:
                    int r7 = -r7
                    int r6 = r6 + r7
                    int r7 = r3 + 1
                    r3 = r4
                    goto L16
                */
                throw new UnsupportedOperationException("Method not decompiled: io.sentry.react.RNSentryModuleImpl$$ExternalSyntheticLambda0.$$c(byte, short, short):java.lang.String");
            }

            @Override // io.sentry.ScopeCallback
            public final void run(IScope iScope) {
                RNSentryModuleImpl.lambda$setUser$5(readableMap, readableMap2, iScope);
            }

            private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
                int i2 = 2 % 2;
                onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
                char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
                onrelationshipvalidationresult.e = 4;
                while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
                    int i3 = $10 + b.f40o;
                    $11 = i3 % 128;
                    int i4 = i3 % 2;
                    onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
                    int i5 = onrelationshipvalidationresult.e;
                    try {
                        Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                        if (objAccessartificialFrame == null) {
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 27, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 30690), 188 - View.MeasureSpec.getSize(0), -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                        }
                        cArrAccessartificialFrame[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                        if (objAccessartificialFrame2 == null) {
                            byte b = (byte) 0;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(33 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), 1483 - TextUtils.getCapsMode("", 0, 0), -1940971975, false, $$c((byte) 46, b, b), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                        int i6 = $10 + 61;
                        $11 = i6 % 128;
                        int i7 = i6 % 2;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                objArr[0] = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
            }

            private static void b(boolean z, byte[] bArr, int[] iArr, Object[] objArr) throws Throwable {
                int i = 2 % 2;
                onPostMessage onpostmessage = new onPostMessage();
                int i2 = 0;
                int i3 = iArr[0];
                int i4 = 1;
                int i5 = iArr[1];
                int i6 = iArr[2];
                int i7 = iArr[3];
                char[] cArr = IPostMessageService;
                if (cArr != null) {
                    int length = cArr.length;
                    char[] cArr2 = new char[length];
                    int i8 = $10 + 3;
                    $11 = i8 % 128;
                    int i9 = i8 % 2;
                    int i10 = 0;
                    while (i10 < length) {
                        try {
                            Object[] objArr2 = new Object[i4];
                            objArr2[i2] = Integer.valueOf(cArr[i10]);
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                            if (objAccessartificialFrame == null) {
                                byte b = (byte) i2;
                                byte b2 = b;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(10 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (Process.myTid() >> 22), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 1561, 178318710, false, $$c(b, b2, b2), new Class[]{Integer.TYPE});
                            }
                            cArr2[i10] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            i10++;
                            i2 = 0;
                            i4 = 1;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    cArr = cArr2;
                }
                char[] cArr3 = new char[i5];
                System.arraycopy(cArr, i3, cArr3, 0, i5);
                if (bArr != null) {
                    char[] cArr4 = new char[i5];
                    onpostmessage.a = 0;
                    char c = 0;
                    while (onpostmessage.a < i5) {
                        if (bArr[onpostmessage.a] == 1) {
                            int i11 = onpostmessage.a;
                            Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                            if (objAccessartificialFrame2 == null) {
                                int absoluteGravity = 23 - Gravity.getAbsoluteGravity(0, 0);
                                char cGreen = (char) Color.green(0);
                                int scrollBarSize = 2441 - (ViewConfiguration.getScrollBarSize() >> 8);
                                byte b3 = (byte) ($$b >>> 2);
                                byte b4 = (byte) (b3 - 3);
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(absoluteGravity, cGreen, scrollBarSize, -850656813, false, $$c(b3, b4, b4), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            cArr4[i11] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        } else {
                            int i12 = onpostmessage.a;
                            try {
                                Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-314759072);
                                if (objAccessartificialFrame3 == null) {
                                    byte b5 = (byte) 0;
                                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 10, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), 1561 - ((byte) KeyEvent.getModifierMetaStateMask()), 1918398056, false, $$c((byte) 57, b5, b5), new Class[]{Integer.TYPE, Integer.TYPE});
                                }
                                cArr4[i12] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                            } catch (Throwable th2) {
                                Throwable cause2 = th2.getCause();
                                if (cause2 == null) {
                                    throw th2;
                                }
                                throw cause2;
                            }
                        }
                        c = cArr4[onpostmessage.a];
                        Object[] objArr5 = {onpostmessage, onpostmessage};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(898481158);
                        if (objAccessartificialFrame4 == null) {
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(22 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (Color.rgb(0, 0, 0) + 16806579), 214 - TextUtils.lastIndexOf("", '0', 0, 0), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    }
                    cArr3 = cArr4;
                }
                if (i7 > 0) {
                    int i13 = $10 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                    $11 = i13 % 128;
                    if (i13 % 2 == 0) {
                        char[] cArr5 = new char[i5];
                        System.arraycopy(cArr3, 1, cArr5, 0, i5);
                        System.arraycopy(cArr5, 1, cArr3, i5 >> i7, i7);
                        System.arraycopy(cArr5, i7, cArr3, 1, i5 >>> i7);
                    } else {
                        char[] cArr6 = new char[i5];
                        System.arraycopy(cArr3, 0, cArr6, 0, i5);
                        int i14 = i5 - i7;
                        System.arraycopy(cArr6, 0, cArr3, i14, i7);
                        System.arraycopy(cArr6, i7, cArr3, 0, i14);
                    }
                }
                if (z) {
                    int i15 = $10 + 117;
                    $11 = i15 % 128;
                    int i16 = i15 % 2;
                    char[] cArr7 = new char[i5];
                    int i17 = 0;
                    while (true) {
                        onpostmessage.a = i17;
                        if (onpostmessage.a >= i5) {
                            break;
                        }
                        cArr7[onpostmessage.a] = cArr3[(i5 - onpostmessage.a) - 1];
                        i17 = onpostmessage.a + 1;
                    }
                    cArr3 = cArr7;
                }
                if (i6 > 0) {
                    int i18 = 0;
                    while (true) {
                        onpostmessage.a = i18;
                        if (onpostmessage.a >= i5) {
                            break;
                        }
                        cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                        i18 = onpostmessage.a + 1;
                    }
                }
                objArr[0] = new String(cArr3);
            }

            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] accessartificialFrame(android.content.Context r21, int r22, int r23) {
                /*
                    Method dump skipped, instruction units count: 2752
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: io.sentry.react.RNSentryModuleImpl$$ExternalSyntheticLambda0.accessartificialFrame(android.content.Context, int, int):java.lang.Object[]");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUser$5(ReadableMap readableMap, ReadableMap readableMap2, IScope iScope) {
        if (readableMap == null && readableMap2 == null) {
            iScope.setUser(null);
            return;
        }
        User user = new User();
        if (readableMap != null) {
            if (readableMap.hasKey("email")) {
                user.setEmail(readableMap.getString("email"));
            }
            if (readableMap.hasKey("id")) {
                user.setId(readableMap.getString("id"));
            }
            if (readableMap.hasKey("username")) {
                user.setUsername(readableMap.getString("username"));
            }
            if (readableMap.hasKey("ip_address")) {
                user.setIpAddress(readableMap.getString("ip_address"));
            }
        }
        if (readableMap2 != null) {
            HashMap map = new HashMap();
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap2.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                String string = readableMap2.getString(strNextKey);
                if (string != null) {
                    map.put(strNextKey, string);
                }
            }
            user.setData(map);
        }
        iScope.setUser(user);
    }

    public void addBreadcrumb(final ReadableMap readableMap) {
        Sentry.configureScope(new ScopeCallback() { // from class: io.sentry.react.RNSentryModuleImpl$$ExternalSyntheticLambda10
            @Override // io.sentry.ScopeCallback
            public final void run(IScope iScope) {
                RNSentryModuleImpl.lambda$addBreadcrumb$6(readableMap, iScope);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addBreadcrumb$6(ReadableMap readableMap, IScope iScope) {
        iScope.addBreadcrumb(RNSentryBreadcrumb.fromMap(readableMap));
        String currentScreenFrom = RNSentryBreadcrumb.getCurrentScreenFrom(readableMap);
        if (currentScreenFrom != null) {
            iScope.setScreen(currentScreenFrom);
        }
    }

    public void clearBreadcrumbs() {
        Sentry.configureScope(new ScopeCallback() { // from class: io.sentry.react.RNSentryModuleImpl$$ExternalSyntheticLambda6
            @Override // io.sentry.ScopeCallback
            public final void run(IScope iScope) {
                iScope.clearBreadcrumbs();
            }
        });
    }

    public void popTimeToDisplayFor(String str, Promise promise) {
        if (str != null) {
            promise.resolve(RNSentryTimeToDisplay.popTimeToDisplayFor(str));
        } else {
            promise.resolve(null);
        }
    }

    public boolean setActiveSpanId(@Nullable String str) {
        RNSentryTimeToDisplay.setActiveSpanId(str);
        return true;
    }

    public void setExtra(final String str, final String str2) {
        if (str == null || str2 == null) {
            logger.log(SentryLevel.ERROR, "RNSentry.setExtra called with null key or value, can't change extra.", new Object[0]);
        } else {
            Sentry.configureScope(new ScopeCallback() { // from class: io.sentry.react.RNSentryModuleImpl$$ExternalSyntheticLambda3
                @Override // io.sentry.ScopeCallback
                public final void run(IScope iScope) {
                    iScope.setExtra(str, str2);
                }
            });
        }
    }

    public void setContext(final String str, final ReadableMap readableMap) {
        if (str == null) {
            logger.log(SentryLevel.ERROR, "RNSentry.setContext called with null key, can't change context.", new Object[0]);
        } else {
            Sentry.configureScope(new ScopeCallback() { // from class: io.sentry.react.RNSentryModuleImpl$$ExternalSyntheticLambda9
                @Override // io.sentry.ScopeCallback
                public final void run(IScope iScope) {
                    RNSentryModuleImpl.lambda$setContext$9(readableMap, str, iScope);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setContext$9(ReadableMap readableMap, String str, IScope iScope) {
        if (readableMap == null) {
            iScope.removeContexts(str);
        } else {
            iScope.setContexts(str, readableMap.toHashMap());
        }
    }

    public void setTag(final String str, final String str2) {
        Sentry.configureScope(new ScopeCallback() { // from class: io.sentry.react.RNSentryModuleImpl$$ExternalSyntheticLambda5
            @Override // io.sentry.ScopeCallback
            public final void run(IScope iScope) {
                iScope.setTag(str, str2);
            }
        });
    }

    public void closeNativeSdk(Promise promise) {
        Sentry.close();
        disableNativeFramesTracking();
        promise.resolve(Boolean.TRUE);
    }

    public void enableNativeFramesTracking() {
        boolean zCheckAndroidXAvailability = checkAndroidXAvailability();
        this.androidXAvailable = zCheckAndroidXAvailability;
        if (zCheckAndroidXAvailability) {
            this.frameMetricsAggregator = new FrameMetricsAggregator();
            Activity currentActivity = getCurrentActivity();
            FrameMetricsAggregator frameMetricsAggregator = this.frameMetricsAggregator;
            if (frameMetricsAggregator != null && currentActivity != null) {
                try {
                    frameMetricsAggregator.add(currentActivity);
                    logger.log(SentryLevel.INFO, "FrameMetricsAggregator installed.", new Object[0]);
                    return;
                } catch (Throwable unused) {
                    logger.log(SentryLevel.ERROR, "Error adding Activity to frameMetricsAggregator.", new Object[0]);
                    return;
                }
            }
            logger.log(SentryLevel.INFO, "currentActivity isn't available.", new Object[0]);
            return;
        }
        logger.log(SentryLevel.WARNING, "androidx.core' isn't available as a dependency.", new Object[0]);
    }

    public void disableNativeFramesTracking() {
        if (isFrameMetricsAggregatorAvailable()) {
            this.frameMetricsAggregator.stop();
            this.frameMetricsAggregator = null;
        }
    }

    public void getNewScreenTimeToDisplay(Promise promise) {
        RNSentryTimeToDisplay.getTimeToDisplay(promise, this.dateProvider);
    }

    private String getProfilingTracesDirPath() {
        if (this.cacheDirPath == null) {
            this.cacheDirPath = new File(getReactApplicationContext().getCacheDir(), "sentry/react").getAbsolutePath();
        }
        File file = new File(this.cacheDirPath, "profiling_trace");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    private void initializeAndroidProfiler() {
        if (this.executorService == null) {
            this.executorService = new SentryExecutorService();
        }
        String profilingTracesDirPath = getProfilingTracesDirPath();
        int micros = ((int) TimeUnit.SECONDS.toMicros(1L)) / this.profilingTracesHz;
        ReactApplicationContext reactApplicationContext = this.reactApplicationContext;
        ILogger iLogger = logger;
        this.androidProfiler = new AndroidProfiler(profilingTracesDirPath, micros, new SentryFrameMetricsCollector(reactApplicationContext, iLogger, buildInfo), this.executorService, iLogger);
    }

    public WritableMap startProfiling(boolean z) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (this.androidProfiler == null && z) {
            initializeAndroidProfiler();
        }
        try {
            HermesSamplingProfiler.enable();
            AndroidProfiler androidProfiler = this.androidProfiler;
            if (androidProfiler != null) {
                androidProfiler.start();
            }
            writableNativeMap.putBoolean(Session.JsonKeys.STARTED, true);
        } catch (Throwable th) {
            writableNativeMap.putBoolean(Session.JsonKeys.STARTED, false);
            writableNativeMap.putString("error", th.toString());
        }
        return writableNativeMap;
    }

    public WritableMap stopProfiling() {
        boolean zDelete;
        boolean zIsDebug = ScopesAdapter.getInstance().getOptions().isDebug();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        File fileCreateTempFile = null;
        try {
            AndroidProfiler androidProfiler = this.androidProfiler;
            AndroidProfiler.ProfileEndData profileEndDataEndAndCollect = androidProfiler != null ? androidProfiler.endAndCollect(false, null) : null;
            HermesSamplingProfiler.disable();
            fileCreateTempFile = File.createTempFile("sampling-profiler-trace", ".cpuprofile", this.reactApplicationContext.getCacheDir());
            if (zIsDebug) {
                logger.log(SentryLevel.INFO, "Profile saved to: " + fileCreateTempFile.getAbsolutePath(), new Object[0]);
            }
            HermesSamplingProfiler.dumpSampledTraceToFile(fileCreateTempFile.getPath());
            writableNativeMap.putString("profile", readStringFromFile(fileCreateTempFile));
            if (profileEndDataEndAndCollect != null) {
                WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                writableNativeMap2.putString("sampled_profile", Base64.encodeToString(FileUtils.readBytesFromFile(profileEndDataEndAndCollect.traceFile.getPath(), this.maxTraceFileSize), 3));
                writableNativeMap2.putInt(ProfilingTraceData.JsonKeys.ANDROID_API_LEVEL, buildInfo.getSdkInfoVersion());
                writableNativeMap2.putString(ProfilingTraceData.JsonKeys.BUILD_ID, getProguardUuid());
                writableNativeMap.putMap("androidProfile", writableNativeMap2);
            }
            try {
                if (!fileCreateTempFile.delete()) {
                    logger.log(SentryLevel.WARNING, "Profile not deleted from:" + fileCreateTempFile.getAbsolutePath(), new Object[0]);
                }
            } catch (Throwable unused) {
                logger.log(SentryLevel.WARNING, "Profile not deleted from:" + fileCreateTempFile.getAbsolutePath(), new Object[0]);
            }
        } catch (Throwable th) {
            try {
                writableNativeMap.putString("error", th.toString());
                if (fileCreateTempFile != null) {
                    try {
                        if (!zDelete) {
                            logger.log(SentryLevel.WARNING, "Profile not deleted from:" + fileCreateTempFile.getAbsolutePath(), new Object[0]);
                        }
                    } catch (Throwable unused2) {
                        logger.log(SentryLevel.WARNING, "Profile not deleted from:" + fileCreateTempFile.getAbsolutePath(), new Object[0]);
                    }
                }
            } finally {
                if (fileCreateTempFile != null) {
                    try {
                        if (!fileCreateTempFile.delete()) {
                            logger.log(SentryLevel.WARNING, "Profile not deleted from:" + fileCreateTempFile.getAbsolutePath(), new Object[0]);
                        }
                    } catch (Throwable unused3) {
                        logger.log(SentryLevel.WARNING, "Profile not deleted from:" + fileCreateTempFile.getAbsolutePath(), new Object[0]);
                    }
                }
            }
        }
        return writableNativeMap;
    }

    private String getProguardUuid() throws Throwable {
        if (this.isProguardDebugMetaLoaded) {
            return this.proguardUuid;
        }
        this.isProguardDebugMetaLoaded = true;
        List<Properties> listLoadDebugMeta = new AssetsDebugMetaLoader(getReactApplicationContext(), logger).loadDebugMeta();
        if (listLoadDebugMeta == null) {
            return null;
        }
        Iterator<Properties> it2 = listLoadDebugMeta.iterator();
        while (it2.hasNext()) {
            String proguardUuid = DebugMetaPropertiesApplier.getProguardUuid(it2.next());
            this.proguardUuid = proguardUuid;
            if (proguardUuid != null) {
                logger.log(SentryLevel.INFO, "Proguard uuid found: " + this.proguardUuid, new Object[0]);
                return this.proguardUuid;
            }
        }
        logger.log(SentryLevel.WARNING, "No proguard uuid found in debug meta properties file!", new Object[0]);
        return null;
    }

    private String readStringFromFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\n');
                } else {
                    String string = sb.toString();
                    bufferedReader.close();
                    return string;
                }
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void fetchNativeLogAttributes(Promise promise) {
        fetchNativeLogContexts(promise, ScopesAdapter.getInstance().getOptions(), getReactApplicationContext().getApplicationContext(), InternalSentrySdk.getCurrentScope());
    }

    public void fetchNativeDeviceContexts(Promise promise) {
        fetchNativeDeviceContexts(promise, ScopesAdapter.getInstance().getOptions(), getReactApplicationContext().getApplicationContext(), InternalSentrySdk.getCurrentScope());
    }

    protected void fetchNativeDeviceContexts(Promise promise, @NotNull SentryOptions sentryOptions, @Nullable Context context, @Nullable IScope iScope) {
        if (!(sentryOptions instanceof SentryAndroidOptions)) {
            promise.resolve(null);
            return;
        }
        if (context == null) {
            promise.resolve(null);
            return;
        }
        if (iScope != null) {
            Iterator<Breadcrumb> it2 = iScope.getBreadcrumbs().iterator();
            while (it2.hasNext()) {
                if ("react-native".equals(it2.next().getOrigin())) {
                    it2.remove();
                }
            }
        }
        promise.resolve(RNSentryMapConverter.convertToWritable(InternalSentrySdk.serializeScope(context, (SentryAndroidOptions) sentryOptions, iScope)));
    }

    protected void fetchNativeLogContexts(Promise promise, @NotNull SentryOptions sentryOptions, @Nullable Context context, @Nullable IScope iScope) {
        if (!(sentryOptions instanceof SentryAndroidOptions) || context == null) {
            promise.resolve(null);
            return;
        }
        Object obj = InternalSentrySdk.serializeScope(context, (SentryAndroidOptions) sentryOptions, iScope).get("contexts");
        if (!(obj instanceof Map)) {
            promise.resolve(null);
            return;
        }
        Map map = (Map) obj;
        HashMap map2 = new HashMap();
        if (map.containsKey(OperatingSystem.TYPE)) {
            map2.put(OperatingSystem.TYPE, map.get(OperatingSystem.TYPE));
        }
        if (map.containsKey("device")) {
            map2.put("device", map.get("device"));
        }
        map2.put("release", sentryOptions.getRelease());
        HashMap map3 = new HashMap();
        map3.put("contexts", map2);
        promise.resolve(RNSentryMapConverter.convertToWritable(map3));
    }

    public void fetchNativeSdkInfo(Promise promise) {
        SdkVersion sdkVersion = ScopesAdapter.getInstance().getOptions().getSdkVersion();
        if (sdkVersion == null) {
            promise.resolve(null);
            return;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("name", sdkVersion.getName());
        writableNativeMap.putString("version", sdkVersion.getVersion());
        promise.resolve(writableNativeMap);
    }

    public String fetchNativePackageName() {
        return this.packageInfo.packageName;
    }

    public void getDataFromUri(String str, Promise promise) {
        try {
            InputStream inputStreamOpenInputStream = getReactApplicationContext().getContentResolver().openInputStream(Uri.parse(str));
            try {
                if (inputStreamOpenInputStream == null) {
                    String str2 = "File not found for uri: " + str;
                    logger.log(SentryLevel.ERROR, str2, new Object[0]);
                    promise.reject(new Exception(str2));
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                        return;
                    }
                    return;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStreamOpenInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                WritableArray writableArrayCreateArray = Arguments.createArray();
                for (byte b : byteArray) {
                    writableArrayCreateArray.pushInt(b & 255);
                }
                promise.resolve(writableArrayCreateArray);
                inputStreamOpenInputStream.close();
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            String str3 = "Error reading uri: " + str + ": " + e.getMessage();
            logger.log(SentryLevel.ERROR, str3, new Object[0]);
            promise.reject(new Exception(str3));
        }
    }

    public void encodeToBase64(ReadableArray readableArray, Promise promise) {
        byte[] bArr = new byte[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            bArr[i] = (byte) readableArray.getInt(i);
        }
        promise.resolve(android.util.Base64.encodeToString(bArr, 0));
    }

    public void crashedLastRun(Promise promise) {
        promise.resolve(Sentry.isCrashedLastRun());
    }

    private void setEventOriginTag(SentryEvent sentryEvent) {
        SdkVersion sdk = sentryEvent.getSdk();
        if (sdk != null) {
            String name = sdk.getName();
            name.hashCode();
            if (name.equals("sentry.java.android.react-native")) {
                setEventEnvironmentTag(sentryEvent, SentryBaseEvent.DEFAULT_PLATFORM);
            } else if (name.equals("sentry.native.android.react-native")) {
                setEventEnvironmentTag(sentryEvent, "native");
            }
        }
    }

    private void setEventEnvironmentTag(SentryEvent sentryEvent, String str) {
        sentryEvent.setTag("event.origin", "android");
        sentryEvent.setTag("event.environment", str);
    }

    private void addPackages(SentryEvent sentryEvent, SdkVersion sdkVersion) {
        SdkVersion sdk = sentryEvent.getSdk();
        if (sdk == null || !"sentry.javascript.react-native".equals(sdk.getName()) || sdkVersion == null) {
            return;
        }
        Set<SentryPackage> packageSet = sdkVersion.getPackageSet();
        if (packageSet != null) {
            for (SentryPackage sentryPackage : packageSet) {
                sdk.addPackage(sentryPackage.getName(), sentryPackage.getVersion());
            }
        }
        Set<String> integrationSet = sdkVersion.getIntegrationSet();
        if (integrationSet != null) {
            Iterator<String> it2 = integrationSet.iterator();
            while (it2.hasNext()) {
                sdk.addIntegration(it2.next());
            }
        }
        sentryEvent.setSdk(sdk);
    }

    private boolean isFrameMetricsAggregatorAvailable() {
        return this.androidXAvailable && this.frameMetricsAggregator != null;
    }

    public static String getURLFromDSN(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            URI uri = new URI(str);
            return uri.getScheme() + "://" + uri.getHost();
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    protected void trySetIgnoreErrors(SentryAndroidOptions sentryAndroidOptions, ReadableMap readableMap) {
        ReadableArray array = readableMap.hasKey("ignoreErrorsRegex") ? readableMap.getArray("ignoreErrorsRegex") : null;
        ReadableArray array2 = readableMap.hasKey("ignoreErrorsStr") ? readableMap.getArray("ignoreErrorsStr") : null;
        if (array == null && array2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList((array != null ? array.size() : 0) + (array2 != null ? array2.size() : 0));
        if (array != null) {
            for (int i = 0; i < array.size(); i++) {
                arrayList.add(array.getString(i));
            }
        }
        if (array2 != null) {
            for (int i2 = 0; i2 < array2.size(); i2++) {
                arrayList.add(SentryOptions.DEFAULT_PROPAGATION_TARGETS + Pattern.quote(array2.getString(i2)) + SentryOptions.DEFAULT_PROPAGATION_TARGETS);
            }
        }
        sentryAndroidOptions.setIgnoredErrors(arrayList);
    }
}
