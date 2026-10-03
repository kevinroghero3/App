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
public final class SdkInfo implements JsonUnknown, JsonSerializable {
    private String sdkName;
    private Map<String, Object> unknown;
    private Integer versionMajor;
    private Integer versionMinor;
    private Integer versionPatchlevel;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String SDK_NAME = "sdk_name";
        public static final String VERSION_MAJOR = "version_major";
        public static final String VERSION_MINOR = "version_minor";
        public static final String VERSION_PATCHLEVEL = "version_patchlevel";
    }

    public String getSdkName() {
        return this.sdkName;
    }

    public void setSdkName(@Nullable String str) {
        this.sdkName = str;
    }

    public Integer getVersionMajor() {
        return this.versionMajor;
    }

    public void setVersionMajor(@Nullable Integer num) {
        this.versionMajor = num;
    }

    public Integer getVersionMinor() {
        return this.versionMinor;
    }

    public void setVersionMinor(@Nullable Integer num) {
        this.versionMinor = num;
    }

    public Integer getVersionPatchlevel() {
        return this.versionPatchlevel;
    }

    public void setVersionPatchlevel(@Nullable Integer num) {
        this.versionPatchlevel = num;
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
        if (this.sdkName != null) {
            objectWriter.name(JsonKeys.SDK_NAME).value(this.sdkName);
        }
        if (this.versionMajor != null) {
            objectWriter.name(JsonKeys.VERSION_MAJOR).value(this.versionMajor);
        }
        if (this.versionMinor != null) {
            objectWriter.name(JsonKeys.VERSION_MINOR).value(this.versionMinor);
        }
        if (this.versionPatchlevel != null) {
            objectWriter.name(JsonKeys.VERSION_PATCHLEVEL).value(this.versionPatchlevel);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<SdkInfo> {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:24:0x004f  */
        @Override // io.sentry.JsonDeserializer
        public SdkInfo deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            SdkInfo sdkInfo = new SdkInfo();
            objectReader.beginObject();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "sdk_name":
                        b = 0;
                        break;
                    case "version_patchlevel":
                        b = 1;
                        break;
                    case "version_major":
                        b = 2;
                        break;
                    case "version_minor":
                        b = 3;
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    sdkInfo.sdkName = objectReader.nextStringOrNull();
                } else if (b == 1) {
                    sdkInfo.versionPatchlevel = objectReader.nextIntegerOrNull();
                } else if (b == 2) {
                    sdkInfo.versionMajor = objectReader.nextIntegerOrNull();
                } else if (b == 3) {
                    sdkInfo.versionMinor = objectReader.nextIntegerOrNull();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            objectReader.endObject();
            sdkInfo.setUnknown(map);
            return sdkInfo;
        }
    }
}
