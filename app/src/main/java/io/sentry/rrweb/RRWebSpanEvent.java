package io.sentry.rrweb;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class RRWebSpanEvent extends RRWebEvent implements JsonSerializable, JsonUnknown {
    public static final String EVENT_TAG = "performanceSpan";
    private Map<String, Object> data;
    private Map<String, Object> dataUnknown;
    private String description;
    private double endTimestamp;
    private String op;
    private Map<String, Object> payloadUnknown;
    private double startTimestamp;
    private String tag;
    private Map<String, Object> unknown;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String DATA = "data";
        public static final String DESCRIPTION = "description";
        public static final String END_TIMESTAMP = "endTimestamp";
        public static final String OP = "op";
        public static final String PAYLOAD = "payload";
        public static final String START_TIMESTAMP = "startTimestamp";
    }

    public RRWebSpanEvent() {
        super(RRWebEventType.Custom);
        this.tag = EVENT_TAG;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(@NotNull String str) {
        this.tag = str;
    }

    public String getOp() {
        return this.op;
    }

    public void setOp(@Nullable String str) {
        this.op = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(@Nullable String str) {
        this.description = str;
    }

    public double getStartTimestamp() {
        return this.startTimestamp;
    }

    public void setStartTimestamp(double d) {
        this.startTimestamp = d;
    }

    public double getEndTimestamp() {
        return this.endTimestamp;
    }

    public void setEndTimestamp(double d) {
        this.endTimestamp = d;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public void setData(@Nullable Map<String, Object> map) {
        this.data = map == null ? null : new ConcurrentHashMap(map);
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
        if (this.op != null) {
            objectWriter.name("op").value(this.op);
        }
        if (this.description != null) {
            objectWriter.name("description").value(this.description);
        }
        objectWriter.name(JsonKeys.START_TIMESTAMP).value(iLogger, BigDecimal.valueOf(this.startTimestamp));
        objectWriter.name(JsonKeys.END_TIMESTAMP).value(iLogger, BigDecimal.valueOf(this.endTimestamp));
        if (this.data != null) {
            objectWriter.name("data").value(iLogger, this.data);
        }
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

    public static final class Deserializer implements JsonDeserializer<RRWebSpanEvent> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.JsonDeserializer
        public RRWebSpanEvent deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            objectReader.beginObject();
            RRWebSpanEvent rRWebSpanEvent = new RRWebSpanEvent();
            RRWebEvent.Deserializer deserializer = new RRWebEvent.Deserializer();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                if (strNextName.equals("data")) {
                    deserializeData(rRWebSpanEvent, objectReader, iLogger);
                } else if (!deserializer.deserializeValue(rRWebSpanEvent, strNextName, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            rRWebSpanEvent.setUnknown(map);
            objectReader.endObject();
            return rRWebSpanEvent;
        }

        private void deserializeData(@NotNull RRWebSpanEvent rRWebSpanEvent, @NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                if (strNextName.equals("payload")) {
                    deserializePayload(rRWebSpanEvent, objectReader, iLogger);
                } else if (strNextName.equals("tag")) {
                    String strNextStringOrNull = objectReader.nextStringOrNull();
                    if (strNextStringOrNull == null) {
                        strNextStringOrNull = "";
                    }
                    rRWebSpanEvent.tag = strNextStringOrNull;
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            rRWebSpanEvent.setDataUnknown(concurrentHashMap);
            objectReader.endObject();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:28:0x0056  */
        private void deserializePayload(@NotNull RRWebSpanEvent rRWebSpanEvent, @NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "description":
                        b = 0;
                        break;
                    case "endTimestamp":
                        b = 1;
                        break;
                    case "startTimestamp":
                        b = 2;
                        break;
                    case "op":
                        b = 3;
                        break;
                    case "data":
                        b = 4;
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    rRWebSpanEvent.description = objectReader.nextStringOrNull();
                } else if (b == 1) {
                    rRWebSpanEvent.endTimestamp = objectReader.nextDouble();
                } else if (b == 2) {
                    rRWebSpanEvent.startTimestamp = objectReader.nextDouble();
                } else if (b == 3) {
                    rRWebSpanEvent.op = objectReader.nextStringOrNull();
                } else if (b == 4) {
                    Map mapNewConcurrentHashMap = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                    if (mapNewConcurrentHashMap != null) {
                        rRWebSpanEvent.data = mapNewConcurrentHashMap;
                    }
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            rRWebSpanEvent.setPayloadUnknown(concurrentHashMap);
            objectReader.endObject();
        }
    }
}
