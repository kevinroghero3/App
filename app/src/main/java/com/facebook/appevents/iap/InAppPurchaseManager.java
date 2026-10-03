package com.facebook.appevents.iap;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.OperationalData;
import com.facebook.appevents.OperationalDataEnum;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class InAppPurchaseManager {
    private static final String GOOGLE_BILLINGCLIENT_VERSION = "com.google.android.play.billingclient.version";
    private static String specificBillingLibraryVersion;
    public static final InAppPurchaseManager INSTANCE = new InAppPurchaseManager();
    private static final ConcurrentHashMap<InAppPurchase, List<Pair<Long, Pair<Bundle, OperationalData>>>> timesOfManualPurchases = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<InAppPurchase, List<Pair<Long, Pair<Bundle, OperationalData>>>> timesOfImplicitPurchases = new ConcurrentHashMap<>();
    private static final AtomicBoolean enabled = new AtomicBoolean(false);

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InAppPurchaseUtils.BillingClientVersion.values().length];
            try {
                iArr[InAppPurchaseUtils.BillingClientVersion.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InAppPurchaseUtils.BillingClientVersion.V1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InAppPurchaseUtils.BillingClientVersion.V2_V4.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InAppPurchaseUtils.BillingClientVersion.V5_V7.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private InAppPurchaseManager() {
    }

    @JvmStatic
    public static final void enableAutoLogging() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return;
        }
        try {
            if (!AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
                InAppPurchaseLoggerManager.updateLatestPossiblePurchaseTime();
            } else {
                enabled.set(true);
                startTracking();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
        }
    }

    @JvmStatic
    public static final void startTracking() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return;
        }
        try {
            if (enabled.get()) {
                InAppPurchaseUtils.BillingClientVersion billingClientVersion = INSTANCE.getBillingClientVersion();
                int i = WhenMappings.$EnumSwitchMapping$0[billingClientVersion.ordinal()];
                if (i == 2) {
                    InAppPurchaseActivityLifecycleTracker.startIapLogging(InAppPurchaseUtils.BillingClientVersion.V1);
                    return;
                }
                if (i == 3) {
                    if (FeatureManager.isEnabled(FeatureManager.Feature.IapLoggingLib2)) {
                        InAppPurchaseAutoLogger.startIapLogging(FacebookSdk.getApplicationContext(), billingClientVersion);
                        return;
                    } else {
                        InAppPurchaseActivityLifecycleTracker.startIapLogging(InAppPurchaseUtils.BillingClientVersion.V2_V4);
                        return;
                    }
                }
                if (i == 4 && FeatureManager.isEnabled(FeatureManager.Feature.IapLoggingLib5To7)) {
                    InAppPurchaseAutoLogger.startIapLogging(FacebookSdk.getApplicationContext(), billingClientVersion);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
        }
    }

    @JvmStatic
    private static final void setSpecificBillingLibraryVersion(String str) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return;
        }
        try {
            specificBillingLibraryVersion = str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
        }
    }

    @JvmStatic
    public static final String getSpecificBillingLibraryVersion() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return null;
        }
        try {
            return specificBillingLibraryVersion;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
            return null;
        }
    }

    private final InAppPurchaseUtils.BillingClientVersion getBillingClientVersion() {
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Context applicationContext = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "context.packageManager.g…TA_DATA\n                )");
                String string = applicationInfo.metaData.getString(GOOGLE_BILLINGCLIENT_VERSION);
                if (string == null) {
                    return InAppPurchaseUtils.BillingClientVersion.NONE;
                }
                List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{"."}, false, 3, 2, (Object) null);
                if (string.length() == 0) {
                    return InAppPurchaseUtils.BillingClientVersion.V5_V7;
                }
                setSpecificBillingLibraryVersion("GPBL." + string);
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) listSplit$default.get(0));
                if (intOrNull == null) {
                    return InAppPurchaseUtils.BillingClientVersion.V5_V7;
                }
                int iIntValue = intOrNull.intValue();
                if (iIntValue == 1) {
                    return InAppPurchaseUtils.BillingClientVersion.V1;
                }
                if (iIntValue < 5) {
                    return InAppPurchaseUtils.BillingClientVersion.V2_V4;
                }
                return InAppPurchaseUtils.BillingClientVersion.V5_V7;
            } catch (Exception unused) {
                return InAppPurchaseUtils.BillingClientVersion.V5_V7;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final Bundle performDedupe(@NotNull List<InAppPurchase> list, long j, boolean z, @NotNull List<Pair<Bundle, OperationalData>> list2) {
        List<Pair<Long, Pair<Bundle, OperationalData>>> list3;
        List<Pair<Long, Pair<Bundle, OperationalData>>> list4;
        InAppPurchase inAppPurchase;
        String str;
        String str2;
        Long l;
        boolean z2;
        List<InAppPurchase> purchases = list;
        List<Pair<Bundle, OperationalData>> purchaseParameters = list2;
        synchronized (InAppPurchaseManager.class) {
            String str3 = null;
            if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(purchases, "purchases");
                Intrinsics.checkNotNullParameter(purchaseParameters, "purchaseParameters");
                if (purchaseParameters.isEmpty()) {
                    return null;
                }
                if (list.size() != list2.size()) {
                    return null;
                }
                ArrayList<Pair> arrayList = new ArrayList();
                int size = list.size();
                Bundle bundle = null;
                int i = 0;
                while (i < size) {
                    InAppPurchase inAppPurchase2 = purchases.get(i);
                    Pair<Bundle, OperationalData> pair = purchaseParameters.get(i);
                    Bundle bundleComponent1 = pair.component1();
                    OperationalData operationalDataComponent2 = pair.component2();
                    InAppPurchase inAppPurchase3 = new InAppPurchase(inAppPurchase2.getEventName(), new BigDecimal(String.valueOf(inAppPurchase2.getAmount())).setScale(2, RoundingMode.HALF_UP).doubleValue(), inAppPurchase2.getCurrency());
                    if (z) {
                        list4 = timesOfManualPurchases.get(inAppPurchase3);
                    } else {
                        list4 = timesOfImplicitPurchases.get(inAppPurchase3);
                    }
                    List<Pair<Long, Pair<Bundle, OperationalData>>> list5 = list4;
                    if (list5 == null || list5.isEmpty()) {
                        inAppPurchase = inAppPurchase3;
                        str = null;
                        str2 = null;
                        l = null;
                        z2 = false;
                    } else {
                        str = str3;
                        str2 = str;
                        Long l2 = str2;
                        z2 = false;
                        for (Pair<Long, Pair<Bundle, OperationalData>> pair2 : list4) {
                            long jLongValue = pair2.getFirst().longValue();
                            Pair<Bundle, OperationalData> second = pair2.getSecond();
                            Bundle bundleComponent2 = second.component1();
                            OperationalData operationalDataComponent3 = second.component2();
                            if (Math.abs(j - jLongValue) <= InAppPurchaseDedupeConfig.INSTANCE.getDedupeWindow() && (l2 == 0 || jLongValue < l2.longValue())) {
                                InAppPurchaseManager inAppPurchaseManager = INSTANCE;
                                boolean z3 = !z;
                                InAppPurchase inAppPurchase4 = inAppPurchase3;
                                String dedupeParameter$default = getDedupeParameter$default(inAppPurchaseManager, bundleComponent1, operationalDataComponent2, bundleComponent2, operationalDataComponent3, z3, false, 32, null);
                                String dedupeParameter = inAppPurchaseManager.getDedupeParameter(bundleComponent1, operationalDataComponent2, bundleComponent2, operationalDataComponent3, z3, true);
                                if (dedupeParameter != null) {
                                    str = dedupeParameter;
                                }
                                if (dedupeParameter$default != null) {
                                    Long lValueOf = Long.valueOf(jLongValue);
                                    arrayList.add(new Pair(inAppPurchase4, Long.valueOf(jLongValue)));
                                    l2 = lValueOf;
                                    z2 = true;
                                }
                                inAppPurchase3 = inAppPurchase4;
                                str2 = dedupeParameter$default;
                            }
                        }
                        inAppPurchase = inAppPurchase3;
                        l = l2;
                    }
                    if (str != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putString(Constants.IAP_TEST_DEDUP_RESULT, AppEventsConstants.EVENT_PARAM_VALUE_YES);
                        bundle.putString(Constants.IAP_TEST_DEDUP_KEY_USED, str);
                    }
                    if (z2) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putString(Constants.IAP_NON_DEDUPED_EVENT_TIME, String.valueOf(l != null ? l.longValue() / ((long) 1000) : 0L));
                        bundle.putString(Constants.IAP_ACTUAL_DEDUP_RESULT, AppEventsConstants.EVENT_PARAM_VALUE_YES);
                        bundle.putString(Constants.IAP_ACTUAL_DEDUP_KEY_USED, str2);
                    }
                    if (z && !z2) {
                        ConcurrentHashMap<InAppPurchase, List<Pair<Long, Pair<Bundle, OperationalData>>>> concurrentHashMap = timesOfImplicitPurchases;
                        if (concurrentHashMap.get(inAppPurchase) == null) {
                            concurrentHashMap.put(inAppPurchase, new ArrayList());
                        }
                        List<Pair<Long, Pair<Bundle, OperationalData>>> list6 = concurrentHashMap.get(inAppPurchase);
                        if (list6 != null) {
                            list6.add(new Pair<>(Long.valueOf(j), new Pair(bundleComponent1, operationalDataComponent2)));
                        }
                    } else if (!z && !z2) {
                        ConcurrentHashMap<InAppPurchase, List<Pair<Long, Pair<Bundle, OperationalData>>>> concurrentHashMap2 = timesOfManualPurchases;
                        if (concurrentHashMap2.get(inAppPurchase) == null) {
                            concurrentHashMap2.put(inAppPurchase, new ArrayList());
                        }
                        List<Pair<Long, Pair<Bundle, OperationalData>>> list7 = concurrentHashMap2.get(inAppPurchase);
                        if (list7 != null) {
                            list7.add(new Pair<>(Long.valueOf(j), new Pair(bundleComponent1, operationalDataComponent2)));
                        }
                    }
                    i++;
                    purchases = list;
                    purchaseParameters = list2;
                    str3 = null;
                }
                for (Pair pair3 : arrayList) {
                    if (z) {
                        list3 = timesOfManualPurchases.get(pair3.getFirst());
                    } else {
                        list3 = timesOfImplicitPurchases.get(pair3.getFirst());
                    }
                    if (list3 != null) {
                        Iterator<Pair<Long, Pair<Bundle, OperationalData>>> it2 = list3.iterator();
                        int i2 = 0;
                        while (it2.hasNext()) {
                            if (it2.next().getFirst().longValue() == ((Number) pair3.getSecond()).longValue()) {
                                list3.remove(i2);
                                break;
                            }
                            i2++;
                        }
                        if (z) {
                            if (list3.isEmpty()) {
                                timesOfManualPurchases.remove(pair3.getFirst());
                            } else {
                                timesOfManualPurchases.put((InAppPurchase) pair3.getFirst(), list3);
                            }
                        } else if (list3.isEmpty()) {
                            timesOfImplicitPurchases.remove(pair3.getFirst());
                        } else {
                            timesOfImplicitPurchases.put((InAppPurchase) pair3.getFirst(), list3);
                        }
                    }
                }
                return bundle;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
                return null;
            }
        }
    }

    public static /* synthetic */ String getDedupeParameter$default(InAppPurchaseManager inAppPurchaseManager, Bundle bundle, OperationalData operationalData, Bundle bundle2, OperationalData operationalData2, boolean z, boolean z2, int i, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return null;
        }
        try {
            return inAppPurchaseManager.getDedupeParameter(bundle, operationalData, bundle2, operationalData2, z, (i & 32) != 0 ? false : z2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
            return null;
        }
    }

    public final String getDedupeParameter(@Nullable Bundle bundle, @Nullable OperationalData operationalData, @Nullable Bundle bundle2, @Nullable OperationalData operationalData2, boolean z, boolean z2) {
        List<Pair<String, List<String>>> dedupeParameters;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (z2) {
                dedupeParameters = InAppPurchaseDedupeConfig.INSTANCE.getTestDedupeParameters(z);
            } else {
                dedupeParameters = InAppPurchaseDedupeConfig.INSTANCE.getDedupeParameters(z);
            }
            if (dedupeParameters == null) {
                return null;
            }
            for (Pair<String, List<String>> pair : dedupeParameters) {
                Object parameter = OperationalData.Companion.getParameter(OperationalDataEnum.IAPParameters, pair.getFirst(), bundle, operationalData);
                String str = parameter instanceof String ? (String) parameter : null;
                if (str != null && str.length() != 0) {
                    for (String str2 : pair.getSecond()) {
                        Object parameter2 = OperationalData.Companion.getParameter(OperationalDataEnum.IAPParameters, str2, bundle2, operationalData2);
                        String str3 = parameter2 instanceof String ? (String) parameter2 : null;
                        if (str3 != null && str3.length() != 0 && Intrinsics.areEqual(str3, str)) {
                            return z ? pair.getFirst() : str2;
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
