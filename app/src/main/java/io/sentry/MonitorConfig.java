package io.sentry;

import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class MonitorConfig implements JsonUnknown, JsonSerializable {
    private Long checkinMargin;
    private Long failureIssueThreshold;
    private Long maxRuntime;
    private Long recoveryThreshold;
    private MonitorSchedule schedule;
    private String timezone;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String CHECKIN_MARGIN = "checkin_margin";
        public static final String FAILURE_ISSUE_THRESHOLD = "failure_issue_threshold";
        public static final String MAX_RUNTIME = "max_runtime";
        public static final String RECOVERY_THRESHOLD = "recovery_threshold";
        public static final String SCHEDULE = "schedule";
        public static final String TIMEZONE = "timezone";
    }

    public MonitorConfig(@NotNull MonitorSchedule monitorSchedule) {
        this.schedule = monitorSchedule;
        SentryOptions.Cron cron = ScopesAdapter.getInstance().getOptions().getCron();
        if (cron != null) {
            this.checkinMargin = cron.getDefaultCheckinMargin();
            this.maxRuntime = cron.getDefaultMaxRuntime();
            this.timezone = cron.getDefaultTimezone();
            this.failureIssueThreshold = cron.getDefaultFailureIssueThreshold();
            this.recoveryThreshold = cron.getDefaultRecoveryThreshold();
        }
    }

    public MonitorSchedule getSchedule() {
        return this.schedule;
    }

    public void setSchedule(@NotNull MonitorSchedule monitorSchedule) {
        this.schedule = monitorSchedule;
    }

    public Long getCheckinMargin() {
        return this.checkinMargin;
    }

    public void setCheckinMargin(@Nullable Long l) {
        this.checkinMargin = l;
    }

    public Long getMaxRuntime() {
        return this.maxRuntime;
    }

    public void setMaxRuntime(@Nullable Long l) {
        this.maxRuntime = l;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(@Nullable String str) {
        this.timezone = str;
    }

    public Long getFailureIssueThreshold() {
        return this.failureIssueThreshold;
    }

    public void setFailureIssueThreshold(@Nullable Long l) {
        this.failureIssueThreshold = l;
    }

    public Long getRecoveryThreshold() {
        return this.recoveryThreshold;
    }

    public void setRecoveryThreshold(@Nullable Long l) {
        this.recoveryThreshold = l;
    }

    @Override // io.sentry.JsonUnknown
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.JsonUnknown
    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("schedule");
        this.schedule.serialize(objectWriter, iLogger);
        if (this.checkinMargin != null) {
            objectWriter.name(JsonKeys.CHECKIN_MARGIN).value(this.checkinMargin);
        }
        if (this.maxRuntime != null) {
            objectWriter.name(JsonKeys.MAX_RUNTIME).value(this.maxRuntime);
        }
        if (this.timezone != null) {
            objectWriter.name("timezone").value(this.timezone);
        }
        if (this.failureIssueThreshold != null) {
            objectWriter.name(JsonKeys.FAILURE_ISSUE_THRESHOLD).value(this.failureIssueThreshold);
        }
        if (this.recoveryThreshold != null) {
            objectWriter.name(JsonKeys.RECOVERY_THRESHOLD).value(this.recoveryThreshold);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<MonitorConfig> {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:32:0x006c  */
        @Override // io.sentry.JsonDeserializer
        public MonitorConfig deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            MonitorSchedule monitorScheduleDeserialize = null;
            Long lNextLongOrNull = null;
            Long lNextLongOrNull2 = null;
            String strNextStringOrNull = null;
            Long lNextLongOrNull3 = null;
            Long lNextLongOrNull4 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "timezone":
                        b = 0;
                        break;
                    case "checkin_margin":
                        b = 1;
                        break;
                    case "schedule":
                        b = 2;
                        break;
                    case "recovery_threshold":
                        b = 3;
                        break;
                    case "max_runtime":
                        b = 4;
                        break;
                    case "failure_issue_threshold":
                        b = 5;
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    strNextStringOrNull = objectReader.nextStringOrNull();
                } else if (b == 1) {
                    lNextLongOrNull = objectReader.nextLongOrNull();
                } else if (b == 2) {
                    monitorScheduleDeserialize = new MonitorSchedule.Deserializer().deserialize(objectReader, iLogger);
                } else if (b == 3) {
                    lNextLongOrNull4 = objectReader.nextLongOrNull();
                } else if (b == 4) {
                    lNextLongOrNull2 = objectReader.nextLongOrNull();
                } else if (b == 5) {
                    lNextLongOrNull3 = objectReader.nextLongOrNull();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            objectReader.endObject();
            if (monitorScheduleDeserialize == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"schedule\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"schedule\"", illegalStateException);
                throw illegalStateException;
            }
            MonitorConfig monitorConfig = new MonitorConfig(monitorScheduleDeserialize);
            monitorConfig.setCheckinMargin(lNextLongOrNull);
            monitorConfig.setMaxRuntime(lNextLongOrNull2);
            monitorConfig.setTimezone(strNextStringOrNull);
            monitorConfig.setFailureIssueThreshold(lNextLongOrNull3);
            monitorConfig.setRecoveryThreshold(lNextLongOrNull4);
            monitorConfig.setUnknown(map);
            return monitorConfig;
        }
    }
}
