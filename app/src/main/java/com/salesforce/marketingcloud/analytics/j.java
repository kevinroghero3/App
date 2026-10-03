package com.salesforce.marketingcloud.analytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface j {
    void a(@NonNull NotificationMessage notificationMessage);

    void a(@NonNull NotificationMessage notificationMessage, int i, String str, @Nullable String str2);

    void a(@NonNull NotificationMessage notificationMessage, boolean z);

    void a(@NonNull com.salesforce.marketingcloud.push.f fVar, @NonNull String str);

    void a(@NonNull Map<String, String> map);

    void b(@NonNull NotificationMessage notificationMessage);
}
