package com.salesforce.marketingcloud.notifications;

import android.os.Build;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.maps.android.BuildConfig;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.util.j;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCustomizationOptions {
    static final String TAG = g.a("NotificationCustomizationOptions");
    final NotificationManager.NotificationChannelIdProvider channelIdProvider;
    final NotificationManager.NotificationLaunchIntentProvider launchIntentProvider;
    final NotificationManager.NotificationBuilder notificationBuilder;
    final int smallIconResId;

    private NotificationCustomizationOptions(int i, NotificationManager.NotificationLaunchIntentProvider notificationLaunchIntentProvider, NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider, NotificationManager.NotificationBuilder notificationBuilder) {
        this.smallIconResId = i;
        this.launchIntentProvider = notificationLaunchIntentProvider;
        this.channelIdProvider = notificationChannelIdProvider;
        this.notificationBuilder = notificationBuilder;
    }

    private static String classNameOrNull(Object obj) {
        return obj != null ? obj.getClass().getName() : BuildConfig.TRAVIS;
    }

    public static NotificationCustomizationOptions create(@NonNull NotificationManager.NotificationBuilder notificationBuilder) {
        if (notificationBuilder != null) {
            return new NotificationCustomizationOptions(0, null, null, notificationBuilder);
        }
        throw new IllegalArgumentException("The provided NotificationManager.NotificationBuilder cannot be null.");
    }

    public NotificationManager.NotificationBuilder getNotificationBuilder() {
        return this.notificationBuilder;
    }

    public String toString() {
        NotificationManager.NotificationBuilder notificationBuilder = this.notificationBuilder;
        if (notificationBuilder != null) {
            return String.format(j.a, "{notificationBuilder=%s}", classNameOrNull(notificationBuilder));
        }
        Locale locale = j.a;
        int i = this.smallIconResId;
        return String.format(locale, "{smallIconResId=%d, launchIntentProvider=%s, channelIdProvider=%s}", Integer.valueOf(i), classNameOrNull(this.launchIntentProvider), classNameOrNull(this.channelIdProvider));
    }

    public static NotificationCustomizationOptions create(@DrawableRes int i) {
        return new NotificationCustomizationOptions(i, null, null, null);
    }

    public static NotificationCustomizationOptions create(@DrawableRes int i, @Nullable NotificationManager.NotificationLaunchIntentProvider notificationLaunchIntentProvider, @Nullable NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider) {
        if (notificationLaunchIntentProvider != null && Build.VERSION.SDK_INT >= 31) {
            g.c(TAG, "Make sure FLAG_IMMUTABLE or FLAG_MUTABLE for Pending Intent is set because of Targeting S+ (version 31 and above) ", new Object[0]);
        }
        return new NotificationCustomizationOptions(i, notificationLaunchIntentProvider, notificationChannelIdProvider, null);
    }
}
