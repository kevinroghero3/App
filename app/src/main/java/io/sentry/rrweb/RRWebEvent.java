package io.sentry.rrweb;

import io.sentry.ILogger;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.Objects;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RRWebEvent {
    private long timestamp;
    private RRWebEventType type;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String TAG = "tag";
        public static final String TIMESTAMP = "timestamp";
        public static final String TYPE = "type";
    }

    protected RRWebEvent(@NotNull RRWebEventType rRWebEventType) {
        this.type = rRWebEventType;
        this.timestamp = System.currentTimeMillis();
    }

    protected RRWebEvent() {
        this(RRWebEventType.Custom);
    }

    public RRWebEventType getType() {
        return this.type;
    }

    public void setType(@NotNull RRWebEventType rRWebEventType) {
        this.type = rRWebEventType;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RRWebEvent)) {
            return false;
        }
        RRWebEvent rRWebEvent = (RRWebEvent) obj;
        return this.timestamp == rRWebEvent.timestamp && this.type == rRWebEvent.type;
    }

    public int hashCode() {
        return Objects.hash(this.type, Long.valueOf(this.timestamp));
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Serializer {
        public void serialize(@NotNull RRWebEvent rRWebEvent, @NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
            objectWriter.name("type").value(iLogger, rRWebEvent.type);
            objectWriter.name("timestamp").value(rRWebEvent.timestamp);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Deserializer {
        public boolean deserializeValue(@NotNull RRWebEvent rRWebEvent, @NotNull String str, @NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            str.hashCode();
            if (str.equals("type")) {
                rRWebEvent.type = (RRWebEventType) Objects.requireNonNull((RRWebEventType) objectReader.nextOrNull(iLogger, new RRWebEventType.Deserializer()), "");
                return true;
            }
            if (!str.equals("timestamp")) {
                return false;
            }
            rRWebEvent.timestamp = objectReader.nextLong();
            return true;
        }
    }
}
