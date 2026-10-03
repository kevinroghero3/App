package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SentryReplayEvent extends SentryBaseEvent implements JsonUnknown, JsonSerializable {
    public static final String REPLAY_EVENT_TYPE = "replay_event";
    public static final long REPLAY_VIDEO_MAX_SIZE = 10485760;
    private Date replayStartTimestamp;
    private int segmentId;
    private Map<String, Object> unknown;
    private File videoFile;
    private SentryId replayId = new SentryId();
    private String type = REPLAY_EVENT_TYPE;
    private ReplayType replayType = ReplayType.SESSION;
    private List<String> errorIds = new ArrayList();
    private List<String> traceIds = new ArrayList();
    private List<String> urls = new ArrayList();
    private Date timestamp = DateUtils.getCurrentDateTime();

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String ERROR_IDS = "error_ids";
        public static final String REPLAY_ID = "replay_id";
        public static final String REPLAY_START_TIMESTAMP = "replay_start_timestamp";
        public static final String REPLAY_TYPE = "replay_type";
        public static final String SEGMENT_ID = "segment_id";
        public static final String TIMESTAMP = "timestamp";
        public static final String TRACE_IDS = "trace_ids";
        public static final String TYPE = "type";
        public static final String URLS = "urls";
    }

    public enum ReplayType implements JsonSerializable {
        SESSION,
        BUFFER;

        @Override // io.sentry.JsonSerializable
        public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
            objectWriter.value(name().toLowerCase(Locale.ROOT));
        }

        /* JADX INFO: loaded from: classes6.dex */
        public static final class Deserializer implements JsonDeserializer<ReplayType> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.sentry.JsonDeserializer
            public ReplayType deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
                return ReplayType.valueOf(objectReader.nextString().toUpperCase(Locale.ROOT));
            }
        }
    }

    public File getVideoFile() {
        return this.videoFile;
    }

    public void setVideoFile(@Nullable File file) {
        this.videoFile = file;
    }

    public String getType() {
        return this.type;
    }

    public void setType(@NotNull String str) {
        this.type = str;
    }

    public SentryId getReplayId() {
        return this.replayId;
    }

    public void setReplayId(@Nullable SentryId sentryId) {
        this.replayId = sentryId;
    }

    public int getSegmentId() {
        return this.segmentId;
    }

    public void setSegmentId(int i) {
        this.segmentId = i;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(@NotNull Date date) {
        this.timestamp = date;
    }

    public Date getReplayStartTimestamp() {
        return this.replayStartTimestamp;
    }

    public void setReplayStartTimestamp(@Nullable Date date) {
        this.replayStartTimestamp = date;
    }

    public List<String> getUrls() {
        return this.urls;
    }

    public void setUrls(@Nullable List<String> list) {
        this.urls = list;
    }

    public List<String> getErrorIds() {
        return this.errorIds;
    }

    public void setErrorIds(@Nullable List<String> list) {
        this.errorIds = list;
    }

    public List<String> getTraceIds() {
        return this.traceIds;
    }

    public void setTraceIds(@Nullable List<String> list) {
        this.traceIds = list;
    }

    public ReplayType getReplayType() {
        return this.replayType;
    }

    public void setReplayType(@NotNull ReplayType replayType) {
        this.replayType = replayType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SentryReplayEvent.class != obj.getClass()) {
            return false;
        }
        SentryReplayEvent sentryReplayEvent = (SentryReplayEvent) obj;
        return this.segmentId == sentryReplayEvent.segmentId && Objects.equals(this.type, sentryReplayEvent.type) && this.replayType == sentryReplayEvent.replayType && Objects.equals(this.replayId, sentryReplayEvent.replayId) && Objects.equals(this.urls, sentryReplayEvent.urls) && Objects.equals(this.errorIds, sentryReplayEvent.errorIds) && Objects.equals(this.traceIds, sentryReplayEvent.traceIds);
    }

    public int hashCode() {
        String str = this.type;
        ReplayType replayType = this.replayType;
        SentryId sentryId = this.replayId;
        int i = this.segmentId;
        return Objects.hash(str, replayType, sentryId, Integer.valueOf(i), this.urls, this.errorIds, this.traceIds);
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("type").value(this.type);
        objectWriter.name(JsonKeys.REPLAY_TYPE).value(iLogger, this.replayType);
        objectWriter.name("segment_id").value(this.segmentId);
        objectWriter.name("timestamp").value(iLogger, this.timestamp);
        if (this.replayId != null) {
            objectWriter.name("replay_id").value(iLogger, this.replayId);
        }
        if (this.replayStartTimestamp != null) {
            objectWriter.name(JsonKeys.REPLAY_START_TIMESTAMP).value(iLogger, this.replayStartTimestamp);
        }
        if (this.urls != null) {
            objectWriter.name(JsonKeys.URLS).value(iLogger, this.urls);
        }
        if (this.errorIds != null) {
            objectWriter.name(JsonKeys.ERROR_IDS).value(iLogger, this.errorIds);
        }
        if (this.traceIds != null) {
            objectWriter.name(JsonKeys.TRACE_IDS).value(iLogger, this.traceIds);
        }
        new SentryBaseEvent.Serializer().serialize(this, objectWriter, iLogger);
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

    public static final class Deserializer implements JsonDeserializer<SentryReplayEvent> {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:44:0x0099  */
        @Override // io.sentry.JsonDeserializer
        public SentryReplayEvent deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            SentryBaseEvent.Deserializer deserializer = new SentryBaseEvent.Deserializer();
            SentryReplayEvent sentryReplayEvent = new SentryReplayEvent();
            objectReader.beginObject();
            String strNextStringOrNull = null;
            ReplayType replayType = null;
            Integer numNextIntegerOrNull = null;
            Date dateNextDateOrNull = null;
            HashMap map = null;
            SentryId sentryId = null;
            Date dateNextDateOrNull2 = null;
            List<String> list = null;
            List<String> list2 = null;
            List<String> list3 = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "replay_id":
                        sentryId = (SentryId) objectReader.nextOrNull(iLogger, new SentryId.Deserializer());
                        break;
                    case "replay_start_timestamp":
                        dateNextDateOrNull2 = objectReader.nextDateOrNull(iLogger);
                        break;
                    case "type":
                        strNextStringOrNull = objectReader.nextStringOrNull();
                        break;
                    case "urls":
                        list = (List) objectReader.nextObjectOrNull();
                        break;
                    case "timestamp":
                        dateNextDateOrNull = objectReader.nextDateOrNull(iLogger);
                        break;
                    case "error_ids":
                        list2 = (List) objectReader.nextObjectOrNull();
                        break;
                    case "trace_ids":
                        list3 = (List) objectReader.nextObjectOrNull();
                        break;
                    case "replay_type":
                        replayType = (ReplayType) objectReader.nextOrNull(iLogger, new ReplayType.Deserializer());
                        break;
                    case "segment_id":
                        numNextIntegerOrNull = objectReader.nextIntegerOrNull();
                        break;
                    default:
                        if (!deserializer.deserializeValue(sentryReplayEvent, strNextName, objectReader, iLogger)) {
                            if (map == null) {
                                map = new HashMap();
                            }
                            objectReader.nextUnknown(iLogger, map, strNextName);
                            break;
                        } else {
                            break;
                        }
                        break;
                }
            }
            objectReader.endObject();
            if (strNextStringOrNull != null) {
                sentryReplayEvent.setType(strNextStringOrNull);
            }
            if (replayType != null) {
                sentryReplayEvent.setReplayType(replayType);
            }
            if (numNextIntegerOrNull != null) {
                sentryReplayEvent.setSegmentId(numNextIntegerOrNull.intValue());
            }
            if (dateNextDateOrNull != null) {
                sentryReplayEvent.setTimestamp(dateNextDateOrNull);
            }
            sentryReplayEvent.setReplayId(sentryId);
            sentryReplayEvent.setReplayStartTimestamp(dateNextDateOrNull2);
            sentryReplayEvent.setUrls(list);
            sentryReplayEvent.setErrorIds(list2);
            sentryReplayEvent.setTraceIds(list3);
            sentryReplayEvent.setUnknown(map);
            return sentryReplayEvent;
        }
    }
}
