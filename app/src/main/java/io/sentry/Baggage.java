package io.sentry;

import ch.qos.logback.core.CoreConstants;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.SampleRateUtils;
import io.sentry.util.StringUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class Baggage {
    static final String CHARSET = "UTF-8";
    static final String SENTRY_BAGGAGE_PREFIX = "sentry-";
    private final ConcurrentHashMap<String, String> keyValues;
    private final AutoClosableReentrantLock keyValuesLock;
    final ILogger logger;
    private boolean mutable;
    private Double sampleRand;
    private Double sampleRate;
    private final boolean shouldFreeze;
    private final String thirdPartyHeader;
    static final Integer MAX_BAGGAGE_STRING_LENGTH = 8192;
    static final Integer MAX_BAGGAGE_LIST_MEMBER_COUNT = 64;
    private static final DecimalFormatterThreadLocal decimalFormatter = new DecimalFormatterThreadLocal();

    /* JADX INFO: loaded from: classes6.dex */
    public static final class DSCKeys {
        public static final String TRACE_ID = "sentry-trace_id";
        public static final String PUBLIC_KEY = "sentry-public_key";
        public static final String RELEASE = "sentry-release";
        public static final String USER_ID = "sentry-user_id";
        public static final String ENVIRONMENT = "sentry-environment";
        public static final String TRANSACTION = "sentry-transaction";
        public static final String SAMPLE_RATE = "sentry-sample_rate";
        public static final String SAMPLE_RAND = "sentry-sample_rand";
        public static final String SAMPLED = "sentry-sampled";
        public static final String REPLAY_ID = "sentry-replay_id";
        public static final List<String> ALL = Arrays.asList(TRACE_ID, PUBLIC_KEY, RELEASE, USER_ID, ENVIRONMENT, TRANSACTION, SAMPLE_RATE, SAMPLE_RAND, SAMPLED, REPLAY_ID);
    }

    static class DecimalFormatterThreadLocal extends ThreadLocal<DecimalFormat> {
        private DecimalFormatterThreadLocal() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public DecimalFormat initialValue() {
            return new DecimalFormat("#.################", DecimalFormatSymbols.getInstance(Locale.ROOT));
        }
    }

    public static Baggage fromHeader(@Nullable String str) {
        return fromHeader(str, false, ScopesAdapter.getInstance().getOptions().getLogger());
    }

    public static Baggage fromHeader(@Nullable List<String> list) {
        return fromHeader(list, false, ScopesAdapter.getInstance().getOptions().getLogger());
    }

    public static Baggage fromHeader(String str, @NotNull ILogger iLogger) {
        return fromHeader(str, false, iLogger);
    }

    public static Baggage fromHeader(@Nullable List<String> list, @NotNull ILogger iLogger) {
        return fromHeader(list, false, iLogger);
    }

    public static Baggage fromHeader(@Nullable List<String> list, boolean z, @NotNull ILogger iLogger) {
        if (list != null) {
            return fromHeader(StringUtils.join(",", list), z, iLogger);
        }
        return fromHeader((String) null, z, iLogger);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:36:0x00af  */
    public static Baggage fromHeader(@Nullable String str, boolean z, @NotNull ILogger iLogger) {
        boolean z2;
        Double d;
        Double d2;
        String strJoin;
        boolean z3;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (str != null) {
            try {
                String[] strArrSplit = str.split(",", -1);
                int length = strArrSplit.length;
                int i2 = 0;
                boolean z4 = false;
                d = null;
                d2 = null;
                while (i2 < length) {
                    try {
                        String str2 = strArrSplit[i2];
                        if (str2.trim().startsWith(SENTRY_BAGGAGE_PREFIX)) {
                            try {
                                int iIndexOf = str2.indexOf("=");
                                String strTrim = str2.substring(i, iIndexOf).trim();
                                String strDecode = decode(strTrim);
                                String strDecode2 = decode(str2.substring(iIndexOf + 1).trim());
                                if (DSCKeys.SAMPLE_RATE.equals(strDecode)) {
                                    d2 = toDouble(strDecode2);
                                } else if (DSCKeys.SAMPLE_RAND.equals(strDecode)) {
                                    d = toDouble(strDecode2);
                                } else {
                                    concurrentHashMap.put(strDecode, strDecode2);
                                }
                                if (!DSCKeys.SAMPLE_RAND.equalsIgnoreCase(strTrim)) {
                                    z4 = true;
                                }
                            } catch (Throwable th) {
                                iLogger.log(SentryLevel.ERROR, th, "Unable to decode baggage key value pair %s", str2);
                            }
                        } else if (z) {
                            arrayList.add(str2.trim());
                        }
                        i2++;
                        i = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        z3 = z4;
                        iLogger.log(SentryLevel.ERROR, th, "Unable to decode baggage header %s", str);
                        z2 = z3;
                        if (arrayList.isEmpty()) {
                            strJoin = null;
                        } else {
                            strJoin = StringUtils.join(",", arrayList);
                        }
                        return new Baggage(concurrentHashMap, d2, d, strJoin, true, z2, iLogger);
                    }
                }
                z2 = z4;
            } catch (Throwable th3) {
                th = th3;
                z3 = false;
                d = null;
                d2 = null;
            }
        } else {
            z2 = false;
            d = null;
            d2 = null;
        }
        if (arrayList.isEmpty()) {
            strJoin = null;
        } else {
            strJoin = StringUtils.join(",", arrayList);
        }
        return new Baggage(concurrentHashMap, d2, d, strJoin, true, z2, iLogger);
    }

    public static Baggage fromEvent(@NotNull SentryBaseEvent sentryBaseEvent, @Nullable String str, @NotNull SentryOptions sentryOptions) {
        Baggage baggage = new Baggage(sentryOptions.getLogger());
        SpanContext trace = sentryBaseEvent.getContexts().getTrace();
        baggage.setTraceId(trace != null ? trace.getTraceId().toString() : null);
        baggage.setPublicKey(sentryOptions.retrieveParsedDsn().getPublicKey());
        baggage.setRelease(sentryBaseEvent.getRelease());
        baggage.setEnvironment(sentryBaseEvent.getEnvironment());
        baggage.setTransaction(str);
        baggage.setSampleRate(null);
        baggage.setSampled(null);
        baggage.setSampleRand(null);
        Object obj = sentryBaseEvent.getContexts().get("replay_id");
        if (obj != null && !obj.toString().equals(SentryId.EMPTY_ID.toString())) {
            baggage.setReplayId(obj.toString());
            sentryBaseEvent.getContexts().remove("replay_id");
        }
        baggage.freeze();
        return baggage;
    }

    public Baggage(@NotNull ILogger iLogger) {
        this(new ConcurrentHashMap(), null, null, null, true, false, iLogger);
    }

    public Baggage(@NotNull Baggage baggage) {
        this(baggage.keyValues, baggage.sampleRate, baggage.sampleRand, baggage.thirdPartyHeader, baggage.mutable, baggage.shouldFreeze, baggage.logger);
    }

    public Baggage(@NotNull ConcurrentHashMap<String, String> concurrentHashMap, @Nullable Double d, @Nullable Double d2, @Nullable String str, boolean z, boolean z2, @NotNull ILogger iLogger) {
        this.keyValuesLock = new AutoClosableReentrantLock();
        this.keyValues = concurrentHashMap;
        this.sampleRate = d;
        this.sampleRand = d2;
        this.logger = iLogger;
        this.thirdPartyHeader = str;
        this.mutable = z;
        this.shouldFreeze = z2;
    }

    public void freeze() {
        this.mutable = false;
    }

    public boolean isMutable() {
        return this.mutable;
    }

    public boolean isShouldFreeze() {
        return this.shouldFreeze;
    }

    public String getThirdPartyHeader() {
        return this.thirdPartyHeader;
    }

    public String toHeaderString(@Nullable String str) {
        String str2;
        int iCountOf;
        String strSampleRateToString;
        StringBuilder sb = new StringBuilder();
        if (str != null && !str.isEmpty()) {
            sb.append(str);
            iCountOf = StringUtils.countOf(str, CoreConstants.COMMA_CHAR) + 1;
            str2 = ",";
        } else {
            str2 = "";
            iCountOf = 0;
        }
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.keyValuesLock.acquire();
        try {
            TreeSet<String> treeSet = new TreeSet(Collections.list(this.keyValues.keys()));
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            treeSet.add(DSCKeys.SAMPLE_RATE);
            treeSet.add(DSCKeys.SAMPLE_RAND);
            for (String str3 : treeSet) {
                if (DSCKeys.SAMPLE_RATE.equals(str3)) {
                    strSampleRateToString = sampleRateToString(this.sampleRate);
                } else if (DSCKeys.SAMPLE_RAND.equals(str3)) {
                    strSampleRateToString = sampleRateToString(this.sampleRand);
                } else {
                    strSampleRateToString = this.keyValues.get(str3);
                }
                if (strSampleRateToString != null) {
                    Integer num = MAX_BAGGAGE_LIST_MEMBER_COUNT;
                    if (iCountOf >= num.intValue()) {
                        this.logger.log(SentryLevel.ERROR, "Not adding baggage value %s as the total number of list members would exceed the maximum of %s.", str3, num);
                    } else {
                        try {
                            String str4 = str2 + encode(str3) + "=" + encode(strSampleRateToString);
                            int length = str4.length();
                            int length2 = sb.length();
                            Integer num2 = MAX_BAGGAGE_STRING_LENGTH;
                            if (length2 + length > num2.intValue()) {
                                this.logger.log(SentryLevel.ERROR, "Not adding baggage value %s as the total header value length would exceed the maximum of %s.", str3, num2);
                            } else {
                                iCountOf++;
                                sb.append(str4);
                                str2 = ",";
                            }
                        } catch (Throwable th) {
                            this.logger.log(SentryLevel.ERROR, th, "Unable to encode baggage key value pair (key=%s,value=%s).", str3, strSampleRateToString);
                        }
                    }
                }
            }
            return sb.toString();
        } catch (Throwable th2) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    private String encode(@NotNull String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static String decode(@NotNull String str) throws UnsupportedEncodingException {
        return URLDecoder.decode(str, "UTF-8");
    }

    public String get(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.keyValues.get(str);
    }

    public String getTraceId() {
        return get(DSCKeys.TRACE_ID);
    }

    public void setTraceId(@Nullable String str) {
        set(DSCKeys.TRACE_ID, str);
    }

    public String getPublicKey() {
        return get(DSCKeys.PUBLIC_KEY);
    }

    public void setPublicKey(@Nullable String str) {
        set(DSCKeys.PUBLIC_KEY, str);
    }

    public String getEnvironment() {
        return get(DSCKeys.ENVIRONMENT);
    }

    public void setEnvironment(@Nullable String str) {
        set(DSCKeys.ENVIRONMENT, str);
    }

    public String getRelease() {
        return get(DSCKeys.RELEASE);
    }

    public void setRelease(@Nullable String str) {
        set(DSCKeys.RELEASE, str);
    }

    public String getUserId() {
        return get(DSCKeys.USER_ID);
    }

    public void setUserId(@Nullable String str) {
        set(DSCKeys.USER_ID, str);
    }

    public String getTransaction() {
        return get(DSCKeys.TRANSACTION);
    }

    public void setTransaction(@Nullable String str) {
        set(DSCKeys.TRANSACTION, str);
    }

    public Double getSampleRate() {
        return this.sampleRate;
    }

    public String getSampled() {
        return get(DSCKeys.SAMPLED);
    }

    public void setSampleRate(@Nullable Double d) {
        if (isMutable()) {
            this.sampleRate = d;
        }
    }

    public void forceSetSampleRate(@Nullable Double d) {
        this.sampleRate = d;
    }

    public Double getSampleRand() {
        return this.sampleRand;
    }

    public void setSampleRand(@Nullable Double d) {
        if (isMutable()) {
            this.sampleRand = d;
        }
    }

    public void setSampled(@Nullable String str) {
        set(DSCKeys.SAMPLED, str);
    }

    public String getReplayId() {
        return get(DSCKeys.REPLAY_ID);
    }

    public void setReplayId(@Nullable String str) {
        set(DSCKeys.REPLAY_ID, str);
    }

    public void set(@NotNull String str, @Nullable String str2) {
        if (this.mutable) {
            if (str2 == null) {
                this.keyValues.remove(str);
            } else {
                this.keyValues.put(str, str2);
            }
        }
    }

    public Map<String, Object> getUnknown() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.keyValuesLock.acquire();
        try {
            for (Map.Entry<String, String> entry : this.keyValues.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!DSCKeys.ALL.contains(key) && value != null) {
                    concurrentHashMap.put(key.replaceFirst(SENTRY_BAGGAGE_PREFIX, ""), value);
                }
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return concurrentHashMap;
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

    public void setValuesFromTransaction(@NotNull SentryId sentryId, @Nullable SentryId sentryId2, @NotNull SentryOptions sentryOptions, @Nullable TracesSamplingDecision tracesSamplingDecision, @Nullable String str, @Nullable TransactionNameSource transactionNameSource) {
        setTraceId(sentryId.toString());
        setPublicKey(sentryOptions.retrieveParsedDsn().getPublicKey());
        setRelease(sentryOptions.getRelease());
        setEnvironment(sentryOptions.getEnvironment());
        if (!isHighQualityTransactionName(transactionNameSource)) {
            str = null;
        }
        setTransaction(str);
        if (sentryId2 != null && !SentryId.EMPTY_ID.equals(sentryId2)) {
            setReplayId(sentryId2.toString());
        }
        setSampleRate(sampleRate(tracesSamplingDecision));
        setSampled(StringUtils.toString(sampled(tracesSamplingDecision)));
        setSampleRand(sampleRand(tracesSamplingDecision));
    }

    public void setValuesFromSamplingDecision(@Nullable TracesSamplingDecision tracesSamplingDecision) {
        if (tracesSamplingDecision == null) {
            return;
        }
        setSampled(StringUtils.toString(sampled(tracesSamplingDecision)));
        if (tracesSamplingDecision.getSampleRand() != null) {
            setSampleRand(sampleRand(tracesSamplingDecision));
        }
        if (tracesSamplingDecision.getSampleRate() != null) {
            forceSetSampleRate(sampleRate(tracesSamplingDecision));
        }
    }

    public void setValuesFromScope(@NotNull IScope iScope, @NotNull SentryOptions sentryOptions) {
        PropagationContext propagationContext = iScope.getPropagationContext();
        SentryId replayId = iScope.getReplayId();
        setTraceId(propagationContext.getTraceId().toString());
        setPublicKey(sentryOptions.retrieveParsedDsn().getPublicKey());
        setRelease(sentryOptions.getRelease());
        setEnvironment(sentryOptions.getEnvironment());
        if (!SentryId.EMPTY_ID.equals(replayId)) {
            setReplayId(replayId.toString());
        }
        setTransaction(null);
        setSampleRate(null);
        setSampled(null);
    }

    private static Double sampleRate(@Nullable TracesSamplingDecision tracesSamplingDecision) {
        if (tracesSamplingDecision == null) {
            return null;
        }
        return tracesSamplingDecision.getSampleRate();
    }

    private static Double sampleRand(@Nullable TracesSamplingDecision tracesSamplingDecision) {
        if (tracesSamplingDecision == null) {
            return null;
        }
        return tracesSamplingDecision.getSampleRand();
    }

    private static String sampleRateToString(@Nullable Double d) {
        if (SampleRateUtils.isValidTracesSampleRate(d, false)) {
            return decimalFormatter.get().format(d);
        }
        return null;
    }

    private static Boolean sampled(@Nullable TracesSamplingDecision tracesSamplingDecision) {
        if (tracesSamplingDecision == null) {
            return null;
        }
        return tracesSamplingDecision.getSampled();
    }

    private static boolean isHighQualityTransactionName(@Nullable TransactionNameSource transactionNameSource) {
        return (transactionNameSource == null || TransactionNameSource.URL.equals(transactionNameSource)) ? false : true;
    }

    private static Double toDouble(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            double d = Double.parseDouble(str);
            if (SampleRateUtils.isValidTracesSampleRate(Double.valueOf(d), false)) {
                return Double.valueOf(d);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public TraceContext toTraceContext() {
        String traceId = getTraceId();
        String replayId = getReplayId();
        String publicKey = getPublicKey();
        if (traceId == null || publicKey == null) {
            return null;
        }
        TraceContext traceContext = new TraceContext(new SentryId(traceId), publicKey, getRelease(), getEnvironment(), getUserId(), getTransaction(), sampleRateToString(getSampleRate()), getSampled(), replayId == null ? null : new SentryId(replayId), sampleRateToString(getSampleRand()));
        traceContext.setUnknown(getUnknown());
        return traceContext;
    }
}
