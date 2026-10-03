package io.sentry;

import com.google.common.base.Ascii;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Request;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import io.sentry.util.CollectionUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SentryBaseEvent {
    public static final String DEFAULT_PLATFORM = "java";
    private List<Breadcrumb> breadcrumbs;
    private final Contexts contexts;
    private DebugMeta debugMeta;
    private String dist;
    private String environment;
    private SentryId eventId;
    private Map<String, Object> extra;
    private String platform;
    private String release;
    private Request request;
    private SdkVersion sdk;
    private String serverName;
    private Map<String, String> tags;
    protected transient Throwable throwable;
    private User user;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String BREADCRUMBS = "breadcrumbs";
        public static final String CONTEXTS = "contexts";
        public static final String DEBUG_META = "debug_meta";
        public static final String DIST = "dist";
        public static final String ENVIRONMENT = "environment";
        public static final String EVENT_ID = "event_id";
        public static final String EXTRA = "extra";
        public static final String PLATFORM = "platform";
        public static final String RELEASE = "release";
        public static final String REQUEST = "request";
        public static final String SDK = "sdk";
        public static final String SERVER_NAME = "server_name";
        public static final String TAGS = "tags";
        public static final String USER = "user";
    }

    public SentryBaseEvent(@NotNull SentryId sentryId) {
        this.contexts = new Contexts();
        this.eventId = sentryId;
    }

    public SentryBaseEvent() {
        this(new SentryId());
    }

    public SentryId getEventId() {
        return this.eventId;
    }

    public void setEventId(@Nullable SentryId sentryId) {
        this.eventId = sentryId;
    }

    public Contexts getContexts() {
        return this.contexts;
    }

    public SdkVersion getSdk() {
        return this.sdk;
    }

    public void setSdk(@Nullable SdkVersion sdkVersion) {
        this.sdk = sdkVersion;
    }

    public Request getRequest() {
        return this.request;
    }

    public void setRequest(@Nullable Request request) {
        this.request = request;
    }

    public Throwable getThrowable() {
        Throwable th = this.throwable;
        return th instanceof ExceptionMechanismException ? ((ExceptionMechanismException) th).getThrowable() : th;
    }

    public Throwable getThrowableMechanism() {
        return this.throwable;
    }

    public void setThrowable(@Nullable Throwable th) {
        this.throwable = th;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public void setTags(@Nullable Map<String, String> map) {
        this.tags = CollectionUtils.newHashMap(map);
    }

    public void removeTag(@Nullable String str) {
        Map<String, String> map = this.tags;
        if (map == null || str == null) {
            return;
        }
        map.remove(str);
    }

    public String getTag(@Nullable String str) {
        Map<String, String> map = this.tags;
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    public void setTag(@Nullable String str, @Nullable String str2) {
        if (this.tags == null) {
            this.tags = new HashMap();
        }
        if (str == null) {
            return;
        }
        if (str2 == null) {
            removeTag(str);
        } else {
            this.tags.put(str, str2);
        }
    }

    public String getRelease() {
        return this.release;
    }

    public void setRelease(@Nullable String str) {
        this.release = str;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(@Nullable String str) {
        this.environment = str;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(@Nullable String str) {
        this.platform = str;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(@Nullable String str) {
        this.serverName = str;
    }

    public String getDist() {
        return this.dist;
    }

    public void setDist(@Nullable String str) {
        this.dist = str;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(@Nullable User user) {
        this.user = user;
    }

    public List<Breadcrumb> getBreadcrumbs() {
        return this.breadcrumbs;
    }

    public void setBreadcrumbs(@Nullable List<Breadcrumb> list) {
        this.breadcrumbs = CollectionUtils.newArrayList(list);
    }

    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb) {
        if (this.breadcrumbs == null) {
            this.breadcrumbs = new ArrayList();
        }
        this.breadcrumbs.add(breadcrumb);
    }

    public DebugMeta getDebugMeta() {
        return this.debugMeta;
    }

    public void setDebugMeta(@Nullable DebugMeta debugMeta) {
        this.debugMeta = debugMeta;
    }

    public Map<String, Object> getExtras() {
        return this.extra;
    }

    public void setExtras(@Nullable Map<String, Object> map) {
        this.extra = CollectionUtils.newHashMap(map);
    }

    public void setExtra(@Nullable String str, @Nullable Object obj) {
        if (this.extra == null) {
            this.extra = new HashMap();
        }
        if (str == null) {
            return;
        }
        if (obj == null) {
            removeExtra(str);
        } else {
            this.extra.put(str, obj);
        }
    }

    public void removeExtra(@Nullable String str) {
        Map<String, Object> map = this.extra;
        if (map == null || str == null) {
            return;
        }
        map.remove(str);
    }

    public Object getExtra(@Nullable String str) {
        Map<String, Object> map = this.extra;
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    public void addBreadcrumb(@Nullable String str) {
        addBreadcrumb(new Breadcrumb(str));
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Serializer {
        public void serialize(@NotNull SentryBaseEvent sentryBaseEvent, @NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
            if (sentryBaseEvent.eventId != null) {
                objectWriter.name("event_id").value(iLogger, sentryBaseEvent.eventId);
            }
            objectWriter.name("contexts").value(iLogger, sentryBaseEvent.contexts);
            if (sentryBaseEvent.sdk != null) {
                objectWriter.name("sdk").value(iLogger, sentryBaseEvent.sdk);
            }
            if (sentryBaseEvent.request != null) {
                objectWriter.name("request").value(iLogger, sentryBaseEvent.request);
            }
            if (sentryBaseEvent.tags != null && !sentryBaseEvent.tags.isEmpty()) {
                objectWriter.name("tags").value(iLogger, sentryBaseEvent.tags);
            }
            if (sentryBaseEvent.release != null) {
                objectWriter.name("release").value(sentryBaseEvent.release);
            }
            if (sentryBaseEvent.environment != null) {
                objectWriter.name("environment").value(sentryBaseEvent.environment);
            }
            if (sentryBaseEvent.platform != null) {
                objectWriter.name("platform").value(sentryBaseEvent.platform);
            }
            if (sentryBaseEvent.user != null) {
                objectWriter.name(JsonKeys.USER).value(iLogger, sentryBaseEvent.user);
            }
            if (sentryBaseEvent.serverName != null) {
                objectWriter.name(JsonKeys.SERVER_NAME).value(sentryBaseEvent.serverName);
            }
            if (sentryBaseEvent.dist != null) {
                objectWriter.name(JsonKeys.DIST).value(sentryBaseEvent.dist);
            }
            if (sentryBaseEvent.breadcrumbs != null && !sentryBaseEvent.breadcrumbs.isEmpty()) {
                objectWriter.name(JsonKeys.BREADCRUMBS).value(iLogger, sentryBaseEvent.breadcrumbs);
            }
            if (sentryBaseEvent.debugMeta != null) {
                objectWriter.name("debug_meta").value(iLogger, sentryBaseEvent.debugMeta);
            }
            if (sentryBaseEvent.extra == null || sentryBaseEvent.extra.isEmpty()) {
                return;
            }
            objectWriter.name(JsonKeys.EXTRA).value(iLogger, sentryBaseEvent.extra);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Deserializer {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:61:0x00ba  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public boolean deserializeValue(@NotNull SentryBaseEvent sentryBaseEvent, @NotNull String str, @NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            str.hashCode();
            switch (str.hashCode()) {
                case -1840434063:
                    if (!str.equals("debug_meta")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case -758770169:
                    if (!str.equals(JsonKeys.SERVER_NAME)) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case -567312220:
                    if (!str.equals("contexts")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case -85904877:
                    if (!str.equals("environment")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case -51457840:
                    if (!str.equals(JsonKeys.BREADCRUMBS)) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 113722:
                    if (!str.equals("sdk")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 3083686:
                    if (!str.equals(JsonKeys.DIST)) {
                        b = -1;
                    } else {
                        b = 6;
                    }
                    break;
                case 3552281:
                    if (!str.equals("tags")) {
                        b = -1;
                    } else {
                        b = 7;
                    }
                    break;
                case 3599307:
                    if (!str.equals(JsonKeys.USER)) {
                        b = -1;
                    } else {
                        b = 8;
                    }
                    break;
                case 96965648:
                    if (!str.equals(JsonKeys.EXTRA)) {
                        b = -1;
                    } else {
                        b = 9;
                    }
                    break;
                case 278118624:
                    if (!str.equals("event_id")) {
                        b = -1;
                    } else {
                        b = 10;
                    }
                    break;
                case 1090594823:
                    if (!str.equals("release")) {
                        b = -1;
                    } else {
                        b = Ascii.VT;
                    }
                    break;
                case 1095692943:
                    if (!str.equals("request")) {
                        b = -1;
                    } else {
                        b = Ascii.FF;
                    }
                    break;
                case 1874684019:
                    if (!str.equals("platform")) {
                        b = -1;
                    } else {
                        b = Ascii.CR;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    sentryBaseEvent.debugMeta = (DebugMeta) objectReader.nextOrNull(iLogger, new DebugMeta.Deserializer());
                    return true;
                case 1:
                    sentryBaseEvent.serverName = objectReader.nextStringOrNull();
                    return true;
                case 2:
                    sentryBaseEvent.contexts.putAll(new Contexts.Deserializer().deserialize(objectReader, iLogger));
                    return true;
                case 3:
                    sentryBaseEvent.environment = objectReader.nextStringOrNull();
                    return true;
                case 4:
                    sentryBaseEvent.breadcrumbs = objectReader.nextListOrNull(iLogger, new Breadcrumb.Deserializer());
                    return true;
                case 5:
                    sentryBaseEvent.sdk = (SdkVersion) objectReader.nextOrNull(iLogger, new SdkVersion.Deserializer());
                    return true;
                case 6:
                    sentryBaseEvent.dist = objectReader.nextStringOrNull();
                    return true;
                case 7:
                    sentryBaseEvent.tags = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                    return true;
                case 8:
                    sentryBaseEvent.user = (User) objectReader.nextOrNull(iLogger, new User.Deserializer());
                    return true;
                case 9:
                    sentryBaseEvent.extra = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                    return true;
                case 10:
                    sentryBaseEvent.eventId = (SentryId) objectReader.nextOrNull(iLogger, new SentryId.Deserializer());
                    return true;
                case 11:
                    sentryBaseEvent.release = objectReader.nextStringOrNull();
                    return true;
                case 12:
                    sentryBaseEvent.request = (Request) objectReader.nextOrNull(iLogger, new Request.Deserializer());
                    return true;
                case 13:
                    sentryBaseEvent.platform = objectReader.nextStringOrNull();
                    return true;
                default:
                    return false;
            }
        }
    }
}
