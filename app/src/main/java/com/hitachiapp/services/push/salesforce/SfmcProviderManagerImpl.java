package com.hitachiapp.services.push.salesforce;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.google.firebase.messaging.RemoteMessage;
import com.hitachiapp.services.push.core.ExternalPushProvider;
import com.salesforce.marketingcloud.UrlHandler;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.notifications.NotificationManager;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdk;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkReadyListener;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleInterface;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleReadyListener;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public final class SfmcProviderManagerImpl implements ExternalPushProvider, UrlHandler, NotificationManager.NotificationChannelIdProvider, NotificationManager.NotificationLaunchIntentProvider {
    public static final SfmcProviderManagerImpl INSTANCE = new SfmcProviderManagerImpl();
    private static final String TAG = "SALESFORCE.PUSH";
    private static final String channelId = "salesforce-sdk-notifications";
    private static final String name = "SfmcProviderManagerImpl";

    private SfmcProviderManagerImpl() {
    }

    public final String getChannelId() {
        return channelId;
    }

    @Override // com.hitachiapp.services.push.core.ExternalPushProvider
    public String getName() {
        return name;
    }

    @Override // com.hitachiapp.services.push.core.ExternalPushProvider
    public boolean canHandle(@NotNull RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        Timber.tag(SfmcPushSdkBootstrap.INSTANCE.getName()).d("SfmcProviderManagerImpl.canHandle invoked...", new Object[0]);
        return PushMessageManager.isMarketingCloudPush(remoteMessage.getData());
    }

    @Override // com.hitachiapp.services.push.core.ExternalPushProvider
    public void onNewToken(@NotNull final String token) {
        Object objM5472constructorimpl;
        Intrinsics.checkNotNullParameter(token, "token");
        Timber.tag(SfmcPushSdkBootstrap.INSTANCE.getName()).d("SfmcProviderManagerImpl.onNewToken invoked...", new Object[0]);
        try {
            Result.Companion companion = Result.Companion;
            SFMCSdk.Companion.requestSdk(new SFMCSdkReadyListener() { // from class: com.hitachiapp.services.push.salesforce.SfmcProviderManagerImpl$$ExternalSyntheticLambda0
                @Override // com.salesforce.marketingcloud.sfmcsdk.SFMCSdkReadyListener
                public final void ready(SFMCSdk sFMCSdk) {
                    SfmcProviderManagerImpl.onNewToken$lambda$1$lambda$0(token, sFMCSdk);
                }
            });
            objM5472constructorimpl = Result.m5472constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m5479isSuccessimpl(objM5472constructorimpl)) {
            Timber.tag(TAG).d("SFMC SDK token updated successfully", new Object[0]);
        }
        if (Result.m5475exceptionOrNullimpl(objM5472constructorimpl) != null) {
            Timber.tag(TAG).d("SFMC SDK not initialized (normal if SFMC disabled for this brand)", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNewToken$lambda$1$lambda$0(final String str, SFMCSdk sFMCSdk) {
        Intrinsics.checkNotNullParameter(sFMCSdk, "sFMCSdk");
        sFMCSdk.mp(new PushModuleReadyListener() { // from class: com.hitachiapp.services.push.salesforce.SfmcProviderManagerImpl$onNewToken$1$1$1
            @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleReadyListener, com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyListener
            public void ready(ModuleInterface moduleInterface) {
                PushModuleReadyListener.DefaultImpls.ready(this, moduleInterface);
            }

            @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleReadyListener
            public final void ready(PushModuleInterface pushModule) {
                Intrinsics.checkNotNullParameter(pushModule, "pushModule");
                pushModule.getPushMessageManager().setPushToken(str);
            }
        });
    }

    @Override // com.hitachiapp.services.push.core.ExternalPushProvider
    public boolean handleMessage(@NotNull final RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        Timber.tag(SfmcPushSdkBootstrap.INSTANCE.getName()).d("SfmcProviderManagerImpl.handleMessage invoked...", new Object[0]);
        try {
            SFMCSdk.Companion.requestSdk(new SFMCSdkReadyListener() { // from class: com.hitachiapp.services.push.salesforce.SfmcProviderManagerImpl$$ExternalSyntheticLambda1
                @Override // com.salesforce.marketingcloud.sfmcsdk.SFMCSdkReadyListener
                public final void ready(SFMCSdk sFMCSdk) {
                    SfmcProviderManagerImpl.handleMessage$lambda$4(remoteMessage, sFMCSdk);
                }
            });
            return true;
        } catch (Exception e) {
            Timber.tag(TAG).e(e, "Error delegating message to SFMC SDK", new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleMessage$lambda$4(final RemoteMessage remoteMessage, SFMCSdk sfmcSdk) {
        Intrinsics.checkNotNullParameter(sfmcSdk, "sfmcSdk");
        sfmcSdk.mp(new PushModuleReadyListener() { // from class: com.hitachiapp.services.push.salesforce.SfmcProviderManagerImpl$handleMessage$1$1
            @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleReadyListener, com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyListener
            public void ready(ModuleInterface moduleInterface) {
                PushModuleReadyListener.DefaultImpls.ready(this, moduleInterface);
            }

            @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleReadyListener
            public final void ready(PushModuleInterface pushModule) {
                Intrinsics.checkNotNullParameter(pushModule, "pushModule");
                pushModule.getPushMessageManager().handleMessage(remoteMessage);
                Timber.tag(SfmcProviderManagerImpl.TAG).d("SFMC SDK handled message successfully", new Object[0]);
            }
        });
    }

    private final int provideIntentFlags() {
        return Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728;
    }

    private final PendingIntent getPendingIntent(Context context, String str) {
        Timber.tag(TAG).d("getPendingIntent called with url: " + str, new Object[0]);
        if (str == null || str.length() == 0) {
            PendingIntent activity = PendingIntent.getActivity(context, Random.Default.nextInt(), context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()), provideIntentFlags());
            Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
            return activity;
        }
        PendingIntent activity2 = PendingIntent.getActivity(context, Random.Default.nextInt(), new Intent("android.intent.action.VIEW", Uri.parse(str)), provideIntentFlags());
        Intrinsics.checkNotNullExpressionValue(activity2, "getActivity(...)");
        return activity2;
    }

    @Override // com.salesforce.marketingcloud.UrlHandler
    public PendingIntent handleUrl(@NotNull Context context, @NotNull String url, @NotNull String urlSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(urlSource, "urlSource");
        Timber.tag(TAG).d("handleUrl called for url: " + url + " with source " + urlSource, new Object[0]);
        return getPendingIntent(context, url);
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager.NotificationChannelIdProvider
    public String getNotificationChannelId(@NotNull Context context, @NotNull NotificationMessage notificationMessage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationMessage, "notificationMessage");
        Timber.tag(TAG).d("getNotificationChannelId called for message: " + notificationMessage.id, new Object[0]);
        String strCreateDefaultNotificationChannel = NotificationManager.createDefaultNotificationChannel(context);
        Intrinsics.checkNotNullExpressionValue(strCreateDefaultNotificationChannel, "createDefaultNotificationChannel(...)");
        return strCreateDefaultNotificationChannel;
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager.NotificationLaunchIntentProvider
    public PendingIntent getNotificationPendingIntent(@NotNull Context context, @NotNull NotificationMessage notificationMessage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationMessage, "notificationMessage");
        Timber.tag(TAG).d("getNotificationPendingIntent called for message: " + notificationMessage.id + " with url: " + notificationMessage.url, new Object[0]);
        return getPendingIntent(context, notificationMessage.url);
    }
}
