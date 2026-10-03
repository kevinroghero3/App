package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class Response implements JsonUnknown, JsonSerializable {
    public static final String TYPE = "response";
    private Long bodySize;
    private String cookies;
    private Object data;
    private Map<String, String> headers;
    private Integer statusCode;
    private Map<String, Object> unknown;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String BODY_SIZE = "body_size";
        public static final String COOKIES = "cookies";
        public static final String DATA = "data";
        public static final String HEADERS = "headers";
        public static final String STATUS_CODE = "status_code";
    }

    public Response() {
    }

    public Response(@NotNull Response response) {
        this.cookies = response.cookies;
        this.headers = CollectionUtils.newConcurrentHashMap(response.headers);
        this.unknown = CollectionUtils.newConcurrentHashMap(response.unknown);
        this.statusCode = response.statusCode;
        this.bodySize = response.bodySize;
        this.data = response.data;
    }

    public String getCookies() {
        return this.cookies;
    }

    public void setCookies(@Nullable String str) {
        this.cookies = str;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void setHeaders(@Nullable Map<String, String> map) {
        this.headers = CollectionUtils.newConcurrentHashMap(map);
    }

    @Override // io.sentry.JsonUnknown
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.JsonUnknown
    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(@Nullable Integer num) {
        this.statusCode = num;
    }

    public Long getBodySize() {
        return this.bodySize;
    }

    public void setBodySize(@Nullable Long l) {
        this.bodySize = l;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(@Nullable Object obj) {
        this.data = obj;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.cookies != null) {
            objectWriter.name("cookies").value(this.cookies);
        }
        if (this.headers != null) {
            objectWriter.name("headers").value(iLogger, this.headers);
        }
        if (this.statusCode != null) {
            objectWriter.name(JsonKeys.STATUS_CODE).value(iLogger, this.statusCode);
        }
        if (this.bodySize != null) {
            objectWriter.name("body_size").value(iLogger, this.bodySize);
        }
        if (this.data != null) {
            objectWriter.name("data").value(iLogger, this.data);
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

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Deserializer implements JsonDeserializer<Response> {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:28:0x005b  */
        @Override // io.sentry.JsonDeserializer
        public Response deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            Response response = new Response();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "status_code":
                        b = 0;
                        break;
                    case "data":
                        b = 1;
                        break;
                    case "headers":
                        b = 2;
                        break;
                    case "cookies":
                        b = 3;
                        break;
                    case "body_size":
                        b = 4;
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    response.statusCode = objectReader.nextIntegerOrNull();
                } else if (b == 1) {
                    response.data = objectReader.nextObjectOrNull();
                } else if (b == 2) {
                    Map map = (Map) objectReader.nextObjectOrNull();
                    if (map != null) {
                        response.headers = CollectionUtils.newConcurrentHashMap(map);
                    }
                } else if (b == 3) {
                    response.cookies = objectReader.nextStringOrNull();
                } else if (b == 4) {
                    response.bodySize = objectReader.nextLongOrNull();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            response.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return response;
        }
    }
}
