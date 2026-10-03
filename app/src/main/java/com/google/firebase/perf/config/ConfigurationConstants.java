package com.google.firebase.perf.config;

import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.util.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class ConfigurationConstants {
    ConfigurationConstants() {
    }

    protected static final class CollectionDeactivated extends ConfigurationFlag<Boolean> {
        private static CollectionDeactivated instance;

        private CollectionDeactivated() {
        }

        protected static CollectionDeactivated getInstance() {
            CollectionDeactivated collectionDeactivated;
            synchronized (CollectionDeactivated.class) {
                if (instance == null) {
                    instance = new CollectionDeactivated();
                }
                collectionDeactivated = instance;
            }
            return collectionDeactivated;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Boolean getDefault() {
            return Boolean.FALSE;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "firebase_performance_collection_deactivated";
        }
    }

    protected static final class CollectionEnabled extends ConfigurationFlag<Boolean> {
        private static CollectionEnabled instance;

        private CollectionEnabled() {
        }

        protected static CollectionEnabled getInstance() {
            CollectionEnabled collectionEnabled;
            synchronized (CollectionEnabled.class) {
                if (instance == null) {
                    instance = new CollectionEnabled();
                }
                collectionEnabled = instance;
            }
            return collectionEnabled;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Boolean getDefault() {
            return Boolean.TRUE;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "firebase_performance_collection_enabled";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return Constants.ENABLE_DISABLE;
        }
    }

    protected static final class SdkEnabled extends ConfigurationFlag<Boolean> {
        private static SdkEnabled instance;

        protected SdkEnabled() {
        }

        protected static SdkEnabled getInstance() {
            SdkEnabled sdkEnabled;
            synchronized (SdkEnabled.class) {
                if (instance == null) {
                    instance = new SdkEnabled();
                }
                sdkEnabled = instance;
            }
            return sdkEnabled;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Boolean getDefault() {
            return Boolean.TRUE;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_enabled";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SdkEnabled";
        }
    }

    protected static final class SdkDisabledVersions extends ConfigurationFlag<String> {
        private static SdkDisabledVersions instance;

        protected SdkDisabledVersions() {
        }

        protected static SdkDisabledVersions getInstance() {
            SdkDisabledVersions sdkDisabledVersions;
            synchronized (SdkDisabledVersions.class) {
                if (instance == null) {
                    instance = new SdkDisabledVersions();
                }
                sdkDisabledVersions = instance;
            }
            return sdkDisabledVersions;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDefault() {
            return "";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_disabled_android_versions";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SdkDisabledVersions";
        }
    }

    protected static final class TraceSamplingRate extends ConfigurationFlag<Double> {
        private static TraceSamplingRate instance;

        private TraceSamplingRate() {
        }

        protected static TraceSamplingRate getInstance() {
            TraceSamplingRate traceSamplingRate;
            synchronized (TraceSamplingRate.class) {
                if (instance == null) {
                    instance = new TraceSamplingRate();
                }
                traceSamplingRate = instance;
            }
            return traceSamplingRate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefault() {
            return Double.valueOf(1.0d);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefaultOnRcFetchFail() {
            return Double.valueOf(getDefault().doubleValue() / 1000.0d);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_vc_trace_sampling_rate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceSamplingRate";
        }
    }

    protected static final class NetworkRequestSamplingRate extends ConfigurationFlag<Double> {
        private static NetworkRequestSamplingRate instance;

        private NetworkRequestSamplingRate() {
        }

        protected static NetworkRequestSamplingRate getInstance() {
            NetworkRequestSamplingRate networkRequestSamplingRate;
            synchronized (NetworkRequestSamplingRate.class) {
                if (instance == null) {
                    instance = new NetworkRequestSamplingRate();
                }
                networkRequestSamplingRate = instance;
            }
            return networkRequestSamplingRate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefault() {
            return Double.valueOf(1.0d);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefaultOnRcFetchFail() {
            return Double.valueOf(getDefault().doubleValue() / 1000.0d);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_vc_network_request_sampling_rate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkRequestSamplingRate";
        }
    }

    protected static final class SessionsCpuCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
        private static SessionsCpuCaptureFrequencyForegroundMs instance;

        private SessionsCpuCaptureFrequencyForegroundMs() {
        }

        public static SessionsCpuCaptureFrequencyForegroundMs getInstance() {
            SessionsCpuCaptureFrequencyForegroundMs sessionsCpuCaptureFrequencyForegroundMs;
            synchronized (SessionsCpuCaptureFrequencyForegroundMs.class) {
                if (instance == null) {
                    instance = new SessionsCpuCaptureFrequencyForegroundMs();
                }
                sessionsCpuCaptureFrequencyForegroundMs = instance;
            }
            return sessionsCpuCaptureFrequencyForegroundMs;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 100L;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefaultOnRcFetchFail() {
            return Long.valueOf(getDefault().longValue() * 3);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_cpu_capture_frequency_fg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
        }
    }

    protected static final class SessionsCpuCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
        private static SessionsCpuCaptureFrequencyBackgroundMs instance;

        private SessionsCpuCaptureFrequencyBackgroundMs() {
        }

        public static SessionsCpuCaptureFrequencyBackgroundMs getInstance() {
            SessionsCpuCaptureFrequencyBackgroundMs sessionsCpuCaptureFrequencyBackgroundMs;
            synchronized (SessionsCpuCaptureFrequencyBackgroundMs.class) {
                if (instance == null) {
                    instance = new SessionsCpuCaptureFrequencyBackgroundMs();
                }
                sessionsCpuCaptureFrequencyBackgroundMs = instance;
            }
            return sessionsCpuCaptureFrequencyBackgroundMs;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 0L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_cpu_capture_frequency_bg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
        }
    }

    protected static final class SessionsMemoryCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
        private static SessionsMemoryCaptureFrequencyForegroundMs instance;

        private SessionsMemoryCaptureFrequencyForegroundMs() {
        }

        public static SessionsMemoryCaptureFrequencyForegroundMs getInstance() {
            SessionsMemoryCaptureFrequencyForegroundMs sessionsMemoryCaptureFrequencyForegroundMs;
            synchronized (SessionsMemoryCaptureFrequencyForegroundMs.class) {
                if (instance == null) {
                    instance = new SessionsMemoryCaptureFrequencyForegroundMs();
                }
                sessionsMemoryCaptureFrequencyForegroundMs = instance;
            }
            return sessionsMemoryCaptureFrequencyForegroundMs;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 100L;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefaultOnRcFetchFail() {
            return Long.valueOf(getDefault().longValue() * 3);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_memory_capture_frequency_fg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_memory_capture_frequency_fg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
        }
    }

    protected static final class SessionsMemoryCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
        private static SessionsMemoryCaptureFrequencyBackgroundMs instance;

        private SessionsMemoryCaptureFrequencyBackgroundMs() {
        }

        public static SessionsMemoryCaptureFrequencyBackgroundMs getInstance() {
            SessionsMemoryCaptureFrequencyBackgroundMs sessionsMemoryCaptureFrequencyBackgroundMs;
            synchronized (SessionsMemoryCaptureFrequencyBackgroundMs.class) {
                if (instance == null) {
                    instance = new SessionsMemoryCaptureFrequencyBackgroundMs();
                }
                sessionsMemoryCaptureFrequencyBackgroundMs = instance;
            }
            return sessionsMemoryCaptureFrequencyBackgroundMs;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 0L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_memory_capture_frequency_bg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_memory_capture_frequency_bg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
        }
    }

    protected static final class SessionsMaxDurationMinutes extends ConfigurationFlag<Long> {
        private static SessionsMaxDurationMinutes instance;

        private SessionsMaxDurationMinutes() {
        }

        public static SessionsMaxDurationMinutes getInstance() {
            SessionsMaxDurationMinutes sessionsMaxDurationMinutes;
            synchronized (SessionsMaxDurationMinutes.class) {
                if (instance == null) {
                    instance = new SessionsMaxDurationMinutes();
                }
                sessionsMaxDurationMinutes = instance;
            }
            return sessionsMaxDurationMinutes;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 240L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_max_duration_min";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_max_length_minutes";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMaxDurationMinutes";
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    protected static final class TraceEventCountForeground extends ConfigurationFlag<Long> {
        private static TraceEventCountForeground instance;

        private TraceEventCountForeground() {
        }

        public static TraceEventCountForeground getInstance() {
            TraceEventCountForeground traceEventCountForeground;
            synchronized (TraceEventCountForeground.class) {
                if (instance == null) {
                    instance = new TraceEventCountForeground();
                }
                traceEventCountForeground = instance;
            }
            return traceEventCountForeground;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 300L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_trace_event_count_fg";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceEventCountForeground";
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    protected static final class TraceEventCountBackground extends ConfigurationFlag<Long> {
        private static TraceEventCountBackground instance;

        private TraceEventCountBackground() {
        }

        public static TraceEventCountBackground getInstance() {
            TraceEventCountBackground traceEventCountBackground;
            synchronized (TraceEventCountBackground.class) {
                if (instance == null) {
                    instance = new TraceEventCountBackground();
                }
                traceEventCountBackground = instance;
            }
            return traceEventCountBackground;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 30L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_trace_event_count_bg";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceEventCountBackground";
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    protected static final class NetworkEventCountForeground extends ConfigurationFlag<Long> {
        private static NetworkEventCountForeground instance;

        private NetworkEventCountForeground() {
        }

        public static NetworkEventCountForeground getInstance() {
            NetworkEventCountForeground networkEventCountForeground;
            synchronized (NetworkEventCountForeground.class) {
                if (instance == null) {
                    instance = new NetworkEventCountForeground();
                }
                networkEventCountForeground = instance;
            }
            return networkEventCountForeground;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 700L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_network_event_count_fg";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkEventCountForeground";
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    protected static final class NetworkEventCountBackground extends ConfigurationFlag<Long> {
        private static NetworkEventCountBackground instance;

        private NetworkEventCountBackground() {
        }

        public static NetworkEventCountBackground getInstance() {
            NetworkEventCountBackground networkEventCountBackground;
            synchronized (NetworkEventCountBackground.class) {
                if (instance == null) {
                    instance = new NetworkEventCountBackground();
                }
                networkEventCountBackground = instance;
            }
            return networkEventCountBackground;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 70L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_network_event_count_bg";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkEventCountBackground";
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    protected static final class RateLimitSec extends ConfigurationFlag<Long> {
        private static RateLimitSec instance;

        private RateLimitSec() {
        }

        public static RateLimitSec getInstance() {
            RateLimitSec rateLimitSec;
            synchronized (RateLimitSec.class) {
                if (instance == null) {
                    instance = new RateLimitSec();
                }
                rateLimitSec = instance;
            }
            return rateLimitSec;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 600L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_time_limit_sec";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TimeLimitSec";
        }
    }

    protected static final class SessionsSamplingRate extends ConfigurationFlag<Double> {
        private static SessionsSamplingRate instance;

        private SessionsSamplingRate() {
        }

        public static SessionsSamplingRate getInstance() {
            SessionsSamplingRate sessionsSamplingRate;
            synchronized (SessionsSamplingRate.class) {
                if (instance == null) {
                    instance = new SessionsSamplingRate();
                }
                sessionsSamplingRate = instance;
            }
            return sessionsSamplingRate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefault() {
            return Double.valueOf(0.01d);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefaultOnRcFetchFail() {
            return Double.valueOf(getDefault().doubleValue() / 1000.0d);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionSamplingRate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_vc_session_sampling_rate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_sampling_percentage";
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    protected static final class LogSourceName extends ConfigurationFlag<String> {
        private static final Map<Long, String> LOG_SOURCE_MAP = Collections.unmodifiableMap(new HashMap<Long, String>() { // from class: com.google.firebase.perf.config.ConfigurationConstants.LogSourceName.1
            {
                put(461L, "FIREPERF_AUTOPUSH");
                put(462L, "FIREPERF");
                put(675L, "FIREPERF_INTERNAL_LOW");
                put(676L, "FIREPERF_INTERNAL_HIGH");
            }
        });
        private static LogSourceName instance;

        private LogSourceName() {
        }

        public static LogSourceName getInstance() {
            LogSourceName logSourceName;
            synchronized (LogSourceName.class) {
                if (instance == null) {
                    instance = new LogSourceName();
                }
                logSourceName = instance;
            }
            return logSourceName;
        }

        protected static String getLogSourceName(long j) {
            return LOG_SOURCE_MAP.get(Long.valueOf(j));
        }

        protected static boolean isLogSourceKnown(long j) {
            return LOG_SOURCE_MAP.containsKey(Long.valueOf(j));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDefault() {
            return BuildConfig.TRANSPORT_LOG_SRC;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_log_source";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.LogSourceName";
        }
    }

    protected static final class FragmentSamplingRate extends ConfigurationFlag<Double> {
        private static FragmentSamplingRate instance;

        private FragmentSamplingRate() {
        }

        protected static FragmentSamplingRate getInstance() {
            FragmentSamplingRate fragmentSamplingRate;
            synchronized (FragmentSamplingRate.class) {
                if (instance == null) {
                    instance = new FragmentSamplingRate();
                }
                fragmentSamplingRate = instance;
            }
            return fragmentSamplingRate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefault() {
            return Double.valueOf(0.0d);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_vc_fragment_sampling_rate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.FragmentSamplingRate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "fragment_sampling_percentage";
        }
    }

    protected static final class ExperimentTTID extends ConfigurationFlag<Boolean> {
        private static ExperimentTTID instance;

        private ExperimentTTID() {
        }

        protected static ExperimentTTID getInstance() {
            ExperimentTTID experimentTTID;
            synchronized (ExperimentTTID.class) {
                if (instance == null) {
                    instance = new ExperimentTTID();
                }
                experimentTTID = instance;
            }
            return experimentTTID;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Boolean getDefault() {
            return Boolean.FALSE;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_experiment_app_start_ttid";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.ExperimentTTID";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "experiment_app_start_ttid";
        }
    }
}
