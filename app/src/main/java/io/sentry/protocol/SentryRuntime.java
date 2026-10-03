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
public final class SentryRuntime implements JsonUnknown, JsonSerializable {
    public static final String TYPE = "runtime";
    private String name;
    private String rawDescription;
    private Map<String, Object> unknown;
    private String version;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String NAME = "name";
        public static final String RAW_DESCRIPTION = "raw_description";
        public static final String VERSION = "version";
    }

    public SentryRuntime() {
    }

    SentryRuntime(@NotNull SentryRuntime sentryRuntime) {
        this.name = sentryRuntime.name;
        this.version = sentryRuntime.version;
        this.rawDescription = sentryRuntime.rawDescription;
        this.unknown = CollectionUtils.newConcurrentHashMap(sentryRuntime.unknown);
    }

    public String getName() {
        return this.name;
    }

    public void setName(@Nullable String str) {
        this.name = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(@Nullable String str) {
        this.version = str;
    }

    public String getRawDescription() {
        return this.rawDescription;
    }

    public void setRawDescription(@Nullable String str) {
        this.rawDescription = str;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.version != null) {
            objectWriter.name("version").value(this.version);
        }
        if (this.rawDescription != null) {
            objectWriter.name("raw_description").value(this.rawDescription);
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

    @Override // io.sentry.JsonUnknown
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.JsonUnknown
    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer<SentryRuntime> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:22:0x004c  */
        @Override // io.sentry.JsonDeserializer
        public SentryRuntime deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            SentryRuntime sentryRuntime = new SentryRuntime();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != -339173787) {
                    if (iHashCode != 3373707) {
                        if (iHashCode == 351608024 && strNextName.equals("version")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals("name")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals("raw_description")) {
                    b = 0;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    sentryRuntime.rawDescription = objectReader.nextStringOrNull();
                } else if (b == 1) {
                    sentryRuntime.name = objectReader.nextStringOrNull();
                } else if (b == 2) {
                    sentryRuntime.version = objectReader.nextStringOrNull();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            sentryRuntime.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return sentryRuntime;
        }
    }
}
