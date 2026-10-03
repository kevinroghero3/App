package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class User implements JsonUnknown, JsonSerializable {
    private Map<String, String> data;
    private String email;
    private Geo geo;
    private String id;
    private String ipAddress;

    @Deprecated
    private String name;
    private Map<String, Object> unknown;
    private String username;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String DATA = "data";
        public static final String EMAIL = "email";
        public static final String GEO = "geo";
        public static final String ID = "id";
        public static final String IP_ADDRESS = "ip_address";
        public static final String NAME = "name";
        public static final String USERNAME = "username";
    }

    public User() {
    }

    public User(@NotNull User user) {
        this.email = user.email;
        this.username = user.username;
        this.id = user.id;
        this.ipAddress = user.ipAddress;
        this.name = user.name;
        this.geo = user.geo;
        this.data = CollectionUtils.newConcurrentHashMap(user.data);
        this.unknown = CollectionUtils.newConcurrentHashMap(user.unknown);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x007e  */
    public static User fromMap(@NotNull Map<String, Object> map, @NotNull SentryOptions sentryOptions) {
        User user = new User();
        ConcurrentHashMap concurrentHashMap = null;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            key.hashCode();
            switch (key) {
                case "username":
                    user.username = value instanceof String ? (String) value : null;
                    break;
                case "id":
                    user.id = value instanceof String ? (String) value : null;
                    break;
                case "geo":
                    Map map2 = value instanceof Map ? (Map) value : null;
                    if (map2 != null) {
                        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                        for (Map.Entry entry2 : map2.entrySet()) {
                            if ((entry2.getKey() instanceof String) && entry2.getValue() != null) {
                                concurrentHashMap2.put((String) entry2.getKey(), entry2.getValue());
                            } else {
                                sentryOptions.getLogger().log(SentryLevel.WARNING, "Invalid key type in gep map.", new Object[0]);
                            }
                        }
                        user.geo = Geo.fromMap(concurrentHashMap2);
                        break;
                    } else {
                        break;
                    }
                    break;
                case "data":
                    Map map3 = value instanceof Map ? (Map) value : null;
                    if (map3 != null) {
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        for (Map.Entry entry3 : map3.entrySet()) {
                            if ((entry3.getKey() instanceof String) && entry3.getValue() != null) {
                                concurrentHashMap3.put((String) entry3.getKey(), entry3.getValue().toString());
                            } else {
                                sentryOptions.getLogger().log(SentryLevel.WARNING, "Invalid key or null value in data map.", new Object[0]);
                            }
                        }
                        user.data = concurrentHashMap3;
                        break;
                    } else {
                        break;
                    }
                    break;
                case "name":
                    user.name = value instanceof String ? (String) value : null;
                    break;
                case "email":
                    user.email = value instanceof String ? (String) value : null;
                    break;
                case "ip_address":
                    user.ipAddress = value instanceof String ? (String) value : null;
                    break;
                default:
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    concurrentHashMap.put(entry.getKey(), entry.getValue());
                    break;
            }
        }
        user.unknown = concurrentHashMap;
        return user;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(@Nullable String str) {
        this.email = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(@Nullable String str) {
        this.id = str;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(@Nullable String str) {
        this.username = str;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(@Nullable String str) {
        this.ipAddress = str;
    }

    @Deprecated
    public String getName() {
        return this.name;
    }

    @Deprecated
    public void setName(@Nullable String str) {
        this.name = str;
    }

    public Geo getGeo() {
        return this.geo;
    }

    public void setGeo(@Nullable Geo geo) {
        this.geo = geo;
    }

    public Map<String, String> getData() {
        return this.data;
    }

    public void setData(@Nullable Map<String, String> map) {
        this.data = CollectionUtils.newConcurrentHashMap(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || User.class != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return Objects.equals(this.email, user.email) && Objects.equals(this.id, user.id) && Objects.equals(this.username, user.username) && Objects.equals(this.ipAddress, user.ipAddress);
    }

    public int hashCode() {
        return Objects.hash(this.email, this.id, this.username, this.ipAddress);
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
        if (this.email != null) {
            objectWriter.name("email").value(this.email);
        }
        if (this.id != null) {
            objectWriter.name("id").value(this.id);
        }
        if (this.username != null) {
            objectWriter.name("username").value(this.username);
        }
        if (this.ipAddress != null) {
            objectWriter.name("ip_address").value(this.ipAddress);
        }
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.geo != null) {
            objectWriter.name(JsonKeys.GEO);
            this.geo.serialize(objectWriter, iLogger);
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

    public static final class Deserializer implements JsonDeserializer<User> {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:36:0x006d  */
        @Override // io.sentry.JsonDeserializer
        public User deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            objectReader.beginObject();
            User user = new User();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "username":
                        user.username = objectReader.nextStringOrNull();
                        break;
                    case "id":
                        user.id = objectReader.nextStringOrNull();
                        break;
                    case "geo":
                        user.geo = new Geo.Deserializer().deserialize(objectReader, iLogger);
                        break;
                    case "data":
                        user.data = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                        break;
                    case "name":
                        user.name = objectReader.nextStringOrNull();
                        break;
                    case "email":
                        user.email = objectReader.nextStringOrNull();
                        break;
                    case "ip_address":
                        user.ipAddress = objectReader.nextStringOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            user.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return user;
        }
    }
}
