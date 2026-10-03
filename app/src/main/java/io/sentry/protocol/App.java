package io.sentry.protocol;

import com.google.common.base.Ascii;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class App implements JsonUnknown, JsonSerializable {
    public static final String TYPE = "app";
    private String appBuild;
    private String appIdentifier;
    private String appName;
    private Date appStartTime;
    private String appVersion;
    private String buildType;
    private String deviceAppHash;
    private Boolean inForeground;
    private Boolean isSplitApks;
    private Map<String, String> permissions;
    private List<String> splitNames;
    private String startType;
    private Map<String, Object> unknown;
    private List<String> viewNames;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String APP_BUILD = "app_build";
        public static final String APP_IDENTIFIER = "app_identifier";
        public static final String APP_NAME = "app_name";
        public static final String APP_PERMISSIONS = "permissions";
        public static final String APP_START_TIME = "app_start_time";
        public static final String APP_VERSION = "app_version";
        public static final String BUILD_TYPE = "build_type";
        public static final String DEVICE_APP_HASH = "device_app_hash";
        public static final String IN_FOREGROUND = "in_foreground";
        public static final String IS_SPLIT_APKS = "is_split_apks";
        public static final String SPLIT_NAMES = "split_names";
        public static final String START_TYPE = "start_type";
        public static final String VIEW_NAMES = "view_names";
    }

    public App() {
    }

    App(@NotNull App app2) {
        this.appBuild = app2.appBuild;
        this.appIdentifier = app2.appIdentifier;
        this.appName = app2.appName;
        this.appStartTime = app2.appStartTime;
        this.appVersion = app2.appVersion;
        this.buildType = app2.buildType;
        this.deviceAppHash = app2.deviceAppHash;
        this.permissions = CollectionUtils.newConcurrentHashMap(app2.permissions);
        this.inForeground = app2.inForeground;
        this.viewNames = CollectionUtils.newArrayList(app2.viewNames);
        this.startType = app2.startType;
        this.isSplitApks = app2.isSplitApks;
        this.splitNames = app2.splitNames;
        this.unknown = CollectionUtils.newConcurrentHashMap(app2.unknown);
    }

    public String getAppIdentifier() {
        return this.appIdentifier;
    }

    public void setAppIdentifier(@Nullable String str) {
        this.appIdentifier = str;
    }

    public Date getAppStartTime() {
        Date date = this.appStartTime;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void setAppStartTime(@Nullable Date date) {
        this.appStartTime = date;
    }

    public String getDeviceAppHash() {
        return this.deviceAppHash;
    }

    public void setDeviceAppHash(@Nullable String str) {
        this.deviceAppHash = str;
    }

    public String getBuildType() {
        return this.buildType;
    }

    public void setBuildType(@Nullable String str) {
        this.buildType = str;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(@Nullable String str) {
        this.appName = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(@Nullable String str) {
        this.appVersion = str;
    }

    public String getAppBuild() {
        return this.appBuild;
    }

    public void setAppBuild(@Nullable String str) {
        this.appBuild = str;
    }

    public Map<String, String> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(@Nullable Map<String, String> map) {
        this.permissions = map;
    }

    public Boolean getInForeground() {
        return this.inForeground;
    }

    public void setInForeground(@Nullable Boolean bool) {
        this.inForeground = bool;
    }

    public List<String> getViewNames() {
        return this.viewNames;
    }

    public void setViewNames(@Nullable List<String> list) {
        this.viewNames = list;
    }

    public String getStartType() {
        return this.startType;
    }

    public void setStartType(@Nullable String str) {
        this.startType = str;
    }

    public Boolean getSplitApks() {
        return this.isSplitApks;
    }

    public void setSplitApks(@Nullable Boolean bool) {
        this.isSplitApks = bool;
    }

    public List<String> getSplitNames() {
        return this.splitNames;
    }

    public void setSplitNames(@Nullable List<String> list) {
        this.splitNames = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || App.class != obj.getClass()) {
            return false;
        }
        App app2 = (App) obj;
        return Objects.equals(this.appIdentifier, app2.appIdentifier) && Objects.equals(this.appStartTime, app2.appStartTime) && Objects.equals(this.deviceAppHash, app2.deviceAppHash) && Objects.equals(this.buildType, app2.buildType) && Objects.equals(this.appName, app2.appName) && Objects.equals(this.appVersion, app2.appVersion) && Objects.equals(this.appBuild, app2.appBuild) && Objects.equals(this.permissions, app2.permissions) && Objects.equals(this.inForeground, app2.inForeground) && Objects.equals(this.viewNames, app2.viewNames) && Objects.equals(this.startType, app2.startType) && Objects.equals(this.isSplitApks, app2.isSplitApks) && Objects.equals(this.splitNames, app2.splitNames);
    }

    public int hashCode() {
        return Objects.hash(this.appIdentifier, this.appStartTime, this.deviceAppHash, this.buildType, this.appName, this.appVersion, this.appBuild, this.permissions, this.inForeground, this.viewNames, this.startType, this.isSplitApks, this.splitNames);
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
        if (this.appIdentifier != null) {
            objectWriter.name(JsonKeys.APP_IDENTIFIER).value(this.appIdentifier);
        }
        if (this.appStartTime != null) {
            objectWriter.name(JsonKeys.APP_START_TIME).value(iLogger, this.appStartTime);
        }
        if (this.deviceAppHash != null) {
            objectWriter.name(JsonKeys.DEVICE_APP_HASH).value(this.deviceAppHash);
        }
        if (this.buildType != null) {
            objectWriter.name(JsonKeys.BUILD_TYPE).value(this.buildType);
        }
        if (this.appName != null) {
            objectWriter.name("app_name").value(this.appName);
        }
        if (this.appVersion != null) {
            objectWriter.name("app_version").value(this.appVersion);
        }
        if (this.appBuild != null) {
            objectWriter.name(JsonKeys.APP_BUILD).value(this.appBuild);
        }
        Map<String, String> map = this.permissions;
        if (map != null && !map.isEmpty()) {
            objectWriter.name("permissions").value(iLogger, this.permissions);
        }
        if (this.inForeground != null) {
            objectWriter.name(JsonKeys.IN_FOREGROUND).value(this.inForeground);
        }
        if (this.viewNames != null) {
            objectWriter.name(JsonKeys.VIEW_NAMES).value(iLogger, this.viewNames);
        }
        if (this.startType != null) {
            objectWriter.name(JsonKeys.START_TYPE).value(this.startType);
        }
        if (this.isSplitApks != null) {
            objectWriter.name(JsonKeys.IS_SPLIT_APKS).value(this.isSplitApks);
        }
        List<String> list = this.splitNames;
        if (list != null && !list.isEmpty()) {
            objectWriter.name(JsonKeys.SPLIT_NAMES).value(iLogger, this.splitNames);
        }
        Map<String, Object> map2 = this.unknown;
        if (map2 != null) {
            for (String str : map2.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<App> {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:60:0x00bf  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // io.sentry.JsonDeserializer
        public App deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            App app2 = new App();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName.hashCode()) {
                    case -1950148125:
                        if (!strNextName.equals(JsonKeys.SPLIT_NAMES)) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    case -1898053579:
                        if (!strNextName.equals(JsonKeys.DEVICE_APP_HASH)) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case -1573129993:
                        if (!strNextName.equals(JsonKeys.START_TYPE)) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case -1524619986:
                        if (!strNextName.equals(JsonKeys.VIEW_NAMES)) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    case -901870406:
                        if (!strNextName.equals("app_version")) {
                            b = -1;
                        } else {
                            b = 4;
                        }
                        break;
                    case -650544995:
                        if (!strNextName.equals(JsonKeys.IN_FOREGROUND)) {
                            b = -1;
                        } else {
                            b = 5;
                        }
                        break;
                    case -470395285:
                        if (!strNextName.equals(JsonKeys.BUILD_TYPE)) {
                            b = -1;
                        } else {
                            b = 6;
                        }
                        break;
                    case 746297735:
                        if (!strNextName.equals(JsonKeys.APP_IDENTIFIER)) {
                            b = -1;
                        } else {
                            b = 7;
                        }
                        break;
                    case 791585128:
                        if (!strNextName.equals(JsonKeys.APP_START_TIME)) {
                            b = -1;
                        } else {
                            b = 8;
                        }
                        break;
                    case 1133704324:
                        if (!strNextName.equals("permissions")) {
                            b = -1;
                        } else {
                            b = 9;
                        }
                        break;
                    case 1167648233:
                        if (!strNextName.equals("app_name")) {
                            b = -1;
                        } else {
                            b = 10;
                        }
                        break;
                    case 1826866896:
                        if (!strNextName.equals(JsonKeys.APP_BUILD)) {
                            b = -1;
                        } else {
                            b = Ascii.VT;
                        }
                        break;
                    case 1965003281:
                        if (!strNextName.equals(JsonKeys.IS_SPLIT_APKS)) {
                            b = -1;
                        } else {
                            b = Ascii.FF;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        List<String> list = (List) objectReader.nextObjectOrNull();
                        if (list != null) {
                            app2.setSplitNames(list);
                        }
                        break;
                    case 1:
                        app2.deviceAppHash = objectReader.nextStringOrNull();
                        break;
                    case 2:
                        app2.startType = objectReader.nextStringOrNull();
                        break;
                    case 3:
                        List<String> list2 = (List) objectReader.nextObjectOrNull();
                        if (list2 != null) {
                            app2.setViewNames(list2);
                        }
                        break;
                    case 4:
                        app2.appVersion = objectReader.nextStringOrNull();
                        break;
                    case 5:
                        app2.inForeground = objectReader.nextBooleanOrNull();
                        break;
                    case 6:
                        app2.buildType = objectReader.nextStringOrNull();
                        break;
                    case 7:
                        app2.appIdentifier = objectReader.nextStringOrNull();
                        break;
                    case 8:
                        app2.appStartTime = objectReader.nextDateOrNull(iLogger);
                        break;
                    case 9:
                        app2.permissions = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                        break;
                    case 10:
                        app2.appName = objectReader.nextStringOrNull();
                        break;
                    case 11:
                        app2.appBuild = objectReader.nextStringOrNull();
                        break;
                    case 12:
                        app2.isSplitApks = objectReader.nextBooleanOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            app2.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return app2;
        }
    }
}
