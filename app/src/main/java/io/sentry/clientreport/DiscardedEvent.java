package io.sentry.clientreport;

import ch.qos.logback.core.CoreConstants;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class DiscardedEvent implements JsonUnknown, JsonSerializable {
    private final String category;
    private final Long quantity;
    private final String reason;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String CATEGORY = "category";
        public static final String QUANTITY = "quantity";
        public static final String REASON = "reason";
    }

    public DiscardedEvent(@NotNull String str, @NotNull String str2, @NotNull Long l) {
        this.reason = str;
        this.category = str2;
        this.quantity = l;
    }

    public String getReason() {
        return this.reason;
    }

    public String getCategory() {
        return this.category;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public String toString() {
        return "DiscardedEvent{reason='" + this.reason + CoreConstants.SINGLE_QUOTE_CHAR + ", category='" + this.category + CoreConstants.SINGLE_QUOTE_CHAR + ", quantity=" + this.quantity + CoreConstants.CURLY_RIGHT;
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
        objectWriter.name(JsonKeys.REASON).value(this.reason);
        objectWriter.name("category").value(this.category);
        objectWriter.name("quantity").value(this.quantity);
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<DiscardedEvent> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:22:0x004a  */
        @Override // io.sentry.JsonDeserializer
        public DiscardedEvent deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            String strNextStringOrNull = null;
            String strNextStringOrNull2 = null;
            Long lNextLongOrNull = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != -1285004149) {
                    if (iHashCode != -934964668) {
                        if (iHashCode == 50511102 && strNextName.equals("category")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals(JsonKeys.REASON)) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals("quantity")) {
                    b = 0;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    lNextLongOrNull = objectReader.nextLongOrNull();
                } else if (b == 1) {
                    strNextStringOrNull = objectReader.nextStringOrNull();
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
                throw missingRequiredFieldException(JsonKeys.REASON, iLogger);
            }
            if (strNextStringOrNull2 == null) {
                throw missingRequiredFieldException("category", iLogger);
            }
            if (lNextLongOrNull == null) {
                throw missingRequiredFieldException("quantity", iLogger);
            }
            DiscardedEvent discardedEvent = new DiscardedEvent(strNextStringOrNull, strNextStringOrNull2, lNextLongOrNull);
            discardedEvent.setUnknown(map);
            return discardedEvent;
        }

        private Exception missingRequiredFieldException(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.log(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }
    }
}
