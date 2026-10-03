package com.intentfilter.androidpermissions.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.DrawableRes;
import androidx.browser.trusted.NotificationApiHelperForO$$ExternalSyntheticApiModelOutline4;
import androidx.core.app.NotificationCompat;
import com.intentfilter.androidpermissions.R;
import com.intentfilter.androidpermissions.helpers.VersionOrchestrator;
import com.transistorsoft.locationmanager.config.TSNotification;

/* JADX INFO: loaded from: classes3.dex */
public class NotificationService {
    private static final String CHANNEL_ID = "android-permissions";
    private final Context context;
    private final NotificationManager notificationManager;

    public NotificationService(Context context) {
        this(context, (NotificationManager) context.getSystemService(TSNotification.NAME));
    }

    private NotificationService(Context context, NotificationManager notificationManager) {
        this.context = context;
        this.notificationManager = notificationManager;
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.notificationManager.createNotificationChannel(NotificationApiHelperForO$$ExternalSyntheticApiModelOutline4.m(CHANNEL_ID, this.context.getString(R.string.notification_channel_name), 3));
        }
    }

    public Notification buildNotification(String str, String str2, @DrawableRes int i, Intent intent, PendingIntent pendingIntent) {
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(this.context, CHANNEL_ID).setContentTitle(str).setContentText(str2).setAutoCancel(true).setPriority(0).setSmallIcon(i).setContentIntent(PendingIntent.getActivity(this.context, str2.hashCode(), intent, VersionOrchestrator.getImmutablePendingIntentFlags(1073741824)));
        contentIntent.setDeleteIntent(pendingIntent);
        return new NotificationCompat.BigTextStyle(contentIntent).bigText(str2).setBigContentTitle(str).build();
    }

    public void notify(String str, int i, Notification notification) {
        this.notificationManager.notify(str, i, notification);
    }
}
