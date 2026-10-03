package com.salesforce.marketingcloud.proximity;

import com.salesforce.marketingcloud.notifications.NotificationManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class ProximityNotificationCustomizationOptions {
    public static final Companion Companion = new Companion(null);
    private static ProximityNotificationCustomizationOptions instance;
    private final NotificationManager.NotificationChannelIdProvider channelIdProvider;
    private final int smallIconResId;

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ProximityNotificationCustomizationOptions create(int i) {
            if (ProximityNotificationCustomizationOptions.instance == null) {
                ProximityNotificationCustomizationOptions.instance = new ProximityNotificationCustomizationOptions(i, null, 0 == true ? 1 : 0);
            }
            ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions = ProximityNotificationCustomizationOptions.instance;
            Intrinsics.checkNotNull(proximityNotificationCustomizationOptions);
            return proximityNotificationCustomizationOptions;
        }

        private Companion() {
        }

        @JvmStatic
        public final ProximityNotificationCustomizationOptions create(int i, @NotNull NotificationManager.NotificationChannelIdProvider channelIdProvider) {
            Intrinsics.checkNotNullParameter(channelIdProvider, "channelIdProvider");
            if (ProximityNotificationCustomizationOptions.instance == null) {
                ProximityNotificationCustomizationOptions.instance = new ProximityNotificationCustomizationOptions(i, channelIdProvider, null);
            }
            ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions = ProximityNotificationCustomizationOptions.instance;
            Intrinsics.checkNotNull(proximityNotificationCustomizationOptions);
            return proximityNotificationCustomizationOptions;
        }
    }

    public /* synthetic */ ProximityNotificationCustomizationOptions(int i, NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, notificationChannelIdProvider);
    }

    @JvmStatic
    public static final ProximityNotificationCustomizationOptions create(int i) {
        return Companion.create(i);
    }

    public final NotificationManager.NotificationChannelIdProvider getChannelIdProvider() {
        return this.channelIdProvider;
    }

    public final int getSmallIconResId() {
        return this.smallIconResId;
    }

    private ProximityNotificationCustomizationOptions(int i, NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider) {
        this.smallIconResId = i;
        this.channelIdProvider = notificationChannelIdProvider;
    }

    @JvmStatic
    public static final ProximityNotificationCustomizationOptions create(int i, @NotNull NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider) {
        return Companion.create(i, notificationChannelIdProvider);
    }
}
