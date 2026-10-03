package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SentryLogEvent implements JsonUnknown, JsonSerializable {
    private Map<String, SentryLogEventAttributeValue> attributes;
    private String body;
    private SentryLogLevel level;
    private Integer severityNumber;
    private Double timestamp;
    private SentryId traceId;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String ATTRIBUTES = "attributes";
        public static final String BODY = "body";
        public static final String LEVEL = "level";
        public static final String SEVERITY_NUMBER = "severity_number";
        public static final String TIMESTAMP = "timestamp";
        public static final String TRACE_ID = "trace_id";
    }

    public SentryLogEvent(@NotNull SentryId sentryId, @NotNull SentryDate sentryDate, @NotNull String str, @NotNull SentryLogLevel sentryLogLevel) {
        this(sentryId, Double.valueOf(DateUtils.nanosToSeconds(sentryDate.nanoTimestamp())), str, sentryLogLevel);
    }

    public SentryLogEvent(@NotNull SentryId sentryId, @NotNull Double d, @NotNull String str, @NotNull SentryLogLevel sentryLogLevel) {
        this.traceId = sentryId;
        this.timestamp = d;
        this.body = str;
        this.level = sentryLogLevel;
    }

    public Double getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(@NotNull Double d) {
        this.timestamp = d;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(@NotNull String str) {
        this.body = str;
    }

    public SentryLogLevel getLevel() {
        return this.level;
    }

    public void setLevel(@NotNull SentryLogLevel sentryLogLevel) {
        this.level = sentryLogLevel;
    }

    public Map<String, SentryLogEventAttributeValue> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(@Nullable Map<String, SentryLogEventAttributeValue> map) {
        this.attributes = map;
    }

    public void setAttribute(@Nullable String str, @Nullable SentryLogEventAttributeValue sentryLogEventAttributeValue) {
        if (str == null) {
            return;
        }
        if (this.attributes == null) {
            this.attributes = new HashMap();
        }
        this.attributes.put(str, sentryLogEventAttributeValue);
    }

    public Integer getSeverityNumber() {
        return this.severityNumber;
    }

    public void setSeverityNumber(@Nullable Integer num) {
        this.severityNumber = num;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("timestamp").value(iLogger, DateUtils.doubleToBigDecimal(this.timestamp));
        objectWriter.name("trace_id").value(iLogger, this.traceId);
        objectWriter.name("body").value(this.body);
        objectWriter.name("level").value(iLogger, this.level);
        if (this.severityNumber != null) {
            objectWriter.name(JsonKeys.SEVERITY_NUMBER).value(iLogger, this.severityNumber);
        }
        if (this.attributes != null) {
            objectWriter.name("attributes").value(iLogger, this.attributes);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
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

    public static final class Deserializer implements JsonDeserializer<SentryLogEvent> {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:32:0x006c  */
        @Override // io.sentry.JsonDeserializer
        public SentryLogEvent deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            SentryId sentryId = null;
            Double dNextDoubleOrNull = null;
            String strNextStringOrNull = null;
            SentryLogLevel sentryLogLevel = null;
            HashMap map = null;
            Map<String, SentryLogEventAttributeValue> mapNextMapOrNull = null;
            Integer numNextIntegerOrNull = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "severity_number":
                        b = 0;
                        break;
                    case "body":
                        b = 1;
                        break;
                    case "timestamp":
                        b = 2;
                        break;
                    case "level":
                        b = 3;
                        break;
                    case "attributes":
                        b = 4;
                        break;
                    case "trace_id":
                        b = 5;
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    numNextIntegerOrNull = objectReader.nextIntegerOrNull();
                } else if (b == 1) {
                    strNextStringOrNull = objectReader.nextStringOrNull();
                } else if (b == 2) {
                    dNextDoubleOrNull = objectReader.nextDoubleOrNull();
                } else if (b == 3) {
                    sentryLogLevel = (SentryLogLevel) objectReader.nextOrNull(iLogger, new SentryLogLevel.Deserializer());
                } else if (b == 4) {
                    mapNextMapOrNull = objectReader.nextMapOrNull(iLogger, new SentryLogEventAttributeValue.Deserializer());
                } else if (b == 5) {
                    sentryId = (SentryId) objectReader.nextOrNull(iLogger, new SentryId.Deserializer());
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            objectReader.endObject();
            if (sentryId == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"trace_id\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"trace_id\"", illegalStateException);
                throw illegalStateException;
            }
            if (dNextDoubleOrNull == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"timestamp\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"timestamp\"", illegalStateException2);
                throw illegalStateException2;
            }
            if (strNextStringOrNull == null) {
                IllegalStateException illegalStateException3 = new IllegalStateException("Missing required field \"body\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"body\"", illegalStateException3);
                throw illegalStateException3;
            }
            if (sentryLogLevel == null) {
                IllegalStateException illegalStateException4 = new IllegalStateException("Missing required field \"level\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"level\"", illegalStateException4);
                throw illegalStateException4;
            }
            SentryLogEvent sentryLogEvent = new SentryLogEvent(sentryId, dNextDoubleOrNull, strNextStringOrNull, sentryLogLevel);
            sentryLogEvent.setAttributes(mapNextMapOrNull);
            sentryLogEvent.setSeverityNumber(numNextIntegerOrNull);
            sentryLogEvent.setUnknown(map);
            return sentryLogEvent;
        }
    }
}
