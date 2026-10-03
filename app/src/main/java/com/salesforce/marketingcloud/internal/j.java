package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final a a = new a(null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final NotificationMessage a(@NotNull Map<String, String> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return NotificationMessage.Companion.a(data);
        }

        private a() {
        }

        @JvmStatic
        public final NotificationMessage a(@NotNull Message message, @NotNull Region region) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(region, "region");
            return NotificationMessage.Companion.a(message, region);
        }

        @JvmStatic
        public final void a(@NotNull NotificationMessage message, int i) {
            Intrinsics.checkNotNullParameter(message, "message");
            message.setNotificationId$sdk_release(i);
        }
    }

    @JvmStatic
    public static final NotificationMessage a(@NotNull Message message, @NotNull Region region) {
        return a.a(message, region);
    }

    @JvmStatic
    public static final NotificationMessage a(@NotNull Map<String, String> map) {
        return a.a(map);
    }

    @JvmStatic
    public static final void a(@NotNull NotificationMessage notificationMessage, int i) {
        a.a(notificationMessage, i);
    }
}
