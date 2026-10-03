package io.sentry;

import com.facebook.appevents.AppEventsConstants;
import com.google.common.base.Ascii;
import io.sentry.profilemeasurements.ProfileMeasurement;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class ProfilingTraceData implements JsonUnknown, JsonSerializable {
    private static final String DEFAULT_ENVIRONMENT = "production";
    public static final String TRUNCATION_REASON_BACKGROUNDED = "backgrounded";
    public static final String TRUNCATION_REASON_NORMAL = "normal";
    public static final String TRUNCATION_REASON_TIMEOUT = "timeout";
    private int androidApiLevel;
    private String buildId;
    private String cpuArchitecture;
    private List<Integer> deviceCpuFrequencies;
    private final Callable<List<Integer>> deviceCpuFrequenciesReader;
    private boolean deviceIsEmulator;
    private String deviceLocale;
    private String deviceManufacturer;
    private String deviceModel;
    private String deviceOsBuildNumber;
    private String deviceOsName;
    private String deviceOsVersion;
    private String devicePhysicalMemoryBytes;
    private String durationNs;
    private String environment;
    private final Map<String, ProfileMeasurement> measurementsMap;
    private String platform;
    private String profileId;
    private String release;
    private String sampledProfile;
    private Date timestamp;
    private final File traceFile;
    private String traceId;
    private String transactionId;
    private String transactionName;
    private List<ProfilingTransactionData> transactions;
    private String truncationReason;
    private Map<String, Object> unknown;
    private String versionCode;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class JsonKeys {
        public static final String ANDROID_API_LEVEL = "android_api_level";
        public static final String ARCHITECTURE = "architecture";
        public static final String BUILD_ID = "build_id";
        public static final String DEVICE_CPU_FREQUENCIES = "device_cpu_frequencies";
        public static final String DEVICE_IS_EMULATOR = "device_is_emulator";
        public static final String DEVICE_LOCALE = "device_locale";
        public static final String DEVICE_MANUFACTURER = "device_manufacturer";
        public static final String DEVICE_MODEL = "device_model";
        public static final String DEVICE_OS_BUILD_NUMBER = "device_os_build_number";
        public static final String DEVICE_OS_NAME = "device_os_name";
        public static final String DEVICE_OS_VERSION = "device_os_version";
        public static final String DEVICE_PHYSICAL_MEMORY_BYTES = "device_physical_memory_bytes";
        public static final String DURATION_NS = "duration_ns";
        public static final String ENVIRONMENT = "environment";
        public static final String MEASUREMENTS = "measurements";
        public static final String PLATFORM = "platform";
        public static final String PROFILE_ID = "profile_id";
        public static final String RELEASE = "version_name";
        public static final String SAMPLED_PROFILE = "sampled_profile";
        public static final String TIMESTAMP = "timestamp";
        public static final String TRACE_ID = "trace_id";
        public static final String TRANSACTION_ID = "transaction_id";
        public static final String TRANSACTION_LIST = "transactions";
        public static final String TRANSACTION_NAME = "transaction_name";
        public static final String TRUNCATION_REASON = "truncation_reason";
        public static final String VERSION_CODE = "version_code";
    }

    private ProfilingTraceData() {
        this(new File("dummy"), NoOpTransaction.getInstance());
    }

    public ProfilingTraceData(@NotNull File file, @NotNull ITransaction iTransaction) {
        this(file, DateUtils.getCurrentDateTime(), new ArrayList(), iTransaction.getName(), iTransaction.getEventId().toString(), iTransaction.getSpanContext().getTraceId().toString(), AppEventsConstants.EVENT_PARAM_VALUE_NO, 0, "", new Callable() { // from class: io.sentry.ProfilingTraceData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ProfilingTraceData.lambda$new$0();
            }
        }, null, null, null, null, null, null, null, null, TRUNCATION_REASON_NORMAL, new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$new$0() throws Exception {
        return new ArrayList();
    }

    public ProfilingTraceData(@NotNull File file, @NotNull Date date, @NotNull List<ProfilingTransactionData> list, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, @NotNull String str5, @NotNull Callable<List<Integer>> callable, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Boolean bool, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @NotNull String str13, @NotNull Map<String, ProfileMeasurement> map) {
        this.deviceCpuFrequencies = new ArrayList();
        this.sampledProfile = null;
        this.traceFile = file;
        this.timestamp = date;
        this.cpuArchitecture = str5;
        this.deviceCpuFrequenciesReader = callable;
        this.androidApiLevel = i;
        this.deviceLocale = Locale.getDefault().toString();
        this.deviceManufacturer = str6 != null ? str6 : "";
        this.deviceModel = str7 != null ? str7 : "";
        this.deviceOsVersion = str8 != null ? str8 : "";
        this.deviceIsEmulator = bool != null ? bool.booleanValue() : false;
        this.devicePhysicalMemoryBytes = str9 != null ? str9 : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.deviceOsBuildNumber = "";
        this.deviceOsName = "android";
        this.platform = "android";
        this.buildId = str10 != null ? str10 : "";
        this.transactions = list;
        this.transactionName = str.isEmpty() ? "unknown" : str;
        this.durationNs = str4;
        this.versionCode = "";
        this.release = str11 != null ? str11 : "";
        this.transactionId = str2;
        this.traceId = str3;
        this.profileId = SentryUUID.generateSentryId();
        this.environment = str12 != null ? str12 : DEFAULT_ENVIRONMENT;
        this.truncationReason = str13;
        if (!isTruncationReasonValid()) {
            this.truncationReason = TRUNCATION_REASON_NORMAL;
        }
        this.measurementsMap = map;
    }

    private boolean isTruncationReasonValid() {
        return this.truncationReason.equals(TRUNCATION_REASON_NORMAL) || this.truncationReason.equals(TRUNCATION_REASON_TIMEOUT) || this.truncationReason.equals(TRUNCATION_REASON_BACKGROUNDED);
    }

    public File getTraceFile() {
        return this.traceFile;
    }

    public int getAndroidApiLevel() {
        return this.androidApiLevel;
    }

    public String getCpuArchitecture() {
        return this.cpuArchitecture;
    }

    public String getDeviceLocale() {
        return this.deviceLocale;
    }

    public String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getDeviceOsBuildNumber() {
        return this.deviceOsBuildNumber;
    }

    public String getDeviceOsName() {
        return this.deviceOsName;
    }

    public String getDeviceOsVersion() {
        return this.deviceOsVersion;
    }

    public boolean isDeviceIsEmulator() {
        return this.deviceIsEmulator;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getBuildId() {
        return this.buildId;
    }

    public String getTransactionName() {
        return this.transactionName;
    }

    public String getRelease() {
        return this.release;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public List<ProfilingTransactionData> getTransactions() {
        return this.transactions;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getProfileId() {
        return this.profileId;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public String getSampledProfile() {
        return this.sampledProfile;
    }

    public String getDurationNs() {
        return this.durationNs;
    }

    public List<Integer> getDeviceCpuFrequencies() {
        return this.deviceCpuFrequencies;
    }

    public String getDevicePhysicalMemoryBytes() {
        return this.devicePhysicalMemoryBytes;
    }

    public String getTruncationReason() {
        return this.truncationReason;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public Map<String, ProfileMeasurement> getMeasurementsMap() {
        return this.measurementsMap;
    }

    public void setAndroidApiLevel(int i) {
        this.androidApiLevel = i;
    }

    public void setCpuArchitecture(@NotNull String str) {
        this.cpuArchitecture = str;
    }

    public void setDeviceLocale(@NotNull String str) {
        this.deviceLocale = str;
    }

    public void setDeviceManufacturer(@NotNull String str) {
        this.deviceManufacturer = str;
    }

    public void setDeviceModel(@NotNull String str) {
        this.deviceModel = str;
    }

    public void setDeviceOsBuildNumber(@NotNull String str) {
        this.deviceOsBuildNumber = str;
    }

    public void setDeviceOsVersion(@NotNull String str) {
        this.deviceOsVersion = str;
    }

    public void setDeviceIsEmulator(boolean z) {
        this.deviceIsEmulator = z;
    }

    public void setDeviceCpuFrequencies(@NotNull List<Integer> list) {
        this.deviceCpuFrequencies = list;
    }

    public void setDevicePhysicalMemoryBytes(@NotNull String str) {
        this.devicePhysicalMemoryBytes = str;
    }

    public void setTimestamp(@NotNull Date date) {
        this.timestamp = date;
    }

    public void setTruncationReason(@NotNull String str) {
        this.truncationReason = str;
    }

    public void setTransactions(@NotNull List<ProfilingTransactionData> list) {
        this.transactions = list;
    }

    public void setBuildId(@NotNull String str) {
        this.buildId = str;
    }

    public void setTransactionName(@NotNull String str) {
        this.transactionName = str;
    }

    public void setDurationNs(@NotNull String str) {
        this.durationNs = str;
    }

    public void setRelease(@NotNull String str) {
        this.release = str;
    }

    public void setTransactionId(@NotNull String str) {
        this.transactionId = str;
    }

    public void setTraceId(@NotNull String str) {
        this.traceId = str;
    }

    public void setProfileId(@NotNull String str) {
        this.profileId = str;
    }

    public void setEnvironment(@NotNull String str) {
        this.environment = str;
    }

    public void setSampledProfile(@Nullable String str) {
        this.sampledProfile = str;
    }

    public void readDeviceCpuFrequencies() {
        try {
            this.deviceCpuFrequencies = this.deviceCpuFrequenciesReader.call();
        } catch (Throwable unused) {
        }
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name(JsonKeys.ANDROID_API_LEVEL).value(iLogger, Integer.valueOf(this.androidApiLevel));
        objectWriter.name(JsonKeys.DEVICE_LOCALE).value(iLogger, this.deviceLocale);
        objectWriter.name(JsonKeys.DEVICE_MANUFACTURER).value(this.deviceManufacturer);
        objectWriter.name(JsonKeys.DEVICE_MODEL).value(this.deviceModel);
        objectWriter.name(JsonKeys.DEVICE_OS_BUILD_NUMBER).value(this.deviceOsBuildNumber);
        objectWriter.name(JsonKeys.DEVICE_OS_NAME).value(this.deviceOsName);
        objectWriter.name(JsonKeys.DEVICE_OS_VERSION).value(this.deviceOsVersion);
        objectWriter.name(JsonKeys.DEVICE_IS_EMULATOR).value(this.deviceIsEmulator);
        objectWriter.name(JsonKeys.ARCHITECTURE).value(iLogger, this.cpuArchitecture);
        objectWriter.name(JsonKeys.DEVICE_CPU_FREQUENCIES).value(iLogger, this.deviceCpuFrequencies);
        objectWriter.name(JsonKeys.DEVICE_PHYSICAL_MEMORY_BYTES).value(this.devicePhysicalMemoryBytes);
        objectWriter.name("platform").value(this.platform);
        objectWriter.name(JsonKeys.BUILD_ID).value(this.buildId);
        objectWriter.name(JsonKeys.TRANSACTION_NAME).value(this.transactionName);
        objectWriter.name(JsonKeys.DURATION_NS).value(this.durationNs);
        objectWriter.name(JsonKeys.RELEASE).value(this.release);
        objectWriter.name(JsonKeys.VERSION_CODE).value(this.versionCode);
        if (!this.transactions.isEmpty()) {
            objectWriter.name(JsonKeys.TRANSACTION_LIST).value(iLogger, this.transactions);
        }
        objectWriter.name("transaction_id").value(this.transactionId);
        objectWriter.name("trace_id").value(this.traceId);
        objectWriter.name(JsonKeys.PROFILE_ID).value(this.profileId);
        objectWriter.name("environment").value(this.environment);
        objectWriter.name(JsonKeys.TRUNCATION_REASON).value(this.truncationReason);
        if (this.sampledProfile != null) {
            objectWriter.name("sampled_profile").value(this.sampledProfile);
        }
        String indent = objectWriter.getIndent();
        objectWriter.setIndent("");
        objectWriter.name("measurements").value(iLogger, this.measurementsMap);
        objectWriter.setIndent(indent);
        objectWriter.name("timestamp").value(iLogger, this.timestamp);
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

    public static final class Deserializer implements JsonDeserializer<ProfilingTraceData> {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:112:0x0175  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // io.sentry.JsonDeserializer
        public ProfilingTraceData deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            byte b;
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            ProfilingTraceData profilingTraceData = new ProfilingTraceData();
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName.hashCode()) {
                    case -2133529830:
                        if (!strNextName.equals(JsonKeys.DEVICE_MANUFACTURER)) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    case -1981468849:
                        if (!strNextName.equals(JsonKeys.ANDROID_API_LEVEL)) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case -1430655860:
                        if (!strNextName.equals(JsonKeys.BUILD_ID)) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case -1172160413:
                        if (!strNextName.equals(JsonKeys.DEVICE_LOCALE)) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    case -1102636175:
                        if (!strNextName.equals(JsonKeys.PROFILE_ID)) {
                            b = -1;
                        } else {
                            b = 4;
                        }
                        break;
                    case -716656436:
                        if (!strNextName.equals(JsonKeys.DEVICE_OS_BUILD_NUMBER)) {
                            b = -1;
                        } else {
                            b = 5;
                        }
                        break;
                    case -591076352:
                        if (!strNextName.equals(JsonKeys.DEVICE_MODEL)) {
                            b = -1;
                        } else {
                            b = 6;
                        }
                        break;
                    case -512511455:
                        if (!strNextName.equals(JsonKeys.DEVICE_IS_EMULATOR)) {
                            b = -1;
                        } else {
                            b = 7;
                        }
                        break;
                    case -478065584:
                        if (!strNextName.equals(JsonKeys.DURATION_NS)) {
                            b = -1;
                        } else {
                            b = 8;
                        }
                        break;
                    case -362243017:
                        if (!strNextName.equals("measurements")) {
                            b = -1;
                        } else {
                            b = 9;
                        }
                        break;
                    case -332426004:
                        if (!strNextName.equals(JsonKeys.DEVICE_PHYSICAL_MEMORY_BYTES)) {
                            b = -1;
                        } else {
                            b = 10;
                        }
                        break;
                    case -212264198:
                        if (!strNextName.equals(JsonKeys.DEVICE_CPU_FREQUENCIES)) {
                            b = -1;
                        } else {
                            b = Ascii.VT;
                        }
                        break;
                    case -102985484:
                        if (!strNextName.equals(JsonKeys.VERSION_CODE)) {
                            b = -1;
                        } else {
                            b = Ascii.FF;
                        }
                        break;
                    case -102670958:
                        if (!strNextName.equals(JsonKeys.RELEASE)) {
                            b = -1;
                        } else {
                            b = Ascii.CR;
                        }
                        break;
                    case -85904877:
                        if (!strNextName.equals("environment")) {
                            b = -1;
                        } else {
                            b = Ascii.SO;
                        }
                        break;
                    case 55126294:
                        if (!strNextName.equals("timestamp")) {
                            b = -1;
                        } else {
                            b = Ascii.SI;
                        }
                        break;
                    case 508853068:
                        if (!strNextName.equals(JsonKeys.TRANSACTION_NAME)) {
                            b = -1;
                        } else {
                            b = Ascii.DLE;
                        }
                        break;
                    case 796476189:
                        if (!strNextName.equals(JsonKeys.DEVICE_OS_NAME)) {
                            b = -1;
                        } else {
                            b = 17;
                        }
                        break;
                    case 839674195:
                        if (!strNextName.equals(JsonKeys.ARCHITECTURE)) {
                            b = -1;
                        } else {
                            b = Ascii.DC2;
                        }
                        break;
                    case 1010584092:
                        if (!strNextName.equals("transaction_id")) {
                            b = -1;
                        } else {
                            b = 19;
                        }
                        break;
                    case 1052553990:
                        if (!strNextName.equals(JsonKeys.DEVICE_OS_VERSION)) {
                            b = -1;
                        } else {
                            b = Ascii.DC4;
                        }
                        break;
                    case 1163928186:
                        if (!strNextName.equals(JsonKeys.TRUNCATION_REASON)) {
                            b = -1;
                        } else {
                            b = Ascii.NAK;
                        }
                        break;
                    case 1270300245:
                        if (!strNextName.equals("trace_id")) {
                            b = -1;
                        } else {
                            b = Ascii.SYN;
                        }
                        break;
                    case 1874684019:
                        if (!strNextName.equals("platform")) {
                            b = -1;
                        } else {
                            b = Ascii.ETB;
                        }
                        break;
                    case 1953158756:
                        if (!strNextName.equals("sampled_profile")) {
                            b = -1;
                        } else {
                            b = Ascii.CAN;
                        }
                        break;
                    case 1954122069:
                        if (!strNextName.equals(JsonKeys.TRANSACTION_LIST)) {
                            b = -1;
                        } else {
                            b = Ascii.EM;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        String strNextStringOrNull = objectReader.nextStringOrNull();
                        if (strNextStringOrNull != null) {
                            profilingTraceData.deviceManufacturer = strNextStringOrNull;
                        }
                        break;
                    case 1:
                        Integer numNextIntegerOrNull = objectReader.nextIntegerOrNull();
                        if (numNextIntegerOrNull != null) {
                            profilingTraceData.androidApiLevel = numNextIntegerOrNull.intValue();
                        }
                        break;
                    case 2:
                        String strNextStringOrNull2 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull2 != null) {
                            profilingTraceData.buildId = strNextStringOrNull2;
                        }
                        break;
                    case 3:
                        String strNextStringOrNull3 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull3 != null) {
                            profilingTraceData.deviceLocale = strNextStringOrNull3;
                        }
                        break;
                    case 4:
                        String strNextStringOrNull4 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull4 != null) {
                            profilingTraceData.profileId = strNextStringOrNull4;
                        }
                        break;
                    case 5:
                        String strNextStringOrNull5 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull5 != null) {
                            profilingTraceData.deviceOsBuildNumber = strNextStringOrNull5;
                        }
                        break;
                    case 6:
                        String strNextStringOrNull6 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull6 != null) {
                            profilingTraceData.deviceModel = strNextStringOrNull6;
                        }
                        break;
                    case 7:
                        Boolean boolNextBooleanOrNull = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull != null) {
                            profilingTraceData.deviceIsEmulator = boolNextBooleanOrNull.booleanValue();
                        }
                        break;
                    case 8:
                        String strNextStringOrNull7 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull7 != null) {
                            profilingTraceData.durationNs = strNextStringOrNull7;
                        }
                        break;
                    case 9:
                        Map mapNextMapOrNull = objectReader.nextMapOrNull(iLogger, new ProfileMeasurement.Deserializer());
                        if (mapNextMapOrNull != null) {
                            profilingTraceData.measurementsMap.putAll(mapNextMapOrNull);
                        }
                        break;
                    case 10:
                        String strNextStringOrNull8 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull8 != null) {
                            profilingTraceData.devicePhysicalMemoryBytes = strNextStringOrNull8;
                        }
                        break;
                    case 11:
                        List list = (List) objectReader.nextObjectOrNull();
                        if (list != null) {
                            profilingTraceData.deviceCpuFrequencies = list;
                        }
                        break;
                    case 12:
                        String strNextStringOrNull9 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull9 != null) {
                            profilingTraceData.versionCode = strNextStringOrNull9;
                        }
                        break;
                    case 13:
                        String strNextStringOrNull10 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull10 != null) {
                            profilingTraceData.release = strNextStringOrNull10;
                        }
                        break;
                    case 14:
                        String strNextStringOrNull11 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull11 != null) {
                            profilingTraceData.environment = strNextStringOrNull11;
                        }
                        break;
                    case 15:
                        Date dateNextDateOrNull = objectReader.nextDateOrNull(iLogger);
                        if (dateNextDateOrNull != null) {
                            profilingTraceData.timestamp = dateNextDateOrNull;
                        }
                        break;
                    case 16:
                        String strNextStringOrNull12 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull12 != null) {
                            profilingTraceData.transactionName = strNextStringOrNull12;
                        }
                        break;
                    case 17:
                        String strNextStringOrNull13 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull13 != null) {
                            profilingTraceData.deviceOsName = strNextStringOrNull13;
                        }
                        break;
                    case 18:
                        String strNextStringOrNull14 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull14 != null) {
                            profilingTraceData.cpuArchitecture = strNextStringOrNull14;
                        }
                        break;
                    case 19:
                        String strNextStringOrNull15 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull15 != null) {
                            profilingTraceData.transactionId = strNextStringOrNull15;
                        }
                        break;
                    case 20:
                        String strNextStringOrNull16 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull16 != null) {
                            profilingTraceData.deviceOsVersion = strNextStringOrNull16;
                        }
                        break;
                    case 21:
                        String strNextStringOrNull17 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull17 != null) {
                            profilingTraceData.truncationReason = strNextStringOrNull17;
                        }
                        break;
                    case 22:
                        String strNextStringOrNull18 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull18 != null) {
                            profilingTraceData.traceId = strNextStringOrNull18;
                        }
                        break;
                    case 23:
                        String strNextStringOrNull19 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull19 != null) {
                            profilingTraceData.platform = strNextStringOrNull19;
                        }
                        break;
                    case 24:
                        String strNextStringOrNull20 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull20 != null) {
                            profilingTraceData.sampledProfile = strNextStringOrNull20;
                        }
                        break;
                    case 25:
                        List listNextListOrNull = objectReader.nextListOrNull(iLogger, new ProfilingTransactionData.Deserializer());
                        if (listNextListOrNull != null) {
                            profilingTraceData.transactions.addAll(listNextListOrNull);
                        }
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            profilingTraceData.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return profilingTraceData;
        }
    }
}
