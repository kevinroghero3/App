package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SentryException implements JsonUnknown, JsonSerializable {
    private Mechanism mechanism;
    private String module;
    private SentryStackTrace stacktrace;
    private Long threadId;
    private String type;
    private Map<String, Object> unknown;
    private String value;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String MECHANISM = "mechanism";
        public static final String MODULE = "module";
        public static final String STACKTRACE = "stacktrace";
        public static final String THREAD_ID = "thread_id";
        public static final String TYPE = "type";
        public static final String VALUE = "value";
    }

    public String getType() {
        return this.type;
    }

    public void setType(@Nullable String str) {
        this.type = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(@Nullable String str) {
        this.value = str;
    }

    public String getModule() {
        return this.module;
    }

    public void setModule(@Nullable String str) {
        this.module = str;
    }

    public Long getThreadId() {
        return this.threadId;
    }

    public void setThreadId(@Nullable Long l) {
        this.threadId = l;
    }

    public SentryStackTrace getStacktrace() {
        return this.stacktrace;
    }

    public void setStacktrace(@Nullable SentryStackTrace sentryStackTrace) {
        this.stacktrace = sentryStackTrace;
    }

    public Mechanism getMechanism() {
        return this.mechanism;
    }

    public void setMechanism(@Nullable Mechanism mechanism) {
        this.mechanism = mechanism;
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
        if (this.type != null) {
            objectWriter.name("type").value(this.type);
        }
        if (this.value != null) {
            objectWriter.name("value").value(this.value);
        }
        if (this.module != null) {
            objectWriter.name("module").value(this.module);
        }
        if (this.threadId != null) {
            objectWriter.name("thread_id").value(this.threadId);
        }
        if (this.stacktrace != null) {
            objectWriter.name("stacktrace").value(iLogger, this.stacktrace);
        }
        if (this.mechanism != null) {
            objectWriter.name(JsonKeys.MECHANISM).value(iLogger, this.mechanism);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<SentryException> {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:32:0x0067  */
        @Override // io.sentry.JsonDeserializer
        public SentryException deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            SentryException sentryException = new SentryException();
            objectReader.beginObject();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "thread_id":
                        b = 0;
                        break;
                    case "module":
                        b = 1;
                        break;
                    case "type":
                        b = 2;
                        break;
                    case "value":
                        b = 3;
                        break;
                    case "mechanism":
                        b = 4;
                        break;
                    case "stacktrace":
                        b = 5;
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    sentryException.threadId = objectReader.nextLongOrNull();
                } else if (b == 1) {
                    sentryException.module = objectReader.nextStringOrNull();
                } else if (b == 2) {
                    sentryException.type = objectReader.nextStringOrNull();
                } else if (b == 3) {
                    sentryException.value = objectReader.nextStringOrNull();
                } else if (b == 4) {
                    sentryException.mechanism = (Mechanism) objectReader.nextOrNull(iLogger, new Mechanism.Deserializer());
                } else if (b == 5) {
                    sentryException.stacktrace = (SentryStackTrace) objectReader.nextOrNull(iLogger, new SentryStackTrace.Deserializer());
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            objectReader.endObject();
            sentryException.setUnknown(map);
            return sentryException;
        }
    }
}
