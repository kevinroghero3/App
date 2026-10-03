package io.sentry;

import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class MonitorSchedule implements JsonUnknown, JsonSerializable {
    private String type;
    private String unit;
    private Map<String, Object> unknown;
    private String value;

    public static final class JsonKeys {
        public static final String TYPE = "type";
        public static final String UNIT = "unit";
        public static final String VALUE = "value";
    }

    public static MonitorSchedule crontab(@NotNull String str) {
        return new MonitorSchedule(MonitorScheduleType.CRONTAB.apiName(), str, null);
    }

    public static MonitorSchedule interval(@NotNull Integer num, @NotNull MonitorScheduleUnit monitorScheduleUnit) {
        return new MonitorSchedule(MonitorScheduleType.INTERVAL.apiName(), num.toString(), monitorScheduleUnit.apiName());
    }

    public MonitorSchedule(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        this.type = str;
        this.value = str2;
        this.unit = str3;
    }

    public String getType() {
        return this.type;
    }

    public void setType(@NotNull String str) {
        this.type = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(@NotNull String str) {
        this.value = str;
    }

    public void setValue(@NotNull Integer num) {
        this.value = num.toString();
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(@Nullable String str) {
        this.unit = str;
    }

    public void setUnit(@Nullable MonitorScheduleUnit monitorScheduleUnit) {
        this.unit = monitorScheduleUnit == null ? null : monitorScheduleUnit.apiName();
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
        objectWriter.name("type").value(this.type);
        if (MonitorScheduleType.INTERVAL.apiName().equalsIgnoreCase(this.type)) {
            try {
                objectWriter.name("value").value(Integer.valueOf(this.value));
            } catch (Throwable unused) {
                iLogger.log(SentryLevel.ERROR, "Unable to serialize monitor schedule value: %s", this.value);
            }
        } else {
            objectWriter.name("value").value(this.value);
        }
        if (this.unit != null) {
            objectWriter.name("unit").value(this.unit);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<MonitorSchedule> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:22:0x004a  */
        @Override // io.sentry.JsonDeserializer
        public MonitorSchedule deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            String strNextStringOrNull = null;
            String strNextStringOrNull2 = null;
            String strNextStringOrNull3 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3575610) {
                    if (iHashCode != 3594628) {
                        if (iHashCode == 111972721 && strNextName.equals("value")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals("unit")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals("type")) {
                    b = 0;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    strNextStringOrNull = objectReader.nextStringOrNull();
                } else if (b == 1) {
                    strNextStringOrNull3 = objectReader.nextStringOrNull();
                } else if (b == 2) {
                    strNextStringOrNull2 = objectReader.nextStringOrNull();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            objectReader.endObject();
            if (strNextStringOrNull == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"type\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"type\"", illegalStateException);
                throw illegalStateException;
            }
            if (strNextStringOrNull2 == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"value\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"value\"", illegalStateException2);
                throw illegalStateException2;
            }
            MonitorSchedule monitorSchedule = new MonitorSchedule(strNextStringOrNull, strNextStringOrNull2, strNextStringOrNull3);
            monitorSchedule.setUnknown(map);
            return monitorSchedule;
        }
    }
}
