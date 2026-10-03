package io.sentry.rrweb;

import com.google.common.base.Ascii;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class RRWebVideoEvent extends RRWebEvent implements JsonUnknown, JsonSerializable {
    public static final String EVENT_TAG = "video";
    public static final String REPLAY_CONTAINER = "mp4";
    public static final String REPLAY_ENCODING = "h264";
    public static final String REPLAY_FRAME_RATE_TYPE_CONSTANT = "constant";
    public static final String REPLAY_FRAME_RATE_TYPE_VARIABLE = "variable";
    private String container;
    private Map<String, Object> dataUnknown;
    private long durationMs;
    private String encoding;
    private int frameCount;
    private int frameRate;
    private String frameRateType;
    private int height;
    private int left;
    private Map<String, Object> payloadUnknown;
    private int segmentId;
    private long size;
    private String tag;
    private int top;
    private Map<String, Object> unknown;
    private int width;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String CONTAINER = "container";
        public static final String DATA = "data";
        public static final String DURATION = "duration";
        public static final String ENCODING = "encoding";
        public static final String FRAME_COUNT = "frameCount";
        public static final String FRAME_RATE = "frameRate";
        public static final String FRAME_RATE_TYPE = "frameRateType";
        public static final String HEIGHT = "height";
        public static final String LEFT = "left";
        public static final String PAYLOAD = "payload";
        public static final String SEGMENT_ID = "segmentId";
        public static final String SIZE = "size";
        public static final String TOP = "top";
        public static final String WIDTH = "width";
    }

    public RRWebVideoEvent() {
        super(RRWebEventType.Custom);
        this.encoding = REPLAY_ENCODING;
        this.container = REPLAY_CONTAINER;
        this.frameRateType = REPLAY_FRAME_RATE_TYPE_CONSTANT;
        this.tag = "video";
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(@NotNull String str) {
        this.tag = str;
    }

    public int getSegmentId() {
        return this.segmentId;
    }

    public void setSegmentId(int i) {
        this.segmentId = i;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public long getDurationMs() {
        return this.durationMs;
    }

    public void setDurationMs(long j) {
        this.durationMs = j;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setEncoding(@NotNull String str) {
        this.encoding = str;
    }

    public String getContainer() {
        return this.container;
    }

    public void setContainer(@NotNull String str) {
        this.container = str;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getFrameCount() {
        return this.frameCount;
    }

    public void setFrameCount(int i) {
        this.frameCount = i;
    }

    public String getFrameRateType() {
        return this.frameRateType;
    }

    public void setFrameRateType(@NotNull String str) {
        this.frameRateType = str;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public void setFrameRate(int i) {
        this.frameRate = i;
    }

    public int getLeft() {
        return this.left;
    }

    public void setLeft(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.top;
    }

    public void setTop(int i) {
        this.top = i;
    }

    public Map<String, Object> getPayloadUnknown() {
        return this.payloadUnknown;
    }

    public void setPayloadUnknown(@Nullable Map<String, Object> map) {
        this.payloadUnknown = map;
    }

    public Map<String, Object> getDataUnknown() {
        return this.dataUnknown;
    }

    public void setDataUnknown(@Nullable Map<String, Object> map) {
        this.dataUnknown = map;
    }

    @Override // io.sentry.JsonUnknown
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.JsonUnknown
    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    @Override // io.sentry.rrweb.RRWebEvent
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RRWebVideoEvent.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        RRWebVideoEvent rRWebVideoEvent = (RRWebVideoEvent) obj;
        return this.segmentId == rRWebVideoEvent.segmentId && this.size == rRWebVideoEvent.size && this.durationMs == rRWebVideoEvent.durationMs && this.height == rRWebVideoEvent.height && this.width == rRWebVideoEvent.width && this.frameCount == rRWebVideoEvent.frameCount && this.frameRate == rRWebVideoEvent.frameRate && this.left == rRWebVideoEvent.left && this.top == rRWebVideoEvent.top && Objects.equals(this.tag, rRWebVideoEvent.tag) && Objects.equals(this.encoding, rRWebVideoEvent.encoding) && Objects.equals(this.container, rRWebVideoEvent.container) && Objects.equals(this.frameRateType, rRWebVideoEvent.frameRateType);
    }

    @Override // io.sentry.rrweb.RRWebEvent
    public int hashCode() {
        int iHashCode = super.hashCode();
        String str = this.tag;
        int i = this.segmentId;
        long j = this.size;
        long j2 = this.durationMs;
        String str2 = this.encoding;
        String str3 = this.container;
        int i2 = this.height;
        int i3 = this.width;
        int i4 = this.frameCount;
        return Objects.hash(Integer.valueOf(iHashCode), str, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), this.frameRateType, Integer.valueOf(this.frameRate), Integer.valueOf(this.left), Integer.valueOf(this.top));
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        new RRWebEvent.Serializer().serialize(this, objectWriter, iLogger);
        objectWriter.name("data");
        serializeData(objectWriter, iLogger);
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

    private void serializeData(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("tag").value(this.tag);
        objectWriter.name("payload");
        serializePayload(objectWriter, iLogger);
        Map<String, Object> map = this.dataUnknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.dataUnknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    private void serializePayload(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name(JsonKeys.SEGMENT_ID).value(this.segmentId);
        objectWriter.name(JsonKeys.SIZE).value(this.size);
        objectWriter.name("duration").value(this.durationMs);
        objectWriter.name(JsonKeys.ENCODING).value(this.encoding);
        objectWriter.name(JsonKeys.CONTAINER).value(this.container);
        objectWriter.name("height").value(this.height);
        objectWriter.name("width").value(this.width);
        objectWriter.name(JsonKeys.FRAME_COUNT).value(this.frameCount);
        objectWriter.name(JsonKeys.FRAME_RATE).value(this.frameRate);
        objectWriter.name(JsonKeys.FRAME_RATE_TYPE).value(this.frameRateType);
        objectWriter.name("left").value(this.left);
        objectWriter.name("top").value(this.top);
        Map<String, Object> map = this.payloadUnknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.payloadUnknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<RRWebVideoEvent> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.JsonDeserializer
        public RRWebVideoEvent deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            objectReader.beginObject();
            RRWebVideoEvent rRWebVideoEvent = new RRWebVideoEvent();
            RRWebEvent.Deserializer deserializer = new RRWebEvent.Deserializer();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                if (strNextName.equals("data")) {
                    deserializeData(rRWebVideoEvent, objectReader, iLogger);
                } else if (!deserializer.deserializeValue(rRWebVideoEvent, strNextName, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            rRWebVideoEvent.setUnknown(map);
            objectReader.endObject();
            return rRWebVideoEvent;
        }

        private void deserializeData(@NotNull RRWebVideoEvent rRWebVideoEvent, @NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                if (strNextName.equals("payload")) {
                    deserializePayload(rRWebVideoEvent, objectReader, iLogger);
                } else if (strNextName.equals("tag")) {
                    String strNextStringOrNull = objectReader.nextStringOrNull();
                    if (strNextStringOrNull == null) {
                        strNextStringOrNull = "";
                    }
                    rRWebVideoEvent.tag = strNextStringOrNull;
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            rRWebVideoEvent.setDataUnknown(concurrentHashMap);
            objectReader.endObject();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:56:0x00ad  */
        private void deserializePayload(@NotNull RRWebVideoEvent rRWebVideoEvent, @NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "duration":
                        b = 0;
                        break;
                    case "segmentId":
                        b = 1;
                        break;
                    case "height":
                        b = 2;
                        break;
                    case "container":
                        b = 3;
                        break;
                    case "frameCount":
                        b = 4;
                        break;
                    case "top":
                        b = 5;
                        break;
                    case "left":
                        b = 6;
                        break;
                    case "size":
                        b = 7;
                        break;
                    case "width":
                        b = 8;
                        break;
                    case "frameRate":
                        b = 9;
                        break;
                    case "encoding":
                        b = 10;
                        break;
                    case "frameRateType":
                        b = Ascii.VT;
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        rRWebVideoEvent.durationMs = objectReader.nextLong();
                        break;
                    case 1:
                        rRWebVideoEvent.segmentId = objectReader.nextInt();
                        break;
                    case 2:
                        Integer numNextIntegerOrNull = objectReader.nextIntegerOrNull();
                        rRWebVideoEvent.height = numNextIntegerOrNull != null ? numNextIntegerOrNull.intValue() : 0;
                        break;
                    case 3:
                        String strNextStringOrNull = objectReader.nextStringOrNull();
                        rRWebVideoEvent.container = strNextStringOrNull != null ? strNextStringOrNull : "";
                        break;
                    case 4:
                        Integer numNextIntegerOrNull2 = objectReader.nextIntegerOrNull();
                        rRWebVideoEvent.frameCount = numNextIntegerOrNull2 != null ? numNextIntegerOrNull2.intValue() : 0;
                        break;
                    case 5:
                        Integer numNextIntegerOrNull3 = objectReader.nextIntegerOrNull();
                        rRWebVideoEvent.top = numNextIntegerOrNull3 != null ? numNextIntegerOrNull3.intValue() : 0;
                        break;
                    case 6:
                        Integer numNextIntegerOrNull4 = objectReader.nextIntegerOrNull();
                        rRWebVideoEvent.left = numNextIntegerOrNull4 != null ? numNextIntegerOrNull4.intValue() : 0;
                        break;
                    case 7:
                        Long lNextLongOrNull = objectReader.nextLongOrNull();
                        rRWebVideoEvent.size = lNextLongOrNull == null ? 0L : lNextLongOrNull.longValue();
                        break;
                    case 8:
                        Integer numNextIntegerOrNull5 = objectReader.nextIntegerOrNull();
                        rRWebVideoEvent.width = numNextIntegerOrNull5 != null ? numNextIntegerOrNull5.intValue() : 0;
                        break;
                    case 9:
                        Integer numNextIntegerOrNull6 = objectReader.nextIntegerOrNull();
                        rRWebVideoEvent.frameRate = numNextIntegerOrNull6 != null ? numNextIntegerOrNull6.intValue() : 0;
                        break;
                    case 10:
                        String strNextStringOrNull2 = objectReader.nextStringOrNull();
                        rRWebVideoEvent.encoding = strNextStringOrNull2 != null ? strNextStringOrNull2 : "";
                        break;
                    case 11:
                        String strNextStringOrNull3 = objectReader.nextStringOrNull();
                        rRWebVideoEvent.frameRateType = strNextStringOrNull3 != null ? strNextStringOrNull3 : "";
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            rRWebVideoEvent.setPayloadUnknown(concurrentHashMap);
            objectReader.endObject();
        }
    }
}
