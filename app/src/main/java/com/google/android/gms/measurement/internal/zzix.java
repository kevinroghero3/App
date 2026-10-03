package com.google.android.gms.measurement.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.firebase.messaging.Constants;
import com.salesforce.marketingcloud.notifications.NotificationMessage;

/* JADX INFO: loaded from: classes5.dex */
public final class zzix {
    public static final String[] zza = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "last_advertising_id_reset", "first_open_after_install", "lifetime_user_engagement", "session_user_engagement", "non_personalized_ads", "ga_session_number", "ga_session_id", "last_gclid", "gbraid", "session_number", SDKAnalyticsEvents.PARAMETER_SESSION_ID};
    public static final String[] zzb = {Constants.ScionAnalytics.USER_PROPERTY_FIREBASE_LAST_NOTIFICATION, "_fot", "_fvt", "_ldl", "_id", "_lair", "_fi", "_lte", "_se", "_npa", "_sno", NotificationMessage.NOTIF_KEY_SID, "_lgclid", "_gbraid", "_sno", NotificationMessage.NOTIF_KEY_SID};

    public static String zza(String str) {
        return zzku.zza(str, zza, zzb);
    }
}
