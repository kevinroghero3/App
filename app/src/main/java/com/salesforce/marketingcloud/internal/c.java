package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final a a = new a(null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String a(@NotNull InAppMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.getActivityInstanceId$sdk_release();
        }

        @JvmStatic
        public final JSONObject b(@NotNull InAppMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return message.toJson();
        }

        private a() {
        }

        @JvmStatic
        public final InAppMessage.CloseButton a() {
            return InAppMessage.CloseButton.Companion.a();
        }
    }

    @JvmStatic
    public static final String a(@NotNull InAppMessage inAppMessage) {
        return a.a(inAppMessage);
    }

    @JvmStatic
    public static final JSONObject b(@NotNull InAppMessage inAppMessage) {
        return a.b(inAppMessage);
    }

    @JvmStatic
    public static final InAppMessage.CloseButton a() {
        return a.a();
    }
}
