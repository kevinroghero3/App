package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.OperationalData;
import com.facebook.appevents.OperationalDataEnum;
import com.facebook.appevents.iap.InAppPurchase;
import com.facebook.appevents.iap.InAppPurchaseDedupeConfig;
import com.facebook.appevents.iap.InAppPurchaseEventManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import io.sentry.android.core.SentryLogcatAdapter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AutomaticAnalyticsLogger {
    private static final String APP_EVENTS_IF_AUTO_LOG_SUBS = "app_events_if_auto_log_subs";
    public static final AutomaticAnalyticsLogger INSTANCE = new AutomaticAnalyticsLogger();
    private static final String TAG = AutomaticAnalyticsLogger.class.getCanonicalName();
    private static final InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());

    private AutomaticAnalyticsLogger() {
    }

    @JvmStatic
    public static final void logActivateAppEvent() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            if (applicationContext instanceof Application) {
                AppEventsLogger.Companion.activateApp((Application) applicationContext, applicationId);
            } else {
                SentryLogcatAdapter.w(TAG, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
            }
        }
    }

    @JvmStatic
    public static final void logActivityTimeSpentEvent(@Nullable String str, long j) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
        if (fetchedAppSettingsQueryAppSettings == null || !fetchedAppSettingsQueryAppSettings.getAutomaticLoggingEnabled() || j <= 0) {
            return;
        }
        InternalAppEventsLogger internalAppEventsLogger2 = new InternalAppEventsLogger(applicationContext);
        Bundle bundle = new Bundle(1);
        bundle.putCharSequence(Constants.AA_TIME_SPENT_SCREEN_PARAMETER_NAME, str);
        internalAppEventsLogger2.logEvent(Constants.AA_TIME_SPENT_EVENT_NAME, j, bundle);
    }

    public static /* synthetic */ void logPurchase$default(String str, String str2, boolean z, InAppPurchaseUtils.BillingClientVersion billingClientVersion, boolean z2, int i, Object obj) {
        if ((i & 16) != 0) {
            z2 = false;
        }
        logPurchase(str, str2, z, billingClientVersion, z2);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x005c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x005e  */
    /* JADX WARN: Code duplicated, block: B:33:0x006b  */
    /* JADX WARN: Code duplicated, block: B:36:0x008b  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b9  */
    @JvmStatic
    public static final void logPurchase(@NotNull String purchase, @NotNull String skuDetails, boolean z, @Nullable InAppPurchaseUtils.BillingClientVersion billingClientVersion, boolean z2) {
        List<PurchaseLoggingParameters> purchaseLoggingParameters;
        String str;
        String str2;
        Bundle purchaseDedupeParameters;
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(skuDetails, "skuDetails");
        if (!isImplicitPurchaseLoggingEnabled() || (purchaseLoggingParameters = INSTANCE.getPurchaseLoggingParameters(purchase, skuDetails, billingClientVersion)) == null || purchaseLoggingParameters.isEmpty()) {
            return;
        }
        if (!z || !FetchedAppGateKeepersManager.getGateKeeperForKey(APP_EVENTS_IF_AUTO_LOG_SUBS, FacebookSdk.getApplicationId(), false)) {
            if (!z2) {
                str = AppEventsConstants.EVENT_NAME_PURCHASED;
            } else {
                str2 = Constants.EVENT_NAME_PURCHASE_RESTORED;
            }
            if (z && FeatureManager.isEnabled(FeatureManager.Feature.AndroidManualImplicitSubsDedupe)) {
                purchaseDedupeParameters = getSubscriptionDedupeParameters(purchaseLoggingParameters, str);
            } else if (z && FeatureManager.isEnabled(FeatureManager.Feature.AndroidManualImplicitPurchaseDedupe)) {
                purchaseDedupeParameters = getPurchaseDedupeParameters(purchaseLoggingParameters);
            } else {
                purchaseDedupeParameters = null;
            }
            InAppPurchaseDedupeConfig.INSTANCE.addDedupeParameters(purchaseDedupeParameters, purchaseLoggingParameters.get(0).getParam(), purchaseLoggingParameters.get(0).getOperationalData());
            if (!Intrinsics.areEqual(str, AppEventsConstants.EVENT_NAME_PURCHASED)) {
                internalAppEventsLogger.logEventImplicitly(str, purchaseLoggingParameters.get(0).getPurchaseAmount(), purchaseLoggingParameters.get(0).getCurrency(), purchaseLoggingParameters.get(0).getParam(), purchaseLoggingParameters.get(0).getOperationalData());
            } else {
                internalAppEventsLogger.logPurchaseImplicitly(purchaseLoggingParameters.get(0).getPurchaseAmount(), purchaseLoggingParameters.get(0).getCurrency(), purchaseLoggingParameters.get(0).getParam(), purchaseLoggingParameters.get(0).getOperationalData());
            }
        }
        if (z2) {
            str2 = Constants.EVENT_NAME_SUBSCRIPTION_RESTORED;
        } else if (InAppPurchaseEventManager.INSTANCE.hasFreeTrialPeirod(skuDetails)) {
            str2 = AppEventsConstants.EVENT_NAME_START_TRIAL;
        } else {
            str2 = AppEventsConstants.EVENT_NAME_SUBSCRIBE;
        }
        str = str2;
        if (z) {
            if (z) {
                purchaseDedupeParameters = null;
            } else {
                purchaseDedupeParameters = null;
            }
        } else if (z) {
            purchaseDedupeParameters = null;
        } else {
            purchaseDedupeParameters = null;
        }
        InAppPurchaseDedupeConfig.INSTANCE.addDedupeParameters(purchaseDedupeParameters, purchaseLoggingParameters.get(0).getParam(), purchaseLoggingParameters.get(0).getOperationalData());
        if (!Intrinsics.areEqual(str, AppEventsConstants.EVENT_NAME_PURCHASED)) {
            internalAppEventsLogger.logEventImplicitly(str, purchaseLoggingParameters.get(0).getPurchaseAmount(), purchaseLoggingParameters.get(0).getCurrency(), purchaseLoggingParameters.get(0).getParam(), purchaseLoggingParameters.get(0).getOperationalData());
        } else {
            internalAppEventsLogger.logPurchaseImplicitly(purchaseLoggingParameters.get(0).getPurchaseAmount(), purchaseLoggingParameters.get(0).getCurrency(), purchaseLoggingParameters.get(0).getParam(), purchaseLoggingParameters.get(0).getOperationalData());
        }
    }

    @JvmStatic
    public static final Bundle getPurchaseDedupeParameters(@NotNull List<PurchaseLoggingParameters> purchaseLoggingParametersList) {
        Bundle bundlePerformDedupe;
        synchronized (AutomaticAnalyticsLogger.class) {
            Intrinsics.checkNotNullParameter(purchaseLoggingParametersList, "purchaseLoggingParametersList");
            PurchaseLoggingParameters purchaseLoggingParameters = purchaseLoggingParametersList.get(0);
            bundlePerformDedupe = InAppPurchaseManager.performDedupe(CollectionsKt__CollectionsJVMKt.listOf(new InAppPurchase(AppEventsConstants.EVENT_NAME_PURCHASED, purchaseLoggingParameters.getPurchaseAmount().doubleValue(), purchaseLoggingParameters.getCurrency())), System.currentTimeMillis(), true, CollectionsKt__CollectionsJVMKt.listOf(new Pair(purchaseLoggingParameters.getParam(), purchaseLoggingParameters.getOperationalData())));
        }
        return bundlePerformDedupe;
    }

    @JvmStatic
    public static final Bundle getSubscriptionDedupeParameters(@NotNull List<PurchaseLoggingParameters> purchaseLoggingParametersList, @NotNull String eventName) {
        Bundle bundlePerformDedupe;
        synchronized (AutomaticAnalyticsLogger.class) {
            Intrinsics.checkNotNullParameter(purchaseLoggingParametersList, "purchaseLoggingParametersList");
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            ArrayList arrayList = new ArrayList();
            for (PurchaseLoggingParameters purchaseLoggingParameters : purchaseLoggingParametersList) {
                arrayList.add(new InAppPurchase(eventName, purchaseLoggingParameters.getPurchaseAmount().doubleValue(), purchaseLoggingParameters.getCurrency()));
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            List<PurchaseLoggingParameters> list = purchaseLoggingParametersList;
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (PurchaseLoggingParameters purchaseLoggingParameters2 : list) {
                arrayList2.add(new Pair(purchaseLoggingParameters2.getParam(), purchaseLoggingParameters2.getOperationalData()));
            }
            bundlePerformDedupe = InAppPurchaseManager.performDedupe(arrayList, jCurrentTimeMillis, true, arrayList2);
        }
        return bundlePerformDedupe;
    }

    @JvmStatic
    public static final boolean isImplicitPurchaseLoggingEnabled() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return appSettingsWithoutQuery != null && FacebookSdk.getAutoLogAppEventsEnabled() && appSettingsWithoutQuery.getIAPAutomaticLoggingEnabled();
    }

    private final List<PurchaseLoggingParameters> getPurchaseLoggingParameters(String str, String str2, InAppPurchaseUtils.BillingClientVersion billingClientVersion) {
        return getPurchaseLoggingParameters(str, str2, new HashMap(), billingClientVersion);
    }

    private final PurchaseLoggingParameters getPurchaseParametersGPBLV2V4(String str, Bundle bundle, OperationalData operationalData, JSONObject jSONObject, JSONObject jSONObject2) {
        if (Intrinsics.areEqual(str, InAppPurchaseUtils.IAPProductType.SUBS.getType())) {
            OperationalData.Companion companion = OperationalData.Companion;
            OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
            String string = Boolean.toString(jSONObject.optBoolean(Constants.GP_IAP_AUTORENEWING, false));
            Intrinsics.checkNotNullExpressionValue(string, "toString(\n              …      )\n                )");
            companion.addParameter(operationalDataEnum, Constants.IAP_SUBSCRIPTION_AUTORENEWING, string, bundle, operationalData);
            String strOptString = jSONObject2.optString(Constants.GP_IAP_SUBSCRIPTION_PERIOD);
            Intrinsics.checkNotNullExpressionValue(strOptString, "skuDetailsJSON.optString…_IAP_SUBSCRIPTION_PERIOD)");
            companion.addParameter(operationalDataEnum, Constants.IAP_SUBSCRIPTION_PERIOD, strOptString, bundle, operationalData);
            String strOptString2 = jSONObject2.optString(Constants.GP_IAP_FREE_TRIAL_PERIOD);
            Intrinsics.checkNotNullExpressionValue(strOptString2, "skuDetailsJSON.optString…GP_IAP_FREE_TRIAL_PERIOD)");
            companion.addParameter(operationalDataEnum, Constants.IAP_FREE_TRIAL_PERIOD, strOptString2, bundle, operationalData);
            String introductoryPriceCycles = jSONObject2.optString(Constants.GP_IAP_INTRODUCTORY_PRICE_CYCLES);
            Intrinsics.checkNotNullExpressionValue(introductoryPriceCycles, "introductoryPriceCycles");
            if (introductoryPriceCycles.length() > 0) {
                companion.addParameter(operationalDataEnum, Constants.IAP_INTRO_PRICE_CYCLES, introductoryPriceCycles, bundle, operationalData);
            }
            String introductoryPricePeriod = jSONObject2.optString(Constants.GP_IAP_INTRODUCTORY_PRICE_PERIOD);
            Intrinsics.checkNotNullExpressionValue(introductoryPricePeriod, "introductoryPricePeriod");
            if (introductoryPricePeriod.length() > 0) {
                companion.addParameter(operationalDataEnum, Constants.IAP_INTRO_PERIOD, introductoryPricePeriod, bundle, operationalData);
            }
            String introductoryPriceAmountMicros = jSONObject2.optString(Constants.GP_IAP_INTRODUCTORY_PRICE_AMOUNT_MICROS);
            Intrinsics.checkNotNullExpressionValue(introductoryPriceAmountMicros, "introductoryPriceAmountMicros");
            if (introductoryPriceAmountMicros.length() > 0) {
                companion.addParameter(operationalDataEnum, Constants.IAP_INTRO_PRICE_AMOUNT_MICROS, introductoryPriceAmountMicros, bundle, operationalData);
            }
        }
        BigDecimal bigDecimal = new BigDecimal(jSONObject2.getLong(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V2V4) / 1000000.0d);
        Currency currency = Currency.getInstance(jSONObject2.getString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V2V4));
        Intrinsics.checkNotNullExpressionValue(currency, "getInstance(skuDetailsJS…RICE_CURRENCY_CODE_V2V4))");
        return new PurchaseLoggingParameters(bigDecimal, currency, bundle, operationalData);
    }

    private final List<PurchaseLoggingParameters> getPurchaseParametersGPBLV5V7(String str, Bundle bundle, OperationalData operationalData, JSONObject jSONObject) throws JSONException {
        if (Intrinsics.areEqual(str, InAppPurchaseUtils.IAPProductType.SUBS.getType())) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(Constants.GP_IAP_SUBSCRIPTION_OFFER_DETAILS);
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONObject.getJSONArray(Constants.GP_IAP_SUBSCRIPTION_OFFER_DETAILS).getJSONObject(i);
                if (jSONObject2 == null) {
                    return null;
                }
                Bundle bundle2 = new Bundle(bundle);
                OperationalData operationalDataCopy = operationalData.copy();
                String basePlanId = jSONObject2.getString(Constants.GP_IAP_BASE_PLAN_ID);
                OperationalData.Companion companion = OperationalData.Companion;
                OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
                Intrinsics.checkNotNullExpressionValue(basePlanId, "basePlanId");
                companion.addParameter(operationalDataEnum, Constants.IAP_BASE_PLAN, basePlanId, bundle2, operationalDataCopy);
                JSONArray jSONArray2 = jSONObject2.getJSONArray(Constants.GP_IAP_SUBSCRIPTION_PRICING_PHASES);
                JSONObject jSONObject3 = jSONArray2.getJSONObject(jSONArray2.length() - 1);
                if (jSONObject3 == null) {
                    return null;
                }
                String strOptString = jSONObject3.optString(Constants.GP_IAP_BILLING_PERIOD);
                Intrinsics.checkNotNullExpressionValue(strOptString, "subscriptionJSON.optStri…IOD\n                    )");
                companion.addParameter(operationalDataEnum, Constants.IAP_SUBSCRIPTION_PERIOD, strOptString, bundle2, operationalDataCopy);
                if (jSONObject3.has(Constants.GP_IAP_RECURRENCE_MODE) && jSONObject3.getInt(Constants.GP_IAP_RECURRENCE_MODE) != 3) {
                    companion.addParameter(operationalDataEnum, Constants.IAP_SUBSCRIPTION_AUTORENEWING, "true", bundle2, operationalDataCopy);
                } else {
                    companion.addParameter(operationalDataEnum, Constants.IAP_SUBSCRIPTION_AUTORENEWING, com.facebook.hermes.intl.Constants.CASEFIRST_FALSE, bundle2, operationalDataCopy);
                }
                BigDecimal bigDecimal = new BigDecimal(jSONObject3.getLong(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V5V7) / 1000000.0d);
                Currency currency = Currency.getInstance(jSONObject3.getString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7));
                Intrinsics.checkNotNullExpressionValue(currency, "getInstance(subscription…RICE_CURRENCY_CODE_V5V7))");
                arrayList.add(new PurchaseLoggingParameters(bigDecimal, currency, bundle2, operationalDataCopy));
            }
            return arrayList;
        }
        JSONObject jSONObject4 = jSONObject.getJSONObject(Constants.GP_IAP_ONE_TIME_PURCHASE_OFFER_DETAILS);
        if (jSONObject4 == null) {
            return null;
        }
        BigDecimal bigDecimal2 = new BigDecimal(jSONObject4.getLong(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V5V7) / 1000000.0d);
        Currency currency2 = Currency.getInstance(jSONObject4.getString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7));
        Intrinsics.checkNotNullExpressionValue(currency2, "getInstance(oneTimePurch…RICE_CURRENCY_CODE_V5V7))");
        return CollectionsKt__CollectionsKt.mutableListOf(new PurchaseLoggingParameters(bigDecimal2, currency2, bundle, operationalData));
    }

    private final List<PurchaseLoggingParameters> getPurchaseLoggingParameters(String str, String str2, Map<String, String> map, InAppPurchaseUtils.BillingClientVersion billingClientVersion) {
        List<PurchaseLoggingParameters> listMutableListOf = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            Bundle bundle = new Bundle(1);
            OperationalData operationalData = new OperationalData();
            if (billingClientVersion != null) {
                OperationalData.Companion.addParameter(OperationalDataEnum.IAPParameters, Constants.IAP_AUTOLOG_IMPLEMENTATION, billingClientVersion.getType(), bundle, operationalData);
            }
            OperationalData.Companion companion = OperationalData.Companion;
            OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
            String string = jSONObject.getString("productId");
            Intrinsics.checkNotNullExpressionValue(string, "purchaseJSON.getString(C…stants.GP_IAP_PRODUCT_ID)");
            companion.addParameter(operationalDataEnum, Constants.IAP_PRODUCT_ID, string, bundle, operationalData);
            String string2 = jSONObject.getString("productId");
            Intrinsics.checkNotNullExpressionValue(string2, "purchaseJSON.getString(C…stants.GP_IAP_PRODUCT_ID)");
            companion.addParameter(operationalDataEnum, AppEventsConstants.EVENT_PARAM_CONTENT_ID, string2, bundle, operationalData);
            companion.addParameter(operationalDataEnum, Constants.ANDROID_DYNAMIC_ADS_CONTENT_ID, "client_implicit", bundle, operationalData);
            String string3 = jSONObject.getString(Constants.GP_IAP_PURCHASE_TIME);
            Intrinsics.checkNotNullExpressionValue(string3, "purchaseJSON.getString(C…nts.GP_IAP_PURCHASE_TIME)");
            companion.addParameter(operationalDataEnum, Constants.IAP_PURCHASE_TIME, string3, bundle, operationalData);
            String string4 = jSONObject.getString("purchaseToken");
            Intrinsics.checkNotNullExpressionValue(string4, "purchaseJSON.getString(C…ts.GP_IAP_PURCHASE_TOKEN)");
            companion.addParameter(operationalDataEnum, Constants.IAP_PURCHASE_TOKEN, string4, bundle, operationalData);
            String strOptString = jSONObject.optString("packageName");
            Intrinsics.checkNotNullExpressionValue(strOptString, "purchaseJSON.optString(C…ants.GP_IAP_PACKAGE_NAME)");
            companion.addParameter(operationalDataEnum, Constants.IAP_PACKAGE_NAME, strOptString, bundle, operationalData);
            String strOptString2 = jSONObject2.optString("title");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "skuDetailsJSON.optString(Constants.GP_IAP_TITLE)");
            companion.addParameter(operationalDataEnum, Constants.IAP_PRODUCT_TITLE, strOptString2, bundle, operationalData);
            String strOptString3 = jSONObject2.optString("description");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "skuDetailsJSON.optString…tants.GP_IAP_DESCRIPTION)");
            companion.addParameter(operationalDataEnum, Constants.IAP_PRODUCT_DESCRIPTION, strOptString3, bundle, operationalData);
            String type = jSONObject2.optString("type");
            Intrinsics.checkNotNullExpressionValue(type, "type");
            companion.addParameter(operationalDataEnum, Constants.IAP_PRODUCT_TYPE, type, bundle, operationalData);
            String specificBillingLibraryVersion = InAppPurchaseManager.getSpecificBillingLibraryVersion();
            if (specificBillingLibraryVersion != null) {
                companion.addParameter(operationalDataEnum, Constants.IAP_BILLING_LIBRARY_VERSION, specificBillingLibraryVersion, bundle, operationalData);
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                OperationalData.Companion.addParameter(OperationalDataEnum.IAPParameters, entry.getKey(), entry.getValue(), bundle, operationalData);
            }
            if (jSONObject2.has(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V2V4)) {
                listMutableListOf = CollectionsKt__CollectionsKt.mutableListOf(getPurchaseParametersGPBLV2V4(type, bundle, operationalData, jSONObject, jSONObject2));
            } else if (jSONObject2.has(Constants.GP_IAP_SUBSCRIPTION_OFFER_DETAILS) || jSONObject2.has(Constants.GP_IAP_ONE_TIME_PURCHASE_OFFER_DETAILS)) {
                try {
                    return getPurchaseParametersGPBLV5V7(type, bundle, operationalData, jSONObject2);
                } catch (JSONException e) {
                    e = e;
                    SentryLogcatAdapter.e(TAG, "Error parsing in-app purchase/subscription data.", e);
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    SentryLogcatAdapter.e(TAG, "Failed to get purchase logging parameters,", e);
                    return null;
                }
            }
            return listMutableListOf;
        } catch (JSONException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static final class PurchaseLoggingParameters {
        private Currency currency;
        private OperationalData operationalData;
        private Bundle param;
        private BigDecimal purchaseAmount;

        public PurchaseLoggingParameters(@NotNull BigDecimal purchaseAmount, @NotNull Currency currency, @NotNull Bundle param, @NotNull OperationalData operationalData) {
            Intrinsics.checkNotNullParameter(purchaseAmount, "purchaseAmount");
            Intrinsics.checkNotNullParameter(currency, "currency");
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(operationalData, "operationalData");
            this.purchaseAmount = purchaseAmount;
            this.currency = currency;
            this.param = param;
            this.operationalData = operationalData;
        }

        public final BigDecimal getPurchaseAmount() {
            return this.purchaseAmount;
        }

        public final void setPurchaseAmount(@NotNull BigDecimal bigDecimal) {
            Intrinsics.checkNotNullParameter(bigDecimal, "<set-?>");
            this.purchaseAmount = bigDecimal;
        }

        public final Currency getCurrency() {
            return this.currency;
        }

        public final void setCurrency(@NotNull Currency currency) {
            Intrinsics.checkNotNullParameter(currency, "<set-?>");
            this.currency = currency;
        }

        public final Bundle getParam() {
            return this.param;
        }

        public final void setParam(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "<set-?>");
            this.param = bundle;
        }

        public final OperationalData getOperationalData() {
            return this.operationalData;
        }

        public final void setOperationalData(@NotNull OperationalData operationalData) {
            Intrinsics.checkNotNullParameter(operationalData, "<set-?>");
            this.operationalData = operationalData;
        }
    }
}
