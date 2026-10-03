package com.facebook.appevents.gps.pa;

import android.adservices.common.AdData;
import android.adservices.common.AdSelectionSignals;
import android.adservices.common.AdTechIdentifier;
import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.CustomAudienceManager;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.OutcomeReceiver;
import android.util.Log;
import androidx.core.os.OutcomeReceiverKt$$ExternalSyntheticApiModelOutline0;
import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager$Api33Ext4Impl$$ExternalSyntheticApiModelOutline25;
import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager$Api33Ext4Impl$$ExternalSyntheticApiModelOutline27;
import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager$Api33Ext4Impl$$ExternalSyntheticApiModelOutline28;
import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager$Api33Ext4Impl$$ExternalSyntheticApiModelOutline29;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.gps.GpsDebugLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class PACustomAudienceClient {
    private static final String BUYER = "facebook.com";
    private static final String DELIMITER = "@";
    private static final String EVENT_NAME_CONFIG_VERSION = "1";
    private static final String GPS_PREFIX = "gps";
    private static final String REPLACEMENT_STRING = "_removed_";
    private static String baseUri;
    private static CustomAudienceManager customAudienceManager;
    private static boolean enabled;
    private static GpsDebugLogger gpsDebugLogger;
    private static boolean isInitialized;
    public static final PACustomAudienceClient INSTANCE = new PACustomAudienceClient();
    private static final String TAG = "Fledge: " + PACustomAudienceClient.class.getSimpleName();

    private PACustomAudienceClient() {
    }

    public static final /* synthetic */ GpsDebugLogger access$getGpsDebugLogger$p() {
        if (CrashShieldHandler.isObjectCrashing(PACustomAudienceClient.class)) {
            return null;
        }
        try {
            return gpsDebugLogger;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PACustomAudienceClient.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$p() {
        if (CrashShieldHandler.isObjectCrashing(PACustomAudienceClient.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PACustomAudienceClient.class);
            return null;
        }
    }

    @JvmStatic
    public static final void enable() {
        String string;
        if (CrashShieldHandler.isObjectCrashing(PACustomAudienceClient.class)) {
            return;
        }
        try {
            isInitialized = true;
            Context applicationContext = FacebookSdk.getApplicationContext();
            gpsDebugLogger = new GpsDebugLogger(applicationContext);
            baseUri = "https://www." + FacebookSdk.getFacebookDomain() + "/privacy_sandbox/pa/logic";
            GpsDebugLogger gpsDebugLogger2 = null;
            try {
                CustomAudienceManager customAudienceManager2 = CustomAudienceManager.get(applicationContext);
                customAudienceManager = customAudienceManager2;
                if (customAudienceManager2 != null) {
                    enabled = true;
                }
                string = null;
            } catch (Error e) {
                string = e.toString();
                SentryLogcatAdapter.w(TAG, "Failed to get CustomAudienceManager: " + e);
            } catch (Exception e2) {
                string = e2.toString();
                SentryLogcatAdapter.w(TAG, "Failed to get CustomAudienceManager: " + e2);
            }
            if (enabled) {
                return;
            }
            GpsDebugLogger gpsDebugLogger3 = gpsDebugLogger;
            if (gpsDebugLogger3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
            } else {
                gpsDebugLogger2 = gpsDebugLogger3;
            }
            Bundle bundle = new Bundle();
            bundle.putString(Constants.GPS_PA_FAILED_REASON, string);
            Unit unit = Unit.INSTANCE;
            gpsDebugLogger2.log(Constants.GPS_PA_FAILED, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PACustomAudienceClient.class);
        }
    }

    public final void joinCustomAudience(@Nullable String str, @Nullable String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (!isInitialized) {
                enable();
            }
            if (enabled) {
                joinCustomAudienceImpl(str, str2);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0029  */
    public final void joinCustomAudience(@Nullable String str, @Nullable AppEvent appEvent) {
        String string;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (!isInitialized) {
                enable();
            }
            if (enabled) {
                if (appEvent != null) {
                    try {
                        JSONObject jSONObject = appEvent.getJSONObject();
                        if (jSONObject != null) {
                            string = jSONObject.getString(Constants.EVENT_NAME_EVENT_KEY);
                        } else {
                            string = null;
                        }
                    } catch (JSONException unused) {
                        SentryLogcatAdapter.w(TAG, "Failed to get event name from event.");
                    }
                } else {
                    string = null;
                }
                joinCustomAudienceImpl(str, string);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void joinCustomAudienceImpl(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            String strValidateAndCreateCAName = validateAndCreateCAName(str, str2);
            if (strValidateAndCreateCAName == null) {
                return;
            }
            GpsDebugLogger gpsDebugLogger2 = null;
            try {
                OutcomeReceiver outcomeReceiverM = OutcomeReceiverKt$$ExternalSyntheticApiModelOutline0.m(new OutcomeReceiver() { // from class: com.facebook.appevents.gps.pa.PACustomAudienceClient$joinCustomAudienceImpl$callback$1
                    public void onResult(@NotNull Object result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        Log.i(PACustomAudienceClient.access$getTAG$p(), "Successfully joined custom audience");
                        GpsDebugLogger gpsDebugLoggerAccess$getGpsDebugLogger$p = PACustomAudienceClient.access$getGpsDebugLogger$p();
                        if (gpsDebugLoggerAccess$getGpsDebugLogger$p == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                            gpsDebugLoggerAccess$getGpsDebugLogger$p = null;
                        }
                        gpsDebugLoggerAccess$getGpsDebugLogger$p.log(Constants.GPS_PA_SUCCEED, null);
                    }

                    public void onError(@NotNull Exception error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        SentryLogcatAdapter.e(PACustomAudienceClient.access$getTAG$p(), error.toString());
                        GpsDebugLogger gpsDebugLoggerAccess$getGpsDebugLogger$p = PACustomAudienceClient.access$getGpsDebugLogger$p();
                        if (gpsDebugLoggerAccess$getGpsDebugLogger$p == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                            gpsDebugLoggerAccess$getGpsDebugLogger$p = null;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString(Constants.GPS_PA_FAILED_REASON, error.toString());
                        Unit unit = Unit.INSTANCE;
                        gpsDebugLoggerAccess$getGpsDebugLogger$p.log(Constants.GPS_PA_FAILED, bundle);
                    }
                });
                PACustomAudienceClient$$ExternalSyntheticApiModelOutline1.m();
                AdData.Builder builderM = CustomAudienceManager$Api33Ext4Impl$$ExternalSyntheticApiModelOutline29.m();
                StringBuilder sb = new StringBuilder();
                String str3 = baseUri;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseUri");
                    str3 = null;
                }
                sb.append(str3);
                sb.append("/ad");
                Uri uri = Uri.parse(sb.toString());
                Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.parse(this)");
                AdData adDataBuild = builderM.setRenderUri(uri).setMetadata("{'isRealAd': false}").build();
                Intrinsics.checkNotNullExpressionValue(adDataBuild, "Builder()\n              …\n                .build()");
                PACustomAudienceClient$$ExternalSyntheticApiModelOutline2.m();
                TrustedBiddingData.Builder builderM2 = CustomAudienceManager$Api33Ext4Impl$$ExternalSyntheticApiModelOutline28.m();
                StringBuilder sb2 = new StringBuilder();
                String str4 = baseUri;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseUri");
                    str4 = null;
                }
                sb2.append(str4);
                sb2.append("?trusted_bidding");
                Uri uri2 = Uri.parse(sb2.toString());
                Intrinsics.checkExpressionValueIsNotNull(uri2, "Uri.parse(this)");
                TrustedBiddingData trustedBiddingDataBuild = builderM2.setTrustedBiddingUri(uri2).setTrustedBiddingKeys(CollectionsKt__CollectionsJVMKt.listOf("")).build();
                Intrinsics.checkNotNullExpressionValue(trustedBiddingDataBuild, "Builder()\n              …\n                .build()");
                PACustomAudienceClient$$ExternalSyntheticApiModelOutline3.m();
                CustomAudience.Builder buyer = CustomAudienceManager$Api33Ext4Impl$$ExternalSyntheticApiModelOutline25.m().setName(strValidateAndCreateCAName).setBuyer(AdTechIdentifier.fromString("facebook.com"));
                StringBuilder sb3 = new StringBuilder();
                String str5 = baseUri;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseUri");
                    str5 = null;
                }
                sb3.append(str5);
                sb3.append("?daily&app_id=");
                sb3.append(str);
                Uri uri3 = Uri.parse(sb3.toString());
                Intrinsics.checkExpressionValueIsNotNull(uri3, "Uri.parse(this)");
                CustomAudience.Builder dailyUpdateUri = buyer.setDailyUpdateUri(uri3);
                StringBuilder sb4 = new StringBuilder();
                String str6 = baseUri;
                if (str6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseUri");
                    str6 = null;
                }
                sb4.append(str6);
                sb4.append("?bidding");
                Uri uri4 = Uri.parse(sb4.toString());
                Intrinsics.checkExpressionValueIsNotNull(uri4, "Uri.parse(this)");
                CustomAudience customAudienceBuild = dailyUpdateUri.setBiddingLogicUri(uri4).setTrustedBiddingData(trustedBiddingDataBuild).setUserBiddingSignals(AdSelectionSignals.fromString("{}")).setAds(CollectionsKt__CollectionsJVMKt.listOf(adDataBuild)).build();
                Intrinsics.checkNotNullExpressionValue(customAudienceBuild, "Builder()\n              …(listOf(dummyAd)).build()");
                PACustomAudienceClient$$ExternalSyntheticApiModelOutline4.m();
                JoinCustomAudienceRequest joinCustomAudienceRequestBuild = CustomAudienceManager$Api33Ext4Impl$$ExternalSyntheticApiModelOutline27.m().setCustomAudience(customAudienceBuild).build();
                Intrinsics.checkNotNullExpressionValue(joinCustomAudienceRequestBuild, "Builder().setCustomAudience(ca).build()");
                CustomAudienceManager customAudienceManager2 = customAudienceManager;
                if (customAudienceManager2 != null) {
                    customAudienceManager2.joinCustomAudience(joinCustomAudienceRequestBuild, Executors.newSingleThreadExecutor(), outcomeReceiverM);
                }
            } catch (Error e) {
                SentryLogcatAdapter.w(TAG, "Failed to join Custom Audience: " + e);
                GpsDebugLogger gpsDebugLogger3 = gpsDebugLogger;
                if (gpsDebugLogger3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                } else {
                    gpsDebugLogger2 = gpsDebugLogger3;
                }
                Bundle bundle = new Bundle();
                bundle.putString(Constants.GPS_PA_FAILED_REASON, e.toString());
                Unit unit = Unit.INSTANCE;
                gpsDebugLogger2.log(Constants.GPS_PA_FAILED, bundle);
            } catch (Exception e2) {
                SentryLogcatAdapter.w(TAG, "Failed to join Custom Audience: " + e2);
                GpsDebugLogger gpsDebugLogger4 = gpsDebugLogger;
                if (gpsDebugLogger4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                } else {
                    gpsDebugLogger2 = gpsDebugLogger4;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString(Constants.GPS_PA_FAILED_REASON, e2.toString());
                Unit unit2 = Unit.INSTANCE;
                gpsDebugLogger2.log(Constants.GPS_PA_FAILED, bundle2);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final String validateAndCreateCAName(String str, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(this) && str != null && str2 != null) {
            try {
                if (!Intrinsics.areEqual(str2, REPLACEMENT_STRING) && !StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) GPS_PREFIX, false, 2, (Object) null)) {
                    return str + '@' + str2 + '@' + (System.currentTimeMillis() / ((long) 1000)) + "@1";
                }
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
        return null;
    }
}
