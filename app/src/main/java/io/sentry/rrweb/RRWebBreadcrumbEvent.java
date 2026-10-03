package io.sentry.rrweb;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
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
public final class RRWebBreadcrumbEvent extends RRWebEvent implements JsonUnknown, JsonSerializable {
    public static final String EVENT_TAG = "breadcrumb";
    private double breadcrumbTimestamp;
    private String breadcrumbType;
    private String category;
    private Map<String, Object> data;
    private Map<String, Object> dataUnknown;
    private SentryLevel level;
    private String message;
    private Map<String, Object> payloadUnknown;
    private String tag;
    private Map<String, Object> unknown;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String CATEGORY = "category";
        public static final String DATA = "data";
        public static final String LEVEL = "level";
        public static final String MESSAGE = "message";
        public static final String PAYLOAD = "payload";
        public static final String TIMESTAMP = "timestamp";
        public static final String TYPE = "type";
    }

    public RRWebBreadcrumbEvent() {
        super(RRWebEventType.Custom);
        this.tag = EVENT_TAG;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(@NotNull String str) {
        this.tag = str;
    }

    public double getBreadcrumbTimestamp() {
        return this.breadcrumbTimestamp;
    }

    public void setBreadcrumbTimestamp(double d) {
        this.breadcrumbTimestamp = d;
    }

    public String getBreadcrumbType() {
        return this.breadcrumbType;
    }

    public void setBreadcrumbType(@Nullable String str) {
        this.breadcrumbType = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(@Nullable String str) {
        this.category = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(@Nullable String str) {
        this.message = str;
    }

    public SentryLevel getLevel() {
        return this.level;
    }

    public void setLevel(@Nullable SentryLevel sentryLevel) {
        this.level = sentryLevel;
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
        if (this.breadcrumbType != null) {
            objectWriter.name("type").value(this.breadcrumbType);
        }
        objectWriter.name("timestamp").value(iLogger, BigDecimal.valueOf(this.breadcrumbTimestamp));
        if (this.category != null) {
            objectWriter.name("category").value(this.category);
        }
        if (this.message != null) {
            objectWriter.name("message").value(this.message);
        }
        if (this.level != null) {
            objectWriter.name("level").value(iLogger, this.level);
        }
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

    public static final class Deserializer implements JsonDeserializer<RRWebBreadcrumbEvent> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.JsonDeserializer
        public RRWebBreadcrumbEvent deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            objectReader.beginObject();
            RRWebBreadcrumbEvent rRWebBreadcrumbEvent = new RRWebBreadcrumbEvent();
            RRWebEvent.Deserializer deserializer = new RRWebEvent.Deserializer();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                if (strNextName.equals("data")) {
                    deserializeData(rRWebBreadcrumbEvent, objectReader, iLogger);
                } else if (!deserializer.deserializeValue(rRWebBreadcrumbEvent, strNextName, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            rRWebBreadcrumbEvent.setUnknown(map);
            objectReader.endObject();
            return rRWebBreadcrumbEvent;
        }

        private void deserializeData(@NotNull RRWebBreadcrumbEvent rRWebBreadcrumbEvent, @NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                if (strNextName.equals("payload")) {
                    deserializePayload(rRWebBreadcrumbEvent, objectReader, iLogger);
                } else if (strNextName.equals("tag")) {
                    String strNextStringOrNull = objectReader.nextStringOrNull();
                    if (strNextStringOrNull == null) {
                        strNextStringOrNull = "";
                    }
                    rRWebBreadcrumbEvent.tag = strNextStringOrNull;
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            rRWebBreadcrumbEvent.setDataUnknown(concurrentHashMap);
            objectReader.endObject();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:32:0x0063  */
        private void deserializePayload(@NotNull RRWebBreadcrumbEvent rRWebBreadcrumbEvent, @NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "data":
                        b = 0;
                        break;
                    case "type":
                        b = 1;
                        break;
                    case "category":
                        b = 2;
                        break;
                    case "timestamp":
                        b = 3;
                        break;
                    case "level":
                        b = 4;
                        break;
                    case "message":
                        b = 5;
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    Map mapNewConcurrentHashMap = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                    if (mapNewConcurrentHashMap != null) {
                        rRWebBreadcrumbEvent.data = mapNewConcurrentHashMap;
                    }
                } else if (b == 1) {
                    rRWebBreadcrumbEvent.breadcrumbType = objectReader.nextStringOrNull();
                } else if (b == 2) {
                    rRWebBreadcrumbEvent.category = objectReader.nextStringOrNull();
                } else if (b == 3) {
                    rRWebBreadcrumbEvent.breadcrumbTimestamp = objectReader.nextDouble();
                } else if (b == 4) {
                    try {
                        rRWebBreadcrumbEvent.level = new SentryLevel.Deserializer().deserialize(objectReader, iLogger);
                    } catch (Exception e) {
                        iLogger.log(SentryLevel.DEBUG, e, "Error when deserializing SentryLevel", new Object[0]);
                    }
                } else if (b == 5) {
                    rRWebBreadcrumbEvent.message = objectReader.nextStringOrNull();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            rRWebBreadcrumbEvent.setPayloadUnknown(concurrentHashMap);
            objectReader.endObject();
        }
    }
}
