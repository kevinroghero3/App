package io.sentry.protocol;

import ch.qos.logback.core.CoreConstants;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class Feedback implements JsonUnknown, JsonSerializable {
    public static final String TYPE = "feedback";
    private SentryId associatedEventId;
    private String contactEmail;
    private String message;
    private String name;
    private SentryId replayId;
    private Map<String, Object> unknown;
    private String url;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String ASSOCIATED_EVENT_ID = "associated_event_id";
        public static final String CONTACT_EMAIL = "contact_email";
        public static final String MESSAGE = "message";
        public static final String NAME = "name";
        public static final String REPLAY_ID = "replay_id";
        public static final String URL = "url";
    }

    public Feedback(@NotNull String str) {
        setMessage(str);
    }

    public Feedback(@NotNull Feedback feedback) {
        this.message = feedback.message;
        this.contactEmail = feedback.contactEmail;
        this.name = feedback.name;
        this.associatedEventId = feedback.associatedEventId;
        this.replayId = feedback.replayId;
        this.url = feedback.url;
        this.unknown = CollectionUtils.newConcurrentHashMap(feedback.unknown);
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setContactEmail(@Nullable String str) {
        this.contactEmail = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(@Nullable String str) {
        this.name = str;
    }

    public SentryId getAssociatedEventId() {
        return this.associatedEventId;
    }

    public void setAssociatedEventId(@NotNull SentryId sentryId) {
        this.associatedEventId = sentryId;
    }

    public SentryId getReplayId() {
        return this.replayId;
    }

    public void setReplayId(@NotNull SentryId sentryId) {
        this.replayId = sentryId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(@Nullable String str) {
        this.url = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(@NotNull String str) {
        if (str.length() > 4096) {
            this.message = str.substring(0, 4096);
        } else {
            this.message = str;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Feedback)) {
            return false;
        }
        Feedback feedback = (Feedback) obj;
        return Objects.equals(this.message, feedback.message) && Objects.equals(this.contactEmail, feedback.contactEmail) && Objects.equals(this.name, feedback.name) && Objects.equals(this.associatedEventId, feedback.associatedEventId) && Objects.equals(this.replayId, feedback.replayId) && Objects.equals(this.url, feedback.url) && Objects.equals(this.unknown, feedback.unknown);
    }

    public String toString() {
        return "Feedback{message='" + this.message + CoreConstants.SINGLE_QUOTE_CHAR + ", contactEmail='" + this.contactEmail + CoreConstants.SINGLE_QUOTE_CHAR + ", name='" + this.name + CoreConstants.SINGLE_QUOTE_CHAR + ", associatedEventId=" + this.associatedEventId + ", replayId=" + this.replayId + ", url='" + this.url + CoreConstants.SINGLE_QUOTE_CHAR + ", unknown=" + this.unknown + CoreConstants.CURLY_RIGHT;
    }

    public int hashCode() {
        return Objects.hash(this.message, this.contactEmail, this.name, this.associatedEventId, this.replayId, this.url, this.unknown);
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
        objectWriter.name("message").value(this.message);
        if (this.contactEmail != null) {
            objectWriter.name(JsonKeys.CONTACT_EMAIL).value(this.contactEmail);
        }
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.associatedEventId != null) {
            objectWriter.name(JsonKeys.ASSOCIATED_EVENT_ID);
            this.associatedEventId.serialize(objectWriter, iLogger);
        }
        if (this.replayId != null) {
            objectWriter.name("replay_id");
            this.replayId.serialize(objectWriter, iLogger);
        }
        if (this.url != null) {
            objectWriter.name("url").value(this.url);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<Feedback> {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:32:0x006c  */
        @Override // io.sentry.JsonDeserializer
        public Feedback deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            String strNextStringOrNull = null;
            String strNextStringOrNull2 = null;
            String strNextStringOrNull3 = null;
            SentryId sentryIdDeserialize = null;
            SentryId sentryIdDeserialize2 = null;
            String strNextStringOrNull4 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "associated_event_id":
                        b = 0;
                        break;
                    case "replay_id":
                        b = 1;
                        break;
                    case "url":
                        b = 2;
                        break;
                    case "name":
                        b = 3;
                        break;
                    case "contact_email":
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
                    sentryIdDeserialize = new SentryId.Deserializer().deserialize(objectReader, iLogger);
                } else if (b == 1) {
                    sentryIdDeserialize2 = new SentryId.Deserializer().deserialize(objectReader, iLogger);
                } else if (b == 2) {
                    strNextStringOrNull4 = objectReader.nextStringOrNull();
                } else if (b == 3) {
                    strNextStringOrNull3 = objectReader.nextStringOrNull();
                } else if (b == 4) {
                    strNextStringOrNull2 = objectReader.nextStringOrNull();
                } else if (b == 5) {
                    strNextStringOrNull = objectReader.nextStringOrNull();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            objectReader.endObject();
            if (strNextStringOrNull == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"message\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"message\"", illegalStateException);
                throw illegalStateException;
            }
            Feedback feedback = new Feedback(strNextStringOrNull);
            feedback.contactEmail = strNextStringOrNull2;
            feedback.name = strNextStringOrNull3;
            feedback.associatedEventId = sentryIdDeserialize;
            feedback.replayId = sentryIdDeserialize2;
            feedback.url = strNextStringOrNull4;
            feedback.unknown = map;
            return feedback;
        }
    }
}
