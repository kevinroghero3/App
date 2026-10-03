package com.salesforce.marketingcloud.messages.push;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.messaging.RemoteMessage;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class PushMessageManager {
    public static final String d = "com.salesforce.marketingcloud.messages.push.TOKEN_REFRESHED";
    public static final String e = "com.salesforce.marketingcloud.push.TOKEN_REFRESH_SUCCESSFUL";
    public static final String f = "com.salesforce.marketingcloud.push.TOKEN_SENDER_ID";
    public static final String g = "com.salesforce.marketingcloud.notifications.PUSH_ENABLED";
    public static final String h = "com.salesforce.marketingcloud.push.TOKEN";
    static final String i = g.a("PushMessageManager");

    /* JADX INFO: loaded from: classes3.dex */
    public interface PushTokenRefreshListener {
        void onTokenRefreshed(@Nullable String str);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface SilentPushListener {
        void silentPushReceived(@NonNull Map<String, String> map);
    }

    public static boolean isMarketingCloudPush(@NonNull Map<String, String> map) {
        return map != null && "SFMC".equalsIgnoreCase(map.get(NotificationMessage.NOTIF_KEY_SID));
    }

    public abstract void disablePush();

    public abstract void enablePush();

    public abstract JSONObject getPushDebugInfo();

    public abstract String getPushToken();

    public abstract boolean handleMessage(@NonNull RemoteMessage remoteMessage);

    public abstract boolean handleMessage(@NonNull Map<String, String> map);

    public abstract boolean isPushEnabled();

    public abstract void registerSilentPushListener(@NonNull SilentPushListener silentPushListener);

    public abstract void registerTokenRefreshListener(@NonNull PushTokenRefreshListener pushTokenRefreshListener);

    public abstract void setPushToken(@NonNull String str);

    public abstract void unregisterSilentPushListener(@NonNull SilentPushListener silentPushListener);

    public abstract void unregisterTokenRefreshListener(@NonNull PushTokenRefreshListener pushTokenRefreshListener);

    public static boolean isMarketingCloudPush(@NonNull RemoteMessage remoteMessage) {
        return remoteMessage != null && isMarketingCloudPush(remoteMessage.getData());
    }
}
