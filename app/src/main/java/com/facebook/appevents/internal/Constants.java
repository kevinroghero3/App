package com.facebook.appevents.internal;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
public final class Constants {
    public static final String AA_TIME_SPENT_EVENT_NAME = "fb_aa_time_spent_on_view";
    public static final String AA_TIME_SPENT_SCREEN_PARAMETER_NAME = "fb_aa_time_spent_view_name";
    public static final String ANDROID_DYNAMIC_ADS_CONTENT_ID = "android_dynamic_ads_content_id";
    public static final String EVENT_NAME_EVENT_KEY = "_eventName";
    public static final String EVENT_NAME_PURCHASE_RESTORED = "fb_mobile_purchase_restored";
    public static final String EVENT_NAME_SUBSCRIPTION_RESTORED = "SubscriptionRestore";
    public static final String EVENT_PARAM_IS_AUTOLOG_APP_EVENTS_ENABLED = "is_autolog_app_events_enabled";
    public static final String EVENT_PARAM_IS_IMPLICIT_PURCHASE_LOGGING_ENABLED = "is_implicit_purchase_logging_enabled";
    public static final String EVENT_PARAM_PRODUCT_AVAILABILITY = "fb_product_availability";
    public static final String EVENT_PARAM_PRODUCT_BRAND = "fb_product_brand";
    public static final String EVENT_PARAM_PRODUCT_CONDITION = "fb_product_condition";
    public static final String EVENT_PARAM_PRODUCT_DESCRIPTION = "fb_product_description";
    public static final String EVENT_PARAM_PRODUCT_GTIN = "fb_product_gtin";
    public static final String EVENT_PARAM_PRODUCT_IMAGE_LINK = "fb_product_image_link";
    public static final String EVENT_PARAM_PRODUCT_ITEM_ID = "fb_product_item_id";
    public static final String EVENT_PARAM_PRODUCT_LINK = "fb_product_link";
    public static final String EVENT_PARAM_PRODUCT_MPN = "fb_product_mpn";
    public static final String EVENT_PARAM_PRODUCT_PRICE_AMOUNT = "fb_product_price_amount";
    public static final String EVENT_PARAM_PRODUCT_PRICE_CURRENCY = "fb_product_price_currency";
    public static final String EVENT_PARAM_PRODUCT_TITLE = "fb_product_title";
    public static final String GPS_ARA_FAILED = "gps_ara_failed";
    public static final String GPS_ARA_FAILED_REASON = "gps_ara_failed_reason";
    public static final String GPS_ARA_SUCCEED = "gps_ara_succeed";
    public static final String GPS_PA_FAILED = "gps_pa_failed";
    public static final String GPS_PA_FAILED_REASON = "gps_pa_failed_reason";
    public static final String GPS_PA_SUCCEED = "gps_pa_succeed";
    public static final String GP_IAP_AUTORENEWING = "autoRenewing";
    public static final String GP_IAP_BASE_PLAN_ID = "basePlanId";
    public static final String GP_IAP_BILLING_PERIOD = "billingPeriod";
    public static final String GP_IAP_DESCRIPTION = "description";
    public static final String GP_IAP_FREE_TRIAL_PERIOD = "freeTrialPeriod";
    public static final String GP_IAP_INTRODUCTORY_PRICE_AMOUNT_MICROS = "introductoryPriceAmountMicros";
    public static final String GP_IAP_INTRODUCTORY_PRICE_CYCLES = "introductoryPriceCycles";
    public static final String GP_IAP_INTRODUCTORY_PRICE_PERIOD = "introductoryPricePeriod";
    public static final String GP_IAP_OFFER_ID = "offerId";
    public static final String GP_IAP_ONE_TIME_PURCHASE_OFFER_DETAILS = "oneTimePurchaseOfferDetails";
    public static final String GP_IAP_PACKAGE_NAME = "packageName";
    public static final String GP_IAP_PRICE_AMOUNT_MICROS_V2V4 = "price_amount_micros";
    public static final String GP_IAP_PRICE_AMOUNT_MICROS_V5V7 = "priceAmountMicros";
    public static final String GP_IAP_PRICE_CURRENCY_CODE_V2V4 = "price_currency_code";
    public static final String GP_IAP_PRICE_CURRENCY_CODE_V5V7 = "priceCurrencyCode";
    public static final String GP_IAP_PRODUCT_ID = "productId";
    public static final String GP_IAP_PURCHASE_TIME = "purchaseTime";
    public static final String GP_IAP_PURCHASE_TOKEN = "purchaseToken";
    public static final String GP_IAP_RECURRENCE_MODE = "recurrenceMode";
    public static final String GP_IAP_SUBSCRIPTION_OFFER_DETAILS = "subscriptionOfferDetails";
    public static final String GP_IAP_SUBSCRIPTION_PERIOD = "subscriptionPeriod";
    public static final String GP_IAP_SUBSCRIPTION_PRICING_PHASES = "pricingPhases";
    public static final String GP_IAP_TITLE = "title";
    public static final String GP_IAP_TYPE = "type";
    public static final String IAP_ACTUAL_DEDUP_KEY_USED = "fb_iap_actual_dedup_key_used";
    public static final String IAP_ACTUAL_DEDUP_RESULT = "fb_iap_actual_dedup_result";
    public static final String IAP_AUTOLOG_IMPLEMENTATION = "fb_iap_sdk_supported_library_versions";
    public static final String IAP_BASE_PLAN = "fb_iap_base_plan";
    public static final String IAP_BILLING_LIBRARY_VERSION = "fb_iap_client_library_version";
    public static final String IAP_FREE_TRIAL_PERIOD = "fb_free_trial_period";
    public static final String IAP_INTRO_PERIOD = "fb_intro_period";
    public static final String IAP_INTRO_PRICE_AMOUNT_MICROS = "fb_intro_price_amount_micros";
    public static final String IAP_INTRO_PRICE_CYCLES = "fb_intro_price_cycles";
    public static final String IAP_NON_DEDUPED_EVENT_TIME = "fb_iap_non_deduped_event_time";
    public static final String IAP_PACKAGE_NAME = "fb_iap_package_name";
    public static final String IAP_PRODUCT_DESCRIPTION = "fb_iap_product_description";
    public static final String IAP_PRODUCT_ID = "fb_iap_product_id";
    public static final String IAP_PRODUCT_TITLE = "fb_iap_product_title";
    public static final String IAP_PRODUCT_TYPE = "fb_iap_product_type";
    public static final String IAP_PURCHASE_TIME = "fb_iap_purchase_time";
    public static final String IAP_PURCHASE_TOKEN = "fb_iap_purchase_token";
    public static final String IAP_SUBSCRIPTION_AUTORENEWING = "fb_iap_subs_auto_renewing";
    public static final String IAP_SUBSCRIPTION_PERIOD = "fb_iap_subs_period";
    public static final String IAP_TEST_DEDUP_KEY_USED = "fb_iap_test_dedup_key_used";
    public static final String IAP_TEST_DEDUP_RESULT = "fb_iap_test_dedup_result";
    public static final Constants INSTANCE = new Constants();
    public static final String LOG_TIME_APP_EVENT_KEY = "_logTime";

    @JvmStatic
    public static final int getDefaultAppEventsSessionTimeoutInSeconds() {
        return 60;
    }

    private Constants() {
    }
}
