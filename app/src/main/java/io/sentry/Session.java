package io.sentry;

import io.sentry.protocol.User;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.StringUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class Session implements JsonUnknown, JsonSerializable {
    private String abnormalMechanism;
    private final String distinctId;
    private Double duration;
    private final String environment;
    private final AtomicInteger errorCount;
    private Boolean init;
    private final String ipAddress;
    private final String release;
    private Long sequence;
    private final String sessionId;
    private final AutoClosableReentrantLock sessionLock;
    private final Date started;
    private State status;
    private Date timestamp;
    private Map<String, Object> unknown;
    private String userAgent;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String ABNORMAL_MECHANISM = "abnormal_mechanism";
        public static final String ATTRS = "attrs";
        public static final String DID = "did";
        public static final String DURATION = "duration";
        public static final String ENVIRONMENT = "environment";
        public static final String ERRORS = "errors";
        public static final String INIT = "init";
        public static final String IP_ADDRESS = "ip_address";
        public static final String RELEASE = "release";
        public static final String SEQ = "seq";
        public static final String SID = "sid";
        public static final String STARTED = "started";
        public static final String STATUS = "status";
        public static final String TIMESTAMP = "timestamp";
        public static final String USER_AGENT = "user_agent";
    }

    public enum State {
        Ok,
        Exited,
        Crashed,
        Abnormal
    }

    public Session(@NotNull State state, @NotNull Date date, @Nullable Date date2, int i, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable Long l, @Nullable Double d, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull String str6, @Nullable String str7) {
        this.sessionLock = new AutoClosableReentrantLock();
        this.status = state;
        this.started = date;
        this.timestamp = date2;
        this.errorCount = new AtomicInteger(i);
        this.distinctId = str;
        this.sessionId = str2;
        this.init = bool;
        this.sequence = l;
        this.duration = d;
        this.ipAddress = str3;
        this.userAgent = str4;
        this.environment = str5;
        this.release = str6;
        this.abnormalMechanism = str7;
    }

    public Session(@Nullable String str, @Nullable User user, @Nullable String str2, @NotNull String str3) {
        this(State.Ok, DateUtils.getCurrentDateTime(), DateUtils.getCurrentDateTime(), 0, str, SentryUUID.generateSentryId(), Boolean.TRUE, null, null, user != null ? user.getIpAddress() : null, null, str2, str3, null);
    }

    public boolean isTerminated() {
        return this.status != State.Ok;
    }

    public Date getStarted() {
        Date date = this.started;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public String getDistinctId() {
        return this.distinctId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public String getRelease() {
        return this.release;
    }

    public Boolean getInit() {
        return this.init;
    }

    public void setInitAsTrue() {
        this.init = Boolean.TRUE;
    }

    public int errorCount() {
        return this.errorCount.get();
    }

    public State getStatus() {
        return this.status;
    }

    public Long getSequence() {
        return this.sequence;
    }

    public Double getDuration() {
        return this.duration;
    }

    public String getAbnormalMechanism() {
        return this.abnormalMechanism;
    }

    public Date getTimestamp() {
        Date date = this.timestamp;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void end() {
        end(DateUtils.getCurrentDateTime());
    }

    public void end(@Nullable Date date) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.sessionLock.acquire();
        try {
            this.init = null;
            if (this.status == State.Ok) {
                this.status = State.Exited;
            }
            if (date != null) {
                this.timestamp = date;
            } else {
                this.timestamp = DateUtils.getCurrentDateTime();
            }
            Date date2 = this.timestamp;
            if (date2 != null) {
                this.duration = Double.valueOf(calculateDurationTime(date2));
                this.sequence = Long.valueOf(getSequenceTimestamp(this.timestamp));
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private double calculateDurationTime(@NotNull Date date) {
        return Math.abs(date.getTime() - this.started.getTime()) / 1000.0d;
    }

    public boolean update(@Nullable State state, @Nullable String str, boolean z) {
        return update(state, str, z, null);
    }

    public boolean update(@Nullable State state, @Nullable String str, boolean z, @Nullable String str2) {
        boolean z2;
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.sessionLock.acquire();
        boolean z3 = true;
        if (state != null) {
            try {
                this.status = state;
                z2 = true;
            } catch (Throwable th) {
                if (iSentryLifecycleTokenAcquire != null) {
                    try {
                        iSentryLifecycleTokenAcquire.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } else {
            z2 = false;
        }
        if (str != null) {
            this.userAgent = str;
            z2 = true;
        }
        if (z) {
            this.errorCount.addAndGet(1);
            z2 = true;
        }
        if (str2 != null) {
            this.abnormalMechanism = str2;
        } else {
            z3 = z2;
        }
        if (z3) {
            this.init = null;
            Date currentDateTime = DateUtils.getCurrentDateTime();
            this.timestamp = currentDateTime;
            if (currentDateTime != null) {
                this.sequence = Long.valueOf(getSequenceTimestamp(currentDateTime));
            }
        }
        if (iSentryLifecycleTokenAcquire != null) {
            iSentryLifecycleTokenAcquire.close();
        }
        return z3;
    }

    private long getSequenceTimestamp(@NotNull Date date) {
        long time = date.getTime();
        return time < 0 ? Math.abs(time) : time;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Session m5403clone() {
        return new Session(this.status, this.started, this.timestamp, this.errorCount.get(), this.distinctId, this.sessionId, this.init, this.sequence, this.duration, this.ipAddress, this.userAgent, this.environment, this.release, this.abnormalMechanism);
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.sessionId != null) {
            objectWriter.name(JsonKeys.SID).value(this.sessionId);
        }
        if (this.distinctId != null) {
            objectWriter.name(JsonKeys.DID).value(this.distinctId);
        }
        if (this.init != null) {
            objectWriter.name(JsonKeys.INIT).value(this.init);
        }
        objectWriter.name(JsonKeys.STARTED).value(iLogger, this.started);
        objectWriter.name("status").value(iLogger, this.status.name().toLowerCase(Locale.ROOT));
        if (this.sequence != null) {
            objectWriter.name(JsonKeys.SEQ).value(this.sequence);
        }
        objectWriter.name(JsonKeys.ERRORS).value(this.errorCount.intValue());
        if (this.duration != null) {
            objectWriter.name("duration").value(this.duration);
        }
        if (this.timestamp != null) {
            objectWriter.name("timestamp").value(iLogger, this.timestamp);
        }
        if (this.abnormalMechanism != null) {
            objectWriter.name(JsonKeys.ABNORMAL_MECHANISM).value(iLogger, this.abnormalMechanism);
        }
        objectWriter.name(JsonKeys.ATTRS);
        objectWriter.beginObject();
        objectWriter.name("release").value(iLogger, this.release);
        if (this.environment != null) {
            objectWriter.name("environment").value(iLogger, this.environment);
        }
        if (this.ipAddress != null) {
            objectWriter.name("ip_address").value(iLogger, this.ipAddress);
        }
        if (this.userAgent != null) {
            objectWriter.name(JsonKeys.USER_AGENT).value(iLogger, this.userAgent);
        }
        objectWriter.endObject();
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

    public static final class Deserializer implements JsonDeserializer<Session> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.JsonDeserializer
        public Session deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            Integer numNextIntegerOrNull = null;
            State stateValueOf = null;
            Date dateNextDateOrNull = null;
            Date dateNextDateOrNull2 = null;
            String strNextStringOrNull = null;
            String str = null;
            Boolean boolNextBooleanOrNull = null;
            Long lNextLongOrNull = null;
            Double dNextDoubleOrNull = null;
            String strNextStringOrNull2 = null;
            String strNextStringOrNull3 = null;
            ConcurrentHashMap concurrentHashMap = null;
            String strNextStringOrNull4 = null;
            String strNextStringOrNull5 = null;
            String strNextStringOrNull6 = null;
            while (true) {
                String str2 = strNextStringOrNull3;
                String str3 = strNextStringOrNull2;
                Double d = dNextDoubleOrNull;
                if (objectReader.peek() != JsonToken.NAME) {
                    Long l = lNextLongOrNull;
                    if (stateValueOf == null) {
                        throw missingRequiredFieldException("status", iLogger);
                    }
                    if (dateNextDateOrNull == null) {
                        throw missingRequiredFieldException(JsonKeys.STARTED, iLogger);
                    }
                    if (numNextIntegerOrNull == null) {
                        throw missingRequiredFieldException(JsonKeys.ERRORS, iLogger);
                    }
                    if (strNextStringOrNull5 == null) {
                        throw missingRequiredFieldException("release", iLogger);
                    }
                    Session session = new Session(stateValueOf, dateNextDateOrNull, dateNextDateOrNull2, numNextIntegerOrNull.intValue(), strNextStringOrNull, str, boolNextBooleanOrNull, l, d, str3, str2, strNextStringOrNull4, strNextStringOrNull5, strNextStringOrNull6);
                    session.setUnknown(concurrentHashMap);
                    objectReader.endObject();
                    return session;
                }
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                Long l2 = lNextLongOrNull;
                switch (strNextName) {
                    case "duration":
                        dNextDoubleOrNull = objectReader.nextDoubleOrNull();
                        strNextStringOrNull3 = str2;
                        strNextStringOrNull2 = str3;
                        lNextLongOrNull = l2;
                        break;
                    case "started":
                        dateNextDateOrNull = objectReader.nextDateOrNull(iLogger);
                        strNextStringOrNull3 = str2;
                        strNextStringOrNull2 = str3;
                        dNextDoubleOrNull = d;
                        lNextLongOrNull = l2;
                        break;
                    case "errors":
                        numNextIntegerOrNull = objectReader.nextIntegerOrNull();
                        strNextStringOrNull3 = str2;
                        strNextStringOrNull2 = str3;
                        dNextDoubleOrNull = d;
                        lNextLongOrNull = l2;
                        break;
                    case "status":
                        String strCapitalize = StringUtils.capitalize(objectReader.nextStringOrNull());
                        if (strCapitalize != null) {
                            stateValueOf = State.valueOf(strCapitalize);
                        }
                        strNextStringOrNull3 = str2;
                        strNextStringOrNull2 = str3;
                        dNextDoubleOrNull = d;
                        lNextLongOrNull = l2;
                        break;
                    case "did":
                        strNextStringOrNull = objectReader.nextStringOrNull();
                        strNextStringOrNull3 = str2;
                        strNextStringOrNull2 = str3;
                        dNextDoubleOrNull = d;
                        lNextLongOrNull = l2;
                        break;
                    case "seq":
                        lNextLongOrNull = objectReader.nextLongOrNull();
                        strNextStringOrNull3 = str2;
                        strNextStringOrNull2 = str3;
                        dNextDoubleOrNull = d;
                        break;
                    case "sid":
                        String strNextStringOrNull7 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull7 != null && (strNextStringOrNull7.length() == 36 || strNextStringOrNull7.length() == 32)) {
                            str = strNextStringOrNull7;
                            strNextStringOrNull3 = str2;
                            strNextStringOrNull2 = str3;
                            dNextDoubleOrNull = d;
                            lNextLongOrNull = l2;
                            break;
                        } else {
                            iLogger.log(SentryLevel.ERROR, "%s sid is not valid.", strNextStringOrNull7);
                            strNextStringOrNull3 = str2;
                            strNextStringOrNull2 = str3;
                            dNextDoubleOrNull = d;
                            lNextLongOrNull = l2;
                            break;
                        }
                        break;
                    case "init":
                        boolNextBooleanOrNull = objectReader.nextBooleanOrNull();
                        strNextStringOrNull3 = str2;
                        strNextStringOrNull2 = str3;
                        dNextDoubleOrNull = d;
                        lNextLongOrNull = l2;
                        break;
                    case "timestamp":
                        dateNextDateOrNull2 = objectReader.nextDateOrNull(iLogger);
                        strNextStringOrNull3 = str2;
                        strNextStringOrNull2 = str3;
                        dNextDoubleOrNull = d;
                        lNextLongOrNull = l2;
                        break;
                    case "attrs":
                        objectReader.beginObject();
                        strNextStringOrNull3 = str2;
                        strNextStringOrNull2 = str3;
                        while (objectReader.peek() == JsonToken.NAME) {
                            String strNextName2 = objectReader.nextName();
                            strNextName2.hashCode();
                            switch (strNextName2) {
                                case "environment":
                                    b = 0;
                                    break;
                                case "release":
                                    b = 1;
                                    break;
                                case "ip_address":
                                    b = 2;
                                    break;
                                case "user_agent":
                                    b = 3;
                                    break;
                                default:
                                    b = -1;
                                    break;
                            }
                            if (b == 0) {
                                strNextStringOrNull4 = objectReader.nextStringOrNull();
                            } else if (b == 1) {
                                strNextStringOrNull5 = objectReader.nextStringOrNull();
                            } else if (b == 2) {
                                strNextStringOrNull2 = objectReader.nextStringOrNull();
                            } else if (b == 3) {
                                strNextStringOrNull3 = objectReader.nextStringOrNull();
                            } else {
                                objectReader.skipValue();
                            }
                        }
                        objectReader.endObject();
                        dNextDoubleOrNull = d;
                        lNextLongOrNull = l2;
                        break;
                    case "abnormal_mechanism":
                        strNextStringOrNull6 = objectReader.nextStringOrNull();
                        strNextStringOrNull3 = str2;
                        strNextStringOrNull2 = str3;
                        dNextDoubleOrNull = d;
                        lNextLongOrNull = l2;
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        strNextStringOrNull3 = str2;
                        strNextStringOrNull2 = str3;
                        dNextDoubleOrNull = d;
                        lNextLongOrNull = l2;
                        break;
                }
            }
        }

        private Exception missingRequiredFieldException(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.log(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }
    }
}
