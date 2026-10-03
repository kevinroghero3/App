package io.sentry;

import com.google.common.base.Ascii;
import io.sentry.util.SentryRandom;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SentryAppStartProfilingOptions implements JsonUnknown, JsonSerializable {
    boolean continuousProfileSampled;
    boolean isContinuousProfilingEnabled;
    boolean isEnableAppStartProfiling;
    boolean isProfilingEnabled;
    boolean isStartProfilerOnAppStart;
    ProfileLifecycle profileLifecycle;
    Double profileSampleRate;
    boolean profileSampled;
    String profilingTracesDirPath;
    int profilingTracesHz;
    Double traceSampleRate;
    boolean traceSampled;
    private Map<String, Object> unknown;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String CONTINUOUS_PROFILE_SAMPLED = "continuous_profile_sampled";
        public static final String IS_CONTINUOUS_PROFILING_ENABLED = "is_continuous_profiling_enabled";
        public static final String IS_ENABLE_APP_START_PROFILING = "is_enable_app_start_profiling";
        public static final String IS_PROFILING_ENABLED = "is_profiling_enabled";
        public static final String IS_START_PROFILER_ON_APP_START = "is_start_profiler_on_app_start";
        public static final String PROFILE_LIFECYCLE = "profile_lifecycle";
        public static final String PROFILE_SAMPLED = "profile_sampled";
        public static final String PROFILE_SAMPLE_RATE = "profile_sample_rate";
        public static final String PROFILING_TRACES_DIR_PATH = "profiling_traces_dir_path";
        public static final String PROFILING_TRACES_HZ = "profiling_traces_hz";
        public static final String TRACE_SAMPLED = "trace_sampled";
        public static final String TRACE_SAMPLE_RATE = "trace_sample_rate";
    }

    public SentryAppStartProfilingOptions() {
        this.traceSampled = false;
        this.traceSampleRate = null;
        this.profileSampled = false;
        this.profileSampleRate = null;
        this.continuousProfileSampled = false;
        this.profilingTracesDirPath = null;
        this.isProfilingEnabled = false;
        this.isContinuousProfilingEnabled = false;
        this.profileLifecycle = ProfileLifecycle.MANUAL;
        this.profilingTracesHz = 0;
        this.isEnableAppStartProfiling = true;
        this.isStartProfilerOnAppStart = false;
    }

    SentryAppStartProfilingOptions(@NotNull SentryOptions sentryOptions, @NotNull TracesSamplingDecision tracesSamplingDecision) {
        this.traceSampled = tracesSamplingDecision.getSampled().booleanValue();
        this.traceSampleRate = tracesSamplingDecision.getSampleRate();
        this.profileSampled = tracesSamplingDecision.getProfileSampled().booleanValue();
        this.profileSampleRate = tracesSamplingDecision.getProfileSampleRate();
        this.continuousProfileSampled = sentryOptions.getInternalTracesSampler().sampleSessionProfile(SentryRandom.current().nextDouble());
        this.profilingTracesDirPath = sentryOptions.getProfilingTracesDirPath();
        this.isProfilingEnabled = sentryOptions.isProfilingEnabled();
        this.isContinuousProfilingEnabled = sentryOptions.isContinuousProfilingEnabled();
        this.profileLifecycle = sentryOptions.getProfileLifecycle();
        this.profilingTracesHz = sentryOptions.getProfilingTracesHz();
        this.isEnableAppStartProfiling = sentryOptions.isEnableAppStartProfiling();
        this.isStartProfilerOnAppStart = sentryOptions.isStartProfilerOnAppStart();
    }

    public void setProfileSampled(boolean z) {
        this.profileSampled = z;
    }

    public boolean isProfileSampled() {
        return this.profileSampled;
    }

    public void setContinuousProfileSampled(boolean z) {
        this.continuousProfileSampled = z;
    }

    public boolean isContinuousProfileSampled() {
        return this.continuousProfileSampled;
    }

    public void setProfileLifecycle(@NotNull ProfileLifecycle profileLifecycle) {
        this.profileLifecycle = profileLifecycle;
    }

    public ProfileLifecycle getProfileLifecycle() {
        return this.profileLifecycle;
    }

    public void setProfileSampleRate(@Nullable Double d) {
        this.profileSampleRate = d;
    }

    public Double getProfileSampleRate() {
        return this.profileSampleRate;
    }

    public void setTraceSampled(boolean z) {
        this.traceSampled = z;
    }

    public boolean isTraceSampled() {
        return this.traceSampled;
    }

    public void setTraceSampleRate(@Nullable Double d) {
        this.traceSampleRate = d;
    }

    public Double getTraceSampleRate() {
        return this.traceSampleRate;
    }

    public void setProfilingTracesDirPath(@Nullable String str) {
        this.profilingTracesDirPath = str;
    }

    public String getProfilingTracesDirPath() {
        return this.profilingTracesDirPath;
    }

    public void setProfilingEnabled(boolean z) {
        this.isProfilingEnabled = z;
    }

    public boolean isProfilingEnabled() {
        return this.isProfilingEnabled;
    }

    public void setContinuousProfilingEnabled(boolean z) {
        this.isContinuousProfilingEnabled = z;
    }

    public boolean isContinuousProfilingEnabled() {
        return this.isContinuousProfilingEnabled;
    }

    public void setProfilingTracesHz(int i) {
        this.profilingTracesHz = i;
    }

    public int getProfilingTracesHz() {
        return this.profilingTracesHz;
    }

    public void setEnableAppStartProfiling(boolean z) {
        this.isEnableAppStartProfiling = z;
    }

    public boolean isEnableAppStartProfiling() {
        return this.isEnableAppStartProfiling;
    }

    public void setStartProfilerOnAppStart(boolean z) {
        this.isStartProfilerOnAppStart = z;
    }

    public boolean isStartProfilerOnAppStart() {
        return this.isStartProfilerOnAppStart;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name(JsonKeys.PROFILE_SAMPLED).value(iLogger, Boolean.valueOf(this.profileSampled));
        objectWriter.name(JsonKeys.PROFILE_SAMPLE_RATE).value(iLogger, this.profileSampleRate);
        objectWriter.name(JsonKeys.CONTINUOUS_PROFILE_SAMPLED).value(iLogger, Boolean.valueOf(this.continuousProfileSampled));
        objectWriter.name(JsonKeys.TRACE_SAMPLED).value(iLogger, Boolean.valueOf(this.traceSampled));
        objectWriter.name(JsonKeys.TRACE_SAMPLE_RATE).value(iLogger, this.traceSampleRate);
        objectWriter.name(JsonKeys.PROFILING_TRACES_DIR_PATH).value(iLogger, this.profilingTracesDirPath);
        objectWriter.name(JsonKeys.IS_PROFILING_ENABLED).value(iLogger, Boolean.valueOf(this.isProfilingEnabled));
        objectWriter.name(JsonKeys.IS_CONTINUOUS_PROFILING_ENABLED).value(iLogger, Boolean.valueOf(this.isContinuousProfilingEnabled));
        objectWriter.name(JsonKeys.PROFILE_LIFECYCLE).value(iLogger, this.profileLifecycle.name());
        objectWriter.name(JsonKeys.PROFILING_TRACES_HZ).value(iLogger, Integer.valueOf(this.profilingTracesHz));
        objectWriter.name(JsonKeys.IS_ENABLE_APP_START_PROFILING).value(iLogger, Boolean.valueOf(this.isEnableAppStartProfiling));
        objectWriter.name(JsonKeys.IS_START_PROFILER_ON_APP_START).value(iLogger, Boolean.valueOf(this.isStartProfilerOnAppStart));
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.unknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    @Override // io.sentry.JsonUnknown
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.JsonUnknown
    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer<SentryAppStartProfilingOptions> {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:56:0x00b2  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // io.sentry.JsonDeserializer
        public SentryAppStartProfilingOptions deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            SentryAppStartProfilingOptions sentryAppStartProfilingOptions = new SentryAppStartProfilingOptions();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName.hashCode()) {
                    case -801141276:
                        if (!strNextName.equals(JsonKeys.IS_ENABLE_APP_START_PROFILING)) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    case -566246656:
                        if (!strNextName.equals(JsonKeys.TRACE_SAMPLED)) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case -450071601:
                        if (!strNextName.equals(JsonKeys.PROFILING_TRACES_DIR_PATH)) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case -436975123:
                        if (!strNextName.equals(JsonKeys.IS_CONTINUOUS_PROFILING_ENABLED)) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    case -116896685:
                        if (!strNextName.equals(JsonKeys.IS_PROFILING_ENABLED)) {
                            b = -1;
                        } else {
                            b = 4;
                        }
                        break;
                    case -104146616:
                        if (!strNextName.equals(JsonKeys.IS_START_PROFILER_ON_APP_START)) {
                            b = -1;
                        } else {
                            b = 5;
                        }
                        break;
                    case -69617820:
                        if (!strNextName.equals(JsonKeys.PROFILE_SAMPLED)) {
                            b = -1;
                        } else {
                            b = 6;
                        }
                        break;
                    case 401419348:
                        if (!strNextName.equals(JsonKeys.PROFILE_LIFECYCLE)) {
                            b = -1;
                        } else {
                            b = 7;
                        }
                        break;
                    case 1401020980:
                        if (!strNextName.equals(JsonKeys.CONTINUOUS_PROFILE_SAMPLED)) {
                            b = -1;
                        } else {
                            b = 8;
                        }
                        break;
                    case 1583866442:
                        if (!strNextName.equals(JsonKeys.PROFILING_TRACES_HZ)) {
                            b = -1;
                        } else {
                            b = 9;
                        }
                        break;
                    case 1653938779:
                        if (!strNextName.equals(JsonKeys.TRACE_SAMPLE_RATE)) {
                            b = -1;
                        } else {
                            b = 10;
                        }
                        break;
                    case 2140552383:
                        if (!strNextName.equals(JsonKeys.PROFILE_SAMPLE_RATE)) {
                            b = -1;
                        } else {
                            b = Ascii.VT;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        Boolean boolNextBooleanOrNull = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull != null) {
                            sentryAppStartProfilingOptions.isEnableAppStartProfiling = boolNextBooleanOrNull.booleanValue();
                        }
                        break;
                    case 1:
                        Boolean boolNextBooleanOrNull2 = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull2 != null) {
                            sentryAppStartProfilingOptions.traceSampled = boolNextBooleanOrNull2.booleanValue();
                        }
                        break;
                    case 2:
                        String strNextStringOrNull = objectReader.nextStringOrNull();
                        if (strNextStringOrNull != null) {
                            sentryAppStartProfilingOptions.profilingTracesDirPath = strNextStringOrNull;
                        }
                        break;
                    case 3:
                        Boolean boolNextBooleanOrNull3 = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull3 != null) {
                            sentryAppStartProfilingOptions.isContinuousProfilingEnabled = boolNextBooleanOrNull3.booleanValue();
                        }
                        break;
                    case 4:
                        Boolean boolNextBooleanOrNull4 = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull4 != null) {
                            sentryAppStartProfilingOptions.isProfilingEnabled = boolNextBooleanOrNull4.booleanValue();
                        }
                        break;
                    case 5:
                        Boolean boolNextBooleanOrNull5 = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull5 != null) {
                            sentryAppStartProfilingOptions.isStartProfilerOnAppStart = boolNextBooleanOrNull5.booleanValue();
                        }
                        break;
                    case 6:
                        Boolean boolNextBooleanOrNull6 = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull6 != null) {
                            sentryAppStartProfilingOptions.profileSampled = boolNextBooleanOrNull6.booleanValue();
                        }
                        break;
                    case 7:
                        String strNextStringOrNull2 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull2 != null) {
                            try {
                                sentryAppStartProfilingOptions.profileLifecycle = ProfileLifecycle.valueOf(strNextStringOrNull2);
                            } catch (IllegalArgumentException unused) {
                                iLogger.log(SentryLevel.ERROR, "Error when deserializing ProfileLifecycle: " + strNextStringOrNull2, new Object[0]);
                            }
                        }
                        break;
                    case 8:
                        Boolean boolNextBooleanOrNull7 = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull7 != null) {
                            sentryAppStartProfilingOptions.continuousProfileSampled = boolNextBooleanOrNull7.booleanValue();
                        }
                        break;
                    case 9:
                        Integer numNextIntegerOrNull = objectReader.nextIntegerOrNull();
                        if (numNextIntegerOrNull != null) {
                            sentryAppStartProfilingOptions.profilingTracesHz = numNextIntegerOrNull.intValue();
                        }
                        break;
                    case 10:
                        Double dNextDoubleOrNull = objectReader.nextDoubleOrNull();
                        if (dNextDoubleOrNull != null) {
                            sentryAppStartProfilingOptions.traceSampleRate = dNextDoubleOrNull;
                        }
                        break;
                    case 11:
                        Double dNextDoubleOrNull2 = objectReader.nextDoubleOrNull();
                        if (dNextDoubleOrNull2 != null) {
                            sentryAppStartProfilingOptions.profileSampleRate = dNextDoubleOrNull2;
                        }
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            sentryAppStartProfilingOptions.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return sentryAppStartProfilingOptions;
        }
    }
}
