package com.salesforce.marketingcloud.notifications;

import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: classes3.dex */
public class c extends b {
    public c(@NonNull int i, @Nullable NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider) {
        super(i, null, null, notificationChannelIdProvider);
    }

    @Override // com.salesforce.marketingcloud.notifications.b, com.salesforce.marketingcloud.notifications.NotificationManager.NotificationBuilder
    public NotificationCompat.Builder setupNotificationBuilder(@NonNull Context context, @NonNull NotificationMessage notificationMessage) {
        NotificationCompat.Builder builderA = b.a(context, notificationMessage, a(context, notificationMessage), this.a);
        PendingIntent pendingIntentC = c(context, notificationMessage);
        if (pendingIntentC != null) {
            builderA.setContentIntent(NotificationManager.redirectIntentForAnalytics(context, pendingIntentC, notificationMessage, true));
        }
        return builderA;
    }
}
