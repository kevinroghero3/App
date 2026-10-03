package com.salesforce.marketingcloud.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.util.j;
import com.transistorsoft.locationmanager.config.TSNotification;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class PushNotificationActionHandler extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        MarketingCloudSdk marketingCloudSdk;
        NotificationMessage notificationMessage;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!j.a(3000L, 50L) || MarketingCloudSdk.getInstance() == null || (marketingCloudSdk = MarketingCloudSdk.getInstance()) == null || (notificationMessage = (NotificationMessage) intent.getParcelableExtra(com.salesforce.marketingcloud.push.b.e)) == null) {
            return;
        }
        Object systemService = context.getSystemService(TSNotification.NAME);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) systemService;
        if (StringsKt__StringsJVMKt.equals$default(intent.getAction(), com.salesforce.marketingcloud.push.carousel.b.m, false, 2, null) || StringsKt__StringsJVMKt.equals$default(intent.getAction(), com.salesforce.marketingcloud.push.carousel.b.l, false, 2, null)) {
            marketingCloudSdk.getMarketingCloudConfig().notificationCustomizationOptions.getNotificationBuilder();
            NotificationManager notificationManager2 = marketingCloudSdk.getNotificationManager();
            Intrinsics.checkNotNullExpressionValue(notificationManager2, "<get-notificationManager>(...)");
            if (notificationManager2 instanceof a) {
                notificationManager.notify("com.marketingcloud.salesforce.notifications.TAG", notificationMessage.getNotificationId$sdk_release(), ((a) notificationManager2).a(notificationMessage).build());
            }
        }
    }
}
