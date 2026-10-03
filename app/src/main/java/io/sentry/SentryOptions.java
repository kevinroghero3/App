package io.sentry;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.horcrux.svg.TextLayoutAlgorithm;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.backpressure.IBackpressureMonitor;
import io.sentry.backpressure.NoOpBackpressureMonitor;
import io.sentry.cache.IEnvelopeCache;
import io.sentry.cache.PersistingScopeObserver;
import io.sentry.clientreport.ClientReportRecorder;
import io.sentry.clientreport.DiscardReason;
import io.sentry.clientreport.IClientReportRecorder;
import io.sentry.clientreport.NoOpClientReportRecorder;
import io.sentry.internal.debugmeta.IDebugMetaLoader;
import io.sentry.internal.debugmeta.NoOpDebugMetaLoader;
import io.sentry.internal.gestures.GestureTargetLocator;
import io.sentry.internal.modules.IModulesLoader;
import io.sentry.internal.modules.NoOpModulesLoader;
import io.sentry.internal.viewhierarchy.ViewHierarchyExporter;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.ITransportGate;
import io.sentry.transport.NoOpEnvelopeCache;
import io.sentry.transport.NoOpTransportGate;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.LazyEvaluator;
import io.sentry.util.LoadClass;
import io.sentry.util.Platform;
import io.sentry.util.SampleRateUtils;
import io.sentry.util.StringUtils;
import io.sentry.util.thread.IThreadChecker;
import io.sentry.util.thread.NoOpThreadChecker;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.net.ssl.SSLSocketFactory;
import o.ArtificialStackFrames;
import o._CREATION;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class SentryOptions {
    static final SentryLevel DEFAULT_DIAGNOSTIC_LEVEL = SentryLevel.DEBUG;
    private static final String DEFAULT_ENVIRONMENT = "production";
    public static final String DEFAULT_PROPAGATION_TARGETS = ".*";
    private boolean attachServerName;
    private boolean attachStacktrace;
    private boolean attachThreads;
    private IBackpressureMonitor backpressureMonitor;
    private BeforeBreadcrumbCallback beforeBreadcrumb;
    private BeforeEnvelopeCallback beforeEnvelopeCallback;
    private BeforeSendCallback beforeSend;
    private BeforeSendCallback beforeSendFeedback;
    private BeforeSendReplayCallback beforeSendReplay;
    private BeforeSendTransactionCallback beforeSendTransaction;
    private final Set<String> bundleIds;
    private String cacheDirPath;
    private boolean captureOpenTelemetryEvents;
    IClientReportRecorder clientReportRecorder;
    private CompositePerformanceCollector compositePerformanceCollector;
    private IConnectionStatusProvider connectionStatusProvider;
    private int connectionTimeoutMillis;
    private final List<String> contextTags;
    private IContinuousProfiler continuousProfiler;
    private Cron cron;
    private final LazyEvaluator<SentryDateProvider> dateProvider;
    private long deadlineTimeout;
    private boolean debug;
    private IDebugMetaLoader debugMetaLoader;
    private ScopeType defaultScopeType;
    private final List<String> defaultTracePropagationTargets;
    private SentryLevel diagnosticLevel;
    private String dist;
    private String distinctId;
    private String dsn;
    private String dsnHash;
    private boolean enableAppStartProfiling;
    private boolean enableAutoSessionTracking;
    private boolean enableBackpressureHandling;
    private boolean enableDeduplication;
    private boolean enableExternalConfiguration;
    private boolean enablePrettySerializationOutput;
    private boolean enableScopePersistence;
    private boolean enableScreenTracking;
    private boolean enableShutdownHook;
    private boolean enableSpotlight;
    private boolean enableTimeToFullDisplayTracing;
    private boolean enableUncaughtExceptionHandler;
    private boolean enableUserInteractionBreadcrumbs;
    private boolean enableUserInteractionTracing;
    private boolean enabled;
    private IEnvelopeCache envelopeDiskCache;
    private final LazyEvaluator<IEnvelopeReader> envelopeReader;
    private String environment;
    private final List<EventProcessor> eventProcessors;
    private ISentryExecutorService executorService;
    private final ExperimentalOptions experimental;
    private ILogger fatalLogger;
    private SentryFeedbackOptions feedbackOptions;
    private long flushTimeoutMillis;
    private boolean forceInit;
    private FullyDisplayedReporter fullyDisplayedReporter;
    private final List<GestureTargetLocator> gestureTargetLocators;
    private Boolean globalHubMode;
    private Long idleTimeout;
    private List<FilterString> ignoredCheckIns;
    private List<FilterString> ignoredErrors;
    private final Set<Class<? extends Throwable>> ignoredExceptionsForType;
    private List<FilterString> ignoredSpanOrigins;
    private List<FilterString> ignoredTransactions;
    private final List<String> inAppExcludes;
    private final List<String> inAppIncludes;
    private InitPriority initPriority;
    private Instrumenter instrumenter;
    private final List<Integration> integrations;
    private volatile TracesSampler internalTracesSampler;
    protected final AutoClosableReentrantLock lock;
    private ILogger logger;
    private Logs logs;
    private long maxAttachmentSize;
    private int maxBreadcrumbs;
    private int maxCacheItems;
    private int maxDepth;
    private int maxQueueSize;
    private RequestSize maxRequestBodySize;
    private int maxSpans;
    private long maxTraceFileSize;
    private IModulesLoader modulesLoader;
    private final List<IScopeObserver> observers;
    private OnDiscardCallback onDiscard;
    private SentryOpenTelemetryMode openTelemetryMode;
    private final List<IOptionsObserver> optionsObservers;
    private final LazyEvaluator<Dsn> parsedDsn;
    private final List<IPerformanceCollector> performanceCollectors;
    private boolean printUncaughtStackTrace;
    private ProfileLifecycle profileLifecycle;
    private Double profileSessionSampleRate;
    private Double profilesSampleRate;
    private ProfilesSamplerCallback profilesSampler;
    private int profilingTracesHz;
    private String proguardUuid;
    private Proxy proxy;
    private int readTimeoutMillis;
    private String release;
    private ReplayController replayController;
    private Double sampleRate;
    private SdkVersion sdkVersion;
    private boolean sendClientReports;
    private boolean sendDefaultPii;
    private boolean sendModules;
    private String sentryClientName;
    private final LazyEvaluator<ISerializer> serializer;
    private String serverName;
    private long sessionFlushTimeoutMillis;
    private SentryReplayOptions sessionReplay;
    private long sessionTrackingIntervalMillis;
    private long shutdownTimeoutMillis;
    private ISocketTagger socketTagger;
    private ISpanFactory spanFactory;
    private String spotlightConnectionUrl;
    private SSLSocketFactory sslSocketFactory;
    private boolean startProfilerOnAppStart;
    private final Map<String, String> tags;
    private IThreadChecker threadChecker;
    private boolean traceOptionsRequests;
    private List<String> tracePropagationTargets;
    private boolean traceSampling;
    private Double tracesSampleRate;
    private TracesSamplerCallback tracesSampler;
    private ITransactionProfiler transactionProfiler;
    private ITransportFactory transportFactory;
    private ITransportGate transportGate;
    private IVersionDetector versionDetector;
    private final List<ViewHierarchyExporter> viewHierarchyExporters;

    /* JADX INFO: loaded from: classes6.dex */
    public interface BeforeBreadcrumbCallback {
        Breadcrumb execute(@NotNull Breadcrumb breadcrumb, @NotNull Hint hint);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface BeforeEmitMetricCallback {
        boolean execute(@NotNull String str, @Nullable Map<String, String> map);
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface BeforeEnvelopeCallback {
        void execute(@NotNull SentryEnvelope sentryEnvelope, @Nullable Hint hint);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface BeforeSendCallback {
        SentryEvent execute(@NotNull SentryEvent sentryEvent, @NotNull Hint hint);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface BeforeSendReplayCallback {
        SentryReplayEvent execute(@NotNull SentryReplayEvent sentryReplayEvent, @NotNull Hint hint);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface BeforeSendTransactionCallback {
        SentryTransaction execute(@NotNull SentryTransaction sentryTransaction, @NotNull Hint hint);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface OnDiscardCallback {
        void execute(@NotNull DiscardReason discardReason, @NotNull DataCategory dataCategory, @NotNull Long l);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface ProfilesSamplerCallback {
        Double sample(@NotNull SamplingContext samplingContext);
    }

    /* JADX INFO: loaded from: classes3.dex */
    public enum RequestSize {
        NONE,
        SMALL,
        MEDIUM,
        ALWAYS
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface TracesSamplerCallback {
        Double sample(@NotNull SamplingContext samplingContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Dsn lambda$new$0() {
        return new Dsn(this.dsn);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Proxy {
        private String host;
        private String pass;
        private String port;
        private java.net.Proxy.Type type;
        private String user;
        private static final byte[] $$c = {91, 80, 41, -1};
        private static final int $$d = 20;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {SignedBytes.MAX_POWER_OF_TWO, -32, 40, -103, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, -50, 50, Ascii.SO};
        private static final int $$b = 27;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] _CREATION = {6559, 13436, 16962, 36936, 44577, 64523, 2578, 22692, 30461, 34013, 53928, 57518, 16011, 19820, 39778, 43268, 51069, 5437, 8968, 28942, 36843, 56794, 60354, 35633, 42719, 53498, 723, 15510, 28346, 39090, 51787, 58453, 5755, 16410, 29211, 44073, 57284, 2551, 15340, 22000, 34709, 6559, 13436, 16962, 36936, 44577, 64523, 2578, 22692, 30461, 34013, 53928, 57518, 16011, 19820, 39778, 43268, 51022, 5439, 9032, 28987, 36862, 56786, 60378, 14755, 22461, 26003, 45170, 52851, 7233, 10796, 30751, 38404, 42008, 62205, 6552, 13438, 16967, 36957, 44605, 6609, 13431, 16978, 36953, 44641, 64523, 2584, 22755, 30442, 33949, 53930, 57526, 16005, 19814, 39739, 43342, 51035, 5424, 8979, 28957, 36841, 56771, 60372, 14758, 22459, 26076, 45172, 52857, 6540, 13437, 16904, 36958, 44587, 64512, 2563, 22765, 30457, 34003, 53924, 57526, 16011, 45602};
        private static long _BOUNDARY = -2127264539286359022L;

        /* JADX WARN: Code duplicated, block: B:10:0x0027  */
        /* JADX WARN: Code duplicated, block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0029). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(short r5, short r6, short r7) {
            /*
                int r6 = r6 * 2
                int r0 = r6 + 1
                int r7 = r7 * 2
                int r7 = 3 - r7
                int r5 = r5 + 103
                byte[] r1 = io.sentry.SentryOptions.Proxy.$$c
                byte[] r0 = new byte[r0]
                r2 = -1
                if (r1 != 0) goto L14
                r3 = r6
                r5 = r7
                goto L29
            L14:
                r4 = r7
                r7 = r5
                r5 = r4
            L17:
                int r2 = r2 + 1
                byte r3 = (byte) r7
                r0[r2] = r3
                int r5 = r5 + 1
                if (r2 != r6) goto L27
                java.lang.String r5 = new java.lang.String
                r6 = 0
                r5.<init>(r0, r6)
                return r5
            L27:
                r3 = r1[r5]
            L29:
                int r3 = -r3
                int r7 = r7 + r3
                goto L17
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryOptions.Proxy.$$e(short, short, short):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        /* JADX WARN: Code duplicated, block: B:8:0x0019  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0027). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void a(byte r7, byte r8, int r9, java.lang.Object[] r10) {
            /*
                int r7 = r7 + 2
                byte[] r0 = io.sentry.SentryOptions.Proxy.$$a
                int r8 = r8 + 4
                int r9 = r9 + 66
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L11
                r3 = r7
                r9 = r8
                r4 = r2
                goto L27
            L11:
                r3 = r2
            L12:
                int r4 = r3 + 1
                byte r5 = (byte) r9
                r1[r3] = r5
                if (r4 != r7) goto L21
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L21:
                r3 = r0[r8]
                r6 = r9
                r9 = r8
                r8 = r3
                r3 = r6
            L27:
                int r3 = r3 + r8
                int r8 = r3 + (-5)
                int r9 = r9 + 1
                r3 = r4
                r6 = r9
                r9 = r8
                r8 = r6
                goto L12
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryOptions.Proxy.a(byte, byte, int, java.lang.Object[]):void");
        }

        private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
            int i3 = 2;
            int i4 = 2 % 2;
            _CREATION _creation = new _CREATION();
            long[] jArr = new long[i2];
            _creation.b = 0;
            while (_creation.b < i2) {
                int i5 = $11 + 123;
                $10 = i5 % 128;
                int i6 = i5 % i3;
                int i7 = _creation.b;
                try {
                    Object[] objArr2 = {Integer.valueOf(_CREATION[i + i7])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame == null) {
                        int iBlue = Color.blue(0) + 8;
                        char c2 = (char) (9279 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1977;
                        byte b = (byte) (-$$c[3]);
                        byte b2 = (byte) (b - 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iBlue, c2, keyRepeatTimeout, 1113883676, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    try {
                        Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i7), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 3;
                            byte b4 = (byte) (b3 - 3);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(29 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (Color.argb(0, 0, 0, 0) + 49362), TextUtils.indexOf("", "", 0) + 684, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                        }
                        jArr[i7] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                        try {
                            Object[] objArr4 = {_creation, _creation};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                            if (objAccessartificialFrame3 == null) {
                                int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 26;
                                char c3 = (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30068);
                                int iAlpha = 816 - Color.alpha(0);
                                byte b5 = (byte) ($$c[3] + 1);
                                byte b6 = b5;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c3, iAlpha, 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                            i3 = 2;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            }
            char[] cArr = new char[i2];
            _creation.b = 0;
            while (_creation.b < i2) {
                cArr[_creation.b] = (char) jArr[_creation.b];
                try {
                    Object[] objArr5 = {_creation, _creation};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame4 == null) {
                        int keyRepeatTimeout2 = 25 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        char cIndexOf = (char) (TextUtils.indexOf("", "", 0, 0) + 30068);
                        int iLastIndexOf2 = 815 - TextUtils.lastIndexOf("", '0');
                        byte b7 = (byte) ($$c[3] + 1);
                        byte b8 = b7;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout2, cIndexOf, iLastIndexOf2, 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    int i8 = $10 + 49;
                    $11 = i8 % 128;
                    int i9 = i8 % 2;
                } catch (Throwable th4) {
                    Throwable cause4 = th4.getCause();
                    if (cause4 == null) {
                        throw th4;
                    }
                    throw cause4;
                }
            }
            String str = new String(cArr);
            int i10 = $10 + 107;
            $11 = i10 % 128;
            if (i10 % 2 != 0) {
                objArr[0] = str;
            } else {
                Object obj = null;
                obj.hashCode();
                throw null;
            }
        }

        public Proxy() {
            this(null, null, null, null, null);
        }

        public Proxy(@Nullable String str, @Nullable String str2) {
            this(str, str2, null, null, null);
        }

        public Proxy(@Nullable String str, @Nullable String str2, @Nullable java.net.Proxy.Type type) {
            this(str, str2, type, null, null);
        }

        public Proxy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this(str, str2, null, str3, str4);
        }

        public Proxy(@Nullable String str, @Nullable String str2, @Nullable java.net.Proxy.Type type, @Nullable String str3, @Nullable String str4) {
            this.host = str;
            this.port = str2;
            this.type = type;
            this.user = str3;
            this.pass = str4;
        }

        public String getHost() {
            return this.host;
        }

        public void setHost(@Nullable String str) {
            this.host = str;
        }

        public String getPort() {
            return this.port;
        }

        public void setPort(@Nullable String str) {
            this.port = str;
        }

        public String getUser() {
            return this.user;
        }

        public void setUser(@Nullable String str) {
            this.user = str;
        }

        public String getPass() {
            return this.pass;
        }

        public void setPass(@Nullable String str) {
            this.pass = str;
        }

        public java.net.Proxy.Type getType() {
            return this.type;
        }

        public void setType(@Nullable java.net.Proxy.Type type) {
            this.type = type;
        }

        /* JADX WARN: Code duplicated, block: B:37:0x053a A[PHI: r25
  0x053a: PHI (r25v2 int) = (r25v1 int), (r25v13 int) binds: [B:31:0x04e3, B:36:0x0538] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:39:0x0540  */
        /* JADX WARN: Code duplicated, block: B:85:0x0974  */
        public static Object[] CoroutineDebuggingKt(Context context, int i, int i2, int i3) throws Throwable {
            Object[] objArr;
            int i4;
            int i5;
            boolean zEquals;
            int i6;
            int i7;
            int i8;
            int i9 = 2 % 2;
            int i10 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
            int i11 = i10 % 128;
            artificialFrame = i11;
            char c = 0;
            if (i10 % 2 == 0) {
                int i12 = 58 / 0;
            }
            int i13 = (i11 & 49) + (i11 | 49);
            int i14 = i13 % 128;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i14;
            int i15 = i13 % 2;
            int i16 = ((i14 | b.f40o) << 1) - (i14 ^ b.f40o);
            artificialFrame = i16 % 128;
            int i17 = i16 % 2;
            if (context == null) {
                int i18 = (i14 ^ 121) + ((i14 & 121) << 1);
                artificialFrame = i18 % 128;
                int i19 = i18 % 2;
                Object[] objArr2 = {new int[]{i}, new int[]{i}, new int[]{(i | i) & (~(i & i))}, null};
                int i20 = ~i;
                int i21 = (-120974004) + (((~((-363779386) | i20)) | 614844389) * 519) + (((~(i20 | (-285872153))) | (~(900716541 | i))) * (-519)) + (((~(i | 614844389)) | 363779385) * 519);
                int i22 = (i21 ^ i) | (i21 & i);
                int i23 = (i21 * 628) + ((i22 | (i22 ^ (-1))) * (-627));
                int i24 = ~i21;
                int i25 = (i23 - (~(-(-((~((i24 & i) | (i24 ^ i))) * (-627)))))) - 1;
                int i26 = ~i;
                int i27 = ~((i26 & i21) | (i26 ^ i21));
                int i28 = ~i;
                int i29 = (i3 - (~(-(-(i25 + (((i28 & i27) | (i27 ^ i28)) * 627)))))) - 1;
                int i30 = i29 << 13;
                int i31 = (i29 | i30) & (~(i29 & i30));
                int i32 = i31 ^ (i31 >>> 17);
                int i33 = i32 << 5;
                return objArr2;
            }
            int i34 = i14 + 31;
            artificialFrame = i34 % 128;
            int i35 = i34 % 2;
            try {
                char pressedStateDuration = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                int touchSlop = ViewConfiguration.getTouchSlop() >> 8;
                int i36 = -TextUtils.getTrimmedLength("");
                int i37 = i36 * (-519);
                int i38 = (i37 & 11983) + (i37 | 11983);
                int i39 = ~i36;
                int i40 = (i39 ^ (-24)) | (i39 & (-24));
                int i41 = ~i;
                int i42 = -(-(((~((i ^ 23) | (i & 23))) | (~((i40 ^ i41) | (i40 & i41)))) * 520));
                int i43 = (i38 & i42) + (i42 | i38);
                int i44 = (i36 ^ i) | (i36 & i);
                int i45 = -(-(((~(((-24) ^ i41) | ((-24) & i41))) | (~i44)) * (-1040)));
                int i46 = (i43 ^ i45) + ((i45 & i43) << 1);
                int i47 = ~i36;
                int i48 = ~((i47 & i41) | (i47 ^ i41));
                int i49 = ~(((-24) ^ i36) | (i36 & (-24)));
                int i50 = (i46 - (~(-(-((((i48 & i49) | (i48 ^ i49)) | (~i44)) * 520))))) - 1;
                Object[] objArr3 = new Object[1];
                b(pressedStateDuration, touchSlop, i50, objArr3);
                Class<?> cls = Class.forName((String) objArr3[0]);
                int iNormalizeMetaState = KeyEvent.normalizeMetaState(0);
                int i51 = ~iNormalizeMetaState;
                int i52 = ~(37544 | i51);
                int i53 = ~((i51 ^ i) | (i51 & i));
                int i54 = ((iNormalizeMetaState * 284) - 10587408) + (((i52 & i53) | (i52 ^ i53)) * (-283)) + ((~((iNormalizeMetaState & (-37545)) | ((-37545) ^ iNormalizeMetaState))) * 283);
                int i55 = (-37545) | i51;
                int i56 = artificialFrame + 121;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i56 % 128;
                int i57 = i56 % 2;
                char c2 = (char) ((i54 - (~(283 * (~((i55 & i) | (i55 ^ i)))))) - 1);
                int i58 = 23 - (~(-(-TextUtils.lastIndexOf("", '0', 0))));
                int i59 = -View.MeasureSpec.getMode(0);
                int i60 = (i59 & 18) + (i59 | 18);
                Object[] objArr4 = new Object[1];
                b(c2, i58, i60, objArr4);
                Object objInvoke = cls.getMethod((String) objArr4[0], null).invoke(context, null);
                char c3 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                int i61 = -View.resolveSizeAndState(0, 0, 0);
                int i62 = ((i61 | 41) << 1) - (i61 ^ 41);
                int i63 = -View.resolveSizeAndState(0, 0, 0);
                int i64 = i63 * (-661);
                int i65 = ((i64 | (-22474)) << 1) - (i64 ^ (-22474));
                int i66 = ~i;
                int i67 = ~i63;
                int i68 = -(-(((~((i67 ^ (-35)) | (i67 & (-35)))) | i66) * 1324));
                int i69 = (((i65 | i68) << 1) - (i68 ^ i65)) + (((~((i63 ^ i) | (i63 & i))) | (~((i ^ 34) | (i & 34)))) * (-1324));
                int i70 = ~((i67 ^ 34) | (i67 & 34));
                int i71 = artificialFrame;
                int i72 = (i71 ^ 29) + ((i71 & 29) << 1);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i72 % 128;
                int i73 = i72 % 2;
                int i74 = ~((i63 & (-35)) | ((-35) ^ i63));
                int i75 = i69 + (662 * ((i74 & i70) | (i70 ^ i74)));
                Object[] objArr5 = new Object[1];
                b(c3, i62, i75, objArr5);
                Class<?> cls2 = Class.forName((String) objArr5[0]);
                char c4 = (char) (0 - (~(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)))));
                int i76 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                int iMediaBrowserCompatItemCallback = TextLayoutAlgorithm.LayoutInput.MediaBrowserCompatItemCallback();
                int i77 = ~iMediaBrowserCompatItemCallback;
                int i78 = (((i76 * 960) - 145692) - (~(((~((i76 ^ iMediaBrowserCompatItemCallback) | (i76 & iMediaBrowserCompatItemCallback))) | (~(((-77) ^ i77) | ((-77) & i77)))) * 959))) - 1;
                int i79 = ~((-77) | iMediaBrowserCompatItemCallback);
                int i80 = ~((i77 & i76) | (i77 ^ i76));
                int i81 = (((i78 ^ 73843) + ((73843 & i78) << 1)) - (~(-(-(((i79 & i80) | (i79 ^ i80)) * 959))))) - 1;
                int minimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity() >> 16;
                int i82 = (minimumFlingVelocity * (-501)) + 2515;
                int i83 = ~(((-6) ^ i) | ((-6) & i));
                int i84 = ~((minimumFlingVelocity ^ 5) | (minimumFlingVelocity & 5));
                int i85 = -(-(((i83 ^ i84) | (i83 & i84)) * (-502)));
                int i86 = (i82 ^ i85) + ((i82 & i85) << 1);
                int i87 = (~(((-6) & i66) | ((-6) ^ i66) | minimumFlingVelocity)) * (-502);
                int i88 = ~minimumFlingVelocity;
                int i89 = (((i86 & i87) + (i87 | i86)) - (~(-(-(((~((i88 & i) | (i88 ^ i))) | (-6)) * TypedValues.PositionType.TYPE_DRAWPATH))))) - 1;
                Object[] objArr6 = new Object[1];
                b(c4, i81, i89, objArr6);
                if ((cls2.getField((String) objArr6[0]).getInt(objInvoke) & 2) != 0) {
                    int i90 = artificialFrame + 107;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i90 % 128;
                    int i91 = i90 % 2;
                    Object[] objArr7 = {new int[]{i}, new int[]{(i & (-2)) | (i41 & 1)}, new int[1], null};
                    int i92 = (int) Runtime.getRuntime().totalMemory();
                    int i93 = (~((-352113993) | i92)) | 72664384;
                    int i94 = ~((~i92) | 905959390);
                    int i95 = 771145886 + ((i93 | i94) * (-470)) + (((~(i92 | (-279449609))) | i94) * 470) + 16;
                    int i96 = (i95 * (-755)) + (i3 * (-755));
                    int i97 = ~i95;
                    int i98 = (~((~i3) | i97)) * 1512;
                    int i99 = (i96 & i98) + (i96 | i98);
                    int i100 = ~i3;
                    int i101 = ~((i100 & i97) | (i97 ^ i100));
                    int i102 = i95 | i3;
                    int i103 = ~((i102 ^ i) | (i102 & i));
                    int i104 = i99 + (((i101 & i103) | (i101 ^ i103)) * (-756)) + ((i102 | i41) * 756);
                    int i105 = i104 << 13;
                    int i106 = (i105 & (~i104)) | ((~i105) & i104);
                    int i107 = i106 >>> 17;
                    int i108 = ((~i106) & i107) | ((~i107) & i106);
                    int i109 = i108 << 5;
                    ((int[]) objArr7[2])[0] = ((~i108) & i109) | ((~i109) & i108);
                    objArr = objArr7;
                } else {
                    int[] iArr = new int[1];
                    objArr = new Object[]{new int[]{i}, new int[]{i}, iArr, null};
                    int i110 = (-1911695090) + (((-899900125) | i) * 376) + (((~(914079017 | i41)) | (-939261950)) * (-376)) + (((~((-914079018) | i)) | 64544757) * 376);
                    int i111 = -(-(i110 * (-67)));
                    int i112 = (i111 << 1) - i111;
                    int i113 = ~i110;
                    int i114 = i113 | ((-1) ^ i113);
                    int i115 = ~((i114 & i66) | (i114 ^ i66));
                    int i116 = ~i110;
                    int i117 = (i115 & i116) | (i115 ^ i116);
                    int i118 = ~((i110 ^ i) | (i110 & i));
                    int i119 = i112 + (((i117 & i118) | (i117 ^ i118)) * (-68));
                    int i120 = ((-1) ^ i66) | i66;
                    int i121 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i122 = (i121 ^ 107) + ((i121 & 107) << 1);
                    artificialFrame = i122 % 128;
                    int i123 = i122 % 2;
                    int i124 = i119 + ((-68) * (~((i120 & i110) | (i120 ^ i110))));
                    int i125 = ~i110;
                    int i126 = ~((i125 & i41) | (i125 ^ i41));
                    int i127 = (i3 - (~(i124 + ((i126 | ((-1) ^ i126)) * 68)))) - 1;
                    int i128 = i121 + 31;
                    artificialFrame = i128 % 128;
                    if (i128 % 2 == 0) {
                        int i129 = i127 % 13;
                        int i130 = ((~i127) & i129) | ((~i129) & i127);
                        int i131 = i130 ^ (i130 >> 36);
                        ((int[]) objArr[5])[0] = i131 ^ (i131 * 2);
                        c = 0;
                    } else {
                        int i132 = i127 << 13;
                        int i133 = ((~i127) & i132) | ((~i132) & i127);
                        int i134 = i133 >>> 17;
                        int i135 = ((~i133) & i134) | ((~i134) & i133);
                        int i136 = i135 << 5;
                        int i137 = (i135 | i136) & (~(i135 & i136));
                        c = 0;
                        iArr[0] = i137;
                    }
                }
                if (((int[]) objArr[1])[c] != i) {
                    return objArr;
                }
                try {
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1330934317);
                    if (objAccessartificialFrame == null) {
                        int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 21;
                        char absoluteGravity = (char) (29754 - Gravity.getAbsoluteGravity(0, 0));
                        int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 1748;
                        i4 = 802081755;
                        byte[] bArr = $$a;
                        Object[] objArr8 = new Object[1];
                        a(bArr[22], bArr[32], bArr[17], objArr8);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(bitsPerPixel, absoluteGravity, tapTimeout, 802081755, false, (String) objArr8[0], new Class[0]);
                    }
                    Set set = (Set) ((Method) objAccessartificialFrame).invoke(null, null);
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-613930663);
                    if (objAccessartificialFrame2 == null) {
                        int jumpTapTimeout = 20 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                        char defaultSize = (char) (29754 - View.getDefaultSize(0, 0));
                        int gidForName = 1747 - Process.getGidForName("");
                        i4 = 1141731153;
                        byte[] bArr2 = $$a;
                        Object[] objArr9 = new Object[1];
                        a(bArr2[22], (byte) (-bArr2[51]), bArr2[8], objArr9);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, defaultSize, gidForName, 1141731153, false, (String) objArr9[0], null);
                    }
                    if (!set.contains(((Field) objAccessartificialFrame2).get(null))) {
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1912765649);
                        if (objAccessartificialFrame3 == null) {
                            int deadChar = 20 - KeyEvent.getDeadChar(0, 0);
                            char cGreen = (char) (Color.green(0) + 29754);
                            int iBlue = Color.blue(0) + 1748;
                            i4 = 312001831;
                            byte[] bArr3 = $$a;
                            Object[] objArr10 = new Object[1];
                            a(bArr3[45], (byte) (-bArr3[7]), bArr3[8], objArr10);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(deadChar, cGreen, iBlue, 312001831, false, (String) objArr10[0], null);
                        }
                        if (set.contains(((Field) objAccessartificialFrame3).get(null))) {
                            if (Build.VERSION.SDK_INT == 30) {
                                int i138 = artificialFrame;
                                int i139 = (i138 ^ 97) + ((i138 & 97) << 1);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i139 % 128;
                                int i140 = i139 % 2;
                                int i141 = (i138 ^ 35) + ((i138 & 35) << 1);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i141 % 128;
                                int i142 = i141 % 2;
                                Object[] objArr11 = {new int[]{i}, new int[]{i}, new int[1], null};
                                int i143 = ~((int) Process.getElapsedCpuTime());
                                int i144 = 746843911 + (((~((-65052207) | i143)) | (-913571569)) * (-983)) + (((~(i143 | (-913571569))) | 873685200) * 983);
                                int iMediaBrowserCompatItemCallback2 = TextLayoutAlgorithm.LayoutInput.MediaBrowserCompatItemCallback();
                                int i145 = i144 * 829;
                                int i146 = ~i144;
                                int i147 = ~(i146 | ((-1) ^ i146));
                                int i148 = ~iMediaBrowserCompatItemCallback2;
                                int i149 = ~((i148 & i144) | (i148 ^ i144));
                                int i150 = ((i147 & i149) | (i147 ^ i149)) * (-828);
                                int i151 = ((i145 | i150) << 1) - (i145 ^ i150);
                                int i152 = ~iMediaBrowserCompatItemCallback2;
                                int i153 = ((i152 & i144) | (i144 ^ i152)) * (-828);
                                int i154 = ((i151 | i153) << 1) - (i153 ^ i151);
                                int i155 = (~i144) * 828;
                                int i156 = -(-((i154 & i155) + (i155 | i154)));
                                int i157 = (i3 ^ i156) + ((i156 & i3) << 1);
                                int i158 = (i157 << 13) ^ i157;
                                int i159 = i158 >>> 17;
                                int i160 = (i158 | i159) & (~(i158 & i159));
                                int i161 = i160 << 5;
                                ((int[]) objArr11[2])[0] = ((~i160) & i161) | ((~i161) & i160);
                                int i162 = artificialFrame;
                                int i163 = (i162 & 95) + (i162 | 95);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i163 % 128;
                                int i164 = i163 % 2;
                                return objArr11;
                            }
                        }
                    } else if (Build.VERSION.SDK_INT == 30) {
                        int i1310 = artificialFrame;
                        int i1311 = (i1310 ^ 97) + ((i1310 & 97) << 1);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i1311 % 128;
                        int i1410 = i1311 % 2;
                        int i1411 = (i1310 ^ 35) + ((i1310 & 35) << 1);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i1411 % 128;
                        int i1412 = i1411 % 2;
                        Object[] objArr12 = {new int[]{i}, new int[]{i}, new int[1], null};
                        int i1413 = ~((int) Process.getElapsedCpuTime());
                        int i1414 = 746843911 + (((~((-65052207) | i1413)) | (-913571569)) * (-983)) + (((~(i1413 | (-913571569))) | 873685200) * 983);
                        int iMediaBrowserCompatItemCallback3 = TextLayoutAlgorithm.LayoutInput.MediaBrowserCompatItemCallback();
                        int i1415 = i1414 * 829;
                        int i1416 = ~i1414;
                        int i1417 = ~(i1416 | ((-1) ^ i1416));
                        int i1418 = ~iMediaBrowserCompatItemCallback3;
                        int i1419 = ~((i1418 & i1414) | (i1418 ^ i1414));
                        int i1510 = ((i1417 & i1419) | (i1417 ^ i1419)) * (-828);
                        int i1511 = ((i1415 | i1510) << 1) - (i1415 ^ i1510);
                        int i1512 = ~iMediaBrowserCompatItemCallback3;
                        int i1513 = ((i1512 & i1414) | (i1414 ^ i1512)) * (-828);
                        int i1514 = ((i1511 | i1513) << 1) - (i1513 ^ i1511);
                        int i1515 = (~i1414) * 828;
                        int i1516 = -(-((i1514 & i1515) + (i1515 | i1514)));
                        int i1517 = (i3 ^ i1516) + ((i1516 & i3) << 1);
                        int i1518 = (i1517 << 13) ^ i1517;
                        int i1519 = i1518 >>> 17;
                        int i165 = (i1518 | i1519) & (~(i1518 & i1519));
                        int i166 = i165 << 5;
                        ((int[]) objArr12[2])[0] = ((~i165) & i166) | ((~i166) & i165);
                        int i167 = artificialFrame;
                        int i168 = (i167 & 95) + (i167 | 95);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i168 % 128;
                        int i169 = i168 % 2;
                        return objArr12;
                    }
                    if ((i2 & 32) == 0) {
                        try {
                            try {
                                if (Build.VERSION.SDK_INT > 33) {
                                    char c5 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                                    int i170 = -(Process.myPid() >> 22);
                                    int i171 = (i170 & 80) + (i170 | 80);
                                    int i172 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                                    int i173 = artificialFrame;
                                    int i174 = (i173 & 7) + (i173 | 7);
                                    int i175 = i174 % 128;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i175;
                                    int i176 = i174 % 2;
                                    int i177 = i172 * 569;
                                    int i178 = ((i177 | 15932) << 1) - (i177 ^ 15932);
                                    int i179 = ~i172;
                                    int i180 = ~(i179 | (-29));
                                    int i181 = ~i172;
                                    int i182 = ~((i181 ^ i41) | (i181 & i41));
                                    int i183 = (i180 ^ i182) | (i180 & i182);
                                    int i184 = ~(((-29) ^ i41) | ((-29) & i41));
                                    int i185 = -(-(((i183 ^ i184) | (i184 & i183)) * (-1136)));
                                    int i186 = (i178 ^ i185) + ((i185 & i178) << 1);
                                    int i187 = i175 + 13;
                                    artificialFrame = i187 % 128;
                                    int i188 = i187 % 2;
                                    int i189 = (i41 ^ i172) | (i41 & i172);
                                    int i190 = (-568) * ((~(((-29) ^ i) | ((-29) & i))) | (~(i181 | i)) | (~((i189 & 28) | (i189 ^ 28))));
                                    int i191 = ((i186 | i190) << 1) - (i190 ^ i186);
                                    int i192 = ~((i172 & i66) | (i66 ^ i172));
                                    int i193 = ~((i66 ^ 28) | (i66 & 28));
                                    int i194 = (i192 & i193) | (i192 ^ i193);
                                    int i195 = i179 | (-29);
                                    int i196 = ~((i195 & i) | (i195 ^ i));
                                    int i197 = ((i194 & i196) | (i194 ^ i196)) * 568;
                                    int i198 = (i191 & i197) + (i197 | i191);
                                    Object[] objArr13 = new Object[1];
                                    b(c5, i171, i198, objArr13);
                                    try {
                                        Object[] objArr14 = {(String) objArr13[0]};
                                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(267846469);
                                        if (objAccessartificialFrame4 == null) {
                                            int i199 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 17;
                                            char c6 = (char) (24343 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                                            int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 2014;
                                            byte[] bArr4 = $$a;
                                            byte b = bArr4[32];
                                            Object[] objArr15 = new Object[1];
                                            a(b, (byte) (b | 65), (byte) (-bArr4[7]), objArr15);
                                            i4 = maximumFlingVelocity;
                                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i199, c6, i4, -1869462195, false, (String) objArr15[0], new Class[]{String.class});
                                        }
                                        long jLongValue = ((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr14)).longValue();
                                        long j = -1139209131;
                                        long j2 = 521;
                                        long j3 = -1;
                                        long j4 = j ^ j3;
                                        i4 = i41;
                                        long j5 = i;
                                        long j6 = (((long) (-520)) * j) + (((long) 522) * jLongValue) + ((((j4 | jLongValue) | j5) ^ j3) * j2);
                                        long j7 = ((jLongValue ^ j3) | j) ^ j3;
                                        long j8 = j6 + (((long) (-1042)) * j7) + (j2 * ((((j4 | (j5 ^ j3)) | jLongValue) ^ j3) | j7)) + ((long) (-172422845));
                                        int i200 = ((int) (j8 >> 32)) & (145444074 + (((~((-1746043052) | i4)) | (~((-308816641) | i))) * (-272)) + (((~(325922576 | i)) | (-2071965628)) * (-272)) + (((~((-325922577) | i)) | 1763148987) * 272));
                                        int i201 = (int) j8;
                                        int iMyTid = Process.myTid();
                                        int i202 = ~iMyTid;
                                        int i203 = i201 & (916180360 + (((~(i202 | (-766212099))) | (-671014312)) * (-1042)) + (((-766212099) | iMyTid) * 521) + (((~(iMyTid | 671014311)) | (-805305768) | (~(i202 | (-631920643)))) * 521));
                                        if (((i200 & i203) | (i200 ^ i203)) == 1) {
                                            int i204 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            int i205 = ((i204 | 101) << 1) - (i204 ^ 101);
                                            artificialFrame = i205 % 128;
                                            zEquals = !(i205 % 2 == 0);
                                            if (zEquals) {
                                                Object[] objArr16 = {new int[]{i}, new int[]{i ^ 10}, new int[]{(i | i) & (~(i & i))}, null};
                                                int i206 = 884058368 + (((~(i4 | 963083113)) | 8913044) * (-108)) + (((~((-15540662) | i)) | 956455496 | (~(i4 | 15540661))) * 54) + ((i | 956455496) * 54) + 16;
                                                int i207 = ((i3 | i206) << 1) - (i3 ^ i206);
                                                int i208 = i207 ^ (i207 << 13);
                                                int i209 = i208 >>> 17;
                                                int i210 = (i208 | i209) & (~(i208 & i209));
                                                int i211 = i210 << 5;
                                                int i212 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                int i213 = (i212 ^ 61) + ((i212 & 61) << 1);
                                                artificialFrame = i213 % 128;
                                                int i214 = i213 % 2;
                                                return objArr16;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        Throwable cause = th.getCause();
                                        if (cause != null) {
                                            throw cause;
                                        }
                                        throw th;
                                    }
                                } else {
                                    i4 = i41;
                                    char cIndexOf = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0));
                                    int i215 = -TextUtils.indexOf((CharSequence) "", '0');
                                    int i216 = (i215 ^ 107) + ((i215 & 107) << 1);
                                    int i217 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                                    int iMediaBrowserCompatItemCallback4 = TextLayoutAlgorithm.LayoutInput.MediaBrowserCompatItemCallback();
                                    int i218 = artificialFrame + 75;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i218 % 128;
                                    int i219 = i218 % 2;
                                    int i220 = (i217 * (-665)) + 4342;
                                    int i221 = ~i217;
                                    int i222 = -(-(i221 * (-333)));
                                    int i223 = (i220 ^ i222) + ((i220 & i222) << 1);
                                    int i224 = ~iMediaBrowserCompatItemCallback4;
                                    int i225 = ~((i221 & i224) | (i221 ^ i224));
                                    int i226 = ~(iMediaBrowserCompatItemCallback4 | 13);
                                    int i227 = ~i217;
                                    int i228 = ~((i227 & iMediaBrowserCompatItemCallback4) | (i227 ^ iMediaBrowserCompatItemCallback4));
                                    int i229 = ~((i224 ^ 13) | (i224 & 13));
                                    int i230 = i223 + (((i225 & i226) | (i225 ^ i226)) * 333) + (((i228 & i229) | (i228 ^ i229)) * 333);
                                    Object[] objArr17 = new Object[1];
                                    b(cIndexOf, i216, i230, objArr17);
                                    try {
                                        Object[] objArr18 = {(String) objArr17[0]};
                                        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                        if (objAccessartificialFrame5 == null) {
                                            int iLastIndexOf = 22 - TextUtils.lastIndexOf("", '0', 0, 0);
                                            char c7 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                            int modifierMetaStateMask = 2440 - ((byte) KeyEvent.getModifierMetaStateMask());
                                            Object[] objArr19 = new Object[1];
                                            a((byte) ($$b & 5), (byte) 66, $$a[32], objArr19);
                                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c7, modifierMetaStateMask, 954751276, false, (String) objArr19[0], new Class[]{String.class});
                                        }
                                        Object objInvoke2 = ((Method) objAccessartificialFrame5).invoke(null, objArr18);
                                        int iGreen = Color.green(0);
                                        int i231 = (iGreen * 569) - (-25043397);
                                        int i232 = artificialFrame;
                                        int i233 = i232 + 19;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i233 % 128;
                                        if (i233 % 2 != 0) {
                                            int i234 = ~iGreen;
                                            int i235 = ~((i234 & (-44014)) | (i234 ^ (-44014)));
                                            int i236 = ~iGreen;
                                            int i237 = ~((i236 & i66) | (i236 ^ i66));
                                            int i238 = (i235 & i237) | (i235 ^ i237);
                                            int i239 = ~((-44014) | i4);
                                            int i240 = -((i238 & i239) | (i238 ^ i239));
                                            i5 = i231 / (((i240 | (-1136)) << 1) - (i240 ^ (-1136)));
                                        } else {
                                            int i241 = ~iGreen;
                                            int i242 = ((~((i241 & i66) | (i241 ^ i66))) | (~((i241 ^ (-44014)) | (i241 & (-44014)))) | (~(((-44014) ^ i4) | ((-44014) & i4)))) * (-1136);
                                            i5 = (i231 | i242) + (i231 & i242);
                                        }
                                        int i243 = ~iGreen;
                                        int i244 = ~((i243 & i) | (i243 ^ i));
                                        int i245 = ~(((-44014) ^ i) | ((-44014) & i));
                                        int i246 = (i244 & i245) | (i244 ^ i245);
                                        int i247 = (i4 ^ iGreen) | (i4 & iGreen);
                                        int i248 = (i246 | (~((i247 & 44013) | (i247 ^ 44013)))) * (-568);
                                        int i249 = (i5 ^ i248) + ((i5 & i248) << 1);
                                        int i250 = ~((i4 ^ iGreen) | (i4 & iGreen));
                                        int i251 = ~((i4 ^ 44013) | (i4 & 44013));
                                        int i252 = ~iGreen;
                                        int i253 = (i252 & (-44014)) | (i252 ^ (-44014));
                                        int i254 = (i250 & i251) | (i250 ^ i251) | (~((i253 & i) | (i253 ^ i)));
                                        int i255 = ((i232 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1) - (i232 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i255 % 128;
                                        int i256 = i255 % 2;
                                        int i257 = -(-(568 * i254));
                                        char c8 = (char) ((i249 ^ i257) + ((i257 & i249) << 1));
                                        int i258 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                                        Object[] objArr20 = new Object[1];
                                        b(c8, (i258 & 121) + (i258 | 121), -TextUtils.lastIndexOf("", '0', 0, 0), objArr20);
                                        zEquals = objInvoke2.equals((String) objArr20[0]);
                                        int i259 = artificialFrame + 29;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i259 % 128;
                                        int i260 = i259 % 2;
                                        if (zEquals) {
                                            Object[] objArr110 = {new int[]{i}, new int[]{i ^ 10}, new int[]{(i210 | i211) & (~(i210 & i211))}, null};
                                            int i2010 = 884058368 + (((~(i4 | 963083113)) | 8913044) * (-108)) + (((~((-15540662) | i)) | 956455496 | (~(i4 | 15540661))) * 54) + ((i | 956455496) * 54) + 16;
                                            int i2011 = ((i3 | i2010) << 1) - (i3 ^ i2010);
                                            int i2012 = i2011 ^ (i2011 << 13);
                                            int i2013 = i2012 >>> 17;
                                            int i2110 = (i2012 | i2013) & (~(i2012 & i2013));
                                            int i2111 = i2110 << 5;
                                            int i2112 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            int i2113 = (i2112 ^ 61) + ((i2112 & 61) << 1);
                                            artificialFrame = i2113 % 128;
                                            int i2114 = i2113 % 2;
                                            return objArr110;
                                        }
                                    } catch (Throwable th2) {
                                        Throwable cause2 = th2.getCause();
                                        if (cause2 != null) {
                                            throw cause2;
                                        }
                                        throw th2;
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                            i4 = i41;
                        }
                    } else {
                        i4 = i41;
                    }
                    Object[] objArr21 = {new int[]{i}, new int[]{i}, new int[1], null};
                    int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                    int i261 = ~((-39911460) | iElapsedRealtime);
                    int i262 = ~iElapsedRealtime;
                    int i263 = (-1707083442) + ((i261 | (~((-554864713) | i262))) * 920) + (((~((-383847604) | i262)) | 39911459) * 920) + (((~(iElapsedRealtime | (-554864713))) | (~((-39911460) | i262)) | (~((-343936145) | iElapsedRealtime))) * 920);
                    int i264 = -(-(i263 * 517));
                    int i265 = ~i263;
                    int i266 = ~((i265 & i) | (i265 ^ i));
                    int i267 = i4;
                    int i268 = ~i267;
                    int i269 = (i266 & i268) | (i266 ^ i268);
                    int i270 = ~((i267 & i263) | (i267 ^ i263));
                    int i271 = ((i269 & i270) | (i269 ^ i270)) * (-516);
                    int i272 = (i264 ^ i271) + ((i264 & i271) << 1);
                    int i273 = ~i263;
                    int i274 = ~(i273 | ((-1) ^ i273) | i);
                    int i275 = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
                    artificialFrame = i275 % 128;
                    if (i275 % 2 == 0) {
                        int i276 = ((-1) ^ i66) | i66;
                        int i277 = -(i274 | (~((i276 & i263) | (i276 ^ i263))));
                        int i278 = ~(((-1) ^ i263) | i263);
                        int i279 = ~(i66 | i263);
                        i6 = (i272 << ((i277 ^ 516) + ((i277 & 516) << 1))) << (516 >> ((i278 & i279) | (i278 ^ i279)));
                    } else {
                        int i280 = -(-((i274 | (~(((-1) ^ i263) | i263))) * 516));
                        int i281 = (i272 ^ i280) + ((i280 & i272) << 1);
                        int i282 = ((~(((-1) ^ i263) | i263)) | i270) * 516;
                        i6 = (i282 | i281) + (i281 & i282);
                    }
                    int iMediaBrowserCompatItemCallback5 = TextLayoutAlgorithm.LayoutInput.MediaBrowserCompatItemCallback();
                    int i283 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i284 = (i283 & 95) + (i283 | 95);
                    artificialFrame = i284 % 128;
                    int i285 = i284 % 2;
                    int i286 = i6 * (-716);
                    int i287 = -(-(i3 * 1435));
                    int i288 = (i286 & i287) + (i286 | i287);
                    int i289 = ~i6;
                    int i290 = ((i3 ^ i289) | (i3 & i289)) * (-1434);
                    int i291 = (i288 ^ i290) + ((i290 & i288) << 1);
                    int i292 = ~iMediaBrowserCompatItemCallback5;
                    int i293 = ~((i292 ^ i3) | (i292 & i3));
                    int i294 = (i6 ^ i3) | (i6 & i3);
                    int i295 = ~i294;
                    int i296 = i293 | i295;
                    int i297 = (i283 ^ 13) + ((i283 & 13) << 1);
                    artificialFrame = i297 % 128;
                    if (i297 % 2 == 0) {
                        int i298 = ~i3;
                        int i299 = i289 | i298;
                        int i300 = ~((i299 & iMediaBrowserCompatItemCallback5) | (i299 ^ iMediaBrowserCompatItemCallback5));
                        i7 = i291 << (717 >>> ((i296 & i300) | (i296 ^ i300)));
                        int i301 = ~((i298 & i289) | (i289 ^ i298) | i292);
                        i8 = (i301 & i295) | (i301 ^ i295);
                    } else {
                        int i302 = ~i6;
                        int i303 = ~i3;
                        int i304 = i302 | i303;
                        int i305 = ~((i304 & iMediaBrowserCompatItemCallback5) | (i304 ^ iMediaBrowserCompatItemCallback5));
                        int i306 = -(-(((i305 & i296) | (i296 ^ i305)) * 717));
                        i7 = (i291 & i306) + (i306 | i291);
                        int i307 = (i289 ^ i303) | (i289 & i303);
                        i8 = (~((i307 & i292) | (i307 ^ i292))) | (~i294);
                    }
                    int i308 = ~(i3 | iMediaBrowserCompatItemCallback5);
                    int i309 = (i7 - (~(717 * ((i8 & i308) | (i8 ^ i308))))) - 1;
                    int i310 = i309 << 13;
                    int i311 = (i310 | i309) & (~(i309 & i310));
                    int i312 = i311 ^ (i311 >>> 17);
                    int i313 = i312 << 5;
                    ((int[]) objArr21[2])[0] = (i312 | i313) & (~(i312 & i313));
                    return objArr21;
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 != null) {
                        throw cause3;
                    }
                    throw th3;
                }
            } catch (Throwable th4) {
                Throwable cause4 = th4.getCause();
                if (cause4 != null) {
                    throw cause4;
                }
                throw th4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ISerializer lambda$new$1() {
        return new JsonSerializer(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ IEnvelopeReader lambda$new$2() {
        return new EnvelopeReader(this.serializer.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SentryDateProvider lambda$new$3() {
        return new SentryAutoDateProvider();
    }

    public void addEventProcessor(@NotNull EventProcessor eventProcessor) {
        this.eventProcessors.add(eventProcessor);
    }

    public List<EventProcessor> getEventProcessors() {
        return this.eventProcessors;
    }

    public void addIntegration(@NotNull Integration integration) {
        this.integrations.add(integration);
    }

    public List<Integration> getIntegrations() {
        return this.integrations;
    }

    public String getDsn() {
        return this.dsn;
    }

    Dsn retrieveParsedDsn() throws IllegalArgumentException {
        return this.parsedDsn.getValue();
    }

    public void setDsn(@Nullable String str) {
        this.dsn = str;
        this.parsedDsn.resetValue();
        this.dsnHash = StringUtils.calculateStringHash(this.dsn, this.logger);
    }

    public boolean isDebug() {
        return this.debug;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    public void setLogger(@Nullable ILogger iLogger) {
        this.logger = iLogger == null ? NoOpLogger.getInstance() : new DiagnosticLogger(this, iLogger);
    }

    public ILogger getFatalLogger() {
        return this.fatalLogger;
    }

    public void setFatalLogger(@Nullable ILogger iLogger) {
        if (iLogger == null) {
            iLogger = NoOpLogger.getInstance();
        }
        this.fatalLogger = iLogger;
    }

    public SentryLevel getDiagnosticLevel() {
        return this.diagnosticLevel;
    }

    public void setDiagnosticLevel(@Nullable SentryLevel sentryLevel) {
        if (sentryLevel == null) {
            sentryLevel = DEFAULT_DIAGNOSTIC_LEVEL;
        }
        this.diagnosticLevel = sentryLevel;
    }

    public ISerializer getSerializer() {
        return this.serializer.getValue();
    }

    public void setSerializer(@Nullable ISerializer iSerializer) {
        LazyEvaluator<ISerializer> lazyEvaluator = this.serializer;
        if (iSerializer == null) {
            iSerializer = NoOpSerializer.getInstance();
        }
        lazyEvaluator.setValue(iSerializer);
    }

    public int getMaxDepth() {
        return this.maxDepth;
    }

    public void setMaxDepth(int i) {
        this.maxDepth = i;
    }

    public IEnvelopeReader getEnvelopeReader() {
        return this.envelopeReader.getValue();
    }

    public void setEnvelopeReader(@Nullable IEnvelopeReader iEnvelopeReader) {
        LazyEvaluator<IEnvelopeReader> lazyEvaluator = this.envelopeReader;
        if (iEnvelopeReader == null) {
            iEnvelopeReader = NoOpEnvelopeReader.getInstance();
        }
        lazyEvaluator.setValue(iEnvelopeReader);
    }

    public long getShutdownTimeoutMillis() {
        return this.shutdownTimeoutMillis;
    }

    public void setShutdownTimeoutMillis(long j) {
        this.shutdownTimeoutMillis = j;
    }

    public String getSentryClientName() {
        return this.sentryClientName;
    }

    public void setSentryClientName(@Nullable String str) {
        this.sentryClientName = str;
    }

    public BeforeSendCallback getBeforeSend() {
        return this.beforeSend;
    }

    public void setBeforeSend(@Nullable BeforeSendCallback beforeSendCallback) {
        this.beforeSend = beforeSendCallback;
    }

    public BeforeSendTransactionCallback getBeforeSendTransaction() {
        return this.beforeSendTransaction;
    }

    public void setBeforeSendTransaction(@Nullable BeforeSendTransactionCallback beforeSendTransactionCallback) {
        this.beforeSendTransaction = beforeSendTransactionCallback;
    }

    public BeforeSendCallback getBeforeSendFeedback() {
        return this.beforeSendFeedback;
    }

    public void setBeforeSendFeedback(@Nullable BeforeSendCallback beforeSendCallback) {
        this.beforeSendFeedback = beforeSendCallback;
    }

    public BeforeSendReplayCallback getBeforeSendReplay() {
        return this.beforeSendReplay;
    }

    public void setBeforeSendReplay(@Nullable BeforeSendReplayCallback beforeSendReplayCallback) {
        this.beforeSendReplay = beforeSendReplayCallback;
    }

    public BeforeBreadcrumbCallback getBeforeBreadcrumb() {
        return this.beforeBreadcrumb;
    }

    public void setBeforeBreadcrumb(@Nullable BeforeBreadcrumbCallback beforeBreadcrumbCallback) {
        this.beforeBreadcrumb = beforeBreadcrumbCallback;
    }

    public OnDiscardCallback getOnDiscard() {
        return this.onDiscard;
    }

    public void setOnDiscard(@Nullable OnDiscardCallback onDiscardCallback) {
        this.onDiscard = onDiscardCallback;
    }

    public String getCacheDirPath() {
        String str = this.cacheDirPath;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.dsnHash != null ? new File(this.cacheDirPath, this.dsnHash).getAbsolutePath() : this.cacheDirPath;
    }

    String getCacheDirPathWithoutDsn() {
        String str = this.cacheDirPath;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.cacheDirPath;
    }

    public String getOutboxPath() {
        String cacheDirPath = getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        return new File(cacheDirPath, "outbox").getAbsolutePath();
    }

    public void setCacheDirPath(@Nullable String str) {
        this.cacheDirPath = str;
    }

    public int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    public void setMaxBreadcrumbs(int i) {
        this.maxBreadcrumbs = i;
    }

    public String getRelease() {
        return this.release;
    }

    public void setRelease(@Nullable String str) {
        this.release = str;
    }

    public String getEnvironment() {
        String str = this.environment;
        return str != null ? str : DEFAULT_ENVIRONMENT;
    }

    public void setEnvironment(@Nullable String str) {
        this.environment = str;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setProxy(@Nullable Proxy proxy) {
        this.proxy = proxy;
    }

    public Double getSampleRate() {
        return this.sampleRate;
    }

    public void setSampleRate(Double d) {
        if (!SampleRateUtils.isValidSampleRate(d)) {
            throw new IllegalArgumentException("The value " + d + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
        }
        this.sampleRate = d;
    }

    public Double getTracesSampleRate() {
        return this.tracesSampleRate;
    }

    public void setTracesSampleRate(@Nullable Double d) {
        if (!SampleRateUtils.isValidTracesSampleRate(d)) {
            throw new IllegalArgumentException("The value " + d + " is not valid. Use null to disable or values between 0.0 and 1.0.");
        }
        this.tracesSampleRate = d;
    }

    public TracesSamplerCallback getTracesSampler() {
        return this.tracesSampler;
    }

    public void setTracesSampler(@Nullable TracesSamplerCallback tracesSamplerCallback) {
        this.tracesSampler = tracesSamplerCallback;
    }

    public TracesSampler getInternalTracesSampler() {
        if (this.internalTracesSampler == null) {
            ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
            try {
                if (this.internalTracesSampler == null) {
                    this.internalTracesSampler = new TracesSampler(this);
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
        return this.internalTracesSampler;
    }

    public List<String> getInAppExcludes() {
        return this.inAppExcludes;
    }

    public void addInAppExclude(@NotNull String str) {
        this.inAppExcludes.add(str);
    }

    public List<String> getInAppIncludes() {
        return this.inAppIncludes;
    }

    public void addInAppInclude(@NotNull String str) {
        this.inAppIncludes.add(str);
    }

    public ITransportFactory getTransportFactory() {
        return this.transportFactory;
    }

    public void setTransportFactory(@Nullable ITransportFactory iTransportFactory) {
        if (iTransportFactory == null) {
            iTransportFactory = NoOpTransportFactory.getInstance();
        }
        this.transportFactory = iTransportFactory;
    }

    public String getDist() {
        return this.dist;
    }

    public void setDist(@Nullable String str) {
        this.dist = str;
    }

    public ITransportGate getTransportGate() {
        return this.transportGate;
    }

    public void setTransportGate(@Nullable ITransportGate iTransportGate) {
        if (iTransportGate == null) {
            iTransportGate = NoOpTransportGate.getInstance();
        }
        this.transportGate = iTransportGate;
    }

    public boolean isAttachStacktrace() {
        return this.attachStacktrace;
    }

    public void setAttachStacktrace(boolean z) {
        this.attachStacktrace = z;
    }

    public boolean isAttachThreads() {
        return this.attachThreads;
    }

    public void setAttachThreads(boolean z) {
        this.attachThreads = z;
    }

    public boolean isEnableAutoSessionTracking() {
        return this.enableAutoSessionTracking;
    }

    public void setEnableAutoSessionTracking(boolean z) {
        this.enableAutoSessionTracking = z;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(@Nullable String str) {
        this.serverName = str;
    }

    public boolean isAttachServerName() {
        return this.attachServerName;
    }

    public void setAttachServerName(boolean z) {
        this.attachServerName = z;
    }

    public long getSessionTrackingIntervalMillis() {
        return this.sessionTrackingIntervalMillis;
    }

    public void setSessionTrackingIntervalMillis(long j) {
        this.sessionTrackingIntervalMillis = j;
    }

    public String getDistinctId() {
        return this.distinctId;
    }

    public void setDistinctId(@Nullable String str) {
        this.distinctId = str;
    }

    public long getFlushTimeoutMillis() {
        return this.flushTimeoutMillis;
    }

    public void setFlushTimeoutMillis(long j) {
        this.flushTimeoutMillis = j;
    }

    public boolean isEnableUncaughtExceptionHandler() {
        return this.enableUncaughtExceptionHandler;
    }

    public void setEnableUncaughtExceptionHandler(boolean z) {
        this.enableUncaughtExceptionHandler = z;
    }

    public boolean isPrintUncaughtStackTrace() {
        return this.printUncaughtStackTrace;
    }

    public void setPrintUncaughtStackTrace(boolean z) {
        this.printUncaughtStackTrace = z;
    }

    public ISentryExecutorService getExecutorService() {
        return this.executorService;
    }

    public void setExecutorService(@NotNull ISentryExecutorService iSentryExecutorService) {
        if (iSentryExecutorService != null) {
            this.executorService = iSentryExecutorService;
        }
    }

    public int getConnectionTimeoutMillis() {
        return this.connectionTimeoutMillis;
    }

    public void setConnectionTimeoutMillis(int i) {
        this.connectionTimeoutMillis = i;
    }

    public int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public void setReadTimeoutMillis(int i) {
        this.readTimeoutMillis = i;
    }

    public IEnvelopeCache getEnvelopeDiskCache() {
        return this.envelopeDiskCache;
    }

    public void setEnvelopeDiskCache(@Nullable IEnvelopeCache iEnvelopeCache) {
        if (iEnvelopeCache == null) {
            iEnvelopeCache = NoOpEnvelopeCache.getInstance();
        }
        this.envelopeDiskCache = iEnvelopeCache;
    }

    public int getMaxQueueSize() {
        return this.maxQueueSize;
    }

    public void setMaxQueueSize(int i) {
        if (i > 0) {
            this.maxQueueSize = i;
        }
    }

    public SdkVersion getSdkVersion() {
        return this.sdkVersion;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public void setSslSocketFactory(@Nullable SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public void setSdkVersion(@Nullable SdkVersion sdkVersion) {
        SdkVersion sdkVersion2 = getSessionReplay().getSdkVersion();
        SdkVersion sdkVersion3 = this.sdkVersion;
        if (sdkVersion3 != null && sdkVersion2 != null && sdkVersion3.equals(sdkVersion2)) {
            getSessionReplay().setSdkVersion(sdkVersion);
        }
        this.sdkVersion = sdkVersion;
    }

    public boolean isSendDefaultPii() {
        return this.sendDefaultPii;
    }

    public void setSendDefaultPii(boolean z) {
        this.sendDefaultPii = z;
    }

    public void addScopeObserver(@NotNull IScopeObserver iScopeObserver) {
        this.observers.add(iScopeObserver);
    }

    public List<IScopeObserver> getScopeObservers() {
        return this.observers;
    }

    public PersistingScopeObserver findPersistingScopeObserver() {
        for (IScopeObserver iScopeObserver : this.observers) {
            if (iScopeObserver instanceof PersistingScopeObserver) {
                return (PersistingScopeObserver) iScopeObserver;
            }
        }
        return null;
    }

    public void addOptionsObserver(@NotNull IOptionsObserver iOptionsObserver) {
        this.optionsObservers.add(iOptionsObserver);
    }

    public List<IOptionsObserver> getOptionsObservers() {
        return this.optionsObservers;
    }

    public boolean isEnableExternalConfiguration() {
        return this.enableExternalConfiguration;
    }

    public void setEnableExternalConfiguration(boolean z) {
        this.enableExternalConfiguration = z;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public void setTag(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            this.tags.remove(str);
        } else {
            this.tags.put(str, str2);
        }
    }

    public long getMaxAttachmentSize() {
        return this.maxAttachmentSize;
    }

    public void setMaxAttachmentSize(long j) {
        this.maxAttachmentSize = j;
    }

    public boolean isEnableDeduplication() {
        return this.enableDeduplication;
    }

    public void setEnableDeduplication(boolean z) {
        this.enableDeduplication = z;
    }

    public boolean isTracingEnabled() {
        return (getTracesSampleRate() == null && getTracesSampler() == null) ? false : true;
    }

    public Set<Class<? extends Throwable>> getIgnoredExceptionsForType() {
        return this.ignoredExceptionsForType;
    }

    public void addIgnoredExceptionForType(@NotNull Class<? extends Throwable> cls) {
        this.ignoredExceptionsForType.add(cls);
    }

    boolean containsIgnoredExceptionForType(@NotNull Throwable th) {
        return this.ignoredExceptionsForType.contains(th.getClass());
    }

    public List<FilterString> getIgnoredErrors() {
        return this.ignoredErrors;
    }

    public void setIgnoredErrors(@Nullable List<String> list) {
        if (list == null) {
            this.ignoredErrors = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(new FilterString(str));
            }
        }
        this.ignoredErrors = arrayList;
    }

    public void addIgnoredError(@NotNull String str) {
        if (this.ignoredErrors == null) {
            this.ignoredErrors = new ArrayList();
        }
        this.ignoredErrors.add(new FilterString(str));
    }

    public int getMaxSpans() {
        return this.maxSpans;
    }

    public void setMaxSpans(int i) {
        this.maxSpans = i;
    }

    public boolean isEnableShutdownHook() {
        return this.enableShutdownHook;
    }

    public void setEnableShutdownHook(boolean z) {
        this.enableShutdownHook = z;
    }

    public int getMaxCacheItems() {
        return this.maxCacheItems;
    }

    public void setMaxCacheItems(int i) {
        this.maxCacheItems = i;
    }

    public RequestSize getMaxRequestBodySize() {
        return this.maxRequestBodySize;
    }

    public void setMaxRequestBodySize(@NotNull RequestSize requestSize) {
        this.maxRequestBodySize = requestSize;
    }

    public boolean isTraceSampling() {
        return this.traceSampling;
    }

    @Deprecated
    public void setTraceSampling(boolean z) {
        this.traceSampling = z;
    }

    public long getMaxTraceFileSize() {
        return this.maxTraceFileSize;
    }

    public void setMaxTraceFileSize(long j) {
        this.maxTraceFileSize = j;
    }

    public ITransactionProfiler getTransactionProfiler() {
        return this.transactionProfiler;
    }

    public void setTransactionProfiler(@Nullable ITransactionProfiler iTransactionProfiler) {
        if (this.transactionProfiler != NoOpTransactionProfiler.getInstance() || iTransactionProfiler == null) {
            return;
        }
        this.transactionProfiler = iTransactionProfiler;
    }

    public IContinuousProfiler getContinuousProfiler() {
        return this.continuousProfiler;
    }

    public void setContinuousProfiler(@Nullable IContinuousProfiler iContinuousProfiler) {
        if (this.continuousProfiler != NoOpContinuousProfiler.getInstance() || iContinuousProfiler == null) {
            return;
        }
        this.continuousProfiler = iContinuousProfiler;
    }

    public boolean isProfilingEnabled() {
        Double d = this.profilesSampleRate;
        return (d != null && d.doubleValue() > 0.0d) || this.profilesSampler != null;
    }

    public boolean isContinuousProfilingEnabled() {
        Double d;
        return this.profilesSampleRate == null && this.profilesSampler == null && (d = this.profileSessionSampleRate) != null && d.doubleValue() > 0.0d;
    }

    public ProfilesSamplerCallback getProfilesSampler() {
        return this.profilesSampler;
    }

    public void setProfilesSampler(@Nullable ProfilesSamplerCallback profilesSamplerCallback) {
        this.profilesSampler = profilesSamplerCallback;
    }

    public Double getProfilesSampleRate() {
        return this.profilesSampleRate;
    }

    public void setProfilesSampleRate(@Nullable Double d) {
        if (!SampleRateUtils.isValidProfilesSampleRate(d)) {
            throw new IllegalArgumentException("The value " + d + " is not valid. Use null to disable or values between 0.0 and 1.0.");
        }
        this.profilesSampleRate = d;
    }

    public Double getProfileSessionSampleRate() {
        return this.profileSessionSampleRate;
    }

    public void setProfileSessionSampleRate(@Nullable Double d) {
        if (!SampleRateUtils.isValidContinuousProfilesSampleRate(d)) {
            throw new IllegalArgumentException("The value " + d + " is not valid. Use values between 0.0 and 1.0.");
        }
        this.profileSessionSampleRate = d;
    }

    public ProfileLifecycle getProfileLifecycle() {
        return this.profileLifecycle;
    }

    public void setProfileLifecycle(@NotNull ProfileLifecycle profileLifecycle) {
        this.profileLifecycle = profileLifecycle;
        if (profileLifecycle != ProfileLifecycle.TRACE || isTracingEnabled()) {
            return;
        }
        this.logger.log(SentryLevel.WARNING, "Profiling lifecycle is set to TRACE but tracing is disabled. Profiling will not be started automatically.", new Object[0]);
    }

    public boolean isStartProfilerOnAppStart() {
        return this.startProfilerOnAppStart;
    }

    public void setStartProfilerOnAppStart(boolean z) {
        this.startProfilerOnAppStart = z;
    }

    public long getDeadlineTimeout() {
        return this.deadlineTimeout;
    }

    public void setDeadlineTimeout(long j) {
        this.deadlineTimeout = j;
    }

    public String getProfilingTracesDirPath() {
        String cacheDirPath = getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        return new File(cacheDirPath, "profiling_traces").getAbsolutePath();
    }

    public List<String> getTracePropagationTargets() {
        List<String> list = this.tracePropagationTargets;
        return list == null ? this.defaultTracePropagationTargets : list;
    }

    public void setTracePropagationTargets(@Nullable List<String> list) {
        if (list == null) {
            this.tracePropagationTargets = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.isEmpty()) {
                arrayList.add(str);
            }
        }
        this.tracePropagationTargets = arrayList;
    }

    public String getProguardUuid() {
        return this.proguardUuid;
    }

    public void setProguardUuid(@Nullable String str) {
        this.proguardUuid = str;
    }

    public void addBundleId(@Nullable String str) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            this.bundleIds.add(strTrim);
        }
    }

    public Set<String> getBundleIds() {
        return this.bundleIds;
    }

    public List<String> getContextTags() {
        return this.contextTags;
    }

    public void addContextTag(@NotNull String str) {
        this.contextTags.add(str);
    }

    public Long getIdleTimeout() {
        return this.idleTimeout;
    }

    public void setIdleTimeout(@Nullable Long l) {
        this.idleTimeout = l;
    }

    public boolean isSendClientReports() {
        return this.sendClientReports;
    }

    public void setSendClientReports(boolean z) {
        this.sendClientReports = z;
        if (z) {
            this.clientReportRecorder = new ClientReportRecorder(this);
        } else {
            this.clientReportRecorder = new NoOpClientReportRecorder();
        }
    }

    public boolean isEnableUserInteractionTracing() {
        return this.enableUserInteractionTracing;
    }

    public void setEnableUserInteractionTracing(boolean z) {
        this.enableUserInteractionTracing = z;
    }

    public boolean isEnableUserInteractionBreadcrumbs() {
        return this.enableUserInteractionBreadcrumbs;
    }

    public void setEnableUserInteractionBreadcrumbs(boolean z) {
        this.enableUserInteractionBreadcrumbs = z;
    }

    @Deprecated
    public void setInstrumenter(@NotNull Instrumenter instrumenter) {
        this.instrumenter = instrumenter;
    }

    public Instrumenter getInstrumenter() {
        return this.instrumenter;
    }

    public IClientReportRecorder getClientReportRecorder() {
        return this.clientReportRecorder;
    }

    public IModulesLoader getModulesLoader() {
        return this.modulesLoader;
    }

    public void setModulesLoader(@Nullable IModulesLoader iModulesLoader) {
        if (iModulesLoader == null) {
            iModulesLoader = NoOpModulesLoader.getInstance();
        }
        this.modulesLoader = iModulesLoader;
    }

    public IDebugMetaLoader getDebugMetaLoader() {
        return this.debugMetaLoader;
    }

    public void setDebugMetaLoader(@Nullable IDebugMetaLoader iDebugMetaLoader) {
        if (iDebugMetaLoader == null) {
            iDebugMetaLoader = NoOpDebugMetaLoader.getInstance();
        }
        this.debugMetaLoader = iDebugMetaLoader;
    }

    public List<GestureTargetLocator> getGestureTargetLocators() {
        return this.gestureTargetLocators;
    }

    public void setGestureTargetLocators(@NotNull List<GestureTargetLocator> list) {
        this.gestureTargetLocators.clear();
        this.gestureTargetLocators.addAll(list);
    }

    public final List<ViewHierarchyExporter> getViewHierarchyExporters() {
        return this.viewHierarchyExporters;
    }

    public void setViewHierarchyExporters(@NotNull List<ViewHierarchyExporter> list) {
        this.viewHierarchyExporters.clear();
        this.viewHierarchyExporters.addAll(list);
    }

    public IThreadChecker getThreadChecker() {
        return this.threadChecker;
    }

    public void setThreadChecker(@NotNull IThreadChecker iThreadChecker) {
        this.threadChecker = iThreadChecker;
    }

    public CompositePerformanceCollector getCompositePerformanceCollector() {
        return this.compositePerformanceCollector;
    }

    public void setCompositePerformanceCollector(@NotNull CompositePerformanceCollector compositePerformanceCollector) {
        this.compositePerformanceCollector = compositePerformanceCollector;
    }

    public boolean isEnableTimeToFullDisplayTracing() {
        return this.enableTimeToFullDisplayTracing;
    }

    public void setEnableTimeToFullDisplayTracing(boolean z) {
        this.enableTimeToFullDisplayTracing = z;
    }

    public FullyDisplayedReporter getFullyDisplayedReporter() {
        return this.fullyDisplayedReporter;
    }

    public void setFullyDisplayedReporter(@NotNull FullyDisplayedReporter fullyDisplayedReporter) {
        this.fullyDisplayedReporter = fullyDisplayedReporter;
    }

    public boolean isTraceOptionsRequests() {
        return this.traceOptionsRequests;
    }

    public void setTraceOptionsRequests(boolean z) {
        this.traceOptionsRequests = z;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public boolean isEnablePrettySerializationOutput() {
        return this.enablePrettySerializationOutput;
    }

    public boolean isSendModules() {
        return this.sendModules;
    }

    public void setEnablePrettySerializationOutput(boolean z) {
        this.enablePrettySerializationOutput = z;
    }

    public boolean isEnableAppStartProfiling() {
        return (isProfilingEnabled() || isContinuousProfilingEnabled()) && this.enableAppStartProfiling;
    }

    public void setEnableAppStartProfiling(boolean z) {
        this.enableAppStartProfiling = z;
    }

    public void setSendModules(boolean z) {
        this.sendModules = z;
    }

    public List<FilterString> getIgnoredSpanOrigins() {
        return this.ignoredSpanOrigins;
    }

    public void addIgnoredSpanOrigin(String str) {
        if (this.ignoredSpanOrigins == null) {
            this.ignoredSpanOrigins = new ArrayList();
        }
        this.ignoredSpanOrigins.add(new FilterString(str));
    }

    public void setIgnoredSpanOrigins(@Nullable List<String> list) {
        if (list == null) {
            this.ignoredSpanOrigins = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(new FilterString(str));
            }
        }
        this.ignoredSpanOrigins = arrayList;
    }

    public List<FilterString> getIgnoredCheckIns() {
        return this.ignoredCheckIns;
    }

    public void addIgnoredCheckIn(String str) {
        if (this.ignoredCheckIns == null) {
            this.ignoredCheckIns = new ArrayList();
        }
        this.ignoredCheckIns.add(new FilterString(str));
    }

    public void setIgnoredCheckIns(@Nullable List<String> list) {
        if (list == null) {
            this.ignoredCheckIns = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.isEmpty()) {
                arrayList.add(new FilterString(str));
            }
        }
        this.ignoredCheckIns = arrayList;
    }

    public List<FilterString> getIgnoredTransactions() {
        return this.ignoredTransactions;
    }

    public void addIgnoredTransaction(String str) {
        if (this.ignoredTransactions == null) {
            this.ignoredTransactions = new ArrayList();
        }
        this.ignoredTransactions.add(new FilterString(str));
    }

    public void setIgnoredTransactions(@Nullable List<String> list) {
        if (list == null) {
            this.ignoredTransactions = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(new FilterString(str));
            }
        }
        this.ignoredTransactions = arrayList;
    }

    public SentryDateProvider getDateProvider() {
        return this.dateProvider.getValue();
    }

    public void setDateProvider(@NotNull SentryDateProvider sentryDateProvider) {
        this.dateProvider.setValue(sentryDateProvider);
    }

    public void addPerformanceCollector(@NotNull IPerformanceCollector iPerformanceCollector) {
        this.performanceCollectors.add(iPerformanceCollector);
    }

    public List<IPerformanceCollector> getPerformanceCollectors() {
        return this.performanceCollectors;
    }

    public IConnectionStatusProvider getConnectionStatusProvider() {
        return this.connectionStatusProvider;
    }

    public void setConnectionStatusProvider(@NotNull IConnectionStatusProvider iConnectionStatusProvider) {
        this.connectionStatusProvider = iConnectionStatusProvider;
    }

    public IBackpressureMonitor getBackpressureMonitor() {
        return this.backpressureMonitor;
    }

    public void setBackpressureMonitor(@NotNull IBackpressureMonitor iBackpressureMonitor) {
        this.backpressureMonitor = iBackpressureMonitor;
    }

    public void setEnableBackpressureHandling(boolean z) {
        this.enableBackpressureHandling = z;
    }

    public IVersionDetector getVersionDetector() {
        return this.versionDetector;
    }

    public void setVersionDetector(@NotNull IVersionDetector iVersionDetector) {
        this.versionDetector = iVersionDetector;
    }

    public int getProfilingTracesHz() {
        return this.profilingTracesHz;
    }

    public void setProfilingTracesHz(int i) {
        this.profilingTracesHz = i;
    }

    public boolean isEnableBackpressureHandling() {
        return this.enableBackpressureHandling;
    }

    public long getSessionFlushTimeoutMillis() {
        return this.sessionFlushTimeoutMillis;
    }

    public void setSessionFlushTimeoutMillis(long j) {
        this.sessionFlushTimeoutMillis = j;
    }

    public BeforeEnvelopeCallback getBeforeEnvelopeCallback() {
        return this.beforeEnvelopeCallback;
    }

    public void setBeforeEnvelopeCallback(@Nullable BeforeEnvelopeCallback beforeEnvelopeCallback) {
        this.beforeEnvelopeCallback = beforeEnvelopeCallback;
    }

    public String getSpotlightConnectionUrl() {
        return this.spotlightConnectionUrl;
    }

    public void setSpotlightConnectionUrl(@Nullable String str) {
        this.spotlightConnectionUrl = str;
    }

    public boolean isEnableSpotlight() {
        return this.enableSpotlight;
    }

    public void setEnableSpotlight(boolean z) {
        this.enableSpotlight = z;
    }

    public boolean isEnableScopePersistence() {
        return this.enableScopePersistence;
    }

    public void setEnableScopePersistence(boolean z) {
        this.enableScopePersistence = z;
    }

    public Cron getCron() {
        return this.cron;
    }

    public void setCron(@Nullable Cron cron) {
        this.cron = cron;
    }

    public ExperimentalOptions getExperimental() {
        return this.experimental;
    }

    public ReplayController getReplayController() {
        return this.replayController;
    }

    public void setReplayController(@Nullable ReplayController replayController) {
        if (replayController == null) {
            replayController = NoOpReplayController.getInstance();
        }
        this.replayController = replayController;
    }

    public boolean isEnableScreenTracking() {
        return this.enableScreenTracking;
    }

    public void setEnableScreenTracking(boolean z) {
        this.enableScreenTracking = z;
    }

    public void setDefaultScopeType(@NotNull ScopeType scopeType) {
        this.defaultScopeType = scopeType;
    }

    public ScopeType getDefaultScopeType() {
        return this.defaultScopeType;
    }

    public void setInitPriority(@NotNull InitPriority initPriority) {
        this.initPriority = initPriority;
    }

    public InitPriority getInitPriority() {
        return this.initPriority;
    }

    public void setForceInit(boolean z) {
        this.forceInit = z;
    }

    public boolean isForceInit() {
        return this.forceInit;
    }

    public void setGlobalHubMode(@Nullable Boolean bool) {
        this.globalHubMode = bool;
    }

    public Boolean isGlobalHubMode() {
        return this.globalHubMode;
    }

    public void setOpenTelemetryMode(@NotNull SentryOpenTelemetryMode sentryOpenTelemetryMode) {
        this.openTelemetryMode = sentryOpenTelemetryMode;
    }

    public SentryOpenTelemetryMode getOpenTelemetryMode() {
        return this.openTelemetryMode;
    }

    public SentryReplayOptions getSessionReplay() {
        return this.sessionReplay;
    }

    public void setSessionReplay(@NotNull SentryReplayOptions sentryReplayOptions) {
        this.sessionReplay = sentryReplayOptions;
    }

    public SentryFeedbackOptions getFeedbackOptions() {
        return this.feedbackOptions;
    }

    public void setFeedbackOptions(@NotNull SentryFeedbackOptions sentryFeedbackOptions) {
        this.feedbackOptions = sentryFeedbackOptions;
    }

    public void setCaptureOpenTelemetryEvents(boolean z) {
        this.captureOpenTelemetryEvents = z;
    }

    public boolean isCaptureOpenTelemetryEvents() {
        return this.captureOpenTelemetryEvents;
    }

    public ISocketTagger getSocketTagger() {
        return this.socketTagger;
    }

    public void setSocketTagger(@Nullable ISocketTagger iSocketTagger) {
        if (iSocketTagger == null) {
            iSocketTagger = NoOpSocketTagger.getInstance();
        }
        this.socketTagger = iSocketTagger;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadLazyFields() {
        getSerializer();
        retrieveParsedDsn();
        getEnvelopeReader();
        getDateProvider();
    }

    public static SentryOptions empty() {
        return new SentryOptions(true);
    }

    public SentryOptions() {
        this(false);
    }

    private SentryOptions(boolean z) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.eventProcessors = copyOnWriteArrayList;
        this.ignoredExceptionsForType = new CopyOnWriteArraySet();
        this.ignoredErrors = null;
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.integrations = copyOnWriteArrayList2;
        this.bundleIds = new CopyOnWriteArraySet();
        this.parsedDsn = new LazyEvaluator<>(new LazyEvaluator.Evaluator() { // from class: io.sentry.SentryOptions$$ExternalSyntheticLambda0
            @Override // io.sentry.util.LazyEvaluator.Evaluator
            public final Object evaluate() {
                return this.f$0.lambda$new$0();
            }
        });
        this.shutdownTimeoutMillis = 2000L;
        this.flushTimeoutMillis = 15000L;
        this.sessionFlushTimeoutMillis = 15000L;
        this.logger = NoOpLogger.getInstance();
        this.fatalLogger = NoOpLogger.getInstance();
        this.diagnosticLevel = DEFAULT_DIAGNOSTIC_LEVEL;
        this.serializer = new LazyEvaluator<>(new LazyEvaluator.Evaluator() { // from class: io.sentry.SentryOptions$$ExternalSyntheticLambda1
            @Override // io.sentry.util.LazyEvaluator.Evaluator
            public final Object evaluate() {
                return this.f$0.lambda$new$1();
            }
        });
        this.envelopeReader = new LazyEvaluator<>(new LazyEvaluator.Evaluator() { // from class: io.sentry.SentryOptions$$ExternalSyntheticLambda2
            @Override // io.sentry.util.LazyEvaluator.Evaluator
            public final Object evaluate() {
                return this.f$0.lambda$new$2();
            }
        });
        this.maxDepth = 100;
        this.maxCacheItems = 30;
        this.maxQueueSize = 30;
        this.maxBreadcrumbs = 100;
        this.inAppExcludes = new CopyOnWriteArrayList();
        this.inAppIncludes = new CopyOnWriteArrayList();
        this.transportFactory = NoOpTransportFactory.getInstance();
        this.transportGate = NoOpTransportGate.getInstance();
        this.attachStacktrace = true;
        this.enableAutoSessionTracking = true;
        this.sessionTrackingIntervalMillis = 30000L;
        this.attachServerName = true;
        this.enableUncaughtExceptionHandler = true;
        this.printUncaughtStackTrace = false;
        this.executorService = NoOpSentryExecutorService.getInstance();
        this.connectionTimeoutMillis = 30000;
        this.readTimeoutMillis = 30000;
        this.envelopeDiskCache = NoOpEnvelopeCache.getInstance();
        this.sendDefaultPii = false;
        this.observers = new CopyOnWriteArrayList();
        this.optionsObservers = new CopyOnWriteArrayList();
        this.tags = new ConcurrentHashMap();
        this.maxAttachmentSize = 20971520L;
        this.enableDeduplication = true;
        this.maxSpans = 1000;
        this.enableShutdownHook = true;
        this.maxRequestBodySize = RequestSize.NONE;
        this.traceSampling = true;
        this.maxTraceFileSize = 5242880L;
        this.transactionProfiler = NoOpTransactionProfiler.getInstance();
        this.continuousProfiler = NoOpContinuousProfiler.getInstance();
        this.tracePropagationTargets = null;
        this.defaultTracePropagationTargets = Collections.singletonList(DEFAULT_PROPAGATION_TARGETS);
        this.idleTimeout = 3000L;
        this.contextTags = new CopyOnWriteArrayList();
        this.sendClientReports = true;
        this.clientReportRecorder = new ClientReportRecorder(this);
        this.modulesLoader = NoOpModulesLoader.getInstance();
        this.debugMetaLoader = NoOpDebugMetaLoader.getInstance();
        this.enableUserInteractionTracing = false;
        this.enableUserInteractionBreadcrumbs = true;
        this.instrumenter = Instrumenter.SENTRY;
        this.gestureTargetLocators = new ArrayList();
        this.viewHierarchyExporters = new ArrayList();
        this.threadChecker = NoOpThreadChecker.getInstance();
        this.traceOptionsRequests = true;
        this.dateProvider = new LazyEvaluator<>(new LazyEvaluator.Evaluator() { // from class: io.sentry.SentryOptions$$ExternalSyntheticLambda3
            @Override // io.sentry.util.LazyEvaluator.Evaluator
            public final Object evaluate() {
                return SentryOptions.lambda$new$3();
            }
        });
        this.performanceCollectors = new ArrayList();
        this.compositePerformanceCollector = NoOpCompositePerformanceCollector.getInstance();
        this.enableTimeToFullDisplayTracing = false;
        this.fullyDisplayedReporter = FullyDisplayedReporter.getInstance();
        this.connectionStatusProvider = new NoOpConnectionStatusProvider();
        this.enabled = true;
        this.enablePrettySerializationOutput = true;
        this.sendModules = true;
        this.enableSpotlight = false;
        this.enableScopePersistence = true;
        this.ignoredCheckIns = null;
        this.ignoredSpanOrigins = null;
        this.ignoredTransactions = null;
        this.backpressureMonitor = NoOpBackpressureMonitor.getInstance();
        this.enableBackpressureHandling = true;
        this.enableAppStartProfiling = false;
        this.spanFactory = NoOpSpanFactory.getInstance();
        this.profilingTracesHz = 101;
        this.cron = null;
        this.replayController = NoOpReplayController.getInstance();
        this.enableScreenTracking = true;
        this.defaultScopeType = ScopeType.ISOLATION;
        this.initPriority = InitPriority.MEDIUM;
        this.forceInit = false;
        this.globalHubMode = null;
        this.lock = new AutoClosableReentrantLock();
        this.openTelemetryMode = SentryOpenTelemetryMode.AUTO;
        this.captureOpenTelemetryEvents = false;
        this.versionDetector = NoopVersionDetector.getInstance();
        this.profileLifecycle = ProfileLifecycle.MANUAL;
        this.startProfilerOnAppStart = false;
        this.deadlineTimeout = 30000L;
        this.logs = new Logs();
        this.socketTagger = NoOpSocketTagger.getInstance();
        SdkVersion sdkVersionCreateSdkVersion = createSdkVersion();
        this.experimental = new ExperimentalOptions(z, sdkVersionCreateSdkVersion);
        this.sessionReplay = new SentryReplayOptions(z, sdkVersionCreateSdkVersion);
        this.feedbackOptions = new SentryFeedbackOptions(new SentryFeedbackOptions.IDialogHandler() { // from class: io.sentry.SentryOptions$$ExternalSyntheticLambda4
            @Override // io.sentry.SentryFeedbackOptions.IDialogHandler
            public final void showDialog(SentryId sentryId, SentryFeedbackOptions.OptionsConfigurator optionsConfigurator) {
                this.f$0.lambda$new$4(sentryId, optionsConfigurator);
            }
        });
        if (z) {
            return;
        }
        setSpanFactory(SpanFactoryFactory.create(new LoadClass(), NoOpLogger.getInstance()));
        SentryExecutorService sentryExecutorService = new SentryExecutorService(this);
        this.executorService = sentryExecutorService;
        sentryExecutorService.prewarm();
        copyOnWriteArrayList2.add(new UncaughtExceptionHandlerIntegration());
        copyOnWriteArrayList2.add(new ShutdownHookIntegration());
        copyOnWriteArrayList2.add(new SpotlightIntegration());
        copyOnWriteArrayList.add(new MainEventProcessor(this));
        copyOnWriteArrayList.add(new DuplicateEventDetectionEventProcessor(this));
        if (Platform.isJvm()) {
            copyOnWriteArrayList.add(new SentryRuntimeEventProcessor());
        }
        setSentryClientName("sentry.java/8.20.0");
        setSdkVersion(sdkVersionCreateSdkVersion);
        addPackageInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(SentryId sentryId, SentryFeedbackOptions.OptionsConfigurator optionsConfigurator) {
        this.logger.log(SentryLevel.WARNING, "showDialog() can only be called in Android.", new Object[0]);
    }

    public void merge(@NotNull ExternalOptions externalOptions) {
        if (externalOptions.getDsn() != null) {
            setDsn(externalOptions.getDsn());
        }
        if (externalOptions.getEnvironment() != null) {
            setEnvironment(externalOptions.getEnvironment());
        }
        if (externalOptions.getRelease() != null) {
            setRelease(externalOptions.getRelease());
        }
        if (externalOptions.getDist() != null) {
            setDist(externalOptions.getDist());
        }
        if (externalOptions.getServerName() != null) {
            setServerName(externalOptions.getServerName());
        }
        if (externalOptions.getProxy() != null) {
            setProxy(externalOptions.getProxy());
        }
        if (externalOptions.getEnableUncaughtExceptionHandler() != null) {
            setEnableUncaughtExceptionHandler(externalOptions.getEnableUncaughtExceptionHandler().booleanValue());
        }
        if (externalOptions.getPrintUncaughtStackTrace() != null) {
            setPrintUncaughtStackTrace(externalOptions.getPrintUncaughtStackTrace().booleanValue());
        }
        if (externalOptions.getTracesSampleRate() != null) {
            setTracesSampleRate(externalOptions.getTracesSampleRate());
        }
        if (externalOptions.getProfilesSampleRate() != null) {
            setProfilesSampleRate(externalOptions.getProfilesSampleRate());
        }
        if (externalOptions.getDebug() != null) {
            setDebug(externalOptions.getDebug().booleanValue());
        }
        if (externalOptions.getEnableDeduplication() != null) {
            setEnableDeduplication(externalOptions.getEnableDeduplication().booleanValue());
        }
        if (externalOptions.getSendClientReports() != null) {
            setSendClientReports(externalOptions.getSendClientReports().booleanValue());
        }
        if (externalOptions.isForceInit() != null) {
            setForceInit(externalOptions.isForceInit().booleanValue());
        }
        for (Map.Entry entry : new HashMap(externalOptions.getTags()).entrySet()) {
            this.tags.put((String) entry.getKey(), (String) entry.getValue());
        }
        Iterator it2 = new ArrayList(externalOptions.getInAppIncludes()).iterator();
        while (it2.hasNext()) {
            addInAppInclude((String) it2.next());
        }
        Iterator it3 = new ArrayList(externalOptions.getInAppExcludes()).iterator();
        while (it3.hasNext()) {
            addInAppExclude((String) it3.next());
        }
        Iterator it4 = new HashSet(externalOptions.getIgnoredExceptionsForType()).iterator();
        while (it4.hasNext()) {
            addIgnoredExceptionForType((Class) it4.next());
        }
        if (externalOptions.getTracePropagationTargets() != null) {
            setTracePropagationTargets(new ArrayList(externalOptions.getTracePropagationTargets()));
        }
        Iterator it5 = new ArrayList(externalOptions.getContextTags()).iterator();
        while (it5.hasNext()) {
            addContextTag((String) it5.next());
        }
        if (externalOptions.getProguardUuid() != null) {
            setProguardUuid(externalOptions.getProguardUuid());
        }
        if (externalOptions.getIdleTimeout() != null) {
            setIdleTimeout(externalOptions.getIdleTimeout());
        }
        Iterator<String> it6 = externalOptions.getBundleIds().iterator();
        while (it6.hasNext()) {
            addBundleId(it6.next());
        }
        if (externalOptions.isEnabled() != null) {
            setEnabled(externalOptions.isEnabled().booleanValue());
        }
        if (externalOptions.isEnablePrettySerializationOutput() != null) {
            setEnablePrettySerializationOutput(externalOptions.isEnablePrettySerializationOutput().booleanValue());
        }
        if (externalOptions.isSendModules() != null) {
            setSendModules(externalOptions.isSendModules().booleanValue());
        }
        if (externalOptions.getIgnoredCheckIns() != null) {
            setIgnoredCheckIns(new ArrayList(externalOptions.getIgnoredCheckIns()));
        }
        if (externalOptions.getIgnoredTransactions() != null) {
            setIgnoredTransactions(new ArrayList(externalOptions.getIgnoredTransactions()));
        }
        if (externalOptions.getIgnoredErrors() != null) {
            setIgnoredErrors(new ArrayList(externalOptions.getIgnoredErrors()));
        }
        if (externalOptions.isEnableBackpressureHandling() != null) {
            setEnableBackpressureHandling(externalOptions.isEnableBackpressureHandling().booleanValue());
        }
        if (externalOptions.getMaxRequestBodySize() != null) {
            setMaxRequestBodySize(externalOptions.getMaxRequestBodySize());
        }
        if (externalOptions.isSendDefaultPii() != null) {
            setSendDefaultPii(externalOptions.isSendDefaultPii().booleanValue());
        }
        if (externalOptions.isCaptureOpenTelemetryEvents() != null) {
            setCaptureOpenTelemetryEvents(externalOptions.isCaptureOpenTelemetryEvents().booleanValue());
        }
        if (externalOptions.isEnableSpotlight() != null) {
            setEnableSpotlight(externalOptions.isEnableSpotlight().booleanValue());
        }
        if (externalOptions.getSpotlightConnectionUrl() != null) {
            setSpotlightConnectionUrl(externalOptions.getSpotlightConnectionUrl());
        }
        if (externalOptions.isGlobalHubMode() != null) {
            setGlobalHubMode(externalOptions.isGlobalHubMode());
        }
        if (externalOptions.getCron() != null) {
            if (getCron() == null) {
                setCron(externalOptions.getCron());
            } else {
                if (externalOptions.getCron().getDefaultCheckinMargin() != null) {
                    getCron().setDefaultCheckinMargin(externalOptions.getCron().getDefaultCheckinMargin());
                }
                if (externalOptions.getCron().getDefaultMaxRuntime() != null) {
                    getCron().setDefaultMaxRuntime(externalOptions.getCron().getDefaultMaxRuntime());
                }
                if (externalOptions.getCron().getDefaultTimezone() != null) {
                    getCron().setDefaultTimezone(externalOptions.getCron().getDefaultTimezone());
                }
                if (externalOptions.getCron().getDefaultFailureIssueThreshold() != null) {
                    getCron().setDefaultFailureIssueThreshold(externalOptions.getCron().getDefaultFailureIssueThreshold());
                }
                if (externalOptions.getCron().getDefaultRecoveryThreshold() != null) {
                    getCron().setDefaultRecoveryThreshold(externalOptions.getCron().getDefaultRecoveryThreshold());
                }
            }
        }
        if (externalOptions.isEnableLogs() != null) {
            getLogs().setEnabled(externalOptions.isEnableLogs().booleanValue());
        }
    }

    private SdkVersion createSdkVersion() {
        SdkVersion sdkVersion = new SdkVersion(BuildConfig.SENTRY_JAVA_SDK_NAME, "8.20.0");
        sdkVersion.setVersion("8.20.0");
        return sdkVersion;
    }

    private void addPackageInfo() {
        SentryIntegrationPackageStorage.getInstance().addPackage("maven:io.sentry:sentry", "8.20.0");
    }

    public ISpanFactory getSpanFactory() {
        return this.spanFactory;
    }

    public void setSpanFactory(@NotNull ISpanFactory iSpanFactory) {
        this.spanFactory = iSpanFactory;
    }

    public Logs getLogs() {
        return this.logs;
    }

    public void setLogs(@NotNull Logs logs) {
        this.logs = logs;
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Cron {
        private Long defaultCheckinMargin;
        private Long defaultFailureIssueThreshold;
        private Long defaultMaxRuntime;
        private Long defaultRecoveryThreshold;
        private String defaultTimezone;

        public Long getDefaultCheckinMargin() {
            return this.defaultCheckinMargin;
        }

        public void setDefaultCheckinMargin(@Nullable Long l) {
            this.defaultCheckinMargin = l;
        }

        public Long getDefaultMaxRuntime() {
            return this.defaultMaxRuntime;
        }

        public void setDefaultMaxRuntime(@Nullable Long l) {
            this.defaultMaxRuntime = l;
        }

        public String getDefaultTimezone() {
            return this.defaultTimezone;
        }

        public void setDefaultTimezone(@Nullable String str) {
            this.defaultTimezone = str;
        }

        public Long getDefaultFailureIssueThreshold() {
            return this.defaultFailureIssueThreshold;
        }

        public void setDefaultFailureIssueThreshold(@Nullable Long l) {
            this.defaultFailureIssueThreshold = l;
        }

        public Long getDefaultRecoveryThreshold() {
            return this.defaultRecoveryThreshold;
        }

        public void setDefaultRecoveryThreshold(@Nullable Long l) {
            this.defaultRecoveryThreshold = l;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Logs {
        private BeforeSendLogCallback beforeSend;
        private boolean enable = false;

        /* JADX INFO: loaded from: classes6.dex */
        public interface BeforeSendLogCallback {
            SentryLogEvent execute(@NotNull SentryLogEvent sentryLogEvent);
        }

        public boolean isEnabled() {
            return this.enable;
        }

        public void setEnabled(boolean z) {
            this.enable = z;
        }

        public BeforeSendLogCallback getBeforeSend() {
            return this.beforeSend;
        }

        public void setBeforeSend(@Nullable BeforeSendLogCallback beforeSendLogCallback) {
            this.beforeSend = beforeSendLogCallback;
        }
    }
}
