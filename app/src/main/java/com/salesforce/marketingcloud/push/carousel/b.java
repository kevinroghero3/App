package com.salesforce.marketingcloud.push.carousel;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.notifications.PushNotificationActionHandler;
import com.salesforce.marketingcloud.push.data.RichFeatures;
import com.salesforce.marketingcloud.util.j;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public class b extends com.salesforce.marketingcloud.push.b {
    public static final a k = new a(null);
    public static final String l = "com.salesforce.marketingcloud.notifications.ACTION_CAROUSEL_NEXT";
    public static final String m = "com.salesforce.marketingcloud.notifications.ACTION_CAROUSEL_PREVIOUS";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f80n = "com.salesforce.marketingcloud.notifications.INTENT_KEY_CAROUSEL_DATA";
    private final Context i;
    private final NotificationMessage j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Context context, @NotNull NotificationMessage message) {
        super(context, message);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        this.i = context;
        this.j = message;
    }

    public final PendingIntent a(@NotNull String intentAction, @NotNull com.salesforce.marketingcloud.push.carousel.a data) {
        RichFeatures richFeaturesCopy$default;
        int iM;
        Intrinsics.checkNotNullParameter(intentAction, "intentAction");
        Intrinsics.checkNotNullParameter(data, "data");
        NotificationMessage notificationMessage = this.j;
        RichFeatures richFeatures = notificationMessage.richFeatures;
        if (richFeatures != null) {
            if (Intrinsics.areEqual(intentAction, l)) {
                iM = data.m() + 1;
            } else {
                iM = Intrinsics.areEqual(intentAction, m) ? data.m() - 1 : data.m();
            }
            richFeaturesCopy$default = RichFeatures.copy$default(richFeatures, null, null, com.salesforce.marketingcloud.push.carousel.a.a(data, null, iM, null, 5, null), null, 11, null);
        } else {
            richFeaturesCopy$default = null;
        }
        NotificationMessage notificationMessageCopy = notificationMessage.copy((458751 & 1) != 0 ? notificationMessage.id : null, (458751 & 2) != 0 ? notificationMessage.requestId : null, (458751 & 4) != 0 ? notificationMessage.region : null, (458751 & 8) != 0 ? notificationMessage.alert : null, (458751 & 16) != 0 ? notificationMessage.sound : null, (458751 & 32) != 0 ? notificationMessage.soundName : null, (458751 & 64) != 0 ? notificationMessage.title : null, (458751 & 128) != 0 ? notificationMessage.subtitle : null, (458751 & 256) != 0 ? notificationMessage.type : null, (458751 & 512) != 0 ? notificationMessage.trigger : null, (458751 & 1024) != 0 ? notificationMessage.url : null, (458751 & 2048) != 0 ? notificationMessage.mediaUrl : null, (458751 & 4096) != 0 ? notificationMessage.mediaAltText : null, (458751 & 8192) != 0 ? notificationMessage.customKeys : null, (458751 & 16384) != 0 ? notificationMessage.custom : null, (458751 & 32768) != 0 ? notificationMessage.payload : null, (458751 & 65536) != 0 ? notificationMessage.richFeatures : richFeaturesCopy$default, (458751 & 131072) != 0 ? notificationMessage.propertyBag : null, (458751 & 262144) != 0 ? notificationMessage.notificationId : 0);
        Context context = this.i;
        int iHashCode = UUID.randomUUID().hashCode();
        Intent intent = new Intent(this.i, (Class<?>) PushNotificationActionHandler.class);
        intent.putExtra(com.salesforce.marketingcloud.push.b.e, notificationMessageCopy.copy((458751 & 1) != 0 ? notificationMessageCopy.id : null, (458751 & 2) != 0 ? notificationMessageCopy.requestId : null, (458751 & 4) != 0 ? notificationMessageCopy.region : null, (458751 & 8) != 0 ? notificationMessageCopy.alert : null, (458751 & 16) != 0 ? notificationMessageCopy.sound : NotificationMessage.Sound.NONE, (458751 & 32) != 0 ? notificationMessageCopy.soundName : null, (458751 & 64) != 0 ? notificationMessageCopy.title : null, (458751 & 128) != 0 ? notificationMessageCopy.subtitle : null, (458751 & 256) != 0 ? notificationMessageCopy.type : null, (458751 & 512) != 0 ? notificationMessageCopy.trigger : null, (458751 & 1024) != 0 ? notificationMessageCopy.url : null, (458751 & 2048) != 0 ? notificationMessageCopy.mediaUrl : null, (458751 & 4096) != 0 ? notificationMessageCopy.mediaAltText : null, (458751 & 8192) != 0 ? notificationMessageCopy.customKeys : null, (458751 & 16384) != 0 ? notificationMessageCopy.custom : null, (458751 & 32768) != 0 ? notificationMessageCopy.payload : null, (458751 & 65536) != 0 ? notificationMessageCopy.richFeatures : null, (458751 & 131072) != 0 ? notificationMessageCopy.propertyBag : null, (458751 & 262144) != 0 ? notificationMessageCopy.notificationId : 0));
        Unit unit = Unit.INSTANCE;
        intent.setAction(intentAction);
        intent.putExtra(f80n, data);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, iHashCode, intent, j.a(134217728));
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }
}
