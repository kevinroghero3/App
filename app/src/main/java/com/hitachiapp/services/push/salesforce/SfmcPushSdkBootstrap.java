package com.hitachiapp.services.push.salesforce;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.browser.trusted.NotificationApiHelperForO$$ExternalSyntheticApiModelOutline4;
import app.notifee.core.a$$ExternalSyntheticApiModelOutline30;
import com.hitachiapp.MainActivity;
import com.hitachiapp.R;
import com.hitachiapp.services.push.bootstrap.PushSdkBootstrap;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.UrlHandler;
import com.salesforce.marketingcloud.notifications.NotificationCustomizationOptions;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.sfmcsdk.InitializationStatus;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdk;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkModuleConfig;
import com.transistorsoft.locationmanager.config.TSNotification;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

/* JADX INFO: loaded from: classes.dex */
public final class SfmcPushSdkBootstrap implements PushSdkBootstrap {
    public static final SfmcPushSdkBootstrap INSTANCE = new SfmcPushSdkBootstrap();
    private static final String name = "SfmcBootstrap";

    private SfmcPushSdkBootstrap() {
    }

    @Override // com.hitachiapp.services.push.bootstrap.PushSdkBootstrap
    public String getName() {
        return name;
    }

    @Override // com.hitachiapp.services.push.bootstrap.PushSdkBootstrap
    public void init(@NotNull Application app2) {
        Intrinsics.checkNotNullParameter(app2, "app");
        String string = app2.getResources().getString(R.string.salesforce_sender_id);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = app2.getResources().getString(R.string.salesforce_app_id);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = app2.getResources().getString(R.string.salesforce_app_endpoint);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = app2.getResources().getString(R.string.salesforce_access_token);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        Timber.tag(getName()).d("Initializing salesforce with:", new Object[0]);
        Timber.tag(getName()).d("salesforce_sender_id " + string, new Object[0]);
        Timber.tag(getName()).d("salesforce_app_id " + string2, new Object[0]);
        Timber.tag(getName()).d("salesforce_app_endpoint " + string3, new Object[0]);
        Timber.tag(getName()).d("salesforce_access_token " + string4, new Object[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            Timber.tag(getName()).d("Creating SFMC notification channel...", new Object[0]);
            a$$ExternalSyntheticApiModelOutline30.m();
            NotificationChannel notificationChannelM = NotificationApiHelperForO$$ExternalSyntheticApiModelOutline4.m(SfmcProviderManagerImpl.INSTANCE.getChannelId(), "Notifiche Salesforce", 4);
            notificationChannelM.enableVibration(true);
            notificationChannelM.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, new AudioAttributes.Builder().setUsage(5).build());
            Object systemService = app2.getSystemService(TSNotification.NAME);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).createNotificationChannel(notificationChannelM);
        }
        Timber.tag(getName()).d("Configuring SFMCSdk module....", new Object[0]);
        SFMCSdk.Companion companion = SFMCSdk.Companion;
        SFMCSdkModuleConfig.Companion companion2 = SFMCSdkModuleConfig.Companion;
        SFMCSdkModuleConfig.Builder builder = new SFMCSdkModuleConfig.Builder();
        MarketingCloudConfig.Builder builder2 = MarketingCloudConfig.builder();
        builder2.setDelayRegistrationUntilContactKeyIsSet(true);
        builder2.setApplicationId(string2);
        builder2.setAccessToken(string4);
        builder2.setMarketingCloudServerUrl(string3);
        builder2.setSenderId(string);
        builder2.setNotificationCustomizationOptions(NotificationCustomizationOptions.create(R.drawable.ic_stat_logo, new com.salesforce.marketingcloud.notifications.NotificationManager.NotificationLaunchIntentProvider() { // from class: com.hitachiapp.services.push.salesforce.SfmcPushSdkBootstrap$$ExternalSyntheticLambda0
            @Override // com.salesforce.marketingcloud.notifications.NotificationManager.NotificationLaunchIntentProvider
            public final PendingIntent getNotificationPendingIntent(Context context, NotificationMessage notificationMessage) {
                return SfmcPushSdkBootstrap.init$lambda$5$lambda$4$lambda$1(context, notificationMessage);
            }
        }, new com.salesforce.marketingcloud.notifications.NotificationManager.NotificationChannelIdProvider() { // from class: com.hitachiapp.services.push.salesforce.SfmcPushSdkBootstrap$$ExternalSyntheticLambda1
            @Override // com.salesforce.marketingcloud.notifications.NotificationManager.NotificationChannelIdProvider
            public final String getNotificationChannelId(Context context, NotificationMessage notificationMessage) {
                return SfmcPushSdkBootstrap.init$lambda$5$lambda$4$lambda$2(context, notificationMessage);
            }
        }));
        builder2.setAnalyticsEnabled(false);
        builder2.setUrlHandler(new UrlHandler() { // from class: com.hitachiapp.services.push.salesforce.SfmcPushSdkBootstrap$$ExternalSyntheticLambda2
            @Override // com.salesforce.marketingcloud.UrlHandler
            public final PendingIntent handleUrl(Context context, String str, String str2) {
                return SfmcPushSdkBootstrap.init$lambda$5$lambda$4$lambda$3(context, str, str2);
            }
        });
        builder.setPushModuleConfig(builder2.build(app2));
        Unit unit = Unit.INSTANCE;
        companion.configure(app2, builder.build(), new Function1() { // from class: com.hitachiapp.services.push.salesforce.SfmcPushSdkBootstrap$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SfmcPushSdkBootstrap.init$lambda$6((InitializationStatus) obj);
            }
        });
        Timber.tag(getName()).d("SFMCSdk module config complete", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PendingIntent init$lambda$5$lambda$4$lambda$1(Context context, NotificationMessage notificationMessage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationMessage, "notificationMessage");
        String str = notificationMessage.id;
        int iHashCode = str != null ? str.hashCode() : Random.Default.nextInt();
        String str2 = notificationMessage.url;
        if (str2 == null || str2.length() == 0) {
            return PendingIntent.getActivity(context, iHashCode, new Intent(context, (Class<?>) MainActivity.class), 201326592);
        }
        return PendingIntent.getActivity(context, iHashCode, new Intent("android.intent.action.VIEW", Uri.parse(str2)), 201326592);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String init$lambda$5$lambda$4$lambda$2(Context context, NotificationMessage notificationMessage) {
        Intrinsics.checkNotNullParameter(context, "<unused var>");
        Intrinsics.checkNotNullParameter(notificationMessage, "<unused var>");
        return SfmcProviderManagerImpl.INSTANCE.getChannelId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PendingIntent init$lambda$5$lambda$4$lambda$3(Context context, String url, String urlType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(urlType, "urlType");
        Timber.tag(INSTANCE.getName()).d("Salesforce UrlHandler called with url: " + url + ", type: " + urlType, new Object[0]);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        intent.setClass(context, MainActivity.class);
        intent.addFlags(536870912);
        return PendingIntent.getActivity(context, url.hashCode(), intent, 201326592);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$6(InitializationStatus initializationStatus) {
        Intrinsics.checkNotNullParameter(initializationStatus, "initializationStatus");
        int status = initializationStatus.getStatus();
        if (status == -1) {
            Timber.tag(INSTANCE.getName()).e("Salesforce SDK initialization failed", new Object[0]);
        } else if (status == 1) {
            Timber.tag(INSTANCE.getName()).d("Salesforce SDK initialized successfully", new Object[0]);
        } else {
            Timber.tag(INSTANCE.getName()).w("Salesforce SDK initialization status unknown", new Object[0]);
        }
        return Unit.INSTANCE;
    }
}
