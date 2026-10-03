package io.sentry.protocol;

import com.google.common.base.Ascii;
import io.sentry.DateUtils;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.Span;
import io.sentry.SpanId;
import io.sentry.SpanStatus;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SentrySpan implements JsonUnknown, JsonSerializable {
    private Map<String, Object> data;
    private final String description;
    private final Map<String, MeasurementValue> measurements;
    private final String op;
    private final String origin;
    private final SpanId parentSpanId;
    private final SpanId spanId;
    private final Double startTimestamp;
    private final SpanStatus status;
    private final Map<String, String> tags;
    private final Double timestamp;
    private final SentryId traceId;
    private Map<String, Object> unknown;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String DATA = "data";
        public static final String DESCRIPTION = "description";
        public static final String MEASUREMENTS = "measurements";
        public static final String OP = "op";
        public static final String ORIGIN = "origin";
        public static final String PARENT_SPAN_ID = "parent_span_id";
        public static final String SPAN_ID = "span_id";
        public static final String START_TIMESTAMP = "start_timestamp";
        public static final String STATUS = "status";
        public static final String TAGS = "tags";
        public static final String TIMESTAMP = "timestamp";
        public static final String TRACE_ID = "trace_id";
    }

    public SentrySpan(@NotNull Span span) {
        this(span, span.getData());
    }

    public SentrySpan(@NotNull Span span, @Nullable Map<String, Object> map) {
        Objects.requireNonNull(span, "span is required");
        this.description = span.getDescription();
        this.op = span.getOperation();
        this.spanId = span.getSpanId();
        this.parentSpanId = span.getParentSpanId();
        this.traceId = span.getTraceId();
        this.status = span.getStatus();
        this.origin = span.getSpanContext().getOrigin();
        Map<String, String> mapNewConcurrentHashMap = CollectionUtils.newConcurrentHashMap(span.getTags());
        this.tags = mapNewConcurrentHashMap == null ? new ConcurrentHashMap<>() : mapNewConcurrentHashMap;
        Map<String, MeasurementValue> mapNewConcurrentHashMap2 = CollectionUtils.newConcurrentHashMap(span.getMeasurements());
        this.measurements = mapNewConcurrentHashMap2 == null ? new ConcurrentHashMap<>() : mapNewConcurrentHashMap2;
        this.timestamp = span.getFinishDate() == null ? null : Double.valueOf(DateUtils.nanosToSeconds(span.getStartDate().laterDateNanosTimestampByDiff(span.getFinishDate())));
        this.startTimestamp = Double.valueOf(DateUtils.nanosToSeconds(span.getStartDate().nanoTimestamp()));
        this.data = map;
    }

    public SentrySpan(@NotNull Double d, @Nullable Double d2, @NotNull SentryId sentryId, @NotNull SpanId spanId, @Nullable SpanId spanId2, @NotNull String str, @Nullable String str2, @Nullable SpanStatus spanStatus, @Nullable String str3, @NotNull Map<String, String> map, @NotNull Map<String, MeasurementValue> map2, @Nullable Map<String, Object> map3) {
        this.startTimestamp = d;
        this.timestamp = d2;
        this.traceId = sentryId;
        this.spanId = spanId;
        this.parentSpanId = spanId2;
        this.op = str;
        this.description = str2;
        this.status = spanStatus;
        this.origin = str3;
        this.tags = map;
        this.measurements = map2;
        this.data = map3;
    }

    public boolean isFinished() {
        return this.timestamp != null;
    }

    public Double getStartTimestamp() {
        return this.startTimestamp;
    }

    public Double getTimestamp() {
        return this.timestamp;
    }

    public SentryId getTraceId() {
        return this.traceId;
    }

    public SpanId getSpanId() {
        return this.spanId;
    }

    public SpanId getParentSpanId() {
        return this.parentSpanId;
    }

    public String getOp() {
        return this.op;
    }

    public String getDescription() {
        return this.description;
    }

    public SpanStatus getStatus() {
        return this.status;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public void setData(@Nullable Map<String, Object> map) {
        this.data = map;
    }

    public String getOrigin() {
        return this.origin;
    }

    public Map<String, MeasurementValue> getMeasurements() {
        return this.measurements;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("start_timestamp").value(iLogger, doubleToBigDecimal(this.startTimestamp));
        if (this.timestamp != null) {
            objectWriter.name("timestamp").value(iLogger, doubleToBigDecimal(this.timestamp));
        }
        objectWriter.name("trace_id").value(iLogger, this.traceId);
        objectWriter.name("span_id").value(iLogger, this.spanId);
        if (this.parentSpanId != null) {
            objectWriter.name("parent_span_id").value(iLogger, this.parentSpanId);
        }
        objectWriter.name("op").value(this.op);
        if (this.description != null) {
            objectWriter.name("description").value(this.description);
        }
        if (this.status != null) {
            objectWriter.name("status").value(iLogger, this.status);
        }
        if (this.origin != null) {
            objectWriter.name("origin").value(iLogger, this.origin);
        }
        if (!this.tags.isEmpty()) {
            objectWriter.name("tags").value(iLogger, this.tags);
        }
        if (this.data != null) {
            objectWriter.name("data").value(iLogger, this.data);
        }
        if (!this.measurements.isEmpty()) {
            objectWriter.name("measurements").value(iLogger, this.measurements);
        }
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

    private BigDecimal doubleToBigDecimal(@NotNull Double d) {
        return BigDecimal.valueOf(d.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    @Override // io.sentry.JsonUnknown
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.JsonUnknown
    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer<SentrySpan> {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:56:0x00c6  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // io.sentry.JsonDeserializer
        public SentrySpan deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            Map map = null;
            Double dValueOf = null;
            Double dValueOf2 = null;
            SentryId sentryIdDeserialize = null;
            SpanId spanIdDeserialize = null;
            SpanId spanId = null;
            String strNextStringOrNull = null;
            String strNextStringOrNull2 = null;
            SpanStatus spanStatus = null;
            String strNextStringOrNull3 = null;
            Map mapNextMapOrNull = null;
            ConcurrentHashMap concurrentHashMap = null;
            Map map2 = null;
            while (true) {
                String str = strNextStringOrNull3;
                SpanStatus spanStatus2 = spanStatus;
                String str2 = strNextStringOrNull2;
                SpanId spanId2 = spanId;
                if (objectReader.peek() != JsonToken.NAME) {
                    if (dValueOf == null) {
                        throw missingRequiredFieldException("start_timestamp", iLogger);
                    }
                    if (sentryIdDeserialize == null) {
                        throw missingRequiredFieldException("trace_id", iLogger);
                    }
                    if (spanIdDeserialize == null) {
                        throw missingRequiredFieldException("span_id", iLogger);
                    }
                    if (strNextStringOrNull == null) {
                        throw missingRequiredFieldException("op", iLogger);
                    }
                    Map map3 = map == null ? new HashMap() : map;
                    Map map4 = mapNextMapOrNull == null ? new HashMap() : mapNextMapOrNull;
                    SentrySpan sentrySpan = new SentrySpan(dValueOf, dValueOf2, sentryIdDeserialize, spanIdDeserialize, spanId2, strNextStringOrNull, str2, spanStatus2, str, map3, map4, map2);
                    sentrySpan.setUnknown(concurrentHashMap);
                    objectReader.endObject();
                    return sentrySpan;
                }
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName.hashCode()) {
                    case -2011840976:
                        if (!strNextName.equals("span_id")) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    case -1757797477:
                        if (!strNextName.equals("parent_span_id")) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case -1724546052:
                        if (!strNextName.equals("description")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case -1526966919:
                        if (!strNextName.equals("start_timestamp")) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    case -1008619738:
                        if (!strNextName.equals("origin")) {
                            b = -1;
                        } else {
                            b = 4;
                        }
                        break;
                    case -892481550:
                        if (!strNextName.equals("status")) {
                            b = -1;
                        } else {
                            b = 5;
                        }
                        break;
                    case -362243017:
                        if (!strNextName.equals("measurements")) {
                            b = -1;
                        } else {
                            b = 6;
                        }
                        break;
                    case 3553:
                        if (!strNextName.equals("op")) {
                            b = -1;
                        } else {
                            b = 7;
                        }
                        break;
                    case 3076010:
                        if (!strNextName.equals("data")) {
                            b = -1;
                        } else {
                            b = 8;
                        }
                        break;
                    case 3552281:
                        if (!strNextName.equals("tags")) {
                            b = -1;
                        } else {
                            b = 9;
                        }
                        break;
                    case 55126294:
                        if (!strNextName.equals("timestamp")) {
                            b = -1;
                        } else {
                            b = 10;
                        }
                        break;
                    case 1270300245:
                        if (!strNextName.equals("trace_id")) {
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
                        spanIdDeserialize = new SpanId.Deserializer().deserialize(objectReader, iLogger);
                        strNextStringOrNull3 = str;
                        spanStatus = spanStatus2;
                        strNextStringOrNull2 = str2;
                        spanId = spanId2;
                        break;
                    case 1:
                        spanId = (SpanId) objectReader.nextOrNull(iLogger, new SpanId.Deserializer());
                        strNextStringOrNull3 = str;
                        spanStatus = spanStatus2;
                        strNextStringOrNull2 = str2;
                        break;
                    case 2:
                        strNextStringOrNull2 = objectReader.nextStringOrNull();
                        strNextStringOrNull3 = str;
                        spanStatus = spanStatus2;
                        spanId = spanId2;
                        break;
                    case 3:
                        try {
                            dValueOf = objectReader.nextDoubleOrNull();
                        } catch (NumberFormatException unused) {
                            Date dateNextDateOrNull = objectReader.nextDateOrNull(iLogger);
                            if (dateNextDateOrNull != null) {
                                dValueOf = Double.valueOf(DateUtils.dateToSeconds(dateNextDateOrNull));
                            } else {
                                strNextStringOrNull3 = str;
                                spanStatus = spanStatus2;
                                strNextStringOrNull2 = str2;
                                spanId = spanId2;
                                dValueOf = null;
                            }
                        }
                        strNextStringOrNull3 = str;
                        spanStatus = spanStatus2;
                        strNextStringOrNull2 = str2;
                        spanId = spanId2;
                        break;
                    case 4:
                        strNextStringOrNull3 = objectReader.nextStringOrNull();
                        spanStatus = spanStatus2;
                        strNextStringOrNull2 = str2;
                        spanId = spanId2;
                        break;
                    case 5:
                        spanStatus = (SpanStatus) objectReader.nextOrNull(iLogger, new SpanStatus.Deserializer());
                        strNextStringOrNull3 = str;
                        strNextStringOrNull2 = str2;
                        spanId = spanId2;
                        break;
                    case 6:
                        mapNextMapOrNull = objectReader.nextMapOrNull(iLogger, new MeasurementValue.Deserializer());
                        strNextStringOrNull3 = str;
                        spanStatus = spanStatus2;
                        strNextStringOrNull2 = str2;
                        spanId = spanId2;
                        break;
                    case 7:
                        strNextStringOrNull = objectReader.nextStringOrNull();
                        strNextStringOrNull3 = str;
                        spanStatus = spanStatus2;
                        strNextStringOrNull2 = str2;
                        spanId = spanId2;
                        break;
                    case 8:
                        map2 = (Map) objectReader.nextObjectOrNull();
                        strNextStringOrNull3 = str;
                        spanStatus = spanStatus2;
                        strNextStringOrNull2 = str2;
                        spanId = spanId2;
                        break;
                    case 9:
                        map = (Map) objectReader.nextObjectOrNull();
                        strNextStringOrNull3 = str;
                        spanStatus = spanStatus2;
                        strNextStringOrNull2 = str2;
                        spanId = spanId2;
                        break;
                    case 10:
                        try {
                            dValueOf2 = objectReader.nextDoubleOrNull();
                        } catch (NumberFormatException unused2) {
                            Date dateNextDateOrNull2 = objectReader.nextDateOrNull(iLogger);
                            if (dateNextDateOrNull2 != null) {
                                dValueOf2 = Double.valueOf(DateUtils.dateToSeconds(dateNextDateOrNull2));
                            } else {
                                strNextStringOrNull3 = str;
                                spanStatus = spanStatus2;
                                strNextStringOrNull2 = str2;
                                spanId = spanId2;
                                dValueOf2 = null;
                            }
                        }
                        strNextStringOrNull3 = str;
                        spanStatus = spanStatus2;
                        strNextStringOrNull2 = str2;
                        spanId = spanId2;
                        break;
                    case 11:
                        sentryIdDeserialize = new SentryId.Deserializer().deserialize(objectReader, iLogger);
                        strNextStringOrNull3 = str;
                        spanStatus = spanStatus2;
                        strNextStringOrNull2 = str2;
                        spanId = spanId2;
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        strNextStringOrNull3 = str;
                        spanStatus = spanStatus2;
                        strNextStringOrNull2 = str2;
                        spanId = spanId2;
                        break;
                }
            }
        }

        private Exception missingRequiredFieldException(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.log(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }
    }
}
