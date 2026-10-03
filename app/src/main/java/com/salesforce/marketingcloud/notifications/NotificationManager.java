package com.salesforce.marketingcloud.notifications;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.RemoteMessage;
import com.salesforce.marketingcloud.NotificationOpenedService;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.internal.j;
import com.salesforce.marketingcloud.internal.k;
import com.salesforce.marketingcloud.push.f;
import com.transistorsoft.locationmanager.config.TSNotification;

/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationManager {
    public static final String ACTION_NOTIFICATION_CLICKED = "com.salesforce.marketingcloud.NOTIFICATION_CLICKED";
    public static final String DEFAULT_CHANNEL_ID = "com.salesforce.marketingcloud.DEFAULT_CHANNEL";
    public static final String DEFAULT_FOREGROUND_CHANNEL_ID = "com.salesforce.marketingcloud.DEFAULT_FOREGROUND_CHANNEL";
    static final String d = g.a("NotificationManager");
    private static final String e = "com.salesforce.marketingcloud.notifications.EXTRA_MESSAGE";

    /* JADX INFO: loaded from: classes3.dex */
    public interface NotificationBuilder {
        NotificationCompat.Builder setupNotificationBuilder(@NonNull Context context, @NonNull NotificationMessage notificationMessage) throws f;
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface NotificationChannelIdProvider {
        String getNotificationChannelId(@NonNull Context context, @NonNull NotificationMessage notificationMessage);
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface NotificationLaunchIntentProvider {
        PendingIntent getNotificationPendingIntent(@NonNull Context context, @NonNull NotificationMessage notificationMessage);
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface NotificationMessageDisplayedListener {
        void onNotificationMessageDisplayed(@NonNull NotificationMessage notificationMessage);
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface ShouldShowNotificationListener {
        boolean shouldShowNotification(@NonNull NotificationMessage notificationMessage);
    }

    static Intent a(@NonNull Intent intent, @NonNull NotificationMessage notificationMessage) {
        return intent.putExtra(e, k.a(notificationMessage));
    }

    public static void cancelNotificationMessage(@NonNull Context context, @NonNull NotificationMessage notificationMessage) {
        if (notificationMessage.notificationId() >= 0) {
            ((android.app.NotificationManager) context.getSystemService(TSNotification.NAME)).cancel("com.marketingcloud.salesforce.notifications.TAG", notificationMessage.notificationId());
        }
    }

    public static String createDefaultNotificationChannel(@NonNull Context context, boolean z) {
        return b.b(context, z);
    }

    public static String createForegroundNotificationChannel(@NonNull Context context) {
        return b.a(context, false);
    }

    public static NotificationMessage extractMessage(@NonNull Intent intent) {
        try {
            return (NotificationMessage) k.a(intent.getByteArrayExtra(e), NotificationMessage.CREATOR);
        } catch (Exception e2) {
            g.b(d, e2, "Unable to retrieve NotificationMessage from Intent (%s).", intent);
            return null;
        }
    }

    public static NotificationCompat.Builder getDefaultNotificationBuilder(@NonNull Context context, @NonNull NotificationMessage notificationMessage, @NonNull String str, @DrawableRes int i) {
        return b.a(context, notificationMessage, str, i);
    }

    public static PendingIntent redirectIntentForAnalytics(@NonNull Context context, @NonNull PendingIntent pendingIntent, @NonNull RemoteMessage remoteMessage, boolean z) {
        try {
            return redirectIntentForAnalytics(context, pendingIntent, j.a(remoteMessage.getData()), z, null);
        } catch (Exception e2) {
            g.b(d, e2, "Failed to create {NotificationMessage} from {RemoteMessage}, not processing {PendingIntent} for analytics.", new Object[0]);
            return null;
        }
    }

    public abstract boolean areNotificationsEnabled();

    public abstract void disableNotifications();

    public abstract void enableNotifications();

    public abstract void registerNotificationMessageDisplayedListener(@NonNull NotificationMessageDisplayedListener notificationMessageDisplayedListener);

    public abstract void setShouldShowNotificationListener(@Nullable ShouldShowNotificationListener shouldShowNotificationListener);

    public abstract void unregisterNotificationMessageDisplayedListener(@NonNull NotificationMessageDisplayedListener notificationMessageDisplayedListener);

    public static String createDefaultNotificationChannel(@NonNull Context context) {
        return b.b(context, false);
    }

    public static PendingIntent redirectIntentForAnalytics(@NonNull Context context, @NonNull PendingIntent pendingIntent, @NonNull NotificationMessage notificationMessage, boolean z) {
        return redirectIntentForAnalytics(context, pendingIntent, notificationMessage, z, null);
    }

    public static PendingIntent redirectIntentForAnalytics(@NonNull Context context, @NonNull PendingIntent pendingIntent, @NonNull NotificationMessage notificationMessage, boolean z, @Nullable Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putByteArray(e, k.a(notificationMessage));
        bundle.putParcelable("com.salesforce.marketingcloud.notifications.EXTRA_OPEN_INTENT", pendingIntent);
        bundle.putBoolean("com.salesforce.marketingcloud.notifications.EXTRA_AUTO_CANCEL", z);
        Uri uriFromParts = Uri.fromParts("mcsdk", "pushOpen", String.valueOf(System.currentTimeMillis()));
        int iA = com.salesforce.marketingcloud.util.j.a(1073741824);
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getActivity(context, 0, NotificationOpenActivity.a(context, bundle).setData(uriFromParts), iA);
        }
        return PendingIntent.getService(context, 0, NotificationOpenedService.b(context, bundle).setData(uriFromParts), iA);
    }
}
