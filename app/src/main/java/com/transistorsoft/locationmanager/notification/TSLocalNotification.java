package com.transistorsoft.locationmanager.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.service.ForegroundNotification;
import com.transistorsoft.locationmanager.util.Util;

/* JADX INFO: loaded from: classes3.dex */
public class TSLocalNotification {
    public static NotificationCompat.Builder build(Context context) {
        NotificationCompat.Builder builder;
        ForegroundNotification.createNotificationChannel(context, false);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                String channelId = TSConfig.getInstance(context).getNotification().getChannelId();
                if (channelId.isEmpty()) {
                    channelId = context.getPackageName() + "TSLocationManager";
                }
                builder = new NotificationCompat.Builder(context, channelId);
            } catch (NoSuchMethodError unused) {
                builder = new NotificationCompat.Builder(context);
            }
        } else {
            builder = new NotificationCompat.Builder(context);
        }
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setAction("android.intent.action.MAIN");
            launchIntentForPackage.putExtra("TSLocationManager", true);
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            launchIntentForPackage.setPackage(null);
            launchIntentForPackage.setFlags(272629760);
            builder.setContentIntent(PendingIntent.getActivity(context, 0, launchIntentForPackage, Util.getPendingIntentFlags(134217728)));
        } else {
            TSLog.logger.warn("Failed to find launchIntent for package: " + context.getPackageName());
        }
        int smallIcon = getSmallIcon(context);
        if (smallIcon > 0) {
            builder.setSmallIcon(smallIcon);
        }
        builder.setOnlyAlertOnce(true);
        return builder;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0026  */
    public static int getSmallIcon(Context context) {
        int identifier;
        if (TSConfig.isLoaded()) {
            String smallIcon = TSConfig.getInstance(context).getNotification().getSmallIcon();
            if (smallIcon.isEmpty()) {
                identifier = 0;
            } else {
                identifier = context.getResources().getIdentifier(smallIcon, null, context.getPackageName());
            }
        } else {
            identifier = 0;
        }
        return identifier > 0 ? identifier : context.getApplicationInfo().icon;
    }

    public static void notify(Context context, Notification notification, int i) {
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
        if (ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") != 0) {
            return;
        }
        notificationManagerCompatFrom.notify(i, notification);
    }
}
